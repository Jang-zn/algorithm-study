package com.problem.algorithm.graph;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class S1_7569_3차원토마토 {

    static int N;
    static int M;
    static int H;
    static int[][][] problem;
    static int[][][] visit;
    static int[][] move = {{1,0,0},{0,1,0},{-1,0,0},{0,-1,0},{0,0,1},{0,0,-1}};
    static Queue<Integer> start = new LinkedList<Integer>();
    static int max=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] mnh = br.readLine().split(" ");
        N = Integer.parseInt(mnh[1]);
        M = Integer.parseInt(mnh[0]);
        H = Integer.parseInt(mnh[2]);
        visit = new int[N][M][H];
        problem = new int[N][M][H];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                String[] temp = br.readLine().split(" ");
                for (int k = 0; k < M; k++) {
                    problem[j][k][i] = Integer.parseInt(temp[k]);
                    visit[j][k][i] = -1;
                    if (problem[j][k][i] == 1) {
                        start.add(j);
                        start.add(k);
                        start.add(i);
                    }
                }
            }
        }
        solve();
        System.out.println(max);
    }

    public static void solve(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < H; k++) {
                    //양배추고, 방문하지 않았으면
                    if(problem[i][j][k]==1&&visit[i][j][k]==-1){
                        search(i,j,k);
                    }
                }
            }
        }
        //다 돌고 나서 0인 위치가 있는경우
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < H; k++) {
                    if(problem[i][j][k]==0&&visit[i][j][k]==-1){
                        max=-1;
                        return;
                    }
                }
            }
        }
    }

    public static void search(int i, int j, int k){
        Queue<Integer> q = new LinkedList<Integer>();
        //매개변수 추가
        start.add(i);
        start.add(j);
        start.add(k);
        visit[i][j][k]=0;

        //초기화 : start 가능한 지점 모두 q에 삽입 / visit처리
        while(!start.isEmpty()){
            int sr = start.poll();
            int sc = start.poll();
            int sh = start.poll();
            visit[sr][sc][sh] = 0;
            q.add(sr);
            q.add(sc);
            q.add(sh);
        }

        //탐색
        while(!q.isEmpty()){
            int r = q.poll();
            int c = q.poll();
            int h = q.poll();
            for(int l=0; l<6; l++){
                int mr = r+move[l][0];
                int mc = c+move[l][1];
                int mh = h+move[l][2];
                //범위 내일때
                if(0<=mr&&mr<N&&0<=mc&&mc<M&&0<=mh&&mh<H) {
                    //방문 안했고, 익을수 있으면
                    if (visit[mr][mc][mh] == -1 && problem[mr][mc][mh] == 0) {
                        //방문처리
                        visit[mr][mc][mh] = visit[r][c][h] + 1;
                        //q add
                        q.add(mr);
                        q.add(mc);
                        q.add(mh);
                        //최대값 처리
                        max = Math.max(max, visit[mr][mc][mh]);
                    }
                }
            }
        }

    }
}