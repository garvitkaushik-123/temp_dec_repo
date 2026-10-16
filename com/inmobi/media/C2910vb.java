package com.inmobi.media;

import android.database.sqlite.SQLiteException;
import android.util.Log;
import com.bytedance.sdk.component.pglcrypt.PglCryptUtils;
import com.inmobi.adquality.models.AdQualityResult;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.vb, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2910vb implements InterfaceC2803p0 {

    /* renamed from: a, reason: collision with root package name */
    public final AdQualityResult f2734a;

    public C2910vb(AdQualityResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        this.f2734a = result;
    }

    @Override // com.inmobi.media.InterfaceC2803p0
    public final Object a() {
        boolean z;
        try {
            ScheduledExecutorService scheduledExecutorService = C2638f0.f2564a;
            ((C2656g0) Nc.f2375a.getValue()).a(this.f2734a);
            z = true;
        } catch (SQLiteException e) {
            Intrinsics.checkNotNullParameter("QueueProcess", "tag");
            Intrinsics.checkNotNullParameter("failed to queue the result", PglCryptUtils.KEY_MESSAGE);
            Log.e("QueueProcess", "failed to queue the result", e);
            z = false;
        }
        return Boolean.valueOf(z);
    }
}
