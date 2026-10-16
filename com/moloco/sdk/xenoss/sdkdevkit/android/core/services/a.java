package com.moloco.sdk.xenoss.sdkdevkit.android.core.services;

import io.bidmachine.iab.vast.tags.VastTagName;
import io.bidmachine.media3.exoplayer.hls.playlist.HlsMediaPlaylist;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public interface a {

    /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC0571a {

        /* renamed from: a, reason: collision with root package name */
        public static final int f6354a = 0;

        /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a$a$a, reason: collision with other inner class name */
        public static final class C0572a extends AbstractC0571a {
            public static final C0572a b = new C0572a();
            public static final int c = 0;

            public C0572a() {
                super(null);
            }
        }

        /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a$a$b */
        public static final class b extends AbstractC0571a {
            public static final int c = 0;
            public final long b;

            public b(long j) {
                super(null);
                this.b = j;
            }

            public final long a() {
                return this.b;
            }

            public final long b() {
                return this.b;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof b) && this.b == ((b) obj).b;
            }

            public int hashCode() {
                return Long.hashCode(this.b);
            }

            public String toString() {
                return "AppForeground(lastBgTimestamp=" + this.b + ')';
            }

            public final b a(long j) {
                return new b(j);
            }

            public static /* synthetic */ b a(b bVar, long j, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = bVar.b;
                }
                return bVar.a(j);
            }
        }

        /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a$a$c */
        public static final class c {
            public static final int d = 0;

            /* renamed from: a, reason: collision with root package name */
            public final EnumC0573a f6355a;
            public final f b;
            public final g c;

            /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
            /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
            /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a$a$c$a, reason: collision with other inner class name */
            public static final class EnumC0573a {

                /* renamed from: a, reason: collision with root package name */
                public static final EnumC0573a f6356a = new EnumC0573a("NONE", 0);
                public static final EnumC0573a b = new EnumC0573a("CLOSE", 1);
                public static final EnumC0573a c = new EnumC0573a(HlsMediaPlaylist.Interstitial.NAVIGATION_RESTRICTION_SKIP, 2);
                public static final EnumC0573a d = new EnumC0573a("SKIP_DEC", 3);
                public static final EnumC0573a e = new EnumC0573a("MUTE", 4);
                public static final EnumC0573a f = new EnumC0573a("UNMUTE", 5);
                public static final EnumC0573a g = new EnumC0573a(VastTagName.CTA, 6);
                public static final EnumC0573a h = new EnumC0573a("REPLAY", 7);
                public static final EnumC0573a i = new EnumC0573a("AD_BADGE", 8);
                public static final /* synthetic */ EnumC0573a[] j;
                public static final /* synthetic */ EnumEntries k;

                static {
                    EnumC0573a[] a2 = a();
                    j = a2;
                    k = EnumEntriesKt.enumEntries(a2);
                }

                public EnumC0573a(String str, int i2) {
                }

                public static final /* synthetic */ EnumC0573a[] a() {
                    return new EnumC0573a[]{f6356a, b, c, d, e, f, g, h, i};
                }

                public static EnumEntries<EnumC0573a> b() {
                    return k;
                }

                public static EnumC0573a valueOf(String str) {
                    return (EnumC0573a) Enum.valueOf(EnumC0573a.class, str);
                }

                public static EnumC0573a[] values() {
                    return (EnumC0573a[]) j.clone();
                }
            }

            public c(EnumC0573a buttonType, f position, g size) {
                Intrinsics.checkNotNullParameter(buttonType, "buttonType");
                Intrinsics.checkNotNullParameter(position, "position");
                Intrinsics.checkNotNullParameter(size, "size");
                this.f6355a = buttonType;
                this.b = position;
                this.c = size;
            }

            public final EnumC0573a a() {
                return this.f6355a;
            }

            public final f b() {
                return this.b;
            }

            public final g c() {
                return this.c;
            }

            public final EnumC0573a d() {
                return this.f6355a;
            }

            public final f e() {
                return this.b;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof c)) {
                    return false;
                }
                c cVar = (c) obj;
                return this.f6355a == cVar.f6355a && Intrinsics.areEqual(this.b, cVar.b) && Intrinsics.areEqual(this.c, cVar.c);
            }

            public final g f() {
                return this.c;
            }

            public int hashCode() {
                return (((this.f6355a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
            }

            public String toString() {
                return "Button(buttonType=" + this.f6355a + ", position=" + this.b + ", size=" + this.c + ')';
            }

            public final c a(EnumC0573a buttonType, f position, g size) {
                Intrinsics.checkNotNullParameter(buttonType, "buttonType");
                Intrinsics.checkNotNullParameter(position, "position");
                Intrinsics.checkNotNullParameter(size, "size");
                return new c(buttonType, position, size);
            }

            public static /* synthetic */ c a(c cVar, EnumC0573a enumC0573a, f fVar, g gVar, int i, Object obj) {
                if ((i & 1) != 0) {
                    enumC0573a = cVar.f6355a;
                }
                if ((i & 2) != 0) {
                    fVar = cVar.b;
                }
                if ((i & 4) != 0) {
                    gVar = cVar.c;
                }
                return cVar.a(enumC0573a, fVar, gVar);
            }
        }

        /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a$a$e */
        public static final class e extends AbstractC0571a {
            public static final e b = new e();
            public static final int c = 0;

            public e() {
                super(null);
            }
        }

        /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a$a$f */
        public static final class f {
            public static final int c = 0;

            /* renamed from: a, reason: collision with root package name */
            public final float f6357a;
            public final float b;

            public f(float f, float f2) {
                this.f6357a = f;
                this.b = f2;
            }

            public final float a() {
                return this.f6357a;
            }

            public final float b() {
                return this.b;
            }

            public final float c() {
                return this.f6357a;
            }

            public final float d() {
                return this.b;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof f)) {
                    return false;
                }
                f fVar = (f) obj;
                return Float.compare(this.f6357a, fVar.f6357a) == 0 && Float.compare(this.b, fVar.b) == 0;
            }

            public int hashCode() {
                return (Float.hashCode(this.f6357a) * 31) + Float.hashCode(this.b);
            }

            public String toString() {
                return "Position(topLeftXDp=" + this.f6357a + ", topLeftYDp=" + this.b + ')';
            }

            public final f a(float f, float f2) {
                return new f(f, f2);
            }

            public static /* synthetic */ f a(f fVar, float f, float f2, int i, Object obj) {
                if ((i & 1) != 0) {
                    f = fVar.f6357a;
                }
                if ((i & 2) != 0) {
                    f2 = fVar.b;
                }
                return fVar.a(f, f2);
            }
        }

        /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a$a$g */
        public static final class g {
            public static final int c = 0;

            /* renamed from: a, reason: collision with root package name */
            public final float f6358a;
            public final float b;

            public g(float f, float f2) {
                this.f6358a = f;
                this.b = f2;
            }

            public final float a() {
                return this.f6358a;
            }

            public final float b() {
                return this.b;
            }

            public final float c() {
                return this.b;
            }

            public final float d() {
                return this.f6358a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof g)) {
                    return false;
                }
                g gVar = (g) obj;
                return Float.compare(this.f6358a, gVar.f6358a) == 0 && Float.compare(this.b, gVar.b) == 0;
            }

            public int hashCode() {
                return (Float.hashCode(this.f6358a) * 31) + Float.hashCode(this.b);
            }

            public String toString() {
                return "Size(widthDp=" + this.f6358a + ", heightDp=" + this.b + ')';
            }

            public final g a(float f, float f2) {
                return new g(f, f2);
            }

            public static /* synthetic */ g a(g gVar, float f, float f2, int i, Object obj) {
                if ((i & 1) != 0) {
                    f = gVar.f6358a;
                }
                if ((i & 2) != 0) {
                    f2 = gVar.b;
                }
                return gVar.a(f, f2);
            }
        }

        public /* synthetic */ AbstractC0571a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a$a$d */
        public static final class d extends AbstractC0571a {
            public static final int f = 8;
            public final f b;
            public final f c;
            public final g d;
            public final List<c> e;

            public /* synthetic */ d(f fVar, f fVar2, g gVar, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(fVar, (i & 2) != 0 ? null : fVar2, (i & 4) != 0 ? null : gVar, (i & 8) != 0 ? CollectionsKt.emptyList() : list);
            }

            public final List<c> a() {
                return this.e;
            }

            public final f b() {
                return this.b;
            }

            public final f c() {
                return this.c;
            }

            public final g d() {
                return this.d;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public d(f clickPosition, f fVar, g gVar, List<c> buttonLayout) {
                super(null);
                Intrinsics.checkNotNullParameter(clickPosition, "clickPosition");
                Intrinsics.checkNotNullParameter(buttonLayout, "buttonLayout");
                this.b = clickPosition;
                this.c = fVar;
                this.d = gVar;
                this.e = buttonLayout;
            }
        }

        public AbstractC0571a() {
        }
    }

    Object a(long j, AbstractC0571a abstractC0571a, String str, Continuation<? super String> continuation);
}
