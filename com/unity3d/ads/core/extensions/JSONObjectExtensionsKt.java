package com.unity3d.ads.core.extensions;

import com.google.android.gms.ads.AdError;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import org.json.JSONObject;

/* compiled from: JSONObjectExtensions.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001*\u00020\u0004¨\u0006\u0005"}, d2 = {"toBuiltInMap", "", "", "", "Lorg/json/JSONObject;", "unity-ads_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class JSONObjectExtensionsKt {
    public static final Map<String, Object> toBuiltInMap(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Iterator<String> keys = jSONObject.keys();
        Intrinsics.checkNotNullExpressionValue(keys, "keys()");
        Sequence asSequence = SequencesKt.asSequence(keys);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : asSequence) {
            LinkedHashMap linkedHashMap2 = linkedHashMap;
            Object opt = jSONObject.opt((String) obj);
            if (opt != null) {
                Intrinsics.checkNotNullExpressionValue(opt, "opt(value)");
                if (!Intrinsics.areEqual(String.valueOf(opt), AdError.UNDEFINED_DOMAIN) && !Intrinsics.areEqual(String.valueOf(opt), "null")) {
                    linkedHashMap2.put(obj, opt);
                }
            }
            opt = null;
            linkedHashMap2.put(obj, opt);
        }
        return linkedHashMap;
    }
}
