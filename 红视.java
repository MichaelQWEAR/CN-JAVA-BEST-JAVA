package ���澯��;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;

import javax.imageio.ImageIO;
public class ���� {


	// �����ɫ������ռ�������������ΪͼƬ���ļ�·��
	public static String calculateRed(String image) throws Exception {

		File file = new File(image);
		BufferedImage bi = null;
		double redCalculateR, redCalculateG, redCalculateB, redPreCalculateR = 0, redPreCalculateG = 0, redPreCalculateB = 0, grayLevel = 0;
		try {
			bi = ImageIO.read(file);
		} catch (Exception e) {
			e.printStackTrace();
		}

		//����
		int width = bi.getWidth();
		int height = bi.getHeight();

		//����������ʼ��
		int minx = bi.getMinX();
		int miny = bi.getMinY();

		//��ɫ���ص����
		long RedNumber = 0;


		int[] rgb = new int[3];// ����RGB�ռ�

		// ��ʼ�����������ص�
		for (int i = minx; i < width; i++) {
			for (int j = miny; j < height; j++) {

				// ��ǰ���ص�
				int pixel = bi.getRGB(i, j); 

				// ��ȡRGB��ֵ
				rgb[0] = (pixel & 0xff0000) >> 16;//R
			rgb[1] = (pixel & 0xff00) >> 8;//G
			rgb[2] = (pixel & 0xff);//B

			//ʹ��rgb�жϸ����ص��Ƿ�����ж�Ϊ��ɫ���ص�
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
			System.out.println("����");
		} 
		else {
			System.out.println("��û������");
		}
		// �����ص����
		long totalPixelNumber = width * height;

		// ��ȡ��������ʾ��ռ��
		double RedPixelProportion = (double) RedNumber / totalPixelNumber;

		// ���ذٷ����ַ���
		return translateDoubleIntoPercent(RedPixelProportion);
	}

	/**
	 * ��������ת��Ϊ�ٷ���
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
			probability = calculateRed("C:\\Users\\yccqw\\Desktop\\QQͼƬ20220328084643.png");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("rgb��ȡ��ɫ����:" + probability);
	}
}
