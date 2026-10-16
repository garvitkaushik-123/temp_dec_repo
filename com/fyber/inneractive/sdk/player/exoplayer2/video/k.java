package com.fyber.inneractive.sdk.player.exoplayer2.video;

import com.fyber.inneractive.sdk.player.exoplayer2.video.VideoRendererEventListener;

/* loaded from: classes4.dex */
public final class k implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.fyber.inneractive.sdk.player.exoplayer2.o f1610a;
    public final /* synthetic */ VideoRendererEventListener.EventDispatcher b;

    public k(VideoRendererEventListener.EventDispatcher eventDispatcher, com.fyber.inneractive.sdk.player.exoplayer2.o oVar) {
        this.b = eventDispatcher;
        this.f1610a = oVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        VideoRendererEventListener videoRendererEventListener;
        videoRendererEventListener = this.b.listener;
        videoRendererEventListener.onVideoInputFormatChanged(this.f1610a);
    }
}
