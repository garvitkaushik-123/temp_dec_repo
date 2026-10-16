package com.inmobi.media;

import android.view.View;
import android.view.ViewGroup;
import com.iab.omid.library.inmobi.adsession.AdEvents;
import com.iab.omid.library.inmobi.adsession.AdSession;
import com.iab.omid.library.inmobi.adsession.AdSessionConfiguration;
import com.iab.omid.library.inmobi.adsession.AdSessionContext;
import com.iab.omid.library.inmobi.adsession.CreativeType;
import com.iab.omid.library.inmobi.adsession.ErrorType;
import com.iab.omid.library.inmobi.adsession.FriendlyObstructionPurpose;
import com.iab.omid.library.inmobi.adsession.ImpressionType;
import com.iab.omid.library.inmobi.adsession.Owner;
import com.iab.omid.library.inmobi.adsession.media.InteractionType;
import com.iab.omid.library.inmobi.adsession.media.MediaEvents;
import com.iab.omid.library.inmobi.adsession.media.PlayerState;
import com.iab.omid.library.inmobi.adsession.media.VastProperties;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.ga, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2667ga {

    /* renamed from: a, reason: collision with root package name */
    public final String f2580a;
    public final ImpressionType b;
    public AdSessionContext c;
    public final boolean d;
    public byte e;
    public AdSession f;
    public C2946y g;

    public C2667ga(String mAdSessionType, ImpressionType impressionType, AdSessionContext adSessionContext, boolean z) {
        Intrinsics.checkNotNullParameter(mAdSessionType, "mAdSessionType");
        Intrinsics.checkNotNullParameter(impressionType, "impressionType");
        this.f2580a = mAdSessionType;
        this.b = impressionType;
        this.c = adSessionContext;
        this.d = z;
    }

    public static boolean a(byte b, byte b2) {
        if (b == b2) {
            return true;
        }
        S5 s5 = S5.f2425a;
        C2640f2 event = new C2640f2(new Exception("Omid AdSession State Error currentState :: " + ((int) b) + ", expectedState :: " + ((int) b2)));
        Intrinsics.checkNotNullParameter(event, "event");
        S5.d.a(event);
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final void a(View view, Map map, View view2) {
        AdSession adSession;
        CreativeType creativeType;
        Owner owner;
        CreativeType creativeType2;
        Intrinsics.checkNotNullParameter(view, "trackingView");
        if (this.f == null) {
            boolean z = this.d;
            Owner owner2 = Owner.JAVASCRIPT;
            CreativeType creativeType3 = CreativeType.DEFINED_BY_JAVASCRIPT;
            String str = this.f2580a;
            switch (str.hashCode()) {
                case -2139264536:
                    if (str.equals("native_display_ad")) {
                        owner2 = Owner.NATIVE;
                        owner = Owner.NONE;
                        creativeType = CreativeType.NATIVE_DISPLAY;
                        break;
                    }
                    creativeType = creativeType3;
                    owner = null;
                    break;
                case -1329992236:
                    if (str.equals("html_display_ad")) {
                        owner = Owner.NONE;
                        creativeType = CreativeType.HTML_DISPLAY;
                        break;
                    }
                    creativeType = creativeType3;
                    owner = null;
                    break;
                case -1191784049:
                    if (str.equals("native_video_ad")) {
                        owner2 = Owner.NATIVE;
                        creativeType2 = CreativeType.VIDEO;
                        creativeType = creativeType2;
                        owner = owner2;
                        break;
                    }
                    creativeType = creativeType3;
                    owner = null;
                    break;
                case 363190080:
                    if (str.equals("html_audio_ad")) {
                        creativeType2 = CreativeType.AUDIO;
                        creativeType = creativeType2;
                        owner = owner2;
                        break;
                    }
                    creativeType = creativeType3;
                    owner = null;
                    break;
                case 538665083:
                    if (str.equals("html_video_ad")) {
                        creativeType2 = CreativeType.VIDEO;
                        creativeType = creativeType2;
                        owner = owner2;
                        break;
                    }
                    creativeType = creativeType3;
                    owner = null;
                    break;
                default:
                    creativeType = creativeType3;
                    owner = null;
                    break;
            }
            AdSession createAdSession = AdSession.createAdSession(AdSessionConfiguration.createAdSessionConfiguration(creativeType, this.b, owner2, owner, z), this.c);
            Intrinsics.checkNotNullExpressionValue(createAdSession, "createAdSession(...)");
            this.f = createAdSession;
            if (createAdSession != null) {
                this.g = new C2946y(createAdSession, this.f2580a);
                this.e = (byte) 1;
            }
        }
        Intrinsics.checkNotNullParameter(view, "view");
        if (a(this.e, (byte) 1) && (adSession = this.f) != null) {
            adSession.registerAdView(view);
        }
        if (map != null) {
            for (Map.Entry entry : map.entrySet()) {
                a((View) entry.getKey(), (FriendlyObstructionPurpose) entry.getValue());
            }
        }
        if (view2 != null && (view2 instanceof ViewGroup)) {
            a(view, map, (ViewGroup) view2);
        }
        if (a(this.e, (byte) 1)) {
            AdSession adSession2 = this.f;
            if (adSession2 != null) {
                adSession2.start();
            }
            this.e = (byte) 2;
        }
    }

    public final void a(int i, int i2, float f, VastProperties vastProps) {
        C2946y c2946y;
        AdEvents adEvents;
        AdSession adSession;
        Intrinsics.checkNotNullParameter(vastProps, "vastProperties");
        if (a(this.e, (byte) 2)) {
            byte b = (byte) i;
            if (b == 17) {
                ErrorType errorType = ErrorType.VIDEO;
                Intrinsics.checkNotNullParameter(errorType, "errorType");
                Intrinsics.checkNotNullParameter("Unknown Player error", "errorMsg");
                if (a(this.e, (byte) 2) && (adSession = this.f) != null) {
                    adSession.error(errorType, "Unknown Player error");
                }
            } else if (b == 0 && (c2946y = this.g) != null && (adEvents = c2946y.f2757a) != null) {
                adEvents.impressionOccurred();
            }
            C2946y c2946y2 = this.g;
            if (c2946y2 != null) {
                Intrinsics.checkNotNullParameter(vastProps, "vastProps");
                MediaEvents mediaEvents = c2946y2.b;
                if (mediaEvents == null) {
                    return;
                }
                if (b == 7) {
                    mediaEvents.pause();
                    return;
                }
                if (b == 5) {
                    AdEvents adEvents2 = c2946y2.f2757a;
                    if (adEvents2 != null) {
                        adEvents2.loaded(vastProps);
                        return;
                    }
                    return;
                }
                if (b == 6) {
                    mediaEvents.start(i2, f);
                    return;
                }
                if (b == 8 || b == 16) {
                    mediaEvents.resume();
                    return;
                }
                if (b == 15) {
                    mediaEvents.skipped();
                    return;
                }
                if (b == 9) {
                    mediaEvents.firstQuartile();
                    return;
                }
                if (b == 10) {
                    mediaEvents.midpoint();
                    return;
                }
                if (b == 11) {
                    mediaEvents.thirdQuartile();
                    return;
                }
                if (b == 12) {
                    mediaEvents.complete();
                    return;
                }
                if (b == 13) {
                    mediaEvents.volumeChange(0.0f);
                    return;
                }
                if (b == 14) {
                    mediaEvents.volumeChange(f);
                    return;
                }
                if (b == 1) {
                    mediaEvents.playerStateChange(PlayerState.FULLSCREEN);
                    return;
                }
                if (b == 2) {
                    mediaEvents.playerStateChange(PlayerState.NORMAL);
                } else if (b == 4) {
                    mediaEvents.adUserInteraction(InteractionType.CLICK);
                } else if (b == 18) {
                    mediaEvents.adUserInteraction(InteractionType.INVITATION_ACCEPTED);
                }
            }
        }
    }

    public final void a(View childView, FriendlyObstructionPurpose obstructionCode) {
        Intrinsics.checkNotNullParameter(childView, "childView");
        Intrinsics.checkNotNullParameter(obstructionCode, "obstructionCode");
        byte b = this.e;
        if (b > 0) {
            AdSession adSession = this.f;
            if (adSession != null) {
                adSession.addFriendlyObstruction(childView, obstructionCode, null);
                return;
            }
            return;
        }
        S5 s5 = S5.f2425a;
        C2640f2 event = new C2640f2(new Exception("Omid AdSession State Error currentState :: " + ((int) b) + ", expectedState :: 1"));
        Intrinsics.checkNotNullParameter(event, "event");
        S5.d.a(event);
    }

    public final void a(View view, Map map, ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (!Intrinsics.areEqual(childAt, view)) {
                if (map == null || !map.containsKey(childAt)) {
                    Intrinsics.checkNotNull(childAt);
                    a(childAt, FriendlyObstructionPurpose.OTHER);
                }
                if (childAt instanceof ViewGroup) {
                    ViewGroup viewGroup2 = (ViewGroup) childAt;
                    if (viewGroup2.getChildCount() > 0) {
                        a(view, map, viewGroup2);
                    }
                }
            }
        }
    }
}
