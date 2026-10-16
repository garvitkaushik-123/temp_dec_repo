package com.mbridge.msdk.tracker;

import java.io.Serializable;

/* compiled from: EventTable.java */
/* loaded from: classes6.dex */
public class i implements Serializable {
    static String i = "CREATE TABLE IF NOT EXISTS %s (id INTEGER PRIMARY KEY,uuid TEXT,name TEXT,type INTEGER,time_stamp INTEGER,duration INTEGER,properties TEXT,priority INTEGER,state INTEGER,invalid_time INTEGER,ignore_max_timeout INTEGER,ignore_max_retry_times INTEGER,report_error_message TEXT,report_count INTEGER)";
    static String j = "DROP TABLE IF EXISTS %s";

    /* renamed from: a, reason: collision with root package name */
    private final e f4926a;
    private int b;
    private int c;
    private final String d;
    private long e;
    private boolean f = false;
    private boolean g = false;
    private String h;

    public i(e eVar) {
        this.f4926a = eVar;
        this.d = eVar.i();
    }

    public void a(boolean z) {
        this.g = z;
    }

    public void b(boolean z) {
        this.f = z;
    }

    public int c() {
        return this.b;
    }

    public String d() {
        return this.h;
    }

    public int e() {
        return this.c;
    }

    public String f() {
        return this.d;
    }

    public boolean g() {
        return this.g;
    }

    public boolean h() {
        return this.f;
    }

    public e a() {
        return this.f4926a;
    }

    public void b(int i2) {
        this.c = i2;
    }

    public void a(int i2) {
        this.b = i2;
    }

    public long b() {
        return this.e;
    }

    public void a(long j2) {
        this.e = j2;
    }

    public void a(String str) {
        this.h = str;
    }
}
