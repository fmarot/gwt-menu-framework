package com.teamtter.gwt.framework.client.presenter.frameworkprivate;

import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;
import com.teamtter.gwt.framework.client.presenter.Presenter;
import com.teamtter.gwt.framework.client.view.frameworkprivate.interfaces.HeaderDisplay;

public class HeaderPresenter implements Presenter {
    @Inject
    private MenuPresenter menuPresenter;
    @Inject
    private HeaderDisplay headerView;

    public void go(AcceptsOneWidget container) {
        AcceptsOneWidget menuArea = headerView.getHeaderMenuPanel();
        menuPresenter.go(menuArea);
        
        container.setWidget(headerView.asWidget());
    }

}
