package com.instagram.common.viewpoint.core;

import android.view.MotionEvent;

/* loaded from: assets/audience_network/classes2.dex */
public abstract class PN {
    public static boolean A00(MotionEvent motionEvent, int i) {
        return (motionEvent.getSource() & i) == i;
    }
}
