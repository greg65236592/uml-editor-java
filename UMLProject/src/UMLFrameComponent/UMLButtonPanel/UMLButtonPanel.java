package UMLFrameComponent.UMLButtonPanel;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

import UMLFrameComponent.UMLCanvas;
import UMLMode.UMLMode;

public class UMLButtonPanel extends JPanel{
	
	private UMLCanvas umlCanvas;
	
	private SelectButton selectButton;
	private ClassObjButton classObjButton;
	private UseCaseButton useCaseButton;
	private AssociationButton associationButton;
	private GeneralizationButton generalizationButton;
	private CompositionButton compositionButton;
	
	public UMLButtonPanel(UMLCanvas canvas){
		
		this.setLayout(new GridLayout(6, 1));
		
		umlCanvas = canvas;
		
		selectButton = new SelectButton(umlCanvas, this);
		classObjButton = new ClassObjButton(umlCanvas, this);
		useCaseButton = new UseCaseButton(umlCanvas, this);
		associationButton = new AssociationButton(umlCanvas, this);
		generalizationButton = new GeneralizationButton(umlCanvas, this);
		compositionButton = new CompositionButton(umlCanvas, this);
		
		this.add(selectButton);
		this.add(classObjButton);
		this.add(useCaseButton);
		this.add(associationButton);
		this.add(generalizationButton);
		this.add(compositionButton);
		
	}
	
	public void setAllButtonColorToWhite(){
		selectButton.setBackground(Color.WHITE);
		classObjButton.setBackground(Color.WHITE);
		useCaseButton.setBackground(Color.WHITE);
		associationButton.setBackground(Color.WHITE);
		generalizationButton.setBackground(Color.WHITE);
		compositionButton.setBackground(Color.WHITE); 
	}

}
