package com.my.imageditor;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageEditor {
	private BufferedImage bImage;
	private File imageFile;
	private final int MAX = 255;
	private  int BLACK,WHITE,GREY;
	
	
	public ImageEditor(String imagePath){
		BLACK = new Color(0, 0, 0).getRGB();
		WHITE=new Color(255, 255, 255).getRGB();
		System.out.println(BLACK+"   "+WHITE);
		imageFile = new File(imagePath);
		try {
			bImage= ImageIO.read(imageFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void changeColor(){
		int height = bImage.getHeight();
		int width = bImage.getWidth();
		
		for(int i =0;i<width;i++){
			for(int j=0;j<height;j++){
				
				int rgb = bImage.getRGB(i, j);

				int red = ((rgb>>16) & 0xFF)^MAX;//((MAX>>16)& 0xFF);
				int green = ((rgb>>8) & 0xFF)^MAX;//((MAX>>8)& 0xFF);
				int blue = ((rgb) & 0xFF)^MAX;//((MAX)& 0xFF);
				if(red==0||green==0||blue==0)
				System.out.println(red+" "+green+" "+blue+"\n");
				rgb= new Color(red, green, blue).getRGB();
				bImage.setRGB(i, j, rgb);
			}
		}
	}
	
	public void writeImage(String pathname){
		File OPImage= new File(pathname);
		try {
			ImageIO.write(bImage, "png", OPImage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
