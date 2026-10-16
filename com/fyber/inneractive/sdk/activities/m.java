package com.fyber.inneractive.sdk.activities;

import android.media.MediaPlayer;
import com.fyber.inneractive.sdk.util.IAlog;

/* loaded from: classes4.dex */
public final class m implements MediaPlayer.OnPreparedListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InneractiveRichMediaVideoPlayerActivityCore f1018a;

    public m(InneractiveRichMediaVideoPlayerActivityCore inneractiveRichMediaVideoPlayerActivityCore) {
        this.f1018a = inneractiveRichMediaVideoPlayerActivityCore;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public final void onPrepared(MediaPlayer mediaPlayer) {
        IAlog.a("onPrepared", new Object[0]);
        InneractiveRichMediaVideoPlayerActivityCore inneractiveRichMediaVideoPlayerActivityCore = this.f1018a;
        inneractiveRichMediaVideoPlayerActivityCore.f1005a.seekTo(inneractiveRichMediaVideoPlayerActivityCore.b);
        this.f1018a.f1005a.start();
    }
}
