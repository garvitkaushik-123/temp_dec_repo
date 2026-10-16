package com.bytedance.sdk.openadsdk.core;

import android.os.Build;
import com.bytedance.sdk.component.embedapplog.PangleEncryptConstant;
import com.ironsource.N6;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class gG {
    private static final AtomicInteger DbA;
    private static final AtomicInteger Os;
    private static final AtomicInteger aGH;
    private static final AtomicInteger eli;

    static {
        AtomicInteger atomicInteger = new AtomicInteger();
        eli = atomicInteger;
        AtomicInteger atomicInteger2 = new AtomicInteger();
        DbA = atomicInteger2;
        AtomicInteger atomicInteger3 = new AtomicInteger();
        Os = atomicInteger3;
        AtomicInteger atomicInteger4 = new AtomicInteger();
        aGH = atomicInteger4;
        atomicInteger.addAndGet(com.bytedance.sdk.openadsdk.multipro.aGH.aGH.eli("encrypt_statistics_file", "encrypt_success_count", 0));
        atomicInteger2.addAndGet(com.bytedance.sdk.openadsdk.multipro.aGH.aGH.eli("encrypt_statistics_file", "encrypt_fail_count", 0));
        atomicInteger3.addAndGet(com.bytedance.sdk.openadsdk.multipro.aGH.aGH.eli("encrypt_statistics_file", "decrypt_success_count", 0));
        atomicInteger4.addAndGet(com.bytedance.sdk.openadsdk.multipro.aGH.aGH.eli("encrypt_statistics_file", "decrypt_fail_count", 0));
    }

    public static void eli() {
        try {
            long eli2 = com.bytedance.sdk.openadsdk.multipro.aGH.aGH.eli("encrypt_statistics_file", "upload_time_key", 0L);
            if (eli2 <= 0 || System.currentTimeMillis() - eli2 < 86400000) {
                if (eli2 <= 0 || eli2 > System.currentTimeMillis()) {
                    com.bytedance.sdk.openadsdk.multipro.aGH.aGH.eli("encrypt_statistics_file", "upload_time_key", Long.valueOf(System.currentTimeMillis()));
                    return;
                }
                return;
            }
            DbA();
            synchronized (gG.class) {
                eli.set(0);
                DbA.set(0);
                Os.set(0);
                aGH.set(0);
                com.bytedance.sdk.openadsdk.multipro.aGH.aGH.eli("encrypt_statistics_file");
                com.bytedance.sdk.openadsdk.multipro.aGH.aGH.eli("encrypt_statistics_file", "upload_time_key", Long.valueOf(System.currentTimeMillis()));
            }
        } catch (Throwable unused) {
        }
    }

    private static void DbA() {
        final int i = eli.get();
        final int i2 = DbA.get();
        final int i3 = Os.get();
        final int i4 = aGH.get();
        com.bytedance.sdk.openadsdk.Dfc.Os.eli("crypt_v4_statistics", false, new com.bytedance.sdk.openadsdk.Dfc.DbA() { // from class: com.bytedance.sdk.openadsdk.core.gG.1
            @Override // com.bytedance.sdk.openadsdk.Dfc.DbA
            public com.bytedance.sdk.openadsdk.Dfc.eli.Os getLogStats() throws Exception {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("encrypt_success_count", i);
                    jSONObject.put("encrypt_fail_count", i2);
                    jSONObject.put("decrypt_success_count", i3);
                    jSONObject.put("decrypt_fail_count", i4);
                } catch (Throwable unused) {
                }
                return com.bytedance.sdk.openadsdk.Dfc.eli.aGH.DbA().eli("crypt_v4_statistics").DbA(jSONObject.toString());
            }
        });
    }

    public static void eli(final int i, final PangleEncryptConstant.CryptDataScene cryptDataScene, final int i2) {
        com.bytedance.sdk.openadsdk.Dfc.Os.eli("crypt_v4_fail", false, new com.bytedance.sdk.openadsdk.Dfc.DbA() { // from class: com.bytedance.sdk.openadsdk.core.gG.2
            @Override // com.bytedance.sdk.openadsdk.Dfc.DbA
            public com.bytedance.sdk.openadsdk.Dfc.eli.Os getLogStats() throws Exception {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("crypt", i);
                    jSONObject.put("scene", cryptDataScene.value());
                    jSONObject.put("reason", i2);
                    if (i2 == 6) {
                        jSONObject.put(N6.B, Build.MODEL);
                        jSONObject.put(VastAttributes.VENDOR, Build.MANUFACTURER);
                    }
                } catch (Throwable unused) {
                }
                return com.bytedance.sdk.openadsdk.Dfc.eli.aGH.DbA().eli("crypt_v4_fail").DbA(jSONObject.toString());
            }
        });
    }

    public static synchronized void eli(boolean z) {
        synchronized (gG.class) {
            if (z) {
                com.bytedance.sdk.openadsdk.multipro.aGH.aGH.eli("encrypt_statistics_file", "decrypt_success_count", Integer.valueOf(Os.incrementAndGet()));
            } else {
                com.bytedance.sdk.openadsdk.multipro.aGH.aGH.eli("encrypt_statistics_file", "decrypt_fail_count", Integer.valueOf(Os.incrementAndGet()));
            }
        }
    }

    public static void eli(JSONObject jSONObject) {
        DbA(jSONObject != null && jSONObject.optInt("cypher") == 4);
    }

    public static synchronized void DbA(boolean z) {
        synchronized (gG.class) {
            if (z) {
                com.bytedance.sdk.openadsdk.multipro.aGH.aGH.eli("encrypt_statistics_file", "encrypt_success_count", Integer.valueOf(eli.incrementAndGet()));
            } else {
                com.bytedance.sdk.openadsdk.multipro.aGH.aGH.eli("encrypt_statistics_file", "encrypt_fail_count", Integer.valueOf(DbA.incrementAndGet()));
            }
        }
    }
}
