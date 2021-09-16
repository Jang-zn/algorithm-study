package com.problem.algorithm.graph;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class S1_2178_미로탐색 {

    static int N;
    static int M;
    static int[][] problem;
    static int[][] course;
    static int[][] move = {{1,0},{0,1},{-1,0},{0,-1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nm = br.readLine().split(" ");
        N = Integer.parseInt(nm[0]);
        M = Integer.parseInt(nm[1]);
        problem = new int[N][M];
        course = new int[N][M];
        for(int i=0;i<N;i++){
            String[] temp = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                problem[i][j] = Integer.parseInt(temp[j]);
                course[i][j]=-1;
            }
        }
        solve();
        System.out.println(course[N-1][M-1]);
    }

    public static void solve(){
        //초기화
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(0);q.add(0);
        course[0][0]=1;
        while(!q.isEmpty()){
            int x = q.poll();
            int y = q.poll();
            for (int i = 0; i < 4; i++) {
                int mx = x+move[i][0];
                int my = y+move[i][1];
                //Map 안일 경우에만 진행
                if(0<=mx&&mx<N&&0<=my&&my<M) {
                    //갈수 있고 방문 안한곳이면
                    if (problem[mx][my] == 1 && course[mx][my] == -1) {
                        course[mx][my] = course[x][y] + 1;//거리 갱신 - 이전점까지의 거리+1
                        q.add(mx);
                        q.add(my); //좌표 q에 넣음
                    }
                }
            }
        }
    }
}