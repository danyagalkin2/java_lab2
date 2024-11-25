package org.example;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Command {
    private String[] command = new String[3];

    @Override
    public String toString() {
        return command[0];
    }

    public Command(String s){
        this.command = s.split(" ");
    }

    public Command(String[] command){
        this.command = command;

    }

    public Command(String s1, String s2, String s3) {
        this.command[0] = s1;
        this.command[1] = s2;
        this.command[2] = s3;
    }

    public String get_name(){
        return command[0];
    }

    public String get_reg1(){
        return command[1];
    }

    public String get_reg2(){
        return command[2];
    }

    public int get_val1(){
        return Integer.parseInt( command[1]);

    }
    public int get_val2(){
        return Integer.parseInt( command[2]);
    }
}
