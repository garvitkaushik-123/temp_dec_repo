package com.ironsource;

import android.view.View;
import com.ironsource.A8;
import com.ironsource.C3040d4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public final class E8 {

    /* renamed from: a, reason: collision with root package name */
    private A8 f2842a;
    private View b;
    private View c;
    private View d;
    private View e;
    private View f;
    private View g;
    private View h;
    private a i;

    public interface a {
        void a(b bVar);

        void a(ag agVar);
    }

    public enum b {
        Title("title"),
        Advertiser(C3040d4.h.F0),
        Body("body"),
        Cta("cta"),
        Icon("icon"),
        Container("container"),
        PrivacyIcon(C3040d4.h.J0);


        /* renamed from: a, reason: collision with root package name */
        private final String f2843a;

        b(String str) {
            this.f2843a = str;
        }

        public final String b() {
            return this.f2843a;
        }
    }

    public static final class c implements A8.a {
        c() {
        }

        @Override // com.ironsource.A8.a
        public void a(ag viewVisibilityParams) {
            Intrinsics.checkNotNullParameter(viewVisibilityParams, "viewVisibilityParams");
            a n = E8.this.n();
            if (n != null) {
                n.a(viewVisibilityParams);
            }
        }
    }

    public E8(A8 containerView, View view, View view2, View view3, View view4, View view5, View view6, View privacyIconView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        Intrinsics.checkNotNullParameter(privacyIconView, "privacyIconView");
        this.f2842a = containerView;
        this.b = view;
        this.c = view2;
        this.d = view3;
        this.e = view4;
        this.f = view5;
        this.g = view6;
        this.h = privacyIconView;
        r();
        s();
    }

    private final void r() {
        a(this, this.b, b.Title);
        a(this, this.c, b.Advertiser);
        a(this, this.e, b.Body);
        a(this, this.g, b.Cta);
        a(this, this.d, b.Icon);
        a(this, this.f2842a, b.Container);
        a(this, this.h, b.PrivacyIcon);
    }

    private final void s() {
        this.f2842a.setListener$mediationsdk_release(new c());
    }

    public final A8 a() {
        return this.f2842a;
    }

    public final View b() {
        return this.b;
    }

    public final View c() {
        return this.c;
    }

    public final View d() {
        return this.d;
    }

    public final View e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof E8)) {
            return false;
        }
        E8 e8 = (E8) obj;
        return Intrinsics.areEqual(this.f2842a, e8.f2842a) && Intrinsics.areEqual(this.b, e8.b) && Intrinsics.areEqual(this.c, e8.c) && Intrinsics.areEqual(this.d, e8.d) && Intrinsics.areEqual(this.e, e8.e) && Intrinsics.areEqual(this.f, e8.f) && Intrinsics.areEqual(this.g, e8.g) && Intrinsics.areEqual(this.h, e8.h);
    }

    public final View f() {
        return this.f;
    }

    public final View g() {
        return this.g;
    }

    public final View h() {
        return this.h;
    }

    public int hashCode() {
        int hashCode = this.f2842a.hashCode() * 31;
        View view = this.b;
        int hashCode2 = (hashCode + (view == null ? 0 : view.hashCode())) * 31;
        View view2 = this.c;
        int hashCode3 = (hashCode2 + (view2 == null ? 0 : view2.hashCode())) * 31;
        View view3 = this.d;
        int hashCode4 = (hashCode3 + (view3 == null ? 0 : view3.hashCode())) * 31;
        View view4 = this.e;
        int hashCode5 = (hashCode4 + (view4 == null ? 0 : view4.hashCode())) * 31;
        View view5 = this.f;
        int hashCode6 = (hashCode5 + (view5 == null ? 0 : view5.hashCode())) * 31;
        View view6 = this.g;
        return ((hashCode6 + (view6 != null ? view6.hashCode() : 0)) * 31) + this.h.hashCode();
    }

    public final View i() {
        return this.c;
    }

    public final View j() {
        return this.e;
    }

    public final A8 k() {
        return this.f2842a;
    }

    public final View l() {
        return this.g;
    }

    public final View m() {
        return this.d;
    }

    public final a n() {
        return this.i;
    }

    public final View o() {
        return this.f;
    }

    public final View p() {
        return this.h;
    }

    public final View q() {
        return this.b;
    }

    public final JSONObject t() {
        JSONObject put = new JSONObject().put("title", this.b != null).put(C3040d4.h.F0, this.c != null).put("body", this.e != null).put("cta", this.g != null).put("media", this.f != null).put("icon", this.d != null);
        Intrinsics.checkNotNullExpressionValue(put, "JSONObject()\n        .pu…\"icon\", iconView != null)");
        return put;
    }

    public String toString() {
        return "ISNNativeAdViewHolder(containerView=" + this.f2842a + ", titleView=" + this.b + ", advertiserView=" + this.c + ", iconView=" + this.d + ", bodyView=" + this.e + ", mediaView=" + this.f + ", ctaView=" + this.g + ", privacyIconView=" + this.h + ")";
    }

    public final E8 a(A8 containerView, View view, View view2, View view3, View view4, View view5, View view6, View privacyIconView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        Intrinsics.checkNotNullParameter(privacyIconView, "privacyIconView");
        return new E8(containerView, view, view2, view3, view4, view5, view6, privacyIconView);
    }

    public final void b(View view) {
        this.e = view;
    }

    public final void c(View view) {
        this.g = view;
    }

    public final void d(View view) {
        this.d = view;
    }

    public final void e(View view) {
        this.f = view;
    }

    public final void f(View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.h = view;
    }

    public final void g(View view) {
        this.b = view;
    }

    public static /* synthetic */ E8 a(E8 e8, A8 a8, View view, View view2, View view3, View view4, View view5, View view6, View view7, int i, Object obj) {
        if ((i & 1) != 0) {
            a8 = e8.f2842a;
        }
        if ((i & 2) != 0) {
            view = e8.b;
        }
        if ((i & 4) != 0) {
            view2 = e8.c;
        }
        if ((i & 8) != 0) {
            view3 = e8.d;
        }
        if ((i & 16) != 0) {
            view4 = e8.e;
        }
        if ((i & 32) != 0) {
            view5 = e8.f;
        }
        if ((i & 64) != 0) {
            view6 = e8.g;
        }
        if ((i & 128) != 0) {
            view7 = e8.h;
        }
        View view8 = view6;
        View view9 = view7;
        View view10 = view4;
        View view11 = view5;
        return e8.a(a8, view, view2, view3, view10, view11, view8, view9);
    }

    public final void a(A8 a8) {
        Intrinsics.checkNotNullParameter(a8, "<set-?>");
        this.f2842a = a8;
    }

    public final void a(View view) {
        this.c = view;
    }

    public final void a(a aVar) {
        this.i = aVar;
    }

    private static final void a(final E8 e8, View view, final b bVar) {
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.ironsource.E8$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    E8.a(E8.this, bVar, view2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(E8 this$0, b viewName, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(viewName, "$viewName");
        a aVar = this$0.i;
        if (aVar != null) {
            aVar.a(viewName);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ E8(A8 a8, View view, View view2, View view3, View view4, View view5, View view6, View view7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(a8, view, view2, view3, view4, view5, r9, r10);
        View view8;
        View view9;
        view = (i & 2) != 0 ? null : view;
        view2 = (i & 4) != 0 ? null : view2;
        view3 = (i & 8) != 0 ? null : view3;
        view4 = (i & 16) != 0 ? null : view4;
        view5 = (i & 32) != 0 ? null : view5;
        if ((i & 64) != 0) {
            view8 = view7;
            view9 = null;
        } else {
            view8 = view7;
            view9 = view6;
        }
    }
}
