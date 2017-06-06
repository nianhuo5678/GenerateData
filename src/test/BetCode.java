package test;

import java.util.ArrayList;
import java.util.Collections;

public class BetCode {
	
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

	//红球数量
	private int redNum;
	
	//蓝球数量
	private int blueNum;
	
	//倍数
	private int mutil = 1;

	//红球列表
	private ArrayList<Integer> redBalls;
	
	//蓝球列表
	private ArrayList<Integer>  blueBalls;
		
	
	
	/**
	 * @return the mutil
	 */
	public int getMutil() {
		return mutil;
	}

	/**
	 * @param mutil the mutil to set
	 */
	public void setMutil(int mutil) {
		this.mutil = mutil;
	}

	/**
	 * @param firstPrize the firstPrize to set
	 */
	public void setFirstPrize(int firstPrize) {
		this.firstPrize = firstPrize;
	}

	/**
	 * @param secondPrize the secondPrize to set
	 */
	public void setSecondPrize(int secondPrize) {
		this.secondPrize = secondPrize;
	}

	/**
	 * @param thirdPrize the thirdPrize to set
	 */
	public void setThirdPrize(int thirdPrize) {
		this.thirdPrize = thirdPrize;
	}

	/**
	 * @param forthPrize the forthPrize to set
	 */
	public void setForthPrize(int forthPrize) {
		this.forthPrize = forthPrize;
	}

	/**
	 * @param fifthPrize the fifthPrize to set
	 */
	public void setFifthPrize(int fifthPrize) {
		this.fifthPrize = fifthPrize;
	}

	/**
	 * @param sixthPrize the sixthPrize to set
	 */
	public void setSixthPrize(int sixthPrize) {
		this.sixthPrize = sixthPrize;
	}

	//一等奖数量
	private int firstPrize = 0;
	
	//二等奖数量
	private int secondPrize = 0;
	
	//三等奖数量
	private int thirdPrize = 0;
	
	//四等奖数量
	private int forthPrize = 0;
	
	//五等奖数量
	private int fifthPrize = 0;
	
	//六等奖数量
	private int sixthPrize = 0;

	/**
	 * @return the redNum
	 */
	public int getRedNum() {
		return redNum;
	}

	/**
	 * @param redNum the redNum to set
	 */
	public void setRedNum(int redNum) {
		this.redNum = redNum;
	}

	/**
	 * @return the blueNum
	 */
	public int getBlueNum() {
		return blueNum;
	}

	/**
	 * @param blueNum the blueNum to set
	 */
	public void setBlueNum(int blueNum) {
		this.blueNum = blueNum;
	}

	/**
	 * @return the redBalls
	 */
	public ArrayList<Integer> getRedBalls() {
		return redBalls;
	}

	/**
	 * @param redBalls the redBalls to set
	 */
	public void setRedBalls(int redBall) {
		redBalls.add(redBall);
	}

	/**
	 * @return the blueBalls
	 */
	public ArrayList<Integer> getBlueBalls() {
		return blueBalls;
	}

	/**
	 * @param blueBalls the blueBalls to set
	 */
	public void setBlueBalls(int blueBall) {
		blueBalls.add(blueBall);
	}

	/**
	 * @return the firstPrize
	 */
	public int getFirstPrize() {
		return firstPrize;
	}

	/**
	 * @return the secondPrize
	 */
	public int getSecondPrize() {
		return secondPrize;
	}

	/**
	 * @return the thirdPrize
	 */
	public int getThirdPrize() {
		return thirdPrize;
	}

	/**
	 * @return the forthPrize
	 */
	public int getForthPrize() {
		return forthPrize;
	}

	/**
	 * @return the fifthPrize
	 */
	public int getFifthPrize() {
		return fifthPrize;
	}

	/**
	 * @return the sixthPrize
	 */
	public int getSixthPrize() {
		return sixthPrize;
	}
	
	/**
	 * @param redBalls
	 * @param blueBalls
	 */
	public BetCode() {
		super();
		this.redBalls = new ArrayList<Integer>();
		this.blueBalls = new ArrayList<Integer>();
	}
	
	
	/**
	 * 生成包含中奖号码的复式投注方案
	 * @param redNum 复式投注中红球的个数
	 * @param blueNum 复式投注中蓝球的个数
	 * @param redWin 红球中奖号码个数
	 * @param blueWin 蓝球中奖号码个数
	 */
	public void lotteryPlan(BetCode bc, int redNum, int blueNum, int redWin, int blueWin) {
		
		//添加红球中奖号码
//		for(int i : winRedBalls) {
//			bc.setRedBalls(i);
//		}
		for(int i = 0; i < redWin; i++) {
			bc.setRedBalls(winRedBalls[i]);
		}
		
		//添加蓝球中奖号码
//		for(int i : winBlueBalls) {
//			bc.setBlueBalls(i);
//		}
		for(int i = 0; i < blueWin; i++) {
			bc.setBlueBalls(winBlueBalls[i]);
		}
		
		//添加其余红球号码
		for(int i = 0; i < (redNum - redWin); i++) {
			int ranRedBall = Util.randomRed();
			while( bc.getRedBalls().contains(ranRedBall) ) {
				ranRedBall = Util.randomRed();
			}
			bc.setRedBalls(ranRedBall);
		}
		
		//添加其余蓝球号码
		for(int i = 0; i < (blueNum - blueWin); i++) {
			int ranBlueBall = Util.randomBlue();
			while( bc.getBlueBalls().contains(ranBlueBall) ) {
				ranBlueBall = Util.randomBlue();
			}
			bc.setBlueBalls(ranBlueBall);
		}	
		
		//排序
		Collections.sort(bc.getRedBalls());
		Collections.sort(bc.getBlueBalls());
	}
	
	/*
	 *一次投注最大10000注的情况下，红球、蓝球最多可以取多少个
	 */
	public ArrayList<BetCode> redBlueBallMax(){
		
		//注数
		int betCount = 0; 
		//倍数
		int mutil = 1;
		
		ArrayList<BetCode> bcList = new ArrayList<BetCode>();
		
		for(int r = MINREDNUM; r < MAXREDNUM; r++){
			for(int b = MINBLUENUM; b < MAXBLUENUM; b++){
				//注数等于红球的排列组合数乘以蓝球的排列组合数
				for(mutil = 1; mutil < 10000; mutil++) {
					betCount = Util.calC(b, MINBLUENUM) * Util.calC(r, MINREDNUM) * mutil;
					if(betCount > 10000 && r >= MINREDNUM && (b - 1) >= MINBLUENUM){
						BetCode bc = new BetCode();
						bc.setRedNum(r);
						bc.setBlueNum(b - 1);
						bc.setMutil(mutil - 1);
						bcList.add(bc);
						break;
					}
				}
			}
			if(r >= 15){
				break;
			}
		}
		return bcList;
	}
	
	/**
	 * 拆分复式投注方案,统计中奖数量
	 */
	public void calPrizes(BetCode bc, int redNum, int blueNum, int redWin, int blueWin) {
		bc.lotteryPlan(bc, redNum, blueNum, redWin, blueWin);
		ArrayList<int[]> redCodeCombination = new ArrayList<int[]>();
		ArrayList<int[]> blueCodeCombination = new ArrayList<int[]>();
	
		//拆分红球排列组合
		redCodeCombination = Util.combinationSelect(redCodeCombination, bc.getRedBalls(), 0, new int[6], 0);
		//拆分蓝球排列组合
		blueCodeCombination = Util.combinationSelect(blueCodeCombination, bc.getBlueBalls(), 0, new int[1], 0);
		
		//合并红球蓝球作为一行投注记录
		for(int[] i : redCodeCombination) {
			for(int[] j : blueCodeCombination) {
				
				//比较红球相等的个数
				int redCount = Util.compareArray(i, winRedBalls);
				//比较蓝球相等的个数
				int blueCount = Util.compareArray(j, winBlueBalls);
				

				//一等奖
				if(redCount == 6 && blueCount == 1) {
					firstPrize++;
					continue;
				}
				
				//二等奖
				if(redCount == 6 && blueCount == 0) {
					secondPrize++;
					continue;
				}
				
				//三等奖
				if(redCount == 5 && blueCount == 1) {
					thirdPrize++;
					continue;
				}
				
				//四等奖
				if( (redCount == 5 && blueCount == 0) || (redCount == 4 && blueCount == 1) ) {
					forthPrize++;
					continue;
				}
				
				//五等奖
				if( (redCount == 4 && blueCount == 0) || (redCount == 3 && blueCount == 1) ) {
					fifthPrize++;
					continue;
				}
				
				//六等奖
				if( (redCount == 2 && blueCount == 1) || 
						(redCount == 1 && blueCount == 1) || 
						(redCount == 0 && blueCount == 1 ) ) {
					sixthPrize++;
					continue;
				}
			}
		}		
	}

	
	
}
