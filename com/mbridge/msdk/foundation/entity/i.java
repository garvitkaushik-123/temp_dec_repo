package com.mbridge.msdk.foundation.entity;

import java.io.Serializable;

/* compiled from: LoopEntity.java */
/* loaded from: classes6.dex */
public class i implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    private int f4244a;
    private String b;
    private String c;

    public i(String str, String str2, int i) {
        this.b = str;
        this.c = str2;
        this.f4244a = i;
    }

    public String a() {
        return this.b;
    }

    public String b() {
        return this.c;
    }
}
