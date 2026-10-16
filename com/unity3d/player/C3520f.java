package com.unity3d.player;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.RuntimeExecutionException;
import com.google.android.gms.tasks.Task;
import com.google.android.play.core.assetpacks.AssetPackException;
import com.google.android.play.core.assetpacks.AssetPackState;
import com.google.android.play.core.assetpacks.AssetPackStates;
import java.util.Collections;
import java.util.Map;
import java.util.Vector;

/* renamed from: com.unity3d.player.f, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C3520f implements OnCompleteListener {

    /* renamed from: a, reason: collision with root package name */
    public final IAssetPackManagerDownloadStatusCallback f6553a;
    public final UnityPlayer b;
    public final String[] c;

    public C3520f(UnityPlayer unityPlayer, IAssetPackManagerDownloadStatusCallback iAssetPackManagerDownloadStatusCallback, String[] strArr) {
        this.b = unityPlayer;
        this.f6553a = iAssetPackManagerDownloadStatusCallback;
        this.c = strArr;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task task) {
        int errorCode;
        try {
            AssetPackStates assetPackStates = (AssetPackStates) task.getResult();
            Map packStates = assetPackStates.packStates();
            if (packStates.size() == 0) {
                return;
            }
            Vector vector = new Vector();
            for (AssetPackState assetPackState : packStates.values()) {
                if (assetPackState.errorCode() != 0 || assetPackState.status() == 4 || assetPackState.status() == 5 || assetPackState.status() == 0) {
                    String name = assetPackState.name();
                    int status = assetPackState.status();
                    int errorCode2 = assetPackState.errorCode();
                    long j = assetPackStates.totalBytes();
                    this.b.invokeOnMainThread(new RunnableC3512b(Collections.singleton(this.f6553a), name, status, j, status == 4 ? j : 0L, 0, errorCode2));
                } else {
                    vector.add(assetPackState.name());
                }
            }
            if (vector.size() > 0) {
                C3526i c3526i = C3526i.e;
                UnityPlayer unityPlayer = this.b;
                IAssetPackManagerDownloadStatusCallback iAssetPackManagerDownloadStatusCallback = this.f6553a;
                c3526i.getClass();
                synchronized (C3526i.e) {
                    C3514c c3514c = c3526i.d;
                    if (c3514c == null) {
                        C3514c c3514c2 = new C3514c(c3526i, unityPlayer, iAssetPackManagerDownloadStatusCallback);
                        c3526i.b.registerListener(c3514c2);
                        c3526i.d = c3514c2;
                    } else {
                        c3514c.a(iAssetPackManagerDownloadStatusCallback);
                    }
                    c3526i.c.addAll(vector);
                    c3526i.b.fetch(vector);
                }
            }
        } catch (RuntimeExecutionException e) {
            Throwable th = e;
            String[] strArr = this.c;
            if (strArr.length == 1) {
                String str = strArr[0];
                while (true) {
                    if (th instanceof AssetPackException) {
                        errorCode = ((AssetPackException) th).getErrorCode();
                        break;
                    }
                    th = th.getCause();
                    if (th == null) {
                        errorCode = -100;
                        break;
                    }
                }
                this.b.invokeOnMainThread(new RunnableC3512b(Collections.singleton(this.f6553a), str, 0, 0L, 0L, 0, errorCode));
                return;
            }
            C3526i c3526i2 = C3526i.e;
            IAssetPackManagerDownloadStatusCallback iAssetPackManagerDownloadStatusCallback2 = this.f6553a;
            c3526i2.getClass();
            for (String str2 : strArr) {
                c3526i2.b.getPackStates(Collections.singletonList(str2)).addOnCompleteListener(new C3520f(c3526i2.f6559a, iAssetPackManagerDownloadStatusCallback2, new String[]{str2}));
            }
        }
    }
}
