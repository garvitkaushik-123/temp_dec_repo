package com.unity3d.player;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.RuntimeExecutionException;
import com.google.android.gms.tasks.Task;
import com.google.android.play.core.assetpacks.AssetPackException;
import com.google.android.play.core.assetpacks.AssetPackState;
import com.google.android.play.core.assetpacks.AssetPackStates;
import java.util.Map;

/* renamed from: com.unity3d.player.h, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C3524h implements OnCompleteListener {

    /* renamed from: a, reason: collision with root package name */
    public final IAssetPackManagerStatusQueryCallback f6557a;
    public final UnityPlayer b;
    public final String[] c;

    public C3524h(UnityPlayer unityPlayer, IAssetPackManagerStatusQueryCallback iAssetPackManagerStatusQueryCallback, String[] strArr) {
        this.b = unityPlayer;
        this.f6557a = iAssetPackManagerStatusQueryCallback;
        this.c = strArr;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task task) {
        int errorCode;
        if (this.f6557a == null) {
            return;
        }
        int i = 0;
        try {
            AssetPackStates assetPackStates = (AssetPackStates) task.getResult();
            Map packStates = assetPackStates.packStates();
            int size = packStates.size();
            String[] strArr = new String[size];
            int[] iArr = new int[size];
            int[] iArr2 = new int[size];
            for (AssetPackState assetPackState : packStates.values()) {
                strArr[i] = assetPackState.name();
                iArr[i] = assetPackState.status();
                iArr2[i] = assetPackState.errorCode();
                i++;
            }
            this.b.invokeOnMainThread(new RunnableC3522g(this.f6557a, assetPackStates.totalBytes(), strArr, iArr, iArr2));
        } catch (RuntimeExecutionException e) {
            e = e;
            String message = e.getMessage();
            String[] strArr2 = this.c;
            int length = strArr2.length;
            int i2 = 0;
            while (true) {
                int i3 = -100;
                if (i2 < length) {
                    String str = strArr2[i2];
                    if (message.contains(str)) {
                        UnityPlayer unityPlayer = this.b;
                        IAssetPackManagerStatusQueryCallback iAssetPackManagerStatusQueryCallback = this.f6557a;
                        String[] strArr3 = {str};
                        int[] iArr3 = {0};
                        while (true) {
                            if (e instanceof AssetPackException) {
                                i3 = e.getErrorCode();
                                break;
                            } else {
                                e = e.getCause();
                                if (e == null) {
                                    break;
                                }
                            }
                        }
                        unityPlayer.invokeOnMainThread(new RunnableC3522g(iAssetPackManagerStatusQueryCallback, 0L, strArr3, iArr3, new int[]{i3}));
                        return;
                    }
                    i2++;
                } else {
                    String[] strArr4 = this.c;
                    int[] iArr4 = new int[strArr4.length];
                    int[] iArr5 = new int[strArr4.length];
                    int i4 = 0;
                    while (true) {
                        String[] strArr5 = this.c;
                        if (i4 < strArr5.length) {
                            iArr4[i4] = 0;
                            AssetPackException assetPackException = e;
                            while (true) {
                                if (assetPackException instanceof AssetPackException) {
                                    errorCode = assetPackException.getErrorCode();
                                    break;
                                }
                                assetPackException = assetPackException.getCause();
                                if (assetPackException == null) {
                                    errorCode = -100;
                                    break;
                                }
                            }
                            iArr5[i4] = errorCode;
                            i4++;
                        } else {
                            this.b.invokeOnMainThread(new RunnableC3522g(this.f6557a, 0L, strArr5, iArr4, iArr5));
                            return;
                        }
                    }
                }
            }
        }
    }
}
