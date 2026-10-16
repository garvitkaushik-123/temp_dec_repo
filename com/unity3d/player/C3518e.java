package com.unity3d.player;

import com.google.android.gms.tasks.OnSuccessListener;

/* renamed from: com.unity3d.player.e, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C3518e implements OnSuccessListener {

    /* renamed from: a, reason: collision with root package name */
    public final IAssetPackManagerMobileDataConfirmationCallback f6551a;
    public final UnityPlayer b;

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public final void onSuccess(Object obj) {
        Integer num = (Integer) obj;
        IAssetPackManagerMobileDataConfirmationCallback iAssetPackManagerMobileDataConfirmationCallback = this.f6551a;
        if (iAssetPackManagerMobileDataConfirmationCallback != null) {
            this.b.invokeOnMainThread(new RunnableC3516d(iAssetPackManagerMobileDataConfirmationCallback, num.intValue() == -1));
        }
    }

    public C3518e(UnityPlayer unityPlayer, IAssetPackManagerMobileDataConfirmationCallback iAssetPackManagerMobileDataConfirmationCallback) {
        this.b = unityPlayer;
        this.f6551a = iAssetPackManagerMobileDataConfirmationCallback;
    }
}
