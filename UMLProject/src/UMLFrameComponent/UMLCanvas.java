package UMLFrameComponent;

import generalObj.GroupUnit;
import generalObj.ShapeObj;
import generalObj.basicObj.BasicObj;
import generalObj.basicObj.ClassObj;
import generalObj.basicObj.UseCaseObj;
import generalObj.lineObj.AssociationLine;
import generalObj.lineObj.CompositionLine;
import generalObj.lineObj.GenerationLine;
import generalObj.lineObj.LineObj;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;


import UMLFrameComponent.UMLButtonPanel.UMLButtonPanel;
import UMLFrameComponent.UMLMenuBar.UMLMenuBar;
import UMLMode.SelectionMode;
import UMLMode.UMLMode;



public class UMLCanvas extends JPanel {
	
	List<ShapeObj> shapeObjLis = new ArrayList<ShapeObj>();

	private static UMLCanvas instance;
	
	private Container c;
	
	//for remove it every time I reset the currentMode
	private UMLMouseMotionListener umlMouseMotionListener;
	
	//record what is the current mode
	private UMLMode currentMode;

	private UMLCanvas(){
 
	}
	
	public static UMLCanvas getInstance() {
		 if(instance == null) {
	         instance = new UMLCanvas();
	     }
	     return instance;
	}
	
	public void initCanvas(){
		 //default mode
		 currentMode = new SelectionMode(this);
		 
		 //set listener
		 umlMouseMotionListener = new UMLMouseMotionListener(this, currentMode);
		 addMouseMotionListener(umlMouseMotionListener);		 
	     addMouseListener(umlMouseMotionListener);
		 
		 setBackground(Color.white);
		 setPreferredSize(new Dimension(500, 500));
		 setVisible(true);
	     
	}
	
	
	//paint in the Canvas
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		g2.setFont(new Font("·s²Ó©úÅé", Font.BOLD, 12));
		
		//paint all shape
		for(ShapeObj shapeObj : shapeObjLis){
			shapeObj.drawSelfOut(g);
		}
		
	}
		
	
	public List<ShapeObj> getShapeObjLis(){
		return shapeObjLis;
	}
	

	public void setCurrentMode(UMLMode newMode){
		currentMode = newMode;
		//remove listener or it will get more and more on canvas
		this.removeMouseListener(umlMouseMotionListener);
		this.removeMouseMotionListener(umlMouseMotionListener);
		umlMouseMotionListener = new UMLMouseMotionListener(this, currentMode);
		addMouseMotionListener(umlMouseMotionListener);		 
	    addMouseListener(umlMouseMotionListener);
	}
	
	public UMLMode getCurrentMode(){
		return currentMode;
	}

}
