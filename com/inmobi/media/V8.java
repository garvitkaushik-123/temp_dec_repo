package com.inmobi.media;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.google.android.gms.ads.RequestConfiguration;
import com.inmobi.ads.AdMetaInfo;
import com.inmobi.ads.InMobiAdRequestStatus;
import com.inmobi.ads.controllers.PublisherCallbacks;
import com.ironsource.C3040d4;
import com.ironsource.C3355vf;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import io.bidmachine.iab.vast.tags.VastAttributes;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0007\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J1\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0017\u0010\u0014J\u000f\u0010\u0018\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0018\u0010\u0016J\r\u0010\u0019\u001a\u00020\u000e¢\u0006\u0004\b\u0019\u0010\u0016J\r\u0010\u001a\u001a\u00020\u000e¢\u0006\u0004\b\u001a\u0010\u0016J\r\u0010\u001b\u001a\u00020\u000e¢\u0006\u0004\b\u001b\u0010\u0016J\r\u0010\u001c\u001a\u00020\u000e¢\u0006\u0004\b\u001c\u0010\u0016J\r\u0010\u001d\u001a\u00020\u000e¢\u0006\u0004\b\u001d\u0010\u0016J\u001d\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000f\u0010\u001eJ\u000f\u0010\u0017\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0017\u0010\u0016J\u000f\u0010\u001f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u001f\u0010\u0016J\u000f\u0010 \u001a\u00020\u000eH\u0016¢\u0006\u0004\b \u0010\u0016J\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000f\u0010\"R\u0014\u0010%\u001a\u00020\f8\u0002X\u0082D¢\u0006\u0006\n\u0004\b#\u0010$R\u001c\u0010(\u001a\n &*\u0004\u0018\u00010\f0\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010$R\u0018\u0010,\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0011\u0010/\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b-\u0010.R\u0016\u00103\u001a\u0004\u0018\u0001008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b1\u00102R\u0014\u00105\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b4\u0010.R\u0013\u00109\u001a\u0004\u0018\u0001068F¢\u0006\u0006\u001a\u0004\b7\u00108R\u0013\u0010<\u001a\u0004\u0018\u00010\f8F¢\u0006\u0006\u001a\u0004\b:\u0010;R\u0013\u0010>\u001a\u0004\u0018\u00010\f8F¢\u0006\u0006\u001a\u0004\b=\u0010;R\u0013\u0010@\u001a\u0004\u0018\u00010\f8F¢\u0006\u0006\u001a\u0004\b?\u0010;R\u0013\u0010B\u001a\u0004\u0018\u00010\f8F¢\u0006\u0006\u001a\u0004\bA\u0010;R\u0013\u0010D\u001a\u0004\u0018\u00010\f8F¢\u0006\u0006\u001a\u0004\bC\u0010;R\u0011\u0010H\u001a\u00020E8F¢\u0006\u0006\u001a\u0004\bF\u0010GR\u0011\u0010J\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\bI\u0010.R\u0013\u0010M\u001a\u0004\u0018\u00010\n8F¢\u0006\u0006\u001a\u0004\bK\u0010L¨\u0006N"}, d2 = {"Lcom/inmobi/media/V8;", "Lcom/inmobi/media/we;", "Lcom/inmobi/ads/controllers/PublisherCallbacks;", "callbacks", "<init>", "(Lcom/inmobi/ads/controllers/PublisherCallbacks;)V", "Lcom/inmobi/media/Wa;", "pubSettings", "Landroid/content/Context;", "context", "", "sendAdLoadTelemetry", "", "logType", "", "a", "(Lcom/inmobi/media/Wa;Landroid/content/Context;ZLjava/lang/String;)V", "Lcom/inmobi/ads/AdMetaInfo;", "info", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "(Lcom/inmobi/ads/AdMetaInfo;)V", "J", "()V", "c", "d", VastAttributes.HORIZONTAL_POSITION, "N", "K", "M", "L", "(Lcom/inmobi/media/Wa;Landroid/content/Context;)V", "i", InneractiveMediationDefs.GENDER_FEMALE, "isMuted", "(Z)V", "o", "Ljava/lang/String;", "DEBUG_LOG_TAG", "kotlin.jvm.PlatformType", "p", "TAG", "Lcom/inmobi/media/c8;", CampaignEx.JSON_KEY_AD_Q, "Lcom/inmobi/media/c8;", "mNativeAdUnit", "F", "()Z", "isAdInReadyState", "Lcom/inmobi/media/S0;", com.mbridge.msdk.foundation.same.report.j.b, "()Lcom/inmobi/media/S0;", "adUnit", "H", "isInitialised", "Lorg/json/JSONObject;", ExifInterface.LONGITUDE_EAST, "()Lorg/json/JSONObject;", "publisherJson", "D", "()Ljava/lang/String;", "adTitle", "z", "adDescription", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "adIconUrl", "B", "adLandingPageUrl", VastAttributes.VERTICAL_POSITION, "adCtaText", "", "C", "()F", "adRating", RequestConfiguration.MAX_AD_CONTENT_RATING_G, "isAppDownload", "I", "()Ljava/lang/Boolean;", "isVideo", "media_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class V8 extends AbstractC2929we {

    /* renamed from: o, reason: from kotlin metadata */
    private final String DEBUG_LOG_TAG;

    /* renamed from: p, reason: from kotlin metadata */
    private final String TAG;

    /* renamed from: q, reason: from kotlin metadata */
    private C2596c8 mNativeAdUnit;

    public V8(PublisherCallbacks callbacks) {
        Intrinsics.checkNotNullParameter(callbacks, "callbacks");
        this.DEBUG_LOG_TAG = "InMobi";
        this.TAG = "V8";
        b(callbacks);
    }

    public static /* synthetic */ void a(V8 v8, Wa wa, Context context, boolean z, String str, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            str = "native";
        }
        v8.a(wa, context, z, str);
    }

    public final String A() {
        InterfaceC2930x k;
        C2794o8 c2794o8;
        C2778n8 c2778n8;
        C2596c8 c2596c8 = this.mNativeAdUnit;
        if (c2596c8 != null && (k = c2596c8.k()) != null) {
            Object dataModel = k.getDataModel();
            C2811p8 c2811p8 = dataModel instanceof C2811p8 ? (C2811p8) dataModel : null;
            if (c2811p8 != null && (c2794o8 = c2811p8.p) != null && (c2778n8 = c2794o8.b) != null) {
                return c2778n8.c;
            }
        }
        return null;
    }

    public final String B() {
        InterfaceC2930x k;
        C2794o8 c2794o8;
        C2778n8 c2778n8;
        C2596c8 c2596c8 = this.mNativeAdUnit;
        if (c2596c8 != null && (k = c2596c8.k()) != null) {
            Object dataModel = k.getDataModel();
            C2811p8 c2811p8 = dataModel instanceof C2811p8 ? (C2811p8) dataModel : null;
            if (c2811p8 != null && (c2794o8 = c2811p8.p) != null && (c2778n8 = c2794o8.b) != null) {
                return c2778n8.f;
            }
        }
        return null;
    }

    public final float C() {
        InterfaceC2930x k;
        C2794o8 c2794o8;
        C2778n8 c2778n8;
        C2596c8 c2596c8 = this.mNativeAdUnit;
        if (c2596c8 == null || (k = c2596c8.k()) == null) {
            return 0.0f;
        }
        Object dataModel = k.getDataModel();
        C2811p8 c2811p8 = dataModel instanceof C2811p8 ? (C2811p8) dataModel : null;
        if (c2811p8 == null || (c2794o8 = c2811p8.p) == null || (c2778n8 = c2794o8.b) == null) {
            return 0.0f;
        }
        return c2778n8.e;
    }

    public final String D() {
        InterfaceC2930x k;
        C2794o8 c2794o8;
        C2778n8 c2778n8;
        C2596c8 c2596c8 = this.mNativeAdUnit;
        if (c2596c8 != null && (k = c2596c8.k()) != null) {
            Object dataModel = k.getDataModel();
            C2811p8 c2811p8 = dataModel instanceof C2811p8 ? (C2811p8) dataModel : null;
            if (c2811p8 != null && (c2794o8 = c2811p8.p) != null && (c2778n8 = c2794o8.b) != null) {
                return c2778n8.f2650a;
            }
        }
        return null;
    }

    public final JSONObject E() {
        InterfaceC2930x k;
        C2794o8 c2794o8;
        C2596c8 c2596c8 = this.mNativeAdUnit;
        if (c2596c8 != null && (k = c2596c8.k()) != null) {
            Object dataModel = k.getDataModel();
            C2811p8 c2811p8 = dataModel instanceof C2811p8 ? (C2811p8) dataModel : null;
            if (c2811p8 != null && (c2794o8 = c2811p8.p) != null) {
                return c2794o8.f2660a;
            }
        }
        return null;
    }

    public final boolean F() {
        C2596c8 c2596c8 = this.mNativeAdUnit;
        return c2596c8 != null && c2596c8.Q() == 4;
    }

    public final boolean G() {
        InterfaceC2930x k;
        C2794o8 c2794o8;
        C2778n8 c2778n8;
        C2596c8 c2596c8 = this.mNativeAdUnit;
        if (c2596c8 == null || (k = c2596c8.k()) == null) {
            return false;
        }
        Object dataModel = k.getDataModel();
        C2811p8 c2811p8 = dataModel instanceof C2811p8 ? (C2811p8) dataModel : null;
        if (c2811p8 == null || (c2794o8 = c2811p8.p) == null || (c2778n8 = c2794o8.b) == null) {
            return false;
        }
        return c2778n8.g;
    }

    public boolean H() {
        return this.mNativeAdUnit != null;
    }

    public final Boolean I() {
        C2596c8 c2596c8 = this.mNativeAdUnit;
        if (c2596c8 != null) {
            return Boolean.valueOf(c2596c8.k() instanceof C2562a9);
        }
        return null;
    }

    public final void J() {
        C2596c8 c2596c8;
        if (Intrinsics.areEqual(u(), Boolean.FALSE)) {
            InterfaceC2971z5 p = p();
            if (p != null) {
                ((A5) p).b(this.DEBUG_LOG_TAG, "Cannot call load() API after calling load(byte[])");
                return;
            }
            return;
        }
        a(Boolean.TRUE);
        C2596c8 c2596c82 = this.mNativeAdUnit;
        if (c2596c82 != null) {
            if (a(this.DEBUG_LOG_TAG, String.valueOf(c2596c82 != null ? c2596c82.I() : null), l()) && (c2596c8 = this.mNativeAdUnit) != null && c2596c8.e((byte) 1)) {
                InterfaceC2971z5 p2 = p();
                if (p2 != null) {
                    String TAG = this.TAG;
                    Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                    ((A5) p2).a(TAG, "internal load timer started");
                }
                a((byte) 1);
                C2596c8 c2596c83 = this.mNativeAdUnit;
                if (c2596c83 != null) {
                    c2596c83.c0();
                }
            }
        }
    }

    public final void K() {
        InterfaceC2971z5 p = p();
        if (p != null) {
            String TAG = this.TAG;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) p).a(TAG, "pause called");
        }
        C2596c8 c2596c8 = this.mNativeAdUnit;
        if (c2596c8 != null) {
            InterfaceC2971z5 interfaceC2971z5 = c2596c8.j;
            if (interfaceC2971z5 != null) {
                Intrinsics.checkNotNullExpressionValue("c8", "TAG");
                ((A5) interfaceC2971z5).c("c8", C3040d4.h.t0);
            }
            if (c2596c8.Q() != 4 || (c2596c8.t() instanceof Activity)) {
                return;
            }
            InterfaceC2930x k = c2596c8.k();
            T7 t7 = k instanceof T7 ? (T7) k : null;
            if (t7 != null) {
                t7.l();
            }
        }
    }

    public final void L() {
        InterfaceC2971z5 p = p();
        if (p != null) {
            String TAG = this.TAG;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) p).c(TAG, "reportAdClickAndOpenLandingPage");
        }
        C2596c8 c2596c8 = this.mNativeAdUnit;
        if (c2596c8 != null) {
            InterfaceC2971z5 interfaceC2971z5 = c2596c8.j;
            if (interfaceC2971z5 != null) {
                Intrinsics.checkNotNullExpressionValue("c8", "TAG");
                ((A5) interfaceC2971z5).c("c8", "reportAdClickAndOpenLandingPage");
            }
            InterfaceC2930x k = c2596c8.k();
            if (k == null) {
                InterfaceC2971z5 interfaceC2971z52 = c2596c8.j;
                if (interfaceC2971z52 != null) {
                    Intrinsics.checkNotNullExpressionValue("c8", "TAG");
                    ((A5) interfaceC2971z52).b("c8", "container is null. ignoring");
                    return;
                }
                return;
            }
            T7 t7 = k instanceof T7 ? (T7) k : null;
            C2811p8 c2811p8 = t7 != null ? t7.b : null;
            if (c2811p8 instanceof C2811p8) {
                C2794o8 c2794o8 = c2811p8.p;
                C2613d8 c2613d8 = c2794o8 != null ? c2794o8.c : null;
                if (c2613d8 != null) {
                    InterfaceC2971z5 interfaceC2971z53 = c2596c8.j;
                    if (interfaceC2971z53 != null) {
                        Intrinsics.checkNotNullExpressionValue("c8", "TAG");
                        ((A5) interfaceC2971z53).a("c8", "reporting ad click and opening landing page");
                    }
                    t7.a((View) null, c2613d8);
                    t7.a(c2613d8, true);
                }
            }
        }
    }

    public final void M() {
        We we;
        InterfaceC2971z5 p = p();
        if (p != null) {
            String TAG = this.TAG;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) p).a(TAG, "resume called");
        }
        C2596c8 c2596c8 = this.mNativeAdUnit;
        if (c2596c8 != null) {
            InterfaceC2971z5 interfaceC2971z5 = c2596c8.j;
            if (interfaceC2971z5 != null) {
                Intrinsics.checkNotNullExpressionValue("c8", "TAG");
                ((A5) interfaceC2971z5).c("c8", C3040d4.h.u0);
            }
            if (c2596c8.Q() != 4 || (c2596c8.t() instanceof Activity)) {
                return;
            }
            InterfaceC2930x k = c2596c8.k();
            T7 t7 = k instanceof T7 ? (T7) k : null;
            if (t7 != null) {
                InterfaceC2971z5 interfaceC2971z52 = t7.j;
                if (interfaceC2971z52 != null) {
                    String TAG2 = t7.m;
                    Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                    ((A5) interfaceC2971z52).c(TAG2, C3040d4.h.u0);
                }
                t7.u = false;
                T8 a2 = T7.a(t7.g());
                if (a2 != null) {
                    a2.c();
                }
                t7.p();
                Context d = t7.d();
                if (d == null || (we = t7.p) == null) {
                    return;
                }
                we.a(d, (byte) 0);
            }
        }
    }

    public final void N() {
        T7 G;
        InterfaceC2971z5 p = p();
        if (p != null) {
            String TAG = this.TAG;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) p).c(TAG, "takeAction");
        }
        C2596c8 c2596c8 = this.mNativeAdUnit;
        if (c2596c8 == null) {
            InterfaceC2971z5 p2 = p();
            if (p2 != null) {
                String TAG2 = this.TAG;
                Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                ((A5) p2).b(TAG2, "InMobiNative is not initialized. Ignoring takeAction");
                return;
            }
            return;
        }
        if (c2596c8 == null || (G = c2596c8.G()) == null) {
            return;
        }
        InterfaceC2971z5 interfaceC2971z5 = G.j;
        if (interfaceC2971z5 != null) {
            String TAG3 = G.m;
            Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
            ((A5) interfaceC2971z5).c(TAG3, "takeAction");
        }
        C2613d8 c2613d8 = G.E;
        String str = G.F;
        Intent intent = G.G;
        Context context = (Context) G.x.get();
        if (c2613d8 != null && str != null) {
            G.a(c2613d8, c2613d8.g, str, null);
        } else {
            if (intent == null || context == null) {
                return;
            }
            Uc.f2453a.a(context, intent);
        }
    }

    @Override // com.inmobi.media.AbstractC2929we, com.inmobi.media.F0
    public void b(final AdMetaInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        InterfaceC2971z5 p = p();
        if (p != null) {
            String TAG = this.TAG;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) p).c(TAG, "onAdFetchSuccess");
        }
        d(info);
        InMobiAdRequestStatus inMobiAdRequestStatus = new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR);
        C2596c8 c2596c8 = this.mNativeAdUnit;
        if (c2596c8 == null) {
            InterfaceC2971z5 p2 = p();
            if (p2 != null) {
                String TAG2 = this.TAG;
                Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                ((A5) p2).b(TAG2, "adunit is null. load failed.");
            }
            a((S0) null, inMobiAdRequestStatus);
            return;
        }
        if (c2596c8.m() == null) {
            InterfaceC2971z5 p3 = p();
            if (p3 != null) {
                String TAG3 = this.TAG;
                Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
                ((A5) p3).b(TAG3, "adObject is null. load failed");
            }
            a((S0) null, inMobiAdRequestStatus);
            return;
        }
        super.b(info);
        s().post(new Runnable() { // from class: com.inmobi.media.V8$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                V8.a(V8.this, info);
            }
        });
        if (F()) {
            return;
        }
        InterfaceC2971z5 p4 = p();
        if (p4 != null) {
            String TAG4 = this.TAG;
            Intrinsics.checkNotNullExpressionValue(TAG4, "TAG");
            ((A5) p4).a(TAG4, "ad is ready. start ad render");
        }
        C2596c8 c2596c82 = this.mNativeAdUnit;
        if (c2596c82 != null) {
            c2596c82.j0();
        }
    }

    @Override // com.inmobi.media.AbstractC2929we, com.inmobi.media.F0
    public void c(final AdMetaInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        InterfaceC2971z5 p = p();
        if (p != null) {
            String TAG = this.TAG;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) p).b(TAG, "onAdLoadSucceeded");
        }
        super.c(info);
        a((byte) 2);
        InterfaceC2971z5 p2 = p();
        if (p2 != null) {
            String TAG2 = this.TAG;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            ((A5) p2).d(TAG2, "AdManager state - LOADED");
        }
        s().post(new Runnable() { // from class: com.inmobi.media.V8$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                V8.b(V8.this, info);
            }
        });
    }

    @Override // com.inmobi.media.F0
    public void d() {
        InterfaceC2971z5 p = p();
        if (p != null) {
            String TAG = this.TAG;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) p).b(TAG, C3355vf.e);
        }
        InterfaceC2971z5 p2 = p();
        if (p2 != null) {
            ((A5) p2).a();
        }
    }

    @Override // com.inmobi.media.F0
    public void f() {
        s().post(new Runnable() { // from class: com.inmobi.media.V8$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                V8.b(V8.this);
            }
        });
    }

    @Override // com.inmobi.media.F0
    public void i() {
        s().post(new Runnable() { // from class: com.inmobi.media.V8$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                V8.c(V8.this);
            }
        });
    }

    @Override // com.inmobi.media.AbstractC2929we
    public S0 j() {
        return this.mNativeAdUnit;
    }

    public final void x() {
        InterfaceC2971z5 p = p();
        if (p != null) {
            String TAG = this.TAG;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) p).a(TAG, "destroy called");
        }
        C2596c8 c2596c8 = this.mNativeAdUnit;
        if (c2596c8 != null) {
            c2596c8.D0();
        }
        this.mNativeAdUnit = null;
        InterfaceC2971z5 p2 = p();
        if (p2 != null) {
            ((A5) p2).a();
        }
    }

    public final String y() {
        InterfaceC2930x k;
        C2794o8 c2794o8;
        C2778n8 c2778n8;
        C2596c8 c2596c8 = this.mNativeAdUnit;
        if (c2596c8 != null && (k = c2596c8.k()) != null) {
            Object dataModel = k.getDataModel();
            C2811p8 c2811p8 = dataModel instanceof C2811p8 ? (C2811p8) dataModel : null;
            if (c2811p8 != null && (c2794o8 = c2811p8.p) != null && (c2778n8 = c2794o8.b) != null) {
                return c2778n8.d;
            }
        }
        return null;
    }

    public final String z() {
        InterfaceC2930x k;
        C2794o8 c2794o8;
        C2778n8 c2778n8;
        C2596c8 c2596c8 = this.mNativeAdUnit;
        if (c2596c8 != null && (k = c2596c8.k()) != null) {
            Object dataModel = k.getDataModel();
            C2811p8 c2811p8 = dataModel instanceof C2811p8 ? (C2811p8) dataModel : null;
            if (c2811p8 != null && (c2794o8 = c2811p8.p) != null && (c2778n8 = c2794o8.b) != null) {
                return c2778n8.b;
            }
        }
        return null;
    }

    public final void a(Wa pubSettings, Context context, boolean sendAdLoadTelemetry, String logType) {
        C2596c8 c2596c8;
        Intrinsics.checkNotNullParameter(pubSettings, "pubSettings");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(logType, "logType");
        C2596c8 c2596c82 = this.mNativeAdUnit;
        if (c2596c82 == null) {
            X a2 = new X("native").a(pubSettings.f2471a);
            Intrinsics.checkNotNullParameter(context, "context");
            this.mNativeAdUnit = new C2596c8(context, a2.d(context instanceof Activity ? "activity" : "others").c(pubSettings.b).a(pubSettings.c).a(pubSettings.d).e(pubSettings.e).b(pubSettings.f).a(), this);
        } else {
            c2596c82.a(context);
            C2596c8 c2596c83 = this.mNativeAdUnit;
            if (c2596c83 != null) {
                Intrinsics.checkNotNullParameter(context, "context");
                c2596c83.c(context instanceof Activity ? "activity" : "others");
            }
        }
        if (sendAdLoadTelemetry) {
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
            if (p2 != null && (c2596c8 = this.mNativeAdUnit) != null) {
                c2596c8.a(p2);
            }
            InterfaceC2971z5 p3 = p();
            if (p3 != null) {
                String TAG = this.TAG;
                Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                ((A5) p3).a(TAG, "adding mNativeAdUnit to referenceTracker");
            }
            C2596c8 c2596c84 = this.mNativeAdUnit;
            Intrinsics.checkNotNull(c2596c84);
            Cb.a(c2596c84, p());
        }
        InterfaceC2971z5 p4 = p();
        if (p4 != null) {
            String TAG2 = this.TAG;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            ((A5) p4).a(TAG2, "load called");
        }
        C2596c8 c2596c85 = this.mNativeAdUnit;
        if (c2596c85 != null) {
            c2596c85.a(pubSettings.c);
        }
    }

    @Override // com.inmobi.media.F0
    public void c() {
        s().post(new Runnable() { // from class: com.inmobi.media.V8$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                V8.a(V8.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(V8 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        InterfaceC2971z5 p = this$0.p();
        if (p != null) {
            String TAG = this$0.TAG;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) p).a(TAG, "callback - onVideoSkipped");
        }
        PublisherCallbacks l = this$0.l();
        if (l != null) {
            l.onVideoSkipped();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(V8 this$0, AdMetaInfo info) {
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
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(V8 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        InterfaceC2971z5 p = this$0.p();
        if (p != null) {
            String TAG = this$0.TAG;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) p).a(TAG, "callback - onVideoCompleted");
        }
        PublisherCallbacks l = this$0.l();
        if (l != null) {
            l.onVideoCompleted();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(V8 this$0, AdMetaInfo info) {
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
        }
    }

    public final void a(Wa pubSettings, Context context) {
        V8 v8;
        Intrinsics.checkNotNullParameter(pubSettings, "pubSettings");
        Intrinsics.checkNotNullParameter(context, "context");
        if (this.mNativeAdUnit == null) {
            v8 = this;
            a(v8, pubSettings, context, false, null, 8, null);
        } else {
            v8 = this;
        }
        InterfaceC2971z5 p = p();
        if (p != null) {
            String TAG = v8.TAG;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) p).c(TAG, "showOnLockScreen");
        }
        C2596c8 c2596c8 = v8.mNativeAdUnit;
        if (c2596c8 != null) {
            c2596c8.O = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(V8 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        InterfaceC2971z5 p = this$0.p();
        if (p != null) {
            String TAG = this$0.TAG;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) p).a(TAG, "callback - onAdImpressed");
        }
        PublisherCallbacks l = this$0.l();
        if (l != null) {
            l.onAdImpressed();
        }
    }

    @Override // com.inmobi.media.F0
    public void a(final boolean isMuted) {
        s().post(new Runnable() { // from class: com.inmobi.media.V8$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                V8.a(V8.this, isMuted);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(V8 this$0, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        InterfaceC2971z5 p = this$0.p();
        if (p != null) {
            String TAG = this$0.TAG;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) p).a(TAG, "callback -onAudioStateChanged - " + z);
        }
        PublisherCallbacks l = this$0.l();
        if (l != null) {
            l.onAudioStateChanged(z);
        }
    }
}
