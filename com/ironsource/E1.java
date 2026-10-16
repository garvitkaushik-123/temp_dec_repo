package com.ironsource;

import android.text.TextUtils;
import java.util.HashSet;

/* loaded from: classes6.dex */
public class E1 {
    private String c;
    private String d;
    private int f;
    private HashSet<String> b = new HashSet<>();

    /* renamed from: a, reason: collision with root package name */
    private boolean f2836a = false;
    private boolean e = false;
    private boolean g = true;

    public void a(boolean z) {
        this.f2836a = z;
    }

    public HashSet<String> b() {
        return this.b;
    }

    public void c(String str) {
        this.c = str;
    }

    public String d() {
        return this.c;
    }

    public boolean e() {
        return this.e;
    }

    public boolean f() {
        return this.f2836a;
    }

    public boolean g() {
        return this.g;
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.b.add(str);
    }

    public void b(String str) {
        this.d = str;
    }

    public String c() {
        return this.d;
    }

    public void b(boolean z) {
        this.g = z;
    }

    public void c(boolean z) {
        this.e = z;
    }

    public int a() {
        return this.f;
    }

    public void a(int i) {
        this.f = i;
    }
}
