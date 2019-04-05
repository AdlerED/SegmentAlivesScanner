package pers.adlered.sacs;

import java.util.Collections;

public class Main {
    //Scan range (Support ',' '-' eg: 10.2.10-20.1, 10.2.40-60.1 Must one dash, will detect segment automatic)
    public static String range = "10.2.1-254.1";

    public static void main(String[] args) {
        //Hosts enumeration
        ArgsAnalyzer.analyzeList(range);

        //Wait for executors shutdown
        Definer.executorService.shutdown();
        while (!Definer.executorService.isTerminated()) {}

        //Split lists
        new Spliter();

        //Sort
        Collections.sort(Definer.storges, new Comparetor(Definer.segment));

        System.out.println("Results:");

        //Display
        new Processer(Definer.segment);
    }
}
