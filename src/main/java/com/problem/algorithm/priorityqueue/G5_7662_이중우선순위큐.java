package com.problem.algorithm.priorityqueue;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

public class G5_7662_이중우선순위큐 {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> max =new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> min =new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            if(i==0){
                max.add(n);
                bw.write(max.peek()+"\n");
            }else if(i==1){
                if(max.peek()<n){
                    min.add(n);
                    bw.write(max.peek()+"\n");
                }else{
                    min.add(max.poll());
                    max.add(n);
                    bw.write(max.peek()+"\n");
                }
            }else{
                int maxsize = max.size();
                int minsize = min.size();
                //사이즈 같을때
                if(maxsize==minsize){
                    //1. min보다 작음
                    if(n<min.peek()){
                        max.add(n);
                        bw.write(max.peek()+"\n");
                    //2. min보다 크거나 같음
                    }else{
                        min.add(n);
                        bw.write(min.peek()+"\n");
                    }
                //사이즈 다를때(1개 차이날때)
                }else{
                    if(maxsize>minsize){
                        //1. max min사이에 있음
                        if(max.peek()<n&&n<min.peek()){
                            min.add(n);
                            bw.write(max.peek()+"\n");
                        //2. min 뒤에 들어가는경우
                        }else if(max.peek()<n){
                            min.add(n);
                            bw.write(max.peek()+"\n");
                        //3. max 뒤에 들어가는경우
                        }else{
                            min.add(max.poll());
                            max.add(n);
                            bw.write(max.peek()+"\n");
                        }
                    }else{
                        //1. max min사이에 있음
                        if(max.peek()<n&&n<min.peek()){
                            max.add(n);
                            bw.write(max.peek()+"\n");

                        //2. max 뒤에 들어가는경우
                        }else if(min.peek()>n){
                            max.add(n);
                            bw.write(max.peek()+"\n");
                        //3. min 뒤에 들어가는경우
                        }else{
                            max.add(min.poll());
                            min.add(n);
                            bw.write(max.peek()+"\n");
                        }
                    }
                }
            }
        }
        bw.flush();
    }
}