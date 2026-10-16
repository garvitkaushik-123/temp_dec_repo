package com.unity3d.player;

/* renamed from: com.unity3d.player.d, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class RunnableC3516d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final IAssetPackManagerMobileDataConfirmationCallback f6548a;
    public final boolean b;

    public RunnableC3516d(IAssetPackManagerMobileDataConfirmationCallback iAssetPackManagerMobileDataConfirmationCallback, boolean z) {
        this.f6548a = iAssetPackManagerMobileDataConfirmationCallback;
        this.b = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f6548a.onMobileDataConfirmationResult(this.b);
    }
}
