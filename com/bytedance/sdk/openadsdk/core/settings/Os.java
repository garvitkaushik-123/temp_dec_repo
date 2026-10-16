package com.bytedance.sdk.openadsdk.core.settings;

import android.text.TextUtils;
import android.util.Log;
import com.bytedance.sdk.openadsdk.core.dV;
import com.bytedance.sdk.openadsdk.utils.nro;
import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Os {
    private static final ConcurrentHashMap<String, DbA> eli = new ConcurrentHashMap<>();

    public static void eli(boolean z) {
        String eli2;
        File DbA = DbA();
        try {
            if (!DbA.exists()) {
                if (com.bytedance.sdk.openadsdk.multipro.DbA.Os()) {
                    eli2 = com.bytedance.sdk.openadsdk.multipro.aGH.eli.DbA("tt_sdk_settings", "ad_slot_conf", null);
                } else {
                    eli2 = nro.eli("tt_sdk_settings", dV.eli()).eli("ad_slot_conf", (String) null);
                }
                if (TextUtils.isEmpty(eli2)) {
                    return;
                }
                HashMap<String, DbA> DbA2 = DbA(new JSONArray(eli2));
                if (DbA2.isEmpty()) {
                    return;
                }
                ConcurrentHashMap<String, DbA> concurrentHashMap = eli;
                concurrentHashMap.clear();
                concurrentHashMap.putAll(DbA2);
                return;
            }
            HashMap<String, DbA> DbA3 = DbA(new JSONArray(new String(com.bytedance.sdk.component.utils.kb.aGH(DbA))));
            if (DbA3.isEmpty()) {
                return;
            }
            for (Map.Entry<String, DbA> entry : DbA3.entrySet()) {
                eli.put(entry.getKey(), entry.getValue());
            }
        } catch (Exception unused) {
        }
    }

    private static HashMap<String, DbA> DbA(JSONArray jSONArray) {
        HashMap<String, DbA> hashMap = new HashMap<>();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                DbA eli2 = eli(jSONArray.getJSONObject(i));
                if (eli2 != null) {
                    hashMap.put(eli2.eli, eli2);
                }
            } catch (Exception unused) {
            }
        }
        return hashMap;
    }

    private static File DbA() {
        return new File(dV.eli().getFilesDir(), "tt_ads_conf_sr");
    }

    private static DbA eli(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return new DbA(jSONObject);
    }

    public static DbA eli(String str) {
        DbA dbA = eli.get(str);
        return dbA == null ? DbA(str) : dbA;
    }

    private static DbA DbA(String str) {
        return new DbA(str, 1);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00a9 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void eli(JSONArray jSONArray) {
        HashMap<String, DbA> DbA;
        FileWriter fileWriter;
        if (jSONArray == null) {
            return;
        }
        File DbA2 = DbA();
        File file = new File(DbA2.getParent(), DbA2.getName() + ".tmp");
        FileWriter fileWriter2 = null;
        try {
            try {
                if (file.exists()) {
                    file.delete();
                }
                fileWriter = new FileWriter(file);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e) {
            e = e;
        }
        try {
            fileWriter.write(jSONArray.toString());
            file.renameTo(DbA2);
            nro.eli("tt_sdk_settings", dV.eli()).eli("ad_slot_conf");
            if (file.exists()) {
                file.delete();
            }
            com.bytedance.sdk.openadsdk.utils.NU.eli(fileWriter);
        } catch (Exception e2) {
            e = e2;
            fileWriter2 = fileWriter;
            Log.e("SdkSettings.AdSlot", "saveAdSlotToLocal: ", e);
            if (file.exists()) {
                file.delete();
            }
            com.bytedance.sdk.openadsdk.utils.NU.eli(fileWriter2);
            DbA = DbA(jSONArray);
            if (DbA.isEmpty()) {
            }
        } catch (Throwable th2) {
            th = th2;
            fileWriter2 = fileWriter;
            if (file.exists()) {
                file.delete();
            }
            com.bytedance.sdk.openadsdk.utils.NU.eli(fileWriter2);
            throw th;
        }
        DbA = DbA(jSONArray);
        if (DbA.isEmpty()) {
            for (Map.Entry<String, DbA> entry : DbA.entrySet()) {
                eli.put(entry.getKey(), entry.getValue());
            }
        }
    }

    public static void eli() {
        File DbA = DbA();
        if (DbA.exists()) {
            DbA.delete();
        }
    }
}
