package com.problem.algorithm.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S3_15651_N과M3_1 {
    static int N;
    static int M;
    static int[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        list = new int[M+1];
        solve(1);
    }

    public static void solve(int k){
        if(k==M+1){
            for(int i=1;i<list.length;i++){
                System.out.print(list[i]);
                System.out.print(" ");
            }
            System.out.println();
            return;
        }else{
            for(int i=1;i<=N;i++){
                list[k] = i;
                solve(k+1);
            }
        }
    }
}
