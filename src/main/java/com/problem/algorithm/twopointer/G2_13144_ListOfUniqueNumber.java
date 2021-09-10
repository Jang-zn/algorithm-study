package com.problem.algorithm.twopointer;

import java.io.*;

public class G2_13144_ListOfUniqueNumber {
    static int N;
    static int[] seq;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        seq = new int[N];
        String[] num = br.readLine().split(" ");
        for(int i=0;i<N;i++){
            seq[i]=Integer.parseInt(num[i]);
        }
        System.out.println(tp());
    }
    static long tp(){
        long count=0;
        int R=-1;
        //이게 중요 -> 숫자가 들어갔는지 안들어갔는지 확인이 바로 가능해짐.
        int[] list = new int[100001];
        for(int L=0;L<N;L++) {
            //R이동하면서 체크
            while (R + 1 < N && list[seq[R + 1]] == 0) {
                R++;
                list[seq[R]]++;
            }
            //정답 갱신
            count += R - L + 1;
            //L 이동
            list[seq[L]]--;
        }
        return count;
    }
}