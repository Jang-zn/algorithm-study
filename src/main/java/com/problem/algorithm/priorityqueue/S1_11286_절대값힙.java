package com.problem.algorithm.priorityqueue;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class S1_11286_절대값힙 {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(Math.abs(o1)!=Math.abs(o2)) {
                    return Math.abs(o1) - Math.abs(o2);
                }else{
                    return o1-o2;
                }
            }
        });
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                if (!q.isEmpty()) {
                    bw.write(q.poll() + "\n");
                } else {
                    bw.write(0 + "\n");
                }
            } else {
                q.add(n);
            }
        }
        bw.flush();
    }

}
