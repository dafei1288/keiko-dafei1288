package net.fly78.dafei1288.util.math.algorithm.sort;

public class InsertionSort {
	 /**
     *插入排序(WHILE循环实现)
     *@param src待排序数组
     */
    public static void doInsertSort1(int[] src)
    {
       int len=src.length;
       for(int i=1;i<len;i++)
       {   
           int temp=src[i];
           int j=i;
           
           while(src[j-1]>temp)
           {
              src[j]=src[j-1];
              j--;
              if(j<=0)
                  break;
           }
           src[j]=temp;
       }
    }
    /**
     *插入排序(FOR循环实现)
     *@param src待排序数组
     */
    public static void doInsertSort2(int[] src)
    {
       int len=src.length;
       for(int i=1;i<len;i++)
       {
           int j;
           int temp=src[i];
           for(j=i;j>0;j--)
           {
              if(src[j-1]>temp)
              {
                  src[j]=src[j-1];
                  
              }else//如果当前的数，不小前面的数，那就说明不小于前面所有的数，
                   //因为前面已经是排好了序的，所以直接通出当前一轮的比较
                  break;
           }
           src[j]=temp;
       }
    }

}
