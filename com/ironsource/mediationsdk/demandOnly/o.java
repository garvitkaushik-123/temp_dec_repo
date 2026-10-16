package com.ironsource.mediationsdk.demandOnly;

import com.ironsource.InterfaceC3227o5;
import com.ironsource.InterfaceC3317tb;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public interface o extends InterfaceC3227o5<String> {

    public static final class a implements o {

        /* renamed from: a, reason: collision with root package name */
        private final String f3526a;

        public a(String rowAdm) {
            Intrinsics.checkNotNullParameter(rowAdm, "rowAdm");
            this.f3526a = rowAdm;
        }

        @Override // com.ironsource.InterfaceC3227o5
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public String a() {
            return this.f3526a;
        }

        @Override // com.ironsource.mediationsdk.demandOnly.o
        public <T> T a(InterfaceC3317tb<String, T> mapper) {
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            return mapper.a(this.f3526a);
        }
    }

    <T> T a(InterfaceC3317tb<String, T> interfaceC3317tb);
}
