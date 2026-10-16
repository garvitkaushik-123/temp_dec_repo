package com.ironsource;

import com.ironsource.mediationsdk.logger.IronLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public abstract class F {
    public static final a c = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final AbstractC3340v0 f2852a;
    private final kg b;

    public static final class a {

        /* renamed from: com.ironsource.F$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0280a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f2853a;

            static {
                int[] iArr = new int[og.values().length];
                try {
                    iArr[og.BIDDER_SENSITIVE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[og.DEFAULT.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                f2853a = iArr;
            }
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final F a(AbstractC3340v0 adUnitData, kg waterfallInstances) {
            Intrinsics.checkNotNullParameter(adUnitData, "adUnitData");
            Intrinsics.checkNotNullParameter(waterfallInstances, "waterfallInstances");
            int i = C0280a.f2853a[(adUnitData.d() ? og.BIDDER_SENSITIVE : og.DEFAULT).ordinal()];
            if (i == 1) {
                return new C3360w3(adUnitData, waterfallInstances);
            }
            if (i == 2) {
                return adUnitData.q() ? new Ve(adUnitData, waterfallInstances) : new J4(adUnitData, waterfallInstances);
            }
            throw new NoWhenBranchMatchedException();
        }

        private a() {
        }
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final List<AbstractC3407z> f2854a = new ArrayList();
        private final List<AbstractC3407z> b = new ArrayList();
        private final List<AbstractC3407z> c = new ArrayList();
        private boolean d;

        public final List<AbstractC3407z> a() {
            return this.f2854a;
        }

        public final List<AbstractC3407z> b() {
            return this.b;
        }

        public final List<AbstractC3407z> c() {
            return this.c;
        }

        public final boolean d() {
            return this.d;
        }

        public final boolean e() {
            return g() == 0;
        }

        public final boolean f() {
            return this.f2854a.isEmpty() && this.c.isEmpty();
        }

        public final int g() {
            return this.f2854a.size() + this.b.size() + this.c.size();
        }

        public final void a(boolean z) {
            this.d = z;
        }
    }

    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        private final AbstractC3407z f2855a;
        private final List<AbstractC3407z> b;

        /* JADX WARN: Multi-variable type inference failed */
        public c(AbstractC3407z abstractC3407z, List<? extends AbstractC3407z> orderedInstances) {
            Intrinsics.checkNotNullParameter(orderedInstances, "orderedInstances");
            this.f2855a = abstractC3407z;
            this.b = orderedInstances;
        }

        public final AbstractC3407z a() {
            return this.f2855a;
        }

        public final List<AbstractC3407z> b() {
            return this.b;
        }

        public final AbstractC3407z c() {
            return this.f2855a;
        }

        public final List<AbstractC3407z> d() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return Intrinsics.areEqual(this.f2855a, cVar.f2855a) && Intrinsics.areEqual(this.b, cVar.b);
        }

        public int hashCode() {
            AbstractC3407z abstractC3407z = this.f2855a;
            return ((abstractC3407z == null ? 0 : abstractC3407z.hashCode()) * 31) + this.b.hashCode();
        }

        public String toString() {
            return "ShowSelection(instanceToShow=" + this.f2855a + ", orderedInstances=" + this.b + ")";
        }

        public final c a(AbstractC3407z abstractC3407z, List<? extends AbstractC3407z> orderedInstances) {
            Intrinsics.checkNotNullParameter(orderedInstances, "orderedInstances");
            return new c(abstractC3407z, orderedInstances);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ c a(c cVar, AbstractC3407z abstractC3407z, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                abstractC3407z = cVar.f2855a;
            }
            if ((i & 2) != 0) {
                list = cVar.b;
            }
            return cVar.a(abstractC3407z, list);
        }
    }

    public static final class d<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            return ComparisonsKt.compareValues(Integer.valueOf(((AbstractC3407z) t).h().l()), Integer.valueOf(((AbstractC3407z) t2).h().l()));
        }
    }

    public F(AbstractC3340v0 adUnitData, kg waterfallInstances) {
        Intrinsics.checkNotNullParameter(adUnitData, "adUnitData");
        Intrinsics.checkNotNullParameter(waterfallInstances, "waterfallInstances");
        this.f2852a = adUnitData;
        this.b = waterfallInstances;
    }

    private final List<AbstractC3407z> b() {
        return CollectionsKt.sortedWith(this.b.b(), new d());
    }

    public abstract void a(AbstractC3407z abstractC3407z, b bVar);

    protected boolean a(AbstractC3407z instance, kg waterfallInstances) {
        Intrinsics.checkNotNullParameter(instance, "instance");
        Intrinsics.checkNotNullParameter(waterfallInstances, "waterfallInstances");
        return false;
    }

    public final c c() {
        Object obj;
        List<AbstractC3407z> b2 = b();
        Iterator<T> it = b2.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((AbstractC3407z) obj).w()) {
                break;
            }
        }
        return new c((AbstractC3407z) obj, b2);
    }

    public final b d() {
        IronLog.INTERNAL.verbose(this.f2852a.b().a().name() + " waterfall size: " + this.b.b().size());
        b bVar = new b();
        Iterator<AbstractC3407z> it = this.b.b().iterator();
        while (it.hasNext() && !b(it.next(), bVar)) {
        }
        return bVar;
    }

    public final boolean a(AbstractC3407z instance) {
        Object obj;
        Intrinsics.checkNotNullParameter(instance, "instance");
        Iterator<T> it = b().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (!((AbstractC3407z) obj).v()) {
                break;
            }
        }
        return Intrinsics.areEqual(obj, instance);
    }

    private final boolean b(AbstractC3407z abstractC3407z, b bVar) {
        if (abstractC3407z.v()) {
            IronLog.INTERNAL.verbose(abstractC3407z.d().name() + " - Instance " + abstractC3407z.q() + " is failed to load");
        } else if (abstractC3407z.w()) {
            IronLog.INTERNAL.verbose(abstractC3407z.d().name() + " - Instance " + abstractC3407z.q() + " is already loaded");
            bVar.b().add(abstractC3407z);
        } else if (abstractC3407z.x()) {
            IronLog.INTERNAL.verbose(abstractC3407z.d().name() + " - Instance " + abstractC3407z.q() + " still loading");
            bVar.c().add(abstractC3407z);
        } else if (a(abstractC3407z, this.b)) {
            IronLog.INTERNAL.verbose(abstractC3407z.d().name() + " - Instance " + abstractC3407z.q() + " is not better than already loaded instances");
        } else {
            a(abstractC3407z, bVar);
        }
        return a(bVar);
    }

    public final boolean a() {
        int i;
        List<AbstractC3407z> b2 = this.b.b();
        if ((b2 instanceof Collection) && b2.isEmpty()) {
            i = 0;
        } else {
            Iterator<T> it = b2.iterator();
            i = 0;
            while (it.hasNext()) {
                if (((AbstractC3407z) it.next()).w() && (i = i + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
            }
        }
        return i >= this.f2852a.k();
    }

    public boolean a(b loadSelection) {
        Intrinsics.checkNotNullParameter(loadSelection, "loadSelection");
        return loadSelection.g() >= this.f2852a.k();
    }
}
