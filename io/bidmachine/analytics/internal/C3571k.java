package io.bidmachine.analytics.internal;

import android.content.Context;
import io.bidmachine.analytics.AnalyticsConfig;
import io.bidmachine.analytics.MonitorConfig;
import io.bidmachine.analytics.ReaderConfig;
import io.bidmachine.analytics.internal.AbstractC3565e;
import io.bidmachine.analytics.internal.AbstractC3567g;
import io.bidmachine.analytics.internal.AbstractC3569i;
import io.bidmachine.analytics.internal.InterfaceC3568h;
import io.bidmachine.analytics.internal.h0;
import io.bidmachine.analytics.internal.q0;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;

/* renamed from: io.bidmachine.analytics.internal.k, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C3571k {

    /* renamed from: a, reason: collision with root package name */
    public static final C3571k f6712a = new C3571k();
    private static final AtomicBoolean b = new AtomicBoolean(false);
    private static Map c = MapsKt.emptyMap();
    private static final C3572l d = new C3572l();

    /* renamed from: io.bidmachine.analytics.internal.k$b */
    private static final class b implements InterfaceC3568h {

        /* renamed from: a, reason: collision with root package name */
        private final String f6714a;

        public b(String str) {
            this.f6714a = str;
        }

        @Override // io.bidmachine.analytics.internal.InterfaceC3568h
        public void a(List list) {
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                InterfaceC3568h.a aVar = (InterfaceC3568h.a) it.next();
                String str = this.f6714a;
                String a2 = aVar.a();
                if (a2 == null) {
                    a2 = "";
                }
                arrayList.add(new h0(null, str, 0L, a2, new h0.a(aVar.c().getTag(), aVar.c().getPath()), aVar.b(), false, 69, null));
            }
            C3573m.f6718a.a(this.f6714a, arrayList);
        }
    }

    private C3571k() {
    }

    public final void b(Context context) {
        if (b.compareAndSet(false, true) && !s0.a(context)) {
            c = a(context);
        }
    }

    public final C3572l a() {
        return d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Map a(Context context) {
        Object m10241constructorimpl;
        Object m10241constructorimpl2;
        Object m10241constructorimpl3;
        Object m10241constructorimpl4;
        Object m10241constructorimpl5;
        Object m10241constructorimpl6;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        try {
            Result.Companion companion = Result.INSTANCE;
            O o = new O();
            o.a(context);
            linkedHashMap.put(o.a(), o);
            m10241constructorimpl = Result.m10241constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
        Throwable m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(m10241constructorimpl);
        if (m10244exceptionOrNullimpl != null) {
            f6712a.a("mimp", "", m10244exceptionOrNullimpl);
        }
        try {
            Result.Companion companion3 = Result.INSTANCE;
            A a2 = new A();
            a2.a(context);
            linkedHashMap.put(a2.a(), a2);
            m10241constructorimpl2 = Result.m10241constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion4 = Result.INSTANCE;
            m10241constructorimpl2 = Result.m10241constructorimpl(ResultKt.createFailure(th2));
        }
        Throwable m10244exceptionOrNullimpl2 = Result.m10244exceptionOrNullimpl(m10241constructorimpl2);
        if (m10244exceptionOrNullimpl2 != null) {
            f6712a.a("isimp", "", m10244exceptionOrNullimpl2);
        }
        try {
            Result.Companion companion5 = Result.INSTANCE;
            C3585z c3585z = new C3585z(context.getFilesDir().getParentFile());
            c3585z.a(context);
            linkedHashMap.put(c3585z.a(), c3585z);
            m10241constructorimpl3 = Result.m10241constructorimpl(Unit.INSTANCE);
        } catch (Throwable th3) {
            Result.Companion companion6 = Result.INSTANCE;
            m10241constructorimpl3 = Result.m10241constructorimpl(ResultKt.createFailure(th3));
        }
        Throwable m10244exceptionOrNullimpl3 = Result.m10244exceptionOrNullimpl(m10241constructorimpl3);
        if (m10244exceptionOrNullimpl3 != null) {
            f6712a.a("aints", m10244exceptionOrNullimpl3);
        }
        try {
            Result.Companion companion7 = Result.INSTANCE;
            C3581v c3581v = new C3581v();
            c3581v.a(context);
            linkedHashMap.put(c3581v.a(), c3581v);
            m10241constructorimpl4 = Result.m10241constructorimpl(Unit.INSTANCE);
        } catch (Throwable th4) {
            Result.Companion companion8 = Result.INSTANCE;
            m10241constructorimpl4 = Result.m10241constructorimpl(ResultKt.createFailure(th4));
        }
        Throwable m10244exceptionOrNullimpl4 = Result.m10244exceptionOrNullimpl(m10241constructorimpl4);
        if (m10244exceptionOrNullimpl4 != null) {
            f6712a.a("aexs", m10244exceptionOrNullimpl4);
        }
        int i = 2;
        Function1 function1 = null;
        Object[] objArr = 0;
        try {
            Result.Companion companion9 = Result.INSTANCE;
            H h = new H(d.a(), null, 2, null);
            h.a(context);
            linkedHashMap.put(h.a(), h);
            m10241constructorimpl5 = Result.m10241constructorimpl(Unit.INSTANCE);
        } catch (Throwable th5) {
            Result.Companion companion10 = Result.INSTANCE;
            m10241constructorimpl5 = Result.m10241constructorimpl(ResultKt.createFailure(th5));
        }
        Throwable m10244exceptionOrNullimpl5 = Result.m10244exceptionOrNullimpl(m10241constructorimpl5);
        if (m10244exceptionOrNullimpl5 != null) {
            f6712a.a("alog", m10244exceptionOrNullimpl5);
        }
        try {
            Result.Companion companion11 = Result.INSTANCE;
            d0 d0Var = new d0(d.b(), function1, i, objArr == true ? 1 : 0);
            d0Var.a(context);
            linkedHashMap.put(d0Var.a(), d0Var);
            m10241constructorimpl6 = Result.m10241constructorimpl(Unit.INSTANCE);
        } catch (Throwable th6) {
            Result.Companion companion12 = Result.INSTANCE;
            m10241constructorimpl6 = Result.m10241constructorimpl(ResultKt.createFailure(th6));
        }
        Throwable m10244exceptionOrNullimpl6 = Result.m10244exceptionOrNullimpl(m10241constructorimpl6);
        if (m10244exceptionOrNullimpl6 != null) {
            f6712a.a("apur", m10244exceptionOrNullimpl6);
        }
        return linkedHashMap;
    }

    /* renamed from: io.bidmachine.analytics.internal.k$a */
    private static final class a implements InterfaceC3566f {

        /* renamed from: a, reason: collision with root package name */
        private final String f6713a;
        private final String b;

        public a(String str, String str2) {
            this.f6713a = str;
            this.b = str2;
        }

        @Override // io.bidmachine.analytics.internal.InterfaceC3566f
        public void a(Map map) {
            C3573m.f6718a.a(new Q(null, this.f6713a, this.b, 0L, map, null, 41, null));
        }

        @Override // io.bidmachine.analytics.internal.InterfaceC3566f
        public void a(q0 q0Var) {
            C3573m.f6718a.a(new Q(null, this.f6713a, this.b, 0L, null, q0Var, 25, null));
        }
    }

    private final void b(Context context, String str, Set set) {
        Object m10241constructorimpl;
        Context applicationContext = context.getApplicationContext();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            AbstractC3570j abstractC3570j = (AbstractC3570j) c.get((String) it.next());
            if (abstractC3570j != null) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    abstractC3570j.c(applicationContext);
                    m10241constructorimpl = Result.m10241constructorimpl(Unit.INSTANCE);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
                }
                Throwable m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(m10241constructorimpl);
                if (m10244exceptionOrNullimpl != null) {
                    f6712a.a(abstractC3570j, str, m10244exceptionOrNullimpl);
                }
            }
        }
    }

    public final void a(Context context, AnalyticsConfig analyticsConfig) {
        a(context, analyticsConfig.getCom.unity3d.services.core.device.reader.JsonStorageKeyNames.SESSION_ID_KEY java.lang.String(), c.keySet());
        HashSet hashSet = new HashSet();
        a(analyticsConfig.getCom.unity3d.services.core.device.reader.JsonStorageKeyNames.SESSION_ID_KEY java.lang.String(), analyticsConfig.getMonitorConfigList(), hashSet);
        a(analyticsConfig.getReaderConfigList(), hashSet);
        b(context, analyticsConfig.getCom.unity3d.services.core.device.reader.JsonStorageKeyNames.SESSION_ID_KEY java.lang.String(), hashSet);
    }

    public final Map a(AbstractC3565e.a aVar) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : c.entrySet()) {
            String str = (String) entry.getKey();
            AbstractC3570j abstractC3570j = (AbstractC3570j) entry.getValue();
            if (abstractC3570j instanceof AbstractC3565e) {
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                AbstractC3565e abstractC3565e = (AbstractC3565e) abstractC3570j;
                AbstractC3565e.b b2 = abstractC3565e.b();
                if (b2 != null) {
                    linkedHashMap2.put("imd", Integer.valueOf(b2.a()));
                    linkedHashMap2.put("wp", Float.valueOf(b2.b()));
                    linkedHashMap2.put("agency", b2.c());
                }
                AbstractC3565e.b a2 = abstractC3565e.a(aVar);
                if (a2 != null) {
                    linkedHashMap2.put("imimd", Integer.valueOf(a2.a()));
                    linkedHashMap2.put("imwp", Float.valueOf(a2.b()));
                    linkedHashMap2.put("imagency", a2.c());
                }
                linkedHashMap.put(str, linkedHashMap2);
            }
        }
        return linkedHashMap;
    }

    private final void a(String str, List list, Set set) {
        Object m10241constructorimpl;
        Unit unit;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String name = ((MonitorConfig) it.next()).getName();
            try {
                Result.Companion companion = Result.INSTANCE;
                AbstractC3570j abstractC3570j = (AbstractC3570j) c.get(name);
                if (abstractC3570j != null) {
                    if (abstractC3570j instanceof AbstractC3567g) {
                        ((AbstractC3567g) abstractC3570j).a(new AbstractC3567g.a(new a(name, str)));
                    }
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                m10241constructorimpl = Result.m10241constructorimpl(unit);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m10248isSuccessimpl(m10241constructorimpl)) {
                set.add(name);
            }
            Throwable m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(m10241constructorimpl);
            if (m10244exceptionOrNullimpl != null) {
                f6712a.a(name, str, m10244exceptionOrNullimpl);
            }
        }
    }

    private final void a(List list, Set set) {
        Object m10241constructorimpl;
        Unit unit;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ReaderConfig readerConfig = (ReaderConfig) it.next();
            String name = readerConfig.getName();
            try {
                Result.Companion companion = Result.INSTANCE;
                AbstractC3570j abstractC3570j = (AbstractC3570j) c.get(name);
                if (abstractC3570j != null) {
                    if (abstractC3570j instanceof AbstractC3569i) {
                        ((AbstractC3569i) abstractC3570j).a((Object) new AbstractC3569i.a(readerConfig.getInterval(), readerConfig.getRules(), new b(name)));
                    }
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                m10241constructorimpl = Result.m10241constructorimpl(unit);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m10248isSuccessimpl(m10241constructorimpl)) {
                set.add(name);
            }
            Throwable m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(m10241constructorimpl);
            if (m10244exceptionOrNullimpl != null) {
                f6712a.a(name, m10244exceptionOrNullimpl);
            }
        }
    }

    private final void a(Context context, String str, Set set) {
        Object m10241constructorimpl;
        Context applicationContext = context.getApplicationContext();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            AbstractC3570j abstractC3570j = (AbstractC3570j) c.get((String) it.next());
            if (abstractC3570j != null) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    abstractC3570j.b(applicationContext);
                    m10241constructorimpl = Result.m10241constructorimpl(Unit.INSTANCE);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
                }
                Throwable m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(m10241constructorimpl);
                if (m10244exceptionOrNullimpl != null) {
                    f6712a.a(abstractC3570j, str, m10244exceptionOrNullimpl);
                }
            }
        }
    }

    private final void a(AbstractC3570j abstractC3570j, String str, Throwable th) {
        if (abstractC3570j instanceof AbstractC3567g) {
            a(abstractC3570j.a(), str, th);
        } else if (abstractC3570j instanceof AbstractC3569i) {
            a(abstractC3570j.a(), th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(String str, String str2, Throwable th) {
        C3573m.f6718a.a(new Q(null, str, str2, 0L, null, new q0(str, q0.a.MONITOR_INVALID, s0.a(th)), 25, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(String str, Throwable th) {
        C3573m.f6718a.a(new h0(null, str, 0L, "", new h0.a("", ""), new q0(str, q0.a.READER_INVALID, s0.a(th)), false, 69, null));
    }
}
