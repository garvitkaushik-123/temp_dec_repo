package com.unity3d.player;

import android.content.Context;
import com.google.android.gms.tasks.OnSuccessListener;
import java.lang.reflect.Proxy;

/* loaded from: classes7.dex */
class AndroidAppSetIdHelper {
    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeOnAndroidAppSetIdResult(String str);

    AndroidAppSetIdHelper() {
    }

    public static void requestAppSetId(Context context) {
        try {
            Class<?> cls = Class.forName("com.google.android.gms.appset.AppSet");
            Object invoke = cls.getMethod("getClient", Context.class).invoke(cls, context);
            if (invoke == null) {
                nativeOnAndroidAppSetIdResult(null);
                return;
            }
            Object invoke2 = invoke.getClass().getMethod("getAppSetIdInfo", null).invoke(invoke, null);
            if (invoke2 == null) {
                nativeOnAndroidAppSetIdResult(null);
            } else {
                invoke2.getClass().getMethod("addOnSuccessListener", OnSuccessListener.class).invoke(invoke2, Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{OnSuccessListener.class}, new C3492a()));
            }
        } catch (Exception unused) {
            nativeOnAndroidAppSetIdResult(null);
        }
    }
}
