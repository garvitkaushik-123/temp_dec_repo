package com.bytedance.sdk.openadsdk.core.du.DbA;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.component.utils.ujq;
import com.bytedance.sdk.component.wC.wC;
import com.bytedance.sdk.openadsdk.core.dV;
import com.bytedance.sdk.openadsdk.core.du.DbA.DbA;
import com.bytedance.sdk.openadsdk.core.du.DbA.eli;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.utils.dZ;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Os {
    private boolean MGA;
    private final String Os;
    private final boolean aGH;
    private EnumC0188Os ui;
    private static final Map<String, DbA> eli = new ConcurrentHashMap();
    private static final AtomicBoolean DbA = new AtomicBoolean(false);

    /* renamed from: com.bytedance.sdk.openadsdk.core.du.DbA.Os$Os, reason: collision with other inner class name */
    enum EnumC0188Os {
        TRACKING_URL,
        QUARTILE_EVENT
    }

    static {
        ujq.eli(new ujq.eli() { // from class: com.bytedance.sdk.openadsdk.core.du.DbA.Os.1
            @Override // com.bytedance.sdk.component.utils.ujq.eli
            public void eli(Context context, Intent intent, boolean z, int i) {
                if (i == 0 || Os.eli.size() <= 0) {
                    return;
                }
                Os.DbA();
            }
        }, dV.eli());
    }

    protected Os(String str, EnumC0188Os enumC0188Os, Boolean bool) {
        this.Os = str;
        this.ui = enumC0188Os;
        this.aGH = bool.booleanValue();
    }

    public static List<String> eli(ev evVar, List<Os> list, com.bytedance.sdk.openadsdk.core.du.eli.eli eliVar, long j, String str, String str2) {
        if (list == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (Os os : list) {
            if (os != null && (!os.ui() || os.aGH())) {
                arrayList.add(os.Os());
                os.m_();
            }
        }
        return arrayList.isEmpty() ? arrayList : new com.bytedance.sdk.openadsdk.core.du.Os.Os(arrayList, evVar).eli(eliVar).eli(j).DbA(str).eli(str2).eli();
    }

    public static boolean eli(ev evVar, List<Os> list, com.bytedance.sdk.openadsdk.core.du.eli.eli eliVar, long j, String str, DbA dbA, String str2) {
        List<String> eli2 = eli(evVar, list, eliVar, j, str, str2);
        eli(eli2, dbA);
        return !eli2.isEmpty();
    }

    public static void DbA(ev evVar, List<Os> list, com.bytedance.sdk.openadsdk.core.du.eli.eli eliVar, long j, String str, String str2) {
        eli(evVar, list, eliVar, j, str, null, str2);
    }

    public static void eli(List<String> list, DbA dbA) {
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            if (!TextUtils.isEmpty(str)) {
                eli(str, dbA, false);
            }
        }
    }

    private static void eli(final String str, final DbA dbA, final boolean z) {
        com.bytedance.sdk.component.kb.DbA.DbA Os = com.bytedance.sdk.openadsdk.nGm.DbA.DbA().Os().Os();
        if (Os == null) {
            return;
        }
        Os.eli(true);
        Os.DbA(str);
        Os.eli(new com.bytedance.sdk.component.kb.eli.eli() { // from class: com.bytedance.sdk.openadsdk.core.du.DbA.Os.2
            @Override // com.bytedance.sdk.component.kb.eli.eli
            public void eli(com.bytedance.sdk.component.kb.DbA.Os os, com.bytedance.sdk.component.kb.DbA dbA2) {
                String str2;
                boolean z2;
                DbA dbA3 = DbA.this;
                if (dbA3 == null || dbA3.eli == null) {
                    return;
                }
                String str3 = null;
                if (dbA2 == null || !dbA2.MGA()) {
                    if (dbA2 != null) {
                        str3 = dbA2.eli() + ":" + dbA2.DbA();
                        if (!z && (dbA2.eli() <= 300 || dbA2.eli() >= 400)) {
                            Os.eli.put(str, DbA.this);
                        }
                    }
                    str2 = str3;
                    z2 = false;
                } else {
                    str2 = null;
                    z2 = true;
                }
                Os.DbA(z2, str2, dZ.Os(DbA.this.eli.cK()), DbA.this, str, z);
                if (!z2 || Os.eli.isEmpty()) {
                    return;
                }
                Os.DbA();
            }

            @Override // com.bytedance.sdk.component.kb.eli.eli
            public void eli(com.bytedance.sdk.component.kb.DbA.Os os, IOException iOException) {
                DbA dbA2 = DbA.this;
                if (dbA2 != null && dbA2.eli != null) {
                    Os.DbA(false, iOException != null ? iOException.getMessage() : null, dZ.Os(DbA.this.eli.cK()), DbA.this, str, z);
                }
                if (z || DbA.this == null) {
                    return;
                }
                Os.eli.put(str, DbA.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void DbA() {
        if (DbA.compareAndSet(false, true)) {
            Map<String, DbA> map = eli;
            HashSet<Map.Entry> hashSet = new HashSet(map.entrySet());
            map.clear();
            for (Map.Entry entry : hashSet) {
                if (entry != null) {
                    eli((String) entry.getKey(), (DbA) entry.getValue(), true);
                }
            }
            DbA.set(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void DbA(final boolean z, final String str, final String str2, final DbA dbA, final String str3, final boolean z2) {
        if (dbA == null || dbA.eli == null) {
            return;
        }
        final boolean Kv = dbA.eli.Kv();
        final String str4 = Kv ? "dsp_track_link_result" : "track_link_result";
        com.bytedance.sdk.openadsdk.aGH.Os.eli(new wC(str4) { // from class: com.bytedance.sdk.openadsdk.core.du.DbA.Os.3
            @Override // java.lang.Runnable
            public void run() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("type", dbA.DbA);
                    jSONObject.put("success", z);
                    jSONObject.put("url", str3);
                    if (z2) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("retry", true);
                        jSONObject.put("pag_json_data", jSONObject2.toString());
                    }
                    if (Kv) {
                        if (!TextUtils.isEmpty(str)) {
                            jSONObject.put("description", str);
                        }
                        if (dbA.Os >= 0.0f) {
                            jSONObject.put(NotificationCompat.CATEGORY_PROGRESS, Math.round(dbA.Os * 100.0f) / 100.0d);
                        }
                    }
                } catch (Throwable unused) {
                }
                com.bytedance.sdk.openadsdk.aGH.Os.DbA(dbA.eli, str2, str4, jSONObject);
            }
        });
    }

    public static JSONArray eli(List<Os> list) {
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < list.size(); i++) {
            jSONArray.put(list.get(i).Os());
        }
        return jSONArray;
    }

    public static List<Os> eli(JSONArray jSONArray) {
        return eli(jSONArray, false);
    }

    public static List<Os> eli(JSONArray jSONArray, boolean z) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                String optString = jSONArray.optString(i);
                if (!TextUtils.isEmpty(optString)) {
                    arrayList.add(new eli(optString).eli(z).eli());
                }
            }
        }
        return arrayList;
    }

    public static List<com.bytedance.sdk.openadsdk.core.du.DbA.DbA> DbA(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    arrayList.add(new DbA.eli(optJSONObject.optString("content"), (float) optJSONObject.optDouble("trackingFraction", 0.0d)).eli());
                }
            }
        }
        return arrayList;
    }

    public static List<com.bytedance.sdk.openadsdk.core.du.DbA.eli> Os(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    arrayList.add(new eli.C0189eli(optJSONObject.optString("content"), optJSONObject.optLong("trackingMilliseconds", 0L)).eli());
                }
            }
        }
        return arrayList;
    }

    public String Os() {
        return this.Os;
    }

    public boolean aGH() {
        return this.aGH;
    }

    public void m_() {
        this.MGA = true;
    }

    public boolean ui() {
        return this.MGA;
    }

    public static class eli {
        private EnumC0188Os DbA = EnumC0188Os.TRACKING_URL;
        private boolean Os = false;
        private final String eli;

        public eli(String str) {
            this.eli = str;
        }

        public eli eli(boolean z) {
            this.Os = z;
            return this;
        }

        public Os eli() {
            return new Os(this.eli, this.DbA, Boolean.valueOf(this.Os));
        }
    }

    public static class DbA {
        String DbA;
        float Os;
        final ev eli;

        public DbA(String str, ev evVar) {
            this(str, evVar, -1.0f);
        }

        public DbA(String str, ev evVar, float f) {
            this.DbA = str;
            this.eli = evVar;
            this.Os = f;
        }

        public String toString() {
            return super.toString();
        }
    }
}
