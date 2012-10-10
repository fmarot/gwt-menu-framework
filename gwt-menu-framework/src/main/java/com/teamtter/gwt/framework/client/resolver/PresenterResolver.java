package com.teamtter.gwt.framework.client.resolver;

import com.teamtter.gwt.framework.client.presenter.MenuWrappedPresenter;
import com.teamtter.gwt.framework.client.presenter.Presenter;

public interface PresenterResolver {
    public MenuWrappedPresenter getPresenterByKey(String key);
    public MenuWrappedPresenter getDefaultPresenter();
    public String getKeyByPresenter(MenuWrappedPresenter presenter);
    public void init();
    
    
}
