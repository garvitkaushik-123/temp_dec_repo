package com.inmobi.media;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.security.NetworkSecurityPolicy;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.e1, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2623e1 {

    /* renamed from: a, reason: collision with root package name */
    public static final String f2554a;
    public static final String b;
    public static final String c;
    public static final String d;
    public static final HashMap e = new HashMap();
    public static final byte f;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v7 */
    static {
        PackageManager packageManager;
        byte b2 = 2;
        f = (byte) 2;
        Context d2 = Uc.d();
        String str = null;
        if (d2 != null) {
            try {
                packageManager = d2.getPackageManager();
            } catch (Exception unused) {
            }
        } else {
            packageManager = null;
        }
        ApplicationInfo applicationInfo = packageManager != null ? packageManager.getApplicationInfo(d2.getPackageName(), 128) : null;
        if (applicationInfo != null) {
            String str2 = applicationInfo.packageName;
            f2554a = str2;
            d = applicationInfo.loadLabel(packageManager).toString();
            Intrinsics.checkNotNull(str2);
            b = packageManager.getInstallerPackageName(str2);
        }
        PackageInfo packageInfo = packageManager != null ? packageManager.getPackageInfo(d2.getPackageName(), 128) : null;
        if (packageInfo != null && ((str = packageInfo.versionName) == null || str.length() == 0)) {
            str = String.valueOf(packageInfo.getLongVersionCode());
        }
        if (B2.a(str)) {
            c = str;
        }
        try {
            b2 = L3.f2348a.H() ? !NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted() : 0;
        } catch (Error | Exception unused2) {
        }
        f = b2;
        String str3 = f2554a;
        if (str3 != null) {
            e.put("u-appbid", str3);
        }
        String str4 = d;
        if (str4 != null) {
            e.put("u-appdnm", str4);
        }
        String str5 = c;
        if (str5 != null) {
            e.put("u-appver", str5);
        }
        e.put("u-appsecure", String.valueOf((int) b2));
    }
}
