package com.teamtter.gwt.frameworksampleapp.client.presenter;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.web.bindery.event.shared.EventBus;
import com.teamtter.gwt.framework.client.event.StatusBarEvent;
import com.teamtter.gwt.framework.client.event.StatusBarWarningLevel;
import com.teamtter.gwt.framework.client.presenter.AbstractMenuWrappedPresenter;
import com.teamtter.gwt.frameworksampleapp.client.event.ContactUpdatedEvent;
import com.teamtter.gwt.frameworksampleapp.client.event.EditContactCancelledEvent;
import com.teamtter.gwt.frameworksampleapp.client.service.ContactsServiceAsync;
import com.teamtter.gwt.frameworksampleapp.client.view.interfaces.EditContactDisplay;
import com.teamtter.gwt.frameworksampleapp.shared.Contact;

@Singleton
public class EditContactPresenter extends AbstractMenuWrappedPresenter implements EditContactPresenterInterface {

    private Contact contact;

    private final ContactsServiceAsync rpcService;

    private final EventBus eventBus;

    private EditContactDisplay display;

    private boolean canCancel = true;

    @Inject
    public EditContactPresenter(ContactsServiceAsync rpcService, EventBus eventBus, EditContactDisplay display) {
        this.contact = new Contact();
        this.rpcService = rpcService;
        this.eventBus = eventBus;
        this.display = display;
        display.setPresenter(this);
        display.disableSave();
    }

    public void go(final AcceptsOneWidget container) {
        container.setWidget(display.asWidget());
    }

    public void onCancelAction() {
        eventBus.fireEvent(new EditContactCancelledEvent());
    }

    public void onSaveAction() {
        contact.setFirstName(display.getFirstName().getValue());
        contact.setLastName(display.getLastName().getValue());
        contact.setEmailAddress(display.getEmailAddress().getValue());

        rpcService.updateContact(contact, new AsyncCallback<Contact>() {
            public void onSuccess(Contact result) {
                eventBus.fireEvent(new ContactUpdatedEvent(result));
            }

            public void onFailure(Throwable caught) {
                Window.alert("Error updating contact");
                canCancel = false;
            }
        });
        // now that it has been saved, the user can quit this Presenter with no warning
        canCancel = true;
    }

    public void displayUser(String id) {
        rpcService.getContact(id, new AsyncCallback<Contact>() {
            public void onSuccess(Contact result) {
                contact = result;
                EditContactPresenter.this.display.getFirstName().setValue(contact.getFirstName());
                EditContactPresenter.this.display.getLastName().setValue(contact.getLastName());
                EditContactPresenter.this.display.getEmailAddress().setValue(contact.getEmailAddress());
            }

            public void onFailure(Throwable caught) {
                Window.alert("Error retrieving contact");
            }
        });
    }

    public void ontTextChange() {
        if (allFieldsAreBlankOrEmpty()) {
            display.disableSave();
            canCancel = true;
        } else {
            display.enableSave();
            canCancel = false;
        }
    }

    private boolean allFieldsAreBlankOrEmpty() {
        String firstName = display.getFirstName().getValue();
        String lastName = display.getLastName().getValue();
        String mail = display.getEmailAddress().getValue();
        // Welcome Apache Commons StringUtils.isBlank(str)...
        boolean allBlanksOrEmpty = (firstName == null || firstName.trim().length() == 0)
                && (lastName == null || lastName.trim().length() == 0)
                && (mail == null || mail.trim().length() == 0);
        return allBlanksOrEmpty;
    }

    public String mayStop() {
        if (canCancel) {
            return null;
        } else {
            return "Abort current contact edition ?";
        }
    }

    public void onSendWarningMessage() {
        StatusBarEvent event = new StatusBarEvent("coucou status bar", StatusBarWarningLevel.WARN);
        eventBus.fireEvent(event);
    }

}
