package com.ironsource;

import com.ironsource.J8;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.ze, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3422ze implements J8, J8.a {

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, Integer> f3968a = new HashMap();
    private final Map<String, Integer> b = new HashMap();

    @Override // com.ironsource.J8.a
    public void a(List<? extends J8.b> smashes) {
        Intrinsics.checkNotNullParameter(smashes, "smashes");
        for (J8.b bVar : smashes) {
            this.f3968a.put(bVar.c(), 0);
            this.b.put(bVar.c(), Integer.valueOf(bVar.b()));
        }
    }

    @Override // com.ironsource.J8
    public boolean b(J8.b smash) {
        boolean z;
        Intrinsics.checkNotNullParameter(smash, "smash");
        synchronized (this) {
            String c = smash.c();
            if (this.f3968a.containsKey(c)) {
                Integer num = this.f3968a.get(c);
                Intrinsics.checkNotNull(num);
                z = num.intValue() >= smash.b();
            }
        }
        return z;
    }

    @Override // com.ironsource.J8.a
    public void a(J8.b smash) {
        Intrinsics.checkNotNullParameter(smash, "smash");
        synchronized (this) {
            String c = smash.c();
            if (this.f3968a.containsKey(c)) {
                Map<String, Integer> map = this.f3968a;
                Integer num = map.get(c);
                Intrinsics.checkNotNull(num);
                map.put(c, Integer.valueOf(num.intValue() + 1));
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.ironsource.J8
    public boolean a() {
        for (String str : this.b.keySet()) {
            Integer num = this.f3968a.get(str);
            Intrinsics.checkNotNull(num);
            int intValue = num.intValue();
            Integer num2 = this.b.get(str);
            Intrinsics.checkNotNull(num2);
            if (intValue < num2.intValue()) {
                return false;
            }
        }
        return true;
    }
}
