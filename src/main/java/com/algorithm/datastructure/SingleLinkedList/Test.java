package com.algorithm.datastructure.SingleLinkedList;

public class Test {
    public static void main(String[] args) {
        SingleLinkedList<Integer> list = new SingleLinkedList<Integer>();
        list.addNode(10);
        list.addNode(20);
        list.addNode(30);
        list.insertIntNode(15);
        list.insertIntNode(25);
        list.insertIntNode(11);
        list.printAll();
    }
}
