package io.bidmachine.media3.extractor;

import io.bidmachine.media3.common.DataReader;
import io.bidmachine.media3.common.Format;
import io.bidmachine.media3.common.util.ParsableByteArray;
import io.bidmachine.media3.extractor.TrackOutput;
import java.io.IOException;

/* loaded from: classes7.dex */
public class ForwardingTrackOutput implements TrackOutput {
    private final TrackOutput trackOutput;

    public ForwardingTrackOutput(TrackOutput trackOutput) {
        this.trackOutput = trackOutput;
    }

    @Override // io.bidmachine.media3.extractor.TrackOutput
    public void durationUs(long j) {
        this.trackOutput.durationUs(j);
    }

    @Override // io.bidmachine.media3.extractor.TrackOutput
    public void format(Format format) {
        this.trackOutput.format(format);
    }

    @Override // io.bidmachine.media3.extractor.TrackOutput
    public int sampleData(DataReader dataReader, int i, boolean z) throws IOException {
        return this.trackOutput.sampleData(dataReader, i, z);
    }

    @Override // io.bidmachine.media3.extractor.TrackOutput
    public void sampleData(ParsableByteArray parsableByteArray, int i) {
        this.trackOutput.sampleData(parsableByteArray, i);
    }

    @Override // io.bidmachine.media3.extractor.TrackOutput
    public int sampleData(DataReader dataReader, int i, boolean z, int i2) throws IOException {
        return this.trackOutput.sampleData(dataReader, i, z, i2);
    }

    @Override // io.bidmachine.media3.extractor.TrackOutput
    public void sampleData(ParsableByteArray parsableByteArray, int i, int i2) {
        this.trackOutput.sampleData(parsableByteArray, i, i2);
    }

    @Override // io.bidmachine.media3.extractor.TrackOutput
    public void sampleMetadata(long j, int i, int i2, int i3, TrackOutput.CryptoData cryptoData) {
        this.trackOutput.sampleMetadata(j, i, i2, i3, cryptoData);
    }
}
