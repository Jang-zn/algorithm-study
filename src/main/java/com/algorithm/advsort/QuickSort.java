package com.algorithm.advsort;

import java.util.ArrayList;

public class QuickSort {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<10;i++){
            list.add((int)(Math.random()*200)+1);
        }
        System.out.println(list);
        System.out.println(qSort(list));
    }

    public static ArrayList<Integer> qSort(ArrayList<Integer> list){
        if(list.size()>1) {
            int pivot = list.get(0);
            ArrayList<Integer> left = new ArrayList<Integer>();
            ArrayList<Integer> right = new ArrayList<Integer>();
            for (int i = 1; i < list.size(); i++) {
                if (pivot > list.get(i)) {
                    left.add(list.get(i));
                } else {
                    right.add(list.get(i));
                }
            }
            left = qSort(left);
            right = qSort(right);
            left.add(pivot);
            left.addAll(right);
            return left;
        }else{
            return list;
        }
    }
}
