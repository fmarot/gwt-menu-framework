package com.teamtter.gwt.framework.client.event;

import com.google.gwt.event.shared.GwtEvent;

/**
 * Event destiné à encapsuler un message apparaissant dans la StatusBar 
 */
public class StatusBarEvent extends GwtEvent<StatusBarEventHandler> {
    public static final Type<StatusBarEventHandler> TYPE = new Type<StatusBarEventHandler>();
    
    private String message;
    private StatusBarWarningLevel warningLevel;
    
    public StatusBarEvent(String message, StatusBarWarningLevel warningLevel) {
        this.message = message;
        this.warningLevel = warningLevel;
    }

    @Override
    public Type<StatusBarEventHandler> getAssociatedType() {
      return TYPE;
    }

    @Override
    protected void dispatch(StatusBarEventHandler handler) {
      handler.onStatusBarEvent(this);
    }

    public String getMessage() {
        return message;
    }

    public StatusBarWarningLevel getWarningLevel() {
        return warningLevel;
    }
    
}
