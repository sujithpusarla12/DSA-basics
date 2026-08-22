package sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MergeSort {
    public static void main(String[] args){
        System.out.println("give array input");
        Scanner sc = new Scanner(System.in);
        String[] inp = sc.nextLine().split(" ");
        List<Integer> inpAr = new ArrayList<>();
        for(String s : inp){
            inpAr.add(Integer.parseInt(s));
        }
        MSort(inpAr, 0, inpAr.size()-1);
        System.out.println(inpAr);
    }

    private static void MSort(List<Integer> a, int l, int h){
        if(l>=h){
            //traversal done
            return;
        }
        int mid = (l+h)/2;
        MSort(a, l, mid);
        MSort(a, mid+1, h);
        SortNMerge(a, l, mid, h); // merge using the sorted indices
    }

    private static void SortNMerge(List<Integer> a, int l, int m, int h){
        List<Integer> temp = new ArrayList<>();
        int i=l, j=m+1;
        while(i<=m && j<=h){
            if(a.get(i)<=a.get(j)){
                temp.add(a.get(i));
                i++;
            }
            else{
                temp.add(a.get(j));
                j++;
            }
        }

        while(i<=m){
            temp.add(a.get(i));
            i++;
        }
        while(j<=h){
            temp.add(a.get(j));
            j++;
        }

        for(int p=l; p<=h; p++){
            a.set(p, temp.get(p-l)); // a index start from low, temp starts with 0
        }
    }
}
