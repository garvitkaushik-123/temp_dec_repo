package com.fyber.inneractive.sdk.player.exoplayer2.decoder;

import android.media.MediaCodec;

/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final MediaCodec.CryptoInfo f1398a;
    public final MediaCodec.CryptoInfo.Pattern b = new MediaCodec.CryptoInfo.Pattern(0, 0);

    public a(MediaCodec.CryptoInfo cryptoInfo) {
        this.f1398a = cryptoInfo;
    }

    public static void a(a aVar) {
        aVar.b.set(0, 0);
        aVar.f1398a.setPattern(aVar.b);
    }
}
