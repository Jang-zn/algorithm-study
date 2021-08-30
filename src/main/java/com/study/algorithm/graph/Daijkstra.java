package com.study.algorithm.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Daijkstra {
    public static class Vertex implements Comparable<Vertex>{
        public String vertex;
        public int distance;
        public Vertex(String vertex, int distance){
            this.vertex = vertex;
            this.distance=distance;
        }
        @Override
        public int compareTo(Vertex v) {
            return this.distance-v.distance;
        }

        @Override
        public String toString() {
            return "Vertex : "+this.vertex+", Distance : "+this.distance;
        }

    }



    public static void main(String[] args) {
        //graph 세팅
        HashMap<String, ArrayList<Vertex>> graph = new HashMap<String, ArrayList<Vertex>>();
        graph.put("A", new ArrayList<Vertex>(Arrays.asList(new Vertex("B",8),new Vertex("C",1),new Vertex("D",2))));
        graph.put("B", new ArrayList<Vertex>());
        graph.put("C", new ArrayList<Vertex>(Arrays.asList(new Vertex("B",5),new Vertex("D",2))));
        graph.put("D", new ArrayList<Vertex>(Arrays.asList(new Vertex("E",3),new Vertex("F",5))));
        graph.put("E", new ArrayList<Vertex>(Arrays.asList(new Vertex("F",1))));
        graph.put("F", new ArrayList<Vertex>(Arrays.asList(new Vertex("A",5))));

        //거리 저장 및 우선순위 큐 준비
        HashMap<String, Integer> distance = new HashMap<String, Integer>();
        for(String s : graph.keySet()){
            distance.put(s,Integer.MAX_VALUE);
        }
        distance.put("A",0);

        PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>();
        pq.add(new Vertex("A",0));

        //다익스트라 구현
        while(pq.size()>0){
            //현재 노드 정보
            Vertex v = pq.poll();
            String currVertex = v.vertex;
            int currDistance = v.distance;
                //이미 확인한 거리보다 크면 생략
                if(distance.get(currVertex)<currDistance){
                    continue;
                }


            ArrayList<Vertex> vertexList = graph.get(currVertex);

            //이동할 노드의 정보
            for(int i=0;i<vertexList.size();i++){
                Vertex adv = vertexList.get(i);
                String adVertex = adv.vertex;
                int adDistance = adv.distance;
                if(currDistance+adDistance<distance.get(adVertex)){
                    distance.put(adVertex,currDistance+adDistance);
                    pq.add(new Vertex(adVertex,currDistance+adDistance));
                }
            }

        }
        System.out.println(distance);
    }
}
