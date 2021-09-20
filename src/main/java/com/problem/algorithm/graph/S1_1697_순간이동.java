package com.problem.algorithm.graph;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class S1_1697_순간이동 {

    static int N;
    static int M;
    static int[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] temp = br.readLine().split(" ");
        N = Integer.parseInt(temp[0]);
        M = Integer.parseInt(temp[1]);
        visit = new int[100001];
        for(int i=0;i<100001;i++){
            visit[i]=-1;
        }
        solve();
        System.out.println(visit[M]);
    }

    public static void solve(){
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(N);
        visit[N] = 0;
        while(!q.isEmpty()){
            int x = q.poll();
            int r = x+1;
            int l = x-1;
            int teleport = 2*x;
            if(0<=r&&r<100001&&visit[r]==-1){
                visit[r]=visit[x]+1;
                q.add(r);
            }
            if(0<=l&&l<100001&&visit[l]==-1){
                visit[l]=visit[x]+1;
                q.add(l);
            }
            if(0<=teleport&&teleport<100001&&visit[teleport]==-1){
                visit[teleport]=visit[x]+1;
                q.add(teleport);
            }
        }
    }
}