package com.inmobi.media;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.webkit.WebResourceResponse;
import android.widget.RelativeLayout;
import com.google.common.net.HttpHeaders;
import java.io.InputStream;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.json.JSONArray;

/* loaded from: classes4.dex */
public abstract class B2 {
    public static final boolean a(String str) {
        return str != null && str.length() > 0;
    }

    public static final int b(float f) {
        try {
            return MathKt.roundToInt(f);
        } catch (Exception unused) {
            return 0;
        }
    }

    public static final int c(float f) {
        try {
            return (int) (f / U3.b());
        } catch (Exception unused) {
            return 0;
        }
    }

    public static final boolean a(JSONArray jSONArray) {
        Intrinsics.checkNotNullParameter(jSONArray, "<this>");
        return jSONArray.length() == 0;
    }

    public static final WebResourceResponse a(InputStream inputStream, String mimeType) {
        Intrinsics.checkNotNullParameter(inputStream, "<this>");
        Intrinsics.checkNotNullParameter(mimeType, "mimeType");
        Map mapOf = MapsKt.mapOf(TuplesKt.to(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "*"));
        if (L3.G()) {
            return new WebResourceResponse(mimeType, "UTF-8", 200, "OK", mapOf, inputStream);
        }
        return new WebResourceResponse(mimeType, "UTF-8", inputStream);
    }

    public static final int a(int i) {
        try {
            return (int) (i / U3.b());
        } catch (Exception unused) {
            return i;
        }
    }

    public static final float a(float f) {
        return MathKt.roundToInt(f * 10.0f) / 10.0f;
    }

    public static final Intent a(Context context, BroadcastReceiver broadcastReceiver, IntentFilter filter) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(filter, "filter");
        if (L3.f2348a.B()) {
            return context.registerReceiver(broadcastReceiver, filter, 2);
        }
        return context.registerReceiver(broadcastReceiver, filter);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0031 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean a(Context context) {
        int i;
        ApplicationInfo applicationInfo;
        Intrinsics.checkNotNullParameter(context, "<this>");
        if (!L3.f2348a.D()) {
            return false;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), PackageManager.PackageInfoFlags.of(0L));
            Intrinsics.checkNotNullExpressionValue(packageInfo, "getPackageInfo(...)");
            applicationInfo = packageInfo.applicationInfo;
        } catch (Exception unused) {
        }
        if (applicationInfo != null) {
            i = applicationInfo.targetSdkVersion;
            return i < 35;
        }
        i = -1;
        if (i < 35) {
        }
    }

    public static final void a(Cf cf, RelativeLayout.LayoutParams layoutParams, EnumC2813pa orientation) {
        Intrinsics.checkNotNullParameter(cf, "<this>");
        Intrinsics.checkNotNullParameter(layoutParams, "layoutParams");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        cf.getClass();
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        Bf bf = (Bf) cf.f2256a.get(orientation);
        int i = bf != null ? bf.f2247a : 0;
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        Bf bf2 = (Bf) cf.f2256a.get(orientation);
        int i2 = bf2 != null ? bf2.c : 0;
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        Bf bf3 = (Bf) cf.f2256a.get(orientation);
        layoutParams.setMargins(i, 0, i2, bf3 != null ? bf3.d : 0);
    }
}
