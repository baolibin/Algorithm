package libin.general.other.basic;

/**
Java实现位图操作
 * 
在海量数据中查找出重复出现的元素或者去除重复出现的元素是面试中常考的文图。针对此类问题，可以使用位图法来解决。
例如：已知某个文件内包含若干个电话号码，要求统计不同的号码的个数，甚至在O（n）时间复杂度内对这些号码进行排序。

位图法需要的空间很少（依赖于数据分布，但是我们也可以通过对数据进行处理，使得数据变得密集），在数据比较密集的时候效率非常高。
例如：8位整数可以表示的最大十进制数值为99999999，如果每个数组对应于一个bit位，那么把所有的八进制整数存储起来只需要：99Mbit = 12.375MB.

实际上，Java jdk1.0已经提供了bitmap的实现BitSet类，不过其中的某些方法是jdk1.4之后才有的。
 */
import java.util.Arrays;
import java.util.BitSet;
import java.util.Random;
/**
 * 去除重复并排序
 */
public class _07_BitMap {
	int ARRNUM = 8; //数组长度
	int LEN_INT = 32; //int基本数据类型  占  32-bit,4字节Byte
	int mmax = 9999;  //数组最大值
	int mmin = 1000;  //数组最小值
	int N = mmax - mmin + 1;  //数组最多元素个数

	public static void main(String args[]) {
		_07_BitMap bitMap1 = new _07_BitMap();
		bitMap1.findDuplicate();
		_07_BitMap bitMap2 = new _07_BitMap();
		bitMap2.findDup_jdk();
	}
	/**
	 * 调用JDK库实现位图
	 * 一位代表1bit,1010有4bit
	 */
	public void findDup_jdk() {
		System.out.println("\n*******调用JDK中的库方法--开始********");
		BitSet bitArray = new BitSet(N); //创建长度为N的bit数组
		int[] array = getArray(ARRNUM);  //待存数组的长度
		for (int i = 0; i < ARRNUM; i++) {
			bitArray.set(array[i] - mmin);
		}
		int count = 0;
		for (int j = 0; j < bitArray.length(); j++) {
			if (bitArray.get(j)) {
				System.out.print(j + mmin + " ");
				count++;
			}
		}
		System.out.println("\n排序后的数组大小为：" + count);
		System.out.println("*******调用JDK中的库方法--结束********");
	}
	/**
	 * 自己实现bitmap
	 * 一个int类型32个bit位,即一个int存32个数
	 */
	public void findDuplicate() {
		int[] array = getArray(ARRNUM);
		int[] bitArray = setBit(array);
		printBitArray(bitArray);
	}
	/**
	 * 去重然后排序打印
	 * 最多N个数
	 * bit数组长度：N/32+1
	 */
	public void printBitArray(int[] bitArray) {
		int count = 0;
		for (int i = 0; i < N; i++) {
			if (getBit(bitArray, i) != 0) {
				count++;
				System.out.print(i + mmin + "、");
			}
		}
		System.out.println();
		System.out.println("去重排序后的数组大小为：" + count);
	}
	/**
	 * 返回指定原数组下标的元素
	 */
	public int getBit(int[] bitArray, int k) {
		return bitArray[k / LEN_INT] & (1 << (k % LEN_INT)); // 1左移 k % 32位 与上 数组下标为 k/32 位置的值
	}
	/**
	 * 把整形数组的数存储到 位图中 ,一个int共32个bit 对应存32个原数组的值
	 * java中有三种移位运算符
	   << : 左移运算符，num << 1,相当于num乘以2
       >> : 右移运算符，num >> 1,相当于num除以2
       >>> : 无符号右移，忽略符号位，空位都以0补齐
	 */
	public int[] setBit(int[] array) {
		int m = array.length;
		//数组最大最小值之差 N 除以 int型占的32bit 再加上1
		int bit_arr_len = N / LEN_INT + 1;
		int[] bitArray = new int[bit_arr_len];  //实际bit位长度为  bit_arr_len * 32 
		for (int i = 0; i < m; i++) {
			int num = array[i] - mmin;
			//首先取得数组位置下标 i/32, 然后 或上 在该位置int类型数值的bit位：i % 32
			bitArray[num / LEN_INT] |= (1 << (num % LEN_INT)); //1左移(num % LEN_INT) 位
		}
		return bitArray;
	}
	/**
	 * 创建一个数组
	 * @param ARRNUM 数组长度
	 */
	public int[] getArray(int ARRNUM) {
		@SuppressWarnings("unused")
		int array1[] = { 1000, 1002, 1032, 1033, 6543, 9999, 1033, 1000 };
		int array[] = new int[ARRNUM];
		System.out.println("数组大小：" + ARRNUM);
		Random r = new Random();
		for (int i = 0; i < ARRNUM; i++) {
			//array[i] = r.nextInt(N) + mmin;
			array[i] = r.nextInt(5) + mmin;
		}
		System.out.println(Arrays.toString(array));
		return array;
	}
}
