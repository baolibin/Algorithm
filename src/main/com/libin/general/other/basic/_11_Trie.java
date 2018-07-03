package libin.general.other.basic;

import java.util.HashMap;
import java.util.Map;
/**
 * 字典树的java实现
 * 每个节点类型为：TrieNode
 * 每个节点孩子节点存储在：hashMap中
 */
public class _11_Trie {
    private TrieNode root; //根节点
    public _11_Trie() {        //构造函数
        root = new TrieNode();
        root.wordEnd = false;
    }
    /**
     * 插入一个字符串
     */
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            if (!node.childdren.containsKey(c)) {
                node.childdren.put(c, new TrieNode());
            }
            node = node.childdren.get(c);
        }
        node.count++;
        node.wordEnd = true;
    }
    /**
     * 查找一个字符串
     */
    public boolean search(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            if (!node.childdren.containsKey(c)) {
                return false;
            }
            node = node.childdren.get(c);
        }
        System.out.println("单词"+word+"的个数为:"+node.count);
        return node.wordEnd;
    }
    /**
     * 查找前缀
     */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            Character c = prefix.charAt(i);
            if (!node.childdren.containsKey(c)) {
                return false;
            }
            node = node.childdren.get(c);
        }
        return true;
    }
    /**
     * 主方法
     */
    public static void main(String[] args) {
		_11_Trie trie = new _11_Trie();
		trie.insert("asd");
		trie.insert("dfg");
		trie.insert("asd");
		trie.insert("areyt");
		trie.insert("arekjh");
		trie.insert("arekjh");
		trie.insert("arekjh");
		String str1="asd";
		String str2="aaa";
		String str3="arekjh";
		if(trie.search(str1)){
			System.out.println("存在字符串:"+str1+"\n");
		}
		if(trie.search(str2)) System.out.println("存在字符串:"+str2+"\n");
		else System.out.println("不存在字符串:"+str2+"\n");
		
		if(trie.search(str3)) System.out.println("存在字符串:"+str3+"\n");
		else System.out.println("不存在字符串:"+str3+"\n");
	}
}
/**
 * 节点类型
 */
class TrieNode {
    Map<Character, TrieNode> childdren;  //存当前节点的所有孩子节点
    boolean wordEnd;   //是否为字符串结尾字符节点
    int count; 		//单词出现的次数

    public TrieNode() {
        childdren = new HashMap<Character, TrieNode>();
        wordEnd = false;
        count=0;
    }
}
