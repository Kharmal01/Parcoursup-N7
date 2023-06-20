package n7.parcoursup;

import java.util.HashMap;
import java.util.Map;

public abstract class Suiting<T, K> {

    private final int id;
    private final String name;
    private final int capacity;

    private final Map<T, K> grades = new HashMap<>();

    public Suiting(int id, String name, int capacity) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public Map<T, K> getGrades() {
        return grades;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
