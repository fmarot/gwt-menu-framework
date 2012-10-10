package com.teamtter.gwt.framework.client.view.frameworkprivate.interfaces;

import com.google.gwt.user.client.ui.Widget;
import com.teamtter.gwt.framework.client.view.View;

public interface FooterDisplay extends View {
    Widget asWidget();
    void setUser(String user);
    //setPageId("Home/0");   //Format PageId/EnvId
    void setAppVersion(String appVersion);
}
