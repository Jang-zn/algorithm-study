package com.algorithm.datastructure.SingleLinkedList;

public class SingleLinkedList<T> {
    Node<T> head = null;

    public class Node<T> {
        T data;
        Node<T> next = null;

        public Node(T data) {
            this.data=data;
        }
    }

    //노드 추가
    public void addNode(T data){
        if(head==null){
            head = new Node<T>(data);
        }else{
            Node<T> node = this.head;
            while(node.next!=null){
                node = node.next;
            }
            node.next=new Node<T>(data);
        }
    }

    // 연결리스트 출력
    public void printAll(){
        if(head==null){
            System.out.println(head.data);
        }else{
            Node<T> node = this.head;
            while(node.next!=null){
                System.out.println(node.data);
                node = node.next;
            }
            System.out.println(node.data);
        }
    }

    //연결리스트 삽입 (int형 가정 정렬방식으로 구현)
    public void insertIntNode(T data){
        Node<T> node = this.head;
        Node<T> insert = new Node<T>(data);
        while((int)(node.data)<=(int)(insert.data)){
            if(node.next==null){
                node.next = insert;
            }else {
                insert.next = node.next;
                Node temp = node.next;
                node.next = insert;
                node=temp;
            }
        }
    }
}
