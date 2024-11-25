package org.example;

import org.example.cpu.BCpu;
import org.example.cpu.ICpu;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Program prog = new Program();
        prog.Add(new Command("init 10 20"));
        prog.Add(new Command("init 11 25"));
        prog.Add(new Command("init" ,"12", "5"));
        prog.Add(new Command("ld", "r1" ,"10"));
        prog.Add(new Command("ld", "r2" ,"11"));
        prog.Add(new Command("ld", "r3" ,"12"));
        prog.Add(new Command("add"));
        prog.Add(new Command("print"));
        prog.Add(new Command("mv", "r1" ,"r4"));
        prog.Add(new Command("mv", "r2" ,"r3"));
        prog.Add(new Command("div"));
        prog.Add(new Command("print"));
        for(Command c: prog) System.out.println(c);
        
        prog.printMostPopInstruction();
        prog.printSortProg();
        prog.memoryAddressRange();
        Executer exec = new Executer();
        exec.run(prog);
    }
}