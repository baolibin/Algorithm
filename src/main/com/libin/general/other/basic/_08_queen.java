package libin.general.other.basic;
/**
 * 8皇后.
 */
public class _08_queen{
    public static void main(String[] ages){
        _8queen queen = new _8queen();
        queen.startQueen(0);
        System.out.println("一共有"+queen.getSum()+"种方法");
    }
}
class _8queen {
    private int numQueen;
    private int[] num;
    private int sum;
    public _8queen(){
        numQueen=8;
        this.sum=0;
        num=new int[numQueen];
    }
    public int getSum(){
        return this.sum;
    }
    public void print(int[] num){
        for(int i=0;i<num.length;i++){
            System.out.print(num[i]+"、");
        }
        System.out.println();
    }
    /**
     * 开始计算8皇后可能情况
     */
    public void startQueen(int curIndex){
        if(curIndex==this.numQueen){
            this.sum++;
            print(num);
        }else{
            for(int i=0;i<this.numQueen;i++){
                num[curIndex]=i;
                if(legal(num,curIndex)){
                    startQueen(curIndex+1);
                }
            }
        }
    }
    /**
     * 判断当前位置是否合法
     */
    public boolean legal(int[] num,int curLocal){
        for(int i=0;i<curLocal;i++){
            if(num[i]==num[curLocal]||Math.abs(num[i]-num[curLocal])==Math.abs(i-curLocal)){
                return false;
            }
        }
        return true;
    }
}
