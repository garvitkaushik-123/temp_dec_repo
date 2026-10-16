package com.bytedance.sdk.openadsdk.core.du.Os;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.kb;
import com.bytedance.sdk.component.wC.wC;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.core.dV;
import com.bytedance.sdk.openadsdk.core.du.eli.DbA;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.core.model.ui;
import com.google.firebase.messaging.Constants;
import com.ironsource.unity.androidbridge.AndroidBridgeConstants;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class aGH {
    public static final List<String> eli = Arrays.asList("video/mp4", "video/3gpp");
    private static final ConcurrentHashMap<String, Boolean> DbA = new ConcurrentHashMap<>();

    public static double eli(int i, double d, int i2, int i3, int i4, String str) {
        double eli2 = eli(i, d, i2, i3);
        return DbA(str) * (1.0d / ((eli2 + 1.0d) + eli(i4)));
    }

    private static double eli(int i, double d, int i2, int i3) {
        return (d > 0.0d ? Math.abs(d - (i3 > 0 ? i2 / i3 : 0.0d)) : 0.0d) + (i > 0 ? Math.abs((i - i2) / i) : 0.0d);
    }

    private static double eli(int i) {
        int max = Math.max(i, 0);
        if (700 > max || max > 1500) {
            return Math.min(Math.abs(700 - max) / 700.0f, Math.abs(1500 - max) / 1500.0f);
        }
        return 0.0d;
    }

    private static double DbA(String str) {
        if (str == null) {
            str = "";
        }
        int hashCode = str.hashCode();
        if (hashCode != -1664118616) {
            return (hashCode == 1331848029 && str.equals("video/mp4")) ? 1.5d : 1.0d;
        }
        str.equals("video/3gpp");
        return 1.0d;
    }

    public static void eli(ev evVar) {
        ui XJc;
        ArrayList<ui.eli> eli2;
        ev evVar2;
        if (evVar == null || !ui.eli(evVar) || (XJc = evVar.XJc()) == null || (eli2 = XJc.eli()) == null || eli2.isEmpty()) {
            return;
        }
        Iterator<ui.eli> it = eli2.iterator();
        while (it.hasNext()) {
            ui.eli next = it.next();
            String aGH = next.aGH();
            if (TextUtils.isEmpty(aGH)) {
                evVar2 = evVar;
            } else {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                com.bytedance.sdk.openadsdk.core.du.eli.eli.ui uiVar = new com.bytedance.sdk.openadsdk.core.du.eli.eli.ui(dV.eli(), 0, 0);
                com.bytedance.sdk.openadsdk.core.du.eli eli3 = uiVar.eli(aGH, (File) null, new ArrayList());
                if (eli3 != null) {
                    next.eli(eli3.eli());
                    next.eli(eli3.NU());
                }
                evVar2 = evVar;
                eli(evVar2, "vast_content", eli3, elapsedRealtime, uiVar.MGA);
            }
            eli(evVar2, next);
            evVar = evVar2;
        }
    }

    public static void eli(com.bytedance.sdk.openadsdk.core.model.eli eliVar) {
        List<ev> aGH = eliVar.aGH();
        if (aGH != null) {
            Iterator<ev> it = aGH.iterator();
            while (it.hasNext()) {
                eli(it.next());
            }
        }
    }

    private static void eli(final ev evVar, final ui.eli eliVar) {
        File eli2;
        String Os = eliVar.Os();
        if (TextUtils.isEmpty(Os)) {
            return;
        }
        final String str = Os + evVar.fO();
        ConcurrentHashMap<String, Boolean> concurrentHashMap = DbA;
        if (concurrentHashMap.containsKey(str) || (eli2 = eli(str)) == null) {
            return;
        }
        if (eli2.exists() && eli2.length() > 0) {
            DbA(evVar, eli2, eliVar, 0L);
            return;
        }
        concurrentHashMap.put(str, Boolean.TRUE);
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        com.bytedance.sdk.component.kb.DbA.eli aGH = com.bytedance.sdk.openadsdk.nGm.DbA.DbA().Os().aGH();
        aGH.DbA(Os);
        aGH.eli(eli2.getParent(), eli2.getName());
        aGH.Os(Os);
        aGH.eli(new com.bytedance.sdk.component.kb.eli.eli() { // from class: com.bytedance.sdk.openadsdk.core.du.Os.aGH.1
            @Override // com.bytedance.sdk.component.kb.eli.eli
            public void eli(com.bytedance.sdk.component.kb.DbA.Os os, com.bytedance.sdk.component.kb.DbA dbA) {
                if (!dbA.MGA() || dbA.ui() == null || !dbA.ui().exists()) {
                    aGH.DbA(evVar, ui.eli.this.Os(), false, SystemClock.elapsedRealtime() - elapsedRealtime);
                } else {
                    aGH.DbA(evVar, dbA.ui(), ui.eli.this, SystemClock.elapsedRealtime() - elapsedRealtime);
                }
                aGH.DbA.remove(str);
            }

            @Override // com.bytedance.sdk.component.kb.eli.eli
            public void eli(com.bytedance.sdk.component.kb.DbA.Os os, IOException iOException) {
                aGH.DbA(evVar, ui.eli.this.Os(), false, SystemClock.elapsedRealtime() - elapsedRealtime);
                aGH.DbA.remove(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void DbA(ev evVar, File file, ui.eli eliVar, long j) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        com.bytedance.sdk.openadsdk.core.du.eli.eli.ui uiVar = new com.bytedance.sdk.openadsdk.core.du.eli.eli.ui(dV.eli(), 0, 0);
        com.bytedance.sdk.openadsdk.core.du.eli eli2 = uiVar.eli((String) null, file, new ArrayList());
        if (eli2 != null) {
            eliVar.eli(eli2.eli());
            eliVar.eli(eli2.NU());
        }
        DbA(evVar, eliVar.Os(), true, j);
        eli(evVar, "vast_url", eli2, elapsedRealtime, uiVar.MGA);
        DbA();
    }

    private static void DbA() {
        File[] listFiles;
        File eli2 = eli(dV.eli(), com.bytedance.sdk.openadsdk.multipro.DbA.Os());
        if (eli2 == null || (listFiles = eli2.listFiles()) == null || listFiles.length <= 5) {
            return;
        }
        Arrays.sort(listFiles, new Comparator<File>() { // from class: com.bytedance.sdk.openadsdk.core.du.Os.aGH.2
            @Override // java.util.Comparator
            /* renamed from: eli, reason: merged with bridge method [inline-methods] */
            public int compare(File file, File file2) {
                if (file.lastModified() < file2.lastModified()) {
                    return -1;
                }
                return file.lastModified() > file2.lastModified() ? 1 : 0;
            }
        });
        int length = listFiles.length - 5;
        for (int i = 0; i < listFiles.length && i < length; i++) {
            File file = listFiles[i];
            if (file.exists()) {
                file.delete();
            }
        }
    }

    public static File eli(String str) {
        String eli2 = com.bytedance.sdk.component.utils.ui.eli(str);
        if (eli2 == null) {
            return null;
        }
        return kb.eli(dV.eli(), com.bytedance.sdk.openadsdk.multipro.DbA.Os(), new File(CacheDirFactory.getRootDir()).getName() + "/vast/", eli2);
    }

    private static File eli(Context context, boolean z) {
        return kb.eli(context, z, new File(CacheDirFactory.getRootDir()).getName() + "/vast/");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void DbA(ev evVar, final String str, final boolean z, final long j) {
        com.bytedance.sdk.openadsdk.aGH.Os.eli(System.currentTimeMillis(), evVar, evVar.aGH(), "track_url_request_result", new com.bytedance.sdk.openadsdk.Dfc.Os.eli() { // from class: com.bytedance.sdk.openadsdk.core.du.Os.aGH.3
            @Override // com.bytedance.sdk.openadsdk.Dfc.Os.eli
            public JSONObject eli() {
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("url", str);
                    jSONObject2.put("duration", j);
                    jSONObject2.put("success", z);
                    jSONObject.put("ad_extra_data", jSONObject2);
                } catch (Exception unused) {
                }
                return jSONObject;
            }
        });
    }

    public static void eli(final ev evVar, final String str, final com.bytedance.sdk.openadsdk.core.du.eli eliVar, final long j, final DbA.eli eliVar2) {
        com.bytedance.sdk.openadsdk.aGH.Os.eli(new wC("vast_parser1") { // from class: com.bytedance.sdk.openadsdk.core.du.Os.aGH.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("duration", SystemClock.elapsedRealtime() - j);
                    jSONObject.put(Constants.MessagePayloadKeys.FROM, str);
                    if (eliVar != null) {
                        ev evVar2 = evVar;
                        com.bytedance.sdk.openadsdk.aGH.Os.DbA(evVar2, evVar2.aGH(), "track_load_vast_success", jSONObject);
                        return;
                    }
                    DbA.eli eliVar3 = eliVar2;
                    if (eliVar3 != null) {
                        jSONObject.put(AndroidBridgeConstants.ERROR_CODE, eliVar3.eli);
                    }
                    ev evVar3 = evVar;
                    com.bytedance.sdk.openadsdk.aGH.Os.DbA(evVar3, evVar3.aGH(), "track_load_vast_fail", jSONObject);
                } catch (Exception unused) {
                }
            }
        });
    }

    public static void DbA(final ev evVar, final String str, final com.bytedance.sdk.openadsdk.core.du.eli eliVar, final long j, final DbA.eli eliVar2) {
        com.bytedance.sdk.openadsdk.aGH.Os.eli(new wC("vast_parser2") { // from class: com.bytedance.sdk.openadsdk.core.du.Os.aGH.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("duration", SystemClock.elapsedRealtime() - j);
                    com.bytedance.sdk.openadsdk.core.du.eli eliVar3 = eliVar;
                    String str2 = "load_vast_fail";
                    if (eliVar3 != null) {
                        if (!TextUtils.isEmpty(eliVar3.FC()) && !TextUtils.isEmpty(eliVar.MGA()) && eliVar.wC() > 0.0d) {
                            str2 = "load_vast_success";
                        }
                        jSONObject.put(AndroidBridgeConstants.ERROR_CODE, -3);
                    } else {
                        DbA.eli eliVar4 = eliVar2;
                        if (eliVar4 != null) {
                            jSONObject.put(AndroidBridgeConstants.ERROR_CODE, eliVar4.eli);
                        }
                    }
                    com.bytedance.sdk.openadsdk.aGH.Os.DbA(evVar, str, str2, jSONObject);
                    com.bytedance.sdk.openadsdk.core.du.eli eliVar5 = eliVar;
                    if (eliVar5 == null || eliVar5.DbA() == null || !TextUtils.isEmpty(eliVar.DbA().MGA())) {
                        return;
                    }
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put(AndroidBridgeConstants.ERROR_CODE, 1000);
                        jSONObject2.put("description", "1000:Image url is null");
                    } catch (Throwable unused) {
                    }
                    com.bytedance.sdk.openadsdk.aGH.Os.DbA(evVar, str, "load_vast_icon_fail", jSONObject2);
                    eliVar.eli((com.bytedance.sdk.openadsdk.core.du.DbA) null);
                } catch (Exception unused2) {
                }
            }
        });
    }
}
