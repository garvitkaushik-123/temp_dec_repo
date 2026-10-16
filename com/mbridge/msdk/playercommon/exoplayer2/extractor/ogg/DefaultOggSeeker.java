package com.mbridge.msdk.playercommon.exoplayer2.extractor.ogg;

import com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorInput;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.SeekMap;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.SeekPoint;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import io.bidmachine.media3.exoplayer.audio.SilenceSkippingAudioProcessor;
import java.io.EOFException;
import java.io.IOException;

/* loaded from: classes6.dex */
final class DefaultOggSeeker implements OggSeeker {
    private static final int DEFAULT_OFFSET = 30000;
    public static final int MATCH_BYTE_RANGE = 100000;
    public static final int MATCH_RANGE = 72000;
    private static final int STATE_IDLE = 3;
    private static final int STATE_READ_LAST_PAGE = 1;
    private static final int STATE_SEEK = 2;
    private static final int STATE_SEEK_TO_END = 0;
    private long end;
    private long endGranule;
    private final long endPosition;
    private final OggPageHeader pageHeader = new OggPageHeader();
    private long positionBeforeSeekToEnd;
    private long start;
    private long startGranule;
    private final long startPosition;
    private int state;
    private final StreamReader streamReader;
    private long targetGranule;
    private long totalGranules;

    private class OggSeekMap implements SeekMap {
        private OggSeekMap() {
        }

        @Override // com.mbridge.msdk.playercommon.exoplayer2.extractor.SeekMap
        public long getDurationUs() {
            return DefaultOggSeeker.this.streamReader.convertGranuleToTime(DefaultOggSeeker.this.totalGranules);
        }

        @Override // com.mbridge.msdk.playercommon.exoplayer2.extractor.SeekMap
        public SeekMap.SeekPoints getSeekPoints(long j) {
            if (j == 0) {
                return new SeekMap.SeekPoints(new SeekPoint(0L, DefaultOggSeeker.this.startPosition));
            }
            long convertTimeToGranule = DefaultOggSeeker.this.streamReader.convertTimeToGranule(j);
            DefaultOggSeeker defaultOggSeeker = DefaultOggSeeker.this;
            return new SeekMap.SeekPoints(new SeekPoint(j, defaultOggSeeker.getEstimatedPosition(defaultOggSeeker.startPosition, convertTimeToGranule, 30000L)));
        }

        @Override // com.mbridge.msdk.playercommon.exoplayer2.extractor.SeekMap
        public boolean isSeekable() {
            return true;
        }
    }

    public DefaultOggSeeker(long j, long j2, StreamReader streamReader, int i, long j3) {
        Assertions.checkArgument(j >= 0 && j2 > j);
        this.streamReader = streamReader;
        this.startPosition = j;
        this.endPosition = j2;
        if (i != j2 - j) {
            this.state = 0;
        } else {
            this.totalGranules = j3;
            this.state = 3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long getEstimatedPosition(long j, long j2, long j3) {
        long j4 = this.endPosition;
        long j5 = this.startPosition;
        long j6 = j + (((j2 * (j4 - j5)) / this.totalGranules) - j3);
        if (j6 >= j5) {
            j5 = j6;
        }
        return j5 >= j4 ? j4 - 1 : j5;
    }

    public long getNextSeekPosition(long j, ExtractorInput extractorInput) throws IOException, InterruptedException {
        if (this.start == this.end) {
            return -(this.startGranule + 2);
        }
        long position = extractorInput.getPosition();
        if (!skipToNextPage(extractorInput, this.end)) {
            long j2 = this.start;
            if (j2 != position) {
                return j2;
            }
            throw new IOException("No ogg page can be found.");
        }
        this.pageHeader.populate(extractorInput, false);
        extractorInput.resetPeekPosition();
        OggPageHeader oggPageHeader = this.pageHeader;
        long j3 = oggPageHeader.granulePosition;
        long j4 = j - j3;
        int i = oggPageHeader.headerSize + oggPageHeader.bodySize;
        if (j4 >= 0 && j4 <= 72000) {
            extractorInput.skipFully(i);
            return -(this.pageHeader.granulePosition + 2);
        }
        if (j4 < 0) {
            this.end = position;
            this.endGranule = j3;
        } else {
            long j5 = i;
            long position2 = extractorInput.getPosition() + j5;
            this.start = position2;
            this.startGranule = this.pageHeader.granulePosition;
            if ((this.end - position2) + j5 < SilenceSkippingAudioProcessor.DEFAULT_MINIMUM_SILENCE_DURATION_US) {
                extractorInput.skipFully(i);
                return -(this.startGranule + 2);
            }
        }
        long j6 = this.end;
        long j7 = this.start;
        if (j6 - j7 < SilenceSkippingAudioProcessor.DEFAULT_MINIMUM_SILENCE_DURATION_US) {
            this.end = j7;
            return j7;
        }
        long j8 = i;
        long j9 = j4 > 0 ? 1L : 2L;
        long position3 = extractorInput.getPosition();
        long j10 = this.end;
        long j11 = this.start;
        return Math.min(Math.max((position3 - (j8 * j9)) + ((j4 * (j10 - j11)) / (this.endGranule - this.startGranule)), j11), this.end - 1);
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.extractor.ogg.OggSeeker
    public long read(ExtractorInput extractorInput) throws IOException, InterruptedException {
        DefaultOggSeeker defaultOggSeeker;
        ExtractorInput extractorInput2;
        DefaultOggSeeker defaultOggSeeker2;
        int i = this.state;
        if (i == 0) {
            defaultOggSeeker = this;
            extractorInput2 = extractorInput;
            long position = extractorInput2.getPosition();
            defaultOggSeeker.positionBeforeSeekToEnd = position;
            defaultOggSeeker.state = 1;
            long j = defaultOggSeeker.endPosition - 65307;
            if (j > position) {
                return j;
            }
        } else {
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        return -1L;
                    }
                    throw new IllegalStateException();
                }
                long j2 = this.targetGranule;
                long j3 = 0;
                if (j2 == 0) {
                    defaultOggSeeker2 = this;
                } else {
                    long nextSeekPosition = getNextSeekPosition(j2, extractorInput);
                    if (nextSeekPosition >= 0) {
                        return nextSeekPosition;
                    }
                    defaultOggSeeker2 = this;
                    j3 = defaultOggSeeker2.skipToPageOfGranule(extractorInput, this.targetGranule, -(nextSeekPosition + 2));
                }
                defaultOggSeeker2.state = 3;
                return -(j3 + 2);
            }
            defaultOggSeeker = this;
            extractorInput2 = extractorInput;
        }
        defaultOggSeeker.totalGranules = readGranuleOfLastPage(extractorInput2);
        defaultOggSeeker.state = 3;
        return defaultOggSeeker.positionBeforeSeekToEnd;
    }

    long readGranuleOfLastPage(ExtractorInput extractorInput) throws IOException, InterruptedException {
        skipToNextPage(extractorInput);
        this.pageHeader.reset();
        while ((this.pageHeader.type & 4) != 4 && extractorInput.getPosition() < this.endPosition) {
            this.pageHeader.populate(extractorInput, false);
            OggPageHeader oggPageHeader = this.pageHeader;
            extractorInput.skipFully(oggPageHeader.headerSize + oggPageHeader.bodySize);
        }
        return this.pageHeader.granulePosition;
    }

    public void resetSeeking() {
        this.start = this.startPosition;
        this.end = this.endPosition;
        this.startGranule = 0L;
        this.endGranule = this.totalGranules;
    }

    void skipToNextPage(ExtractorInput extractorInput) throws IOException, InterruptedException {
        if (!skipToNextPage(extractorInput, this.endPosition)) {
            throw new EOFException();
        }
    }

    long skipToPageOfGranule(ExtractorInput extractorInput, long j, long j2) throws IOException, InterruptedException {
        this.pageHeader.populate(extractorInput, false);
        while (true) {
            OggPageHeader oggPageHeader = this.pageHeader;
            if (oggPageHeader.granulePosition >= j) {
                extractorInput.resetPeekPosition();
                return j2;
            }
            extractorInput.skipFully(oggPageHeader.headerSize + oggPageHeader.bodySize);
            OggPageHeader oggPageHeader2 = this.pageHeader;
            long j3 = oggPageHeader2.granulePosition;
            oggPageHeader2.populate(extractorInput, false);
            j2 = j3;
        }
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.extractor.ogg.OggSeeker
    public long startSeek(long j) {
        int i = this.state;
        Assertions.checkArgument(i == 3 || i == 2);
        this.targetGranule = j != 0 ? this.streamReader.convertTimeToGranule(j) : 0L;
        this.state = 2;
        resetSeeking();
        return this.targetGranule;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.extractor.ogg.OggSeeker
    public OggSeekMap createSeekMap() {
        if (this.totalGranules != 0) {
            return new OggSeekMap();
        }
        return null;
    }

    boolean skipToNextPage(ExtractorInput extractorInput, long j) throws IOException, InterruptedException {
        int i;
        long min = Math.min(j + 3, this.endPosition);
        int i2 = 2048;
        byte[] bArr = new byte[2048];
        while (true) {
            int i3 = 0;
            if (extractorInput.getPosition() + i2 > min && (i2 = (int) (min - extractorInput.getPosition())) < 4) {
                return false;
            }
            extractorInput.peekFully(bArr, 0, i2, false);
            while (true) {
                i = i2 - 3;
                if (i3 < i) {
                    if (bArr[i3] == 79 && bArr[i3 + 1] == 103 && bArr[i3 + 2] == 103 && bArr[i3 + 3] == 83) {
                        extractorInput.skipFully(i3);
                        return true;
                    }
                    i3++;
                }
            }
            extractorInput.skipFully(i);
        }
    }
}
