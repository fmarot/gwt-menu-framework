package com.teamtter.gwt.framework.shared.menu;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Contains all app menus
 */
public class FrameworkMenusDTO implements Serializable {

    private static final String APP_MENU = "applicationMenu";
    private static final String HEADER_MENU = "headerMenu";
    private static final String FOOTER_MENU = "footerMenu";
    
    private List<MenuDTO> menus = new ArrayList<MenuDTO>();
    
    public FrameworkMenusDTO() {
    }
    
    public FrameworkMenusDTO(List<MenuDTO> menus) {
        this.menus = menus;
    }

    public MenuDTO getApplicationMenu() {
        return getMenu(APP_MENU);
    }
    
    public MenuDTO getHeaderMenu() {
        return getMenu(HEADER_MENU);
    }

    public MenuDTO getFooterMenu() {
        return getMenu(FOOTER_MENU);
    }
    
    private MenuDTO getMenu(String menuKey) {
        for (MenuDTO currMenuDto : menus) {
            String menuName = currMenuDto.getMenuName();
            if (menuName.equalsIgnoreCase(menuKey)) {
                return currMenuDto;
            }
        }
        // TODO: log error
        return null;
    }
}
