package recursion.subsequence;

import java.util.*;

//pick, no-pick.
public class MatchingSubSeqSum {
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
        List<Integer> temp  = new ArrayList<>();
        MatchSum(inpAr, temp, inpAr.size(), 0,  sum, 0);
    }

    private static void MatchSum(List<Integer> ar, List<Integer> temp, int n, int i, int s, int sum) {
        if(i>=n){
            if(s == sum){
                System.out.println(temp);
            }
            return;
        }

        temp.add(ar.get(i));
        sum += ar.get(i);
        MatchSum(ar, temp, n, i+1, s,sum); // pick
        temp.removeLast();
        sum -= ar.get(i);
        MatchSum(ar, temp, n, i+1, s, sum); // back track/ no pick
    }
}
