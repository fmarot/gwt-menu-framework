package com.teamtter.gwt.frameworksampleapp.client.view;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.inject.Singleton;
import com.teamtter.gwt.frameworksampleapp.client.view.interfaces.FirstLevelContactDisplay;

@Singleton
public class FirstLevelContactView extends Composite implements FirstLevelContactDisplay {

    private FlexTable table;
    
    public FirstLevelContactView() {
        table = new FlexTable();
        initWidget(table);
    }
    
    public void addLink(String linkText, String url) {
        Anchor anchor = new Anchor(linkText, url);
        table.setWidget(table.getRowCount()+1, 0, anchor);
    }


}
