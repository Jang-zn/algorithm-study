package com.problem.algorithm.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class S5_1436_영화감독숌 {
    static ArrayList<Integer> list = new ArrayList<Integer>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        solve(N);
        System.out.println(list.get(N-1));
    }
    public static void solve(int N){
        int n=666;
        while(list.size()<N){
            if(String.valueOf(n).indexOf("666")!=-1) {
                list.add(n);
            }
            n++;
        }
    }
}