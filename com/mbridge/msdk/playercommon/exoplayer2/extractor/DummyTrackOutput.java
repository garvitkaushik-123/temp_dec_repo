package com.mbridge.msdk.playercommon.exoplayer2.extractor;

import com.mbridge.msdk.playercommon.exoplayer2.Format;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.TrackOutput;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray;
import java.io.EOFException;
import java.io.IOException;

/* loaded from: classes6.dex */
public final class DummyTrackOutput implements TrackOutput {
    @Override // com.mbridge.msdk.playercommon.exoplayer2.extractor.TrackOutput
    public void format(Format format) {
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.extractor.TrackOutput
    public int sampleData(ExtractorInput extractorInput, int i, boolean z) throws IOException, InterruptedException {
        int skip = extractorInput.skip(i);
        if (skip != -1) {
            return skip;
        }
        if (z) {
            return -1;
        }
        throw new EOFException();
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.extractor.TrackOutput
    public void sampleMetadata(long j, int i, int i2, int i3, TrackOutput.CryptoData cryptoData) {
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.extractor.TrackOutput
    public void sampleData(ParsableByteArray parsableByteArray, int i) {
        parsableByteArray.skipBytes(i);
    }
}
