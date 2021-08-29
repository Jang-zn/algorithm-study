package com.algorithm.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class BreadthFirstSearch {
    public class graph {
        private HashMap<String, ArrayList<String>> graph = new HashMap<String, ArrayList<String>>();
        public graph(){
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
    }

}
