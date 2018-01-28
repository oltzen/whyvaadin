package de.oltzen.youtubevaadin.part4;

import com.vaadin.ui.*;

public class NumberInputComp extends GridLayout{
	
	private TextField inputTF;

	public NumberInputComp (TextField in) {
		super(3, 4);
		inputTF = in;
		this.addComponent(createButton("7"), 0,0);
		this.addComponent(createButton("8"), 1,0);
		this.addComponent(createButton("9"), 2,0);
		this.addComponent(createButton("4"), 0,1);
		this.addComponent(createButton("5"), 1,1);
		this.addComponent(createButton("6"), 2,1);
		this.addComponent(createButton("1"), 0,2);
		this.addComponent(createButton("2"), 1,2);
		this.addComponent(createButton("3"), 2,2);
		Button zero = createButton("0");
		zero.setSizeFull();
		addComponent(zero, 0,3,1,3);
		Button dot = createButton(".");
		dot.setSizeFull();
		addComponent(dot, 2,3);
	}
	
	private Button createButton(String val) {
		Button b = new Button(val);
		b.addClickListener(e->addValue(e.getButton().getCaption()));
		return b;
	}
	
	private void addValue(String val) {
		inputTF.setValue(inputTF.getValue()+val);
	}
}
