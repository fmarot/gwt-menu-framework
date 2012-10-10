package com.teamtter.gwt.frameworksampleapp.client.presenter;

/** Interface for EditContactPresenter as we used the "reverse-MVP" pattern */
public interface EditContactPresenterInterface {
    public void onSaveAction();

    /** can not name method simply onSave() because it would conflict with AbstractActivity::onSave :( */
    public void onCancelAction();

    public void ontTextChange();
    
    public void onSendWarningMessage();
}
