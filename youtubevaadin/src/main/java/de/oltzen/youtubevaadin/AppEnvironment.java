package de.oltzen.youtubevaadin;

import com.vaadin.ui.AbstractOrderedLayout;
import com.vaadin.ui.Component;

public class AppEnvironment implements IAppEnvironment {

	private AbstractOrderedLayout mainComponent;

	private Component embeddedComponent;

	public AppEnvironment(AbstractOrderedLayout mainComp) {
		mainComponent = mainComp;
	}

	@Override
	public void setMainComponent(Component comp) {
		if (comp != mainComponent) {
			if (embeddedComponent == null) {
				mainComponent.addComponent(comp);
			} else {
				mainComponent.replaceComponent(embeddedComponent, comp);
			}
			embeddedComponent = comp;
		}
	}

}
