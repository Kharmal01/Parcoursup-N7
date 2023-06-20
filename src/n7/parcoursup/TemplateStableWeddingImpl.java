package n7.parcoursup;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TemplateStableWeddingImpl extends TemplateStableWedding {
    @Override
    public void step1(Result result, Integer i) {
        Iterator<Suitor> suitorIterator = result.getWithoutSuitables().iterator();
        //Suitors without full capacity reached are bidding (people who can still bid to someone else)
        while (suitorIterator.hasNext()) {
            Suitor suitor = suitorIterator.next();

            //Suitors are bidding to people on their list, starting from the next person after the last person they bid to
            // and the next one after the next one until they reached their capacity.
            int j ;
            for(j = suitor.getUsedCapacity() + 1 ; j < suitor.getUsedCapacity() + suitor.getUnusedCapacity() + 1; j++) {
                Suitable suitable = suitor.getGrades().get(j);
                List<Suitor> suitors = result.getStableStep1().getOrDefault(suitable, new ArrayList<>());
                suitors.add(suitor);

                result.getStableStep1().put(suitable, suitors);
            }
            suitorIterator.remove();
            //Increase the maximum they reached and reset their capacity
            suitor.setUsedCapacity(j-1);
            suitor.setUnusedCapacity(0);
        }
    }

    @Override
    public void step2(Result result) {
        //Each Suitable (Serenaded) are choosing their X favorites among the bidding
        //For each suitable we get their list of bidder and we sort them by preferance
        for (Map.Entry<Suitable, List<Suitor>> entry : result.getStableStep1().entrySet()) {
            Suitable suitable = entry.getKey();
            List<Suitor> suitors = entry.getValue();

            List<Suitor> goodSuitors = suitable.getGrades().entrySet().stream()
                    .filter(entry1 -> suitors.contains(entry1.getKey()))
                    .sorted(Map.Entry.comparingByValue())
                    .map(Map.Entry::getKey)
                    .toList();

            int count = 0;
            for (Suitor suitor : goodSuitors) {
                //For each suitor, if they are kept by suitable, nothing change
                if(count < suitable.getCapacity()) {

                    List<Suitor> suitorList2 = result.getStableStep2().getOrDefault(suitable, new ArrayList<>());
                    suitorList2.add(suitor);
                    result.getStableStep2().put(suitable, suitorList2);
                } else {
                    //Otherwise, we increase their capacity each time they are rejected and are added to the list of not fully reached capacity
                    suitor.setUnusedCapacity(suitor.getUnusedCapacity()+1);
                    result.getWithoutSuitables().add(suitor);
                }

                count ++;
            }

        }
    }

    @Override
    public void showResult(Result result) {
        System.out.println("Résultat du tour: ");
        System.out.println("- Sans correspondance: " + result.getWithoutSuitables().toString());
        System.out.println("- Etape 1: " + result.getStableStep1().toString());
        System.out.println("- Etape 2: " + result.getStableStep2().toString());
    }
}
