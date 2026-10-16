package io.bidmachine.media3.extractor;

/* loaded from: classes7.dex */
public class ForwardingExtractorOutput implements ExtractorOutput {
    private final ExtractorOutput output;

    public ForwardingExtractorOutput(ExtractorOutput extractorOutput) {
        this.output = extractorOutput;
    }

    @Override // io.bidmachine.media3.extractor.ExtractorOutput
    public TrackOutput track(int i, int i2) {
        return this.output.track(i, i2);
    }

    @Override // io.bidmachine.media3.extractor.ExtractorOutput
    public void endTracks() {
        this.output.endTracks();
    }

    @Override // io.bidmachine.media3.extractor.ExtractorOutput
    public void seekMap(SeekMap seekMap) {
        this.output.seekMap(seekMap);
    }
}
