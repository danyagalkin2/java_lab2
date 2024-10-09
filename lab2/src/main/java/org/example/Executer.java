package org.example;

import org.example.cpu.BCpu;
import org.example.cpu.ICpu;

public class Executer {
    ICpu icpu = BCpu.build();

    public void run(Command[] commands){

        for (int i = 0; i <commands.length;i++){
            icpu.exec(commands[i]);

        }


    }





}
