package com.unity3d.player;

import android.content.Context;
import com.ironsource.C3040d4;
import java.lang.reflect.Method;

/* loaded from: classes7.dex */
class AndroidAdvertisingIdHelper {
    private static native void nativeOnAndroidAdvertisingIdResult(String str);

    AndroidAdvertisingIdHelper() {
    }

    public static void requestGoogleAdId(Context context) {
        try {
            Method method = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient").getMethod("getAdvertisingIdInfo", Context.class);
            if (method == null) {
                nativeOnAndroidAdvertisingIdResult(null);
                return;
            }
            Object invoke = method.invoke(null, context);
            if (invoke == null) {
                nativeOnAndroidAdvertisingIdResult(null);
                return;
            }
            Class<?> cls = invoke.getClass();
            Method method2 = cls.getMethod("getId", null);
            if (method2 == null) {
                nativeOnAndroidAdvertisingIdResult(null);
                return;
            }
            String str = (String) method2.invoke(invoke, null);
            Method method3 = cls.getMethod(C3040d4.i.M, null);
            if (method3 == null) {
                nativeOnAndroidAdvertisingIdResult(null);
            } else if (((Boolean) method3.invoke(invoke, null)).booleanValue()) {
                nativeOnAndroidAdvertisingIdResult(null);
            } else {
                nativeOnAndroidAdvertisingIdResult(str);
            }
        } catch (Exception unused) {
            nativeOnAndroidAdvertisingIdResult(null);
        }
    }
}
