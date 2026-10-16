package com.fyber.inneractive.sdk.player.exoplayer2.mediacodec;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;

/* loaded from: classes4.dex */
public final class i implements g {

    /* renamed from: a, reason: collision with root package name */
    public final int f1517a;
    public MediaCodecInfo[] b;

    public i(boolean z) {
        this.f1517a = z ? 1 : 0;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.g
    public final boolean a(String str, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("secure-playback");
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.g
    public final boolean b() {
        return true;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.g
    public final int a() {
        if (this.b == null) {
            this.b = new MediaCodecList(this.f1517a).getCodecInfos();
        }
        return this.b.length;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.g
    public final MediaCodecInfo a(int i) {
        if (this.b == null) {
            this.b = new MediaCodecList(this.f1517a).getCodecInfos();
        }
        return this.b[i];
    }
}
