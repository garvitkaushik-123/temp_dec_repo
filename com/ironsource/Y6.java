package com.ironsource;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public interface Y6 {

    public static final class a implements Y6 {

        /* renamed from: a, reason: collision with root package name */
        private final EnumC2989a7 f3141a;

        public a(EnumC2989a7 strategy) {
            Intrinsics.checkNotNullParameter(strategy, "strategy");
            this.f3141a = strategy;
        }

        @Override // com.ironsource.Y6
        public String a() {
            return "WebView is unavailable";
        }

        @Override // com.ironsource.Y6
        public EnumC2989a7 b() {
            return this.f3141a;
        }

        public final EnumC2989a7 c() {
            return this.f3141a;
        }
    }

    String a();

    EnumC2989a7 b();
}
