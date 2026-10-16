package com.applovin.impl;

import android.net.Uri;
import android.webkit.MimeTypeMap;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class y7 implements n4 {

    /* renamed from: a, reason: collision with root package name */
    private List f806a;
    private List b;
    private int c;
    private Uri d;
    private final Set e;
    private r7 f;
    private final Map g;

    private y7() {
        this.f806a = Collections.emptyList();
        this.b = Collections.emptyList();
        this.e = new HashSet();
        this.g = new HashMap();
    }

    public static y7 a(m8 m8Var, y7 y7Var, p7 p7Var, com.applovin.impl.sdk.k kVar) {
        m8 c;
        r7 a2;
        List a3;
        m8 c2;
        List a4;
        m8 c3;
        int a5;
        if (m8Var == null) {
            throw new IllegalArgumentException("No node specified.");
        }
        if (p7Var == null) {
            throw new IllegalArgumentException("No context specified.");
        }
        if (kVar == null) {
            throw new IllegalArgumentException("No sdk specified.");
        }
        if (y7Var == null) {
            try {
                y7Var = new y7(p7Var);
            } catch (Throwable th) {
                kVar.O();
                if (com.applovin.impl.sdk.o.a()) {
                    kVar.O().a("VastVideoCreative", "Error occurred while initializing", th);
                }
                kVar.E().a("VastVideoCreative", th);
                return null;
            }
        }
        if (y7Var.c == 0 && (c3 = m8Var.c("Duration")) != null && (a5 = a(c3.d(), kVar)) > 0) {
            y7Var.c = a5;
        }
        m8 c4 = m8Var.c("MediaFiles");
        if (c4 != null && (a4 = a(c4, kVar)) != null && a4.size() > 0) {
            List list = y7Var.f806a;
            if (list != null) {
                a4.addAll(list);
            }
            y7Var.f806a = a4;
        }
        m8 c5 = m8Var.c("VideoClicks");
        if (c5 != null) {
            if (y7Var.d == null && (c2 = c5.c("ClickThrough")) != null) {
                String d = c2.d();
                if (StringUtils.isValidString(d)) {
                    y7Var.d = Uri.parse(d);
                }
            }
            x7.a(c5.a("ClickTracking"), y7Var.e, p7Var, kVar);
        }
        m8 c6 = m8Var.c(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.B);
        if (c6 != null && (a2 = r7.a((c = c6.c(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.C)), kVar)) != null) {
            m8 c7 = c.c(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.G);
            if (c7 != null && (a3 = c7.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.I)) != null) {
                x7.a(a3, a2.f645a, p7Var, kVar);
            }
            List a6 = c.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.J);
            if (a6 != null) {
                x7.a(a6, a2.b, p7Var, kVar);
            }
            y7Var.f = a2;
        }
        x7.a(m8Var, y7Var.g, p7Var, kVar);
        return y7Var;
    }

    public Set b() {
        return this.e;
    }

    public Uri c() {
        return this.d;
    }

    public int d() {
        return this.c;
    }

    public Map e() {
        return this.g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y7)) {
            return false;
        }
        y7 y7Var = (y7) obj;
        if (this.c != y7Var.c) {
            return false;
        }
        List list = this.f806a;
        if (list == null ? y7Var.f806a != null : !list.equals(y7Var.f806a)) {
            return false;
        }
        Uri uri = this.d;
        if (uri == null ? y7Var.d != null : !uri.equals(y7Var.d)) {
            return false;
        }
        Set set = this.e;
        if (set == null ? y7Var.e != null : !set.equals(y7Var.e)) {
            return false;
        }
        Map map = this.g;
        Map map2 = y7Var.g;
        return map != null ? map.equals(map2) : map2 == null;
    }

    public r7 f() {
        return this.f;
    }

    public List g() {
        return this.f806a;
    }

    public int hashCode() {
        List list = this.f806a;
        int hashCode = (((list != null ? list.hashCode() : 0) * 31) + this.c) * 31;
        Uri uri = this.d;
        int hashCode2 = (hashCode + (uri != null ? uri.hashCode() : 0)) * 31;
        Set set = this.e;
        int hashCode3 = (hashCode2 + (set != null ? set.hashCode() : 0)) * 31;
        Map map = this.g;
        return hashCode3 + (map != null ? map.hashCode() : 0);
    }

    public String toString() {
        return "VastVideoCreative{videoFiles=" + this.f806a + ", durationSeconds=" + this.c + ", destinationUri=" + this.d + ", clickTrackers=" + this.e + ", eventTrackers=" + this.g + ", industryIcon=" + this.f + AbstractJsonLexerKt.END_OBJ;
    }

    private y7(p7 p7Var) {
        this.f806a = Collections.emptyList();
        this.b = Collections.emptyList();
        this.e = new HashSet();
        this.g = new HashMap();
        this.b = p7Var.f();
    }

    private static int a(String str, com.applovin.impl.sdk.k kVar) {
        try {
            if (CollectionUtils.explode(str, ":").size() == 3) {
                return (int) (TimeUnit.HOURS.toSeconds(StringUtils.parseInt(r1.get(0))) + TimeUnit.MINUTES.toSeconds(StringUtils.parseInt(r1.get(1))) + StringUtils.parseInt(r1.get(2)));
            }
        } catch (Throwable unused) {
            kVar.O();
            if (com.applovin.impl.sdk.o.a()) {
                kVar.O().b("VastVideoCreative", "Unable to parse duration from \"" + str + "\"");
            }
        }
        return 0;
    }

    private static List a(m8 m8Var, com.applovin.impl.sdk.k kVar) {
        List a2 = m8Var.a("MediaFile");
        ArrayList arrayList = new ArrayList(a2.size());
        List<String> explode = CollectionUtils.explode((String) kVar.a(v4.I4));
        List<String> explode2 = CollectionUtils.explode((String) kVar.a(v4.H4));
        Iterator it = a2.iterator();
        while (it.hasNext()) {
            z7 a3 = z7.a((m8) it.next(), kVar);
            if (a3 != null) {
                try {
                    String c = a3.c();
                    if (StringUtils.isValidString(c) && !explode.contains(c)) {
                        arrayList.add(a3);
                    } else {
                        if (((Boolean) kVar.a(v4.J4)).booleanValue()) {
                            String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(a3.e().toString());
                            if (StringUtils.isValidString(fileExtensionFromUrl) && !explode2.contains(fileExtensionFromUrl)) {
                                arrayList.add(a3);
                            }
                        }
                        kVar.O();
                        if (com.applovin.impl.sdk.o.a()) {
                            kVar.O().k("VastVideoCreative", "Video file not supported: " + a3);
                        }
                    }
                } catch (Throwable th) {
                    kVar.O();
                    if (com.applovin.impl.sdk.o.a()) {
                        kVar.O().a("VastVideoCreative", "Failed to validate video file: " + a3, th);
                    }
                }
            }
        }
        return arrayList;
    }

    public z7 a(long j) {
        List list = this.f806a;
        z7 z7Var = null;
        if (list == null || list.size() == 0) {
            return null;
        }
        List<z7> arrayList = new ArrayList(3);
        for (String str : this.b) {
            for (z7 z7Var2 : this.f806a) {
                String c = z7Var2.c();
                if (StringUtils.isValidString(c) && str.equalsIgnoreCase(c)) {
                    arrayList.add(z7Var2);
                }
            }
            if (!arrayList.isEmpty()) {
                break;
            }
        }
        if (arrayList.isEmpty()) {
            arrayList = this.f806a;
        }
        Collections.sort(arrayList, new Comparator() { // from class: com.applovin.impl.y7$$ExternalSyntheticLambda0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int a2;
                a2 = y7.a((z7) obj, (z7) obj2);
                return a2;
            }
        });
        for (z7 z7Var3 : arrayList) {
            if (z7Var3.b() > j) {
                break;
            }
            z7Var = z7Var3;
        }
        return z7Var != null ? z7Var : (z7) arrayList.get(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int a(z7 z7Var, z7 z7Var2) {
        return Long.compare(z7Var.b(), z7Var2.b());
    }

    public static y7 a(JSONObject jSONObject, com.applovin.impl.sdk.k kVar) {
        if (jSONObject == null) {
            return null;
        }
        y7 y7Var = new y7();
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "video_files", new JSONArray());
        y7Var.f806a = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            z7 a2 = z7.a(JsonUtils.getJSONObject(jSONArray, i, (JSONObject) null), kVar);
            if (a2 != null) {
                y7Var.f806a.add(a2);
            }
        }
        y7Var.b = JsonUtils.getStringList(jSONObject, "preferred_video_file_types", Collections.emptyList());
        y7Var.c = JsonUtils.getInt(jSONObject, "duration_seconds", 0);
        String string = JsonUtils.getString(jSONObject, "destination_uri", null);
        y7Var.d = StringUtils.isValidString(string) ? Uri.parse(string) : null;
        JSONArray jSONArray2 = JsonUtils.getJSONArray(jSONObject, "click_trackers", new JSONArray());
        for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
            v7 a3 = v7.a(JsonUtils.getJSONObject(jSONArray2, i2, (JSONObject) null), kVar);
            if (a3 != null) {
                y7Var.e.add(a3);
            }
        }
        y7Var.f = r7.a(JsonUtils.getJSONObject(jSONObject, "industry_icon", (JSONObject) null), kVar);
        JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONObject, "event_trackers", new JSONObject());
        Iterator<String> keys = jSONObject2.keys();
        while (keys.hasNext()) {
            HashSet hashSet = new HashSet();
            String next = keys.next();
            JSONArray jSONArray3 = JsonUtils.getJSONArray(jSONObject2, next, new JSONArray());
            for (int i3 = 0; i3 < jSONArray3.length(); i3++) {
                v7 a4 = v7.a(JsonUtils.getJSONObject(jSONArray3, i3, (JSONObject) null), kVar);
                if (a4 != null) {
                    hashSet.add(a4);
                }
            }
            y7Var.g.put(next, hashSet);
        }
        return y7Var;
    }

    @Override // com.applovin.impl.n4
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        List list = this.f806a;
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                jSONArray.put(((z7) it.next()).a());
            }
        }
        JsonUtils.putJsonArray(jSONObject, "video_files", jSONArray);
        JsonUtils.putJsonArray(jSONObject, "preferred_video_file_types", new JSONArray((Collection) this.b));
        JsonUtils.putInt(jSONObject, "duration_seconds", this.c);
        Uri uri = this.d;
        JsonUtils.putString(jSONObject, "destination_uri", uri == null ? null : uri.toString());
        JSONArray jSONArray2 = new JSONArray();
        Iterator it2 = this.e.iterator();
        while (it2.hasNext()) {
            jSONArray2.put(((v7) it2.next()).a());
        }
        JsonUtils.putJsonArray(jSONObject, "click_trackers", jSONArray2);
        r7 r7Var = this.f;
        if (r7Var != null) {
            JsonUtils.putJSONObject(jSONObject, "industry_icon", r7Var.a());
        }
        JSONObject jSONObject2 = new JSONObject();
        for (String str : this.g.keySet()) {
            Set set = (Set) this.g.get(str);
            if (set != null) {
                JSONArray jSONArray3 = new JSONArray();
                Iterator it3 = set.iterator();
                while (it3.hasNext()) {
                    jSONArray3.put(((v7) it3.next()).a());
                }
                JsonUtils.putJsonArray(jSONObject2, str, jSONArray3);
            }
        }
        JsonUtils.putJSONObject(jSONObject, "event_trackers", jSONObject2);
        return jSONObject;
    }
}
