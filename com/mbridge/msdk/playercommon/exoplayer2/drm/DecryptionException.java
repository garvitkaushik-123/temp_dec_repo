package com.mbridge.msdk.playercommon.exoplayer2.drm;

/* loaded from: classes6.dex */
public class DecryptionException extends Exception {
    public final int errorCode;

    public DecryptionException(int i, String str) {
        super(str);
        this.errorCode = i;
    }
}
