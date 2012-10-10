package com.teamtter.gwt.framework.client.view.frameworkprivate;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Singleton;
import com.teamtter.gwt.framework.client.view.frameworkprivate.interfaces.HeaderDisplay;

@Singleton
public class HeaderView extends Composite implements HeaderDisplay {
    
    interface MyUiBinder extends UiBinder<Widget, HeaderView> {}
    private static MyUiBinder uiBinder = GWT.create(MyUiBinder.class);


    @UiField
    protected AcceptsOneWidget headerMenuPanel;
    
    public Widget asWidget() {
        return this;
    }
    
    public HeaderView() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    public AcceptsOneWidget getHeaderMenuPanel() {
        return headerMenuPanel;
    }

}
