package com.example.android.myapplication;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by dell on 3/1/2017.
 */

public class BehaviourClass extends CoordinatorLayout.Behavior<LinearLayout> {
    public BehaviourClass() {
        super();
    }

    public BehaviourClass(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, LinearLayout child, View dependency) {
        float translationY = Math.min(0, ViewCompat.getTranslationY(dependency) - dependency.getHeight());
        ViewCompat.setTranslationY(child, translationY);
        return true;
    }

    @Override
    public void onDependentViewRemoved(CoordinatorLayout parent, LinearLayout child, View dependency) {
        ViewCompat.animate(child).translationY(0).start();
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, LinearLayout child, View dependency) {
        return dependency instanceof Snackbar.SnackbarLayout;
    }
}
