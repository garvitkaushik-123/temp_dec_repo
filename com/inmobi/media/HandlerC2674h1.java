package com.inmobi.media;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.h1, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class HandlerC2674h1 extends Handler {

    /* renamed from: a, reason: collision with root package name */
    public boolean f2584a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HandlerC2674h1(Looper looper) {
        super(looper);
        Intrinsics.checkNotNullParameter(looper, "looper");
        this.f2584a = true;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message msg) {
        boolean z;
        Intrinsics.checkNotNullParameter(msg, "msg");
        z = C2723k1.c;
        if (z) {
            return;
        }
        int i = msg.what;
        if (i == 1001 && this.f2584a) {
            this.f2584a = false;
            C2723k1.a(C2723k1.f2618a, false);
            Intrinsics.checkNotNullExpressionValue(C2723k1.b(), "access$getTAG$p(...)");
        } else {
            if (i != 1002 || this.f2584a) {
                return;
            }
            this.f2584a = true;
            C2723k1.a(C2723k1.f2618a, true);
            Intrinsics.checkNotNullExpressionValue(C2723k1.b(), "access$getTAG$p(...)");
        }
    }
}
