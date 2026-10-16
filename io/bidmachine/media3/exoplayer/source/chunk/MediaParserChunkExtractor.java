package io.bidmachine.media3.exoplayer.source.chunk;

import android.media.MediaParser;
import io.bidmachine.media3.common.Format;
import io.bidmachine.media3.common.MimeTypes;
import io.bidmachine.media3.common.util.Assertions;
import io.bidmachine.media3.common.util.Util;
import io.bidmachine.media3.exoplayer.analytics.PlayerId;
import io.bidmachine.media3.exoplayer.source.chunk.ChunkExtractor;
import io.bidmachine.media3.exoplayer.source.mediaparser.InputReaderAdapterV30;
import io.bidmachine.media3.exoplayer.source.mediaparser.MediaParserUtil;
import io.bidmachine.media3.exoplayer.source.mediaparser.OutputConsumerAdapterV30;
import io.bidmachine.media3.extractor.ChunkIndex;
import io.bidmachine.media3.extractor.DiscardingTrackOutput;
import io.bidmachine.media3.extractor.ExtractorInput;
import io.bidmachine.media3.extractor.ExtractorOutput;
import io.bidmachine.media3.extractor.SeekMap;
import io.bidmachine.media3.extractor.TrackOutput;
import io.bidmachine.media3.extractor.text.DefaultSubtitleParserFactory;
import io.bidmachine.media3.extractor.text.SubtitleExtractor;
import io.bidmachine.media3.extractor.text.SubtitleParser;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes7.dex */
public final class MediaParserChunkExtractor implements ChunkExtractor {

    @Deprecated
    public static final ChunkExtractor.Factory FACTORY = new Factory();
    private static final String TAG = "MediaPrsrChunkExtractor";
    private final DiscardingTrackOutput discardingTrackOutput;
    private final InputReaderAdapterV30 inputReaderAdapter;
    private final MediaParser mediaParser;
    private final OutputConsumerAdapterV30 outputConsumerAdapter;
    private long pendingSeekUs;
    private Format[] sampleFormats;
    private ChunkExtractor.TrackOutputProvider trackOutputProvider;
    private final TrackOutputProviderAdapter trackOutputProviderAdapter;

    public static class Factory implements ChunkExtractor.Factory {
        private boolean parseSubtitlesDuringExtraction;
        private SubtitleParser.Factory subtitleParserFactory = new DefaultSubtitleParserFactory();

        @Override // io.bidmachine.media3.exoplayer.source.chunk.ChunkExtractor.Factory
        public Factory setSubtitleParserFactory(SubtitleParser.Factory factory) {
            this.subtitleParserFactory = (SubtitleParser.Factory) Assertions.checkNotNull(factory);
            return this;
        }

        @Override // io.bidmachine.media3.exoplayer.source.chunk.ChunkExtractor.Factory
        public Factory experimentalParseSubtitlesDuringExtraction(boolean z) {
            this.parseSubtitlesDuringExtraction = z;
            return this;
        }

        @Override // io.bidmachine.media3.exoplayer.source.chunk.ChunkExtractor.Factory
        public Format getOutputTextFormat(Format format) {
            if (this.parseSubtitlesDuringExtraction && this.subtitleParserFactory.supportsFormat(format)) {
                return format.buildUpon().setSampleMimeType(MimeTypes.APPLICATION_MEDIA3_CUES).setCueReplacementBehavior(this.subtitleParserFactory.getCueReplacementBehavior(format)).setCodecs(format.sampleMimeType + (format.codecs != null ? " " + format.codecs : "")).setSubsampleOffsetUs(Long.MAX_VALUE).build();
            }
            return format;
        }

        @Override // io.bidmachine.media3.exoplayer.source.chunk.ChunkExtractor.Factory
        public ChunkExtractor createProgressiveMediaExtractor(int i, Format format, boolean z, List<Format> list, TrackOutput trackOutput, PlayerId playerId) {
            if (!MimeTypes.isText(format.containerMimeType)) {
                return new MediaParserChunkExtractor(i, format, list, playerId);
            }
            if (this.parseSubtitlesDuringExtraction) {
                return new BundledChunkExtractor(new SubtitleExtractor(this.subtitleParserFactory.create(format), format), i, format);
            }
            return null;
        }
    }

    public MediaParserChunkExtractor(int i, Format format, List<Format> list, PlayerId playerId) {
        String str;
        OutputConsumerAdapterV30 outputConsumerAdapterV30 = new OutputConsumerAdapterV30(format, i, true);
        this.outputConsumerAdapter = outputConsumerAdapterV30;
        this.inputReaderAdapter = new InputReaderAdapterV30();
        if (MimeTypes.isMatroska((String) Assertions.checkNotNull(format.containerMimeType))) {
            str = "android.media.mediaparser.MatroskaParser";
        } else {
            str = "android.media.mediaparser.FragmentedMp4Parser";
        }
        outputConsumerAdapterV30.setSelectedParserName(str);
        MediaParser createByName = MediaParser.createByName(str, outputConsumerAdapterV30);
        this.mediaParser = createByName;
        createByName.setParameter("android.media.mediaparser.matroska.disableCuesSeeking", true);
        createByName.setParameter("android.media.mediaparser.inBandCryptoInfo", true);
        createByName.setParameter("android.media.mediaparser.includeSupplementalData", true);
        createByName.setParameter("android.media.mediaparser.eagerlyExposeTrackType", true);
        createByName.setParameter("android.media.mediaparser.exposeDummySeekMap", true);
        createByName.setParameter("android.media.mediaParser.exposeChunkIndexAsMediaFormat", true);
        createByName.setParameter("android.media.mediaParser.overrideInBandCaptionDeclarations", true);
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            arrayList.add(MediaParserUtil.toCaptionsMediaFormat(list.get(i2)));
        }
        this.mediaParser.setParameter("android.media.mediaParser.exposeCaptionFormats", arrayList);
        if (Util.SDK_INT >= 31) {
            MediaParserUtil.setLogSessionIdOnMediaParser(this.mediaParser, playerId);
        }
        this.outputConsumerAdapter.setMuxedCaptionFormats(list);
        this.trackOutputProviderAdapter = new TrackOutputProviderAdapter();
        this.discardingTrackOutput = new DiscardingTrackOutput();
        this.pendingSeekUs = -9223372036854775807L;
    }

    @Override // io.bidmachine.media3.exoplayer.source.chunk.ChunkExtractor
    public void init(ChunkExtractor.TrackOutputProvider trackOutputProvider, long j, long j2) {
        this.trackOutputProvider = trackOutputProvider;
        this.outputConsumerAdapter.setSampleTimestampUpperLimitFilterUs(j2);
        this.outputConsumerAdapter.setExtractorOutput(this.trackOutputProviderAdapter);
        this.pendingSeekUs = j;
    }

    @Override // io.bidmachine.media3.exoplayer.source.chunk.ChunkExtractor
    public void release() {
        this.mediaParser.release();
    }

    @Override // io.bidmachine.media3.exoplayer.source.chunk.ChunkExtractor
    public boolean read(ExtractorInput extractorInput) throws IOException {
        maybeExecutePendingSeek();
        this.inputReaderAdapter.setDataReader(extractorInput, extractorInput.getLength());
        return this.mediaParser.advance(this.inputReaderAdapter);
    }

    @Override // io.bidmachine.media3.exoplayer.source.chunk.ChunkExtractor
    public ChunkIndex getChunkIndex() {
        return this.outputConsumerAdapter.getChunkIndex();
    }

    @Override // io.bidmachine.media3.exoplayer.source.chunk.ChunkExtractor
    public Format[] getSampleFormats() {
        return this.sampleFormats;
    }

    private void maybeExecutePendingSeek() {
        MediaParser.SeekMap dummySeekMap = this.outputConsumerAdapter.getDummySeekMap();
        long j = this.pendingSeekUs;
        if (j == -9223372036854775807L || dummySeekMap == null) {
            return;
        }
        this.mediaParser.seek((MediaParser.SeekPoint) dummySeekMap.getSeekPoints(j).first);
        this.pendingSeekUs = -9223372036854775807L;
    }

    private class TrackOutputProviderAdapter implements ExtractorOutput {
        @Override // io.bidmachine.media3.extractor.ExtractorOutput
        public void seekMap(SeekMap seekMap) {
        }

        private TrackOutputProviderAdapter() {
        }

        @Override // io.bidmachine.media3.extractor.ExtractorOutput
        public TrackOutput track(int i, int i2) {
            return MediaParserChunkExtractor.this.trackOutputProvider != null ? MediaParserChunkExtractor.this.trackOutputProvider.track(i, i2) : MediaParserChunkExtractor.this.discardingTrackOutput;
        }

        @Override // io.bidmachine.media3.extractor.ExtractorOutput
        public void endTracks() {
            MediaParserChunkExtractor mediaParserChunkExtractor = MediaParserChunkExtractor.this;
            mediaParserChunkExtractor.sampleFormats = mediaParserChunkExtractor.outputConsumerAdapter.getSampleFormats();
        }
    }
}
