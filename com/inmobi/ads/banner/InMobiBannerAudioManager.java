package com.inmobi.ads.banner;

import android.view.View;
import android.view.ViewGroup;
import com.inmobi.ads.InMobiBanner;
import com.inmobi.media.C2904v5;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001J)\u0010\b\u001a\u00020\u0007\"\b\b\u0000\u0010\u0003*\u00020\u00022\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/inmobi/ads/banner/InMobiBannerAudioManager;", "", "Landroid/view/ViewGroup;", "T", "t", "Lcom/inmobi/ads/banner/AudioListener;", "audioListener", "", "setAudioListener", "(Landroid/view/ViewGroup;Lcom/inmobi/ads/banner/AudioListener;)V", "", "isEnabled", "setAudioEnabled", "(Z)V", "media_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class InMobiBannerAudioManager {
    public static final InMobiBannerAudioManager INSTANCE = new InMobiBannerAudioManager();

    public static InMobiBanner a(ViewGroup viewGroup) {
        InMobiBanner a2;
        if (viewGroup instanceof InMobiBanner) {
            if (viewGroup.getVisibility() == 0 && viewGroup.isShown()) {
                return (InMobiBanner) viewGroup;
            }
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if ((childAt instanceof ViewGroup) && (a2 = a((ViewGroup) childAt)) != null) {
                return a2;
            }
        }
        return null;
    }

    @JvmStatic
    public static final void setAudioEnabled(boolean isEnabled) {
        C2904v5 c2904v5 = C2904v5.c;
        C2904v5.d.set(isEnabled);
    }

    @JvmStatic
    public static final <T extends ViewGroup> void setAudioListener(T t, AudioListener audioListener) {
        Intrinsics.checkNotNullParameter(t, "t");
        Intrinsics.checkNotNullParameter(audioListener, "audioListener");
        INSTANCE.getClass();
        InMobiBanner a2 = a(t);
        if (a2 == null || !a2.isAudioAd()) {
            return;
        }
        a2.setAudioListener(audioListener);
    }
}
