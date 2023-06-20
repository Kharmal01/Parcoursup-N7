package n7.parcoursup.csv;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class CsvFramework {

    private static final String STUDENT_COLUMN_NAME = "Elève";

    public static Csv read(String file) throws IOException, CsvException {
        CSVParser parser = new CSVParserBuilder()
                .withSeparator(',')
                .withIgnoreQuotations(true)
                .build();

        CSVReader csvReader = new CSVReaderBuilder(Files.newBufferedReader(new File(file).toPath()))
                .withSkipLines(0)
                .withCSVParser(parser)
                .build();

        List<String[]> lines = csvReader.readAll();

        Csv csv = new Csv();

        for (String s : lines.get(0)) {
            if(STUDENT_COLUMN_NAME.equals(s)) continue;

            String[] data = s.split("-");
            csv.getSchools().add(new CsvSchool(data[0], Integer.parseInt(data[1])));
        }

        lines.stream().skip(1).forEach(strings -> {
            if(strings.length == 0) return;

            CsvStudent student = new CsvStudent(strings[0]);
            for (int i = 1; i < strings.length; i++) {
                student.getGrades().put(i, strings[i]);
            }

            csv.getStudents().add(student);
        });

        return csv;
    }
}
