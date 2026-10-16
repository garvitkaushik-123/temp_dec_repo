package com.unity3d.player;

import android.view.accessibility.CaptioningManager;
import java.util.Objects;

/* loaded from: classes7.dex */
public final class S extends CaptioningManager.CaptioningChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UnityAccessibilityDelegate f6489a;

    public S(UnityAccessibilityDelegate unityAccessibilityDelegate) {
        CaptioningManager captioningManager;
        CaptioningManager captioningManager2;
        this.f6489a = unityAccessibilityDelegate;
        captioningManager = unityAccessibilityDelegate.e;
        captioningManager.addCaptioningChangeListener(this);
        captioningManager2 = unityAccessibilityDelegate.e;
        onEnabledChanged(captioningManager2.isEnabled());
    }

    @Override // android.view.accessibility.CaptioningManager.CaptioningChangeListener
    public final void onEnabledChanged(boolean z) {
        UnityPlayer unityPlayer;
        UnityPlayer unityPlayer2;
        unityPlayer = this.f6489a.f6494a;
        Objects.requireNonNull(unityPlayer);
        Q q = new Q(unityPlayer, z);
        unityPlayer2 = this.f6489a.f6494a;
        unityPlayer2.invokeOnMainThread((Runnable) q);
    }

    public void cleanup() {
        CaptioningManager captioningManager;
        captioningManager = this.f6489a.e;
        captioningManager.removeCaptioningChangeListener(this);
    }
}
