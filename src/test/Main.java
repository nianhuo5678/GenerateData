package test;

public class Main {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int redWin = 6; //�����н�����
		int blueWin = 1;  //�����н�����
		LotteryPlan lp = new LotteryPlan();
		for(redWin = 0; redWin <= 6; redWin++) {
			for(blueWin= 0; blueWin <= 1; blueWin++){
				lp.genPlans(redWin,blueWin);
			}
		}
	}
	
}
