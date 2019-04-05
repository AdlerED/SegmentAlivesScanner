package pers.adlered.sacs;

import java.util.Comparator;

public class Comparetor implements Comparator<Storge> {
    String segment;

    public Comparetor(String segment) {
        segment = segment.toUpperCase();
        this.segment = segment;
    }

    @Override
    public int compare(Storge o1, Storge o2) {
        int sgmt1 = -1;
        int sgmt2 = -1;
        switch (segment) {
            case "A":
                sgmt1 = o1.getA();
                sgmt2 = o2.getA();
                break;
            case "B":
                sgmt1 = o1.getB();
                sgmt2 = o2.getB();
                break;
            case "C":
                sgmt1 = o1.getC();
                sgmt2 = o2.getC();
                break;
            case "D":
                sgmt1 = o1.getD();
                sgmt2 = o2.getD();
                break;
            default:
                sgmt1 = o1.getC();
                sgmt2 = o2.getC();
        }
        if (sgmt1 > sgmt2) {
            return 1;
        } else if (sgmt1 == sgmt2) {
            return 0;
        } else {
            return -1;
        }
    }
}
