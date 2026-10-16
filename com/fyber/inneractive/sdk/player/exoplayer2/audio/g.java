package com.fyber.inneractive.sdk.player.exoplayer2.audio;

import com.fyber.inneractive.sdk.player.exoplayer2.audio.AudioRendererEventListener;

/* loaded from: classes4.dex */
public final class g implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1386a;
    public final /* synthetic */ long b;
    public final /* synthetic */ long c;
    public final /* synthetic */ AudioRendererEventListener.EventDispatcher d;

    public g(AudioRendererEventListener.EventDispatcher eventDispatcher, int i, long j, long j2) {
        this.d = eventDispatcher;
        this.f1386a = i;
        this.b = j;
        this.c = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AudioRendererEventListener audioRendererEventListener;
        audioRendererEventListener = this.d.listener;
        audioRendererEventListener.onAudioTrackUnderrun(this.f1386a, this.b, this.c);
    }
}
