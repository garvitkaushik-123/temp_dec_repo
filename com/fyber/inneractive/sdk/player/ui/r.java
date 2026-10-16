package com.fyber.inneractive.sdk.player.ui;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/* loaded from: classes4.dex */
public final class r implements View.OnTouchListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GestureDetector f1647a;

    public r(GestureDetector gestureDetector) {
        this.f1647a = gestureDetector;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return this.f1647a.onTouchEvent(motionEvent);
    }
}
