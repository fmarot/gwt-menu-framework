package com.teamtter.gwt.framework.client.history;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.inject.Inject;
import com.teamtter.gwt.framework.client.resolver.FrameworkPresenterResolver;

public class MenuPlace extends Place {
    private String menuKey;
    
    public MenuPlace(String menuKey) {
        this.menuKey = menuKey;
    }
    
    public String getMenuKey() {
        return menuKey;
    }
    
    public static class Tokenizer implements PlaceTokenizer<MenuPlace> {

        public MenuPlace getPlace(String token) {
            return new MenuPlace(token);
        }

        public String getToken(MenuPlace place) {
            return place.getMenuKey();
        }
    }
    
    public String toString() {
        return "Place::"+menuKey;
    }
    
}

