package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import control.MainWindow;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import screens.BaseScreen;

public class Avatar {
	private Canvas canvas;
	private GraphicsContext gc;
	
	private int x=250;
	private int y=250;
	private Image avatar;
	
	
	public Avatar(Canvas canvas) {
		
		gc=canvas.getGraphicsContext2D();
		
		File file = new File("src/avatar/avatar2.png");
		System.out.println(file.exists());
		try {
			avatar = new Image(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void paint() {
		gc.drawImage(avatar, x, y);
		
	}

	public void moveYBy(int i) {
		this.y += i;
		
	}

	public void moveXBy(int i) {
		this.x += i;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	

	
	
	
	
	
	
}
