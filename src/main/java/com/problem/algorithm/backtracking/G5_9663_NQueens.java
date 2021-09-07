package com.problem.algorithm.backtracking;

import java.io.*;
import java.util.ArrayList;

public class G5_9663_NQueens {
    static ArrayList board = new ArrayList();
    static int N;
    int count=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
    }

    public void queen(int col){
        if(col>=N){
            return;
        }else{
            boolean check = true;
            while(check){

            }
            queen(col+1);
        }
    }
}