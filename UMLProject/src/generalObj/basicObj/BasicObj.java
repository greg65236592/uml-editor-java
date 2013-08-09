package generalObj.basicObj;

import generalObj.Port;
import generalObj.ShapeObj;

public interface BasicObj extends ShapeObj {

		
		public int getPosX();
		
		public int getPosY();
		
		public void setPosX(int newX);
		
		public void setPosY(int newY);
		
		public int getWidth();
		
		public int getHeight();
		
		public String getName();
		
		public void setName(String newName);
		
		public Port getPortUp();
		
		public Port getPortDown();
		
		public Port getPortLeft();
		
		public Port getPortRight();

		public void setPort();
		
		public void setPortToNewPos();
		
		public int getSelectMode();
		
		public void setSelectMode(int mode);
		
		public void killPort();

}
