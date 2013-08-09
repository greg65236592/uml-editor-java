package UMLMode;

import generalObj.GroupUnit;
import generalObj.Port;
import generalObj.ShapeObj;
import generalObj.basicObj.BasicObj;
import generalObj.basicObj.ClassObj;
import generalObj.basicObj.UseCaseObj;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;


import UMLFrameComponent.UMLCanvas;

public class UseCaseMode extends UMLMode  {

	public UseCaseMode(UMLCanvas canvas){
		super(canvas);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		super.mouseClicked(e);
		// (left click mouse)
		if (e.getButton() == MouseEvent.BUTTON1) {
			//add a UseCaseUnit unit while click a button
			addNewUseCaseObj(e.getX()-60, e.getY()-30);
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
			
    		ShapeObj shapeObj = chosenObj;
    		
			shapeObj.resetGroupMember(e);

			shapeObj.setPosX(e.getX() - shapeObj.getWidth()/2);
    		shapeObj.setPosY(e.getY() - shapeObj.getHeight()/2);
    		shapeObj.setPortToNewPos();
			umlCanvas.repaint();	
    	} 
    	
   }

}
