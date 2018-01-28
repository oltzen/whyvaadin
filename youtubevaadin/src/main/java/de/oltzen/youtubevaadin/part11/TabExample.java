package de.oltzen.youtubevaadin.part11;

import com.vaadin.ui.*;

import de.oltzen.youtubevaadin.AppEnvironment;
import de.oltzen.youtubevaadin.part10.ArticleDialogTable;
import de.oltzen.youtubevaadin.part11.article.ListArticle;
import de.oltzen.youtubevaadin.part4.CalculatorGrid;
import de.oltzen.youtubevaadin.part7.GridExample;
import de.oltzen.youtubevaadin.part9.TreeExample;

public class TabExample extends VerticalLayout {
	
	public TabExample() {
		TabSheet ts = new TabSheet();
		ts.addTab(new CalculatorGrid(), "Calculator");
		ts.addTab(new ArticleDialogTable()).setCaption("Article Dialog");
		ts.addTab(new TreeExample()).setCaption("Tree");
		VerticalLayout vl = new VerticalLayout();
		vl.setMargin(false);
		AppEnvironment env = new AppEnvironment(vl);
		ts.addTab(vl).setCaption("Article List");
		env.setMainComponent(new ListArticle(env));
		

		this.addComponent(ts);
		ts.setSizeFull();
		this.setSizeFull();
	}

}
