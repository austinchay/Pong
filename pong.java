// My first swing animation game
// Using Keylistener, MouseMotionListener
// Created By: Austin
// Created on: Dec 7

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class pong implements ActionListener, KeyListener, MouseMotionListener{
	// Properties
	JFrame theframe;
	pongpanel thepanel;
	Timer thetimer;
	
	// Methods
	public void actionPerformed(ActionEvent evt){
		if(evt.getSource() == thetimer){
			thepanel.repaint();
		}
	}
	public void keyReleased(KeyEvent evt){
		if(evt.getKeyCode() == 38){
			thepanel.blnGoUp = false;
		}else if(evt.getKeyCode() == 40){
			thepanel.blnGoDown = false;
		}
	}
	public void keyPressed(KeyEvent evt){
		System.out.println(evt.getKeyCode());
		if(evt.getKeyCode() == 38){
			thepanel.blnGoUp = true;
		}else if(evt.getKeyCode() == 40){
			thepanel.blnGoDown = true;
		}
	}
	public void keyTyped(KeyEvent evt){
		
	}
	// This is a overriden method for Mouse Motion Listener
	public void mouseMoved(MouseEvent evt){
		thepanel.intRect2Y = evt.getY();
		//System.out.println(evt.getY());
	}
	public void mouseDragged(MouseEvent evt){
		
	}
	
	// Constructor
	public pong(){
		theframe = new JFrame("Pong");
		thepanel = new pongpanel();
		thepanel.addMouseMotionListener(this);
		theframe.addKeyListener(this);
		thepanel.setPreferredSize(new Dimension(1280,640));
		thetimer = new Timer(1000/60, this);
		thetimer.start();
		
		theframe.setContentPane(thepanel);
		theframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		theframe.pack();
		theframe.setVisible(true);
	}
	
	// Main Method
	public static void main(String [] args){
		new pong();
	}
}
