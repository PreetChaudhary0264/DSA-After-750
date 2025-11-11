import java.util.*;

public class Leet833 {
    class Pair{
        int str;
        int idx;
        public Pair(int str,int idx){
            this.str = str;
            this.idx = idx;
        }
    }
    class Solution {
        public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
            List<Pair> list = new ArrayList<>();
            for(int i = 0; i < indices.length; i++){
                list.add(new Pair(indices[i],i));
            }
            Map<Integer,Boolean> mpp = new HashMap<>();
            Collections.sort(list,(a, b)-> Integer.compare(a.str,b.str));

            StringBuilder sb = new StringBuilder();
            int prev = 0;

            for(Pair p : list){
                int idx = p.str;
                int i = p.idx;
                if(mpp.containsKey(idx))continue;

                if(prev < idx)sb.append(s,prev,idx);

                String source = sources[i];
                if(idx + source.length() <= s.length() && s.substring(idx,idx + source.length()).equals(source)){
                    sb.append(targets[i]);
                    prev = idx + source.length();
                    mpp.put(idx,true);
                }else{
                    if(idx < prev)continue;
                    prev = idx;
                }
            }
            if(prev < s.length())sb.append(s.substring(prev));
            return sb.toString();
        }
    }
}
