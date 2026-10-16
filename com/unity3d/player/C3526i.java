package com.unity3d.player;

import android.content.Context;
import com.google.android.play.core.assetpacks.AssetPackManager;
import com.google.android.play.core.assetpacks.AssetPackManagerFactory;
import java.util.HashSet;

/* renamed from: com.unity3d.player.i, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C3526i {
    public static C3526i e;

    /* renamed from: a, reason: collision with root package name */
    public final UnityPlayer f6559a;
    public final AssetPackManager b;
    public final HashSet c;
    public C3514c d;

    public C3526i(UnityPlayer unityPlayer, Context context) {
        if (e != null) {
            throw new RuntimeException("AssetPackManagerWrapper should be created only once. Use getInstance() instead.");
        }
        this.f6559a = unityPlayer;
        this.b = AssetPackManagerFactory.getInstance(context);
        this.c = new HashSet();
    }
}
