package com.google.android.gms.internal.ads;

import android.content.Context;
import android.opengl.EGL14;
import android.os.Build;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzdr {
    public static void zza(boolean z, String str) throws zzdq {
        if (!z) {
            throw new zzdq(str);
        }
    }

    public static boolean zzb() {
        return Build.VERSION.SDK_INT >= 33 && zzf("EGL_EXT_gl_colorspace_bt2020_pq");
    }

    public static boolean zzc(int i) {
        if (i == 6) {
            return zzb();
        }
        if (i == 7) {
            return zzf("EGL_EXT_gl_colorspace_bt2020_hlg");
        }
        return true;
    }

    public static boolean zze() {
        return zzf("EGL_KHR_surfaceless_context");
    }

    private static boolean zzf(String str) {
        String eglQueryString = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373);
        return eglQueryString != null && eglQueryString.contains(str);
    }

    public static boolean zzd(Context context) {
        return zzf("EGL_EXT_protected_content");
    }
}
