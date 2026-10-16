package com.inmobi.media;

import android.os.Handler;
import android.os.Looper;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class A0 implements InterfaceC2884u1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ B0 f2226a;

    public A0(B0 b0) {
        this.f2226a = b0;
    }

    public static final void a(B0 this$0, byte b) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.f2239a.a(this$0.c, false, b == 1 ? (short) 78 : b == 2 ? (short) 79 : b == 3 ? (short) 80 : b == 4 ? (short) 81 : b == 5 ? (short) 5 : b == 6 ? (short) 77 : b == 7 ? (short) 31 : b == 8 ? (short) 27 : (short) 82);
    }

    public static final void a(B0 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.f2239a.a(this$0.c, true, (short) 0);
    }

    @Override // com.inmobi.media.InterfaceC2884u1
    public final void a(C2721k assetBatch, final byte b) {
        Intrinsics.checkNotNullParameter(assetBatch, "assetBatch");
        this.f2226a.h.a(assetBatch, b);
        B0 b0 = this.f2226a;
        InterfaceC2971z5 interfaceC2971z5 = b0.f;
        if (interfaceC2971z5 != null) {
            String str = b0.d;
            ((A5) interfaceC2971z5).b(str, H6.a(str, "access$getTAG$p(...)", "Notifying failure  to ad unit with placement ID (").append(this.f2226a.c).append(')').toString());
        }
        Handler handler = new Handler(Looper.getMainLooper());
        final B0 b02 = this.f2226a;
        handler.post(new Runnable() { // from class: com.inmobi.media.A0$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                A0.a(B0.this, b);
            }
        });
    }

    @Override // com.inmobi.media.InterfaceC2884u1
    public final void a(C2721k assetBatch) {
        Intrinsics.checkNotNullParameter(assetBatch, "assetBatch");
        this.f2226a.h.a(assetBatch);
        B0 b0 = this.f2226a;
        InterfaceC2971z5 interfaceC2971z5 = b0.f;
        if (interfaceC2971z5 != null) {
            String str = b0.d;
            ((A5) interfaceC2971z5).a(str, H6.a(str, "access$getTAG$p(...)", "Notifying ad unit with placement ID (").append(this.f2226a.c).append(')').toString());
        }
        Handler handler = new Handler(Looper.getMainLooper());
        final B0 b02 = this.f2226a;
        handler.post(new Runnable() { // from class: com.inmobi.media.A0$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                A0.a(B0.this);
            }
        });
    }
}
