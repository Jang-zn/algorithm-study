package com.problem.algorithm.bruteforce;

import java.io.*;

public class S5_1018_체스판다시칠하기 {
    static int N;
    static int M;
    static String[][] chess = new String[8][8];
    static String[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nm = br.readLine().split(" ");
        N=Integer.parseInt(nm[0]);
        M=Integer.parseInt(nm[1]);
        board = new String[N][M];
        for(int i=0;i<N;i++){
            board[i] = br.readLine().split("");
        }
    }
}