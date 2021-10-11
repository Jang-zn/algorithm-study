package com.problem.algorithm.dp;

import java.io.*;

public class S5_1010_다리놓기 {


    static int T;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String[] temp = br.readLine().split(" ");
            N = Integer.parseInt(temp[0]);
            M = Integer.parseInt(temp[1]);
            bw.write(combi(M,N)+"\n");
        }
        bw.flush();
    }

    static long combi(int n, int r){
        long a = 1;
        long b = 1;
        if (n/2 < r) r = n - r;

        for(long i=n;i>n-r;i--){
            a*=i;
        }

        for(long i=r;i>0;i--){
            b*=i;
        }
        return a/b;
    }
}