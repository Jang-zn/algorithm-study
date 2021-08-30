package com.study.algorithm.search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=0; i<100000;i++){
            list.add((int)(Math.random()*100000+1));
        }
        Collections.sort(list);
        Scanner sc = new Scanner(System.in);
        System.out.println(list);
        System.out.print("찾을 숫자 입력<1000 : ");
        int val = Integer.parseInt(sc.nextLine());

        //LinearSearch
        for(int i=0;i<list.size();i++){
            int lcount=i+1;
            if(list.get(i)==val){
                System.out.println(list.get(i));
                System.out.println("lCount : "+lcount);
                break;
            }
            if(i==list.size()-1){
                System.out.println(-1);
                System.out.println("lCount : "+lcount);
                break;
            }
        }

        //BinarySearch
        System.out.println(bSearch(list,val));
        System.out.println("bCount : " + bCount);


    }
    public static int bCount = 0;
    public static int bSearch(ArrayList<Integer> list, int val){
        bCount++;
        if(list.size()>1){
            int pivot = list.get(list.size()/2);
            ArrayList<Integer> left = new ArrayList<Integer>(list.subList(0,list.size()/2));
            ArrayList<Integer> right = new ArrayList<Integer>(list.subList(list.size()/2+1,list.size()));
            if(pivot==val){
                return pivot;
            }else if(pivot>val){
                return bSearch(left,val);
            }else{
                return bSearch(right,val);
            }
        }else{
            if(list.get(0)==val) {
                return list.get(0);
            }else{
                return -1;
            }
        }
    }

}
