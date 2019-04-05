package pers.adlered.sacs;

public class Processer {
    public Processer(String segment) {
        int pointer = -1;
        int count = 0;
        int pointerC = -1;
        boolean hasResult = false;

        for (Storge i : Definer.storges) {
            segment = segment.toUpperCase();
            int sgmt;
            switch (segment) {
                case "A":
                    sgmt = i.getA();
                    break;
                case "B":
                    sgmt = i.getB();
                    break;
                case "C":
                    sgmt = i.getC();
                    break;
                case "D":
                    sgmt = i.getD();
                    break;
                default:
                     sgmt = i.getC();
                     break;
            }
            if (pointer == -1) {
                pointer = sgmt;
            }
            //Codes here
            //C segment equal pointer, add count
            if (sgmt == pointer) {
                pointerC = sgmt;
                count++;
            } else {
                //Avoid only 1 result but cannot printout
                hasResult = true;
                new Printer(pointerC, count, segment);
                count = 0;
                pointerC = sgmt;
                count++;
            }
            //End line
            pointer = sgmt;
        }
        if (!hasResult) {
            new Printer(pointerC, count, segment);
        }
    }
}
