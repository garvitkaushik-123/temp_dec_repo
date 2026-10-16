package com.unity3d.player;

/* renamed from: com.unity3d.player.u, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class RunnableC3549u implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final long f6578a;
    public final long b;

    public RunnableC3549u(long j, long j2) {
        this.f6578a = j;
        this.b = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (ReflectionHelper.beginProxyCall(this.f6578a)) {
            try {
                ReflectionHelper.nativeProxyFinalize(this.b);
            } finally {
                ReflectionHelper.endProxyCall();
            }
        }
    }
}
