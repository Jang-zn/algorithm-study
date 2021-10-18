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
        solve(1,N,1,N);
        System.out.println(first);
        System.out.println(second);
        System.out.println(third);
    }

    public static void solve(int xstart, int xend, int ystart, int yend){
        if(check(xstart,xend,ystart,yend)){
            if(problem[xstart][ystart]==-1){
                first++;

            }else if(problem[xstart][ystart]==0){
                second++;

            }else{
                third++;
            }
        }else{
            int xx = (xend-xstart)/3+1;
            int yy = (yend-ystart)/3+1;
            // 1 2 3
            solve(xstart,xx,ystart,yy);
            solve(xstart,xx,ystart+yy,2*yy);
            solve(xstart,xx,ystart+2*yy,yend);
            // 4 5 6
            solve(xstart+xx,2*xx,ystart,yy);
            solve(xstart+xx,2*xx,ystart+yy,2*yy);
            solve(xstart+xx,2*xx,ystart+2*yy,yend);
            // 7 8 9
            solve(xstart+2*xx,xend,ystart,yy);
            solve(xstart+2*xx,xend,ystart+yy,2*yy);
            solve(xstart+2*xx,xend,ystart+2*yy,yend);
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