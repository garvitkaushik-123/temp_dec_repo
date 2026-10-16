package com.fyber.inneractive.sdk.player.exoplayer2.video;

import com.fyber.inneractive.sdk.player.exoplayer2.video.VideoRendererEventListener;

/* loaded from: classes4.dex */
public final class m implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1612a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;
    public final /* synthetic */ float d;
    public final /* synthetic */ VideoRendererEventListener.EventDispatcher e;

    public m(VideoRendererEventListener.EventDispatcher eventDispatcher, int i, int i2, int i3, float f) {
        this.e = eventDispatcher;
        this.f1612a = i;
        this.b = i2;
        this.c = i3;
        this.d = f;
    }

    @Override // java.lang.Runnable
    public final void run() {
        VideoRendererEventListener videoRendererEventListener;
        videoRendererEventListener = this.e.listener;
        videoRendererEventListener.onVideoSizeChanged(this.f1612a, this.b, this.c, this.d);
    }
}
