package com.inmobi.media;

import android.content.ContentValues;
import com.adjust.sdk.Constants;
import com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class Pa extends T1 {
    public Pa() {
        super("pings", "(id TEXT PRIMARY KEY,url TEXT NOT NULL,headers TEXT,allow_redirects TEXT NOT NULL,priority TEXT NOT NULL,ack_required TEXT NOT NULL,time_created INTEGER NOT NULL,owner TEXT NOT NULL,retry_count INTEGER DEFAULT 0,retryAfter INTEGER DEFAULT 0,telemetry_metadata TEXT)");
    }

    @Override // com.inmobi.media.T1
    public final Object a(ContentValues contentValues) {
        String str;
        String str2;
        String str3;
        C2685hc c2685hc;
        Intrinsics.checkNotNullParameter(contentValues, "contentValues");
        String asString = contentValues.getAsString("id");
        String asString2 = contentValues.getAsString("url");
        JSONObject jSONObject = new JSONObject(contentValues.getAsString("headers"));
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<String> keys = jSONObject.keys();
        Intrinsics.checkNotNullExpressionValue(keys, "keys(...)");
        while (true) {
            String str4 = "";
            if (!keys.hasNext()) {
                break;
            }
            String next = keys.next();
            Intrinsics.checkNotNull(next);
            String string = jSONObject.getString(next);
            if (string != null) {
                Intrinsics.checkNotNull(string);
                str4 = string;
            }
            linkedHashMap.put(next, str4);
        }
        boolean parseBoolean = Boolean.parseBoolean(contentValues.getAsString("allow_redirects"));
        String asString3 = contentValues.getAsString(HandleInvocationsFromAdViewer.KEY_DOWNLOAD_PRIORITY);
        boolean parseBoolean2 = Boolean.parseBoolean(contentValues.getAsString("ack_required"));
        Integer asInteger = contentValues.getAsInteger("retry_count");
        int intValue = asInteger == null ? 0 : asInteger.intValue();
        String asString4 = contentValues.getAsString("owner");
        if (asString4 == null) {
            asString4 = "unknown";
        }
        String str5 = asString4;
        Long asLong = contentValues.getAsLong("retryAfter");
        Long asLong2 = contentValues.getAsLong("time_created");
        Intrinsics.checkNotNull(asString2);
        Intrinsics.checkNotNull(asString);
        Intrinsics.checkNotNull(asString3);
        Intrinsics.checkNotNull(asLong2);
        long longValue = asLong2.longValue();
        String json = contentValues.getAsString("telemetry_metadata");
        if (json != null) {
            Intrinsics.checkNotNullParameter(json, "json");
            try {
                JSONObject jSONObject2 = new JSONObject(json);
                str = asString3;
                try {
                    String string2 = jSONObject2.getString("adType");
                    Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                    str2 = asString2;
                    str3 = asString;
                    try {
                        Z a2 = new X(string2).a(jSONObject2.getLong("plId")).a();
                        String string3 = jSONObject2.getString("markupType");
                        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                        String optString = jSONObject2.optString("metadataBlob", "");
                        Intrinsics.checkNotNullExpressionValue(optString, "optString(...)");
                        String string4 = jSONObject2.getString("creativeType");
                        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
                        String string5 = jSONObject2.getString("creativeId");
                        Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
                        c2685hc = new C2685hc(a2, string3, optString, 0, string4, string5, jSONObject2.getBoolean("isRewarded"), jSONObject2.getInt("adPosition"), null, null, null);
                    } catch (JSONException unused) {
                    }
                } catch (JSONException unused2) {
                }
            } catch (JSONException unused3) {
            }
            return new C2976za(str2, str3, linkedHashMap, parseBoolean, str, parseBoolean2, intValue, str5, longValue, asLong, c2685hc);
        }
        str = asString3;
        str2 = asString2;
        str3 = asString;
        c2685hc = null;
        return new C2976za(str2, str3, linkedHashMap, parseBoolean, str, parseBoolean2, intValue, str5, longValue, asLong, c2685hc);
    }

    @Override // com.inmobi.media.T1
    public final ContentValues b(Object obj) {
        C2976za item = (C2976za) obj;
        Intrinsics.checkNotNullParameter(item, "item");
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", item.b);
        contentValues.put("url", item.f2774a);
        Map map = item.c;
        Intrinsics.checkNotNullParameter(map, "<this>");
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry entry : map.entrySet()) {
            jSONObject.put((String) entry.getKey(), (String) entry.getValue());
        }
        contentValues.put("headers", jSONObject.toString());
        contentValues.put("allow_redirects", String.valueOf(item.d));
        contentValues.put(HandleInvocationsFromAdViewer.KEY_DOWNLOAD_PRIORITY, item.e);
        contentValues.put("ack_required", String.valueOf(item.f));
        contentValues.put("time_created", Long.valueOf(item.i));
        contentValues.put("retry_count", Integer.valueOf(item.g));
        contentValues.put("owner", item.h);
        Long l = item.j;
        contentValues.put("retryAfter", Long.valueOf(l != null ? l.longValue() : 0L));
        C2685hc c2685hc = item.k;
        if (c2685hc != null) {
            String jSONObject2 = new JSONObject().put("plType", c2685hc.f2589a.m()).put("plId", c2685hc.f2589a.l()).put("adType", c2685hc.f2589a.b()).put("markupType", c2685hc.b).put("networkType", L3.q()).put("creativeType", c2685hc.e).put("creativeId", c2685hc.f).put("isRewarded", c2685hc.g).put("adPosition", c2685hc.h).put("metadataBlob", c2685hc.c).toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "toString(...)");
            contentValues.put("telemetry_metadata", jSONObject2);
        }
        return contentValues;
    }

    public final ArrayList a(Integer num) {
        Intrinsics.checkNotNullParameter(Constants.HIGH, HandleInvocationsFromAdViewer.KEY_DOWNLOAD_PRIORITY);
        return T1.a(this, "priority = ? AND retry_count >= ? AND retryAfter <= ?", new String[]{Constants.HIGH, "1", String.valueOf(System.currentTimeMillis())}, null, null, "time_created ASC", num, 12);
    }

    public final C2976za a(String priority) {
        Intrinsics.checkNotNullParameter(priority, "priority");
        C2976za c2976za = (C2976za) CollectionsKt.firstOrNull((List) T1.a(this, "priority = ?", new String[]{priority}, null, null, "time_created ASC", 1, 12));
        if (c2976za == null) {
            return null;
        }
        a("id = ?", new String[]{c2976za.b});
        return c2976za;
    }
}
