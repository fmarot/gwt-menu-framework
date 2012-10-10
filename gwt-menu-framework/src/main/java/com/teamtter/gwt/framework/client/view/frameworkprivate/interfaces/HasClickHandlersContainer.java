package com.teamtter.gwt.framework.client.view.frameworkprivate.interfaces;

import java.util.List;

import com.sencha.gxt.widget.core.client.event.SelectEvent.HasSelectHandlers;

public interface HasClickHandlersContainer {
    List<? extends HasSelectHandlers> getHasClickHandlers();
}
