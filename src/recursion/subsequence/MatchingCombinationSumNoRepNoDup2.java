//combination sum 2 - bad space -> hashset is also used, if return type is list -> extra space
package recursion.subsequence;

import java.util.*;

public class MatchingCombinationSumNoRepNoDup2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("provide input array");
        String[] inp = sc.nextLine().split(" ");
        System.out.println("provide sum needed");
        int sum = sc.nextInt();
        List<Integer> inpAr = new ArrayList<>();
        for(String s : inp){
            inpAr.add(Integer.parseInt(s));
        }
        Collections.sort(inpAr);
        List<List<Integer>> temp  = new ArrayList<>();
        List<Integer> b  = new ArrayList<>();
        MatchCombSum(inpAr, b, temp , 0, sum);
        System.out.println(temp);
    }

    private static void MatchCombSum(List<Integer> inpAr, List<Integer> add, List<List<Integer>> temp, int i, int target) {

    }
}