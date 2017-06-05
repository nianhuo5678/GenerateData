package test;

public class Main {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BetCode betCode = new BetCode();
		betCode.calPrizes(betCode);
		
		
		System.out.println("Red balls:" + betCode.getRedBalls().toString());
		System.out.println("Blue balls:" + betCode.getBlueBalls().toString());
		
		System.out.println("First Prize: " + betCode.getFirstPrize());
		System.out.println("Second Prize: " + betCode.getSecondPrize());
		System.out.println("Third Prize: " + betCode.getThirdPrize());
		System.out.println("Forth Prize: " + betCode.getForthPrize());
		System.out.println("Fifth Prize: " + betCode.getFifthPrize());
		System.out.println("Sixth Prize: " + betCode.getSixthPrize());
	}
	
}
