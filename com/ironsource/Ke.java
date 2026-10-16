package com.ironsource;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class Ke implements InterfaceC3317tb<Ee, C3322u> {
    @Override // com.ironsource.InterfaceC3317tb
    public C3322u a(Ee input) {
        String str;
        String str2;
        String str3;
        S7 s7;
        String c;
        Intrinsics.checkNotNullParameter(input, "input");
        Le b = input.b();
        N a2 = input.a();
        if (a2 == null || (str = a2.h()) == null) {
            str = "0";
        }
        N a3 = input.a();
        if (a3 == null || (str2 = a3.i()) == null) {
            str2 = "0";
        }
        N a4 = input.a();
        if (a4 == null || (str3 = a4.g()) == null) {
            str3 = "0";
        }
        N a5 = input.a();
        if (a5 == null || (s7 = a5.e()) == null) {
            s7 = S7.UnknownProvider;
        }
        N a6 = input.a();
        return new C3322u(b, str, str2, str3, s7, (a6 == null || (c = a6.c()) == null) ? "0" : c);
    }
}
