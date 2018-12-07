import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

public class pongpanel extends JPanel{
	// Properties
	int intBallX = 640;
	int intBallY = 320;
	int intRectY = 320;
	int intRect2Y = 320;
	int intSpeed = 9;
	int intScoreA = 0;
	int intScoreB = 0;
	int intCount = 0;
	boolean blnGoDown = false;
	boolean blnGoUp = false;
	boolean blndirection = true;
	boolean blnmin = false;
	boolean blnmax = false;
	
	// Methods
	public void paintComponent(Graphics g){
		
		g.setColor(Color.BLACK);
		g.fillRect(0,0,1280,640);
		
		g.setColor(Color.ORANGE);
		// rect with key movement rect
		g.fillRect(80,intRectY,30,100);
		// rect with mouse movement rect2
		g.fillRect(1180,intRect2Y,30,100);
		g.setColor(Color.WHITE);
		g.fillOval(intBallX,intBallY,20,20);
		g.drawString(intScoreA + " ",280,0);
		g.drawString(intScoreB + " ",390,0);
		// true is left
		intCount += 1;
		if(intCount % 60 == 0){
		int intRandDirect = (int) (Math.random () * 2) + 1;
		if(intRandDirect == 2){
			blndirection = false;
		}else{
			blndirection = true;
		}
	}
		System.out.println(intRectY + " | X ball: " + intBallX + " | Y ball: " + intBallY);
		if(blndirection == true){
			if(intBallX < 115 && (intBallY >= intRectY && intBallY <= (intRectY + 100))){
				//System.out.println(intRectY + " | " + intBallX + " | " + intBallY);
					intBallX += 1;
					intBallY += 1;
					blndirection = false;
			}
		}
	
		if(intBallX > 1150 && (intBallY >= intRect2Y && intBallY <= (intRect2Y + 100))){
			//System.out.println(intRect2Y + " | " + intBallX  + " | " + intBallY);
			intBallX -= 1;
			intBallY -= 1;
			blndirection = true;
		}
	
	
		if (intBallY <= 0){
			blnmin = true;
			blnmax = false;
		}else if(intBallY >= 640){
				blnmax = true;
				blnmin = false;
			}
	if(blndirection == true){
		if(blnmin){
			System.out.println("min:" + intRect2Y + " | " + intBallX  + " | " + intBallY);
			intBallX -= intSpeed;
			intBallY += intSpeed;
		}else if(blnmax){
			System.out.println("max:" + intRect2Y + " | " + intBallX  + " | " + intBallY);
			intBallX -= intSpeed;
			intBallY -= intSpeed;
		}else{
			intBallX -= intSpeed;
			intBallY += intSpeed;
		}
	}
	if(blndirection == false){
		if(blnmin){
			System.out.println("min2:" + intRect2Y + " | " + intBallX  + " | " + intBallY);
			intBallX += intSpeed;
			intBallY += intSpeed;
		}else if(blnmax){
			System.out.println("max2:" + intRect2Y + " | " + intBallX  + " | " + intBallY);
			intBallX += intSpeed;
			intBallY -= intSpeed;
		}else{
			intBallX += 9;
		}
	}
		// rect with key movement
		if(blnGoDown){
			intRectY += intSpeed;
		}
		if(blnGoUp){
			intRectY -= intSpeed;
		}
		if((intBallX < 80 && intBallY < 640) || (intBallX < 80 && intBallY < 0)){
			System.out.println("BALL OUT:" + intScoreB + " | " + intBallX  + " | " + intBallY);
			intScoreB += 1;
			intBallX = 640;
			intBallY = 320;
			blnmin = false;
			blnmax = false;
			if(blndirection == true){
				blndirection = false;
			}else{
				blndirection = true;
			}
		}
		if((intBallX > 1180 && intBallY < 0) || (intBallX > 1180 && intBallY < 640)){
			intScoreA += 1;
			intBallX = 640;
			intBallY = 320;
			blnmin = false;
			blnmax = false;
			if(blndirection == true){
				blndirection = false;
			}else{
				blndirection = true;
			}
		}
	}
	// Constructor
	public pongpanel(){
		super();
	}



}
