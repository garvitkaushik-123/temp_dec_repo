package com.unity3d.player;

/* renamed from: com.unity3d.player.g, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class RunnableC3522g implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final IAssetPackManagerStatusQueryCallback f6555a;
    public final long b;
    public final String[] c;
    public final int[] d;
    public final int[] e;

    public RunnableC3522g(IAssetPackManagerStatusQueryCallback iAssetPackManagerStatusQueryCallback, long j, String[] strArr, int[] iArr, int[] iArr2) {
        this.f6555a = iAssetPackManagerStatusQueryCallback;
        this.b = j;
        this.c = strArr;
        this.d = iArr;
        this.e = iArr2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f6555a.onStatusResult(this.b, this.c, this.d, this.e);
    }
}
