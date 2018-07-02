package libin.general.other.basic;

/**
 * 最长公共子串
 * @author baolibin
 */
public class _10_LCSubstring {
    public static void main(String[] args){
        String str1="qweasdfyy";
        String str2="ytrasdfjy";
        LCStr lcStr = new LCStr(str1,str2);
        lcStr.getLcstr();
    }
}
class LCStr{
    private String str1;
    private String str2;
    int[][] choose;
    public LCStr(String str1,String str2){
        this.str1=str1;
        this.str2=str2;
        choose=new int[str1.length()+1][str2.length()+1];
    }
    public void getLcstr(){
        int max=Integer.MIN_VALUE,x=-1,y=-1;
        char[] str1_1=str1.toCharArray();
        char[] str2_2=str2.toCharArray();
        int len1=str1_1.length;
        int len2=str2_2.length;
        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                if(str1_1[i-1]==str2_2[j-1]){
                    choose[i][j]=choose[i-1][j-1]+1;
                }else{
                    choose[i][j]=0;
                }
                if(choose[i][j]>max){
                    max=choose[i][j];
                    x=i;
                    y=j;
                }
            }
        }
        StringBuilder sb=new StringBuilder();
        while (x>=1&&y>=1){
            if(str1_1[--x]==str2_2[--y]){
                sb.append(str1_1[x]);
            }else{
                break;
            }
        }
        System.out.println("最长公共子串为："+sb.reverse().toString());
    }
}