package com.fortune;

import org.apache.wicket.Component;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.WebPage;

public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;

	private Component PropertyUnitsGrid;
	public HomePage(final PageParameters parameters) {
		super(parameters);

//		add(new Label("version", getApplication().getFrameworkSettings().getVersion()));

		add(PropertyUnitsGrid = new PropertyUnitsGrid("PropertyUnitsGrid"));

		// TODO Add your page's components here

    }
}
