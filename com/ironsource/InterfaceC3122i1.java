package com.ironsource;

import com.ironsource.C3172l1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.i1, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public interface InterfaceC3122i1 {

    /* renamed from: com.ironsource.i1$a */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final C0289a f3348a = new C0289a(null);

        /* renamed from: com.ironsource.i1$a$a, reason: collision with other inner class name */
        public static final class C0289a {
            public /* synthetic */ C0289a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @JvmStatic
            public final InterfaceC3122i1 a(C3172l1.j errorCode, C3172l1.k errorReason) {
                Intrinsics.checkNotNullParameter(errorCode, "errorCode");
                Intrinsics.checkNotNullParameter(errorReason, "errorReason");
                return new b(403, CollectionsKt.mutableListOf(errorCode, errorReason));
            }

            @JvmStatic
            public final InterfaceC3122i1 b(InterfaceC3189m1... entity) {
                Intrinsics.checkNotNullParameter(entity, "entity");
                return new b(404, CollectionsKt.mutableListOf(Arrays.copyOf(entity, entity.length)));
            }

            @JvmStatic
            public final InterfaceC3122i1 c(InterfaceC3189m1... entity) {
                Intrinsics.checkNotNullParameter(entity, "entity");
                return new b(409, CollectionsKt.mutableListOf(Arrays.copyOf(entity, entity.length)));
            }

            @JvmStatic
            public final InterfaceC3122i1 d(InterfaceC3189m1... entity) {
                Intrinsics.checkNotNullParameter(entity, "entity");
                return new b(401, CollectionsKt.mutableListOf(Arrays.copyOf(entity, entity.length)));
            }

            @JvmStatic
            public final InterfaceC3122i1 e(InterfaceC3189m1... entity) {
                Intrinsics.checkNotNullParameter(entity, "entity");
                return new b(408, CollectionsKt.mutableListOf(Arrays.copyOf(entity, entity.length)));
            }

            @JvmStatic
            public final InterfaceC3122i1 f(InterfaceC3189m1... entity) {
                Intrinsics.checkNotNullParameter(entity, "entity");
                return new b(405, CollectionsKt.mutableListOf(Arrays.copyOf(entity, entity.length)));
            }

            private C0289a() {
            }

            @JvmStatic
            public final InterfaceC3122i1 a() {
                return new b(406, new ArrayList());
            }

            @JvmStatic
            public final InterfaceC3122i1 a(InterfaceC3189m1... entity) {
                Intrinsics.checkNotNullParameter(entity, "entity");
                return new b(407, CollectionsKt.mutableListOf(Arrays.copyOf(entity, entity.length)));
            }

            @JvmStatic
            public final InterfaceC3122i1 a(boolean z) {
                if (z) {
                    return new b(410, new ArrayList());
                }
                return new b(411, new ArrayList());
            }
        }

        /* renamed from: com.ironsource.i1$a$b */
        public static final class b {

            /* renamed from: a, reason: collision with root package name */
            public static final b f3349a = new b();
            public static final int b = 401;
            public static final int c = 403;
            public static final int d = 404;
            public static final int e = 405;
            public static final int f = 406;
            public static final int g = 407;
            public static final int h = 408;
            public static final int i = 409;
            public static final int j = 410;
            public static final int k = 411;

            private b() {
            }
        }

        @JvmStatic
        public static final InterfaceC3122i1 a() {
            return f3348a.a();
        }

        @JvmStatic
        public static final InterfaceC3122i1 b(InterfaceC3189m1... interfaceC3189m1Arr) {
            return f3348a.b(interfaceC3189m1Arr);
        }

        @JvmStatic
        public static final InterfaceC3122i1 c(InterfaceC3189m1... interfaceC3189m1Arr) {
            return f3348a.c(interfaceC3189m1Arr);
        }

        @JvmStatic
        public static final InterfaceC3122i1 d(InterfaceC3189m1... interfaceC3189m1Arr) {
            return f3348a.d(interfaceC3189m1Arr);
        }

        @JvmStatic
        public static final InterfaceC3122i1 e(InterfaceC3189m1... interfaceC3189m1Arr) {
            return f3348a.e(interfaceC3189m1Arr);
        }

        @JvmStatic
        public static final InterfaceC3122i1 f(InterfaceC3189m1... interfaceC3189m1Arr) {
            return f3348a.f(interfaceC3189m1Arr);
        }

        @JvmStatic
        public static final InterfaceC3122i1 a(InterfaceC3189m1... interfaceC3189m1Arr) {
            return f3348a.a(interfaceC3189m1Arr);
        }

        @JvmStatic
        public static final InterfaceC3122i1 a(boolean z) {
            return f3348a.a(z);
        }

        @JvmStatic
        public static final InterfaceC3122i1 a(C3172l1.j jVar, C3172l1.k kVar) {
            return f3348a.a(jVar, kVar);
        }
    }

    /* renamed from: com.ironsource.i1$b */
    public static final class b implements InterfaceC3122i1 {

        /* renamed from: a, reason: collision with root package name */
        private final int f3350a;
        private final List<InterfaceC3189m1> b;

        public b(int i, List<InterfaceC3189m1> arrayList) {
            Intrinsics.checkNotNullParameter(arrayList, "arrayList");
            this.f3350a = i;
            this.b = arrayList;
        }

        @Override // com.ironsource.InterfaceC3122i1
        public void a(InterfaceC3240p1 analytics) {
            Intrinsics.checkNotNullParameter(analytics, "analytics");
            analytics.a(this.f3350a, this.b);
        }
    }

    /* renamed from: com.ironsource.i1$c */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public static final a f3351a = new a(null);

        /* renamed from: com.ironsource.i1$c$a */
        public static final class a {
            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @JvmStatic
            public final InterfaceC3122i1 a() {
                return new b(201, new ArrayList());
            }

            @JvmStatic
            public final InterfaceC3122i1 b() {
                return new b(206, new ArrayList());
            }

            private a() {
            }

            @JvmStatic
            public final InterfaceC3122i1 a(C3172l1.l ext1) {
                Intrinsics.checkNotNullParameter(ext1, "ext1");
                return new b(207, CollectionsKt.mutableListOf(ext1));
            }

            @JvmStatic
            public final InterfaceC3122i1 a(InterfaceC3189m1 duration) {
                Intrinsics.checkNotNullParameter(duration, "duration");
                return new b(202, CollectionsKt.mutableListOf(duration));
            }

            @JvmStatic
            public final InterfaceC3122i1 a(C3172l1.j errorCode, C3172l1.k errorReason, C3172l1.f duration) {
                Intrinsics.checkNotNullParameter(errorCode, "errorCode");
                Intrinsics.checkNotNullParameter(errorReason, "errorReason");
                Intrinsics.checkNotNullParameter(duration, "duration");
                return new b(203, CollectionsKt.mutableListOf(errorCode, errorReason, duration));
            }

            @JvmStatic
            public final InterfaceC3122i1 a(InterfaceC3189m1... entity) {
                Intrinsics.checkNotNullParameter(entity, "entity");
                return new b(204, CollectionsKt.mutableListOf(Arrays.copyOf(entity, entity.length)));
            }
        }

        /* renamed from: com.ironsource.i1$c$b */
        public static final class b {

            /* renamed from: a, reason: collision with root package name */
            public static final b f3352a = new b();
            public static final int b = 201;
            public static final int c = 202;
            public static final int d = 203;
            public static final int e = 204;
            public static final int f = 205;
            public static final int g = 206;
            public static final int h = 207;

            private b() {
            }
        }

        @JvmStatic
        public static final InterfaceC3122i1 a(InterfaceC3189m1... interfaceC3189m1Arr) {
            return f3351a.a(interfaceC3189m1Arr);
        }

        @JvmStatic
        public static final InterfaceC3122i1 b() {
            return f3351a.b();
        }

        @JvmStatic
        public static final InterfaceC3122i1 a() {
            return f3351a.a();
        }

        @JvmStatic
        public static final InterfaceC3122i1 a(C3172l1.j jVar, C3172l1.k kVar, C3172l1.f fVar) {
            return f3351a.a(jVar, kVar, fVar);
        }

        @JvmStatic
        public static final InterfaceC3122i1 a(InterfaceC3189m1 interfaceC3189m1) {
            return f3351a.a(interfaceC3189m1);
        }

        @JvmStatic
        public static final InterfaceC3122i1 a(C3172l1.l lVar) {
            return f3351a.a(lVar);
        }
    }

    /* renamed from: com.ironsource.i1$d */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        public static final a f3353a = new a(null);

        /* renamed from: com.ironsource.i1$d$a */
        public static final class a {
            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @JvmStatic
            public final InterfaceC3122i1 a() {
                return new b(101, new ArrayList());
            }

            @JvmStatic
            public final InterfaceC3122i1 b(InterfaceC3189m1... entity) {
                Intrinsics.checkNotNullParameter(entity, "entity");
                return new b(110, CollectionsKt.mutableListOf(Arrays.copyOf(entity, entity.length)));
            }

            @JvmStatic
            public final b c() {
                return new b(105, new ArrayList());
            }

            private a() {
            }

            @JvmStatic
            public final InterfaceC3122i1 a(InterfaceC3189m1... entity) {
                Intrinsics.checkNotNullParameter(entity, "entity");
                return new b(102, CollectionsKt.mutableListOf(Arrays.copyOf(entity, entity.length)));
            }

            @JvmStatic
            public final InterfaceC3122i1 b() {
                return new b(112, new ArrayList());
            }

            @JvmStatic
            public final InterfaceC3122i1 a(C3172l1.f duration) {
                Intrinsics.checkNotNullParameter(duration, "duration");
                return new b(103, CollectionsKt.mutableListOf(duration));
            }

            @JvmStatic
            public final InterfaceC3122i1 a(C3172l1.j errorCode, C3172l1.k errorReason, C3172l1.f duration, C3172l1.l loaderState) {
                Intrinsics.checkNotNullParameter(errorCode, "errorCode");
                Intrinsics.checkNotNullParameter(errorReason, "errorReason");
                Intrinsics.checkNotNullParameter(duration, "duration");
                Intrinsics.checkNotNullParameter(loaderState, "loaderState");
                return new b(104, CollectionsKt.mutableListOf(errorCode, errorReason, duration, loaderState));
            }

            @JvmStatic
            public final InterfaceC3122i1 a(C3172l1.j errorCode, C3172l1.k errorReason) {
                Intrinsics.checkNotNullParameter(errorCode, "errorCode");
                Intrinsics.checkNotNullParameter(errorReason, "errorReason");
                return new b(109, CollectionsKt.mutableListOf(errorCode, errorReason));
            }

            @JvmStatic
            public final InterfaceC3122i1 a(InterfaceC3189m1 ext1) {
                Intrinsics.checkNotNullParameter(ext1, "ext1");
                return new b(111, CollectionsKt.mutableListOf(ext1));
            }
        }

        /* renamed from: com.ironsource.i1$d$b */
        public static final class b {

            /* renamed from: a, reason: collision with root package name */
            public static final b f3354a = new b();
            public static final int b = 101;
            public static final int c = 102;
            public static final int d = 103;
            public static final int e = 104;
            public static final int f = 105;
            public static final int g = 109;
            public static final int h = 110;
            public static final int i = 111;
            public static final int j = 112;

            private b() {
            }
        }

        @JvmStatic
        public static final InterfaceC3122i1 a() {
            return f3353a.a();
        }

        @JvmStatic
        public static final InterfaceC3122i1 b() {
            return f3353a.b();
        }

        @JvmStatic
        public static final b c() {
            return f3353a.c();
        }

        @JvmStatic
        public static final InterfaceC3122i1 a(InterfaceC3189m1... interfaceC3189m1Arr) {
            return f3353a.a(interfaceC3189m1Arr);
        }

        @JvmStatic
        public static final InterfaceC3122i1 b(InterfaceC3189m1... interfaceC3189m1Arr) {
            return f3353a.b(interfaceC3189m1Arr);
        }

        @JvmStatic
        public static final InterfaceC3122i1 a(C3172l1.j jVar, C3172l1.k kVar) {
            return f3353a.a(jVar, kVar);
        }

        @JvmStatic
        public static final InterfaceC3122i1 a(C3172l1.j jVar, C3172l1.k kVar, C3172l1.f fVar, C3172l1.l lVar) {
            return f3353a.a(jVar, kVar, fVar, lVar);
        }

        @JvmStatic
        public static final InterfaceC3122i1 a(InterfaceC3189m1 interfaceC3189m1) {
            return f3353a.a(interfaceC3189m1);
        }

        @JvmStatic
        public static final InterfaceC3122i1 a(C3172l1.f fVar) {
            return f3353a.a(fVar);
        }
    }

    void a(InterfaceC3240p1 interfaceC3240p1);
}
