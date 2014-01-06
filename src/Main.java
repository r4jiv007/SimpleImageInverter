package com.my.imageditor;

public class Main {

	public static void main(String [] args){
			String path ="/home/rajiv/temp_work/image.png";
			ImageEditor myEditor = new ImageEditor(path);
			myEditor.changeColor();
			myEditor.writeImage("/home/rajiv/temp_work/image_inverted.png");
	}
}
