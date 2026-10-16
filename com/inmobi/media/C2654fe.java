package com.inmobi.media;

import java.util.TimerTask;

/* renamed from: com.inmobi.media.fe, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2654fe extends TimerTask {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C2671ge f2572a;
    public final /* synthetic */ byte b;

    public C2654fe(C2671ge c2671ge, byte b) {
        this.f2572a = c2671ge;
        this.b = b;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        this.f2572a.a(this.b);
    }
}
