package com.inmobi.media;

import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.s7, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2857s7 implements InterfaceC2841r7 {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC2841r7 f2703a;
    public final AtomicBoolean b;

    public C2857s7(InterfaceC2841r7 mediaChangeReceiver) {
        Intrinsics.checkNotNullParameter(mediaChangeReceiver, "mediaChangeReceiver");
        this.f2703a = mediaChangeReceiver;
        this.b = new AtomicBoolean(false);
    }

    @Override // com.inmobi.media.InterfaceC2841r7
    public final void a() {
        if (this.b.getAndSet(false)) {
            this.f2703a.a();
        }
    }

    @Override // com.inmobi.media.InterfaceC2841r7
    public final void b() {
        if (this.b.getAndSet(true)) {
            return;
        }
        this.f2703a.b();
    }
}
