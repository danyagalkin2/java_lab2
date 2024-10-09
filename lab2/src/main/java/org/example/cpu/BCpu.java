package org.example.cpu;

public class BCpu {
    public static ICpu build(){
        return new Cpu();
    }
}
