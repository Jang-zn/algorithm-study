package com.problem.algorithm.graph;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class S1_7576_토마토 {

    static int N;
    static int M;
    static int[][] problem;
    static int[][] move = {{1,0},{0,1},{-1,0},{0,-1}};
    static int[][] visit;
    static Queue<Integer> start = new LinkedList<Integer>();
    static int max=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] temp = br.readLine().split(" ");
        M = Integer.parseInt(temp[0]);
        N = Integer.parseInt(temp[1]);
        problem = new int[N][M];
        visit = new int[N][M];
        for (int i = 0; i < N; i++) {
            temp = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                problem[i][j] = Integer.parseInt(temp[j]);
                visit[i][j]=-1;
                if(problem[i][j]==1){
                    start.add(i);
                    start.add(j);
                }
            }
        }
        solve();
        System.out.println(max);
    }

    public static void solve(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                //양배추고, 방문하지 않았으면
                if(problem[i][j]==1&&visit[i][j]==-1){
                    search(i,j);
                }
            }
        }
        //다 돌고 나서 0인 위치가 있는경우
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(problem[i][j]==0&&visit[i][j]==-1){
                    max=-1;
                    return;
                }
            }
        }
    }

    public static void search(int i, int j){
        Queue<Integer> q = new LinkedList<Integer>();
        //매개변수 추가
        start.add(i);
        start.add(j);
        visit[i][j]=0;

        //초기화 : start 가능한 지점 모두 q에 삽입 / visit처리
        while(!start.isEmpty()){
            int sr = start.poll();
            int sc = start.poll();
            visit[sr][sc] = 0;
            q.add(sr);
            q.add(sc);
        }

        //탐색
        while(!q.isEmpty()){
            int r = q.poll();
            int c = q.poll();
            for(int l=0; l<4; l++){
                int mr = r+move[l][0];
                int mc = c+move[l][1];
                //범위 내일때
                if(0<=mr&&mr<N&&0<=mc&&mc<M) {
                    //방문 안했고, 익을수 있으면
                    if (visit[mr][mc] == -1 && problem[mr][mc] == 0) {
                        //방문처리
                        visit[mr][mc] = visit[r][c] + 1;
                        //q add
                        q.add(mr);
                        q.add(mc);
                        //최대값 처리
                        max = Math.max(max, visit[mr][mc]);
                    }
                }
            }
        }

    }
}