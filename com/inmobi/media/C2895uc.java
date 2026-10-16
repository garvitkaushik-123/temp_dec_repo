package com.inmobi.media;

import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.uc, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2895uc {

    /* renamed from: a, reason: collision with root package name */
    public final String f2723a;
    public final EnumC2846rc b;
    public final HashMap c;
    public final HashMap d;
    public final String e;
    public final EnumC2862sc f;
    public final boolean g;
    public final C2879tc h;
    public final int i;
    public final int j;
    public final boolean k;
    public M9 l;
    public int m;

    public C2895uc(C2831qc c2831qc) {
        Intrinsics.checkNotNullExpressionValue("uc", "getSimpleName(...)");
        this.f2723a = c2831qc.f2685a;
        this.b = c2831qc.b;
        this.c = c2831qc.c;
        this.d = c2831qc.d;
        String str = c2831qc.e;
        this.e = str == null ? "" : str;
        this.f = EnumC2862sc.f2704a;
        Boolean bool = c2831qc.f;
        this.g = bool != null ? bool.booleanValue() : true;
        this.h = c2831qc.g;
        Integer num = c2831qc.h;
        this.i = num != null ? num.intValue() : 60000;
        Integer num2 = c2831qc.i;
        this.j = num2 != null ? num2.intValue() : 60000;
        Boolean bool2 = c2831qc.j;
        this.k = bool2 != null ? bool2.booleanValue() : false;
    }

    public final String toString() {
        return "URL:" + J9.a(this.f2723a, this.d) + " | TAG:null | METHOD:" + this.b + " | PAYLOAD:" + this.e + " | HEADERS:" + this.c + " | RETRY_POLICY:" + this.h;
    }
}
