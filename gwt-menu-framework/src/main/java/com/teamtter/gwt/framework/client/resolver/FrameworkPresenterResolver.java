package com.teamtter.gwt.framework.client.resolver;

import java.util.HashMap;
import java.util.Map;

import com.teamtter.gwt.framework.client.presenter.MenuWrappedPresenter;
import com.teamtter.gwt.framework.client.presenter.Presenter;

public abstract class FrameworkPresenterResolver implements PresenterResolver {
    // Note: we could use Google's Guava lib to have a unique bidirectionnalmap instead of 2 Maps here
    protected Map<String, MenuWrappedPresenter> presentersByKey = new HashMap<String, MenuWrappedPresenter>();

    protected Map<MenuWrappedPresenter, String> keysByPresenter = new HashMap<MenuWrappedPresenter, String>();

    
    protected void addToList(String presenterKey, MenuWrappedPresenter presenter) {
        presentersByKey.put(presenterKey, presenter);
        keysByPresenter.put(presenter, presenterKey);
    }
    
    /** set a specific presenter in the app. For exemple, the admin Presenter may be available
     * only by a header or footer link handled by the framework(menu.xml). The framework
     * will match the purpose of this presenter with a specific i18nKey and display this
     * presenter when the link is clicked.
     * @param purpose the role of this presenter (will enable to find the link/menu Button to match)
     **/
    public void setSpecificPresenter(String purpose, MenuWrappedPresenter presenter) {
        // TODO
    }

    /** @returns the Presenter associated to the given key. May be null (if so, call {@link #getDefaultPresenter()}) */
    public MenuWrappedPresenter getPresenterByKey(String key) {
        MenuWrappedPresenter result = presentersByKey.get(key);
        return result;
    }
    
    public String getKeyByPresenter(MenuWrappedPresenter presenter) {
        String key = keysByPresenter.get(presenter);
        return key;
    }
    
    public abstract void init();
    /** Returns the presenter to be used at application init */
    public abstract MenuWrappedPresenter getDefaultPresenter();
}
