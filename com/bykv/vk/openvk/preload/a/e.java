package com.bykv.vk.openvk.preload.a;

import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: GsonBuilder.java */
/* loaded from: classes3.dex */
public final class e {
    private String g;

    /* renamed from: a, reason: collision with root package name */
    private com.bykv.vk.openvk.preload.a.b.c f915a = com.bykv.vk.openvk.preload.a.b.c.f894a;
    private q b = q.f920a;
    private c c = b.f854a;
    private final Map<Type, f<?>> d = new HashMap();
    private final List<s> e = new ArrayList();
    private final List<s> f = new ArrayList();
    private int h = 2;
    private int i = 2;
    private boolean j = true;

    public final e a(Type type, Object obj) {
        com.bykv.vk.openvk.preload.falconx.a.a.a(true);
        this.e.add(com.bykv.vk.openvk.preload.a.b.a.m.a(com.bykv.vk.openvk.preload.a.c.a.a(type), (r) obj));
        return this;
    }

    public final d a() {
        a aVar;
        a aVar2;
        a aVar3;
        ArrayList arrayList = new ArrayList(this.e.size() + this.f.size() + 3);
        arrayList.addAll(this.e);
        Collections.reverse(arrayList);
        ArrayList arrayList2 = new ArrayList(this.f);
        Collections.reverse(arrayList2);
        arrayList.addAll(arrayList2);
        String str = this.g;
        int i = this.h;
        int i2 = this.i;
        if (str == null || "".equals(str.trim())) {
            if (i != 2 && i2 != 2) {
                a aVar4 = new a(Date.class, i, i2);
                a aVar5 = new a(Timestamp.class, i, i2);
                a aVar6 = new a(java.sql.Date.class, i, i2);
                aVar = aVar4;
                aVar2 = aVar5;
                aVar3 = aVar6;
            }
            return new d(this.f915a, this.c, this.d, this.j, this.b, arrayList);
        }
        aVar = new a(Date.class, str);
        aVar2 = new a(Timestamp.class, str);
        aVar3 = new a(java.sql.Date.class, str);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.a(Date.class, aVar));
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.a(Timestamp.class, aVar2));
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.a(java.sql.Date.class, aVar3));
        return new d(this.f915a, this.c, this.d, this.j, this.b, arrayList);
    }
}
