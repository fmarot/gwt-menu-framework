package com.teamtter.gwt.frameworksampleapp.client.gin;

import com.google.gwt.inject.client.GinModules;
import com.teamtter.gwt.framework.client.gin.FrameworkPrezGinjector;
import com.teamtter.gwt.frameworksampleapp.client.view.AppViewSwitcher;

/** Sample: in a class extending {@link FrameworkPrezGinjector} a Framework client app 
must define all the higher level accessors to root of dependency-injected objects */
//FIXME: plutot que d'etendre FrameworkPrezGinjector, on devrait sans doutes utiliser l'annotation
// de la façon suivante: @GinModules(AppGinModule.class, FrameworkPrezGinModule.class) ce qui
// éviterait d'avoir à dériver de classes du framework.
@GinModules(AppGinModule.class)
public interface AppGinjector extends FrameworkPrezGinjector {

    AppViewSwitcher getAppViewSwitcher();
    
}