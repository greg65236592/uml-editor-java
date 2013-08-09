package UMLMode;

import generalObj.Port;
import generalObj.basicObj.BasicObj;
import generalObj.lineObj.AssociationLine;
import generalObj.lineObj.LineObj;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.List;



import UMLFrameComponent.UMLCanvas;

public class AssociationMode extends UMLMode  {
	
	public AssociationMode(UMLCanvas canvas){
		super(canvas);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		super.mouseClicked(e);
		
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
		//save src port
		lineSrcPort = getMostClosedPort(getInRangeObj(e.getX(), e.getY()), e.getX(), e.getY());
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		//get the most closed port
		lineTarPort = getMostClosedPort(getInRangeObj(e.getX(), e.getY()), e.getX(), e.getY());
		
		//new a AssociationRel while release the mouse
		AssociationLine ass = new AssociationLine();
		ass.setPortSrc(lineSrcPort);
		ass.setPortTar(lineTarPort);
		umlCanvas.getShapeObjLis().add(ass);
		umlCanvas.repaint();
	}

}
