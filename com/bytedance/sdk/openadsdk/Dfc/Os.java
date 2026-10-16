package com.bytedance.sdk.openadsdk.Dfc;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.component.utils.Xb;
import com.bytedance.sdk.component.wC.wC;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.Dfc.eli.aGH;
import com.bytedance.sdk.openadsdk.core.dV;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.core.nlS;
import com.bytedance.sdk.openadsdk.core.nn;
import com.bytedance.sdk.openadsdk.core.settings.NU;
import com.bytedance.sdk.openadsdk.utils.cyF;
import com.bytedance.sdk.openadsdk.utils.dZ;
import com.ironsource.C3040d4;
import com.ironsource.N6;
import com.ironsource.unity.androidbridge.AndroidBridgeConstants;
import java.io.File;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Os {
    private static volatile Os eli;

    private boolean Os(aGH agh) {
        return agh == null;
    }

    private Os() {
    }

    public static Os eli() {
        if (eli == null) {
            synchronized (Os.class) {
                if (eli == null) {
                    eli = new Os();
                }
            }
        }
        return eli;
    }

    public static void eli(final ev evVar) {
        if (evVar == null) {
            return;
        }
        final long currentTimeMillis = System.currentTimeMillis();
        eli("bidding_receive", false, new DbA() { // from class: com.bytedance.sdk.openadsdk.Dfc.Os.1
            @Override // com.bytedance.sdk.openadsdk.Dfc.DbA
            public com.bytedance.sdk.openadsdk.Dfc.eli.Os getLogStats() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("reveice_ts", currentTimeMillis);
                if (evVar.bBQ() == 3) {
                    jSONObject.put("is_icon_only", evVar.gG() ? 1 : 0);
                }
                return aGH.DbA().eli("bidding_receive").DbA(jSONObject.toString());
            }
        });
    }

    public static void eli(ev evVar, final long j) {
        if (evVar == null) {
            return;
        }
        eli("bidding_load", false, new DbA() { // from class: com.bytedance.sdk.openadsdk.Dfc.Os.12
            @Override // com.bytedance.sdk.openadsdk.Dfc.DbA
            public com.bytedance.sdk.openadsdk.Dfc.eli.Os getLogStats() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("duration", j);
                return aGH.DbA().eli("bidding_load").DbA(jSONObject.toString());
            }
        });
    }

    public static void eli(final String str, final com.bytedance.sdk.openadsdk.aGH.ui.DbA.eli eliVar) {
        if (eliVar == null) {
            return;
        }
        eli(str, false, new DbA() { // from class: com.bytedance.sdk.openadsdk.Dfc.Os.17
            @Override // com.bytedance.sdk.openadsdk.Dfc.DbA
            public com.bytedance.sdk.openadsdk.Dfc.eli.Os getLogStats() throws Exception {
                JSONObject Os = com.bytedance.sdk.openadsdk.aGH.ui.DbA.eli.this.Os();
                if (Os == null) {
                    Os = new JSONObject();
                }
                com.bytedance.sdk.openadsdk.aGH.ui.DbA.Os aGH = com.bytedance.sdk.openadsdk.aGH.ui.DbA.eli.this.aGH();
                if (aGH != null) {
                    aGH.eli(Os);
                }
                return aGH.DbA().eli(str).eli(com.bytedance.sdk.openadsdk.aGH.ui.DbA.eli.this.eli().bBQ()).DbA(Os.toString());
            }
        });
    }

    public static void DbA(final ev evVar) {
        if (dZ.eli(evVar) == null || TextUtils.isEmpty(evVar.QxD())) {
            return;
        }
        eli("download_gecko_start", false, new DbA() { // from class: com.bytedance.sdk.openadsdk.Dfc.Os.18
            @Override // com.bytedance.sdk.openadsdk.Dfc.DbA
            public com.bytedance.sdk.openadsdk.Dfc.eli.Os getLogStats() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("url", ev.this.dM());
                jSONObject.put("channel_name", ev.this.QxD());
                return aGH.DbA().eli("download_gecko_start").eli(ev.this.bBQ()).DbA(jSONObject.toString());
            }
        });
    }

    public static void eli(final ev evVar, final JSONObject jSONObject) {
        if (dZ.eli(evVar) == null || TextUtils.isEmpty(evVar.QxD())) {
            return;
        }
        eli("download_gecko_end", false, new DbA() { // from class: com.bytedance.sdk.openadsdk.Dfc.Os.19
            @Override // com.bytedance.sdk.openadsdk.Dfc.DbA
            public com.bytedance.sdk.openadsdk.Dfc.eli.Os getLogStats() throws Exception {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("url", ev.this.dM());
                jSONObject2.put("channel_name", ev.this.QxD());
                jSONObject2.put("data", jSONObject);
                return aGH.DbA().eli("download_gecko_end").eli(ev.this.bBQ()).DbA(jSONObject2.toString());
            }
        });
    }

    public void eli(final aGH agh) {
        if (Os(agh)) {
            return;
        }
        agh.eli("express_ad_render");
        dV.ui().eli(new DbA() { // from class: com.bytedance.sdk.openadsdk.Dfc.Os.20
            @Override // com.bytedance.sdk.openadsdk.Dfc.DbA
            public com.bytedance.sdk.openadsdk.Dfc.eli.Os getLogStats() throws Exception {
                return agh;
            }
        });
    }

    public void DbA(final aGH agh) {
        if (Os(agh)) {
            return;
        }
        agh.eli("show_backup_endcard");
        dV.ui().eli(new DbA() { // from class: com.bytedance.sdk.openadsdk.Dfc.Os.21
            @Override // com.bytedance.sdk.openadsdk.Dfc.DbA
            public com.bytedance.sdk.openadsdk.Dfc.eli.Os getLogStats() throws Exception {
                return agh;
            }
        });
    }

    public void eli(final String str) {
        eli("click_playable_test_tool", false, new DbA() { // from class: com.bytedance.sdk.openadsdk.Dfc.Os.2
            @Override // com.bytedance.sdk.openadsdk.Dfc.DbA
            public com.bytedance.sdk.openadsdk.Dfc.eli.Os getLogStats() throws Exception {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("playable_url", str);
                } catch (Throwable unused) {
                }
                return aGH.DbA().eli("click_playable_test_tool").DbA(jSONObject.toString());
            }
        });
    }

    public void DbA(final String str) {
        eli("close_playable_test_tool", false, new DbA() { // from class: com.bytedance.sdk.openadsdk.Dfc.Os.3
            @Override // com.bytedance.sdk.openadsdk.Dfc.DbA
            public com.bytedance.sdk.openadsdk.Dfc.eli.Os getLogStats() throws Exception {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("playable_url", str);
                } catch (Throwable unused) {
                }
                return aGH.DbA().eli("close_playable_test_tool").DbA(jSONObject.toString());
            }
        });
    }

    public void eli(final String str, final int i, final String str2) {
        eli("use_playable_test_tool_error", false, new DbA() { // from class: com.bytedance.sdk.openadsdk.Dfc.Os.4
            @Override // com.bytedance.sdk.openadsdk.Dfc.DbA
            public com.bytedance.sdk.openadsdk.Dfc.eli.Os getLogStats() throws Exception {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("playable_url", str);
                    jSONObject.put(AndroidBridgeConstants.ERROR_CODE, i);
                    jSONObject.put("error_message", str2);
                } catch (Throwable unused) {
                }
                return aGH.DbA().eli("use_playable_test_tool_error").DbA(jSONObject.toString());
            }
        });
    }

    public void eli(final long j, final long j2) {
        final long j3 = j2 - j;
        eli("general_label", false, new DbA() { // from class: com.bytedance.sdk.openadsdk.Dfc.Os.5
            @Override // com.bytedance.sdk.openadsdk.Dfc.DbA
            public com.bytedance.sdk.openadsdk.Dfc.eli.Os getLogStats() throws Exception {
                int i = !nn.DbA.get() ? 1 : 0;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("starttime", j);
                    jSONObject.put("endtime", j2);
                    jSONObject.put("start_type", i);
                } catch (Throwable unused) {
                }
                return aGH.DbA().eli("general_label").wC(String.valueOf(j3)).DbA(jSONObject.toString());
            }
        });
    }

    public static void DbA() {
        cyF.Os(new wC("showFailLog") { // from class: com.bytedance.sdk.openadsdk.Dfc.Os.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Os.eli().eli("show_fail_log", new JSONObject());
                } catch (Throwable th) {
                    Xb.Os("StatsLogManager", th.getMessage());
                }
            }
        });
    }

    public void eli(final String str, final JSONObject jSONObject) {
        if (str == null || jSONObject == null) {
            return;
        }
        eli(str, false, new DbA() { // from class: com.bytedance.sdk.openadsdk.Dfc.Os.7
            @Override // com.bytedance.sdk.openadsdk.Dfc.DbA
            public com.bytedance.sdk.openadsdk.Dfc.eli.Os getLogStats() throws Exception {
                return aGH.DbA().eli(str).DbA(jSONObject.toString());
            }
        });
    }

    public void eli(final String str, final String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        eli(str, false, new DbA() { // from class: com.bytedance.sdk.openadsdk.Dfc.Os.8
            @Override // com.bytedance.sdk.openadsdk.Dfc.DbA
            public com.bytedance.sdk.openadsdk.Dfc.eli.Os getLogStats() throws Exception {
                return aGH.DbA().eli(str).DbA(str2);
            }
        });
    }

    public void Os() {
        eli("blind_mode_status", true, new DbA() { // from class: com.bytedance.sdk.openadsdk.Dfc.Os.9
            @Override // com.bytedance.sdk.openadsdk.Dfc.DbA
            public com.bytedance.sdk.openadsdk.Dfc.eli.Os getLogStats() throws Exception {
                return aGH.DbA().eli("blind_mode_status");
            }
        });
    }

    public void eli(final JSONObject jSONObject) {
        if (jSONObject == null) {
            Xb.eli("adRevenuePangle", "You must pass adRevenue json to pangle");
            return;
        }
        Object opt = jSONObject.opt("device_ad_mediation_platform");
        if (!(opt instanceof String) || TextUtils.isEmpty((String) opt)) {
            Xb.eli("adRevenuePangle", "You must pass device_ad_mediation_platform to pangle");
        } else {
            Xb.eli("adRevenuePangle", "pangle", "You successfully passed the parameters to pangle. The parameters are:", jSONObject);
            eli("ad_revenue", true, new DbA() { // from class: com.bytedance.sdk.openadsdk.Dfc.Os.10
                @Override // com.bytedance.sdk.openadsdk.Dfc.DbA
                public com.bytedance.sdk.openadsdk.Dfc.eli.Os getLogStats() throws Exception {
                    try {
                        jSONObject.put("event", 272);
                        jSONObject.put("uuid", nlS.Os(dV.eli()));
                        String str = "";
                        try {
                            if (nlS.eli(dV.eli()) != null) {
                                str = nlS.eli(dV.eli());
                            }
                        } catch (Throwable th) {
                            th.getMessage();
                        }
                        jSONObject.put("device_id", str);
                        jSONObject.put(N6.H, "android");
                        jSONObject.put("partner", "PangleSDK");
                    } catch (Throwable th2) {
                        th2.getMessage();
                    }
                    return aGH.DbA().eli("ad_revenue").DbA(jSONObject.toString());
                }
            });
        }
    }

    public static void aGH() {
        eli("disk_log", false, new DbA() { // from class: com.bytedance.sdk.openadsdk.Dfc.Os.11
            @Override // com.bytedance.sdk.openadsdk.Dfc.DbA
            public com.bytedance.sdk.openadsdk.Dfc.eli.Os getLogStats() throws Exception {
                JSONObject jSONObject = new JSONObject();
                File file = new File(CacheDirFactory.getRootDir());
                long j = 0;
                if (file.exists() && file.isDirectory()) {
                    for (File file2 : file.listFiles()) {
                        long eli2 = Os.eli(file2);
                        j += eli2;
                        jSONObject.put(file2.getName(), eli2);
                    }
                }
                if (j < 524288000) {
                    return null;
                }
                return aGH.DbA().eli("disk_log").DbA(jSONObject.toString());
            }
        });
    }

    public static long eli(File file) {
        if (file.isFile()) {
            return file.length();
        }
        long j = 0;
        for (File file2 : file.listFiles()) {
            j += eli(file2);
        }
        return j;
    }

    public static void DbA(String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                final aGH DbA = aGH.DbA().eli(str).DbA(str2);
                dV.ui().eli(new DbA() { // from class: com.bytedance.sdk.openadsdk.Dfc.Os.13
                    @Override // com.bytedance.sdk.openadsdk.Dfc.DbA
                    public com.bytedance.sdk.openadsdk.Dfc.eli.Os getLogStats() throws Exception {
                        return aGH.this;
                    }
                }, false);
            }
        } catch (Throwable th) {
            Xb.Os("StatsLogManager", th.getMessage());
        }
    }

    public static void eli(String str, boolean z, DbA dbA) {
        eli(str, z, 100, dbA);
    }

    public static void eli(String str, boolean z, int i, DbA dbA) {
        int eli2 = NU.nY().eli(str, i);
        new Object[]{"type=", str, "  ", Integer.valueOf(eli2)};
        if (TextUtils.isEmpty(str) || eli2 == 0 || dbA == null) {
            return;
        }
        boolean z2 = eli2 == 100;
        if (!z2) {
            z2 = ((int) ((Math.random() * 100.0d) + 1.0d)) <= eli2;
        }
        if (z2) {
            dV.ui().eli(dbA, z);
        }
    }

    public static void eli(long j, long j2, final String str, final int i) {
        if (j == 0) {
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        final long j3 = elapsedRealtime - j;
        final long j4 = elapsedRealtime - j2;
        final long j5 = j2 - j;
        eli("ad_show_cost_time", false, new DbA() { // from class: com.bytedance.sdk.openadsdk.Dfc.Os.14
            @Override // com.bytedance.sdk.openadsdk.Dfc.DbA
            public com.bytedance.sdk.openadsdk.Dfc.eli.Os getLogStats() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("duration", j3);
                jSONObject.put("renderDuration", j4);
                jSONObject.put("showToRenderDuration", j5);
                jSONObject.put("tag", str);
                jSONObject.put("renderType", i);
                return aGH.DbA().eli("ad_show_cost_time").DbA(jSONObject.toString());
            }
        });
    }

    public static void eli(int i, String str) {
        eli(i, str, 0, (String) null);
    }

    public static void eli(final int i, final String str, final int i2, final String str2) {
        eli("ipv6_req", false, (DbA) new DbA<com.bytedance.sdk.openadsdk.Dfc.eli.Os>() { // from class: com.bytedance.sdk.openadsdk.Dfc.Os.15
            @Override // com.bytedance.sdk.openadsdk.Dfc.DbA
            public com.bytedance.sdk.openadsdk.Dfc.eli.Os getLogStats() throws Exception {
                String str3;
                JSONObject jSONObject = new JSONObject();
                int i3 = i;
                if (i3 == 1) {
                    str3 = "success";
                } else if (i3 != -1) {
                    str3 = "start";
                } else {
                    jSONObject.put(AndroidBridgeConstants.ERROR_CODE, i2);
                    jSONObject.put("error_msg", str2);
                    str3 = C3040d4.f.e;
                }
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put("url", str);
                }
                jSONObject.put("status", str3);
                return aGH.DbA().eli("ipv6_req").DbA(jSONObject.toString());
            }
        });
    }

    public static void eli(final String str, final boolean z) {
        eli("img_error_param", false, new DbA() { // from class: com.bytedance.sdk.openadsdk.Dfc.Os.16
            @Override // com.bytedance.sdk.openadsdk.Dfc.DbA
            public com.bytedance.sdk.openadsdk.Dfc.eli.Os getLogStats() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("is_new", z ? 1 : 0);
                    jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, str);
                } catch (Throwable unused) {
                }
                return aGH.DbA().eli("img_error_param").DbA(jSONObject.toString());
            }
        });
    }
}
