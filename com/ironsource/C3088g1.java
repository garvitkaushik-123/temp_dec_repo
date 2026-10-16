package com.ironsource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

/* renamed from: com.ironsource.g1, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3088g1 implements Oe<JSONArray> {

    /* renamed from: a, reason: collision with root package name */
    private final List<C3071f1> f3308a = new ArrayList();

    /* renamed from: com.ironsource.g1$a */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3309a;

        static {
            int[] iArr = new int[Ne.values().length];
            try {
                iArr[Ne.FullHistory.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Ne.CurrentlyLoadedAds.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f3309a = iArr;
        }
    }

    @Override // com.ironsource.InterfaceC3060e7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public JSONArray a(Ne mode) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        int i = a.f3309a[mode.ordinal()];
        if (i == 1) {
            List<C3071f1> b = b();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(b, 10));
            Iterator<T> it = b.iterator();
            while (it.hasNext()) {
                arrayList.add(((C3071f1) it.next()).d());
            }
            return new JSONArray((Collection) arrayList);
        }
        if (i != 2) {
            throw new NoWhenBranchMatchedException();
        }
        List<C3071f1> a2 = a();
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(a2, 10));
        Iterator<T> it2 = a2.iterator();
        while (it2.hasNext()) {
            arrayList2.add(((C3071f1) it2.next()).c());
        }
        return new JSONArray((Collection) arrayList2);
    }

    public final void a(C3071f1 event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.f3308a.add(event);
    }

    private final List<C3071f1> a() {
        List<C3071f1> list = this.f3308a;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            C3071f1 c3071f1 = (C3071f1) obj;
            if (c3071f1.e() != Le.LoadSuccess && c3071f1.e() != Le.LoadRequest) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((C3071f1) it.next()).a());
        }
        Set set = CollectionsKt.toSet(arrayList2);
        List<C3071f1> list2 = this.f3308a;
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : list2) {
            C3071f1 c3071f12 = (C3071f1) obj2;
            if (c3071f12.e() == Le.LoadSuccess && !set.contains(c3071f12.a())) {
                arrayList3.add(obj2);
            }
        }
        return arrayList3;
    }

    private final List<C3071f1> b() {
        List<C3071f1> list = this.f3308a;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((C3071f1) obj).e() != Le.LoadRequest) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }
}
