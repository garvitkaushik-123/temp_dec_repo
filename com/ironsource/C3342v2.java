package com.ironsource;

import android.app.Activity;
import android.content.Context;
import com.ironsource.C3230o8;
import com.ironsource.mediationsdk.logger.IronLog;

/* renamed from: com.ironsource.v2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public class C3342v2 {

    /* renamed from: a, reason: collision with root package name */
    public static C3342v2 f3903a;

    /* renamed from: com.ironsource.v2$a */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3904a;

        static {
            int[] iArr = new int[C3230o8.a.values().length];
            f3904a = iArr;
            try {
                iArr[C3230o8.a.None.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3904a[C3230o8.a.Device.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3904a[C3230o8.a.Controller.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static C3342v2 a() {
        C3342v2 c3342v2 = f3903a;
        return c3342v2 == null ? new C3342v2() : c3342v2;
    }

    public boolean a(Activity activity) {
        if (a.f3904a[R9.e().b().ordinal()] != 3) {
            return false;
        }
        try {
            com.ironsource.sdk.controller.v vVar = (com.ironsource.sdk.controller.v) F9.b((Context) activity).a().k();
            if (vVar == null) {
                return true;
            }
            vVar.k("back");
            return true;
        } catch (Exception e) {
            C3260q4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
            return false;
        }
    }
}
