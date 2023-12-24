package medium.everyday1466;

import java.util.ArrayList;
import java.util.HashSet;

public class Solution {
    HashSet<Integer>hs = new HashSet<>();
    int ans = 0;
    public int minReorder(int n, int[][] connections) {


        ArrayList<ArrayList<Integer>> matrix_pos = new ArrayList<>(), matrix_neg = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            matrix_pos.add(new ArrayList<>());
            matrix_neg.add(new ArrayList<>());
        }
        for (int[] road : connections) {
            matrix_pos.get(road[0]).add(road[1]);
            matrix_neg.get(road[1]).add(road[0]);
        }
        hs.add(0);
        dfs(0, matrix_pos, matrix_neg);
        return ans;
    }
    public void dfs(int now, ArrayList<ArrayList<Integer>>matrix_pos, ArrayList<ArrayList<Integer>>matrix_neg){
        for (int i = 0; i < matrix_pos.get(now).size(); i++) {
            if(!hs.contains(matrix_pos.get(now).get(i))){
                hs.add(matrix_pos.get(now).get(i));
                ans += 1;
                dfs(matrix_pos.get(now).get(i), matrix_pos, matrix_neg);
            }

        }
        for (int i = 0; i < matrix_neg.get(now).size(); i++) {
            if(!hs.contains(matrix_neg.get(now).get(i))){
                hs.add(matrix_neg.get(now).get(i));
                dfs(matrix_neg.get(now).get(i), matrix_pos, matrix_neg);
            }
        }
    }
}
