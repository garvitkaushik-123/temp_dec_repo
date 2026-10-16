package io.bidmachine.media3.exoplayer.drm;

import io.bidmachine.media3.common.util.Assertions;
import io.bidmachine.media3.exoplayer.drm.ExoMediaDrm;
import java.util.UUID;

/* loaded from: classes7.dex */
public final class LocalMediaDrmCallback implements MediaDrmCallback {
    private final byte[] keyResponse;

    public LocalMediaDrmCallback(byte[] bArr) {
        this.keyResponse = (byte[]) Assertions.checkNotNull(bArr);
    }

    @Override // io.bidmachine.media3.exoplayer.drm.MediaDrmCallback
    public byte[] executeProvisionRequest(UUID uuid, ExoMediaDrm.ProvisionRequest provisionRequest) {
        throw new UnsupportedOperationException();
    }

    @Override // io.bidmachine.media3.exoplayer.drm.MediaDrmCallback
    public byte[] executeKeyRequest(UUID uuid, ExoMediaDrm.KeyRequest keyRequest) {
        return this.keyResponse;
    }
}
