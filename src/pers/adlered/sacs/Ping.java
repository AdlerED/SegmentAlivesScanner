package pers.adlered.sacs;

import java.io.*;
import java.net.*;
import java.nio.channels.*;
import java.util.*;
import java.util.regex.*;

public class Ping extends Thread {
    private String ipAddress;

    public Ping(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    @Override
    public void run() {
        try {
            if (InetAddress.getByName(ipAddress).isReachable(Definer.timeout)) { Definer.alive.add(ipAddress); }
            else { Definer.dead.add(ipAddress); }
        } catch (Exception e) {}
    }
}