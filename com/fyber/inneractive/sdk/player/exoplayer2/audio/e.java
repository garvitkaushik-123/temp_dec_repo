package com.fyber.inneractive.sdk.player.exoplayer2.audio;

import com.fyber.inneractive.sdk.player.exoplayer2.audio.AudioRendererEventListener;

/* loaded from: classes4.dex */
public final class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f1384a;
    public final /* synthetic */ long b;
    public final /* synthetic */ long c;
    public final /* synthetic */ AudioRendererEventListener.EventDispatcher d;

    public e(AudioRendererEventListener.EventDispatcher eventDispatcher, String str, long j, long j2) {
        this.d = eventDispatcher;
        this.f1384a = str;
        this.b = j;
        this.c = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AudioRendererEventListener audioRendererEventListener;
        audioRendererEventListener = this.d.listener;
        audioRendererEventListener.onAudioDecoderInitialized(this.f1384a, this.b, this.c);
    }
}
