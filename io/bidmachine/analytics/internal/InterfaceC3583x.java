package io.bidmachine.analytics.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.vungle.ads.internal.protos.Sdk;
import io.bidmachine.protobuf.EventTypeExtended;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* renamed from: io.bidmachine.analytics.internal.x, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public interface InterfaceC3583x extends IInterface {

    /* renamed from: io.bidmachine.analytics.internal.x$a */
    public static final class a implements InterfaceC3583x {
        public static final d d = new d(null);
        private static final Lazy e = LazyKt.lazy(c.f6791a);
        private static final b f;
        private static final b g;
        private static final b h;
        private static final b i;
        private static final b j;
        private static final b k;
        private static final b l;
        private static final b m;
        private static final b n;
        private static final b o;
        private static final b p;
        private static final b q;
        private static final b r;
        private static final b s;

        /* renamed from: a, reason: collision with root package name */
        private final IBinder f6788a;
        private b b;
        private final Function0 c;

        /* renamed from: io.bidmachine.analytics.internal.x$a$a, reason: collision with other inner class name */
        static final class C0599a extends Lambda implements Function0 {

            /* renamed from: a, reason: collision with root package name */
            public static final C0599a f6789a = new C0599a();

            C0599a() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Parcel invoke() {
                return Parcel.obtain();
            }
        }

        /* renamed from: io.bidmachine.analytics.internal.x$a$b */
        public static final class b {

            /* renamed from: a, reason: collision with root package name */
            private final int f6790a;
            private final int b;
            private final int c;
            private final int d;
            private final int e;
            private final int f;
            private final int g;
            private final int h;

            public b(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                this.f6790a = i;
                this.b = i2;
                this.c = i3;
                this.d = i4;
                this.e = i5;
                this.f = i6;
                this.g = i7;
                this.h = i8;
            }

            public final b a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                return new b(i, i2, i3, i4, i5, i6, i7, i8);
            }

            public final int b() {
                return this.h;
            }

            public final int c() {
                return this.f;
            }

            public final int d() {
                return this.b;
            }

            public final int e() {
                return this.c;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof b)) {
                    return false;
                }
                b bVar = (b) obj;
                return this.f6790a == bVar.f6790a && this.b == bVar.b && this.c == bVar.c && this.d == bVar.d && this.e == bVar.e && this.f == bVar.f && this.g == bVar.g && this.h == bVar.h;
            }

            public final int f() {
                return this.g;
            }

            public final int g() {
                return this.e;
            }

            public final int h() {
                return this.f6790a;
            }

            public int hashCode() {
                return (((((((((((((Integer.hashCode(this.f6790a) * 31) + Integer.hashCode(this.b)) * 31) + Integer.hashCode(this.c)) * 31) + Integer.hashCode(this.d)) * 31) + Integer.hashCode(this.e)) * 31) + Integer.hashCode(this.f)) * 31) + Integer.hashCode(this.g)) * 31) + Integer.hashCode(this.h);
            }

            public String toString() {
                return super.toString();
            }

            public static /* synthetic */ b a(b bVar, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, Object obj) {
                if ((i9 & 1) != 0) {
                    i = bVar.f6790a;
                }
                if ((i9 & 2) != 0) {
                    i2 = bVar.b;
                }
                if ((i9 & 4) != 0) {
                    i3 = bVar.c;
                }
                if ((i9 & 8) != 0) {
                    i4 = bVar.d;
                }
                if ((i9 & 16) != 0) {
                    i5 = bVar.e;
                }
                if ((i9 & 32) != 0) {
                    i6 = bVar.f;
                }
                if ((i9 & 64) != 0) {
                    i7 = bVar.g;
                }
                if ((i9 & 128) != 0) {
                    i8 = bVar.h;
                }
                int i10 = i7;
                int i11 = i8;
                int i12 = i5;
                int i13 = i6;
                return bVar.a(i, i2, i3, i4, i12, i13, i10, i11);
            }

            public final int a() {
                return this.d;
            }
        }

        /* renamed from: io.bidmachine.analytics.internal.x$a$c */
        static final class c extends Lambda implements Function0 {

            /* renamed from: a, reason: collision with root package name */
            public static final c f6791a = new c();

            c() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final String invoke() {
                return s0.a("Y29tLmFuZHJvaWQudmVuZGluZy5iaWxsaW5nLklJbkFwcEJpbGxpbmdTZXJ2aWNl");
            }
        }

        /* renamed from: io.bidmachine.analytics.internal.x$a$d */
        public static final class d {
            public /* synthetic */ d(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final String a() {
                return (String) a.e.getValue();
            }

            public final b b() {
                return a.g;
            }

            public final b c() {
                return a.h;
            }

            public final b d() {
                return a.i;
            }

            public final b e() {
                return a.j;
            }

            public final b f() {
                return a.k;
            }

            public final b g() {
                return a.l;
            }

            public final b h() {
                return a.m;
            }

            public final b i() {
                return a.n;
            }

            public final b j() {
                return a.o;
            }

            public final b k() {
                return a.p;
            }

            public final b l() {
                return a.q;
            }

            public final b m() {
                return a.r;
            }

            public final b n() {
                return a.s;
            }

            public final b o() {
                return a.f;
            }

            private d() {
            }

            public final b a(t0 t0Var) {
                return t0Var.compareTo(new t0(5, 1, 0)) < 0 ? b() : t0Var.compareTo(new t0(5, 2, 0)) < 0 ? c() : t0Var.compareTo(new t0(5, 2, 1)) < 0 ? d() : t0Var.compareTo(new t0(6, 0, 0)) < 0 ? e() : t0Var.compareTo(new t0(6, 0, 1)) < 0 ? f() : t0Var.compareTo(new t0(6, 1, 0)) < 0 ? g() : t0Var.compareTo(new t0(6, 2, 0)) < 0 ? h() : t0Var.compareTo(new t0(6, 2, 1)) < 0 ? i() : t0Var.compareTo(new t0(7, 0, 0)) < 0 ? j() : t0Var.compareTo(new t0(7, 1, 0)) < 0 ? k() : t0Var.compareTo(new t0(7, 1, 1)) < 0 ? l() : t0Var.compareTo(new t0(7, 2, 0)) < 0 ? m() : t0Var.compareTo(new t0(8, 0, 1)) < 0 ? n() : o();
            }
        }

        static {
            b bVar = new b(1, 25, 11, 24, 9, 6, EventTypeExtended.EVENT_TYPE_EXTENDED_WATERFALL_STARTED_VALUE, 20);
            f = bVar;
            b a2 = b.a(bVar, 0, 17, 0, 9, 0, 0, 0, 17, Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE, null);
            g = a2;
            h = a2;
            b a3 = b.a(a2, 0, 19, 0, 19, 0, 0, 0, 0, 245, null);
            i = a3;
            j = a3;
            b a4 = b.a(a3, 0, 20, 0, 0, 0, 0, 0, 20, Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE, null);
            k = a4;
            l = a4;
            b a5 = b.a(a4, 0, 21, 0, 0, 0, 0, 0, 0, 253, null);
            m = a5;
            b a6 = b.a(a5, 0, 22, 0, 0, 0, 0, 0, 0, 253, null);
            n = a6;
            o = a6;
            p = a6;
            b a7 = b.a(a6, 0, 23, 0, 0, 0, 0, 0, 0, 253, null);
            q = a7;
            b a8 = b.a(a7, 0, 23, 0, 0, 0, 0, 0, 0, 253, null);
            r = a8;
            s = b.a(a8, 0, 25, 0, 24, 0, 0, 0, 0, 245, null);
        }

        public a(IBinder iBinder, b bVar, Function0 function0) {
            this.f6788a = iBinder;
            this.b = bVar;
            this.c = function0;
        }

        private final Parcel p() {
            Parcel parcel = (Parcel) this.c.invoke();
            parcel.writeInterfaceToken(d.a());
            return parcel;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.f6788a;
        }

        @Override // io.bidmachine.analytics.internal.InterfaceC3583x
        public int a(String str, String str2) {
            Parcel p2 = p();
            p2.writeInt(this.b.d());
            p2.writeString(str);
            p2.writeString(str2);
            Parcel a2 = a(this.b.h(), p2);
            int readInt = a2.readInt();
            a2.recycle();
            return readInt;
        }

        @Override // io.bidmachine.analytics.internal.InterfaceC3583x
        public Bundle b(String str, String str2, Bundle bundle) {
            Parcel p2 = p();
            p2.writeInt(this.b.c());
            p2.writeString(str);
            p2.writeString(str2);
            p2.writeString(null);
            a(p2, bundle);
            Parcel a2 = a(this.b.g(), p2);
            Bundle bundle2 = (Bundle) a(a2, Bundle.CREATOR);
            a2.recycle();
            return bundle2;
        }

        public /* synthetic */ a(IBinder iBinder, b bVar, Function0 function0, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(iBinder, bVar, (i2 & 4) != 0 ? C0599a.f6789a : function0);
        }

        @Override // io.bidmachine.analytics.internal.InterfaceC3583x
        public Bundle a(String str, String str2, Bundle bundle) {
            Parcel p2 = p();
            p2.writeInt(this.b.a());
            p2.writeString(str);
            p2.writeString(str2);
            p2.writeString(null);
            a(p2, bundle);
            Parcel a2 = a(this.b.e(), p2);
            Bundle bundle2 = (Bundle) a(a2, Bundle.CREATOR);
            a2.recycle();
            return bundle2;
        }

        @Override // io.bidmachine.analytics.internal.InterfaceC3583x
        public Bundle a(String str, String str2, Bundle bundle, Bundle bundle2) {
            Parcel p2 = p();
            p2.writeInt(this.b.b());
            p2.writeString(str);
            p2.writeString(str2);
            a(p2, bundle);
            a(p2, bundle2);
            Parcel a2 = a(this.b.f(), p2);
            Bundle bundle3 = (Bundle) a(a2, Bundle.CREATOR);
            a2.recycle();
            return bundle3;
        }

        private final void a(Parcel parcel, Parcelable parcelable) {
            parcel.writeInt(1);
            parcelable.writeToParcel(parcel, 0);
        }

        public final Parcel a(int i2, Parcel parcel) {
            Parcel parcel2 = (Parcel) this.c.invoke();
            try {
                try {
                    this.f6788a.transact(i2, parcel, parcel2, 0);
                    parcel2.readException();
                    return parcel2;
                } catch (RuntimeException e2) {
                    parcel2.recycle();
                    throw e2;
                }
            } finally {
                parcel.recycle();
            }
        }

        private final Parcelable a(Parcel parcel, Parcelable.Creator creator) {
            if (parcel.readInt() == 0) {
                return null;
            }
            Object createFromParcel = creator.createFromParcel(parcel);
            Intrinsics.checkNotNull(createFromParcel, "null cannot be cast to non-null type android.os.Parcelable");
            return (Parcelable) createFromParcel;
        }
    }

    int a(String str, String str2);

    Bundle a(String str, String str2, Bundle bundle);

    Bundle a(String str, String str2, Bundle bundle, Bundle bundle2);

    Bundle b(String str, String str2, Bundle bundle);
}
