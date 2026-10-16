package com.moloco.sdk.internal.services;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.moloco.sdk.internal.services.AbstractC3439c;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.moloco.sdk.internal.services.e, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3441e implements InterfaceC3440d {
    public static final int b = 8;

    /* renamed from: a, reason: collision with root package name */
    public final Context f5673a;

    public C3441e(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f5673a = context;
    }

    @Override // com.moloco.sdk.internal.services.InterfaceC3440d
    public AbstractC3439c a() {
        Object m10241constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            m10241constructorimpl = Result.m10241constructorimpl(AdvertisingIdClient.getAdvertisingIdInfo(this.f5673a));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
        AbstractC3439c abstractC3439c = null;
        if (Result.m10247isFailureimpl(m10241constructorimpl)) {
            m10241constructorimpl = null;
        }
        AdvertisingIdClient.Info info = (AdvertisingIdClient.Info) m10241constructorimpl;
        if (info != null) {
            if (info.isLimitAdTrackingEnabled()) {
                abstractC3439c = AbstractC3439c.b.b;
            } else {
                String id = info.getId();
                if (id != null) {
                    abstractC3439c = new AbstractC3439c.a(id);
                }
            }
            if (abstractC3439c != null) {
                return abstractC3439c;
            }
        }
        return AbstractC3439c.b.b;
    }
}
