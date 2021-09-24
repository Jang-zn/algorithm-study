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
        problem = new int[100][100];
        sol = new int[100][100];
        for (int i = 0; i < N; i++) {
            String[] temp =br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                problem[i][j] = Integer.parseInt(temp[j]);
                sol[i][j] = Integer.parseInt(temp[j]);
            }
        }
        solve();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(sol[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void solve(){
        //플로이드-와샬??
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (sol[i][k] == 1 && sol[k][j] == 1) {
                        sol[i][j] = 1;
                    }
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (sol[i][k] == 1 && sol[k][j] == 1) {
                        sol[i][j] = 1;
                    }
                }
            }
        }
    }
}