package com.teamtter.gwt.framework.client.view.frameworkprivate;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.FlowLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.event.SelectEvent.HasSelectHandlers;
import com.teamtter.gwt.framework.client.view.frameworkprivate.interfaces.MenuDisplay;
import com.teamtter.gwt.framework.shared.menu.MenuItemDTO;

@Singleton
public class MenuView extends Composite implements MenuDisplay {
    
    private List<HasSelectHandlers> mainMenuItems = new ArrayList<HasSelectHandlers>();
    private List<Button> secondaryMenuItems = new ArrayList<Button>(); // FIXME dynamic behavior !!!
    
    private VerticalLayoutContainer verticalLayout = new VerticalLayoutContainer();
    private FlowLayoutContainer firstMenuBar = new FlowLayoutContainer();
    private FlowLayoutContainer secondMenuBar = new FlowLayoutContainer();
    
    @Inject
    public MenuView() {
        verticalLayout.add(firstMenuBar);
        verticalLayout.add(secondMenuBar);
        initWidget(verticalLayout);    // Composite's method: makes this <-> decorator
    }
    
    public void replaceSecondaryMenuItems(Widget secondaryMenuBar) {
        verticalLayout.remove(1);
        verticalLayout.add(secondaryMenuBar);
    }

    public List<? extends HasClickHandlers> getMenuSecondaryItems() {
        // TODO ??? perhaps method is not needed...
        return null;
    }

    public void add1stLevelMenuEntry(MenuItemDTO menuDto) {
//        Button but = new Button(menuDto.getI18NKey());
        String text = menuDto.getI18NKey();
        TextButton but = new TextButton(text);
        mainMenuItems.add(but);
        firstMenuBar.add(but);
    }

    public List<? extends HasSelectHandlers> getHasClickHandlers() {
        return mainMenuItems;
    }

}
