package org.example.cpu;

import org.example.Command;

import java.util.HashMap;
import java.util.Map;

class Cpu implements ICpu{

    private int[] mem = new int[1024];
    private Map<String, Integer> registers = new HashMap<String, Integer>();
    public Cpu() {
        for (int i = 0; i < 1024; i++) {
            this.mem[i] = 0;
        }
        for(int i = 0; i <4; i++){
            this.registers.put("r" + String.valueOf(i + 1) , 0);
        }
    }
    private int get_value(String s){
        return registers.get(s);
    }
    @Override
    public void exec(Command c) {
        String name = c.get_name();
        switch (name) {
            case "print":
                System.out.println(get_value("r1") + " " + get_value("r2") + " " + get_value("r3") + " " + get_value("r4"));
                break;
            case "add":
                registers.put("r4",get_value("r1") + get_value("r2"));
                break;
            case "sub":
                registers.put("r4",get_value("r1") - get_value("r2"));
                break;
            case "mult":
                registers.put("r4",get_value("r1") * get_value("r2"));
                break;
            case "div":
                registers.put("r4",get_value("r1") / get_value("r2"));
                break;
            case "mv":
                registers.put(c.get_reg1(),get_value(c.get_reg2()));
                break;
            case "init":
                mem[c.get_val1()] = c.get_val2();
                break;
            case "ld":
                registers.put(c.get_reg1(), mem[c.get_val2()]);
                break;
            case "st":
                mem[c.get_val1()] = get_value(c.get_reg2());
                break;
        }
    }
}
