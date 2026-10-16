package com.mbridge.msdk.foundation.same.net.exception;

/* compiled from: CommonError.java */
/* loaded from: classes6.dex */
public class a extends Exception {

    /* renamed from: a, reason: collision with root package name */
    public int f4288a;
    public String b;
    public com.mbridge.msdk.foundation.same.net.toolbox.a c;

    public a(int i, com.mbridge.msdk.foundation.same.net.toolbox.a aVar) {
        this.f4288a = i;
        this.c = aVar;
    }

    public a(int i, com.mbridge.msdk.foundation.same.net.toolbox.a aVar, String str) {
        this.f4288a = i;
        this.c = aVar;
        this.b = str;
    }
}
