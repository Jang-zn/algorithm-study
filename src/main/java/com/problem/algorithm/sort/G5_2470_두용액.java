package com.problem.algorithm.sort;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class G5_2470_두용액 {
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
        for(int i=0;i<list.size();i++){
            int x = list.get(i);
            int y = binary(-1*x,i+1,list.size()-1);
            if(Math.abs(min)>Math.abs(x+y)&&x!=y) {
                pair[0] = x;
                pair[1] = y;
                min=x+y;
            }
        }
        return pair;
    }

    public static int binary(int x, int l, int r){
        int result=list.get(r);
        while(l<=r) {
            if(l==r){
                if(list.get(l-1)!=-1*x&&list.get(l)!=-1*x) {
                    int a = Math.abs(x-list.get(l));
                    int b = Math.abs(x-list.get(l-1));
                    result = a < b ? list.get(l) : list.get(l - 1);
                }else{
                    result = list.get(l)==-1*x?list.get(l-1):list.get(l);
                }
                break;
            }
            int m = (l+r)/2;
            int midVal = list.get(m);
            if(midVal>x){
                r = m;
            }else if(midVal<x){
                l=m+1;
            }else{
                result = midVal;
                break;
            }
        }

        return result;
    }
}