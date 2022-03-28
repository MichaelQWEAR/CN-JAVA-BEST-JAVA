package 警告警告;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;

import javax.imageio.ImageIO;
public class 红视 {


	// 计算红色像素所占比例，传入参数为图片的文件路径
	public static String calculateRed(String image) throws Exception {

		File file = new File(image);
		BufferedImage bi = null;
		double redCalculateR, redCalculateG, redCalculateB, redPreCalculateR = 0, redPreCalculateG = 0, redPreCalculateB = 0, grayLevel = 0;
		try {
			bi = ImageIO.read(file);
		} catch (Exception e) {
			e.printStackTrace();
		}

		//长宽
		int width = bi.getWidth();
		int height = bi.getHeight();

		//横纵坐标起始点
		int minx = bi.getMinX();
		int miny = bi.getMinY();

		//红色像素点个数
		long RedNumber = 0;


		int[] rgb = new int[3];// 定义RGB空间

		// 开始遍历所有像素点
		for (int i = minx; i < width; i++) {
			for (int j = miny; j < height; j++) {

				// 当前像素点
				int pixel = bi.getRGB(i, j); 

				// 获取RGB各值
				rgb[0] = (pixel & 0xff0000) >> 16;//R
			rgb[1] = (pixel & 0xff00) >> 8;//G
			rgb[2] = (pixel & 0xff);//B

			//使用rgb判断该像素点是否可以判定为红色像素点
			if (rgb[0]  >= 135 && rgb[0]  <= 255 && rgb[1]  >= 0 && rgb[1]  <= 192 && rgb[2]  > 0 && rgb[2] <= 255) {
				RedNumber++;
				redPreCalculateR=redPreCalculateR+rgb[0];
				redPreCalculateG=redPreCalculateG+rgb[1];
				redPreCalculateB=redPreCalculateB+rgb[2];

			}
			redCalculateR=redPreCalculateR/RedNumber;
			redCalculateG=redPreCalculateR/RedNumber;
			redCalculateB=redPreCalculateR/RedNumber;
			grayLevel = redCalculateR*0.299 + redCalculateG * 0.587+ redCalculateB * 0.114;
			
			}
		}
		if (grayLevel >= 192) {
			System.out.println("红温");
		} 
		else {
			System.out.println("还没红温呢");
		}
		// 总像素点个数
		long totalPixelNumber = width * height;

		// 获取浮点数表示的占比
		double RedPixelProportion = (double) RedNumber / totalPixelNumber;

		// 返回百分制字符串
		return translateDoubleIntoPercent(RedPixelProportion);
	}

	/**
	 * 将浮点数转换为百分制
	 * @param d
	 * @return
	 */
	public static String translateDoubleIntoPercent(double d) {
		BigDecimal bDecimal = new BigDecimal(d);
		bDecimal = bDecimal.setScale(4, BigDecimal.ROUND_HALF_UP);
		DecimalFormat dFormat = new DecimalFormat("0.00%");
		String result = dFormat.format(bDecimal.doubleValue());
		return result;
	}


	public static void main(String[] args) throws IOException {
		String probability = null;
		try {
			probability = calculateRed("C:\\Users\\yccqw\\Desktop\\QQ图片20220328084643.png");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("rgb提取红色视率:" + probability);
	}
}
