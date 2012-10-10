package com.teamtter.gwt.framework.client.event;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

/**
 * Event destiné à etre dispatché sur l'EventBus lors de la selection d'un item du menu principal.
 * A l'application d'en faire ce qu'elle veut. 
 **/
public class MenuSelectionEvent extends GwtEvent<MenuSelectionEventHandler> {
    public static Type<MenuSelectionEventHandler> TYPE = new Type<MenuSelectionEventHandler>();
    
    private String btnKey;
    private boolean cancelled = false;
    
    public MenuSelectionEvent(String btnKey) {
        this.btnKey = btnKey;
    }

    @Override
    public Type<MenuSelectionEventHandler> getAssociatedType() {
      return TYPE;
    }

    @Override
    protected void dispatch(MenuSelectionEventHandler handler) {
      handler.onMenuSelected(this);
    }
    
    public String getBtnKey() {
        return btnKey;
    }

    /** @return true if anyone has called {@link #cancelMenuSelection()} on this event */ 
    public boolean isCancelled() {
        return cancelled;
    }
    
    /** tell the framework that he must not handle the menuSelection. Someone else has already handled it */
    public void cancelMenuSelection() {
        cancelled = true;
    }
}
