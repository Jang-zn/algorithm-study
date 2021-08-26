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

    //연결리스트 탐색
    public Node<T> searchData(T isData){
        Node<T> node = this.head;
        //head와 일치할경우
        if(node.data.equals(isData)){
            return node;
        }
        //탐색하면서 일치하는거 찾기
        while(node.next!=null){
            if(node.next.data.equals(isData)){
                return node.next;
            }else{
                node=node.next;
            }
        }
        //없으면 null
        return null;
    }

    //연결리스트 삽입
    public void insertIntNode(T data, T isData){
        Node<T> insert = new Node<T>(data);
        Node<T> search = searchData(isData);

        //있으면 뒤에 넣기
        if(search!=null){
        insert.next = search.next;
        search.next = insert;

        //없으면 맨끝에 넣기
        }else{
            addNode(data);
        }
    }

    //연결리스트 삭제
    public boolean deleteNode(T data){
        Node<T> node = this.head;
        //헤드랑 일치하면 삭제
        if(node.data.equals(data)) {
            this.head = node.next;
            return true;
        }
        while(node.next!=null){
            if(node.next.data.equals(data)){
                node.next = node.next.next;
                return true;
            }
        }
        return false;
    }
}
