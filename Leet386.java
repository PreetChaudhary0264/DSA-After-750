import java.util.ArrayList;
import java.util.List;

public class Leet386 {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>();
        int count = 1;

        for(int i = 0; i < n; i++){
            ans.add(count);
            if(count * 10 <= n){
                count *= 10;
            }else{
                if(count >= n)count /= 10;
                count++;
                while(count % 10 == 0){
                    count /= 10;
                }
            }
        }
        //this comment is for testign after deployed RevAI ....
        return ans;
    }
}
