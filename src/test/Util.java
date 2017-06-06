package test;

import java.util.*;

public class Util {

	/**
     * 计算C组合数
     * @param big 下标
     * @param small 上标
     * @return
     */
	public static int calC(int big, int small){
		if(big <=0 || small <= 0 || big < small){
			System.out.println("param_error");
		}
		
		int res = 1;
		int b = big;
		for(int i=0; i< small; i++){
			res *= b;
			b--;
		}
		int s = small;
		for(int i=0; i< small; i++){
			res /= s;
			s--;
		}

		return res;
	}
	
	/**
	 * 随机生成红球号码
	 * 范围 1 ~ 33
	 * @return  red 红球号码
	 */
	public static int randomRed() {
		Random ran = new Random();
		int red = ran.nextInt(33) + 1;
		return red;
	}
	
	/**
	 * 随机生成蓝球号码
	 * 范围 1 ~ 16
	 * @return blue 蓝球号码
	 */
	public static int randomBlue() {
		Random ran = new Random();
		int blue = ran.nextInt(16) + 1;
		return blue;
	}
	
	
    /** 
     * 组合选择 
     * @param dataList 待选列表 
     * @param dataIndex 待选开始索引 
     * @param resultList 前面（resultIndex-1）个的组合结果 
     * @param resultIndex 选择索引，从0开始 
     */  
    public static ArrayList<int[]> combinationSelect(ArrayList<int[]> lines, ArrayList<Integer> dataList, int dataIndex, int[] resultList, int resultIndex) {  
        int resultLen = resultList.length;  
        int resultCount = resultIndex + 1;  
        if (resultCount > resultLen) { // 全部选择完时，输出组合结果  
//            System.out.println(Arrays.toString(resultList));  
        	lines.add(resultList.clone());
            return lines;  
        }  
  
        // 递归选择下一个  
        for (int i = dataIndex; i < dataList.size() + resultCount - resultLen; i++) {  
            resultList[resultIndex] = dataList.get(i);  
            combinationSelect(lines, dataList, i + 1, resultList, resultIndex + 1);  
        }
		return lines;
    } 
    
    /**
     * 比较两个数组，返回相同元素的个数
     * @param a,b 代比较的两个数组
     * @return count 相同元素的数量，0表示没有相同
     */
    public static int compareArray(int[] a, int[] b) {
    	int count = 0;
    	//循环b数组的每一个元素，是否在a数组中出现，如果有count + 1
    	for(int i = 0; i < a.length; i++) {
    		for(int j = 0; j < b.length; j++) {
    			if(a[i] ==  b[j]) {
    				count++;
    			}
    		}
    	}
    	return count;
    }
}
