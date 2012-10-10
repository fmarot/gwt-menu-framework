package com.teamtter.gwt.frameworksampleapp.client.gin;

import com.google.gwt.core.client.GWT;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.teamtter.gwt.framework.client.gin.FrameworkPrezGinModule;
import com.teamtter.gwt.framework.client.resolver.PresenterResolver;
import com.teamtter.gwt.frameworksampleapp.client.resolver.AppPresenterResolver;
import com.teamtter.gwt.frameworksampleapp.client.service.ContactsService;
import com.teamtter.gwt.frameworksampleapp.client.service.ContactsServiceAsync;
import com.teamtter.gwt.frameworksampleapp.client.view.ContactsView;
import com.teamtter.gwt.frameworksampleapp.client.view.EditContactView;
import com.teamtter.gwt.frameworksampleapp.client.view.FirstLevelContactView;
import com.teamtter.gwt.frameworksampleapp.client.view.interfaces.ContactsDisplay;
import com.teamtter.gwt.frameworksampleapp.client.view.interfaces.EditContactDisplay;
import com.teamtter.gwt.frameworksampleapp.client.view.interfaces.FirstLevelContactDisplay;

/** here are configured how each instance returned by gin are configured */
public class AppGinModule extends FrameworkPrezGinModule {

    @Provides
    @Singleton
    public ContactsServiceAsync getContactsService() {
        return GWT.create(ContactsService.class);
    }
    
    @Override
    protected void configure() {
        super.configure();
        
        // App specific but each App *MUST* bind a PresenterResolver class
        bind(PresenterResolver.class).to(AppPresenterResolver.class).in(Singleton.class);
        
        // App specific views.
        bind(EditContactDisplay.class).to(EditContactView.class);
        bind(ContactsDisplay.class).to(ContactsView.class);
        bind(FirstLevelContactDisplay.class).to(FirstLevelContactView.class);
        
    }

}