package com.pgl.ssdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.hardware.camera2.CameraManager;
import android.telephony.TelephonyManager;
import androidx.autofill.HintConstants;

/* loaded from: classes6.dex */
public class x {

    /* renamed from: a, reason: collision with root package name */
    public static int f6415a = -1;
    public static int b = -1;

    static class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            x.b = x.b(z.b());
            SharedPreferences a2 = x0.a(z.b());
            if (a2 != null) {
                a2.edit().putInt("camera_count", x.b).apply();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(Context context) {
        int i = b;
        if (i != -1) {
            return i;
        }
        CameraManager cameraManager = (CameraManager) context.getSystemService("camera");
        if (cameraManager != null) {
            try {
                b = cameraManager.getCameraIdList().length;
            } catch (Throwable unused) {
                b = -1;
            }
        } else {
            b = -2;
        }
        return b;
    }

    public static int c(Context context) {
        TelephonyManager telephonyManager;
        if (f6415a == -1 && (telephonyManager = (TelephonyManager) context.getSystemService(HintConstants.AUTOFILL_HINT_PHONE)) != null) {
            f6415a = telephonyManager.getSimState();
        }
        return f6415a;
    }

    public static int a() {
        int i;
        int i2 = b;
        if (i2 != -1) {
            return i2;
        }
        SharedPreferences a2 = x0.a(z.b());
        if (a2 == null || (i = a2.getInt("camera_count", -1)) == -1) {
            r0.b(new a());
            return -1;
        }
        b = i;
        return i;
    }
}
