package com.teamtter.gwt.framework.client.view.frameworkprivate;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.web.bindery.event.shared.EventBus;
import com.teamtter.gwt.framework.client.event.StatusBarEvent;
import com.teamtter.gwt.framework.client.event.StatusBarEventHandler;
import com.teamtter.gwt.framework.client.view.frameworkprivate.interfaces.MainPageDisplay;

@Singleton
public class MainPageView extends Composite implements MainPageDisplay, StatusBarEventHandler {
    
    @UiTemplate("MainPageView-GWT.ui.xml")
//    @UiTemplate("MainPageView-GXT.ui.xml")
    // 'Widget' is the type returned by uiBinder.createAndBindUi
    // 'MainPageView' is the type whose @UiField annotated fields will be filled
    interface MyUiBinder extends UiBinder<Widget, MainPageView> {}
    
    private static MyUiBinder uiBinder = GWT.create(MyUiBinder.class);
    
    @UiField
    protected AcceptsOneWidget headerPanel;
    @UiField
    protected AcceptsOneWidget footerPanel;
    @UiField
    protected AcceptsOneWidget centerPanel;
//    @UiField
//    protected Label statusBarText;
    

    @Inject
    public MainPageView(MenuView menuView, EventBus eventBus) {
        initWidget(uiBinder.createAndBindUi(this));
        headerPanel.setWidget(menuView);
                
        eventBus.addHandler(StatusBarEvent.TYPE, this);
    }

    public AcceptsOneWidget getHeaderPanel() {
        return headerPanel;
    }

    public AcceptsOneWidget getFooterPanel() {
        return footerPanel;
    }

    public AcceptsOneWidget getCenterPanel() {
        return centerPanel;
    }

    public void onStatusBarEvent(StatusBarEvent event) {
//        statusBarText.setText(event.getWarningLevel() + " " + event.getMessage());
    }
    
}