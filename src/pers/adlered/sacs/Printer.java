package pers.adlered.sacs;

public class Printer {
    public Printer(int text, int count, String segment) {
        segment = segment.toUpperCase();
        try {
            int A = Definer.storges.get(0).getA();
            int B = Definer.storges.get(0).getB();
            int C = Definer.storges.get(0).getC();
            int D = Definer.storges.get(0).getD();
        } catch (Exception e) {}
        String countFinal = " - " + count + " Alive";
        System.out.println("Segment " + segment + " > " + text + countFinal);
        /*switch (segment) {
            case "A":
                System.out.println(text + ".0.0.0" + countFinal);
                break;
            case "B":
                System.out.println(A + "." + text + ".0.0" + countFinal);
                break;
            case "C":
                System.out.println(A + "." + B + "." + text + ".0" + countFinal);
                break;
            case "D":
                System.out.println("0.0.0." + text + countFinal);
                break;
            default:
                System.out.println(A + "." + B + "." + text + ".0" + countFinal);
        }*/
    }
}
