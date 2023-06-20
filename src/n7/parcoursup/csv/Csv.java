package n7.parcoursup.csv;

import java.util.ArrayList;
import java.util.List;

public class Csv {

    private final List<CsvEntity> schools = new ArrayList<>();
    private final List<CsvEntity> students = new ArrayList<>();

    public Csv() {
    }

    public List<CsvEntity> getSchools() {
        return schools;
    }

    public List<CsvEntity> getStudents() {
        return students;
    }
}
