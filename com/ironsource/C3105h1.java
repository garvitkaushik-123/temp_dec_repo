package com.ironsource;

import com.ironsource.InterfaceC3293s4;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* renamed from: com.ironsource.h1, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public class C3105h1 implements InterfaceC3240p1 {

    /* renamed from: a, reason: collision with root package name */
    private final InterfaceC3155k1 f3329a;
    private final B7 b;
    private final InterfaceC3317tb<Integer, Integer> c;
    private final InterfaceC3293s4 d;
    private List<InterfaceC3189m1> e;

    public C3105h1(InterfaceC3155k1 eventBaseData, B7 eventsManager, InterfaceC3317tb<Integer, Integer> eventsMapper, InterfaceC3293s4 currentTimeProvider) {
        Intrinsics.checkNotNullParameter(eventBaseData, "eventBaseData");
        Intrinsics.checkNotNullParameter(eventsManager, "eventsManager");
        Intrinsics.checkNotNullParameter(eventsMapper, "eventsMapper");
        Intrinsics.checkNotNullParameter(currentTimeProvider, "currentTimeProvider");
        this.f3329a = eventBaseData;
        this.b = eventsManager;
        this.c = eventsMapper;
        this.d = currentTimeProvider;
        this.e = new ArrayList();
    }

    public final void a(List<InterfaceC3189m1> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.e = list;
    }

    public final List<InterfaceC3189m1> b() {
        return this.e;
    }

    private final JSONObject b(List<? extends InterfaceC3189m1> list) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<? extends InterfaceC3189m1> it = list.iterator();
        while (it.hasNext()) {
            it.next().a(linkedHashMap);
        }
        return new JSONObject(linkedHashMap);
    }

    @Override // com.ironsource.InterfaceC3240p1
    public void a(int i, List<InterfaceC3189m1> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "arrayList");
        try {
            Iterator<T> it = this.f3329a.a().iterator();
            while (it.hasNext()) {
                arrayList.add((InterfaceC3189m1) it.next());
            }
            Iterator<InterfaceC3189m1> it2 = this.e.iterator();
            while (it2.hasNext()) {
                arrayList.add(it2.next());
            }
            this.b.a(new C3413z5(this.c.a(Integer.valueOf(i)).intValue(), this.d.a(), b(arrayList)));
        } catch (Exception e) {
            C3260q4.d().a(e);
            System.out.println((Object) ("LogRemote | Exception: " + e.getMessage()));
        }
    }

    public /* synthetic */ C3105h1(InterfaceC3155k1 interfaceC3155k1, B7 b7, InterfaceC3317tb interfaceC3317tb, InterfaceC3293s4 interfaceC3293s4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(interfaceC3155k1, b7, interfaceC3317tb, (i & 8) != 0 ? new InterfaceC3293s4.a() : interfaceC3293s4);
    }

    @Override // com.ironsource.InterfaceC3240p1
    public void a() {
        this.e.clear();
    }

    @Override // com.ironsource.InterfaceC3240p1
    public void a(InterfaceC3189m1... analyticsEventEntity) {
        Intrinsics.checkNotNullParameter(analyticsEventEntity, "analyticsEventEntity");
        for (InterfaceC3189m1 interfaceC3189m1 : analyticsEventEntity) {
            this.e.add(interfaceC3189m1);
        }
    }
}
