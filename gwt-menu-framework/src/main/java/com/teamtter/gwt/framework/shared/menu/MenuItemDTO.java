package com.teamtter.gwt.framework.shared.menu;

import java.io.Serializable;
import java.util.List;

public class MenuItemDTO implements Serializable {

    protected String i18NKey;
    protected List<MenuItemDTO> subMenuItem;
//    protected List<String> userRights;
//    protected String text;

    public MenuItemDTO() {
    }

    public List<MenuItemDTO> getSubMenuItem() {
        return subMenuItem;
    }

    public void setSubMenuItem(List<MenuItemDTO> subMenuItem) {
        this.subMenuItem = subMenuItem;
    }

//    public List<String> getUserRights() {
//        return userRights;
//    }
//
//    public void setUserRights(List<String> userRights) {
//        this.userRights = userRights;
//    }
//
//    public String getText() {
//        return text;
//    }
//
//    public void setText(String text) {
//        this.text = text;
//    }

    public void setI18NKey(String i18nKey) {
        i18NKey = i18nKey;
    }

    public String getI18NKey() {
        return i18NKey;
    }
}
