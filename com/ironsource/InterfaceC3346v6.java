package com.ironsource;

import android.app.Activity;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.v6, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public interface InterfaceC3346v6 {

    /* renamed from: com.ironsource.v6$a */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final c f3907a;

        public a(c strategyType) {
            Intrinsics.checkNotNullParameter(strategyType, "strategyType");
            this.f3907a = strategyType;
        }

        public final c a() {
            return this.f3907a;
        }

        public final c b() {
            return this.f3907a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && this.f3907a == ((a) obj).f3907a;
        }

        public int hashCode() {
            return this.f3907a.hashCode();
        }

        public String toString() {
            return "Config(strategyType=" + this.f3907a + ")";
        }

        public final a a(c strategyType) {
            Intrinsics.checkNotNullParameter(strategyType, "strategyType");
            return new a(strategyType);
        }

        public static /* synthetic */ a a(a aVar, c cVar, int i, Object obj) {
            if ((i & 1) != 0) {
                cVar = aVar.f3907a;
            }
            return aVar.a(cVar);
        }
    }

    /* renamed from: com.ironsource.v6$b */
    public static final class b {

        /* renamed from: com.ironsource.v6$b$a */
        public /* synthetic */ class a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f3908a;

            static {
                int[] iArr = new int[c.values().length];
                try {
                    iArr[c.SINGLE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[c.PROGRESSIVE_ON_SHOW_SUCCESS.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[c.PROGRESSIVE_ON_LOAD_SUCCESS.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                f3908a = iArr;
            }
        }

        public final InterfaceC3346v6 a(C3205n0 adTools, a config, InterfaceC3278r6 fullscreenAdUnitFactory, InterfaceC3312t6 fullscreenAdUnitListener, InterfaceC3329u6 listener) {
            Intrinsics.checkNotNullParameter(adTools, "adTools");
            Intrinsics.checkNotNullParameter(config, "config");
            Intrinsics.checkNotNullParameter(fullscreenAdUnitFactory, "fullscreenAdUnitFactory");
            Intrinsics.checkNotNullParameter(fullscreenAdUnitListener, "fullscreenAdUnitListener");
            Intrinsics.checkNotNullParameter(listener, "listener");
            int i = a.f3908a[config.b().ordinal()];
            if (i == 1) {
                return new J6(adTools, config, fullscreenAdUnitFactory, fullscreenAdUnitListener, listener);
            }
            if (i == 2) {
                return new C6(adTools, fullscreenAdUnitFactory, fullscreenAdUnitListener, listener);
            }
            if (i == 3) {
                return new C3363w6(adTools, fullscreenAdUnitFactory, fullscreenAdUnitListener, listener);
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    /* renamed from: com.ironsource.v6$c */
    public enum c {
        SINGLE("Single"),
        PROGRESSIVE_ON_SHOW_SUCCESS("OnShowSuccess"),
        PROGRESSIVE_ON_LOAD_SUCCESS("OnLoadSuccess");


        /* renamed from: a, reason: collision with root package name */
        private final String f3909a;

        c(String str) {
            this.f3909a = str;
        }

        public final String b() {
            return this.f3909a;
        }
    }

    void a(Activity activity);

    void loadAd();
}
