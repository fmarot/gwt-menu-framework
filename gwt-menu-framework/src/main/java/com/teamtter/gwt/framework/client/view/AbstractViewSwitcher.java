package com.teamtter.gwt.framework.client.view;

import com.google.gwt.place.shared.PlaceController;
import com.google.inject.Inject;
import com.teamtter.gwt.framework.client.history.MenuPlace;
import com.teamtter.gwt.framework.client.presenter.MenuWrappedPresenter;
import com.teamtter.gwt.framework.client.presenter.Presenter;
import com.teamtter.gwt.framework.client.resolver.PresenterResolver;

/**
 * Derive from this base class if you want to be able to force the
 * display of any Presenter at any moment. Classic usage is:<br>
 * - you derive from this class<br>
 * - you inject the eventBus in your constructor<br>
 * - you register events on the bus<br>
 * - you react to events by calling {@link #replaceCurrentViewWithPresenter(Presenter)}
 */
public abstract class AbstractViewSwitcher {

    @Inject
    private PresenterResolver presenterResolver;

    @Inject
    private PlaceController placeController;

    public void replaceCurrentViewWithPresenter(MenuWrappedPresenter presenter) {
        String key = presenterResolver.getKeyByPresenter(presenter);
        placeController.goTo(new MenuPlace(key));
    }

    public void replaceCurrentViewWithPresenterByKey(String key) {
        presenterResolver.getPresenterByKey(key);
        placeController.goTo(new MenuPlace(key));
    }
    
    public void replaceCurrentViewWithPresenterAndHighLightMenu(MenuWrappedPresenter presenter, String key) {
        // replaceCurrentViewWithPresenter(presenter);
        // PrezGlobalConfiguration.highlightMenuByKey(key);
    }
    
    public void replaceCurrentViewWithPresenterAndHighLightMenu(MenuWrappedPresenter presenter, String firstLevelMenuPosition, String secondLevelMenuPosition) {
        // replaceCurrentViewWithPresenter(presenter);
        // PrezGlobalConfiguration.highlightMenuByPosition(firstLevelMenuPosition, secondLevelMenuPosition);
    }
}
