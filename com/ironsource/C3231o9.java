package com.ironsource;

import com.ironsource.mediationsdk.logger.IronSourceError;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* renamed from: com.ironsource.o9, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3231o9 implements Vf {

    /* renamed from: a, reason: collision with root package name */
    private final C3165kb f3618a;

    /* renamed from: com.ironsource.o9$a */
    static final class a extends Lambda implements Function0<IronSourceError> {

        /* renamed from: a, reason: collision with root package name */
        public static final a f3619a = new a();

        a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final IronSourceError invoke() {
            return C3362w5.f3920a.b("Load task config is null");
        }
    }

    public C3231o9(C3165kb c3165kb) {
        this.f3618a = c3165kb;
    }

    @Override // com.ironsource.Vf
    public void a() {
        a(this.f3618a != null, a.f3619a);
    }
}
