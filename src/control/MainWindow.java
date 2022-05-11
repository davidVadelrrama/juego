package control;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import screens.BaseScreen;
import screens.ScreenA;
import screens.ScreenB;

public class MainWindow implements Initializable {

	@FXML
	private Canvas canvas;
	
	private GraphicsContext gc;

	public static int SCREEN = 0;

	private ArrayList<BaseScreen> screens;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		screens = new ArrayList<>();
		
		screens.add(new ScreenA(canvas));
		screens.add(new ScreenB(canvas));
		
		
		
		gc = canvas.getGraphicsContext2D();
		canvas.setFocusTraversable(true);
		
		new Thread(() -> {
			while (true) {
				// Code
				paint();
				pause(50);
			}
		}).start();

		initEvents();
	}

	private void paint() {
		screens.get(SCREEN).paint();
	}

	private void pause(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public void initEvents() {

		canvas.setOnMouseClicked(e -> {
			screens.get(SCREEN).onClick(e);

		});

		canvas.setOnKeyPressed(e -> {
			screens.get(SCREEN).onKey(e);
		});
		
		canvas.setOnKeyReleased(e -> {
			
		});
	}

}
