package com.ironsource;

import com.ironsource.AbstractC3292s3;
import com.ironsource.mediationsdk.logger.IronLog;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class qg<Smash extends AbstractC3292s3<?>> {

    /* renamed from: a, reason: collision with root package name */
    private final U f3660a;

    public static final class a<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            return ComparisonsKt.compareValues(Integer.valueOf(((AbstractC3292s3) t).i().l()), Integer.valueOf(((AbstractC3292s3) t2).i().l()));
        }
    }

    public qg(U managerData) {
        Intrinsics.checkNotNullParameter(managerData, "managerData");
        this.f3660a = managerData;
    }

    public final boolean a(AbstractC3292s3<?> smash, List<? extends Smash> waterfall) {
        Object obj;
        Intrinsics.checkNotNullParameter(smash, "smash");
        Intrinsics.checkNotNullParameter(waterfall, "waterfall");
        Iterator<T> it = b(waterfall).iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (!((AbstractC3292s3) obj).x()) {
                break;
            }
        }
        return Intrinsics.areEqual(obj, smash);
    }

    public final List<Smash> b(List<? extends Smash> waterfall) {
        Intrinsics.checkNotNullParameter(waterfall, "waterfall");
        return CollectionsKt.sortedWith(waterfall, new a());
    }

    public final Smash c(List<? extends Smash> waterfall) {
        Object obj;
        Intrinsics.checkNotNullParameter(waterfall, "waterfall");
        Iterator<T> it = b(waterfall).iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((AbstractC3292s3) obj).B()) {
                break;
            }
        }
        return (Smash) obj;
    }

    public final rg<Smash> d(List<? extends Smash> waterfall) {
        Intrinsics.checkNotNullParameter(waterfall, "waterfall");
        IronLog.INTERNAL.verbose(this.f3660a.b().name() + " waterfall size: " + waterfall.size());
        sg a2 = sg.g.a(this.f3660a.c() ? og.BIDDER_SENSITIVE : og.DEFAULT, this.f3660a.i(), this.f3660a.m(), waterfall);
        Iterator<? extends Smash> it = waterfall.iterator();
        while (it.hasNext()) {
            a2.d(it.next());
            if (a2.e()) {
                return new rg<>(a2);
            }
        }
        return new rg<>(a2);
    }

    public final boolean a(List<? extends Smash> waterfall) {
        int i;
        Intrinsics.checkNotNullParameter(waterfall, "waterfall");
        if ((waterfall instanceof Collection) && waterfall.isEmpty()) {
            i = 0;
        } else {
            Iterator<T> it = waterfall.iterator();
            i = 0;
            while (it.hasNext()) {
                if (((AbstractC3292s3) it.next()).y() && (i = i + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
            }
        }
        return i >= this.f3660a.i();
    }
}
