package com.problem.algorithm.graph;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class S2_1012_유기농배추 {

    static int T;
    static int N;
    static int M;
    static int K;
    static int[][] problem;
    static boolean[][] visit;
    static int[][] move = {{1,0},{0,1},{-1,0},{0,-1}};
    static ArrayList<Integer> list = new ArrayList<Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++){
            String[] temp = br.readLine().split(" ");
            M = Integer.parseInt(temp[0]);
            N = Integer.parseInt(temp[1]);
            K = Integer.parseInt(temp[2]);
            problem = new int[N][M];
            visit = new boolean[N][M];
            for(int j=0;j<K;j++){
                String[] xy = br.readLine().split(" ");
                int x = Integer.parseInt(xy[1]);
                int y = Integer.parseInt(xy[0]);
                problem[x][y] = 1;
                visit[x][y]=false;
            }
            solve();
            System.out.println(list.size());
            list = new ArrayList<Integer>();
        }
    }

    public static void solve(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                //방문 안한 배추인 경우
                if(!visit[i][j]&&problem[i][j]==1) {
                    int bug = search(i, j);
                    list.add(bug);
                }
            }
        }
    }

    public static int search(int currX, int currY){
        Queue<Integer> q = new LinkedList<Integer>();
        //초기화
        int count=1;
        q.add(currX);q.add(currY);
        visit[currX][currY]=true;

        while(!q.isEmpty()) {
            int x = q.poll();
            int y = q.poll();
            for(int i=0;i<4;i++){
                int mx = x+move[i][0];
                int my = y+move[i][1];
                //Map 안에 있는경우
                if(0<=mx&&mx<N&&0<=my&&my<M) {
                    //배추고 방문 안한경우
                    if (problem[mx][my] == 1 && !visit[mx][my]) {
                        visit[mx][my] = true;
                        q.add(mx);
                        q.add(my);
                        count++;
                    }
                }
            }
        }
        return count;
    }
}