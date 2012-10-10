package com.teamtter.gwt.frameworksampleapp.client.resolver;

import com.google.inject.Inject;
import com.teamtter.gwt.framework.client.presenter.MenuWrappedPresenter;
import com.teamtter.gwt.framework.client.resolver.FrameworkPresenterResolver;
import com.teamtter.gwt.framework.client.resolver.LinkPurpose;
import com.teamtter.gwt.frameworksampleapp.client.presenter.ContactsPresenter;
import com.teamtter.gwt.frameworksampleapp.client.presenter.DefaultAppPresenter;
import com.teamtter.gwt.frameworksampleapp.client.presenter.EditContactPresenter;
import com.teamtter.gwt.frameworksampleapp.client.presenter.FirstLevelContactPresenter;
import com.teamtter.gwt.frameworksampleapp.client.view.senchaborderlayout.BorderLayoutTestPresenter;

/** For each of the presenters to be used by the Framework after a menu click, you 
 * have to declare them here, associated with a key (usually the menu button's key). As
 * the Presenter are GIN-injected, their deps (view...) will be automatically injected */
public class AppPresenterResolver extends FrameworkPresenterResolver {
    @Inject
    private ContactsPresenter contactsPresenter;
    @Inject
    private EditContactPresenter editContactPresenter;
    @Inject
    private DefaultAppPresenter defaultAppPresenter;
    @Inject
    private FirstLevelContactPresenter firstLevelContactPresenter;
    
    @Inject
    private BorderLayoutTestPresenter borderLayoutTestPresenter;
    
    /** This is an exemple of an administration Presenter. TODO: implement its own class
     * instead of re-using 'EditContactPresenter' which is totally irrelevant here !
     * 'EditContactPresenter' is only used for demo purpose. */
    @Inject
    private EditContactPresenter adminPresenter;

    /** Inits the list of all presenter the app wants the Framework to
     * know about (those who may be used by the Framework's menu) */
    @Override
    public void init() {
        addToList("List", contactsPresenter);
        addToList("Add", editContactPresenter);
        addToList("Add (1)", editContactPresenter);
        addToList("Add (2)", editContactPresenter);
        addToList("Contacts", firstLevelContactPresenter);
        setSpecificPresenter(LinkPurpose.ADMIN, adminPresenter);
        setSpecificPresenter(LinkPurpose.HOME, getDefaultPresenter());

    }
    

    @Override
    public MenuWrappedPresenter getDefaultPresenter() {
        return borderLayoutTestPresenter;
    }
}
