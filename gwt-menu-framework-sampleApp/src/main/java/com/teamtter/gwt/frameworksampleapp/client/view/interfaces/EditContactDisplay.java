package com.teamtter.gwt.frameworksampleapp.client.view.interfaces;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.Widget;
import com.teamtter.gwt.framework.client.view.ReversedMVPView;
import com.teamtter.gwt.framework.client.view.View;
import com.teamtter.gwt.frameworksampleapp.client.presenter.EditContactPresenterInterface;

public interface EditContactDisplay extends ReversedMVPView<EditContactPresenterInterface> {
    public HasValue<String> getFirstName();
    public HasValue<String> getLastName();
    public HasValue<String> getEmailAddress();
    public Widget asWidget();
    public void setPresenter(EditContactPresenterInterface presenter);
    public void enableSave();
    public void disableSave();
}