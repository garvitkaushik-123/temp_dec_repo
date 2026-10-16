package com.bytedance.sdk.openadsdk.utils;

import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.google.common.net.HttpHeaders;
import com.ironsource.C3040d4;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class bf {
    public static int DbA = Integer.MIN_VALUE;
    public static final String[] Os = {"api16-access-ttp.tiktokpangle.us", "api16-access-ttp-b.tiktokpangle.us", "api16-access-ttp.tiktokpangle-b.us", "api16-access-ttp-b.tiktokpangle-b.us"};
    public static int eli = Integer.MIN_VALUE;

    public static String eli() {
        if (eli == Integer.MIN_VALUE) {
            eli = com.bytedance.sdk.openadsdk.core.FC.ui();
        }
        if (eli < 0) {
            eli = 0;
        }
        String[] strArr = Os;
        try {
            return strArr[eli % strArr.length];
        } catch (Throwable unused) {
            return strArr[0];
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0016, code lost:
    
        r2 = com.bytedance.sdk.openadsdk.utils.bf.eli + 1;
        com.bytedance.sdk.openadsdk.utils.bf.eli = r2;
        com.bytedance.sdk.openadsdk.core.FC.eli(r2);
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x003d A[Catch: all -> 0x0073, TryCatch #0 {, blocks: (B:16:0x0027, B:18:0x002f, B:22:0x0037, B:24:0x003d, B:25:0x0043, B:27:0x004c, B:28:0x006c, B:36:0x0024, B:9:0x0009, B:11:0x000e, B:15:0x0016), top: B:8:0x0009, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004c A[Catch: all -> 0x0073, TryCatch #0 {, blocks: (B:16:0x0027, B:18:0x002f, B:22:0x0037, B:24:0x003d, B:25:0x0043, B:27:0x004c, B:28:0x006c, B:36:0x0024, B:9:0x0009, B:11:0x000e, B:15:0x0016), top: B:8:0x0009, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized void eli(String str) {
        int i;
        synchronized (bf.class) {
            if (str == null) {
                return;
            }
            int i2 = 0;
            while (true) {
                try {
                    String[] strArr = Os;
                    if (i2 >= strArr.length) {
                        break;
                    } else if (str.contains(strArr[i2])) {
                        break;
                    } else {
                        i2++;
                    }
                } finally {
                    if (!str.contains("/api/ad/union/sdk/settings/")) {
                    }
                    if (DbA == Integer.MIN_VALUE) {
                    }
                    i = DbA + 1;
                    DbA = i;
                    if (i >= 3) {
                    }
                    com.bytedance.sdk.openadsdk.core.FC.DbA(DbA);
                }
            }
            if (!str.contains("/api/ad/union/sdk/settings/") || str.contains("/api/ad/union/sdk/strategies/adn")) {
                if (DbA == Integer.MIN_VALUE) {
                    DbA = com.bytedance.sdk.openadsdk.core.FC.MGA();
                }
                i = DbA + 1;
                DbA = i;
                if (i >= 3) {
                    final String VM = com.bytedance.sdk.openadsdk.core.settings.NU.nY().VM();
                    final int i3 = DbA;
                    com.bytedance.sdk.openadsdk.core.settings.NU.nY().RY();
                    DbA = 0;
                    com.bytedance.sdk.openadsdk.Dfc.Os.eli();
                    com.bytedance.sdk.openadsdk.Dfc.Os.eli("clear_domain", false, new com.bytedance.sdk.openadsdk.Dfc.DbA() { // from class: com.bytedance.sdk.openadsdk.utils.bf.1
                        @Override // com.bytedance.sdk.openadsdk.Dfc.DbA
                        public com.bytedance.sdk.openadsdk.Dfc.eli.Os getLogStats() throws Exception {
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put(C3040d4.i.D, VM);
                                jSONObject.put("times", i3);
                            } catch (Exception unused) {
                            }
                            return com.bytedance.sdk.openadsdk.Dfc.eli.aGH.DbA().eli("clear_domain").DbA(jSONObject.toString());
                        }
                    });
                }
                com.bytedance.sdk.openadsdk.core.FC.DbA(DbA);
            }
        }
    }

    public static synchronized void DbA() {
        synchronized (bf.class) {
            if (DbA == 0) {
                return;
            }
            DbA = 0;
            com.bytedance.sdk.openadsdk.core.FC.DbA(0);
        }
    }

    public static void eli(com.bytedance.sdk.component.FC.MGA mga, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(HttpHeaders.REFERER, TTAdConstant.REQUEST_HEAD_REFERER);
        mga.eli(str, hashMap);
    }
}
