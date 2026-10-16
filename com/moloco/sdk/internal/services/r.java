package com.moloco.sdk.internal.services;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class r implements q {
    public static final int b = 8;

    /* renamed from: a, reason: collision with root package name */
    public final Context f5719a;

    public r(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f5719a = context;
    }

    @Override // com.moloco.sdk.internal.services.q
    public int a() {
        Intent registerReceiver = this.f5719a.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver != null) {
            return registerReceiver.getIntExtra("status", 1);
        }
        return 1;
    }

    @Override // com.moloco.sdk.internal.services.q
    public int b() {
        Intent registerReceiver = this.f5719a.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver != null) {
            return registerReceiver.getIntExtra("scale", -1);
        }
        return -1;
    }

    @Override // com.moloco.sdk.internal.services.q
    public boolean c() {
        Object systemService = this.f5719a.getSystemService("power");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.PowerManager");
        return ((PowerManager) systemService).isPowerSaveMode();
    }
}
