package io.adn.sdk.internal.ui.common.design.compose;

import android.content.Context;
import android.widget.FrameLayout;
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
import com.ironsource.C3040d4;
import io.adn.sdk.internal.domain.model.ad.PlaybackProgress;
import io.adn.sdk.internal.domain.model.ui.VideoState;
import io.adn.sdk.internal.ui.common.design.view.SimplifiedVideoView;
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

/* compiled from: VideoPlayer.kt */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a¨\u0001\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u000e2!\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00010\u00102\u0016\b\u0002\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00102\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00010\u0010H\u0001¢\u0006\u0002\u0010\u0019¨\u0006\u001a"}, d2 = {"VideoPlayer", "", "modifier", "Landroidx/compose/ui/Modifier;", C3040d4.h.b, "Ljava/io/File;", "shouldPlay", "", "seekToMillis", "", "isMute", "loopPlayback", "enableZoomMode", "onFirstFrameRendered", "Lkotlin/Function0;", "onPlayerStateChanged", "Lkotlin/Function1;", "Lio/adn/sdk/internal/domain/model/ui/VideoState;", "Lkotlin/ParameterName;", "name", "state", "onProgressChanged", "Lio/adn/sdk/internal/domain/model/ad/PlaybackProgress;", "onError", "", "(Landroidx/compose/ui/Modifier;Ljava/io/File;ZJZZZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "adn-sdk_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class VideoPlayerKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final SimplifiedVideoView VideoPlayer$lambda$12$lambda$11(SimplifiedVideoView simplifiedVideoView, Context it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return simplifiedVideoView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VideoPlayer$lambda$13(Modifier modifier, File file, boolean z, long j, boolean z2, boolean z3, boolean z4, Function0 function0, Function1 function1, Function1 function12, Function1 function13, int i, int i2, int i3, Composer composer, int i4) {
        VideoPlayer(modifier, file, z, j, z2, z3, z4, function0, function1, function12, function13, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0333  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x035c  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0386  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x02a3  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0394  */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0262  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x02a1  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x02af  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x02dd  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x02e9  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x030e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void VideoPlayer(Modifier modifier, final File file, final boolean z, final long j, boolean z2, boolean z3, boolean z4, final Function0<Unit> onFirstFrameRendered, final Function1<? super VideoState, Unit> onPlayerStateChanged, Function1<? super PlaybackProgress, Unit> function1, final Function1<? super String, Unit> onError, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        boolean z5;
        boolean z6;
        int i5;
        int i6;
        int i7;
        Object rememberedValue;
        Continuation continuation;
        Composer composer2;
        Function1<? super PlaybackProgress, Unit> function12;
        int i8;
        boolean z7;
        int i9;
        Object obj;
        boolean changedInstance;
        VideoPlayerKt$VideoPlayer$1$1 rememberedValue2;
        boolean changedInstance2;
        VideoPlayerKt$VideoPlayer$2$1 rememberedValue3;
        boolean z8;
        boolean changedInstance3;
        final boolean z9;
        VideoPlayerKt$VideoPlayer$3$1 videoPlayerKt$VideoPlayer$3$1;
        boolean changedInstance4;
        Object rememberedValue4;
        boolean changedInstance5;
        Object rememberedValue5;
        boolean changedInstance6;
        Object rememberedValue6;
        boolean changedInstance7;
        Object rememberedValue7;
        Composer composer3;
        final boolean z10;
        final Function1<? super PlaybackProgress, Unit> function13;
        final Modifier modifier2;
        ScopeUpdateScope endRestartGroup;
        int i10;
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(onFirstFrameRendered, "onFirstFrameRendered");
        Intrinsics.checkNotNullParameter(onPlayerStateChanged, "onPlayerStateChanged");
        Intrinsics.checkNotNullParameter(onError, "onError");
        Composer startRestartGroup = composer.startRestartGroup(222858809);
        int i11 = i3 & 1;
        if (i11 != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = i | (startRestartGroup.changed(modifier) ? 4 : 2);
        } else {
            i4 = i;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 48) == 0) {
            i4 |= startRestartGroup.changedInstance(file) ? 32 : 16;
        }
        int i12 = i4;
        if ((i3 & 4) != 0) {
            i12 |= 384;
        } else if ((i & 384) == 0) {
            i12 |= startRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i3 & 8) != 0) {
            i12 |= 3072;
        } else if ((i & 3072) == 0) {
            i12 |= startRestartGroup.changed(j) ? 2048 : 1024;
        }
        if ((i3 & 16) != 0) {
            i12 |= 24576;
        } else if ((i & 24576) == 0) {
            i12 |= startRestartGroup.changed(z2) ? 16384 : 8192;
        }
        int i13 = i3 & 32;
        if (i13 != 0) {
            i12 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            z5 = z3;
        } else {
            z5 = z3;
            if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                i12 |= startRestartGroup.changed(z5) ? 131072 : 65536;
            }
        }
        int i14 = i3 & 64;
        if (i14 != 0) {
            i12 |= 1572864;
            z6 = z4;
        } else {
            z6 = z4;
            if ((i & 1572864) == 0) {
                i12 |= startRestartGroup.changed(z6) ? 1048576 : 524288;
            }
        }
        if ((i3 & 128) != 0) {
            i12 |= 12582912;
        } else if ((i & 12582912) == 0) {
            i12 |= startRestartGroup.changedInstance(onFirstFrameRendered) ? 8388608 : 4194304;
        }
        if ((i3 & 256) == 0) {
            i10 = (i & 100663296) == 0 ? startRestartGroup.changedInstance(onPlayerStateChanged) ? 67108864 : 33554432 : 100663296;
            i5 = i3 & 512;
            if (i5 == 0) {
                i12 |= C.ENCODING_PCM_32BIT;
            } else if ((i & C.ENCODING_PCM_32BIT) == 0) {
                i6 = i5;
                i12 |= startRestartGroup.changedInstance(function1) ? 536870912 : 268435456;
                if ((i3 & 1024) != 0) {
                    i7 = i2 | 6;
                } else if ((i2 & 6) == 0) {
                    i7 = i2 | (startRestartGroup.changedInstance(onError) ? 4 : 2);
                } else {
                    i7 = i2;
                }
                if ((i12 & 306783379) == 306783378 || (i7 & 3) != 2 || !startRestartGroup.getSkipping()) {
                    Modifier modifier3 = i11 != 0 ? Modifier.INSTANCE : modifier;
                    if (i13 != 0) {
                        z5 = false;
                    }
                    if (i14 != 0) {
                        z6 = false;
                    }
                    Function1<? super PlaybackProgress, Unit> function14 = i6 != 0 ? null : function1;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(222858809, i12, i7, "io.adn.sdk.internal.ui.common.design.compose.VideoPlayer (VideoPlayer.kt:29)");
                    }
                    ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume = startRestartGroup.consume(localContext);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    Context context = (Context) consume;
                    startRestartGroup.startReplaceableGroup(1290323761);
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                        boolean z11 = z6;
                        continuation = null;
                        Composer composer4 = startRestartGroup;
                        i8 = i12;
                        i9 = 2048;
                        SimplifiedVideoView simplifiedVideoView = new SimplifiedVideoView(context, file, z5, z11, onFirstFrameRendered, onPlayerStateChanged, function14, onError, null, 256, null);
                        z7 = z11;
                        function12 = function14;
                        simplifiedVideoView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                        composer4.updateRememberedValue(simplifiedVideoView);
                        obj = simplifiedVideoView;
                        composer2 = composer4;
                    } else {
                        continuation = null;
                        composer2 = startRestartGroup;
                        function12 = function14;
                        i8 = i12;
                        z7 = z6;
                        i9 = 2048;
                        obj = rememberedValue;
                    }
                    final SimplifiedVideoView simplifiedVideoView2 = (SimplifiedVideoView) obj;
                    composer2.endReplaceableGroup();
                    Long valueOf = Long.valueOf(j);
                    composer2.startReplaceableGroup(1290342978);
                    changedInstance = composer2.changedInstance(simplifiedVideoView2) | ((i8 & 7168) == i9);
                    rememberedValue2 = composer2.rememberedValue();
                    if (!changedInstance || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue2 = new VideoPlayerKt$VideoPlayer$1$1(simplifiedVideoView2, j, continuation);
                        composer2.updateRememberedValue(rememberedValue2);
                    }
                    composer2.endReplaceableGroup();
                    EffectsKt.LaunchedEffect(valueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue2, composer2, (i8 >> 9) & 14);
                    Boolean valueOf2 = Boolean.valueOf(z2);
                    composer2.startReplaceableGroup(1290345653);
                    changedInstance2 = composer2.changedInstance(simplifiedVideoView2) | ((57344 & i8) == 16384);
                    rememberedValue3 = composer2.rememberedValue();
                    if (!changedInstance2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        z8 = z2;
                        rememberedValue3 = new VideoPlayerKt$VideoPlayer$2$1(simplifiedVideoView2, z8, continuation);
                        composer2.updateRememberedValue(rememberedValue3);
                    } else {
                        z8 = z2;
                    }
                    composer2.endReplaceableGroup();
                    EffectsKt.LaunchedEffect(valueOf2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue3, composer2, (i8 >> 12) & 14);
                    Boolean valueOf3 = Boolean.valueOf(z);
                    composer2.startReplaceableGroup(1290348084);
                    int i15 = i8 & 896;
                    changedInstance3 = (i15 == 256) | composer2.changedInstance(simplifiedVideoView2);
                    Object rememberedValue8 = composer2.rememberedValue();
                    if (!changedInstance3 || rememberedValue8 == Composer.INSTANCE.getEmpty()) {
                        z9 = z;
                        videoPlayerKt$VideoPlayer$3$1 = new VideoPlayerKt$VideoPlayer$3$1(z9, simplifiedVideoView2, continuation);
                        composer2.updateRememberedValue(videoPlayerKt$VideoPlayer$3$1);
                    } else {
                        videoPlayerKt$VideoPlayer$3$1 = rememberedValue8;
                        z9 = z;
                    }
                    composer2.endReplaceableGroup();
                    EffectsKt.LaunchedEffect(valueOf3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) videoPlayerKt$VideoPlayer$3$1, composer2, (i8 >> 6) & 14);
                    composer2.startReplaceableGroup(1290351912);
                    changedInstance4 = composer2.changedInstance(simplifiedVideoView2) | (i15 == 256);
                    rememberedValue4 = composer2.rememberedValue();
                    if (!changedInstance4 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue4 = new Function0() { // from class: io.adn.sdk.internal.ui.common.design.compose.VideoPlayerKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit VideoPlayer$lambda$6$lambda$5;
                                VideoPlayer$lambda$6$lambda$5 = VideoPlayerKt.VideoPlayer$lambda$6$lambda$5(z9, simplifiedVideoView2);
                                return VideoPlayer$lambda$6$lambda$5;
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue4);
                    }
                    Function0 function0 = (Function0) rememberedValue4;
                    composer2.endReplaceableGroup();
                    composer2.startReplaceableGroup(1290354625);
                    changedInstance5 = composer2.changedInstance(simplifiedVideoView2);
                    rememberedValue5 = composer2.rememberedValue();
                    if (!changedInstance5 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue5 = new Function0() { // from class: io.adn.sdk.internal.ui.common.design.compose.VideoPlayerKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit VideoPlayer$lambda$8$lambda$7;
                                VideoPlayer$lambda$8$lambda$7 = VideoPlayerKt.VideoPlayer$lambda$8$lambda$7(SimplifiedVideoView.this);
                                return VideoPlayer$lambda$8$lambda$7;
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue5);
                    }
                    Function0 function02 = (Function0) rememberedValue5;
                    composer2.endReplaceableGroup();
                    composer2.startReplaceableGroup(1290356092);
                    changedInstance6 = composer2.changedInstance(simplifiedVideoView2);
                    rememberedValue6 = composer2.rememberedValue();
                    if (!changedInstance6 || rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue6 = new Function0() { // from class: io.adn.sdk.internal.ui.common.design.compose.VideoPlayerKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit VideoPlayer$lambda$10$lambda$9;
                                VideoPlayer$lambda$10$lambda$9 = VideoPlayerKt.VideoPlayer$lambda$10$lambda$9(SimplifiedVideoView.this);
                                return VideoPlayer$lambda$10$lambda$9;
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue6);
                    }
                    composer2.endReplaceableGroup();
                    BindWithLifecycleKt.ObserveLifecycle(function0, function02, (Function0) rememberedValue6, composer2, 0);
                    composer2.startReplaceableGroup(1290360921);
                    changedInstance7 = composer2.changedInstance(simplifiedVideoView2);
                    rememberedValue7 = composer2.rememberedValue();
                    if (!changedInstance7 || rememberedValue7 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue7 = new Function1() { // from class: io.adn.sdk.internal.ui.common.design.compose.VideoPlayerKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                SimplifiedVideoView VideoPlayer$lambda$12$lambda$11;
                                VideoPlayer$lambda$12$lambda$11 = VideoPlayerKt.VideoPlayer$lambda$12$lambda$11(SimplifiedVideoView.this, (Context) obj2);
                                return VideoPlayer$lambda$12$lambda$11;
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue7);
                    }
                    composer2.endReplaceableGroup();
                    Composer composer5 = composer2;
                    Modifier modifier4 = modifier3;
                    AndroidView_androidKt.AndroidView((Function1) rememberedValue7, modifier4, null, composer5, (i8 << 3) & 112, 4);
                    composer3 = composer5;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z10 = z7;
                    function13 = function12;
                    modifier2 = modifier4;
                } else {
                    startRestartGroup.skipToGroupEnd();
                    modifier2 = modifier;
                    function13 = function1;
                    composer3 = startRestartGroup;
                    z10 = z6;
                    z8 = z2;
                }
                final boolean z12 = z5;
                endRestartGroup = composer3.endRestartGroup();
                if (endRestartGroup != null) {
                    final boolean z13 = z8;
                    endRestartGroup.updateScope(new Function2() { // from class: io.adn.sdk.internal.ui.common.design.compose.VideoPlayerKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            Unit VideoPlayer$lambda$13;
                            VideoPlayer$lambda$13 = VideoPlayerKt.VideoPlayer$lambda$13(Modifier.this, file, z, j, z13, z12, z10, onFirstFrameRendered, onPlayerStateChanged, function13, onError, i, i2, i3, (Composer) obj2, ((Integer) obj3).intValue());
                            return VideoPlayer$lambda$13;
                        }
                    });
                    return;
                }
                return;
            }
            i6 = i5;
            if ((i3 & 1024) != 0) {
            }
            if ((i12 & 306783379) == 306783378) {
            }
            if (i11 != 0) {
            }
            if (i13 != 0) {
            }
            if (i14 != 0) {
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
            startRestartGroup.startReplaceableGroup(1290323761);
            rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            }
            final SimplifiedVideoView simplifiedVideoView22 = (SimplifiedVideoView) obj;
            composer2.endReplaceableGroup();
            Long valueOf4 = Long.valueOf(j);
            composer2.startReplaceableGroup(1290342978);
            changedInstance = composer2.changedInstance(simplifiedVideoView22) | ((i8 & 7168) == i9);
            rememberedValue2 = composer2.rememberedValue();
            if (!changedInstance) {
            }
            rememberedValue2 = new VideoPlayerKt$VideoPlayer$1$1(simplifiedVideoView22, j, continuation);
            composer2.updateRememberedValue(rememberedValue2);
            composer2.endReplaceableGroup();
            EffectsKt.LaunchedEffect(valueOf4, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue2, composer2, (i8 >> 9) & 14);
            Boolean valueOf22 = Boolean.valueOf(z2);
            composer2.startReplaceableGroup(1290345653);
            changedInstance2 = composer2.changedInstance(simplifiedVideoView22) | ((57344 & i8) == 16384);
            rememberedValue3 = composer2.rememberedValue();
            if (changedInstance2) {
            }
            z8 = z2;
            rememberedValue3 = new VideoPlayerKt$VideoPlayer$2$1(simplifiedVideoView22, z8, continuation);
            composer2.updateRememberedValue(rememberedValue3);
            composer2.endReplaceableGroup();
            EffectsKt.LaunchedEffect(valueOf22, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue3, composer2, (i8 >> 12) & 14);
            Boolean valueOf32 = Boolean.valueOf(z);
            composer2.startReplaceableGroup(1290348084);
            int i152 = i8 & 896;
            changedInstance3 = (i152 == 256) | composer2.changedInstance(simplifiedVideoView22);
            Object rememberedValue82 = composer2.rememberedValue();
            if (changedInstance3) {
            }
            z9 = z;
            videoPlayerKt$VideoPlayer$3$1 = new VideoPlayerKt$VideoPlayer$3$1(z9, simplifiedVideoView22, continuation);
            composer2.updateRememberedValue(videoPlayerKt$VideoPlayer$3$1);
            composer2.endReplaceableGroup();
            EffectsKt.LaunchedEffect(valueOf32, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) videoPlayerKt$VideoPlayer$3$1, composer2, (i8 >> 6) & 14);
            composer2.startReplaceableGroup(1290351912);
            changedInstance4 = composer2.changedInstance(simplifiedVideoView22) | (i152 == 256);
            rememberedValue4 = composer2.rememberedValue();
            if (!changedInstance4) {
            }
            rememberedValue4 = new Function0() { // from class: io.adn.sdk.internal.ui.common.design.compose.VideoPlayerKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit VideoPlayer$lambda$6$lambda$5;
                    VideoPlayer$lambda$6$lambda$5 = VideoPlayerKt.VideoPlayer$lambda$6$lambda$5(z9, simplifiedVideoView22);
                    return VideoPlayer$lambda$6$lambda$5;
                }
            };
            composer2.updateRememberedValue(rememberedValue4);
            Function0 function03 = (Function0) rememberedValue4;
            composer2.endReplaceableGroup();
            composer2.startReplaceableGroup(1290354625);
            changedInstance5 = composer2.changedInstance(simplifiedVideoView22);
            rememberedValue5 = composer2.rememberedValue();
            if (!changedInstance5) {
            }
            rememberedValue5 = new Function0() { // from class: io.adn.sdk.internal.ui.common.design.compose.VideoPlayerKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit VideoPlayer$lambda$8$lambda$7;
                    VideoPlayer$lambda$8$lambda$7 = VideoPlayerKt.VideoPlayer$lambda$8$lambda$7(SimplifiedVideoView.this);
                    return VideoPlayer$lambda$8$lambda$7;
                }
            };
            composer2.updateRememberedValue(rememberedValue5);
            Function0 function022 = (Function0) rememberedValue5;
            composer2.endReplaceableGroup();
            composer2.startReplaceableGroup(1290356092);
            changedInstance6 = composer2.changedInstance(simplifiedVideoView22);
            rememberedValue6 = composer2.rememberedValue();
            if (!changedInstance6) {
            }
            rememberedValue6 = new Function0() { // from class: io.adn.sdk.internal.ui.common.design.compose.VideoPlayerKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit VideoPlayer$lambda$10$lambda$9;
                    VideoPlayer$lambda$10$lambda$9 = VideoPlayerKt.VideoPlayer$lambda$10$lambda$9(SimplifiedVideoView.this);
                    return VideoPlayer$lambda$10$lambda$9;
                }
            };
            composer2.updateRememberedValue(rememberedValue6);
            composer2.endReplaceableGroup();
            BindWithLifecycleKt.ObserveLifecycle(function03, function022, (Function0) rememberedValue6, composer2, 0);
            composer2.startReplaceableGroup(1290360921);
            changedInstance7 = composer2.changedInstance(simplifiedVideoView22);
            rememberedValue7 = composer2.rememberedValue();
            if (!changedInstance7) {
            }
            rememberedValue7 = new Function1() { // from class: io.adn.sdk.internal.ui.common.design.compose.VideoPlayerKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    SimplifiedVideoView VideoPlayer$lambda$12$lambda$11;
                    VideoPlayer$lambda$12$lambda$11 = VideoPlayerKt.VideoPlayer$lambda$12$lambda$11(SimplifiedVideoView.this, (Context) obj2);
                    return VideoPlayer$lambda$12$lambda$11;
                }
            };
            composer2.updateRememberedValue(rememberedValue7);
            composer2.endReplaceableGroup();
            Composer composer52 = composer2;
            Modifier modifier42 = modifier3;
            AndroidView_androidKt.AndroidView((Function1) rememberedValue7, modifier42, null, composer52, (i8 << 3) & 112, 4);
            composer3 = composer52;
            if (ComposerKt.isTraceInProgress()) {
            }
            z10 = z7;
            function13 = function12;
            modifier2 = modifier42;
            final boolean z122 = z5;
            endRestartGroup = composer3.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        i12 |= i10;
        i5 = i3 & 512;
        if (i5 == 0) {
        }
        i6 = i5;
        if ((i3 & 1024) != 0) {
        }
        if ((i12 & 306783379) == 306783378) {
        }
        if (i11 != 0) {
        }
        if (i13 != 0) {
        }
        if (i14 != 0) {
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
        startRestartGroup.startReplaceableGroup(1290323761);
        rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
        }
        final SimplifiedVideoView simplifiedVideoView222 = (SimplifiedVideoView) obj;
        composer2.endReplaceableGroup();
        Long valueOf42 = Long.valueOf(j);
        composer2.startReplaceableGroup(1290342978);
        changedInstance = composer2.changedInstance(simplifiedVideoView222) | ((i8 & 7168) == i9);
        rememberedValue2 = composer2.rememberedValue();
        if (!changedInstance) {
        }
        rememberedValue2 = new VideoPlayerKt$VideoPlayer$1$1(simplifiedVideoView222, j, continuation);
        composer2.updateRememberedValue(rememberedValue2);
        composer2.endReplaceableGroup();
        EffectsKt.LaunchedEffect(valueOf42, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue2, composer2, (i8 >> 9) & 14);
        Boolean valueOf222 = Boolean.valueOf(z2);
        composer2.startReplaceableGroup(1290345653);
        changedInstance2 = composer2.changedInstance(simplifiedVideoView222) | ((57344 & i8) == 16384);
        rememberedValue3 = composer2.rememberedValue();
        if (changedInstance2) {
        }
        z8 = z2;
        rememberedValue3 = new VideoPlayerKt$VideoPlayer$2$1(simplifiedVideoView222, z8, continuation);
        composer2.updateRememberedValue(rememberedValue3);
        composer2.endReplaceableGroup();
        EffectsKt.LaunchedEffect(valueOf222, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue3, composer2, (i8 >> 12) & 14);
        Boolean valueOf322 = Boolean.valueOf(z);
        composer2.startReplaceableGroup(1290348084);
        int i1522 = i8 & 896;
        changedInstance3 = (i1522 == 256) | composer2.changedInstance(simplifiedVideoView222);
        Object rememberedValue822 = composer2.rememberedValue();
        if (changedInstance3) {
        }
        z9 = z;
        videoPlayerKt$VideoPlayer$3$1 = new VideoPlayerKt$VideoPlayer$3$1(z9, simplifiedVideoView222, continuation);
        composer2.updateRememberedValue(videoPlayerKt$VideoPlayer$3$1);
        composer2.endReplaceableGroup();
        EffectsKt.LaunchedEffect(valueOf322, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) videoPlayerKt$VideoPlayer$3$1, composer2, (i8 >> 6) & 14);
        composer2.startReplaceableGroup(1290351912);
        changedInstance4 = composer2.changedInstance(simplifiedVideoView222) | (i1522 == 256);
        rememberedValue4 = composer2.rememberedValue();
        if (!changedInstance4) {
        }
        rememberedValue4 = new Function0() { // from class: io.adn.sdk.internal.ui.common.design.compose.VideoPlayerKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit VideoPlayer$lambda$6$lambda$5;
                VideoPlayer$lambda$6$lambda$5 = VideoPlayerKt.VideoPlayer$lambda$6$lambda$5(z9, simplifiedVideoView222);
                return VideoPlayer$lambda$6$lambda$5;
            }
        };
        composer2.updateRememberedValue(rememberedValue4);
        Function0 function032 = (Function0) rememberedValue4;
        composer2.endReplaceableGroup();
        composer2.startReplaceableGroup(1290354625);
        changedInstance5 = composer2.changedInstance(simplifiedVideoView222);
        rememberedValue5 = composer2.rememberedValue();
        if (!changedInstance5) {
        }
        rememberedValue5 = new Function0() { // from class: io.adn.sdk.internal.ui.common.design.compose.VideoPlayerKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit VideoPlayer$lambda$8$lambda$7;
                VideoPlayer$lambda$8$lambda$7 = VideoPlayerKt.VideoPlayer$lambda$8$lambda$7(SimplifiedVideoView.this);
                return VideoPlayer$lambda$8$lambda$7;
            }
        };
        composer2.updateRememberedValue(rememberedValue5);
        Function0 function0222 = (Function0) rememberedValue5;
        composer2.endReplaceableGroup();
        composer2.startReplaceableGroup(1290356092);
        changedInstance6 = composer2.changedInstance(simplifiedVideoView222);
        rememberedValue6 = composer2.rememberedValue();
        if (!changedInstance6) {
        }
        rememberedValue6 = new Function0() { // from class: io.adn.sdk.internal.ui.common.design.compose.VideoPlayerKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit VideoPlayer$lambda$10$lambda$9;
                VideoPlayer$lambda$10$lambda$9 = VideoPlayerKt.VideoPlayer$lambda$10$lambda$9(SimplifiedVideoView.this);
                return VideoPlayer$lambda$10$lambda$9;
            }
        };
        composer2.updateRememberedValue(rememberedValue6);
        composer2.endReplaceableGroup();
        BindWithLifecycleKt.ObserveLifecycle(function032, function0222, (Function0) rememberedValue6, composer2, 0);
        composer2.startReplaceableGroup(1290360921);
        changedInstance7 = composer2.changedInstance(simplifiedVideoView222);
        rememberedValue7 = composer2.rememberedValue();
        if (!changedInstance7) {
        }
        rememberedValue7 = new Function1() { // from class: io.adn.sdk.internal.ui.common.design.compose.VideoPlayerKt$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                SimplifiedVideoView VideoPlayer$lambda$12$lambda$11;
                VideoPlayer$lambda$12$lambda$11 = VideoPlayerKt.VideoPlayer$lambda$12$lambda$11(SimplifiedVideoView.this, (Context) obj2);
                return VideoPlayer$lambda$12$lambda$11;
            }
        };
        composer2.updateRememberedValue(rememberedValue7);
        composer2.endReplaceableGroup();
        Composer composer522 = composer2;
        Modifier modifier422 = modifier3;
        AndroidView_androidKt.AndroidView((Function1) rememberedValue7, modifier422, null, composer522, (i8 << 3) & 112, 4);
        composer3 = composer522;
        if (ComposerKt.isTraceInProgress()) {
        }
        z10 = z7;
        function13 = function12;
        modifier2 = modifier422;
        final boolean z1222 = z5;
        endRestartGroup = composer3.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VideoPlayer$lambda$6$lambda$5(boolean z, SimplifiedVideoView simplifiedVideoView) {
        if (z) {
            simplifiedVideoView.play();
        } else {
            simplifiedVideoView.pause();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VideoPlayer$lambda$8$lambda$7(SimplifiedVideoView simplifiedVideoView) {
        simplifiedVideoView.pause();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VideoPlayer$lambda$10$lambda$9(SimplifiedVideoView simplifiedVideoView) {
        simplifiedVideoView.pause();
        simplifiedVideoView.releasePlayer();
        return Unit.INSTANCE;
    }
}
