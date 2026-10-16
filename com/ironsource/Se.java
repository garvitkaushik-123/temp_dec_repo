package com.ironsource;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class Se implements O8 {

    /* renamed from: a, reason: collision with root package name */
    private final I3 f3053a;
    private ConcurrentHashMap<String, Integer> b;
    private ConcurrentHashMap<String, Long> c;

    public Se(I3 storage) {
        Intrinsics.checkNotNullParameter(storage, "storage");
        this.f3053a = storage;
        this.b = new ConcurrentHashMap<>();
        this.c = new ConcurrentHashMap<>();
    }

    @Override // com.ironsource.O8
    public void a(int i, String identifier) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        this.b.put(identifier, Integer.valueOf(i));
        this.f3053a.a(identifier, i);
    }

    @Override // com.ironsource.O8
    public Long b(String identifier) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        Long l = this.c.get(identifier);
        if (l != null) {
            return l;
        }
        Long a2 = this.f3053a.a(identifier);
        if (a2 == null) {
            return null;
        }
        long longValue = a2.longValue();
        this.c.put(identifier, Long.valueOf(longValue));
        return Long.valueOf(longValue);
    }

    @Override // com.ironsource.O8
    public int a(String identifier) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        Integer num = this.b.get(identifier);
        if (num != null) {
            return num.intValue();
        }
        Integer c = this.f3053a.c(identifier);
        if (c != null) {
            int intValue = c.intValue();
            this.b.put(identifier, Integer.valueOf(intValue));
            return intValue;
        }
        this.b.put(identifier, 0);
        return 0;
    }

    @Override // com.ironsource.O8
    public void a(long j, String identifier) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        this.c.put(identifier, Long.valueOf(j));
        this.f3053a.b(identifier, j);
    }
}
