package com.study.algorithm.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class SpanningTree_Prim {
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

    public static void main(String[] args) {
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
        System.out.println(Prim.prim("A",edgeList));

    }

    public static class Prim{
        public static ArrayList<Edge> prim(String startNode, ArrayList<Edge> edgeList){
            //초기화
            ArrayList<String> connectedNodes = new ArrayList<String>();
            ArrayList<Edge> mst = new ArrayList<Edge>();
            HashMap<String, ArrayList<Edge>> graph = new HashMap<String, ArrayList<Edge>>();
            for(int i=0;i<edgeList.size();i++){
                Edge currEdge = edgeList.get(i);
                if(!graph.containsKey(currEdge.node1)){
                    graph.put(currEdge.node1, new ArrayList<Edge>());
                }
                if(!graph.containsKey(currEdge.node2)){
                    graph.put(currEdge.node2, new ArrayList<Edge>());
                }
            }
            for(int i=0;i<edgeList.size();i++){
                Edge currEdge = edgeList.get(i);
                ArrayList<Edge> currEdgeList = graph.get(currEdge.node1);
                currEdgeList.add(new Edge(currEdge.weight, currEdge.node1, currEdge.node2));
                currEdgeList = graph.get(currEdge.node2);
                currEdgeList.add(new Edge(currEdge.weight, currEdge.node2, currEdge.node1));
            }
            connectedNodes.add(startNode);
            ArrayList<Edge> candidateList = graph.getOrDefault(startNode, new ArrayList<Edge>());
            PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
            for(Edge e : candidateList){
                pq.add(e);
            }


            //프림알고리즘 구현
            while(pq.size()>0){
                Edge currEdge = pq.poll();
                if(!connectedNodes.contains(currEdge.node2)){
                    connectedNodes.add(currEdge.node2);
                    mst.add(currEdge);
                    candidateList = graph.getOrDefault(currEdge.node2, new ArrayList<Edge>());
                    for(Edge e : candidateList){
                        if(!connectedNodes.contains(e.node2)) {
                            pq.add(e);
                        }
                    }
                }
            }
            return mst;
        }
    }
}
