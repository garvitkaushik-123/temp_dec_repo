package com.mbridge.msdk.dycreator.error;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: DyError.java */
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private int f4170a;
    private String b;

    public a(b bVar) {
        if (bVar != null) {
            this.f4170a = bVar.a();
            this.b = bVar.b();
        }
    }

    public String toString() {
        return "DyError{errorCode=" + this.f4170a + AbstractJsonLexerKt.END_OBJ;
    }

    public a(int i, String str) {
        this.f4170a = i;
        this.b = str;
    }
}
