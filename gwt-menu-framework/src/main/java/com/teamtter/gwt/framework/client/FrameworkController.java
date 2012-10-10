package com.teamtter.gwt.framework.client;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.teamtter.gwt.framework.client.history.MenuPlace;
import com.teamtter.gwt.framework.client.presenter.frameworkprivate.MainPagePresenter;
import com.teamtter.gwt.framework.client.service.FrameworkService;
import com.teamtter.gwt.framework.client.service.FrameworkServiceAsync;
import com.teamtter.gwt.framework.client.view.AbstractViewSwitcher;
import com.teamtter.gwt.framework.client.view.HasWidgetsToAcceptsOneWidgetWrapper;

/** Controller de plus haut niveau, encapsule le Presenter de la vue principale */
public class FrameworkController {

    private MainPagePresenter mainPagePresenter;
    private List<AbstractViewSwitcher> viewSwitchers = new ArrayList<AbstractViewSwitcher>();
    
    public static final FrameworkServiceAsync frameworkService = GWT.create(FrameworkService.class);
    private final EventBus eventBus;
    private final PlaceController placeController;
    private PlaceHistoryMapper historyMapper;
    private ActivityMapper activityMapper;

    
    @Inject
    public FrameworkController(MainPagePresenter mainPagePresenter,
            EventBus eventBus,
            PlaceController placeController,
            PlaceHistoryMapper historyMapper,
            ActivityMapper activityMapper) {
        this.mainPagePresenter = mainPagePresenter;
        this.eventBus = eventBus;
        this.placeController = placeController;
        this.historyMapper = historyMapper;
        this.activityMapper = activityMapper;
    }
    
    public void go(HasWidgets container) {
        
        // Start GWT's PlaceHistoryHandler with our PlaceHistoryMapper
        PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
        historyHandler.register(placeController, eventBus, new MenuPlace(null)/*defaultPlace*/);

        // Goes to place represented on URL or default place
        historyHandler.handleCurrentHistory();
        HasWidgetsToAcceptsOneWidgetWrapper wrappedContainer = new HasWidgetsToAcceptsOneWidgetWrapper(container);
        
        ActivityManager activityManager = new ActivityManager(activityMapper, eventBus);
        activityManager.setDisplay(mainPagePresenter.getCenterPanel());
        
        mainPagePresenter.go(wrappedContainer);
    }
    
    /** Ne sert pas à grand chose pour l'instant, à part donner au
     * Framework la connaissance explicite des ViewSwitcher */
    public void addCustomViewSwitcher(AbstractViewSwitcher viewSwitcher) {
        viewSwitchers.add(viewSwitcher);
    }
    
}
