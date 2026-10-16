package com.unity3d.player;

import android.app.Activity;
import android.content.Context;
import com.google.android.play.core.assetpacks.AssetPackLocation;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes7.dex */
class PlayAssetDeliveryUnityWrapper {
    private static PlayAssetDeliveryUnityWrapper b;

    /* renamed from: a, reason: collision with root package name */
    private final C3526i f6487a;

    private PlayAssetDeliveryUnityWrapper(UnityPlayer unityPlayer, Context context) {
        this.f6487a = null;
        if (b != null) {
            throw new RuntimeException("PlayAssetDeliveryUnityWrapper should be created only once. Use getInstance() instead.");
        }
        try {
            if (getClass().getClassLoader().loadClass("com.google.android.play.core.assetpacks.AssetPackManager").getMethod("getPackStates", List.class).getReturnType().getName().equals("com.google.android.gms.tasks.Task")) {
                this.f6487a = a(unityPlayer, context);
            }
        } catch (ClassNotFoundException | NoSuchMethodException | SecurityException unused) {
        }
    }

    public static synchronized PlayAssetDeliveryUnityWrapper getInstance() {
        PlayAssetDeliveryUnityWrapper playAssetDeliveryUnityWrapper;
        synchronized (PlayAssetDeliveryUnityWrapper.class) {
            while (true) {
                playAssetDeliveryUnityWrapper = b;
                if (playAssetDeliveryUnityWrapper != null) {
                    break;
                }
                try {
                    PlayAssetDeliveryUnityWrapper.class.wait(3000L);
                } catch (InterruptedException e) {
                    com.unity3d.player.a.t.Log(6, e.getMessage());
                }
            }
            if (playAssetDeliveryUnityWrapper == null) {
                throw new RuntimeException("PlayAssetDeliveryUnityWrapper is not yet initialised.");
            }
        }
        return playAssetDeliveryUnityWrapper;
    }

    private static C3526i a(UnityPlayer unityPlayer, Context context) {
        if (C3526i.e == null) {
            C3526i.e = new C3526i(unityPlayer, context);
        }
        return C3526i.e;
    }

    public static synchronized PlayAssetDeliveryUnityWrapper init(UnityPlayer unityPlayer, Context context) {
        PlayAssetDeliveryUnityWrapper playAssetDeliveryUnityWrapper;
        synchronized (PlayAssetDeliveryUnityWrapper.class) {
            if (b != null) {
                throw new RuntimeException("PlayAssetDeliveryUnityWrapper.init() should be called only once. Use getInstance() instead.");
            }
            b = new PlayAssetDeliveryUnityWrapper(unityPlayer, context);
            PlayAssetDeliveryUnityWrapper.class.notifyAll();
            playAssetDeliveryUnityWrapper = b;
        }
        return playAssetDeliveryUnityWrapper;
    }

    public void getAssetPackState(String str, IAssetPackManagerStatusQueryCallback iAssetPackManagerStatusQueryCallback) {
        getAssetPackStates(new String[]{str}, iAssetPackManagerStatusQueryCallback);
    }

    public void getAssetPackStates(String[] strArr, IAssetPackManagerStatusQueryCallback iAssetPackManagerStatusQueryCallback) {
        a();
        C3526i c3526i = this.f6487a;
        c3526i.b.getPackStates(Arrays.asList(strArr)).addOnCompleteListener(new C3524h(c3526i.f6559a, iAssetPackManagerStatusQueryCallback, strArr));
    }

    public void downloadAssetPack(String str, IAssetPackManagerDownloadStatusCallback iAssetPackManagerDownloadStatusCallback) {
        downloadAssetPacks(new String[]{str}, iAssetPackManagerDownloadStatusCallback);
    }

    public void downloadAssetPacks(String[] strArr, IAssetPackManagerDownloadStatusCallback iAssetPackManagerDownloadStatusCallback) {
        a();
        C3526i c3526i = this.f6487a;
        c3526i.getClass();
        if (strArr == null || strArr.length == 0) {
            return;
        }
        c3526i.b.getPackStates(Arrays.asList(strArr)).addOnCompleteListener(new C3520f(c3526i.f6559a, iAssetPackManagerDownloadStatusCallback, strArr));
    }

    public Object registerDownloadStatusListener(IAssetPackManagerDownloadStatusCallback iAssetPackManagerDownloadStatusCallback) {
        a();
        C3526i c3526i = this.f6487a;
        C3514c c3514c = new C3514c(c3526i, c3526i.f6559a, iAssetPackManagerDownloadStatusCallback);
        c3526i.b.registerListener(c3514c);
        return c3514c;
    }

    public void unregisterDownloadStatusListener(Object obj) {
        a();
        C3526i c3526i = this.f6487a;
        c3526i.getClass();
        if (obj instanceof C3514c) {
            c3526i.b.unregisterListener((C3514c) obj);
        }
    }

    public void requestToUseMobileData(Activity activity, IAssetPackManagerMobileDataConfirmationCallback iAssetPackManagerMobileDataConfirmationCallback) {
        a();
        C3526i c3526i = this.f6487a;
        c3526i.b.showCellularDataConfirmation(activity).addOnSuccessListener(new C3518e(c3526i.f6559a, iAssetPackManagerMobileDataConfirmationCallback));
    }

    public String getAssetPackPath(String str) {
        a();
        AssetPackLocation packLocation = this.f6487a.b.getPackLocation(str);
        if (packLocation == null) {
            return "";
        }
        return packLocation.assetsPath();
    }

    public void cancelAssetPackDownload(String str) {
        cancelAssetPackDownloads(new String[]{str});
    }

    public void cancelAssetPackDownloads(String[] strArr) {
        a();
        this.f6487a.b.cancel(Arrays.asList(strArr));
    }

    public void removeAssetPack(String str) {
        a();
        this.f6487a.b.removePack(str);
    }

    public boolean playCoreApiMissing() {
        return this.f6487a == null;
    }

    private void a() {
        if (playCoreApiMissing()) {
            throw new RuntimeException("AssetPackManager API is not available! Make sure your gradle project includes 'com.google.android.play:asset-delivery' dependency.");
        }
    }
}
