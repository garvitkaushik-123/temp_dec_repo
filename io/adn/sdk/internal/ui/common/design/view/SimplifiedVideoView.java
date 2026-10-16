package io.adn.sdk.internal.ui.common.design.view;

import android.content.Context;
import android.media.MediaPlayer;
import android.widget.VideoView;
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
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* compiled from: SimplifiedVideoView.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000e\b\u0001\u0018\u00002\u00020\u0001B\u0083\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000b0\r\u0012\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r\u0012\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000b0\r\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u001e\u001a\u00020\u000bH\u0002J\u0006\u0010\u001f\u001a\u00020 J\u0006\u0010!\u001a\u00020 J\u0006\u0010\"\u001a\u00020\u000bJ\b\u0010#\u001a\u00020\u000bH\u0016J\u000e\u0010$\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\u0007J\u0010\u0010&\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020\u001dH\u0016J\u0006\u0010(\u001a\u00020\u000bJ\b\u0010)\u001a\u00020\u000bH\u0002J\u000e\u0010*\u001a\u00020\u000bH\u0082@¢\u0006\u0002\u0010+J\b\u0010,\u001a\u00020\u000bH\u0002J\b\u0010-\u001a\u00020\u000bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000b0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u000b\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000b0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lio/adn/sdk/internal/ui/common/design/view/SimplifiedVideoView;", "Landroid/widget/VideoView;", "context", "Landroid/content/Context;", C3040d4.h.b, "Ljava/io/File;", "loopPlayback", "", "enableZoomMode", "onFirstFrameRendered", "Lkotlin/Function0;", "", "onPlayerStateChanged", "Lkotlin/Function1;", "Lio/adn/sdk/internal/domain/model/ui/VideoState;", "onProgressChanged", "Lio/adn/sdk/internal/domain/model/ad/PlaybackProgress;", "onError", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Landroid/content/Context;Ljava/io/File;ZZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlinx/coroutines/CoroutineScope;)V", "player", "Landroid/media/MediaPlayer;", "playbackProgressJob", "Lkotlinx/coroutines/Job;", "savedIsMute", "savedSeekPosition", "", "initializePlayer", "currentPosition", "", "duration", "play", CampaignEx.JSON_NATIVE_VIDEO_PAUSE, "setMute", "isMute", "seekTo", C3040d4.h.L, "releasePlayer", "startProgressTracking", "trackPlayerProgress", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "trackPlayerFinish", "stopProgressTracking", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class SimplifiedVideoView extends VideoView {
    public static final int $stable = 8;
    private final boolean enableZoomMode;
    private final File file;
    private final boolean loopPlayback;
    private final Function1<String, Unit> onError;
    private final Function0<Unit> onFirstFrameRendered;
    private final Function1<VideoState, Unit> onPlayerStateChanged;
    private final Function1<PlaybackProgress, Unit> onProgressChanged;
    private Job playbackProgressJob;
    private MediaPlayer player;
    private boolean savedIsMute;
    private int savedSeekPosition;
    private final CoroutineScope scope;

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initializePlayer$lambda$5$lambda$4$lambda$3$lambda$1(MediaPlayer mediaPlayer, int i, int i2) {
        return true;
    }

    public /* synthetic */ SimplifiedVideoView(Context context, File file, boolean z, boolean z2, Function0 function0, Function1 function1, Function1 function12, Function1 function13, CoroutineScope coroutineScope, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, file, (i & 4) != 0 ? false : z, (i & 8) != 0 ? false : z2, function0, function1, (i & 64) != 0 ? null : function12, function13, (i & 256) != 0 ? CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()) : coroutineScope);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SimplifiedVideoView(Context context, File file, boolean z, boolean z2, Function0<Unit> onFirstFrameRendered, Function1<? super VideoState, Unit> onPlayerStateChanged, Function1<? super PlaybackProgress, Unit> function1, Function1<? super String, Unit> onError, CoroutineScope scope) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(onFirstFrameRendered, "onFirstFrameRendered");
        Intrinsics.checkNotNullParameter(onPlayerStateChanged, "onPlayerStateChanged");
        Intrinsics.checkNotNullParameter(onError, "onError");
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.file = file;
        this.loopPlayback = z;
        this.enableZoomMode = z2;
        this.onFirstFrameRendered = onFirstFrameRendered;
        this.onPlayerStateChanged = onPlayerStateChanged;
        this.onProgressChanged = function1;
        this.onError = onError;
        this.scope = scope;
        this.savedIsMute = true;
        initializePlayer();
    }

    private final void initializePlayer() {
        Object m10241constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            SimplifiedVideoView simplifiedVideoView = this;
            setAudioFocusRequest(0);
            setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: io.adn.sdk.internal.ui.common.design.view.SimplifiedVideoView$$ExternalSyntheticLambda0
                @Override // android.media.MediaPlayer.OnPreparedListener
                public final void onPrepared(MediaPlayer mediaPlayer) {
                    SimplifiedVideoView.initializePlayer$lambda$5$lambda$4(SimplifiedVideoView.this, mediaPlayer);
                }
            });
            setVideoPath(this.file.getAbsolutePath());
            m10241constructorimpl = Result.m10241constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m10244exceptionOrNullimpl(m10241constructorimpl) != null) {
            this.onError.invoke("VideoError");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initializePlayer$lambda$5$lambda$4(final SimplifiedVideoView simplifiedVideoView, MediaPlayer mediaPlayer) {
        mediaPlayer.setVideoScalingMode(simplifiedVideoView.enableZoomMode ? 2 : 1);
        mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: io.adn.sdk.internal.ui.common.design.view.SimplifiedVideoView$$ExternalSyntheticLambda1
            @Override // android.media.MediaPlayer.OnInfoListener
            public final boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                boolean initializePlayer$lambda$5$lambda$4$lambda$3$lambda$0;
                initializePlayer$lambda$5$lambda$4$lambda$3$lambda$0 = SimplifiedVideoView.initializePlayer$lambda$5$lambda$4$lambda$3$lambda$0(SimplifiedVideoView.this, mediaPlayer2, i, i2);
                return initializePlayer$lambda$5$lambda$4$lambda$3$lambda$0;
            }
        });
        mediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: io.adn.sdk.internal.ui.common.design.view.SimplifiedVideoView$$ExternalSyntheticLambda2
            @Override // android.media.MediaPlayer.OnErrorListener
            public final boolean onError(MediaPlayer mediaPlayer2, int i, int i2) {
                boolean initializePlayer$lambda$5$lambda$4$lambda$3$lambda$1;
                initializePlayer$lambda$5$lambda$4$lambda$3$lambda$1 = SimplifiedVideoView.initializePlayer$lambda$5$lambda$4$lambda$3$lambda$1(mediaPlayer2, i, i2);
                return initializePlayer$lambda$5$lambda$4$lambda$3$lambda$1;
            }
        });
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: io.adn.sdk.internal.ui.common.design.view.SimplifiedVideoView$$ExternalSyntheticLambda3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public final void onCompletion(MediaPlayer mediaPlayer2) {
                SimplifiedVideoView.initializePlayer$lambda$5$lambda$4$lambda$3$lambda$2(SimplifiedVideoView.this, mediaPlayer2);
            }
        });
        simplifiedVideoView.player = mediaPlayer;
        simplifiedVideoView.seekTo(simplifiedVideoView.savedSeekPosition);
        simplifiedVideoView.setMute(simplifiedVideoView.savedIsMute);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initializePlayer$lambda$5$lambda$4$lambda$3$lambda$0(SimplifiedVideoView simplifiedVideoView, MediaPlayer mediaPlayer, int i, int i2) {
        if (i != 3) {
            return false;
        }
        simplifiedVideoView.onFirstFrameRendered.invoke();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initializePlayer$lambda$5$lambda$4$lambda$3$lambda$2(SimplifiedVideoView simplifiedVideoView, MediaPlayer mediaPlayer) {
        simplifiedVideoView.trackPlayerFinish();
        if (simplifiedVideoView.loopPlayback) {
            simplifiedVideoView.play();
        }
    }

    public final long currentPosition() {
        Object m10241constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            SimplifiedVideoView simplifiedVideoView = this;
            m10241constructorimpl = Result.m10241constructorimpl(Long.valueOf(this.player != null ? r2.getCurrentPosition() : 0L));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m10247isFailureimpl(m10241constructorimpl)) {
            m10241constructorimpl = 0L;
        }
        return ((Number) m10241constructorimpl).longValue();
    }

    public final long duration() {
        Object m10241constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            SimplifiedVideoView simplifiedVideoView = this;
            m10241constructorimpl = Result.m10241constructorimpl(Long.valueOf(this.player != null ? r2.getDuration() : 0L));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m10247isFailureimpl(m10241constructorimpl)) {
            m10241constructorimpl = 0L;
        }
        return ((Number) m10241constructorimpl).longValue();
    }

    public final void play() {
        try {
            Result.Companion companion = Result.INSTANCE;
            SimplifiedVideoView simplifiedVideoView = this;
            MediaPlayer mediaPlayer = this.player;
            if (mediaPlayer != null) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer = null;
                }
                if (mediaPlayer != null) {
                    mediaPlayer.start();
                }
            }
            this.onPlayerStateChanged.invoke(VideoState.Playing.INSTANCE);
            startProgressTracking();
            Result.m10241constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
    }

    @Override // android.widget.VideoView, android.widget.MediaController.MediaPlayerControl
    public void pause() {
        try {
            Result.Companion companion = Result.INSTANCE;
            SimplifiedVideoView simplifiedVideoView = this;
            MediaPlayer mediaPlayer = this.player;
            Unit unit = null;
            if (mediaPlayer != null) {
                if (!mediaPlayer.isPlaying()) {
                    mediaPlayer = null;
                }
                if (mediaPlayer != null) {
                    mediaPlayer.pause();
                    this.onPlayerStateChanged.invoke(new VideoState.Paused(currentPosition()));
                    stopProgressTracking();
                    unit = Unit.INSTANCE;
                }
            }
            Result.m10241constructorimpl(unit);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
    }

    public final void setMute(boolean isMute) {
        float f = isMute ? 0.0f : 1.0f;
        this.savedIsMute = isMute;
        MediaPlayer mediaPlayer = this.player;
        if (mediaPlayer != null) {
            mediaPlayer.setVolume(f, f);
        }
    }

    @Override // android.widget.VideoView, android.widget.MediaController.MediaPlayerControl
    public void seekTo(int position) {
        Unit unit;
        try {
            Result.Companion companion = Result.INSTANCE;
            SimplifiedVideoView simplifiedVideoView = this;
            this.savedSeekPosition = position;
            MediaPlayer mediaPlayer = this.player;
            if (mediaPlayer != null) {
                mediaPlayer.seekTo(position);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            Result.m10241constructorimpl(unit);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
    }

    public final void releasePlayer() {
        try {
            Result.Companion companion = Result.INSTANCE;
            SimplifiedVideoView simplifiedVideoView = this;
            stopProgressTracking();
            stopPlayback();
            MediaPlayer mediaPlayer = this.player;
            if (mediaPlayer != null) {
                mediaPlayer.release();
            }
            this.player = null;
            Result.m10241constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
    }

    private final void startProgressTracking() {
        Job launch$default;
        Job job = this.playbackProgressJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        if (this.onProgressChanged != null) {
            launch$default = BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new SimplifiedVideoView$startProgressTracking$1(this, null), 3, null);
            this.playbackProgressJob = launch$default;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object trackPlayerProgress(Continuation<? super Unit> continuation) {
        Function1<PlaybackProgress, Unit> function1;
        long currentPosition = currentPosition();
        if (this.player != null && (function1 = this.onProgressChanged) != null) {
            function1.invoke(new PlaybackProgress(currentPosition, duration()));
        }
        Object delay = DelayKt.delay(currentPosition > 0 ? 500L : 200L, continuation);
        return delay == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? delay : Unit.INSTANCE;
    }

    private final void trackPlayerFinish() {
        if (this.player != null) {
            long duration = duration();
            Function1<PlaybackProgress, Unit> function1 = this.onProgressChanged;
            if (function1 != null) {
                function1.invoke(new PlaybackProgress(duration, duration));
            }
            this.onPlayerStateChanged.invoke(VideoState.Finished.INSTANCE);
        }
    }

    private final void stopProgressTracking() {
        Job job = this.playbackProgressJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.playbackProgressJob = null;
    }
}
