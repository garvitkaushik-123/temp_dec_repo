package com.mbridge.msdk.click.entity;

/* compiled from: ClickResponseHeader.java */
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public String f4039a;
    public String b;
    public String c;
    public String d;
    public int e;
    public int f;
    public String g;
    public String h;

    public String a() {
        return "statusCode=" + this.f + ", location=" + this.f4039a + ", contentType=" + this.b + ", contentLength=" + this.e + ", contentEncoding=" + this.c + ", referer=" + this.d;
    }

    public String toString() {
        return "ClickResponseHeader{location='" + this.f4039a + "', contentType='" + this.b + "', contentEncoding='" + this.c + "', referer='" + this.d + "', contentLength=" + this.e + ", statusCode=" + this.f + ", url='" + this.g + "', exception='" + this.h + "'}";
    }
}
