package test;

import java.util.ArrayList;

public class BetCode {

	//红球数量
	private int redNum;
	
	//蓝球数量
	private int blueNum;

	//红球列表
	private ArrayList<Integer> redBalls;
	
	//蓝球列表
	private ArrayList<Integer>  blueBalls;

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
	 * @param redBalls
	 * @param blueBalls
	 */
	public BetCode() {
		super();
		this.redBalls = new ArrayList<Integer>();
		this.blueBalls = new ArrayList<Integer>();
	}

	
	
	
	
	
}
