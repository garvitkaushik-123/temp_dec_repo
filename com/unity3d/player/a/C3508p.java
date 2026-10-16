package com.unity3d.player.a;

import android.content.Context;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.unity3d.player.U;
import com.unity3d.player.UnityPlayerForActivityOrService;

/* renamed from: com.unity3d.player.a.p, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C3508p extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    public final UnityPlayerForActivityOrService f6534a;
    public final U b;

    public C3508p(Context context, UnityPlayerForActivityOrService unityPlayerForActivityOrService) {
        super(context);
        this.f6534a = unityPlayerForActivityOrService;
        U u = new U(unityPlayerForActivityOrService);
        this.b = u;
        addView(u);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyUp(int i, KeyEvent keyEvent) {
        return this.f6534a.injectEvent(keyEvent);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.f6534a.injectEvent(keyEvent);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyMultiple(int i, int i2, KeyEvent keyEvent) {
        return this.f6534a.injectEvent(keyEvent);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyLongPress(int i, KeyEvent keyEvent) {
        return this.f6534a.injectEvent(keyEvent);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        C3499g c3499g = this.b.f6493a;
        if (c3499g == null || c3499g.f6528a <= 0.0f) {
            return this.f6534a.injectEvent(motionEvent);
        }
        return false;
    }

    @Override // android.view.View
    public final boolean onGenericMotionEvent(MotionEvent motionEvent) {
        C3499g c3499g = this.b.f6493a;
        if (c3499g == null || c3499g.f6528a <= 0.0f) {
            return this.f6534a.injectEvent(motionEvent);
        }
        return false;
    }
}
