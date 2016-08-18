package com.github.clans.fab;

import android.content.Context;
import android.util.AttributeSet;

public class AnydoFloatingActionMenu extends FloatingActionMenu {

    public AnydoFloatingActionMenu(Context context) {
        super(context);
    }

    public AnydoFloatingActionMenu(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AnydoFloatingActionMenu(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected FloatingActionButton createMenuFabInstance() {
        AnydoSlideFloatingActionButton fab = new AnydoSlideFloatingActionButton(getContext());
        fab.setId(R.id.fab_menu_button);
        return fab;
    }
}
