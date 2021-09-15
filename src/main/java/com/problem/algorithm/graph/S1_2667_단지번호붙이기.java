package com.problem.algorithm.graph;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class S1_2667_단지번호붙이기 {

    static int N;
    static int[][] move = {{1,0},{0,1},{-1,0},{0,-1}};
    static ArrayList<Integer> ans = new ArrayList<Integer>();
    static int[][] map;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        map=new int[N][N];
        visit=new boolean[N][N];
        for(int i=0;i<N;i++){
            String[] temp = br.readLine().split("");
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(temp[j]);
                visit[i][j]=false;
            }
        }
        check();
        Collections.sort(ans);
        System.out.println(ans.size());
        for(int i=0;i<ans.size();i++){
            System.out.println(ans.get(i));
        }
    }

    //1. 입력받은 맵 순회, 건물 있으면 탐색
    static void check(){
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                //건물이 있고, 방문하지 않은곳이면'
                if(map[i][j]!=0&&!visit[i][j]){
                    int count = search(i,j);
                    ans.add(count);
                }else{
                    continue;
                }
            }
        }
    }

    // 2.탐색 : 연결된 단지들의 크기를 반환
    static int search(int i, int j) {
        Queue<Integer> q = new LinkedList<>();
        //시작점 방문+1, visit=true;
        int result = 1;
        visit[i][j]=true;
        q.add(i);
        q.add(j);
        //move 4개에 대해 순회
        while (!q.isEmpty()) {
            //좌표출력
            int x = q.poll();
            int y = q.poll();

            //상하좌우 탐색 -> 갈수있으면 q에 추가, 없으면 pass
            for (int m = 0; m < 4; m++) {
                //이동한 좌표
                int mx = x+move[m][0];
                int my = y+move[m][1];
                //map 범위 내 check
                if(0<=mx&&mx<N&&0<=my&&my<N) {
                    //단지가 있고 && 방문하지 않았던곳이면
                    if (map[mx][my] != 0 && !visit[mx][my]) {
                        //방문체크
                        visit[mx][my] = true;
                        //단지크기++
                        result++;
                        //q에 방문할 좌표 입력
                        q.add(mx);
                        q.add(my);
                    }
                }
            }
        }
        return result;
    }

}