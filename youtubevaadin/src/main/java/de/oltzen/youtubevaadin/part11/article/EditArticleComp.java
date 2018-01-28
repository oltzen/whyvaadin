package de.oltzen.youtubevaadin.part11.article;

import com.vaadin.data.*;
import com.vaadin.data.converter.StringToDoubleConverter;
import com.vaadin.data.validator.DoubleRangeValidator;
import com.vaadin.ui.*;

import de.oltzen.youtubevaadin.IAppEnvironment;
import de.oltzen.youtubevaadin.MyUI;
import de.oltzen.youtubevaadin.data.ArticleData;

public class EditArticleComp extends FormLayout{
	
	TextField name = new TextField("Name");
	
	TextField articleNo = new TextField("Article Number");
	
	TextField cost = new TextField("Cost");
	
	CheckBox available = new CheckBox("Available");
	
	private Component backComp;

	private IAppEnvironment env;
	
	public EditArticleComp(IAppEnvironment env, ArticleData article, Component back) {
		backComp = back;
		this.env = env;
		
		Binder<ArticleData>b = new Binder<>();
		b.setBean(article);
		b.forField(name).withValidator(text->text.length()>2, "To Short!").bind(ArticleData::getName, ArticleData::setName);
		b.bind(articleNo, ArticleData::getArticleNo, ArticleData::setArticleNo );
		b.bind(available, ArticleData::isAvailable, ArticleData::setAvailable);
		DoubleRangeValidator val = new DoubleRangeValidator("The value bust be float between 0.01-9999.99 (was {0}", 0.01, 9999.99);
		b.forField(cost).withConverter(new DoubleConverter()).withValidator(val). bind(ArticleData::getCost, ArticleData::setCost);
		
		Button backBut = new Button("Back");
		backBut.addClickListener(e->doBack());
		addComponents(name, articleNo, cost, available, backBut);
	}

	private void doBack() {
		env.setMainComponent(backComp);
	}

}
