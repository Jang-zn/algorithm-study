package com.problem.algorithm.divideconquer;

import java.io.*;

public class S2_1780_종이의개수 {

    static int N;
    static int[][] problem;
    static int first = 0;
    static int second = 0;
    static int third = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        problem = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 1; j <=N ; j++) {
                problem[i][j] = Integer.parseInt(row[j-1]);
            }
        }
        solve(1,1,N);
        System.out.println(first);
        System.out.println(second);
        System.out.println(third);
    }

    public static void solve(int i, int j, int length){
        if(check(i, j, length)){
            if(problem[i][j]==-1){
                first++;
            }else if(problem[i][j]==0){
                second++;
            }else{
                third++;
            }
        }else{
            int nextLength = length/3;
            // 1 2 3
            solve(i,j,nextLength);
            solve(i,j+nextLength,nextLength);
            solve(i,j+2*nextLength, nextLength);
            // 4 5 6
            solve(i+nextLength,j,nextLength);
            solve(i+nextLength,j+nextLength,nextLength);
            solve(i+nextLength,j+2*nextLength,nextLength);
            // 7 8 9
            solve(i+2*nextLength,j,nextLength);
            solve(i+2*nextLength,j+nextLength,nextLength);
            solve(i+2*nextLength,j+2*nextLength,nextLength);

        }
    }

    public static boolean check(int row,int col,int length){
        int check = problem[row][col];
        for (int i = row; i < row+length; i++) {
            for (int j = col; j < col+length; j++) {
                if(check!=problem[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

}