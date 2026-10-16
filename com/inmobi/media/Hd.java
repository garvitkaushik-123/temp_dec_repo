package com.inmobi.media;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class Hd extends BroadcastReceiver {
    public static final void a(Intent intent, Context context) {
        Intrinsics.checkNotNullParameter(intent, "$intent");
        Intrinsics.checkNotNullParameter(context, "$context");
        Jd.a(context, intent);
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(final Context context, final Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        Uc.a(new Runnable() { // from class: com.inmobi.media.Hd$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                Hd.a(intent, context);
            }
        });
    }
}
