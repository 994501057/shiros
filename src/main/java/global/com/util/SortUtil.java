package global.com.util;

public class SortUtil {
    public static void main(String[] args) {
        /*int[] arr={4,8,1,22,19,20,11,30,28};
        for (int x:sort(arr)){
            System.out.println(x);
        };*/
       int x= diedai(10);
       int y= digui(3);
        System.out.println(x);
       int j=x*y;
        System.out.println(j);
    }

    /**
     * 冒泡排序
     * return array；
     * 比较相邻的两位数据，如果第一个比第二个大，则交换两个数字，对每一对相邻数字进行比较，以达到最后一位为最大的数字，再次重复前述步骤
     * （已经排除掉最后一位）
     */
    public static  int[] sort(int[] array){
        if (array.length==0)
            return array;
        for (int i=0;i<array.length;i++){
            for (int j=0;j<array.length-1-i;j++){
                if (array[j]>array[j+1]){
                    int temp=array[j+1];
                    array[j+1]=array[j];
                    array[j]=temp;
                }
            }
        }
    return array;
    }
    /**
     * 选择排序
     * 选择未排序中的最小数，并保存，再从剩余未排序元素中继续寻找最小（大）元素，
     * 然后放到已排序序列的末尾。以此类推，直到所有元素均排序完毕
     * */
    public static int[] Selection(int[] arr){
        if (arr.length==0)
            return arr;
        for (int i=0;i<arr.length;i++){
            int minIndex=i;
            for ( int j=i;j<arr.length;j++){
                if (arr[j]<arr[minIndex]){
                    minIndex=j;
                }
            }
            int temp=arr[minIndex];
            arr[minIndex]=arr[i];
            arr[i]=temp;
        }
    return arr;
    }
    /**
     * 插入排序
     * @param array
     * @return
     * 从第一个元素开始，该元素可以认为已经被排序；
     * 取出下一个元素，在已经排序的元素序列中从后向前扫描；
     * 如果该元素（已排序）大于新元素，将该元素移到下一位置；
     * 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
     * 将新元素插入到该位置后；
     * 重复步骤2~5。
     */
    public static int[] insertionSort(int[] array) {
        if (array.length == 0)
            return array;
        int current;
        for (int i = 0; i < array.length - 1; i++) {
            current = array[i + 1];
            int preIndex = i;
            while (preIndex >= 0 && current < array[preIndex]) {
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            array[preIndex + 1] = current;
        }
        return array;
    }
    /**
     * 递归 n的阶乘
     */
    public static int digui(int n){
        int res=1;
        if (n==1){
            return 1;
        }else {
            res=digui(n-1)*n;
        }
        return res;
    }
    /**
     * 迭代
     */
    public  static int diedai(int n){
        int temp=0;
        for (int i=1;i<n;i++){
            temp+=(i-2);
        }
        return temp;
    }
}
