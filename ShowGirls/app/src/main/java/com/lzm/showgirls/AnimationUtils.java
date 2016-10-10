package com.lzm.showgirls;

import android.app.Activity;
import android.transition.ChangeBounds;
import android.transition.ChangeTransform;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.TransitionSet;
import android.view.View;
import android.view.Window;

/**
 * Created by luzhiming on 16/9/11.
 */
public class AnimationUtils {

    public static void myTransitionImage(Activity activity, View view, String name) {
        TransitionSet set = new TransitionSet();
        set.addTransition(new Explode());
        set.addTransition(new Fade());
        set.setDuration(1000);
        activity.getWindow().setReturnTransition(set);
        activity.getWindow().setReenterTransition(set);
        activity.getWindow().setEnterTransition(set);
        activity.getWindow().setExitTransition(set);

        view.setTransitionName(name);
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.addTransition(new ChangeTransform());
        transitionSet.addTransition(new ChangeBounds());
        transitionSet.addTarget(name);
        transitionSet.setDuration(1000);
        activity.getWindow().setSharedElementEnterTransition(transitionSet);
        activity.getWindow().setSharedElementExitTransition(transitionSet);
        activity.getWindow().setSharedElementReturnTransition(transitionSet);
        activity.getWindow().setSharedElementReenterTransition(transitionSet);
    }

    public static void receiveTransitionImage(Activity activity, String name) {
        activity.getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        activity.getWindow().setAllowEnterTransitionOverlap(true);
        activity.getWindow().setAllowReturnTransitionOverlap(true);
        activity.getWindow().setSharedElementsUseOverlay(true);

        TransitionSet transitionSet = new TransitionSet();
        transitionSet.addTransition(new Fade());
        transitionSet.addTransition(new ChangeTransform());
        transitionSet.addTransition(new ChangeBounds());
        transitionSet.addTarget(name);
        transitionSet.setDuration(1000);
        activity.getWindow().setSharedElementEnterTransition(transitionSet);
        activity.getWindow().setSharedElementExitTransition(transitionSet);
        activity.getWindow().setSharedElementReturnTransition(transitionSet);
        activity.getWindow().setSharedElementReenterTransition(transitionSet);
    }


}
