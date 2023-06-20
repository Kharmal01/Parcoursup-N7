package n7.parcoursup.csv;

import java.util.HashMap;
import java.util.Map;

public class CsvStudent implements CsvEntity {

    private final String name;

    private final Map<Integer, String> grades = new HashMap<>();

    public CsvStudent(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getCapacity() {
        return 1;
    }

    @Override
    public Map<Integer, String> getGrades() {
        return grades;
    }
}
