package com.teamtter.gwt.framework.client.gin;

import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;
import com.teamtter.gwt.framework.client.activity.FrameworkActivityMapper;
import com.teamtter.gwt.framework.client.history.DefaultMenuPlaceHistoryMapper;
import com.teamtter.gwt.framework.client.view.frameworkprivate.FooterView;
import com.teamtter.gwt.framework.client.view.frameworkprivate.HeaderView;
import com.teamtter.gwt.framework.client.view.frameworkprivate.MenuView;
import com.teamtter.gwt.framework.client.view.frameworkprivate.interfaces.FooterDisplay;
import com.teamtter.gwt.framework.client.view.frameworkprivate.interfaces.HeaderDisplay;
import com.teamtter.gwt.framework.client.view.frameworkprivate.interfaces.MenuDisplay;

/** here are configured how each instance returned by gin are configured */
public abstract class FrameworkPrezGinModule extends AbstractGinModule {

//    @Provides
//    @Singleton
//    public EventBus getEventBus() {
//        return new SimpleEventBus();
//    }

    // FIXME: cette méthode sert elle vraiment ???
    @Provides
    @Singleton
    public PlaceController getPlaceController(EventBus eventBus) {
      return new PlaceController(eventBus);
    }
    
    @Override
    protected void configure() {
        // "if anyone asks for an instance of this interface, provide an instance of this class"
        bind(EventBus.class).to(SimpleEventBus.class).in(Singleton.class);
        bind(PlaceHistoryMapper.class).to(DefaultMenuPlaceHistoryMapper.class).in(Singleton.class);
        bind(ActivityMapper.class).to(FrameworkActivityMapper.class).in(Singleton.class);
        
        // Framework views
        bind(MenuDisplay.class).to(MenuView.class);
        bind(HeaderDisplay.class).to(HeaderView.class);
        bind(FooterDisplay.class).to(FooterView.class);

        // bind(TotoInterface.class).to(TotoImpl.class);
        // bind(Toto.class).toProvider(TotoProvider.class);
        
//        bind(Presenter.class)
//            .annotatedWith(Names.named("Contacts"))
//            .to(ContactsPresenter.class);
//        bind(Presenter.class)
//            .annotatedWith(Names.named("Edit"))
//            .to(EditContactPresenter.class);
    }
    
//    protected void bindDefaultMenuHistoryMapper() {
//        bind(PlaceHistoryMapper.class).to(DefaultMenuPlaceHistoryMapper.class);
//    }

}