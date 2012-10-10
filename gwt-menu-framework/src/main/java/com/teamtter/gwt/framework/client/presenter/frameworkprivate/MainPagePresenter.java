package com.teamtter.gwt.framework.client.presenter.frameworkprivate;

import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.teamtter.gwt.framework.client.presenter.Presenter;
import com.teamtter.gwt.framework.client.view.frameworkprivate.MainPageView;

@Singleton
public class MainPagePresenter implements Presenter {

    private MainPageView mainPageView;
    
    private HeaderPresenter headerPresenter;
    private FooterPresenter footerPresenter;
    
    @Inject
    public MainPagePresenter(MainPageView mainPageView,
            HeaderPresenter headerPresenter,
            FooterPresenter footerPresenter) {
        this.mainPageView = mainPageView;
        this.headerPresenter = headerPresenter;
        this.footerPresenter = footerPresenter;
        bind();
    }
    
    public AcceptsOneWidget getCenterPanel() {
        return mainPageView.getCenterPanel();
    }
    
    public void go(AcceptsOneWidget container) { 
        // On alloue au headerPresenter la place occupée dans le haut de la MainView
        AcceptsOneWidget headerPanel = mainPageView.getHeaderPanel();
        headerPresenter.go(headerPanel);
        
        // On alloue au footerPresenter la place occupée dans le bas de la MainView
        AcceptsOneWidget footerPanel = mainPageView.getFooterPanel();
        footerPresenter.go(footerPanel);
        
        // Le tout est positionné dans le container passé en parametre
        container.setWidget(mainPageView);
    }
    
    /** Add listeners to view's widgets */
    public void bind() {
    }
    
}
