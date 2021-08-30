package com.problem.algorithm.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class P11047_동전0 {
    //문제
    //준규가 가지고 있는 동전은 총 N종류이고, 각각의 동전을 매우 많이 가지고 있다.
    //
    //동전을 적절히 사용해서 그 가치의 합을 K로 만들려고 한다. 이때 필요한 동전 개수의 최솟값을 구하는 프로그램을 작성하시오.
    //
    //입력
    //첫째 줄에 N과 K가 주어진다. (1 ≤ N ≤ 10, 1 ≤ K ≤ 100,000,000)
    //
    //둘째 줄부터 N개의 줄에 동전의 가치 Ai가 오름차순으로 주어진다. (1 ≤ Ai ≤ 1,000,000, A1 = 1, i ≥ 2인 경우에 Ai는 Ai-1의 배수)
    //
    //출력
    //첫째 줄에 K원을 만드는데 필요한 동전 개수의 최솟값을 출력한다.
    public static void main(String[] args) throws IOException {
        //세팅
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] problem = (br.readLine()).split(" ");
        int coinN = Integer.parseInt(problem[0]);
        int value = Integer.parseInt(problem[1]);

        //주어지는 동전 입력
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<coinN;i++){
            int coin = Integer.parseInt(br.readLine());
            list.add(coin);
        }
        //탐욕법 비교
        System.out.println(greedy(list, value));


    }

    //탐욕법 로직
    public static int greedy(ArrayList<Integer> list, int value){
        int answer=0;
        while(value>0) {
            int coin = list.remove(list.size() - 1);
            if (coin>value){
                continue;
            }else if(coin<=value){
                int n = value/coin;
                answer+=n;
                value-=n*coin;
            }
        }
        return answer;
    }

}
