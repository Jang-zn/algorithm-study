package com.algorithm.datastructure;

import java.util.ArrayList;
import java.util.Scanner;

public class Stack {

    public static void main(String[] args) {
        while(true) {
            Scanner sc = new Scanner(System.in);
            System.out.print("메소드 입력 : ");
            String method = sc.nextLine();
            switch (method) {
                case "push":
                    System.out.print("넣을 값 입력 : ");
                    String s = sc.nextLine();
                    push(s);
                    System.out.println("push : " + stack);
                    break;
                case "pop" :
                    if (!stack.isEmpty()) {
                        System.out.println("pop : " + stack.get(stack.size()-1));
                        pop();
                        System.out.println(stack.isEmpty()?"null":stack);
                    } else {
                        System.out.println("null");
                    }
                    break;
                case "exit": return;
            }
        }

    }

    private static ArrayList stack = new ArrayList();

    public static void push(Object q){
        stack.add(q);
    }
    public static void pop (){
        if(!stack.isEmpty()) {
            stack.remove(stack.size() - 1);
        }else {
            return;
        }
    }
}
