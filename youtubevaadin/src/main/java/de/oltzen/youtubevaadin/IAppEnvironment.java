package de.oltzen.youtubevaadin;

import com.vaadin.ui.Component;

public interface IAppEnvironment {
	
	/** Replace the main component on the screen. */
	void setMainComponent(Component comp);

}
