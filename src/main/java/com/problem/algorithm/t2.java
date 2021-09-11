package com.problem.algorithm;

import java.util.ArrayList;

public class t2 {


    public static void main(String[] args) {
        System.out.println(solution(113, 10));
    }

    static String result = "";

    public static int solution(int n, int k) {
        int answer = -1;
        change(n,k);
        reverse();
        answer = find();
        return answer;
    }

    //진수변환
    static void change(int n, int k){
        if(n==0){
            return;
        }else{
            result+=n%k;
            change(n/k,k);
        }
    }
    //변환된거 뒤집어서 진수로 만들어줌
    static void reverse(){
        String temp="";
        for(int i=result.length()-1;i>=0;i--){
            temp+=result.charAt(i);
        }
        result = temp;
    }

    //변환된거에서 숫자 선택 / 소수 확인하고 count++해서 리턴
    static int find(){
        int count=0;
        String s = "";
        String e = "";
        ArrayList<Integer> check= new ArrayList<Integer>();
        for(int start = 0;start<result.length()-1;start++){
            if(result.length()==1){
                int num = Integer.parseInt(result);
                if(isPrime(num)){
                    count++;
                }
            }
            if(result.indexOf("0")<0&&isPrime(Integer.parseInt(result))){
                count++;
                break;
            }
            s=String.valueOf(result.charAt(start));
            if(s.equals("0")){
                continue;
            }
            for(int end=start;end<result.length();end++){
                e=String.valueOf(result.charAt(end));
                if(e.equals("0")||end==result.length()-1){
                    int num=0;
                    if(end!=result.length()-1) {
                        num = Integer.parseInt(result.substring(start, end));
                        start=end;
                    }else{
                        num = Integer.parseInt(result.substring(start, end+1));
                    }
                    if(isPrime(num)){
                        check.add(num);
                        count++;
                    }
                    break;
                }
            }
        }
        System.out.println(check);
        return count;
    }

    //소수인지 확인
    public static boolean isPrime(int num){
        if(num==1){
            return false;
        }
        for(int i=2; i*i<=num; i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }

}
