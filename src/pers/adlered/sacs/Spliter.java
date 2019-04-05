package pers.adlered.sacs;

public class Spliter {
    public Spliter() {
        //Alive hosts process
        for (String i:Definer.alive) {
            try {
                int A = Integer.parseInt(i.split("\\.")[0]);
                int B = Integer.parseInt(i.split("\\.")[1]);
                int C = Integer.parseInt(i.split("\\.")[2]);
                int D = Integer.parseInt(i.split("\\.")[3]);
                Storge storge = new Storge();
                storge.setA(A);
                storge.setB(B);
                storge.setC(C);
                storge.setD(D);
                Definer.storges.add(storge);
            } catch (Exception e) {}
        }
    }
}
