package com.ironsource;

import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class Zf {
    private int b = 4;
    private int c = 4;

    /* renamed from: a, reason: collision with root package name */
    private HashMap<String, Boolean> f3168a = new a();

    class a extends HashMap<String, Boolean> {
        a() {
            put(C3061e8.k, Boolean.valueOf(Zf.this.b == 0));
            put(C3061e8.l, Boolean.valueOf(Zf.this.c == 0));
            Boolean bool = Boolean.FALSE;
            put(C3061e8.m, bool);
            put(C3061e8.n, bool);
        }
    }

    Zf() {
    }

    void a(String str, int i, boolean z) {
        if (this.f3168a.containsKey(str)) {
            this.f3168a.put(str, Boolean.valueOf(i == 0));
        }
        this.f3168a.put(C3061e8.m, Boolean.valueOf(z));
        this.f3168a.put(C3061e8.n, Boolean.valueOf((this.f3168a.get(C3061e8.l).booleanValue() || this.f3168a.get(C3061e8.k).booleanValue()) && this.f3168a.get(C3061e8.m).booleanValue()));
    }

    public JSONObject a() {
        return new JSONObject(this.f3168a);
    }
}
