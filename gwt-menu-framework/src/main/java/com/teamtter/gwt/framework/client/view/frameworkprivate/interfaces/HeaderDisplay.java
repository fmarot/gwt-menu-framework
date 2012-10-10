package com.teamtter.gwt.framework.client.view.frameworkprivate.interfaces;

import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.Widget;
import com.teamtter.gwt.framework.client.view.View;

public interface HeaderDisplay extends View {
    public Widget asWidget();

    public AcceptsOneWidget getHeaderMenuPanel();
}
