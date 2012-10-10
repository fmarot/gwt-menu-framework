package com.teamtter.gwt.frameworksampleapp.client.presenter;

import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.teamtter.gwt.framework.client.presenter.AbstractMenuWrappedPresenter;
import com.teamtter.gwt.frameworksampleapp.client.view.TestGXTMenuDisplay;

@Singleton
public class TestGXTMenuPresenter extends AbstractMenuWrappedPresenter {

    private TestGXTMenuDisplay display;

    @Inject
    public TestGXTMenuPresenter(TestGXTMenuDisplay display) {
        this.display = display;
        bind();
    }

    public void bind() {
    }

    public void go(final AcceptsOneWidget container) {
        container.setWidget(display.asWidget());
    }

}
