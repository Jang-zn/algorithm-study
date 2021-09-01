package com.study.algorithm.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class SpanningTree_Kruskal {
    public static class Edge implements Comparable<Edge>{
        int weight;
        String node1;
        String node2;

        public Edge(int weight, String node1, String node2) {
            this.weight = weight;
            this.node1 = node1;
            this.node2 = node2;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight-o.weight;
        }

        @Override
        public String toString() {
            return "("+this.node1+" "+this.weight+" "+this.node2+")";
        }
    }


    public static HashMap<String, String> rootNode = new HashMap<String, String>();
    public static HashMap<String, Integer> nodeRank = new HashMap<String, Integer>();

    public static String find(String node){
        //path Compression
        if(rootNode.get(node)!=node){
            rootNode.put(node,find(rootNode.get(node)));
        }
        return rootNode.get(node);
    }

    public static void union(String node1, String node2){
        String root1 = rootNode.get(node1);
        String root2 = rootNode.get(node2);
        if(nodeRank.get(root1)>nodeRank.get(root2)){
            rootNode.put(root2,root1);
        }else{
            rootNode.put(root1,root2);
            if(nodeRank.get(root1)==nodeRank.get(root2)){
                nodeRank.put(root2,nodeRank.get(root2)+1);
            }
        }
    }

    public static void start(ArrayList<String> list){
        for(String s : list){
            rootNode.put(s,s);
            nodeRank.put(s,0);
        }
    }

    public static ArrayList<Edge> kruskal(ArrayList<String> nodeList, ArrayList<Edge> edgeList){
        ArrayList<Edge> mst = new ArrayList<Edge>();
        Edge currEdge;
        int weight;
        String node1, node2;
        start(nodeList);
        Collections.sort(edgeList);
        for(int i=0;i<edgeList.size();i++){
            currEdge = edgeList.get(i);
            if(find(currEdge.node1)!=find(currEdge.node2)){
                union(currEdge.node1, currEdge.node2);
                mst.add(currEdge);
            }
        }

        return mst;
    }


    public static void main(String[] args) {
        ArrayList<String> nodeList = new ArrayList<String>(Arrays.asList("A","B","C","D","E","F","G"));
        ArrayList<Edge> edgeList = new ArrayList<Edge>();
        edgeList.add(new Edge(7,"A","B"));
        edgeList.add(new Edge(5,"A","D"));
        edgeList.add(new Edge(9,"B","D"));
        edgeList.add(new Edge(8,"B","C"));
        edgeList.add(new Edge(7,"B","E"));
        edgeList.add(new Edge(5,"C","E"));
        edgeList.add(new Edge(6,"D","F"));
        edgeList.add(new Edge(8,"E","F"));
        edgeList.add(new Edge(7,"D","E"));
        edgeList.add(new Edge(11,"F","G"));
        edgeList.add(new Edge(9,"E","G"));
        ArrayList<Edge> mst = kruskal(nodeList,edgeList);
        System.out.println(mst);
    }



}

