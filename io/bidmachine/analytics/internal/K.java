package io.bidmachine.analytics.internal;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;

/* loaded from: classes7.dex */
public final class K {

    /* renamed from: a, reason: collision with root package name */
    private Object f6662a;
    private final String b;
    private final String c;
    private final String d;
    private final String e;

    public K() {
        Result.Companion companion = Result.INSTANCE;
        this.f6662a = Result.m10241constructorimpl(ResultKt.createFailure(new NullPointerException()));
        this.b = "amF2YS5sYW5nLlByb2Nlc3NCdWlsZGVy";
        this.c = "c3RhcnQ=";
        this.d = "Z2V0SW5wdXRTdHJlYW0=";
        this.e = "ZGVzdHJveQ==";
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x007e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final InputStream a(List list) {
        Object m10241constructorimpl;
        Object m10241constructorimpl2;
        Method method;
        try {
            Result.Companion companion = Result.INSTANCE;
            Class<?> cls = Class.forName(s0.a(this.b));
            m10241constructorimpl = Result.m10241constructorimpl(cls.getMethod(s0.a(this.c), null).invoke(cls.getConstructor(List.class).newInstance(CollectionsKt.toList(list)), null));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
        this.f6662a = m10241constructorimpl;
        if (Result.m10248isSuccessimpl(m10241constructorimpl)) {
            try {
                Result.Companion companion3 = Result.INSTANCE;
                m10241constructorimpl2 = Result.m10241constructorimpl((InputStream) ((m10241constructorimpl == null || (method = m10241constructorimpl.getClass().getMethod(s0.a(this.d), null)) == null) ? null : method.invoke(m10241constructorimpl, null)));
            } catch (Throwable th2) {
                Result.Companion companion4 = Result.INSTANCE;
                m10241constructorimpl = ResultKt.createFailure(th2);
            }
            return (InputStream) (Result.m10247isFailureimpl(m10241constructorimpl2) ? null : m10241constructorimpl2);
        }
        m10241constructorimpl2 = Result.m10241constructorimpl(m10241constructorimpl);
        return (InputStream) (Result.m10247isFailureimpl(m10241constructorimpl2) ? null : m10241constructorimpl2);
    }

    public final void a() {
        Method method;
        Object obj = this.f6662a;
        if (!Result.m10248isSuccessimpl(obj)) {
            Result.m10241constructorimpl(obj);
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            Object obj2 = null;
            if (obj != null && (method = obj.getClass().getMethod(s0.a(this.e), null)) != null) {
                obj2 = method.invoke(obj, null);
            }
            Result.m10241constructorimpl(obj2);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
    }
}
