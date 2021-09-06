package com.problem.algorithm.bruteforce;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class S5_1018_체스판다시칠하기 {
    static int N;
    static int M;
    static String[][] chess = new String[8][8];
    static String[][] board;
    static ArrayList<Integer> color=new ArrayList<Integer>();

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
        count(0,0,board);
    }

    public static void count(int N, int M, String[][] board){
        if(N+8>=board.length||M+8>=board[0].length){
            return;
        }else {
            for (int i = N; i < board.length - 8; i++) {
                for (int j = M; j < board[0].length - 8; j++) {
                    chess[i][j] = board[i][j];
                }
            }
            int check = 0;
            for (int i = 0; i < N - 1; i++) {
                for (int j = 0; j < M - 1; j++) {
                    if (chess[i][j].equals(chess[i + 1][j]) || chess[i][j].equals(chess[i][j + 1])) {
                        check++;
                    }
                }
            }
            color.add(check);
            count(N+1,M,board);
            count(N,M+1,board);
            count(N+1,M+1,board);
            Collections.sort(color);
            System.out.println(color.get(0));
        }
    }
}