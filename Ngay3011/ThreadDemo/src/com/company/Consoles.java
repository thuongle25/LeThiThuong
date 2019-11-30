package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Consoles {
    private final BufferedReader in;
    private static class Singleton {
        static final Consoles INSTANCE = new Consoles();
    }
    public static Consoles getInstance(){return Consoles.Singleton.INSTANCE;}

    private Consoles(){in = new BufferedReader(new InputStreamReader(System.in));}

    public String readLine() throws IOException {
        return in.readLine();
    }
}
