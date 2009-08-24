package net.fly78.dafei1288.util.math.algorithm.sort;

public class SelectionSort {
	 /**
     *选择排序
     *@param src待排序的数组
     */
    public static void doChooseSort(int[] src)
    {
       int len=src.length;
       int temp;
       for(int i=0;i<len;i++)
       {
           temp=src[i];
           int j;
           int samllestLocation=i;//最小数的下标
           for(j=i+1;j<len;j++)
           {
              if(src[j]<temp)
              {
                  temp=src[j];//取出最小值
                  samllestLocation=j;//取出最小值所在下标
              }
           }
           src[samllestLocation]=src[i];
           src[i]=temp;
       }
    }
}
