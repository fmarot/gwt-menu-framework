package com.teamtter.gwt.frameworksampleapp.client.view;


import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Singleton;

@Singleton
public class DefaultAppView extends Composite {
    interface MyUiBinder extends UiBinder<Widget, DefaultAppView> {
    }

    private static MyUiBinder uiBinder = GWT.create(MyUiBinder.class);

    public DefaultAppView() {
        initWidget(uiBinder.createAndBindUi(this));
    }
    
}



