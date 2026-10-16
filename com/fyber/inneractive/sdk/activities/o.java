package com.fyber.inneractive.sdk.activities;

import android.media.MediaPlayer;

/* loaded from: classes4.dex */
public final class o implements MediaPlayer.OnCompletionListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InneractiveRichMediaVideoPlayerActivityCore f1020a;

    public o(InneractiveRichMediaVideoPlayerActivityCore inneractiveRichMediaVideoPlayerActivityCore) {
        this.f1020a = inneractiveRichMediaVideoPlayerActivityCore;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public final void onCompletion(MediaPlayer mediaPlayer) {
        this.f1020a.finish();
    }
}
