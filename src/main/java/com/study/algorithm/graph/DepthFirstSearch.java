package com.study.algorithm.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class DepthFirstSearch {
    public HashMap<String, ArrayList<String>> graph = new HashMap<String, ArrayList<String>>();
    public DepthFirstSearch(){
        this.graph.put("A", new ArrayList<String>(Arrays.asList("B","C")));
        this.graph.put("B", new ArrayList<String>(Arrays.asList("A","D")));
        this.graph.put("C", new ArrayList<String>(Arrays.asList("A","G","H","I")));
        this.graph.put("D", new ArrayList<String>(Arrays.asList("B","E","F")));
        this.graph.put("E", new ArrayList<String>(Arrays.asList("D")));
        this.graph.put("F", new ArrayList<String>(Arrays.asList("D")));
        this.graph.put("G", new ArrayList<String>(Arrays.asList("C")));
        this.graph.put("H", new ArrayList<String>(Arrays.asList("C")));
        this.graph.put("I", new ArrayList<String>(Arrays.asList("C","J")));
        this.graph.put("J", new ArrayList<String>(Arrays.asList("I")));
    }




    public static void main(String[] args) {
        DepthFirstSearch dfs = new DepthFirstSearch();
        ArrayList<String> visited = new ArrayList<String>();
        ArrayList<String> needVisit = new ArrayList<String>();

        //DFS
        needVisit.add("A");
        while(visited.size()<10){
            String node = needVisit.remove(needVisit.size()-1);
            if(!visited.contains(node)) {
                visited.add(node);
                needVisit.addAll(dfs.graph.get(node));
            }
            System.out.println("visited : "+visited);
            System.out.println("needVisit : "+needVisit);
        }
        System.out.println("visited : "+visited);

    }

}
