/**
 * Created by Lx on 2015/11/26.
 */
public class MedianOfTwoSortedArrays {
    /*思想：getKth方法返回输入的两个数组中合并起来第k小的数，将k对半分，比较a数组和b数字第k/2位的数字大小，
    若a中k/2大于b中k/2，则第k小的数不可能出现在b的前k/2个数字之中，因此递归的去调用a数组和b数组k/2之后的数组成的数组(
    这里只用开始位去当做‘新的’b数组的起始下标，而并未真的去创建新数组)并求其第k减去b去除的k/2个最小数字。当k=1时，即求最小
    的一位，因此返回a，b数组中起始位中最小的那个数字,当a的起始位大于a的数组长度时，应去求b中第k个最小的元素，b的起始位大于b
    数组长度时同理。当想去获取a的第k/2位来与b的第k/2位比较大小而a + k /2却超过了a的数组长度时应取a的最后一位与b的k/2位比较;
    * */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLength = nums1.length + nums2.length;
        if(totalLength % 2 == 0){
            return (getKth(nums1,0,nums2,0,totalLength / 2) + getKth(nums1,0,nums2,0,totalLength / 2 + 1))/2.0;
        }else {
            return getKth(nums1,0,nums2,0,totalLength / 2 + 1);
        }
    }

    public int getKth(int[] a,int startA,int[] b,int startB,int k){
        if (startA > a.length - 1){
            return b[startB + k - 1];
        }

        if (startB > b.length - 1){
            return a[startA + k - 1];
        }

        if(k == 1){
            return Math.min(a[startA],b[startB]);
        }

        int aMid = Math.min(a.length - 1,startA + k / 2 - 1);
        int bMid = Math.min(b.length - 1,startB + k / 2 - 1);

        if(a[aMid] > b[bMid]){
            return getKth(a,startA,b,bMid + 1,k - (bMid - startB + 1));
        }else{
            return getKth(a,aMid + 1,b,startB,k - (aMid - startA + 1));
        }
    }

    public static void main(String[] args){
        MedianOfTwoSortedArrays m = new MedianOfTwoSortedArrays();
        int[] a = {1,2,3,4,6,9};
        int[] b = {1,3,9};
        System.out.println(m.findMedianSortedArrays(a,b) + "");
    }
}
