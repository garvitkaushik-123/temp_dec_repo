package com.unity3d.player;

import android.os.SystemClock;
import android.view.KeyEvent;

/* renamed from: com.unity3d.player.e0, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class RunnableC3519e0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UnityPlayer f6552a;

    public RunnableC3519e0(UnityPlayer unityPlayer) {
        this.f6552a = unityPlayer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        long uptimeMillis = SystemClock.uptimeMillis();
        KeyEvent keyEvent = new KeyEvent(uptimeMillis, uptimeMillis, 0, 4, 1, 0, -1, 0, 0, 257);
        KeyEvent keyEvent2 = new KeyEvent(uptimeMillis, 1 + uptimeMillis, 1, 4, 1, 0, -1, 0, 0, 257);
        this.f6552a.getActivity().dispatchKeyEvent(keyEvent);
        this.f6552a.getActivity().dispatchKeyEvent(keyEvent2);
    }
}
