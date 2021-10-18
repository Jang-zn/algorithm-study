package com.problem.algorithm.divideconquer;

import java.io.*;

public class S3_2630_색종이만들기 {

    static int N;
    static int[][] problem;
    static int white = 0;
    static int blue = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        problem = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 1; j <=N ; j++) {
                problem[i][j] = Integer.parseInt(row[j]);
            }
        }
        solve(1,N,1,N);
    }

    public static void solve(int xstart, int xend, int ystart, int yend){
        if(check(start,end)){
            if(problem[start][start]==1){
                blue++;
            }else{
                white++;
            }
        }else{
            solve(start,end/2);
            solve(end/2+1,end);
            solve(end,end/2);
            solve(start,end/2);
        }
    }

    public static boolean check(int xstart, int xend, int ystart, int yend){
        int check = problem[xstart][ystart];
        for (int i = ystart; i <= yend; i++) {
            for (int j = xstart; j <= xend; j++) {
                if(check!=problem[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

}