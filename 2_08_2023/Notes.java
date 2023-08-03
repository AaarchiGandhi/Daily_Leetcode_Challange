// 46. Permutations

// Question : Given an array nums of distinct integers, return all the possible permutations. 
//             You can return the answer in any order.

// Example 1:

// Input: nums = [1,2,3]
// Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

// Solution:

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public static void findAns(int index , int[] arr ,List<List<Integer>> ans){
        if(index == arr.length){
            List<Integer> l1 = new LinkedList<Integer>();

            for(int data : arr){
                l1.add(data);
            }

            ans.add(new LinkedList<Integer>(l1));
        }

        for(int i = index ; i < arr.length ;i++){
            swap(i,index,arr);
            findAns(index+1,arr,ans);
            swap(i,index,arr);
        }

        
    }
    public static void swap(int i , int j , int[] arr){
            int x = arr[i];
            arr[i] = arr[j];
            arr[j] = x;
        }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        findAns(0,nums,ans);
        return ans;
    }
}