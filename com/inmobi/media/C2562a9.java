package com.inmobi.media;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.google.common.base.Ascii;
import com.iab.omid.library.inmobi.adsession.media.Position;
import com.iab.omid.library.inmobi.adsession.media.VastProperties;
import com.inmobi.commons.core.configs.AdConfig;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.lang.ref.WeakReference;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

/* renamed from: com.inmobi.media.a9, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2562a9 extends T7 {
    public final String U;
    public final String V;
    public final InterfaceC2971z5 W;
    public final String X;
    public final String Y;
    public WeakReference Z;
    public final Z8 a0;
    public final Y8 b0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2562a9(Context context, byte b, C2811p8 dataModel, String impressionId, Set set, AdConfig adConfig, long j, boolean z, String creativeId, C2625e3 c2625e3, S6 s6, InterfaceC2971z5 interfaceC2971z5) {
        super(context, b, dataModel, impressionId, set, adConfig, j, z, creativeId, c2625e3, s6, interfaceC2971z5);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(dataModel, "dataModel");
        Intrinsics.checkNotNullParameter(impressionId, "impressionId");
        Intrinsics.checkNotNullParameter(adConfig, "adConfig");
        Intrinsics.checkNotNullParameter(creativeId, "creativeId");
        this.U = impressionId;
        this.V = creativeId;
        this.W = interfaceC2971z5;
        this.X = "a9";
        this.Y = "InMobi";
        this.a0 = new Z8(this);
        this.b0 = new Y8(this);
    }

    public final void a(View view, final boolean z) {
        final C2747l9 c2747l9 = (C2747l9) view.findViewById(Integer.MAX_VALUE);
        if (c2747l9 != null) {
            Object tag = c2747l9.getTag();
            final C2597c9 c2597c9 = tag instanceof C2597c9 ? (C2597c9) tag : null;
            if (c2597c9 != null) {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.inmobi.media.a9$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        C2562a9.a(C2597c9.this, z, this, c2747l9);
                    }
                });
            }
        }
    }

    @Override // com.inmobi.media.T7
    public final void b(View view) {
        if (this.r || this.t || !(view instanceof C2747l9)) {
            return;
        }
        this.r = true;
        C2625e3 c2625e3 = this.h;
        if (c2625e3 != null) {
            c2625e3.a();
        }
        Object tag = ((C2747l9) view).getTag();
        if (tag instanceof C2597c9) {
            String TAG = this.X;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            C2597c9 c2597c9 = (C2597c9) tag;
            Object obj = c2597c9.t.get("didImpressionFire");
            if (Intrinsics.areEqual(obj instanceof Boolean ? (Boolean) obj : null, Boolean.TRUE)) {
                return;
            }
            ArrayList arrayList = c2597c9.s;
            HashMap j = j(c2597c9);
            Iterator it = arrayList.iterator();
            List list = null;
            while (it.hasNext()) {
                U8 u8 = (U8) it.next();
                if (Intrinsics.areEqual("VideoImpression", u8.b)) {
                    if (StringsKt.startsWith$default(u8.d, "http", false, 2, (Object) null)) {
                        C2613d8.a(u8, j, (L7) null, this.W);
                    }
                    HashMap hashMap = u8.e;
                    Object obj2 = hashMap != null ? hashMap.get("referencedEvents") : null;
                    list = obj2 instanceof List ? (List) obj2 : null;
                    if (list != null) {
                        Iterator it2 = list.iterator();
                        while (it2.hasNext()) {
                            c2597c9.a((String) it2.next(), j, (L7) null, this.W);
                        }
                    }
                }
            }
            if (list == null || list.isEmpty()) {
                c2597c9.a("start", j, (L7) null, this.W);
                c2597c9.a("Impression", j, this.O, this.W);
            }
            C2681h8 c2681h8 = this.b.e;
            if (c2681h8 != null) {
                c2681h8.a("Impression", j(c2597c9), this.O, this.W);
            }
            c2597c9.t.put("didImpressionFire", Boolean.TRUE);
            We we = this.p;
            if (we != null) {
                we.a((byte) 0);
            }
            P0 p0 = this.w;
            if (p0 != null) {
                p0.f();
            }
        }
    }

    @Override // com.inmobi.media.T7
    public final void c(C2613d8 asset) {
        Intrinsics.checkNotNullParameter(asset, "asset");
        byte b = asset.k;
        if (b != 0) {
            if (b == 2) {
                try {
                    if (1 != this.f2437a) {
                        P0 p0 = this.w;
                        if (p0 != null) {
                            p0.h();
                        }
                        r();
                        return;
                    }
                    super.c(asset);
                    if (Intrinsics.areEqual("VIDEO", asset.c)) {
                        View videoContainerView = getVideoContainerView();
                        C2763m9 c2763m9 = videoContainerView instanceof C2763m9 ? (C2763m9) videoContainerView : null;
                        if (c2763m9 != null) {
                            c2763m9.getVideoView().c();
                            c2763m9.getVideoView().j();
                        }
                        r();
                        return;
                    }
                    InterfaceC2971z5 interfaceC2971z5 = this.W;
                    if (interfaceC2971z5 != null) {
                        String TAG = this.X;
                        Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                        ((A5) interfaceC2971z5).b(TAG, "Action 2 not valid for asset of type: " + asset.c);
                        return;
                    }
                    return;
                } catch (Exception e) {
                    InterfaceC2971z5 interfaceC2971z52 = this.W;
                    if (interfaceC2971z52 != null) {
                        String str = this.X;
                        ((A5) interfaceC2971z52).b(str, H6.a(str, "TAG", "Action 2 not valid for asset of type: ").append(asset.c).toString());
                    }
                    S5 s5 = S5.f2425a;
                    S5.d.a(AbstractC2920w5.a(e, "event"));
                    return;
                }
            }
            if (b == 3) {
                try {
                    if (!Intrinsics.areEqual("VIDEO", asset.c)) {
                        InterfaceC2971z5 interfaceC2971z53 = this.W;
                        if (interfaceC2971z53 != null) {
                            String TAG2 = this.X;
                            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                            ((A5) interfaceC2971z53).b(TAG2, "Action 3 not valid for asset of type: " + asset.c);
                            return;
                        }
                        return;
                    }
                    GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec = this.H;
                    if (gestureDetectorOnGestureListenerC2634ec != null) {
                        InterfaceC2971z5 interfaceC2971z54 = gestureDetectorOnGestureListenerC2634ec.i;
                        if (interfaceC2971z54 != null) {
                            String TAG3 = GestureDetectorOnGestureListenerC2634ec.a1;
                            Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
                            ((A5) interfaceC2971z54).a(TAG3, "replayToInterActive");
                        }
                        gestureDetectorOnGestureListenerC2634ec.c("window.imraid.broadcastEvent('replay');");
                    }
                    View g = g();
                    if (g != null) {
                        T8 a2 = T7.a(g);
                        if (a2 != null) {
                            a2.d();
                        }
                        ViewParent parent = g.getParent();
                        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
                        if (viewGroup != null) {
                            viewGroup.removeView(g);
                        }
                    }
                    View videoContainerView2 = getVideoContainerView();
                    C2763m9 c2763m92 = videoContainerView2 instanceof C2763m9 ? (C2763m9) videoContainerView2 : null;
                    if (c2763m92 != null) {
                        c2763m92.getVideoView().k();
                        c2763m92.getVideoView().start();
                        return;
                    }
                    return;
                } catch (Exception e2) {
                    InterfaceC2971z5 interfaceC2971z55 = this.W;
                    if (interfaceC2971z55 != null) {
                        String str2 = this.X;
                        ((A5) interfaceC2971z55).b(str2, rf.a(e2, H6.a(str2, "TAG", "Encountered unexpected error in handling replay action on video: ")));
                    }
                    AbstractC2680h7.a((byte) 2, this.Y, "SDK encountered unexpected error in replaying video");
                    S5 s52 = S5.f2425a;
                    S5.d.a(AbstractC2920w5.a(e2, "event"));
                    return;
                }
            }
            if (b == 1) {
                super.c(asset);
                return;
            }
            if (b == 4) {
                try {
                    if (this.f2437a != 0) {
                        InterfaceC2971z5 interfaceC2971z56 = this.W;
                        if (interfaceC2971z56 != null) {
                            String TAG4 = this.X;
                            Intrinsics.checkNotNullExpressionValue(TAG4, "TAG");
                            ((A5) interfaceC2971z56).b(TAG4, "Invalid action! Online inline videos can be expanded to fullscreen!");
                            return;
                        }
                        return;
                    }
                    View videoContainerView3 = getVideoContainerView();
                    C2763m9 c2763m93 = videoContainerView3 instanceof C2763m9 ? (C2763m9) videoContainerView3 : null;
                    if (c2763m93 != null) {
                        C2747l9 videoView = c2763m93.getVideoView();
                        Object tag = videoView.getTag();
                        C2597c9 c2597c9 = tag instanceof C2597c9 ? (C2597c9) tag : null;
                        if (videoView.getState() == 1 || c2597c9 == null) {
                            return;
                        }
                        try {
                            a(c2597c9, videoView);
                            return;
                        } catch (Exception e3) {
                            InterfaceC2971z5 interfaceC2971z57 = this.W;
                            if (interfaceC2971z57 != null) {
                                String TAG5 = this.X;
                                Intrinsics.checkNotNullExpressionValue(TAG5, "TAG");
                                ((A5) interfaceC2971z57).b(TAG5, "SDK encountered unexpected error in handling the onVideoRequestedFullScreen event; " + e3.getMessage());
                            }
                            S5 s53 = S5.f2425a;
                            C2640f2 event = new C2640f2(e3);
                            Intrinsics.checkNotNullParameter(event, "event");
                            S5.d.a(event);
                            return;
                        }
                    }
                    return;
                } catch (Exception e4) {
                    InterfaceC2971z5 interfaceC2971z58 = this.W;
                    if (interfaceC2971z58 != null) {
                        String str3 = this.X;
                        ((A5) interfaceC2971z58).b(str3, rf.a(e4, H6.a(str3, "TAG", "Encountered unexpected error in handling fullscreen action on video: ")));
                    }
                    AbstractC2680h7.a((byte) 2, this.Y, "SDK encountered unexpected error in expanding video to fullscreen");
                    S5 s54 = S5.f2425a;
                    S5.d.a(AbstractC2920w5.a(e4, "event"));
                    return;
                }
            }
            if (b == 5) {
                try {
                    View videoContainerView4 = getVideoContainerView();
                    C2763m9 c2763m94 = videoContainerView4 instanceof C2763m9 ? (C2763m9) videoContainerView4 : null;
                    if (c2763m94 != null) {
                        Object tag2 = c2763m94.getVideoView().getTag();
                        C2597c9 c2597c92 = tag2 instanceof C2597c9 ? (C2597c9) tag2 : null;
                        if (c2597c92 != null) {
                            HashMap hashMap = c2597c92.t;
                            Boolean bool = Boolean.TRUE;
                            hashMap.put("shouldAutoPlay", bool);
                            C2613d8 c2613d8 = c2597c92.w;
                            if (c2613d8 != null) {
                                c2613d8.t.put("shouldAutoPlay", bool);
                            }
                        }
                        c2763m94.getVideoView().start();
                        return;
                    }
                    return;
                } catch (Exception e5) {
                    InterfaceC2971z5 interfaceC2971z59 = this.W;
                    if (interfaceC2971z59 != null) {
                        String str4 = this.X;
                        ((A5) interfaceC2971z59).b(str4, rf.a(e5, H6.a(str4, "TAG", "Encountered unexpected error in handling play action on video: ")));
                    }
                    AbstractC2680h7.a((byte) 2, this.Y, "SDK encountered unexpected error in playing video");
                    S5 s55 = S5.f2425a;
                    S5.d.a(AbstractC2920w5.a(e5, "event"));
                    return;
                }
            }
            try {
                if (1 != this.f2437a) {
                    P0 p02 = this.w;
                    if (p02 != null) {
                        p02.h();
                    }
                    r();
                    return;
                }
                super.c(asset);
                if (Intrinsics.areEqual("VIDEO", asset.c)) {
                    View videoContainerView5 = getVideoContainerView();
                    C2763m9 c2763m95 = videoContainerView5 instanceof C2763m9 ? (C2763m9) videoContainerView5 : null;
                    if (c2763m95 != null) {
                        c2763m95.getVideoView().c();
                        c2763m95.getVideoView().j();
                    }
                    r();
                    return;
                }
                InterfaceC2971z5 interfaceC2971z510 = this.W;
                if (interfaceC2971z510 != null) {
                    String TAG6 = this.X;
                    Intrinsics.checkNotNullExpressionValue(TAG6, "TAG");
                    ((A5) interfaceC2971z510).b(TAG6, "Action 2 not valid for asset of type: " + asset.c);
                }
            } catch (Exception e6) {
                InterfaceC2971z5 interfaceC2971z511 = this.W;
                if (interfaceC2971z511 != null) {
                    String str5 = this.X;
                    ((A5) interfaceC2971z511).b(str5, H6.a(str5, "TAG", "Action 2 not valid for asset of type: ").append(asset.c).toString());
                }
                S5 s56 = S5.f2425a;
                S5.d.a(AbstractC2920w5.a(e6, "event"));
            }
        }
    }

    public final void d(C2597c9 videoAsset) {
        Intrinsics.checkNotNullParameter(videoAsset, "videoAsset");
        InterfaceC2971z5 interfaceC2971z5 = this.W;
        if (interfaceC2971z5 != null) {
            String str = this.X;
            ((A5) interfaceC2971z5).c(str, H6.a(str, "TAG", "Firing Q4 beacons for completion at ").append(videoAsset.D).toString());
        }
        videoAsset.t.put("didQ4Fire", Boolean.TRUE);
        videoAsset.a(CampaignEx.JSON_NATIVE_VIDEO_COMPLETE, j(videoAsset), (L7) null, this.W);
        We we = this.p;
        if (we != null) {
            we.a(Ascii.FF);
        }
        InterfaceC2971z5 interfaceC2971z52 = this.W;
        if (interfaceC2971z52 != null) {
            String TAG = this.X;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) interfaceC2971z52).c(TAG, "onVideoQuartileEvent(Q4)");
        }
    }

    public final void e(C2597c9 videoAsset) {
        Intrinsics.checkNotNullParameter(videoAsset, "videoAsset");
        if (this.t) {
            return;
        }
        videoAsset.t.put("lastMediaVolume", 0);
        videoAsset.a(CampaignEx.JSON_NATIVE_VIDEO_MUTE, j(videoAsset), (L7) null, this.W);
        InterfaceC2971z5 interfaceC2971z5 = this.W;
        if (interfaceC2971z5 != null) {
            String TAG = this.X;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) interfaceC2971z5).c(TAG, "onVideoMuted");
        }
        We we = this.p;
        if (we != null) {
            we.a(Ascii.CR);
        }
    }

    public final void f(C2597c9 videoAsset) {
        Intrinsics.checkNotNullParameter(videoAsset, "videoAsset");
        if (this.t) {
            return;
        }
        T8 a2 = T7.a(g());
        if (a2 != null) {
            a2.b();
        }
        videoAsset.a(CampaignEx.JSON_NATIVE_VIDEO_PAUSE, j(videoAsset), (L7) null, this.W);
        InterfaceC2971z5 interfaceC2971z5 = this.W;
        if (interfaceC2971z5 != null) {
            String TAG = this.X;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) interfaceC2971z5).c(TAG, "onVideoPaused");
        }
        We we = this.p;
        if (we != null) {
            we.a((byte) 7);
        }
    }

    public final void g(C2597c9 videoAsset) {
        Intrinsics.checkNotNullParameter(videoAsset, "videoAsset");
        if (this.t) {
            return;
        }
        InterfaceC2971z5 interfaceC2971z5 = this.W;
        if (interfaceC2971z5 != null) {
            String TAG = this.X;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) interfaceC2971z5).c(TAG, "onVideoPlayed");
        }
        if (this.f2437a == 0) {
            Object obj = videoAsset.t.get("currentMediaVolume");
            Integer num = obj instanceof Integer ? (Integer) obj : null;
            int intValue = num != null ? num.intValue() : 0;
            Object obj2 = videoAsset.t.get("lastMediaVolume");
            Integer num2 = obj2 instanceof Integer ? (Integer) obj2 : null;
            int intValue2 = num2 != null ? num2.intValue() : 0;
            if (intValue > 0 && intValue2 == 0) {
                i(videoAsset);
            }
            Object obj3 = videoAsset.t.get("currentMediaVolume");
            Integer num3 = obj3 instanceof Integer ? (Integer) obj3 : null;
            int intValue3 = num3 != null ? num3.intValue() : 0;
            Object obj4 = videoAsset.t.get("lastMediaVolume");
            Integer num4 = obj4 instanceof Integer ? (Integer) obj4 : null;
            int intValue4 = num4 != null ? num4.intValue() : 0;
            if (intValue3 == 0 && intValue4 > 0) {
                e(videoAsset);
            }
        }
        Object obj5 = videoAsset.t.get("didStartPlaying");
        if (Intrinsics.areEqual(obj5 instanceof Boolean ? (Boolean) obj5 : null, Boolean.FALSE)) {
            videoAsset.t.put("didStartPlaying", Boolean.TRUE);
            Xe viewableAd = getViewableAd();
            if (viewableAd != null) {
                viewableAd.a((byte) 6);
            }
        }
    }

    @Override // com.inmobi.media.T7, com.inmobi.media.InterfaceC2930x
    public final String getCreativeId() {
        return this.V;
    }

    @Override // com.inmobi.media.T7, com.inmobi.media.InterfaceC2930x
    public final InterfaceC2914w getFullScreenEventsListener() {
        return this.a0;
    }

    @Override // com.inmobi.media.T7, com.inmobi.media.InterfaceC2930x
    public final String getImpressionId() {
        return this.U;
    }

    @Override // com.inmobi.media.T7, com.inmobi.media.InterfaceC2930x
    public final View getVideoContainerView() {
        WeakReference weakReference = this.Z;
        if (weakReference != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    @Override // com.inmobi.media.T7, com.inmobi.media.InterfaceC2930x
    public final Xe getViewableAd() {
        C2562a9 c2562a9;
        Context j = j();
        if (this.p == null && j != null) {
            InterfaceC2971z5 interfaceC2971z5 = this.j;
            if (interfaceC2971z5 != null) {
                String TAG = this.m;
                Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                ((A5) interfaceC2971z5).c(TAG, "fireLoadedAndServedBeacons");
            }
            C2681h8 c2681h8 = this.b.e;
            if (c2681h8 != null) {
                HashMap a2 = a(c2681h8);
                a((byte) 1, a2);
                a((byte) 2, a2);
            }
            this.p = new N5(this, new C2603cf(this, this.W), this.W);
            Set<C2833qe> set = this.d;
            if (set != null) {
                for (C2833qe c2833qe : set) {
                    try {
                        if (c2833qe.f2687a == 3) {
                            Object obj = c2833qe.b.get("omidAdSession");
                            C2667ga c2667ga = obj instanceof C2667ga ? (C2667ga) obj : null;
                            Object obj2 = c2833qe.b.get("videoAutoPlay");
                            Boolean bool = obj2 instanceof Boolean ? (Boolean) obj2 : null;
                            boolean booleanValue = bool != null ? bool.booleanValue() : false;
                            Object obj3 = c2833qe.b.get("videoSkippable");
                            Boolean bool2 = obj3 instanceof Boolean ? (Boolean) obj3 : null;
                            boolean booleanValue2 = bool2 != null ? bool2.booleanValue() : false;
                            Object obj4 = c2833qe.b.get("videoSkipOffset");
                            VastProperties createVastPropertiesForSkippableMedia = booleanValue2 ? VastProperties.createVastPropertiesForSkippableMedia((obj4 instanceof Integer ? (Integer) obj4 : null) != null ? r4.intValue() : 0, booleanValue, Position.STANDALONE) : VastProperties.createVastPropertiesForNonSkippableMedia(booleanValue, Position.STANDALONE);
                            C2667ga c2667ga2 = c2667ga;
                            We we = this.p;
                            if (c2667ga2 == null || we == null) {
                                InterfaceC2971z5 interfaceC2971z52 = this.W;
                                if (interfaceC2971z52 != null) {
                                    String TAG2 = this.X;
                                    Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                                    ((A5) interfaceC2971z52).b(TAG2, "Did not find a OMID video ad session; the OMID decorator will not be applied.");
                                }
                            } else {
                                Intrinsics.checkNotNull(createVastPropertiesForSkippableMedia);
                                c2562a9 = this;
                                try {
                                    c2562a9.p = new C2764ma(j, we, c2562a9, c2667ga2, createVastPropertiesForSkippableMedia, this.W);
                                } catch (Exception e) {
                                    e = e;
                                    InterfaceC2971z5 interfaceC2971z53 = c2562a9.W;
                                    if (interfaceC2971z53 != null) {
                                        String str = c2562a9.X;
                                        ((A5) interfaceC2971z53).b(str, rf.a(e, H6.a(str, "TAG", "Exception occurred while creating the video viewable ad : ")));
                                    }
                                    S5 s5 = S5.f2425a;
                                    S5.d.a(AbstractC2920w5.a(e, "event"));
                                }
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                        c2562a9 = this;
                    }
                }
            }
        }
        return this.p;
    }

    public final void h(C2597c9 videoAsset) {
        Intrinsics.checkNotNullParameter(videoAsset, "videoAsset");
        if (this.t) {
            return;
        }
        T8 a2 = T7.a(g());
        if (a2 != null) {
            a2.c();
        }
        videoAsset.a(CampaignEx.JSON_NATIVE_VIDEO_RESUME, j(videoAsset), (L7) null, this.W);
        InterfaceC2971z5 interfaceC2971z5 = this.W;
        if (interfaceC2971z5 != null) {
            String TAG = this.X;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) interfaceC2971z5).c(TAG, "onVideoResumed");
        }
        We we = this.p;
        if (we != null) {
            we.a((byte) 8);
        }
    }

    @Override // com.inmobi.media.T7
    public final ef i() {
        return this.b0;
    }

    public final HashMap j(C2597c9 c2597c9) {
        String b;
        C2747l9 videoView;
        C2681h8 c2681h8 = c2597c9.r;
        if (!(c2681h8 instanceof C2681h8)) {
            c2681h8 = null;
        }
        HashMap hashMap = new HashMap();
        WeakReference weakReference = this.Z;
        View view = weakReference != null ? (View) weakReference.get() : null;
        C2763m9 c2763m9 = view instanceof C2763m9 ? (C2763m9) view : null;
        if (c2763m9 != null && (videoView = c2763m9.getVideoView()) != null) {
        }
        hashMap.put("[ERRORCODE]", "405");
        SecureRandom secureRandom = new SecureRandom();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i == 0) {
            i = (secureRandom.nextInt() & Integer.MAX_VALUE) % 10;
        }
        sb.append(i);
        for (int i2 = 1; i2 < 8; i2++) {
            sb.append((secureRandom.nextInt() & Integer.MAX_VALUE) % 10);
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        hashMap.put("[CACHEBUSTING]", sb2);
        Ve d = c2597c9.d();
        if (d != null && (b = ((Ue) d).b()) != null) {
        }
        hashMap.put("$TS", String.valueOf(System.currentTimeMillis()));
        Object obj = c2597c9.t.get("seekPosition");
        Integer num = obj instanceof Integer ? (Integer) obj : null;
        int intValue = num != null ? num.intValue() : 0;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        Locale locale = Locale.US;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        long j = intValue;
        String format = String.format(locale, "%02d:%02d:%02d.%03d", Arrays.copyOf(new Object[]{Long.valueOf(timeUnit.toHours(j)), Long.valueOf(timeUnit.toMinutes(j) - TimeUnit.HOURS.toMinutes(timeUnit.toHours(j))), Long.valueOf(timeUnit.toSeconds(j) - TimeUnit.MINUTES.toSeconds(timeUnit.toMinutes(j))), Long.valueOf(j - (timeUnit.toSeconds(j) * 1000))}, 4));
        Intrinsics.checkNotNullExpressionValue(format, "format(locale, format, *args)");
        hashMap.put("[CONTENTPLAYHEAD]", format);
        if (c2681h8 != null) {
        }
        Object obj2 = this.b.t;
        if (obj2 == null) {
            obj2 = new HashMap();
        }
        hashMap.putAll(obj2);
        return hashMap;
    }

    @Override // com.inmobi.media.T7
    public final boolean k() {
        return this.f2437a == 0 && f() != null;
    }

    @Override // com.inmobi.media.T7
    public final void l() {
        super.l();
        View videoContainerView = getVideoContainerView();
        C2763m9 c2763m9 = videoContainerView instanceof C2763m9 ? (C2763m9) videoContainerView : null;
        if (c2763m9 != null) {
            C2747l9 videoView = c2763m9.getVideoView();
            if (this.f2437a == 0 && !k() && videoView.getVideoVolume() > 0) {
                videoView.setLastVolume(-2);
                a(true);
            }
            videoView.pause();
        }
    }

    @Override // com.inmobi.media.T7
    public final boolean n() {
        return !this.A;
    }

    public final void r() {
        C2625e3 c2625e3 = this.h;
        if (c2625e3 != null) {
            if (!c2625e3.g.get()) {
                c2625e3.d.h = 1;
                Intrinsics.checkNotNull(c2625e3.c);
            }
            this.h.b();
        }
        We we = this.p;
        if (we != null) {
            we.a(Ascii.SI);
        }
    }

    public final void i(C2597c9 videoAsset) {
        Intrinsics.checkNotNullParameter(videoAsset, "videoAsset");
        if (this.t) {
            return;
        }
        videoAsset.t.put("lastMediaVolume", 15);
        videoAsset.a(CampaignEx.JSON_NATIVE_VIDEO_UNMUTE, j(videoAsset), (L7) null, this.W);
        InterfaceC2971z5 interfaceC2971z5 = this.W;
        if (interfaceC2971z5 != null) {
            String TAG = this.X;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) interfaceC2971z5).c(TAG, "onVideoUnMuted");
        }
        We we = this.p;
        if (we != null) {
            we.a(Ascii.SO);
        }
    }

    public static final void a(C2597c9 c2597c9, boolean z, C2562a9 this$0, C2747l9 c2747l9) {
        int videoVolume;
        int lastVolume;
        int videoVolume2;
        int lastVolume2;
        int videoVolume3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        c2597c9.t.put(VastAttributes.VISIBLE, Boolean.valueOf(z));
        if (z && !this$0.u) {
            c2597c9.t.put("lastVisibleTimestamp", Long.valueOf(SystemClock.uptimeMillis()));
            if (c2747l9.getPauseScheduled() && c2747l9.getMediaPlayer() != null) {
                if (c2597c9.c()) {
                    c2747l9.k();
                } else {
                    c2747l9.c();
                }
            }
            Handler handler = c2747l9.s;
            if (handler != null) {
                handler.removeMessages(0);
            }
            c2747l9.t = false;
            Intrinsics.checkNotNull(c2747l9);
            if (this$0.f2437a == 0 && !this$0.k() && (videoVolume3 = c2747l9.getVideoVolume()) != c2747l9.getLastVolume() && c2747l9.isPlaying()) {
                this$0.a(videoVolume3 <= 0);
                c2747l9.setLastVolume(videoVolume3);
            }
            if (this$0.f2437a == 0 && !this$0.k() && !c2597c9.B && !c2747l9.isPlaying() && c2747l9.getState() == 5 && (videoVolume2 = c2747l9.getVideoVolume()) != (lastVolume2 = c2747l9.getLastVolume()) && lastVolume2 > 0) {
                this$0.a(true);
                c2747l9.setLastVolume(videoVolume2);
            }
            if (1 == c2747l9.getState()) {
                G8 mediaPlayer = c2747l9.getMediaPlayer();
                if (mediaPlayer == null) {
                    return;
                }
                mediaPlayer.b = 3;
                return;
            }
            if (2 == c2747l9.getState() || 4 == c2747l9.getState() || (5 == c2747l9.getState() && c2597c9.B)) {
                c2747l9.start();
                return;
            }
            return;
        }
        Intrinsics.checkNotNull(c2747l9);
        if (this$0.f2437a == 0 && !this$0.k() && !this$0.u && (videoVolume = c2747l9.getVideoVolume()) != (lastVolume = c2747l9.getLastVolume()) && lastVolume > 0) {
            this$0.a(true);
            c2747l9.setLastVolume(videoVolume);
        }
        c2747l9.a(c2597c9.E);
    }

    public final void a(boolean z) {
        P0 p0;
        if (this.f2437a != 0 || k() || (p0 = this.w) == null) {
            return;
        }
        InterfaceC2971z5 interfaceC2971z5 = p0.f2390a.j;
        if (interfaceC2971z5 != null) {
            String e = S0.e();
            Intrinsics.checkNotNullExpressionValue(e, "<get-TAG>(...)");
            ((A5) interfaceC2971z5).a(e, "onAudioStateChanged");
        }
        if (p0.f2390a.Z()) {
            return;
        }
        F0 f0 = (F0) p0.b.get();
        if (f0 != null) {
            f0.a(z);
            return;
        }
        InterfaceC2971z5 interfaceC2971z52 = p0.f2390a.j;
        if (interfaceC2971z52 != null) {
            ((A5) interfaceC2971z52).b("InMobi", "Listener was garbage collected.Unable to give callback");
        }
    }

    public final void a(C2597c9 videoAsset, int i) {
        Intrinsics.checkNotNullParameter(videoAsset, "videoAsset");
        if (this.t) {
            return;
        }
        InterfaceC2971z5 interfaceC2971z5 = this.W;
        if (interfaceC2971z5 != null) {
            String str = this.X;
            ((A5) interfaceC2971z5).a(str, X8.a(str, "TAG", "Moat onVideoError + ", i));
        }
        videoAsset.a("error", j(videoAsset), (L7) null, this.W);
        InterfaceC2971z5 interfaceC2971z52 = this.W;
        if (interfaceC2971z52 != null) {
            String TAG = this.X;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) interfaceC2971z52).c(TAG, "onVideoError");
        }
        We we = this.p;
        if (we != null) {
            we.a((byte) 17);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0055, code lost:
    
        if (r0.isPlaying() == true) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(C2597c9 c2597c9, C2747l9 c2747l9) {
        boolean z;
        if (this.t || this.x.get() == null) {
            return;
        }
        Object obj = c2597c9.t.get("didRequestFullScreen");
        Boolean bool = obj instanceof Boolean ? (Boolean) obj : null;
        if (bool != null ? bool.booleanValue() : false) {
            return;
        }
        HashMap hashMap = c2597c9.t;
        Boolean bool2 = Boolean.TRUE;
        hashMap.put("didRequestFullScreen", bool2);
        hashMap.put("seekPosition", Integer.valueOf(c2747l9.getCurrentPosition()));
        hashMap.put("lastMediaVolume", Integer.valueOf(c2747l9.getVolume()));
        G8 mediaPlayer = c2747l9.getMediaPlayer();
        if (mediaPlayer != null) {
            z = true;
        }
        z = false;
        if (z) {
            G8 mediaPlayer2 = c2747l9.getMediaPlayer();
            if (mediaPlayer2 != null) {
                mediaPlayer2.pause();
            }
            c2747l9.getAudioFocusManager$media_release().a();
        }
        G8 mediaPlayer3 = c2747l9.getMediaPlayer();
        if (mediaPlayer3 != null) {
            mediaPlayer3.f2294a = 4;
        }
        c2597c9.t.put("isFullScreen", bool2);
        HashMap hashMap2 = c2597c9.t;
        G8 mediaPlayer4 = c2747l9.getMediaPlayer();
        hashMap2.put("seekPosition", Integer.valueOf(mediaPlayer4 != null ? mediaPlayer4.getCurrentPosition() : 0));
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            String TAG = this.m;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) interfaceC2971z5).c(TAG, "launchFullscreen");
        }
        T7 c = T7.c(this);
        if (c == null) {
            return;
        }
        P0 p0 = c.w;
        if (p0 != null) {
            p0.e();
        }
        A a2 = this.M;
        int hashCode = hashCode();
        M7 m7 = new M7(this, c);
        a2.getClass();
        A.a(hashCode, m7);
    }

    public final void b(C2597c9 videoAsset, C2747l9 videoView) {
        Intrinsics.checkNotNullParameter(videoAsset, "videoAsset");
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        InterfaceC2971z5 interfaceC2971z5 = this.W;
        if (interfaceC2971z5 != null) {
            String TAG = this.X;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) interfaceC2971z5).c(TAG, "onVideoViewCreated");
        }
        videoView.setIsLockScreen(this.D);
        ViewParent parent = videoView.getParent();
        C2763m9 c2763m9 = parent instanceof C2763m9 ? (C2763m9) parent : null;
        if (c2763m9 != null) {
            this.Z = new WeakReference(c2763m9);
            C2631e9 mediaController = c2763m9.getVideoView().getMediaController();
            if (mediaController != null) {
                mediaController.setVideoAd(this);
            }
        }
    }

    @Override // com.inmobi.media.T7, com.inmobi.media.InterfaceC2930x
    public final void b() {
        C2747l9 videoView;
        if (this.t) {
            return;
        }
        View videoContainerView = getVideoContainerView();
        C2763m9 c2763m9 = videoContainerView instanceof C2763m9 ? (C2763m9) videoContainerView : null;
        if (c2763m9 != null && (videoView = c2763m9.getVideoView()) != null) {
            videoView.g();
        }
        super.b();
    }

    public final void b(C2597c9 videoAsset) {
        HashMap hashMap;
        Intrinsics.checkNotNullParameter(videoAsset, "videoAsset");
        if (this.t) {
            return;
        }
        Object obj = videoAsset.t.get("didRequestFullScreen");
        if (Intrinsics.areEqual(obj instanceof Boolean ? (Boolean) obj : null, Boolean.TRUE)) {
            HashMap hashMap2 = videoAsset.t;
            Boolean bool = Boolean.FALSE;
            hashMap2.put("didRequestFullScreen", bool);
            C2613d8 c2613d8 = videoAsset.w;
            if (c2613d8 != null && (hashMap = c2613d8.t) != null) {
                hashMap.put("didRequestFullScreen", bool);
            }
            a();
            videoAsset.t.put("isFullScreen", bool);
        }
    }

    public final void c(C2597c9 videoAsset) {
        Intrinsics.checkNotNullParameter(videoAsset, "videoAsset");
        InterfaceC2971z5 interfaceC2971z5 = this.W;
        if (interfaceC2971z5 != null) {
            String TAG = this.X;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) interfaceC2971z5).c(TAG, "Video completed; rewards, if any, will be unlocked and end-card displayed");
        }
        Object obj = videoAsset.t.get("didSignalVideoCompleted");
        Boolean bool = obj instanceof Boolean ? (Boolean) obj : null;
        C2625e3 c2625e3 = this.h;
        if (c2625e3 != null) {
            if (!c2625e3.g.get()) {
                c2625e3.d.i = 1;
                Intrinsics.checkNotNull(c2625e3.c);
            }
            this.h.b();
        }
        if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
            InterfaceC2971z5 interfaceC2971z52 = this.W;
            if (interfaceC2971z52 != null) {
                String TAG2 = this.X;
                Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                ((A5) interfaceC2971z52).c(TAG2, "Ignoring callback onAdRewardsUnlocked(), as it is only fired after first time video is played.");
            }
        } else {
            q();
            P0 p0 = this.w;
            if (p0 != null) {
                InterfaceC2971z5 interfaceC2971z53 = p0.f2390a.j;
                if (interfaceC2971z53 != null) {
                    String e = S0.e();
                    Intrinsics.checkNotNullExpressionValue(e, "<get-TAG>(...)");
                    ((A5) interfaceC2971z53).a(e, "onMediaPlaybackComplete");
                }
                if (!p0.f2390a.Z()) {
                    F0 f0 = (F0) p0.b.get();
                    if (f0 != null) {
                        f0.f();
                    } else {
                        InterfaceC2971z5 interfaceC2971z54 = p0.f2390a.j;
                        if (interfaceC2971z54 != null) {
                            ((A5) interfaceC2971z54).b("InMobi", "Listener was garbage collected.Unable to give callback");
                        }
                    }
                }
            }
        }
        if (1 == this.f2437a) {
            b((C2613d8) videoAsset);
        }
    }
}
