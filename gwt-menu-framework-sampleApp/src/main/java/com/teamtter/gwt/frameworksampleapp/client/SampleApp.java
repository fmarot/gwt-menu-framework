package com.teamtter.gwt.frameworksampleapp.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.teamtter.gwt.framework.client.FrameworkController;
import com.teamtter.gwt.frameworksampleapp.client.gin.AppGinjector;
import com.teamtter.gwt.frameworksampleapp.client.view.AppViewSwitcher;

public class SampleApp implements EntryPoint {
    
    private AppGinjector injector = GWT.create(AppGinjector.class);
    
    public void onModuleLoad() {
        FrameworkController mainController= injector.getFrameworkController();
        
        Panel rootPanel = null;
        rootPanel = RootLayoutPanel.get();

        // The view switcher here is intended to showcase its use but is not really needed
        // by a real app witout a real need for it (so you could comment the 2 line below)
        AppViewSwitcher myCustomViewSwitcher = injector.getAppViewSwitcher();
        mainController.addCustomViewSwitcher(myCustomViewSwitcher);
        
        mainController.go(rootPanel);
    }
    
    
}
