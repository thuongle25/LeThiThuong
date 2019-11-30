package com.company;

import java.io.Console;
import java.io.IOException;

public class ConsoleInput implements Runnable{
    private Boolean running = true;
    String s = "";
    @Override
    public void run() {
        while (running){
            System.out.print("INPUT: ");
            try {
                s = Consoles.getInstance().readLine();
            }catch (IOException e) {
                e.printStackTrace();
            }
            if (s.equalsIgnoreCase("exit")){
                running =false;
            }

        }
        System.out.println(Thread.currentThread().getName() + " terminated");
    }
}