package UMLMode;

import generalObj.GroupUnit;
import generalObj.Port;
import generalObj.ShapeObj;
import generalObj.basicObj.BasicObj;
import generalObj.basicObj.ClassObj;
import generalObj.basicObj.UseCaseObj;
import generalObj.lineObj.LineObj;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.List;



import UMLFrameComponent.UMLCanvas;

public class ClassObjMode extends UMLMode  {

	public ClassObjMode(UMLCanvas canvas){
		super(canvas);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		super.mouseClicked(e);
		// (left click mouse)
		if (e.getButton() == MouseEvent.BUTTON1) {
			//add a class unit while click a button
			addNewClsObj(e.getX()-50, e.getY()-60);
			umlCanvas.repaint();
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		chosenObj = getInRangeObj(e.getX(), e.getY());	
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		//reset index
		chosenObj = null;
	}
	
    public void mouseDragged(MouseEvent e) {
    	if(chosenObj != null){
    			
	    	ShapeObj basicObj = chosenObj;
	    		
	    	basicObj.setPosX(e.getX() - basicObj.getWidth()/2);
		    basicObj.setPosY(e.getY() - basicObj.getHeight()/2);
		    basicObj.setPortToNewPos();
			umlCanvas.repaint();

	    	basicObj.resetGroupMember(e);
			umlCanvas.repaint();
	    		
	    			
		} 	
    	
     }
}
