package com.teamtter.gwt.framework.shared.menu;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MenuDTO implements Serializable {
    public void setMenuItems(List<MenuItemDTO> menuItems) {
        this.menuItems = menuItems;
    }

    protected String menuName;
    protected List<MenuItemDTO> menuItems = new ArrayList<MenuItemDTO>();
    
    public MenuDTO() {
    }
    
    public MenuDTO(String menuName) {
        this.menuName = menuName;
    }
    
    public void addMenuItemDto(MenuItemDTO menuItemDto) {
        menuItems.add(menuItemDto);
    }
    
    public String getMenuName() {
        return menuName;
    }
    
    public List<MenuItemDTO> getMenuItems() {
        return menuItems;
    }

}
