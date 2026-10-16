package com.inmobi.media;

import android.content.Context;
import com.inmobi.commons.core.configs.SignalsConfig;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class Ya {
    public static Sa c;
    public static final /* synthetic */ KProperty[] b = {Reflection.property1(new PropertyReference1Impl(Ya.class, "cachedJson", "getCachedJson()Lorg/json/JSONObject;", 0))};

    /* renamed from: a, reason: collision with root package name */
    public static final Ya f2496a = new Ya();
    public static final C2932x1 d = new C2932x1((Object) new JSONObject(), (Function0) Xa.f2483a, true, true);

    public static void b() {
        final Context d2 = Uc.d();
        if (d2 != null) {
            Uc.a(new Runnable() { // from class: com.inmobi.media.Ya$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    Ya.a(d2);
                }
            });
        }
    }

    public final LinkedHashMap a() {
        String str;
        JSONObject jSONObject;
        JSONObject jSONObject2 = (JSONObject) d.getValue(this, b[0]);
        LinkedHashMap linkedHashMap = O2.f2380a;
        SignalsConfig.PublisherConfig publisher = ((SignalsConfig) AbstractC2808p5.a("signals", "null cannot be cast to non-null type com.inmobi.commons.core.configs.SignalsConfig", null)).getPublisher();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Map.Entry<String, String> entry : publisher.getGeneralKeys().entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (jSONObject2.has(key)) {
                int hashCode = value.hashCode();
                if (hashCode != -1325958191) {
                    if (hashCode != -891985903) {
                        if (hashCode != 104431) {
                            if (hashCode == 3029738 && value.equals("bool")) {
                                linkedHashMap2.put(key, Boolean.valueOf(jSONObject2.optBoolean(key)));
                            }
                        } else if (value.equals("int")) {
                            linkedHashMap2.put(key, Integer.valueOf(jSONObject2.optInt(key)));
                        }
                    } else if (value.equals("string")) {
                        String optString = jSONObject2.optString(key);
                        Intrinsics.checkNotNullExpressionValue(optString, "optString(...)");
                        linkedHashMap2.put(key, optString);
                    }
                } else if (value.equals("double")) {
                    linkedHashMap2.put(key, Double.valueOf(jSONObject2.optDouble(key)));
                }
            }
        }
        for (Map.Entry<String, String> entry2 : publisher.getAdSpecificKeys().entrySet()) {
            String key2 = entry2.getKey();
            String value2 = entry2.getValue();
            JSONArray optJSONArray = jSONObject2.optJSONArray(key2);
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                int i = 0;
                while (i < length) {
                    StringBuilder append = new StringBuilder().append(key2).append('_');
                    if (i == 0) {
                        str = "ban";
                    } else if (i == 1) {
                        str = "int";
                    } else if (i == 2) {
                        str = "rew";
                    } else if (i != 3) {
                        jSONObject = jSONObject2;
                        i++;
                        jSONObject2 = jSONObject;
                    } else {
                        str = "nat";
                    }
                    String sb = append.append(str).toString();
                    int hashCode2 = value2.hashCode();
                    jSONObject = jSONObject2;
                    if (hashCode2 != -1325958191) {
                        if (hashCode2 != -891985903) {
                            if (hashCode2 != 104431) {
                                if (hashCode2 == 3029738 && value2.equals("bool")) {
                                    linkedHashMap2.put(sb, Boolean.valueOf(optJSONArray.optBoolean(i)));
                                }
                            } else if (value2.equals("int")) {
                                linkedHashMap2.put(sb, Integer.valueOf(optJSONArray.optInt(i)));
                            }
                        } else if (value2.equals("string")) {
                            String optString2 = optJSONArray.optString(i);
                            Intrinsics.checkNotNullExpressionValue(optString2, "optString(...)");
                            linkedHashMap2.put(sb, optString2);
                        }
                    } else if (value2.equals("double")) {
                        linkedHashMap2.put(sb, Double.valueOf(optJSONArray.optDouble(i)));
                    }
                    i++;
                    jSONObject2 = jSONObject;
                }
            }
        }
        return linkedHashMap2;
    }

    public static final void b(JSONObject this_saveSignalsToPersistentCache) {
        Intrinsics.checkNotNullParameter(this_saveSignalsToPersistentCache, "$this_saveSignalsToPersistentCache");
        Context d2 = Uc.d();
        if (d2 != null) {
            f2496a.getClass();
            if (c == null) {
                c = new Sa(d2, "pub_signals_store");
            }
            Sa sa = c;
            if (sa == null) {
                Intrinsics.throwUninitializedPropertyAccessException("prefDao");
                sa = null;
            }
            String jSONObject = this_saveSignalsToPersistentCache.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "toString(...)");
            sa.a("saved_signals", jSONObject);
            d.a();
            AbstractC2680h7.a((byte) 2, "PubSignalsStore", "Publisher Signals saved successfully.");
        }
    }

    public static final void a(Context context) {
        Intrinsics.checkNotNullParameter(context, "$context");
        try {
            f2496a.getClass();
            if (c == null) {
                c = new Sa(context, "pub_signals_store");
            }
            Sa sa = c;
            if (sa == null) {
                Intrinsics.throwUninitializedPropertyAccessException("prefDao");
                sa = null;
            }
            sa.c("saved_signals");
            d.a();
        } catch (Exception e) {
            AbstractC2680h7.a((byte) 1, "PubSignalsStore", "Publisher signals could not be reset.");
            S5 s5 = S5.f2425a;
            S5.d.a(AbstractC2920w5.a(e, "event"));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x00ef, code lost:
    
        r1.remove(r4);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static LinkedHashMap a(LinkedHashMap linkedHashMap, SignalsConfig.PublisherConfig publisherConfig) {
        Object a2;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        linkedHashMap3.putAll(linkedHashMap);
        for (Map.Entry<String, String> entry : publisherConfig.getGeneralKeys().entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            Object obj = linkedHashMap.get(key);
            if (obj != null && (a2 = a(obj, value)) != null) {
                linkedHashMap3.remove(key);
                linkedHashMap2.put(key, a2);
            }
        }
        for (Map.Entry<String, String> entry2 : publisherConfig.getAdSpecificKeys().entrySet()) {
            String key2 = entry2.getKey();
            String value2 = entry2.getValue();
            String str = key2 + "_ban";
            String str2 = key2 + "_int";
            String str3 = key2 + "_rew";
            String str4 = key2 + "_nat";
            Object obj2 = linkedHashMap.get(str);
            Object a3 = obj2 != null ? a(obj2, value2) : null;
            Object obj3 = linkedHashMap.get(str2);
            Object a4 = obj3 != null ? a(obj3, value2) : null;
            Object obj4 = linkedHashMap.get(str3);
            Object a5 = obj4 != null ? a(obj4, value2) : null;
            Object obj5 = linkedHashMap.get(str4);
            Object a6 = obj5 != null ? a(obj5, value2) : null;
            if (a3 != null || a4 != null || a5 != null || a6 != null) {
                if (a4 != null) {
                    linkedHashMap3.remove(str2);
                }
                if (a5 != null) {
                    linkedHashMap3.remove(str3);
                }
                if (a6 != null) {
                    linkedHashMap3.remove(str4);
                }
                JSONArray jSONArray = new JSONArray();
                if (a3 == null) {
                    a3 = a(value2);
                }
                JSONArray put = jSONArray.put(a3);
                if (a4 == null) {
                    a4 = a(value2);
                }
                JSONArray put2 = put.put(a4);
                if (a5 == null) {
                    a5 = a(value2);
                }
                JSONArray put3 = put2.put(a5);
                if (a6 == null) {
                    a6 = a(value2);
                }
                JSONArray put4 = put3.put(a6);
                Intrinsics.checkNotNullExpressionValue(put4, "put(...)");
                linkedHashMap2.put(key2, put4);
            }
        }
        for (Map.Entry entry3 : linkedHashMap3.entrySet()) {
            AbstractC2680h7.a((byte) 1, "PubSignalsStore", "Publisher Signal, " + ((String) entry3.getKey()) + com.ironsource.D5.T + entry3.getValue() + " Not supported");
        }
        return linkedHashMap2;
    }

    public static Object a(Object obj, String str) {
        int hashCode = str.hashCode();
        if (hashCode == -1325958191) {
            if (!str.equals("double")) {
                return null;
            }
            if (obj instanceof Double) {
                return (Double) obj;
            }
            if (obj instanceof Integer) {
                return Double.valueOf(((Number) obj).intValue());
            }
            if (obj instanceof Float) {
                return Double.valueOf(((Number) obj).floatValue());
            }
            return null;
        }
        if (hashCode == -891985903) {
            if (str.equals("string") && (obj instanceof String)) {
                return (String) obj;
            }
            return null;
        }
        if (hashCode != 104431) {
            if (hashCode == 3029738 && str.equals("bool") && (obj instanceof Boolean)) {
                return (Boolean) obj;
            }
            return null;
        }
        if (str.equals("int") && (obj instanceof Integer)) {
            return (Integer) obj;
        }
        return null;
    }

    public static Object a(String str) {
        int hashCode = str.hashCode();
        if (hashCode != -1325958191) {
            if (hashCode == -891985903) {
                str.equals("string");
            } else if (hashCode != 104431) {
                if (hashCode == 3029738) {
                    str.equals("bool");
                }
            } else if (str.equals("int")) {
                return Integer.valueOf(Integer.parseInt(com.ironsource.Y1.f));
            }
        } else if (str.equals("double")) {
            return Double.valueOf(Double.parseDouble(com.ironsource.Y1.f));
        }
        return com.ironsource.Y1.f;
    }

    public static JSONObject a(LinkedHashMap linkedHashMap) {
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            String str = (String) entry.getKey();
            Object value = entry.getValue();
            if (value instanceof String) {
                jSONObject.put(str, value);
            } else if (value instanceof Integer) {
                jSONObject.put(str, ((Number) value).intValue());
            } else if (value instanceof Boolean) {
                jSONObject.put(str, ((Boolean) value).booleanValue());
            } else if (value instanceof Double) {
                jSONObject.put(str, ((Number) value).doubleValue());
            } else if (value instanceof JSONArray) {
                jSONObject.put(str, value);
            }
        }
        return jSONObject;
    }

    public static void a(final JSONObject jSONObject) {
        Uc.a(new Runnable() { // from class: com.inmobi.media.Ya$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                Ya.b(jSONObject);
            }
        });
    }

    public static JSONObject a(JSONObject jSONObject, SignalsConfig.PublisherConfig publisherConfig) {
        if (jSONObject.toString().length() <= publisherConfig.getPayloadSize()) {
            return jSONObject;
        }
        AbstractC2680h7.a((byte) 1, "PubSignalsStore", "Publisher Signal payload size exceeded.");
        S5 s5 = S5.f2425a;
        C2640f2 event = new C2640f2(new IllegalStateException("Publisher signals size exceeds the limit"));
        Intrinsics.checkNotNullParameter(event, "event");
        S5.d.a(event);
        return null;
    }
}
