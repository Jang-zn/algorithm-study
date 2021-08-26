package com.algorithm.datastructure.DoubleLinkedList;

public class test2 {
    public static void main(String[] args) {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
        list.addNode(1);
        list.addNode(2);
        list.addNode(3);
        list.addNode(4);
        list.addNode(5);
        list.printAll();
        System.out.println(list.searchFromHead(5).data);
        System.out.println(list.searchFromTail(3).data);

    }
}
