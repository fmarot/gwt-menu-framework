//package com.teamtter.gwt.framework.client.config;
//
//import com.google.gwt.resources.client.ImageResource;
//import com.teamtter.gwt.framework.client.presenter.Presenter;
//import com.teamtter.gwt.framework.client.resolver.LinkPurpose;
//
//public interface PrezGlobalConfiguration {
//
//    public String getAppTitle();
//    public void setAppTitle(String appTitle);
//
//    public String getAppVersion();
//    public void setAppVersion(String appVersion);
//
//    public String getContextualHelpURI();
//    /** @deprecated kept for compatibility with fwk V1, use {@link #setSpecificPurposeUrl(LinkPurpose, String)} with LinkPurpose.HELP instead */
//    @Deprecated
//    public void setContextualHelpURI(String contextualHelpURI);
//    
//    /** use this method to specify a specific url for a specific link clicked 
//     * @param purpose for exemple LinkPurpose.HELP to specify application's help location
//     * @param url the url to point to */
//    public void setSpecificPurposeUrl(LinkPurpose purpose, String url);
//    
//    /** @param the image to be set as background in the application center panel */
//    public void setGlobalBackgroundImage(ImageResource img);
//    
//    /** Doit on vraiment concerver cette méthode ? Je pense que ca serait plutot à
//     * chaque vue de se mettre elle-même dans un centerLayout ou un truc du genre si besoin...
//     * @param height in CSS units (e.g. "10px", "15em")
//     */
//    // public setMainPanelWidth(String width);
//    
//    
//    // pas besoin de la méthode ci dessous, faire une classe dérivée de "AbstractViewSwitcher"
//    //public void forceDisplayPresenter(Presenter presenter);
//    public void highlightMenuByKey(String i18nKey); // TODO: donner la possibilité de highlight par position i/j ?
//}
