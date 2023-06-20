package n7.parcoursup;

import com.opencsv.exceptions.CsvException;
import n7.parcoursup.csv.Csv;
import n7.parcoursup.csv.CsvEntity;
import n7.parcoursup.csv.CsvFramework;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Runner {
    private final static TemplateStableWedding TEMPLATE_STABLE_WEDDING = new TemplateStableWeddingImpl();

    private final List<Suitor> suitors = new ArrayList<>();
    private final List<Suitable> suitables = new ArrayList<>();

    private final String fileName;

    public Runner(String fileName) {
        this.fileName = fileName;
    }

    public void run(boolean favoriteSchool) throws IOException, CsvException {
        Csv csv = CsvFramework.read(this.fileName);

        if(favoriteSchool) {
            this.loadSuitors(csv.getSchools());
            this.loadSuitable(csv.getStudents());
        } else {
            this.loadSuitable(csv.getSchools());
            this.loadSuitors(csv.getStudents());
        }

        System.out.println(suitors);
        System.out.println(suitables);

        Result result = TEMPLATE_STABLE_WEDDING.run(suitors);
        if (favoriteSchool) {
            Map<Suitor, List<Suitable>> mapAffichage = new HashMap<>();
            result.getStableStep2().forEach((suitable, suitorss) -> {
                suitorss.forEach((suitor -> {
                    List<Suitable> suitableList = mapAffichage.getOrDefault(suitor, new ArrayList<>());
                    suitableList.add(suitable);
                    mapAffichage.put(suitor, suitableList);
                }));
            });
            mapAffichage.forEach((suitor, suitables) -> {
                System.out.println(suitor.getName() + " => " + suitables.stream().map(Suitable::getName).collect(Collectors.joining(", ")));
            });
        } else {
            result.getStableStep2().forEach((suitable, suitorss) -> {
                System.out.println(suitable.getName() + " => " + suitorss.stream().map(Suitor::getName).collect(Collectors.joining(", ")));
            });
        }
    }

    private void loadSuitors(List<CsvEntity> csvEntities) {
        for (int i = 0; i < csvEntities.size(); i++) {
            CsvEntity csvSchool = csvEntities.get(i);

            Suitor suitor = new Suitor(i+1, csvSchool.getName(), csvSchool.getCapacity());

            csvSchool.getGrades().forEach((integer, s) -> {
                Suitable suitable = getSuitable(integer);

                String[] data = s.split("-");
                int studentForSchool = Integer.parseInt(data[0]);
                int schoolForStudent = Integer.parseInt(data[1]);

                suitor.getGrades().put(studentForSchool, suitable);
                suitable.getGrades().put(suitor, schoolForStudent);
            });

            suitors.add(suitor);
        }
    }

    private void loadSuitable(List<CsvEntity> csvEntities) {
        for (int i = 0; i < csvEntities.size(); i++) {
            CsvEntity csvStudent = csvEntities.get(i);

            Suitable suitable = new Suitable(i+1, csvStudent.getName(), csvStudent.getCapacity());

            csvStudent.getGrades().forEach((integer, s) -> {
                Suitor suitor = getSuitor(integer);

                String[] data = s.split("-");
                int studentForSchool = Integer.parseInt(data[0]);
                int schoolForStudent = Integer.parseInt(data[1]);

                suitable.getGrades().put(suitor, studentForSchool);
                suitor.getGrades().put(schoolForStudent, suitable);
            });

            suitables.add(suitable);
        }
    }

    private Suitable getSuitable(int id) {
        return suitables.stream().filter(suitable -> suitable.getId() == id).findFirst().orElse(null);
    }

    private Suitor getSuitor(int id) {
        return suitors.stream().filter(suitable -> suitable.getId() == id).findFirst().orElse(null);
    }
}
