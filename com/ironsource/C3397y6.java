package com.ironsource;

import android.app.Activity;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.unity3d.mediation.LevelPlayAdInfo;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.y6, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3397y6 implements B6 {

    /* renamed from: a, reason: collision with root package name */
    private final C3363w6 f3948a;
    private final C3262q6 b;
    private C3262q6 c;
    private boolean d;

    public C3397y6(C3363w6 strategy, C3262q6 currentAdUnit, C3262q6 c3262q6, boolean z) {
        Intrinsics.checkNotNullParameter(strategy, "strategy");
        Intrinsics.checkNotNullParameter(currentAdUnit, "currentAdUnit");
        this.f3948a = strategy;
        this.b = currentAdUnit;
        this.c = c3262q6;
        this.d = z;
    }

    @Override // com.ironsource.B6
    public void a(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.f3948a.a(new A6(this.f3948a, this.b, this.c));
        this.b.a(activity, this.f3948a);
    }

    @Override // com.ironsource.B6
    public void b(C3262q6 adUnit, LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adUnit, "adUnit");
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        if (Intrinsics.areEqual(this.b, adUnit)) {
            this.f3948a.a("load success after current ad is loaded");
        }
    }

    @Override // com.ironsource.B6
    public void c(C3262q6 adUnit, LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adUnit, "adUnit");
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        if (Intrinsics.areEqual(adUnit, this.b)) {
            this.f3948a.d().onAdInfoChanged(adInfo);
        }
    }

    @Override // com.ironsource.B6
    public void loadAd() {
        Unit unit;
        if (this.d) {
            this.f3948a.a("load called while current ad is loaded");
            return;
        }
        this.d = true;
        LevelPlayAdInfo e = this.b.e();
        if (e != null) {
            this.f3948a.d().b(e);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            this.f3948a.a("current ad is loaded without ad info");
        } else if (this.c == null) {
            C3262q6 a2 = this.f3948a.b().a(false, this.f3948a.c());
            this.c = a2;
            a2.a(this.f3948a);
        }
    }

    @Override // com.ironsource.B6
    public void b(C3262q6 adUnit, IronSourceError ironSourceError) {
        Intrinsics.checkNotNullParameter(adUnit, "adUnit");
        if (Intrinsics.areEqual(adUnit, this.c)) {
            this.c = null;
        } else {
            this.f3948a.a("load failed after current ad is loaded");
        }
    }

    @Override // com.ironsource.B6
    public void a(C3262q6 adUnit, LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adUnit, "adUnit");
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        if (Intrinsics.areEqual(adUnit, this.b)) {
            this.f3948a.a("show success when loaded");
        } else {
            this.f3948a.a("progressive show success while current ad is loaded");
        }
    }

    public /* synthetic */ C3397y6(C3363w6 c3363w6, C3262q6 c3262q6, C3262q6 c3262q62, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(c3363w6, c3262q6, c3262q62, (i & 8) != 0 ? false : z);
    }

    @Override // com.ironsource.B6
    public void a(C3262q6 adUnit, IronSourceError ironSourceError) {
        Intrinsics.checkNotNullParameter(adUnit, "adUnit");
        if (Intrinsics.areEqual(adUnit, this.b)) {
            this.f3948a.a("show failed when loaded");
        } else {
            this.f3948a.a("progressive show failed while current ad is loaded");
        }
    }

    @Override // com.ironsource.B6
    public void a(C3262q6 adUnit) {
        Intrinsics.checkNotNullParameter(adUnit, "adUnit");
        if (Intrinsics.areEqual(adUnit, this.c)) {
            this.c = null;
        } else if (Intrinsics.areEqual(adUnit, this.b)) {
            a();
        }
    }

    private final void a() {
        B6 c3414z6;
        C3262q6 c3262q6 = this.c;
        if (c3262q6 == null) {
            C3363w6 c3363w6 = this.f3948a;
            c3363w6.a(new C3380x6(c3363w6));
        } else {
            if ((c3262q6 != null ? c3262q6.e() : null) != null) {
                C3363w6 c3363w62 = this.f3948a;
                C3262q6 c3262q62 = this.c;
                Intrinsics.checkNotNull(c3262q62);
                c3414z6 = new C3397y6(c3363w62, c3262q62, null, false, 8, null);
            } else {
                C3363w6 c3363w63 = this.f3948a;
                C3262q6 c3262q63 = this.c;
                Intrinsics.checkNotNull(c3262q63);
                c3414z6 = new C3414z6(c3363w63, c3262q63, false);
            }
            this.f3948a.a(c3414z6);
        }
        this.f3948a.d().a();
    }
}
