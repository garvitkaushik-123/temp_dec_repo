package io.bidmachine.analytics.internal;

import android.content.Context;
import io.bidmachine.analytics.AnalyticsConfig;
import io.bidmachine.analytics.MonitorConfig;
import io.bidmachine.analytics.ReaderConfig;
import io.bidmachine.analytics.internal.X;
import io.bidmachine.analytics.internal.g0;
import io.bidmachine.analytics.internal.h0;
import io.bidmachine.analytics.internal.n0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* renamed from: io.bidmachine.analytics.internal.m, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C3573m {

    /* renamed from: a, reason: collision with root package name */
    public static final C3573m f6718a = new C3573m();
    private static final p0 b;
    private static final CoroutineScope c;
    private static C3563c d;
    private static V e;
    private static l0 f;
    private static Map g;
    private static Map h;
    private static final List i;

    /* renamed from: io.bidmachine.analytics.internal.m$a */
    static final class a extends SuspendLambda implements Function2 {

        /* renamed from: a, reason: collision with root package name */
        int f6719a;
        final /* synthetic */ V b;
        final /* synthetic */ String c;
        final /* synthetic */ List d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(V v, String str, List list, Continuation continuation) {
            super(2, continuation);
            this.b = v;
            this.c = str;
            this.d = list;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new a(this.b, this.c, this.d, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f6719a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.b.a(this.c, this.d);
            return Unit.INSTANCE;
        }
    }

    /* renamed from: io.bidmachine.analytics.internal.m$b */
    static final class b extends SuspendLambda implements Function2 {

        /* renamed from: a, reason: collision with root package name */
        int f6720a;
        final /* synthetic */ l0 b;
        final /* synthetic */ List c;
        final /* synthetic */ List d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(l0 l0Var, List list, List list2, Continuation continuation) {
            super(2, continuation);
            this.b = l0Var;
            this.c = list;
            this.d = list2;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new b(this.b, this.c, this.d, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f6720a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.b.a(this.c, this.d);
            return Unit.INSTANCE;
        }
    }

    static {
        p0 a2 = p0.g.a();
        b = a2;
        c = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(a2.b()));
        g = MapsKt.emptyMap();
        h = MapsKt.emptyMap();
        i = Collections.synchronizedList(new ArrayList());
    }

    private C3573m() {
    }

    private final synchronized l0 b(C3563c c3563c) {
        l0 l0Var;
        l0 l0Var2 = f;
        l0Var = l0Var2;
        if (l0Var2 == null) {
            m0 m0Var = new m0(c3563c);
            m0Var.b();
            f = m0Var;
            l0Var = m0Var;
        }
        return l0Var;
    }

    public final void a(Context context, AnalyticsConfig analyticsConfig) {
        synchronized (this) {
            C3573m c3573m = f6718a;
            C3563c a2 = c3573m.a(context);
            V a3 = c3573m.a(a2);
            l0 b2 = c3573m.b(a2);
            c3573m.a(g);
            g = c3573m.a(analyticsConfig, a3);
            h = c3573m.a(context, analyticsConfig, b2);
            c3573m.a(analyticsConfig.getCom.unity3d.services.core.device.reader.JsonStorageKeyNames.SESSION_ID_KEY java.lang.String());
            String str = analyticsConfig.getCom.unity3d.services.core.device.reader.JsonStorageKeyNames.SESSION_ID_KEY java.lang.String();
            List<MonitorConfig> monitorConfigList = analyticsConfig.getMonitorConfigList();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(monitorConfigList, 10));
            Iterator<T> it = monitorConfigList.iterator();
            while (it.hasNext()) {
                arrayList.add(((MonitorConfig) it.next()).getName());
            }
            c3573m.a(a3, str, arrayList);
            C3573m c3573m2 = f6718a;
            List<ReaderConfig> readerConfigList = analyticsConfig.getReaderConfigList();
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(readerConfigList, 10));
            Iterator<T> it2 = readerConfigList.iterator();
            while (it2.hasNext()) {
                arrayList2.add(((ReaderConfig) it2.next()).getName());
            }
            List<ReaderConfig> readerConfigList2 = analyticsConfig.getReaderConfigList();
            ArrayList<List> arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(readerConfigList2, 10));
            Iterator<T> it3 = readerConfigList2.iterator();
            while (it3.hasNext()) {
                arrayList3.add(((ReaderConfig) it3.next()).getRules());
            }
            ArrayList arrayList4 = new ArrayList();
            for (List<ReaderConfig.Rule> list : arrayList3) {
                ArrayList arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                for (ReaderConfig.Rule rule : list) {
                    arrayList5.add(new h0.a(rule.getTag(), rule.getPath()));
                }
                CollectionsKt.addAll(arrayList4, arrayList5);
            }
            c3573m2.a(b2, arrayList2, arrayList4);
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void a(Map map) {
        Iterator it = map.values().iterator();
        while (it.hasNext()) {
            ((X) it.next()).a();
        }
    }

    private final V a(C3563c c3563c) {
        V v = e;
        if (v != null) {
            return v;
        }
        W w = new W(c3563c);
        w.b();
        e = w;
        return w;
    }

    private final synchronized C3563c a(Context context) {
        C3563c c3563c;
        c3563c = d;
        if (c3563c == null) {
            c3563c = new C3563c(context);
            d = c3563c;
        }
        return c3563c;
    }

    private final Map a(AnalyticsConfig analyticsConfig, V v) {
        List<MonitorConfig> monitorConfigList = analyticsConfig.getMonitorConfigList();
        ArrayList arrayList = new ArrayList();
        for (Object obj : monitorConfigList) {
            if (((MonitorConfig) obj).getIsReportEnabled()) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(new X(p0.g.a(), new X.b((MonitorConfig) it.next(), analyticsConfig.getCom.unity3d.services.core.device.reader.JsonStorageKeyNames.SESSION_ID_KEY java.lang.String(), analyticsConfig.getExtras()), v));
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(arrayList2, 10)), 16));
        for (Object obj2 : arrayList2) {
            linkedHashMap.put(((X) obj2).b(), obj2);
        }
        return linkedHashMap;
    }

    private final Map a(Context context, AnalyticsConfig analyticsConfig, l0 l0Var) {
        g0.a c3580u;
        n0 n0Var;
        List<ReaderConfig> readerConfigList = analyticsConfig.getReaderConfigList();
        ArrayList arrayList = new ArrayList();
        for (ReaderConfig readerConfig : readerConfigList) {
            String name = readerConfig.getName();
            int hashCode = name.hashCode();
            if (hashCode == 2990623) {
                if (name.equals("aexs")) {
                    c3580u = new C3580u();
                    n0Var = new n0(p0.g.a(), new n0.a(readerConfig, analyticsConfig.getCom.unity3d.services.core.device.reader.JsonStorageKeyNames.SESSION_ID_KEY java.lang.String(), analyticsConfig.getExtras(), c3580u), l0Var);
                }
                n0Var = null;
            } else if (hashCode == 2997059) {
                if (name.equals("alog")) {
                    c3580u = new E(C3571k.f6712a.a().a());
                    n0Var = new n0(p0.g.a(), new n0.a(readerConfig, analyticsConfig.getCom.unity3d.services.core.device.reader.JsonStorageKeyNames.SESSION_ID_KEY java.lang.String(), analyticsConfig.getExtras(), c3580u), l0Var);
                }
                n0Var = null;
            } else if (hashCode != 3001100) {
                if (hashCode == 92819013 && name.equals("aints")) {
                    c3580u = new C3584y(context.getFilesDir().getParentFile());
                    n0Var = new n0(p0.g.a(), new n0.a(readerConfig, analyticsConfig.getCom.unity3d.services.core.device.reader.JsonStorageKeyNames.SESSION_ID_KEY java.lang.String(), analyticsConfig.getExtras(), c3580u), l0Var);
                }
                n0Var = null;
            } else {
                if (name.equals("apur")) {
                    c3580u = new c0(C3571k.f6712a.a().b());
                    n0Var = new n0(p0.g.a(), new n0.a(readerConfig, analyticsConfig.getCom.unity3d.services.core.device.reader.JsonStorageKeyNames.SESSION_ID_KEY java.lang.String(), analyticsConfig.getExtras(), c3580u), l0Var);
                }
                n0Var = null;
            }
            if (n0Var != null) {
                arrayList.add(n0Var);
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(arrayList, 10)), 16));
        for (Object obj : arrayList) {
            linkedHashMap.put(((n0) obj).a(), obj);
        }
        return linkedHashMap;
    }

    private final void a(String str) {
        List list = i;
        List list2 = CollectionsKt.toList(list);
        list.clear();
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            String str2 = str;
            f6718a.a(Q.a((Q) it.next(), null, null, str2, 0L, null, null, 59, null));
            str = str2;
        }
    }

    private final void a(V v, String str, List list) {
        BuildersKt__Builders_commonKt.launch$default(c, b.c(), null, new a(v, str, list, null), 2, null);
    }

    private final void a(l0 l0Var, List list, List list2) {
        BuildersKt__Builders_commonKt.launch$default(c, b.c(), null, new b(l0Var, list, list2, null), 2, null);
    }

    public final void a(Q q) {
        if (Intrinsics.areEqual(q.e(), "")) {
            i.add(q);
            return;
        }
        X x = (X) g.get(q.d());
        if (x != null) {
            x.b(q);
        }
    }

    public final void a(h0 h0Var) {
        a(h0Var.d(), CollectionsKt.listOf(h0Var));
    }

    public final void a(String str, List list) {
        n0 n0Var = (n0) h.get(str);
        if (n0Var != null) {
            n0Var.b(str, list);
        }
    }
}
