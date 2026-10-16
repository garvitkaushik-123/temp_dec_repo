package com.inmobi.media;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.n, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2769n extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (Intrinsics.areEqual(intent != null ? intent.getAction() : null, "android.media.VOLUME_CHANGED_ACTION")) {
            C2849s c2849s = C2849s.f2699a;
            C2849s.c();
        }
    }
}
