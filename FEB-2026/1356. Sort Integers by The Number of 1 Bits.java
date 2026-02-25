import java.util.*;

class Solution {
    public int[] sortByBits(int[] arr) {
       Integer[] boxedArr = new Integer[arr.length];//we using class because hame Integer class ke inbuild function use karne hai hai jo ko normal primitive datatype pe nhi lagta i tryed by direct nhi ho raha (arr sort)..
       //so i take new Integer type arr and then i sort that :)
        for (int i = 0; i < arr.length; i++) {
            boxedArr[i] = arr[i];
        }

        Arrays.sort(boxedArr, (a, b) -> {
            int countA = Integer.bitCount(a);
            int countB = Integer.bitCount(b);

            if (countA == countB) {
                return a.compareTo(b);
            }

            return Integer.compare(countA, countB);
        });

        for (int i = 0; i < arr.length; i++) {
            arr[i] = boxedArr[i];
        }

        return arr;
    }
}


//T.C -> O(n log n) for sorting
//S.C -> O(n) for the boxed array