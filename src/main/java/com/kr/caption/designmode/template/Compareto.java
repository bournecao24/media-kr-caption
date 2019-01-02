package com.kr.caption.designmode.template;

public class Compareto implements Comparable{

    String name;
    int weight;

    public Compareto(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public int compareTo(Object o) {

        Compareto example = (Compareto) o;
        if(this.weight < example.weight){
            return -1;
        }else if(this.weight == example.weight) {
            return 0;
        }
            return 1;
    }

    @Override
    public String toString() {
        return "Compareto{" +
                "name='" + name + '\'' +
                ", weught='" + weight + '\'' +
                '}';
    }
}
