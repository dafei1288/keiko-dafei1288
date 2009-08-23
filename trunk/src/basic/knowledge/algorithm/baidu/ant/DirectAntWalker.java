package basic.knowledge.algorithm.baidu.ant;

public class DirectAntWalker {   
	  
    public static int totalLength = 27;   
  
    public static void main(String[] args) {   
  
        directTest();   
  
    }   
  
    private static void directTest() {   
        int count = 0;   
        for (int d1 = -1; d1 <= 1; d1 += 2) {   
            for (int d2 = -1; d2 <= 1; d2 += 2) {   
                for (int d3 = -1; d3 <= 1; d3 += 2) {   
                    for (int d4 = -1; d4 <= 1; d4 += 2) {   
                        for (int d5 = -1; d5 <= 1; d5 += 2) {   
  
                            count++;   
  
                            // 构造蚂蚁数组   
                            int[] ants = { 3 * d1, 7 * d2, 11 * d3, 17 * d4,   
                                    23 * d5 };   
  
                            // 设置index初始取值范围   
                            int idx1 = 0, idx2 = 4;   
                            int totalTime = 0;   
  
                            int i = 0;   
                            while (true) {   
  
                                // 如果有蚂蚁先达到边界，一定是发生在边界处   
                                // 如果第一只蚂蚁已经达到边界，就忽略这只蚂蚁   
                                if (ants[idx1] == 0  
                                        || ants[idx1] == totalLength) {   
                                    idx1++;   
                                }   
                                // 如果最后一只蚂蚁已经达到边界，就忽略这只蚂蚁   
                                if (ants[idx2] == 0  
                                        || ants[idx2] == totalLength) {   
                                    idx2--;   
                                }   
                                // 如果当前可访问的下界超过上界，就跳出循环   
                                if (idx1 > idx2)   
                                    break;   
                                // 如果下届等于上界，则说明仅有一只蚂蚁还没有走出去。   
                                else if (idx1 == idx2) {   
                                    if (ants[idx1] < 0) {   
                                        totalTime -= ants[idx1];   
                                    } else {   
                                        totalTime += (totalLength - ants[idx1]);   
                                    }   
                                    break;   
                                }   
  
                                // 对于其他情况让 所有的蚂蚁走一步，如果出现了蚂蚁位置重合，就让重合的2只蚂蚁转向   
                               
                                ants[idx1] = ants[idx1] + 1;   
                                for (i = idx1 + 1; i <= idx2; i++) {   
                                    ants[i] = ants[i] + 1;   
                                    if (ants[i] + ants[i - 1] == 0) {   
                                        ants[i] *= -1;   
                                        ants[i - 1] *= -1;   
                                    }   
                                }   
                                   
                                // 消耗的时间递增1。   
                                totalTime++;   
                            }   
  
                            System.out.print("count=" + count + " d1=" + d1   
                                    + " d2=" + d2 + " d3=" + d3 + " d4=" + d4   
                                    + " d5=" + d5);   
                            System.out.println("  totalTime=" + totalTime);   
                        }   
                    }   
                }   
            }   
        }   
    }   
}  

