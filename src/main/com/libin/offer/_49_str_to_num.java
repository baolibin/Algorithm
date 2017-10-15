package libin.offer;
/**
 * 面试题49：把字符串转换为整数
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0 
 */
public class _49_str_to_num {
	public static void main(String[] args) {
		Solution49 solution49 = new Solution49();
		System.out.println(solution49.StrToInt("+1234"));
	}
}
class Solution49 {
    public int StrToInt(String str) {
    	if(str==null){
    		return 0;
    	}
    	char operation='|';
    	char[] charArray = str.toCharArray();
    	int result=0;
    	for(int i=0;i<charArray.length;i++){
    		if(charArray[i]=='+'){
    			if(operation!='|'){
    				return 0;
    			}
    			operation='+';
    			continue;
    		}
    		if(charArray[i]=='-'){
    			if(operation!='|'){
    				return 0;
    			}
    			operation='-';
    			continue;
    		}
    		if(charArray[i]<'0'||charArray[i]>'9'){
    			return 0;
    		}
    		result=result*10+(charArray[i]-'0');
    	}
    	if(operation=='-'){
    		result=-result;
    	}
        return result;
    }
}
