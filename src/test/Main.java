package test;

public class Main {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int redWin = 6; //红球中奖个数
		int blueWin = 1;  //蓝球中奖个数
		LotteryPlan lp = new LotteryPlan();
		for(redWin = 0; redWin <= 6; redWin++) {
			for(blueWin= 0; blueWin <= 1; blueWin++){
				lp.genPlans(redWin,blueWin);
			}
		}
	}
	
}
