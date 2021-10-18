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
                problem[i][j] = Integer.parseInt(row[j-1]);
            }
        }
        solve(1,N,1,N);
        System.out.println(white);
        System.out.println(blue);
    }

    public static void solve(int xstart, int xend, int ystart, int yend){
        if(check(xstart,xend,ystart,yend)){
            if(problem[xstart][ystart]==1){
                blue++;

            }else{
                white++;

            }
        }else{
                //2사분면
                solve(xstart, (xstart+xend)/2, ystart, (ystart+yend)/2);
                //1사분면
                solve((xstart+xend)/2 + 1, xend, ystart, (ystart+yend)/2);
                //3사분면
                solve(xstart, (xstart+xend)/2, (ystart+yend)/2 + 1, yend);
                //4사분면
                solve((xstart+xend)/2 + 1, xend, (ystart+yend)/2 + 1, yend);
        }
    }

    public static boolean check(int xstart, int xend, int ystart, int yend){
        int check = problem[xstart][ystart];
        for (int i = xstart; i <= xend; i++) {
            for (int j = ystart; j <= yend; j++) {
                if(check!=problem[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

}