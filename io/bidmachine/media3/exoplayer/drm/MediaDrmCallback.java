package io.bidmachine.media3.exoplayer.drm;

import io.bidmachine.media3.exoplayer.drm.ExoMediaDrm;
import java.util.UUID;

/* loaded from: classes7.dex */
public interface MediaDrmCallback {
    byte[] executeKeyRequest(UUID uuid, ExoMediaDrm.KeyRequest keyRequest) throws MediaDrmCallbackException;

    byte[] executeProvisionRequest(UUID uuid, ExoMediaDrm.ProvisionRequest provisionRequest) throws MediaDrmCallbackException;
}
