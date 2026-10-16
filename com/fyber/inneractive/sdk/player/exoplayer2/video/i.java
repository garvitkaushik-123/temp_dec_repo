package com.fyber.inneractive.sdk.player.exoplayer2.video;

import com.fyber.inneractive.sdk.player.exoplayer2.decoder.DecoderCounters;
import com.fyber.inneractive.sdk.player.exoplayer2.video.VideoRendererEventListener;

/* loaded from: classes4.dex */
public final class i implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DecoderCounters f1608a;
    public final /* synthetic */ VideoRendererEventListener.EventDispatcher b;

    public i(VideoRendererEventListener.EventDispatcher eventDispatcher, DecoderCounters decoderCounters) {
        this.b = eventDispatcher;
        this.f1608a = decoderCounters;
    }

    @Override // java.lang.Runnable
    public final void run() {
        VideoRendererEventListener videoRendererEventListener;
        videoRendererEventListener = this.b.listener;
        videoRendererEventListener.onVideoEnabled(this.f1608a);
    }
}
