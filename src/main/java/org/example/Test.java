package org.example;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        int[] nums = {3,3,3,2,2,2};
        int count = nums.length;
        //6
        int maxCount = count / 2;
        //3 본인포함 세계

        int check[] = new int[count]; //선택했는지 찾기
        int output[] = new int[20001];


        dfs(nums, 0, 0, check, maxCount, output);
        System.out.println("result = " + result);


    }
    public static int result = 0;
    private static void dfs(int[] num, int sum, int sCount, int[] check, int maxCount, int[] output) {

        
        if(sCount > maxCount){ //넘어가면 멈춘다.
            return;
        }

        if(sCount == maxCount){ //모두 선택했고
            result = Math.max(result,sum); //선택된 값을 갱신함
        }

        for(int i = 0; i < num.length; i++){

            //	[3, 3, 3, 2, 2, 2]
            if(check[i] == 0){
                check[i] = 1;
                //3번부터 체크한다.

                int sumTotal = sum;

                if(output[num[i]] == 0){ //아예 처음인것을 찾는다.
                    sumTotal += 1;
                    output[num[i]]++;
                } else {
                    output[num[i]]++;
                }
                //처음이 아니면 더하지 않는다.

                dfs(num, sumTotal, sCount+1, check, maxCount, output);

                //다시 빼주는것을 해줘야한다.
                if(output[num[i]] == 1){ //아예 처음인것을 찾는다.
                    sumTotal -= 1;
                    output[num[i]]--;
                } else {
                    output[num[i]]--;
                }

                check[i] = 0;
            }
        }
    }
}
