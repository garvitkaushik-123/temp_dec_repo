package com.unity3d.player;

import android.app.Activity;
import android.content.Context;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes7.dex */
public final class c1 {

    /* renamed from: a, reason: collision with root package name */
    public final UnityPlayer f6547a;
    public C3527i0 c;
    public Context b = null;
    public final Semaphore d = new Semaphore(0);
    public final ReentrantLock e = new ReentrantLock();
    public VideoPlayer f = null;
    public int g = 2;
    public boolean h = false;
    public boolean i = false;

    public c1(UnityPlayer unityPlayer) {
        this.f6547a = null;
        this.f6547a = unityPlayer;
    }

    public void runOnUiThread(Runnable runnable) {
        Context context = this.b;
        if (context instanceof Activity) {
            ((Activity) context).runOnUiThread(runnable);
        } else {
            com.unity3d.player.a.t.Log(5, "Not running from an Activity; Ignoring execution request...");
        }
    }
}
