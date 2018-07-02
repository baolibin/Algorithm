package libin.base._04_basic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期格式化
 * @author baolibin
 */
public class _03_SimpleDateFormat {
	public static void main(String[] args) throws ParseException {
		/*String strDate="2016-10-04 15:33:21.233"; //定义日期格式字符串
		String part1="yyyy-MM-DD HH:mm:ss.SSS"; //准备模板
		String part2="yyyy年MM月dd日HH时mm分ss秒SSS毫秒"; //准备模板
		SimpleDateFormat df1 = new SimpleDateFormat(part1); //实例化模板对象
		SimpleDateFormat df2 = new SimpleDateFormat(part2); //实例化模板对象
		Date parse = df1.parse(strDate);
		System.out.println(df2.format(parse));*/
		
		/**
		 * 按照指定的格式进行格式化
		 */
		String part1="yyyy-MM-DD HH:mm:ss.SSS"; //准备模板
		SimpleDateFormat df1 = new SimpleDateFormat(part1); //实例化模板对象
		String fm = df1.format(new Date());
		System.out.println(fm);
		
	}
}
