package de.oltzen.youtubevaadin.part11;

import com.vaadin.ui.*;

import de.oltzen.youtubevaadin.part10.ArticleDialogTable;
import de.oltzen.youtubevaadin.part4.CalculatorGrid;
import de.oltzen.youtubevaadin.part9.TreeExample;

public class AccordionExample extends VerticalLayout{
	
	public AccordionExample() {
		Accordion ts = new Accordion();
		ts.addTab(new CalculatorGrid(), "Calculator");
		ts.addTab(new ArticleDialogTable()).setCaption("Article Tabel");
		ts.addTab(new TreeExample()).setCaption("Tree");

		this.addComponent(ts);
		ts.setSizeFull();
		this.setSizeFull();
	}
}
