package com.teamtter.gwt.framework.client.activity;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.info.Info;
import com.teamtter.gwt.framework.client.history.MenuPlace;
import com.teamtter.gwt.framework.client.presenter.MenuWrappedPresenter;
import com.teamtter.gwt.framework.client.presenter.Presenter;
import com.teamtter.gwt.framework.client.resolver.FrameworkPresenterResolver;
import com.teamtter.gwt.framework.client.resolver.PresenterResolver;

/** AppActivityMapper associates each Place with its corresponding {@link Activity} */
public class FrameworkActivityMapper implements ActivityMapper {

    @Inject
    private PresenterResolver presenterResolver;

    public Activity getActivity(Place place) {
        MenuWrappedPresenter presenterToReturn = null;

        if (place instanceof MenuPlace) {
            MenuPlace menuPlace = (MenuPlace) place;
            String menuKey = menuPlace.getMenuKey();
            presenterToReturn = presenterResolver.getPresenterByKey(menuKey);
        }

        if (presenterToReturn == null) {
            Info.display("WARNING", "no Presenter/Activity found for " + place + "... => default one will be used...");
            presenterToReturn = presenterResolver.getDefaultPresenter();
        }

        return presenterToReturn;
    }

}
