package io.adn.sdk.internal.ui.common.design.compose;

import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.CornerRadiusKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.Dp;
import androidx.core.app.NotificationCompat;
import androidx.profileinstaller.ProfileVerifier;
import io.adn.sdk.internal.domain.model.ad.PlaybackProgress;
import io.adn.sdk.internal.domain.model.ad.ProgressbarConfig;
import io.adn.sdk.internal.ui.utils.ComposeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VideoProgressBar.kt */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a=\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\r¢\u0006\u0002\b\n¢\u0006\u0002\b\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0001¢\u0006\u0002\u0010\u0010\u001a1\u0010\u0000\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0001¢\u0006\u0004\b\u0015\u0010\u0016\u001a3\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0003¢\u0006\u0004\b\u0018\u0010\u0019*\u0090\u0001\b\u0000\u0010\u0000\"D\u0012\u0004\u0012\u00020\u0002\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0015\u0012\u0013\u0018\u00010\u0007¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0001¢\u0006\u0002\b\n¢\u0006\u0002\b\u000b2D\u0012\u0004\u0012\u00020\u0002\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0015\u0012\u0013\u0018\u00010\u0007¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0001¢\u0006\u0002\b\n¢\u0006\u0002\b\u000b¨\u0006\u001a"}, d2 = {"VideoProgressBar", "Lkotlin/Function3;", "Landroidx/compose/foundation/layout/BoxScope;", "", "Lkotlin/ParameterName;", "name", "isPlaying", "Lio/adn/sdk/internal/domain/model/ad/PlaybackProgress;", NotificationCompat.CATEGORY_PROGRESS, "", "Lkotlin/ExtensionFunctionType;", "Landroidx/compose/runtime/Composable;", "videoProgressBar", "Lkotlin/Function1;", "config", "Lio/adn/sdk/internal/domain/model/ad/ProgressbarConfig;", "(Lio/adn/sdk/internal/domain/model/ad/ProgressbarConfig;ZLio/adn/sdk/internal/domain/model/ad/PlaybackProgress;Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function3;", "modifier", "Landroidx/compose/ui/Modifier;", "color", "Landroidx/compose/ui/graphics/Color;", "VideoProgressBar-Bx497Mc", "(ZLio/adn/sdk/internal/domain/model/ad/PlaybackProgress;Landroidx/compose/ui/Modifier;JLandroidx/compose/runtime/Composer;I)V", "ProgressBar", "ProgressBar-ww6aTOc", "(ZLio/adn/sdk/internal/domain/model/ad/PlaybackProgress;Landroidx/compose/ui/Modifier;JLandroidx/compose/runtime/Composer;II)V", "adn-sdk_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class VideoProgressBarKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProgressBar_ww6aTOc$lambda$5(boolean z, PlaybackProgress playbackProgress, Modifier modifier, long j, int i, int i2, Composer composer, int i3) {
        m9542ProgressBarww6aTOc(z, playbackProgress, modifier, j, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VideoProgressBar_Bx497Mc$lambda$0(boolean z, PlaybackProgress playbackProgress, Modifier modifier, long j, int i, Composer composer, int i2) {
        m9543VideoProgressBarBx497Mc(z, playbackProgress, modifier, j, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final Function3<BoxScope, Composer, Integer, Unit> videoProgressBar(final ProgressbarConfig config, final boolean z, final PlaybackProgress playbackProgress, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(config, "config");
        composer.startReplaceableGroup(2093746143);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2093746143, i, -1, "io.adn.sdk.internal.ui.common.design.compose.videoProgressBar (VideoProgressBar.kt:34)");
        }
        ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer, -1551065991, true, new Function3<BoxScope, Composer, Integer, Unit>() { // from class: io.adn.sdk.internal.ui.common.design.compose.VideoProgressBarKt$videoProgressBar$1
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(BoxScope boxScope, Composer composer2, Integer num) {
                invoke(boxScope, composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(BoxScope boxScope, Composer composer2, int i2) {
                Intrinsics.checkNotNullParameter(boxScope, "<this>");
                if ((i2 & 6) == 0) {
                    i2 |= composer2.changed(boxScope) ? 4 : 2;
                }
                if ((i2 & 19) != 18 || !composer2.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1551065991, i2, -1, "io.adn.sdk.internal.ui.common.design.compose.videoProgressBar.<anonymous> (VideoProgressBar.kt:35)");
                    }
                    VideoProgressBarKt.m9543VideoProgressBarBx497Mc(z, playbackProgress, boxScope.align(Modifier.INSTANCE, ComposeKt.toAlignment(config.getPosition())), ComposeKt.toColor(config.getColor()), composer2, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer2.skipToGroupEnd();
            }
        });
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return composableLambda;
    }

    /* renamed from: VideoProgressBar-Bx497Mc, reason: not valid java name */
    public static final void m9543VideoProgressBarBx497Mc(final boolean z, final PlaybackProgress playbackProgress, final Modifier modifier, final long j, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Composer startRestartGroup = composer.startRestartGroup(-1380404981);
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(playbackProgress) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changed(modifier) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changed(j) ? 2048 : 1024;
        }
        if ((i2 & 1171) != 1170 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1380404981, i2, -1, "io.adn.sdk.internal.ui.common.design.compose.VideoProgressBar (VideoProgressBar.kt:51)");
            }
            AnimatedVisibilityKt.AnimatedVisibility(z, SizeKt.fillMaxWidth$default(modifier, 0.0f, 1, null), (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.composableLambda(startRestartGroup, -1945131037, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: io.adn.sdk.internal.ui.common.design.compose.VideoProgressBarKt$VideoProgressBar$2
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer2, Integer num) {
                    invoke(animatedVisibilityScope, composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer composer2, int i3) {
                    Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1945131037, i3, -1, "io.adn.sdk.internal.ui.common.design.compose.VideoProgressBar.<anonymous> (VideoProgressBar.kt:57)");
                    }
                    VideoProgressBarKt.m9542ProgressBarww6aTOc(z, playbackProgress, null, j, composer2, 0, 4);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), startRestartGroup, (i2 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 28);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: io.adn.sdk.internal.ui.common.design.compose.VideoProgressBarKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit VideoProgressBar_Bx497Mc$lambda$0;
                    VideoProgressBar_Bx497Mc$lambda$0 = VideoProgressBarKt.VideoProgressBar_Bx497Mc$lambda$0(z, playbackProgress, modifier, j, i, (Composer) obj, ((Integer) obj2).intValue());
                    return VideoProgressBar_Bx497Mc$lambda$0;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0065  */
    /* renamed from: ProgressBar-ww6aTOc, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m9542ProgressBarww6aTOc(final boolean z, final PlaybackProgress playbackProgress, Modifier modifier, final long j, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        Modifier.Companion companion;
        Object rememberedValue;
        boolean changedInstance;
        VideoProgressBarKt$ProgressBar$1$1 rememberedValue2;
        boolean changedInstance2;
        Object rememberedValue3;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(801856716);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changed(playbackProgress) ? 32 : 16;
        }
        int i4 = i2 & 4;
        if (i4 != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 256 : 128;
            if ((i2 & 8) == 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                i3 |= startRestartGroup.changed(j) ? 2048 : 1024;
            }
            if ((i3 & 1171) == 1170 || !startRestartGroup.getSkipping()) {
                companion = i4 == 0 ? Modifier.INSTANCE : modifier2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(801856716, i3, -1, "io.adn.sdk.internal.ui.common.design.compose.ProgressBar (VideoProgressBar.kt:71)");
                }
                float f = 4;
                final float m6389constructorimpl = Dp.m6389constructorimpl(f);
                startRestartGroup.startReplaceableGroup(431781224);
                rememberedValue = startRestartGroup.rememberedValue();
                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = AnimatableKt.Animatable$default(playbackProgress != null ? playbackProgress.getPercentage() : 0.0f, 0.0f, 2, null);
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                final Animatable animatable = (Animatable) rememberedValue;
                startRestartGroup.endReplaceableGroup();
                Boolean valueOf = Boolean.valueOf(z);
                startRestartGroup.startReplaceableGroup(431784552);
                changedInstance = ((i3 & 112) != 32) | startRestartGroup.changedInstance(animatable) | ((i3 & 14) != 4);
                rememberedValue2 = startRestartGroup.rememberedValue();
                if (!changedInstance || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue2 = new VideoProgressBarKt$ProgressBar$1$1(animatable, playbackProgress, z, null);
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                startRestartGroup.endReplaceableGroup();
                EffectsKt.LaunchedEffect(playbackProgress, valueOf, (Function2) rememberedValue2, startRestartGroup, ((i3 >> 3) & 14) | ((i3 << 3) & 112));
                Modifier m914height3ABfNKs = SizeKt.m914height3ABfNKs(companion, Dp.m6389constructorimpl(f));
                startRestartGroup.startReplaceableGroup(431799810);
                changedInstance2 = startRestartGroup.changedInstance(animatable) | ((i3 & 7168) == 2048);
                rememberedValue3 = startRestartGroup.rememberedValue();
                if (!changedInstance2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue3 = new Function1() { // from class: io.adn.sdk.internal.ui.common.design.compose.VideoProgressBarKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit ProgressBar_ww6aTOc$lambda$4$lambda$3;
                            ProgressBar_ww6aTOc$lambda$4$lambda$3 = VideoProgressBarKt.ProgressBar_ww6aTOc$lambda$4$lambda$3(Animatable.this, m6389constructorimpl, j, (DrawScope) obj);
                            return ProgressBar_ww6aTOc$lambda$4$lambda$3;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                }
                startRestartGroup.endReplaceableGroup();
                BoxKt.Box(DrawModifierKt.drawBehind(m914height3ABfNKs, (Function1) rememberedValue3), startRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                startRestartGroup.skipToGroupEnd();
                companion = modifier2;
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
                final Modifier modifier3 = companion;
                endRestartGroup.updateScope(new Function2() { // from class: io.adn.sdk.internal.ui.common.design.compose.VideoProgressBarKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        Unit ProgressBar_ww6aTOc$lambda$5;
                        ProgressBar_ww6aTOc$lambda$5 = VideoProgressBarKt.ProgressBar_ww6aTOc$lambda$5(z, playbackProgress, modifier3, j, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        return ProgressBar_ww6aTOc$lambda$5;
                    }
                });
                return;
            }
            return;
        }
        modifier2 = modifier;
        if ((i2 & 8) == 0) {
        }
        if ((i3 & 1171) == 1170) {
        }
        if (i4 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        float f2 = 4;
        final float m6389constructorimpl2 = Dp.m6389constructorimpl(f2);
        startRestartGroup.startReplaceableGroup(431781224);
        rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
        }
        final Animatable animatable2 = (Animatable) rememberedValue;
        startRestartGroup.endReplaceableGroup();
        Boolean valueOf2 = Boolean.valueOf(z);
        startRestartGroup.startReplaceableGroup(431784552);
        changedInstance = ((i3 & 112) != 32) | startRestartGroup.changedInstance(animatable2) | ((i3 & 14) != 4);
        rememberedValue2 = startRestartGroup.rememberedValue();
        if (!changedInstance) {
        }
        rememberedValue2 = new VideoProgressBarKt$ProgressBar$1$1(animatable2, playbackProgress, z, null);
        startRestartGroup.updateRememberedValue(rememberedValue2);
        startRestartGroup.endReplaceableGroup();
        EffectsKt.LaunchedEffect(playbackProgress, valueOf2, (Function2) rememberedValue2, startRestartGroup, ((i3 >> 3) & 14) | ((i3 << 3) & 112));
        Modifier m914height3ABfNKs2 = SizeKt.m914height3ABfNKs(companion, Dp.m6389constructorimpl(f2));
        startRestartGroup.startReplaceableGroup(431799810);
        changedInstance2 = startRestartGroup.changedInstance(animatable2) | ((i3 & 7168) == 2048);
        rememberedValue3 = startRestartGroup.rememberedValue();
        if (!changedInstance2) {
        }
        rememberedValue3 = new Function1() { // from class: io.adn.sdk.internal.ui.common.design.compose.VideoProgressBarKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit ProgressBar_ww6aTOc$lambda$4$lambda$3;
                ProgressBar_ww6aTOc$lambda$4$lambda$3 = VideoProgressBarKt.ProgressBar_ww6aTOc$lambda$4$lambda$3(Animatable.this, m6389constructorimpl2, j, (DrawScope) obj);
                return ProgressBar_ww6aTOc$lambda$4$lambda$3;
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue3);
        startRestartGroup.endReplaceableGroup();
        BoxKt.Box(DrawModifierKt.drawBehind(m914height3ABfNKs2, (Function1) rememberedValue3), startRestartGroup, 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProgressBar_ww6aTOc$lambda$4$lambda$3(Animatable animatable, float f, long j, DrawScope drawBehind) {
        Intrinsics.checkNotNullParameter(drawBehind, "$this$drawBehind");
        DrawScope.m4609drawRoundRectuAw5IA$default(drawBehind, j, 0L, androidx.compose.ui.geometry.SizeKt.Size(((Number) animatable.getValue()).floatValue() * Size.m3891getWidthimpl(drawBehind.mo4612getSizeNHjbRc()), Size.m3888getHeightimpl(drawBehind.mo4612getSizeNHjbRc())), CornerRadiusKt.CornerRadius(drawBehind.mo630toPx0680j_4(f), drawBehind.mo630toPx0680j_4(f)), null, 0.0f, null, 0, 242, null);
        return Unit.INSTANCE;
    }
}
