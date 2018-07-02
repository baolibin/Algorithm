package libin.general.other.basic;
/**
 * 字符串全排列
 * 1、递归，不重复
 * 2、递归、空间换时间
 * 3、非递归
 */
public class _05_str_permutations {
    public static void main(String[] args){
        //String str="abcde";
        String str1="ada";
        permutation permutation = new permutation(str1);
        permutation.countPermumation(permutation.str,permutation.str.length,0);
        permutation.allLen(); //打印全排列个数

        String str2="232";
        permutation permutation2 = new permutation(str2);
        permutation2.countPermumation_2(permutation2.str,permutation2.str.length,0);
        permutation2.allLen(); //打印全排列个数

        /**
         * 起点：字符串最小的序列，如12345
         * 终点：字符串最大的序列，如54321
         * 过程：从当前排列生成字典序刚好比它大的下一个序列
         * 如：21543下一个序列是23154
         */
        String str3="12";
        permutation permutation3 = new permutation(str3);
        permutation3.print(permutation3.str);
        while (permutation3.permutation_3(permutation3.str,permutation3.str.length)){
            permutation3.print(permutation3.str);
        }
    }
}
class permutation{
    char[] str;
    int count;
    public permutation(String str){
        this.str=str.toCharArray();
        count=0;
    }
    /**
     * 求全排列函数
     * 字符串全排序
     * 递归求解
     */
    public void countPermumation(char[] str,int length,int currentIndex){
        if(currentIndex==length-1){
            count++;
            print(str);
            return;
        }
        for (int i = currentIndex; i < length; i++) { //currentIndex左侧以及排列过
            if(repetition(str, currentIndex, i)){
                char tmp=str[currentIndex];//第currentIndex个元素与右侧任一元素交换
                str[currentIndex]=str[i];
                str[i]=tmp;
                countPermumation(str,length,currentIndex+1);//第currentIndex个元素不断与currentIndex的右侧元素交换
                str[i]=str[currentIndex];//第currentIndex个元素与右侧任一元素再换回来
                str[currentIndex]=tmp;
            }
        }
    }
    /**
     * 去掉重复元素交换
     * @param str 字符数组
     * @param currentIndex 当前元素下标
     * @param slip 右侧待交换的元素下标
     */
    public boolean repetition(char[] str,int currentIndex,int slip){
        while (currentIndex<slip) {  //扫描当前点与待交换点之间，待交换的是否有重复元素
            if(str[currentIndex]==str[slip]){
                return false;
            }
            currentIndex++;
        }
        return true;
    }
    /**
     * 打印所有的结果
     */
    public void print(char[] str){
        for (int i = 0; i < str.length; i++) {
            System.out.print(str[i]);
        }
        System.out.println("");
    }
    /**
     * 打印全排列个数
     */
    public void allLen(){
        System.out.println("全排列个数为："+count);
    }
    /**
     * 空间换时间
     * 字符串全排序
     * 递归求解
     */
    public void countPermumation_2(char[] str,int length,int currentIndex){
        if(currentIndex==length-1){
            count++;
            print(str);
            return;
        }
        int[] flag=new int[256];  //ASCLL编码
        for (int i = 0; i < flag.length; i++) {
            flag[i]=0;
        }
        for (int i = currentIndex; i < length; i++) { //currentIndex左侧以及排列过
            if(flag[str[i]]!=1){
                flag[str[i]]=1;
                char tmp=str[currentIndex];//第currentIndex个元素与右侧任一元素交换
                str[currentIndex]=str[i];
                str[i]=tmp;
                countPermumation(str,length,currentIndex+1);//第currentIndex个元素不断与currentIndex的右侧元素交换
                str[i]=str[currentIndex];//第currentIndex个元素与右侧任一元素再换回来
                str[currentIndex]=tmp;
            }
        }
    }
    /**
     * 字符串全排序
     * 非递归
     */
    public boolean permutation_3(char[] str,int length){
        int i=length-2;
        //字符串中最后一个升序的i
        while((i>=0)&&(str[i]>=str[i+1])){
            i--;
        }
        if(i<0){
            return false;
        }
        //str[i+1,length-1]中比str[i]大的最小的元素
        int j=length-1;
        while (str[j]<=str[i]){
            j--;
        }
        //交换
        char tmp=str[i];
        str[i]=str[j];
        str[j]=tmp;
        //翻转str[i+1,lenght-1]
        int from=i+1;
        int end=length-1;
        while (from<end){
            tmp=str[from];
            str[from]=str[end];
            str[end]=tmp;
            from++;
            end--;
        }
        return true;
    }
}