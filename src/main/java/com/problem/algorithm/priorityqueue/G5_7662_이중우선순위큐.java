package com.problem.algorithm.priorityqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class G5_7662_이중우선순위큐 {

    static int N;
    static int T;
    static PriorityQueue<Integer> max =new PriorityQueue<>(Collections.reverseOrder());
    static PriorityQueue<Integer> min =new PriorityQueue<>();

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
                        insert(num);
                        System.out.println("min "+min+" "+"max "+max);
                        break;
                    case "D":
                        switch(num){
                            case 1 : max.poll(); break;
                            case -1 : min.poll(); break;
                        }
                        break;
                }
            }


            if(max.isEmpty()&& min.isEmpty()){
                System.out.println("EMPTY");
            }else if(min.isEmpty()){
                System.out.println(max.peek()+" "+max.peek());
            }else if(max.isEmpty()){
                System.out.println(min.peek()+" "+min.peek());
            }else{
                System.out.println(max.peek()+" "+min.peek());
            }
        }
    }

        public static void insert(int n){
            int minsize = min.size();
            int maxsize = max.size();

            //둘다 비었으면 min에 입력
            if(min.isEmpty()&&max.isEmpty()) {
                min.add(n);

            //max가 비어있는 경우
            }else if(max.isEmpty()){
              if(min.peek()<=n){
                  max.add(n);
              }else{
                  max.add(min.poll());
                  min.add(n);
              }
            //사이즈가 다른경우
            }else if(minsize!=maxsize){
                //최소~최대 사이에 있는경우 더 작은쪽에 넣음
                if(min.peek()<n&&n<max.peek()){
                    if(minsize>maxsize){
                        max.add(n);
                    }else{
                        min.add(n);
                    }
                //최소보다 작으면 min 최대보다 크면 max
                }else{
                    if(min.peek()>=n){
                        min.add(n);
                    }else if(max.peek()<=n){
                        max.add(n);
                    }
                }

            //같은경우
            }else{
                //최소~최대 사이에 있는경우 min에 넣음
                if(min.peek()<n&&n<max.peek()){
                    min.add(n);

                //최소보다 작으면 min 최대보다 크면 max
                }else{
                    if(min.peek()>=n){
                        min.add(n);
                    }else if(max.peek()<=n){
                        max.add(n);
                    }
                }
            }
        }
}