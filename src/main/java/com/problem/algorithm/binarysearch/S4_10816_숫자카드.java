package com.problem.algorithm.binarysearch;

    import java.io.*;
    import java.util.Arrays;

    public class S4_10816_숫자카드 {

        static int N;
        static int[] problem;
        static int M;
        static int[] value;
        static int[] ans;

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            N = Integer.parseInt(br.readLine());
            String[] temp = br.readLine().split(" ");
            problem = new int[N];
            for (int i = 0; i < N; i++) {
                problem[i] = Integer.parseInt(temp[i]);
            }
            M = Integer.parseInt(br.readLine());
            temp = br.readLine().split(" ");
            value = new int[M];
            ans = new int[M];
            for (int i = 0; i < M; i++) {
                value[i] = Integer.parseInt(temp[i]);
            }
            Arrays.sort(problem);
            solve();
        }

        public static void solve() throws IOException{
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            for (int i = 0; i < M; i++) {
                int a = Arrays.binarySearch(problem,value[i]);
                if(a<0){
                    bw.write(ans[i]+" ");
                    continue;
                }else {
                    int lower = lower(value[i]);
                    int upper = upper(value[i]);
                    System.out.println(lower+" "+upper);
                    ans[i] = upper-lower+1;
                    bw.write(ans[i]+" ");
                }
            }
            bw.flush();
        }

        public static int lower(int val){
            int first = 0;
            int last = N-1;
            while(first<=last){
                int mid = (first+last)/2;
                if(problem[first]==val){
                    return first;
                }else{
                    if(problem[mid]>=val){
                        last=mid-1;
                    }else{
                        first=mid+1;
                    }
                }
            }
            return first;
        }

        public static int upper(int val){
            int first = 0;
            int last = N-1;
            while(first<=last){
                int mid = (first+last)/2;
                if(problem[last]==val){
                    return last;
                }else{
                    if(problem[mid]<=val){
                        first=mid+1;
                    }else{
                        last=mid-1;
                    }
                }
            }
            return last;
        }
    }