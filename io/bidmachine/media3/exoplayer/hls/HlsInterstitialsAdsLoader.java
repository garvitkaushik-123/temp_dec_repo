package io.bidmachine.media3.exoplayer.hls;

import android.content.Context;
import io.bidmachine.media3.common.AdPlaybackState;
import io.bidmachine.media3.common.AdViewProvider;
import io.bidmachine.media3.common.MediaItem;
import io.bidmachine.media3.common.Metadata;
import io.bidmachine.media3.common.Player;
import io.bidmachine.media3.common.Timeline;
import io.bidmachine.media3.common.util.Assertions;
import io.bidmachine.media3.common.util.Consumer;
import io.bidmachine.media3.common.util.Log;
import io.bidmachine.media3.common.util.Util;
import io.bidmachine.media3.datasource.DataSpec;
import io.bidmachine.media3.datasource.DefaultDataSource;
import io.bidmachine.media3.exoplayer.drm.DrmSessionManagerProvider;
import io.bidmachine.media3.exoplayer.hls.HlsInterstitialsAdsLoader;
import io.bidmachine.media3.exoplayer.hls.HlsMediaSource;
import io.bidmachine.media3.exoplayer.hls.playlist.HlsMediaPlaylist;
import io.bidmachine.media3.exoplayer.source.MediaSource;
import io.bidmachine.media3.exoplayer.source.ads.AdsLoader;
import io.bidmachine.media3.exoplayer.source.ads.AdsMediaSource;
import io.bidmachine.media3.exoplayer.upstream.LoadErrorHandlingPolicy;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes7.dex */
public final class HlsInterstitialsAdsLoader implements AdsLoader {
    private static final String TAG = "HlsInterstitiaAdsLoader";
    private boolean isReleased;
    private Player player;
    private final PlayerListener playerListener = new PlayerListener();
    private final Map<Object, AdsLoader.EventListener> activeEventListeners = new HashMap();
    private final Map<Object, AdPlaybackState> activeAdPlaybackStates = new HashMap();
    private final List<Listener> listeners = new ArrayList();
    private final Set<Object> unsupportedAdsIds = new HashSet();

    public interface Listener {
        default void onAdCompleted(MediaItem mediaItem, Object obj, int i, int i2) {
        }

        default void onContentTimelineChanged(MediaItem mediaItem, Object obj, Timeline timeline) {
        }

        default void onMetadata(MediaItem mediaItem, Object obj, int i, int i2, Metadata metadata) {
        }

        default void onPrepareCompleted(MediaItem mediaItem, Object obj, int i, int i2) {
        }

        default void onPrepareError(MediaItem mediaItem, Object obj, int i, int i2, IOException iOException) {
        }

        default void onStart(MediaItem mediaItem, Object obj, AdViewProvider adViewProvider) {
        }

        default void onStop(MediaItem mediaItem, Object obj, AdPlaybackState adPlaybackState) {
        }
    }

    public static final class AdsMediaSourceFactory implements MediaSource.Factory {
        private final AdViewProvider adViewProvider;
        private final HlsInterstitialsAdsLoader adsLoader;
        private final MediaSource.Factory mediaSourceFactory;

        public AdsMediaSourceFactory(HlsInterstitialsAdsLoader hlsInterstitialsAdsLoader, AdViewProvider adViewProvider, Context context) {
            this(hlsInterstitialsAdsLoader, context, null, adViewProvider);
        }

        public AdsMediaSourceFactory(HlsInterstitialsAdsLoader hlsInterstitialsAdsLoader, AdViewProvider adViewProvider, MediaSource.Factory factory) {
            this(hlsInterstitialsAdsLoader, null, factory, adViewProvider);
        }

        private AdsMediaSourceFactory(HlsInterstitialsAdsLoader hlsInterstitialsAdsLoader, Context context, MediaSource.Factory factory, AdViewProvider adViewProvider) {
            boolean z = false;
            Assertions.checkArgument((context == null && factory == null) ? false : true);
            this.adsLoader = hlsInterstitialsAdsLoader;
            factory = factory == null ? new HlsMediaSource.Factory(new DefaultDataSource.Factory((Context) Assertions.checkNotNull(context))) : factory;
            this.mediaSourceFactory = factory;
            this.adViewProvider = adViewProvider;
            int[] supportedTypes = factory.getSupportedTypes();
            int length = supportedTypes.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                if (supportedTypes[i] == 2) {
                    z = true;
                    break;
                }
                i++;
            }
            Assertions.checkState(z);
        }

        @Override // io.bidmachine.media3.exoplayer.source.MediaSource.Factory
        public int[] getSupportedTypes() {
            return new int[]{2};
        }

        @Override // io.bidmachine.media3.exoplayer.source.MediaSource.Factory
        public AdsMediaSourceFactory setDrmSessionManagerProvider(DrmSessionManagerProvider drmSessionManagerProvider) {
            this.mediaSourceFactory.setDrmSessionManagerProvider(drmSessionManagerProvider);
            return this;
        }

        @Override // io.bidmachine.media3.exoplayer.source.MediaSource.Factory
        public AdsMediaSourceFactory setLoadErrorHandlingPolicy(LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
            this.mediaSourceFactory.setLoadErrorHandlingPolicy(loadErrorHandlingPolicy);
            return this;
        }

        @Override // io.bidmachine.media3.exoplayer.source.MediaSource.Factory
        public MediaSource createMediaSource(MediaItem mediaItem) {
            Assertions.checkNotNull(mediaItem.localConfiguration);
            MediaSource createMediaSource = this.mediaSourceFactory.createMediaSource(mediaItem);
            if (mediaItem.localConfiguration.adsConfiguration == null) {
                return createMediaSource;
            }
            if (!(mediaItem.localConfiguration.adsConfiguration.adsId instanceof String)) {
                throw new IllegalArgumentException("Please use an AdsConfiguration with an adsId of type String when using HlsInterstitialsAdsLoader");
            }
            return new AdsMediaSource(createMediaSource, new DataSpec(mediaItem.localConfiguration.adsConfiguration.adTagUri), Assertions.checkNotNull(mediaItem.localConfiguration.adsConfiguration.adsId), this.mediaSourceFactory, this.adsLoader, this.adViewProvider, false);
        }
    }

    public void addListener(Listener listener) {
        this.listeners.add(listener);
    }

    public void removeListener(Listener listener) {
        this.listeners.remove(listener);
    }

    @Override // io.bidmachine.media3.exoplayer.source.ads.AdsLoader
    public void setPlayer(Player player) {
        boolean z = true;
        Assertions.checkState(!this.isReleased);
        if (Objects.equals(this.player, player)) {
            return;
        }
        if (this.player != null && !this.activeEventListeners.isEmpty()) {
            this.player.removeListener(this.playerListener);
        }
        if (player != null && !this.activeEventListeners.isEmpty()) {
            z = false;
        }
        Assertions.checkState(z);
        this.player = player;
    }

    @Override // io.bidmachine.media3.exoplayer.source.ads.AdsLoader
    public void setSupportedContentTypes(int... iArr) {
        for (int i : iArr) {
            if (i == 2) {
                return;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override // io.bidmachine.media3.exoplayer.source.ads.AdsLoader
    public void start(AdsMediaSource adsMediaSource, DataSpec dataSpec, final Object obj, final AdViewProvider adViewProvider, AdsLoader.EventListener eventListener) {
        if (this.isReleased) {
            eventListener.onAdPlaybackState(new AdPlaybackState(obj, new long[0]));
            return;
        }
        if (this.activeAdPlaybackStates.containsKey(obj) || this.unsupportedAdsIds.contains(obj)) {
            throw new IllegalStateException("media item with adsId='" + obj + "' already started. Make sure adsIds are unique within the same playlist.");
        }
        if (this.activeEventListeners.isEmpty()) {
            ((Player) Assertions.checkStateNotNull(this.player, "setPlayer(Player) needs to be called")).addListener(this.playerListener);
        }
        this.activeEventListeners.put(obj, eventListener);
        final MediaItem mediaItem = adsMediaSource.getMediaItem();
        Player player = this.player;
        if (player != null && isSupportedMediaItem(mediaItem, player.getCurrentTimeline())) {
            this.activeAdPlaybackStates.put(obj, AdPlaybackState.NONE);
            notifyListeners(new Consumer() { // from class: io.bidmachine.media3.exoplayer.hls.HlsInterstitialsAdsLoader$$ExternalSyntheticLambda0
                @Override // io.bidmachine.media3.common.util.Consumer
                public final void accept(Object obj2) {
                    ((HlsInterstitialsAdsLoader.Listener) obj2).onStart(MediaItem.this, obj, adViewProvider);
                }
            });
            return;
        }
        putAndNotifyAdPlaybackStateUpdate(obj, new AdPlaybackState(obj, new long[0]));
        if (this.player != null) {
            Log.w(TAG, "Unsupported media item. Playing without ads for adsId=" + obj);
            this.unsupportedAdsIds.add(obj);
        }
    }

    @Override // io.bidmachine.media3.exoplayer.source.ads.AdsLoader
    public void handleContentTimelineChanged(final AdsMediaSource adsMediaSource, final Timeline timeline) {
        final Object adsId = adsMediaSource.getAdsId();
        if (this.isReleased) {
            AdsLoader.EventListener remove = this.activeEventListeners.remove(adsId);
            if (remove != null) {
                this.unsupportedAdsIds.remove(adsId);
                if (((AdPlaybackState) Assertions.checkNotNull(this.activeAdPlaybackStates.remove(adsId))).equals(AdPlaybackState.NONE)) {
                    remove.onAdPlaybackState(new AdPlaybackState(adsId, new long[0]));
                    return;
                }
                return;
            }
            return;
        }
        if (((AdPlaybackState) Assertions.checkNotNull(this.activeAdPlaybackStates.get(adsId))).equals(AdPlaybackState.NONE)) {
            AdPlaybackState adPlaybackState = new AdPlaybackState(adsId, new long[0]);
            Timeline.Window window = timeline.getWindow(0, new Timeline.Window());
            if (window.manifest instanceof HlsManifest) {
                adPlaybackState = mapHlsInterstitialsToAdPlaybackState(((HlsManifest) window.manifest).mediaPlaylist, adPlaybackState);
            }
            putAndNotifyAdPlaybackStateUpdate(adsId, adPlaybackState);
            if (this.unsupportedAdsIds.contains(adsId)) {
                return;
            }
            notifyListeners(new Consumer() { // from class: io.bidmachine.media3.exoplayer.hls.HlsInterstitialsAdsLoader$$ExternalSyntheticLambda2
                @Override // io.bidmachine.media3.common.util.Consumer
                public final void accept(Object obj) {
                    HlsInterstitialsAdsLoader.Listener listener = (HlsInterstitialsAdsLoader.Listener) obj;
                    listener.onContentTimelineChanged(AdsMediaSource.this.getMediaItem(), adsId, timeline);
                }
            });
        }
    }

    @Override // io.bidmachine.media3.exoplayer.source.ads.AdsLoader
    public void handlePrepareComplete(final AdsMediaSource adsMediaSource, final int i, final int i2) {
        final Object adsId = adsMediaSource.getAdsId();
        if (this.isReleased || this.unsupportedAdsIds.contains(adsId)) {
            return;
        }
        notifyListeners(new Consumer() { // from class: io.bidmachine.media3.exoplayer.hls.HlsInterstitialsAdsLoader$$ExternalSyntheticLambda3
            @Override // io.bidmachine.media3.common.util.Consumer
            public final void accept(Object obj) {
                HlsInterstitialsAdsLoader.Listener listener = (HlsInterstitialsAdsLoader.Listener) obj;
                listener.onPrepareCompleted(AdsMediaSource.this.getMediaItem(), adsId, i, i2);
            }
        });
    }

    @Override // io.bidmachine.media3.exoplayer.source.ads.AdsLoader
    public void handlePrepareError(final AdsMediaSource adsMediaSource, final int i, final int i2, final IOException iOException) {
        final Object adsId = adsMediaSource.getAdsId();
        putAndNotifyAdPlaybackStateUpdate(adsId, ((AdPlaybackState) Assertions.checkNotNull(this.activeAdPlaybackStates.get(adsId))).withAdLoadError(i, i2));
        if (this.isReleased || this.unsupportedAdsIds.contains(adsId)) {
            return;
        }
        notifyListeners(new Consumer() { // from class: io.bidmachine.media3.exoplayer.hls.HlsInterstitialsAdsLoader$$ExternalSyntheticLambda1
            @Override // io.bidmachine.media3.common.util.Consumer
            public final void accept(Object obj) {
                HlsInterstitialsAdsLoader.Listener listener = (HlsInterstitialsAdsLoader.Listener) obj;
                listener.onPrepareError(AdsMediaSource.this.getMediaItem(), adsId, i, i2, iOException);
            }
        });
    }

    @Override // io.bidmachine.media3.exoplayer.source.ads.AdsLoader
    public void stop(final AdsMediaSource adsMediaSource, AdsLoader.EventListener eventListener) {
        Object adsId = adsMediaSource.getAdsId();
        this.activeEventListeners.remove(adsId);
        final AdPlaybackState remove = this.activeAdPlaybackStates.remove(adsId);
        if (this.player != null && this.activeEventListeners.isEmpty()) {
            this.player.removeListener(this.playerListener);
            if (this.isReleased) {
                this.player = null;
            }
        }
        if (!this.isReleased && !this.unsupportedAdsIds.contains(adsId)) {
            notifyListeners(new Consumer() { // from class: io.bidmachine.media3.exoplayer.hls.HlsInterstitialsAdsLoader$$ExternalSyntheticLambda4
                @Override // io.bidmachine.media3.common.util.Consumer
                public final void accept(Object obj) {
                    ((HlsInterstitialsAdsLoader.Listener) obj).onStop(r0.getMediaItem(), AdsMediaSource.this.getAdsId(), (AdPlaybackState) Assertions.checkNotNull(remove));
                }
            });
        }
        this.unsupportedAdsIds.remove(adsId);
    }

    @Override // io.bidmachine.media3.exoplayer.source.ads.AdsLoader
    public void release() {
        if (this.activeEventListeners.isEmpty()) {
            this.player = null;
        }
        this.isReleased = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void putAndNotifyAdPlaybackStateUpdate(Object obj, AdPlaybackState adPlaybackState) {
        if (adPlaybackState.equals(this.activeAdPlaybackStates.put(obj, adPlaybackState))) {
            return;
        }
        AdsLoader.EventListener eventListener = this.activeEventListeners.get(obj);
        if (eventListener != null) {
            eventListener.onAdPlaybackState(adPlaybackState);
        } else {
            this.activeAdPlaybackStates.remove(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyListeners(Consumer<Listener> consumer) {
        for (int i = 0; i < this.listeners.size(); i++) {
            consumer.accept(this.listeners.get(i));
        }
    }

    private static boolean isSupportedMediaItem(MediaItem mediaItem, Timeline timeline) {
        return isHlsMediaItem(mediaItem) && !isLiveMediaItem(mediaItem, timeline);
    }

    private static boolean isLiveMediaItem(MediaItem mediaItem, Timeline timeline) {
        int firstWindowIndex = timeline.getFirstWindowIndex(false);
        Timeline.Window window = new Timeline.Window();
        while (firstWindowIndex != -1) {
            timeline.getWindow(firstWindowIndex, window);
            if (window.mediaItem.equals(mediaItem)) {
                return window.isLive();
            }
            firstWindowIndex = timeline.getNextWindowIndex(firstWindowIndex, 0, false);
        }
        return false;
    }

    private static boolean isHlsMediaItem(MediaItem mediaItem) {
        MediaItem.LocalConfiguration localConfiguration = (MediaItem.LocalConfiguration) Assertions.checkNotNull(mediaItem.localConfiguration);
        return Objects.equals(localConfiguration.mimeType, "application/x-mpegURL") || Util.inferContentType(localConfiguration.uri) == 2;
    }

    private static AdPlaybackState mapHlsInterstitialsToAdPlaybackState(HlsMediaPlaylist hlsMediaPlaylist, AdPlaybackState adPlaybackState) {
        long j;
        long[] jArr;
        long j2;
        AdPlaybackState adPlaybackState2 = adPlaybackState;
        for (int i = 0; i < hlsMediaPlaylist.interstitials.size(); i++) {
            HlsMediaPlaylist.Interstitial interstitial = hlsMediaPlaylist.interstitials.get(i);
            if (interstitial.assetUri == null) {
                Log.w(TAG, "Ignoring interstitials with X-ASSET-LIST. Not yet supported.");
            } else {
                if (interstitial.cue.contains(HlsMediaPlaylist.Interstitial.CUE_TRIGGER_PRE)) {
                    j = 0;
                } else {
                    j = interstitial.cue.contains("POST") ? Long.MIN_VALUE : interstitial.startDateUnixUs - hlsMediaPlaylist.startTimeUs;
                }
                int adGroupIndexForPositionUs = adPlaybackState2.getAdGroupIndexForPositionUs(j, hlsMediaPlaylist.durationUs);
                if (adGroupIndexForPositionUs == -1) {
                    adPlaybackState2 = adPlaybackState2.withNewAdGroup(0, j);
                    adGroupIndexForPositionUs = 0;
                } else if (adPlaybackState2.getAdGroup(adGroupIndexForPositionUs).timeUs != j) {
                    adGroupIndexForPositionUs++;
                    adPlaybackState2 = adPlaybackState2.withNewAdGroup(adGroupIndexForPositionUs, j);
                }
                int max = Math.max(adPlaybackState2.getAdGroup(adGroupIndexForPositionUs).count, 0);
                long interstitialDurationUs = getInterstitialDurationUs(interstitial, -9223372036854775807L);
                if (max == 0) {
                    jArr = new long[1];
                } else {
                    long[] jArr2 = adPlaybackState2.getAdGroup(adGroupIndexForPositionUs).durationsUs;
                    long[] jArr3 = new long[jArr2.length + 1];
                    System.arraycopy(jArr2, 0, jArr3, 0, jArr2.length);
                    jArr = jArr3;
                }
                jArr[jArr.length - 1] = interstitialDurationUs;
                if (interstitial.resumeOffsetUs != -9223372036854775807L) {
                    j2 = interstitial.resumeOffsetUs;
                } else {
                    j2 = interstitialDurationUs != -9223372036854775807L ? interstitialDurationUs : 0L;
                }
                adPlaybackState2 = adPlaybackState2.withAdCount(adGroupIndexForPositionUs, max + 1).withAdDurationsUs(adGroupIndexForPositionUs, jArr).withContentResumeOffsetUs(adGroupIndexForPositionUs, adPlaybackState2.getAdGroup(adGroupIndexForPositionUs).contentResumeOffsetUs + j2).withAvailableAdMediaItem(adGroupIndexForPositionUs, max, MediaItem.fromUri(interstitial.assetUri));
            }
        }
        return adPlaybackState2;
    }

    private static long getInterstitialDurationUs(HlsMediaPlaylist.Interstitial interstitial, long j) {
        if (interstitial.playoutLimitUs != -9223372036854775807L) {
            return interstitial.playoutLimitUs;
        }
        if (interstitial.durationUs != -9223372036854775807L) {
            return interstitial.durationUs;
        }
        if (interstitial.endDateUnixUs != -9223372036854775807L) {
            return interstitial.endDateUnixUs - interstitial.startDateUnixUs;
        }
        return interstitial.plannedDurationUs != -9223372036854775807L ? interstitial.plannedDurationUs : j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    class PlayerListener implements Player.Listener {
        private final Timeline.Period period;

        private PlayerListener() {
            this.period = new Timeline.Period();
        }

        @Override // io.bidmachine.media3.common.Player.Listener
        public void onMetadata(final Metadata metadata) {
            Player player = HlsInterstitialsAdsLoader.this.player;
            if (player == null || !player.isPlayingAd()) {
                return;
            }
            player.getCurrentTimeline().getPeriod(player.getCurrentPeriodIndex(), this.period);
            final Object obj = this.period.adPlaybackState.adsId;
            if (obj == null || !HlsInterstitialsAdsLoader.this.activeAdPlaybackStates.containsKey(obj)) {
                return;
            }
            final MediaItem mediaItem = (MediaItem) Assertions.checkNotNull(player.getCurrentMediaItem());
            final int currentAdGroupIndex = player.getCurrentAdGroupIndex();
            final int currentAdIndexInAdGroup = player.getCurrentAdIndexInAdGroup();
            HlsInterstitialsAdsLoader.this.notifyListeners(new Consumer() { // from class: io.bidmachine.media3.exoplayer.hls.HlsInterstitialsAdsLoader$PlayerListener$$ExternalSyntheticLambda1
                @Override // io.bidmachine.media3.common.util.Consumer
                public final void accept(Object obj2) {
                    ((HlsInterstitialsAdsLoader.Listener) obj2).onMetadata(MediaItem.this, obj, currentAdGroupIndex, currentAdIndexInAdGroup, metadata);
                }
            });
        }

        @Override // io.bidmachine.media3.common.Player.Listener
        public void onPositionDiscontinuity(Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i) {
            if (i != 0 || HlsInterstitialsAdsLoader.this.player == null || positionInfo.mediaItem == null || positionInfo.adGroupIndex == -1) {
                return;
            }
            HlsInterstitialsAdsLoader.this.player.getCurrentTimeline().getPeriod(positionInfo.periodIndex, this.period);
            Object obj = this.period.adPlaybackState.adsId;
            if (obj == null || !HlsInterstitialsAdsLoader.this.activeAdPlaybackStates.containsKey(obj)) {
                return;
            }
            markAdAsPlayedAndNotifyListeners(positionInfo.mediaItem, obj, positionInfo.adGroupIndex, positionInfo.adIndexInAdGroup);
        }

        @Override // io.bidmachine.media3.common.Player.Listener
        public void onPlaybackStateChanged(int i) {
            Player player = HlsInterstitialsAdsLoader.this.player;
            if (i == 4 && player != null && player.isPlayingAd()) {
                player.getCurrentTimeline().getPeriod(player.getCurrentPeriodIndex(), this.period);
                Object obj = this.period.adPlaybackState.adsId;
                if (obj == null || !HlsInterstitialsAdsLoader.this.activeAdPlaybackStates.containsKey(obj)) {
                    return;
                }
                markAdAsPlayedAndNotifyListeners((MediaItem) Assertions.checkNotNull(player.getCurrentMediaItem()), obj, player.getCurrentAdGroupIndex(), player.getCurrentAdIndexInAdGroup());
            }
        }

        private void markAdAsPlayedAndNotifyListeners(final MediaItem mediaItem, final Object obj, final int i, final int i2) {
            AdPlaybackState adPlaybackState = (AdPlaybackState) HlsInterstitialsAdsLoader.this.activeAdPlaybackStates.get(obj);
            if (adPlaybackState != null) {
                HlsInterstitialsAdsLoader.this.putAndNotifyAdPlaybackStateUpdate(obj, adPlaybackState.withPlayedAd(i, i2));
                HlsInterstitialsAdsLoader.this.notifyListeners(new Consumer() { // from class: io.bidmachine.media3.exoplayer.hls.HlsInterstitialsAdsLoader$PlayerListener$$ExternalSyntheticLambda0
                    @Override // io.bidmachine.media3.common.util.Consumer
                    public final void accept(Object obj2) {
                        ((HlsInterstitialsAdsLoader.Listener) obj2).onAdCompleted(MediaItem.this, obj, i, i2);
                    }
                });
            }
        }
    }
}
