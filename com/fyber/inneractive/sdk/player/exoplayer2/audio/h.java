package com.fyber.inneractive.sdk.player.exoplayer2.audio;

import com.fyber.inneractive.sdk.player.exoplayer2.audio.AudioRendererEventListener;
import com.fyber.inneractive.sdk.player.exoplayer2.decoder.DecoderCounters;

/* loaded from: classes4.dex */
public final class h implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DecoderCounters f1387a;
    public final /* synthetic */ AudioRendererEventListener.EventDispatcher b;

    public h(AudioRendererEventListener.EventDispatcher eventDispatcher, DecoderCounters decoderCounters) {
        this.b = eventDispatcher;
        this.f1387a = decoderCounters;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AudioRendererEventListener audioRendererEventListener;
        this.f1387a.ensureUpdated();
        audioRendererEventListener = this.b.listener;
        audioRendererEventListener.onAudioDisabled(this.f1387a);
    }
}
