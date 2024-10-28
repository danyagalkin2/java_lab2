package org.example;

import java.util.*;


public class Program implements Iterable<Command>{
    private ArrayList<Command> prog = new ArrayList<>();

    public int getCountProg(){return prog.size();}
    public void Add(Command c){
        prog.add(c);
    }

    @Override
    public Iterator<Command> iterator() {
        return prog.iterator();
    }

    public Set<String> getUniqueProg() {
        Set<String> uProg = new HashSet<>();
        for (Command c : prog) {
            uProg.add(c.get_name());
        }
        return uProg;
    }

    public LinkedHashMap<String,Integer> countProg(){
        HashMap<String,Integer> mapProg = new HashMap<>();
        Set<String> uProg = getUniqueProg();
        for(String s: uProg){
            mapProg.put(s,0);
        }
        for (Command c : prog) {
            mapProg.put(c.get_name(),mapProg.get(c.get_name()) + 1);
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(mapProg.entrySet());
        Comparator<Map.Entry<String, Integer>> valueComparator = Comparator.comparing(Map.Entry::getValue);
        list.sort(valueComparator);
        LinkedHashMap<String, Integer> sortedMapProg = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : list) {
            sortedMapProg.put(entry.getKey(), entry.getValue());
        }

        return sortedMapProg;
    }

    public String mostPopularInstruction(){
        LinkedHashMap<String, Integer> sortedMapProg = countProg();
        Iterator<HashMap.Entry<String,Integer>> iterator = sortedMapProg.entrySet().iterator();
        HashMap.Entry<String, Integer> result = null;
        while (iterator.hasNext()) {
            result = iterator.next();
        }
        return result.getKey();
        //return sortedMapProg.keySet().iterator().next();
    }

    public void printSortProg(){
        LinkedHashMap<String, Integer> sortedMapProg = countProg();
        for (Map.Entry<String, Integer> entry : sortedMapProg.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println("Команда: " + key + " выполнилась: " + value + " раз");
        }
    }

    public void memoryAddressRange(){
        int maxRange = 0, minRange = 0;
        for (Command c : prog) {
            if(Objects.equals(c.get_name(), "init")){
                if( maxRange == 0 && minRange == 0){
                    maxRange = minRange = c.get_val1();
                }else{
                    if(c.get_val1() < minRange){
                        minRange = c.get_val1();
                    }else if (maxRange < c.get_val1()){
                        maxRange = c.get_val1();
                    }
                }
            }
        }
        System.out.println("В программе используются адреса в диапазоне от " + minRange + " до " + maxRange);
    }






}
