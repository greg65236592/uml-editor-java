package generalObj;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.List;

public interface ShapeObj {
	
	public void drawSelfOut(Graphics g);

	public void setSelectMode(int i);

	public int getPosX();

	public int getWidth();

	public int getPosY();

	public int getHeight();

	public Port getPortSrc();

	public Port getPortTar();

	public Port getPortDown();

	public Port getPortRight();

	public Port getPortUp();

	public Port getPortLeft();

	public int getSelectMode();

	public void setPosY(int i);

	public void setPosX(int i);

	public void setPortToNewPos();

	public void setPort();

	public void resetGroupMember(MouseEvent e);

	public void unSelectGroupMember();

	public void setName(String newName);

	public List<ShapeObj> getShapeObjLis();
	
	
}
