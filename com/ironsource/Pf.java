package com.ironsource;

import com.ironsource.mediationsdk.logger.IronLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes6.dex */
public final class Pf implements Nf {

    /* renamed from: a, reason: collision with root package name */
    public static final Pf f2998a = new Pf();
    private static final Lazy b = LazyKt.lazy(a.f2999a);

    static final class a extends Lambda implements Function0<String> {

        /* renamed from: a, reason: collision with root package name */
        public static final a f2999a = new a();

        a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            try {
                Object invoke = Class.forName(Of.f2983a).getMethod("getVersion", null).invoke(null, null);
                if (invoke instanceof String) {
                    return (String) invoke;
                }
                return null;
            } catch (Throwable th) {
                C3260q4.d().a(th);
                IronLog.INTERNAL.warning(th.getMessage());
                return null;
            }
        }
    }

    private Pf() {
    }

    @Override // com.ironsource.Nf
    public String a() {
        return (String) b.getValue();
    }
}
