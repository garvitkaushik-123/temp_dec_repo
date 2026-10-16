package com.ironsource;

import android.content.Context;
import com.ironsource.C3118he;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.logger.IronSourceError;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.he, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3118he implements InterfaceC3200mc {

    /* renamed from: a, reason: collision with root package name */
    public static final C3118he f3342a = new C3118he();
    private static final C3168ke b = new C3168ke();

    /* renamed from: com.ironsource.he$a */
    public static final class a implements Yd {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Yd f3343a;

        a(Yd yd) {
            this.f3343a = yd;
        }

        @Override // com.ironsource.Yd
        public void a(final Sd sdkConfig) {
            Intrinsics.checkNotNullParameter(sdkConfig, "sdkConfig");
            C3168ke c3168ke = C3118he.b;
            final Yd yd = this.f3343a;
            c3168ke.a(new Runnable() { // from class: com.ironsource.he$a$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    C3118he.a.a(Sd.this, yd);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(Sd sdkConfig, Yd listener) {
            Intrinsics.checkNotNullParameter(sdkConfig, "$sdkConfig");
            Intrinsics.checkNotNullParameter(listener, "$listener");
            C3118he.f3342a.a(sdkConfig, listener);
        }

        @Override // com.ironsource.Yd
        public void a(final Ud error) {
            Intrinsics.checkNotNullParameter(error, "error");
            C3168ke c3168ke = C3118he.b;
            final Yd yd = this.f3343a;
            c3168ke.d(new Runnable() { // from class: com.ironsource.he$a$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    C3118he.a.a(Yd.this, error);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(Yd listener, Ud error) {
            Intrinsics.checkNotNullParameter(listener, "$listener");
            Intrinsics.checkNotNullParameter(error, "$error");
            listener.a(error);
        }
    }

    private C3118he() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Context context, C2996ae initRequest, Yd listener) {
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(initRequest, "$initRequest");
        Intrinsics.checkNotNullParameter(listener, "$listener");
        new J9().a(Zd.LEVEL_PLAY_INIT);
        f3342a.a(context, initRequest, listener, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(Context context, C2996ae initRequest, Yd listener) {
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(initRequest, "$initRequest");
        Intrinsics.checkNotNullParameter(listener, "$listener");
        com.ironsource.mediationsdk.p j = com.ironsource.mediationsdk.p.j();
        String d = initRequest.d();
        IronSource.AD_UNIT[] ad_unitArr = (IronSource.AD_UNIT[]) initRequest.e().toArray(new IronSource.AD_UNIT[0]);
        List<IronSource.AD_UNIT> validAdUnitsList = j.a(context, d, false, (IronSource.AD_UNIT[]) Arrays.copyOf(ad_unitArr, ad_unitArr.length));
        Intrinsics.checkNotNullExpressionValue(validAdUnitsList, "validAdUnitsList");
        initRequest.a(validAdUnitsList);
        new J9().a(Zd.EXTERNAL_MEDIATION_INIT);
        f3342a.a(context, initRequest, listener, true);
    }

    public final void c(final Context context, final C2996ae initRequest, final Yd listener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(initRequest, "initRequest");
        Intrinsics.checkNotNullParameter(listener, "listener");
        b.c(new Runnable() { // from class: com.ironsource.he$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                C3118he.d(context, initRequest, listener);
            }
        });
    }

    @Override // com.ironsource.InterfaceC3200mc
    public void onInitFailed(final IronSourceError error) {
        Intrinsics.checkNotNullParameter(error, "error");
        b.a(new Runnable() { // from class: com.ironsource.he$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                C3118he.a(IronSourceError.this);
            }
        });
    }

    public final void a(final Context context, final C2996ae initRequest, final Yd listener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(initRequest, "initRequest");
        Intrinsics.checkNotNullParameter(listener, "listener");
        b.c(new Runnable() { // from class: com.ironsource.he$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                C3118he.b(context, initRequest, listener);
            }
        });
    }

    private final void a(Context context, C2996ae c2996ae, final Yd yd, boolean z) {
        String f = c2996ae.f();
        if (f != null && f.length() > 0) {
            com.ironsource.mediationsdk.p.j().p(c2996ae.f());
        } else {
            c2996ae = new C2996ae(c2996ae.d(), com.ironsource.mediationsdk.p.j().l(), CollectionsKt.toMutableList((Collection) c2996ae.e()));
        }
        com.ironsource.mediationsdk.p j = com.ironsource.mediationsdk.p.j();
        String d = c2996ae.d();
        IronSource.AD_UNIT[] ad_unitArr = (IronSource.AD_UNIT[]) c2996ae.e().toArray(new IronSource.AD_UNIT[0]);
        final IronSourceError a2 = j.a(context, d, z, null, this, (IronSource.AD_UNIT[]) Arrays.copyOf(ad_unitArr, ad_unitArr.length));
        if (a2 != null && a2.getErrorCode() != 2020) {
            if (a2.getErrorCode() == 2040) {
                C3337ue e = com.ironsource.mediationsdk.p.j().e();
                if (e != null) {
                    a(new Sd(new C3013be(e)), yd);
                    return;
                }
            } else if (a2.getErrorCode() == 2030) {
                C3101ge.f3320a.e();
                return;
            }
            b.d(new Runnable() { // from class: com.ironsource.he$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    C3118he.a(Yd.this, a2);
                }
            });
            return;
        }
        C3101ge.f3320a.a(context, c2996ae, new a(yd));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(C3337ue serverResponse) {
        Intrinsics.checkNotNullParameter(serverResponse, "$serverResponse");
        C3101ge.f3320a.a(new C3013be(serverResponse));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Yd listener, IronSourceError error) {
        Intrinsics.checkNotNullParameter(listener, "$listener");
        Intrinsics.checkNotNullExpressionValue(error, "error");
        listener.a(new Ud(error));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(final Sd sd, final Yd yd) {
        if (!com.ironsource.mediationsdk.p.j().a(false, sd.d())) {
            b.d(new Runnable() { // from class: com.ironsource.he$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    C3118he.a(Yd.this);
                }
            });
        } else {
            b.d(new Runnable() { // from class: com.ironsource.he$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    C3118he.a(Yd.this, sd);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Yd listener) {
        Intrinsics.checkNotNullParameter(listener, "$listener");
        listener.a(new Ud(IronSourceError.ERROR_LEGACY_INIT_POST_FAILED, "An unknown error has occurred"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Yd listener, Sd sdkInitResponse) {
        Intrinsics.checkNotNullParameter(listener, "$listener");
        Intrinsics.checkNotNullParameter(sdkInitResponse, "$sdkInitResponse");
        listener.a(sdkInitResponse);
    }

    @Override // com.ironsource.InterfaceC3200mc
    public void a(final C3337ue serverResponse) {
        Intrinsics.checkNotNullParameter(serverResponse, "serverResponse");
        b.a(new Runnable() { // from class: com.ironsource.he$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                C3118he.b(C3337ue.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(IronSourceError error) {
        Intrinsics.checkNotNullParameter(error, "$error");
        C3101ge.f3320a.b(new Ud(error));
    }
}
