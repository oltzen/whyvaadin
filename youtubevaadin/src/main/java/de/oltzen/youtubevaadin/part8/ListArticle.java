package de.oltzen.youtubevaadin.part8;

import java.util.Optional;

import com.vaadin.event.selection.SelectionEvent;
import com.vaadin.ui.*;

import de.oltzen.youtubevaadin.MyUI;
import de.oltzen.youtubevaadin.data.ArticleData;

public class ListArticle extends VerticalLayout {

	public Grid<ArticleData> articleGrid = new Grid<>();

	public ListArticle() {

		articleGrid.addColumn(ArticleData::getName).setCaption("Name");
		articleGrid.addColumn(ArticleData::getArticleNo).setCaption("Article No");
		articleGrid.addColumn(ArticleData::getCost).setCaption("Netto");
		articleGrid.addColumn(ArticleData::getCost, cost -> "" + (cost * 1.19)).setCaption("Brutto");
		articleGrid.addColumn(ArticleData::isAvailable, e -> e ? "Yes" : "No").setCaption("Available?");

		articleGrid.addSelectionListener(e -> edit(e));

		articleGrid.setSizeFull();
		articleGrid.setItems(ArticleData.getExampleList());

		addComponents(articleGrid);
		this.setExpandRatio(articleGrid, 1);
		this.setSizeFull();
	}

	private void edit(SelectionEvent<ArticleData> e) {
		MyUI ui = (MyUI) UI.getCurrent();
		Optional<ArticleData> optArt = e.getFirstSelectedItem();
		if (optArt.isPresent())
			ui.setMainComponent(new EditArticleComp(optArt.get(), this));
	}

}
