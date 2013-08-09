package UMLFrameComponent;

import generalObj.GroupUnit;
import generalObj.Port;
import generalObj.ShapeObj;
import generalObj.basicObj.BasicObj;
import generalObj.basicObj.ClassObj;
import generalObj.basicObj.UseCaseObj;
import generalObj.lineObj.AssociationLine;
import generalObj.lineObj.CompositionLine;
import generalObj.lineObj.GenerationLine;
import generalObj.lineObj.LineObj;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.List;

import UMLMode.UMLMode;



public class UMLMouseMotionListener extends MouseMotionAdapter implements MouseListener {
	
	UMLCanvas umlCanvas;
	
	UMLMode currentMode;
	
	BasicObj chosenObj; //the chosen BasicObj
	
	//For multiple selection
	int mutiSelectFirstIndex; //if mutiSelectFirstIndex==-1, then when released the mouse there'll be multiple selection
	int multiSelectRangeX1, multiSelectRangeY1, multiSelectRangeX2, multiSelectRangeY2;
	
	Port lineSrcPort; //record the src port
	Port lineTarPort; //record the tar port
	
	String srcPortPos, tarPortPos; //for association port's position in string form
	
	
	public UMLMouseMotionListener(UMLCanvas importedConvas, UMLMode mode){
		umlCanvas = importedConvas;
		currentMode = mode;
	}
	
	// from MouseMotionListener
    public void mouseDragged(MouseEvent e) {
    	currentMode.mouseDragged(e);
    }
    	
  	
	@Override
	public void mouseClicked(MouseEvent e) {
		currentMode.mouseClicked(e);		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		currentMode.mousePressed(e);	
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		currentMode.mouseReleased(e);
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	 	
}
