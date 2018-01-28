package de.oltzen.youtubevaadin;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;
import com.vaadin.ui.MenuBar.Command;
import com.vaadin.ui.MenuBar.MenuItem;

import de.oltzen.youtubevaadin.part10.ArticleDialogTable;
import de.oltzen.youtubevaadin.part11.AccordionExample;
import de.oltzen.youtubevaadin.part11.TabExample;
import de.oltzen.youtubevaadin.part3.Calculator;
import de.oltzen.youtubevaadin.part3.CalculatorCss;
import de.oltzen.youtubevaadin.part3.CalculatorForm;
import de.oltzen.youtubevaadin.part4.CalculatorGrid;
import de.oltzen.youtubevaadin.part7.GridExample;
import de.oltzen.youtubevaadin.part8.ListArticle;
import de.oltzen.youtubevaadin.part9.TreeExample;
import de.oltzen.youtubevaadin.part9.TreeGridExample;


/**
 * This UI is the application entry point. A UI may either represent a browser
 * window (or tab) or some part of an HTML page where a Vaadin application is
 * embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is
 * intended to be overridden to add component to the user interface and
 * initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {

	VerticalLayout mainLayout = new VerticalLayout();

	Component actualComponent;

	@Override
	protected void init(VaadinRequest vaadinRequest) {

		mainLayout.setSizeFull();
		mainLayout.setMargin(false);
		
		Label title = new Label("Tom's Vaadin 8 Intro");
		title.setStyleName("title");
		mainLayout.addComponent(title);

		MenuBar mbar = new MenuBar();
		mbar.setWidth("100%");
		mainLayout.addComponent(mbar);

		MenuItem calc = mbar.addItem("Calculator", null);
		calc.addItem("Normal", e -> setMainComponent(new Calculator()));
		calc.addItem("Css", e -> setMainComponent(new CalculatorCss()));
		calc.addItem("Form", e -> setMainComponent(new CalculatorForm()));
		calc.addItem("Grid", e -> setMainComponent(new CalculatorGrid()));

		MenuItem stat = mbar.addItem("Static", null);
		stat .addItem("Normal", new MenuCommand(Calculator.class));
		stat .addItem("Css", new MenuCommand(CalculatorCss.class));
		stat .addItem("Form", new MenuCommand(CalculatorForm.class));
		stat .addItem("Grid", new MenuCommand(CalculatorGrid.class));

		MenuItem compitem = mbar.addItem("Component", null);
		compitem.addItem("Grid Example", new MenuCommand(GridExample.class));
		compitem.addItem("Edit Article", new MenuCommand(ListArticle.class));
		compitem.addItem("Tree", new MenuCommand(TreeExample.class));
		compitem.addItem("Tree Grid", new MenuCommand(TreeGridExample.class));
		compitem.addItem("Window Example", new MenuCommand(ArticleDialogTable.class));
		compitem.addItem("TabSheet Example", new MenuCommand(TabExample.class));
		compitem.addItem("Accordion Example", new MenuCommand(AccordionExample.class));
		
		setMainComponent(new VerticalLayout());
		setContent(mainLayout);
	}

	public void setMainComponent(Component comp) {
		if (actualComponent != null) {
//			if (comp.getClass() == actualComponent.getClass()) {
//				// Nothing to change
//				return;
//			}
			mainLayout.removeComponent(actualComponent);
		}
		mainLayout.addComponent(comp);
		mainLayout.setExpandRatio(comp, 1);
		actualComponent = comp;
	}

	@WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
	@VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
	public static class MyUIServlet extends VaadinServlet {
	}

	class MenuCommand implements Command {

		private Class myClass;

		private Component comp;

		MenuCommand(Class compclass) {
			myClass = compclass;
		}

		@Override
		public void menuSelected(MenuItem selectedItem) {

			if (comp == null)
				try {
					comp = (Component) myClass.newInstance();
				} catch (InstantiationException | IllegalAccessException e) {
					e.printStackTrace();
				}

			setMainComponent(comp);
		}
	}
}
