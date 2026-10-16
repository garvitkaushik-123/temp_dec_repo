package io.bidmachine.iab.utils;

import android.content.Context;

/* loaded from: classes7.dex */
public class SystemFeatureAvailability {

    /* renamed from: a, reason: collision with root package name */
    private final Context f6859a;

    public SystemFeatureAvailability(Context context) {
        this.f6859a = context.getApplicationContext();
    }

    public boolean hasTelephony() {
        return this.f6859a.getPackageManager().hasSystemFeature("android.hardware.telephony");
    }
}
