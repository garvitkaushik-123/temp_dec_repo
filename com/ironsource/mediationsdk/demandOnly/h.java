package com.ironsource.mediationsdk.demandOnly;

import android.app.Activity;
import com.ironsource.InterfaceC3136j;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.demandOnly.q;
import com.ironsource.mediationsdk.logger.IronSourceError;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public interface h extends q {

    public static abstract class a implements h {

        /* renamed from: a, reason: collision with root package name */
        private final String f3519a;
        private final String b;
        private final boolean c;

        public a(String str, String str2, boolean z) {
            this.f3519a = str;
            this.b = str2;
            this.c = z;
        }

        @Override // com.ironsource.mediationsdk.demandOnly.q
        public abstract IronSourceError a();

        @Override // com.ironsource.mediationsdk.demandOnly.h
        public String b() {
            return this.b;
        }

        @Override // com.ironsource.mediationsdk.demandOnly.h
        public boolean c() {
            return this.c;
        }

        @Override // com.ironsource.mediationsdk.demandOnly.h
        public String e() {
            return this.f3519a;
        }
    }

    public static final class b extends a {
        private final String d;
        private final Activity e;
        private final ISDemandOnlyBannerLayout f;

        public /* synthetic */ b(String str, Activity activity, String str2, ISDemandOnlyBannerLayout iSDemandOnlyBannerLayout, String str3, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, activity, str2, iSDemandOnlyBannerLayout, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? false : z);
        }

        @Override // com.ironsource.mediationsdk.demandOnly.h.a, com.ironsource.mediationsdk.demandOnly.q
        public IronSourceError a() {
            IronSourceError a2 = new q.a(this.d).a(this);
            if (a2 != null) {
                return a2;
            }
            return null;
        }

        public final Activity f() {
            return this.e;
        }

        public final ISDemandOnlyBannerLayout g() {
            return this.f;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String adFormat, Activity activity, String str, ISDemandOnlyBannerLayout iSDemandOnlyBannerLayout, String str2, boolean z) {
            super(str, str2, z);
            Intrinsics.checkNotNullParameter(adFormat, "adFormat");
            this.d = adFormat;
            this.e = activity;
            this.f = iSDemandOnlyBannerLayout;
        }
    }

    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        private String f3520a = "";
        private Activity b;
        private String c;
        private boolean d;
        private String e;
        private ISDemandOnlyBannerLayout f;

        public final c a(IronSource.AD_UNIT adFormat) {
            Intrinsics.checkNotNullParameter(adFormat, "adFormat");
            String ad_unit = adFormat.toString();
            Intrinsics.checkNotNullExpressionValue(ad_unit, "adFormat.toString()");
            this.f3520a = ad_unit;
            return this;
        }

        public final c b(String str) {
            this.c = str;
            return this;
        }

        public final c a(Activity activity) {
            this.b = activity;
            return this;
        }

        public final d b() {
            return new d(this.f3520a, this.b, this.c, this.e, this.d);
        }

        public final c a(Activity activity, Activity activity2) {
            if (activity == null) {
                activity = activity2;
            }
            this.b = activity;
            return this;
        }

        public final c a(boolean z) {
            this.d = z;
            return this;
        }

        public final c a(String str) {
            this.e = str;
            return this;
        }

        public final c a(ISDemandOnlyBannerLayout iSDemandOnlyBannerLayout) {
            this.f = iSDemandOnlyBannerLayout;
            return this;
        }

        public final b a() {
            return new b(this.f3520a, this.b, this.c, this.f, this.e, this.d);
        }
    }

    public static final class d extends a implements InterfaceC3136j {
        private final String d;
        private final Activity e;

        public /* synthetic */ d(String str, Activity activity, String str2, String str3, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, activity, str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? false : z);
        }

        @Override // com.ironsource.mediationsdk.demandOnly.h.a, com.ironsource.mediationsdk.demandOnly.q
        public IronSourceError a() {
            IronSourceError a2 = new q.b(this.d).a(this);
            if (a2 != null) {
                return a2;
            }
            return null;
        }

        @Override // com.ironsource.InterfaceC3136j
        public Activity d() {
            return this.e;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(String adFormat, Activity activity, String str, String str2, boolean z) {
            super(str, str2, z);
            Intrinsics.checkNotNullParameter(adFormat, "adFormat");
            this.d = adFormat;
            this.e = activity;
        }
    }

    String b();

    boolean c();

    String e();
}
