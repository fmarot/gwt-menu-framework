package com.teamtter.gwt.frameworksampleapp.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Singleton;

@Singleton
public class TestGXTMenuDisplay  extends Composite {
    interface MyUiBinder extends UiBinder<Widget, TestGXTMenuDisplay> {
    }

    private static MyUiBinder uiBinder = GWT.create(MyUiBinder.class);

    public TestGXTMenuDisplay() {
        initWidget(uiBinder.createAndBindUi(this));
    }
    
}
