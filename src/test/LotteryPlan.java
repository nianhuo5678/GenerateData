package test;

import java.util.*;

public class LotteryPlan {
	
	//倍数
	private int mutil;
	
	//最大投注数
	private static final int MAXCOUNT = 10000;
	
	/**
	 * 生成复式投注方案，注数不超过10000
	 */
	public void genPlans(int redWin, int blueWin) {	
		int plans = 0;
		Random ran = new Random();
		for(int i = 6; i <= 15; i++) {
			for(int j = 1; j <= 10; j++) {
				plans = Util.calC(i, 6) * Util.calC(j, 1);
				//排除6个红球，1个蓝球非复式的方案
				if( (plans <= MAXCOUNT) && !(i == 6 && j == 1) ) {
					if(plans < 2000) {
						mutil = ran.nextInt(5) + 1;
					} else if(plans < 2500) {
						mutil = ran.nextInt(4) + 1;
					} else if(plans < 3333) {
						mutil = ran.nextInt(3) + 1;
					} else if(plans < 5000) {
						mutil = ran.nextInt(2) + 1;
					} else {
						mutil = 1;
					}
					System.out.printf("i: %d j: %d mutil: %d\n", i, j, mutil);
					BetCode bc = new BetCode();
					bc.calPrizes(bc, i, j, redWin, blueWin);
					FileOperation fo = new FileOperation();
					fo.writeFile(bc, mutil);
					System.out.println("Red Balls: " + bc.getRedBalls().toString());
					System.out.println("Blue Balls: " + bc.getBlueBalls().toString());
				}
			}
		}
	}
}
