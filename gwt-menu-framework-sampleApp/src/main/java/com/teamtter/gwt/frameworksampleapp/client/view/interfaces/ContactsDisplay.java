package com.teamtter.gwt.frameworksampleapp.client.view.interfaces;

import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Widget;
import com.teamtter.gwt.framework.client.view.View;

public interface ContactsDisplay extends View {
    HasClickHandlers getAddButton();
    HasClickHandlers getDeleteButton();
    HasClickHandlers getList();
    void setData(List<String> data);
    int getClickedRow(ClickEvent event);
    List<Integer> getSelectedRows();
    Widget asWidget();
}