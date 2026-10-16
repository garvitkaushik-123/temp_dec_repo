package com.moloco.sdk.internal;

import androidx.recyclerview.widget.ItemTouchHelper;
import com.vungle.ads.internal.protos.Sdk;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes6.dex */
public abstract class i {
    public static final int c = 0;

    /* renamed from: a, reason: collision with root package name */
    public final int f5401a;
    public final int b;

    public static final class a extends i {
        public static final int f = 0;
        public final int d;
        public final int e;

        public a(int i, int i2) {
            super(i, i2, null);
            this.d = i;
            this.e = i2;
        }

        public final a a(int i, int i2) {
            return new a(i, i2);
        }

        @Override // com.moloco.sdk.internal.i
        public int b() {
            return this.d;
        }

        public final int c() {
            return this.d;
        }

        public final int d() {
            return this.e;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.d == aVar.d && this.e == aVar.e;
        }

        public int hashCode() {
            return (Integer.hashCode(this.d) * 31) + Integer.hashCode(this.e);
        }

        public String toString() {
            return "Custom(wDp=" + this.d + ", hDp=" + this.e + ')';
        }

        public static /* synthetic */ a a(a aVar, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = aVar.d;
            }
            if ((i3 & 2) != 0) {
                i2 = aVar.e;
            }
            return aVar.a(i, i2);
        }

        @Override // com.moloco.sdk.internal.i
        public int a() {
            return this.e;
        }
    }

    public static final class b extends i {
        public static final b d = new b();
        public static final int e = 0;

        public b() {
            super(300, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, null);
        }
    }

    public static final class c extends i {
        public static final c d = new c();
        public static final int e = 0;

        public c() {
            super(Sdk.SDKError.Reason.WEBVIEW_ERROR_VALUE, 50, null);
        }
    }

    public static final class d extends i {
        public static final d d = new d();
        public static final int e = 0;

        public d() {
            super(728, 90, null);
        }
    }

    public /* synthetic */ i(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2);
    }

    public int a() {
        return this.b;
    }

    public int b() {
        return this.f5401a;
    }

    public i(int i, int i2) {
        this.f5401a = i;
        this.b = i2;
    }
}
