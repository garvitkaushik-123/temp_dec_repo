package com.inmobi.media;

import android.media.MediaPlayer;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.j9, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2715j9 implements MediaPlayer.OnPreparedListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C2747l9 f2612a;

    public C2715j9(C2747l9 c2747l9) {
        this.f2612a = c2747l9;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public final void onPrepared(MediaPlayer mp) {
        HashMap hashMap;
        C2631e9 c2631e9;
        HashMap hashMap2;
        HashMap hashMap3;
        Intrinsics.checkNotNullParameter(mp, "mp");
        if (this.f2612a.getMediaPlayer() == null) {
            return;
        }
        G8 mediaPlayer = this.f2612a.getMediaPlayer();
        if (mediaPlayer != null) {
            mediaPlayer.f2294a = 2;
        }
        C2747l9 c2747l9 = this.f2612a;
        c2747l9.r = true;
        c2747l9.q = true;
        c2747l9.p = true;
        C2631e9 c2631e92 = c2747l9.n;
        if (c2631e92 != null) {
            c2631e92.setEnabled(true);
        }
        this.f2612a.e = mp.getVideoWidth();
        this.f2612a.f = mp.getVideoHeight();
        Object tag = this.f2612a.getTag();
        C2597c9 c2597c9 = tag instanceof C2597c9 ? (C2597c9) tag : null;
        int i = 0;
        if (c2597c9 != null) {
            Object obj = c2597c9.t.get("didCompleteQ4");
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
            if (((Boolean) obj).booleanValue()) {
                this.f2612a.a(8, 0);
                Object obj2 = c2597c9.t.get("placementType");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Byte");
                if (((Byte) obj2).byteValue() == 1) {
                    return;
                }
            }
        }
        InterfaceC2666g9 playbackEventListener = this.f2612a.getPlaybackEventListener();
        if (playbackEventListener != null) {
            ((A8) playbackEventListener).a((byte) 0);
        }
        Object obj3 = (c2597c9 == null || (hashMap3 = c2597c9.t) == null) ? null : hashMap3.get("didCompleteQ4");
        if (Intrinsics.areEqual(obj3 instanceof Boolean ? (Boolean) obj3 : null, Boolean.FALSE)) {
            Object obj4 = c2597c9.t.get("seekPosition");
            Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type kotlin.Int");
            i = ((Integer) obj4).intValue();
        }
        C2747l9 c2747l92 = this.f2612a;
        if (c2747l92.e == 0 || c2747l92.f == 0) {
            G8 mediaPlayer2 = c2747l92.getMediaPlayer();
            if (mediaPlayer2 == null || 3 != mediaPlayer2.b) {
                return;
            }
            Object obj5 = (c2597c9 == null || (hashMap = c2597c9.t) == null) ? null : hashMap.get("isFullScreen");
            if (Intrinsics.areEqual(obj5 instanceof Boolean ? (Boolean) obj5 : null, Boolean.TRUE)) {
                this.f2612a.start();
                return;
            }
            return;
        }
        G8 mediaPlayer3 = c2747l92.getMediaPlayer();
        if (mediaPlayer3 == null || 3 != mediaPlayer3.b) {
            if (this.f2612a.isPlaying()) {
                return;
            }
            if ((i != 0 || this.f2612a.getCurrentPosition() > 0) && (c2631e9 = this.f2612a.n) != null) {
                c2631e9.d();
                return;
            }
            return;
        }
        Object obj6 = (c2597c9 == null || (hashMap2 = c2597c9.t) == null) ? null : hashMap2.get("isFullScreen");
        if (Intrinsics.areEqual(obj6 instanceof Boolean ? (Boolean) obj6 : null, Boolean.TRUE)) {
            this.f2612a.start();
        }
        C2631e9 c2631e93 = this.f2612a.n;
        if (c2631e93 != null) {
            c2631e93.d();
        }
    }
}
