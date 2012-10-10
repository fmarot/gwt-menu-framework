package com.teamtter.gwt.frameworksampleapp.client.view.senchaborderlayout;

import java.util.List;

import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.web.bindery.event.shared.EventBus;
import com.teamtter.gwt.framework.client.presenter.AbstractMenuWrappedPresenter;
import com.teamtter.gwt.frameworksampleapp.client.service.ContactsServiceAsync;
import com.teamtter.gwt.frameworksampleapp.client.view.interfaces.ContactsDisplay;
import com.teamtter.gwt.frameworksampleapp.shared.ContactDetails;

@Singleton
public class BorderLayoutTestPresenter extends AbstractMenuWrappedPresenter {

    private List<ContactDetails> contactDetails;

    private final ContactsServiceAsync rpcService;
    private final EventBus eventBus;
    private ContactsDisplay display;
    
    @Inject
    private BorderLayoutExample senchaExempleView;


    @Inject
    public BorderLayoutTestPresenter(ContactsServiceAsync rpcService, EventBus eventBus, ContactsDisplay display) {
        this.rpcService = rpcService;
        this.eventBus = eventBus;
        this.display = display;
        bind();
    }

    public void bind() {
        
    }

    public void go(final AcceptsOneWidget container) {
        container.setWidget(senchaExempleView.asWidget());
       
    }

}
