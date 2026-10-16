package io.bidmachine.analytics.internal;

import android.content.Context;
import io.bidmachine.analytics.ReaderConfig;
import io.bidmachine.analytics.internal.AbstractC3569i;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes7.dex */
public final class H extends AbstractC3569i {
    public static final a j = new a(null);
    private final J g;
    private final I h;
    private final String i;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private a() {
        }
    }

    public /* synthetic */ H(J j2, I i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j2, (i2 & 2) != 0 ? new I(j2, null, 2, null) : i);
    }

    @Override // io.bidmachine.analytics.internal.AbstractC3570j
    public String a() {
        return this.i;
    }

    @Override // io.bidmachine.analytics.internal.AbstractC3570j
    public void d(Context context) {
    }

    @Override // io.bidmachine.analytics.internal.AbstractC3569i, io.bidmachine.analytics.internal.AbstractC3570j
    public void e(Context context) {
        super.e(context);
        this.h.a();
    }

    @Override // io.bidmachine.analytics.internal.AbstractC3569i, io.bidmachine.analytics.internal.AbstractC3570j
    public void f(Context context) {
        this.h.b();
        super.f(context);
    }

    @Override // io.bidmachine.analytics.internal.AbstractC3569i, io.bidmachine.analytics.internal.AbstractC3570j
    /* renamed from: a */
    public void b(AbstractC3569i.a aVar) {
        super.b(aVar);
        this.h.a(aVar);
    }

    public H(J j2, I i) {
        this.g = j2;
        this.h = i;
        this.i = "alog";
    }

    @Override // io.bidmachine.analytics.internal.AbstractC3569i
    public Object a(ReaderConfig.Rule rule, Continuation continuation) {
        return this.h.a(rule);
    }
}
