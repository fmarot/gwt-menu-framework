package com.teamtter.gwt.framework.client.presenter.frameworkprivate;

import java.util.HashMap;
import java.util.Map;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.Button;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.web.bindery.event.shared.EventBus;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.HasSelectHandlers;
import com.sencha.gxt.widget.core.client.info.Info;
import com.teamtter.gwt.framework.client.event.MenuSelectionEvent;
import com.teamtter.gwt.framework.client.history.MenuPlace;
import com.teamtter.gwt.framework.client.presenter.Presenter;
import com.teamtter.gwt.framework.client.resolver.PresenterResolver;
import com.teamtter.gwt.framework.client.service.FrameworkServiceAsync;
import com.teamtter.gwt.framework.client.view.frameworkprivate.interfaces.HasClickHandlersContainer;
import com.teamtter.gwt.framework.client.view.frameworkprivate.interfaces.MenuDisplay;
import com.teamtter.gwt.framework.client.view.frameworkprivate.interfaces.SecondLevelMenuView;
import com.teamtter.gwt.framework.shared.menu.FrameworkMenusDTO;
import com.teamtter.gwt.framework.shared.menu.MenuDTO;
import com.teamtter.gwt.framework.shared.menu.MenuItemDTO;

@Singleton
public class MenuPresenter implements Presenter, ClickHandler, SelectEvent.SelectHandler {
    
    private PresenterResolver presenterResolver;
    public FrameworkServiceAsync frkService;
    public MenuDisplay menuView;
    /** Maps a 1st level key to its subMenuBar */
    public Map<String, SecondLevelMenuView> secondaryMenuBars = new HashMap<String, SecondLevelMenuView>();
    private PlaceController placeController;
    
    @Inject
    private EventBus eventBus;
    
    @Inject
    public void initIt(final MenuDisplay menuView,
            PresenterResolver presenterResolver,
            FrameworkServiceAsync frkService,
            PlaceController placeController) {
        this.menuView = menuView;
        this.presenterResolver = presenterResolver;
        this.frkService = frkService;
        this.placeController = placeController;
        
        presenterResolver.init();
        
        frkService.getAllMenus(new AsyncCallback<FrameworkMenusDTO>() {
            public void onFailure(Throwable caught) {
            	caught.printStackTrace();
                Info.display("ERREUR", "unable to create menus..." + caught.getStackTrace().toString());
                // TODO: log !
            }

            public void onSuccess(FrameworkMenusDTO menus) {
                MenuDTO applicationMenu = menus.getApplicationMenu();
                Info.display("OK", "able to get menus :)" + applicationMenu.getMenuName());
                for (MenuItemDTO currFirstLevelItem : applicationMenu.getMenuItems()) {
                    menuView.add1stLevelMenuEntry(currFirstLevelItem);
                    SecondLevelMenuView secondLevelMenuBar = new SecondLevelMenuView();
                    for (MenuItemDTO subItem : currFirstLevelItem.getSubMenuItem()) {
                        secondLevelMenuBar.addButton(subItem);
                    }
                    secondaryMenuBars.put(currFirstLevelItem.getI18NKey(), secondLevelMenuBar);
                    bindToDisplayPresenter(secondLevelMenuBar);
                }
                bindToDisplayPresenter(menuView);
                bindToDisplaySecondLevelMenubar(menuView);
            }
        });
    }
    
    public void go(AcceptsOneWidget container) {
        container.setWidget(menuView.asWidget());
        // Display default Presenter
        Presenter defaultPresenter = presenterResolver.getDefaultPresenter();
//        forceDisplayPresenter(defaultPresenter);
        // if this Presenter is associated to a menu entry, maybe we should pre-select/highlight it ?
    }
    
    private void bindToDisplaySecondLevelMenubar(final MenuDisplay menuView) {
//        for (HasClickHandlers menuBtn : menuView.getHasClickHandlers()) {
//            menuBtn.addClickHandler(new ClickHandler() {
//                public void onClick(ClickEvent event) {
//                    String btnKey = ((Button)(event.getSource())).getText();
//                    SecondLevelMenuView secondLevelMenu = secondaryMenuBars.get(btnKey);
//                    menuView.replaceSecondaryMenuItems(secondLevelMenu);
//                }
//            });
//        }
        
        for (HasSelectHandlers menuBtn : menuView.getHasClickHandlers()) {
            menuBtn.addSelectHandler(new SelectEvent.SelectHandler() {
                public void onSelect(SelectEvent event) {
                    String btnKey = ((TextButton)(event.getSource())).getText();
                    SecondLevelMenuView secondLevelMenu = secondaryMenuBars.get(btnKey);
                    menuView.replaceSecondaryMenuItems(secondLevelMenu);
                }
            });
        }
    }
    
    /** Add listeners to view's widgets */
    public void bindToDisplayPresenter(HasClickHandlersContainer menuBar) {
//        for (HasClickHandlers menuBtn : menuBar.getHasClickHandlers()) {
//            menuBtn.addClickHandler(this);
//        }
        
        for (HasSelectHandlers menuBtn : menuBar.getHasClickHandlers()) {
            menuBtn.addSelectHandler(this);
        }
    }

    // utilisé si boutons GXT (pourquoi pas une interface commune avec GWT ?! :( )
    // voir ici: http://www.sencha.com/forum/showthread.php?187093-Why-is-there-inconsistent-use-of-HasSelectHandlers-HasClickHandlers
    // => le pattern reverse MVP serait peut etre plus adapté...
    public void onSelect(SelectEvent event) {
        String btnKey = ((TextButton)(event.getSource())).getText();    // FIXME: caca
        MenuSelectionEvent menuSelectEvent = buildMenuSelectionEvent(event);
        eventBus.fireEvent(buildMenuSelectionEvent(menuSelectEvent));
        if (menuSelectEvent.isCancelled()) {
            // do not switch page/presenter/place
        } else {
            placeController.goTo(new MenuPlace(btnKey));
        }
    }

    // utilisé si boutons GWT (pourquoi pas une interface commune avec GXT ?! :( )
    // voir ici: http://www.sencha.com/forum/showthread.php?187093-Why-is-there-inconsistent-use-of-HasSelectHandlers-HasClickHandlers
    // => le pattern reverse MVP serait peut etre plus adapté...    
    public void onClick(ClickEvent event) {
        String btnKey = ((Button)(event.getSource())).getText();    // FIXME: caca
        MenuSelectionEvent menuSelectEvent = buildMenuSelectionEvent(event);
        eventBus.fireEvent(menuSelectEvent);
        if (menuSelectEvent.isCancelled()) {
            // do not switch page/presenter/place
        } else {
            placeController.goTo(new MenuPlace(btnKey));
        }
    }
    
    private MenuSelectionEvent buildMenuSelectionEvent(GwtEvent event) {
        Object source = event.getSource();
        String btnKey = null;
        if (source instanceof TextButton) {
            btnKey = ((TextButton)source).getText();
        } else if (source instanceof TextButton) {
            btnKey = ((Button)source).getText();
        }
        MenuSelectionEvent result = new MenuSelectionEvent(btnKey);
        return result;
    }

}
