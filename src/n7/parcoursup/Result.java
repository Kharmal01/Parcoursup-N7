package n7.parcoursup;

import java.util.*;

public class Result {

    private final Set<Suitor> withoutSuitables;
    private final Map<Suitable, List<Suitor>> stableStep1 = new HashMap<>();
    private final Map<Suitable, List<Suitor>> stableStep2 = new HashMap<>();

    public Result(List<Suitor> suitors) {
        this.withoutSuitables = new HashSet<>(suitors);
    }

    public void reset() {
        this.stableStep1.clear();
        this.stableStep1.putAll(this.stableStep2);
        this.stableStep2.clear();
    }

    public boolean isFinish() {
        return withoutSuitables.isEmpty();
    }

    public Set<Suitor> getWithoutSuitables() {
        return withoutSuitables;
    }

    public Map<Suitable, List<Suitor>> getStableStep1() {
        return stableStep1;
    }

    public Map<Suitable, List<Suitor>> getStableStep2() {
        return stableStep2;
    }
}
