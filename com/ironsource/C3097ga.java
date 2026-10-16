package com.ironsource;

import java.util.Collection;
import java.util.Iterator;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.ironsource.ga, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3097ga {

    /* renamed from: a, reason: collision with root package name */
    private static final int f3315a = 100;

    public static final boolean a(JSONObject lhs, JSONObject rhs) {
        Intrinsics.checkNotNullParameter(lhs, "lhs");
        Intrinsics.checkNotNullParameter(rhs, "rhs");
        return a(lhs, rhs, 0);
    }

    public static final boolean a(JSONArray lhs, JSONArray rhs) {
        Intrinsics.checkNotNullParameter(lhs, "lhs");
        Intrinsics.checkNotNullParameter(rhs, "rhs");
        return a(lhs, rhs, 0);
    }

    private static final boolean a(JSONObject jSONObject, JSONObject jSONObject2, int i) {
        if (jSONObject == jSONObject2) {
            return true;
        }
        if (jSONObject.length() != jSONObject2.length() || i > 100) {
            return false;
        }
        Iterator<String> keys = jSONObject.keys();
        Intrinsics.checkNotNullExpressionValue(keys, "lhs.keys()");
        for (String str : SequencesKt.asSequence(keys)) {
            if (!jSONObject2.has(str) || !a(jSONObject.get(str), jSONObject2.get(str), i)) {
                return false;
            }
        }
        return true;
    }

    private static final boolean a(JSONArray jSONArray, JSONArray jSONArray2, int i) {
        if (jSONArray == jSONArray2) {
            return true;
        }
        if (jSONArray.length() != jSONArray2.length() || i > 100) {
            return false;
        }
        Iterable until = RangesKt.until(0, jSONArray.length());
        if (!(until instanceof Collection) || !((Collection) until).isEmpty()) {
            Iterator it = until.iterator();
            while (it.hasNext()) {
                int nextInt = ((IntIterator) it).nextInt();
                if (!a(jSONArray.get(nextInt), jSONArray2.get(nextInt), i)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static final boolean a(Object obj, Object obj2, int i) {
        if ((obj instanceof JSONObject) && (obj2 instanceof JSONObject)) {
            return a((JSONObject) obj, (JSONObject) obj2, i + 1);
        }
        if ((obj instanceof JSONArray) && (obj2 instanceof JSONArray)) {
            return a((JSONArray) obj, (JSONArray) obj2, i + 1);
        }
        if ((obj instanceof Number) && (obj2 instanceof Number)) {
            return ((Number) obj).doubleValue() == ((Number) obj2).doubleValue();
        }
        return Intrinsics.areEqual(obj, obj2);
    }
}
