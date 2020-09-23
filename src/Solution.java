// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

import java.util.Arrays;
import java.util.Collections;

class Solution {

    public int solution(int[] A) {
        // write your code in Java SE 8
        Arrays.sort(A);
        int min = 1000000;
        int flag = 1;
        for(int i = 0; i < A.length-1; i++)
        {
            if(A[i+1] - A[i] <= min)
            {
                min = A[i+1] - A[i];
                if(min == 1 && flag == 0)
                {
                    flag = 1;
                    return -2;
                }
                flag = 0;
            }
        }

        if(min > 100000000)
            return -1;
        else
            return min;
    }

}