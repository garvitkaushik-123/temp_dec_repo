package io.adn.sdk.internal.common.utils;

import com.ironsource.C3040d4;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: Json.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0000\u001a)\u0010\u0003\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0005*\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u0001H\u0005H\u0000¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"mergeWith", "Lorg/json/JSONObject;", "source", "putIfNotNull", "", "T", C3040d4.h.W, "", "value", "(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/Object;)V", "adn-sdk_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class JsonKt {
    public static final JSONObject mergeWith(JSONObject jSONObject, JSONObject source) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        Iterator<String> keys = source.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            jSONObject.put(next, source.get(next));
        }
        return jSONObject;
    }

    public static final <T> void putIfNotNull(JSONObject jSONObject, String key, T t) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        if (t != null) {
            jSONObject.put(key, t);
        }
    }
}
