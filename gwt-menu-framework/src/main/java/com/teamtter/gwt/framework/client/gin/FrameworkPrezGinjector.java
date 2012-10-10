package com.teamtter.gwt.framework.client.gin;

import com.google.gwt.inject.client.Ginjector;
import com.google.web.bindery.event.shared.EventBus;
import com.teamtter.gwt.framework.client.FrameworkController;
import com.teamtter.gwt.framework.client.presenter.frameworkprivate.MainPagePresenter;

//@GinModules(FrameworkPrezGinModule.class)
public interface FrameworkPrezGinjector extends Ginjector {
    FrameworkController getFrameworkController();
    EventBus getEventBus();
    MainPagePresenter getMainPagePresenter();
//    PrezGlobalConfiguration getConfiguration();
}