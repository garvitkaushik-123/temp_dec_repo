package com.moloco.sdk.internal.publisher.nativead.model;

import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class b {
    public static final int g = 8;

    /* renamed from: a, reason: collision with root package name */
    public final String f5548a;
    public final List<a> b;
    public final c c;
    public final List<String> d;
    public final List<C0449b> e;
    public final String f;

    public static abstract class a {
        public static final int c = 0;

        /* renamed from: a, reason: collision with root package name */
        public final int f5549a;
        public final boolean b;

        /* renamed from: com.moloco.sdk.internal.publisher.nativead.model.b$a$a, reason: collision with other inner class name */
        public static final class C0447a extends a {
            public static final int g = 0;
            public final Integer d;
            public final Integer e;
            public final String f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0447a(int i, boolean z, Integer num, Integer num2, String value) {
                super(i, z, null);
                Intrinsics.checkNotNullParameter(value, "value");
                this.d = num;
                this.e = num2;
                this.f = value;
            }

            public final Integer c() {
                return this.e;
            }

            public final Integer d() {
                return this.d;
            }

            public final String e() {
                return this.f;
            }
        }

        /* renamed from: com.moloco.sdk.internal.publisher.nativead.model.b$a$b, reason: collision with other inner class name */
        public static final class C0448b extends a {
            public static final int h = 0;
            public final Integer d;
            public final String e;
            public final Integer f;
            public final Integer g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0448b(int i, boolean z, Integer num, String url, Integer num2, Integer num3) {
                super(i, z, null);
                Intrinsics.checkNotNullParameter(url, "url");
                this.d = num;
                this.e = url;
                this.f = num2;
                this.g = num3;
            }

            public final Integer c() {
                return this.g;
            }

            public final Integer d() {
                return this.d;
            }

            public final String e() {
                return this.e;
            }

            public final Integer f() {
                return this.f;
            }
        }

        public static final class c extends a {
            public static final int f = 0;
            public final String d;
            public final Integer e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(int i, boolean z, String text, Integer num) {
                super(i, z, null);
                Intrinsics.checkNotNullParameter(text, "text");
                this.d = text;
                this.e = num;
            }

            public final Integer c() {
                return this.e;
            }

            public final String d() {
                return this.d;
            }
        }

        public static final class d extends a {
            public static final int e = 0;
            public final String d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public d(int i, boolean z, String vastTag) {
                super(i, z, null);
                Intrinsics.checkNotNullParameter(vastTag, "vastTag");
                this.d = vastTag;
            }

            public final String c() {
                return this.d;
            }
        }

        public /* synthetic */ a(int i, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, z);
        }

        public final int a() {
            return this.f5549a;
        }

        public final boolean b() {
            return this.b;
        }

        public a(int i, boolean z) {
            this.f5549a = i;
            this.b = z;
        }
    }

    /* renamed from: com.moloco.sdk.internal.publisher.nativead.model.b$b, reason: collision with other inner class name */
    public static final class C0449b {
        public static final int d = 0;

        /* renamed from: a, reason: collision with root package name */
        public final int f5550a;
        public final int b;
        public final String c;

        public C0449b(int i, int i2, String str) {
            this.f5550a = i;
            this.b = i2;
            this.c = str;
        }

        public final int a() {
            return this.f5550a;
        }

        public final int b() {
            return this.b;
        }

        public final String c() {
            return this.c;
        }
    }

    public static final class c {
        public static final int d = 8;

        /* renamed from: a, reason: collision with root package name */
        public final String f5551a;
        public final List<String> b;
        public final String c;

        public c(String url, List<String> clickTrackerUrls, String str) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(clickTrackerUrls, "clickTrackerUrls");
            this.f5551a = url;
            this.b = clickTrackerUrls;
            this.c = str;
        }

        public final List<String> a() {
            return this.b;
        }

        public final String b() {
            return this.c;
        }

        public final String c() {
            return this.f5551a;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(String str, List<? extends a> assets, c cVar, List<String> impressionTrackerUrls, List<C0449b> eventTrackers, String str2) {
        Intrinsics.checkNotNullParameter(assets, "assets");
        Intrinsics.checkNotNullParameter(impressionTrackerUrls, "impressionTrackerUrls");
        Intrinsics.checkNotNullParameter(eventTrackers, "eventTrackers");
        this.f5548a = str;
        this.b = assets;
        this.c = cVar;
        this.d = impressionTrackerUrls;
        this.e = eventTrackers;
        this.f = str2;
    }

    public final List<a> a() {
        return this.b;
    }

    public final List<C0449b> b() {
        return this.e;
    }

    public final List<String> c() {
        return this.d;
    }

    public final c d() {
        return this.c;
    }

    public final String e() {
        return this.f;
    }

    public final String f() {
        return this.f5548a;
    }
}
