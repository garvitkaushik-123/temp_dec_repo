package com.unity3d.player;

import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.CaptioningManager;
import java.util.concurrent.Semaphore;

/* loaded from: classes7.dex */
public final class E implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Semaphore f6469a;
    public final /* synthetic */ UnityAccessibilityDelegate b;

    public E(UnityAccessibilityDelegate unityAccessibilityDelegate, Semaphore semaphore) {
        this.b = unityAccessibilityDelegate;
        this.f6469a = semaphore;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AccessibilityManager accessibilityManager;
        CaptioningManager captioningManager;
        try {
            UnityAccessibilityDelegate unityAccessibilityDelegate = this.b;
            accessibilityManager = unityAccessibilityDelegate.c;
            if (accessibilityManager != null) {
                unityAccessibilityDelegate.d = new P(unityAccessibilityDelegate);
            }
            UnityAccessibilityDelegate unityAccessibilityDelegate2 = this.b;
            captioningManager = unityAccessibilityDelegate2.e;
            if (captioningManager != null) {
                unityAccessibilityDelegate2.f = new S(this.b);
            }
        } finally {
            this.f6469a.release();
        }
    }
}
