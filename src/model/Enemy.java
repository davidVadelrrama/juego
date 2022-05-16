package model;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Enemy {

	private Canvas canvas;
	private GraphicsContext gc;
	
	private int x;
	private int y;
	
	public Enemy(Canvas canvas, int x, int y) {
		this.canvas = canvas;
		this.gc = canvas.getGraphicsContext2D();
		this.x = x;
		this.y = y;
	}
	
	public void paint() {
		gc.setFill(Color.WHITE);
		gc.fillRect(x, y, 30, 30);
	}
}
