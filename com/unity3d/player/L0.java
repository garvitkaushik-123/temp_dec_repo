package com.unity3d.player;

import android.view.ViewGroup;
import com.unity3d.player.a.C3499g;

/* loaded from: classes7.dex */
public final class L0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ float f6480a;
    public final /* synthetic */ UnityPlayerForActivityOrService b;

    public L0(UnityPlayerForActivityOrService unityPlayerForActivityOrService, float f) {
        this.b = unityPlayerForActivityOrService;
        this.f6480a = f;
    }

    @Override // java.lang.Runnable
    public final void run() {
        U view = this.b.getView();
        if (view != null) {
            float f = this.f6480a;
            C3499g c3499g = view.f6493a;
            c3499g.f6528a = f;
            ViewGroup.LayoutParams layoutParams = c3499g.getLayoutParams();
            if (f <= 0.0f) {
                layoutParams.width = -1;
                layoutParams.height = -1;
            } else {
                layoutParams.width = -2;
                layoutParams.height = -2;
            }
            c3499g.setLayoutParams(layoutParams);
        }
    }
}
