package io.bidmachine.media3.extractor;

import java.io.IOException;
import java.util.List;

/* loaded from: classes7.dex */
public class ForwardingExtractor implements Extractor {
    private final Extractor delegate;

    public ForwardingExtractor(Extractor extractor) {
        this.delegate = extractor;
    }

    @Override // io.bidmachine.media3.extractor.Extractor
    public boolean sniff(ExtractorInput extractorInput) throws IOException {
        return this.delegate.sniff(extractorInput);
    }

    @Override // io.bidmachine.media3.extractor.Extractor
    public List<SniffFailure> getSniffFailureDetails() {
        return this.delegate.getSniffFailureDetails();
    }

    @Override // io.bidmachine.media3.extractor.Extractor
    public void init(ExtractorOutput extractorOutput) {
        this.delegate.init(extractorOutput);
    }

    @Override // io.bidmachine.media3.extractor.Extractor
    public int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        return this.delegate.read(extractorInput, positionHolder);
    }

    @Override // io.bidmachine.media3.extractor.Extractor
    public void seek(long j, long j2) {
        this.delegate.seek(j, j2);
    }

    @Override // io.bidmachine.media3.extractor.Extractor
    public void release() {
        this.delegate.release();
    }

    @Override // io.bidmachine.media3.extractor.Extractor
    public Extractor getUnderlyingImplementation() {
        return this.delegate.getUnderlyingImplementation();
    }
}
