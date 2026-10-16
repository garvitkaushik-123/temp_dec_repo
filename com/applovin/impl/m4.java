package com.applovin.impl;

import android.content.Context;

/* loaded from: classes2.dex */
public class m4 {

    /* renamed from: a, reason: collision with root package name */
    private final String f546a;
    private final String b;
    private final boolean c;

    m4(String str, String str2, Context context) {
        this.f546a = str.replace("android.permission.", "");
        this.b = str2;
        this.c = o0.a(str, context);
    }

    public String a() {
        return this.b;
    }

    public String b() {
        return this.f546a;
    }

    public boolean c() {
        return this.c;
    }
}
