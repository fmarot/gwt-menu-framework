package com.teamtter.gwt.framework.client.view;

import com.google.gwt.user.client.ui.Widget;
import com.teamtter.gwt.framework.client.presenter.Presenter;

/** Les vues souhaitant notifier leur Presenter ('reversed MVP') peuvent
 * etendre cette classe qui leur permet d'avoir la méthode setPresenter avec le bon type.
 * Le type paramétré T est destiné à etre remplacé par l'interface du Presenter qui sera visible dans la View
 *  */
public interface ReversedMVPView<T> extends View {
    Widget asWidget();
    void setPresenter(T presenter);
}
