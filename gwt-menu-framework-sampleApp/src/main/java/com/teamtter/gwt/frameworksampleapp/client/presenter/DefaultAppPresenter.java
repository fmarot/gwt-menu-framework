package com.teamtter.gwt.frameworksampleapp.client.presenter;

import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.teamtter.gwt.framework.client.presenter.AbstractMenuWrappedPresenter;
import com.teamtter.gwt.frameworksampleapp.client.view.DefaultAppView;

@Singleton
public class DefaultAppPresenter extends AbstractMenuWrappedPresenter {

    @Inject
    private DefaultAppView view;
    
    public void go(AcceptsOneWidget container) {
        container.setWidget(view);
    }

}
