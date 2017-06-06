package test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileOperation {

	public void writeFile(BetCode bc, int mutil){
		String path = "E:\\testtools\\jmeter\\404\\apache-jmeter-3.1\\bin\\404\\LotteryPlans.csv";
		FileWriter fw = null;
		BufferedWriter bw = null;
		StringBuilder sb = new StringBuilder();
		try {
			fw = new FileWriter(path,true);
			bw = new BufferedWriter(fw);
			
			//写入红球
			for(int redBall : bc.getRedBalls()) {
				//号码小于10，前面补零
				if(redBall < 10) {
					sb.append("0");
				}
				sb.append(redBall);
				sb.append(",");
			}
			//删除最后一个逗号
			sb.deleteCharAt(sb.length() - 1);
			//插入分隔符
			sb.append("|");
			//写入蓝球
			for(int blueBall : bc.getBlueBalls()) {
				if(blueBall < 10) {
					sb.append("0");
				}
				sb.append(blueBall);
				sb.append(",");
			}
			//删除最后一个逗号
			sb.deleteCharAt(sb.length() - 1);
			
			//插入分隔符 \t
			sb.append("\t");
			
			//插入倍数
			sb.append(mutil + "\t");
			
			//一等奖个数
			sb.append(bc.getFirstPrize() + "\t");
			
			//二等奖个数
			sb.append(bc.getSecondPrize() + "\t");
			
			//三等奖个数
			sb.append(bc.getThirdPrize() + "\t");
			
			//四等奖个数
			sb.append(bc.getForthPrize() + "\t");
			
			//五等奖个数
			sb.append(bc.getFifthPrize() + "\t");
			
			//六等奖个数
			sb.append(bc.getSixthPrize());
			
			sb.append("\n");
			bw.write(sb.toString());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			bw.close();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
