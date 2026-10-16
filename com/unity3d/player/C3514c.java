package com.unity3d.player;

import com.google.android.play.core.assetpacks.AssetPackState;
import com.google.android.play.core.assetpacks.AssetPackStateUpdateListener;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.unity3d.player.c, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C3514c implements AssetPackStateUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final HashSet f6546a;
    public final UnityPlayer b;
    public final /* synthetic */ C3526i c;

    public final void onStateUpdate(Object obj) {
        AssetPackState assetPackState = (AssetPackState) obj;
        synchronized (this) {
            if (assetPackState.status() == 4 || assetPackState.status() == 5 || assetPackState.status() == 0) {
                synchronized (C3526i.e) {
                    this.c.c.remove(assetPackState.name());
                    if (this.c.c.isEmpty()) {
                        C3526i c3526i = this.c;
                        C3514c c3514c = c3526i.d;
                        if (c3514c instanceof C3514c) {
                            c3526i.b.unregisterListener(c3514c);
                        }
                        this.c.d = null;
                    }
                }
            }
            if (this.f6546a.size() == 0) {
                return;
            }
            this.b.invokeOnMainThread(new RunnableC3512b((Set) this.f6546a.clone(), assetPackState.name(), assetPackState.status(), assetPackState.totalBytesToDownload(), assetPackState.bytesDownloaded(), assetPackState.transferProgressPercentage(), assetPackState.errorCode()));
        }
    }

    public C3514c(C3526i c3526i, UnityPlayer unityPlayer, IAssetPackManagerDownloadStatusCallback iAssetPackManagerDownloadStatusCallback) {
        this.c = c3526i;
        this.b = unityPlayer;
        HashSet hashSet = new HashSet();
        this.f6546a = hashSet;
        hashSet.add(iAssetPackManagerDownloadStatusCallback);
    }

    public final synchronized void a(IAssetPackManagerDownloadStatusCallback iAssetPackManagerDownloadStatusCallback) {
        this.f6546a.add(iAssetPackManagerDownloadStatusCallback);
    }
}
