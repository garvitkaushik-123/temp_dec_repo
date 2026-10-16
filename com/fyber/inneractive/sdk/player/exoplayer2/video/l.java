package com.fyber.inneractive.sdk.player.exoplayer2.video;

import com.fyber.inneractive.sdk.player.exoplayer2.video.VideoRendererEventListener;

/* loaded from: classes4.dex */
public final class l implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1611a;
    public final /* synthetic */ long b;
    public final /* synthetic */ VideoRendererEventListener.EventDispatcher c;

    public l(VideoRendererEventListener.EventDispatcher eventDispatcher, int i, long j) {
        this.c = eventDispatcher;
        this.f1611a = i;
        this.b = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        VideoRendererEventListener videoRendererEventListener;
        videoRendererEventListener = this.c.listener;
        videoRendererEventListener.onDroppedFrames(this.f1611a, this.b);
    }
}
