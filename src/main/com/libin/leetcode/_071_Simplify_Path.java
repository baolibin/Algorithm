package libin.leetcode;

import java.util.Stack;

public class _71_Simplify_Path {

    public static void main(String[] args) {
        Solution71 solution71 = new Solution71();
        System.out.println(solution71.simplifyPath("/home/"));
        System.out.println(solution71.simplifyPath("/a/./b/../../c/"));
        System.out.println(solution71.simplifyPath("/../"));
        System.out.println(solution71.simplifyPath("/home//foo/"));
    }

}
class Solution71 {
    public String simplifyPath(String path) {
        String[] spl=path.split("/");
        StringBuilder sb=new StringBuilder();
        Stack<String> stack = new Stack<String>();
        for(int i=0;i<spl.length;i++){
            if(spl[i].equals(".")||spl[i].equals("")){
                continue;
            }else if(spl[i].equals("..")){
                if(stack.size()>0){
                    stack.pop();
                }
            }else{
                if(!spl[i].isEmpty()){
                    stack.push(spl[i]);
                }
            }
        }
        if(stack.size()==0){
            return "/";
        }
        for (String str : stack) {
            sb.append("/");
            sb.append(str);
        }
        return sb.toString();
    }
}
