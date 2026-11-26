package recursion.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.lang.Math.abs;
import static java.lang.Math.min;

public class FrogJump {
    public static void main(String[] a){
        System.out.println("Input the energies at each level");
        Scanner sc = new Scanner(System.in);
        String[] inp = sc.nextLine().split(",");
        List<Integer> eng = new ArrayList<>();
        for(String i : inp)
            eng.add(Integer.parseInt(i));
        int n = eng.size();
//        int leastEng = Jump(eng, n-1);
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        int leastEng1 = JumpBetter(eng, n-1, dp);
        System.out.println(leastEng1);
    }

    // just recursion
    private static Integer Jump(List<Integer> engs, int indx){
        if(indx == 0) return 0;
        int l = Jump(engs, indx -1) + abs(engs.get(indx) - engs.get(indx -1));
        int r = 1000; // MAX_INT -> used when index is 1 - min(l,r) to give l value by default
        if(indx>1)
            r = Jump(engs, indx -2) + abs(engs.get(indx) - engs.get(indx -2));
        return min(l,r);
    }

    // memoization (using dp array)
    private static Integer JumpBetter(List<Integer> engs, int indx, int[] dp){
        if(indx == 0) return 0;
        if(dp[indx] != -1) return dp[indx];
        int l = JumpBetter(engs, indx -1, dp) + abs(engs.get(indx) - engs.get(indx -1));
        int r = 1000; // MAX_INT -> used when index is 1 - min(l,r) to give l value by default
        if(indx>1)
            r = JumpBetter(engs, indx -2, dp) + abs(engs.get(indx) - engs.get(indx -2));
        return dp [indx] = min(l,r);
    }
}
