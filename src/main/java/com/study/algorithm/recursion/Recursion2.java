package com.study.algorithm.recursion;

import java.util.ArrayList;

public class Recursion2 {
    //List의 합 구하기
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<10;i++){
            list.add(i);
        }
        System.out.println(list);
        System.out.println(sumList(list));
    }

    public static int sumList (ArrayList<Integer> list){
        if(list.size()>1){
            return list.get(0)+sumList(new ArrayList<Integer>(list.subList(1,list.size())));
        }else{
            return list.get(0);
        }
    }
}
