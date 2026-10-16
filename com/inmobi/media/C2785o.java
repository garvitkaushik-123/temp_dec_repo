package com.inmobi.media;

import android.content.Context;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* renamed from: com.inmobi.media.o, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2785o extends Lambda implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f2654a;
    public final /* synthetic */ C2769n b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2785o(Context context, C2769n c2769n) {
        super(0);
        this.f2654a = context;
        this.b = c2769n;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        this.f2654a.unregisterReceiver(this.b);
        return Unit.INSTANCE;
    }
}
