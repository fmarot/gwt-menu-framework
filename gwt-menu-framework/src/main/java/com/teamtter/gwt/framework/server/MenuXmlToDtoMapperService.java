package com.teamtter.gwt.framework.server;

import java.util.ArrayList;
import java.util.List;

import com.teamtter.gwt.framework.client.menu.jaxb.Menu;
import com.teamtter.gwt.framework.client.menu.jaxb.MenuItem;
import com.teamtter.gwt.framework.client.menu.jaxb.UserRight;
import com.teamtter.gwt.framework.shared.menu.FrameworkMenusDTO;
import com.teamtter.gwt.framework.shared.menu.MenuDTO;
import com.teamtter.gwt.framework.shared.menu.MenuItemDTO;

/** Utility class to map Menu (from XML file) into a nice FrameworkMenusDTO object */
public class MenuXmlToDtoMapperService {
    
    public FrameworkMenusDTO map(List<Menu> xmlMenuList) {
        List<MenuDTO> DtoMenuList = mapMenuListXmlToMenuListDto(xmlMenuList);
        FrameworkMenusDTO allMenus = new FrameworkMenusDTO(DtoMenuList);
        return allMenus;
    }
    
    // TODO: virer toute cette daube et utiliser DOZER !
    
    /** Les 3 menus principaux de l'appli (header, main, footer) */
    private List<MenuDTO> mapMenuListXmlToMenuListDto(List<Menu> xmlMenuList) {
        List<MenuDTO> menusAsDto = new ArrayList<MenuDTO>();
        for (Menu currMenu : xmlMenuList) {
            MenuDTO menuDTO = mapMenuXmlToMenuDto(currMenu);
            menusAsDto.add(menuDTO);
        }
        return menusAsDto;
    }

    /** Map l'element de 1er niveau d'un menu */
    private MenuDTO mapMenuXmlToMenuDto(Menu menuXml) {
        MenuDTO menuDto = new MenuDTO(menuXml.getMenuName());
        List<MenuItem> xmlMenuItems = menuXml.getMenuItem();
        List<MenuItemDTO> menuItemsDto = mapMenuItemXmlToMenuItemDto(xmlMenuItems);
        menuDto.setMenuItems(menuItemsDto);
        return menuDto;
    }

    /** Recursivity OK: can handle infinite levels of MenuItem */
    private List<MenuItemDTO> mapMenuItemXmlToMenuItemDto(List<MenuItem> xmlMenuItems) {
        List<MenuItemDTO> result = new ArrayList<MenuItemDTO>();
        for (MenuItem currMenuItem : xmlMenuItems) {
            MenuItemDTO unitaryDtoResult = new MenuItemDTO();
            unitaryDtoResult.setI18NKey(currMenuItem.getI18NKey());
//            unitaryDtoResult.setUserRights(getUserRightsAsStringList(currMenuItem.getUserRight()));            
            unitaryDtoResult.setSubMenuItem(mapSubMenuItems(currMenuItem.getMenuItem()));
            // unitaryDtoResult.setText("xxx") sera fait par ailleurs, ici on ne fait que mapper (pour separation of concerns)
            result.add(unitaryDtoResult);
        }
        return result;
    }

    private List<MenuItemDTO> mapSubMenuItems(List<MenuItem> innerLevelXmlMenuItems) {
        List<MenuItemDTO> innerLevelMenuItemsDto = new ArrayList<MenuItemDTO>();
        if (innerLevelXmlMenuItems != null && !innerLevelXmlMenuItems.isEmpty()) {
            innerLevelMenuItemsDto = mapMenuItemXmlToMenuItemDto(innerLevelXmlMenuItems);
        }
        return innerLevelMenuItemsDto;
    }

    private List<String> getUserRightsAsStringList(List<UserRight> rights) {
        List<String> stringRights = new ArrayList<String>();
        for (UserRight currRight : rights) {
            stringRights.add(currRight.getUserRightName());
        }
        return stringRights;
    }

}
