package com.ironsource.mediationsdk.demandOnly;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public interface p {

    public static class a implements p {

        /* renamed from: a, reason: collision with root package name */
        private final String f3527a;

        public a(String plumbus) {
            Intrinsics.checkNotNullParameter(plumbus, "plumbus");
            this.f3527a = plumbus;
        }

        @Override // com.ironsource.mediationsdk.demandOnly.p
        public String value() {
            return this.f3527a;
        }
    }

    public static final class b extends a {
        public b() {
            super("");
        }
    }

    String value();
}
