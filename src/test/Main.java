package test;

import java.util.ArrayList;
import test.Util;

public class Main {

	//��С�������
	public static final int MINREDNUM = 6;
	
	 //��С�������
	public static final int MINBLUENUM = 1;
	
	//���������
	public static final int MAXREDNUM = 33;
	
	//���������� 
	public static final int MAXBLUENUM = 16;
	
	//�����н�����
	public static int[] winRedBalls = {2,11,17,19,24,30};
	
	//�����н�����
	public static int[] winBlueBalls = {13};
	
	/*
	 *һ��Ͷע���10000ע������£���������������ȡ���ٸ�
	 */
	public ArrayList<BetCode> redBlueBallMax(){
		
		//�������
		int redNumber = 0;
		
		//�������
		int blueNumber = 0;
		
		//ע��
		int betCount = 0; 
		
		ArrayList<BetCode> bcList = new ArrayList<BetCode>();
		
		for(int r = MINREDNUM; r < MAXREDNUM; r++){
			for(int b = MINBLUENUM; b < MAXBLUENUM; b++){
				//ע�����ں�������������������������������
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
	 * ���ɰ����н�����ĸ�ʽͶע����
	 * @param redNum ��ʽͶע�к���ĸ���
	 * @param blueNum ��ʽͶע������ĸ���
	 */
	public BetCode lotteryPlan(int redNum, int blueNum) {
		BetCode bc = new BetCode();
		
		//��Ӻ����н�����
		for(int i : winRedBalls) {
			bc.setRedBalls(i);
		}
		
		//��������н�����
		for(int i : winBlueBalls) {
			bc.setBlueBalls(i);
		}
		
		//�������������
		for(int i = 0; i < (redNum - 6); i++) {
			int ranRedBall = Util.randomRed();
			while( bc.getRedBalls().contains(ranRedBall) ) {
				ranRedBall = Util.randomRed();
			}
			bc.setRedBalls(ranRedBall);
		}
		
		//��������������
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
		
		//��ֺ����������
		redCodeCombination = Util.combinationSelect(redCodeCombination, betCode.getRedBalls(), 0, new int[MINREDNUM], 0);
		//��������������
		blueCodeCombination = Util.combinationSelect(blueCodeCombination, betCode.getBlueBalls(), 0, new int[MINBLUENUM], 0);
		
		//�ϲ�����������Ϊһ��Ͷע��¼
		for(int[] i : redCodeCombination) {
			for(int[] j : blueCodeCombination) {
				StringBuilder plan = new StringBuilder();
				//�������ֲ�ʮλ0
				for(int k = 0; k < i.length; k++) {
					if(i[k] < 10) {
						plan.append("0");
					}
					plan.append(i[k]);
					plan.append(",");
				}
				plan.deleteCharAt(plan.length() - 1);
				plan.append("|");
				//�������ֲ�ʮλ0
				for(int h = 0; h < j.length; h++) {
					if(j[h] < 10) {
						plan.append("0");
					}
					plan.append(j[h]);
				}
				allCombination.add(plan.toString());
			}
		}

		//��ӡ���в�ֺ��Ͷע����
		for(String str : allCombination) {
			System.out.println(str);
		}
	}
	
}
