package com.github.clans.fab;

import android.view.View;

public interface OnFabMainButtonOnClickListener {

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     * @return Was the click handled externally? If {@code false}, FAB menu is opened/closed regularly.
     * If {@code true}, nothing happens - some action executed externally.
     */
    boolean onFabMainButtonClick(View v);
}
