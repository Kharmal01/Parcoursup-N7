package n7.parcoursup.csv;

import java.util.Map;

public interface CsvEntity {

    String getName();

    int getCapacity();

    Map<Integer, String> getGrades();
}
