package com.problem.algorithm.twopointer;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class G5_2470_두용액3 {
    static ArrayList<Integer> list = new ArrayList<Integer>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String[] temp = br.readLine().split(" ");
        for(int i=0;i<N;i++){
           int solution = Integer.parseInt(temp[i]);
           list.add(solution);
        }
        Collections.sort(list);
        int[]sol = calc();
        System.out.println(sol[0]+" "+sol[1]);

    }

    public static int[] calc(){
        int[] pair = new int[2];
        int min = Integer.MAX_VALUE;
        int R=list.size()-1;
        int L=0;
        while(L!=R){
            int sum = list.get(L)+list.get(R);
            if(Math.abs(sum)<min){
                min=Math.abs(sum);
                pair[0]=list.get(L);
                pair[1]=list.get(R);
            }
            if(sum>0){
                R--;
            }else if(sum<0){
                L++;
            }else{
                pair[0]=list.get(L);
                pair[1]=list.get(R);
                return pair;
            }
        }
        return pair;
    }
}