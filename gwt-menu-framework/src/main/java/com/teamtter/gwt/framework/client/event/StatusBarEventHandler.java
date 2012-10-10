package com.teamtter.gwt.framework.client.event;

import com.google.gwt.event.shared.EventHandler;

public interface StatusBarEventHandler extends EventHandler {
  void onStatusBarEvent(StatusBarEvent event);
}
