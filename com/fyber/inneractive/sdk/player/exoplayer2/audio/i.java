package com.fyber.inneractive.sdk.player.exoplayer2.audio;

import com.fyber.inneractive.sdk.player.exoplayer2.audio.AudioRendererEventListener;

/* loaded from: classes4.dex */
public final class i implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1388a;
    public final /* synthetic */ AudioRendererEventListener.EventDispatcher b;

    public i(AudioRendererEventListener.EventDispatcher eventDispatcher, int i) {
        this.b = eventDispatcher;
        this.f1388a = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AudioRendererEventListener audioRendererEventListener;
        audioRendererEventListener = this.b.listener;
        audioRendererEventListener.onAudioSessionId(this.f1388a);
    }
}
