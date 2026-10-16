package io.bidmachine.media3.exoplayer.source;

import android.net.Uri;
import com.google.common.base.MoreObjects;
import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableList;
import io.bidmachine.media3.common.Format;
import io.bidmachine.media3.common.MediaItem;
import io.bidmachine.media3.common.Timeline;
import io.bidmachine.media3.common.util.Assertions;
import io.bidmachine.media3.common.util.Consumer;
import io.bidmachine.media3.datasource.DataSource;
import io.bidmachine.media3.datasource.DataSpec;
import io.bidmachine.media3.datasource.TransferListener;
import io.bidmachine.media3.exoplayer.source.MediaSource;
import io.bidmachine.media3.exoplayer.source.MediaSourceEventListener;
import io.bidmachine.media3.exoplayer.upstream.Allocator;
import io.bidmachine.media3.exoplayer.upstream.DefaultLoadErrorHandlingPolicy;
import io.bidmachine.media3.exoplayer.upstream.LoadErrorHandlingPolicy;
import io.bidmachine.media3.exoplayer.util.ReleasableExecutor;
import java.util.concurrent.Executor;

@Deprecated
/* loaded from: classes7.dex */
public final class SingleSampleMediaSource extends BaseMediaSource {
    private final DataSource.Factory dataSourceFactory;
    private final DataSpec dataSpec;
    private final Supplier<ReleasableExecutor> downloadExecutorSupplier;
    private final long durationUs;
    private final Format format;
    private final LoadErrorHandlingPolicy loadErrorHandlingPolicy;
    private final MediaItem mediaItem;
    private final Timeline timeline;
    private TransferListener transferListener;
    private final boolean treatLoadErrorsAsEndOfStream;

    @Override // io.bidmachine.media3.exoplayer.source.MediaSource
    public void maybeThrowSourceInfoRefreshError() {
    }

    @Override // io.bidmachine.media3.exoplayer.source.BaseMediaSource
    protected void releaseSourceInternal() {
    }

    public static final class Factory {
        private final DataSource.Factory dataSourceFactory;
        private Supplier<ReleasableExecutor> downloadExecutorSupplier;
        private Object tag;
        private String trackId;
        private LoadErrorHandlingPolicy loadErrorHandlingPolicy = new DefaultLoadErrorHandlingPolicy();
        private boolean treatLoadErrorsAsEndOfStream = true;

        public Factory(DataSource.Factory factory) {
            this.dataSourceFactory = (DataSource.Factory) Assertions.checkNotNull(factory);
        }

        public Factory setTag(Object obj) {
            this.tag = obj;
            return this;
        }

        @Deprecated
        public Factory setTrackId(String str) {
            this.trackId = str;
            return this;
        }

        public Factory setLoadErrorHandlingPolicy(LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
            if (loadErrorHandlingPolicy == null) {
                loadErrorHandlingPolicy = new DefaultLoadErrorHandlingPolicy();
            }
            this.loadErrorHandlingPolicy = loadErrorHandlingPolicy;
            return this;
        }

        public Factory setTreatLoadErrorsAsEndOfStream(boolean z) {
            this.treatLoadErrorsAsEndOfStream = z;
            return this;
        }

        public <T extends Executor> Factory setDownloadExecutor(final Supplier<T> supplier, final Consumer<T> consumer) {
            this.downloadExecutorSupplier = new Supplier() { // from class: io.bidmachine.media3.exoplayer.source.SingleSampleMediaSource$Factory$$ExternalSyntheticLambda0
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    ReleasableExecutor from;
                    from = ReleasableExecutor.from((Executor) Supplier.this.get(), consumer);
                    return from;
                }
            };
            return this;
        }

        public SingleSampleMediaSource createMediaSource(MediaItem.SubtitleConfiguration subtitleConfiguration, long j) {
            return new SingleSampleMediaSource(this.trackId, subtitleConfiguration, this.dataSourceFactory, j, this.loadErrorHandlingPolicy, this.treatLoadErrorsAsEndOfStream, this.tag, this.downloadExecutorSupplier);
        }
    }

    private SingleSampleMediaSource(String str, MediaItem.SubtitleConfiguration subtitleConfiguration, DataSource.Factory factory, long j, LoadErrorHandlingPolicy loadErrorHandlingPolicy, boolean z, Object obj, Supplier<ReleasableExecutor> supplier) {
        this.dataSourceFactory = factory;
        this.durationUs = j;
        this.loadErrorHandlingPolicy = loadErrorHandlingPolicy;
        this.treatLoadErrorsAsEndOfStream = z;
        MediaItem build = new MediaItem.Builder().setUri(Uri.EMPTY).setMediaId(subtitleConfiguration.uri.toString()).setSubtitleConfigurations(ImmutableList.of(subtitleConfiguration)).setTag(obj).build();
        this.mediaItem = build;
        this.format = new Format.Builder().setSampleMimeType((String) MoreObjects.firstNonNull(subtitleConfiguration.mimeType, "text/x-unknown")).setLanguage(subtitleConfiguration.language).setSelectionFlags(subtitleConfiguration.selectionFlags).setRoleFlags(subtitleConfiguration.roleFlags).setLabel(subtitleConfiguration.label).setId(subtitleConfiguration.id != null ? subtitleConfiguration.id : str).build();
        this.dataSpec = new DataSpec.Builder().setUri(subtitleConfiguration.uri).setFlags(1).build();
        this.timeline = new SinglePeriodTimeline(j, true, false, false, (Object) null, build);
        this.downloadExecutorSupplier = supplier;
    }

    @Override // io.bidmachine.media3.exoplayer.source.MediaSource
    public MediaItem getMediaItem() {
        return this.mediaItem;
    }

    @Override // io.bidmachine.media3.exoplayer.source.BaseMediaSource
    protected void prepareSourceInternal(TransferListener transferListener) {
        this.transferListener = transferListener;
        refreshSourceInfo(this.timeline);
    }

    @Override // io.bidmachine.media3.exoplayer.source.MediaSource
    public MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j) {
        DataSpec dataSpec = this.dataSpec;
        DataSource.Factory factory = this.dataSourceFactory;
        TransferListener transferListener = this.transferListener;
        Format format = this.format;
        long j2 = this.durationUs;
        LoadErrorHandlingPolicy loadErrorHandlingPolicy = this.loadErrorHandlingPolicy;
        MediaSourceEventListener.EventDispatcher createEventDispatcher = createEventDispatcher(mediaPeriodId);
        boolean z = this.treatLoadErrorsAsEndOfStream;
        Supplier<ReleasableExecutor> supplier = this.downloadExecutorSupplier;
        return new SingleSampleMediaPeriod(dataSpec, factory, transferListener, format, j2, loadErrorHandlingPolicy, createEventDispatcher, z, supplier != null ? supplier.get() : null);
    }

    @Override // io.bidmachine.media3.exoplayer.source.MediaSource
    public void releasePeriod(MediaPeriod mediaPeriod) {
        ((SingleSampleMediaPeriod) mediaPeriod).release();
    }
}
