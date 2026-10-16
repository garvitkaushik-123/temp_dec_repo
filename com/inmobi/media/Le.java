package com.inmobi.media;

import com.adjust.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class Le {
    public static final List h = CollectionsKt.listOf((Object[]) new String[]{"image/jpeg", "image/png", "image/jpg"});

    /* renamed from: a, reason: collision with root package name */
    public final int f2356a;
    public final int b;
    public final String d;
    public boolean g;
    public String c = null;
    public final ArrayList e = new ArrayList();
    public final ArrayList f = new ArrayList();

    public Le(int i, int i2, String str) {
        this.f2356a = i;
        this.b = i2;
        this.d = str;
    }

    public final ArrayList a(int i) {
        ArrayList arrayList = new ArrayList();
        Iterator it = this.e.iterator();
        while (it.hasNext()) {
            Ke ke = (Ke) it.next();
            if (ke.f2344a == i) {
                arrayList.add(ke);
            }
        }
        return arrayList;
    }

    public final String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            String str = this.d;
            if (str != null) {
                jSONObject.put("id", str);
            }
            jSONObject.put("width", this.f2356a);
            jSONObject.put("height", this.b);
            jSONObject.put("clickThroughUrl", this.c);
            JSONArray jSONArray = new JSONArray();
            Iterator it = this.e.iterator();
            while (it.hasNext()) {
                jSONArray.put(((Ke) it.next()).toString());
            }
            jSONObject.put("resources", jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            Iterator it2 = this.f.iterator();
            while (it2.hasNext()) {
                jSONArray2.put(((U8) it2.next()).toString());
            }
            jSONObject.put(Constants.ADJUST_PREINSTALL_CONTENT_URI_PATH, jSONArray2);
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "toString(...)");
            return jSONObject2;
        } catch (JSONException e) {
            Intrinsics.checkNotNullExpressionValue("Le", "TAG");
            S5 s5 = S5.f2425a;
            C2640f2 event = new C2640f2(e);
            Intrinsics.checkNotNullParameter(event, "event");
            S5.d.a(event);
            return "";
        }
    }

    public final ArrayList a(String trackerEventType) {
        Intrinsics.checkNotNullParameter(trackerEventType, "trackerEventType");
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f.iterator();
        while (it.hasNext()) {
            U8 u8 = (U8) it.next();
            if (Intrinsics.areEqual(u8.b, trackerEventType)) {
                arrayList.add(u8);
            }
        }
        return arrayList;
    }
}
