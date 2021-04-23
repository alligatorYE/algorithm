package array;

/**
 * @Description
 * @Version v1.0
 * @Author yange1
 * @Date 2021/2/23
 * @Time 11:35
 */
public class Array {
    //TODO 定义整型数据data保存数据
    public int  data[];
    //TODO 定义数组长度
    private int n;
    //TODO 定义实际个数
    private int count;
    //TODO 构造方法定义数组大小
    public Array(int capacity){
        this.data = new int[capacity];
        this.n = capacity;
        this.count = 0;
    }
    //TODO 根据索引找到数据中的元素并返回
    public int find(int index){
        if (index < 0 || index >= count) {
            return -1;
        }
        return data[index];
    }
    //TODO 插入元素:头部插入、尾部插入
    public boolean insert(int index, int value){
        //TODO 数组中无元素
        if (index == count && count == 0){
           data[index] = value;
           ++count;
           return true;
        }
        //TODO 数组空间已满
        if (count == n){
            System.out.printf("没有可插入的位置");
            return false;
        }
        //如果count还没满，那么就可以插入数据到数组中
        //TODO　位置不合法
        if (index < 0 || index > count){
            System.out.printf("位置不合法");
            return false;
        }
        //TODO 位置合法
        for (int i = count;i > index; --i){
            data[i] = data[i -1];
        }
        data[index] = value;
        ++count;
        return true;
    }
    //TODO 根据索引，删除数组中元素
    public boolean delete(int index){
        //位置非法
        if (index < 0 || index > count){
            return false;
        }
        //从删除的位置开始，将后面的元素向前移动一位
        for (int i = index + 1 ; i < count; ++i) {
            data[i - 1] = data[i];
        }
        --count;
        return true;
    }
    //TODO 打印所有
    public void printAll(){
        for (int i = 0; i < count; ++i) {
            System.out.printf(data[i] + "\t");
        }
        System.out.println();
    }
    /**
     * 主函数
     * */
    public static void main(String[] args) {
        Array array = new Array(5);
        array.printAll();
        array.insert(0,3);
        array.insert(0,4);
        array.insert(1,5);
        array.insert(3,9);
        array.insert(3,10);
        array.printAll();
        array.delete(3);
        array.printAll();

        StringBuilder sb = new StringBuilder(1024);
        sb.append("Mr ").append("Bob").append("!").insert(0,"Hello, ");
        System.out.println(sb.toString());
    }
}
