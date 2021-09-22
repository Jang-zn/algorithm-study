package com.problem.algorithm.graph;

import java.io.*;

public class S1_11403_경로찾기 {

    static int N;
    static int[][] problem;
    static int[][] sol;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        problem = new int[N][N];
        sol = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] temp =br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                problem[i][j] = Integer.parseInt(temp[j]);
                sol[i][j] = 0;
            }
        }
        solve(0);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(sol[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void solve(int ii){

    }
}