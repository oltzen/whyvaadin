package de.oltzen.youtubevaadin.part7;

import java.util.Optional;

import com.vaadin.event.selection.SelectionEvent;
import com.vaadin.ui.*;

import de.oltzen.youtubevaadin.data.ArticleData;

public class GridExample extends VerticalLayout {
	
	public Grid<ArticleData> articleGrid = new Grid<>();
	
	TextField tax = new TextField("Tax");
	
	public GridExample () {
		
		Button b = new Button("Add List");
		b.addClickListener(e-> addListValues());
		
		articleGrid.addColumn(ArticleData::getName).setCaption("Name");
		articleGrid.addColumn(ArticleData::getArticleNo).setCaption("Article No");
		articleGrid.addColumn(ArticleData::getCost).setCaption("Netto");
		articleGrid.addColumn(ArticleData::getCost, cost ->""+( cost*1.19)).setCaption("Brutto");
		articleGrid.addColumn(ArticleData::isAvailable, e->e?"Yes":"No").setCaption("Available?");
		
		articleGrid.addSelectionListener(e -> show(e));
		
		
		articleGrid.setSizeFull();
		
		
		addComponents(b, tax, articleGrid);
		this.setExpandRatio(articleGrid, 1);
		this.setSizeFull();
	}

	private void addListValues() {
		articleGrid.setItems(ArticleData.getExampleList());
	}

	private void show(SelectionEvent<ArticleData> e) {
		Optional<ArticleData> a = e.getFirstSelectedItem();
		if (a.isPresent()) {
			tax.setValue(""+(a.get().getCost()*0.19));
		} else {
			tax.setValue("");
		}
	}

}
