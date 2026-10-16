package com.bytedance.sdk.openadsdk.aGH;

/* loaded from: classes3.dex */
public class Dfc {
    public static String eli() {
        return "CREATE TABLE IF NOT EXISTS logstats (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,value TEXT ,gen_time TEXT , encrypt INTEGER default 0 , retry INTEGER default 0)";
    }

    public static String DbA() {
        return "ALTER TABLE logstats ADD COLUMN encrypt INTEGER default 0";
    }
}
