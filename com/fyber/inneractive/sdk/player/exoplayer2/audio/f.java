package com.fyber.inneractive.sdk.player.exoplayer2.audio;

import com.fyber.inneractive.sdk.player.exoplayer2.audio.AudioRendererEventListener;

/* loaded from: classes4.dex */
public final class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.fyber.inneractive.sdk.player.exoplayer2.o f1385a;
    public final /* synthetic */ AudioRendererEventListener.EventDispatcher b;

    public f(AudioRendererEventListener.EventDispatcher eventDispatcher, com.fyber.inneractive.sdk.player.exoplayer2.o oVar) {
        this.b = eventDispatcher;
        this.f1385a = oVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AudioRendererEventListener audioRendererEventListener;
        audioRendererEventListener = this.b.listener;
        audioRendererEventListener.onAudioInputFormatChanged(this.f1385a);
    }
}
