package com.moloco.sdk.internal.services;

import android.content.Context;
import android.content.res.Resources;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.view.inputmethod.InputMethodManager;
import android.view.inputmethod.InputMethodSubtype;
import androidx.core.content.ContextCompat;
import com.moloco.sdk.R;
import java.util.Locale;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ReplaceWith;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.moloco.sdk.internal.services.i, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3445i implements y {
    public static final int c = 8;

    /* renamed from: a, reason: collision with root package name */
    public final Context f5688a;
    public final Lazy b;

    public C3445i(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f5688a = context;
        this.b = LazyKt.lazy(new Function0() { // from class: com.moloco.sdk.internal.services.i$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(C3445i.a(C3445i.this));
            }
        });
    }

    public static final boolean a(C3445i c3445i) {
        return c3445i.f5688a.getResources().getBoolean(R.bool.isTablet);
    }

    @Override // com.moloco.sdk.internal.services.y
    public x b() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5 = Build.MANUFACTURER;
        if (str5 == null) {
            str5 = "";
        }
        String str6 = Build.MODEL;
        if (str6 == null) {
            str6 = "";
        }
        String str7 = Build.HARDWARE;
        if (str7 == null) {
            str3 = str7;
            str = str6;
            str2 = "";
        } else {
            str = str6;
            str2 = str7;
            str3 = str2;
        }
        boolean e = e();
        String str8 = str3;
        String RELEASE = Build.VERSION.RELEASE;
        Intrinsics.checkNotNullExpressionValue(RELEASE, "RELEASE");
        String str9 = str8;
        int i = Build.VERSION.SDK_INT;
        String language = Locale.getDefault().getLanguage();
        Intrinsics.checkNotNullExpressionValue(language, "getLanguage(...)");
        TelephonyManager telephonyManager = (TelephonyManager) ContextCompat.getSystemService(this.f5688a, TelephonyManager.class);
        if (telephonyManager == null || (str4 = telephonyManager.getNetworkOperatorName()) == null) {
            str4 = "";
        }
        float f = Resources.getSystem().getDisplayMetrics().density;
        long currentTimeMillis = System.currentTimeMillis() - SystemClock.elapsedRealtime();
        if (str9 == null) {
            str9 = "";
        }
        String str10 = Build.BRAND;
        if (str10 == null) {
            str10 = "";
        }
        return new x(str5, str, str2, e, "android", RELEASE, i, language, str4, f, currentTimeMillis, str9, str10);
    }

    @Override // com.moloco.sdk.internal.services.y
    public String c() {
        String language = Locale.getDefault().getLanguage();
        Intrinsics.checkNotNullExpressionValue(language, "getLanguage(...)");
        return language;
    }

    @Override // com.moloco.sdk.internal.services.y
    public String d() {
        Object systemService = this.f5688a.getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        InputMethodSubtype currentInputMethodSubtype = ((InputMethodManager) systemService).getCurrentInputMethodSubtype();
        if (currentInputMethodSubtype != null) {
            return currentInputMethodSubtype.getLocale();
        }
        return null;
    }

    public final boolean e() {
        return ((Boolean) this.b.getValue()).booleanValue();
    }

    @Override // com.moloco.sdk.internal.services.y
    @Deprecated(message = "Use invoke() instead", replaceWith = @ReplaceWith(expression = "deviceInfo", imports = {}))
    public x invoke() {
        return b();
    }

    @Override // com.moloco.sdk.internal.services.y
    public Boolean a() {
        try {
            Object systemService = this.f5688a.getSystemService("sensor");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.hardware.SensorManager");
            return Boolean.valueOf(((SensorManager) systemService).getDefaultSensor(4) != null);
        } catch (Exception unused) {
            return null;
        }
    }
}
