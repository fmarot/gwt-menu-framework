package com.teamtter.gwt.framework.client.service;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.teamtter.gwt.framework.shared.menu.FrameworkMenusDTO;

/**
 * Synchrone interface for Framework Presentation initialization 
 */
@RemoteServiceRelativePath("framework")
public interface FrameworkService extends RemoteService {

//    /** Utility class for simplifying access to the instance of async service. */
//    public static class Util {
//        private static FrameworkServiceAsync instance = null;
//
//        public static FrameworkServiceAsync getInstance() {
//            if (instance == null) {
//                instance = GWT.create(FrameworkService.class);
//            }
//            return instance;
//        }
//    }

    public String END_POINT = "framework";

    public FrameworkMenusDTO getAllMenus() throws Exception;
}
