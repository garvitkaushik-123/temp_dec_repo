package com.unity3d.player;

import android.app.Activity;
import android.app.Dialog;
import android.window.OnBackInvokedDispatcher;
import com.unity3d.player.a.AbstractC3498f;
import com.unity3d.player.a.C3497e;

/* renamed from: com.unity3d.player.q, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C3542q extends com.unity3d.player.a.x {
    public C3497e d;
    public final OnBackInvokedDispatcher e;
    public final int f;

    public C3542q(OnBackInvokedDispatcher onBackInvokedDispatcher, int i, Runnable runnable) {
        super(runnable);
        this.d = null;
        this.f = i;
        this.e = onBackInvokedDispatcher;
    }

    public static com.unity3d.player.a.x a(Object obj, int i, Runnable runnable) {
        com.unity3d.player.a.x xVar;
        if (PlatformSupport.TIRAMISU_SUPPORT && ((obj instanceof Activity) || (obj instanceof Dialog))) {
            xVar = new C3542q(AbstractC3498f.a(obj), i, runnable);
        } else {
            xVar = new com.unity3d.player.a.x(runnable);
        }
        xVar.registerOnBackPressedCallback();
        return xVar;
    }

    @Override // com.unity3d.player.a.x
    public void registerOnBackPressedCallback() {
        if (this.f6539a != null) {
            return;
        }
        super.registerOnBackPressedCallback();
        if (PlatformSupport.TIRAMISU_SUPPORT) {
            C3497e c3497e = new C3497e(this.f6539a);
            this.d = c3497e;
            AbstractC3498f.a(this.e, this.f, c3497e);
        }
    }

    @Override // com.unity3d.player.a.x
    public void unregisterOnBackPressedCallback() {
        if (this.f6539a != null) {
            if (PlatformSupport.TIRAMISU_SUPPORT) {
                AbstractC3498f.a(this.e, this.d);
                this.d = null;
            }
            super.unregisterOnBackPressedCallback();
        }
    }
}
