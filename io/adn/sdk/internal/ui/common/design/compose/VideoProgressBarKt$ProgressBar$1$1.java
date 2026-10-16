package io.adn.sdk.internal.ui.common.design.compose;

import adn.analytics.Analytics;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import io.adn.sdk.internal.domain.model.ad.PlaybackProgress;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: VideoProgressBar.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.adn.sdk.internal.ui.common.design.compose.VideoProgressBarKt$ProgressBar$1$1", f = "VideoProgressBar.kt", i = {}, l = {Analytics.AnalyticsData.COUNT_IMP_FIELD_NUMBER, Analytics.AnalyticsData.BOOT_TIME_FIELD_NUMBER, 88}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
final class VideoProgressBarKt$ProgressBar$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isPlaying;
    final /* synthetic */ PlaybackProgress $progress;
    final /* synthetic */ Animatable<Float, AnimationVector1D> $progressRatio;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    VideoProgressBarKt$ProgressBar$1$1(Animatable<Float, AnimationVector1D> animatable, PlaybackProgress playbackProgress, boolean z, Continuation<? super VideoProgressBarKt$ProgressBar$1$1> continuation) {
        super(2, continuation);
        this.$progressRatio = animatable;
        this.$progress = playbackProgress;
        this.$isPlaying = z;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new VideoProgressBarKt$ProgressBar$1$1(this.$progressRatio, this.$progress, this.$isPlaying, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((VideoProgressBarKt$ProgressBar$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0076, code lost:
    
        if (androidx.compose.animation.core.Animatable.animateTo$default(r5, r6, androidx.compose.animation.core.AnimationSpecKt.tween$default(r14, 0, androidx.compose.animation.core.EasingKt.getLinearEasing(), 2, null), null, null, r13, 12, null) == r0) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0084, code lost:
    
        if (r13.$progressRatio.stop(r13) == r0) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0042, code lost:
    
        if (r14.snapTo(kotlin.coroutines.jvm.internal.Boxing.boxFloat(r1), r13) == r0) goto L30;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Animatable<Float, AnimationVector1D> animatable = this.$progressRatio;
            PlaybackProgress playbackProgress = this.$progress;
            float percentage = playbackProgress != null ? playbackProgress.getPercentage() : 0.0f;
            this.label = 1;
        } else {
            if (i != 1) {
                if (i == 2) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                if (i != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                Unit unit = Unit.INSTANCE;
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
        }
        if (this.$isPlaying) {
            Animatable<Float, AnimationVector1D> animatable2 = this.$progressRatio;
            Float boxFloat = Boxing.boxFloat(1.0f);
            PlaybackProgress playbackProgress2 = this.$progress;
            int remainingMillis = playbackProgress2 != null ? playbackProgress2.getRemainingMillis() : 0;
            this.label = 2;
        } else {
            this.label = 3;
        }
        return coroutine_suspended;
    }
}
