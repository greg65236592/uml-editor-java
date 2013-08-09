package UMLFrameComponent;

import java.awt.BorderLayout;
import java.awt.Frame;

import javax.swing.JFrame;

import UMLFrameComponent.UMLButtonPanel.UMLButtonPanel;
import UMLFrameComponent.UMLMenuBar.UMLMenuBar;

public class UMLEditorFrame extends JFrame{
	
	private UMLCanvas umlCanvas;
	
	public UMLEditorFrame(){
		umlCanvas = UMLCanvas.getInstance();	
		umlCanvas.initCanvas();
		UMLEditorFrame.this.setSize(1920,1080);  
		UMLEditorFrame.this.setLocationRelativeTo(null);  
		UMLEditorFrame.this.setVisible(true); 
		UMLEditorFrame.this.setLayout(new BorderLayout());
		
		UMLEditorFrame.this.add(new UMLMenuBar(umlCanvas), BorderLayout.NORTH);
		UMLEditorFrame.this.add(new UMLButtonPanel(umlCanvas), BorderLayout.WEST);  
		UMLEditorFrame.this.add(umlCanvas, BorderLayout.CENTER);
		UMLEditorFrame.this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		UMLEditorFrame.this.setExtendedState(Frame.MAXIMIZED_BOTH); 
		
	}

}
