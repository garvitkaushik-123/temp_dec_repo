package com.bytedance.sdk.openadsdk.aGH.eli;

/* loaded from: classes3.dex */
public class eli {
    public static final DbA eli = new DbA(0);
    public static final DbA DbA = new DbA(1);
    public static final DbA Os = new DbA(2);
    public static final DbA aGH = new DbA(0);
    public static final DbA ui = new DbA(1);
    public static final DbA MGA = new DbA(2);

    public static void eli(DbA dbA, boolean z, int i, long j) {
        try {
            dbA.kb.getAndSet(true);
            if (z) {
                dbA.eli.incrementAndGet();
                dbA.Os.addAndGet(j);
                return;
            }
            dbA.DbA.incrementAndGet();
            Integer num = dbA.MGA.get(Integer.valueOf(i));
            if (num != null) {
                dbA.MGA.put(Integer.valueOf(i), Integer.valueOf(num.intValue() + 1));
            } else {
                dbA.MGA.put(Integer.valueOf(i), 1);
            }
        } catch (Throwable unused) {
        }
    }

    public static void eli(DbA dbA, boolean z) {
        try {
            dbA.kb.getAndSet(true);
            if (z) {
                dbA.eli.incrementAndGet();
            } else {
                dbA.DbA.incrementAndGet();
            }
        } catch (Throwable unused) {
        }
    }

    public static void eli(DbA dbA) {
        try {
            dbA.kb.getAndSet(true);
            dbA.ui.incrementAndGet();
        } catch (Throwable unused) {
        }
    }

    public static void eli() {
        try {
            DbA dbA = eli;
            if (dbA.kb.get()) {
                com.bytedance.sdk.openadsdk.multipro.aGH.eli.eli("tt_sdk_event_net_ad", "tt_sdk_event_net_ad", dbA.eli().toString());
            }
            DbA dbA2 = DbA;
            if (dbA2.kb.get()) {
                com.bytedance.sdk.openadsdk.multipro.aGH.eli.eli("tt_sdk_event_net_state", "tt_sdk_event_net_state", dbA2.eli().toString());
            }
            DbA dbA3 = Os;
            if (dbA3.kb.get()) {
                com.bytedance.sdk.openadsdk.multipro.aGH.eli.eli("tt_sdk_event_net_trail", "tt_sdk_event_net_trail", dbA3.eli().toString());
            }
            DbA dbA4 = aGH;
            if (dbA4.kb.get()) {
                com.bytedance.sdk.openadsdk.multipro.aGH.eli.eli("tt_sdk_event_db_ad", "tt_sdk_event_db_ad", dbA4.DbA().toString());
            }
            DbA dbA5 = ui;
            if (dbA5.kb.get()) {
                com.bytedance.sdk.openadsdk.multipro.aGH.eli.eli("tt_sdk_event_db_state", "tt_sdk_event_db_state", dbA5.DbA().toString());
            }
            DbA dbA6 = MGA;
            if (dbA6.kb.get()) {
                com.bytedance.sdk.openadsdk.multipro.aGH.eli.eli("tt_sdk_event_db_trail", "tt_sdk_event_db_trail", dbA6.DbA().toString());
            }
        } catch (Throwable unused) {
        }
    }

    public static void DbA() {
        try {
            com.bytedance.sdk.openadsdk.Dfc.Os.DbA("net_upload_monitor", com.bytedance.sdk.openadsdk.multipro.aGH.eli.DbA("tt_sdk_event_net_ad", "tt_sdk_event_net_ad", ""));
            com.bytedance.sdk.openadsdk.multipro.aGH.eli.eli("tt_sdk_event_net_ad");
            com.bytedance.sdk.openadsdk.Dfc.Os.DbA("net_upload_monitor", com.bytedance.sdk.openadsdk.multipro.aGH.eli.DbA("tt_sdk_event_net_state", "tt_sdk_event_net_state", ""));
            com.bytedance.sdk.openadsdk.multipro.aGH.eli.eli("tt_sdk_event_net_state");
            com.bytedance.sdk.openadsdk.Dfc.Os.DbA("net_upload_monitor", com.bytedance.sdk.openadsdk.multipro.aGH.eli.DbA("tt_sdk_event_net_trail", "tt_sdk_event_net_trail", ""));
            com.bytedance.sdk.openadsdk.multipro.aGH.eli.eli("tt_sdk_event_net_trail");
            com.bytedance.sdk.openadsdk.Dfc.Os.DbA("db_upload_monitor", com.bytedance.sdk.openadsdk.multipro.aGH.eli.DbA("tt_sdk_event_db_ad", "tt_sdk_event_db_ad", ""));
            com.bytedance.sdk.openadsdk.multipro.aGH.eli.eli("tt_sdk_event_db_ad");
            com.bytedance.sdk.openadsdk.Dfc.Os.DbA("db_upload_monitor", com.bytedance.sdk.openadsdk.multipro.aGH.eli.DbA("tt_sdk_event_db_state", "tt_sdk_event_db_state", ""));
            com.bytedance.sdk.openadsdk.multipro.aGH.eli.eli("tt_sdk_event_db_state");
            com.bytedance.sdk.openadsdk.Dfc.Os.DbA("db_upload_monitor", com.bytedance.sdk.openadsdk.multipro.aGH.eli.DbA("tt_sdk_event_db_trail", "tt_sdk_event_db_trail", ""));
            com.bytedance.sdk.openadsdk.multipro.aGH.eli.eli("tt_sdk_event_db_trail");
        } catch (Throwable unused) {
        }
    }
}
