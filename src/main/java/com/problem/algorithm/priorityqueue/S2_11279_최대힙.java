package com.problem.algorithm.priorityqueue;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

public class S2_11279_최대힙 {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(Collections.reverseOrder());
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            if(n==0){
                if(!q.isEmpty()) {
                    bw.write(q.poll() + "\n");
                }else{
                    bw.write(0 + "\n");
                }
            }else{
                q.add(n);
            }
        }
        bw.flush();
    }
}