package com.algorithm.sort;

import java.util.ArrayList;

public class InsertionSort {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList();
        for (int i = 0; i < 6; i++) {
            list.add((int) (Math.random() * 100) + 1);
        }
        System.out.println(list);
        list = sort(list);
        System.out.println(list);

    }

    public static ArrayList<Integer> sort(ArrayList<Integer> list) {
        for (int i = 1; i < list.size(); i++) {
            int value = list.get(i);
            int insertIdx=0;
            boolean check = false;
            for (int j = i-1; j >= 0; j--) {
                check=value>list.get(j)?true:false;
                if(!check){
                    insertIdx=j;
                }
            }
            if(!check){
                list.add(insertIdx,value);
                list.remove(i+1);
            }else if(insertIdx!=0){
                list.add(insertIdx,value);
                list.remove(i+1);
            }
        }
        return list;
    }

}
