package com.fyber.inneractive.sdk.player.exoplayer2.video;

import android.media.MediaCodec;
import android.os.Handler;

/* loaded from: classes4.dex */
public final class f implements MediaCodec.OnFrameRenderedListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MediaCodecVideoRenderer f1605a;

    public f(MediaCodecVideoRenderer mediaCodecVideoRenderer, MediaCodec mediaCodec) {
        this.f1605a = mediaCodecVideoRenderer;
        mediaCodec.setOnFrameRenderedListener(this, new Handler());
    }

    @Override // android.media.MediaCodec.OnFrameRenderedListener
    public final void onFrameRendered(MediaCodec mediaCodec, long j, long j2) {
        MediaCodecVideoRenderer mediaCodecVideoRenderer = this.f1605a;
        if (this == mediaCodecVideoRenderer.p0 && !mediaCodecVideoRenderer.Y) {
            mediaCodecVideoRenderer.Y = true;
            mediaCodecVideoRenderer.Q.renderedFirstFrame(mediaCodecVideoRenderer.W);
        }
    }
}
