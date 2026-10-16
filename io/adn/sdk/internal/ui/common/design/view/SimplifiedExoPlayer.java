package io.adn.sdk.internal.ui.common.design.view;

import android.content.Context;
import android.net.Uri;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.upstream.DefaultDataSource;
import com.ironsource.C3040d4;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import io.adn.sdk.internal.domain.model.ad.PlaybackProgress;
import io.adn.sdk.internal.domain.model.ui.VideoState;
import java.io.File;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* compiled from: SimplifiedExoPlayer.kt */
@Metadata(d1 = {"\u0000g\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\f*\u0001\u001e\b\u0001\u0018\u00002\u00020\u0001By\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n0\f\u0012\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\f\u0012\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\n0\f\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\b\u0010 \u001a\u00020\nH\u0002J\b\u0010!\u001a\u0004\u0018\u00010\u0017J\u0006\u0010\"\u001a\u00020#J\u0006\u0010$\u001a\u00020\nJ\u0006\u0010%\u001a\u00020\nJ\u0006\u0010&\u001a\u00020\nJ\u000e\u0010'\u001a\u00020\n2\u0006\u0010(\u001a\u00020\u0007J\u000e\u0010)\u001a\u00020\n2\u0006\u0010*\u001a\u00020#J\b\u0010+\u001a\u00020\nH\u0002J\b\u0010,\u001a\u00020\nH\u0002J\b\u0010-\u001a\u00020\nH\u0002J\b\u0010.\u001a\u00020\nH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\n0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001cR\u0010\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001f¨\u0006/"}, d2 = {"Lio/adn/sdk/internal/ui/common/design/view/SimplifiedExoPlayer;", "", "context", "Landroid/content/Context;", C3040d4.h.b, "Ljava/io/File;", "loopPlayback", "", "onFirstFrameRendered", "Lkotlin/Function0;", "", "onPlayerStateChanged", "Lkotlin/Function1;", "Lio/adn/sdk/internal/domain/model/ui/VideoState;", "onProgressChanged", "Lio/adn/sdk/internal/domain/model/ad/PlaybackProgress;", "onError", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Landroid/content/Context;Ljava/io/File;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlinx/coroutines/CoroutineScope;)V", "exoPlayer", "Lcom/google/android/exoplayer2/ExoPlayer;", "playbackProgressJob", "Lkotlinx/coroutines/Job;", "playerState", "", "Ljava/lang/Integer;", "exoPlayerListener", "io/adn/sdk/internal/ui/common/design/view/SimplifiedExoPlayer$exoPlayerListener$1", "Lio/adn/sdk/internal/ui/common/design/view/SimplifiedExoPlayer$exoPlayerListener$1;", "initializePlayer", "player", "currentPosition", "", "play", CampaignEx.JSON_NATIVE_VIDEO_PAUSE, "releasePlayer", "setMute", "isMute", "seekTo", "seekToMillis", "startProgressTracking", "trackPlayerFinish", "trackPlayerProgress", "stopProgressTracking", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class SimplifiedExoPlayer {
    public static final int $stable = 8;
    private final Context context;
    private ExoPlayer exoPlayer;
    private final SimplifiedExoPlayer$exoPlayerListener$1 exoPlayerListener;
    private final File file;
    private final boolean loopPlayback;
    private final Function1<String, Unit> onError;
    private final Function0<Unit> onFirstFrameRendered;
    private final Function1<VideoState, Unit> onPlayerStateChanged;
    private final Function1<PlaybackProgress, Unit> onProgressChanged;
    private Job playbackProgressJob;
    private Integer playerState;
    private final CoroutineScope scope;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [io.adn.sdk.internal.ui.common.design.view.SimplifiedExoPlayer$exoPlayerListener$1] */
    public SimplifiedExoPlayer(Context context, File file, boolean z, Function0<Unit> onFirstFrameRendered, Function1<? super VideoState, Unit> onPlayerStateChanged, Function1<? super PlaybackProgress, Unit> function1, Function1<? super String, Unit> onError, CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(onFirstFrameRendered, "onFirstFrameRendered");
        Intrinsics.checkNotNullParameter(onPlayerStateChanged, "onPlayerStateChanged");
        Intrinsics.checkNotNullParameter(onError, "onError");
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.context = context;
        this.file = file;
        this.loopPlayback = z;
        this.onFirstFrameRendered = onFirstFrameRendered;
        this.onPlayerStateChanged = onPlayerStateChanged;
        this.onProgressChanged = function1;
        this.onError = onError;
        this.scope = scope;
        this.exoPlayerListener = new Player.Listener() { // from class: io.adn.sdk.internal.ui.common.design.view.SimplifiedExoPlayer$exoPlayerListener$1
            private boolean isFirstFrameEventTriggered;

            @Override // com.google.android.exoplayer2.Player.Listener
            public void onPlaybackStateChanged(int playbackState) {
                SimplifiedExoPlayer.this.playerState = Integer.valueOf(playbackState);
                if (playbackState == 4) {
                    SimplifiedExoPlayer.this.trackPlayerFinish();
                }
            }

            @Override // com.google.android.exoplayer2.Player.Listener
            public void onRenderedFirstFrame() {
                Function0 function0;
                if (this.isFirstFrameEventTriggered) {
                    return;
                }
                this.isFirstFrameEventTriggered = true;
                function0 = SimplifiedExoPlayer.this.onFirstFrameRendered;
                function0.invoke();
            }

            @Override // com.google.android.exoplayer2.Player.Listener
            public void onIsPlayingChanged(boolean isPlaying) {
                Function1 function12;
                Integer num;
                Object obj;
                function12 = SimplifiedExoPlayer.this.onPlayerStateChanged;
                if (!isPlaying) {
                    num = SimplifiedExoPlayer.this.playerState;
                    obj = (num != null && num.intValue() == 4) ? (VideoState) VideoState.Finished.INSTANCE : (VideoState) new VideoState.Paused(SimplifiedExoPlayer.this.currentPosition());
                } else {
                    obj = (VideoState) VideoState.Playing.INSTANCE;
                }
                function12.invoke(obj);
                if (isPlaying) {
                    SimplifiedExoPlayer.this.startProgressTracking();
                } else {
                    SimplifiedExoPlayer.this.stopProgressTracking();
                }
            }

            @Override // com.google.android.exoplayer2.Player.Listener
            public void onPlayerError(PlaybackException error) {
                Function1 function12;
                Intrinsics.checkNotNullParameter(error, "error");
                function12 = SimplifiedExoPlayer.this.onError;
                function12.invoke("VideoError: " + error.getErrorCodeName());
            }
        };
        initializePlayer();
    }

    public /* synthetic */ SimplifiedExoPlayer(Context context, File file, boolean z, Function0 function0, Function1 function1, Function1 function12, Function1 function13, CoroutineScope coroutineScope, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, file, (i & 4) != 0 ? false : z, function0, function1, (i & 32) != 0 ? null : function12, function13, (i & 128) != 0 ? CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()) : coroutineScope);
    }

    private final void initializePlayer() {
        AudioAttributes build = new AudioAttributes.Builder().setUsage(1).setContentType(2).build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        ExoPlayer build2 = new ExoPlayer.Builder(this.context).build();
        ProgressiveMediaSource createMediaSource = new ProgressiveMediaSource.Factory(new DefaultDataSource.Factory(this.context)).createMediaSource(MediaItem.fromUri(Uri.fromFile(this.file)));
        Intrinsics.checkNotNullExpressionValue(createMediaSource, "createMediaSource(...)");
        if (this.loopPlayback) {
            build2.setRepeatMode(1);
        } else {
            build2.setRepeatMode(0);
            build2.setPauseAtEndOfMediaItems(true);
        }
        build2.setAudioAttributes(build, false);
        build2.addListener(this.exoPlayerListener);
        build2.setMediaSource(createMediaSource);
        build2.prepare();
        build2.seekTo(25L);
        this.exoPlayer = build2;
    }

    /* renamed from: player, reason: from getter */
    public final ExoPlayer getExoPlayer() {
        return this.exoPlayer;
    }

    public final long currentPosition() {
        ExoPlayer exoPlayer = this.exoPlayer;
        if (exoPlayer != null) {
            return exoPlayer.getCurrentPosition();
        }
        return 0L;
    }

    public final void play() {
        ExoPlayer exoPlayer = this.exoPlayer;
        if (exoPlayer != null) {
            if (exoPlayer.getPlayWhenReady()) {
                exoPlayer = null;
            }
            if (exoPlayer != null) {
                exoPlayer.setPlayWhenReady(true);
            }
        }
    }

    public final void pause() {
        ExoPlayer exoPlayer = this.exoPlayer;
        if (exoPlayer != null) {
            if (!exoPlayer.isPlaying()) {
                exoPlayer = null;
            }
            if (exoPlayer != null) {
                exoPlayer.pause();
            }
        }
    }

    public final void releasePlayer() {
        try {
            Result.Companion companion = Result.INSTANCE;
            SimplifiedExoPlayer simplifiedExoPlayer = this;
            pause();
            stopProgressTracking();
            ExoPlayer exoPlayer = this.exoPlayer;
            if (exoPlayer != null) {
                exoPlayer.removeListener(this.exoPlayerListener);
            }
            ExoPlayer exoPlayer2 = this.exoPlayer;
            if (exoPlayer2 != null) {
                exoPlayer2.release();
            }
            this.exoPlayer = null;
            Result.m10241constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
    }

    public final void setMute(boolean isMute) {
        ExoPlayer exoPlayer = this.exoPlayer;
        if (exoPlayer != null) {
            exoPlayer.setVolume(isMute ? 0.0f : 1.0f);
        }
    }

    public final void seekTo(long seekToMillis) {
        ExoPlayer exoPlayer = this.exoPlayer;
        if (exoPlayer != null) {
            exoPlayer.seekTo(seekToMillis);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startProgressTracking() {
        Job launch$default;
        Job job = this.playbackProgressJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        if (this.onProgressChanged != null) {
            launch$default = BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new SimplifiedExoPlayer$startProgressTracking$1(this, null), 3, null);
            this.playbackProgressJob = launch$default;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void trackPlayerFinish() {
        ExoPlayer exoPlayer = this.exoPlayer;
        if (exoPlayer != null) {
            long duration = exoPlayer.getDuration();
            Function1<PlaybackProgress, Unit> function1 = this.onProgressChanged;
            if (function1 != null) {
                function1.invoke(new PlaybackProgress(duration, duration));
            }
            this.onPlayerStateChanged.invoke(VideoState.Finished.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void trackPlayerProgress() {
        Function1<PlaybackProgress, Unit> function1;
        ExoPlayer exoPlayer = this.exoPlayer;
        if (exoPlayer == null || (function1 = this.onProgressChanged) == null) {
            return;
        }
        function1.invoke(new PlaybackProgress(exoPlayer.getCurrentPosition(), exoPlayer.getDuration()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void stopProgressTracking() {
        Job job = this.playbackProgressJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.playbackProgressJob = null;
    }
}
