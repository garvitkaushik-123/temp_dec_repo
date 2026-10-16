package com.inmobi.media;

import com.inmobi.commons.core.configs.Config;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;

/* loaded from: classes4.dex */
public final class V2 {
    public static final Pair a(TreeMap treeMap) {
        if (treeMap.isEmpty()) {
            return TuplesKt.to(CollectionsKt.emptyList(), CollectionsKt.emptyList());
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Q2 q2 = new Q2();
        for (Map.Entry entry : treeMap.entrySet()) {
            String str = (String) entry.getKey();
            long a2 = q2.a(str, ((Config) entry.getValue()).getAccountId$media_release());
            arrayList.add(str);
            arrayList2.add(Long.valueOf(a2));
        }
        return TuplesKt.to(arrayList, arrayList2);
    }
}
