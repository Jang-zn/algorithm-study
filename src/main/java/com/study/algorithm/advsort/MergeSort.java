package com.study.algorithm.advsort;

import java.util.ArrayList;

public class MergeSort {
    int count=0;
    static boolean check=false;
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<16;i++){
            list.add((int)(Math.random()*1000)+1);
        }
        System.out.println(list);
        System.out.println(mergeSort(list));

    }
    public static ArrayList<Integer> mergeSort(ArrayList<Integer> list){
        if(list.size()<=1){
            return list;
        }else{
             ArrayList<Integer> left = mergeSort(new ArrayList<Integer>(list.subList(0,list.size()/2)));
             ArrayList<Integer> right = mergeSort(new ArrayList<Integer>(list.subList(list.size()/2,list.size())));
             return merge(left,right);
        }
    }

    public static ArrayList<Integer> merge(ArrayList<Integer> left,ArrayList<Integer> right){
        ArrayList<Integer> mergeList = new ArrayList<Integer>();
        int lidx = 0;
        int ridx = 0;
        while(lidx<left.size()||ridx<right.size()){
            if(lidx>=left.size()){
                mergeList.add(right.get(ridx++));
            }else if(ridx>=right.size()){
                mergeList.add(left.get(lidx++));
            }else if(left.get(lidx)<right.get(ridx)){
                mergeList.add(left.get(lidx++));
            }else{
                mergeList.add(right.get(ridx++));
            }
        }
        return mergeList;
    }
}
