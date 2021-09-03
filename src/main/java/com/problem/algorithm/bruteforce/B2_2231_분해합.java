package com.problem.algorithm.bruteforce;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class B2_2231_분해합 {

    static ArrayList<Integer> list = new ArrayList<Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String p = br.readLine();
        int N = Integer.parseInt(p);
        int length = p.length();
        solve(N,length);
        if(list.size()>0) {
            Collections.sort(list);
            System.out.println(list.get(0));
        }else{
            System.out.println(0);
        }
    }

    public static void solve(int N, int length){
        for(int i=1;i<=9*length;i++){
            int check = N-i;
            if(check>0) {
                int plus = 0;
                String[] p = String.valueOf(check).split("");
                for (String s : p) {
                    plus += (Integer.parseInt(s));
                }
                if (check + plus == N) {
                    list.add(check);
                }
            }
        }
    }
}