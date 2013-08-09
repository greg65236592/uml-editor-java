package generalObj.basicObj;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.util.List;

import generalObj.Port;
import generalObj.ShapeObj;
import UMLFrameComponent.UMLCanvas;

public class ClassObj implements BasicObj {
	//Class Unit attributes
	int clsUnitWid = 100, clsUnitLen = 120;
	int posX, posY;
	//classUnit attributes
	String clsUnitName = "Test";
	String attri1 = "Attribute1";
	String attri2 = "Attribute2";
	String attri3 = "Attribute3";
	String method1 = "method1()"; 
	String method2 = "method2()";
	String method3 = "method3()";
	
	int selectMode = 0;
	
	Port upPort;
	Port downPort;
	Port leftPort;
	Port rightPort;
	
	UMLCanvas convas;
	
	public ClassObj(int x, int y, UMLCanvas convasIn){
		posX = x;
		posY = y; 
		convas = convasIn;	
	}
	
	public ClassObj(UMLCanvas convasIn){
		convas = convasIn;
	}
	
	public Port getPortUp(){
		return upPort;
	}
	public Port getPortDown(){
		return downPort;
	}
	public Port getPortLeft(){
		return leftPort;
	}
	public Port getPortRight(){
		return rightPort;
	}
	
	public void setPort(){
		int leftPortX = posX, leftPortY = posY + 60;
		int rightPortX = posX + 100, rightPortY = posY +60;
		int upPortX = posX + 50, upPortY = posY;
		int downPortX = posX +50, downPortY = posY + 120; 
		upPort = new Port(upPortX, upPortY);
		downPort = new Port(downPortX, downPortY);
		leftPort = new Port(leftPortX, leftPortY);
		rightPort = new Port(rightPortX, rightPortY);		
	}
	
	public void setPortToNewPos(){
		int leftPortX = posX, leftPortY = posY + 60;
		int rightPortX = posX + 100, rightPortY = posY +60;
		int upPortX = posX + 50, upPortY = posY;
		int downPortX = posX +50, downPortY = posY + 120; 
		upPort.setPosX(upPortX);
		upPort.setPosY(upPortY);
		downPort.setPosX(downPortX);
		downPort.setPosY(downPortY);
		leftPort.setPosX(leftPortX);
		leftPort.setPosY(leftPortY);
		rightPort.setPosX(rightPortX);	
		rightPort.setPosY(rightPortY);	
	}

	@Override
	public int getPosX() {
		// TODO Auto-generated method stub
		return posX;
	}

	@Override
	public int getPosY() {
		// TODO Auto-generated method stub
		return posY;
	}

	@Override
	public void setPosX(int newX) {
		// TODO Auto-generated method stub
		posX = newX;
	}

	@Override
	public void setPosY(int newY) {
		// TODO Auto-generated method stub
		posY = newY;
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return clsUnitWid;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return clsUnitLen;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return clsUnitName;
	}

	@Override
	public void setName(String newName) {
		clsUnitName = newName;
	}

	@Override
	public int getSelectMode() {
		// TODO Auto-generated method stub
		return selectMode;
	}

	@Override
	public void setSelectMode(int mode) {
		// TODO Auto-generated method stub
		selectMode = mode;
	}

	@Override
	public void drawSelfOut(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		g2.setFont(new Font("·s²Ó©úÅé", Font.BOLD, 12));
		
		ClassObj clsObj = ClassObj.this;
		int posX = clsObj.getPosX();
		int posY = clsObj.getPosY();
		int clsUnitWid = 100, clsUnitLen = 120;
		String clsUnitName = clsObj.getName();
		String attri1 = "Attribute1";
		String attri2 = "Attribute2";
		String attri3 = "Attribute3";
		String method1 = "method1()"; 
		String method2 = "method2()";
		String method3 = "method3()";
		g2.setColor(Color.WHITE);
		g2.fillRect(posX, posY, clsUnitWid, clsUnitLen);
		g2.setColor(Color.BLACK);
		g2.drawRect(posX, posY, clsUnitWid, clsUnitLen);
		g2.drawString(clsUnitName, posX + 10, posY + 10); //set classUnit name 
		g2.drawString(attri1, posX + 10, posY + 30);//set classUnit attribue1
		g2.drawString(attri2, posX + 10, posY + 40);//set classUnit attribue2
		g2.drawString(attri3, posX + 10, posY + 50);//set classUnit attribue3
		g2.drawLine(posX, posY+20, posX+100, posY+20); //first line
		g2.drawLine(posX, posY+60, posX+100, posY+60); //second line
		g2.drawString(method1, posX + 10, posY + 70);//set classUnit method1
		g2.drawString(method2, posX + 10, posY + 80);//set classUnit method2
		g2.drawString(method3, posX + 10, posY + 90);//set classUnit method3
		
		//if select mode is 1, unit prints it's ports
		if(clsObj.getSelectMode() == 1){
			g2.fillRect(clsObj.getPortDown().getPosX()-3, clsObj.getPortDown().getPosY()-3, 6, 6);
			g2.fillRect(clsObj.getPortUp().getPosX()-3, clsObj.getPortUp().getPosY()-3, 6, 6);
			g2.fillRect(clsObj.getPortLeft().getPosX()-3, clsObj.getPortLeft().getPosY()-3, 6, 6);
			g2.fillRect(clsObj.getPortRight().getPosX()-3, clsObj.getPortRight().getPosY()-3, 6, 6);
		}
	}

	@Override
	public void killPort() {
		upPort = null;
		downPort = null;
		leftPort = null;
		rightPort = null;
	}

	@Override
	public Port getPortSrc() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Port getPortTar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void resetGroupMember(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void unSelectGroupMember() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ShapeObj> getShapeObjLis() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
