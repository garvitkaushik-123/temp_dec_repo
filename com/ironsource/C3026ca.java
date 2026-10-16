package com.ironsource;

import org.json.JSONObject;

/* renamed from: com.ironsource.ca, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public class C3026ca {

    /* renamed from: a, reason: collision with root package name */
    private InterfaceC2992aa f3227a;

    public C3026ca(InterfaceC2992aa interfaceC2992aa) {
        this.f3227a = interfaceC2992aa;
    }

    public void a(C3009ba c3009ba, JSONObject jSONObject) {
        this.f3227a.a(false, c3009ba.a(), jSONObject);
    }

    public void b(C3009ba c3009ba, JSONObject jSONObject) {
        this.f3227a.a(true, c3009ba.d(), jSONObject);
    }
}
