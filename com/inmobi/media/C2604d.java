package com.inmobi.media;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* renamed from: com.inmobi.media.d, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2604d extends Lambda implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Lambda f2540a;
    public final /* synthetic */ InterfaceC2803p0 b;
    public final /* synthetic */ Va c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public C2604d(Function0 function0, InterfaceC2803p0 interfaceC2803p0, Va va) {
        super(0);
        this.f2540a = (Lambda) function0;
        this.b = interfaceC2803p0;
        this.c = va;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [kotlin.jvm.functions.Function0, kotlin.jvm.internal.Lambda] */
    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        try {
            if (((Boolean) this.f2540a.invoke()).booleanValue()) {
                this.c.a(this.b.a());
            } else {
                this.c.onError(new Exception("Capture Aborted: Should Capture not satisfied"));
            }
        } catch (Exception e) {
            this.c.onError(e);
        }
        return Unit.INSTANCE;
    }
}
