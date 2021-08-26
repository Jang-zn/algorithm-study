package com.algorithm.datastructure.DoubleLinkedList;

public class DoubleLinkedList<T> {
    Node<T> head = null;
    Node<T> tail = null;

    public class Node<T> {
        T data;
        Node<T> next = null;
        Node<T> prev = null;

        public Node(T data) {
            this.data=data;
        }
    }

    public void addNode(T data){
        Node<T> node = this.head;
        if(node==null){
            this.head = new Node<T>(data);
            this.tail = this.head;
        }else{
            while(node.next!=null){
                node = node.next;
            }
            node.next = new Node<T>(data);
            node.next.prev = node;
            this.tail = node.next;
        }
    }

    public void printAll(){
        Node<T> node = this.head;
        if(node!=null){
            System.out.print("[");
            while(node.next!=null){
                System.out.print(node.data+",");
                node=node.next;
            }
            System.out.print(node.data+"]\n");
        }else{
            System.out.println("null");
        }
    }

    public Node<T> searchFromHead(T data){
        Node<T> node = this.head;

        if(node==null){
            return null;
        }

        if(node.data.equals(data)){
            return node;
        }

        while(node.next!=null){
            node = node.next;
            if(node.data.equals(data)){
                return node;
            }
        }
        return null;
    }

    public Node<T> searchFromTail(T data){
        Node<T> node = this.tail;
        if(node==null){
            return null;
        }
        if(node.data.equals(data)){
            return node;
        }
        while(node.prev!=null){
            node = node.prev;
            if(node.data.equals(data)){
                return node;
            }
        }
        return null;
    }


    //노드 앞에 insert
    public void insertPrev(T data, T isData){
        Node<T> search = searchFromHead(isData);
        Node<T> insert = new Node<T>(data);
        if(search==null){
            search = this.head;
            search.prev = insert;
            insert.next = search;
            this.head = insert;
        }else if(search.prev==null){
            search.prev = insert;
            insert.next = search;
            this.head = insert;
        }else{
            insert.next = search;
            insert.prev = search.prev;
            search.prev.next = insert;
            search.prev = insert;
        }
    }
    //노드 뒤에 insert
    public void insertNext(T data, T isData){
        Node<T> search = searchFromHead(isData);
        Node<T> insert = new Node<T>(data);
        if(search==null){
            search = this.tail;
            search.next = insert;
            insert.prev = search;
            this.tail = insert;
        }else if(search.next==null){
            search.next = insert;
            insert.prev = search;
            this.tail = insert;
        }else{
            insert.prev = search;
            insert.next = search.next;
            search.next.prev = insert;
            search.next = insert;
        }
    }
}
