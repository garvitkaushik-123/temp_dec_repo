package io.adn.sdk.internal.ui.common.design.compose;

import android.content.Context;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.viewinterop.AndroidView_androidKt;
import androidx.profileinstaller.ProfileVerifier;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ui.StyledPlayerView;
import com.ironsource.C3040d4;
import io.adn.sdk.internal.domain.model.ad.PlaybackProgress;
import io.adn.sdk.internal.domain.model.ui.VideoState;
import io.adn.sdk.internal.ui.common.design.view.SimplifiedExoPlayer;
import io.adn.sdk.internal.ui.common.lifecycle.BindWithLifecycleKt;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: ExoVideoPlayer.kt */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a¨\u0001\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u000e2!\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00010\u00102\u0016\b\u0002\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00102\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00010\u0010H\u0001¢\u0006\u0002\u0010\u0019¨\u0006\u001a"}, d2 = {"ExoVideoPlayer", "", "modifier", "Landroidx/compose/ui/Modifier;", C3040d4.h.b, "Ljava/io/File;", "playAutomatically", "", "seekToMillis", "", "isMute", "loopPlayback", "enableZoomMode", "onFirstFrameRendered", "Lkotlin/Function0;", "onPlayerStateChanged", "Lkotlin/Function1;", "Lio/adn/sdk/internal/domain/model/ui/VideoState;", "Lkotlin/ParameterName;", "name", "state", "onProgressChanged", "Lio/adn/sdk/internal/domain/model/ad/PlaybackProgress;", "onError", "", "(Landroidx/compose/ui/Modifier;Ljava/io/File;ZJZZZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "adn-sdk_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class ExoVideoPlayerKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final StyledPlayerView ExoVideoPlayer$lambda$13$lambda$12(StyledPlayerView styledPlayerView, Context it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return styledPlayerView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExoVideoPlayer$lambda$14(Modifier modifier, File file, boolean z, long j, boolean z2, boolean z3, boolean z4, Function0 function0, Function1 function1, Function1 function12, Function1 function13, int i, int i2, int i3, Composer composer, int i4) {
        ExoVideoPlayer(modifier, file, z, j, z2, z3, z4, function0, function1, function12, function13, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x0337  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x035c  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x038c  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x03af  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0306  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x02cb  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x03bd  */
    /* JADX WARN: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x028a  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0294  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x02c9  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x02d7  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0304  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0312  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ExoVideoPlayer(Modifier modifier, final File file, boolean z, final long j, boolean z2, boolean z3, boolean z4, final Function0<Unit> onFirstFrameRendered, final Function1<? super VideoState, Unit> onPlayerStateChanged, Function1<? super PlaybackProgress, Unit> function1, final Function1<? super String, Unit> onError, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        final boolean z5;
        int i5;
        int i6;
        int i7;
        Object rememberedValue;
        Modifier modifier2;
        Composer composer2;
        boolean z6;
        int i8;
        int i9;
        final SimplifiedExoPlayer simplifiedExoPlayer;
        Object rememberedValue2;
        boolean changedInstance;
        Continuation continuation;
        ExoVideoPlayerKt$ExoVideoPlayer$1$1 exoVideoPlayerKt$ExoVideoPlayer$1$1;
        boolean changedInstance2;
        ExoVideoPlayerKt$ExoVideoPlayer$2$1 rememberedValue3;
        boolean changedInstance3;
        final boolean z7;
        ExoVideoPlayerKt$ExoVideoPlayer$3$1 exoVideoPlayerKt$ExoVideoPlayer$3$1;
        boolean changedInstance4;
        Object rememberedValue4;
        boolean changedInstance5;
        Object rememberedValue5;
        boolean changedInstance6;
        Object rememberedValue6;
        boolean changedInstance7;
        Object rememberedValue7;
        Composer composer3;
        final boolean z8;
        final Modifier modifier3;
        final Function1<? super PlaybackProgress, Unit> function12;
        ScopeUpdateScope endRestartGroup;
        int i10;
        boolean z9 = z2;
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(onFirstFrameRendered, "onFirstFrameRendered");
        Intrinsics.checkNotNullParameter(onPlayerStateChanged, "onPlayerStateChanged");
        Intrinsics.checkNotNullParameter(onError, "onError");
        Composer startRestartGroup = composer.startRestartGroup(685760217);
        int i11 = i3 & 1;
        if (i11 != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (startRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 48) == 0) {
            i4 |= startRestartGroup.changedInstance(file) ? 32 : 16;
        }
        if ((i3 & 4) != 0) {
            i4 |= 384;
        } else if ((i & 384) == 0) {
            i4 |= startRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i3 & 8) != 0) {
            i4 |= 3072;
        } else if ((i & 3072) == 0) {
            i4 |= startRestartGroup.changed(j) ? 2048 : 1024;
        }
        if ((i3 & 16) != 0) {
            i4 |= 24576;
        } else if ((i & 24576) == 0) {
            i4 |= startRestartGroup.changed(z9) ? 16384 : 8192;
        }
        int i12 = i3 & 32;
        if (i12 != 0) {
            i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            i4 |= startRestartGroup.changed(z3) ? 131072 : 65536;
        }
        int i13 = i3 & 64;
        if (i13 != 0) {
            i4 |= 1572864;
            z5 = z4;
        } else {
            z5 = z4;
            if ((i & 1572864) == 0) {
                i4 |= startRestartGroup.changed(z5) ? 1048576 : 524288;
            }
        }
        if ((i3 & 128) != 0) {
            i4 |= 12582912;
        } else if ((i & 12582912) == 0) {
            i4 |= startRestartGroup.changedInstance(onFirstFrameRendered) ? 8388608 : 4194304;
        }
        if ((i3 & 256) == 0) {
            i10 = (100663296 & i) == 0 ? startRestartGroup.changedInstance(onPlayerStateChanged) ? 67108864 : 33554432 : 100663296;
            i5 = i3 & 512;
            if (i5 == 0) {
                i4 |= C.ENCODING_PCM_32BIT;
            } else if ((i & C.ENCODING_PCM_32BIT) == 0) {
                i6 = i5;
                i4 |= startRestartGroup.changedInstance(function1) ? 536870912 : 268435456;
                if ((i3 & 1024) != 0) {
                    i7 = i2 | 6;
                } else if ((i2 & 6) == 0) {
                    i7 = i2 | (startRestartGroup.changedInstance(onError) ? 4 : 2);
                } else {
                    i7 = i2;
                }
                if ((i4 & 306783379) == 306783378 || (i7 & 3) != 2 || !startRestartGroup.getSkipping()) {
                    Modifier.Companion companion = i11 != 0 ? Modifier.INSTANCE : modifier;
                    boolean z10 = i12 != 0 ? false : z3;
                    boolean z11 = i13 != 0 ? false : z5;
                    Function1<? super PlaybackProgress, Unit> function13 = i6 != 0 ? null : function1;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(685760217, i4, i7, "io.adn.sdk.internal.ui.common.design.compose.ExoVideoPlayer (ExoVideoPlayer.kt:32)");
                    }
                    ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume = startRestartGroup.consume(localContext);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    Context context = (Context) consume;
                    startRestartGroup.startReplaceableGroup(1641104268);
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                        boolean z12 = z10;
                        Function1<? super PlaybackProgress, Unit> function14 = function13;
                        Composer composer4 = startRestartGroup;
                        i8 = i4;
                        modifier2 = companion;
                        i9 = 2048;
                        SimplifiedExoPlayer simplifiedExoPlayer2 = new SimplifiedExoPlayer(context, file, z12, onFirstFrameRendered, onPlayerStateChanged, function14, onError, null, 128, null);
                        z6 = z12;
                        function13 = function14;
                        composer4.updateRememberedValue(simplifiedExoPlayer2);
                        rememberedValue = simplifiedExoPlayer2;
                        composer2 = composer4;
                    } else {
                        modifier2 = companion;
                        composer2 = startRestartGroup;
                        z6 = z10;
                        i8 = i4;
                        i9 = 2048;
                    }
                    simplifiedExoPlayer = (SimplifiedExoPlayer) rememberedValue;
                    composer2.endReplaceableGroup();
                    composer2.startReplaceableGroup(1641116032);
                    rememberedValue2 = composer2.rememberedValue();
                    Object obj = rememberedValue2;
                    if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        StyledPlayerView styledPlayerView = new StyledPlayerView(context);
                        styledPlayerView.setUseController(false);
                        styledPlayerView.setPlayer(simplifiedExoPlayer.getExoPlayer());
                        styledPlayerView.setResizeMode(z11 ? 4 : 0);
                        composer2.updateRememberedValue(styledPlayerView);
                        obj = styledPlayerView;
                    }
                    final StyledPlayerView styledPlayerView2 = (StyledPlayerView) obj;
                    composer2.endReplaceableGroup();
                    Long valueOf = Long.valueOf(j);
                    composer2.startReplaceableGroup(1641125621);
                    changedInstance = ((i8 & 7168) == i9) | composer2.changedInstance(simplifiedExoPlayer);
                    Object rememberedValue8 = composer2.rememberedValue();
                    if (!changedInstance || rememberedValue8 == Composer.INSTANCE.getEmpty()) {
                        continuation = null;
                        exoVideoPlayerKt$ExoVideoPlayer$1$1 = new ExoVideoPlayerKt$ExoVideoPlayer$1$1(j, simplifiedExoPlayer, null);
                        composer2.updateRememberedValue(exoVideoPlayerKt$ExoVideoPlayer$1$1);
                    } else {
                        exoVideoPlayerKt$ExoVideoPlayer$1$1 = rememberedValue8;
                        continuation = null;
                    }
                    composer2.endReplaceableGroup();
                    EffectsKt.LaunchedEffect(valueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) exoVideoPlayerKt$ExoVideoPlayer$1$1, composer2, (i8 >> 9) & 14);
                    Boolean valueOf2 = Boolean.valueOf(z2);
                    composer2.startReplaceableGroup(1641128698);
                    changedInstance2 = composer2.changedInstance(simplifiedExoPlayer) | ((57344 & i8) == 16384);
                    rememberedValue3 = composer2.rememberedValue();
                    if (!changedInstance2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        z9 = z2;
                        rememberedValue3 = new ExoVideoPlayerKt$ExoVideoPlayer$2$1(simplifiedExoPlayer, z9, continuation);
                        composer2.updateRememberedValue(rememberedValue3);
                    } else {
                        z9 = z2;
                    }
                    composer2.endReplaceableGroup();
                    EffectsKt.LaunchedEffect(valueOf2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue3, composer2, (i8 >> 12) & 14);
                    Boolean valueOf3 = Boolean.valueOf(z);
                    composer2.startReplaceableGroup(1641131327);
                    int i14 = i8 & 896;
                    changedInstance3 = (i14 == 256) | composer2.changedInstance(simplifiedExoPlayer);
                    Object rememberedValue9 = composer2.rememberedValue();
                    if (!changedInstance3 || rememberedValue9 == Composer.INSTANCE.getEmpty()) {
                        z7 = z;
                        exoVideoPlayerKt$ExoVideoPlayer$3$1 = new ExoVideoPlayerKt$ExoVideoPlayer$3$1(z7, simplifiedExoPlayer, continuation);
                        composer2.updateRememberedValue(exoVideoPlayerKt$ExoVideoPlayer$3$1);
                    } else {
                        exoVideoPlayerKt$ExoVideoPlayer$3$1 = rememberedValue9;
                        z7 = z;
                    }
                    composer2.endReplaceableGroup();
                    EffectsKt.LaunchedEffect(valueOf3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) exoVideoPlayerKt$ExoVideoPlayer$3$1, composer2, (i8 >> 6) & 14);
                    composer2.startReplaceableGroup(1641135315);
                    changedInstance4 = (i14 == 256) | composer2.changedInstance(simplifiedExoPlayer);
                    rememberedValue4 = composer2.rememberedValue();
                    if (!changedInstance4 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue4 = new Function0() { // from class: io.adn.sdk.internal.ui.common.design.compose.ExoVideoPlayerKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit ExoVideoPlayer$lambda$7$lambda$6;
                                ExoVideoPlayer$lambda$7$lambda$6 = ExoVideoPlayerKt.ExoVideoPlayer$lambda$7$lambda$6(z7, simplifiedExoPlayer);
                                return ExoVideoPlayer$lambda$7$lambda$6;
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue4);
                    }
                    Function0 function0 = (Function0) rememberedValue4;
                    composer2.endReplaceableGroup();
                    composer2.startReplaceableGroup(1641138182);
                    changedInstance5 = composer2.changedInstance(simplifiedExoPlayer);
                    rememberedValue5 = composer2.rememberedValue();
                    if (!changedInstance5 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue5 = new Function0() { // from class: io.adn.sdk.internal.ui.common.design.compose.ExoVideoPlayerKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit ExoVideoPlayer$lambda$9$lambda$8;
                                ExoVideoPlayer$lambda$9$lambda$8 = ExoVideoPlayerKt.ExoVideoPlayer$lambda$9$lambda$8(SimplifiedExoPlayer.this);
                                return ExoVideoPlayer$lambda$9$lambda$8;
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue5);
                    }
                    Function0 function02 = (Function0) rememberedValue5;
                    composer2.endReplaceableGroup();
                    composer2.startReplaceableGroup(1641139566);
                    changedInstance6 = composer2.changedInstance(simplifiedExoPlayer);
                    rememberedValue6 = composer2.rememberedValue();
                    if (!changedInstance6 || rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue6 = new Function0() { // from class: io.adn.sdk.internal.ui.common.design.compose.ExoVideoPlayerKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit ExoVideoPlayer$lambda$11$lambda$10;
                                ExoVideoPlayer$lambda$11$lambda$10 = ExoVideoPlayerKt.ExoVideoPlayer$lambda$11$lambda$10(SimplifiedExoPlayer.this);
                                return ExoVideoPlayer$lambda$11$lambda$10;
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue6);
                    }
                    composer2.endReplaceableGroup();
                    BindWithLifecycleKt.ObserveLifecycle(function0, function02, (Function0) rememberedValue6, composer2, 0);
                    Modifier modifier4 = modifier2;
                    Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(modifier4, 0.0f, 1, continuation);
                    composer2.startReplaceableGroup(1641143231);
                    changedInstance7 = composer2.changedInstance(styledPlayerView2);
                    rememberedValue7 = composer2.rememberedValue();
                    if (!changedInstance7 || rememberedValue7 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue7 = new Function1() { // from class: io.adn.sdk.internal.ui.common.design.compose.ExoVideoPlayerKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                StyledPlayerView ExoVideoPlayer$lambda$13$lambda$12;
                                ExoVideoPlayer$lambda$13$lambda$12 = ExoVideoPlayerKt.ExoVideoPlayer$lambda$13$lambda$12(StyledPlayerView.this, (Context) obj2);
                                return ExoVideoPlayer$lambda$13$lambda$12;
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue7);
                    }
                    composer2.endReplaceableGroup();
                    Composer composer5 = composer2;
                    AndroidView_androidKt.AndroidView((Function1) rememberedValue7, fillMaxSize$default, null, composer5, 0, 4);
                    composer3 = composer5;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z8 = z6;
                    modifier3 = modifier4;
                    z5 = z11;
                    function12 = function13;
                } else {
                    startRestartGroup.skipToGroupEnd();
                    modifier3 = modifier;
                    z8 = z3;
                    composer3 = startRestartGroup;
                    z7 = z;
                    function12 = function1;
                }
                endRestartGroup = composer3.endRestartGroup();
                if (endRestartGroup != null) {
                    final boolean z13 = z7;
                    final boolean z14 = z9;
                    endRestartGroup.updateScope(new Function2() { // from class: io.adn.sdk.internal.ui.common.design.compose.ExoVideoPlayerKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            Unit ExoVideoPlayer$lambda$14;
                            ExoVideoPlayer$lambda$14 = ExoVideoPlayerKt.ExoVideoPlayer$lambda$14(Modifier.this, file, z13, j, z14, z8, z5, onFirstFrameRendered, onPlayerStateChanged, function12, onError, i, i2, i3, (Composer) obj2, ((Integer) obj3).intValue());
                            return ExoVideoPlayer$lambda$14;
                        }
                    });
                    return;
                }
                return;
            }
            i6 = i5;
            if ((i3 & 1024) != 0) {
            }
            if ((i4 & 306783379) == 306783378) {
            }
            if (i11 != 0) {
            }
            if (i12 != 0) {
            }
            if (i13 != 0) {
            }
            if (i6 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            ProvidableCompositionLocal<Context> localContext2 = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume2 = startRestartGroup.consume(localContext2);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Context context2 = (Context) consume2;
            startRestartGroup.startReplaceableGroup(1641104268);
            rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            }
            simplifiedExoPlayer = (SimplifiedExoPlayer) rememberedValue;
            composer2.endReplaceableGroup();
            composer2.startReplaceableGroup(1641116032);
            rememberedValue2 = composer2.rememberedValue();
            Object obj2 = rememberedValue2;
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
            }
            final StyledPlayerView styledPlayerView22 = (StyledPlayerView) obj2;
            composer2.endReplaceableGroup();
            Long valueOf4 = Long.valueOf(j);
            composer2.startReplaceableGroup(1641125621);
            changedInstance = ((i8 & 7168) == i9) | composer2.changedInstance(simplifiedExoPlayer);
            Object rememberedValue82 = composer2.rememberedValue();
            if (changedInstance) {
            }
            continuation = null;
            exoVideoPlayerKt$ExoVideoPlayer$1$1 = new ExoVideoPlayerKt$ExoVideoPlayer$1$1(j, simplifiedExoPlayer, null);
            composer2.updateRememberedValue(exoVideoPlayerKt$ExoVideoPlayer$1$1);
            composer2.endReplaceableGroup();
            EffectsKt.LaunchedEffect(valueOf4, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) exoVideoPlayerKt$ExoVideoPlayer$1$1, composer2, (i8 >> 9) & 14);
            Boolean valueOf22 = Boolean.valueOf(z2);
            composer2.startReplaceableGroup(1641128698);
            changedInstance2 = composer2.changedInstance(simplifiedExoPlayer) | ((57344 & i8) == 16384);
            rememberedValue3 = composer2.rememberedValue();
            if (changedInstance2) {
            }
            z9 = z2;
            rememberedValue3 = new ExoVideoPlayerKt$ExoVideoPlayer$2$1(simplifiedExoPlayer, z9, continuation);
            composer2.updateRememberedValue(rememberedValue3);
            composer2.endReplaceableGroup();
            EffectsKt.LaunchedEffect(valueOf22, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue3, composer2, (i8 >> 12) & 14);
            Boolean valueOf32 = Boolean.valueOf(z);
            composer2.startReplaceableGroup(1641131327);
            int i142 = i8 & 896;
            changedInstance3 = (i142 == 256) | composer2.changedInstance(simplifiedExoPlayer);
            Object rememberedValue92 = composer2.rememberedValue();
            if (changedInstance3) {
            }
            z7 = z;
            exoVideoPlayerKt$ExoVideoPlayer$3$1 = new ExoVideoPlayerKt$ExoVideoPlayer$3$1(z7, simplifiedExoPlayer, continuation);
            composer2.updateRememberedValue(exoVideoPlayerKt$ExoVideoPlayer$3$1);
            composer2.endReplaceableGroup();
            EffectsKt.LaunchedEffect(valueOf32, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) exoVideoPlayerKt$ExoVideoPlayer$3$1, composer2, (i8 >> 6) & 14);
            composer2.startReplaceableGroup(1641135315);
            changedInstance4 = (i142 == 256) | composer2.changedInstance(simplifiedExoPlayer);
            rememberedValue4 = composer2.rememberedValue();
            if (!changedInstance4) {
            }
            rememberedValue4 = new Function0() { // from class: io.adn.sdk.internal.ui.common.design.compose.ExoVideoPlayerKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit ExoVideoPlayer$lambda$7$lambda$6;
                    ExoVideoPlayer$lambda$7$lambda$6 = ExoVideoPlayerKt.ExoVideoPlayer$lambda$7$lambda$6(z7, simplifiedExoPlayer);
                    return ExoVideoPlayer$lambda$7$lambda$6;
                }
            };
            composer2.updateRememberedValue(rememberedValue4);
            Function0 function03 = (Function0) rememberedValue4;
            composer2.endReplaceableGroup();
            composer2.startReplaceableGroup(1641138182);
            changedInstance5 = composer2.changedInstance(simplifiedExoPlayer);
            rememberedValue5 = composer2.rememberedValue();
            if (!changedInstance5) {
            }
            rememberedValue5 = new Function0() { // from class: io.adn.sdk.internal.ui.common.design.compose.ExoVideoPlayerKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit ExoVideoPlayer$lambda$9$lambda$8;
                    ExoVideoPlayer$lambda$9$lambda$8 = ExoVideoPlayerKt.ExoVideoPlayer$lambda$9$lambda$8(SimplifiedExoPlayer.this);
                    return ExoVideoPlayer$lambda$9$lambda$8;
                }
            };
            composer2.updateRememberedValue(rememberedValue5);
            Function0 function022 = (Function0) rememberedValue5;
            composer2.endReplaceableGroup();
            composer2.startReplaceableGroup(1641139566);
            changedInstance6 = composer2.changedInstance(simplifiedExoPlayer);
            rememberedValue6 = composer2.rememberedValue();
            if (!changedInstance6) {
            }
            rememberedValue6 = new Function0() { // from class: io.adn.sdk.internal.ui.common.design.compose.ExoVideoPlayerKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit ExoVideoPlayer$lambda$11$lambda$10;
                    ExoVideoPlayer$lambda$11$lambda$10 = ExoVideoPlayerKt.ExoVideoPlayer$lambda$11$lambda$10(SimplifiedExoPlayer.this);
                    return ExoVideoPlayer$lambda$11$lambda$10;
                }
            };
            composer2.updateRememberedValue(rememberedValue6);
            composer2.endReplaceableGroup();
            BindWithLifecycleKt.ObserveLifecycle(function03, function022, (Function0) rememberedValue6, composer2, 0);
            Modifier modifier42 = modifier2;
            Modifier fillMaxSize$default2 = SizeKt.fillMaxSize$default(modifier42, 0.0f, 1, continuation);
            composer2.startReplaceableGroup(1641143231);
            changedInstance7 = composer2.changedInstance(styledPlayerView22);
            rememberedValue7 = composer2.rememberedValue();
            if (!changedInstance7) {
            }
            rememberedValue7 = new Function1() { // from class: io.adn.sdk.internal.ui.common.design.compose.ExoVideoPlayerKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj22) {
                    StyledPlayerView ExoVideoPlayer$lambda$13$lambda$12;
                    ExoVideoPlayer$lambda$13$lambda$12 = ExoVideoPlayerKt.ExoVideoPlayer$lambda$13$lambda$12(StyledPlayerView.this, (Context) obj22);
                    return ExoVideoPlayer$lambda$13$lambda$12;
                }
            };
            composer2.updateRememberedValue(rememberedValue7);
            composer2.endReplaceableGroup();
            Composer composer52 = composer2;
            AndroidView_androidKt.AndroidView((Function1) rememberedValue7, fillMaxSize$default2, null, composer52, 0, 4);
            composer3 = composer52;
            if (ComposerKt.isTraceInProgress()) {
            }
            z8 = z6;
            modifier3 = modifier42;
            z5 = z11;
            function12 = function13;
            endRestartGroup = composer3.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        i4 |= i10;
        i5 = i3 & 512;
        if (i5 == 0) {
        }
        i6 = i5;
        if ((i3 & 1024) != 0) {
        }
        if ((i4 & 306783379) == 306783378) {
        }
        if (i11 != 0) {
        }
        if (i12 != 0) {
        }
        if (i13 != 0) {
        }
        if (i6 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        ProvidableCompositionLocal<Context> localContext22 = AndroidCompositionLocals_androidKt.getLocalContext();
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume22 = startRestartGroup.consume(localContext22);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        Context context22 = (Context) consume22;
        startRestartGroup.startReplaceableGroup(1641104268);
        rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
        }
        simplifiedExoPlayer = (SimplifiedExoPlayer) rememberedValue;
        composer2.endReplaceableGroup();
        composer2.startReplaceableGroup(1641116032);
        rememberedValue2 = composer2.rememberedValue();
        Object obj22 = rememberedValue2;
        if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
        }
        final StyledPlayerView styledPlayerView222 = (StyledPlayerView) obj22;
        composer2.endReplaceableGroup();
        Long valueOf42 = Long.valueOf(j);
        composer2.startReplaceableGroup(1641125621);
        changedInstance = ((i8 & 7168) == i9) | composer2.changedInstance(simplifiedExoPlayer);
        Object rememberedValue822 = composer2.rememberedValue();
        if (changedInstance) {
        }
        continuation = null;
        exoVideoPlayerKt$ExoVideoPlayer$1$1 = new ExoVideoPlayerKt$ExoVideoPlayer$1$1(j, simplifiedExoPlayer, null);
        composer2.updateRememberedValue(exoVideoPlayerKt$ExoVideoPlayer$1$1);
        composer2.endReplaceableGroup();
        EffectsKt.LaunchedEffect(valueOf42, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) exoVideoPlayerKt$ExoVideoPlayer$1$1, composer2, (i8 >> 9) & 14);
        Boolean valueOf222 = Boolean.valueOf(z2);
        composer2.startReplaceableGroup(1641128698);
        changedInstance2 = composer2.changedInstance(simplifiedExoPlayer) | ((57344 & i8) == 16384);
        rememberedValue3 = composer2.rememberedValue();
        if (changedInstance2) {
        }
        z9 = z2;
        rememberedValue3 = new ExoVideoPlayerKt$ExoVideoPlayer$2$1(simplifiedExoPlayer, z9, continuation);
        composer2.updateRememberedValue(rememberedValue3);
        composer2.endReplaceableGroup();
        EffectsKt.LaunchedEffect(valueOf222, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue3, composer2, (i8 >> 12) & 14);
        Boolean valueOf322 = Boolean.valueOf(z);
        composer2.startReplaceableGroup(1641131327);
        int i1422 = i8 & 896;
        changedInstance3 = (i1422 == 256) | composer2.changedInstance(simplifiedExoPlayer);
        Object rememberedValue922 = composer2.rememberedValue();
        if (changedInstance3) {
        }
        z7 = z;
        exoVideoPlayerKt$ExoVideoPlayer$3$1 = new ExoVideoPlayerKt$ExoVideoPlayer$3$1(z7, simplifiedExoPlayer, continuation);
        composer2.updateRememberedValue(exoVideoPlayerKt$ExoVideoPlayer$3$1);
        composer2.endReplaceableGroup();
        EffectsKt.LaunchedEffect(valueOf322, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) exoVideoPlayerKt$ExoVideoPlayer$3$1, composer2, (i8 >> 6) & 14);
        composer2.startReplaceableGroup(1641135315);
        changedInstance4 = (i1422 == 256) | composer2.changedInstance(simplifiedExoPlayer);
        rememberedValue4 = composer2.rememberedValue();
        if (!changedInstance4) {
        }
        rememberedValue4 = new Function0() { // from class: io.adn.sdk.internal.ui.common.design.compose.ExoVideoPlayerKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit ExoVideoPlayer$lambda$7$lambda$6;
                ExoVideoPlayer$lambda$7$lambda$6 = ExoVideoPlayerKt.ExoVideoPlayer$lambda$7$lambda$6(z7, simplifiedExoPlayer);
                return ExoVideoPlayer$lambda$7$lambda$6;
            }
        };
        composer2.updateRememberedValue(rememberedValue4);
        Function0 function032 = (Function0) rememberedValue4;
        composer2.endReplaceableGroup();
        composer2.startReplaceableGroup(1641138182);
        changedInstance5 = composer2.changedInstance(simplifiedExoPlayer);
        rememberedValue5 = composer2.rememberedValue();
        if (!changedInstance5) {
        }
        rememberedValue5 = new Function0() { // from class: io.adn.sdk.internal.ui.common.design.compose.ExoVideoPlayerKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit ExoVideoPlayer$lambda$9$lambda$8;
                ExoVideoPlayer$lambda$9$lambda$8 = ExoVideoPlayerKt.ExoVideoPlayer$lambda$9$lambda$8(SimplifiedExoPlayer.this);
                return ExoVideoPlayer$lambda$9$lambda$8;
            }
        };
        composer2.updateRememberedValue(rememberedValue5);
        Function0 function0222 = (Function0) rememberedValue5;
        composer2.endReplaceableGroup();
        composer2.startReplaceableGroup(1641139566);
        changedInstance6 = composer2.changedInstance(simplifiedExoPlayer);
        rememberedValue6 = composer2.rememberedValue();
        if (!changedInstance6) {
        }
        rememberedValue6 = new Function0() { // from class: io.adn.sdk.internal.ui.common.design.compose.ExoVideoPlayerKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit ExoVideoPlayer$lambda$11$lambda$10;
                ExoVideoPlayer$lambda$11$lambda$10 = ExoVideoPlayerKt.ExoVideoPlayer$lambda$11$lambda$10(SimplifiedExoPlayer.this);
                return ExoVideoPlayer$lambda$11$lambda$10;
            }
        };
        composer2.updateRememberedValue(rememberedValue6);
        composer2.endReplaceableGroup();
        BindWithLifecycleKt.ObserveLifecycle(function032, function0222, (Function0) rememberedValue6, composer2, 0);
        Modifier modifier422 = modifier2;
        Modifier fillMaxSize$default22 = SizeKt.fillMaxSize$default(modifier422, 0.0f, 1, continuation);
        composer2.startReplaceableGroup(1641143231);
        changedInstance7 = composer2.changedInstance(styledPlayerView222);
        rememberedValue7 = composer2.rememberedValue();
        if (!changedInstance7) {
        }
        rememberedValue7 = new Function1() { // from class: io.adn.sdk.internal.ui.common.design.compose.ExoVideoPlayerKt$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj222) {
                StyledPlayerView ExoVideoPlayer$lambda$13$lambda$12;
                ExoVideoPlayer$lambda$13$lambda$12 = ExoVideoPlayerKt.ExoVideoPlayer$lambda$13$lambda$12(StyledPlayerView.this, (Context) obj222);
                return ExoVideoPlayer$lambda$13$lambda$12;
            }
        };
        composer2.updateRememberedValue(rememberedValue7);
        composer2.endReplaceableGroup();
        Composer composer522 = composer2;
        AndroidView_androidKt.AndroidView((Function1) rememberedValue7, fillMaxSize$default22, null, composer522, 0, 4);
        composer3 = composer522;
        if (ComposerKt.isTraceInProgress()) {
        }
        z8 = z6;
        modifier3 = modifier422;
        z5 = z11;
        function12 = function13;
        endRestartGroup = composer3.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExoVideoPlayer$lambda$7$lambda$6(boolean z, SimplifiedExoPlayer simplifiedExoPlayer) {
        if (z) {
            simplifiedExoPlayer.play();
        } else {
            simplifiedExoPlayer.pause();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExoVideoPlayer$lambda$9$lambda$8(SimplifiedExoPlayer simplifiedExoPlayer) {
        simplifiedExoPlayer.pause();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExoVideoPlayer$lambda$11$lambda$10(SimplifiedExoPlayer simplifiedExoPlayer) {
        simplifiedExoPlayer.releasePlayer();
        return Unit.INSTANCE;
    }
}
