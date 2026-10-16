package com.fyber.inneractive.sdk.player.exoplayer2.video;

import com.fyber.inneractive.sdk.player.exoplayer2.decoder.DecoderCounters;
import com.fyber.inneractive.sdk.player.exoplayer2.video.VideoRendererEventListener;

/* loaded from: classes4.dex */
public final class o implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DecoderCounters f1614a;
    public final /* synthetic */ VideoRendererEventListener.EventDispatcher b;

    public o(VideoRendererEventListener.EventDispatcher eventDispatcher, DecoderCounters decoderCounters) {
        this.b = eventDispatcher;
        this.f1614a = decoderCounters;
    }

    @Override // java.lang.Runnable
    public final void run() {
        VideoRendererEventListener videoRendererEventListener;
        this.f1614a.ensureUpdated();
        videoRendererEventListener = this.b.listener;
        videoRendererEventListener.onVideoDisabled(this.f1614a);
    }
}
