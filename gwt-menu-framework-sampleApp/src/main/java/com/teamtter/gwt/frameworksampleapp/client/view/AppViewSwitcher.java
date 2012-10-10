package com.teamtter.gwt.frameworksampleapp.client.view;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.web.bindery.event.shared.EventBus;
import com.sencha.gxt.widget.core.client.info.Info;
import com.teamtter.gwt.framework.client.view.AbstractViewSwitcher;
import com.teamtter.gwt.frameworksampleapp.client.event.AddContactEvent;
import com.teamtter.gwt.frameworksampleapp.client.event.AddContactEventHandler;
import com.teamtter.gwt.frameworksampleapp.client.presenter.EditContactPresenter;

/** WARNING: the sole purpose of this class is to show what can be done if
 * you want to EXPLICITLY switch a view upon receiving a specific event.
 * Most application SHOULD NOT DO THAT. Instead, it's you presenter that should
 * handle the work of displaying another sub-presenter's view inside its own main
 * view. So pure procedural Java, no eventBus. Usually, it should be left up
 * to the menu button to switch between main presenters. */
@Singleton
public class AppViewSwitcher extends AbstractViewSwitcher implements AddContactEventHandler {
	
    @Inject
    protected EditContactPresenter editContactPresenter;
    
    @Inject
    public AppViewSwitcher(EventBus eventBus) {
        eventBus.addHandler(AddContactEvent.TYPE, this);
    }
    
    public void onAddContact(AddContactEvent event) {
        Info.display("Event", "AddContactEvent received ! " + event);
        replaceCurrentViewWithPresenter(editContactPresenter);
    }
    
}
