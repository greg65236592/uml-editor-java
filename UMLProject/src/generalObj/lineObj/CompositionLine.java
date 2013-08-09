package generalObj.lineObj;

import generalObj.Port;
import generalObj.ShapeObj;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.util.List;

public class CompositionLine implements LineObj {

	Port portSrc, portTar;
	
	
	public CompositionLine(int inSrcX, int inSrcY, int inTarX, int inTarY) {

	}
	
	public CompositionLine(){
		//default constructor
	}

	
	@Override
	public void drawSelfOut(Graphics g) {
		CompositionLine comRel = CompositionLine.this;
		Graphics2D g2 = (Graphics2D)g;
		int srcX = comRel.getPortSrc().getPosX(), 
				srcY = comRel.getPortSrc().getPosY(),
				tarX = comRel.getPortTar().getPosX(),
				tarY = comRel.getPortTar().getPosY();
		
		//the Java Math is calculating Trigonometric functions by "ARC" not angle's degree
		double radius = 20;
		double theta = Math.atan2(tarY - srcY, tarX - srcX);
		double x1, y1, x2, y2, x3, y3, x4, y4;
		x1 = tarX; y1 = tarY;
		x2 = tarX - radius*Math.cos(theta - 30*Math.PI/180); y2 = tarY - radius*Math.sin(theta - 30*Math.PI/180);
		x3 = tarX - radius*Math.cos(theta + 30*Math.PI/180); y3 = tarY - radius*Math.sin(theta + 30*Math.PI/180);
		x4 = tarX - 2*radius*Math.cos(theta); y4 = tarY - 2*radius*Math.sin(theta);	
		int xArray[] = {(int)x1, (int)x2, (int)x4, (int)x3};
		int yArray[] = {(int)y1, (int)y2, (int)y4, (int)y3};
		g2.drawPolygon(xArray, yArray, 4);
		
		double lineEndX, lineEndY;
		lineEndX = tarX - 2*radius*Math.cos(theta);
		lineEndY = tarY - 2*radius*Math.sin(theta);	
		g.drawLine(srcX, srcY, (int)lineEndX, (int)lineEndY);
	}

	@Override
	public Port getPortSrc() {
		// TODO Auto-generated method stub
		return portSrc;
	}

	@Override
	public Port getPortTar() {
		// TODO Auto-generated method stub
		return portTar;
	}
	
	@Override
	public void setPortSrc(Port port) {
		portSrc = port;
	}
	
	@Override
	public void setPortTar(Port port) {
		portTar = port;
	}

	@Override
	public void setSelectMode(int i) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getPosX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getPosY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Port getPortDown() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Port getPortRight() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Port getPortUp() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Port getPortLeft() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getSelectMode() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setPosY(int i) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPosX(int i) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPortToNewPos() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPort() {
		// TODO Auto-generated method stub
		
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
	public void setName(String newName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ShapeObj> getShapeObjLis() {
		// TODO Auto-generated method stub
		return null;
	}
}
