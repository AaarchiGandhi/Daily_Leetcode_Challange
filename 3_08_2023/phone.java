// https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/

// 17 medium
// Given a string containing digits from 2-9 inclusive, return all possible letter combinations 
// that the number could represent. Return the answer in any order.

// A mapping of digits to letters (just like on the telephone buttons) is given below. 
// Note that 1 does not map to any letters.

import java.util.LinkedList;
import java.util.List;

public class phone {
    String[] words = {"" , "" , "abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
         List<String> ans = new LinkedList<>();

         if(digits.length() == 0 || digits == null){
             return ans;
         }

         fun(ans,0,words,new StringBuilder(),digits);
         return ans;
    }

    private static void fun(List<String> ans ,int index , String[] words , StringBuilder sb,String digits){
        if(index == digits.length()){
            ans.add(sb.toString());
            return;
        }

        String val = words[digits.charAt(index) - '0'];
        for(char ch : val.toCharArray()){
            sb.append(ch);
            fun(ans,index+1,words,sb,digits);
            sb.setLength(sb.length() - 1);
        }
    }
}
