package io.bidmachine.media3.extractor;

import io.bidmachine.media3.common.DataReader;
import io.bidmachine.media3.common.Format;
import io.bidmachine.media3.common.util.ParsableByteArray;
import io.bidmachine.media3.extractor.TrackOutput;
import java.io.EOFException;
import java.io.IOException;

/* loaded from: classes7.dex */
public final class DiscardingTrackOutput implements TrackOutput {
    private final byte[] readBuffer = new byte[4096];

    @Override // io.bidmachine.media3.extractor.TrackOutput
    public void format(Format format) {
    }

    @Override // io.bidmachine.media3.extractor.TrackOutput
    public void sampleMetadata(long j, int i, int i2, int i3, TrackOutput.CryptoData cryptoData) {
    }

    @Override // io.bidmachine.media3.extractor.TrackOutput
    public int sampleData(DataReader dataReader, int i, boolean z, int i2) throws IOException {
        int read = dataReader.read(this.readBuffer, 0, Math.min(this.readBuffer.length, i));
        if (read != -1) {
            return read;
        }
        if (z) {
            return -1;
        }
        throw new EOFException();
    }

    @Override // io.bidmachine.media3.extractor.TrackOutput
    public void sampleData(ParsableByteArray parsableByteArray, int i, int i2) {
        parsableByteArray.skipBytes(i);
    }
}
