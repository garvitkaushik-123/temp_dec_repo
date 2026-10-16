package com.ironsource;

import com.ironsource.mediationsdk.logger.IronSourceError;
import com.unity3d.ironsourceads.AdSize;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* renamed from: com.ironsource.e3, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3056e3 implements Vf {

    /* renamed from: a, reason: collision with root package name */
    private final C3165kb f3264a;
    private final AdSize b;

    /* renamed from: com.ironsource.e3$a */
    static final class a extends Lambda implements Function0<IronSourceError> {

        /* renamed from: a, reason: collision with root package name */
        public static final a f3265a = new a();

        a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final IronSourceError invoke() {
            return C3362w5.f3920a.a("Load task config is null");
        }
    }

    /* renamed from: com.ironsource.e3$b */
    static final class b extends Lambda implements Function0<IronSourceError> {

        /* renamed from: a, reason: collision with root package name */
        public static final b f3266a = new b();

        b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final IronSourceError invoke() {
            return C3362w5.f3920a.l();
        }
    }

    public C3056e3(C3165kb c3165kb, AdSize adSize) {
        this.f3264a = c3165kb;
        this.b = adSize;
    }

    @Override // com.ironsource.Vf
    public void a() {
        a(this.f3264a != null, a.f3265a);
        a(this.b != null, b.f3266a);
    }
}
