package net.fly78.dafei1288.util.math.algorithm.sort;

public class BubbleSort {
	/**
     *冒泡排序
     *@param src待排序数组
     */
	public static void  doBubbleSort(int[] src)
    {
       int len=src.length;
       for(int i=0;i<len;i++)
       {
           for(int j=i+1;j<len;j++)
           {
              int temp;
              if(src[i]>src[j])
              {
                  temp=src[j];
                  src[j]=src[i];
                  src[i]=temp;
              }             
           }
       }      
    }

}
