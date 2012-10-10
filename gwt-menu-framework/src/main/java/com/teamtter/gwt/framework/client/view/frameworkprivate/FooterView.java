package com.teamtter.gwt.framework.client.view.frameworkprivate;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.teamtter.gwt.framework.client.view.frameworkprivate.interfaces.FooterDisplay;

public class FooterView extends Composite implements FooterDisplay {

    interface MyUiBinder extends UiBinder<Widget, FooterView> {}
    private static MyUiBinder uiBinder = GWT.create(MyUiBinder.class);


    @UiField
    protected SpanElement appVersion;
    
    @UiField
    protected SpanElement user;
    
    public Widget asWidget() {
        return this;
    }

    public void setUser(String user) {
        this.user.setInnerText(user);
    }

    public void setAppVersion(String appVersion) {
        this.appVersion.setInnerText(appVersion);
    }

}
