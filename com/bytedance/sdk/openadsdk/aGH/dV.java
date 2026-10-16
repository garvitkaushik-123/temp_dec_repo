package com.bytedance.sdk.openadsdk.aGH;

/* loaded from: classes3.dex */
public class dV extends aGH {
    public static String Os() {
        return "CREATE TABLE IF NOT EXISTS adevent_applog (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,value TEXT ,gen_time TEXT , retry INTEGER default 0 , encrypt INTEGER default 0, channel INTEGER default 0)";
    }
}
