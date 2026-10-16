package com.inmobi.media;

import android.content.ContentValues;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.inmobi.media.m2, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2756m2 extends T1 {
    public C2756m2() {
        super("click", "(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, pending_attempts INTEGER NOT NULL, url TEXT NOT NULL, ping_in_webview TEXT NOT NULL, follow_redirect TEXT NOT NULL, ts TEXT NOT NULL, track_extras TEXT, created_ts TEXT NOT NULL )");
    }

    @Override // com.inmobi.media.T1
    public final Object a(ContentValues contentValues) {
        Intrinsics.checkNotNullParameter(contentValues, "contentValues");
        Integer asInteger = contentValues.getAsInteger("id");
        Integer asInteger2 = contentValues.getAsInteger("pending_attempts");
        String asString = contentValues.getAsString("url");
        Long asLong = contentValues.getAsLong("ts");
        Long asLong2 = contentValues.getAsLong("created_ts");
        Boolean asBoolean = contentValues.getAsBoolean("follow_redirect");
        Boolean asBoolean2 = contentValues.getAsBoolean("ping_in_webview");
        String asString2 = contentValues.getAsString("track_extras");
        HashMap hashMap = new HashMap();
        if (asString2 != null) {
            try {
                hashMap.putAll(a(new JSONObject(asString2)));
            } catch (JSONException unused) {
                Intrinsics.checkNotNullExpressionValue("m2", "TAG");
            } catch (Exception unused2) {
                Intrinsics.checkNotNullExpressionValue("m2", "TAG");
            }
        }
        Intrinsics.checkNotNull(asInteger);
        int intValue = asInteger.intValue();
        Intrinsics.checkNotNull(asString);
        Intrinsics.checkNotNull(asBoolean);
        boolean booleanValue = asBoolean.booleanValue();
        Intrinsics.checkNotNull(asBoolean2);
        boolean booleanValue2 = asBoolean2.booleanValue();
        Intrinsics.checkNotNull(asInteger2);
        int intValue2 = asInteger2.intValue();
        Intrinsics.checkNotNull(asLong);
        long longValue = asLong.longValue();
        Intrinsics.checkNotNull(asLong2);
        return new C2740l2(intValue, asString, hashMap, booleanValue, booleanValue2, intValue2, longValue, asLong2.longValue());
    }

    @Override // com.inmobi.media.T1
    public final ContentValues b(Object obj) {
        C2740l2 click = (C2740l2) obj;
        Intrinsics.checkNotNullParameter(click, "click");
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", Integer.valueOf(click.f2628a));
        contentValues.put("url", click.b);
        contentValues.put("pending_attempts", Integer.valueOf(click.f));
        contentValues.put("ts", Long.valueOf(click.g));
        contentValues.put("created_ts", Long.valueOf(click.h));
        contentValues.put("follow_redirect", Boolean.valueOf(click.d));
        contentValues.put("ping_in_webview", Boolean.valueOf(click.e));
        Map map = click.c;
        if (map != null && !map.isEmpty()) {
            Map map2 = click.c;
            Intrinsics.checkNotNull(map2, "null cannot be cast to non-null type kotlin.collections.Map<*, *>");
            contentValues.put("track_extras", new JSONObject(map2).toString());
        }
        return contentValues;
    }

    public final ArrayList a(int i, int i2) {
        if (T1.a(this, null, null, 63) == 0) {
            return new ArrayList();
        }
        ArrayList<C2740l2> a2 = T1.a(this, null, null, "ts", "ts < " + (System.currentTimeMillis() - i2), "ts ASC ", -1 != i ? Integer.valueOf(i) : null, 3);
        ArrayList arrayList = new ArrayList();
        for (C2740l2 c2740l2 : a2) {
            if (c2740l2 != null) {
                arrayList.add(c2740l2);
            }
        }
        return arrayList;
    }

    public static HashMap a(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Intrinsics.checkNotNull(next);
            Object obj = jSONObject.get(next);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            hashMap.put(next, (String) obj);
        }
        return hashMap;
    }
}
