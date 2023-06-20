package n7.parcoursup;

import java.util.List;

public abstract class TemplateStableWedding {

    public Result run(List<Suitor> suitors) {
        System.out.println("Lancement de l'algorithme de marriage stable...");

        Result result = new Result(suitors);

        int i = 1;
        long start = System.currentTimeMillis();
        do {
            System.out.println();
            System.out.println("Lancement du tour " + i);
            result.reset();

            System.out.println("-- Lancement étape 1");
            step1(result, i);

            System.out.println("-- Lancement étape 2");
            step2(result);

            showResult(result);
            i++;
        } while (!result.isFinish());

        System.out.println();
        System.out.println("Fin de l'algorithme de marriage stable !");
        System.out.println("  Durée de l'algorithme: " + (System.currentTimeMillis() - start) + "ms");
        System.out.println();

        return result;
    }

    public abstract void step1(Result result, Integer i);

    public abstract void step2(Result result);

    public abstract void showResult(Result result);
}
