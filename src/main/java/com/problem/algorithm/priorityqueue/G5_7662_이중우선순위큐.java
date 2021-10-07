package com.problem.algorithm.priorityqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class G5_7662_이중우선순위큐 {

    static int N;
    static int T;
    static int dCount=0;
    static int iCount=0;
    static int dMax=0;
    static int dMin=0;

    static PriorityQueue<Integer> max =new PriorityQueue<>(Collections.reverseOrder());
    static PriorityQueue<Integer> min=new PriorityQueue<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int n = 0; n < N; n++) {
            T = Integer.parseInt(br.readLine());
            for (int i = 0; i < T; i++) {
                //명령어 확인
                String[] order = br.readLine().split(" ");
                String func = order[0];
                int num = Integer.parseInt(order[1]);
                //구현
                switch (func) {
                    case "I":
                        iCount++;
                        max.add(n);
                        min.add(n);
                        break;

                    case "D":
                        drop(num);
                        break;
                }
            }

            result();
        }
    }

    public static void drop(int n){
        dCount++;
        if(iCount>dCount){
            switch (n) {
                case 1:
                    dMax++;
                    max.poll();
                    break;
                case -1:
                    dMin++;
                    min.poll();
                    break;
            }
        }else if(iCount==dCount&&iCount!=0&&dCount!=0){
            if(max.peek()!=min.peek()){
                if(dMax>dMin){
                    dMin++;
                    min.poll();
                }else{
                    dMax++;
                    max.poll();
                }
            }else{
                dMax++;
                max.poll();
            }
        }

        //다뽑았으면 초기화
        if(dMax+dMin==iCount&&iCount!=0){
            while(!max.isEmpty()){
                max.poll();
            }
            while(!min.isEmpty()){
                min.poll();
            }
            iCount=0;dCount=0;dMax=0;dMin=0;
        }

    }

    public static void result() {
        if(dCount==iCount){
            System.out.println("EMPTY");
        }else{
            if(iCount-dCount>1){
                System.out.println(max.poll()+" "+min.poll());
            }else{
                if(max.peek()!=min.peek()){
                    if(dMax>dMin){
                        System.out.println(min.peek()+" "+min.peek());
                    }else{
                        System.out.println(max.peek()+" "+max.peek());
                    }
                }else{
                    System.out.println(max.peek()+" "+max.peek());
                }
            }
        }
    }

}