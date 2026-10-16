package io.adn.sdk.internal.ui.common.design.compose;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.ProgressIndicatorDefaults;
import androidx.compose.material3.ProgressIndicatorKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.DpSize;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.core.app.NotificationCompat;
import androidx.profileinstaller.ProfileVerifier;
import com.google.android.exoplayer2.C;
import io.adn.sdk.R;
import io.adn.sdk.internal.domain.model.ad.AdCloseConfig;
import io.adn.sdk.internal.domain.model.ui.CloseButtonType;
import io.adn.sdk.internal.ui.common.lifecycle.LifecycleCountdownKt;
import io.adn.sdk.internal.ui.common.lifecycle.LifecycleCountdownState;
import io.adn.sdk.internal.ui.utils.ComposeKt;
import io.adn.sdk.internal.ui.utils.UIConstants;
import io.ktor.http.ContentDisposition;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CloseButton.kt */
@Metadata(d1 = {"\u0000^\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0010\u001aQ\u0010\u0000\u001a\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\tH\u0001¢\u0006\u0002\u0010\r\u001a{\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000b2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00172\b\b\u0002\u0010\u001b\u001a\u00020\u00172\b\b\u0002\u0010\u001c\u001a\u00020\u001dH\u0001¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u001d\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020!H\u0003¢\u0006\u0002\u0010$\u001aS\u0010%\u001a\u00020\u00032\u0006\u0010&\u001a\u00020!2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001d2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\tH\u0003¢\u0006\u0004\b'\u0010(\u001ac\u0010)\u001a\u00020\u00032\u0006\u0010*\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001d2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\tH\u0003¢\u0006\u0004\b+\u0010,\u001aS\u0010-\u001a\u00020\u00032\u0006\u0010&\u001a\u00020!2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0012\u001a\u00020\u00132\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\tH\u0003¢\u0006\u0004\b.\u0010/¨\u00060²\u0006\n\u00101\u001a\u00020\u0013X\u008a\u0084\u0002"}, d2 = {"closeButton", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/BoxScope;", "", "Lkotlin/ExtensionFunctionType;", "Landroidx/compose/runtime/Composable;", "config", "Lio/adn/sdk/internal/domain/model/ad/AdCloseConfig;", "onClick", "Lkotlin/Function0;", "iconResId", "", "onOutsideClick", "(Lio/adn/sdk/internal/domain/model/ad/AdCloseConfig;Lkotlin/jvm/functions/Function0;ILkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Lkotlin/jvm/functions/Function3;", "CloseButton", "type", "Lio/adn/sdk/internal/domain/model/ui/CloseButtonType;", "delay", "clickableSizeRatio", "", "modifier", "Landroidx/compose/ui/Modifier;", "color", "Landroidx/compose/ui/graphics/Color;", ContentDisposition.Parameters.Size, "Landroidx/compose/ui/unit/DpSize;", "disabledColor", "progressColor", "icon", "Landroidx/compose/ui/graphics/painter/Painter;", "CloseButton-QjtC1ps", "(Lio/adn/sdk/internal/domain/model/ui/CloseButtonType;ILkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;FLandroidx/compose/ui/Modifier;JJJJLandroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/runtime/Composer;III)V", "countdownTimeLeft", "", "initialTime", "timeInterval", "(JJLandroidx/compose/runtime/Composer;I)J", "CloseTextButton", "timeLeftMillis", "CloseTextButton-Q4MTOb0", "(JJJFLandroidx/compose/ui/graphics/painter/Painter;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "ProgressCloseButton", NotificationCompat.CATEGORY_PROGRESS, "ProgressCloseButton-CvmUFeM", "(FJJJJFLandroidx/compose/ui/graphics/painter/Painter;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "InvisibleCloseButton", "InvisibleCloseButton-Q2Kma20", "(JLandroidx/compose/ui/graphics/painter/Painter;JJFLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "adn-sdk_release", "animatedProgress"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class CloseButtonKt {

    /* compiled from: CloseButton.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CloseButtonType.values().length];
            try {
                iArr[CloseButtonType.CountdownWithClose.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CloseButtonType.ProgressbarWithClose.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CloseButtonType.SimpleCross.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CloseButton_QjtC1ps$lambda$1(CloseButtonType closeButtonType, int i, Function0 function0, Function0 function02, float f, Modifier modifier, long j, long j2, long j3, long j4, Painter painter, int i2, int i3, int i4, Composer composer, int i5) {
        m9519CloseButtonQjtC1ps(closeButtonType, i, function0, function02, f, modifier, j, j2, j3, j4, painter, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3), i4);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CloseTextButton_Q4MTOb0$lambda$3(long j, long j2, long j3, float f, Painter painter, Function0 function0, Function0 function02, int i, Composer composer, int i2) {
        m9520CloseTextButtonQ4MTOb0(j, j2, j3, f, painter, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InvisibleCloseButton_Q2Kma20$lambda$9(long j, Painter painter, long j2, long j3, float f, Function0 function0, Function0 function02, int i, Composer composer, int i2) {
        m9521InvisibleCloseButtonQ2Kma20(j, painter, j2, j3, f, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProgressCloseButton_CvmUFeM$lambda$8(float f, long j, long j2, long j3, long j4, float f2, Painter painter, Function0 function0, Function0 function02, int i, Composer composer, int i2) {
        m9522ProgressCloseButtonCvmUFeM(f, j, j2, j3, j4, f2, painter, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final Function3<BoxScope, Composer, Integer, Unit> closeButton(final AdCloseConfig config, final Function0<Unit> onClick, final int i, final Function0<Unit> onOutsideClick, Composer composer, int i2, int i3) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(onOutsideClick, "onOutsideClick");
        composer.startReplaceableGroup(-1020865933);
        if ((i3 & 4) != 0) {
            i = R.drawable.adn_ic_close;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1020865933, i2, -1, "io.adn.sdk.internal.ui.common.design.compose.closeButton (CloseButton.kt:39)");
        }
        ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer, -2086216423, true, new Function3<BoxScope, Composer, Integer, Unit>() { // from class: io.adn.sdk.internal.ui.common.design.compose.CloseButtonKt$closeButton$1
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(BoxScope boxScope, Composer composer2, Integer num) {
                invoke(boxScope, composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(BoxScope boxScope, Composer composer2, int i4) {
                int i5;
                Intrinsics.checkNotNullParameter(boxScope, "<this>");
                if ((i4 & 6) == 0) {
                    i5 = i4 | (composer2.changed(boxScope) ? 4 : 2);
                } else {
                    i5 = i4;
                }
                if ((i5 & 19) != 18 || !composer2.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2086216423, i5, -1, "io.adn.sdk.internal.ui.common.design.compose.closeButton.<anonymous> (CloseButton.kt:40)");
                    }
                    CloseButtonType type = AdCloseConfig.this.getType();
                    int delay = AdCloseConfig.this.getDelay();
                    Modifier padding = PaddingKt.padding(boxScope.align(Modifier.INSTANCE, ComposeKt.toAlignment(AdCloseConfig.this.getPosition())), UIConstants.INSTANCE.getICON_BUTTON_PADDING$adn_sdk_release());
                    long dpSize = ComposeKt.toDpSize(AdCloseConfig.this.getSize());
                    CloseButtonKt.m9519CloseButtonQjtC1ps(type, delay, onClick, onOutsideClick, AdCloseConfig.this.getClickableRatio(), padding, ComposeKt.toColor(AdCloseConfig.this.getColor()), dpSize, 0L, 0L, PainterResources_androidKt.painterResource(i, composer2, 0), composer2, 0, 0, 768);
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

    /* JADX WARN: Removed duplicated region for block: B:103:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x03ff  */
    /* JADX WARN: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x02be  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x03ee  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x038c  */
    /* renamed from: CloseButton-QjtC1ps, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m9519CloseButtonQjtC1ps(final CloseButtonType type, final int i, final Function0<Unit> onClick, final Function0<Unit> onOutsideClick, float f, final Modifier modifier, final long j, final long j2, long j3, long j4, Painter painter, Composer composer, final int i2, final int i3, final int i4) {
        int i5;
        float f2;
        int i6;
        int i7;
        long j5;
        int i8;
        int i9;
        long j6;
        int i10;
        int i11;
        int i12;
        float f3;
        Painter painter2;
        int i13;
        long j7;
        long j8;
        int currentCompositeKeyHash;
        Composer m3593constructorimpl;
        int i14;
        long j9;
        long countdownTimeLeft;
        final Painter painter3;
        Composer composer2;
        final long j10;
        final long j11;
        ScopeUpdateScope endRestartGroup;
        int i15;
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(onOutsideClick, "onOutsideClick");
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Composer startRestartGroup = composer.startRestartGroup(-834035170);
        if ((i4 & 1) != 0) {
            i5 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i5 = (startRestartGroup.changed(type) ? 4 : 2) | i2;
        } else {
            i5 = i2;
        }
        if ((i4 & 2) != 0) {
            i5 |= 48;
        } else if ((i2 & 48) == 0) {
            i5 |= startRestartGroup.changed(i) ? 32 : 16;
        }
        if ((i4 & 4) != 0) {
            i5 |= 384;
        } else if ((i2 & 384) == 0) {
            i5 |= startRestartGroup.changedInstance(onClick) ? 256 : 128;
        }
        if ((i4 & 8) != 0) {
            i5 |= 3072;
        } else if ((i2 & 3072) == 0) {
            i5 |= startRestartGroup.changedInstance(onOutsideClick) ? 2048 : 1024;
        }
        int i16 = i4 & 16;
        if (i16 != 0) {
            i5 |= 24576;
        } else if ((i2 & 24576) == 0) {
            f2 = f;
            i5 |= startRestartGroup.changed(f2) ? 16384 : 8192;
            if ((i4 & 32) == 0) {
                i6 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else {
                if ((196608 & i2) == 0) {
                    i6 = startRestartGroup.changed(modifier) ? 131072 : 65536;
                }
                if ((i4 & 64) != 0) {
                    i7 = i5 | 1572864;
                } else {
                    int i17 = i5;
                    if ((1572864 & i2) == 0) {
                        i7 = i17 | (startRestartGroup.changed(j) ? 1048576 : 524288);
                    } else {
                        i7 = i17;
                    }
                }
                if ((i4 & 128) != 0) {
                    i7 |= 12582912;
                    j5 = j2;
                } else {
                    j5 = j2;
                    if ((12582912 & i2) == 0) {
                        i7 |= startRestartGroup.changed(j5) ? 8388608 : 4194304;
                    }
                }
                i8 = i4 & 256;
                if (i8 != 0) {
                    i7 |= 100663296;
                    i9 = i16;
                    j6 = j3;
                } else {
                    i9 = i16;
                    j6 = j3;
                    if ((i2 & 100663296) == 0) {
                        i7 |= startRestartGroup.changed(j6) ? 67108864 : 33554432;
                    }
                }
                i10 = i4 & 512;
                if (i10 != 0) {
                    i7 |= C.ENCODING_PCM_32BIT;
                } else if ((i2 & C.ENCODING_PCM_32BIT) == 0) {
                    i11 = i10;
                    i7 |= startRestartGroup.changed(j4) ? 536870912 : 268435456;
                    if ((i3 & 6) != 0) {
                        if ((i4 & 1024) == 0 && startRestartGroup.changedInstance(painter)) {
                            i15 = 4;
                            i12 = i3 | i15;
                        }
                        i15 = 2;
                        i12 = i3 | i15;
                    } else {
                        i12 = i3;
                    }
                    int i18 = i12;
                    if ((i7 & 306783379) == 306783378 || (i18 & 3) != 2 || !startRestartGroup.getSkipping()) {
                        startRestartGroup.startDefaults();
                        if ((i2 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                            float f4 = i9 == 0 ? 1.0f : f2;
                            long m9597getICON_BUTTON_COLOR_DISABLED0d7_KjU$adn_sdk_release = i8 == 0 ? UIConstants.INSTANCE.m9597getICON_BUTTON_COLOR_DISABLED0d7_KjU$adn_sdk_release() : j6;
                            long m9594getCOUNTDOWN_PROGRESS_COLOR0d7_KjU$adn_sdk_release = i11 == 0 ? UIConstants.INSTANCE.m9594getCOUNTDOWN_PROGRESS_COLOR0d7_KjU$adn_sdk_release() : j4;
                            if ((i4 & 1024) == 0) {
                                f3 = f4;
                                i13 = i18 & (-15);
                                painter2 = PainterResources_androidKt.painterResource(R.drawable.adn_ic_close, startRestartGroup, 0);
                            } else {
                                f3 = f4;
                                painter2 = painter;
                                i13 = i18;
                            }
                            j7 = m9597getICON_BUTTON_COLOR_DISABLED0d7_KjU$adn_sdk_release;
                            j8 = m9594getCOUNTDOWN_PROGRESS_COLOR0d7_KjU$adn_sdk_release;
                            f2 = f3;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            if ((i4 & 1024) != 0) {
                                j8 = j4;
                                painter2 = painter;
                                i13 = i18 & (-15);
                            } else {
                                j8 = j4;
                                painter2 = painter;
                                i13 = i18;
                            }
                            j7 = j6;
                        }
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-834035170, i7, i13, "io.adn.sdk.internal.ui.common.design.compose.CloseButton (CloseButton.kt:68)");
                        }
                        int i19 = i7 >> 15;
                        startRestartGroup.startReplaceableGroup(733328855);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
                        startRestartGroup.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                        long j12 = j7;
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier);
                        if (!(startRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        startRestartGroup.startReusableNode();
                        if (!startRestartGroup.getInserting()) {
                            startRestartGroup.createNode(constructor);
                        } else {
                            startRestartGroup.useNode();
                        }
                        m3593constructorimpl = Updater.m3593constructorimpl(startRestartGroup);
                        Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (!m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
                        startRestartGroup.startReplaceableGroup(2058660585);
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        long j13 = i * 1000;
                        i14 = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
                        if (i14 != 1) {
                            j9 = j8;
                            startRestartGroup.startReplaceableGroup(-570567629);
                            startRestartGroup.startReplaceableGroup(-1680972735);
                            countdownTimeLeft = j13 > 0 ? countdownTimeLeft(j13, 1000L, startRestartGroup, 48) : 0L;
                            startRestartGroup.endReplaceableGroup();
                            int i20 = (i19 & 1008) | ((i7 >> 3) & 7168) | ((i13 << 12) & 57344);
                            int i21 = i7 << 9;
                            Painter painter4 = painter2;
                            m9520CloseTextButtonQ4MTOb0(countdownTimeLeft, j, j2, f2, painter4, onClick, onOutsideClick, startRestartGroup, i20 | (i21 & 458752) | (i21 & 3670016));
                            painter2 = painter4;
                            startRestartGroup.endReplaceableGroup();
                        } else if (i14 == 2) {
                            startRestartGroup.startReplaceableGroup(-570043264);
                            startRestartGroup.startReplaceableGroup(-1680955920);
                            float countdownTimeLeft2 = j13 > 0 ? countdownTimeLeft(j13, 200L, startRestartGroup, 48) / j13 : 0.0f;
                            startRestartGroup.endReplaceableGroup();
                            int i22 = i7 >> 18;
                            int i23 = (i19 & 112) | (i22 & 896) | (i22 & 7168) | ((i7 >> 9) & 57344) | ((i7 << 3) & 458752) | ((i13 << 18) & 3670016);
                            int i24 = i7 << 15;
                            float f5 = f2;
                            long j14 = j8;
                            Painter painter5 = painter2;
                            m9522ProgressCloseButtonCvmUFeM(countdownTimeLeft2, j, j12, j14, j2, f5, painter5, onClick, onOutsideClick, startRestartGroup, i23 | (29360128 & i24) | (i24 & 234881024));
                            j9 = j14;
                            f2 = f5;
                            painter2 = painter5;
                            startRestartGroup = startRestartGroup;
                            startRestartGroup.endReplaceableGroup();
                        } else {
                            if (i14 != 3) {
                                startRestartGroup.startReplaceableGroup(-1680974206);
                                startRestartGroup.endReplaceableGroup();
                                throw new NoWhenBranchMatchedException();
                            }
                            startRestartGroup.startReplaceableGroup(-569420722);
                            startRestartGroup.startReplaceableGroup(-1680935743);
                            countdownTimeLeft = j13 > 0 ? countdownTimeLeft(j13, 1000L, startRestartGroup, 48) : 0L;
                            startRestartGroup.endReplaceableGroup();
                            int i25 = i7 >> 12;
                            int i26 = ((i13 << 3) & 112) | (i25 & 896) | (i25 & 7168) | (i7 & 57344);
                            int i27 = i7 << 9;
                            long j15 = j5;
                            float f6 = f2;
                            m9521InvisibleCloseButtonQ2Kma20(countdownTimeLeft, painter2, j, j15, f6, onClick, onOutsideClick, startRestartGroup, i26 | (i27 & 458752) | (i27 & 3670016));
                            f2 = f6;
                            startRestartGroup.endReplaceableGroup();
                            j9 = j8;
                        }
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        startRestartGroup.endReplaceableGroup();
                        startRestartGroup.endNode();
                        startRestartGroup.endReplaceableGroup();
                        startRestartGroup.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        painter3 = painter2;
                        composer2 = startRestartGroup;
                        j10 = j12;
                        j11 = j9;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        painter3 = painter;
                        j10 = j6;
                        composer2 = startRestartGroup;
                        j11 = j4;
                    }
                    final float f7 = f2;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                        endRestartGroup.updateScope(new Function2() { // from class: io.adn.sdk.internal.ui.common.design.compose.CloseButtonKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                Unit CloseButton_QjtC1ps$lambda$1;
                                CloseButton_QjtC1ps$lambda$1 = CloseButtonKt.CloseButton_QjtC1ps$lambda$1(CloseButtonType.this, i, onClick, onOutsideClick, f7, modifier, j, j2, j10, j11, painter3, i2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                                return CloseButton_QjtC1ps$lambda$1;
                            }
                        });
                        return;
                    }
                    return;
                }
                i11 = i10;
                if ((i3 & 6) != 0) {
                }
                int i182 = i12;
                if ((i7 & 306783379) == 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                }
                if (i9 == 0) {
                }
                if (i8 == 0) {
                }
                if (i11 == 0) {
                }
                if ((i4 & 1024) == 0) {
                }
                j7 = m9597getICON_BUTTON_COLOR_DISABLED0d7_KjU$adn_sdk_release;
                j8 = m9594getCOUNTDOWN_PROGRESS_COLOR0d7_KjU$adn_sdk_release;
                f2 = f3;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                int i192 = i7 >> 15;
                startRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                long j122 = j7;
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(modifier);
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                }
                startRestartGroup.startReusableNode();
                if (!startRestartGroup.getInserting()) {
                }
                m3593constructorimpl = Updater.m3593constructorimpl(startRestartGroup);
                Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!m3593constructorimpl.getInserting()) {
                }
                m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash2);
                modifierMaterializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(2058660585);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                long j132 = i * 1000;
                i14 = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
                if (i14 != 1) {
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endNode();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                }
                painter3 = painter2;
                composer2 = startRestartGroup;
                j10 = j122;
                j11 = j9;
                final float f72 = f2;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            i5 |= i6;
            if ((i4 & 64) != 0) {
            }
            if ((i4 & 128) != 0) {
            }
            i8 = i4 & 256;
            if (i8 != 0) {
            }
            i10 = i4 & 512;
            if (i10 != 0) {
            }
            i11 = i10;
            if ((i3 & 6) != 0) {
            }
            int i1822 = i12;
            if ((i7 & 306783379) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i2 & 1) != 0) {
            }
            if (i9 == 0) {
            }
            if (i8 == 0) {
            }
            if (i11 == 0) {
            }
            if ((i4 & 1024) == 0) {
            }
            j7 = m9597getICON_BUTTON_COLOR_DISABLED0d7_KjU$adn_sdk_release;
            j8 = m9594getCOUNTDOWN_PROGRESS_COLOR0d7_KjU$adn_sdk_release;
            f2 = f3;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            int i1922 = i7 >> 15;
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy22 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap22 = startRestartGroup.getCurrentCompositionLocalMap();
            long j1222 = j7;
            Function0<ComposeUiNode> constructor22 = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf22 = LayoutKt.modifierMaterializerOf(modifier);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
            }
            startRestartGroup.startReusableNode();
            if (!startRestartGroup.getInserting()) {
            }
            m3593constructorimpl = Updater.m3593constructorimpl(startRestartGroup);
            Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy22, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap22, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash22 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!m3593constructorimpl.getInserting()) {
            }
            m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash22);
            modifierMaterializerOf22.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance22 = BoxScopeInstance.INSTANCE;
            long j1322 = i * 1000;
            i14 = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
            if (i14 != 1) {
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
            }
            painter3 = painter2;
            composer2 = startRestartGroup;
            j10 = j1222;
            j11 = j9;
            final float f722 = f2;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        f2 = f;
        if ((i4 & 32) == 0) {
        }
        i5 |= i6;
        if ((i4 & 64) != 0) {
        }
        if ((i4 & 128) != 0) {
        }
        i8 = i4 & 256;
        if (i8 != 0) {
        }
        i10 = i4 & 512;
        if (i10 != 0) {
        }
        i11 = i10;
        if ((i3 & 6) != 0) {
        }
        int i18222 = i12;
        if ((i7 & 306783379) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i2 & 1) != 0) {
        }
        if (i9 == 0) {
        }
        if (i8 == 0) {
        }
        if (i11 == 0) {
        }
        if ((i4 & 1024) == 0) {
        }
        j7 = m9597getICON_BUTTON_COLOR_DISABLED0d7_KjU$adn_sdk_release;
        j8 = m9594getCOUNTDOWN_PROGRESS_COLOR0d7_KjU$adn_sdk_release;
        f2 = f3;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        int i19222 = i7 >> 15;
        startRestartGroup.startReplaceableGroup(733328855);
        ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
        MeasurePolicy rememberBoxMeasurePolicy222 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap222 = startRestartGroup.getCurrentCompositionLocalMap();
        long j12222 = j7;
        Function0<ComposeUiNode> constructor222 = ComposeUiNode.INSTANCE.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf222 = LayoutKt.modifierMaterializerOf(modifier);
        if (!(startRestartGroup.getApplier() instanceof Applier)) {
        }
        startRestartGroup.startReusableNode();
        if (!startRestartGroup.getInserting()) {
        }
        m3593constructorimpl = Updater.m3593constructorimpl(startRestartGroup);
        Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy222, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap222, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash222 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
        if (!m3593constructorimpl.getInserting()) {
        }
        m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
        m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash222);
        modifierMaterializerOf222.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(2058660585);
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
        BoxScopeInstance boxScopeInstance222 = BoxScopeInstance.INSTANCE;
        long j13222 = i * 1000;
        i14 = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
        if (i14 != 1) {
        }
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
        }
        painter3 = painter2;
        composer2 = startRestartGroup;
        j10 = j12222;
        j11 = j9;
        final float f7222 = f2;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    private static final long countdownTimeLeft(long j, long j2, Composer composer, int i) {
        composer.startReplaceableGroup(1449591282);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1449591282, i, -1, "io.adn.sdk.internal.ui.common.design.compose.countdownTimeLeft (CloseButton.kt:118)");
        }
        LifecycleCountdownState rememberLifecycleCountdownState = LifecycleCountdownKt.rememberLifecycleCountdownState(j, j2, composer, i & 126);
        LifecycleCountdownKt.LifecycleCountdown(rememberLifecycleCountdownState, composer, 0);
        long timeLeft = rememberLifecycleCountdownState.getTimeLeft();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return timeLeft;
    }

    /* renamed from: CloseTextButton-Q4MTOb0, reason: not valid java name */
    private static final void m9520CloseTextButtonQ4MTOb0(final long j, final long j2, final long j3, final float f, final Painter painter, final Function0<Unit> function0, final Function0<Unit> function02, Composer composer, final int i) {
        int i2;
        Function0<Unit> function03;
        Function0<Unit> function04;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(2018672893);
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(j) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(j2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changed(j3) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changed(f) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= startRestartGroup.changedInstance(painter) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            function03 = function0;
            i2 |= startRestartGroup.changedInstance(function03) ? 131072 : 65536;
        } else {
            function03 = function0;
        }
        if ((1572864 & i) == 0) {
            function04 = function02;
            i2 |= startRestartGroup.changedInstance(function04) ? 1048576 : 524288;
        } else {
            function04 = function02;
        }
        if ((599187 & i2) != 599186 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2018672893, i2, -1, "io.adn.sdk.internal.ui.common.design.compose.CloseTextButton (CloseButton.kt:133)");
            }
            int i3 = (int) (j / 1000);
            if (i3 == 0) {
                startRestartGroup.startReplaceableGroup(259125125);
                int i4 = i2 >> 9;
                int i5 = i2 << 15;
                GenericIconButtonKt.m9526GenericIconButtonmPunlVI(null, painter, function03, function04, true, null, j2, j3, false, f, startRestartGroup, (i4 & 7168) | (i4 & 896) | (i4 & 112) | 24576 | (3670016 & i5) | (i5 & 29360128) | ((i2 << 18) & 1879048192), 289);
                startRestartGroup.endReplaceableGroup();
                composer2 = startRestartGroup;
            } else {
                startRestartGroup.startReplaceableGroup(259411069);
                Alignment center = Alignment.INSTANCE.getCenter();
                Modifier defaultButtonBackground = ComposeKt.defaultButtonBackground(SizeKt.m929size6HolHcs(Modifier.INSTANCE, j3), startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, startRestartGroup, 6);
                startRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(defaultButtonBackground);
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor);
                } else {
                    startRestartGroup.useNode();
                }
                Composer m3593constructorimpl = Updater.m3593constructorimpl(startRestartGroup);
                Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(2058660585);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                composer2 = startRestartGroup;
                TextKt.m2781Text4IGK_g(String.valueOf(i3), (Modifier) null, j2, TextUnitKt.getSp(18), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.m6274boximpl(TextAlign.INSTANCE.m6281getCentere0LSkKk()), 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer2, ((i2 << 3) & 896) | 3072, 0, 130546);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endReplaceableGroup();
                composer2.endNode();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: io.adn.sdk.internal.ui.common.design.compose.CloseButtonKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit CloseTextButton_Q4MTOb0$lambda$3;
                    CloseTextButton_Q4MTOb0$lambda$3 = CloseButtonKt.CloseTextButton_Q4MTOb0$lambda$3(j, j2, j3, f, painter, function0, function02, i, (Composer) obj, ((Integer) obj2).intValue());
                    return CloseTextButton_Q4MTOb0$lambda$3;
                }
            });
        }
    }

    /* renamed from: ProgressCloseButton-CvmUFeM, reason: not valid java name */
    private static final void m9522ProgressCloseButtonCvmUFeM(final float f, final long j, final long j2, final long j3, final long j4, final float f2, final Painter painter, final Function0<Unit> function0, final Function0<Unit> function02, Composer composer, final int i) {
        int i2;
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(-173596921);
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(f) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(j) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changed(j2) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changed(j3) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= startRestartGroup.changed(j4) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= startRestartGroup.changed(f2) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= startRestartGroup.changedInstance(painter) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i2 |= startRestartGroup.changedInstance(function0) ? 8388608 : 4194304;
        }
        int i4 = i2;
        if ((i & 100663296) == 0) {
            i3 = i4 | (startRestartGroup.changedInstance(function02) ? 67108864 : 33554432);
        } else {
            i3 = i4;
        }
        if ((i3 & 38347923) != 38347922 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-173596921, i3, -1, "io.adn.sdk.internal.ui.common.design.compose.ProgressCloseButton (CloseButton.kt:173)");
            }
            int i5 = i3;
            final State<Float> animateFloatAsState = AnimateAsStateKt.animateFloatAsState(f, ProgressIndicatorDefaults.INSTANCE.getProgressAnimationSpec(), 0.0f, "", null, startRestartGroup, (i3 & 14) | 3072, 20);
            boolean z = f == 0.0f;
            Alignment center = Alignment.INSTANCE.getCenter();
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, startRestartGroup, 6);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(companion);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer m3593constructorimpl = Updater.m3593constructorimpl(startRestartGroup);
            Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            int i6 = i5 >> 15;
            GenericIconButtonKt.m9526GenericIconButtonmPunlVI(Modifier.INSTANCE, painter, function0, function02, z, null, z ? j : j2, j4, false, f2, startRestartGroup, (i6 & 7168) | (i6 & 112) | 6 | (i6 & 896) | ((i5 << 9) & 29360128) | ((i5 << 12) & 1879048192), 288);
            startRestartGroup.startReplaceableGroup(1190632095);
            boolean changed = startRestartGroup.changed(animateFloatAsState);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: io.adn.sdk.internal.ui.common.design.compose.CloseButtonKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        float ProgressCloseButton_CvmUFeM$lambda$4;
                        ProgressCloseButton_CvmUFeM$lambda$4 = CloseButtonKt.ProgressCloseButton_CvmUFeM$lambda$4(State.this);
                        return Float.valueOf(ProgressCloseButton_CvmUFeM$lambda$4);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            Function0 function03 = (Function0) rememberedValue;
            startRestartGroup.endReplaceableGroup();
            Modifier.Companion companion2 = Modifier.INSTANCE;
            long m6411DpSizeYgX7TsA = DpKt.m6411DpSizeYgX7TsA(UIConstants.INSTANCE.m9595getCOUNTDOWN_STROKE_SIZED9Ej5fM$adn_sdk_release(), UIConstants.INSTANCE.m9595getCOUNTDOWN_STROKE_SIZED9Ej5fM$adn_sdk_release());
            ProgressIndicatorKt.m2399CircularProgressIndicatorDUhRLBM((Function0<Float>) function03, SizeKt.m929size6HolHcs(companion2, DpKt.m6411DpSizeYgX7TsA(Dp.m6389constructorimpl(DpSize.m6487getWidthD9Ej5fM(j4) + DpSize.m6487getWidthD9Ej5fM(m6411DpSizeYgX7TsA)), Dp.m6389constructorimpl(DpSize.m6485getHeightD9Ej5fM(j4) + DpSize.m6485getHeightD9Ej5fM(m6411DpSizeYgX7TsA)))), j3, UIConstants.INSTANCE.m9595getCOUNTDOWN_STROKE_SIZED9Ej5fM$adn_sdk_release(), 0L, 0, startRestartGroup, ((i5 >> 3) & 896) | 3072, 48);
            startRestartGroup = startRestartGroup;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: io.adn.sdk.internal.ui.common.design.compose.CloseButtonKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit ProgressCloseButton_CvmUFeM$lambda$8;
                    ProgressCloseButton_CvmUFeM$lambda$8 = CloseButtonKt.ProgressCloseButton_CvmUFeM$lambda$8(f, j, j2, j3, j4, f2, painter, function0, function02, i, (Composer) obj, ((Integer) obj2).intValue());
                    return ProgressCloseButton_CvmUFeM$lambda$8;
                }
            });
        }
    }

    /* renamed from: InvisibleCloseButton-Q2Kma20, reason: not valid java name */
    private static final void m9521InvisibleCloseButtonQ2Kma20(final long j, final Painter painter, final long j2, final long j3, final float f, final Function0<Unit> function0, final Function0<Unit> function02, Composer composer, final int i) {
        int i2;
        long j4;
        long j5;
        float f2;
        Function0<Unit> function03;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-539304767);
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(j) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(painter) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            j4 = j2;
            i2 |= startRestartGroup.changed(j4) ? 256 : 128;
        } else {
            j4 = j2;
        }
        if ((i & 3072) == 0) {
            j5 = j3;
            i2 |= startRestartGroup.changed(j5) ? 2048 : 1024;
        } else {
            j5 = j3;
        }
        if ((i & 24576) == 0) {
            f2 = f;
            i2 |= startRestartGroup.changed(f2) ? 16384 : 8192;
        } else {
            f2 = f;
        }
        if ((196608 & i) == 0) {
            i2 |= startRestartGroup.changedInstance(function0) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            function03 = function02;
            i2 |= startRestartGroup.changedInstance(function03) ? 1048576 : 524288;
        } else {
            function03 = function02;
        }
        if ((599187 & i2) != 599186 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-539304767, i2, -1, "io.adn.sdk.internal.ui.common.design.compose.InvisibleCloseButton (CloseButton.kt:209)");
            }
            if (j == 0) {
                int i3 = i2 >> 9;
                int i4 = (i2 & 112) | 24576 | (i3 & 896) | (i3 & 7168);
                int i5 = i2 << 12;
                composer2 = startRestartGroup;
                GenericIconButtonKt.m9526GenericIconButtonmPunlVI(null, painter, function0, function03, true, null, j4, j5, false, f2, composer2, i4 | (3670016 & i5) | (i5 & 29360128) | ((i2 << 15) & 1879048192), 289);
            } else {
                composer2 = startRestartGroup;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: io.adn.sdk.internal.ui.common.design.compose.CloseButtonKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit InvisibleCloseButton_Q2Kma20$lambda$9;
                    InvisibleCloseButton_Q2Kma20$lambda$9 = CloseButtonKt.InvisibleCloseButton_Q2Kma20$lambda$9(j, painter, j2, j3, f, function0, function02, i, (Composer) obj, ((Integer) obj2).intValue());
                    return InvisibleCloseButton_Q2Kma20$lambda$9;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float ProgressCloseButton_CvmUFeM$lambda$4(State<Float> state) {
        return state.getValue().floatValue();
    }
}
