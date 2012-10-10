package com.teamtter.gwt.framework.client.presenter;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.HasWidgets;
import com.sencha.gxt.widget.core.client.info.Info;


public abstract class AbstractMenuWrappedPresenter extends AbstractActivity implements MenuWrappedPresenter {

    /**
     * la méthode start des Activity est dispatchée vers la méthode go() plus classique dans un Presenter. A priori, pas
     * besoin de surcharger cette méthode dans les Presenter des applications
     */
    public void start(AcceptsOneWidget panel, EventBus eventBus) {
        go(panel);
        // Warning: on ignore completement l'eventBus car si une classe le veut, elle se l'injecte pas GIN
    }

    /**
     * Methode à surcharger si besoin de libérer de la mémoire (celle de la View ?), par exemple, une fois que
     * l'utilisateur passe sur une autre page.
     */
    public void onStop() {
        Info.display("onStop called", this.getClass().toString().substring(40));
    }

}
