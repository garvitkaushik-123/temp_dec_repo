package com.inmobi.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.WindowInsets;
import android.widget.RelativeLayout;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.inmobi.ads.InMobiAdRequestStatus;
import com.inmobi.ads.exceptions.InvalidPlacementIdException;
import com.inmobi.ads.exceptions.SdkNotInitializedException;
import com.inmobi.ads.listeners.AudioAdEventListener;
import com.inmobi.commons.core.configs.AdConfig;
import com.inmobi.commons.core.configs.Config;
import com.inmobi.media.A1;
import com.inmobi.media.A5;
import com.inmobi.media.AbstractC2680h7;
import com.inmobi.media.AbstractC2808p5;
import com.inmobi.media.B2;
import com.inmobi.media.C2967z1;
import com.inmobi.media.Cb;
import com.inmobi.media.E1;
import com.inmobi.media.EnumC2560a7;
import com.inmobi.media.F1;
import com.inmobi.media.InterfaceC2971z5;
import com.inmobi.media.L3;
import com.inmobi.media.M2;
import com.inmobi.media.Md;
import com.inmobi.media.O2;
import com.inmobi.media.U3;
import com.inmobi.media.Uc;
import com.inmobi.media.V3;
import com.inmobi.media.Vc;
import com.inmobi.media.ViewTreeObserverOnGlobalLayoutListenerC2824q5;
import com.inmobi.media.Wa;
import com.inmobi.media.X;
import com.inmobi.media.Z;
import com.ironsource.C3207n2;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u0001)B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0006\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u000e\u0010\rJ#\u0010\u0012\u001a\u00020\u000b2\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0010¢\u0006\u0004\b\u0018\u0010\u0016J\u0015\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\r\u0010\u001d\u001a\u00020\u000b¢\u0006\u0004\b\u001d\u0010\rJ\u000f\u0010\u001e\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\u001e\u0010\rJ\u000f\u0010\u001f\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\u001f\u0010\rJ!\u0010#\u001a\u00020\u000b2\b\b\u0001\u0010!\u001a\u00020 2\b\b\u0001\u0010\"\u001a\u00020 ¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u000bH\u0007¢\u0006\u0004\b%\u0010\rJ\r\u0010&\u001a\u00020\u000b¢\u0006\u0004\b&\u0010\rJ\r\u0010'\u001a\u00020\u000b¢\u0006\u0004\b'\u0010\rJ\u000f\u0010(\u001a\u00020\u000bH\u0007¢\u0006\u0004\b(\u0010\rR$\u0010.\u001a\u0004\u0018\u00010\u00198\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010\u001cR$\u00106\u001a\u0004\u0018\u00010/8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u0014\u00109\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b7\u00108¨\u0006:"}, d2 = {"Lcom/inmobi/ads/InMobiAudio;", "Landroid/widget/RelativeLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "placementId", "(Landroid/content/Context;J)V", "", "load", "()V", C3207n2.v, "", "", "extras", "setExtras", "(Ljava/util/Map;)V", "keywords", "setKeywords", "(Ljava/lang/String;)V", "contentUrl", "setContentUrl", "Lcom/inmobi/ads/listeners/AudioAdEventListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setListener", "(Lcom/inmobi/ads/listeners/AudioAdEventListener;)V", "disableHardwareAcceleration", "onAttachedToWindow", "onDetachedFromWindow", "", "widthInDp", "heightInDp", "setAudioSize", "(II)V", "setupViewSizeObserver", CampaignEx.JSON_NATIVE_VIDEO_RESUME, CampaignEx.JSON_NATIVE_VIDEO_PAUSE, "destroy", "a", "Lcom/inmobi/ads/listeners/AudioAdEventListener;", "getMPubListener$media_release", "()Lcom/inmobi/ads/listeners/AudioAdEventListener;", "setMPubListener$media_release", "mPubListener", "Lcom/inmobi/media/E1;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/inmobi/media/E1;", "getMAdManager$media_release", "()Lcom/inmobi/media/E1;", "setMAdManager$media_release", "(Lcom/inmobi/media/E1;)V", "mAdManager", "getFrameSizeString", "()Ljava/lang/String;", "frameSizeString", "media_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class InMobiAudio extends RelativeLayout {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public AudioAdEventListener mPubListener;

    /* renamed from: b, reason: from kotlin metadata */
    public E1 mAdManager;
    public final WeakReference c;
    public final Wa d;
    public long e;
    public int f;
    public int g;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/inmobi/ads/InMobiAudio$a;", "Lcom/inmobi/media/A1;", "Lcom/inmobi/ads/InMobiAudio;", "audio", "<init>", "(Lcom/inmobi/ads/InMobiAudio;)V", "Lcom/inmobi/ads/AdMetaInfo;", "info", "", "onAdFetchSuccessful", "(Lcom/inmobi/ads/AdMetaInfo;)V", "Lcom/inmobi/ads/InMobiAdRequestStatus;", "status", "onAdFetchFailed", "(Lcom/inmobi/ads/InMobiAdRequestStatus;)V", "", "getType", "()B", "type", "media_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class a extends A1 {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(InMobiAudio audio) {
            super(audio);
            Intrinsics.checkNotNullParameter(audio, "audio");
        }

        @Override // com.inmobi.ads.controllers.PublisherCallbacks
        public byte getType() {
            return (byte) 0;
        }

        @Override // com.inmobi.ads.controllers.PublisherCallbacks
        public void onAdFetchFailed(InMobiAdRequestStatus status) {
            AudioAdEventListener mPubListener;
            Intrinsics.checkNotNullParameter(status, "status");
            InMobiAudio inMobiAudio = a().get();
            if (inMobiAudio == null || (mPubListener = inMobiAudio.getMPubListener()) == null) {
                return;
            }
            mPubListener.onAdLoadFailed(inMobiAudio, status);
        }

        @Override // com.inmobi.media.A1, com.inmobi.ads.controllers.PublisherCallbacks
        public void onAdFetchSuccessful(AdMetaInfo info) {
            Intrinsics.checkNotNullParameter(info, "info");
            super.onAdFetchSuccessful(info);
            InMobiAudio inMobiAudio = a().get();
            if (inMobiAudio == null) {
                return;
            }
            try {
                E1 mAdManager = inMobiAudio.getMAdManager();
                if (mAdManager != null) {
                    mAdManager.y();
                }
            } catch (IllegalStateException e) {
                AbstractC2680h7.a((byte) 1, "InMobiAudio", e.getMessage());
                AudioAdEventListener mPubListener = inMobiAudio.getMPubListener();
                if (mPubListener != null) {
                    mPubListener.onAdLoadFailed(inMobiAudio, new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR));
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0108  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public InMobiAudio(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        long j;
        StringBuilder sb;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attributeSet");
        a aVar = new a(this);
        this.d = new Wa();
        if (!Uc.q()) {
            throw new SdkNotInitializedException("InMobiAudio");
        }
        if (context instanceof Activity) {
            this.c = new WeakReference(context);
        }
        this.mAdManager = new E1(aVar);
        String attributeValue = attributeSet.getAttributeValue("http://schemas.android.com/apk/lib/com.inmobi.ads", "placementId");
        if (attributeValue != null) {
            try {
                int length = attributeValue.length() - 1;
                int i = 0;
                boolean z = false;
                while (i <= length) {
                    boolean z2 = Intrinsics.compare((int) attributeValue.charAt(!z ? i : length), 32) <= 0;
                    if (z) {
                        if (!z2) {
                            break;
                        } else {
                            length--;
                        }
                    } else if (z2) {
                        i++;
                    } else {
                        z = true;
                    }
                }
                sb = new StringBuilder(attributeValue.subSequence(i, length + 1).toString());
            } catch (NumberFormatException unused) {
                AbstractC2680h7.a((byte) 1, "InMobiAudio", "Placement id value supplied in XML layout is not valid. Audio creation failed.");
                AbstractC2680h7.a((byte) 1, "InMobiAudio", "Invalid Placement id: ".concat(attributeValue));
            } catch (StringIndexOutOfBoundsException unused2) {
                AbstractC2680h7.a((byte) 1, "InMobiAudio", "Placement id value supplied in XML layout is not valid. Please make sure placement id is in plid-0123456789 format.");
                AbstractC2680h7.a((byte) 1, "InMobiAudio", "Invalid Placement id: ".concat(attributeValue));
            }
            if (StringsKt.equals("plid-", sb.substring(0, 5), true)) {
                String substring = sb.substring(5, sb.length());
                Intrinsics.checkNotNull(substring);
                int length2 = substring.length() - 1;
                int i2 = 0;
                boolean z3 = false;
                while (i2 <= length2) {
                    boolean z4 = Intrinsics.compare((int) substring.charAt(!z3 ? i2 : length2), 32) <= 0;
                    if (z3) {
                        if (!z4) {
                            break;
                        } else {
                            length2--;
                        }
                    } else if (z4) {
                        i2++;
                    } else {
                        z3 = true;
                    }
                }
                j = Long.parseLong(substring.subSequence(i2, length2 + 1).toString());
                if (j != Long.MIN_VALUE) {
                    throw new InvalidPlacementIdException();
                }
                this.d.f2471a = j;
            } else {
                AbstractC2680h7.a((byte) 1, "InMobiAudio", "Placement id value supplied in XML layout is not valid. Please make sure placement id is in plid-0123456789 format.");
                AbstractC2680h7.a((byte) 1, "InMobiAudio", "Invalid Placement id: " + attributeValue);
                j = Long.MIN_VALUE;
                if (j != Long.MIN_VALUE) {
                }
            }
        }
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        a(context2);
    }

    public static final void a(InMobiAudio this$0) {
        E1 e1;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            if (this$0.b()) {
                if (!this$0.a() || (e1 = this$0.mAdManager) == null) {
                    return;
                }
                e1.b(this$0.getFrameSizeString());
                return;
            }
            AbstractC2680h7.a((byte) 1, "InMobiAudio", "The height or width of the audio ad can not be determined");
            E1 e12 = this$0.mAdManager;
            if (e12 != null) {
                e12.a((short) 108);
            }
            E1 e13 = this$0.mAdManager;
            if (e13 != null) {
                e13.a(e13.j(), new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR));
            }
        } catch (Exception unused) {
            E1 e14 = this$0.mAdManager;
            if (e14 != null) {
                e14.a((short) 105);
            }
            AbstractC2680h7.a((byte) 1, "InMobiAudio", "SDK encountered unexpected error while loading an ad");
        }
    }

    private final String getFrameSizeString() {
        return new StringBuilder().append(this.f).append('x').append(this.g).toString();
    }

    public final boolean b() {
        return this.f > 0 && this.g > 0;
    }

    public final boolean c() {
        if (!b()) {
            if (getLayoutParams() == null) {
                AbstractC2680h7.a((byte) 1, "InMobiAudio", "The layout params of the audio ad view must be set before calling load or call setAudioSize(int widthInDp, int heightInDp) before load");
                return false;
            }
            if (getLayoutParams().width == -2 || getLayoutParams().height == -2) {
                AbstractC2680h7.a((byte) 1, "InMobiAudio", "The height or width of a Audio ad can't be WRAP_CONTENT or call setAudioSize(int widthInDp, int heightInDp) before load");
                return false;
            }
            if (getLayoutParams() != null) {
                this.f = B2.b(getLayoutParams().width / U3.b());
                this.g = B2.b(getLayoutParams().height / U3.b());
            }
        }
        return true;
    }

    public final void d() {
        E1 e1;
        try {
            LinkedHashMap linkedHashMap = O2.f2380a;
            Config a2 = M2.a(com.mbridge.msdk.foundation.entity.b.JSON_KEY_ADS, Uc.b(), null);
            Intrinsics.checkNotNull(a2, "null cannot be cast to non-null type com.inmobi.commons.core.configs.AdConfig");
            if (!((AdConfig) a2).getAudio().getIsAudioEnabled()) {
                E1 e12 = this.mAdManager;
                if (e12 != null) {
                    e12.a((short) 107);
                }
                E1 e13 = this.mAdManager;
                if (e13 != null) {
                    e13.a(e13.j(), new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.FEATURE_DISABLED));
                }
                AbstractC2680h7.a((byte) 1, "InMobi", "");
                return;
            }
            this.d.e = "NonAB";
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            a(context);
            E1 e14 = this.mAdManager;
            if (e14 != null) {
                C2967z1 c2967z1 = e14.q;
                if (c2967z1 != null ? c2967z1.E0() : false) {
                    E1 e15 = this.mAdManager;
                    if (e15 != null) {
                        InterfaceC2971z5 p = e15.p();
                        if (p != null) {
                            String str = F1.f2278a;
                            Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$p(...)");
                            ((A5) p).b(str, "submitAdLoadFailed " + e15);
                        }
                        C2967z1 c2967z12 = e15.r;
                        if (c2967z12 != null) {
                            c2967z12.b((short) 15);
                        }
                    }
                    AudioAdEventListener audioAdEventListener = this.mPubListener;
                    if (audioAdEventListener != null) {
                        audioAdEventListener.onAdLoadFailed(this, new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.AD_ACTIVE));
                    }
                    AbstractC2680h7.a((byte) 1, "InMobiAudio", "An ad is currently being viewed by the user. Please wait for the user to close the ad before requesting for another ad.");
                    return;
                }
            }
            if (!c()) {
                E1 e16 = this.mAdManager;
                if (e16 != null) {
                    e16.a((short) 108);
                }
                E1 e17 = this.mAdManager;
                if (e17 != null) {
                    e17.a(e17.j(), new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.REQUEST_INVALID));
                    return;
                }
                return;
            }
            Config a3 = M2.a(com.mbridge.msdk.foundation.entity.b.JSON_KEY_ADS, Uc.b(), null);
            Intrinsics.checkNotNull(a3, "null cannot be cast to non-null type com.inmobi.commons.core.configs.AdConfig");
            if (((AdConfig) a3).getAudio().getMinDeviceVolume() > L3.f2348a.a(Uc.d(), Uc.o())) {
                E1 e18 = this.mAdManager;
                if (e18 != null) {
                    e18.a((short) 106);
                }
                E1 e19 = this.mAdManager;
                if (e19 != null) {
                    e19.a(e19.j(), new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.DEVICE_AUDIO_LEVEL_LOW));
                    return;
                }
                return;
            }
            if (!b()) {
                Md.a(new Runnable() { // from class: com.inmobi.ads.InMobiAudio$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        InMobiAudio.a(InMobiAudio.this);
                    }
                }, 200L);
            } else {
                if (!a() || (e1 = this.mAdManager) == null) {
                    return;
                }
                e1.b(getFrameSizeString());
            }
        } catch (Exception unused) {
            E1 e110 = this.mAdManager;
            if (e110 != null) {
                e110.a((short) 105);
            }
            AbstractC2680h7.a((byte) 1, "InMobiAudio", "Unable to load ad; SDK encountered an unexpected error");
        }
    }

    public final void destroy() {
        removeAllViews();
        E1 e1 = this.mAdManager;
        if (e1 != null) {
            InterfaceC2971z5 p = e1.p();
            if (p != null) {
                String str = F1.f2278a;
                Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$p(...)");
                ((A5) p).a(str, "clear " + e1);
            }
            InterfaceC2971z5 p2 = e1.p();
            if (p2 != null) {
                String str2 = F1.f2278a;
                Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
                ((A5) p2).c(str2, "unregisterLifecycleCallbacks " + e1);
            }
            C2967z1 c2967z1 = e1.o;
            if (c2967z1 != null) {
                c2967z1.J0();
            }
            C2967z1 c2967z12 = e1.p;
            if (c2967z12 != null) {
                c2967z12.J0();
            }
            C2967z1 c2967z13 = e1.o;
            if (c2967z13 != null) {
                c2967z13.g();
            }
            e1.o = null;
            C2967z1 c2967z14 = e1.p;
            if (c2967z14 != null) {
                c2967z14.g();
            }
            e1.p = null;
            e1.q = null;
            e1.r = null;
            e1.a((Boolean) null);
        }
        this.mPubListener = null;
    }

    public final void disableHardwareAcceleration() {
        this.d.d = true;
    }

    /* renamed from: getMAdManager$media_release, reason: from getter */
    public final E1 getMAdManager() {
        return this.mAdManager;
    }

    /* renamed from: getMPubListener$media_release, reason: from getter */
    public final AudioAdEventListener getMPubListener() {
        return this.mPubListener;
    }

    public final void load() {
        E1 e1 = this.mAdManager;
        if (e1 != null) {
            e1.w();
        }
        d();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        try {
            super.onAttachedToWindow();
            E1 e1 = this.mAdManager;
            if (e1 != null) {
                e1.x();
            }
            if (getLayoutParams() != null) {
                this.f = B2.b(getLayoutParams().width / U3.b());
                this.g = B2.b(getLayoutParams().height / U3.b());
            }
            if (!b()) {
                setupViewSizeObserver();
            }
            if (Build.VERSION.SDK_INT >= 29) {
                V3 v3 = U3.f2447a;
                Context context = getContext();
                WindowInsets rootWindowInsets = getRootWindowInsets();
                Intrinsics.checkNotNullExpressionValue(rootWindowInsets, "getRootWindowInsets(...)");
                U3.a(rootWindowInsets, context);
            }
        } catch (Exception unused) {
            AbstractC2680h7.a((byte) 1, "InMobiAudio", "InMobiAudio#onAttachedToWindow() handler threw unexpected error");
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        try {
            super.onDetachedFromWindow();
            E1 e1 = this.mAdManager;
            if (e1 != null) {
                InterfaceC2971z5 p = e1.p();
                if (p != null) {
                    String str = F1.f2278a;
                    Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$p(...)");
                    ((A5) p).c(str, "unregisterLifecycleCallbacks " + e1);
                }
                C2967z1 c2967z1 = e1.o;
                if (c2967z1 != null) {
                    c2967z1.J0();
                }
                C2967z1 c2967z12 = e1.p;
                if (c2967z12 != null) {
                    c2967z12.J0();
                }
            }
        } catch (Exception unused) {
            AbstractC2680h7.a((byte) 1, "InMobiAudio", "InMobiAudio.onDetachedFromWindow() handler threw unexpected error");
        }
    }

    public final void pause() {
        E1 e1;
        try {
            if (this.c != null || (e1 = this.mAdManager) == null) {
                return;
            }
            InterfaceC2971z5 p = e1.p();
            if (p != null) {
                String str = F1.f2278a;
                Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$p(...)");
                ((A5) p).a(str, "pause " + e1);
            }
            C2967z1 c2967z1 = e1.q;
            if (c2967z1 != null) {
                c2967z1.F0();
            }
        } catch (Exception unused) {
            AbstractC2680h7.a((byte) 1, "InMobi", "Could not pause ad; SDK encountered an unexpected error");
        }
    }

    public final void resume() {
        E1 e1;
        try {
            if (this.c != null || (e1 = this.mAdManager) == null) {
                return;
            }
            InterfaceC2971z5 p = e1.p();
            if (p != null) {
                String str = F1.f2278a;
                Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$p(...)");
                ((A5) p).a(str, "resume " + e1);
            }
            C2967z1 c2967z1 = e1.q;
            if (c2967z1 != null) {
                c2967z1.G0();
            }
        } catch (Exception unused) {
            AbstractC2680h7.a((byte) 1, "InMobi", "Could not resume ad; SDK encountered an unexpected error");
        }
    }

    public final void setAudioSize(int widthInDp, int heightInDp) {
        this.f = widthInDp;
        this.g = heightInDp;
    }

    public final void setContentUrl(String contentUrl) {
        Intrinsics.checkNotNullParameter(contentUrl, "contentUrl");
        this.d.f = contentUrl;
    }

    public final void setExtras(Map<String, String> extras) {
        if (extras != null) {
            String str = extras.get("tp");
            if (str != null) {
                Vc.a(str);
            }
            String str2 = extras.get("tp-v");
            if (str2 != null) {
                Vc.b(str2);
            }
        }
        this.d.c = extras;
    }

    public final void setKeywords(String keywords) {
        this.d.b = keywords;
    }

    public final void setListener(AudioAdEventListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mPubListener = listener;
    }

    public final void setMAdManager$media_release(E1 e1) {
        this.mAdManager = e1;
    }

    public final void setMPubListener$media_release(AudioAdEventListener audioAdEventListener) {
        this.mPubListener = audioAdEventListener;
    }

    public final void setupViewSizeObserver() {
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserverOnGlobalLayoutListenerC2824q5(this));
    }

    public final void show() {
        E1 e1 = this.mAdManager;
        if (e1 != null) {
            InterfaceC2971z5 p = e1.p();
            if (p != null) {
                String str = F1.f2278a;
                Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$p(...)");
                ((A5) p).a(str, "submitAdShowCalled " + e1);
            }
            C2967z1 c2967z1 = e1.r;
            if (c2967z1 != null) {
                c2967z1.w0();
            }
        }
        E1 e12 = this.mAdManager;
        if (e12 != null) {
            e12.a(this);
        }
    }

    public final boolean a() {
        E1 e1;
        long j = this.e;
        if (j != 0 && (e1 = this.mAdManager) != null) {
            InterfaceC2971z5 p = e1.p();
            if (p != null) {
                String str = F1.f2278a;
                Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$p(...)");
                ((A5) p).c(str, "checkForRefreshRate " + e1);
            }
            if (e1.r == null) {
                return false;
            }
            LinkedHashMap linkedHashMap = O2.f2380a;
            int minRefreshInterval = ((AdConfig) AbstractC2808p5.a(com.mbridge.msdk.foundation.entity.b.JSON_KEY_ADS, "null cannot be cast to non-null type com.inmobi.commons.core.configs.AdConfig", null)).getAudio().getMinRefreshInterval();
            if (SystemClock.elapsedRealtime() - j < minRefreshInterval * 1000) {
                e1.a((short) 2175);
                e1.b(e1.r, new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.EARLY_REFRESH_REQUEST).setCustomMessage("Ad cannot be refreshed before " + minRefreshInterval + " seconds"));
                String str2 = F1.f2278a;
                Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
                StringBuilder append = new StringBuilder("Ad cannot be refreshed before ").append(minRefreshInterval).append(" seconds (AdPlacement Id = ");
                C2967z1 c2967z1 = e1.r;
                AbstractC2680h7.a((byte) 1, str2, append.append(c2967z1 != null ? c2967z1.I() : null).append(')').toString());
                InterfaceC2971z5 p2 = e1.p();
                if (p2 == null) {
                    return false;
                }
                Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
                StringBuilder append2 = new StringBuilder("Ad cannot be refreshed before ").append(minRefreshInterval).append(" seconds (AdPlacement Id = ");
                C2967z1 c2967z12 = e1.r;
                ((A5) p2).b(str2, append2.append(c2967z12 != null ? c2967z12.I() : null).append(')').toString());
                return false;
            }
        }
        this.e = SystemClock.elapsedRealtime();
        return true;
    }

    public final void a(Context context) {
        String str;
        E1 e1 = this.mAdManager;
        if (e1 != null) {
            Wa pubSettings = this.d;
            String adSize = getFrameSizeString();
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(pubSettings, "pubSettings");
            Intrinsics.checkNotNullParameter(adSize, "adSize");
            String str2 = F1.f2278a;
            Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
            X x = new X("audio");
            Intrinsics.checkNotNullParameter(context, "context");
            if (context instanceof Activity) {
                str = "activity";
            } else {
                str = "others";
            }
            Z a2 = x.d(str).a(pubSettings.f2471a).c(pubSettings.b).a(pubSettings.c).a(adSize).a(pubSettings.d).e(pubSettings.e).b(pubSettings.f).a();
            C2967z1 c2967z1 = e1.o;
            if (c2967z1 != null && e1.p != null) {
                c2967z1.a(context, a2, e1);
                C2967z1 c2967z12 = e1.p;
                if (c2967z12 != null) {
                    c2967z12.a(context, a2, e1);
                }
            } else {
                e1.o = new C2967z1(context, a2, e1);
                e1.p = new C2967z1(context, a2, e1);
                e1.r = e1.o;
            }
            String str3 = pubSettings.e;
            if (str3 != null) {
                InterfaceC2971z5 p = e1.p();
                if (p != null) {
                    ((A5) p).a();
                }
                EnumC2560a7 enumC2560a7 = Cb.f2253a;
                e1.a(Cb.a("audio", str3, false));
                InterfaceC2971z5 p2 = e1.p();
                if (p2 != null) {
                    Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
                    ((A5) p2).a(str2, "adding audioAdUnit1 to reference tracker");
                }
                C2967z1 c2967z13 = e1.o;
                Intrinsics.checkNotNull(c2967z13);
                Cb.a(c2967z13, e1.p());
                InterfaceC2971z5 p3 = e1.p();
                if (p3 != null) {
                    Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
                    ((A5) p3).a(str2, "adding audioAdUnit2 to reference tracker");
                }
                C2967z1 c2967z14 = e1.p;
                Intrinsics.checkNotNull(c2967z14);
                Cb.a(c2967z14, e1.p());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InMobiAudio(Context context, long j) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        a aVar = new a(this);
        Wa wa = new Wa();
        this.d = wa;
        if (Uc.q()) {
            if (context instanceof Activity) {
                this.c = new WeakReference(context);
            }
            this.mAdManager = new E1(aVar);
            wa.f2471a = j;
            a(context);
            return;
        }
        throw new SdkNotInitializedException("InMobiAudio");
    }
}
