//combination sum
package recursion.subsequence;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MatchingCombinationSum {
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
        List<List<Integer>> temp  = new ArrayList<>();
        List<Integer> b  = new ArrayList<>();
        MatchCombSum(inpAr, b, temp , 0, sum);
        System.out.println(temp);
    }

    private static void MatchCombSum(List<Integer> inpAr, List<Integer> add, List<List<Integer>> temp, int i, int target) {
        if(i>=inpAr.size()){
            if(target == 0){
                temp.add(new ArrayList<>(add)); // list is mutable, so if we change add, the data will be changed in temp as well(both point to same)
            }
            return;
        }
        if(inpAr.get(i)<=target){
            add.add(inpAr.get(i));
            MatchCombSum(inpAr, add, temp, i, target-inpAr.get(i)); //not i+1, as same number can be repeated.
            add.removeLast();
        }
        MatchCombSum(inpAr, add, temp, i+1, target); // no-take, so next index = i+1.
    }
}
