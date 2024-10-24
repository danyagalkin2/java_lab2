package org.example;

import org.example.cpu.BCpu;
import org.example.cpu.ICpu;

public class Executer {
    ICpu icpu = BCpu.build();

    public void run(Program prog){

        for(Command c: prog)
            icpu.exec(c);


        }


    }






