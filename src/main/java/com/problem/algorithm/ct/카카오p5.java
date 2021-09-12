package com.problem.algorithm.ct;


import java.util.*;

public class 카카오p5 {
    public static void main(String[] args) {
        int[] info = new int[]{0,0,1,1,1,0,1,0,1,0,1,1};
        int[][] edge = new int[][]{{0,1},{1,2},{1,4},{0,8},{8,7},{9,10},{9,11},{4,3},{6,5},{4,6},{8,9}};
        System.out.println(new 카카오p5().solution(info, edge));
    }

    static boolean[] visit;
    static int maxSheep=0;
    static Map<Integer,ArrayList<Integer>> tree = new HashMap<Integer,ArrayList<Integer>>();
    static Map<Integer,Integer> parent = new HashMap<Integer,Integer>();

    public int solution(int[] info, int[][] edges) {
        visit=new boolean[info.length];
        for(int i=0;i<edges.length;i++){
            if(tree.get(edges[i][0])==null){
                tree.put(edges[i][0],new ArrayList<Integer>());
            }
            tree.get(edges[i][0]).add(edges[i][1]);
            parent.put(edges[i][1],edges[i][0]);
        }

        solve(0, 1 ,0, info);
        return maxSheep;
    }

    static void solve(int x, int currSheep, int currWolf, int[] info) {

    }
}

