package libin.general.other.basic;
/**
 * 最长公共子序列
 * @author baolibin
 *
  用动态规划解决LCS
 */
public class _03_LCS {
	public static void main(String[] args) {
		String str1="sdebyjkdslsdgrteyb";  //测试一
		String str2="bqwelsadfjjb";
		LCSCommon lcsCommon = new LCSCommon(str1,str2);
		lcsCommon.getCommonStr();
		lcsCommon.strPrint();
		
		String str3="qewrtuyi";  //测试2
		String str4="asdfghjk";
		LCSCommon lcsCommon2 = new LCSCommon(str3,str4);
		lcsCommon2.getCommonStr();
		lcsCommon2.strPrint();
		
		String str5="abgh";  //测试3
		String str6="agbh";
		LCSCommon lcsCommon3 = new LCSCommon(str5,str6);
		lcsCommon3.getCommonStr();
		lcsCommon3.strPrint();
	}
}

class LCSCommon{
	private String str1;
	private String str2;
	private String strCom;
	int[][] chose;
	public LCSCommon(String str1,String str2){
		this.str1=str1;
		this.str2=str2;
		strCom=new String();
		chose=new int[str1.length()+1][str2.length()+1];
	}
	/**
	 * 求最长公共子序列
	 */
	public void getCommonStr(){
		char[] str_1=str1.toCharArray();
		char[] str_2=str2.toCharArray();
		int len1=str1.length();
		int len2=str2.length();
		for (int i = 0; i <=len1; i++) { //第一列全部赋值为0 , len1+1行
			chose[i][0]=0;
		}
		for (int j = 0; j <=len2; j++) { //第一行全部赋值为0 , len2+1列
			chose[0][j]=0;
		}
		for (int i = 1; i <=len1; i++) {//生成数组chose，数组chose记录序列Xi和Yi的最长公共子序列的长度
			for(int j=1;j<=len2;j++){
				if(str_1[i-1]==str_2[j-1]){
					chose[i][j]=chose[i-1][j-1]+1;
				}else {
					if(chose[i][j-1]<chose[i-1][j]){
						chose[i][j]=chose[i-1][j];
					}else{
						chose[i][j]=chose[i][j-1];
					}
				}
			}
		}
		int i=len1;
		int j=len2;
		while (i!=0&&j!=0) {  //根据生成的数组求最长公共子串
			if (str_1[i-1]==str_2[j-1]) {
				strCom+=String.valueOf(str_1[i-1]).trim();
				i--;
				j--;
			}else{
				if(chose[i][j-1]>=chose[i-1][j]){
					j--;
				}else {
					i--;
				}
			}
		}
	}
	public void strPrint(){
		char[] char_reverse=strCom.trim().toCharArray();
		if(char_reverse.length==0){
			System.out.println("最长公共子序列为空");
			return;
		}
		int len=strCom.length()-1;
		int low=0;
		char tmp;
		while (low!=len&&(low+1)!=len) {  //反转数组
			tmp=char_reverse[low];
			char_reverse[low]=char_reverse[len];
			char_reverse[len]=tmp;
			low++;
			len--;
		}
		String sb=new String();
		for (int i = 0; i < char_reverse.length; i++) {
			sb+=char_reverse[i];
		}
		strCom=sb;
		System.out.println("最长公共子序列为："+strCom);
	}
}