package com.bytedance.sdk.openadsdk.aGH;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.Xb;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.moloco.sdk.internal.services.init.i;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class nGm implements com.bytedance.sdk.openadsdk.aGH.aGH.ui {
    private ev DbA;
    private JSONObject MGA;
    private Boolean Os;
    private Boolean aGH;
    private String eli;
    private JSONArray kb;
    private Boolean ui;
    private JSONArray wC;

    public nGm(int i, String str, ev evVar) {
        this.eli = "embeded_ad";
        this.Os = Boolean.FALSE;
        this.aGH = Boolean.FALSE;
        this.ui = Boolean.FALSE;
        this.eli = str;
        this.DbA = evVar;
        this.MGA = new JSONObject();
        this.kb = new JSONArray();
        this.wC = new JSONArray();
        eli(this.MGA, "webview_source", Integer.valueOf(i));
    }

    protected nGm() {
        this.eli = "embeded_ad";
        this.Os = Boolean.FALSE;
        this.aGH = Boolean.FALSE;
        this.ui = Boolean.FALSE;
    }

    @Override // com.bytedance.sdk.openadsdk.aGH.aGH.aGH
    public void eli() {
        com.bytedance.sdk.component.utils.FC.eli().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.aGH.nGm.1
            @Override // java.lang.Runnable
            public void run() {
                long currentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                nGm.this.eli(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                nGm ngm = nGm.this;
                ngm.eli(jSONObject, "render_sequence", Integer.valueOf(ngm.DbA.rH()));
                if (nGm.this.DbA != null) {
                    if (nGm.this.DbA.RY() != null) {
                        if (nGm.this.DbA.RY().nlS()) {
                            nGm.this.eli(jSONObject, "webview_count", Integer.valueOf(com.bytedance.sdk.component.adexpress.ui.ui.eli().aGH()));
                            nGm.this.eli(jSONObject, "available_cache_count", Integer.valueOf(com.bytedance.sdk.component.adexpress.ui.ui.eli().aGH()));
                        } else {
                            nGm.this.eli(jSONObject, "webview_count", Integer.valueOf(com.bytedance.sdk.component.adexpress.ui.ui.eli().Os()));
                            nGm.this.eli(jSONObject, "available_cache_count", Integer.valueOf(com.bytedance.sdk.component.adexpress.ui.ui.eli().Os()));
                        }
                    } else if (nGm.this.DbA.hg() != null) {
                        nGm.this.eli(jSONObject, "webview_count", Integer.valueOf(com.bytedance.sdk.component.adexpress.ui.ui.eli().aGH()));
                        nGm.this.eli(jSONObject, "available_cache_count", Integer.valueOf(com.bytedance.sdk.component.adexpress.ui.ui.eli().aGH()));
                    }
                }
                nGm ngm2 = nGm.this;
                ngm2.eli(ngm2.MGA, "render_start", jSONObject);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.aGH.aGH.aGH
    public void DbA() {
        com.bytedance.sdk.component.utils.FC.eli().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.aGH.nGm.12
            @Override // java.lang.Runnable
            public void run() {
                long currentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                nGm.this.eli(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                nGm ngm = nGm.this;
                ngm.eli(ngm.MGA, "render_success", jSONObject);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.aGH.aGH.aGH
    public void eli(final int i, final String str) {
        com.bytedance.sdk.component.utils.FC.eli().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.aGH.nGm.23
            @Override // java.lang.Runnable
            public void run() {
                long currentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                nGm.this.eli(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                nGm.this.eli(jSONObject, "code", Integer.valueOf(i));
                String str2 = str;
                if (str2 != null) {
                    nGm.this.eli(jSONObject, "reason", str2);
                }
                nGm ngm = nGm.this;
                ngm.eli(ngm.MGA, "render_error", jSONObject);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.aGH.aGH.DbA
    public void Os() {
        com.bytedance.sdk.component.utils.FC.eli().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.aGH.nGm.25
            @Override // java.lang.Runnable
            public void run() {
                long currentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                nGm.this.eli(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                nGm ngm = nGm.this;
                ngm.eli(ngm.MGA, "native_render_start", jSONObject);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.aGH.aGH.Os
    public void aGH() {
        com.bytedance.sdk.component.utils.FC.eli().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.aGH.nGm.26
            @Override // java.lang.Runnable
            public void run() {
                long currentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                nGm.this.eli(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                nGm ngm = nGm.this;
                ngm.eli(ngm.MGA, "native_render_end", jSONObject);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.aGH.aGH.MGA
    public void ui() {
        com.bytedance.sdk.component.utils.FC.eli().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.aGH.nGm.27
            @Override // java.lang.Runnable
            public void run() {
                long currentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                nGm.this.eli(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                nGm ngm = nGm.this;
                ngm.eli(ngm.MGA, "webview_load_start", (Object) jSONObject, false);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.aGH.aGH.MGA
    public void MGA() {
        com.bytedance.sdk.component.utils.FC.eli().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.aGH.nGm.28
            @Override // java.lang.Runnable
            public void run() {
                long currentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                nGm.this.eli(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                nGm ngm = nGm.this;
                ngm.eli(ngm.MGA, "webview_load_success", jSONObject);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.aGH.aGH.MGA
    public void eli(final JSONObject jSONObject) {
        com.bytedance.sdk.component.utils.FC.eli().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.aGH.nGm.29
            @Override // java.lang.Runnable
            public void run() {
                JSONObject jSONObject2 = jSONObject;
                if (jSONObject2 == null) {
                    jSONObject2 = new JSONObject();
                }
                nGm.this.eli(jSONObject2, "ts", Long.valueOf(System.currentTimeMillis()));
                nGm ngm = nGm.this;
                ngm.eli(ngm.MGA, "webview_load_error", jSONObject2);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.aGH.aGH.Os
    public void kb() {
        com.bytedance.sdk.component.utils.FC.eli().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.aGH.nGm.30
            @Override // java.lang.Runnable
            public void run() {
                long currentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                nGm.this.eli(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                nGm ngm = nGm.this;
                ngm.eli(ngm.MGA, "native_endcard_show", jSONObject);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.aGH.aGH.Os
    public void wC() {
        com.bytedance.sdk.component.utils.FC.eli().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.aGH.nGm.2
            @Override // java.lang.Runnable
            public void run() {
                long currentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                nGm.this.eli(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                nGm ngm = nGm.this;
                ngm.eli(ngm.MGA, "native_endcard_close", jSONObject);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.aGH.aGH.Os
    public void FC() {
        com.bytedance.sdk.component.utils.FC.eli().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.aGH.nGm.3
            @Override // java.lang.Runnable
            public void run() {
                long currentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                nGm.this.eli(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                nGm.this.eli(jSONObject, "type", "native_enterBackground");
                nGm ngm = nGm.this;
                ngm.eli(ngm.kb, jSONObject);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.aGH.aGH.Os
    public void aAs() {
        com.bytedance.sdk.component.utils.FC.eli().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.aGH.nGm.4
            @Override // java.lang.Runnable
            public void run() {
                long currentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                nGm.this.eli(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                nGm.this.eli(jSONObject, "type", "native_enterForeground");
                nGm ngm = nGm.this;
                ngm.eli(ngm.kb, jSONObject);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.aGH.aGH.MGA
    public void eli(final String str, final long j, final long j2, final int i) {
        com.bytedance.sdk.component.utils.FC.eli().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.aGH.nGm.5
            @Override // java.lang.Runnable
            public void run() {
                if (TextUtils.isEmpty(str) || j2 < j) {
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                nGm.this.eli(jSONObject, "start_ts", Long.valueOf(j));
                nGm.this.eli(jSONObject, "end_ts", Long.valueOf(j2));
                nGm.this.eli(jSONObject, "intercept_type", Integer.valueOf(i));
                nGm.this.eli(jSONObject, "type", "intercept_html");
                nGm.this.eli(jSONObject, "url", str);
                nGm.this.eli(jSONObject, "duration", Long.valueOf(j2 - j));
                nGm ngm = nGm.this;
                ngm.eli(ngm.wC, jSONObject);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.aGH.aGH.MGA
    public void DbA(final String str, final long j, final long j2, final int i) {
        com.bytedance.sdk.component.utils.FC.eli().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.aGH.nGm.6
            @Override // java.lang.Runnable
            public void run() {
                if (TextUtils.isEmpty(str) || j2 < j) {
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                nGm.this.eli(jSONObject, "start_ts", Long.valueOf(j));
                nGm.this.eli(jSONObject, "end_ts", Long.valueOf(j2));
                nGm.this.eli(jSONObject, "intercept_type", Integer.valueOf(i));
                nGm.this.eli(jSONObject, "type", "intercept_js");
                nGm.this.eli(jSONObject, "url", str);
                nGm.this.eli(jSONObject, "duration", Long.valueOf(j2 - j));
                nGm ngm = nGm.this;
                ngm.eli(ngm.wC, jSONObject);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.aGH.aGH.MGA
    public void eli(final String str) {
        com.bytedance.sdk.component.utils.FC.eli().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.aGH.nGm.7
            @Override // java.lang.Runnable
            public void run() {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                nGm.this.eli(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                nGm.this.eli(jSONObject, "jsb", str);
                nGm ngm = nGm.this;
                ngm.eli(ngm.MGA, "webview_jsb_start", jSONObject);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.aGH.aGH.MGA
    public void DbA(final String str) {
        com.bytedance.sdk.component.utils.FC.eli().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.aGH.nGm.8
            @Override // java.lang.Runnable
            public void run() {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                nGm.this.eli(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                nGm.this.eli(jSONObject, "jsb", str);
                nGm ngm = nGm.this;
                ngm.eli(ngm.MGA, "webview_jsb_end", jSONObject);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.aGH.aGH.MGA
    public void DbA(final JSONObject jSONObject) {
        com.bytedance.sdk.component.utils.FC.eli().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.aGH.nGm.9
            @Override // java.lang.Runnable
            public void run() {
                JSONObject jSONObject2;
                if (nGm.this.MGA == null || (jSONObject2 = jSONObject) == null) {
                    return;
                }
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    nGm ngm = nGm.this;
                    ngm.eli(ngm.MGA, next, jSONObject.opt(next));
                }
                nGm.this.aGH = Boolean.TRUE;
                nGm.this.nlS();
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.aGH.aGH.ui
    public void du() {
        this.Os = Boolean.TRUE;
    }

    @Override // com.bytedance.sdk.openadsdk.aGH.aGH.ui
    public void eli(boolean z) {
        this.ui = Boolean.valueOf(z);
    }

    @Override // com.bytedance.sdk.openadsdk.aGH.aGH.ui
    public void nlS() {
        com.bytedance.sdk.component.utils.FC.eli().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.aGH.nGm.10
            @Override // java.lang.Runnable
            public void run() {
                if (nGm.this.dV()) {
                    if (nGm.this.kb != null && nGm.this.kb.length() != 0) {
                        try {
                            nGm.this.MGA.put("native_switchBackgroundAndForeground", nGm.this.kb);
                        } catch (Exception unused) {
                        }
                    }
                    if (nGm.this.wC != null && nGm.this.wC.length() != 0) {
                        try {
                            nGm.this.MGA.put("intercept_source", nGm.this.wC);
                        } catch (Exception unused2) {
                        }
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("webview_time_track", nGm.this.MGA);
                    } catch (JSONException e) {
                        Xb.eli("WebviewTimeTrack", "trySendTrackInfo json error", e);
                    }
                    if (com.bytedance.sdk.openadsdk.core.FC.DbA().dV() && nGm.this.MGA != null) {
                        JSONObject unused3 = nGm.this.MGA;
                    }
                    Os.DbA(nGm.this.DbA, nGm.this.eli, "webview_time_track", jSONObject);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dV() {
        if (this.ui.booleanValue()) {
            return true;
        }
        return this.aGH.booleanValue() && this.Os.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eli(JSONObject jSONObject, String str, Object obj, boolean z) {
        if (jSONObject == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (!z) {
            try {
                if (jSONObject.has(str)) {
                    return;
                }
            } catch (Exception unused) {
                return;
            }
        }
        jSONObject.put(str, obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eli(JSONObject jSONObject, String str, Object obj) {
        eli(jSONObject, str, obj, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eli(JSONArray jSONArray, Object obj) {
        if (jSONArray == null || jSONArray.length() >= 10) {
            return;
        }
        try {
            jSONArray.put(obj);
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.aGH.aGH.eli
    public void Os(final String str) {
        com.bytedance.sdk.component.utils.FC.eli().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.aGH.nGm.11
            @Override // java.lang.Runnable
            public void run() {
                long currentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                nGm.this.eli(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                nGm ngm = nGm.this;
                ngm.eli(ngm.MGA, str, jSONObject);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.aGH.aGH.eli
    public void DbA(final int i, final String str) {
        com.bytedance.sdk.component.utils.FC.eli().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.aGH.nGm.13
            @Override // java.lang.Runnable
            public void run() {
                long currentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                nGm.this.eli(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                nGm.this.eli(jSONObject, "code", Integer.valueOf(i));
                nGm ngm = nGm.this;
                ngm.eli(ngm.MGA, str, jSONObject);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.aGH.aGH.DbA
    public void NU() {
        com.bytedance.sdk.component.utils.FC.eli().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.aGH.nGm.14
            @Override // java.lang.Runnable
            public void run() {
                long currentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                nGm.this.eli(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                nGm ngm = nGm.this;
                ngm.eli(ngm.MGA, "native_render_end", jSONObject);
                long currentTimeMillis2 = System.currentTimeMillis();
                JSONObject jSONObject2 = new JSONObject();
                nGm.this.eli(jSONObject2, "ts", Long.valueOf(currentTimeMillis2));
                nGm ngm2 = nGm.this;
                ngm2.eli(ngm2.MGA, "render_success", jSONObject2);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.aGH.aGH.DbA
    public void nn() {
        com.bytedance.sdk.component.utils.FC.eli().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.aGH.nGm.15
            @Override // java.lang.Runnable
            public void run() {
                long currentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                nGm.this.eli(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                nGm ngm = nGm.this;
                ngm.eli(ngm.MGA, "no_native_render", jSONObject);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.aGH.aGH.aGH
    public void Dfc() {
        com.bytedance.sdk.component.utils.FC.eli().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.aGH.nGm.16
            @Override // java.lang.Runnable
            public void run() {
                long currentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                nGm.this.eli(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                nGm ngm = nGm.this;
                ngm.eli(ngm.MGA, "render_failed", jSONObject);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.aGH.aGH.aGH
    public void aqO() {
        try {
            com.bytedance.sdk.component.utils.FC.eli().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.aGH.nGm.17
                @Override // java.lang.Runnable
                public void run() {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    nGm.this.eli(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                    nGm ngm = nGm.this;
                    ngm.eli(ngm.MGA, "render_did_finish", jSONObject);
                }
            });
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.aGH.aGH.eli
    public void aGH(final String str) {
        com.bytedance.sdk.component.utils.FC.eli().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.aGH.nGm.18
            @Override // java.lang.Runnable
            public void run() {
                long currentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                nGm.this.eli(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                nGm ngm = nGm.this;
                ngm.eli(ngm.MGA, str, jSONObject);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.aGH.aGH.eli
    public void ui(final String str) {
        try {
            com.bytedance.sdk.component.utils.FC.eli().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.aGH.nGm.19
                @Override // java.lang.Runnable
                public void run() {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    nGm.this.eli(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                    nGm ngm = nGm.this;
                    ngm.eli(ngm.MGA, str, jSONObject);
                }
            });
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.aGH.aGH.eli
    public void MGA(final String str) {
        try {
            com.bytedance.sdk.component.utils.FC.eli().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.aGH.nGm.20
                @Override // java.lang.Runnable
                public void run() {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    nGm.this.eli(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                    nGm ngm = nGm.this;
                    ngm.eli(ngm.MGA, str, jSONObject);
                }
            });
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.aGH.aGH.eli
    public void Os(final int i, final String str) {
        try {
            com.bytedance.sdk.component.utils.FC.eli().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.aGH.nGm.21
                @Override // java.lang.Runnable
                public void run() {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    nGm.this.eli(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                    nGm.this.eli(jSONObject, "code", Integer.valueOf(i));
                    nGm ngm = nGm.this;
                    ngm.eli(ngm.MGA, str, jSONObject);
                }
            });
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.aGH.aGH.eli
    public void kb(final String str) {
        com.bytedance.sdk.component.utils.FC.eli().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.aGH.nGm.22
            @Override // java.lang.Runnable
            public void run() {
                long currentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                nGm.this.eli(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                nGm ngm = nGm.this;
                ngm.eli(ngm.MGA, str, jSONObject);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.aGH.aGH.MGA
    public void eli(final int i) {
        com.bytedance.sdk.component.utils.FC.eli().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.aGH.nGm.24
            @Override // java.lang.Runnable
            public void run() {
                long currentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                nGm.this.eli(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                nGm.this.eli(jSONObject, "isWebViewCache", Integer.valueOf(i));
                if (nGm.this.DbA != null) {
                    if (nGm.this.DbA.qWy()) {
                        nGm.this.eli(jSONObject, "engine_version", "v3");
                    } else {
                        nGm.this.eli(jSONObject, "engine_version", i.f5703a);
                    }
                }
                nGm ngm = nGm.this;
                ngm.eli(ngm.MGA, "before_webview_request", jSONObject);
            }
        });
    }
}
