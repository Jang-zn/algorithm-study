package com.study.algorithm.sort;

import java.util.ArrayList;
import java.util.Collections;

public class SelectionSort {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList();
        for(int i=0;i<20;i++){
            list.add((int)(Math.random()*100)+1);
        }
        list = sort(list);
        System.out.println(list);

    }

    public static ArrayList<Integer> sort(ArrayList<Integer> list){
        for(int i=0; i<list.size()-1;i++){
            int minIdx=i;
            for(int j=i+1;j<list.size();j++){
                if(list.get(minIdx)>list.get(j)){
                    minIdx = j;
                }
            }
            Collections.swap(list,i,minIdx);
        }
        return list;
    }
}
