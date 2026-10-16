package com.fyber.inneractive.sdk.player.exoplayer2.video;

import android.view.Surface;
import com.fyber.inneractive.sdk.player.exoplayer2.video.VideoRendererEventListener;

/* loaded from: classes4.dex */
public final class n implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Surface f1613a;
    public final /* synthetic */ VideoRendererEventListener.EventDispatcher b;

    public n(VideoRendererEventListener.EventDispatcher eventDispatcher, Surface surface) {
        this.b = eventDispatcher;
        this.f1613a = surface;
    }

    @Override // java.lang.Runnable
    public final void run() {
        VideoRendererEventListener videoRendererEventListener;
        videoRendererEventListener = this.b.listener;
        videoRendererEventListener.onRenderedFirstFrame(this.f1613a);
    }
}
