package com.study.algorithm.datastructure.DoubleLinkedList;

public class test2 {
    public static void main(String[] args) {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
        list.addNode(1);
        list.addNode(2);
        list.addNode(3);
        list.printAll();

        list.insertNext(10,1);
        list.insertNext(20,2);
        list.insertNext(30,3);
        list.insertPrev(-10,1);
        list.insertPrev(-20,2);
        list.insertPrev(-30,3);
        list.insertNext(100,7);
        list.insertPrev(-100,6);
        list.printAll();
    }
}
