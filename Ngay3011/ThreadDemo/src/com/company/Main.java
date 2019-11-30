package com.company;

import java.io.IOException;

public class Main{
    public static void main(String[] args) throws IOException{
        Thread thread = new Thread(new ConsoleInput());
        thread.start();
    }
}