package io.adn.sdk.internal.ui.common.design.compose;

import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.res.PainterResources_androidKt;
import io.adn.sdk.R;
import io.ktor.http.ContentDisposition;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PlayButton.kt */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aa\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u0003H\u0001¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"PlayButton", "", "isEnabled", "", "isPlaying", "onPlayStateChange", "Lkotlin/Function1;", ContentDisposition.Parameters.Size, "Landroidx/compose/ui/unit/DpSize;", "color", "Landroidx/compose/ui/graphics/Color;", "pauseIcon", "Landroidx/compose/ui/graphics/painter/Painter;", "playIcon", "useDefaultBackground", "PlayButton-rjX7Trg", "(ZZLkotlin/jvm/functions/Function1;JJLandroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/graphics/painter/Painter;ZLandroidx/compose/runtime/Composer;II)V", "adn-sdk_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class PlayButtonKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PlayButton_rjX7Trg$lambda$0(boolean z, boolean z2, Function1 function1, long j, long j2, Painter painter, Painter painter2, boolean z3, int i, int i2, Composer composer, int i3) {
        m9529PlayButtonrjX7Trg(z, z2, function1, j, j2, painter, painter2, z3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x006b  */
    /* renamed from: PlayButton-rjX7Trg, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m9529PlayButtonrjX7Trg(final boolean z, final boolean z2, final Function1<? super Boolean, Unit> onPlayStateChange, final long j, final long j2, Painter painter, Painter painter2, boolean z3, Composer composer, final int i, final int i2) {
        boolean z4;
        int i3;
        boolean z5;
        long j3;
        long j4;
        Painter painter3;
        Painter painter4;
        int i4;
        boolean z6;
        int i5;
        Painter painter5;
        boolean z7;
        Composer composer2;
        final Painter painter6;
        final Painter painter7;
        ScopeUpdateScope endRestartGroup;
        int i6;
        int i7;
        Intrinsics.checkNotNullParameter(onPlayStateChange, "onPlayStateChange");
        Composer startRestartGroup = composer.startRestartGroup(-560098686);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            z4 = z;
        } else {
            z4 = z;
            if ((i & 6) == 0) {
                i3 = (startRestartGroup.changed(z4) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            z5 = z2;
            i3 |= startRestartGroup.changed(z5) ? 32 : 16;
            if ((i2 & 4) == 0) {
                i3 |= 384;
            } else if ((i & 384) == 0) {
                i3 |= startRestartGroup.changedInstance(onPlayStateChange) ? 256 : 128;
            }
            if ((i2 & 8) == 0) {
                i3 |= 3072;
                j3 = j;
            } else {
                j3 = j;
                if ((i & 3072) == 0) {
                    i3 |= startRestartGroup.changed(j3) ? 2048 : 1024;
                }
            }
            if ((i2 & 16) == 0) {
                i3 |= 24576;
                j4 = j2;
            } else {
                j4 = j2;
                if ((i & 24576) == 0) {
                    i3 |= startRestartGroup.changed(j4) ? 16384 : 8192;
                }
            }
            if ((196608 & i) != 0) {
                if ((i2 & 32) == 0) {
                    painter3 = painter;
                    if (startRestartGroup.changedInstance(painter3)) {
                        i7 = 131072;
                        i3 |= i7;
                    }
                } else {
                    painter3 = painter;
                }
                i7 = 65536;
                i3 |= i7;
            } else {
                painter3 = painter;
            }
            if ((1572864 & i) != 0) {
                if ((i2 & 64) == 0) {
                    painter4 = painter2;
                    if (startRestartGroup.changedInstance(painter4)) {
                        i6 = 1048576;
                        i3 |= i6;
                    }
                } else {
                    painter4 = painter2;
                }
                i6 = 524288;
                i3 |= i6;
            } else {
                painter4 = painter2;
            }
            i4 = i2 & 128;
            if (i4 == 0) {
                i3 |= 12582912;
            } else if ((12582912 & i) == 0) {
                z6 = z3;
                i3 |= startRestartGroup.changed(z6) ? 8388608 : 4194304;
                int i8 = i3;
                if ((i3 & 4793491) == 4793490 || !startRestartGroup.getSkipping()) {
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                        if ((i2 & 32) != 0) {
                            painter3 = PainterResources_androidKt.painterResource(R.drawable.adn_ic_pause, startRestartGroup, 0);
                            i5 = i8 & (-458753);
                        } else {
                            i5 = i8;
                        }
                        if ((i2 & 64) != 0) {
                            i5 &= -3670017;
                            painter4 = PainterResources_androidKt.painterResource(R.drawable.adn_ic_play, startRestartGroup, 0);
                        }
                        if (i4 != 0) {
                            painter5 = painter4;
                            z7 = true;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-560098686, i5, -1, "io.adn.sdk.internal.ui.common.design.compose.PlayButton (PlayButton.kt:20)");
                            }
                            boolean z8 = z5;
                            Painter painter8 = painter3;
                            Painter painter9 = painter5;
                            z6 = z7;
                            composer2 = startRestartGroup;
                            AnimatedVisibilityKt.AnimatedVisibility(true, (Modifier) null, (EnterTransition) null, (ExitTransition) null, (String) null, (Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(startRestartGroup, 22308010, true, new PlayButtonKt$PlayButton$1(z8, painter8, painter5, z4, onPlayStateChange, j4, j3, z7)), composer2, 196614, 30);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            painter6 = painter8;
                            painter7 = painter9;
                        }
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        i5 = (i2 & 32) != 0 ? i8 & (-458753) : i8;
                        if ((i2 & 64) != 0) {
                            i5 &= -3670017;
                        }
                    }
                    painter5 = painter4;
                    z7 = z6;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    boolean z82 = z5;
                    Painter painter82 = painter3;
                    Painter painter92 = painter5;
                    z6 = z7;
                    composer2 = startRestartGroup;
                    AnimatedVisibilityKt.AnimatedVisibility(true, (Modifier) null, (EnterTransition) null, (ExitTransition) null, (String) null, (Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(startRestartGroup, 22308010, true, new PlayButtonKt$PlayButton$1(z82, painter82, painter5, z4, onPlayStateChange, j4, j3, z7)), composer2, 196614, 30);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    painter6 = painter82;
                    painter7 = painter92;
                } else {
                    startRestartGroup.skipToGroupEnd();
                    painter6 = painter3;
                    painter7 = painter4;
                    composer2 = startRestartGroup;
                }
                final boolean z9 = z6;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2() { // from class: io.adn.sdk.internal.ui.common.design.compose.PlayButtonKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit PlayButton_rjX7Trg$lambda$0;
                            PlayButton_rjX7Trg$lambda$0 = PlayButtonKt.PlayButton_rjX7Trg$lambda$0(z, z2, onPlayStateChange, j, j2, painter6, painter7, z9, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            return PlayButton_rjX7Trg$lambda$0;
                        }
                    });
                    return;
                }
                return;
            }
            z6 = z3;
            int i82 = i3;
            if ((i3 & 4793491) == 4793490) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if ((i2 & 32) != 0) {
            }
            if ((i2 & 64) != 0) {
            }
            if (i4 != 0) {
            }
            painter5 = painter4;
            z7 = z6;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            boolean z822 = z5;
            Painter painter822 = painter3;
            Painter painter922 = painter5;
            z6 = z7;
            composer2 = startRestartGroup;
            AnimatedVisibilityKt.AnimatedVisibility(true, (Modifier) null, (EnterTransition) null, (ExitTransition) null, (String) null, (Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(startRestartGroup, 22308010, true, new PlayButtonKt$PlayButton$1(z822, painter822, painter5, z4, onPlayStateChange, j4, j3, z7)), composer2, 196614, 30);
            if (ComposerKt.isTraceInProgress()) {
            }
            painter6 = painter822;
            painter7 = painter922;
            final boolean z92 = z6;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        z5 = z2;
        if ((i2 & 4) == 0) {
        }
        if ((i2 & 8) == 0) {
        }
        if ((i2 & 16) == 0) {
        }
        if ((196608 & i) != 0) {
        }
        if ((1572864 & i) != 0) {
        }
        i4 = i2 & 128;
        if (i4 == 0) {
        }
        z6 = z3;
        int i822 = i3;
        if ((i3 & 4793491) == 4793490) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if ((i2 & 32) != 0) {
        }
        if ((i2 & 64) != 0) {
        }
        if (i4 != 0) {
        }
        painter5 = painter4;
        z7 = z6;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        boolean z8222 = z5;
        Painter painter8222 = painter3;
        Painter painter9222 = painter5;
        z6 = z7;
        composer2 = startRestartGroup;
        AnimatedVisibilityKt.AnimatedVisibility(true, (Modifier) null, (EnterTransition) null, (ExitTransition) null, (String) null, (Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(startRestartGroup, 22308010, true, new PlayButtonKt$PlayButton$1(z8222, painter8222, painter5, z4, onPlayStateChange, j4, j3, z7)), composer2, 196614, 30);
        if (ComposerKt.isTraceInProgress()) {
        }
        painter6 = painter8222;
        painter7 = painter9222;
        final boolean z922 = z6;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }
}
