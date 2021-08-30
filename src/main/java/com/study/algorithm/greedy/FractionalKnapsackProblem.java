package com.study.algorithm.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsackProblem {
    int[][] products= {{10,10},{15,12},{20,10},{25,8},{30,5}};

    public void FKP(int[][] products, double capacity){
        double totalValue=0.0;
        double fraction = 0.0;
        Arrays.sort(products, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1]/o2[0]-o1[1]/o1[0];
            }
        });
        for(int i = 0; i<products.length;i++){
            if(capacity-products[i][0]>=0){
                capacity-=products[i][0];
                totalValue+=products[i][1];
            }else{
                fraction = capacity/products[i][0];
                totalValue+=products[i][1]*fraction;
                capacity=0;
                break;
            }
        }
        System.out.println("value : "+totalValue);
    }


    public static void main(String[] args) {
        FractionalKnapsackProblem f = new FractionalKnapsackProblem();
        f.FKP(f.products,30.0);
    }
}
