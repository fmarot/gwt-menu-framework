package com.teamtter.gwt.framework.client.view.frameworkprivate;

import java.util.List;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.teamtter.gwt.framework.client.view.frameworkprivate.interfaces.HasClickHandlersContainer;
import com.teamtter.gwt.framework.shared.menu.MenuItemDTO;

public interface SecondLevelMenuDisplay extends HasClickHandlersContainer {

    public abstract void addButton(MenuItemDTO menuDto);

}