package com.inmobi.media;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.ads.RequestConfiguration;
import com.inmobi.ads.AdMetaInfo;
import com.inmobi.ads.InMobiAdRequestStatus;
import com.inmobi.ads.InMobiBanner;
import com.inmobi.ads.WatermarkData;
import com.inmobi.ads.controllers.PublisherCallbacks;
import com.inmobi.commons.core.configs.AdConfig;
import com.ironsource.C3040d4;
import com.ironsource.C3337ue;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import io.bidmachine.iab.vast.tags.VastAttributes;
import io.bidmachine.iab.vast.tags.VastTagName;
import io.ktor.http.LinkHeader;
import java.util.HashMap;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\n\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0012\u0010\u0011J\r\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0010\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0010\u0010\u0003J)\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0017¢\u0006\u0004\b\f\u0010\u001bJ\r\u0010\u001c\u001a\u00020\u0013¢\u0006\u0004\b\u001c\u0010\u0015J'\u0010\f\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u0013H\u0007¢\u0006\u0004\b\f\u0010 J\r\u0010!\u001a\u00020\u000b¢\u0006\u0004\b!\u0010\u0003J!\u0010\f\u001a\u00020\u000b2\b\u0010#\u001a\u0004\u0018\u00010\"2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\f\u0010$J\r\u0010%\u001a\u00020\u000b¢\u0006\u0004\b%\u0010\u0003J\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020&¢\u0006\u0004\b\f\u0010(J\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020)H\u0016¢\u0006\u0004\b\f\u0010+J\r\u0010,\u001a\u00020\u000b¢\u0006\u0004\b,\u0010\u0003J\r\u0010-\u001a\u00020\u000b¢\u0006\u0004\b-\u0010\u0003J\u001d\u0010\f\u001a\u00020\u00162\u0006\u0010.\u001a\u00020\u00162\u0006\u0010/\u001a\u00020\u0016¢\u0006\u0004\b\f\u00100J\u0015\u0010\f\u001a\u00020\u00132\u0006\u00102\u001a\u000201¢\u0006\u0004\b\f\u00103J\r\u00104\u001a\u00020\u000b¢\u0006\u0004\b4\u0010\u0003J\r\u00105\u001a\u00020\u0013¢\u0006\u0004\b5\u0010\u0015J\r\u00106\u001a\u00020\u000b¢\u0006\u0004\b6\u0010\u0003J\r\u00107\u001a\u00020\u000b¢\u0006\u0004\b7\u0010\u0003J\u0015\u0010\u0010\u001a\u00020\u000b2\u0006\u00109\u001a\u000208¢\u0006\u0004\b\u0010\u0010:J\u000f\u0010;\u001a\u00020\u0013H\u0002¢\u0006\u0004\b;\u0010\u0015J\u0017\u0010\u0010\u001a\u00020\u000b2\u0006\u0010<\u001a\u00020&H\u0002¢\u0006\u0004\b\u0010\u0010(J\u000f\u0010=\u001a\u00020\u000bH\u0002¢\u0006\u0004\b=\u0010\u0003R\u0014\u0010@\u001a\u00020\b8\u0002X\u0082D¢\u0006\u0006\n\u0004\b>\u0010?R\u001c\u0010C\u001a\n A*\u0004\u0018\u00010\b0\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010?R\u0018\u0010G\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u0018\u0010I\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010FR\u0018\u0010K\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010FR\u0018\u0010M\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010FR\u0016\u0010Q\u001a\u0004\u0018\u00010N8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bO\u0010PR\u0014\u0010S\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bR\u0010\u0015R\u0011\u0010V\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\bT\u0010UR\u0011\u0010X\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\bW\u0010\u0015¨\u0006Y"}, d2 = {"Lcom/inmobi/media/R1;", "Lcom/inmobi/media/we;", "<init>", "()V", "Landroid/content/Context;", "context", "Lcom/inmobi/media/Wa;", "pubSettings", "", C3040d4.h.O, "logType", "", "a", "(Landroid/content/Context;Lcom/inmobi/media/Wa;Ljava/lang/String;Ljava/lang/String;)V", "Lcom/inmobi/ads/AdMetaInfo;", "info", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "(Lcom/inmobi/ads/AdMetaInfo;)V", "c", "", "C", "()Z", "", LinkHeader.Rel.Next, "callerIndex", "Lcom/inmobi/media/ec;", "renderView", "(IILcom/inmobi/media/ec;)V", VastAttributes.VERTICAL_POSITION, "Lcom/inmobi/ads/controllers/PublisherCallbacks;", "callbacks", "isRefreshRequest", "(Lcom/inmobi/ads/controllers/PublisherCallbacks;Ljava/lang/String;Z)V", RequestConfiguration.MAX_AD_CONTENT_RATING_G, "", C3337ue.n, "([BLcom/inmobi/ads/controllers/PublisherCallbacks;)V", "K", "Landroid/widget/RelativeLayout;", "banner", "(Landroid/widget/RelativeLayout;)V", "Lcom/inmobi/ads/WatermarkData;", "watermarkData", "(Lcom/inmobi/ads/WatermarkData;)V", "H", ExifInterface.LONGITUDE_EAST, "_refreshInterval", "previousInterval", "(II)I", "", "adLoadCalledTimestamp", "(J)Z", "L", VastAttributes.HORIZONTAL_POSITION, "F", "z", "", IronSourceConstants.EVENTS_ERROR_CODE, "(S)V", "I", "inMobiBanner", "J", "o", "Ljava/lang/String;", "DEBUG_LOG_TAG", "kotlin.jvm.PlatformType", "p", "TAG", "Lcom/inmobi/media/M1;", CampaignEx.JSON_KEY_AD_Q, "Lcom/inmobi/media/M1;", "mBannerAdUnit1", "r", "mBannerAdUnit2", "s", "mForegroundBannerAdUnit", "t", "mBackgroundBannerAdUnit", "Lcom/inmobi/media/S0;", com.mbridge.msdk.foundation.same.report.j.b, "()Lcom/inmobi/media/S0;", "adUnit", "D", "isInitialised", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()I", "defaultRefreshInterval", "B", "isActive", "media_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class R1 extends AbstractC2929we {

    /* renamed from: o, reason: from kotlin metadata */
    private final String DEBUG_LOG_TAG = "InMobi";

    /* renamed from: p, reason: from kotlin metadata */
    private final String TAG = VastTagName.R1;

    /* renamed from: q, reason: from kotlin metadata */
    private M1 mBannerAdUnit1;

    /* renamed from: r, reason: from kotlin metadata */
    private M1 mBannerAdUnit2;

    /* renamed from: s, reason: from kotlin metadata */
    private M1 mForegroundBannerAdUnit;

    /* renamed from: t, reason: from kotlin metadata */
    private M1 mBackgroundBannerAdUnit;

    private final boolean I() {
        M1 m1 = this.mForegroundBannerAdUnit;
        Byte valueOf = m1 != null ? Byte.valueOf(m1.Q()) : null;
        InterfaceC2971z5 p = p();
        if (p != null) {
            String TAG = this.TAG;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) p).c(TAG, "shouldUseForegroundUnit " + this + " state - " + valueOf);
        }
        if (valueOf != null && valueOf.byteValue() == 4) {
            return true;
        }
        if (valueOf == null || valueOf.byteValue() != 7) {
            return valueOf != null && valueOf.byteValue() == 6;
        }
        return true;
    }

    private final void J() {
        InterfaceC2971z5 p = p();
        if (p != null) {
            String str = this.TAG;
            ((A5) p).c(str, Q1.a(str, "TAG", "submitAdShowFail ", this));
        }
        S0 j = j();
        if (j != null) {
            j.c((short) 2239);
        }
    }

    public final int A() {
        AdConfig j;
        InterfaceC2971z5 p = p();
        if (p != null) {
            String str = this.TAG;
            ((A5) p).c(str, Q1.a(str, "TAG", "defaultRefreshInterval ", this));
        }
        S0 j2 = j();
        if (j2 == null || (j = j2.j()) == null) {
            return -1;
        }
        return j.getDefaultRefreshInterval();
    }

    public final boolean B() {
        String TAG = this.TAG;
        Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
        Intrinsics.areEqual(this.mForegroundBannerAdUnit, this.mBannerAdUnit1);
        String TAG2 = this.TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        Intrinsics.areEqual(this.mBackgroundBannerAdUnit, this.mBannerAdUnit1);
        String TAG3 = this.TAG;
        Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
        Intrinsics.areEqual(this.mForegroundBannerAdUnit, this.mBannerAdUnit2);
        String TAG4 = this.TAG;
        Intrinsics.checkNotNullExpressionValue(TAG4, "TAG");
        Intrinsics.areEqual(this.mBackgroundBannerAdUnit, this.mBannerAdUnit2);
        String TAG5 = this.TAG;
        Intrinsics.checkNotNullExpressionValue(TAG5, "TAG");
        M1 m1 = this.mBannerAdUnit1;
        if (m1 != null) {
            m1.E0();
        }
        M1 m12 = this.mBannerAdUnit1;
        if (m12 != null) {
            m12.Q();
        }
        Objects.toString(this.mBannerAdUnit1);
        String TAG6 = this.TAG;
        Intrinsics.checkNotNullExpressionValue(TAG6, "TAG");
        M1 m13 = this.mBannerAdUnit2;
        if (m13 != null) {
            m13.E0();
        }
        M1 m14 = this.mBannerAdUnit2;
        if (m14 != null) {
            m14.Q();
        }
        Objects.toString(this.mBannerAdUnit2);
        M1 m15 = this.mForegroundBannerAdUnit;
        if (m15 != null) {
            return m15.E0();
        }
        return false;
    }

    public final boolean C() {
        C2672h m;
        M1 m1 = this.mForegroundBannerAdUnit;
        if (m1 == null || (m = m1.m()) == null) {
            return false;
        }
        return Intrinsics.areEqual(m.p(), "audio");
    }

    public boolean D() {
        return (this.mBannerAdUnit1 == null || this.mBannerAdUnit2 == null) ? false : true;
    }

    public final void E() {
        InterfaceC2971z5 p = p();
        if (p != null) {
            String str = this.TAG;
            ((A5) p).a(str, Q1.a(str, "TAG", "pause ", this));
        }
        M1 m1 = this.mForegroundBannerAdUnit;
        if (m1 != null) {
            m1.F0();
        }
    }

    public final void F() {
        InterfaceC2971z5 p = p();
        if (p != null) {
            String str = this.TAG;
            ((A5) p).c(str, Q1.a(str, "TAG", "registerLifeCycleCallbacks ", this));
        }
        M1 m1 = this.mBannerAdUnit1;
        if (m1 != null) {
            m1.H0();
        }
        M1 m12 = this.mBannerAdUnit2;
        if (m12 != null) {
            m12.H0();
        }
    }

    public final void G() throws IllegalStateException {
        M1 m1;
        InterfaceC2971z5 p = p();
        if (p != null) {
            String str = this.TAG;
            ((A5) p).a(str, Q1.a(str, "TAG", "render ", this));
        }
        M1 m12 = this.mBackgroundBannerAdUnit;
        if (m12 == null) {
            throw new IllegalStateException(AbstractC2929we.m);
        }
        if (m12 == null || !a(this.DEBUG_LOG_TAG, m12.I().toString())) {
            return;
        }
        if (v() && (m1 = this.mBackgroundBannerAdUnit) != null) {
            m1.e((byte) 1);
        }
        a((byte) 8);
        m12.j0();
    }

    public final void H() {
        InterfaceC2971z5 p = p();
        if (p != null) {
            String str = this.TAG;
            ((A5) p).a(str, Q1.a(str, "TAG", "resume ", this));
        }
        M1 m1 = this.mForegroundBannerAdUnit;
        if (m1 != null) {
            m1.G0();
        }
    }

    public final void K() {
        InterfaceC2971z5 p = p();
        if (p != null) {
            String str = this.TAG;
            ((A5) p).c(str, Q1.a(str, "TAG", "swapAdUnits ", this));
        }
        M1 m1 = this.mForegroundBannerAdUnit;
        if (m1 == null) {
            this.mForegroundBannerAdUnit = this.mBannerAdUnit1;
            this.mBackgroundBannerAdUnit = this.mBannerAdUnit2;
        } else if (Intrinsics.areEqual(m1, this.mBannerAdUnit1)) {
            this.mForegroundBannerAdUnit = this.mBannerAdUnit2;
            this.mBackgroundBannerAdUnit = this.mBannerAdUnit1;
        } else if (Intrinsics.areEqual(m1, this.mBannerAdUnit2)) {
            this.mForegroundBannerAdUnit = this.mBannerAdUnit1;
            this.mBackgroundBannerAdUnit = this.mBannerAdUnit2;
        }
    }

    public final void L() {
        InterfaceC2971z5 p = p();
        if (p != null) {
            String str = this.TAG;
            ((A5) p).c(str, Q1.a(str, "TAG", "unregisterLifeCycleCallbacks ", this));
        }
        M1 m1 = this.mBannerAdUnit1;
        if (m1 != null) {
            m1.J0();
        }
        M1 m12 = this.mBannerAdUnit2;
        if (m12 != null) {
            m12.J0();
        }
    }

    public final void a(Context context, Wa pubSettings, String adSize, String logType) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(pubSettings, "pubSettings");
        Intrinsics.checkNotNullParameter(adSize, "adSize");
        Intrinsics.checkNotNullParameter(logType, "logType");
        Intrinsics.checkNotNullExpressionValue(this.TAG, "TAG");
        X x = new X("banner");
        Intrinsics.checkNotNullParameter(context, "context");
        Z a2 = x.d(context instanceof Activity ? "activity" : "others").a(pubSettings.f2471a).c(pubSettings.b).a(pubSettings.c).a(adSize).a(pubSettings.d).e(pubSettings.e).b(pubSettings.f).a();
        String str = pubSettings.e;
        if (str != null) {
            InterfaceC2971z5 p = p();
            if (p != null) {
                ((A5) p).a();
            }
            EnumC2560a7 enumC2560a7 = Cb.f2253a;
            a(Cb.a(logType, str, false));
        }
        M1 m1 = this.mBannerAdUnit1;
        if (m1 == null || this.mBannerAdUnit2 == null) {
            this.mBannerAdUnit1 = new M1(context, a2, this);
            M1 m12 = new M1(context, a2, this);
            this.mBannerAdUnit2 = m12;
            this.mBackgroundBannerAdUnit = this.mBannerAdUnit1;
            this.mForegroundBannerAdUnit = m12;
        } else {
            m1.a(context, a2, this);
            M1 m13 = this.mBannerAdUnit2;
            if (m13 != null) {
                m13.a(context, a2, this);
            }
        }
        InterfaceC2971z5 p2 = p();
        if (p2 != null) {
            M1 m14 = this.mBannerAdUnit1;
            if (m14 != null) {
                m14.a(p2);
            }
            M1 m15 = this.mBannerAdUnit2;
            if (m15 != null) {
                m15.a(p2);
            }
            InterfaceC2971z5 p3 = p();
            if (p3 != null) {
                String TAG = this.TAG;
                Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                ((A5) p3).a(TAG, "adding mBannerAdUnit1 to reference tracker");
            }
            EnumC2560a7 enumC2560a72 = Cb.f2253a;
            M1 m16 = this.mBannerAdUnit1;
            Intrinsics.checkNotNull(m16);
            Cb.a(m16, p());
            InterfaceC2971z5 p4 = p();
            if (p4 != null) {
                String TAG2 = this.TAG;
                Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                ((A5) p4).a(TAG2, "adding mBannerAdUnit2 to reference tracker");
            }
            M1 m17 = this.mBannerAdUnit2;
            Intrinsics.checkNotNull(m17);
            Cb.a(m17, p());
        }
        WatermarkData t = t();
        if (t != null) {
            M1 m18 = this.mBannerAdUnit1;
            if (m18 != null) {
                m18.a(t);
            }
            M1 m19 = this.mBannerAdUnit2;
            if (m19 != null) {
                m19.a(t);
            }
        }
    }

    @Override // com.inmobi.media.AbstractC2929we, com.inmobi.media.F0
    public void b(final AdMetaInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        InterfaceC2971z5 p = p();
        if (p != null) {
            String str = this.TAG;
            ((A5) p).c(str, Q1.a(str, "TAG", "onAdFetchSuccess ", this));
        }
        d(info);
        InMobiAdRequestStatus inMobiAdRequestStatus = new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR);
        M1 m1 = this.mBackgroundBannerAdUnit;
        if ((m1 != null ? m1.m() : null) == null) {
            InterfaceC2971z5 p2 = p();
            if (p2 != null) {
                String TAG = this.TAG;
                Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                ((A5) p2).b(TAG, "backgroundAdUnit ad object is null");
            }
            a((S0) null, inMobiAdRequestStatus);
            b((short) 2189);
            return;
        }
        InterfaceC2971z5 p3 = p();
        if (p3 != null) {
            String TAG2 = this.TAG;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            ((A5) p3).a(TAG2, "Ad fetch successful, calling loadAd()");
        }
        super.b(info);
        s().post(new Runnable() { // from class: com.inmobi.media.R1$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                R1.a(R1.this, info);
            }
        });
    }

    @Override // com.inmobi.media.AbstractC2929we, com.inmobi.media.F0
    public void c(final AdMetaInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        InterfaceC2971z5 p = p();
        if (p != null) {
            String str = this.TAG;
            ((A5) p).c(str, Q1.a(str, "TAG", "onAdLoadSucceeded ", this));
        }
        super.c(info);
        a((byte) 0);
        InterfaceC2971z5 p2 = p();
        if (p2 != null) {
            String TAG = this.TAG;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) p2).a(TAG, "Ad load successful, providing callback");
        }
        s().post(new Runnable() { // from class: com.inmobi.media.R1$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                R1.b(R1.this, info);
            }
        });
    }

    @Override // com.inmobi.media.AbstractC2929we
    public S0 j() {
        return I() ? this.mForegroundBannerAdUnit : this.mBackgroundBannerAdUnit;
    }

    public final boolean x() {
        M1 m1;
        InterfaceC2971z5 p = p();
        if (p != null) {
            String str = this.TAG;
            ((A5) p).c(str, Q1.a(str, "TAG", "canProceedForSuccess ", this));
        }
        if (this.mForegroundBannerAdUnit != null && (m1 = this.mBackgroundBannerAdUnit) != null) {
            m1.Q();
        }
        return true;
    }

    public final boolean y() {
        M1 m1;
        InterfaceC2971z5 p = p();
        if (p != null) {
            String str = this.TAG;
            ((A5) p).c(str, Q1.a(str, "TAG", "canScheduleRefresh ", this));
        }
        M1 m12 = this.mBackgroundBannerAdUnit;
        if (m12 == null) {
            return false;
        }
        Byte valueOf = m12 != null ? Byte.valueOf(m12.Q()) : null;
        if ((valueOf == null || valueOf.byteValue() != 4) && ((valueOf == null || valueOf.byteValue() != 1) && ((valueOf == null || valueOf.byteValue() != 2) && ((m1 = this.mForegroundBannerAdUnit) == null || m1.Q() != 7)))) {
            return true;
        }
        InterfaceC2971z5 p2 = p();
        if (p2 != null) {
            String TAG = this.TAG;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) p2).a(TAG, "Ignoring an attempt to schedule refresh when an ad is already loading or active.");
        }
        return false;
    }

    public final void z() {
        InterfaceC2971z5 p = p();
        if (p != null) {
            String str = this.TAG;
            ((A5) p).a(str, Q1.a(str, "TAG", "clear ", this));
        }
        L();
        M1 m1 = this.mBannerAdUnit1;
        if (m1 != null) {
            m1.g();
        }
        this.mBannerAdUnit1 = null;
        M1 m12 = this.mBannerAdUnit2;
        if (m12 != null) {
            m12.g();
        }
        this.mBannerAdUnit2 = null;
        a((InterfaceC2971z5) null);
        this.mForegroundBannerAdUnit = null;
        this.mBackgroundBannerAdUnit = null;
        a((Boolean) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(R1 this$0, AdMetaInfo info) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(info, "$info");
        InterfaceC2971z5 p = this$0.p();
        if (p != null) {
            String TAG = this$0.TAG;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) p).a(TAG, "callback - onAdFetchSuccessful");
        }
        PublisherCallbacks l = this$0.l();
        if (l != null) {
            l.onAdFetchSuccessful(info);
            return;
        }
        InterfaceC2971z5 p2 = this$0.p();
        if (p2 != null) {
            String TAG2 = this$0.TAG;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            ((A5) p2).b(TAG2, "callback null");
        }
    }

    @Override // com.inmobi.media.F0
    public void a(int next, final int callerIndex, GestureDetectorOnGestureListenerC2634ec renderView) {
        ViewParent parent;
        InterfaceC2971z5 p = p();
        if (p != null) {
            String str = this.TAG;
            ((A5) p).c(str, Q1.a(str, "TAG", "onShowNextPodAd ", this));
        }
        super.a(next, callerIndex, renderView);
        InterfaceC2971z5 p2 = p();
        if (p2 != null) {
            String str2 = this.TAG;
            ((A5) p2).a(str2, X8.a(str2, "TAG", "on Show next pod ad index: ", next));
        }
        if (renderView != null) {
            try {
                parent = renderView.getParent();
            } catch (Exception unused) {
                M1 m1 = this.mForegroundBannerAdUnit;
                if (m1 != null) {
                    m1.g(callerIndex);
                }
                M1 m12 = this.mForegroundBannerAdUnit;
                if (m12 != null) {
                    m12.b(callerIndex, false);
                    return;
                }
                return;
            }
        } else {
            parent = null;
        }
        InMobiBanner inMobiBanner = parent instanceof InMobiBanner ? (InMobiBanner) parent : null;
        if (inMobiBanner != null) {
            M1 m13 = this.mForegroundBannerAdUnit;
            if (m13 != null) {
                m13.b(callerIndex, true);
            }
            b(inMobiBanner);
            s().post(new Runnable() { // from class: com.inmobi.media.R1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    R1.a(R1.this, callerIndex);
                }
            });
            return;
        }
        M1 m14 = this.mForegroundBannerAdUnit;
        if (m14 != null) {
            m14.g(callerIndex);
        }
        M1 m15 = this.mForegroundBannerAdUnit;
        if (m15 != null) {
            m15.b(callerIndex, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(R1 this$0, AdMetaInfo info) {
        Unit unit;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(info, "$info");
        InterfaceC2971z5 p = this$0.p();
        if (p != null) {
            String TAG = this$0.TAG;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) p).a(TAG, "callback - onAdLoadSucceeded");
        }
        PublisherCallbacks l = this$0.l();
        if (l != null) {
            l.onAdLoadSucceeded(info);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            this$0.b((short) 2184);
        }
    }

    @Override // com.inmobi.media.AbstractC2929we, com.inmobi.media.F0
    public void b() {
        InterfaceC2971z5 p = p();
        if (p != null) {
            String str = this.TAG;
            ((A5) p).c(str, Q1.a(str, "TAG", "onAdDismissed ", this));
        }
        a((byte) 0);
        InterfaceC2971z5 p2 = p();
        if (p2 != null) {
            String TAG = this.TAG;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) p2).d(TAG, "AdManager state - CREATED");
        }
        super.b();
    }

    private final void b(RelativeLayout inMobiBanner) {
        Z I;
        InterfaceC2971z5 p = p();
        if (p != null) {
            String str = this.TAG;
            ((A5) p).a(str, Q1.a(str, "TAG", "displayInternal ", this));
        }
        M1 m1 = this.mForegroundBannerAdUnit;
        if (m1 == null) {
            return;
        }
        InterfaceC2930x k = m1.k();
        GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec = k instanceof GestureDetectorOnGestureListenerC2634ec ? (GestureDetectorOnGestureListenerC2634ec) k : null;
        if (gestureDetectorOnGestureListenerC2634ec == null) {
            return;
        }
        Xe viewableAd = gestureDetectorOnGestureListenerC2634ec.getViewableAd();
        M1 m12 = this.mForegroundBannerAdUnit;
        if (m12 != null && (I = m12.I()) != null && I.p()) {
            gestureDetectorOnGestureListenerC2634ec.e();
        }
        View d = viewableAd.d();
        viewableAd.a(new HashMap());
        ViewParent parent = gestureDetectorOnGestureListenerC2634ec.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (viewGroup == null) {
            inMobiBanner.addView(d, layoutParams);
        } else {
            viewGroup.removeAllViews();
            viewGroup.addView(d, layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(R1 this$0, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        M1 m1 = this$0.mForegroundBannerAdUnit;
        if (m1 != null) {
            m1.a(i, false);
        }
    }

    public final void a(PublisherCallbacks callbacks, String adSize, boolean isRefreshRequest) {
        M1 m1;
        Intrinsics.checkNotNullParameter(callbacks, "callbacks");
        Intrinsics.checkNotNullParameter(adSize, "adSize");
        InterfaceC2971z5 p = p();
        if (p != null) {
            String str = this.TAG;
            ((A5) p).c(str, Q1.a(str, "TAG", "load 1 ", this));
        }
        if (Intrinsics.areEqual(u(), Boolean.FALSE)) {
            b(this.mBackgroundBannerAdUnit, new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.REPETITIVE_LOAD));
            M1 m12 = this.mBackgroundBannerAdUnit;
            if (m12 != null) {
                m12.a((short) 2006);
            }
            AbstractC2680h7.a((byte) 1, this.DEBUG_LOG_TAG, "Cannot call load() API after calling load(byte[])");
            InterfaceC2971z5 p2 = p();
            if (p2 != null) {
                String TAG = this.TAG;
                Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                ((A5) p2).b(TAG, "Cannot call load() API after calling load(byte[])");
                return;
            }
            return;
        }
        a(Boolean.TRUE);
        if (l() == null) {
            b(callbacks);
        }
        M1 m13 = this.mBackgroundBannerAdUnit;
        if (m13 == null || !a(this.DEBUG_LOG_TAG, String.valueOf(m13.I()), callbacks) || (m1 = this.mBackgroundBannerAdUnit) == null || !m1.e(o())) {
            return;
        }
        InterfaceC2971z5 p3 = p();
        if (p3 != null) {
            String TAG2 = this.TAG;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            ((A5) p3).d(TAG2, "AdManager state - LOADING");
        }
        a((byte) 1);
        d(null);
        M1 m14 = this.mBackgroundBannerAdUnit;
        Intrinsics.checkNotNull(m14);
        m14.e(adSize);
        M1 m15 = this.mBackgroundBannerAdUnit;
        Intrinsics.checkNotNull(m15);
        m15.e(isRefreshRequest);
    }

    @Override // com.inmobi.media.AbstractC2929we
    public void a(byte[] response, PublisherCallbacks callbacks) {
        M1 m1;
        Intrinsics.checkNotNullParameter(callbacks, "callbacks");
        InterfaceC2971z5 p = p();
        if (p != null) {
            String str = this.TAG;
            ((A5) p).a(str, Q1.a(str, "TAG", "load 2 ", this));
        }
        if (Intrinsics.areEqual(u(), Boolean.TRUE)) {
            AbstractC2680h7.a((byte) 1, "InMobi", "Cannot call load(byte[]) API after load() API is called");
            InterfaceC2971z5 p2 = p();
            if (p2 != null) {
                String TAG = this.TAG;
                Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                ((A5) p2).b(TAG, "Cannot call load(byte[]) API after load() API is called");
                return;
            }
            return;
        }
        a(Boolean.FALSE);
        a((byte) 1);
        b(callbacks);
        if (this.mBackgroundBannerAdUnit != null) {
            M1 m12 = this.mForegroundBannerAdUnit;
            if ((m12 == null || !m12.Y()) && (m1 = this.mBackgroundBannerAdUnit) != null && m1.e((byte) 1)) {
                InterfaceC2971z5 p3 = p();
                if (p3 != null) {
                    String TAG2 = this.TAG;
                    Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                    ((A5) p3).a(TAG2, "timer started - load banner");
                }
                M1 m13 = this.mBackgroundBannerAdUnit;
                if (m13 != null) {
                    m13.e0();
                }
                M1 m14 = this.mBackgroundBannerAdUnit;
                if (m14 != null) {
                    m14.a(response);
                }
            }
        }
    }

    public final void b(short errorCode) {
        InterfaceC2971z5 p = p();
        if (p != null) {
            String str = this.TAG;
            ((A5) p).c(str, Q1.a(str, "TAG", "submitAdLoadFailed ", this));
        }
        S0 j = j();
        if (j != null) {
            j.b(errorCode);
        }
    }

    public final void a(RelativeLayout banner) {
        Z I;
        Intrinsics.checkNotNullParameter(banner, "banner");
        InterfaceC2971z5 p = p();
        if (p != null) {
            String str = this.TAG;
            ((A5) p).a(str, Q1.a(str, "TAG", "displayAd ", this));
        }
        M1 m1 = this.mForegroundBannerAdUnit;
        InterfaceC2930x k = m1 != null ? m1.k() : null;
        GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec = k instanceof GestureDetectorOnGestureListenerC2634ec ? (GestureDetectorOnGestureListenerC2634ec) k : null;
        if (gestureDetectorOnGestureListenerC2634ec == null) {
            return;
        }
        Xe viewableAd = gestureDetectorOnGestureListenerC2634ec.getViewableAd();
        M1 m12 = this.mForegroundBannerAdUnit;
        if (m12 != null && (I = m12.I()) != null && I.p()) {
            gestureDetectorOnGestureListenerC2634ec.e();
        }
        ViewParent parent = gestureDetectorOnGestureListenerC2634ec.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        View d = viewableAd.d();
        viewableAd.a(new HashMap());
        M1 m13 = this.mBackgroundBannerAdUnit;
        if (m13 != null) {
            m13.F0();
        }
        M1 m14 = this.mForegroundBannerAdUnit;
        if (m14 != null && m14.Q() == 8) {
            View view = new View(banner.getContext());
            view.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            view.setBackgroundColor(-16777216);
            a(viewGroup, banner, layoutParams, view);
            J();
        } else {
            a(viewGroup, banner, layoutParams, d);
        }
        M1 m15 = this.mBackgroundBannerAdUnit;
        if (m15 != null) {
            m15.g();
        }
    }

    private static final void a(ViewGroup viewGroup, RelativeLayout relativeLayout, RelativeLayout.LayoutParams layoutParams, View view) {
        if (viewGroup == null) {
            relativeLayout.addView(view, layoutParams);
        } else {
            viewGroup.removeAllViews();
            viewGroup.addView(view, layoutParams);
        }
    }

    @Override // com.inmobi.media.AbstractC2929we
    public void a(WatermarkData watermarkData) {
        Intrinsics.checkNotNullParameter(watermarkData, "watermarkData");
        super.a(watermarkData);
        M1 m1 = this.mBannerAdUnit1;
        if (m1 != null) {
            m1.a(watermarkData);
        }
        M1 m12 = this.mBannerAdUnit2;
        if (m12 != null) {
            m12.a(watermarkData);
        }
    }

    public final int a(int _refreshInterval, int previousInterval) {
        AdConfig j;
        InterfaceC2971z5 p = p();
        if (p != null) {
            String str = this.TAG;
            ((A5) p).c(str, Q1.a(str, "TAG", "getRefreshInterval ", this));
        }
        M1 m1 = this.mBackgroundBannerAdUnit;
        return (m1 == null || (j = m1.j()) == null) ? previousInterval : _refreshInterval < j.getMinimumRefreshInterval() ? j.getMinimumRefreshInterval() : _refreshInterval;
    }

    public final boolean a(long adLoadCalledTimestamp) {
        InterfaceC2971z5 p = p();
        if (p != null) {
            String str = this.TAG;
            ((A5) p).c(str, Q1.a(str, "TAG", "checkForRefreshRate ", this));
        }
        M1 m1 = this.mBackgroundBannerAdUnit;
        if (m1 == null) {
            return false;
        }
        AdConfig j = m1.j();
        Intrinsics.checkNotNull(j);
        int minimumRefreshInterval = j.getMinimumRefreshInterval();
        if (SystemClock.elapsedRealtime() - adLoadCalledTimestamp >= minimumRefreshInterval * 1000) {
            return true;
        }
        a((short) 2175);
        InterfaceC2971z5 p2 = p();
        if (p2 != null) {
            String TAG = this.TAG;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) p2).b(TAG, "Early refresh request");
        }
        b(this.mBackgroundBannerAdUnit, new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.EARLY_REFRESH_REQUEST).setCustomMessage("Ad cannot be refreshed before " + minimumRefreshInterval + " seconds"));
        String TAG2 = this.TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        StringBuilder append = new StringBuilder("Ad cannot be refreshed before ").append(minimumRefreshInterval).append(" seconds (AdPlacement Id = ");
        M1 m12 = this.mBackgroundBannerAdUnit;
        AbstractC2680h7.a((byte) 1, TAG2, append.append(m12 != null ? m12.I() : null).append(')').toString());
        InterfaceC2971z5 p3 = p();
        if (p3 != null) {
            String TAG3 = this.TAG;
            Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
            StringBuilder append2 = new StringBuilder("Ad cannot be refreshed before ").append(minimumRefreshInterval).append(" seconds (AdPlacement Id = ");
            M1 m13 = this.mBackgroundBannerAdUnit;
            ((A5) p3).b(TAG3, append2.append(m13 != null ? m13.I() : null).append(')').toString());
        }
        return false;
    }
}
