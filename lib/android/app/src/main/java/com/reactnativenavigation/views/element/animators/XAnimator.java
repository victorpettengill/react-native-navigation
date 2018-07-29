package com.reactnativenavigation.views.element.animators;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.graphics.Point;
import android.view.View;

import com.facebook.react.views.text.ReactTextView;
import com.reactnativenavigation.utils.ViewUtils;
import com.reactnativenavigation.views.element.Element;

public class XAnimator extends PropertyAnimatorCreator<View> {

    private final int dx;

    public XAnimator(Element from, Element to) {
        super(from, to);
        final Point fromXy = ViewUtils.getLocationOnScreen(from.getChild());
        final Point toXy = ViewUtils.getLocationOnScreen(to.getChild());
        dx = fromXy.x - toXy.x;
    }

    @Override
    public boolean shouldAnimateProperty(View fromChild, View toChild) {
        return dx != 0 && !ViewUtils.instanceOf(ReactTextView.class, fromChild, toChild);
    }

    @Override
    public Animator create() {
        return ObjectAnimator.ofFloat(to.getChild(), View.TRANSLATION_X, dx, 0);
    }
}
