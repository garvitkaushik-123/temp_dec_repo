package io.bidmachine.analytics.internal;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes7.dex */
public final class J {
    private static final a d = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final int f6661a;
    private final Map b;
    private final Object c;

    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private a() {
        }
    }

    public J(int i) {
        this.f6661a = i;
        this.b = new LinkedHashMap();
        this.c = new Object();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final InputStream a(String str) {
        Object m10241constructorimpl;
        synchronized (this.c) {
            try {
                Result.Companion companion = Result.INSTANCE;
                L l = (L) this.b.remove(str);
                m10241constructorimpl = Result.m10241constructorimpl(new ByteArrayInputStream(l != null ? M.a(l) : null));
            } finally {
                return (InputStream) (Result.m10247isFailureimpl(m10241constructorimpl) ? null : m10241constructorimpl);
            }
        }
        return (InputStream) (Result.m10247isFailureimpl(m10241constructorimpl) ? null : m10241constructorimpl);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String b(String str) {
        Object m10241constructorimpl;
        Long a2;
        synchronized (this.c) {
            try {
                Result.Companion companion = Result.INSTANCE;
                L l = (L) this.b.get(str);
                m10241constructorimpl = Result.m10241constructorimpl((l == null || (a2 = l.a()) == null) ? null : a2.toString());
            } finally {
                return (String) (Result.m10247isFailureimpl(m10241constructorimpl) ? null : m10241constructorimpl);
            }
        }
        return (String) (Result.m10247isFailureimpl(m10241constructorimpl) ? null : m10241constructorimpl);
    }

    public /* synthetic */ J(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 2097152 : i);
    }

    public final void a(String str, String str2) {
        synchronized (this.c) {
            try {
                Result.Companion companion = Result.INSTANCE;
                Map map = this.b;
                Object obj = map.get(str);
                if (obj == null) {
                    obj = a();
                    map.put(str, obj);
                }
                ((L) obj).a(str2);
                Result.m10241constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m10241constructorimpl(ResultKt.createFailure(th));
            }
        }
    }

    private final L a() {
        int i = this.f6661a;
        return new L(i / 2, i);
    }
}
