package com.ironsource;

import android.adservices.measurement.MeasurementManager;
import android.content.Context;
import android.os.Build;
import android.os.ext.SdkExtensions;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.j0, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3137j0 {

    /* renamed from: a, reason: collision with root package name */
    public static final C3137j0 f3365a = new C3137j0();

    private C3137j0() {
    }

    public static final int a() {
        if (Build.VERSION.SDK_INT < 30) {
            return 0;
        }
        try {
            return SdkExtensions.getExtensionVersion(1000000);
        } catch (Exception e) {
            C3260q4.d().a(e);
            return 0;
        }
    }

    @JvmStatic
    public static /* synthetic */ void b() {
    }

    @JvmStatic
    public static final MeasurementManager a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (Build.VERSION.SDK_INT >= 30 && a() >= 4) {
            try {
                return (MeasurementManager) context.getSystemService(MeasurementManager.class);
            } catch (Exception unused) {
            }
        }
        return null;
    }
}
