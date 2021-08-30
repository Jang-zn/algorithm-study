package com.study.algorithm.datastructure;

import java.util.ArrayList;
import java.util.Scanner;

public class Queue {

    public static void main(String[] args) {
        while(true) {
            Scanner sc = new Scanner(System.in);
            System.out.print("메소드 입력 : ");
            String method = sc.nextLine();
            switch (method) {
                case "enqueue":
                    System.out.print("넣을 값 입력 : ");
                    String q = sc.nextLine();
                    enqueue(q);
                    System.out.println("Enqueue : " + queue);
                    break;
                case "dequeue":
                        System.out.println("Dequeue : " + queue.get(queue.size()-1));
                        dequeue();
                    if (!queue.isEmpty()) {
                        System.out.println(queue);
                    } else {
                        System.out.println("null");
                    }
                    break;
                case "exit": return;
            }
        }

    }

    private static ArrayList queue = new ArrayList();

    public static void enqueue(Object q){
        queue.add(0, q);
    }
    public static void dequeue (){
        queue.remove(queue.size()-1);
    }
}
