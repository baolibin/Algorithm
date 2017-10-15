package libin.offer;

import java.util.HashMap;

/**
 * 面试题26：复杂链表的复制
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。（
 * 注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
public class _26_linked_copy {
    public static void main(String[] args){
        Solution26 solution26 = new Solution26();
        //{1,2,3,4,5,3,5,#,2,#}
        RandomListNode26 randomListNode1 = new RandomListNode26(1);
        RandomListNode26 randomListNode2 = new RandomListNode26(2);
        RandomListNode26 randomListNode3 = new RandomListNode26(3);
        RandomListNode26 randomListNode4 = new RandomListNode26(4);
        RandomListNode26 randomListNode5 = new RandomListNode26(5);
        randomListNode1.next=randomListNode2;
        randomListNode2.next=randomListNode3;
        randomListNode3.next=randomListNode4;
        randomListNode4.next=randomListNode5;
        randomListNode1.random=randomListNode3;
        randomListNode2.random=randomListNode4;
        randomListNode3.random=null;
        randomListNode4.random=randomListNode2;
        randomListNode5.random=null;

        RandomListNode26 pResult=solution26.Clone(randomListNode1);
        RandomListNode26 pResult2=pResult;
        while(pResult!=null){
            System.out.print(pResult.label+"、");
            pResult=pResult.next;
        }
        while(pResult2!=null){
            if(pResult2.random==null){
                System.out.print("#、");
            }else{
                System.out.print(pResult2.random.label+"、");
            }
            pResult2=pResult2.next;
        }
    }
}
class Solution26 {
    public RandomListNode26 Clone(RandomListNode26 pHead) {
        if(pHead==null){
            return null;
        }
        int count=0;
        RandomListNode26 pResult=new RandomListNode26(pHead.label);
        HashMap<Integer, RandomListNode26> hash = new HashMap<Integer, RandomListNode26>();
        hash.put(++count,pHead.random);
        RandomListNode26 pResultTmp=pResult;
        while(pHead.next!=null){
            RandomListNode26 pTmp=new RandomListNode26(pHead.next.label);
            pResultTmp.next=pTmp;
            hash.put(++count,pHead.next.random);
            pHead=pHead.next;
            pResultTmp=pResultTmp.next;
        }
        pResultTmp.next=null;
        RandomListNode26 tmp=pResult;
        count=1;
        while(tmp!=null){
            if(hash.get(count)!=null){
                tmp.random=hash.get(count++);
            }else{
                count++;
                tmp.random=null;
            }
            tmp=tmp.next;
        }
        return pResult;
    }
}
class RandomListNode26 {
    int label;
    RandomListNode26 next = null;
    RandomListNode26 random = null;
    RandomListNode26(int label) {
        this.label = label;
    }
}
