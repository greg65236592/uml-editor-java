package generalObj.lineObj;

import generalObj.Port;
import generalObj.ShapeObj;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.util.List;

public class GenerationLine implements LineObj {

	Port portSrc, portTar;
	
	
	public GenerationLine(int inSrcX, int inSrcY, int inTarX, int inTarY) {
		
	}
	
	public GenerationLine(){
		//default constructor
	}

	
	@Override
	public void drawSelfOut(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		GenerationLine gRel = GenerationLine.this;
		int srcX =  gRel.getPortSrc().getPosX(), 
				srcY = gRel.getPortSrc().getPosY(), 
				tarX = gRel.getPortTar().getPosX(), 
				tarY = gRel.getPortTar().getPosY();
		
		//the Java Math is calculating Trigonometric functions by "ARC" not angle's degree
		double radius = 20;
		double theta = Math.atan2(tarY - srcY, tarX - srcX);
		double x1, y1, x2, y2, x3, y3;
		x1 = tarX; y1 = tarY;
		x2 = tarX - radius*Math.cos(theta - 30*Math.PI/180); y2 = tarY - radius*Math.sin(theta - 30*Math.PI/180);
		x3 = tarX - radius*Math.cos(theta + 30*Math.PI/180); y3 = tarY - radius*Math.sin(theta + 30*Math.PI/180);
		int xArray[] = {(int)x1, (int)x2, (int)x3};
		int yArray[] = {(int)y1, (int)y2, (int)y3};
		g2.drawPolygon(xArray, yArray, 3);
		
		double lineEndX, lineEndY;
		lineEndX = tarX - radius*Math.cos(theta);
		lineEndY = tarY - radius*Math.sin(theta);	
		g.drawLine(gRel.getPortSrc().getPosX(), gRel.getPortSrc().getPosY(), 
				(int)lineEndX, (int)lineEndY);
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
