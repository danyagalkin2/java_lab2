package org.example;

import org.example.cpu.BCpu;
import org.example.cpu.ICpu;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Command [] prog = {
                new Command("init 10 20"),
                new Command("init" ,"11", "25"),
                new Command("ld", "r1" ,"10"),
                new Command("ld", "r2" ,"11"),
                new Command("add"),
                new Command("print")}; //вывод 20 25 * 45

        Executer exec = new Executer();
        exec.run(prog);

    }
}