package generalObj.lineObj;

import generalObj.Port;
import generalObj.ShapeObj;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.List;

public class AssociationLine implements LineObj {
	
	Port portSrc, portTar;
	
	
	public AssociationLine(int inSrcX, int inSrcY, int inTarX, int inTarY) {
		
	}
	
	public AssociationLine(){
		//default constructor
	}

	@Override
	public void drawSelfOut(Graphics g) {
		AssociationLine assRel = AssociationLine.this;
		
		//set source's XY

		g.drawLine(assRel.getPortSrc().getPosX(), assRel.getPortSrc().getPosY(), 
				assRel.getPortTar().getPosX(), assRel.getPortTar().getPosY());
	}

	@Override
	public Port getPortSrc() {
		return portSrc;
	}

	@Override
	public Port getPortTar() {
		return portTar;
	}
	
	public void setPortSrc(Port port) {
		portSrc = port;
	}

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
