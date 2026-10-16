package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast;

import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.q;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.y;
import java.util.Comparator;
import java.util.Iterator;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* loaded from: classes6.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public static final Comparator<y> f6079a = new Comparator() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.g$$ExternalSyntheticLambda1
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return g.a((y) obj, (y) obj2);
        }
    };
    public static final Comparator<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.l> b = new Comparator() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.g$$ExternalSyntheticLambda2
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return g.a((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.l) obj, (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.l) obj2);
        }
    };

    public static final Comparator<y> b() {
        return f6079a;
    }

    public static final Pair<Boolean, Boolean> c(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.e eVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.e eVar2, Integer num, Integer num2) {
        return a(b(eVar.i(), eVar.f(), num, num2), b(eVar2.i(), eVar2.f(), num, num2));
    }

    public static final Pair<Integer, Integer> d(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.e eVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.e eVar2, Integer num, Integer num2) {
        final Ref.IntRef intRef = new Ref.IntRef();
        final Ref.IntRef intRef2 = new Ref.IntRef();
        Function1 function1 = new Function1() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.g$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return g.a(Ref.IntRef.this, intRef2, (Pair) obj);
            }
        };
        function1.invoke(b(eVar, eVar2, num, num2));
        function1.invoke(c(eVar, eVar2, num, num2));
        function1.invoke(a(eVar, eVar2));
        return TuplesKt.to(Integer.valueOf(intRef.element), Integer.valueOf(intRef2.element));
    }

    public static final Pair<Integer, Integer> b(q qVar, q qVar2, double d, Long l, Integer num, Integer num2) {
        final Ref.IntRef intRef = new Ref.IntRef();
        final Ref.IntRef intRef2 = new Ref.IntRef();
        Function1 function1 = new Function1() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.g$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return g.b(Ref.IntRef.this, intRef2, (Pair) obj);
            }
        };
        function1.invoke(a(qVar, qVar2, num, num2));
        function1.invoke(b(qVar, qVar2, num, num2));
        function1.invoke(a(qVar, qVar2, d, l));
        return TuplesKt.to(Integer.valueOf(intRef.element), Integer.valueOf(intRef2.element));
    }

    public static final Comparator<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.e> a(Integer num, Integer num2) {
        return new a(num, num2);
    }

    public static final Comparator<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.l> a() {
        return b;
    }

    public static final Comparator<q> a(double d, Long l, Integer num, Integer num2) {
        return new b(d, l, num, num2);
    }

    public static final int a(y yVar, y yVar2) {
        Intrinsics.checkNotNull(yVar2);
        int b2 = b(yVar2);
        Intrinsics.checkNotNull(yVar);
        return Intrinsics.compare(b2, b(yVar));
    }

    public static final int a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.l lVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.l lVar2) {
        return f6079a.compare(lVar.g(), lVar2.g());
    }

    public static /* synthetic */ Pair a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.e eVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.e eVar2, Integer num, Integer num2, int i, Object obj) {
        if ((i & 4) != 0) {
            num = null;
        }
        if ((i & 8) != 0) {
            num2 = null;
        }
        return d(eVar, eVar2, num, num2);
    }

    public static final Unit a(Ref.IntRef intRef, Ref.IntRef intRef2, Pair pair) {
        Intrinsics.checkNotNullParameter(pair, "<destruct>");
        boolean booleanValue = ((Boolean) pair.component1()).booleanValue();
        boolean booleanValue2 = ((Boolean) pair.component2()).booleanValue();
        if (booleanValue) {
            intRef.element++;
        }
        if (booleanValue2) {
            intRef2.element++;
        }
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Pair a(q qVar, q qVar2, double d, Long l, Integer num, Integer num2, int i, Object obj) {
        if ((i & 8) != 0) {
            l = null;
        }
        if ((i & 16) != 0) {
            num = null;
        }
        if ((i & 32) != 0) {
            num2 = null;
        }
        return b(qVar, qVar2, d, l, num, num2);
    }

    public static final boolean a(y it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it instanceof y.c;
    }

    public static final Pair<Boolean, Boolean> a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.e eVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.e eVar2) {
        Object obj;
        Object obj2;
        Function1 function1 = new Function1() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.g$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj3) {
                return Boolean.valueOf(g.a((y) obj3));
            }
        };
        Iterator<T> it = eVar.h().iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                obj2 = null;
                break;
            }
            obj2 = it.next();
            if (((Boolean) function1.invoke(obj2)).booleanValue()) {
                break;
            }
        }
        boolean z = obj2 != null;
        Iterator<T> it2 = eVar2.h().iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Object next = it2.next();
            if (((Boolean) function1.invoke(next)).booleanValue()) {
                obj = next;
                break;
            }
        }
        return TuplesKt.to(Boolean.valueOf(z), Boolean.valueOf(obj != null));
    }

    public static final Unit b(Ref.IntRef intRef, Ref.IntRef intRef2, Pair pair) {
        Intrinsics.checkNotNullParameter(pair, "<destruct>");
        boolean booleanValue = ((Boolean) pair.component1()).booleanValue();
        boolean booleanValue2 = ((Boolean) pair.component2()).booleanValue();
        if (booleanValue) {
            intRef.element++;
        }
        if (booleanValue2) {
            intRef2.element++;
        }
        return Unit.INSTANCE;
    }

    public static final Pair<Boolean, Boolean> b(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.e eVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.e eVar2, Integer num, Integer num2) {
        return a(a(eVar.i(), eVar.f(), num, num2), a(eVar2.i(), eVar2.f(), num, num2));
    }

    public static final Pair<Boolean, Boolean> b(q qVar, q qVar2, Integer num, Integer num2) {
        return a(b(qVar.j(), qVar.d(), num, num2), b(qVar2.j(), qVar2.d(), num, num2));
    }

    public static final Double b(Integer num, Integer num2, Integer num3, Integer num4) {
        if (num == null || num.intValue() == 0 || num2 == null || num2.intValue() == 0 || num3 == null || num3.intValue() == 0 || num4 == null || num4.intValue() == 0) {
            return null;
        }
        return Double.valueOf((num.intValue() / num2.intValue()) - (num3.intValue() / num4.intValue()));
    }

    public static final int b(y yVar) {
        if (yVar instanceof y.a) {
            return 4;
        }
        if (yVar instanceof y.c) {
            return ((y.c) yVar).a().a() == com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.i.b ? 3 : 2;
        }
        if (yVar instanceof y.b) {
            return 1;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final Pair<Boolean, Boolean> a(q qVar, q qVar2, Integer num, Integer num2) {
        return a(a(qVar.j(), qVar.d(), num, num2), a(qVar2.j(), qVar2.d(), num, num2));
    }

    public static final Pair<Boolean, Boolean> a(q qVar, q qVar2, double d, Long l) {
        return a(a(qVar, d, l), a(qVar2, d, l));
    }

    public static final Pair<Boolean, Boolean> a(Double d, Double d2) {
        if (d == null || d2 == null) {
            return TuplesKt.to(Boolean.valueOf(d != null), Boolean.valueOf(d2 != null));
        }
        if (Intrinsics.areEqual(d, d2)) {
            Boolean bool = Boolean.TRUE;
            return TuplesKt.to(bool, bool);
        }
        if (Math.abs(d.doubleValue()) == Math.abs(d2.doubleValue())) {
            return TuplesKt.to(Boolean.valueOf(d.doubleValue() < 0.0d), Boolean.valueOf(d2.doubleValue() < 0.0d));
        }
        if (Double.compare(Math.abs(d.doubleValue()), Math.abs(d2.doubleValue())) < 0) {
            return TuplesKt.to(Boolean.TRUE, Boolean.FALSE);
        }
        return TuplesKt.to(Boolean.FALSE, Boolean.TRUE);
    }

    public static final Double a(Integer num, Integer num2, Integer num3, Integer num4) {
        if (num == null || num.intValue() == 0 || num2 == null || num2.intValue() == 0 || num3 == null || num3.intValue() == 0 || num4 == null || num4.intValue() == 0) {
            return null;
        }
        return Double.valueOf((num.intValue() * num2.intValue()) - (num3.intValue() * num4.intValue()));
    }

    public static final Double a(q qVar, double d, Long l) {
        Double a2 = a(qVar, l);
        if (a2 != null) {
            return Double.valueOf(a2.doubleValue() - d);
        }
        return null;
    }

    public static final Double a(q qVar, Long l) {
        Double valueOf;
        if (l == null) {
            return null;
        }
        if (qVar.b() != null) {
            valueOf = Double.valueOf(qVar.b().intValue());
        } else {
            valueOf = (qVar.f() == null || qVar.h() == null) ? null : Double.valueOf((qVar.f().intValue() - qVar.h().intValue()) / 2.0d);
        }
        if (valueOf != null) {
            return Double.valueOf((valueOf.doubleValue() / 8192) * (l.longValue() / 1000.0d));
        }
        return null;
    }
}
