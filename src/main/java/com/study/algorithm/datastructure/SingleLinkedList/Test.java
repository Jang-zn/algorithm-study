package com.study.algorithm.datastructure.SingleLinkedList;

public class Test {
    public static void main(String[] args) {
        SingleLinkedList<Integer> list = new SingleLinkedList<Integer>();
        list.addNode(10);
        list.printAll();
        System.out.println("------------");
        list.addNode(20);
        list.printAll();
        System.out.println("------------");
        list.addNode(30);
        list.printAll();
        System.out.println("------------");
        list.insertIntNode(5,10);
        list.printAll();
        System.out.println("------------");
        list.insertIntNode(25,20);
        list.printAll();
        System.out.println("------------");
        list.insertIntNode(35,30);
        list.printAll();
        System.out.println("------------");
        list.deleteNode(5);
        list.printAll();
        System.out.println("------------");
    }
}
