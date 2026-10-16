package io.bidmachine.analytics.internal;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* renamed from: io.bidmachine.analytics.internal.l, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C3572l {

    /* renamed from: a, reason: collision with root package name */
    private final Lazy f6715a = LazyKt.lazy(a.f6716a);
    private final Lazy b = LazyKt.lazy(b.f6717a);

    /* renamed from: io.bidmachine.analytics.internal.l$a */
    static final class a extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public static final a f6716a = new a();

        a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final J invoke() {
            return new J(0, 1, null);
        }
    }

    /* renamed from: io.bidmachine.analytics.internal.l$b */
    static final class b extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public static final b f6717a = new b();

        b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final e0 invoke() {
            return new e0();
        }
    }

    public final J a() {
        return (J) this.f6715a.getValue();
    }

    public final e0 b() {
        return (e0) this.b.getValue();
    }
}
