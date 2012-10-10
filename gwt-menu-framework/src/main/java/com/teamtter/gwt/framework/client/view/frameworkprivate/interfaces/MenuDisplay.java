package com.teamtter.gwt.framework.client.view.frameworkprivate.interfaces;

import java.util.List;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Widget;
import com.teamtter.gwt.framework.client.view.View;
import com.teamtter.gwt.framework.shared.menu.MenuItemDTO;

public interface MenuDisplay extends View, HasClickHandlersContainer {
    void add1stLevelMenuEntry(MenuItemDTO menuDto);
    void replaceSecondaryMenuItems(Widget secondaryMenuBar);
    Widget asWidget();
}