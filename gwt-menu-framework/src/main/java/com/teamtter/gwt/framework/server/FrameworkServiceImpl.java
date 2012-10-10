package com.teamtter.gwt.framework.server;

import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.teamtter.gwt.framework.client.menu.jaxb.Menu;
import com.teamtter.gwt.framework.client.menu.jaxb.MenuConfiguration;
import com.teamtter.gwt.framework.client.service.FrameworkService;
import com.teamtter.gwt.framework.shared.menu.FrameworkMenusDTO;

/**
 * Initializes the framework at startup (menus).
 */
public class FrameworkServiceImpl extends RemoteServiceServlet implements FrameworkService {

    private static final String MENU_CONFIG_PROPERTY = "com.teamtter.gwt.presentation.gxt.menuConfig";


    public FrameworkMenusDTO getAllMenus() throws JAXBException {
        HttpServletRequest aRequest = getThreadLocalRequest();
        HttpSession session = aRequest.getSession();
//        Locale locale = initLocale(aRequest, session);
        FrameworkMenusDTO menus = getMenuList(session/*, locale*/);
        return menus;
    }
    
    private FrameworkMenusDTO getMenuList(HttpSession session/*, Locale locale*/) throws JAXBException {
        String menuConfigPath = session.getServletContext().getInitParameter(MENU_CONFIG_PROPERTY);
        MenuConfiguration menuConfiguration = unmarshallFromPath(menuConfigPath);
        List<Menu> xmlMenuList = menuConfiguration.getMenu();
        FrameworkMenusDTO allMenus = new MenuXmlToDtoMapperService().map(xmlMenuList);
        // TODO: filterAccordingToUserRights(allMenus);
        // TODO: initTextAccordingToLocale(allMenus)
        return allMenus;
    }

    private MenuConfiguration unmarshallFromPath(String path) throws JAXBException {
        InputStream menuInputStream = FrameworkServiceImpl.class.getResourceAsStream(path);
        if (menuInputStream == null) {
            // If not available from framework classloader, try current thread classloader
            menuInputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
        }
        JAXBContext jaxbContext = JAXBContext.newInstance(MenuConfiguration.class.getPackage().getName()); // "com.teamtter.gwt.framework.client.menu.jaxb"
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        MenuConfiguration mc = (MenuConfiguration) ((JAXBElement) unmarshaller.unmarshal(menuInputStream)).getValue();
        return mc;
    }
    
}
