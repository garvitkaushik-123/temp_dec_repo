package com.google.android.exoplayer2;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import com.google.android.exoplayer2.DefaultMediaClock;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.MediaSourceList;
import com.google.android.exoplayer2.PlayerMessage;
import com.google.android.exoplayer2.Renderer;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.analytics.AnalyticsCollector;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.MetadataRenderer;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.ShuffleOrder;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.text.TextRenderer;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectorResult;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DataSourceException;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.HandlerWrapper;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.TraceUtil;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Sets;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

@Deprecated
/* loaded from: classes4.dex */
final class ExoPlayerImplInternal implements Handler.Callback, MediaPeriod.Callback, TrackSelector.InvalidationListener, MediaSourceList.MediaSourceListInfoRefreshListener, DefaultMediaClock.PlaybackParametersListener, PlayerMessage.Sender {
    private static final int ACTIVE_INTERVAL_MS = 10;
    private static final int IDLE_INTERVAL_MS = 1000;
    private static final int MSG_ADD_MEDIA_SOURCES = 18;
    private static final int MSG_ATTEMPT_RENDERER_ERROR_RECOVERY = 25;
    private static final int MSG_DO_SOME_WORK = 2;
    private static final int MSG_MOVE_MEDIA_SOURCES = 19;
    private static final int MSG_PERIOD_PREPARED = 8;
    private static final int MSG_PLAYBACK_PARAMETERS_CHANGED_INTERNAL = 16;
    private static final int MSG_PLAYLIST_UPDATE_REQUESTED = 22;
    private static final int MSG_PREPARE = 0;
    private static final int MSG_RELEASE = 7;
    private static final int MSG_REMOVE_MEDIA_SOURCES = 20;
    private static final int MSG_RENDERER_CAPABILITIES_CHANGED = 26;
    private static final int MSG_SEEK_TO = 3;
    private static final int MSG_SEND_MESSAGE = 14;
    private static final int MSG_SEND_MESSAGE_TO_TARGET_THREAD = 15;
    private static final int MSG_SET_FOREGROUND_MODE = 13;
    private static final int MSG_SET_MEDIA_SOURCES = 17;
    private static final int MSG_SET_OFFLOAD_SCHEDULING_ENABLED = 24;
    private static final int MSG_SET_PAUSE_AT_END_OF_WINDOW = 23;
    private static final int MSG_SET_PLAYBACK_PARAMETERS = 4;
    private static final int MSG_SET_PLAY_WHEN_READY = 1;
    private static final int MSG_SET_REPEAT_MODE = 11;
    private static final int MSG_SET_SEEK_PARAMETERS = 5;
    private static final int MSG_SET_SHUFFLE_ENABLED = 12;
    private static final int MSG_SET_SHUFFLE_ORDER = 21;
    private static final int MSG_SOURCE_CONTINUE_LOADING_REQUESTED = 9;
    private static final int MSG_STOP = 6;
    private static final int MSG_TRACK_SELECTION_INVALIDATED = 10;
    private static final long PLAYBACK_BUFFER_EMPTY_THRESHOLD_US = 500000;
    private static final long PLAYBACK_STUCK_AFTER_MS = 4000;
    private static final String TAG = "ExoPlayerImplInternal";
    private final long backBufferDurationUs;
    private final BandwidthMeter bandwidthMeter;
    private final Clock clock;
    private boolean deliverPendingMessageAtStartPositionRequired;
    private final TrackSelectorResult emptyTrackSelectorResult;
    private int enabledRendererCount;
    private boolean foregroundMode;
    private final HandlerWrapper handler;
    private final HandlerThread internalPlaybackThread;
    private boolean isRebuffering;
    private final LivePlaybackSpeedControl livePlaybackSpeedControl;
    private final LoadControl loadControl;
    private final DefaultMediaClock mediaClock;
    private final MediaSourceList mediaSourceList;
    private int nextPendingMessageIndexHint;
    private boolean offloadSchedulingEnabled;
    private boolean pauseAtEndOfWindow;
    private SeekPosition pendingInitialSeekPosition;
    private final ArrayList<PendingMessageInfo> pendingMessages;
    private boolean pendingPauseAtEndOfPeriod;
    private ExoPlaybackException pendingRecoverableRendererError;
    private final Timeline.Period period;
    private PlaybackInfo playbackInfo;
    private PlaybackInfoUpdate playbackInfoUpdate;
    private final PlaybackInfoUpdateListener playbackInfoUpdateListener;
    private final Looper playbackLooper;
    private long playbackMaybeBecameStuckAtMs = -9223372036854775807L;
    private final MediaPeriodQueue queue;
    private final long releaseTimeoutMs;
    private boolean released;
    private final RendererCapabilities[] rendererCapabilities;
    private long rendererPositionUs;
    private final Renderer[] renderers;
    private final Set<Renderer> renderersToReset;
    private int repeatMode;
    private boolean requestForRendererSleep;
    private final boolean retainBackBufferFromKeyframe;
    private SeekParameters seekParameters;
    private long setForegroundModeTimeoutMs;
    private boolean shouldContinueLoading;
    private boolean shuffleModeEnabled;
    private final TrackSelector trackSelector;
    private final Timeline.Window window;

    public interface PlaybackInfoUpdateListener {
        void onPlaybackInfoUpdate(PlaybackInfoUpdate playbackInfoUpdate);
    }

    public static final class PlaybackInfoUpdate {
        public int discontinuityReason;
        private boolean hasPendingChange;
        public boolean hasPlayWhenReadyChangeReason;
        public int operationAcks;
        public int playWhenReadyChangeReason;
        public PlaybackInfo playbackInfo;
        public boolean positionDiscontinuity;

        public PlaybackInfoUpdate(PlaybackInfo playbackInfo) {
            this.playbackInfo = playbackInfo;
        }

        public void incrementPendingOperationAcks(int i) {
            this.hasPendingChange |= i > 0;
            this.operationAcks += i;
        }

        public void setPlaybackInfo(PlaybackInfo playbackInfo) {
            this.hasPendingChange |= this.playbackInfo != playbackInfo;
            this.playbackInfo = playbackInfo;
        }

        public void setPositionDiscontinuity(int i) {
            if (this.positionDiscontinuity && this.discontinuityReason != 5) {
                Assertions.checkArgument(i == 5);
                return;
            }
            this.hasPendingChange = true;
            this.positionDiscontinuity = true;
            this.discontinuityReason = i;
        }

        public void setPlayWhenReadyChangeReason(int i) {
            this.hasPendingChange = true;
            this.hasPlayWhenReadyChangeReason = true;
            this.playWhenReadyChangeReason = i;
        }
    }

    public ExoPlayerImplInternal(Renderer[] rendererArr, TrackSelector trackSelector, TrackSelectorResult trackSelectorResult, LoadControl loadControl, BandwidthMeter bandwidthMeter, int i, boolean z, AnalyticsCollector analyticsCollector, SeekParameters seekParameters, LivePlaybackSpeedControl livePlaybackSpeedControl, long j, boolean z2, Looper looper, Clock clock, PlaybackInfoUpdateListener playbackInfoUpdateListener, PlayerId playerId, Looper looper2) {
        this.playbackInfoUpdateListener = playbackInfoUpdateListener;
        this.renderers = rendererArr;
        this.trackSelector = trackSelector;
        this.emptyTrackSelectorResult = trackSelectorResult;
        this.loadControl = loadControl;
        this.bandwidthMeter = bandwidthMeter;
        this.repeatMode = i;
        this.shuffleModeEnabled = z;
        this.seekParameters = seekParameters;
        this.livePlaybackSpeedControl = livePlaybackSpeedControl;
        this.releaseTimeoutMs = j;
        this.setForegroundModeTimeoutMs = j;
        this.pauseAtEndOfWindow = z2;
        this.clock = clock;
        this.backBufferDurationUs = loadControl.getBackBufferDurationUs();
        this.retainBackBufferFromKeyframe = loadControl.retainBackBufferFromKeyframe();
        this.playbackInfo = PlaybackInfo.createDummy(trackSelectorResult);
        this.playbackInfoUpdate = new PlaybackInfoUpdate(this.playbackInfo);
        this.rendererCapabilities = new RendererCapabilities[rendererArr.length];
        RendererCapabilities.Listener rendererCapabilitiesListener = trackSelector.getRendererCapabilitiesListener();
        for (int i2 = 0; i2 < rendererArr.length; i2++) {
            rendererArr[i2].init(i2, playerId);
            this.rendererCapabilities[i2] = rendererArr[i2].getCapabilities();
            if (rendererCapabilitiesListener != null) {
                this.rendererCapabilities[i2].setListener(rendererCapabilitiesListener);
            }
        }
        this.mediaClock = new DefaultMediaClock(this, clock);
        this.pendingMessages = new ArrayList<>();
        this.renderersToReset = Sets.newIdentityHashSet();
        this.window = new Timeline.Window();
        this.period = new Timeline.Period();
        trackSelector.init(this, bandwidthMeter);
        this.deliverPendingMessageAtStartPositionRequired = true;
        HandlerWrapper createHandler = clock.createHandler(looper, null);
        this.queue = new MediaPeriodQueue(analyticsCollector, createHandler);
        this.mediaSourceList = new MediaSourceList(this, analyticsCollector, createHandler, playerId);
        if (looper2 != null) {
            this.internalPlaybackThread = null;
            this.playbackLooper = looper2;
        } else {
            HandlerThread handlerThread = new HandlerThread("ExoPlayer:Playback", -16);
            this.internalPlaybackThread = handlerThread;
            handlerThread.start();
            this.playbackLooper = handlerThread.getLooper();
        }
        this.handler = clock.createHandler(this.playbackLooper, this);
    }

    public void experimentalSetForegroundModeTimeoutMs(long j) {
        this.setForegroundModeTimeoutMs = j;
    }

    public void experimentalSetOffloadSchedulingEnabled(boolean z) {
        this.handler.obtainMessage(24, z ? 1 : 0, 0).sendToTarget();
    }

    public void prepare() {
        this.handler.obtainMessage(0).sendToTarget();
    }

    public void setPlayWhenReady(boolean z, int i) {
        this.handler.obtainMessage(1, z ? 1 : 0, i).sendToTarget();
    }

    public void setPauseAtEndOfWindow(boolean z) {
        this.handler.obtainMessage(23, z ? 1 : 0, 0).sendToTarget();
    }

    public void setRepeatMode(int i) {
        this.handler.obtainMessage(11, i, 0).sendToTarget();
    }

    public void setShuffleModeEnabled(boolean z) {
        this.handler.obtainMessage(12, z ? 1 : 0, 0).sendToTarget();
    }

    public void seekTo(Timeline timeline, int i, long j) {
        this.handler.obtainMessage(3, new SeekPosition(timeline, i, j)).sendToTarget();
    }

    public void setPlaybackParameters(PlaybackParameters playbackParameters) {
        this.handler.obtainMessage(4, playbackParameters).sendToTarget();
    }

    public void setSeekParameters(SeekParameters seekParameters) {
        this.handler.obtainMessage(5, seekParameters).sendToTarget();
    }

    public void stop() {
        this.handler.obtainMessage(6).sendToTarget();
    }

    public void setMediaSources(List<MediaSourceList.MediaSourceHolder> list, int i, long j, ShuffleOrder shuffleOrder) {
        this.handler.obtainMessage(17, new MediaSourceListUpdateMessage(list, shuffleOrder, i, j)).sendToTarget();
    }

    public void addMediaSources(int i, List<MediaSourceList.MediaSourceHolder> list, ShuffleOrder shuffleOrder) {
        this.handler.obtainMessage(18, i, 0, new MediaSourceListUpdateMessage(list, shuffleOrder, -1, -9223372036854775807L)).sendToTarget();
    }

    public void removeMediaSources(int i, int i2, ShuffleOrder shuffleOrder) {
        this.handler.obtainMessage(20, i, i2, shuffleOrder).sendToTarget();
    }

    public void moveMediaSources(int i, int i2, int i3, ShuffleOrder shuffleOrder) {
        this.handler.obtainMessage(19, new MoveMediaItemsMessage(i, i2, i3, shuffleOrder)).sendToTarget();
    }

    public void setShuffleOrder(ShuffleOrder shuffleOrder) {
        this.handler.obtainMessage(21, shuffleOrder).sendToTarget();
    }

    @Override // com.google.android.exoplayer2.PlayerMessage.Sender
    public synchronized void sendMessage(PlayerMessage playerMessage) {
        if (!this.released && this.playbackLooper.getThread().isAlive()) {
            this.handler.obtainMessage(14, playerMessage).sendToTarget();
            return;
        }
        Log.w(TAG, "Ignoring messages sent after release.");
        playerMessage.markAsProcessed(false);
    }

    public synchronized boolean setForegroundMode(boolean z) {
        if (!this.released && this.playbackLooper.getThread().isAlive()) {
            if (z) {
                this.handler.obtainMessage(13, 1, 0).sendToTarget();
                return true;
            }
            final AtomicBoolean atomicBoolean = new AtomicBoolean();
            this.handler.obtainMessage(13, 0, 0, atomicBoolean).sendToTarget();
            Objects.requireNonNull(atomicBoolean);
            waitUninterruptibly(new Supplier() { // from class: com.google.android.exoplayer2.ExoPlayerImplInternal$$ExternalSyntheticLambda0
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    boolean z2;
                    z2 = atomicBoolean.get();
                    return Boolean.valueOf(z2);
                }
            }, this.setForegroundModeTimeoutMs);
            return atomicBoolean.get();
        }
        return true;
    }

    public synchronized boolean release() {
        if (!this.released && this.playbackLooper.getThread().isAlive()) {
            this.handler.sendEmptyMessage(7);
            waitUninterruptibly(new Supplier() { // from class: com.google.android.exoplayer2.ExoPlayerImplInternal$$ExternalSyntheticLambda1
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    return ExoPlayerImplInternal.this.m7113x37739a9a();
                }
            }, this.releaseTimeoutMs);
            return this.released;
        }
        return true;
    }

    /* renamed from: lambda$release$0$com-google-android-exoplayer2-ExoPlayerImplInternal, reason: not valid java name */
    /* synthetic */ Boolean m7113x37739a9a() {
        return Boolean.valueOf(this.released);
    }

    public Looper getPlaybackLooper() {
        return this.playbackLooper;
    }

    @Override // com.google.android.exoplayer2.MediaSourceList.MediaSourceListInfoRefreshListener
    public void onPlaylistUpdateRequested() {
        this.handler.sendEmptyMessage(22);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod.Callback
    public void onPrepared(MediaPeriod mediaPeriod) {
        this.handler.obtainMessage(8, mediaPeriod).sendToTarget();
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader.Callback
    public void onContinueLoadingRequested(MediaPeriod mediaPeriod) {
        this.handler.obtainMessage(9, mediaPeriod).sendToTarget();
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelector.InvalidationListener
    public void onTrackSelectionsInvalidated() {
        this.handler.sendEmptyMessage(10);
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelector.InvalidationListener
    public void onRendererCapabilitiesChanged(Renderer renderer) {
        this.handler.sendEmptyMessage(26);
    }

    @Override // com.google.android.exoplayer2.DefaultMediaClock.PlaybackParametersListener
    public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
        this.handler.obtainMessage(16, playbackParameters).sendToTarget();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i;
        MediaPeriodHolder readingPeriod;
        try {
            switch (message.what) {
                case 0:
                    prepareInternal();
                    break;
                case 1:
                    setPlayWhenReadyInternal(message.arg1 != 0, message.arg2, true, 1);
                    break;
                case 2:
                    doSomeWork();
                    break;
                case 3:
                    seekToInternal((SeekPosition) message.obj);
                    break;
                case 4:
                    setPlaybackParametersInternal((PlaybackParameters) message.obj);
                    break;
                case 5:
                    setSeekParametersInternal((SeekParameters) message.obj);
                    break;
                case 6:
                    stopInternal(false, true);
                    break;
                case 7:
                    releaseInternal();
                    return true;
                case 8:
                    handlePeriodPrepared((MediaPeriod) message.obj);
                    break;
                case 9:
                    handleContinueLoadingRequested((MediaPeriod) message.obj);
                    break;
                case 10:
                    reselectTracksInternal();
                    break;
                case 11:
                    setRepeatModeInternal(message.arg1);
                    break;
                case 12:
                    setShuffleModeEnabledInternal(message.arg1 != 0);
                    break;
                case 13:
                    setForegroundModeInternal(message.arg1 != 0, (AtomicBoolean) message.obj);
                    break;
                case 14:
                    sendMessageInternal((PlayerMessage) message.obj);
                    break;
                case 15:
                    sendMessageToTargetThread((PlayerMessage) message.obj);
                    break;
                case 16:
                    handlePlaybackParameters((PlaybackParameters) message.obj, false);
                    break;
                case 17:
                    setMediaItemsInternal((MediaSourceListUpdateMessage) message.obj);
                    break;
                case 18:
                    addMediaItemsInternal((MediaSourceListUpdateMessage) message.obj, message.arg1);
                    break;
                case 19:
                    moveMediaItemsInternal((MoveMediaItemsMessage) message.obj);
                    break;
                case 20:
                    removeMediaItemsInternal(message.arg1, message.arg2, (ShuffleOrder) message.obj);
                    break;
                case 21:
                    setShuffleOrderInternal((ShuffleOrder) message.obj);
                    break;
                case 22:
                    mediaSourceListUpdateRequestedInternal();
                    break;
                case 23:
                    setPauseAtEndOfWindowInternal(message.arg1 != 0);
                    break;
                case 24:
                    setOffloadSchedulingEnabledInternal(message.arg1 == 1);
                    break;
                case 25:
                    attemptRendererErrorRecovery();
                    break;
                case 26:
                    reselectTracksInternalAndSeek();
                    break;
                default:
                    return false;
            }
        } catch (ExoPlaybackException e) {
            e = e;
            if (e.type == 1 && (readingPeriod = this.queue.getReadingPeriod()) != null) {
                e = e.copyWithMediaPeriodId(readingPeriod.info.id);
            }
            if (e.isRecoverable && this.pendingRecoverableRendererError == null) {
                Log.w(TAG, "Recoverable renderer error", e);
                this.pendingRecoverableRendererError = e;
                HandlerWrapper handlerWrapper = this.handler;
                handlerWrapper.sendMessageAtFrontOfQueue(handlerWrapper.obtainMessage(25, e));
            } else {
                ExoPlaybackException exoPlaybackException = this.pendingRecoverableRendererError;
                if (exoPlaybackException != null) {
                    exoPlaybackException.addSuppressed(e);
                    e = this.pendingRecoverableRendererError;
                }
                Log.e(TAG, "Playback error", e);
                if (e.type == 1 && this.queue.getPlayingPeriod() != this.queue.getReadingPeriod()) {
                    while (this.queue.getPlayingPeriod() != this.queue.getReadingPeriod()) {
                        this.queue.advancePlayingPeriod();
                    }
                    MediaPeriodHolder mediaPeriodHolder = (MediaPeriodHolder) Assertions.checkNotNull(this.queue.getPlayingPeriod());
                    this.playbackInfo = handlePositionDiscontinuity(mediaPeriodHolder.info.id, mediaPeriodHolder.info.startPositionUs, mediaPeriodHolder.info.requestedContentPositionUs, mediaPeriodHolder.info.startPositionUs, true, 0);
                }
                stopInternal(true, false);
                this.playbackInfo = this.playbackInfo.copyWithPlaybackError(e);
            }
        } catch (ParserException e2) {
            if (e2.dataType == 1) {
                i = e2.contentIsMalformed ? 3001 : 3003;
            } else {
                if (e2.dataType == 4) {
                    i = e2.contentIsMalformed ? 3002 : 3004;
                }
                handleIoException(e2, r4);
            }
            r4 = i;
            handleIoException(e2, r4);
        } catch (DrmSession.DrmSessionException e3) {
            handleIoException(e3, e3.errorCode);
        } catch (BehindLiveWindowException e4) {
            handleIoException(e4, 1002);
        } catch (DataSourceException e5) {
            handleIoException(e5, e5.reason);
        } catch (IOException e6) {
            handleIoException(e6, 2000);
        } catch (RuntimeException e7) {
            ExoPlaybackException createForUnexpected = ExoPlaybackException.createForUnexpected(e7, ((e7 instanceof IllegalStateException) || (e7 instanceof IllegalArgumentException)) ? 1004 : 1000);
            Log.e(TAG, "Playback error", createForUnexpected);
            stopInternal(true, false);
            this.playbackInfo = this.playbackInfo.copyWithPlaybackError(createForUnexpected);
        }
        maybeNotifyPlaybackInfoChanged();
        return true;
    }

    private void handleIoException(IOException iOException, int i) {
        ExoPlaybackException createForSource = ExoPlaybackException.createForSource(iOException, i);
        MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
        if (playingPeriod != null) {
            createForSource = createForSource.copyWithMediaPeriodId(playingPeriod.info.id);
        }
        Log.e(TAG, "Playback error", createForSource);
        stopInternal(false, false);
        this.playbackInfo = this.playbackInfo.copyWithPlaybackError(createForSource);
    }

    private synchronized void waitUninterruptibly(Supplier<Boolean> supplier, long j) {
        long elapsedRealtime = this.clock.elapsedRealtime() + j;
        boolean z = false;
        while (!supplier.get().booleanValue() && j > 0) {
            try {
                this.clock.onThreadBlocked();
                wait(j);
            } catch (InterruptedException unused) {
                z = true;
            }
            j = elapsedRealtime - this.clock.elapsedRealtime();
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    private void setState(int i) {
        if (this.playbackInfo.playbackState != i) {
            if (i != 2) {
                this.playbackMaybeBecameStuckAtMs = -9223372036854775807L;
            }
            this.playbackInfo = this.playbackInfo.copyWithPlaybackState(i);
        }
    }

    private void maybeNotifyPlaybackInfoChanged() {
        this.playbackInfoUpdate.setPlaybackInfo(this.playbackInfo);
        if (this.playbackInfoUpdate.hasPendingChange) {
            this.playbackInfoUpdateListener.onPlaybackInfoUpdate(this.playbackInfoUpdate);
            this.playbackInfoUpdate = new PlaybackInfoUpdate(this.playbackInfo);
        }
    }

    private void prepareInternal() {
        this.playbackInfoUpdate.incrementPendingOperationAcks(1);
        resetInternal(false, false, false, true);
        this.loadControl.onPrepared();
        setState(this.playbackInfo.timeline.isEmpty() ? 4 : 2);
        this.mediaSourceList.prepare(this.bandwidthMeter.getTransferListener());
        this.handler.sendEmptyMessage(2);
    }

    private void setMediaItemsInternal(MediaSourceListUpdateMessage mediaSourceListUpdateMessage) throws ExoPlaybackException {
        this.playbackInfoUpdate.incrementPendingOperationAcks(1);
        if (mediaSourceListUpdateMessage.windowIndex != -1) {
            this.pendingInitialSeekPosition = new SeekPosition(new PlaylistTimeline(mediaSourceListUpdateMessage.mediaSourceHolders, mediaSourceListUpdateMessage.shuffleOrder), mediaSourceListUpdateMessage.windowIndex, mediaSourceListUpdateMessage.positionUs);
        }
        handleMediaSourceListInfoRefreshed(this.mediaSourceList.setMediaSources(mediaSourceListUpdateMessage.mediaSourceHolders, mediaSourceListUpdateMessage.shuffleOrder), false);
    }

    private void addMediaItemsInternal(MediaSourceListUpdateMessage mediaSourceListUpdateMessage, int i) throws ExoPlaybackException {
        this.playbackInfoUpdate.incrementPendingOperationAcks(1);
        MediaSourceList mediaSourceList = this.mediaSourceList;
        if (i == -1) {
            i = mediaSourceList.getSize();
        }
        handleMediaSourceListInfoRefreshed(mediaSourceList.addMediaSources(i, mediaSourceListUpdateMessage.mediaSourceHolders, mediaSourceListUpdateMessage.shuffleOrder), false);
    }

    private void moveMediaItemsInternal(MoveMediaItemsMessage moveMediaItemsMessage) throws ExoPlaybackException {
        this.playbackInfoUpdate.incrementPendingOperationAcks(1);
        handleMediaSourceListInfoRefreshed(this.mediaSourceList.moveMediaSourceRange(moveMediaItemsMessage.fromIndex, moveMediaItemsMessage.toIndex, moveMediaItemsMessage.newFromIndex, moveMediaItemsMessage.shuffleOrder), false);
    }

    private void removeMediaItemsInternal(int i, int i2, ShuffleOrder shuffleOrder) throws ExoPlaybackException {
        this.playbackInfoUpdate.incrementPendingOperationAcks(1);
        handleMediaSourceListInfoRefreshed(this.mediaSourceList.removeMediaSourceRange(i, i2, shuffleOrder), false);
    }

    private void mediaSourceListUpdateRequestedInternal() throws ExoPlaybackException {
        handleMediaSourceListInfoRefreshed(this.mediaSourceList.createTimeline(), true);
    }

    private void setShuffleOrderInternal(ShuffleOrder shuffleOrder) throws ExoPlaybackException {
        this.playbackInfoUpdate.incrementPendingOperationAcks(1);
        handleMediaSourceListInfoRefreshed(this.mediaSourceList.setShuffleOrder(shuffleOrder), false);
    }

    private void notifyTrackSelectionPlayWhenReadyChanged(boolean z) {
        for (MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod(); playingPeriod != null; playingPeriod = playingPeriod.getNext()) {
            for (ExoTrackSelection exoTrackSelection : playingPeriod.getTrackSelectorResult().selections) {
                if (exoTrackSelection != null) {
                    exoTrackSelection.onPlayWhenReadyChanged(z);
                }
            }
        }
    }

    private void setPlayWhenReadyInternal(boolean z, int i, boolean z2, int i2) throws ExoPlaybackException {
        this.playbackInfoUpdate.incrementPendingOperationAcks(z2 ? 1 : 0);
        this.playbackInfoUpdate.setPlayWhenReadyChangeReason(i2);
        this.playbackInfo = this.playbackInfo.copyWithPlayWhenReady(z, i);
        this.isRebuffering = false;
        notifyTrackSelectionPlayWhenReadyChanged(z);
        if (!shouldPlayWhenReady()) {
            stopRenderers();
            updatePlaybackPositions();
        } else if (this.playbackInfo.playbackState == 3) {
            startRenderers();
            this.handler.sendEmptyMessage(2);
        } else if (this.playbackInfo.playbackState == 2) {
            this.handler.sendEmptyMessage(2);
        }
    }

    private void setPauseAtEndOfWindowInternal(boolean z) throws ExoPlaybackException {
        this.pauseAtEndOfWindow = z;
        resetPendingPauseAtEndOfPeriod();
        if (!this.pendingPauseAtEndOfPeriod || this.queue.getReadingPeriod() == this.queue.getPlayingPeriod()) {
            return;
        }
        seekToCurrentPosition(true);
        handleLoadingMediaPeriodChanged(false);
    }

    private void setOffloadSchedulingEnabledInternal(boolean z) {
        if (z == this.offloadSchedulingEnabled) {
            return;
        }
        this.offloadSchedulingEnabled = z;
        if (z || !this.playbackInfo.sleepingForOffload) {
            return;
        }
        this.handler.sendEmptyMessage(2);
    }

    private void setRepeatModeInternal(int i) throws ExoPlaybackException {
        this.repeatMode = i;
        if (!this.queue.updateRepeatMode(this.playbackInfo.timeline, i)) {
            seekToCurrentPosition(true);
        }
        handleLoadingMediaPeriodChanged(false);
    }

    private void setShuffleModeEnabledInternal(boolean z) throws ExoPlaybackException {
        this.shuffleModeEnabled = z;
        if (!this.queue.updateShuffleModeEnabled(this.playbackInfo.timeline, z)) {
            seekToCurrentPosition(true);
        }
        handleLoadingMediaPeriodChanged(false);
    }

    private void seekToCurrentPosition(boolean z) throws ExoPlaybackException {
        MediaSource.MediaPeriodId mediaPeriodId = this.queue.getPlayingPeriod().info.id;
        long seekToPeriodPosition = seekToPeriodPosition(mediaPeriodId, this.playbackInfo.positionUs, true, false);
        if (seekToPeriodPosition != this.playbackInfo.positionUs) {
            this.playbackInfo = handlePositionDiscontinuity(mediaPeriodId, seekToPeriodPosition, this.playbackInfo.requestedContentPositionUs, this.playbackInfo.discontinuityStartPositionUs, z, 5);
        }
    }

    private void startRenderers() throws ExoPlaybackException {
        this.isRebuffering = false;
        this.mediaClock.start();
        for (Renderer renderer : this.renderers) {
            if (isRendererEnabled(renderer)) {
                renderer.start();
            }
        }
    }

    private void stopRenderers() throws ExoPlaybackException {
        this.mediaClock.stop();
        for (Renderer renderer : this.renderers) {
            if (isRendererEnabled(renderer)) {
                ensureStopped(renderer);
            }
        }
    }

    private void attemptRendererErrorRecovery() throws ExoPlaybackException {
        reselectTracksInternalAndSeek();
    }

    private void updatePlaybackPositions() throws ExoPlaybackException {
        MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
        if (playingPeriod == null) {
            return;
        }
        long readDiscontinuity = playingPeriod.prepared ? playingPeriod.mediaPeriod.readDiscontinuity() : -9223372036854775807L;
        if (readDiscontinuity != -9223372036854775807L) {
            resetRendererPosition(readDiscontinuity);
            if (readDiscontinuity != this.playbackInfo.positionUs) {
                long j = readDiscontinuity;
                this.playbackInfo = handlePositionDiscontinuity(this.playbackInfo.periodId, j, this.playbackInfo.requestedContentPositionUs, j, true, 5);
            }
        } else {
            long syncAndGetPositionUs = this.mediaClock.syncAndGetPositionUs(playingPeriod != this.queue.getReadingPeriod());
            this.rendererPositionUs = syncAndGetPositionUs;
            long periodTime = playingPeriod.toPeriodTime(syncAndGetPositionUs);
            maybeTriggerPendingMessages(this.playbackInfo.positionUs, periodTime);
            this.playbackInfo.updatePositionUs(periodTime);
        }
        this.playbackInfo.bufferedPositionUs = this.queue.getLoadingPeriod().getBufferedPositionUs();
        this.playbackInfo.totalBufferedDurationUs = getTotalBufferedDurationUs();
        if (this.playbackInfo.playWhenReady && this.playbackInfo.playbackState == 3 && shouldUseLivePlaybackSpeedControl(this.playbackInfo.timeline, this.playbackInfo.periodId) && this.playbackInfo.playbackParameters.speed == 1.0f) {
            float adjustedPlaybackSpeed = this.livePlaybackSpeedControl.getAdjustedPlaybackSpeed(getCurrentLiveOffsetUs(), getTotalBufferedDurationUs());
            if (this.mediaClock.getPlaybackParameters().speed != adjustedPlaybackSpeed) {
                setMediaClockPlaybackParameters(this.playbackInfo.playbackParameters.withSpeed(adjustedPlaybackSpeed));
                handlePlaybackParameters(this.playbackInfo.playbackParameters, this.mediaClock.getPlaybackParameters().speed, false, false);
            }
        }
    }

    private void setMediaClockPlaybackParameters(PlaybackParameters playbackParameters) {
        this.handler.removeMessages(16);
        this.mediaClock.setPlaybackParameters(playbackParameters);
    }

    private void notifyTrackSelectionRebuffer() {
        for (MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod(); playingPeriod != null; playingPeriod = playingPeriod.getNext()) {
            for (ExoTrackSelection exoTrackSelection : playingPeriod.getTrackSelectorResult().selections) {
                if (exoTrackSelection != null) {
                    exoTrackSelection.onRebuffer();
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x01cc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void doSomeWork() throws ExoPlaybackException, IOException {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        long uptimeMillis = this.clock.uptimeMillis();
        this.handler.removeMessages(2);
        updatePeriods();
        if (this.playbackInfo.playbackState == 1 || this.playbackInfo.playbackState == 4) {
            return;
        }
        MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
        if (playingPeriod == null) {
            scheduleNextWork(uptimeMillis, 10L);
            return;
        }
        TraceUtil.beginSection("doSomeWork");
        updatePlaybackPositions();
        if (playingPeriod.prepared) {
            long elapsedRealtime = SystemClock.elapsedRealtime() * 1000;
            playingPeriod.mediaPeriod.discardBuffer(this.playbackInfo.positionUs - this.backBufferDurationUs, this.retainBackBufferFromKeyframe);
            z = true;
            z2 = true;
            int i = 0;
            while (true) {
                Renderer[] rendererArr = this.renderers;
                if (i >= rendererArr.length) {
                    break;
                }
                Renderer renderer = rendererArr[i];
                if (isRendererEnabled(renderer)) {
                    renderer.render(this.rendererPositionUs, elapsedRealtime);
                    z = z && renderer.isEnded();
                    boolean z5 = playingPeriod.sampleStreams[i] != renderer.getStream();
                    boolean z6 = z5 || (!z5 && renderer.hasReadStreamToEnd()) || renderer.isReady() || renderer.isEnded();
                    z2 = z2 && z6;
                    if (!z6) {
                        renderer.maybeThrowStreamError();
                    }
                }
                i++;
            }
        } else {
            playingPeriod.mediaPeriod.maybeThrowPrepareError();
            z = true;
            z2 = true;
        }
        long j = playingPeriod.info.durationUs;
        boolean z7 = z && playingPeriod.prepared && (j == -9223372036854775807L || j <= this.playbackInfo.positionUs);
        if (z7 && this.pendingPauseAtEndOfPeriod) {
            this.pendingPauseAtEndOfPeriod = false;
            setPlayWhenReadyInternal(false, this.playbackInfo.playbackSuppressionReason, false, 5);
        }
        if (z7 && playingPeriod.info.isFinal) {
            setState(4);
            stopRenderers();
        } else if (this.playbackInfo.playbackState == 2 && shouldTransitionToReadyState(z2)) {
            setState(3);
            this.pendingRecoverableRendererError = null;
            if (shouldPlayWhenReady()) {
                startRenderers();
            }
        } else if (this.playbackInfo.playbackState == 3 && (this.enabledRendererCount != 0 ? !z2 : !isTimelineReady())) {
            this.isRebuffering = shouldPlayWhenReady();
            setState(2);
            if (this.isRebuffering) {
                notifyTrackSelectionRebuffer();
                this.livePlaybackSpeedControl.notifyRebuffer();
            }
            stopRenderers();
        }
        if (this.playbackInfo.playbackState == 2) {
            int i2 = 0;
            while (true) {
                Renderer[] rendererArr2 = this.renderers;
                if (i2 >= rendererArr2.length) {
                    break;
                }
                if (isRendererEnabled(rendererArr2[i2]) && this.renderers[i2].getStream() == playingPeriod.sampleStreams[i2]) {
                    this.renderers[i2].maybeThrowStreamError();
                }
                i2++;
            }
            if (!this.playbackInfo.isLoading && this.playbackInfo.totalBufferedDurationUs < PLAYBACK_BUFFER_EMPTY_THRESHOLD_US && isLoadingPossible()) {
                if (this.playbackMaybeBecameStuckAtMs == -9223372036854775807L) {
                    this.playbackMaybeBecameStuckAtMs = this.clock.elapsedRealtime();
                } else if (this.clock.elapsedRealtime() - this.playbackMaybeBecameStuckAtMs >= PLAYBACK_STUCK_AFTER_MS) {
                    throw new IllegalStateException("Playback stuck buffering and not loading");
                }
                z3 = !shouldPlayWhenReady() && this.playbackInfo.playbackState == 3;
                z4 = !this.offloadSchedulingEnabled && this.requestForRendererSleep && z3;
                if (this.playbackInfo.sleepingForOffload != z4) {
                    this.playbackInfo = this.playbackInfo.copyWithSleepingForOffload(z4);
                }
                this.requestForRendererSleep = false;
                if (!z4 && this.playbackInfo.playbackState != 4) {
                    if (!z3 || this.playbackInfo.playbackState == 2) {
                        scheduleNextWork(uptimeMillis, 10L);
                    } else if (this.playbackInfo.playbackState == 3 && this.enabledRendererCount != 0) {
                        scheduleNextWork(uptimeMillis, 1000L);
                    }
                }
                TraceUtil.endSection();
            }
        }
        this.playbackMaybeBecameStuckAtMs = -9223372036854775807L;
        if (shouldPlayWhenReady()) {
        }
        if (this.offloadSchedulingEnabled) {
        }
        if (this.playbackInfo.sleepingForOffload != z4) {
        }
        this.requestForRendererSleep = false;
        if (!z4) {
            if (!z3) {
            }
            scheduleNextWork(uptimeMillis, 10L);
        }
        TraceUtil.endSection();
    }

    private long getCurrentLiveOffsetUs() {
        return getLiveOffsetUs(this.playbackInfo.timeline, this.playbackInfo.periodId.periodUid, this.playbackInfo.positionUs);
    }

    private long getLiveOffsetUs(Timeline timeline, Object obj, long j) {
        timeline.getWindow(timeline.getPeriodByUid(obj, this.period).windowIndex, this.window);
        if (this.window.windowStartTimeMs != -9223372036854775807L && this.window.isLive() && this.window.isDynamic) {
            return Util.msToUs(this.window.getCurrentUnixTimeMs() - this.window.windowStartTimeMs) - (j + this.period.getPositionInWindowUs());
        }
        return -9223372036854775807L;
    }

    private boolean shouldUseLivePlaybackSpeedControl(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId) {
        if (!mediaPeriodId.isAd() && !timeline.isEmpty()) {
            timeline.getWindow(timeline.getPeriodByUid(mediaPeriodId.periodUid, this.period).windowIndex, this.window);
            if (this.window.isLive() && this.window.isDynamic && this.window.windowStartTimeMs != -9223372036854775807L) {
                return true;
            }
        }
        return false;
    }

    private void scheduleNextWork(long j, long j2) {
        this.handler.sendEmptyMessageAtTime(2, j + j2);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:20|(7:(9:52|53|(1:82)(1:59)|60|61|62|63|(7:65|66|(3:71|72|73)|68|69|11|12)|78)(1:22)|35|36|37|10|11|12)|23|24|(1:26)(1:48)|27|28|(1:30)|31|32|33|34) */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0153, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0154, code lost:
    
        r2 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0157, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00f9, code lost:
    
        if (r1.playbackInfo.playbackState == 3) goto L56;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x00a1 A[Catch: all -> 0x015a, TryCatch #4 {all -> 0x015a, blocks: (B:6:0x0097, B:8:0x00a1, B:16:0x00a7, B:18:0x00ad, B:19:0x00b0, B:20:0x00b8, B:55:0x00ca, B:59:0x00d2), top: B:5:0x0097 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void seekToInternal(SeekPosition seekPosition) throws ExoPlaybackException {
        long longValue;
        MediaSource.MediaPeriodId resolveMediaPeriodIdForAdsAfterPeriodPositionChange;
        long j;
        boolean z;
        long j2;
        boolean z2;
        MediaSource.MediaPeriodId mediaPeriodId;
        long j3;
        MediaSource.MediaPeriodId mediaPeriodId2;
        long adjustedSeekPositionUs;
        int i;
        long j4;
        MediaSource.MediaPeriodId mediaPeriodId3;
        long j5;
        long seekToPeriodPosition;
        long j6;
        MediaSource.MediaPeriodId mediaPeriodId4;
        ExoPlayerImplInternal exoPlayerImplInternal = this;
        exoPlayerImplInternal.playbackInfoUpdate.incrementPendingOperationAcks(1);
        Pair<Object, Long> resolveSeekPositionUs = resolveSeekPositionUs(exoPlayerImplInternal.playbackInfo.timeline, seekPosition, true, exoPlayerImplInternal.repeatMode, exoPlayerImplInternal.shuffleModeEnabled, exoPlayerImplInternal.window, exoPlayerImplInternal.period);
        try {
            if (resolveSeekPositionUs == null) {
                Pair<MediaSource.MediaPeriodId, Long> placeholderFirstMediaPeriodPositionUs = exoPlayerImplInternal.getPlaceholderFirstMediaPeriodPositionUs(exoPlayerImplInternal.playbackInfo.timeline);
                resolveMediaPeriodIdForAdsAfterPeriodPositionChange = (MediaSource.MediaPeriodId) placeholderFirstMediaPeriodPositionUs.first;
                longValue = ((Long) placeholderFirstMediaPeriodPositionUs.second).longValue();
                z = !exoPlayerImplInternal.playbackInfo.timeline.isEmpty();
                j2 = -9223372036854775807L;
            } else {
                Object obj = resolveSeekPositionUs.first;
                longValue = ((Long) resolveSeekPositionUs.second).longValue();
                long j7 = seekPosition.windowPositionUs == -9223372036854775807L ? -9223372036854775807L : longValue;
                resolveMediaPeriodIdForAdsAfterPeriodPositionChange = exoPlayerImplInternal.queue.resolveMediaPeriodIdForAdsAfterPeriodPositionChange(exoPlayerImplInternal.playbackInfo.timeline, obj, longValue);
                if (resolveMediaPeriodIdForAdsAfterPeriodPositionChange.isAd()) {
                    exoPlayerImplInternal.playbackInfo.timeline.getPeriodByUid(resolveMediaPeriodIdForAdsAfterPeriodPositionChange.periodUid, exoPlayerImplInternal.period);
                    longValue = exoPlayerImplInternal.period.getFirstAdIndexToPlay(resolveMediaPeriodIdForAdsAfterPeriodPositionChange.adGroupIndex) == resolveMediaPeriodIdForAdsAfterPeriodPositionChange.adIndexInAdGroup ? exoPlayerImplInternal.period.getAdResumePositionUs() : 0L;
                    z = true;
                    j2 = j7;
                } else {
                    j = 0;
                    z = seekPosition.windowPositionUs == -9223372036854775807L;
                    j2 = j7;
                    if (!exoPlayerImplInternal.playbackInfo.timeline.isEmpty()) {
                        exoPlayerImplInternal.pendingInitialSeekPosition = seekPosition;
                    } else if (resolveSeekPositionUs == null) {
                        if (exoPlayerImplInternal.playbackInfo.playbackState != 1) {
                            exoPlayerImplInternal.setState(4);
                        }
                        exoPlayerImplInternal.resetInternal(false, true, false, true);
                    } else {
                        try {
                            if (resolveMediaPeriodIdForAdsAfterPeriodPositionChange.equals(exoPlayerImplInternal.playbackInfo.periodId)) {
                                try {
                                    MediaPeriodHolder playingPeriod = exoPlayerImplInternal.queue.getPlayingPeriod();
                                    adjustedSeekPositionUs = (playingPeriod == null || !playingPeriod.prepared || longValue == j) ? longValue : playingPeriod.mediaPeriod.getAdjustedSeekPositionUs(longValue, exoPlayerImplInternal.seekParameters);
                                    mediaPeriodId2 = resolveMediaPeriodIdForAdsAfterPeriodPositionChange;
                                    try {
                                        if (Util.usToMs(adjustedSeekPositionUs) == Util.usToMs(exoPlayerImplInternal.playbackInfo.positionUs)) {
                                            if (exoPlayerImplInternal.playbackInfo.playbackState != 2) {
                                                try {
                                                } catch (Throwable th) {
                                                    th = th;
                                                    mediaPeriodId = mediaPeriodId2;
                                                    z2 = z;
                                                    j3 = longValue;
                                                    exoPlayerImplInternal.playbackInfo = exoPlayerImplInternal.handlePositionDiscontinuity(mediaPeriodId, j3, j2, j3, z2, 2);
                                                    throw th;
                                                }
                                            }
                                            long j8 = exoPlayerImplInternal.playbackInfo.positionUs;
                                            i = 2;
                                            z2 = z;
                                            j4 = j8;
                                            mediaPeriodId3 = mediaPeriodId2;
                                            j5 = j8;
                                            exoPlayerImplInternal.playbackInfo = exoPlayerImplInternal.handlePositionDiscontinuity(mediaPeriodId3, j5, j2, j4, z2, i);
                                            return;
                                        }
                                        z2 = z;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        z2 = z;
                                        mediaPeriodId = mediaPeriodId2;
                                        j3 = longValue;
                                        exoPlayerImplInternal.playbackInfo = exoPlayerImplInternal.handlePositionDiscontinuity(mediaPeriodId, j3, j2, j3, z2, 2);
                                        throw th;
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    z2 = z;
                                    mediaPeriodId2 = resolveMediaPeriodIdForAdsAfterPeriodPositionChange;
                                }
                            } else {
                                z2 = z;
                                mediaPeriodId2 = resolveMediaPeriodIdForAdsAfterPeriodPositionChange;
                                adjustedSeekPositionUs = longValue;
                            }
                            exoPlayerImplInternal.updatePlaybackSpeedSettingsForNewPeriod(exoPlayerImplInternal.playbackInfo.timeline, mediaPeriodId4, exoPlayerImplInternal.playbackInfo.timeline, exoPlayerImplInternal.playbackInfo.periodId, j6, true);
                            mediaPeriodId3 = mediaPeriodId4;
                            j2 = j6;
                            j5 = seekToPeriodPosition;
                            i = 2;
                            j4 = j5;
                            exoPlayerImplInternal = this;
                            exoPlayerImplInternal.playbackInfo = exoPlayerImplInternal.handlePositionDiscontinuity(mediaPeriodId3, j5, j2, j4, z2, i);
                            return;
                        } catch (Throwable th4) {
                            th = th4;
                            mediaPeriodId = mediaPeriodId4;
                            j2 = j6;
                            j3 = seekToPeriodPosition;
                            exoPlayerImplInternal.playbackInfo = exoPlayerImplInternal.handlePositionDiscontinuity(mediaPeriodId, j3, j2, j3, z2, 2);
                            throw th;
                        }
                        seekToPeriodPosition = exoPlayerImplInternal.seekToPeriodPosition(mediaPeriodId2, adjustedSeekPositionUs, exoPlayerImplInternal.playbackInfo.playbackState == 4);
                        z2 |= longValue != seekToPeriodPosition;
                        j6 = j2;
                        mediaPeriodId4 = mediaPeriodId2;
                    }
                    z2 = z;
                    mediaPeriodId3 = resolveMediaPeriodIdForAdsAfterPeriodPositionChange;
                    j5 = longValue;
                    i = 2;
                    j4 = j5;
                    exoPlayerImplInternal = this;
                    exoPlayerImplInternal.playbackInfo = exoPlayerImplInternal.handlePositionDiscontinuity(mediaPeriodId3, j5, j2, j4, z2, i);
                    return;
                }
            }
            if (!exoPlayerImplInternal.playbackInfo.timeline.isEmpty()) {
            }
            z2 = z;
            mediaPeriodId3 = resolveMediaPeriodIdForAdsAfterPeriodPositionChange;
            j5 = longValue;
            i = 2;
            j4 = j5;
            exoPlayerImplInternal = this;
            exoPlayerImplInternal.playbackInfo = exoPlayerImplInternal.handlePositionDiscontinuity(mediaPeriodId3, j5, j2, j4, z2, i);
            return;
        } catch (Throwable th5) {
            th = th5;
            z2 = z;
            mediaPeriodId = resolveMediaPeriodIdForAdsAfterPeriodPositionChange;
        }
        j = 0;
    }

    private long seekToPeriodPosition(MediaSource.MediaPeriodId mediaPeriodId, long j, boolean z) throws ExoPlaybackException {
        return seekToPeriodPosition(mediaPeriodId, j, this.queue.getPlayingPeriod() != this.queue.getReadingPeriod(), z);
    }

    private long seekToPeriodPosition(MediaSource.MediaPeriodId mediaPeriodId, long j, boolean z, boolean z2) throws ExoPlaybackException {
        stopRenderers();
        this.isRebuffering = false;
        if (z2 || this.playbackInfo.playbackState == 3) {
            setState(2);
        }
        MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
        MediaPeriodHolder mediaPeriodHolder = playingPeriod;
        while (mediaPeriodHolder != null && !mediaPeriodId.equals(mediaPeriodHolder.info.id)) {
            mediaPeriodHolder = mediaPeriodHolder.getNext();
        }
        if (z || playingPeriod != mediaPeriodHolder || (mediaPeriodHolder != null && mediaPeriodHolder.toRendererTime(j) < 0)) {
            for (Renderer renderer : this.renderers) {
                disableRenderer(renderer);
            }
            if (mediaPeriodHolder != null) {
                while (this.queue.getPlayingPeriod() != mediaPeriodHolder) {
                    this.queue.advancePlayingPeriod();
                }
                this.queue.removeAfter(mediaPeriodHolder);
                mediaPeriodHolder.setRendererOffset(1000000000000L);
                enableRenderers();
            }
        }
        if (mediaPeriodHolder != null) {
            this.queue.removeAfter(mediaPeriodHolder);
            if (!mediaPeriodHolder.prepared) {
                mediaPeriodHolder.info = mediaPeriodHolder.info.copyWithStartPositionUs(j);
            } else if (mediaPeriodHolder.hasEnabledTracks) {
                long seekToUs = mediaPeriodHolder.mediaPeriod.seekToUs(j);
                mediaPeriodHolder.mediaPeriod.discardBuffer(seekToUs - this.backBufferDurationUs, this.retainBackBufferFromKeyframe);
                j = seekToUs;
            }
            resetRendererPosition(j);
            maybeContinueLoading();
        } else {
            this.queue.clear();
            resetRendererPosition(j);
        }
        handleLoadingMediaPeriodChanged(false);
        this.handler.sendEmptyMessage(2);
        return j;
    }

    private void resetRendererPosition(long j) throws ExoPlaybackException {
        MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
        long rendererTime = playingPeriod == null ? j + 1000000000000L : playingPeriod.toRendererTime(j);
        this.rendererPositionUs = rendererTime;
        this.mediaClock.resetPosition(rendererTime);
        for (Renderer renderer : this.renderers) {
            if (isRendererEnabled(renderer)) {
                renderer.resetPosition(this.rendererPositionUs);
            }
        }
        notifyTrackSelectionDiscontinuity();
    }

    private void setPlaybackParametersInternal(PlaybackParameters playbackParameters) throws ExoPlaybackException {
        setMediaClockPlaybackParameters(playbackParameters);
        handlePlaybackParameters(this.mediaClock.getPlaybackParameters(), true);
    }

    private void setSeekParametersInternal(SeekParameters seekParameters) {
        this.seekParameters = seekParameters;
    }

    private void setForegroundModeInternal(boolean z, AtomicBoolean atomicBoolean) {
        if (this.foregroundMode != z) {
            this.foregroundMode = z;
            if (!z) {
                for (Renderer renderer : this.renderers) {
                    if (!isRendererEnabled(renderer) && this.renderersToReset.remove(renderer)) {
                        renderer.reset();
                    }
                }
            }
        }
        if (atomicBoolean != null) {
            synchronized (this) {
                atomicBoolean.set(true);
                notifyAll();
            }
        }
    }

    private void stopInternal(boolean z, boolean z2) {
        resetInternal(z || !this.foregroundMode, false, true, false);
        this.playbackInfoUpdate.incrementPendingOperationAcks(z2 ? 1 : 0);
        this.loadControl.onStopped();
        setState(1);
    }

    private void releaseInternal() {
        resetInternal(true, false, true, false);
        releaseRenderers();
        this.loadControl.onReleased();
        setState(1);
        HandlerThread handlerThread = this.internalPlaybackThread;
        if (handlerThread != null) {
            handlerThread.quit();
        }
        synchronized (this) {
            this.released = true;
            notifyAll();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:64:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x010d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void resetInternal(boolean z, boolean z2, boolean z3, boolean z4) {
        long j;
        long j2;
        long j3;
        boolean z5;
        Timeline timeline;
        MediaSource.MediaPeriodId mediaPeriodId;
        Timeline timeline2;
        this.handler.removeMessages(2);
        this.pendingRecoverableRendererError = null;
        this.isRebuffering = false;
        this.mediaClock.stop();
        this.rendererPositionUs = 1000000000000L;
        for (Renderer renderer : this.renderers) {
            try {
                disableRenderer(renderer);
            } catch (ExoPlaybackException | RuntimeException e) {
                Log.e(TAG, "Disable failed.", e);
            }
        }
        if (z) {
            for (Renderer renderer2 : this.renderers) {
                if (this.renderersToReset.remove(renderer2)) {
                    try {
                        renderer2.reset();
                    } catch (RuntimeException e2) {
                        Log.e(TAG, "Reset failed.", e2);
                    }
                }
            }
        }
        this.enabledRendererCount = 0;
        MediaSource.MediaPeriodId mediaPeriodId2 = this.playbackInfo.periodId;
        long j4 = this.playbackInfo.positionUs;
        if (this.playbackInfo.periodId.isAd() || isUsingPlaceholderPeriod(this.playbackInfo, this.period)) {
            j = this.playbackInfo.requestedContentPositionUs;
        } else {
            j = this.playbackInfo.positionUs;
        }
        if (z2) {
            this.pendingInitialSeekPosition = null;
            Pair<MediaSource.MediaPeriodId, Long> placeholderFirstMediaPeriodPositionUs = getPlaceholderFirstMediaPeriodPositionUs(this.playbackInfo.timeline);
            MediaSource.MediaPeriodId mediaPeriodId3 = (MediaSource.MediaPeriodId) placeholderFirstMediaPeriodPositionUs.first;
            long longValue = ((Long) placeholderFirstMediaPeriodPositionUs.second).longValue();
            if (mediaPeriodId3.equals(this.playbackInfo.periodId)) {
                mediaPeriodId2 = mediaPeriodId3;
                j2 = longValue;
                j3 = -9223372036854775807L;
            } else {
                z5 = true;
                mediaPeriodId2 = mediaPeriodId3;
                j2 = longValue;
                j3 = -9223372036854775807L;
                this.queue.clear();
                this.shouldContinueLoading = false;
                timeline = this.playbackInfo.timeline;
                if (z3 && (timeline instanceof PlaylistTimeline)) {
                    timeline = ((PlaylistTimeline) this.playbackInfo.timeline).copyWithPlaceholderTimeline(this.mediaSourceList.getShuffleOrder());
                    if (mediaPeriodId2.adGroupIndex != -1) {
                        timeline.getPeriodByUid(mediaPeriodId2.periodUid, this.period);
                        if (timeline.getWindow(this.period.windowIndex, this.window).isLive()) {
                            timeline2 = timeline;
                            mediaPeriodId = new MediaSource.MediaPeriodId(mediaPeriodId2.periodUid, mediaPeriodId2.windowSequenceNumber);
                            this.playbackInfo = new PlaybackInfo(timeline2, mediaPeriodId, j3, j2, this.playbackInfo.playbackState, z4 ? null : this.playbackInfo.playbackError, false, z5 ? TrackGroupArray.EMPTY : this.playbackInfo.trackGroups, z5 ? this.emptyTrackSelectorResult : this.playbackInfo.trackSelectorResult, z5 ? ImmutableList.of() : this.playbackInfo.staticMetadata, mediaPeriodId, this.playbackInfo.playWhenReady, this.playbackInfo.playbackSuppressionReason, this.playbackInfo.playbackParameters, j2, 0L, j2, 0L, false);
                            if (z3) {
                                this.mediaSourceList.release();
                                return;
                            }
                            return;
                        }
                    }
                }
                mediaPeriodId = mediaPeriodId2;
                timeline2 = timeline;
                this.playbackInfo = new PlaybackInfo(timeline2, mediaPeriodId, j3, j2, this.playbackInfo.playbackState, z4 ? null : this.playbackInfo.playbackError, false, z5 ? TrackGroupArray.EMPTY : this.playbackInfo.trackGroups, z5 ? this.emptyTrackSelectorResult : this.playbackInfo.trackSelectorResult, z5 ? ImmutableList.of() : this.playbackInfo.staticMetadata, mediaPeriodId, this.playbackInfo.playWhenReady, this.playbackInfo.playbackSuppressionReason, this.playbackInfo.playbackParameters, j2, 0L, j2, 0L, false);
                if (z3) {
                }
            }
        } else {
            j2 = j4;
            j3 = j;
        }
        z5 = false;
        this.queue.clear();
        this.shouldContinueLoading = false;
        timeline = this.playbackInfo.timeline;
        if (z3) {
            timeline = ((PlaylistTimeline) this.playbackInfo.timeline).copyWithPlaceholderTimeline(this.mediaSourceList.getShuffleOrder());
            if (mediaPeriodId2.adGroupIndex != -1) {
            }
        }
        mediaPeriodId = mediaPeriodId2;
        timeline2 = timeline;
        this.playbackInfo = new PlaybackInfo(timeline2, mediaPeriodId, j3, j2, this.playbackInfo.playbackState, z4 ? null : this.playbackInfo.playbackError, false, z5 ? TrackGroupArray.EMPTY : this.playbackInfo.trackGroups, z5 ? this.emptyTrackSelectorResult : this.playbackInfo.trackSelectorResult, z5 ? ImmutableList.of() : this.playbackInfo.staticMetadata, mediaPeriodId, this.playbackInfo.playWhenReady, this.playbackInfo.playbackSuppressionReason, this.playbackInfo.playbackParameters, j2, 0L, j2, 0L, false);
        if (z3) {
        }
    }

    private Pair<MediaSource.MediaPeriodId, Long> getPlaceholderFirstMediaPeriodPositionUs(Timeline timeline) {
        if (timeline.isEmpty()) {
            return Pair.create(PlaybackInfo.getDummyPeriodForEmptyTimeline(), 0L);
        }
        Pair<Object, Long> periodPositionUs = timeline.getPeriodPositionUs(this.window, this.period, timeline.getFirstWindowIndex(this.shuffleModeEnabled), -9223372036854775807L);
        MediaSource.MediaPeriodId resolveMediaPeriodIdForAdsAfterPeriodPositionChange = this.queue.resolveMediaPeriodIdForAdsAfterPeriodPositionChange(timeline, periodPositionUs.first, 0L);
        long longValue = ((Long) periodPositionUs.second).longValue();
        if (resolveMediaPeriodIdForAdsAfterPeriodPositionChange.isAd()) {
            timeline.getPeriodByUid(resolveMediaPeriodIdForAdsAfterPeriodPositionChange.periodUid, this.period);
            longValue = resolveMediaPeriodIdForAdsAfterPeriodPositionChange.adIndexInAdGroup == this.period.getFirstAdIndexToPlay(resolveMediaPeriodIdForAdsAfterPeriodPositionChange.adGroupIndex) ? this.period.getAdResumePositionUs() : 0L;
        }
        return Pair.create(resolveMediaPeriodIdForAdsAfterPeriodPositionChange, Long.valueOf(longValue));
    }

    private void sendMessageInternal(PlayerMessage playerMessage) throws ExoPlaybackException {
        if (playerMessage.getPositionMs() == -9223372036854775807L) {
            sendMessageToTarget(playerMessage);
            return;
        }
        if (this.playbackInfo.timeline.isEmpty()) {
            this.pendingMessages.add(new PendingMessageInfo(playerMessage));
            return;
        }
        PendingMessageInfo pendingMessageInfo = new PendingMessageInfo(playerMessage);
        if (resolvePendingMessagePosition(pendingMessageInfo, this.playbackInfo.timeline, this.playbackInfo.timeline, this.repeatMode, this.shuffleModeEnabled, this.window, this.period)) {
            this.pendingMessages.add(pendingMessageInfo);
            Collections.sort(this.pendingMessages);
        } else {
            playerMessage.markAsProcessed(false);
        }
    }

    private void sendMessageToTarget(PlayerMessage playerMessage) throws ExoPlaybackException {
        if (playerMessage.getLooper() == this.playbackLooper) {
            deliverMessage(playerMessage);
            if (this.playbackInfo.playbackState == 3 || this.playbackInfo.playbackState == 2) {
                this.handler.sendEmptyMessage(2);
                return;
            }
            return;
        }
        this.handler.obtainMessage(15, playerMessage).sendToTarget();
    }

    private void sendMessageToTargetThread(final PlayerMessage playerMessage) {
        Looper looper = playerMessage.getLooper();
        if (!looper.getThread().isAlive()) {
            Log.w("TAG", "Trying to send message on a dead thread.");
            playerMessage.markAsProcessed(false);
        } else {
            this.clock.createHandler(looper, null).post(new Runnable() { // from class: com.google.android.exoplayer2.ExoPlayerImplInternal$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    ExoPlayerImplInternal.this.m7114xacec0129(playerMessage);
                }
            });
        }
    }

    /* renamed from: lambda$sendMessageToTargetThread$1$com-google-android-exoplayer2-ExoPlayerImplInternal, reason: not valid java name */
    /* synthetic */ void m7114xacec0129(PlayerMessage playerMessage) {
        try {
            deliverMessage(playerMessage);
        } catch (ExoPlaybackException e) {
            Log.e(TAG, "Unexpected error delivering message on external thread.", e);
            throw new RuntimeException(e);
        }
    }

    private void deliverMessage(PlayerMessage playerMessage) throws ExoPlaybackException {
        if (playerMessage.isCanceled()) {
            return;
        }
        try {
            playerMessage.getTarget().handleMessage(playerMessage.getType(), playerMessage.getPayload());
        } finally {
            playerMessage.markAsProcessed(true);
        }
    }

    private void resolvePendingMessagePositions(Timeline timeline, Timeline timeline2) {
        if (timeline.isEmpty() && timeline2.isEmpty()) {
            return;
        }
        int size = this.pendingMessages.size() - 1;
        while (size >= 0) {
            Timeline timeline3 = timeline;
            Timeline timeline4 = timeline2;
            if (!resolvePendingMessagePosition(this.pendingMessages.get(size), timeline3, timeline4, this.repeatMode, this.shuffleModeEnabled, this.window, this.period)) {
                this.pendingMessages.get(size).message.markAsProcessed(false);
                this.pendingMessages.remove(size);
            }
            size--;
            timeline = timeline3;
            timeline2 = timeline4;
        }
        Collections.sort(this.pendingMessages);
    }

    /* JADX WARN: Code restructure failed: missing block: B:89:0x007d, code lost:
    
        r3 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void maybeTriggerPendingMessages(long j, long j2) throws ExoPlaybackException {
        PendingMessageInfo pendingMessageInfo;
        if (this.pendingMessages.isEmpty() || this.playbackInfo.periodId.isAd()) {
            return;
        }
        if (this.deliverPendingMessageAtStartPositionRequired) {
            j--;
            this.deliverPendingMessageAtStartPositionRequired = false;
        }
        int indexOfPeriod = this.playbackInfo.timeline.getIndexOfPeriod(this.playbackInfo.periodId.periodUid);
        int min = Math.min(this.nextPendingMessageIndexHint, this.pendingMessages.size());
        PendingMessageInfo pendingMessageInfo2 = min > 0 ? this.pendingMessages.get(min - 1) : null;
        while (pendingMessageInfo2 != null && (pendingMessageInfo2.resolvedPeriodIndex > indexOfPeriod || (pendingMessageInfo2.resolvedPeriodIndex == indexOfPeriod && pendingMessageInfo2.resolvedPeriodTimeUs > j))) {
            int i = min - 1;
            pendingMessageInfo2 = i > 0 ? this.pendingMessages.get(min - 2) : null;
            min = i;
        }
        if (min < this.pendingMessages.size()) {
            pendingMessageInfo = this.pendingMessages.get(min);
            while (pendingMessageInfo != null && pendingMessageInfo.resolvedPeriodUid != null && (pendingMessageInfo.resolvedPeriodIndex < indexOfPeriod || (pendingMessageInfo.resolvedPeriodIndex == indexOfPeriod && pendingMessageInfo.resolvedPeriodTimeUs <= j))) {
                min++;
                if (min < this.pendingMessages.size()) {
                    pendingMessageInfo = this.pendingMessages.get(min);
                }
            }
            while (pendingMessageInfo != null && pendingMessageInfo.resolvedPeriodUid != null && pendingMessageInfo.resolvedPeriodIndex == indexOfPeriod && pendingMessageInfo.resolvedPeriodTimeUs > j && pendingMessageInfo.resolvedPeriodTimeUs <= j2) {
                try {
                    sendMessageToTarget(pendingMessageInfo.message);
                    if (pendingMessageInfo.message.getDeleteAfterDelivery() || pendingMessageInfo.message.isCanceled()) {
                        this.pendingMessages.remove(min);
                    } else {
                        min++;
                    }
                    pendingMessageInfo = min < this.pendingMessages.size() ? this.pendingMessages.get(min) : null;
                } catch (Throwable th) {
                    if (pendingMessageInfo.message.getDeleteAfterDelivery() || pendingMessageInfo.message.isCanceled()) {
                        this.pendingMessages.remove(min);
                    }
                    throw th;
                }
            }
            this.nextPendingMessageIndexHint = min;
            return;
        }
        pendingMessageInfo = null;
    }

    private void ensureStopped(Renderer renderer) {
        if (renderer.getState() == 2) {
            renderer.stop();
        }
    }

    private void disableRenderer(Renderer renderer) throws ExoPlaybackException {
        if (isRendererEnabled(renderer)) {
            this.mediaClock.onRendererDisabled(renderer);
            ensureStopped(renderer);
            renderer.disable();
            this.enabledRendererCount--;
        }
    }

    private void reselectTracksInternalAndSeek() throws ExoPlaybackException {
        reselectTracksInternal();
        seekToCurrentPosition(true);
    }

    private void reselectTracksInternal() throws ExoPlaybackException {
        int i;
        float f = this.mediaClock.getPlaybackParameters().speed;
        MediaPeriodHolder readingPeriod = this.queue.getReadingPeriod();
        boolean z = true;
        for (MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod(); playingPeriod != null && playingPeriod.prepared; playingPeriod = playingPeriod.getNext()) {
            TrackSelectorResult selectTracks = playingPeriod.selectTracks(f, this.playbackInfo.timeline);
            if (selectTracks.isEquivalent(playingPeriod.getTrackSelectorResult())) {
                if (playingPeriod == readingPeriod) {
                    z = false;
                }
            } else {
                if (z) {
                    MediaPeriodHolder playingPeriod2 = this.queue.getPlayingPeriod();
                    boolean removeAfter = this.queue.removeAfter(playingPeriod2);
                    boolean[] zArr = new boolean[this.renderers.length];
                    long applyTrackSelection = playingPeriod2.applyTrackSelection(selectTracks, this.playbackInfo.positionUs, removeAfter, zArr);
                    boolean z2 = (this.playbackInfo.playbackState == 4 || applyTrackSelection == this.playbackInfo.positionUs) ? false : true;
                    i = 4;
                    this.playbackInfo = handlePositionDiscontinuity(this.playbackInfo.periodId, applyTrackSelection, this.playbackInfo.requestedContentPositionUs, this.playbackInfo.discontinuityStartPositionUs, z2, 5);
                    if (z2) {
                        resetRendererPosition(applyTrackSelection);
                    }
                    boolean[] zArr2 = new boolean[this.renderers.length];
                    int i2 = 0;
                    while (true) {
                        Renderer[] rendererArr = this.renderers;
                        if (i2 >= rendererArr.length) {
                            break;
                        }
                        Renderer renderer = rendererArr[i2];
                        zArr2[i2] = isRendererEnabled(renderer);
                        SampleStream sampleStream = playingPeriod2.sampleStreams[i2];
                        if (zArr2[i2]) {
                            if (sampleStream != renderer.getStream()) {
                                disableRenderer(renderer);
                            } else if (zArr[i2]) {
                                renderer.resetPosition(this.rendererPositionUs);
                            }
                        }
                        i2++;
                    }
                    enableRenderers(zArr2);
                } else {
                    i = 4;
                    this.queue.removeAfter(playingPeriod);
                    if (playingPeriod.prepared) {
                        playingPeriod.applyTrackSelection(selectTracks, Math.max(playingPeriod.info.startPositionUs, playingPeriod.toPeriodTime(this.rendererPositionUs)), false);
                    }
                }
                handleLoadingMediaPeriodChanged(true);
                if (this.playbackInfo.playbackState != i) {
                    maybeContinueLoading();
                    updatePlaybackPositions();
                    this.handler.sendEmptyMessage(2);
                    return;
                }
                return;
            }
        }
    }

    private void updateTrackSelectionPlaybackSpeed(float f) {
        for (MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod(); playingPeriod != null; playingPeriod = playingPeriod.getNext()) {
            for (ExoTrackSelection exoTrackSelection : playingPeriod.getTrackSelectorResult().selections) {
                if (exoTrackSelection != null) {
                    exoTrackSelection.onPlaybackSpeed(f);
                }
            }
        }
    }

    private void notifyTrackSelectionDiscontinuity() {
        for (MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod(); playingPeriod != null; playingPeriod = playingPeriod.getNext()) {
            for (ExoTrackSelection exoTrackSelection : playingPeriod.getTrackSelectorResult().selections) {
                if (exoTrackSelection != null) {
                    exoTrackSelection.onDiscontinuity();
                }
            }
        }
    }

    private boolean shouldTransitionToReadyState(boolean z) {
        if (this.enabledRendererCount == 0) {
            return isTimelineReady();
        }
        if (!z) {
            return false;
        }
        if (!this.playbackInfo.isLoading) {
            return true;
        }
        MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
        long targetLiveOffsetUs = shouldUseLivePlaybackSpeedControl(this.playbackInfo.timeline, playingPeriod.info.id) ? this.livePlaybackSpeedControl.getTargetLiveOffsetUs() : -9223372036854775807L;
        MediaPeriodHolder loadingPeriod = this.queue.getLoadingPeriod();
        return (loadingPeriod.isFullyBuffered() && loadingPeriod.info.isFinal) || (loadingPeriod.info.id.isAd() && !loadingPeriod.prepared) || this.loadControl.shouldStartPlayback(this.playbackInfo.timeline, playingPeriod.info.id, getTotalBufferedDurationUs(), this.mediaClock.getPlaybackParameters().speed, this.isRebuffering, targetLiveOffsetUs);
    }

    private boolean isTimelineReady() {
        MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
        long j = playingPeriod.info.durationUs;
        if (playingPeriod.prepared) {
            return j == -9223372036854775807L || this.playbackInfo.positionUs < j || !shouldPlayWhenReady();
        }
        return false;
    }

    private void handleMediaSourceListInfoRefreshed(Timeline timeline, boolean z) throws ExoPlaybackException {
        int i;
        MediaSource.MediaPeriodId mediaPeriodId;
        long j;
        Timeline timeline2;
        long j2;
        boolean z2;
        Timeline timeline3;
        long j3;
        int i2;
        Timeline timeline4;
        PositionUpdateForPlaylistChange resolvePositionForPlaylistChange = resolvePositionForPlaylistChange(timeline, this.playbackInfo, this.pendingInitialSeekPosition, this.queue, this.repeatMode, this.shuffleModeEnabled, this.window, this.period);
        MediaSource.MediaPeriodId mediaPeriodId2 = resolvePositionForPlaylistChange.periodId;
        long j4 = resolvePositionForPlaylistChange.requestedContentPositionUs;
        boolean z3 = resolvePositionForPlaylistChange.forceBufferingState;
        long j5 = resolvePositionForPlaylistChange.periodPositionUs;
        int i3 = 1;
        boolean z4 = (this.playbackInfo.periodId.equals(mediaPeriodId2) && j5 == this.playbackInfo.positionUs) ? false : true;
        Timeline timeline5 = null;
        try {
            if (resolvePositionForPlaylistChange.endPlayback) {
                if (this.playbackInfo.playbackState != 1) {
                    setState(4);
                }
                resetInternal(false, false, false, true);
            }
            try {
                if (z4) {
                    timeline3 = timeline;
                    i3 = -1;
                    i = 4;
                    if (!timeline3.isEmpty()) {
                        for (MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod(); playingPeriod != null; playingPeriod = playingPeriod.getNext()) {
                            if (playingPeriod.info.id.equals(mediaPeriodId2)) {
                                playingPeriod.info = this.queue.getUpdatedMediaPeriodInfo(timeline3, playingPeriod.info);
                                playingPeriod.updateClipping();
                            }
                        }
                        j5 = seekToPeriodPosition(mediaPeriodId2, j5, z3);
                    }
                } else {
                    try {
                        try {
                            i = 4;
                            try {
                                i3 = -1;
                                try {
                                    timeline3 = timeline;
                                    if (!this.queue.updateQueuedPeriods(timeline, this.rendererPositionUs, getMaxRendererReadPositionUs())) {
                                        seekToCurrentPosition(false);
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    timeline5 = timeline;
                                    mediaPeriodId = mediaPeriodId2;
                                    j = j4;
                                    timeline2 = timeline5;
                                    updatePlaybackSpeedSettingsForNewPeriod(timeline2, mediaPeriodId, this.playbackInfo.timeline, this.playbackInfo.periodId, resolvePositionForPlaylistChange.setTargetLiveOffset ? j5 : -9223372036854775807L, false);
                                    if (z4 || j != this.playbackInfo.requestedContentPositionUs) {
                                        Object obj = this.playbackInfo.periodId.periodUid;
                                        Timeline timeline6 = this.playbackInfo.timeline;
                                        if (!z4 || !z || timeline6.isEmpty() || timeline6.getPeriodByUid(obj, this.period).isPlaceholder) {
                                            j2 = j;
                                            z2 = false;
                                        } else {
                                            j2 = j;
                                            z2 = true;
                                        }
                                        this.playbackInfo = handlePositionDiscontinuity(mediaPeriodId, j5, j2, this.playbackInfo.discontinuityStartPositionUs, z2, timeline2.getIndexOfPeriod(obj) == i3 ? i : 3);
                                    }
                                    resetPendingPauseAtEndOfPeriod();
                                    resolvePendingMessagePositions(timeline2, this.playbackInfo.timeline);
                                    this.playbackInfo = this.playbackInfo.copyWithTimeline(timeline2);
                                    if (!timeline2.isEmpty()) {
                                        this.pendingInitialSeekPosition = null;
                                    }
                                    handleLoadingMediaPeriodChanged(false);
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                timeline5 = timeline;
                                i3 = -1;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            timeline5 = timeline;
                            i3 = -1;
                            i = 4;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        timeline5 = timeline;
                        i3 = -1;
                        i = 4;
                    }
                }
                updatePlaybackSpeedSettingsForNewPeriod(timeline3, mediaPeriodId2, this.playbackInfo.timeline, this.playbackInfo.periodId, resolvePositionForPlaylistChange.setTargetLiveOffset ? j5 : -9223372036854775807L, false);
                if (z4 || j4 != this.playbackInfo.requestedContentPositionUs) {
                    Object obj2 = this.playbackInfo.periodId.periodUid;
                    Timeline timeline7 = this.playbackInfo.timeline;
                    boolean z5 = z4 && z && !timeline7.isEmpty() && !timeline7.getPeriodByUid(obj2, this.period).isPlaceholder;
                    long j6 = this.playbackInfo.discontinuityStartPositionUs;
                    if (timeline3.getIndexOfPeriod(obj2) == i3) {
                        j3 = j4;
                        i2 = i;
                    } else {
                        j3 = j4;
                        i2 = 3;
                    }
                    timeline4 = timeline3;
                    this.playbackInfo = handlePositionDiscontinuity(mediaPeriodId2, j5, j3, j6, z5, i2);
                } else {
                    timeline4 = timeline3;
                }
                resetPendingPauseAtEndOfPeriod();
                resolvePendingMessagePositions(timeline4, this.playbackInfo.timeline);
                this.playbackInfo = this.playbackInfo.copyWithTimeline(timeline4);
                if (!timeline4.isEmpty()) {
                    this.pendingInitialSeekPosition = null;
                }
                handleLoadingMediaPeriodChanged(false);
            } catch (Throwable th5) {
                th = th5;
            }
        } catch (Throwable th6) {
            th = th6;
            i3 = -1;
            i = 4;
            mediaPeriodId = mediaPeriodId2;
            j = j4;
            timeline2 = timeline;
        }
    }

    private void updatePlaybackSpeedSettingsForNewPeriod(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId, Timeline timeline2, MediaSource.MediaPeriodId mediaPeriodId2, long j, boolean z) throws ExoPlaybackException {
        if (!shouldUseLivePlaybackSpeedControl(timeline, mediaPeriodId)) {
            PlaybackParameters playbackParameters = mediaPeriodId.isAd() ? PlaybackParameters.DEFAULT : this.playbackInfo.playbackParameters;
            if (this.mediaClock.getPlaybackParameters().equals(playbackParameters)) {
                return;
            }
            setMediaClockPlaybackParameters(playbackParameters);
            handlePlaybackParameters(this.playbackInfo.playbackParameters, playbackParameters.speed, false, false);
            return;
        }
        timeline.getWindow(timeline.getPeriodByUid(mediaPeriodId.periodUid, this.period).windowIndex, this.window);
        this.livePlaybackSpeedControl.setLiveConfiguration((MediaItem.LiveConfiguration) Util.castNonNull(this.window.liveConfiguration));
        if (j != -9223372036854775807L) {
            this.livePlaybackSpeedControl.setTargetLiveOffsetOverrideUs(getLiveOffsetUs(timeline, mediaPeriodId.periodUid, j));
            return;
        }
        if (!Util.areEqual(!timeline2.isEmpty() ? timeline2.getWindow(timeline2.getPeriodByUid(mediaPeriodId2.periodUid, this.period).windowIndex, this.window).uid : null, this.window.uid) || z) {
            this.livePlaybackSpeedControl.setTargetLiveOffsetOverrideUs(-9223372036854775807L);
        }
    }

    private long getMaxRendererReadPositionUs() {
        MediaPeriodHolder readingPeriod = this.queue.getReadingPeriod();
        if (readingPeriod == null) {
            return 0L;
        }
        long rendererOffset = readingPeriod.getRendererOffset();
        if (!readingPeriod.prepared) {
            return rendererOffset;
        }
        int i = 0;
        while (true) {
            Renderer[] rendererArr = this.renderers;
            if (i >= rendererArr.length) {
                return rendererOffset;
            }
            if (isRendererEnabled(rendererArr[i]) && this.renderers[i].getStream() == readingPeriod.sampleStreams[i]) {
                long readingPositionUs = this.renderers[i].getReadingPositionUs();
                if (readingPositionUs == Long.MIN_VALUE) {
                    return Long.MIN_VALUE;
                }
                rendererOffset = Math.max(readingPositionUs, rendererOffset);
            }
            i++;
        }
    }

    private void updatePeriods() throws ExoPlaybackException {
        if (this.playbackInfo.timeline.isEmpty() || !this.mediaSourceList.isPrepared()) {
            return;
        }
        maybeUpdateLoadingPeriod();
        maybeUpdateReadingPeriod();
        maybeUpdateReadingRenderers();
        maybeUpdatePlayingPeriod();
    }

    private void maybeUpdateLoadingPeriod() throws ExoPlaybackException {
        MediaPeriodInfo nextMediaPeriodInfo;
        this.queue.reevaluateBuffer(this.rendererPositionUs);
        if (this.queue.shouldLoadNextMediaPeriod() && (nextMediaPeriodInfo = this.queue.getNextMediaPeriodInfo(this.rendererPositionUs, this.playbackInfo)) != null) {
            MediaPeriodHolder enqueueNextMediaPeriodHolder = this.queue.enqueueNextMediaPeriodHolder(this.rendererCapabilities, this.trackSelector, this.loadControl.getAllocator(), this.mediaSourceList, nextMediaPeriodInfo, this.emptyTrackSelectorResult);
            enqueueNextMediaPeriodHolder.mediaPeriod.prepare(this, nextMediaPeriodInfo.startPositionUs);
            if (this.queue.getPlayingPeriod() == enqueueNextMediaPeriodHolder) {
                resetRendererPosition(nextMediaPeriodInfo.startPositionUs);
            }
            handleLoadingMediaPeriodChanged(false);
        }
        if (this.shouldContinueLoading) {
            this.shouldContinueLoading = isLoadingPossible();
            updateIsLoading();
        } else {
            maybeContinueLoading();
        }
    }

    private void maybeUpdateReadingPeriod() throws ExoPlaybackException {
        MediaPeriodHolder readingPeriod = this.queue.getReadingPeriod();
        if (readingPeriod == null) {
            return;
        }
        int i = 0;
        if (readingPeriod.getNext() == null || this.pendingPauseAtEndOfPeriod) {
            if (!readingPeriod.info.isFinal && !this.pendingPauseAtEndOfPeriod) {
                return;
            }
            while (true) {
                Renderer[] rendererArr = this.renderers;
                if (i >= rendererArr.length) {
                    return;
                }
                Renderer renderer = rendererArr[i];
                SampleStream sampleStream = readingPeriod.sampleStreams[i];
                if (sampleStream != null && renderer.getStream() == sampleStream && renderer.hasReadStreamToEnd()) {
                    setCurrentStreamFinal(renderer, (readingPeriod.info.durationUs == -9223372036854775807L || readingPeriod.info.durationUs == Long.MIN_VALUE) ? -9223372036854775807L : readingPeriod.getRendererOffset() + readingPeriod.info.durationUs);
                }
                i++;
            }
        } else if (hasReadingPeriodFinishedReading()) {
            if (readingPeriod.getNext().prepared || this.rendererPositionUs >= readingPeriod.getNext().getStartPositionRendererTime()) {
                TrackSelectorResult trackSelectorResult = readingPeriod.getTrackSelectorResult();
                MediaPeriodHolder advanceReadingPeriod = this.queue.advanceReadingPeriod();
                TrackSelectorResult trackSelectorResult2 = advanceReadingPeriod.getTrackSelectorResult();
                updatePlaybackSpeedSettingsForNewPeriod(this.playbackInfo.timeline, advanceReadingPeriod.info.id, this.playbackInfo.timeline, readingPeriod.info.id, -9223372036854775807L, false);
                if (advanceReadingPeriod.prepared && advanceReadingPeriod.mediaPeriod.readDiscontinuity() != -9223372036854775807L) {
                    setAllRendererStreamsFinal(advanceReadingPeriod.getStartPositionRendererTime());
                    return;
                }
                for (int i2 = 0; i2 < this.renderers.length; i2++) {
                    boolean isRendererEnabled = trackSelectorResult.isRendererEnabled(i2);
                    boolean isRendererEnabled2 = trackSelectorResult2.isRendererEnabled(i2);
                    if (isRendererEnabled && !this.renderers[i2].isCurrentStreamFinal()) {
                        boolean z = this.rendererCapabilities[i2].getTrackType() == -2;
                        RendererConfiguration rendererConfiguration = trackSelectorResult.rendererConfigurations[i2];
                        RendererConfiguration rendererConfiguration2 = trackSelectorResult2.rendererConfigurations[i2];
                        if (!isRendererEnabled2 || !rendererConfiguration2.equals(rendererConfiguration) || z) {
                            setCurrentStreamFinal(this.renderers[i2], advanceReadingPeriod.getStartPositionRendererTime());
                        }
                    }
                }
            }
        }
    }

    private void maybeUpdateReadingRenderers() throws ExoPlaybackException {
        MediaPeriodHolder readingPeriod = this.queue.getReadingPeriod();
        if (readingPeriod == null || this.queue.getPlayingPeriod() == readingPeriod || readingPeriod.allRenderersInCorrectState || !replaceStreamsOrDisableRendererForTransition()) {
            return;
        }
        enableRenderers();
    }

    private boolean replaceStreamsOrDisableRendererForTransition() throws ExoPlaybackException {
        MediaPeriodHolder readingPeriod = this.queue.getReadingPeriod();
        TrackSelectorResult trackSelectorResult = readingPeriod.getTrackSelectorResult();
        int i = 0;
        boolean z = false;
        while (true) {
            Renderer[] rendererArr = this.renderers;
            if (i >= rendererArr.length) {
                return !z;
            }
            Renderer renderer = rendererArr[i];
            if (isRendererEnabled(renderer)) {
                boolean z2 = renderer.getStream() != readingPeriod.sampleStreams[i];
                if (!trackSelectorResult.isRendererEnabled(i) || z2) {
                    if (!renderer.isCurrentStreamFinal()) {
                        renderer.replaceStream(getFormats(trackSelectorResult.selections[i]), readingPeriod.sampleStreams[i], readingPeriod.getStartPositionRendererTime(), readingPeriod.getRendererOffset());
                    } else if (renderer.isEnded()) {
                        disableRenderer(renderer);
                    } else {
                        z = true;
                    }
                }
            }
            i++;
        }
    }

    private void maybeUpdatePlayingPeriod() throws ExoPlaybackException {
        boolean z = false;
        while (shouldAdvancePlayingPeriod()) {
            if (z) {
                maybeNotifyPlaybackInfoChanged();
            }
            MediaPeriodHolder mediaPeriodHolder = (MediaPeriodHolder) Assertions.checkNotNull(this.queue.advancePlayingPeriod());
            this.playbackInfo = handlePositionDiscontinuity(mediaPeriodHolder.info.id, mediaPeriodHolder.info.startPositionUs, mediaPeriodHolder.info.requestedContentPositionUs, mediaPeriodHolder.info.startPositionUs, !(this.playbackInfo.periodId.periodUid.equals(mediaPeriodHolder.info.id.periodUid) && this.playbackInfo.periodId.adGroupIndex == -1 && mediaPeriodHolder.info.id.adGroupIndex == -1 && this.playbackInfo.periodId.nextAdGroupIndex != mediaPeriodHolder.info.id.nextAdGroupIndex), 0);
            resetPendingPauseAtEndOfPeriod();
            updatePlaybackPositions();
            z = true;
        }
    }

    private void resetPendingPauseAtEndOfPeriod() {
        MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
        this.pendingPauseAtEndOfPeriod = playingPeriod != null && playingPeriod.info.isLastInTimelineWindow && this.pauseAtEndOfWindow;
    }

    private boolean shouldAdvancePlayingPeriod() {
        MediaPeriodHolder playingPeriod;
        MediaPeriodHolder next;
        return shouldPlayWhenReady() && !this.pendingPauseAtEndOfPeriod && (playingPeriod = this.queue.getPlayingPeriod()) != null && (next = playingPeriod.getNext()) != null && this.rendererPositionUs >= next.getStartPositionRendererTime() && next.allRenderersInCorrectState;
    }

    private boolean hasReadingPeriodFinishedReading() {
        MediaPeriodHolder readingPeriod = this.queue.getReadingPeriod();
        if (!readingPeriod.prepared) {
            return false;
        }
        int i = 0;
        while (true) {
            Renderer[] rendererArr = this.renderers;
            if (i >= rendererArr.length) {
                return true;
            }
            Renderer renderer = rendererArr[i];
            SampleStream sampleStream = readingPeriod.sampleStreams[i];
            if (renderer.getStream() != sampleStream || (sampleStream != null && !renderer.hasReadStreamToEnd() && !hasReachedServerSideInsertedAdsTransition(renderer, readingPeriod))) {
                break;
            }
            i++;
        }
        return false;
    }

    private boolean hasReachedServerSideInsertedAdsTransition(Renderer renderer, MediaPeriodHolder mediaPeriodHolder) {
        MediaPeriodHolder next = mediaPeriodHolder.getNext();
        if (mediaPeriodHolder.info.isFollowedByTransitionToSameStream && next.prepared) {
            return (renderer instanceof TextRenderer) || (renderer instanceof MetadataRenderer) || renderer.getReadingPositionUs() >= next.getStartPositionRendererTime();
        }
        return false;
    }

    private void setAllRendererStreamsFinal(long j) {
        for (Renderer renderer : this.renderers) {
            if (renderer.getStream() != null) {
                setCurrentStreamFinal(renderer, j);
            }
        }
    }

    private void setCurrentStreamFinal(Renderer renderer, long j) {
        renderer.setCurrentStreamFinal();
        if (renderer instanceof TextRenderer) {
            ((TextRenderer) renderer).setFinalStreamEndPositionUs(j);
        }
    }

    private void handlePeriodPrepared(MediaPeriod mediaPeriod) throws ExoPlaybackException {
        if (this.queue.isLoading(mediaPeriod)) {
            MediaPeriodHolder loadingPeriod = this.queue.getLoadingPeriod();
            loadingPeriod.handlePrepared(this.mediaClock.getPlaybackParameters().speed, this.playbackInfo.timeline);
            updateLoadControlTrackSelection(loadingPeriod.info.id, loadingPeriod.getTrackGroups(), loadingPeriod.getTrackSelectorResult());
            if (loadingPeriod == this.queue.getPlayingPeriod()) {
                resetRendererPosition(loadingPeriod.info.startPositionUs);
                enableRenderers();
                this.playbackInfo = handlePositionDiscontinuity(this.playbackInfo.periodId, loadingPeriod.info.startPositionUs, this.playbackInfo.requestedContentPositionUs, loadingPeriod.info.startPositionUs, false, 5);
            }
            maybeContinueLoading();
        }
    }

    private void handleContinueLoadingRequested(MediaPeriod mediaPeriod) {
        if (this.queue.isLoading(mediaPeriod)) {
            this.queue.reevaluateBuffer(this.rendererPositionUs);
            maybeContinueLoading();
        }
    }

    private void handlePlaybackParameters(PlaybackParameters playbackParameters, boolean z) throws ExoPlaybackException {
        handlePlaybackParameters(playbackParameters, playbackParameters.speed, true, z);
    }

    private void handlePlaybackParameters(PlaybackParameters playbackParameters, float f, boolean z, boolean z2) throws ExoPlaybackException {
        if (z) {
            if (z2) {
                this.playbackInfoUpdate.incrementPendingOperationAcks(1);
            }
            this.playbackInfo = this.playbackInfo.copyWithPlaybackParameters(playbackParameters);
        }
        updateTrackSelectionPlaybackSpeed(playbackParameters.speed);
        for (Renderer renderer : this.renderers) {
            if (renderer != null) {
                renderer.setPlaybackSpeed(f, playbackParameters.speed);
            }
        }
    }

    private void maybeContinueLoading() {
        boolean shouldContinueLoading = shouldContinueLoading();
        this.shouldContinueLoading = shouldContinueLoading;
        if (shouldContinueLoading) {
            this.queue.getLoadingPeriod().continueLoading(this.rendererPositionUs);
        }
        updateIsLoading();
    }

    private boolean shouldContinueLoading() {
        long periodTime;
        if (!isLoadingPossible()) {
            return false;
        }
        MediaPeriodHolder loadingPeriod = this.queue.getLoadingPeriod();
        long totalBufferedDurationUs = getTotalBufferedDurationUs(loadingPeriod.getNextLoadPositionUs());
        if (loadingPeriod == this.queue.getPlayingPeriod()) {
            periodTime = loadingPeriod.toPeriodTime(this.rendererPositionUs);
        } else {
            periodTime = loadingPeriod.toPeriodTime(this.rendererPositionUs) - loadingPeriod.info.startPositionUs;
        }
        long j = periodTime;
        boolean shouldContinueLoading = this.loadControl.shouldContinueLoading(j, totalBufferedDurationUs, this.mediaClock.getPlaybackParameters().speed);
        if (shouldContinueLoading || totalBufferedDurationUs >= PLAYBACK_BUFFER_EMPTY_THRESHOLD_US) {
            return shouldContinueLoading;
        }
        if (this.backBufferDurationUs <= 0 && !this.retainBackBufferFromKeyframe) {
            return shouldContinueLoading;
        }
        this.queue.getPlayingPeriod().mediaPeriod.discardBuffer(this.playbackInfo.positionUs, false);
        return this.loadControl.shouldContinueLoading(j, totalBufferedDurationUs, this.mediaClock.getPlaybackParameters().speed);
    }

    private boolean isLoadingPossible() {
        MediaPeriodHolder loadingPeriod = this.queue.getLoadingPeriod();
        return (loadingPeriod == null || loadingPeriod.getNextLoadPositionUs() == Long.MIN_VALUE) ? false : true;
    }

    private void updateIsLoading() {
        MediaPeriodHolder loadingPeriod = this.queue.getLoadingPeriod();
        boolean z = this.shouldContinueLoading || (loadingPeriod != null && loadingPeriod.mediaPeriod.isLoading());
        if (z != this.playbackInfo.isLoading) {
            this.playbackInfo = this.playbackInfo.copyWithIsLoading(z);
        }
    }

    private PlaybackInfo handlePositionDiscontinuity(MediaSource.MediaPeriodId mediaPeriodId, long j, long j2, long j3, boolean z, int i) {
        TrackGroupArray trackGroupArray;
        TrackSelectorResult trackSelectorResult;
        List list;
        TrackGroupArray trackGroups;
        TrackSelectorResult trackSelectorResult2;
        this.deliverPendingMessageAtStartPositionRequired = (!this.deliverPendingMessageAtStartPositionRequired && j == this.playbackInfo.positionUs && mediaPeriodId.equals(this.playbackInfo.periodId)) ? false : true;
        resetPendingPauseAtEndOfPeriod();
        TrackGroupArray trackGroupArray2 = this.playbackInfo.trackGroups;
        TrackSelectorResult trackSelectorResult3 = this.playbackInfo.trackSelectorResult;
        List list2 = this.playbackInfo.staticMetadata;
        if (this.mediaSourceList.isPrepared()) {
            MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
            if (playingPeriod == null) {
                trackGroups = TrackGroupArray.EMPTY;
            } else {
                trackGroups = playingPeriod.getTrackGroups();
            }
            if (playingPeriod == null) {
                trackSelectorResult2 = this.emptyTrackSelectorResult;
            } else {
                trackSelectorResult2 = playingPeriod.getTrackSelectorResult();
            }
            List extractMetadataFromTrackSelectionArray = extractMetadataFromTrackSelectionArray(trackSelectorResult2.selections);
            if (playingPeriod != null && playingPeriod.info.requestedContentPositionUs != j2) {
                playingPeriod.info = playingPeriod.info.copyWithRequestedContentPositionUs(j2);
            }
            trackGroupArray = trackGroups;
            trackSelectorResult = trackSelectorResult2;
            list = extractMetadataFromTrackSelectionArray;
        } else {
            if (!mediaPeriodId.equals(this.playbackInfo.periodId)) {
                trackGroupArray2 = TrackGroupArray.EMPTY;
                trackSelectorResult3 = this.emptyTrackSelectorResult;
                list2 = ImmutableList.of();
            }
            trackGroupArray = trackGroupArray2;
            trackSelectorResult = trackSelectorResult3;
            list = list2;
        }
        if (z) {
            this.playbackInfoUpdate.setPositionDiscontinuity(i);
        }
        return this.playbackInfo.copyWithNewPosition(mediaPeriodId, j, j2, j3, getTotalBufferedDurationUs(), trackGroupArray, trackSelectorResult, list);
    }

    private ImmutableList<Metadata> extractMetadataFromTrackSelectionArray(ExoTrackSelection[] exoTrackSelectionArr) {
        ImmutableList.Builder builder = new ImmutableList.Builder();
        boolean z = false;
        for (ExoTrackSelection exoTrackSelection : exoTrackSelectionArr) {
            if (exoTrackSelection != null) {
                Format format = exoTrackSelection.getFormat(0);
                if (format.metadata == null) {
                    builder.add((ImmutableList.Builder) new Metadata(new Metadata.Entry[0]));
                } else {
                    builder.add((ImmutableList.Builder) format.metadata);
                    z = true;
                }
            }
        }
        return z ? builder.build() : ImmutableList.of();
    }

    private void enableRenderers() throws ExoPlaybackException {
        enableRenderers(new boolean[this.renderers.length]);
    }

    private void enableRenderers(boolean[] zArr) throws ExoPlaybackException {
        MediaPeriodHolder readingPeriod = this.queue.getReadingPeriod();
        TrackSelectorResult trackSelectorResult = readingPeriod.getTrackSelectorResult();
        for (int i = 0; i < this.renderers.length; i++) {
            if (!trackSelectorResult.isRendererEnabled(i) && this.renderersToReset.remove(this.renderers[i])) {
                this.renderers[i].reset();
            }
        }
        for (int i2 = 0; i2 < this.renderers.length; i2++) {
            if (trackSelectorResult.isRendererEnabled(i2)) {
                enableRenderer(i2, zArr[i2]);
            }
        }
        readingPeriod.allRenderersInCorrectState = true;
    }

    private void enableRenderer(int i, boolean z) throws ExoPlaybackException {
        Renderer renderer = this.renderers[i];
        if (isRendererEnabled(renderer)) {
            return;
        }
        MediaPeriodHolder readingPeriod = this.queue.getReadingPeriod();
        boolean z2 = readingPeriod == this.queue.getPlayingPeriod();
        TrackSelectorResult trackSelectorResult = readingPeriod.getTrackSelectorResult();
        RendererConfiguration rendererConfiguration = trackSelectorResult.rendererConfigurations[i];
        Format[] formats = getFormats(trackSelectorResult.selections[i]);
        boolean z3 = shouldPlayWhenReady() && this.playbackInfo.playbackState == 3;
        boolean z4 = !z && z3;
        this.enabledRendererCount++;
        this.renderersToReset.add(renderer);
        renderer.enable(rendererConfiguration, formats, readingPeriod.sampleStreams[i], this.rendererPositionUs, z4, z2, readingPeriod.getStartPositionRendererTime(), readingPeriod.getRendererOffset());
        renderer.handleMessage(11, new Renderer.WakeupListener() { // from class: com.google.android.exoplayer2.ExoPlayerImplInternal.1
            @Override // com.google.android.exoplayer2.Renderer.WakeupListener
            public void onSleep() {
                ExoPlayerImplInternal.this.requestForRendererSleep = true;
            }

            @Override // com.google.android.exoplayer2.Renderer.WakeupListener
            public void onWakeup() {
                ExoPlayerImplInternal.this.handler.sendEmptyMessage(2);
            }
        });
        this.mediaClock.onRendererEnabled(renderer);
        if (z3) {
            renderer.start();
        }
    }

    private void releaseRenderers() {
        for (int i = 0; i < this.renderers.length; i++) {
            this.rendererCapabilities[i].clearListener();
            this.renderers[i].release();
        }
    }

    private void handleLoadingMediaPeriodChanged(boolean z) {
        long bufferedPositionUs;
        MediaPeriodHolder loadingPeriod = this.queue.getLoadingPeriod();
        MediaSource.MediaPeriodId mediaPeriodId = loadingPeriod == null ? this.playbackInfo.periodId : loadingPeriod.info.id;
        boolean equals = this.playbackInfo.loadingMediaPeriodId.equals(mediaPeriodId);
        if (!equals) {
            this.playbackInfo = this.playbackInfo.copyWithLoadingMediaPeriodId(mediaPeriodId);
        }
        PlaybackInfo playbackInfo = this.playbackInfo;
        if (loadingPeriod == null) {
            bufferedPositionUs = playbackInfo.positionUs;
        } else {
            bufferedPositionUs = loadingPeriod.getBufferedPositionUs();
        }
        playbackInfo.bufferedPositionUs = bufferedPositionUs;
        this.playbackInfo.totalBufferedDurationUs = getTotalBufferedDurationUs();
        if ((!equals || z) && loadingPeriod != null && loadingPeriod.prepared) {
            updateLoadControlTrackSelection(loadingPeriod.info.id, loadingPeriod.getTrackGroups(), loadingPeriod.getTrackSelectorResult());
        }
    }

    private long getTotalBufferedDurationUs() {
        return getTotalBufferedDurationUs(this.playbackInfo.bufferedPositionUs);
    }

    private long getTotalBufferedDurationUs(long j) {
        MediaPeriodHolder loadingPeriod = this.queue.getLoadingPeriod();
        if (loadingPeriod == null) {
            return 0L;
        }
        return Math.max(0L, j - loadingPeriod.toPeriodTime(this.rendererPositionUs));
    }

    private void updateLoadControlTrackSelection(MediaSource.MediaPeriodId mediaPeriodId, TrackGroupArray trackGroupArray, TrackSelectorResult trackSelectorResult) {
        this.loadControl.onTracksSelected(this.playbackInfo.timeline, mediaPeriodId, this.renderers, trackGroupArray, trackSelectorResult.selections);
    }

    private boolean shouldPlayWhenReady() {
        return this.playbackInfo.playWhenReady && this.playbackInfo.playbackSuppressionReason == 0;
    }

    private static PositionUpdateForPlaylistChange resolvePositionForPlaylistChange(Timeline timeline, PlaybackInfo playbackInfo, SeekPosition seekPosition, MediaPeriodQueue mediaPeriodQueue, int i, boolean z, Timeline.Window window, Timeline.Period period) {
        long j;
        long j2;
        long j3;
        int i2;
        boolean z2;
        boolean z3;
        boolean z4;
        int i3;
        boolean z5;
        Timeline timeline2;
        Timeline.Period period2;
        long j4;
        boolean z6;
        boolean z7;
        boolean z8;
        if (timeline.isEmpty()) {
            return new PositionUpdateForPlaylistChange(PlaybackInfo.getDummyPeriodForEmptyTimeline(), 0L, -9223372036854775807L, false, true, false);
        }
        MediaSource.MediaPeriodId mediaPeriodId = playbackInfo.periodId;
        Object obj = mediaPeriodId.periodUid;
        boolean isUsingPlaceholderPeriod = isUsingPlaceholderPeriod(playbackInfo, period);
        if (playbackInfo.periodId.isAd() || isUsingPlaceholderPeriod) {
            j = playbackInfo.requestedContentPositionUs;
        } else {
            j = playbackInfo.positionUs;
        }
        long j5 = j;
        boolean z9 = false;
        if (seekPosition != null) {
            Pair<Object, Long> resolveSeekPositionUs = resolveSeekPositionUs(timeline, seekPosition, true, i, z, window, period);
            if (resolveSeekPositionUs == null) {
                i2 = timeline.getFirstWindowIndex(z);
                j3 = j5;
                j2 = -9223372036854775807L;
                z6 = false;
                z7 = false;
                z8 = true;
            } else {
                if (seekPosition.windowPositionUs == -9223372036854775807L) {
                    i2 = timeline.getPeriodByUid(resolveSeekPositionUs.first, period).windowIndex;
                    j3 = j5;
                    z6 = false;
                } else {
                    obj = resolveSeekPositionUs.first;
                    j3 = ((Long) resolveSeekPositionUs.second).longValue();
                    i2 = -1;
                    z6 = true;
                }
                j2 = -9223372036854775807L;
                z7 = playbackInfo.playbackState == 4;
                z8 = false;
            }
            z4 = z6;
            z2 = z7;
            z3 = z8;
        } else {
            j2 = -9223372036854775807L;
            if (playbackInfo.timeline.isEmpty()) {
                i2 = timeline.getFirstWindowIndex(z);
            } else if (timeline.getIndexOfPeriod(obj) == -1) {
                Object resolveSubsequentPeriod = resolveSubsequentPeriod(window, period, i, z, obj, playbackInfo.timeline, timeline);
                if (resolveSubsequentPeriod == null) {
                    i3 = timeline.getFirstWindowIndex(z);
                    z5 = true;
                } else {
                    i3 = timeline.getPeriodByUid(resolveSubsequentPeriod, period).windowIndex;
                    z5 = false;
                }
                i2 = i3;
                obj = obj;
                j3 = j5;
                z3 = z5;
                z2 = false;
                z4 = false;
            } else if (j5 == -9223372036854775807L) {
                i2 = timeline.getPeriodByUid(obj, period).windowIndex;
                obj = obj;
            } else if (isUsingPlaceholderPeriod) {
                playbackInfo.timeline.getPeriodByUid(mediaPeriodId.periodUid, period);
                if (playbackInfo.timeline.getWindow(period.windowIndex, window).firstPeriodIndex == playbackInfo.timeline.getIndexOfPeriod(mediaPeriodId.periodUid)) {
                    Pair<Object, Long> periodPositionUs = timeline.getPeriodPositionUs(window, period, timeline.getPeriodByUid(obj, period).windowIndex, period.getPositionInWindowUs() + j5);
                    Object obj2 = periodPositionUs.first;
                    j3 = ((Long) periodPositionUs.second).longValue();
                    obj = obj2;
                } else {
                    obj = obj;
                    j3 = j5;
                }
                i2 = -1;
                z2 = false;
                z3 = false;
                z4 = true;
            } else {
                obj = obj;
                j3 = j5;
                i2 = -1;
                z2 = false;
                z3 = false;
                z4 = false;
            }
            j3 = j5;
            z2 = false;
            z3 = false;
            z4 = false;
        }
        if (i2 != -1) {
            timeline2 = timeline;
            Pair<Object, Long> periodPositionUs2 = timeline2.getPeriodPositionUs(window, period, i2, -9223372036854775807L);
            period2 = period;
            obj = periodPositionUs2.first;
            j3 = ((Long) periodPositionUs2.second).longValue();
            j4 = j2;
        } else {
            timeline2 = timeline;
            period2 = period;
            j4 = j3;
        }
        MediaSource.MediaPeriodId resolveMediaPeriodIdForAdsAfterPeriodPositionChange = mediaPeriodQueue.resolveMediaPeriodIdForAdsAfterPeriodPositionChange(timeline2, obj, j3);
        boolean z10 = resolveMediaPeriodIdForAdsAfterPeriodPositionChange.nextAdGroupIndex == -1 || (mediaPeriodId.nextAdGroupIndex != -1 && resolveMediaPeriodIdForAdsAfterPeriodPositionChange.nextAdGroupIndex >= mediaPeriodId.nextAdGroupIndex);
        if (mediaPeriodId.periodUid.equals(obj) && !mediaPeriodId.isAd() && !resolveMediaPeriodIdForAdsAfterPeriodPositionChange.isAd() && z10) {
            z9 = true;
        }
        MediaSource.MediaPeriodId mediaPeriodId2 = resolveMediaPeriodIdForAdsAfterPeriodPositionChange;
        boolean isIgnorableServerSideAdInsertionPeriodChange = isIgnorableServerSideAdInsertionPeriodChange(isUsingPlaceholderPeriod, mediaPeriodId, j5, mediaPeriodId2, timeline2.getPeriodByUid(obj, period2), j4);
        if (z9 || isIgnorableServerSideAdInsertionPeriodChange) {
            mediaPeriodId2 = mediaPeriodId;
        }
        if (mediaPeriodId2.isAd()) {
            if (mediaPeriodId2.equals(mediaPeriodId)) {
                j3 = playbackInfo.positionUs;
            } else {
                timeline2.getPeriodByUid(mediaPeriodId2.periodUid, period2);
                j3 = mediaPeriodId2.adIndexInAdGroup == period2.getFirstAdIndexToPlay(mediaPeriodId2.adGroupIndex) ? period2.getAdResumePositionUs() : 0L;
            }
        }
        return new PositionUpdateForPlaylistChange(mediaPeriodId2, j3, j4, z2, z3, z4);
    }

    private static boolean isIgnorableServerSideAdInsertionPeriodChange(boolean z, MediaSource.MediaPeriodId mediaPeriodId, long j, MediaSource.MediaPeriodId mediaPeriodId2, Timeline.Period period, long j2) {
        if (!z && j == j2 && mediaPeriodId.periodUid.equals(mediaPeriodId2.periodUid)) {
            if (mediaPeriodId.isAd() && period.isServerSideInsertedAdGroup(mediaPeriodId.adGroupIndex)) {
                return (period.getAdState(mediaPeriodId.adGroupIndex, mediaPeriodId.adIndexInAdGroup) == 4 || period.getAdState(mediaPeriodId.adGroupIndex, mediaPeriodId.adIndexInAdGroup) == 2) ? false : true;
            }
            if (mediaPeriodId2.isAd() && period.isServerSideInsertedAdGroup(mediaPeriodId2.adGroupIndex)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isUsingPlaceholderPeriod(PlaybackInfo playbackInfo, Timeline.Period period) {
        MediaSource.MediaPeriodId mediaPeriodId = playbackInfo.periodId;
        Timeline timeline = playbackInfo.timeline;
        return timeline.isEmpty() || timeline.getPeriodByUid(mediaPeriodId.periodUid, period).isPlaceholder;
    }

    private static boolean resolvePendingMessagePosition(PendingMessageInfo pendingMessageInfo, Timeline timeline, Timeline timeline2, int i, boolean z, Timeline.Window window, Timeline.Period period) {
        if (pendingMessageInfo.resolvedPeriodUid == null) {
            Pair<Object, Long> resolveSeekPositionUs = resolveSeekPositionUs(timeline, new SeekPosition(pendingMessageInfo.message.getTimeline(), pendingMessageInfo.message.getMediaItemIndex(), pendingMessageInfo.message.getPositionMs() == Long.MIN_VALUE ? -9223372036854775807L : Util.msToUs(pendingMessageInfo.message.getPositionMs())), false, i, z, window, period);
            if (resolveSeekPositionUs == null) {
                return false;
            }
            pendingMessageInfo.setResolvedPosition(timeline.getIndexOfPeriod(resolveSeekPositionUs.first), ((Long) resolveSeekPositionUs.second).longValue(), resolveSeekPositionUs.first);
            if (pendingMessageInfo.message.getPositionMs() == Long.MIN_VALUE) {
                resolvePendingMessageEndOfStreamPosition(timeline, pendingMessageInfo, window, period);
            }
            return true;
        }
        int indexOfPeriod = timeline.getIndexOfPeriod(pendingMessageInfo.resolvedPeriodUid);
        if (indexOfPeriod == -1) {
            return false;
        }
        if (pendingMessageInfo.message.getPositionMs() == Long.MIN_VALUE) {
            resolvePendingMessageEndOfStreamPosition(timeline, pendingMessageInfo, window, period);
            return true;
        }
        pendingMessageInfo.resolvedPeriodIndex = indexOfPeriod;
        timeline2.getPeriodByUid(pendingMessageInfo.resolvedPeriodUid, period);
        if (period.isPlaceholder && timeline2.getWindow(period.windowIndex, window).firstPeriodIndex == timeline2.getIndexOfPeriod(pendingMessageInfo.resolvedPeriodUid)) {
            Pair<Object, Long> periodPositionUs = timeline.getPeriodPositionUs(window, period, timeline.getPeriodByUid(pendingMessageInfo.resolvedPeriodUid, period).windowIndex, pendingMessageInfo.resolvedPeriodTimeUs + period.getPositionInWindowUs());
            pendingMessageInfo.setResolvedPosition(timeline.getIndexOfPeriod(periodPositionUs.first), ((Long) periodPositionUs.second).longValue(), periodPositionUs.first);
        }
        return true;
    }

    private static void resolvePendingMessageEndOfStreamPosition(Timeline timeline, PendingMessageInfo pendingMessageInfo, Timeline.Window window, Timeline.Period period) {
        int i = timeline.getWindow(timeline.getPeriodByUid(pendingMessageInfo.resolvedPeriodUid, period).windowIndex, window).lastPeriodIndex;
        pendingMessageInfo.setResolvedPosition(i, period.durationUs != -9223372036854775807L ? period.durationUs - 1 : Long.MAX_VALUE, timeline.getPeriod(i, period, true).uid);
    }

    private static Pair<Object, Long> resolveSeekPositionUs(Timeline timeline, SeekPosition seekPosition, boolean z, int i, boolean z2, Timeline.Window window, Timeline.Period period) {
        Pair<Object, Long> periodPositionUs;
        Timeline timeline2;
        Object resolveSubsequentPeriod;
        Timeline timeline3 = seekPosition.timeline;
        if (timeline.isEmpty()) {
            return null;
        }
        if (timeline3.isEmpty()) {
            timeline3 = timeline;
        }
        try {
            periodPositionUs = timeline3.getPeriodPositionUs(window, period, seekPosition.windowIndex, seekPosition.windowPositionUs);
            timeline2 = timeline3;
        } catch (IndexOutOfBoundsException unused) {
        }
        if (!timeline.equals(timeline2)) {
            if (timeline.getIndexOfPeriod(periodPositionUs.first) == -1) {
                if (z && (resolveSubsequentPeriod = resolveSubsequentPeriod(window, period, i, z2, periodPositionUs.first, timeline2, timeline)) != null) {
                    return timeline.getPeriodPositionUs(window, period, timeline.getPeriodByUid(resolveSubsequentPeriod, period).windowIndex, -9223372036854775807L);
                }
                return null;
            }
            if (timeline2.getPeriodByUid(periodPositionUs.first, period).isPlaceholder && timeline2.getWindow(period.windowIndex, window).firstPeriodIndex == timeline2.getIndexOfPeriod(periodPositionUs.first)) {
                return timeline.getPeriodPositionUs(window, period, timeline.getPeriodByUid(periodPositionUs.first, period).windowIndex, seekPosition.windowPositionUs);
            }
        }
        return periodPositionUs;
    }

    static Object resolveSubsequentPeriod(Timeline.Window window, Timeline.Period period, int i, boolean z, Object obj, Timeline timeline, Timeline timeline2) {
        int indexOfPeriod = timeline.getIndexOfPeriod(obj);
        int periodCount = timeline.getPeriodCount();
        int i2 = 0;
        int i3 = indexOfPeriod;
        int i4 = -1;
        while (i2 < periodCount && i4 == -1) {
            Timeline.Window window2 = window;
            Timeline.Period period2 = period;
            int i5 = i;
            boolean z2 = z;
            Timeline timeline3 = timeline;
            i3 = timeline3.getNextPeriodIndex(i3, period2, window2, i5, z2);
            if (i3 == -1) {
                break;
            }
            i4 = timeline2.getIndexOfPeriod(timeline3.getUidOfPeriod(i3));
            i2++;
            timeline = timeline3;
            period = period2;
            window = window2;
            i = i5;
            z = z2;
        }
        if (i4 == -1) {
            return null;
        }
        return timeline2.getUidOfPeriod(i4);
    }

    private static Format[] getFormats(ExoTrackSelection exoTrackSelection) {
        int length = exoTrackSelection != null ? exoTrackSelection.length() : 0;
        Format[] formatArr = new Format[length];
        for (int i = 0; i < length; i++) {
            formatArr[i] = exoTrackSelection.getFormat(i);
        }
        return formatArr;
    }

    private static boolean isRendererEnabled(Renderer renderer) {
        return renderer.getState() != 0;
    }

    private static final class SeekPosition {
        public final Timeline timeline;
        public final int windowIndex;
        public final long windowPositionUs;

        public SeekPosition(Timeline timeline, int i, long j) {
            this.timeline = timeline;
            this.windowIndex = i;
            this.windowPositionUs = j;
        }
    }

    private static final class PositionUpdateForPlaylistChange {
        public final boolean endPlayback;
        public final boolean forceBufferingState;
        public final MediaSource.MediaPeriodId periodId;
        public final long periodPositionUs;
        public final long requestedContentPositionUs;
        public final boolean setTargetLiveOffset;

        public PositionUpdateForPlaylistChange(MediaSource.MediaPeriodId mediaPeriodId, long j, long j2, boolean z, boolean z2, boolean z3) {
            this.periodId = mediaPeriodId;
            this.periodPositionUs = j;
            this.requestedContentPositionUs = j2;
            this.forceBufferingState = z;
            this.endPlayback = z2;
            this.setTargetLiveOffset = z3;
        }
    }

    private static final class PendingMessageInfo implements Comparable<PendingMessageInfo> {
        public final PlayerMessage message;
        public int resolvedPeriodIndex;
        public long resolvedPeriodTimeUs;
        public Object resolvedPeriodUid;

        public PendingMessageInfo(PlayerMessage playerMessage) {
            this.message = playerMessage;
        }

        public void setResolvedPosition(int i, long j, Object obj) {
            this.resolvedPeriodIndex = i;
            this.resolvedPeriodTimeUs = j;
            this.resolvedPeriodUid = obj;
        }

        @Override // java.lang.Comparable
        public int compareTo(PendingMessageInfo pendingMessageInfo) {
            Object obj = this.resolvedPeriodUid;
            if ((obj == null) != (pendingMessageInfo.resolvedPeriodUid == null)) {
                return obj != null ? -1 : 1;
            }
            if (obj == null) {
                return 0;
            }
            int i = this.resolvedPeriodIndex - pendingMessageInfo.resolvedPeriodIndex;
            return i != 0 ? i : Util.compareLong(this.resolvedPeriodTimeUs, pendingMessageInfo.resolvedPeriodTimeUs);
        }
    }

    private static final class MediaSourceListUpdateMessage {
        private final List<MediaSourceList.MediaSourceHolder> mediaSourceHolders;
        private final long positionUs;
        private final ShuffleOrder shuffleOrder;
        private final int windowIndex;

        private MediaSourceListUpdateMessage(List<MediaSourceList.MediaSourceHolder> list, ShuffleOrder shuffleOrder, int i, long j) {
            this.mediaSourceHolders = list;
            this.shuffleOrder = shuffleOrder;
            this.windowIndex = i;
            this.positionUs = j;
        }
    }

    private static class MoveMediaItemsMessage {
        public final int fromIndex;
        public final int newFromIndex;
        public final ShuffleOrder shuffleOrder;
        public final int toIndex;

        public MoveMediaItemsMessage(int i, int i2, int i3, ShuffleOrder shuffleOrder) {
            this.fromIndex = i;
            this.toIndex = i2;
            this.newFromIndex = i3;
            this.shuffleOrder = shuffleOrder;
        }
    }
}
