package com.moloco.sdk.acm.eventprocessing;

import android.util.Log;
import androidx.work.Data;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class e {
    public static final Data a(Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        try {
            ArrayList arrayList = new ArrayList(map.size());
            for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
                arrayList.add(TuplesKt.to(entry.getKey(), entry.getValue()));
            }
            Pair[] pairArr = (Pair[]) arrayList.toArray(new Pair[0]);
            Pair[] pairArr2 = (Pair[]) Arrays.copyOf(pairArr, pairArr.length);
            Data.Builder builder = new Data.Builder();
            for (Pair pair : pairArr2) {
                builder.put((String) pair.getFirst(), pair.getSecond());
            }
            Data build = builder.build();
            Intrinsics.checkNotNullExpressionValue(build, "dataBuilder.build()");
            return build;
        } catch (Exception e) {
            Log.e("DBPeriodicRequest", e.getMessage() + ". Data: " + map);
            return null;
        }
    }
}
