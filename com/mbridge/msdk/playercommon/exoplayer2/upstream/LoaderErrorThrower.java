package com.mbridge.msdk.playercommon.exoplayer2.upstream;

import java.io.IOException;

/* loaded from: classes6.dex */
public interface LoaderErrorThrower {

    public static final class Dummy implements LoaderErrorThrower {
        @Override // com.mbridge.msdk.playercommon.exoplayer2.upstream.LoaderErrorThrower
        public void maybeThrowError() throws IOException {
        }

        @Override // com.mbridge.msdk.playercommon.exoplayer2.upstream.LoaderErrorThrower
        public void maybeThrowError(int i) throws IOException {
        }
    }

    void maybeThrowError() throws IOException;

    void maybeThrowError(int i) throws IOException;
}
