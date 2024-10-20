package problem;
import java.util.*;
public class GroupAnagram {

    public static void main(String[] args) {

        String input = "cat dog tac sat tas god dog";
        GroupAnagram sol = new GroupAnagram();
        sol.setOfAnagrams(input);

    }
    private void setOfAnagrams(String input) {
        String[] words = input.split(" ");
        Map<String,String> map  = new HashMap<>();
        for(int i=0;i < words.length; i++){
            String word = words[i];
            char[] chars=word.toCharArray();
            Arrays.sort(chars);
            String newWord = new String(chars);
            if(map.containsKey(newWord)){
                String val = map.get(newWord);
                List<String> list= Arrays.asList(val.split(" "));
                if(!list.contains(word)){
                    map.put(newWord,val+" "+word);
                }
            }else{
                map.put(newWord,word);
            }
        }
        map.values().stream().forEach(e->System.out.print(e+" "));
    }
}
