package com.sourcepoint.cmplibrary.model;

import com.ironsource.C3040d4;
import com.sourcepoint.cmplibrary.model.exposed.GDPRPurposeGrants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonPrimitive;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: JsonToMapExt.kt */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0016\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0002\u001a\u001e\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0002\u001a/\u0010\n\u001a\u0004\u0018\u0001H\u000b\"\u0004\b\u0000\u0010\u000b*\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00062\u0006\u0010\f\u001a\u00020\u0007H\u0000¢\u0006\u0002\u0010\r\u001a8\u0010\u000e\u001a\u0018\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0006\u0018\u00010\u0001*\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00062\u0006\u0010\f\u001a\u00020\u0007H\u0000\u001a2\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0006*\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00062\u0006\u0010\f\u001a\u00020\u0007H\u0000\u001a\u001a\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0006*\u00020\u0007H\u0000\u001a\u001a\u0010\u0011\u001a\u00020\t*\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0006H\u0000\u001a\u001a\u0010\u0012\u001a\u00020\t*\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0006H\u0000\u001a\u001a\u0010\u0013\u001a\u00020\t*\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0006H\u0000\u001a\u001a\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0006*\u00020\tH\u0000¨\u0006\u0016"}, d2 = {"toList", "", "", "array", "Lorg/json/JSONArray;", "toMap", "", "", "jsonObj", "Lorg/json/JSONObject;", "getFieldValue", "T", C3040d4.h.W, "(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/Object;", "getList", "getMap", "jsonToTreeMap", "toConsentJSONObj", "toJSONObj", "toJSONObjGrant", "Lcom/sourcepoint/cmplibrary/model/exposed/GDPRPurposeGrants;", "toTreeMap", "cmplibrary_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class JsonToMapExtKt {
    public static final Map<String, Object> jsonToTreeMap(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return Intrinsics.areEqual(str, JSONObject.NULL) ? new TreeMap() : toMap(new JSONObject(str));
    }

    public static final Map<String, Object> toTreeMap(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        return Intrinsics.areEqual(jSONObject, JSONObject.NULL) ? new TreeMap() : toMap(jSONObject);
    }

    public static final Map<String, Object> getMap(Map<String, ? extends Object> map, String key) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Object obj = map.get(key);
        if (obj instanceof Map) {
            return (Map) obj;
        }
        return null;
    }

    public static final List<Map<String, Object>> getList(Map<String, ? extends Object> map, String key) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Object obj = map.get(key);
        if (obj instanceof List) {
            return (List) obj;
        }
        return null;
    }

    public static final JSONObject toJSONObj(Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        return new JSONObject(map);
    }

    public static final JSONObject toConsentJSONObj(Map<String, ? extends Object> map) {
        Pair pair;
        Integer intOrNull;
        Intrinsics.checkNotNullParameter(map, "<this>");
        List<Pair> list = MapsKt.toList(map);
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list, 10)), 16));
        for (Pair pair2 : list) {
            Object second = pair2.getSecond();
            JsonPrimitive jsonPrimitive = second instanceof JsonPrimitive ? (JsonPrimitive) second : null;
            if (jsonPrimitive != null ? jsonPrimitive.getIsString() : false) {
                pair = new Pair(pair2.getFirst(), String.valueOf(pair2.getSecond()));
            } else {
                Object second2 = pair2.getSecond();
                JsonPrimitive jsonPrimitive2 = second2 instanceof JsonPrimitive ? (JsonPrimitive) second2 : null;
                pair = (jsonPrimitive2 == null || (intOrNull = JsonElementKt.getIntOrNull(jsonPrimitive2)) == null) ? new Pair(pair2.getFirst(), String.valueOf(pair2.getSecond())) : new Pair(pair2.getFirst(), Integer.valueOf(intOrNull.intValue()));
            }
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        return new JSONObject(linkedHashMap);
    }

    public static final JSONObject toJSONObjGrant(Map<String, GDPRPurposeGrants> map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, GDPRPurposeGrants> entry : map.entrySet()) {
            String key = entry.getKey();
            JSONObject jSONObject2 = new JSONObject();
            GDPRPurposeGrants value = entry.getValue();
            Map<String, Boolean> map2 = null;
            jSONObject2.put("granted", value != null ? Boolean.valueOf(value.getGranted()) : null);
            GDPRPurposeGrants value2 = entry.getValue();
            if (value2 != null) {
                map2 = value2.getPurposeGrants();
            }
            jSONObject2.put("purposeGrants", new JSONObject(map2));
            Unit unit = Unit.INSTANCE;
            jSONObject.put(key, jSONObject2);
        }
        return jSONObject;
    }

    public static final <T> T getFieldValue(Map<String, ? extends Object> map, String key) {
        T t;
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        if (toJSONObj(map).isNull(key) || (t = (T) map.get(key)) == null) {
            return null;
        }
        return t;
    }

    private static final Map<String, Object> toMap(JSONObject jSONObject) {
        TreeMap treeMap = new TreeMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (!jSONObject.isNull(next)) {
                Object obj = jSONObject.get(next);
                if (obj instanceof JSONArray) {
                    Intrinsics.checkNotNull(obj);
                    obj = toList((JSONArray) obj);
                } else if (obj instanceof JSONObject) {
                    Intrinsics.checkNotNull(obj);
                    obj = toMap((JSONObject) obj);
                }
                Intrinsics.checkNotNull(next);
                treeMap.put(next, obj);
            }
        }
        return treeMap;
    }

    private static final List<Object> toList(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            Object obj = jSONArray.get(i);
            if (obj instanceof JSONArray) {
                Intrinsics.checkNotNull(obj);
                obj = toList((JSONArray) obj);
            } else if (obj instanceof JSONObject) {
                Intrinsics.checkNotNull(obj);
                obj = toMap((JSONObject) obj);
            }
            Intrinsics.checkNotNull(obj);
            arrayList.add(obj);
        }
        return arrayList;
    }
}
