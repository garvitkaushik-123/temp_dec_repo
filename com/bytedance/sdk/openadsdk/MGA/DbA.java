package com.bytedance.sdk.openadsdk.MGA;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.component.utils.Xb;
import com.bytedance.sdk.component.utils.wC;
import com.bytedance.sdk.openadsdk.Dfc.eli.aGH;
import com.bytedance.sdk.openadsdk.core.Os;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.core.nn;
import com.bytedance.sdk.openadsdk.utils.qj;
import com.ironsource.C3207n2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class DbA {
    private static volatile DbA eli;
    private final ConcurrentHashMap<String, com.bytedance.sdk.openadsdk.aqO.eli> DbA = new ConcurrentHashMap<>();
    private com.bytedance.sdk.openadsdk.aqO.eli Os = null;
    private volatile boolean aGH = false;
    private volatile HandlerThread ui = null;
    private volatile Handler MGA = null;
    private String kb = "";
    private int wC = 0;
    private volatile long FC = 0;
    private final Runnable aAs = new Runnable() { // from class: com.bytedance.sdk.openadsdk.MGA.DbA.6
        @Override // java.lang.Runnable
        public void run() {
            try {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                try {
                } catch (Throwable th) {
                    Xb.Os(th.getMessage(), new Object[0]);
                }
                if (eli.eli().ui()) {
                    Set<String> keySet = DbA.this.DbA.keySet();
                    if (keySet.size() > DbA.this.wC) {
                        DbA.this.wC = keySet.size();
                    }
                    HashSet hashSet = new HashSet(5);
                    ArrayList arrayList = new ArrayList(keySet.size());
                    arrayList.addAll(DbA.this.DbA.values());
                    Collections.sort(arrayList);
                    for (int i = 0; i < arrayList.size() && i < 5; i++) {
                        hashSet.add(((com.bytedance.sdk.openadsdk.aqO.eli) arrayList.get(i)).DbA());
                    }
                    try {
                        for (String str : keySet) {
                            com.bytedance.sdk.openadsdk.aqO.eli eliVar = (com.bytedance.sdk.openadsdk.aqO.eli) DbA.this.DbA.get(str);
                            if (eliVar != null) {
                                JSONObject eli2 = eliVar.eli(jSONObject2);
                                if (hashSet.contains(str)) {
                                    jSONObject.put(str, eli2);
                                }
                            }
                        }
                        jSONObject.put("common", jSONObject2);
                    } catch (JSONException e) {
                        Xb.Os(e.getMessage(), new Object[0]);
                    }
                    DbA.this.kb = jSONObject.toString();
                    DbA dbA = DbA.this;
                    dbA.eli(dbA.aAs, eli.eli().aGH());
                }
                try {
                    if (DbA.this.Os != null) {
                        jSONObject.put("common", DbA.this.Os.eli(jSONObject2));
                    }
                } catch (JSONException e2) {
                    Xb.Os(e2.getMessage(), new Object[0]);
                }
                DbA.this.kb = jSONObject.toString();
                DbA dbA2 = DbA.this;
                dbA2.eli(dbA2.aAs, eli.eli().aGH());
            } catch (OutOfMemoryError e3) {
                Xb.Os(e3.getMessage(), new Object[0]);
            }
        }
    };

    private Handler Os() {
        if (this.ui == null || !this.ui.isAlive()) {
            synchronized (nn.class) {
                if (this.ui == null || !this.ui.isAlive()) {
                    this.ui = wC.eli("csj_feature", -1);
                    this.MGA = new Handler(this.ui.getLooper());
                }
            }
        } else if (this.MGA == null) {
            synchronized (nn.class) {
                if (this.MGA == null) {
                    this.MGA = new Handler(this.ui.getLooper());
                }
            }
        }
        return this.MGA;
    }

    private void eli(Runnable runnable) {
        if (qj.eli || runnable == null) {
            return;
        }
        try {
            Os().post(runnable);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eli(Runnable runnable, long j) {
        if (qj.eli || runnable == null) {
            return;
        }
        try {
            Os().postDelayed(runnable, j);
        } catch (Throwable unused) {
        }
    }

    private DbA() {
    }

    public static DbA eli() {
        if (eli == null) {
            synchronized (Os.class) {
                if (eli == null) {
                    eli = new DbA();
                }
            }
        }
        return eli;
    }

    public void eli(JSONObject jSONObject) {
        if (eli.eli().Os()) {
            try {
                jSONObject.put("feature_data", this.kb);
                aGH();
            } catch (JSONException e) {
                Xb.Os(e.getMessage(), new Object[0]);
            }
        }
    }

    private void aGH() {
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        if (elapsedRealtime - this.FC > 10000) {
            com.bytedance.sdk.openadsdk.Dfc.Os.eli("track_feature_result", false, new com.bytedance.sdk.openadsdk.Dfc.DbA() { // from class: com.bytedance.sdk.openadsdk.MGA.DbA.1
                @Override // com.bytedance.sdk.openadsdk.Dfc.DbA
                public com.bytedance.sdk.openadsdk.Dfc.eli.Os getLogStats() throws Exception {
                    DbA.this.FC = elapsedRealtime;
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, String.valueOf(DbA.this.wC));
                    return aGH.DbA().eli("track_feature_result").DbA(jSONObject.toString());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eli(String str, String str2, String str3) {
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && eli.eli().Os()) {
                ui();
                if (eli.eli().ui()) {
                    com.bytedance.sdk.openadsdk.aqO.eli eliVar = this.DbA.get(str2);
                    if (eliVar == null) {
                        eliVar = new com.bytedance.sdk.openadsdk.aqO.eli(str2);
                    }
                    eliVar.eli(str, str3);
                    this.DbA.put(str2, eliVar);
                    return;
                }
                if (this.Os == null) {
                    this.Os = new com.bytedance.sdk.openadsdk.aqO.eli(str2);
                }
                this.Os.eli(str, str3);
            }
        } catch (OutOfMemoryError e) {
            Xb.Os(e.getMessage(), new Object[0]);
        }
    }

    public void eli(final String str, final String str2, final String str3, String str4) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !eli.eli().Os()) {
            return;
        }
        if (C3207n2.v.equals(str) || "click".equals(str) || "dislike".equals(str)) {
            eli(new Runnable() { // from class: com.bytedance.sdk.openadsdk.MGA.DbA.2
                @Override // java.lang.Runnable
                public void run() {
                    DbA.this.eli(str, str2, str3);
                }
            });
            return;
        }
        if (eli.eli().nGm()) {
            if (TextUtils.isEmpty(str4)) {
                return;
            }
            if (!"rewarded_video".equals(str4) && !"fullscreen_interstitial_ad".equals(str4) && !"open_ad".equals(str4)) {
                return;
            }
        }
        if ("feed_play".equals(str) || "feed_pause".equals(str) || "feed_continue".equals(str) || "feed_over".equals(str) || "feed_break".equals(str) || "play_error".equals(str)) {
            eli(new Runnable() { // from class: com.bytedance.sdk.openadsdk.MGA.DbA.3
                @Override // java.lang.Runnable
                public void run() {
                    DbA.this.eli(str, str2, str3);
                }
            });
        }
    }

    public void eli(final String str, final ev evVar) {
        if (!TextUtils.isEmpty(str) && eli.eli().Os() && ev.ui(evVar)) {
            if (!eli.eli().nGm() || evVar.bBQ() == 8 || evVar.bBQ() == 7 || evVar.bBQ() == 3) {
                if ("videoPercent30".equals(str) || "videoForceBreak".equals(str)) {
                    eli(new Runnable() { // from class: com.bytedance.sdk.openadsdk.MGA.DbA.4
                        @Override // java.lang.Runnable
                        public void run() {
                            String Uv = evVar.Uv();
                            String fO = evVar.fO();
                            if (TextUtils.isEmpty(Uv)) {
                                return;
                            }
                            DbA.this.eli(str, Uv, fO);
                        }
                    });
                }
            }
        }
    }

    public void eli(final String str, final ev evVar, final String str2) {
        if (TextUtils.isEmpty(str) || !eli.eli().Os()) {
            return;
        }
        if ("landingStart".equals(str) || "landingFinish".equals(str) || "landingContinue".equals(str) || "landingPause".equals(str)) {
            eli(new Runnable() { // from class: com.bytedance.sdk.openadsdk.MGA.DbA.5
                @Override // java.lang.Runnable
                public void run() {
                    ev evVar2 = evVar;
                    if (evVar2 == null || TextUtils.isEmpty(evVar2.Uv())) {
                        return;
                    }
                    DbA.this.eli(str, evVar.Uv(), evVar.fO() + str2);
                }
            });
        }
    }

    private void ui() {
        if (this.aGH) {
            return;
        }
        this.aGH = true;
        eli(this.aAs, eli.eli().aGH());
    }

    public void DbA() {
        try {
            if (eli.eli().Os()) {
                eli(new Runnable() { // from class: com.bytedance.sdk.openadsdk.MGA.DbA.7
                    @Override // java.lang.Runnable
                    public void run() {
                        if (eli.eli().ui()) {
                            Iterator it = DbA.this.DbA.keySet().iterator();
                            while (it.hasNext()) {
                                com.bytedance.sdk.openadsdk.aqO.eli eliVar = (com.bytedance.sdk.openadsdk.aqO.eli) DbA.this.DbA.get((String) it.next());
                                if (eliVar != null) {
                                    eliVar.eli();
                                }
                            }
                            return;
                        }
                        if (DbA.this.Os != null) {
                            DbA.this.Os.eli();
                        }
                    }
                });
            }
        } catch (OutOfMemoryError e) {
            Xb.Os(e.getMessage(), new Object[0]);
        }
    }
}
