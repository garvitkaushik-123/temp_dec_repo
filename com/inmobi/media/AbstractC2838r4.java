package com.inmobi.media;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.r4, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC2838r4 extends T1 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractC2838r4(String tableName, String tableSchema) {
        super(tableName, tableSchema);
        Intrinsics.checkNotNullParameter(tableName, "tableName");
        Intrinsics.checkNotNullParameter(tableSchema, "tableSchema");
    }

    public final void a(ArrayList eventIdList) {
        Intrinsics.checkNotNullParameter(eventIdList, "eventIdList");
        if (eventIdList.isEmpty()) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        int size = eventIdList.size() - 1;
        for (int i = 0; i < size; i++) {
            sb.append(eventIdList.get(i)).append(",");
        }
        sb.append(eventIdList.get(eventIdList.size() - 1));
        a("id IN (" + ((Object) sb) + ')', null);
        Intrinsics.checkNotNullExpressionValue("r4", "TAG");
    }

    public final ArrayList b(int i) {
        Intrinsics.checkNotNullExpressionValue("r4", "TAG");
        ArrayList<U1> a2 = T1.a(this, null, null, null, null, "ts ASC", Integer.valueOf(i), 15);
        ArrayList arrayList = new ArrayList();
        for (U1 u1 : a2) {
            if (u1 != null) {
                arrayList.add(u1);
            }
        }
        return arrayList;
    }

    public final void a(long j) {
        Context d = Uc.d();
        if (d != null) {
            ConcurrentHashMap concurrentHashMap = C6.b;
            C6.a(B6.a(d, "batch_processing_info"), this.f2433a.concat("_last_batch_process"), j, false, 4, (Object) null);
        }
    }

    public final void a(int i) {
        ArrayList<U1> a2 = T1.a(this, null, null, null, null, "ts ASC", Integer.valueOf(i), 15);
        ArrayList arrayList = new ArrayList();
        for (U1 u1 : a2) {
            Intrinsics.checkNotNullExpressionValue("r4", "TAG");
            arrayList.add(u1 != null ? Integer.valueOf(u1.c) : null);
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            if (num != null) {
                arrayList2.add(num);
            }
        }
        a(arrayList2);
    }
}
