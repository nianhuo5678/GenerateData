package test;

import java.util.ArrayList;
import test.Util;

public class Main {

	//最小红球个数
	public static final int MINREDNUM = 6;
	
	 //最小蓝球个数
	public static final int MINBLUENUM = 1;
	
	//最大红球个数
	public static final int MAXREDNUM = 33;
	
	//最大蓝球个数 
	public static final int MAXBLUENUM = 16;
	
	//红球中奖号码
	public static int[] winRedBalls = {2,11,17,19,24,30};
	
	//蓝球中奖号码
	public static int[] winBlueBalls = {13};
	
	/*
	 *一次投注最大10000注的情况下，红球、蓝球最多可以取多少个
	 */
	public ArrayList<BetCode> redBlueBallMax(){
		
		//红球个数
		int redNumber = 0;
		
		//蓝球个数
		int blueNumber = 0;
		
		//注数
		int betCount = 0; 
		
		ArrayList<BetCode> bcList = new ArrayList<BetCode>();
		
		for(int r = MINREDNUM; r < MAXREDNUM; r++){
			for(int b = MINBLUENUM; b < MAXBLUENUM; b++){
				//注数等于红球的排列组合数乘以蓝球的排列组合数
				betCount = Util.calC(b, MINBLUENUM) * Util.calC(r, MINREDNUM);
				if(betCount > 10000 && r >= MINREDNUM && (b - 1) >= MINBLUENUM){
					BetCode bc = new BetCode();
					bc.setRedNum(r);
					bc.setBlueNum(b-1);
					bcList.add(bc);
					break;
				}
			}
			if(r >= 15){
				break;
			}
		}
		return bcList;
	}
	
	/**
	 * 生成包含中奖号码的复式投注方案
	 * @param redNum 复式投注中红球的个数
	 * @param blueNum 复式投注中蓝球的个数
	 */
	public BetCode lotteryPlan(int redNum, int blueNum) {
		BetCode bc = new BetCode();
		
		//添加红球中奖号码
		for(int i : winRedBalls) {
			bc.setRedBalls(i);
		}
		
		//添加蓝球中奖号码
		for(int i : winBlueBalls) {
			bc.setBlueBalls(i);
		}
		
		//添加其余红球号码
		for(int i = 0; i < (redNum - 6); i++) {
			int ranRedBall = Util.randomRed();
			while( bc.getRedBalls().contains(ranRedBall) ) {
				ranRedBall = Util.randomRed();
			}
			bc.setRedBalls(ranRedBall);
		}
		
		//添加其余蓝球号码
		for(int i = 0; i < (blueNum -1); i++) {
			int redBlueBall = Util.randomBlue();
			while( bc.getBlueBalls().contains(redBlueBall) ) {
				redBlueBall = Util.randomBlue();
			}
			bc.setBlueBalls(redBlueBall);
		}
		
		
		return bc;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Main m = new  Main();
		BetCode betCode = m.lotteryPlan(12, 10);	
		ArrayList<int[]> redCodeCombination = new ArrayList<int[]>();
		ArrayList<int[]> blueCodeCombination = new ArrayList<int[]>();
		ArrayList<String> allCombination = new ArrayList<String>();
		
		//拆分红球排列组合
		redCodeCombination = Util.combinationSelect(redCodeCombination, betCode.getRedBalls(), 0, new int[MINREDNUM], 0);
		//拆分蓝球排列组合
		blueCodeCombination = Util.combinationSelect(blueCodeCombination, betCode.getBlueBalls(), 0, new int[MINBLUENUM], 0);
		
		//合并红球蓝球作为一行投注记录
		for(int[] i : redCodeCombination) {
			for(int[] j : blueCodeCombination) {
				StringBuilder plan = new StringBuilder();
				//红球数字补十位0
				for(int k = 0; k < i.length; k++) {
					if(i[k] < 10) {
						plan.append("0");
					}
					plan.append(i[k]);
					plan.append(",");
				}
				plan.deleteCharAt(plan.length() - 1);
				plan.append("|");
				//蓝球数字补十位0
				for(int h = 0; h < j.length; h++) {
					if(j[h] < 10) {
						plan.append("0");
					}
					plan.append(j[h]);
				}
				allCombination.add(plan.toString());
			}
		}

		//打印所有拆分后的投注方案
		for(String str : allCombination) {
			System.out.println(str);
		}
	}
	
}
