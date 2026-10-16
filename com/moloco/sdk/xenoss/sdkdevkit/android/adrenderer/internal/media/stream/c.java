package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream;

import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.i;
import java.io.File;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public static final int f5876a = 0;

    public static final class a extends c {
        public static final int c = 8;
        public final File b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(File file) {
            super(null);
            Intrinsics.checkNotNullParameter(file, "file");
            this.b = file;
        }

        public final File a() {
            return this.b;
        }

        public final File b() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && Intrinsics.areEqual(this.b, ((a) obj).b);
        }

        public int hashCode() {
            return this.b.hashCode();
        }

        public String toString() {
            return "Complete(file=" + this.b + ')';
        }

        public final a a(File file) {
            Intrinsics.checkNotNullParameter(file, "file");
            return new a(file);
        }

        public static /* synthetic */ a a(a aVar, File file, int i, Object obj) {
            if ((i & 1) != 0) {
                file = aVar.b;
            }
            return aVar.a(file);
        }
    }

    public static final class b extends c {
        public static final int c = 0;
        public final i.a.AbstractC0479a b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(i.a.AbstractC0479a failure) {
            super(null);
            Intrinsics.checkNotNullParameter(failure, "failure");
            this.b = failure;
        }

        public final i.a.AbstractC0479a a() {
            return this.b;
        }

        public final i.a.AbstractC0479a b() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && Intrinsics.areEqual(this.b, ((b) obj).b);
        }

        public int hashCode() {
            return this.b.hashCode();
        }

        public String toString() {
            return "Failure(failure=" + this.b + ')';
        }

        public final b a(i.a.AbstractC0479a failure) {
            Intrinsics.checkNotNullParameter(failure, "failure");
            return new b(failure);
        }

        public static /* synthetic */ b a(b bVar, i.a.AbstractC0479a abstractC0479a, int i, Object obj) {
            if ((i & 1) != 0) {
                abstractC0479a = bVar.b;
            }
            return bVar.a(abstractC0479a);
        }
    }

    /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c$c, reason: collision with other inner class name */
    public static final class C0482c extends c {
        public static final int d = 8;
        public final File b;
        public final d c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0482c(File file, d progress) {
            super(null);
            Intrinsics.checkNotNullParameter(file, "file");
            Intrinsics.checkNotNullParameter(progress, "progress");
            this.b = file;
            this.c = progress;
        }

        public final File a() {
            return this.b;
        }

        public final d b() {
            return this.c;
        }

        public final File c() {
            return this.b;
        }

        public final d d() {
            return this.c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0482c)) {
                return false;
            }
            C0482c c0482c = (C0482c) obj;
            return Intrinsics.areEqual(this.b, c0482c.b) && Intrinsics.areEqual(this.c, c0482c.c);
        }

        public int hashCode() {
            return (this.b.hashCode() * 31) + this.c.hashCode();
        }

        public String toString() {
            return "InProgress(file=" + this.b + ", progress=" + this.c + ')';
        }

        public final C0482c a(File file, d progress) {
            Intrinsics.checkNotNullParameter(file, "file");
            Intrinsics.checkNotNullParameter(progress, "progress");
            return new C0482c(file, progress);
        }

        public static /* synthetic */ C0482c a(C0482c c0482c, File file, d dVar, int i, Object obj) {
            if ((i & 1) != 0) {
                file = c0482c.b;
            }
            if ((i & 2) != 0) {
                dVar = c0482c.c;
            }
            return c0482c.a(file, dVar);
        }
    }

    public static final class d {
        public static final int c = 0;

        /* renamed from: a, reason: collision with root package name */
        public final long f5877a;
        public final long b;

        public d(long j, long j2) {
            this.f5877a = j;
            this.b = j2;
        }

        public final long a() {
            return this.f5877a;
        }

        public final long b() {
            return this.b;
        }

        public final long c() {
            return this.f5877a;
        }

        public final long d() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return this.f5877a == dVar.f5877a && this.b == dVar.b;
        }

        public int hashCode() {
            return (Long.hashCode(this.f5877a) * 31) + Long.hashCode(this.b);
        }

        public String toString() {
            return "Progress(bytesDownloaded=" + this.f5877a + ", totalBytes=" + this.b + ')';
        }

        public final d a(long j, long j2) {
            return new d(j, j2);
        }

        public static /* synthetic */ d a(d dVar, long j, long j2, int i, Object obj) {
            if ((i & 1) != 0) {
                j = dVar.f5877a;
            }
            if ((i & 2) != 0) {
                j2 = dVar.b;
            }
            return dVar.a(j, j2);
        }
    }

    public /* synthetic */ c(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public c() {
    }
}
