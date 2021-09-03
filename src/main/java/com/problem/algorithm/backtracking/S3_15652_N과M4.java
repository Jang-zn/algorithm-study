package com.problem.algorithm.backtracking;

import java.io.*;

public class S3_15652_N과M4 {
    static int N;
    static int M;
    static int[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        list = new int[M+1];
        solve(1, bw);
        bw.flush();
    }

    public static void solve(int k, BufferedWriter bw) throws IOException{
        if(k==M+1){
            for(int i=1;i<list.length;i++){
                bw.write(String.valueOf(list[i]));
                bw.write(" ");
            }
            bw.write("\n");
            return;
        }else{
            for(int i=1;i<=N;i++){
                if(list[k-1]<=i) {
                    list[k] = i;
                    solve(k + 1, bw);
                }
            }
        }
    }
}