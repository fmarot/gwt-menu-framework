package com.teamtter.gwt.framework.client.view.frameworkprivate.interfaces;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.inject.Singleton;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.FlowLayoutContainer;
import com.sencha.gxt.widget.core.client.event.SelectEvent.HasSelectHandlers;
import com.teamtter.gwt.framework.client.view.frameworkprivate.SecondLevelMenuDisplay;
import com.teamtter.gwt.framework.shared.menu.MenuItemDTO;

@Singleton
public class SecondLevelMenuView extends Composite implements SecondLevelMenuDisplay {

    private List<HasSelectHandlers> menuItems = new ArrayList<HasSelectHandlers>();
    private FlowLayoutContainer menuBar = new FlowLayoutContainer();
    
    public SecondLevelMenuView() {
        initWidget(menuBar);    // Composite's method: makes this <-> decorator
    }

    public void addButton(MenuItemDTO menuDto) {
//        Button but = new Button(menuDto.getI18NKey());
        String text = menuDto.getI18NKey();
        TextButton but = new TextButton(text);
        menuBar.add(but);
        menuItems.add(but);
    }

    public List<? extends HasSelectHandlers> getHasClickHandlers() {
        return menuItems;
    }
}
