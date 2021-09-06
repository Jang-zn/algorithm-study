package com.problem.algorithm.bruteforce;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class S5_1018_체스판다시칠하기 {
    static int N;
    static int M;
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
            board[i]=br.readLine().split("");
        }
        for(int i=0;i<N-7;i++) {
            for(int j=0;j<M-7;j++) {
                count(i, j);
            }
        }
        Collections.sort(color);
        if(color.isEmpty()){
            System.out.println(0);
        }else {
            System.out.println(color.get(0));
        }
    }

    public static void count(int N, int M) {
        String check = board[N][M];
        int change=0;
        for(int i=N;i<N+8;i++) {
            for(int j=M;j<M+8;j++) {
                if(board[i][j].equals(check)){
                    change++;
                }
                if(check.equals("W")){
                    check="B";
                }else{
                    check="W";
                }
            }
            if(check.equals("W")){
                check="B";
            }else{
                check="W";
            }
        }
        int value = Math.min(change,64-change);
        color.add(value);
    }
}