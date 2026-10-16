package com.moloco.sdk.internal.ortb;

import com.moloco.sdk.internal.ortb.model.e;
import com.moloco.sdk.internal.ortb.model.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* loaded from: classes6.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final Regex f5440a = new Regex("\\$\\{AUCTION_PRICE\\}");

    public static final e a(e eVar) {
        Intrinsics.checkNotNullParameter(eVar, "<this>");
        List<s> b = eVar.b();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(b, 10));
        Iterator<T> it = b.iterator();
        while (it.hasNext()) {
            List<com.moloco.sdk.internal.ortb.model.c> b2 = ((s) it.next()).b();
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(b2, 10));
            for (com.moloco.sdk.internal.ortb.model.c cVar : b2) {
                float g = cVar.g();
                String a2 = a(cVar.a(), Float.valueOf(g));
                String c = cVar.c();
                arrayList2.add(new com.moloco.sdk.internal.ortb.model.c(a2, g, c != null ? a(c, Float.valueOf(g)) : null, cVar.e()));
            }
            arrayList.add(new s(arrayList2));
        }
        return new e(arrayList);
    }

    public static final String a(String str, Float f) {
        String str2;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Regex regex = f5440a;
        if (f == null || (str2 = f.toString()) == null) {
            str2 = "";
        }
        return regex.replace(str, str2);
    }
}
