package generalObj;

import generalObj.basicObj.BasicObj;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import UMLFrameComponent.UMLCanvas;

public class GroupUnit implements BasicObj {
	//GroupComponent attributes
	int posX, posY; 
	int posXInit, posYInit;
	int groupWid, groupHeight;
	//GroupComponent attributes
	String name = "Test Group";
	
	int selectMode = 0;
	
	Port upPort = new Port();
	Port downPort = new Port();
	Port leftPort = new Port();
	Port rightPort = new Port();
	
	UMLCanvas convas;
	List<ShapeObj> ShapeObjLis = new ArrayList<ShapeObj>();
	
	public GroupUnit(UMLCanvas convasIn){
		convas = convasIn;
	}
	
	public void addInGroup(ShapeObj basicObj){
		ShapeObjLis.add(basicObj);
	}
	
	public void deCompose(){
		
	}
	
	@Override
	public int getPosX() {
		return posX;
	}

	@Override
	public int getPosY() {
		return posY;
	}

	@Override
	public void setPosX(int newX) {
		posX = newX;
	}

	@Override
	public void setPosY(int newY) {
		posY = newY;
	}

	@Override
	public int getWidth() {
		return groupWid;
	}

	@Override
	public int getHeight() {
		return groupHeight;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String newName) {
		name = newName;
	}

	@Override
	public Port getPortUp() {
		return upPort;
	}

	@Override
	public Port getPortDown() {
		return downPort;
	}

	@Override
	public Port getPortLeft() {
		return leftPort;
	}

	@Override
	public Port getPortRight() {
		return rightPort;
	}

	@Override
	public void setPort() {
		int mostLeft, mostRight, mostUp, mostDown;
		//initialize the variable
		mostLeft = ((BasicObj)ShapeObjLis.get(1)).getPortLeft().getPosX();
		mostRight = ((BasicObj)ShapeObjLis.get(1)).getPortRight().getPosX();
		mostDown = ((BasicObj)ShapeObjLis.get(1)).getPortDown().getPosY();
		mostUp = ((BasicObj)ShapeObjLis.get(1)).getPortUp().getPosY();
		for(ShapeObj basicObj : ShapeObjLis){
			int left = ((BasicObj)basicObj).getPortLeft().getPosX();
			if(left < mostLeft){
				mostLeft = left;
			}
			int right = ((BasicObj)basicObj).getPortRight().getPosX();
			if(right > mostRight){
				mostRight = right;
			}
			int down = ((BasicObj)basicObj).getPortDown().getPosY();
			if(down > mostDown){
				mostDown = down;
			}
			int up = ((BasicObj)basicObj).getPortUp().getPosY();
			if(up < mostUp){
				mostUp = up;
			}
		}
		upPort.setPosX((mostLeft + mostRight)/2);
		upPort.setPosY(mostUp);
		leftPort.setPosX(mostLeft);
		leftPort.setPosY((mostDown + mostUp)/2);
		rightPort.setPosX(mostRight);
		rightPort.setPosY((mostDown + mostUp)/2);
		downPort.setPosX((mostLeft + mostRight)/2);
		downPort.setPosY(mostDown);
		
		groupWid = mostRight - mostLeft;
		groupHeight = mostDown - mostUp;
		
		posXInit = mostLeft;
		posYInit = mostUp;
	}
	
	@Override
	public void setPortToNewPos() {
		int mostLeft, mostRight, mostUp, mostDown;
		//initialize the variable
		mostLeft = ((BasicObj)ShapeObjLis.get(1)).getPortLeft().getPosX();
		mostRight = ((BasicObj)ShapeObjLis.get(1)).getPortRight().getPosX();
		mostDown = ((BasicObj)ShapeObjLis.get(1)).getPortDown().getPosY();
		mostUp = ((BasicObj)ShapeObjLis.get(1)).getPortUp().getPosY();
		for(ShapeObj basicObj : ShapeObjLis){
			int left = ((BasicObj)basicObj).getPortLeft().getPosX();
			if(left < mostLeft){
				mostLeft = left;
			}
			int right = ((BasicObj)basicObj).getPortRight().getPosX();
			if(right > mostRight){
				mostRight = right;
			}
			int down = ((BasicObj)basicObj).getPortDown().getPosY();
			if(down > mostDown){
				mostDown = down;
			}
			int up = ((BasicObj)basicObj).getPortUp().getPosY();
			if(up < mostUp){
				mostUp = up;
			}
		}
		upPort.setPosX((mostLeft + mostRight)/2);
		upPort.setPosY(mostUp);
		leftPort.setPosX(mostLeft);
		leftPort.setPosY((mostDown + mostUp)/2);
		rightPort.setPosX(mostRight);
		rightPort.setPosY((mostDown + mostUp)/2);
		downPort.setPosX((mostLeft + mostRight)/2);
		downPort.setPosY(mostDown);
		
		groupWid = mostRight - mostLeft;
		groupHeight = mostDown - mostUp;
		
		posXInit = mostLeft;
		posYInit = mostUp;
	}
	
	public void setInitPos(){
		posX = posXInit;
		posY = posYInit;
	}

	@Override
	public int getSelectMode() {
		return selectMode;
	}

	@Override
	public void setSelectMode(int mode) {
		selectMode= mode;
	}
	
	public List<ShapeObj> getShapeObjLis(){
		return ShapeObjLis;
	}

	@Override
	public void drawSelfOut(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		g2.setFont(new Font("·s²Ó©úÅé", Font.BOLD, 12));
		
		GroupUnit groupObj = GroupUnit.this;
		g2.drawRect(groupObj.getPosX(), groupObj.getPosY(), groupObj.getWidth(), groupObj.getHeight());
		if(groupObj.getSelectMode() == 1){
			g2.fillRect(groupObj.getPortDown().getPosX()-3, groupObj.getPortDown().getPosY()-3, 6, 6);
			g2.fillRect(groupObj.getPortUp().getPosX()-3, groupObj.getPortUp().getPosY()-3, 6, 6);
			g2.fillRect(groupObj.getPortLeft().getPosX()-3, groupObj.getPortLeft().getPosY()-3, 6, 6);
			g2.fillRect(groupObj.getPortRight().getPosX()-3, groupObj.getPortRight().getPosY()-3, 6, 6);
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
	
	public void resetGroupMember(MouseEvent e){
		int height = groupHeight;
		int width = groupWid;
		for(ShapeObj objInGroup : ShapeObjLis){
			//calculate displacement
			int disX = objInGroup.getPosX() - posX;
			int disY = objInGroup.getPosY() - posY;
			objInGroup.setPosX(e.getX() + disX - width/2);
			objInGroup.setPosY(e.getY() + disY - height/2);
			objInGroup.setPortToNewPos();
			
		}
	}
	
	public void unSelectGroupMember(){
		for(ShapeObj groupMember : ShapeObjLis){
			((BasicObj)groupMember).setSelectMode(0);
		}
	}

}
