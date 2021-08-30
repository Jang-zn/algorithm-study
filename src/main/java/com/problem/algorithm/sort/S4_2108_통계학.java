package com.problem.algorithm.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class S4_2108_통계학 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<Integer>();
        double sum = 0.0;
        for(int i=0;i<n;i++){
            int num = Integer.parseInt(br.readLine());
            list.add(num);
            sum+=num;
        }
        Collections.sort(list);
        //산술평균
        System.out.println((int)(Math.round(sum/n)));
        //중앙값
        System.out.println(midVal(list));
        //최빈값
        System.out.println(maxCount(list));
        //범위
        System.out.println(range(list));

    }


    public static int midVal(ArrayList<Integer> list){
        return list.get(list.size()/2);
    }

    public static int maxCount(ArrayList<Integer> list){
        int count = 1;
        int maxCount = 1;
        ArrayList<Integer> cart = new ArrayList<Integer>();
        for(int i=0;i<list.size();i++){
            int n1 = list.get(i);
            int n2 = list.get(i)+1;
                if(i<list.size()-1){
                    n2 = list.get(i+1);
                }
            if(n1==n2){
                count++;
            }else{
                if(count==maxCount){
                    cart.add(n1);
                    count=1;
                }else if(count>maxCount){
                    maxCount = count;
                    cart = new ArrayList<Integer>();
                    cart.add(n1);
                    count=1;
                }else{
                    count=1;
                }
            }
        }
        if(cart.size()>1) {
            return cart.get(1);
        }else{
            return cart.get(0);
        }
    }

    public static int range(ArrayList<Integer> list){
        int maxValue = list.get(list.size()-1);
        int minValue = list.get(0);
        return maxValue-minValue;
    }



}
