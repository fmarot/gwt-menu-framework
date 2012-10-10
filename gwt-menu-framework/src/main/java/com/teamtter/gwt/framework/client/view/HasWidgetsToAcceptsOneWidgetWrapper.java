package com.teamtter.gwt.framework.client.view;

import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.IsWidget;

/**
 * Classe 'wrapper' destinée à faire passer un HasWidgets pour un 'AcceptsOneWidget'. Concretement, un conteneur pouvant
 * contenir plusieurs widget ne pourra plus en contenir qu'un seul apres avoir été wrappé par cette classe.
 */
public class HasWidgetsToAcceptsOneWidgetWrapper implements AcceptsOneWidget {
    private HasWidgets wrapped;

    public HasWidgetsToAcceptsOneWidgetWrapper(HasWidgets wrapped) {
        this.wrapped = wrapped;
    }

    public void setWidget(IsWidget widgetToAdd) {
        wrapped.clear();
        wrapped.add(widgetToAdd.asWidget());
    }

}