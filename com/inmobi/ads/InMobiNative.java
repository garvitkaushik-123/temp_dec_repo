package com.inmobi.ads;

import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.inmobi.ads.InMobiAdRequestStatus;
import com.inmobi.ads.exceptions.SdkNotInitializedException;
import com.inmobi.ads.listeners.NativeAdEventListener;
import com.inmobi.ads.listeners.VideoEventListener;
import com.inmobi.media.A5;
import com.inmobi.media.AbstractC2680h7;
import com.inmobi.media.AbstractC2920w5;
import com.inmobi.media.C2596c8;
import com.inmobi.media.H8;
import com.inmobi.media.InterfaceC2971z5;
import com.inmobi.media.S5;
import com.inmobi.media.U3;
import com.inmobi.media.U7;
import com.inmobi.media.Uc;
import com.inmobi.media.V7;
import com.inmobi.media.V8;
import com.inmobi.media.Vc;
import com.inmobi.media.Wa;
import com.inmobi.media.Yd;
import com.ironsource.C3337ue;
import com.ironsource.C3355vf;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.vungle.ads.internal.ui.AdActivity;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0007\n\u0002\b\n\u0018\u0000 V2\u00020\u0001:\u0003VWXB\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\fH\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\r\u0010\u0018\u001a\u00020\f¢\u0006\u0004\b\u0018\u0010\u0015J\u0015\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u001aJ\u0015\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\r\u0010\u001f\u001a\u00020\f¢\u0006\u0004\b\u001f\u0010\u0015J\r\u0010 \u001a\u00020\f¢\u0006\u0004\b \u0010\u0015J\r\u0010!\u001a\u00020\f¢\u0006\u0004\b!\u0010\u0015J5\u0010(\u001a\u0004\u0018\u00010\"2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010#\u001a\u0004\u0018\u00010\"2\b\u0010%\u001a\u0004\u0018\u00010$2\u0006\u0010'\u001a\u00020&¢\u0006\u0004\b(\u0010)J\r\u0010*\u001a\u00020\f¢\u0006\u0004\b*\u0010\u0015J\r\u0010+\u001a\u00020\n¢\u0006\u0004\b+\u0010,J#\u00100\u001a\u00020\f2\u0014\u0010/\u001a\u0010\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020.\u0018\u00010-¢\u0006\u0004\b0\u00101J\u0017\u00103\u001a\u00020\f2\b\u00102\u001a\u0004\u0018\u00010.¢\u0006\u0004\b3\u00104J\u0017\u00106\u001a\u00020\f2\b\u00105\u001a\u0004\u0018\u00010.¢\u0006\u0004\b6\u00104J\r\u00107\u001a\u00020\f¢\u0006\u0004\b7\u0010\u0015R$\u0010?\u001a\u0004\u0018\u0001088\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u0013\u0010C\u001a\u0004\u0018\u00010@8F¢\u0006\u0006\u001a\u0004\bA\u0010BR\u0013\u0010F\u001a\u0004\u0018\u00010.8F¢\u0006\u0006\u001a\u0004\bD\u0010ER\u0013\u0010H\u001a\u0004\u0018\u00010.8F¢\u0006\u0006\u001a\u0004\bG\u0010ER\u0013\u0010J\u001a\u0004\u0018\u00010.8F¢\u0006\u0006\u001a\u0004\bI\u0010ER\u0013\u0010L\u001a\u0004\u0018\u00010.8F¢\u0006\u0006\u001a\u0004\bK\u0010ER\u0013\u0010N\u001a\u0004\u0018\u00010.8F¢\u0006\u0006\u001a\u0004\bM\u0010ER\u0011\u0010R\u001a\u00020O8F¢\u0006\u0006\u001a\u0004\bP\u0010QR\u0011\u0010S\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\bS\u0010,R\u0013\u0010T\u001a\u0004\u0018\u00010\n8F¢\u0006\u0006\u001a\u0004\bT\u0010U¨\u0006Y"}, d2 = {"Lcom/inmobi/ads/InMobiNative;", "", "Landroid/content/Context;", "context", "", "placementId", "Lcom/inmobi/ads/listeners/NativeAdEventListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "<init>", "(Landroid/content/Context;JLcom/inmobi/ads/listeners/NativeAdEventListener;)V", "", "mPrimaryViewReturned", "", "setPrimaryViewReturned", "(Z)V", "setListener", "(Lcom/inmobi/ads/listeners/NativeAdEventListener;)V", "Lcom/inmobi/ads/listeners/VideoEventListener;", "setVideoEventListener", "(Lcom/inmobi/ads/listeners/VideoEventListener;)V", "getSignals", "()V", "", C3337ue.n, "load", "([B)V", "(Landroid/content/Context;)V", "Lcom/inmobi/ads/InMobiNative$LockScreenListener;", "lockScreenListener", "showOnLockScreen", "(Lcom/inmobi/ads/InMobiNative$LockScreenListener;)V", "takeAction", CampaignEx.JSON_NATIVE_VIDEO_PAUSE, CampaignEx.JSON_NATIVE_VIDEO_RESUME, "Landroid/view/View;", "convertView", "Landroid/view/ViewGroup;", "parent", "", "viewWidthInPixels", "getPrimaryViewOfWidth", "(Landroid/content/Context;Landroid/view/View;Landroid/view/ViewGroup;I)Landroid/view/View;", "reportAdClickAndOpenLandingPage", "isReady", "()Z", "", "", "extras", "setExtras", "(Ljava/util/Map;)V", "keywords", "setKeywords", "(Ljava/lang/String;)V", "contentUrl", "setContentUrl", "destroy", "Lcom/inmobi/media/U7;", "c", "Lcom/inmobi/media/U7;", "getMPubListener", "()Lcom/inmobi/media/U7;", "setMPubListener", "(Lcom/inmobi/media/U7;)V", "mPubListener", "Lorg/json/JSONObject;", "getCustomAdContent", "()Lorg/json/JSONObject;", "customAdContent", "getAdTitle", "()Ljava/lang/String;", "adTitle", "getAdDescription", "adDescription", "getAdIconUrl", "adIconUrl", "getAdLandingPageUrl", "adLandingPageUrl", "getAdCtaText", "adCtaText", "", "getAdRating", "()F", "adRating", "isAppDownload", "isVideo", "()Ljava/lang/Boolean;", "Companion", "LockScreenListener", "NativeCallbacks", "media_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class InMobiNative {
    public static final String j = "InMobiNative";

    /* renamed from: a, reason: collision with root package name */
    public final V8 f2217a;
    public final NativeCallbacks b;

    /* renamed from: c, reason: from kotlin metadata */
    public U7 mPubListener;
    public VideoEventListener d;
    public WeakReference e;
    public boolean f;
    public final Wa g;
    public WeakReference h;
    public LockScreenListener i;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/inmobi/ads/InMobiNative$LockScreenListener;", "", "onActionRequired", "", "nativeAd", "Lcom/inmobi/ads/InMobiNative;", "media_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface LockScreenListener {
        void onActionRequired(InMobiNative nativeAd);
    }

    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0005\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0011\u0010\fJ\u0017\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0012\u0010\u0010J\u000f\u0010\u0013\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0013\u0010\bJ\u0017\u0010\u0014\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0014\u0010\fJ\u000f\u0010\u0015\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0015\u0010\bJ#\u0010\u0019\u001a\u00020\u00062\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00170\u0016H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001b\u0010\bJ\u000f\u0010\u001c\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001c\u0010\bJ\u000f\u0010\u001d\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001d\u0010\bJ\u000f\u0010\u001e\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001e\u0010\bJ\u0017\u0010!\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b!\u0010\"J\u0017\u0010%\u001a\u00020\u00062\u0006\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\b%\u0010&J\u0017\u0010(\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\rH\u0016¢\u0006\u0004\b(\u0010\u0010J\u0019\u0010+\u001a\u00020\u00062\b\u0010*\u001a\u0004\u0018\u00010)H\u0016¢\u0006\u0004\b+\u0010,R\u0016\u0010/\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0014\u00103\u001a\u0002008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b1\u00102¨\u00064"}, d2 = {"Lcom/inmobi/ads/InMobiNative$NativeCallbacks;", "Lcom/inmobi/media/H8;", "Lcom/inmobi/ads/InMobiNative;", "inMobiNative", "<init>", "(Lcom/inmobi/ads/InMobiNative;)V", "", "resetHasGivenCallbackFlag", "()V", "Lcom/inmobi/ads/AdMetaInfo;", "info", "onAdFetchSuccessful", "(Lcom/inmobi/ads/AdMetaInfo;)V", "Lcom/inmobi/ads/InMobiAdRequestStatus;", "status", "onAdFetchFailed", "(Lcom/inmobi/ads/InMobiAdRequestStatus;)V", "onAdLoadSucceeded", C3355vf.b, "onAdWillDisplay", "onAdDisplayed", "onAdDismissed", "", "", "params", C3355vf.f, "(Ljava/util/Map;)V", "onUserLeftApplication", "onAdImpressed", "onVideoCompleted", "onVideoSkipped", "", "isMuted", "onAudioStateChanged", "(Z)V", "", AdActivity.REQUEST_KEY_EXTRA, "onRequestPayloadCreated", "([B)V", "reason", "onRequestPayloadCreationFailed", "Lcom/inmobi/media/Yd;", "telemetryOnAdImpression", "onAdImpression", "(Lcom/inmobi/media/Yd;)V", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Z", "mHasGivenCallback", "", "getType", "()B", "type", "media_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class NativeCallbacks extends H8 {

        /* renamed from: b, reason: from kotlin metadata */
        private boolean mHasGivenCallback;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NativeCallbacks(InMobiNative inMobiNative) {
            super(inMobiNative);
            Intrinsics.checkNotNullParameter(inMobiNative, "inMobiNative");
            this.mHasGivenCallback = true;
        }

        @Override // com.inmobi.ads.controllers.PublisherCallbacks
        public byte getType() {
            return (byte) 0;
        }

        @Override // com.inmobi.ads.controllers.PublisherCallbacks
        public void onAdClicked(Map<Object, ? extends Object> params) {
            Intrinsics.checkNotNullParameter(params, "params");
            InMobiNative ad = getNativeRef().get();
            if (ad == null) {
                String str = InMobiNative.j;
                Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
                AbstractC2680h7.a((byte) 1, str, "Lost reference to InMobiNative! callback cannot be given");
            } else {
                U7 mPubListener = ad.getMPubListener();
                if (mPubListener != null) {
                    Intrinsics.checkNotNullParameter(ad, "ad");
                    ((V7) mPubListener).f2461a.onAdClicked(ad);
                }
            }
        }

        @Override // com.inmobi.ads.controllers.PublisherCallbacks
        public void onAdDismissed() {
            InMobiNative ad = getNativeRef().get();
            if (ad == null) {
                String str = InMobiNative.j;
                Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
                AbstractC2680h7.a((byte) 1, str, "Lost reference to InMobiNative! callback cannot be given");
            } else {
                U7 mPubListener = ad.getMPubListener();
                if (mPubListener != null) {
                    Intrinsics.checkNotNullParameter(ad, "ad");
                    ((V7) mPubListener).f2461a.onAdFullScreenDismissed(ad);
                }
            }
        }

        @Override // com.inmobi.ads.controllers.PublisherCallbacks
        public void onAdDisplayed(AdMetaInfo info) {
            Intrinsics.checkNotNullParameter(info, "info");
            InMobiNative ad = getNativeRef().get();
            if (ad == null) {
                String str = InMobiNative.j;
                Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
                AbstractC2680h7.a((byte) 1, str, "Lost reference to InMobiNative! callback cannot be given");
            } else {
                U7 mPubListener = ad.getMPubListener();
                if (mPubListener != null) {
                    Intrinsics.checkNotNullParameter(ad, "ad");
                    ((V7) mPubListener).f2461a.onAdFullScreenDisplayed(ad);
                }
            }
        }

        @Override // com.inmobi.ads.controllers.PublisherCallbacks
        public void onAdFetchFailed(InMobiAdRequestStatus status) {
            Intrinsics.checkNotNullParameter(status, "status");
            onAdLoadFailed(status);
        }

        @Override // com.inmobi.ads.controllers.PublisherCallbacks
        public void onAdFetchSuccessful(AdMetaInfo info) {
            Intrinsics.checkNotNullParameter(info, "info");
            InMobiNative inMobiNative = getNativeRef().get();
            if (inMobiNative == null) {
                String str = InMobiNative.j;
                Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
                AbstractC2680h7.a((byte) 1, str, "Lost reference to InMobiNative! callback cannot be given");
            } else {
                U7 mPubListener = inMobiNative.getMPubListener();
                if (mPubListener != null) {
                    mPubListener.a(inMobiNative, info);
                }
            }
        }

        @Override // com.inmobi.ads.controllers.PublisherCallbacks
        public void onAdImpressed() {
            InMobiNative ad = getNativeRef().get();
            if (ad == null) {
                String str = InMobiNative.j;
                Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
                AbstractC2680h7.a((byte) 1, str, "Lost reference to InMobiNative! callback cannot be given");
            } else {
                U7 mPubListener = ad.getMPubListener();
                if (mPubListener != null) {
                    Intrinsics.checkNotNullParameter(ad, "ad");
                    ((V7) mPubListener).f2461a.onAdImpressed(ad);
                }
            }
        }

        @Override // com.inmobi.ads.controllers.PublisherCallbacks
        public void onAdImpression(Yd telemetryOnAdImpression) {
            InMobiNative inMobiNative = getNativeRef().get();
            U7 mPubListener = inMobiNative != null ? inMobiNative.getMPubListener() : null;
            if (mPubListener != null) {
                mPubListener.a(inMobiNative);
                if (telemetryOnAdImpression != null) {
                    telemetryOnAdImpression.d();
                    return;
                }
                return;
            }
            String str = InMobiNative.j;
            Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
            AbstractC2680h7.a((byte) 1, str, "Lost reference to InMobiNative! callback cannot be given");
            if (telemetryOnAdImpression != null) {
                telemetryOnAdImpression.c();
            }
        }

        @Override // com.inmobi.ads.controllers.PublisherCallbacks
        public void onAdLoadFailed(InMobiAdRequestStatus status) {
            Intrinsics.checkNotNullParameter(status, "status");
            InMobiNative inMobiNative = getNativeRef().get();
            if (inMobiNative == null) {
                String str = InMobiNative.j;
                Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
                AbstractC2680h7.a((byte) 1, str, "Lost reference to InMobiNative! callback cannot be given");
            } else {
                if (this.mHasGivenCallback) {
                    return;
                }
                this.mHasGivenCallback = true;
                U7 mPubListener = inMobiNative.getMPubListener();
                if (mPubListener != null) {
                    mPubListener.a(inMobiNative, status);
                }
            }
        }

        @Override // com.inmobi.ads.controllers.PublisherCallbacks
        public void onAdLoadSucceeded(AdMetaInfo info) {
            Intrinsics.checkNotNullParameter(info, "info");
            InMobiNative inMobiNative = getNativeRef().get();
            if (inMobiNative == null) {
                String str = InMobiNative.j;
                Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
                AbstractC2680h7.a((byte) 1, str, "Lost reference to InMobiNative! callback cannot be given");
            } else {
                if (this.mHasGivenCallback) {
                    return;
                }
                this.mHasGivenCallback = true;
                U7 mPubListener = inMobiNative.getMPubListener();
                if (mPubListener != null) {
                    mPubListener.b(inMobiNative, info);
                }
            }
        }

        @Override // com.inmobi.ads.controllers.PublisherCallbacks
        public void onAdWillDisplay() {
            InMobiNative ad = getNativeRef().get();
            if (ad == null) {
                String str = InMobiNative.j;
                Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
                AbstractC2680h7.a((byte) 1, str, "Lost reference to InMobiNative! callback cannot be given");
                return;
            }
            LockScreenListener lockScreenListener = ad.i;
            if (lockScreenListener != null) {
                lockScreenListener.onActionRequired(ad);
            }
            U7 mPubListener = ad.getMPubListener();
            if (mPubListener != null) {
                Intrinsics.checkNotNullParameter(ad, "ad");
                ((V7) mPubListener).f2461a.onAdFullScreenWillDisplay(ad);
            }
        }

        @Override // com.inmobi.ads.controllers.PublisherCallbacks
        public void onAudioStateChanged(boolean isMuted) {
            InMobiNative inMobiNative = getNativeRef().get();
            if (inMobiNative == null) {
                String str = InMobiNative.j;
                Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
                AbstractC2680h7.a((byte) 1, str, "Lost reference to InMobiNative! callback cannot be given");
            } else {
                VideoEventListener videoEventListener = inMobiNative.d;
                if (videoEventListener != null) {
                    videoEventListener.onAudioStateChanged(inMobiNative, isMuted);
                }
            }
        }

        @Override // com.inmobi.ads.controllers.PublisherCallbacks
        public void onRequestPayloadCreated(byte[] request) {
            Intrinsics.checkNotNullParameter(request, "request");
            InMobiNative inMobiNative = getNativeRef().get();
            if (inMobiNative == null) {
                String str = InMobiNative.j;
                Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
                AbstractC2680h7.a((byte) 1, str, "Lost reference to InMobiNative! callback cannot be given");
            } else {
                U7 mPubListener = inMobiNative.getMPubListener();
                if (mPubListener != null) {
                    ((V7) mPubListener).f2461a.onRequestPayloadCreated(request);
                }
            }
        }

        @Override // com.inmobi.ads.controllers.PublisherCallbacks
        public void onRequestPayloadCreationFailed(InMobiAdRequestStatus reason) {
            Intrinsics.checkNotNullParameter(reason, "reason");
            InMobiNative inMobiNative = getNativeRef().get();
            if (inMobiNative == null) {
                String str = InMobiNative.j;
                Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
                AbstractC2680h7.a((byte) 1, str, "Lost reference to InMobiNative! callback cannot be given");
            } else {
                U7 mPubListener = inMobiNative.getMPubListener();
                if (mPubListener != null) {
                    Intrinsics.checkNotNullParameter(reason, "status");
                    ((V7) mPubListener).f2461a.onRequestPayloadCreationFailed(reason);
                }
            }
        }

        @Override // com.inmobi.ads.controllers.PublisherCallbacks
        public void onUserLeftApplication() {
            InMobiNative ad = getNativeRef().get();
            if (ad == null) {
                String str = InMobiNative.j;
                Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
                AbstractC2680h7.a((byte) 1, str, "Lost reference to InMobiNative! callback cannot be given");
                return;
            }
            LockScreenListener lockScreenListener = ad.i;
            if (lockScreenListener != null) {
                lockScreenListener.onActionRequired(ad);
            }
            U7 mPubListener = ad.getMPubListener();
            if (mPubListener != null) {
                Intrinsics.checkNotNullParameter(ad, "ad");
                ((V7) mPubListener).f2461a.onUserWillLeaveApplication(ad);
            }
        }

        @Override // com.inmobi.ads.controllers.PublisherCallbacks
        public void onVideoCompleted() {
            InMobiNative inMobiNative = getNativeRef().get();
            if (inMobiNative == null) {
                String str = InMobiNative.j;
                Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
                AbstractC2680h7.a((byte) 1, str, "Lost reference to InMobiNative! callback cannot be given");
            } else {
                VideoEventListener videoEventListener = inMobiNative.d;
                if (videoEventListener != null) {
                    videoEventListener.onVideoCompleted(inMobiNative);
                }
            }
        }

        @Override // com.inmobi.ads.controllers.PublisherCallbacks
        public void onVideoSkipped() {
            InMobiNative inMobiNative = getNativeRef().get();
            if (inMobiNative == null) {
                String str = InMobiNative.j;
                Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
                AbstractC2680h7.a((byte) 1, str, "Lost reference to InMobiNative! callback cannot be given");
            } else {
                VideoEventListener videoEventListener = inMobiNative.d;
                if (videoEventListener != null) {
                    videoEventListener.onVideoSkipped(inMobiNative);
                }
            }
        }

        public final void resetHasGivenCallbackFlag() {
            this.mHasGivenCallback = false;
        }
    }

    public InMobiNative(Context context, long j2, NativeAdEventListener listener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Wa wa = new Wa();
        this.g = wa;
        if (!Uc.q()) {
            String TAG = j;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            throw new SdkNotInitializedException(TAG);
        }
        wa.f2471a = j2;
        this.h = new WeakReference(context);
        this.mPubListener = new V7(listener);
        NativeCallbacks nativeCallbacks = new NativeCallbacks(this);
        this.b = nativeCallbacks;
        this.f2217a = new V8(nativeCallbacks);
    }

    public final boolean a(boolean z) {
        if (!z && this.mPubListener == null) {
            String TAG = j;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            AbstractC2680h7.a((byte) 1, TAG, "Listener supplied is null, your call is ignored.");
            return false;
        }
        if (this.h.get() != null) {
            return true;
        }
        String TAG2 = j;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        AbstractC2680h7.a((byte) 1, TAG2, "Context supplied is null, your call is ignored.");
        return false;
    }

    public final void destroy() {
        View view;
        try {
            WeakReference weakReference = this.e;
            if (weakReference == null) {
                view = null;
            } else {
                Intrinsics.checkNotNull(weakReference);
                view = (View) weakReference.get();
            }
            if (view != null) {
                ((ViewGroup) view).removeAllViews();
            }
            this.f2217a.x();
            this.mPubListener = null;
            this.d = null;
            this.f = false;
        } catch (Exception e) {
            String TAG = j;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            AbstractC2680h7.a((byte) 1, TAG, "Failed to destroy ad; SDK encountered an unexpected error");
            S5 s5 = S5.f2425a;
            S5.d.a(AbstractC2920w5.a(e, "event"));
        }
    }

    public final String getAdCtaText() {
        try {
            return this.f2217a.y();
        } catch (Exception e) {
            String TAG = j;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            AbstractC2680h7.a((byte) 1, TAG, "Could not get the ctaText; SDK encountered unexpected error");
            S5 s5 = S5.f2425a;
            S5.d.a(AbstractC2920w5.a(e, "event"));
            return null;
        }
    }

    public final String getAdDescription() {
        try {
            return this.f2217a.z();
        } catch (Exception e) {
            String TAG = j;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            AbstractC2680h7.a((byte) 1, TAG, "Could not get the description; SDK encountered unexpected error");
            S5 s5 = S5.f2425a;
            S5.d.a(AbstractC2920w5.a(e, "event"));
            return null;
        }
    }

    public final String getAdIconUrl() {
        try {
            return this.f2217a.A();
        } catch (Exception e) {
            String TAG = j;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            AbstractC2680h7.a((byte) 1, TAG, "Could not get the iconUrl; SDK encountered unexpected error");
            S5 s5 = S5.f2425a;
            S5.d.a(AbstractC2920w5.a(e, "event"));
            return null;
        }
    }

    public final String getAdLandingPageUrl() {
        try {
            return this.f2217a.B();
        } catch (Exception e) {
            String TAG = j;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            AbstractC2680h7.a((byte) 1, TAG, "Could not get the adLandingPageUrl; SDK encountered unexpected error");
            S5 s5 = S5.f2425a;
            S5.d.a(AbstractC2920w5.a(e, "event"));
            return null;
        }
    }

    public final float getAdRating() {
        try {
            return this.f2217a.C();
        } catch (Exception e) {
            S5 s5 = S5.f2425a;
            S5.d.a(AbstractC2920w5.a(e, "event"));
            AbstractC2680h7.a((byte) 1, "InMobi", "Could not get rating; SDK encountered an unexpected error");
            String TAG = j;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            return 0.0f;
        }
    }

    public final String getAdTitle() {
        try {
            return this.f2217a.D();
        } catch (Exception e) {
            String TAG = j;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            AbstractC2680h7.a((byte) 1, TAG, "Could not get the ad title; SDK encountered unexpected error");
            S5 s5 = S5.f2425a;
            S5.d.a(AbstractC2920w5.a(e, "event"));
            return null;
        }
    }

    public final JSONObject getCustomAdContent() {
        try {
            return this.f2217a.E();
        } catch (Exception e) {
            String TAG = j;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            AbstractC2680h7.a((byte) 1, TAG, "Could not get the ad customJson ; SDK encountered unexpected error");
            S5 s5 = S5.f2425a;
            S5.d.a(AbstractC2920w5.a(e, "event"));
            return null;
        }
    }

    public final U7 getMPubListener() {
        return this.mPubListener;
    }

    public final View getPrimaryViewOfWidth(Context context, View convertView, ViewGroup parent, int viewWidthInPixels) {
        try {
            if (context == null) {
                String TAG = j;
                Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                AbstractC2680h7.a((byte) 1, TAG, "View can not be rendered using null context");
                return null;
            }
            C2596c8 c2596c8 = this.f2217a.j() == null ? null : (C2596c8) this.f2217a.j();
            if (c2596c8 == null) {
                String TAG2 = j;
                Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                AbstractC2680h7.a((byte) 1, TAG2, "InMobiNative is not initialized. Ignoring InMobiNative.getPrimaryView()");
                return null;
            }
            this.h = new WeakReference(context);
            c2596c8.a(context);
            Intrinsics.checkNotNull(parent);
            WeakReference weakReference = new WeakReference(c2596c8.a(convertView, parent, viewWidthInPixels));
            this.e = weakReference;
            View view = (View) weakReference.get();
            if (view != null) {
                this.f = true;
                return view;
            }
            String TAG3 = j;
            Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
            return null;
        } catch (Exception e) {
            S5 s5 = S5.f2425a;
            S5.d.a(AbstractC2920w5.a(e, "event"));
            AbstractC2680h7.a((byte) 1, "InMobi", "Could not pause ad; SDK encountered an unexpected error");
            String TAG4 = j;
            Intrinsics.checkNotNullExpressionValue(TAG4, "TAG");
            return null;
        }
    }

    @Deprecated(message = "Use [InMobiSdk.getToken] instead.")
    public final void getSignals() {
        if (a(false)) {
            this.b.resetHasGivenCallbackFlag();
            Context context = (Context) this.h.get();
            if (context != null) {
                this.f2217a.a(this.g, context, false, "getToken");
            }
            this.f2217a.a(this.b);
        }
    }

    public final boolean isAppDownload() {
        try {
            return this.f2217a.G();
        } catch (Exception e) {
            String TAG = j;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            AbstractC2680h7.a((byte) 1, TAG, "Could not get isAppDownload; SDK encountered unexpected error");
            S5 s5 = S5.f2425a;
            S5.d.a(AbstractC2920w5.a(e, "event"));
            return false;
        }
    }

    public final boolean isReady() {
        return this.f2217a.F();
    }

    public final Boolean isVideo() {
        try {
            return this.f2217a.I();
        } catch (Exception e) {
            String TAG = j;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            AbstractC2680h7.a((byte) 1, TAG, "Could not get isVideo; SDK encountered unexpected error");
            S5 s5 = S5.f2425a;
            S5.d.a(AbstractC2920w5.a(e, "event"));
            return null;
        }
    }

    public final void load(byte[] response) {
        if (a(false)) {
            if (Build.VERSION.SDK_INT >= 29) {
                U3.b((Context) this.h.get());
            }
            this.g.e = "AB";
            Context context = (Context) this.h.get();
            if (context != null) {
                this.f2217a.a(this.g, context, true, "native");
            }
            this.b.resetHasGivenCallbackFlag();
            this.f2217a.a(response, this.b);
        }
    }

    public final void pause() {
        try {
            this.f2217a.K();
        } catch (Exception unused) {
            String TAG = j;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            AbstractC2680h7.a((byte) 1, TAG, "Could not pause ad; SDK encountered an unexpected error");
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
        }
    }

    public final void reportAdClickAndOpenLandingPage() {
        try {
            this.f2217a.L();
        } catch (Exception e) {
            String TAG = j;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            AbstractC2680h7.a((byte) 1, TAG, "reportAdClickAndOpenLandingPage failed; SDK encountered unexpected error");
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            S5 s5 = S5.f2425a;
            S5.d.a(AbstractC2920w5.a(e, "event"));
        }
    }

    public final void resume() {
        try {
            this.f2217a.M();
        } catch (Exception unused) {
            String TAG = j;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            AbstractC2680h7.a((byte) 1, TAG, "Could not resume ad; SDK encountered an unexpected error");
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
        }
    }

    public final void setContentUrl(String contentUrl) {
        this.g.f = contentUrl;
    }

    public final void setExtras(Map<String, String> extras) {
        if (extras != null) {
            Vc.a(extras.get("tp"));
            Vc.b(extras.get("tp-v"));
        }
        this.g.c = extras;
    }

    public final void setKeywords(String keywords) {
        this.g.b = keywords;
    }

    public final void setListener(NativeAdEventListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mPubListener = new V7(listener);
    }

    public final void setMPubListener(U7 u7) {
        this.mPubListener = u7;
    }

    public final void setPrimaryViewReturned(boolean mPrimaryViewReturned) {
        this.f = mPrimaryViewReturned;
    }

    public final void setVideoEventListener(VideoEventListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.d = listener;
    }

    public final void showOnLockScreen(LockScreenListener lockScreenListener) {
        Intrinsics.checkNotNullParameter(lockScreenListener, "lockScreenListener");
        if (this.h.get() == null) {
            String TAG = j;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            AbstractC2680h7.a((byte) 1, TAG, "InMobiNative is not initialized. Provided context is null. Ignoring showOnLockScreen");
            return;
        }
        try {
            V8 v8 = this.f2217a;
            Wa wa = this.g;
            Object obj = this.h.get();
            Intrinsics.checkNotNull(obj);
            v8.a(wa, (Context) obj);
            this.i = lockScreenListener;
        } catch (Exception unused) {
            String TAG2 = j;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            AbstractC2680h7.a((byte) 1, TAG2, "SDK encountered unexpected error in showOnLockScreen");
        }
    }

    public final void takeAction() {
        try {
            this.f2217a.N();
        } catch (Exception unused) {
            String TAG = j;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            AbstractC2680h7.a((byte) 1, TAG, "SDK encountered unexpected error in takeAction");
        }
    }

    public final void load() {
        try {
            if (a(true)) {
                this.b.resetHasGivenCallbackFlag();
                if (this.f) {
                    V8 v8 = this.f2217a;
                    v8.a(v8.j(), new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.REPETITIVE_LOAD));
                    String TAG = j;
                    Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                    AbstractC2680h7.a((byte) 1, TAG, "You can call load() on an instance of InMobiNative only once if the ad request has been successful. Ignoring InMobiNative.load()");
                    return;
                }
                if (Build.VERSION.SDK_INT >= 29) {
                    U3.b((Context) this.h.get());
                }
                this.g.e = "NonAB";
                Context context = (Context) this.h.get();
                if (context != null) {
                    this.f2217a.a(this.g, context, true, "native");
                }
                this.f2217a.J();
            }
        } catch (Exception e) {
            this.f2217a.a((short) 2192);
            U7 u7 = this.mPubListener;
            if (u7 != null) {
                u7.a(this, new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR));
            }
            InterfaceC2971z5 p = this.f2217a.p();
            if (p != null) {
                String TAG2 = j;
                Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                ((A5) p).a(TAG2, "Load failed with unexpected error: ", e);
            }
        }
    }

    public final void load(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (a(true)) {
            this.h = new WeakReference(context);
            load();
        }
    }
}
