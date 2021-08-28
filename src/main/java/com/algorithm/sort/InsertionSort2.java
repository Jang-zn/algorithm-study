package com.algorithm.sort;

import java.util.ArrayList;
import java.util.Collections;

public class InsertionSort2 {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList();
        for (int i = 0; i < 20; i++) {
            list.add((int) (Math.random() * 100) + 1);
        }
        System.out.println(list);
        list = sort(list);
        System.out.println(list);

    }

    public static ArrayList<Integer> sort(ArrayList<Integer> list) {
        for (int i = 0; i < list.size()-1; i++) {
            for (int j = i+1; j > 0; j--) {
                if(list.get(j)<list.get(j-1)){
                    Collections.swap(list,j,j-1);
                }else{
                    break;
                }
            }
        }
        return list;
    }

}
