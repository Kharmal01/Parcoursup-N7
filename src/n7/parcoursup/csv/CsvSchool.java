package n7.parcoursup.csv;

import java.util.HashMap;
import java.util.Map;

public class CsvSchool implements CsvEntity {

    private final String name;
    private final int capacity;

    public CsvSchool(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getCapacity() {
        return capacity;
    }

    @Override
    public Map<Integer, String> getGrades() {
        return new HashMap<>();
    }
}
