package medium.everyday1094;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
    }
    public boolean carPooling(int[][] trips, int capacity) {
        int n = trips.length;
        int[][] from = new int[n][2], to = new int[n][2];
        for (int i = 0; i < trips.length; i++) {
            int f = trips[i][1], t = trips[i][2];
            from[i][0] = f;
            from[i][1] = i;
            to[i][0] = t;
            to[i][1] = i;
        }
        Arrays.sort(from, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        Arrays.sort(to, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int nowf = 0, nowt = 0;
        int people = 0;
        while(nowf < n){
            while(to[nowt][0] <= from[nowf][0]){
                people -= trips[to[nowt][1]][0];
                nowt += 1;
            }
            people += trips[from[nowf][1]][0];
            if(people > capacity){
                return false;
            }
            nowf += 1;
        }
        return true;
    }
}
