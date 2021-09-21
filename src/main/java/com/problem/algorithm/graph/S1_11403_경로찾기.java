package com.problem.algorithm.graph;

import java.io.*;

public class S1_11403_경로찾기 {

    static int N;
    static int[][] problem;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        problem = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                String[] temp =br.readLine().split(" ");
                problem[i][j] = Integer.parseInt(temp[j]);
            }
        }
    }
}