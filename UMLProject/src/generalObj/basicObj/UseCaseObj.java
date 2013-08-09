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

public class UseCaseObj implements BasicObj {

		//Class Unit attributes
		int useCaseWid = 120, useCaseHeight = 60;
		int posX, posY;
		//classUnit attributes
		String useCaseName = "Test";
		
		int selectMode = 0;
		
		Port upPort;
		Port downPort;
		Port leftPort;
		Port rightPort;
		
		UMLCanvas convas;
		
		public UseCaseObj(int x, int y, UMLCanvas convasIn){
			posX = x;
			posY = y; 
			convas = convasIn;	
		}
		
		public UseCaseObj(UMLCanvas convasIn){
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
			int leftPortX = posX, leftPortY = posY + 30;
			int rightPortX = posX + 120, rightPortY = posY + 30;
			int upPortX = posX + 60, upPortY = posY;
			int downPortX = posX +60, downPortY = posY + 60; 
			upPort = new Port(upPortX, upPortY);
			downPort = new Port(downPortX, downPortY);
			leftPort = new Port(leftPortX, leftPortY);
			rightPort = new Port(rightPortX, rightPortY);		
		}
		
		@Override
		public void setPortToNewPos() {
			int leftPortX = posX, leftPortY = posY + 30;
			int rightPortX = posX + 120, rightPortY = posY + 30;
			int upPortX = posX + 60, upPortY = posY;
			int downPortX = posX +60, downPortY = posY + 60; 
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
			return useCaseWid;
		}

		@Override
		public int getHeight() {
			// TODO Auto-generated method stub
			return useCaseHeight;
		}

		@Override
		public String getName() {
			// TODO Auto-generated method stub
			return useCaseName;
		}

		@Override
		public void setName(String newName) {
			useCaseName = newName;
			
		}

		@Override
		public int getSelectMode() {
			return selectMode;
		}

		@Override
		public void setSelectMode(int mode) {
			selectMode = mode;
		}
		
		@Override
		public void drawSelfOut(Graphics g) {
			Graphics2D g2 = (Graphics2D)g;
			g2.setFont(new Font("·s²Ó©úÅé", Font.BOLD, 12));
			
			UseCaseObj useCaseObj = UseCaseObj.this;
			g2.setColor(Color.WHITE);
			g2.fillOval(useCaseObj.getPosX(), useCaseObj.getPosY(), useCaseObj.getWidth(), useCaseObj.getHeight());
			g2.setColor(Color.BLACK);
			g.drawOval(useCaseObj.getPosX(), useCaseObj.getPosY(), useCaseObj.getWidth(), useCaseObj.getHeight());
			g2.drawString(useCaseObj.getName(), useCaseObj.getPosX() + 40, useCaseObj.getPosY() + 30);
			//if select mode is 1, unit prints it's ports
			if(useCaseObj.getSelectMode() == 1){
				g2.fillRect(useCaseObj.getPortDown().getPosX()-3, useCaseObj.getPortDown().getPosY()-3, 6, 6);
				g2.fillRect(useCaseObj.getPortUp().getPosX()-3, useCaseObj.getPortUp().getPosY()-3, 6, 6);
				g2.fillRect(useCaseObj.getPortLeft().getPosX()-3, useCaseObj.getPortLeft().getPosY()-3, 6, 6);
				g2.fillRect(useCaseObj.getPortRight().getPosX()-3, useCaseObj.getPortRight().getPosY()-3, 6, 6);
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
