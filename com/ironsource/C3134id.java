package com.ironsource;

import android.text.TextUtils;
import java.util.ArrayList;

/* renamed from: com.ironsource.id, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public class C3134id {

    /* renamed from: a, reason: collision with root package name */
    private final ArrayList<String> f3362a = new ArrayList<>();
    private final ArrayList<String> b = new ArrayList<>();
    private final ArrayList<String> c = new ArrayList<>();
    private final ArrayList<String> d = new ArrayList<>();

    public ArrayList<String> a() {
        return this.c;
    }

    public ArrayList<String> b() {
        return this.b;
    }

    public ArrayList<String> c() {
        return this.d;
    }

    public ArrayList<String> d() {
        return this.f3362a;
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.c.add(str);
    }

    public void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.b.add(str);
    }

    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.d.add(str);
    }

    public void d(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f3362a.add(str);
    }
}
