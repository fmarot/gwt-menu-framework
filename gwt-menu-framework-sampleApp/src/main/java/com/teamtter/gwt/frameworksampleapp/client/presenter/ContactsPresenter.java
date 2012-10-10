package com.teamtter.gwt.frameworksampleapp.client.presenter;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.web.bindery.event.shared.EventBus;
import com.teamtter.gwt.framework.client.presenter.AbstractMenuWrappedPresenter;
import com.teamtter.gwt.frameworksampleapp.client.event.AddContactEvent;
import com.teamtter.gwt.frameworksampleapp.client.event.EditContactEvent;
import com.teamtter.gwt.frameworksampleapp.client.service.ContactsServiceAsync;
import com.teamtter.gwt.frameworksampleapp.client.view.interfaces.ContactsDisplay;
import com.teamtter.gwt.frameworksampleapp.shared.ContactDetails;

@Singleton
public class ContactsPresenter extends AbstractMenuWrappedPresenter {

    private List<ContactDetails> contactDetails;

    private final ContactsServiceAsync rpcService;
    private final EventBus eventBus;
    private ContactsDisplay display;

    @Inject
    public ContactsPresenter(ContactsServiceAsync rpcService, EventBus eventBus, ContactsDisplay display) {
        this.rpcService = rpcService;
        this.eventBus = eventBus;
        this.display = display;
        bind();
    }

    public void bind() {
        display.getAddButton().addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                eventBus.fireEvent(new AddContactEvent());
            }
        });

        display.getDeleteButton().addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                deleteSelectedContacts();
            }
        });

        display.getList().addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                int selectedRow = display.getClickedRow(event);

                if (selectedRow >= 0) {
                    String id = contactDetails.get(selectedRow).getId();
                    eventBus.fireEvent(new EditContactEvent(id));
                }
            }
        });
    }

    public void go(final AcceptsOneWidget container) {
        container.setWidget(display.asWidget());
        fetchContactDetails();
    }

    public void sortContactDetails() {

        // Yes, we could use a more optimized method of sorting, but the
        // point is to create a test case that helps illustrate the higher
        // level concepts used when creating MVP-based applications.
        //
        for (int i = 0; i < contactDetails.size(); ++i) {
            for (int j = 0; j < contactDetails.size() - 1; ++j) {
                if (contactDetails.get(j).getDisplayName()
                        .compareToIgnoreCase(contactDetails.get(j + 1).getDisplayName()) >= 0) {
                    ContactDetails tmp = contactDetails.get(j);
                    contactDetails.set(j, contactDetails.get(j + 1));
                    contactDetails.set(j + 1, tmp);
                }
            }
        }
    }

    public void setContactDetails(List<ContactDetails> contactDetails) {
        this.contactDetails = contactDetails;
    }

    public ContactDetails getContactDetail(int index) {
        return contactDetails.get(index);
    }

    private void fetchContactDetails() {
        rpcService.getContactDetails(new AsyncCallback<ArrayList<ContactDetails>>() {
            public void onSuccess(ArrayList<ContactDetails> result) {
                contactDetails = result;
                sortContactDetails();
                List<String> data = new ArrayList<String>();

                for (int i = 0; i < result.size(); ++i) {
                    data.add(contactDetails.get(i).getDisplayName());
                }

                display.setData(data);
            }

            public void onFailure(Throwable caught) {
                Window.alert("Error fetching contact details");
            }
        });
    }

    private void deleteSelectedContacts() {
        List<Integer> selectedRows = display.getSelectedRows();
        ArrayList<String> ids = new ArrayList<String>();

        for (int i = 0; i < selectedRows.size(); ++i) {
            ids.add(contactDetails.get(selectedRows.get(i)).getId());
        }

        rpcService.deleteContacts(ids, new AsyncCallback<ArrayList<ContactDetails>>() {
            public void onSuccess(ArrayList<ContactDetails> result) {
                contactDetails = result;
                sortContactDetails();
                List<String> data = new ArrayList<String>();

                for (int i = 0; i < result.size(); ++i) {
                    data.add(contactDetails.get(i).getDisplayName());
                }

                display.setData(data);
            }

            public void onFailure(Throwable caught) {
                Window.alert("Error deleting selected contacts");
            }
        });
    }

}
