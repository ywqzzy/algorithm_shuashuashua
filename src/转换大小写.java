

import java.util.ArrayList;
import java.util.List;
class 转换大小写 {
        List<String> res = new ArrayList();
        int dis = 'A'-'a';
        public List<String> letterCasePermutation(String S) {
            if(S.length()==0){return res;}
            char[] cs = S.toCharArray();
            helper(cs,0);
            return res;
        }

        public void helper(char[] cs,int idx){
            res.add(String.valueOf(cs));
            for(int i=idx;i<cs.length;i++){
                if(cs[i]>='0'&&cs[i]<='9'){
                    continue;
                }else if(cs[i]>='a'&&cs[i]<='z'){
                    cs[i] = (char)(cs[i] + dis);
                    helper(cs,i+1);
                    cs[i] = (char)(cs[i] - dis);
                }else if (cs[i] <='Z' && cs[i] >='A'){
                    cs[i] = (char)(cs[i] - dis);
                    helper(cs,i+1);
                    cs[i] = (char)(cs[i] + dis);
                }
            }
        }

    public static void main(String[] args) {
        转换大小写 o = new 转换大小写();
        o.letterCasePermutation("a1b2");
    }
}
