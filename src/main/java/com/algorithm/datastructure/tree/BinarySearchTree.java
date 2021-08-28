package com.algorithm.datastructure.tree;

import java.util.ArrayList;

//영상에서는 LinkedList로 구현했는데 나는 그냥 ArrayList로 구현 + 재귀호출 활용해서 만들어본다.
//Tree 내에서 중복값은 무시하는것으로 가정 (안넣어줄거임)
public class BinarySearchTree {

    private int level = 0;
    private ArrayList<Integer> tree;

    public BinarySearchTree() {
        this.tree = new ArrayList<Integer>();
    }



    public boolean insertValue (int parentIdx, int value){
        int leftIdx = parentIdx*2;
        int rightIdx = parentIdx*2+1;

        if(tree.size()<Math.pow(2,level+2)){
            for(int i=0;tree.size()<Math.pow(2,level+2);i++){
                tree.add(null);

            }
        }

        //도착한 노드가 null인 경우
        if(this.tree.get(parentIdx)==null){
            this.tree.set(parentIdx,value);
            level=0;
            return true;
        }
        //하위노드가 없는경우
        if(leftIdx>=this.tree.size()&&rightIdx>=this.tree.size()){
            if(this.tree.get(parentIdx)>value){
                this.tree.set(leftIdx,value);
                level=0;
                return true;
            }else{
                this.tree.set(rightIdx,value);
                level=0;
                return true;
            }
        //하위노드가 하나만 있는 경우
        //left
        }else if(leftIdx<this.tree.size()&&rightIdx>=this.tree.size()){
            //right에 들어가면 될 경우
            if(this.tree.get(parentIdx)<value){
                this.tree.set(rightIdx,value);
                level=0;
                return true;
            //left랑 비교해야 될 경우
            }else{
                level++;
                insertValue(leftIdx,value);
            }
        //right
        }else if(rightIdx<this.tree.size()&&leftIdx>=this.tree.size()){
            //left에 들어가면 될 경우
            if(this.tree.get(parentIdx)>value){
                this.tree.set(leftIdx,value);
                level=0;
                return true;
                //right랑 비교해야 될 경우
            }else{
                level++;
                insertValue(rightIdx,value);
            }

        //하위노드가 둘다 있는경우
        }else{
            //left랑 비교할 경우
            if(this.tree.get(parentIdx)>value){
                level++;
                insertValue(leftIdx,value);
            //right랑 비교해야 될 경우
            }else{
                level++;
                insertValue(rightIdx,value);
            }
        }
        level=0;
        return true;
    }

    public void printTree() {
        for (int l=0; l < baseLog(tree.size(), 2); l++) {
            for (int i = (int)Math.pow(2,l); i < Math.pow(2,l+1); i++) {
                System.out.print(" "+tree.get(i)+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insertValue(1,20);

        bst.insertValue(1,15);

        bst.insertValue(1,23);

        bst.insertValue(1,10);

        bst.insertValue(1,27);

        bst.insertValue(1,21);
        bst.insertValue(1,11);
        bst.insertValue(1,2);
        bst.insertValue(1,14);
        bst.insertValue(1,13);
        bst.printTree();

    }

    static double baseLog(double x, double base) {
        return Math.log(x) / Math.log(base);
    }

}
