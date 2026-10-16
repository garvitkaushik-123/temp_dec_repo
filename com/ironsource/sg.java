package com.ironsource;

import com.ironsource.AbstractC3292s3;
import com.ironsource.mediationsdk.logger.IronLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public abstract class sg<Smash extends AbstractC3292s3<?>> {
    public static final a g = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final int f3830a;
    private final boolean b;
    private final List<Smash> c;
    private final List<Smash> d;
    private final List<Smash> e;
    private final List<Smash> f;

    public static final class a {

        /* renamed from: com.ironsource.sg$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0306a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f3831a;

            static {
                int[] iArr = new int[og.values().length];
                try {
                    iArr[og.DEFAULT.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[og.BIDDER_SENSITIVE.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                f3831a = iArr;
            }
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final <Smash extends AbstractC3292s3<?>> sg<Smash> a(og loadingStrategy, int i, boolean z, List<? extends Smash> waterfall) {
            Intrinsics.checkNotNullParameter(loadingStrategy, "loadingStrategy");
            Intrinsics.checkNotNullParameter(waterfall, "waterfall");
            int i2 = C0306a.f3831a[loadingStrategy.ordinal()];
            if (i2 == 1) {
                return new M4(i, z, waterfall);
            }
            if (i2 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            return new C3377x3(i, z, waterfall, false, 8, null);
        }

        private a() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public sg(int i, boolean z, List<? extends Smash> waterfall) {
        Intrinsics.checkNotNullParameter(waterfall, "waterfall");
        this.f3830a = i;
        this.b = z;
        this.c = waterfall;
        this.d = new ArrayList();
        this.e = new ArrayList();
        this.f = new ArrayList();
    }

    private final boolean b(Smash smash) {
        return b() < a(smash);
    }

    public final List<Smash> a() {
        return this.f;
    }

    public final List<Smash> c() {
        return this.d;
    }

    public abstract void c(Smash smash);

    public final int d() {
        return this.d.size() + this.e.size() + this.f.size();
    }

    public boolean e() {
        return d() >= this.f3830a;
    }

    private final int a(Smash smash) {
        return smash.i().l();
    }

    public final void d(Smash smash) {
        Intrinsics.checkNotNullParameter(smash, "smash");
        if (smash.x()) {
            IronLog.INTERNAL.verbose(smash.g().name() + " - smash " + smash.k() + " is failed to load");
            return;
        }
        if (smash.y()) {
            IronLog.INTERNAL.verbose(smash.g().name() + " - Smash " + smash.k() + " is already loaded");
            this.e.add(smash);
            return;
        }
        if (smash.z()) {
            IronLog.INTERNAL.verbose(smash.g().name() + " - Smash " + smash.k() + " still loading");
            this.f.add(smash);
            return;
        }
        if (smash.A().get()) {
            IronLog.INTERNAL.verbose(smash.g().name() + " - Smash " + smash.k() + " marked as loading candidate");
            this.f.add(smash);
            return;
        }
        if (!this.b || !b(smash)) {
            c(smash);
            return;
        }
        IronLog.INTERNAL.verbose(smash.g().name() + " - Smash " + smash.k() + " is not better than already loaded smashes");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final int b() {
        Integer num;
        List<Smash> list = this.c;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((AbstractC3292s3) obj).y()) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            Integer valueOf = Integer.valueOf(a((AbstractC3292s3) it.next()));
            while (it.hasNext()) {
                Integer valueOf2 = Integer.valueOf(a((AbstractC3292s3) it.next()));
                if (valueOf.compareTo(valueOf2) > 0) {
                    valueOf = valueOf2;
                }
            }
            num = valueOf;
        } else {
            num = null;
        }
        if (num != null) {
            return num.intValue();
        }
        return Integer.MAX_VALUE;
    }
}
