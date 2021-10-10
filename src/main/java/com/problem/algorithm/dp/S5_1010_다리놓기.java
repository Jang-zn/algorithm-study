package com.problem.algorithm.dp;

import java.io.*;

public class S5_1010_다리놓기 {


    static int T;
    static int N;
    static int M;
    static int[][] dp = new int[30][30];

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

    static int combi(int n, int r) {
        // 이미 탐색했던 경우 바로 반환
        if(dp[n][r] > 0) {
            return dp[n][r];
        }
        // 2번 성질
        if(n == r || r == 0) {
            return dp[n][r] = 1;
        }
        // 1번 성질
        return combi(n - 1, r - 1) + combi(n - 1, r);
    }
}