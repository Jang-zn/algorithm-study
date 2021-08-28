package com.algorithm.datastructure.tree;

import java.util.ArrayList;
import java.util.Collections;

public class MaxHeap {
    private ArrayList<Integer> heap;

    public MaxHeap(){
        this.heap = new ArrayList<Integer>();
        heap.add(0);
    }

    public void insertNode(int currIdx, int value){
        int parent = currIdx/2;
        int left = currIdx*2;
        int right = currIdx*2+1;

        if(heap.size()-1<right){
            addPlace(right);
        }

        if(heap.get(1)==null){
            heap.set(currIdx,value);
            return;

        }else if(heap.get(currIdx)==null){
            heap.set(currIdx,value);
            swap(currIdx);
            return;
        }else if(heap.get(left)==null){
            insertNode(left,value);
        }else if(heap.get(right)==null){
            insertNode(right,value);
        }else{
            insertNode(currIdx+1,value);
        }
    }
    public void swap(int currIdx){
        int parent = currIdx/2;
        if(currIdx==1){
            return;
        }
        if(heap.get(parent)<heap.get(currIdx)){
            Collections.swap(heap,parent,currIdx);
            swap(parent);
        }else{
            swap(parent);
        }
    }

    public void rSwap(int index){
        int left = index*2;
        int right = index*2+1;
        if(heap.size()-1<right||heap.get(left)==null&&heap.get(right)==null){
            return;
        }
        boolean lr;
        try {
            lr = heap.get(left) > heap.get(right) ? true : false;
        }catch(Exception e){
            lr=true;
        }
        if(lr){
            if(heap.get(index)<heap.get(left)) {
                Collections.swap(heap, left, index);
                rSwap(left);
            }
        }else{
            if(heap.get(index)<heap.get(right)) {
                Collections.swap(heap, right, index);
                rSwap(right);
            }
        }
    }

    public void addPlace(int length){
        if(heap.size()-1<length){
            while(heap.size()-1<length){
                heap.add(null);
            }
        }
    }

    public int pop(){
        int root = heap.get(1);
        int lastIndex = heap.indexOf(null);
        Collections.swap(heap,1,lastIndex-1);
        heap.remove(lastIndex-1);
        rSwap(1);
        return root;
    }


    public void printHeap(){
        ArrayList list = new ArrayList(heap.subList(1,heap.size()));
        System.out.println(list);
    }


    public static void main(String[] args) {
        MaxHeap myHeap = new MaxHeap();
        for(int i=1;i<20;i++){
            myHeap.insertNode(1,i);
        }
        myHeap.printHeap();
        System.out.println(myHeap.pop());
        myHeap.printHeap();
        System.out.println(myHeap.pop());
        myHeap.printHeap();
        System.out.println(myHeap.pop());
        myHeap.printHeap();
        System.out.println(myHeap.pop());
        myHeap.printHeap();
        System.out.println(myHeap.pop());
        myHeap.printHeap();
        System.out.println(myHeap.pop());
        myHeap.printHeap();
        System.out.println(myHeap.pop());
        myHeap.printHeap();
        System.out.println(myHeap.pop());
        myHeap.printHeap();
        System.out.println(myHeap.pop());
        myHeap.printHeap();
        System.out.println(myHeap.pop());
        myHeap.printHeap();
    }
}

