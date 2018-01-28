package de.oltzen.youtubevaadin.part3;

import com.vaadin.ui.*;
import com.vaadin.ui.Button.ClickEvent;

public class CalculatorForm extends FormLayout {
	
	TextField inputTF = new TextField("Input");
	TextField outputTF = new TextField("Output");
	
	String action;
	
	double result;
	
	public CalculatorForm() {
	
		Button plus = new Button("+");
		Button minus = new Button("-");
		Button mul = new Button("*");
		Button div = new Button("/");
		Button set = new Button("=");
		Button clr = new Button("clr");
		
		plus.addClickListener(e->doAction(e));
		minus.addClickListener(e->doAction(e));
		mul.addClickListener(e->doAction(e));
		div.addClickListener(e->doAction(e));
		set.addClickListener(e->doSet());
		clr.addClickListener(e->doClear());
		
		CssLayout buttonline = new CssLayout();
		buttonline.setCaption("Action");
		buttonline.addComponents(plus, minus, mul, div, set, clr);
		
		addComponents(outputTF, inputTF, buttonline);
	}

	private void doAction(ClickEvent e) {
		perfomAction(e.getButton().getCaption());
	}

	private void doClear() {
		inputTF.setValue("");
		outputTF.setValue("0.0");
		result = 0;
		action = null;
	}

	private void doSet() {
		perfomAction(null);
	}
	
	private void perfomAction(String nextaction) {
		double value = Double.parseDouble(inputTF.getValue());
		if (action == null) {
			result = value;
		} else if ("+".equals(action)) {
			result += value;
		}else if ("-".equals(action)) {
			result -= value;
		}else if ("*".equals(action)) {
			result *= value;
		}else if ("/".equals(action)) {
			result /= value;
		}
		action = nextaction;
		outputTF.setValue(""+result);
		inputTF.setValue("");
	}


}
