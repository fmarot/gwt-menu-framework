package com.teamtter.gwt.frameworksampleapp.client.presenter;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.teamtter.gwt.framework.client.history.MenuPlace;
import com.teamtter.gwt.framework.client.presenter.AbstractMenuWrappedPresenter;
import com.teamtter.gwt.framework.client.resolver.PresenterResolver;
import com.teamtter.gwt.frameworksampleapp.client.view.interfaces.FirstLevelContactDisplay;

/**
 * This Presenter intends to showcase what can be done when a user clicks on a first-level menu item. This presenter
 * lists the available sub-pages as links
 */
@Singleton
public class FirstLevelContactPresenter extends AbstractMenuWrappedPresenter {

    private FirstLevelContactDisplay display;

    private final PlaceHistoryMapper placeMapper;

    @Inject
    public FirstLevelContactPresenter(FirstLevelContactDisplay display, PlaceHistoryMapper placeMapper) {
        this.display = display;
        this.placeMapper = placeMapper;

        // TODO: Hard wired sub-pages links. Any way to dynamically get all the subpages ? => framework task
        addLink("List");
        addLink("Add");
    }

    public void go(final AcceptsOneWidget container) {
        container.setWidget(display.asWidget());
    }

    private void addLink(final String key) {
        MenuPlace place = new MenuPlace(key);
        display.addLink(key, "#" + placeMapper.getToken(place));
    }

}
