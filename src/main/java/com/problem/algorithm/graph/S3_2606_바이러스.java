package com.problem.algorithm.graph;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class S3_2606_바이러스 {

    static int N;
    static int M;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
    static boolean[] visit;
    static int count=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        visit = new boolean[N+1];
        for (int i = 0; i < N+1; i++) {
            list.add(new ArrayList<Integer>());
            visit[i]=false;
        }
        for (int i = 0; i < M; i++) {
            String[] temp = br.readLine().split(" ");
            list.get(Integer.parseInt(temp[0])).add(Integer.parseInt(temp[1]));
            list.get(Integer.parseInt(temp[1])).add(Integer.parseInt(temp[0]));
        }
        solve();
        System.out.println(count);
    }

    public static void solve(){
        Queue<Integer> q = new LinkedList<Integer>();
        //초기화
        ArrayList<Integer> temp = list.get(1);

        //1에서 갈데가 없으면 종료
        if(temp.size()<1){
            count=0;
            return;
        }
        //아니면 진행
        for(int l : temp){
            q.add(l);
        }
        visit[1]=true;
        while(!q.isEmpty()){
            int currPC = q.poll();
            //현재 pc에 방문한적 없으면
            if(!visit[currPC]){
                visit[currPC]=true;
                ArrayList<Integer> next = list.get(currPC);
                for (int l : next) {
                    q.add(l);
                }
                count++;
            }
        }
    }
}