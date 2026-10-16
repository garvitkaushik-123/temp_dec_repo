package com.inmobi.media;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import com.inmobi.ads.AdMetaInfo;
import com.inmobi.ads.InMobiAdRequestStatus;
import com.inmobi.ads.WatermarkData;
import com.inmobi.ads.controllers.PublisherCallbacks;
import com.ironsource.C3066ed;
import com.ironsource.C3207n2;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import io.bidmachine.iab.vast.tags.VastAttributes;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0013\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\tH\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0017\u0010\u0003J1\u0010\r\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\t2\b\b\u0002\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\r\u0010\u001fJ\u0017\u0010 \u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b \u0010\bJ\r\u0010!\u001a\u00020\u0006¢\u0006\u0004\b!\u0010\u0003J\u0017\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0013\u0010\bJ\u000f\u0010\"\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\"\u0010\u0003J\u000f\u0010 \u001a\u00020\u0006H\u0016¢\u0006\u0004\b \u0010\u0003J\u0015\u0010\u0013\u001a\u00020\u00062\u0006\u0010$\u001a\u00020#¢\u0006\u0004\b\u0013\u0010%J\r\u0010&\u001a\u00020\u0006¢\u0006\u0004\b&\u0010\u0003J\u000f\u0010'\u001a\u00020\u0006H\u0016¢\u0006\u0004\b'\u0010\u0003J\u0017\u0010\r\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\bJ\u0017\u0010\r\u001a\u00020\u00062\u0006\u0010)\u001a\u00020(H\u0016¢\u0006\u0004\b\r\u0010*J\r\u0010+\u001a\u00020\u0006¢\u0006\u0004\b+\u0010\u0003R*\u00103\u001a\u0004\u0018\u00010,8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b-\u0010.\u0012\u0004\b2\u0010\u0003\u001a\u0004\b/\u00100\"\u0004\b\r\u00101R\u0016\u00106\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b7\u00108R\u0014\u0010:\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b9\u0010\u0016R\u0011\u0010<\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b;\u0010\u0016¨\u0006="}, d2 = {"Lcom/inmobi/media/o6;", "Lcom/inmobi/media/we;", "<init>", "()V", "Lcom/inmobi/ads/AdMetaInfo;", "info", "", "e", "(Lcom/inmobi/ads/AdMetaInfo;)V", "", "shouldResetPubState", "", IronSourceConstants.EVENTS_ERROR_CODE, "a", "(ZS)V", "Lcom/inmobi/media/S0;", "adUnit", "Lcom/inmobi/ads/InMobiAdRequestStatus;", "status", "c", "(Lcom/inmobi/media/S0;Lcom/inmobi/ads/InMobiAdRequestStatus;)V", VastAttributes.HORIZONTAL_POSITION, "()Z", VastAttributes.VERTICAL_POSITION, "Lcom/inmobi/media/Wa;", "pubSettings", "Landroid/content/Context;", "context", "sendLoadCalledTelemetry", "", "logType", "(Lcom/inmobi/media/Wa;Landroid/content/Context;ZLjava/lang/String;)V", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "D", "d", "Lcom/inmobi/ads/controllers/PublisherCallbacks;", "callbacks", "(Lcom/inmobi/ads/controllers/PublisherCallbacks;)V", "F", "g", "Lcom/inmobi/ads/WatermarkData;", "watermarkData", "(Lcom/inmobi/ads/WatermarkData;)V", ExifInterface.LONGITUDE_EAST, "Lcom/inmobi/media/m6;", "o", "Lcom/inmobi/media/m6;", "z", "()Lcom/inmobi/media/m6;", "(Lcom/inmobi/media/m6;)V", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "interstitialAdUnit", "p", "Z", "showRequested", com.mbridge.msdk.foundation.same.report.j.b, "()Lcom/inmobi/media/S0;", "C", "isInitialised", "B", "isAdInReadyState", "media_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* renamed from: com.inmobi.media.o6, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2792o6 extends AbstractC2929we {

    /* renamed from: o, reason: from kotlin metadata */
    private C2760m6 interstitialAdUnit;

    /* renamed from: p, reason: from kotlin metadata */
    private boolean showRequested;

    public static /* synthetic */ void A() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(C2792o6 this$0, AdMetaInfo info) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(info, "$info");
        InterfaceC2971z5 p = this$0.p();
        if (p != null) {
            ((A5) p).a("InterstitialUnifiedAdManager", "callback - onAdLoadSucceeded");
        }
        PublisherCallbacks l = this$0.l();
        if (l != null) {
            l.onAdLoadSucceeded(info);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(C2792o6 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        InterfaceC2971z5 p = this$0.p();
        if (p != null) {
            ((A5) p).a("InterstitialUnifiedAdManager", "callback - onAdDisplayFailed");
        }
        PublisherCallbacks l = this$0.l();
        if (l != null) {
            l.onAdDisplayFailed();
        }
        InterfaceC2971z5 p2 = this$0.p();
        if (p2 != null) {
            ((A5) p2).a();
        }
        this$0.y();
    }

    private final void e(final AdMetaInfo info) {
        InterfaceC2971z5 p = p();
        if (p != null) {
            ((A5) p).c("InterstitialUnifiedAdManager", C3066ed.f);
        }
        super.c(info);
        InterfaceC2971z5 p2 = p();
        if (p2 != null) {
            ((A5) p2).d("InterstitialUnifiedAdManager", "AdManager state - LOADED");
        }
        a((byte) 2);
        s().post(new Runnable() { // from class: com.inmobi.media.o6$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C2792o6.b(C2792o6.this, info);
            }
        });
    }

    private final boolean x() {
        byte q = q();
        if (q == 1) {
            InterfaceC2971z5 p = p();
            if (p != null) {
                ((A5) p).b("InMobi", "Ad Load is not complete. Please wait for the Ad to be in a ready state before calling show.");
            }
            AbstractC2680h7.a((byte) 1, "InMobi", "Ad Load is not complete. Please wait for the Ad to be in a ready state before calling show.");
            a(false, (short) 2147);
            return false;
        }
        if (q == 7) {
            AbstractC2680h7.a((byte) 1, "InMobi", "Ad Load is not complete. Please wait for the Ad to be in a ready state before calling show.");
            InterfaceC2971z5 p2 = p();
            if (p2 != null) {
                ((A5) p2).b("InMobi", "Ad Load is not complete. Please wait for the Ad to be in a ready state before calling show.");
            }
            a(false, (short) 2168);
            return false;
        }
        if (q != 5) {
            if (!this.showRequested) {
                return true;
            }
            C2760m6 c2760m6 = this.interstitialAdUnit;
            if (c2760m6 != null) {
                c2760m6.c((short) 2149);
            }
            AbstractC2680h7.a((byte) 1, "InMobi", AbstractC2929we.k);
            InterfaceC2971z5 p3 = p();
            if (p3 != null) {
                ((A5) p3).b("InMobi", AbstractC2929we.k);
            }
            return false;
        }
        if (this.interstitialAdUnit != null) {
            StringBuilder sb = new StringBuilder(AbstractC2929we.j);
            C2760m6 c2760m62 = this.interstitialAdUnit;
            AbstractC2680h7.a((byte) 1, "InMobi", sb.append(c2760m62 != null ? c2760m62.I() : null).toString());
            InterfaceC2971z5 p4 = p();
            if (p4 != null) {
                StringBuilder sb2 = new StringBuilder(AbstractC2929we.j);
                C2760m6 c2760m63 = this.interstitialAdUnit;
                ((A5) p4).b("InMobi", sb2.append(c2760m63 != null ? c2760m63.I() : null).toString());
            }
            a(false, (short) 2148);
        }
        return false;
    }

    private final void y() {
        C2760m6 c2760m6 = this.interstitialAdUnit;
        if (c2760m6 != null) {
            c2760m6.b((byte) 4);
        }
    }

    public final boolean B() {
        C2760m6 c2760m6 = this.interstitialAdUnit;
        if (c2760m6 != null && 2 == q()) {
            return c2760m6.H0();
        }
        return false;
    }

    public boolean C() {
        return this.interstitialAdUnit != null;
    }

    public final void D() throws IllegalStateException {
        S0 j;
        InterfaceC2971z5 p = p();
        if (p != null) {
            ((A5) p).a("InterstitialUnifiedAdManager", "render");
        }
        C2760m6 c2760m6 = this.interstitialAdUnit;
        if (c2760m6 == null) {
            throw new IllegalStateException(AbstractC2929we.m);
        }
        if (c2760m6.H0() && n() != null) {
            InterfaceC2971z5 p2 = p();
            if (p2 != null) {
                ((A5) p2).c("InterstitialUnifiedAdManager", "already in ready state");
            }
            AdMetaInfo n = n();
            Intrinsics.checkNotNull(n);
            e(n);
            return;
        }
        if (this.showRequested) {
            InterfaceC2971z5 p3 = p();
            if (p3 != null) {
                ((A5) p3).b("InMobi", AbstractC2929we.k);
            }
            AbstractC2680h7.a((byte) 1, "InMobi", AbstractC2929we.k);
            b(this.interstitialAdUnit, new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR));
            C2760m6 c2760m62 = this.interstitialAdUnit;
            if (c2760m62 != null) {
                c2760m62.b((short) 2128);
                return;
            }
            return;
        }
        C2760m6 c2760m63 = this.interstitialAdUnit;
        C2672h m = c2760m63 != null ? c2760m63.m() : null;
        C2760m6 c2760m64 = this.interstitialAdUnit;
        boolean a2 = a("InMobi", String.valueOf(c2760m64 != null ? c2760m64.I() : null));
        if (m == null) {
            InterfaceC2971z5 p4 = p();
            if (p4 != null) {
                ((A5) p4).b("InterstitialUnifiedAdManager", "ad is null. failure");
            }
            b(this.interstitialAdUnit, new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR));
            C2760m6 c2760m65 = this.interstitialAdUnit;
            if (c2760m65 != null) {
                c2760m65.a((short) 2166);
            }
        }
        if (n() == null) {
            InterfaceC2971z5 p5 = p();
            if (p5 != null) {
                ((A5) p5).b("InterstitialUnifiedAdManager", "ad meta info is null. failure");
            }
            b(this.interstitialAdUnit, new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR));
            C2760m6 c2760m66 = this.interstitialAdUnit;
            if (c2760m66 != null) {
                c2760m66.a((short) 2167);
            }
        }
        if (m == null || !a2) {
            return;
        }
        if (v() && (j = j()) != null) {
            j.e((byte) 1);
        }
        InterfaceC2971z5 p6 = p();
        if (p6 != null) {
            ((A5) p6).d("InterstitialUnifiedAdManager", "AdManager state - LOADING_INTO_VIEW");
        }
        a((byte) 8);
        C2760m6 c2760m67 = this.interstitialAdUnit;
        if (c2760m67 != null) {
            c2760m67.j0();
        }
    }

    public final void E() {
        C2760m6 c2760m6;
        Nd G0;
        C2760m6 c2760m62 = this.interstitialAdUnit;
        if ((c2760m62 == null || (G0 = c2760m62.G0()) == null || !G0.b) && (c2760m6 = this.interstitialAdUnit) != null) {
            c2760m6.K0();
        }
    }

    public final void F() {
        InterfaceC2971z5 p = p();
        if (p != null) {
            ((A5) p).a("InterstitialUnifiedAdManager", C3207n2.v);
        }
        C2760m6 c2760m6 = this.interstitialAdUnit;
        Nd G0 = c2760m6 != null ? c2760m6.G0() : null;
        if (G0 != null) {
            G0.b = true;
        }
        C2760m6 c2760m62 = this.interstitialAdUnit;
        if (c2760m62 != null) {
            c2760m62.w0();
        }
        if (x()) {
            if (!G4.f2291a.a()) {
                if (this.interstitialAdUnit != null) {
                    a(true, (short) 2141);
                    return;
                }
                return;
            }
            C2760m6 c2760m63 = this.interstitialAdUnit;
            if (c2760m63 == null || !c2760m63.e((byte) 4)) {
                return;
            }
            this.showRequested = true;
            C2760m6 c2760m64 = this.interstitialAdUnit;
            if (c2760m64 != null) {
                c2760m64.j(this);
            }
        }
    }

    public final void a(C2760m6 c2760m6) {
        this.interstitialAdUnit = c2760m6;
    }

    @Override // com.inmobi.media.F0
    public void d() {
        s().post(new Runnable() { // from class: com.inmobi.media.o6$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                C2792o6.b(C2792o6.this);
            }
        });
        InterfaceC2971z5 p = p();
        if (p != null) {
            ((A5) p).d("InterstitialUnifiedAdManager", "AdManager state - DISPLAY_FAILED");
        }
        a((byte) 6);
        C2760m6 c2760m6 = this.interstitialAdUnit;
        if (c2760m6 != null) {
            c2760m6.g();
        }
        InterfaceC2971z5 p2 = p();
        if (p2 != null) {
            ((A5) p2).a();
        }
    }

    @Override // com.inmobi.media.F0
    public void g() {
        InterfaceC2971z5 p = p();
        if (p != null) {
            ((A5) p).a("InterstitialUnifiedAdManager", "showTimeOut");
        }
        S0 j = j();
        if (j != null) {
            if (j.Q() == 6 || j.Q() == 7) {
                j.a(this);
            } else {
                a(true, (short) 2159);
            }
        }
    }

    @Override // com.inmobi.media.AbstractC2929we
    public S0 j() {
        return this.interstitialAdUnit;
    }

    /* renamed from: z, reason: from getter */
    public final C2760m6 getInterstitialAdUnit() {
        return this.interstitialAdUnit;
    }

    private final void a(boolean shouldResetPubState, short errorCode) {
        C2760m6 c2760m6;
        InterfaceC2971z5 p = p();
        if (p != null) {
            ((A5) p).c("InterstitialUnifiedAdManager", "onShowFailure");
        }
        if (errorCode != 0 && (c2760m6 = this.interstitialAdUnit) != null) {
            c2760m6.c(errorCode);
        }
        s().post(new Runnable() { // from class: com.inmobi.media.o6$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                C2792o6.c(C2792o6.this);
            }
        });
        if (shouldResetPubState) {
            InterfaceC2971z5 p2 = p();
            if (p2 != null) {
                ((A5) p2).d("InterstitialUnifiedAdManager", "AdManager state - FAILED");
            }
            a((byte) 6);
            C2760m6 c2760m62 = this.interstitialAdUnit;
            if (c2760m62 != null) {
                c2760m62.g();
            }
        }
        InterfaceC2971z5 p3 = p();
        if (p3 != null) {
            ((A5) p3).a();
        }
    }

    @Override // com.inmobi.media.AbstractC2929we, com.inmobi.media.F0
    public void b(final AdMetaInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        InterfaceC2971z5 p = p();
        if (p != null) {
            ((A5) p).c("InterstitialUnifiedAdManager", "onAdFetchSuccess");
        }
        d(info);
        if (this.interstitialAdUnit == null) {
            InterfaceC2971z5 p2 = p();
            if (p2 != null) {
                ((A5) p2).b("InterstitialUnifiedAdManager", "onAdFetchSuccess - adUnit is null - fail");
            }
            a((S0) null, new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR));
            a((short) 2190);
            return;
        }
        super.b(info);
        s().post(new Runnable() { // from class: com.inmobi.media.o6$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                C2792o6.a(C2792o6.this, info);
            }
        });
    }

    @Override // com.inmobi.media.AbstractC2929we, com.inmobi.media.F0
    public void c(AdMetaInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        InterfaceC2971z5 p = p();
        if (p != null) {
            ((A5) p).c("InterstitialUnifiedAdManager", "onAdLoadSucceeded");
        }
        if (this.interstitialAdUnit == null) {
            InterfaceC2971z5 p2 = p();
            if (p2 != null) {
                ((A5) p2).b("InterstitialUnifiedAdManager", "adUnit is null");
            }
            c(null, new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR));
            return;
        }
        e(info);
    }

    public final void c(PublisherCallbacks callbacks) {
        C2760m6 c2760m6;
        Intrinsics.checkNotNullParameter(callbacks, "callbacks");
        if (l() == null) {
            b(callbacks);
        }
        if (Intrinsics.areEqual(u(), Boolean.FALSE)) {
            C2760m6 c2760m62 = this.interstitialAdUnit;
            if (c2760m62 != null) {
                c2760m62.a((short) 2006);
            }
            callbacks.onAdLoadFailed(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.REPETITIVE_LOAD));
            InterfaceC2971z5 p = p();
            if (p != null) {
                ((A5) p).b("InMobi", "Cannot call load() API after calling load(byte[])");
            }
            AbstractC2680h7.a((byte) 1, "InMobi", "Cannot call load() API after calling load(byte[])");
            return;
        }
        if (this.showRequested) {
            C2760m6 c2760m63 = this.interstitialAdUnit;
            if (c2760m63 != null) {
                c2760m63.a((short) 2004);
            }
            callbacks.onAdLoadFailed(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR));
            InterfaceC2971z5 p2 = p();
            if (p2 != null) {
                ((A5) p2).b("InMobi", AbstractC2929we.k);
            }
            AbstractC2680h7.a((byte) 1, "InMobi", AbstractC2929we.k);
            return;
        }
        a(Boolean.TRUE);
        C2760m6 c2760m64 = this.interstitialAdUnit;
        if (c2760m64 == null || !a("InMobi", String.valueOf(c2760m64.I()), callbacks) || (c2760m6 = this.interstitialAdUnit) == null || !c2760m6.e(o())) {
            return;
        }
        a((byte) 1);
        InterfaceC2971z5 p3 = p();
        if (p3 != null) {
            StringBuilder sb = new StringBuilder("Fetching an Interstitial ad for placement id: ");
            C2760m6 c2760m65 = this.interstitialAdUnit;
            ((A5) p3).c("InterstitialUnifiedAdManager", sb.append(c2760m65 != null ? c2760m65.I() : null).toString());
        }
        StringBuilder sb2 = new StringBuilder("Fetching an Interstitial ad for placement id: ");
        C2760m6 c2760m66 = this.interstitialAdUnit;
        AbstractC2680h7.a((byte) 2, "InterstitialUnifiedAdManager", sb2.append(c2760m66 != null ? c2760m66.I() : null).toString());
        C2760m6 c2760m67 = this.interstitialAdUnit;
        if (c2760m67 != null) {
            c2760m67.g(this);
        }
        C2760m6 c2760m68 = this.interstitialAdUnit;
        if (c2760m68 != null) {
            c2760m68.c0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(C2792o6 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        InterfaceC2971z5 p = this$0.p();
        if (p != null) {
            ((A5) p).a("InterstitialUnifiedAdManager", "callback - onAdDisplayFailed");
        }
        PublisherCallbacks l = this$0.l();
        if (l != null) {
            l.onAdDisplayFailed();
        }
        this$0.y();
    }

    @Override // com.inmobi.media.AbstractC2929we, com.inmobi.media.F0
    public void b() {
        s().post(new Runnable() { // from class: com.inmobi.media.o6$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                C2792o6.a(C2792o6.this);
            }
        });
        InterfaceC2971z5 p = p();
        if (p != null) {
            ((A5) p).d("InterstitialUnifiedAdManager", "AdManager state - CREATED");
        }
        a((byte) 0);
        a((Boolean) null);
        C2760m6 c2760m6 = this.interstitialAdUnit;
        if (c2760m6 != null) {
            c2760m6.g();
        }
        InterfaceC2971z5 p2 = p();
        if (p2 != null) {
            ((A5) p2).a();
        }
    }

    public static /* synthetic */ void a(C2792o6 c2792o6, Wa wa, Context context, boolean z, String str, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            str = "intHtml";
        }
        c2792o6.a(wa, context, z, str);
    }

    public final void a(Wa pubSettings, Context context, boolean sendLoadCalledTelemetry, String logType) {
        C2760m6 c2760m6;
        C2760m6 c2760m62;
        Intrinsics.checkNotNullParameter(pubSettings, "pubSettings");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(logType, "logType");
        if (this.interstitialAdUnit == null) {
            this.interstitialAdUnit = new C2760m6(context, new X("int").a(pubSettings.f2471a).c(pubSettings.b).a(pubSettings.c).e(pubSettings.e).b(pubSettings.f).a(), this);
        }
        if (sendLoadCalledTelemetry) {
            w();
        }
        String str = pubSettings.e;
        if (str != null) {
            InterfaceC2971z5 p = p();
            if (p != null) {
                ((A5) p).a();
            }
            EnumC2560a7 enumC2560a7 = Cb.f2253a;
            a(Cb.a(logType, str, false));
            InterfaceC2971z5 p2 = p();
            if (p2 != null) {
                ((A5) p2).a("InterstitialUnifiedAdManager", "Ad Unit initialised");
            }
            InterfaceC2971z5 p3 = p();
            if (p3 != null && (c2760m62 = this.interstitialAdUnit) != null) {
                c2760m62.a(p3);
            }
            InterfaceC2971z5 p4 = p();
            if (p4 != null) {
                ((A5) p4).a("InterstitialUnifiedAdManager", "adding interstitialAdUnit in referenceTracker");
            }
            C2760m6 c2760m63 = this.interstitialAdUnit;
            Intrinsics.checkNotNull(c2760m63);
            Cb.a(c2760m63, p());
        }
        C2760m6 c2760m64 = this.interstitialAdUnit;
        if (c2760m64 != null) {
            c2760m64.a(context);
        }
        C2760m6 c2760m65 = this.interstitialAdUnit;
        if (c2760m65 != null) {
            c2760m65.a(pubSettings.c);
        }
        C2760m6 c2760m66 = this.interstitialAdUnit;
        if (c2760m66 != null) {
            c2760m66.c("activity");
        }
        if (pubSettings.d && (c2760m6 = this.interstitialAdUnit) != null) {
            c2760m6.F0();
        }
        WatermarkData t = t();
        if (t != null) {
            C2760m6 c2760m67 = this.interstitialAdUnit;
            if (c2760m67 != null) {
                c2760m67.a(t);
            }
            InterfaceC2971z5 p5 = p();
            if (p5 != null) {
                ((A5) p5).c("InterstitialUnifiedAdManager", "setting up watermark");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(C2792o6 this$0, AdMetaInfo info) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(info, "$info");
        InterfaceC2971z5 p = this$0.p();
        if (p != null) {
            ((A5) p).a("InterstitialUnifiedAdManager", "callback - onAdFetchSuccessful");
        }
        PublisherCallbacks l = this$0.l();
        if (l != null) {
            l.onAdFetchSuccessful(info);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(C2792o6 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        InterfaceC2971z5 p = this$0.p();
        if (p != null) {
            ((A5) p).a("InterstitialUnifiedAdManager", "callback - onAdDismissed");
        }
        PublisherCallbacks l = this$0.l();
        if (l != null) {
            l.onAdDismissed();
        }
    }

    @Override // com.inmobi.media.AbstractC2929we, com.inmobi.media.F0
    public void a(AdMetaInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        super.a(info);
        S0 j = j();
        if (j != null) {
            j.x0();
        }
        this.showRequested = false;
    }

    private final void c(S0 adUnit, InMobiAdRequestStatus status) {
        byte q = q();
        if (q == 8 || q == 1) {
            b(adUnit, status);
            return;
        }
        if (q == 2) {
            AbstractC2680h7.a((byte) 1, "InMobi", "Unable to Show Ad, canShowAd Failed");
            InterfaceC2971z5 p = p();
            if (p != null) {
                ((A5) p).b("InMobi", "Unable to Show Ad, canShowAd Failed");
            }
            a(true, (short) 0);
            return;
        }
        if (q == 5) {
            AbstractC2680h7.a((byte) 1, "InMobi", "Ad will be dismissed, Internal error");
            InterfaceC2971z5 p2 = p();
            if (p2 != null) {
                ((A5) p2).b("InMobi", "Ad will be dismissed, Internal error");
            }
            y();
            b();
            return;
        }
        AbstractC2680h7.a((byte) 1, "InMobi", "Invalid state passed in fireErrorScenarioCallback");
        InterfaceC2971z5 p3 = p();
        if (p3 != null) {
            ((A5) p3).b("InMobi", "Invalid state passed in fireErrorScenarioCallback");
        }
    }

    @Override // com.inmobi.media.AbstractC2929we
    public void a(WatermarkData watermarkData) {
        Intrinsics.checkNotNullParameter(watermarkData, "watermarkData");
        super.a(watermarkData);
        C2760m6 c2760m6 = this.interstitialAdUnit;
        if (c2760m6 != null) {
            c2760m6.a(watermarkData);
        }
    }
}
