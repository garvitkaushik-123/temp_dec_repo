package com.inmobi.media;

import android.os.Handler;
import android.os.Looper;
import com.inmobi.ads.AdMetaInfo;
import com.inmobi.ads.InMobiAdRequestStatus;
import com.inmobi.ads.WatermarkData;
import com.inmobi.ads.controllers.PublisherCallbacks;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* renamed from: com.inmobi.media.we, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC2929we extends F0 {
    public static final C2913ve h = new C2913ve();
    private static final String i = "we";
    public static final String j = "An ad is currently being viewed by the user. Please wait for the user to close the ad before requesting for another ad for placement id: ";
    public static final String k = "Ad show is already called. Please wait for the the ad to be shown.";
    public static final String l = "preload() and load() cannot be called on the same instance, please use a different instance.";
    public static final String m = "Please make an ad request first in order to start loading the ad.";
    public static final String n = "An ad load is already in progress. Please wait for the load to complete before requesting for another ad for placement id: ";

    /* renamed from: a, reason: collision with root package name */
    private byte f2746a;
    private Boolean b;
    private PublisherCallbacks c;
    private final Handler d = new Handler(Looper.getMainLooper());
    private AdMetaInfo e;
    private InterfaceC2971z5 f;
    private WatermarkData g;

    public static /* synthetic */ void r() {
    }

    public final void a(byte b) {
        this.f2746a = b;
    }

    public final void b(PublisherCallbacks publisherCallbacks) {
        this.c = publisherCallbacks;
    }

    @Override // com.inmobi.media.F0
    public void c(AdMetaInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        InterfaceC2971z5 interfaceC2971z5 = this.f;
        if (interfaceC2971z5 != null) {
            String TAG = i;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) interfaceC2971z5).c(TAG, "onAdLoadSucceeded " + this);
        }
        this.e = info;
        S0 j2 = j();
        if (j2 != null) {
            j2.b((byte) 1);
        }
    }

    public final void d(AdMetaInfo adMetaInfo) {
        this.e = adMetaInfo;
    }

    @Override // com.inmobi.media.F0
    public void e() {
        InterfaceC2971z5 interfaceC2971z5 = this.f;
        if (interfaceC2971z5 != null) {
            String TAG = i;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) interfaceC2971z5).c(TAG, "onAdWillShow " + this);
        }
        byte b = this.f2746a;
        if (b == 4 || b == 5) {
            return;
        }
        this.d.post(new Runnable() { // from class: com.inmobi.media.we$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                AbstractC2929we.b(AbstractC2929we.this);
            }
        });
        InterfaceC2971z5 interfaceC2971z52 = this.f;
        if (interfaceC2971z52 != null) {
            String TAG2 = i;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            ((A5) interfaceC2971z52).d(TAG2, "AdManager state - WILL_DISPLAY");
        }
        this.f2746a = (byte) 4;
    }

    @Override // com.inmobi.media.F0
    public void h() {
        InterfaceC2971z5 interfaceC2971z5 = this.f;
        if (interfaceC2971z5 != null) {
            String TAG = i;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) interfaceC2971z5).c(TAG, "onUserLeftApplication " + this);
        }
        this.d.post(new Runnable() { // from class: com.inmobi.media.we$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                AbstractC2929we.c(AbstractC2929we.this);
            }
        });
    }

    public abstract S0 j();

    public final JSONObject k() {
        JSONObject bidInfo;
        AdMetaInfo adMetaInfo = this.e;
        return (adMetaInfo == null || (bidInfo = adMetaInfo.getBidInfo()) == null) ? new JSONObject() : bidInfo;
    }

    public final PublisherCallbacks l() {
        return this.c;
    }

    public final String m() {
        String creativeID;
        AdMetaInfo adMetaInfo = this.e;
        return (adMetaInfo == null || (creativeID = adMetaInfo.getCreativeID()) == null) ? "" : creativeID;
    }

    public final AdMetaInfo n() {
        return this.e;
    }

    public final byte o() {
        return v() ? (byte) 2 : (byte) 1;
    }

    public final InterfaceC2971z5 p() {
        return this.f;
    }

    public final byte q() {
        return this.f2746a;
    }

    public final Handler s() {
        return this.d;
    }

    public final WatermarkData t() {
        return this.g;
    }

    public final Boolean u() {
        return this.b;
    }

    public final boolean v() {
        PublisherCallbacks publisherCallbacks = this.c;
        return publisherCallbacks != null && publisherCallbacks.getType() == 1;
    }

    public void w() {
        InterfaceC2971z5 interfaceC2971z5 = this.f;
        if (interfaceC2971z5 != null) {
            String TAG = i;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) interfaceC2971z5).c(TAG, "submitAdLoadCalled " + this);
        }
        S0 j2 = j();
        if (j2 != null) {
            j2.t0();
        }
    }

    public final void a(Boolean bool) {
        this.b = bool;
    }

    public final void b(WatermarkData watermarkData) {
        this.g = watermarkData;
    }

    public final void a(InterfaceC2971z5 interfaceC2971z5) {
        this.f = interfaceC2971z5;
    }

    public final void b(final S0 s0, final InMobiAdRequestStatus status) {
        Intrinsics.checkNotNullParameter(status, "status");
        InterfaceC2971z5 interfaceC2971z5 = this.f;
        if (interfaceC2971z5 != null) {
            String TAG = i;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) interfaceC2971z5).c(TAG, "onLoadFailure " + this);
        }
        InterfaceC2971z5 interfaceC2971z52 = this.f;
        if (interfaceC2971z52 != null) {
            String TAG2 = i;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            ((A5) interfaceC2971z52).d(TAG2, "AdManager state - LOAD_FAILED");
        }
        this.f2746a = (byte) 3;
        this.d.post(new Runnable() { // from class: com.inmobi.media.we$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                AbstractC2929we.a(S0.this, this, status);
            }
        });
    }

    public static final void a(S0 s0, AbstractC2929we this$0, InMobiAdRequestStatus status) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(status, "$status");
        if (s0 != null) {
            s0.b((byte) 1);
        }
        InterfaceC2971z5 interfaceC2971z5 = this$0.f;
        if (interfaceC2971z5 != null) {
            String TAG = i;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) interfaceC2971z5).a(TAG, "callback - onAdLoadFailed");
        }
        PublisherCallbacks publisherCallbacks = this$0.c;
        if (publisherCallbacks != null) {
            publisherCallbacks.onAdLoadFailed(status);
        }
        InterfaceC2971z5 interfaceC2971z52 = this$0.f;
        if (interfaceC2971z52 != null) {
            ((A5) interfaceC2971z52).a();
        }
    }

    public static final void c(AbstractC2929we this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        InterfaceC2971z5 interfaceC2971z5 = this$0.f;
        if (interfaceC2971z5 != null) {
            String TAG = i;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) interfaceC2971z5).a(TAG, "callback - onUserLeftApplication");
        }
        PublisherCallbacks publisherCallbacks = this$0.c;
        if (publisherCallbacks != null) {
            publisherCallbacks.onUserLeftApplication();
        }
    }

    @Override // com.inmobi.media.F0
    public void b(AdMetaInfo info) {
        S0 j2;
        Intrinsics.checkNotNullParameter(info, "info");
        InterfaceC2971z5 interfaceC2971z5 = this.f;
        if (interfaceC2971z5 != null) {
            String TAG = i;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) interfaceC2971z5).c(TAG, "onAdFetchSuccess " + this);
        }
        InterfaceC2971z5 interfaceC2971z52 = this.f;
        if (interfaceC2971z52 != null) {
            String TAG2 = i;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            ((A5) interfaceC2971z52).d(TAG2, "AdManager state - FETCHED");
        }
        this.f2746a = (byte) 7;
        if (!v() || (j2 = j()) == null) {
            return;
        }
        j2.b((byte) 2);
    }

    @Override // com.inmobi.media.F0
    public void a(final InMobiAdRequestStatus status) {
        Intrinsics.checkNotNullParameter(status, "status");
        InterfaceC2971z5 interfaceC2971z5 = this.f;
        if (interfaceC2971z5 != null) {
            String TAG = i;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) interfaceC2971z5).c(TAG, "onAdFetchFailed " + this);
        }
        this.f2746a = (byte) 3;
        this.d.post(new Runnable() { // from class: com.inmobi.media.we$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                AbstractC2929we.a(AbstractC2929we.this, status);
            }
        });
    }

    public static final void a(AbstractC2929we this$0, InMobiAdRequestStatus status) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(status, "$status");
        InterfaceC2971z5 interfaceC2971z5 = this$0.f;
        if (interfaceC2971z5 != null) {
            String TAG = i;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) interfaceC2971z5).a(TAG, "callback - onAdFetchFailed");
        }
        PublisherCallbacks publisherCallbacks = this$0.c;
        if (publisherCallbacks != null) {
            publisherCallbacks.onAdFetchFailed(status);
        }
        InterfaceC2971z5 interfaceC2971z52 = this$0.f;
        if (interfaceC2971z52 != null) {
            ((A5) interfaceC2971z52).a();
        }
    }

    public static final void b(AbstractC2929we this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        InterfaceC2971z5 interfaceC2971z5 = this$0.f;
        if (interfaceC2971z5 != null) {
            String TAG = i;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) interfaceC2971z5).a(TAG, "callback - onAdWillShow");
        }
        PublisherCallbacks publisherCallbacks = this$0.c;
        if (publisherCallbacks != null) {
            publisherCallbacks.onAdWillDisplay();
        }
    }

    @Override // com.inmobi.media.F0
    public void a(final AdMetaInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        InterfaceC2971z5 interfaceC2971z5 = this.f;
        if (interfaceC2971z5 != null) {
            String TAG = i;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) interfaceC2971z5).c(TAG, "onAdDisplayed " + this);
        }
        if (this.f2746a != 5) {
            this.e = info;
            this.d.post(new Runnable() { // from class: com.inmobi.media.we$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    AbstractC2929we.a(AbstractC2929we.this, info);
                }
            });
            InterfaceC2971z5 interfaceC2971z52 = this.f;
            if (interfaceC2971z52 != null) {
                String TAG2 = i;
                Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                ((A5) interfaceC2971z52).d(TAG2, "AdManager state - DISPLAYED");
            }
            this.f2746a = (byte) 5;
        }
    }

    @Override // com.inmobi.media.F0
    public void b(final Map<Object, ? extends Object> rewards) {
        Intrinsics.checkNotNullParameter(rewards, "rewards");
        InterfaceC2971z5 interfaceC2971z5 = this.f;
        if (interfaceC2971z5 != null) {
            String TAG = i;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) interfaceC2971z5).c(TAG, "onAdRewardActionCompleted " + this);
        }
        this.d.post(new Runnable() { // from class: com.inmobi.media.we$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                AbstractC2929we.b(AbstractC2929we.this, rewards);
            }
        });
    }

    public static final void b(AbstractC2929we this$0, Map rewards) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(rewards, "$rewards");
        InterfaceC2971z5 interfaceC2971z5 = this$0.f;
        if (interfaceC2971z5 != null) {
            String TAG = i;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) interfaceC2971z5).a(TAG, "callback - onRewardsUnlocked");
        }
        PublisherCallbacks publisherCallbacks = this$0.c;
        if (publisherCallbacks != null) {
            publisherCallbacks.onRewardsUnlocked(rewards);
        }
    }

    @Override // com.inmobi.media.F0
    public void b(final InMobiAdRequestStatus reason) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        InterfaceC2971z5 interfaceC2971z5 = this.f;
        if (interfaceC2971z5 != null) {
            String TAG = i;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) interfaceC2971z5).c(TAG, "onRequestCreationFailed " + this);
        }
        this.d.post(new Runnable() { // from class: com.inmobi.media.we$$ExternalSyntheticLambda12
            @Override // java.lang.Runnable
            public final void run() {
                AbstractC2929we.b(AbstractC2929we.this, reason);
            }
        });
    }

    public static final void b(AbstractC2929we this$0, InMobiAdRequestStatus reason) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(reason, "$reason");
        InterfaceC2971z5 interfaceC2971z5 = this$0.f;
        if (interfaceC2971z5 != null) {
            String TAG = i;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) interfaceC2971z5).a(TAG, "callback - onRequestPayloadCreationFailed");
        }
        PublisherCallbacks publisherCallbacks = this$0.c;
        if (publisherCallbacks != null) {
            publisherCallbacks.onRequestPayloadCreationFailed(reason);
        }
        InterfaceC2971z5 interfaceC2971z52 = this$0.f;
        if (interfaceC2971z52 != null) {
            ((A5) interfaceC2971z52).a();
        }
    }

    public static final void a(AbstractC2929we this$0, AdMetaInfo info) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(info, "$info");
        InterfaceC2971z5 interfaceC2971z5 = this$0.f;
        if (interfaceC2971z5 != null) {
            String TAG = i;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) interfaceC2971z5).a(TAG, "callback - onAdDisplayed");
        }
        PublisherCallbacks publisherCallbacks = this$0.c;
        if (publisherCallbacks != null) {
            publisherCallbacks.onAdDisplayed(info);
        }
    }

    @Override // com.inmobi.media.F0
    public void b() {
        InterfaceC2971z5 interfaceC2971z5 = this.f;
        if (interfaceC2971z5 != null) {
            String TAG = i;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) interfaceC2971z5).c(TAG, "onAdDismissed " + this);
        }
        this.d.post(new Runnable() { // from class: com.inmobi.media.we$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                AbstractC2929we.a(AbstractC2929we.this);
            }
        });
        InterfaceC2971z5 interfaceC2971z52 = this.f;
        if (interfaceC2971z52 != null) {
            ((A5) interfaceC2971z52).a();
        }
    }

    @Override // com.inmobi.media.F0
    public void a(S0 s0, InMobiAdRequestStatus status) {
        Intrinsics.checkNotNullParameter(status, "status");
        InterfaceC2971z5 interfaceC2971z5 = this.f;
        if (interfaceC2971z5 != null) {
            String TAG = i;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) interfaceC2971z5).c(TAG, "onAdLoadFailed " + this);
        }
        b(s0, status);
    }

    @Override // com.inmobi.media.F0
    public void a(final Map<Object, ? extends Object> params) {
        Intrinsics.checkNotNullParameter(params, "params");
        InterfaceC2971z5 interfaceC2971z5 = this.f;
        if (interfaceC2971z5 != null) {
            String TAG = i;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) interfaceC2971z5).c(TAG, "onAdInteraction " + this);
        }
        this.d.post(new Runnable() { // from class: com.inmobi.media.we$$ExternalSyntheticLambda10
            @Override // java.lang.Runnable
            public final void run() {
                AbstractC2929we.a(AbstractC2929we.this, params);
            }
        });
    }

    public static final void a(AbstractC2929we this$0, Map params) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(params, "$params");
        InterfaceC2971z5 interfaceC2971z5 = this$0.f;
        if (interfaceC2971z5 != null) {
            String TAG = i;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) interfaceC2971z5).a(TAG, "callback - onAdClicked");
        }
        PublisherCallbacks publisherCallbacks = this$0.c;
        if (publisherCallbacks != null) {
            publisherCallbacks.onAdClicked(params);
        }
    }

    public final void a(PublisherCallbacks callbacks) {
        Intrinsics.checkNotNullParameter(callbacks, "callbacks");
        InterfaceC2971z5 interfaceC2971z5 = this.f;
        if (interfaceC2971z5 != null) {
            String TAG = i;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) interfaceC2971z5).a(TAG, "getSignals " + this);
        }
        if (j() != null) {
            S0 j2 = j();
            if (j2 != null) {
                j2.y0();
            }
            this.c = callbacks;
            S0 j3 = j();
            if (j3 != null) {
                j3.P();
            }
        }
    }

    public void a(byte[] bArr, PublisherCallbacks callbacks) {
        S0 j2;
        S0 j3;
        Intrinsics.checkNotNullParameter(callbacks, "callbacks");
        InterfaceC2971z5 interfaceC2971z5 = this.f;
        if (interfaceC2971z5 != null) {
            String TAG = i;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) interfaceC2971z5).c(TAG, "load " + this);
        }
        if (Intrinsics.areEqual(this.b, Boolean.TRUE)) {
            AbstractC2680h7.a((byte) 1, "InMobi", "Cannot call load(byte[]) API after load() API is called");
            InterfaceC2971z5 interfaceC2971z52 = this.f;
            if (interfaceC2971z52 != null) {
                String TAG2 = i;
                Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                ((A5) interfaceC2971z52).a(TAG2, "Cannot call load(byte[]) API after load() API is called");
            }
            b(j(), new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.REPETITIVE_LOAD));
            S0 j4 = j();
            if (j4 != null) {
                j4.a((short) 2140);
                return;
            }
            return;
        }
        this.b = Boolean.FALSE;
        this.f2746a = (byte) 1;
        InterfaceC2971z5 interfaceC2971z53 = this.f;
        if (interfaceC2971z53 != null && (j3 = j()) != null) {
            j3.a(interfaceC2971z53);
        }
        if (j() == null || (j2 = j()) == null || !j2.e((byte) 1)) {
            return;
        }
        InterfaceC2971z5 interfaceC2971z54 = this.f;
        if (interfaceC2971z54 != null) {
            String TAG3 = i;
            Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
            ((A5) interfaceC2971z54).a(TAG3, "load starting. Started INTERNAL_LOAD_TIMER");
        }
        this.c = callbacks;
        S0 j5 = j();
        if (j5 != null) {
            j5.a(bArr);
        }
    }

    @Override // com.inmobi.media.F0
    public void a(final byte[] request) {
        Intrinsics.checkNotNullParameter(request, "request");
        InterfaceC2971z5 interfaceC2971z5 = this.f;
        if (interfaceC2971z5 != null) {
            String TAG = i;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) interfaceC2971z5).c(TAG, "onRequestCreated " + this);
        }
        this.d.post(new Runnable() { // from class: com.inmobi.media.we$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                AbstractC2929we.a(AbstractC2929we.this, request);
            }
        });
    }

    public static final void a(AbstractC2929we this$0, byte[] request) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(request, "$request");
        InterfaceC2971z5 interfaceC2971z5 = this$0.f;
        if (interfaceC2971z5 != null) {
            String TAG = i;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) interfaceC2971z5).a(TAG, "callback - onRequestPayloadCreated");
        }
        PublisherCallbacks publisherCallbacks = this$0.c;
        if (publisherCallbacks != null) {
            publisherCallbacks.onRequestPayloadCreated(request);
        }
        InterfaceC2971z5 interfaceC2971z52 = this$0.f;
        if (interfaceC2971z52 != null) {
            ((A5) interfaceC2971z52).a();
        }
    }

    public void a(WatermarkData watermarkData) {
        Intrinsics.checkNotNullParameter(watermarkData, "watermarkData");
        InterfaceC2971z5 interfaceC2971z5 = this.f;
        if (interfaceC2971z5 != null) {
            String str = i;
            ((A5) interfaceC2971z5).c(str, H6.a(str, "TAG", "setWatermark - ").append(watermarkData.getWatermarkBase64EncodedString()).toString());
        }
        this.g = watermarkData;
    }

    public final boolean a(String tag, String placementString, PublisherCallbacks publisherCallbacks) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(placementString, "placementString");
        InterfaceC2971z5 interfaceC2971z5 = this.f;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).c(tag, "canProceedToLoad " + this);
        }
        PublisherCallbacks publisherCallbacks2 = this.c;
        if (publisherCallbacks2 != null && publisherCallbacks != null && publisherCallbacks2.getType() != publisherCallbacks.getType()) {
            String TAG = i;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            AbstractC2680h7.a((byte) 1, TAG, l);
            InterfaceC2971z5 interfaceC2971z52 = this.f;
            if (interfaceC2971z52 != null) {
                ((A5) interfaceC2971z52).b(tag, l);
            }
            S0 j2 = j();
            if (j2 != null) {
                j2.a((short) 2005);
            }
            b(j(), new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.REPETITIVE_LOAD));
            return false;
        }
        byte b = this.f2746a;
        if (b == 8) {
            AbstractC2680h7.a((byte) 1, tag, n + placementString);
            InterfaceC2971z5 interfaceC2971z53 = this.f;
            if (interfaceC2971z53 != null) {
                ((A5) interfaceC2971z53).b(tag, AbstractC2673h0.a(n, placementString));
            }
            S0 j3 = j();
            if (j3 != null) {
                j3.a((short) 2002);
            }
        } else if (b == 1) {
            AbstractC2680h7.a((byte) 1, tag, n + placementString);
            InterfaceC2971z5 interfaceC2971z54 = this.f;
            if (interfaceC2971z54 != null) {
                ((A5) interfaceC2971z54).b(tag, AbstractC2673h0.a(n, placementString));
            }
            S0 j4 = j();
            if (j4 != null) {
                j4.a((short) 2001);
            }
        } else {
            if (b != 5) {
                return true;
            }
            AbstractC2680h7.a((byte) 1, tag, j + placementString);
            InterfaceC2971z5 interfaceC2971z55 = this.f;
            if (interfaceC2971z55 != null) {
                ((A5) interfaceC2971z55).b(tag, AbstractC2673h0.a(j, placementString));
            }
            b(j(), new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.AD_ACTIVE));
            S0 j5 = j();
            if (j5 != null) {
                j5.b((short) 2003);
            }
        }
        return false;
    }

    public final boolean a(String tag, String placementString) throws IllegalStateException {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(placementString, "placementString");
        InterfaceC2971z5 interfaceC2971z5 = this.f;
        if (interfaceC2971z5 != null) {
            String TAG = i;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) interfaceC2971z5).c(TAG, "canRender " + this);
        }
        byte b = this.f2746a;
        if (b == 1) {
            AbstractC2680h7.a((byte) 1, tag, n + placementString);
            InterfaceC2971z5 interfaceC2971z52 = this.f;
            if (interfaceC2971z52 != null) {
                String TAG2 = i;
                Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                ((A5) interfaceC2971z52).b(TAG2, "adload in progress");
            }
            S0 j2 = j();
            if (j2 != null) {
                j2.b((short) 2129);
            }
        } else {
            if (b != 8) {
                if (b == 5) {
                    AbstractC2680h7.a((byte) 1, tag, j + placementString);
                    InterfaceC2971z5 interfaceC2971z53 = this.f;
                    if (interfaceC2971z53 != null) {
                        String TAG3 = i;
                        Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
                        ((A5) interfaceC2971z53).b(TAG3, "ad active before renderAd");
                    }
                    S0 j3 = j();
                    if (j3 != null) {
                        j3.b((short) 2130);
                    }
                    S0 j4 = j();
                    if (j4 != null) {
                        j4.m0();
                    }
                    b(j(), new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.AD_ACTIVE));
                    return false;
                }
                if (b == 7) {
                    return true;
                }
                InterfaceC2971z5 interfaceC2971z54 = this.f;
                if (interfaceC2971z54 != null) {
                    String TAG4 = i;
                    Intrinsics.checkNotNullExpressionValue(TAG4, "TAG");
                    ((A5) interfaceC2971z54).b(TAG4, "ad in illegal state");
                }
                S0 j5 = j();
                if (j5 != null) {
                    j5.b((short) 2165);
                }
                S0 j6 = j();
                if (j6 != null) {
                    j6.m0();
                }
                b(j(), new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR));
                throw new IllegalStateException(m);
            }
            AbstractC2680h7.a((byte) 1, tag, n + placementString);
            InterfaceC2971z5 interfaceC2971z55 = this.f;
            if (interfaceC2971z55 != null) {
                String TAG5 = i;
                Intrinsics.checkNotNullExpressionValue(TAG5, "TAG");
                ((A5) interfaceC2971z55).b(TAG5, "ad loading into view is in progress");
            }
            S0 j7 = j();
            if (j7 != null) {
                j7.b((short) 2164);
            }
        }
        return false;
    }

    public static final void a(AbstractC2929we this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        InterfaceC2971z5 interfaceC2971z5 = this$0.f;
        if (interfaceC2971z5 != null) {
            String TAG = i;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) interfaceC2971z5).a(TAG, "callback - onAdDismissed");
        }
        PublisherCallbacks publisherCallbacks = this$0.c;
        if (publisherCallbacks != null) {
            publisherCallbacks.onAdDismissed();
            return;
        }
        InterfaceC2971z5 interfaceC2971z52 = this$0.f;
        if (interfaceC2971z52 != null) {
            String TAG2 = i;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            ((A5) interfaceC2971z52).b(TAG2, "callback is null");
        }
    }

    @Override // com.inmobi.media.F0
    public void a(final Yd yd) {
        InterfaceC2971z5 interfaceC2971z5 = this.f;
        if (interfaceC2971z5 != null) {
            String TAG = i;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) interfaceC2971z5).c(TAG, "onAdImpression " + this);
        }
        this.d.post(new Runnable() { // from class: com.inmobi.media.we$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                AbstractC2929we.a(AbstractC2929we.this, yd);
            }
        });
    }

    public static final void a(AbstractC2929we this$0, Yd yd) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.c == null) {
            InterfaceC2971z5 interfaceC2971z5 = this$0.f;
            if (interfaceC2971z5 != null) {
                String TAG = i;
                Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                ((A5) interfaceC2971z5).b(TAG, "callback is null");
            }
            if (yd != null) {
                yd.c();
                return;
            }
            return;
        }
        InterfaceC2971z5 interfaceC2971z52 = this$0.f;
        if (interfaceC2971z52 != null) {
            String TAG2 = i;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            ((A5) interfaceC2971z52).a(TAG2, "callback - onAdImpression");
        }
        PublisherCallbacks publisherCallbacks = this$0.c;
        if (publisherCallbacks != null) {
            publisherCallbacks.onAdImpression(yd);
        }
    }

    @Override // com.inmobi.media.F0
    public void a(final D1 audioStatusInternal) {
        Intrinsics.checkNotNullParameter(audioStatusInternal, "audioStatusInternal");
        this.d.post(new Runnable() { // from class: com.inmobi.media.we$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                AbstractC2929we.a(AbstractC2929we.this, audioStatusInternal);
            }
        });
    }

    public static final void a(AbstractC2929we this$0, D1 audioStatusInternal) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(audioStatusInternal, "$audioStatusInternal");
        InterfaceC2971z5 interfaceC2971z5 = this$0.f;
        if (interfaceC2971z5 != null) {
            String str = i;
            ((A5) interfaceC2971z5).a(str, H6.a(str, "TAG", "callback - onAudioStatusChanged - ").append(audioStatusInternal.f2257a).toString());
        }
        PublisherCallbacks publisherCallbacks = this$0.c;
        if (publisherCallbacks != null) {
            publisherCallbacks.onAudioStatusChanged(audioStatusInternal);
        }
    }

    @Override // com.inmobi.media.F0
    public void a(final String log) {
        Intrinsics.checkNotNullParameter(log, "log");
        this.d.post(new Runnable() { // from class: com.inmobi.media.we$$ExternalSyntheticLambda11
            @Override // java.lang.Runnable
            public final void run() {
                AbstractC2929we.a(AbstractC2929we.this, log);
            }
        });
    }

    public static final void a(AbstractC2929we this$0, String log) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(log, "$log");
        InterfaceC2971z5 interfaceC2971z5 = this$0.f;
        if (interfaceC2971z5 != null) {
            String TAG = i;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) interfaceC2971z5).a(TAG, "callback - onImraidLog");
        }
        PublisherCallbacks publisherCallbacks = this$0.c;
        if (publisherCallbacks != null) {
            publisherCallbacks.onImraidLog(log);
        }
    }

    public void a(short s) {
        InterfaceC2971z5 interfaceC2971z5 = this.f;
        if (interfaceC2971z5 != null) {
            String TAG = i;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) interfaceC2971z5).c(TAG, "submitAdLoadDroppedAtSDK " + this);
        }
        S0 j2 = j();
        if (j2 != null) {
            j2.a(s);
        }
    }
}
