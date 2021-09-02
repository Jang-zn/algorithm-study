package com.study.algorithm.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class SpanningTree_Prim_improve {
    public static class Node implements Comparable<Node>{
        String nextNode;
        int weight;

        public Node(String nextNode, int weight) {
            this.nextNode = nextNode;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight-o.weight;
        }

        @Override
        public String toString() {
            return "("+this.weight+" "+this.nextNode+")";
        }
    }

    public static class Path{
        int weight;
        String node1;
        String node2;

        public Path(int weight, String node1, String node2) {
            this.weight = weight;
            this.node1 = node1;
            this.node2 = node2;
        }

        @Override
        public String toString() {
            return "("+this.weight+" "+this.node1+" "+this.node2+")";
        }
    }

    public static void main(String[] args) {
        //graph 자료구조화
        HashMap<String, HashMap<String, Integer>> graph = new HashMap<String, HashMap<String, Integer>>();
        HashMap<String, Integer> edges = new HashMap<String, Integer>();
        edges.put("B",7);
        edges.put("D",5);
        graph.put("A",edges);

        edges = new HashMap<String, Integer>();
        edges.put("A",7);
        edges.put("D",9);
        edges.put("C",8);
        edges.put("E",7);
        graph.put("B",edges);

        edges = new HashMap<String, Integer>();
        edges.put("B",8);
        edges.put("E",5);
        graph.put("C",edges);

        edges = new HashMap<String, Integer>();
        edges.put("A",5);
        edges.put("B",9);
        edges.put("E",7);
        edges.put("F",6);
        graph.put("D",edges);

        edges = new HashMap<String, Integer>();
        edges.put("B",7);
        edges.put("C",5);
        edges.put("D",7);
        edges.put("F",8);
        edges.put("G",9);
        graph.put("E",edges);

        edges = new HashMap<String, Integer>();
        edges.put("D",6);
        edges.put("E",8);
        edges.put("G",11);
        graph.put("F",edges);

        edges = new HashMap<String, Integer>();
        edges.put("E",9);
        edges.put("F",11);
        graph.put("G",edges);

        System.out.println(graph);
        prim(graph,"A");

    }

    public static void prim(HashMap<String,HashMap<String, Integer>> graph, String startNode){
        ArrayList<Path> mst = new ArrayList<Path>();
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        Node addNode=null;
        HashMap<String, Node> keyObject = new HashMap<String, Node>();
        HashMap<String, String> mstPath = new HashMap<String, String>();
        int totalWeight;
        //초기세팅
        for(String key : graph.keySet()){
            if(key.equals(startNode)){
                addNode = new Node(key,0);
                mstPath.put(key,key);
            }else{
                addNode = new Node(key,Integer.MAX_VALUE);
                mstPath.put(key,null);
            }
            pq.add(addNode);
            keyObject.put(key,addNode);
        }

        //로직
        while(pq.size()>0){
            Node currNode = pq.poll();
            keyObject.remove(currNode.nextNode);


            mst.add(new Path(currNode.weight,mstPath.get(currNode.nextNode), currNode.nextNode));
            HashMap<String, Integer> adjacentEdge = graph.get(currNode.nextNode);


            for(String s : adjacentEdge.keySet()){
                if(keyObject.containsKey(s)){
                    Node linked = keyObject.get(s);
                    if(adjacentEdge.get(s)<linked.weight){
                        linked.weight = adjacentEdge.get(s);
                        adjacentEdge.put(s,linked.weight);
                        mstPath.put(s,currNode.nextNode);

                        //우선순위 큐 업데이트 뺐다가 넣으면 업데이트 된다.
                        pq.remove(linked);
                        pq.add(linked);
                    }
                }
            }
        }

        System.out.println(mst);
        System.out.println(mstPath);
    }
}
