package pers.adlered.sacs;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Definer {
    //Threads
    public static int threads = 2000;
    //Timeout
    public static int timeout = 3000;
    //Waiting for scan hosts
    public static List<String> scanList = new ArrayList<String>();
    //Alive hosts
    public static List<String> alive = new ArrayList<String>();
    //Dead hosts
    public static List<String> dead = new ArrayList<String>();
    //Hosts
    public static List<Storge> storges = new ArrayList<Storge>();
    //Thread pool
    public static ExecutorService executorService = Executors.newFixedThreadPool(threads);
    //Segment A|B|C|D
    public static String segment = "";
}
