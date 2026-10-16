package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.IntrinsicKt;
import androidx.compose.foundation.layout.IntrinsicSize;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.SelectableGroupKt;
import androidx.compose.material3.tokens.OutlinedSegmentedButtonTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.MultiContentMeasurePolicyKt;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.profileinstaller.ProfileVerifier;
import com.google.android.exoplayer2.C;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: SegmentedButton.kt */
@Metadata(d1 = {"\u0000v\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aD\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\u001c\u0010\n\u001a\u0018\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00060\u000b¢\u0006\u0002\b\r¢\u0006\u0002\b\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a3\u0010\u0011\u001a\u00020\u00062\u0011\u0010\u0012\u001a\r\u0012\u0004\u0012\u00020\u00060\u0013¢\u0006\u0002\b\r2\u0011\u0010\n\u001a\r\u0012\u0004\u0012\u00020\u00060\u0013¢\u0006\u0002\b\rH\u0003¢\u0006\u0002\u0010\u0014\u001aD\u0010\u0015\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\u001c\u0010\n\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00060\u000b¢\u0006\u0002\b\r¢\u0006\u0002\b\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0010\u001a\u008f\u0001\u0010\u0018\u001a\u00020\u0006*\u00020\f2\u0006\u0010\u0019\u001a\u00020\u001a2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00060\u000b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u001e\u001a\u00020\u001a2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\u0013\b\u0002\u0010\u0012\u001a\r\u0012\u0004\u0012\u00020\u00060\u0013¢\u0006\u0002\b\r2\u0011\u0010%\u001a\r\u0012\u0004\u0012\u00020\u00060\u0013¢\u0006\u0002\b\rH\u0007¢\u0006\u0002\u0010&\u001a\u0089\u0001\u0010\u0018\u001a\u00020\u0006*\u00020\u00162\u0006\u0010'\u001a\u00020\u001a2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00060\u00132\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u001e\u001a\u00020\u001a2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\u0013\b\u0002\u0010\u0012\u001a\r\u0012\u0004\u0012\u00020\u00060\u0013¢\u0006\u0002\b\r2\u0011\u0010%\u001a\r\u0012\u0004\u0012\u00020\u00060\u0013¢\u0006\u0002\b\rH\u0007¢\u0006\u0002\u0010)\u001a\u0017\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+*\u00020-H\u0003¢\u0006\u0002\u0010.\u001a\"\u0010/\u001a\u00020\b*\u00020\b2\u0006\u0010\u0019\u001a\u00020\u001a2\f\u00100\u001a\b\u0012\u0004\u0012\u00020,0+H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00061"}, d2 = {"CheckedZIndexFactor", "", "IconSpacing", "Landroidx/compose/ui/unit/Dp;", "F", "MultiChoiceSegmentedButtonRow", "", "modifier", "Landroidx/compose/ui/Modifier;", "space", "content", "Lkotlin/Function1;", "Landroidx/compose/material3/MultiChoiceSegmentedButtonRowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "MultiChoiceSegmentedButtonRow-uFdPcIQ", "(Landroidx/compose/ui/Modifier;FLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "SegmentedButtonContent", "icon", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "SingleChoiceSegmentedButtonRow", "Landroidx/compose/material3/SingleChoiceSegmentedButtonRowScope;", "SingleChoiceSegmentedButtonRow-uFdPcIQ", "SegmentedButton", "checked", "", "onCheckedChange", "shape", "Landroidx/compose/ui/graphics/Shape;", "enabled", "colors", "Landroidx/compose/material3/SegmentedButtonColors;", androidx.compose.material.OutlinedTextFieldKt.BorderId, "Landroidx/compose/foundation/BorderStroke;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "label", "(Landroidx/compose/material3/MultiChoiceSegmentedButtonRowScope;ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/SegmentedButtonColors;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "selected", "onClick", "(Landroidx/compose/material3/SingleChoiceSegmentedButtonRowScope;ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/SegmentedButtonColors;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "interactionCountAsState", "Landroidx/compose/runtime/State;", "", "Landroidx/compose/foundation/interaction/InteractionSource;", "(Landroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "interactionZIndex", "interactionCount", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SegmentedButtonKt {
    private static final float CheckedZIndexFactor = 5.0f;
    private static final float IconSpacing = Dp.m6389constructorimpl(8);

    /* JADX WARN: Removed duplicated region for block: B:100:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x02c4  */
    /* JADX WARN: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x02b4  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01a5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void SegmentedButton(final MultiChoiceSegmentedButtonRowScope multiChoiceSegmentedButtonRowScope, final boolean z, final Function1<? super Boolean, Unit> function1, final Shape shape, Modifier modifier, boolean z2, SegmentedButtonColors segmentedButtonColors, BorderStroke borderStroke, MutableInteractionSource mutableInteractionSource, Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        int i5;
        Modifier modifier2;
        int i6;
        boolean z3;
        SegmentedButtonColors segmentedButtonColors2;
        BorderStroke borderStroke2;
        int i7;
        int i8;
        int i9;
        int i10;
        Modifier.Companion companion;
        MutableInteractionSource mutableInteractionSource2;
        BorderStroke borderStroke3;
        MutableInteractionSource mutableInteractionSource3;
        boolean z4;
        int i11;
        SegmentedButtonColors segmentedButtonColors3;
        final Function2<? super Composer, ? super Integer, Unit> function23;
        Composer composer2;
        final SegmentedButtonColors segmentedButtonColors4;
        final Function2<? super Composer, ? super Integer, Unit> function24;
        final boolean z5;
        final BorderStroke borderStroke4;
        final MutableInteractionSource mutableInteractionSource4;
        final Modifier modifier3;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-1596038053);
        ComposerKt.sourceInformation(startRestartGroup, "C(SegmentedButton)P(1,8,9,7,3,2!1,5)134@6782L8,138@6959L39,144@7288L25,146@7319L585:SegmentedButton.kt#uh7d8r");
        if ((Integer.MIN_VALUE & i3) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (startRestartGroup.changed(multiChoiceSegmentedButtonRowScope) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i3 & 1) != 0) {
            i4 |= 48;
        } else if ((i & 48) == 0) {
            i4 |= startRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i3 & 2) != 0) {
            i4 |= 384;
        } else if ((i & 384) == 0) {
            i4 |= startRestartGroup.changedInstance(function1) ? 256 : 128;
            if ((i3 & 4) == 0) {
                i4 |= 3072;
            } else if ((i & 3072) == 0) {
                i4 |= startRestartGroup.changed(shape) ? 2048 : 1024;
                i5 = i3 & 8;
                if (i5 != 0) {
                    i4 |= 24576;
                } else if ((i & 24576) == 0) {
                    modifier2 = modifier;
                    i4 |= startRestartGroup.changed(modifier2) ? 16384 : 8192;
                    i6 = i3 & 16;
                    if (i6 == 0) {
                        i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((196608 & i) == 0) {
                        z3 = z2;
                        i4 |= startRestartGroup.changed(z3) ? 131072 : 65536;
                        if ((i & 1572864) == 0) {
                            segmentedButtonColors2 = segmentedButtonColors;
                            i4 |= ((i3 & 32) == 0 && startRestartGroup.changed(segmentedButtonColors2)) ? 1048576 : 524288;
                        } else {
                            segmentedButtonColors2 = segmentedButtonColors;
                        }
                        if ((i & 12582912) == 0) {
                            borderStroke2 = borderStroke;
                            i4 |= ((i3 & 64) == 0 && startRestartGroup.changed(borderStroke2)) ? 8388608 : 4194304;
                        } else {
                            borderStroke2 = borderStroke;
                        }
                        i7 = i3 & 128;
                        if (i7 != 0) {
                            i4 |= 100663296;
                        } else if ((i & 100663296) == 0) {
                            i4 |= startRestartGroup.changed(mutableInteractionSource) ? 67108864 : 33554432;
                        }
                        i8 = i3 & 256;
                        if (i8 != 0) {
                            i4 |= C.ENCODING_PCM_32BIT;
                        } else if ((i & C.ENCODING_PCM_32BIT) == 0) {
                            i9 = i8;
                            i4 |= startRestartGroup.changedInstance(function2) ? 536870912 : 268435456;
                            if ((i3 & 512) == 0) {
                                i10 = i2 | 6;
                            } else if ((i2 & 6) == 0) {
                                i10 = i2 | (startRestartGroup.changedInstance(function22) ? 4 : 2);
                            } else {
                                i10 = i2;
                            }
                            if ((i4 & 306783379) == 306783378 || (i10 & 3) != 2 || !startRestartGroup.getSkipping()) {
                                startRestartGroup.startDefaults();
                                if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                    companion = i5 == 0 ? Modifier.INSTANCE : modifier2;
                                    if (i6 != 0) {
                                        z3 = true;
                                    }
                                    if ((i3 & 32) != 0) {
                                        segmentedButtonColors2 = SegmentedButtonDefaults.INSTANCE.colors(startRestartGroup, 6);
                                        i4 &= -3670017;
                                    }
                                    if ((i3 & 64) != 0) {
                                        borderStroke2 = SegmentedButtonDefaults.m2476borderStrokel07J4OM$default(SegmentedButtonDefaults.INSTANCE, segmentedButtonColors2.m2460borderColorWaAFU9c$material3_release(z3, z), 0.0f, 2, null);
                                        i4 &= -29360129;
                                    }
                                    if (i7 == 0) {
                                        startRestartGroup.startReplaceableGroup(-773603666);
                                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):SegmentedButton.kt#9igjgp");
                                        Object rememberedValue = startRestartGroup.rememberedValue();
                                        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                            startRestartGroup.updateRememberedValue(rememberedValue);
                                        }
                                        mutableInteractionSource2 = (MutableInteractionSource) rememberedValue;
                                        startRestartGroup.endReplaceableGroup();
                                    } else {
                                        mutableInteractionSource2 = mutableInteractionSource;
                                    }
                                    if (i9 == 0) {
                                        borderStroke3 = borderStroke2;
                                        mutableInteractionSource3 = mutableInteractionSource2;
                                        z4 = z3;
                                        i11 = i4;
                                        segmentedButtonColors3 = segmentedButtonColors2;
                                        function23 = ComposableLambdaKt.composableLambda(startRestartGroup, 970447394, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SegmentedButtonKt$SegmentedButton$2
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                                invoke(composer3, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer composer3, int i12) {
                                                ComposerKt.sourceInformation(composer3, "C139@7061L13:SegmentedButton.kt#uh7d8r");
                                                if ((i12 & 3) == 2 && composer3.getSkipping()) {
                                                    composer3.skipToGroupEnd();
                                                    return;
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(970447394, i12, -1, "androidx.compose.material3.SegmentedButton.<anonymous> (SegmentedButton.kt:139)");
                                                }
                                                SegmentedButtonDefaults.INSTANCE.Icon(z, null, null, composer3, 3072, 6);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        });
                                    } else {
                                        borderStroke3 = borderStroke2;
                                        mutableInteractionSource3 = mutableInteractionSource2;
                                        z4 = z3;
                                        i11 = i4;
                                        segmentedButtonColors3 = segmentedButtonColors2;
                                        function23 = function2;
                                    }
                                } else {
                                    startRestartGroup.skipToGroupEnd();
                                    if ((i3 & 32) != 0) {
                                        i4 &= -3670017;
                                    }
                                    if ((i3 & 64) != 0) {
                                        i4 &= -29360129;
                                    }
                                    mutableInteractionSource3 = mutableInteractionSource;
                                    i11 = i4;
                                    segmentedButtonColors3 = segmentedButtonColors2;
                                    companion = modifier2;
                                    function23 = function2;
                                    borderStroke3 = borderStroke2;
                                    z4 = z3;
                                }
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1596038053, i11, i10, "androidx.compose.material3.SegmentedButton (SegmentedButton.kt:141)");
                                }
                                int i12 = i11;
                                int i13 = (i12 >> 24) & 14;
                                Modifier modifier4 = companion;
                                Function2<? super Composer, ? super Integer, Unit> function25 = function23;
                                composer2 = startRestartGroup;
                                SegmentedButtonColors segmentedButtonColors5 = segmentedButtonColors3;
                                SurfaceKt.m2635Surfaced85dljk(z, function1, SizeKt.m912defaultMinSizeVpY3zN4(interactionZIndex(RowScope.weight$default(multiChoiceSegmentedButtonRowScope, modifier4, 1.0f, false, 2, null), z, interactionCountAsState(mutableInteractionSource3, startRestartGroup, i13)), ButtonDefaults.INSTANCE.m1932getMinWidthD9Ej5fM(), ButtonDefaults.INSTANCE.m1931getMinHeightD9Ej5fM()), z4, shape, segmentedButtonColors3.m2461containerColorWaAFU9c$material3_release(z4, z), segmentedButtonColors3.m2462contentColorWaAFU9c$material3_release(z4, z), 0.0f, 0.0f, borderStroke3, mutableInteractionSource3, ComposableLambdaKt.composableLambda(startRestartGroup, 1635710341, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SegmentedButtonKt$SegmentedButton$3
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                        invoke(composer3, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer3, int i14) {
                                        ComposerKt.sourceInformation(composer3, "C163@7863L35:SegmentedButton.kt#uh7d8r");
                                        if ((i14 & 3) == 2 && composer3.getSkipping()) {
                                            composer3.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1635710341, i14, -1, "androidx.compose.material3.SegmentedButton.<anonymous> (SegmentedButton.kt:163)");
                                        }
                                        SegmentedButtonKt.SegmentedButtonContent(function23, function22, composer3, 0);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }), composer2, ((i12 >> 3) & 126) | ((i12 >> 6) & 7168) | ((i12 << 3) & 57344) | ((i12 << 6) & 1879048192), i13 | 48, 384);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                segmentedButtonColors4 = segmentedButtonColors5;
                                function24 = function25;
                                z5 = z4;
                                borderStroke4 = borderStroke3;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                modifier3 = modifier4;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                mutableInteractionSource4 = mutableInteractionSource;
                                function24 = function2;
                                composer2 = startRestartGroup;
                                segmentedButtonColors4 = segmentedButtonColors2;
                                z5 = z3;
                                borderStroke4 = borderStroke2;
                                modifier3 = modifier2;
                            }
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup == null) {
                                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SegmentedButtonKt$SegmentedButton$4
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                        invoke(composer3, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer3, int i14) {
                                        SegmentedButtonKt.SegmentedButton(MultiChoiceSegmentedButtonRowScope.this, z, function1, shape, modifier3, z5, segmentedButtonColors4, borderStroke4, mutableInteractionSource4, function24, function22, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        i9 = i8;
                        if ((i3 & 512) == 0) {
                        }
                        if ((i4 & 306783379) == 306783378) {
                        }
                        startRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                        }
                        if (i5 == 0) {
                        }
                        if (i6 != 0) {
                        }
                        if ((i3 & 32) != 0) {
                        }
                        if ((i3 & 64) != 0) {
                        }
                        if (i7 == 0) {
                        }
                        if (i9 == 0) {
                        }
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        int i122 = i11;
                        int i132 = (i122 >> 24) & 14;
                        Modifier modifier42 = companion;
                        Function2<? super Composer, ? super Integer, Unit> function252 = function23;
                        composer2 = startRestartGroup;
                        SegmentedButtonColors segmentedButtonColors52 = segmentedButtonColors3;
                        SurfaceKt.m2635Surfaced85dljk(z, function1, SizeKt.m912defaultMinSizeVpY3zN4(interactionZIndex(RowScope.weight$default(multiChoiceSegmentedButtonRowScope, modifier42, 1.0f, false, 2, null), z, interactionCountAsState(mutableInteractionSource3, startRestartGroup, i132)), ButtonDefaults.INSTANCE.m1932getMinWidthD9Ej5fM(), ButtonDefaults.INSTANCE.m1931getMinHeightD9Ej5fM()), z4, shape, segmentedButtonColors3.m2461containerColorWaAFU9c$material3_release(z4, z), segmentedButtonColors3.m2462contentColorWaAFU9c$material3_release(z4, z), 0.0f, 0.0f, borderStroke3, mutableInteractionSource3, ComposableLambdaKt.composableLambda(startRestartGroup, 1635710341, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SegmentedButtonKt$SegmentedButton$3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                invoke(composer3, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i14) {
                                ComposerKt.sourceInformation(composer3, "C163@7863L35:SegmentedButton.kt#uh7d8r");
                                if ((i14 & 3) == 2 && composer3.getSkipping()) {
                                    composer3.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1635710341, i14, -1, "androidx.compose.material3.SegmentedButton.<anonymous> (SegmentedButton.kt:163)");
                                }
                                SegmentedButtonKt.SegmentedButtonContent(function23, function22, composer3, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), composer2, ((i122 >> 3) & 126) | ((i122 >> 6) & 7168) | ((i122 << 3) & 57344) | ((i122 << 6) & 1879048192), i132 | 48, 384);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        segmentedButtonColors4 = segmentedButtonColors52;
                        function24 = function252;
                        z5 = z4;
                        borderStroke4 = borderStroke3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        modifier3 = modifier42;
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    z3 = z2;
                    if ((i & 1572864) == 0) {
                    }
                    if ((i & 12582912) == 0) {
                    }
                    i7 = i3 & 128;
                    if (i7 != 0) {
                    }
                    i8 = i3 & 256;
                    if (i8 != 0) {
                    }
                    i9 = i8;
                    if ((i3 & 512) == 0) {
                    }
                    if ((i4 & 306783379) == 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i5 == 0) {
                    }
                    if (i6 != 0) {
                    }
                    if ((i3 & 32) != 0) {
                    }
                    if ((i3 & 64) != 0) {
                    }
                    if (i7 == 0) {
                    }
                    if (i9 == 0) {
                    }
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    int i1222 = i11;
                    int i1322 = (i1222 >> 24) & 14;
                    Modifier modifier422 = companion;
                    Function2<? super Composer, ? super Integer, Unit> function2522 = function23;
                    composer2 = startRestartGroup;
                    SegmentedButtonColors segmentedButtonColors522 = segmentedButtonColors3;
                    SurfaceKt.m2635Surfaced85dljk(z, function1, SizeKt.m912defaultMinSizeVpY3zN4(interactionZIndex(RowScope.weight$default(multiChoiceSegmentedButtonRowScope, modifier422, 1.0f, false, 2, null), z, interactionCountAsState(mutableInteractionSource3, startRestartGroup, i1322)), ButtonDefaults.INSTANCE.m1932getMinWidthD9Ej5fM(), ButtonDefaults.INSTANCE.m1931getMinHeightD9Ej5fM()), z4, shape, segmentedButtonColors3.m2461containerColorWaAFU9c$material3_release(z4, z), segmentedButtonColors3.m2462contentColorWaAFU9c$material3_release(z4, z), 0.0f, 0.0f, borderStroke3, mutableInteractionSource3, ComposableLambdaKt.composableLambda(startRestartGroup, 1635710341, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SegmentedButtonKt$SegmentedButton$3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                            invoke(composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i14) {
                            ComposerKt.sourceInformation(composer3, "C163@7863L35:SegmentedButton.kt#uh7d8r");
                            if ((i14 & 3) == 2 && composer3.getSkipping()) {
                                composer3.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1635710341, i14, -1, "androidx.compose.material3.SegmentedButton.<anonymous> (SegmentedButton.kt:163)");
                            }
                            SegmentedButtonKt.SegmentedButtonContent(function23, function22, composer3, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }), composer2, ((i1222 >> 3) & 126) | ((i1222 >> 6) & 7168) | ((i1222 << 3) & 57344) | ((i1222 << 6) & 1879048192), i1322 | 48, 384);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    segmentedButtonColors4 = segmentedButtonColors522;
                    function24 = function2522;
                    z5 = z4;
                    borderStroke4 = borderStroke3;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    modifier3 = modifier422;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                modifier2 = modifier;
                i6 = i3 & 16;
                if (i6 == 0) {
                }
                z3 = z2;
                if ((i & 1572864) == 0) {
                }
                if ((i & 12582912) == 0) {
                }
                i7 = i3 & 128;
                if (i7 != 0) {
                }
                i8 = i3 & 256;
                if (i8 != 0) {
                }
                i9 = i8;
                if ((i3 & 512) == 0) {
                }
                if ((i4 & 306783379) == 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i5 == 0) {
                }
                if (i6 != 0) {
                }
                if ((i3 & 32) != 0) {
                }
                if ((i3 & 64) != 0) {
                }
                if (i7 == 0) {
                }
                if (i9 == 0) {
                }
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                int i12222 = i11;
                int i13222 = (i12222 >> 24) & 14;
                Modifier modifier4222 = companion;
                Function2<? super Composer, ? super Integer, Unit> function25222 = function23;
                composer2 = startRestartGroup;
                SegmentedButtonColors segmentedButtonColors5222 = segmentedButtonColors3;
                SurfaceKt.m2635Surfaced85dljk(z, function1, SizeKt.m912defaultMinSizeVpY3zN4(interactionZIndex(RowScope.weight$default(multiChoiceSegmentedButtonRowScope, modifier4222, 1.0f, false, 2, null), z, interactionCountAsState(mutableInteractionSource3, startRestartGroup, i13222)), ButtonDefaults.INSTANCE.m1932getMinWidthD9Ej5fM(), ButtonDefaults.INSTANCE.m1931getMinHeightD9Ej5fM()), z4, shape, segmentedButtonColors3.m2461containerColorWaAFU9c$material3_release(z4, z), segmentedButtonColors3.m2462contentColorWaAFU9c$material3_release(z4, z), 0.0f, 0.0f, borderStroke3, mutableInteractionSource3, ComposableLambdaKt.composableLambda(startRestartGroup, 1635710341, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SegmentedButtonKt$SegmentedButton$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                        invoke(composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i14) {
                        ComposerKt.sourceInformation(composer3, "C163@7863L35:SegmentedButton.kt#uh7d8r");
                        if ((i14 & 3) == 2 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1635710341, i14, -1, "androidx.compose.material3.SegmentedButton.<anonymous> (SegmentedButton.kt:163)");
                        }
                        SegmentedButtonKt.SegmentedButtonContent(function23, function22, composer3, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), composer2, ((i12222 >> 3) & 126) | ((i12222 >> 6) & 7168) | ((i12222 << 3) & 57344) | ((i12222 << 6) & 1879048192), i13222 | 48, 384);
                if (ComposerKt.isTraceInProgress()) {
                }
                segmentedButtonColors4 = segmentedButtonColors5222;
                function24 = function25222;
                z5 = z4;
                borderStroke4 = borderStroke3;
                mutableInteractionSource4 = mutableInteractionSource3;
                modifier3 = modifier4222;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            i5 = i3 & 8;
            if (i5 != 0) {
            }
            modifier2 = modifier;
            i6 = i3 & 16;
            if (i6 == 0) {
            }
            z3 = z2;
            if ((i & 1572864) == 0) {
            }
            if ((i & 12582912) == 0) {
            }
            i7 = i3 & 128;
            if (i7 != 0) {
            }
            i8 = i3 & 256;
            if (i8 != 0) {
            }
            i9 = i8;
            if ((i3 & 512) == 0) {
            }
            if ((i4 & 306783379) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i5 == 0) {
            }
            if (i6 != 0) {
            }
            if ((i3 & 32) != 0) {
            }
            if ((i3 & 64) != 0) {
            }
            if (i7 == 0) {
            }
            if (i9 == 0) {
            }
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            int i122222 = i11;
            int i132222 = (i122222 >> 24) & 14;
            Modifier modifier42222 = companion;
            Function2<? super Composer, ? super Integer, Unit> function252222 = function23;
            composer2 = startRestartGroup;
            SegmentedButtonColors segmentedButtonColors52222 = segmentedButtonColors3;
            SurfaceKt.m2635Surfaced85dljk(z, function1, SizeKt.m912defaultMinSizeVpY3zN4(interactionZIndex(RowScope.weight$default(multiChoiceSegmentedButtonRowScope, modifier42222, 1.0f, false, 2, null), z, interactionCountAsState(mutableInteractionSource3, startRestartGroup, i132222)), ButtonDefaults.INSTANCE.m1932getMinWidthD9Ej5fM(), ButtonDefaults.INSTANCE.m1931getMinHeightD9Ej5fM()), z4, shape, segmentedButtonColors3.m2461containerColorWaAFU9c$material3_release(z4, z), segmentedButtonColors3.m2462contentColorWaAFU9c$material3_release(z4, z), 0.0f, 0.0f, borderStroke3, mutableInteractionSource3, ComposableLambdaKt.composableLambda(startRestartGroup, 1635710341, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SegmentedButtonKt$SegmentedButton$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i14) {
                    ComposerKt.sourceInformation(composer3, "C163@7863L35:SegmentedButton.kt#uh7d8r");
                    if ((i14 & 3) == 2 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1635710341, i14, -1, "androidx.compose.material3.SegmentedButton.<anonymous> (SegmentedButton.kt:163)");
                    }
                    SegmentedButtonKt.SegmentedButtonContent(function23, function22, composer3, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), composer2, ((i122222 >> 3) & 126) | ((i122222 >> 6) & 7168) | ((i122222 << 3) & 57344) | ((i122222 << 6) & 1879048192), i132222 | 48, 384);
            if (ComposerKt.isTraceInProgress()) {
            }
            segmentedButtonColors4 = segmentedButtonColors52222;
            function24 = function252222;
            z5 = z4;
            borderStroke4 = borderStroke3;
            mutableInteractionSource4 = mutableInteractionSource3;
            modifier3 = modifier42222;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        if ((i3 & 4) == 0) {
        }
        i5 = i3 & 8;
        if (i5 != 0) {
        }
        modifier2 = modifier;
        i6 = i3 & 16;
        if (i6 == 0) {
        }
        z3 = z2;
        if ((i & 1572864) == 0) {
        }
        if ((i & 12582912) == 0) {
        }
        i7 = i3 & 128;
        if (i7 != 0) {
        }
        i8 = i3 & 256;
        if (i8 != 0) {
        }
        i9 = i8;
        if ((i3 & 512) == 0) {
        }
        if ((i4 & 306783379) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i5 == 0) {
        }
        if (i6 != 0) {
        }
        if ((i3 & 32) != 0) {
        }
        if ((i3 & 64) != 0) {
        }
        if (i7 == 0) {
        }
        if (i9 == 0) {
        }
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        int i1222222 = i11;
        int i1322222 = (i1222222 >> 24) & 14;
        Modifier modifier422222 = companion;
        Function2<? super Composer, ? super Integer, Unit> function2522222 = function23;
        composer2 = startRestartGroup;
        SegmentedButtonColors segmentedButtonColors522222 = segmentedButtonColors3;
        SurfaceKt.m2635Surfaced85dljk(z, function1, SizeKt.m912defaultMinSizeVpY3zN4(interactionZIndex(RowScope.weight$default(multiChoiceSegmentedButtonRowScope, modifier422222, 1.0f, false, 2, null), z, interactionCountAsState(mutableInteractionSource3, startRestartGroup, i1322222)), ButtonDefaults.INSTANCE.m1932getMinWidthD9Ej5fM(), ButtonDefaults.INSTANCE.m1931getMinHeightD9Ej5fM()), z4, shape, segmentedButtonColors3.m2461containerColorWaAFU9c$material3_release(z4, z), segmentedButtonColors3.m2462contentColorWaAFU9c$material3_release(z4, z), 0.0f, 0.0f, borderStroke3, mutableInteractionSource3, ComposableLambdaKt.composableLambda(startRestartGroup, 1635710341, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SegmentedButtonKt$SegmentedButton$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                invoke(composer3, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer3, int i14) {
                ComposerKt.sourceInformation(composer3, "C163@7863L35:SegmentedButton.kt#uh7d8r");
                if ((i14 & 3) == 2 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1635710341, i14, -1, "androidx.compose.material3.SegmentedButton.<anonymous> (SegmentedButton.kt:163)");
                }
                SegmentedButtonKt.SegmentedButtonContent(function23, function22, composer3, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), composer2, ((i1222222 >> 3) & 126) | ((i1222222 >> 6) & 7168) | ((i1222222 << 3) & 57344) | ((i1222222 << 6) & 1879048192), i1322222 | 48, 384);
        if (ComposerKt.isTraceInProgress()) {
        }
        segmentedButtonColors4 = segmentedButtonColors522222;
        function24 = function2522222;
        z5 = z4;
        borderStroke4 = borderStroke3;
        mutableInteractionSource4 = mutableInteractionSource3;
        modifier3 = modifier422222;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x02cd  */
    /* JADX WARN: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x02bc  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01a5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void SegmentedButton(final SingleChoiceSegmentedButtonRowScope singleChoiceSegmentedButtonRowScope, final boolean z, final Function0<Unit> function0, final Shape shape, Modifier modifier, boolean z2, SegmentedButtonColors segmentedButtonColors, BorderStroke borderStroke, MutableInteractionSource mutableInteractionSource, Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        int i5;
        Modifier modifier2;
        int i6;
        boolean z3;
        SegmentedButtonColors segmentedButtonColors2;
        BorderStroke borderStroke2;
        int i7;
        int i8;
        int i9;
        int i10;
        Modifier.Companion companion;
        MutableInteractionSource mutableInteractionSource2;
        BorderStroke borderStroke3;
        MutableInteractionSource mutableInteractionSource3;
        boolean z4;
        int i11;
        SegmentedButtonColors segmentedButtonColors3;
        final Function2<? super Composer, ? super Integer, Unit> function23;
        Composer composer2;
        final SegmentedButtonColors segmentedButtonColors4;
        final boolean z5;
        final BorderStroke borderStroke4;
        final MutableInteractionSource mutableInteractionSource4;
        final Modifier modifier3;
        final Function2<? super Composer, ? super Integer, Unit> function24;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-1016574361);
        ComposerKt.sourceInformation(startRestartGroup, "C(SegmentedButton)P(8,7,9,6,2,1!1,4)209@10206L8,213@10384L39,219@10716L25,221@10747L623:SegmentedButton.kt#uh7d8r");
        if ((Integer.MIN_VALUE & i3) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (startRestartGroup.changed(singleChoiceSegmentedButtonRowScope) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i3 & 1) != 0) {
            i4 |= 48;
        } else if ((i & 48) == 0) {
            i4 |= startRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i3 & 2) != 0) {
            i4 |= 384;
        } else if ((i & 384) == 0) {
            i4 |= startRestartGroup.changedInstance(function0) ? 256 : 128;
            if ((i3 & 4) == 0) {
                i4 |= 3072;
            } else if ((i & 3072) == 0) {
                i4 |= startRestartGroup.changed(shape) ? 2048 : 1024;
                i5 = i3 & 8;
                if (i5 != 0) {
                    i4 |= 24576;
                } else if ((i & 24576) == 0) {
                    modifier2 = modifier;
                    i4 |= startRestartGroup.changed(modifier2) ? 16384 : 8192;
                    i6 = i3 & 16;
                    if (i6 == 0) {
                        i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((196608 & i) == 0) {
                        z3 = z2;
                        i4 |= startRestartGroup.changed(z3) ? 131072 : 65536;
                        if ((i & 1572864) == 0) {
                            segmentedButtonColors2 = segmentedButtonColors;
                            i4 |= ((i3 & 32) == 0 && startRestartGroup.changed(segmentedButtonColors2)) ? 1048576 : 524288;
                        } else {
                            segmentedButtonColors2 = segmentedButtonColors;
                        }
                        if ((i & 12582912) == 0) {
                            borderStroke2 = borderStroke;
                            i4 |= ((i3 & 64) == 0 && startRestartGroup.changed(borderStroke2)) ? 8388608 : 4194304;
                        } else {
                            borderStroke2 = borderStroke;
                        }
                        i7 = i3 & 128;
                        if (i7 != 0) {
                            i4 |= 100663296;
                        } else if ((i & 100663296) == 0) {
                            i4 |= startRestartGroup.changed(mutableInteractionSource) ? 67108864 : 33554432;
                        }
                        i8 = i3 & 256;
                        if (i8 != 0) {
                            i4 |= C.ENCODING_PCM_32BIT;
                        } else if ((i & C.ENCODING_PCM_32BIT) == 0) {
                            i9 = i8;
                            i4 |= startRestartGroup.changedInstance(function2) ? 536870912 : 268435456;
                            if ((i3 & 512) == 0) {
                                i10 = i2 | 6;
                            } else if ((i2 & 6) == 0) {
                                i10 = i2 | (startRestartGroup.changedInstance(function22) ? 4 : 2);
                            } else {
                                i10 = i2;
                            }
                            if ((i4 & 306783379) == 306783378 || (i10 & 3) != 2 || !startRestartGroup.getSkipping()) {
                                startRestartGroup.startDefaults();
                                if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                    companion = i5 == 0 ? Modifier.INSTANCE : modifier2;
                                    if (i6 != 0) {
                                        z3 = true;
                                    }
                                    if ((i3 & 32) != 0) {
                                        segmentedButtonColors2 = SegmentedButtonDefaults.INSTANCE.colors(startRestartGroup, 6);
                                        i4 &= -3670017;
                                    }
                                    if ((i3 & 64) != 0) {
                                        borderStroke2 = SegmentedButtonDefaults.m2476borderStrokel07J4OM$default(SegmentedButtonDefaults.INSTANCE, segmentedButtonColors2.m2460borderColorWaAFU9c$material3_release(z3, z), 0.0f, 2, null);
                                        i4 &= -29360129;
                                    }
                                    if (i7 == 0) {
                                        startRestartGroup.startReplaceableGroup(-773600241);
                                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):SegmentedButton.kt#9igjgp");
                                        Object rememberedValue = startRestartGroup.rememberedValue();
                                        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                            startRestartGroup.updateRememberedValue(rememberedValue);
                                        }
                                        mutableInteractionSource2 = (MutableInteractionSource) rememberedValue;
                                        startRestartGroup.endReplaceableGroup();
                                    } else {
                                        mutableInteractionSource2 = mutableInteractionSource;
                                    }
                                    if (i9 == 0) {
                                        borderStroke3 = borderStroke2;
                                        mutableInteractionSource3 = mutableInteractionSource2;
                                        z4 = z3;
                                        i11 = i4;
                                        segmentedButtonColors3 = segmentedButtonColors2;
                                        function23 = ComposableLambdaKt.composableLambda(startRestartGroup, 1235063168, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SegmentedButtonKt$SegmentedButton$6
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                                invoke(composer3, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer composer3, int i12) {
                                                ComposerKt.sourceInformation(composer3, "C214@10486L14:SegmentedButton.kt#uh7d8r");
                                                if ((i12 & 3) == 2 && composer3.getSkipping()) {
                                                    composer3.skipToGroupEnd();
                                                    return;
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(1235063168, i12, -1, "androidx.compose.material3.SegmentedButton.<anonymous> (SegmentedButton.kt:214)");
                                                }
                                                SegmentedButtonDefaults.INSTANCE.Icon(z, null, null, composer3, 3072, 6);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        });
                                    } else {
                                        borderStroke3 = borderStroke2;
                                        mutableInteractionSource3 = mutableInteractionSource2;
                                        z4 = z3;
                                        i11 = i4;
                                        segmentedButtonColors3 = segmentedButtonColors2;
                                        function23 = function2;
                                    }
                                } else {
                                    startRestartGroup.skipToGroupEnd();
                                    if ((i3 & 32) != 0) {
                                        i4 &= -3670017;
                                    }
                                    if ((i3 & 64) != 0) {
                                        i4 &= -29360129;
                                    }
                                    mutableInteractionSource3 = mutableInteractionSource;
                                    i11 = i4;
                                    segmentedButtonColors3 = segmentedButtonColors2;
                                    companion = modifier2;
                                    function23 = function2;
                                    borderStroke3 = borderStroke2;
                                    z4 = z3;
                                }
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1016574361, i11, i10, "androidx.compose.material3.SegmentedButton (SegmentedButton.kt:216)");
                                }
                                int i12 = i11;
                                int i13 = (i12 >> 24) & 14;
                                Modifier modifier4 = companion;
                                SegmentedButtonColors segmentedButtonColors5 = segmentedButtonColors3;
                                Function2<? super Composer, ? super Integer, Unit> function25 = function23;
                                composer2 = startRestartGroup;
                                SurfaceKt.m2634Surfaced85dljk(z, function0, SemanticsModifierKt.semantics$default(SizeKt.m912defaultMinSizeVpY3zN4(interactionZIndex(RowScope.weight$default(singleChoiceSegmentedButtonRowScope, modifier4, 1.0f, false, 2, null), z, interactionCountAsState(mutableInteractionSource3, startRestartGroup, i13)), ButtonDefaults.INSTANCE.m1932getMinWidthD9Ej5fM(), ButtonDefaults.INSTANCE.m1931getMinHeightD9Ej5fM()), false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.SegmentedButtonKt$SegmentedButton$7
                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                        invoke2(semanticsPropertyReceiver);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                        SemanticsPropertiesKt.m5732setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m5720getRadioButtono7Vup1c());
                                    }
                                }, 1, null), z4, shape, segmentedButtonColors3.m2461containerColorWaAFU9c$material3_release(z4, z), segmentedButtonColors3.m2462contentColorWaAFU9c$material3_release(z4, z), 0.0f, 0.0f, borderStroke3, mutableInteractionSource3, ComposableLambdaKt.composableLambda(startRestartGroup, 383378045, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SegmentedButtonKt$SegmentedButton$8
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                        invoke(composer3, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer3, int i14) {
                                        ComposerKt.sourceInformation(composer3, "C239@11329L35:SegmentedButton.kt#uh7d8r");
                                        if ((i14 & 3) == 2 && composer3.getSkipping()) {
                                            composer3.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(383378045, i14, -1, "androidx.compose.material3.SegmentedButton.<anonymous> (SegmentedButton.kt:239)");
                                        }
                                        SegmentedButtonKt.SegmentedButtonContent(function23, function22, composer3, 0);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }), composer2, ((i12 >> 3) & 126) | ((i12 >> 6) & 7168) | (57344 & (i12 << 3)) | (1879048192 & (i12 << 6)), i13 | 48, 384);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                segmentedButtonColors4 = segmentedButtonColors5;
                                z5 = z4;
                                borderStroke4 = borderStroke3;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                modifier3 = modifier4;
                                function24 = function25;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                mutableInteractionSource4 = mutableInteractionSource;
                                function24 = function2;
                                composer2 = startRestartGroup;
                                segmentedButtonColors4 = segmentedButtonColors2;
                                z5 = z3;
                                borderStroke4 = borderStroke2;
                                modifier3 = modifier2;
                            }
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup == null) {
                                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SegmentedButtonKt$SegmentedButton$9
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                        invoke(composer3, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer3, int i14) {
                                        SegmentedButtonKt.SegmentedButton(SingleChoiceSegmentedButtonRowScope.this, z, function0, shape, modifier3, z5, segmentedButtonColors4, borderStroke4, mutableInteractionSource4, function24, function22, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        i9 = i8;
                        if ((i3 & 512) == 0) {
                        }
                        if ((i4 & 306783379) == 306783378) {
                        }
                        startRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                        }
                        if (i5 == 0) {
                        }
                        if (i6 != 0) {
                        }
                        if ((i3 & 32) != 0) {
                        }
                        if ((i3 & 64) != 0) {
                        }
                        if (i7 == 0) {
                        }
                        if (i9 == 0) {
                        }
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        int i122 = i11;
                        int i132 = (i122 >> 24) & 14;
                        Modifier modifier42 = companion;
                        SegmentedButtonColors segmentedButtonColors52 = segmentedButtonColors3;
                        Function2<? super Composer, ? super Integer, Unit> function252 = function23;
                        composer2 = startRestartGroup;
                        SurfaceKt.m2634Surfaced85dljk(z, function0, SemanticsModifierKt.semantics$default(SizeKt.m912defaultMinSizeVpY3zN4(interactionZIndex(RowScope.weight$default(singleChoiceSegmentedButtonRowScope, modifier42, 1.0f, false, 2, null), z, interactionCountAsState(mutableInteractionSource3, startRestartGroup, i132)), ButtonDefaults.INSTANCE.m1932getMinWidthD9Ej5fM(), ButtonDefaults.INSTANCE.m1931getMinHeightD9Ej5fM()), false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.SegmentedButtonKt$SegmentedButton$7
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                invoke2(semanticsPropertyReceiver);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                SemanticsPropertiesKt.m5732setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m5720getRadioButtono7Vup1c());
                            }
                        }, 1, null), z4, shape, segmentedButtonColors3.m2461containerColorWaAFU9c$material3_release(z4, z), segmentedButtonColors3.m2462contentColorWaAFU9c$material3_release(z4, z), 0.0f, 0.0f, borderStroke3, mutableInteractionSource3, ComposableLambdaKt.composableLambda(startRestartGroup, 383378045, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SegmentedButtonKt$SegmentedButton$8
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                invoke(composer3, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i14) {
                                ComposerKt.sourceInformation(composer3, "C239@11329L35:SegmentedButton.kt#uh7d8r");
                                if ((i14 & 3) == 2 && composer3.getSkipping()) {
                                    composer3.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(383378045, i14, -1, "androidx.compose.material3.SegmentedButton.<anonymous> (SegmentedButton.kt:239)");
                                }
                                SegmentedButtonKt.SegmentedButtonContent(function23, function22, composer3, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), composer2, ((i122 >> 3) & 126) | ((i122 >> 6) & 7168) | (57344 & (i122 << 3)) | (1879048192 & (i122 << 6)), i132 | 48, 384);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        segmentedButtonColors4 = segmentedButtonColors52;
                        z5 = z4;
                        borderStroke4 = borderStroke3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        modifier3 = modifier42;
                        function24 = function252;
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    z3 = z2;
                    if ((i & 1572864) == 0) {
                    }
                    if ((i & 12582912) == 0) {
                    }
                    i7 = i3 & 128;
                    if (i7 != 0) {
                    }
                    i8 = i3 & 256;
                    if (i8 != 0) {
                    }
                    i9 = i8;
                    if ((i3 & 512) == 0) {
                    }
                    if ((i4 & 306783379) == 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i5 == 0) {
                    }
                    if (i6 != 0) {
                    }
                    if ((i3 & 32) != 0) {
                    }
                    if ((i3 & 64) != 0) {
                    }
                    if (i7 == 0) {
                    }
                    if (i9 == 0) {
                    }
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    int i1222 = i11;
                    int i1322 = (i1222 >> 24) & 14;
                    Modifier modifier422 = companion;
                    SegmentedButtonColors segmentedButtonColors522 = segmentedButtonColors3;
                    Function2<? super Composer, ? super Integer, Unit> function2522 = function23;
                    composer2 = startRestartGroup;
                    SurfaceKt.m2634Surfaced85dljk(z, function0, SemanticsModifierKt.semantics$default(SizeKt.m912defaultMinSizeVpY3zN4(interactionZIndex(RowScope.weight$default(singleChoiceSegmentedButtonRowScope, modifier422, 1.0f, false, 2, null), z, interactionCountAsState(mutableInteractionSource3, startRestartGroup, i1322)), ButtonDefaults.INSTANCE.m1932getMinWidthD9Ej5fM(), ButtonDefaults.INSTANCE.m1931getMinHeightD9Ej5fM()), false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.SegmentedButtonKt$SegmentedButton$7
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            invoke2(semanticsPropertyReceiver);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            SemanticsPropertiesKt.m5732setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m5720getRadioButtono7Vup1c());
                        }
                    }, 1, null), z4, shape, segmentedButtonColors3.m2461containerColorWaAFU9c$material3_release(z4, z), segmentedButtonColors3.m2462contentColorWaAFU9c$material3_release(z4, z), 0.0f, 0.0f, borderStroke3, mutableInteractionSource3, ComposableLambdaKt.composableLambda(startRestartGroup, 383378045, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SegmentedButtonKt$SegmentedButton$8
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                            invoke(composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i14) {
                            ComposerKt.sourceInformation(composer3, "C239@11329L35:SegmentedButton.kt#uh7d8r");
                            if ((i14 & 3) == 2 && composer3.getSkipping()) {
                                composer3.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(383378045, i14, -1, "androidx.compose.material3.SegmentedButton.<anonymous> (SegmentedButton.kt:239)");
                            }
                            SegmentedButtonKt.SegmentedButtonContent(function23, function22, composer3, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }), composer2, ((i1222 >> 3) & 126) | ((i1222 >> 6) & 7168) | (57344 & (i1222 << 3)) | (1879048192 & (i1222 << 6)), i1322 | 48, 384);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    segmentedButtonColors4 = segmentedButtonColors522;
                    z5 = z4;
                    borderStroke4 = borderStroke3;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    modifier3 = modifier422;
                    function24 = function2522;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                modifier2 = modifier;
                i6 = i3 & 16;
                if (i6 == 0) {
                }
                z3 = z2;
                if ((i & 1572864) == 0) {
                }
                if ((i & 12582912) == 0) {
                }
                i7 = i3 & 128;
                if (i7 != 0) {
                }
                i8 = i3 & 256;
                if (i8 != 0) {
                }
                i9 = i8;
                if ((i3 & 512) == 0) {
                }
                if ((i4 & 306783379) == 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i5 == 0) {
                }
                if (i6 != 0) {
                }
                if ((i3 & 32) != 0) {
                }
                if ((i3 & 64) != 0) {
                }
                if (i7 == 0) {
                }
                if (i9 == 0) {
                }
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                int i12222 = i11;
                int i13222 = (i12222 >> 24) & 14;
                Modifier modifier4222 = companion;
                SegmentedButtonColors segmentedButtonColors5222 = segmentedButtonColors3;
                Function2<? super Composer, ? super Integer, Unit> function25222 = function23;
                composer2 = startRestartGroup;
                SurfaceKt.m2634Surfaced85dljk(z, function0, SemanticsModifierKt.semantics$default(SizeKt.m912defaultMinSizeVpY3zN4(interactionZIndex(RowScope.weight$default(singleChoiceSegmentedButtonRowScope, modifier4222, 1.0f, false, 2, null), z, interactionCountAsState(mutableInteractionSource3, startRestartGroup, i13222)), ButtonDefaults.INSTANCE.m1932getMinWidthD9Ej5fM(), ButtonDefaults.INSTANCE.m1931getMinHeightD9Ej5fM()), false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.SegmentedButtonKt$SegmentedButton$7
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        invoke2(semanticsPropertyReceiver);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        SemanticsPropertiesKt.m5732setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m5720getRadioButtono7Vup1c());
                    }
                }, 1, null), z4, shape, segmentedButtonColors3.m2461containerColorWaAFU9c$material3_release(z4, z), segmentedButtonColors3.m2462contentColorWaAFU9c$material3_release(z4, z), 0.0f, 0.0f, borderStroke3, mutableInteractionSource3, ComposableLambdaKt.composableLambda(startRestartGroup, 383378045, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SegmentedButtonKt$SegmentedButton$8
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                        invoke(composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i14) {
                        ComposerKt.sourceInformation(composer3, "C239@11329L35:SegmentedButton.kt#uh7d8r");
                        if ((i14 & 3) == 2 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(383378045, i14, -1, "androidx.compose.material3.SegmentedButton.<anonymous> (SegmentedButton.kt:239)");
                        }
                        SegmentedButtonKt.SegmentedButtonContent(function23, function22, composer3, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), composer2, ((i12222 >> 3) & 126) | ((i12222 >> 6) & 7168) | (57344 & (i12222 << 3)) | (1879048192 & (i12222 << 6)), i13222 | 48, 384);
                if (ComposerKt.isTraceInProgress()) {
                }
                segmentedButtonColors4 = segmentedButtonColors5222;
                z5 = z4;
                borderStroke4 = borderStroke3;
                mutableInteractionSource4 = mutableInteractionSource3;
                modifier3 = modifier4222;
                function24 = function25222;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            i5 = i3 & 8;
            if (i5 != 0) {
            }
            modifier2 = modifier;
            i6 = i3 & 16;
            if (i6 == 0) {
            }
            z3 = z2;
            if ((i & 1572864) == 0) {
            }
            if ((i & 12582912) == 0) {
            }
            i7 = i3 & 128;
            if (i7 != 0) {
            }
            i8 = i3 & 256;
            if (i8 != 0) {
            }
            i9 = i8;
            if ((i3 & 512) == 0) {
            }
            if ((i4 & 306783379) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i5 == 0) {
            }
            if (i6 != 0) {
            }
            if ((i3 & 32) != 0) {
            }
            if ((i3 & 64) != 0) {
            }
            if (i7 == 0) {
            }
            if (i9 == 0) {
            }
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            int i122222 = i11;
            int i132222 = (i122222 >> 24) & 14;
            Modifier modifier42222 = companion;
            SegmentedButtonColors segmentedButtonColors52222 = segmentedButtonColors3;
            Function2<? super Composer, ? super Integer, Unit> function252222 = function23;
            composer2 = startRestartGroup;
            SurfaceKt.m2634Surfaced85dljk(z, function0, SemanticsModifierKt.semantics$default(SizeKt.m912defaultMinSizeVpY3zN4(interactionZIndex(RowScope.weight$default(singleChoiceSegmentedButtonRowScope, modifier42222, 1.0f, false, 2, null), z, interactionCountAsState(mutableInteractionSource3, startRestartGroup, i132222)), ButtonDefaults.INSTANCE.m1932getMinWidthD9Ej5fM(), ButtonDefaults.INSTANCE.m1931getMinHeightD9Ej5fM()), false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.SegmentedButtonKt$SegmentedButton$7
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    SemanticsPropertiesKt.m5732setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m5720getRadioButtono7Vup1c());
                }
            }, 1, null), z4, shape, segmentedButtonColors3.m2461containerColorWaAFU9c$material3_release(z4, z), segmentedButtonColors3.m2462contentColorWaAFU9c$material3_release(z4, z), 0.0f, 0.0f, borderStroke3, mutableInteractionSource3, ComposableLambdaKt.composableLambda(startRestartGroup, 383378045, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SegmentedButtonKt$SegmentedButton$8
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i14) {
                    ComposerKt.sourceInformation(composer3, "C239@11329L35:SegmentedButton.kt#uh7d8r");
                    if ((i14 & 3) == 2 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(383378045, i14, -1, "androidx.compose.material3.SegmentedButton.<anonymous> (SegmentedButton.kt:239)");
                    }
                    SegmentedButtonKt.SegmentedButtonContent(function23, function22, composer3, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), composer2, ((i122222 >> 3) & 126) | ((i122222 >> 6) & 7168) | (57344 & (i122222 << 3)) | (1879048192 & (i122222 << 6)), i132222 | 48, 384);
            if (ComposerKt.isTraceInProgress()) {
            }
            segmentedButtonColors4 = segmentedButtonColors52222;
            z5 = z4;
            borderStroke4 = borderStroke3;
            mutableInteractionSource4 = mutableInteractionSource3;
            modifier3 = modifier42222;
            function24 = function252222;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        if ((i3 & 4) == 0) {
        }
        i5 = i3 & 8;
        if (i5 != 0) {
        }
        modifier2 = modifier;
        i6 = i3 & 16;
        if (i6 == 0) {
        }
        z3 = z2;
        if ((i & 1572864) == 0) {
        }
        if ((i & 12582912) == 0) {
        }
        i7 = i3 & 128;
        if (i7 != 0) {
        }
        i8 = i3 & 256;
        if (i8 != 0) {
        }
        i9 = i8;
        if ((i3 & 512) == 0) {
        }
        if ((i4 & 306783379) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i5 == 0) {
        }
        if (i6 != 0) {
        }
        if ((i3 & 32) != 0) {
        }
        if ((i3 & 64) != 0) {
        }
        if (i7 == 0) {
        }
        if (i9 == 0) {
        }
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        int i1222222 = i11;
        int i1322222 = (i1222222 >> 24) & 14;
        Modifier modifier422222 = companion;
        SegmentedButtonColors segmentedButtonColors522222 = segmentedButtonColors3;
        Function2<? super Composer, ? super Integer, Unit> function2522222 = function23;
        composer2 = startRestartGroup;
        SurfaceKt.m2634Surfaced85dljk(z, function0, SemanticsModifierKt.semantics$default(SizeKt.m912defaultMinSizeVpY3zN4(interactionZIndex(RowScope.weight$default(singleChoiceSegmentedButtonRowScope, modifier422222, 1.0f, false, 2, null), z, interactionCountAsState(mutableInteractionSource3, startRestartGroup, i1322222)), ButtonDefaults.INSTANCE.m1932getMinWidthD9Ej5fM(), ButtonDefaults.INSTANCE.m1931getMinHeightD9Ej5fM()), false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.SegmentedButtonKt$SegmentedButton$7
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                invoke2(semanticsPropertyReceiver);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                SemanticsPropertiesKt.m5732setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m5720getRadioButtono7Vup1c());
            }
        }, 1, null), z4, shape, segmentedButtonColors3.m2461containerColorWaAFU9c$material3_release(z4, z), segmentedButtonColors3.m2462contentColorWaAFU9c$material3_release(z4, z), 0.0f, 0.0f, borderStroke3, mutableInteractionSource3, ComposableLambdaKt.composableLambda(startRestartGroup, 383378045, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SegmentedButtonKt$SegmentedButton$8
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                invoke(composer3, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer3, int i14) {
                ComposerKt.sourceInformation(composer3, "C239@11329L35:SegmentedButton.kt#uh7d8r");
                if ((i14 & 3) == 2 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(383378045, i14, -1, "androidx.compose.material3.SegmentedButton.<anonymous> (SegmentedButton.kt:239)");
                }
                SegmentedButtonKt.SegmentedButtonContent(function23, function22, composer3, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), composer2, ((i1222222 >> 3) & 126) | ((i1222222 >> 6) & 7168) | (57344 & (i1222222 << 3)) | (1879048192 & (i1222222 << 6)), i1322222 | 48, 384);
        if (ComposerKt.isTraceInProgress()) {
        }
        segmentedButtonColors4 = segmentedButtonColors522222;
        z5 = z4;
        borderStroke4 = borderStroke3;
        mutableInteractionSource4 = mutableInteractionSource3;
        modifier3 = modifier422222;
        function24 = function2522222;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* renamed from: SingleChoiceSegmentedButtonRow-uFdPcIQ, reason: not valid java name */
    public static final void m2482SingleChoiceSegmentedButtonRowuFdPcIQ(Modifier modifier, float f, final Function3<? super SingleChoiceSegmentedButtonRowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(-1520863498);
        ComposerKt.sourceInformation(startRestartGroup, "C(SingleChoiceSegmentedButtonRow)P(1,2:c#ui.unit.Dp)266@12418L423:SegmentedButton.kt#uh7d8r");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i5 = i2 & 2;
        if (i5 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changed(f) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= startRestartGroup.changedInstance(function3) ? 256 : 128;
        }
        if ((i3 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (i4 != 0) {
                modifier = Modifier.INSTANCE;
            }
            if (i5 != 0) {
                f = SegmentedButtonDefaults.INSTANCE.m2479getBorderWidthD9Ej5fM();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1520863498, i3, -1, "androidx.compose.material3.SingleChoiceSegmentedButtonRow (SegmentedButton.kt:265)");
            }
            Modifier width = IntrinsicKt.width(SizeKt.m913defaultMinSizeVpY3zN4$default(SelectableGroupKt.selectableGroup(modifier), 0.0f, OutlinedSegmentedButtonTokens.INSTANCE.m3318getContainerHeightD9Ej5fM(), 1, null), IntrinsicSize.Min);
            Arrangement.HorizontalOrVertical m788spacedBy0680j_4 = Arrangement.INSTANCE.m788spacedBy0680j_4(Dp.m6389constructorimpl(-f));
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            startRestartGroup.startReplaceableGroup(693286680);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(m788spacedBy0680j_4, centerVertically, startRestartGroup, 48);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(width);
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
            Updater.m3600setimpl(m3593constructorimpl, rowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -326681643, "C92@4661L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -181589436, "C274@12753L58,275@12826L9:SegmentedButton.kt#uh7d8r");
            startRestartGroup.startReplaceableGroup(-181589424);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):SegmentedButton.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new SingleChoiceSegmentedButtonScopeWrapper(rowScopeInstance);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            function3.invoke((SingleChoiceSegmentedButtonScopeWrapper) rememberedValue, startRestartGroup, Integer.valueOf(((i3 >> 3) & 112) | 6));
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        final Modifier modifier2 = modifier;
        final float f2 = f;
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SegmentedButtonKt$SingleChoiceSegmentedButtonRow$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i6) {
                    SegmentedButtonKt.m2482SingleChoiceSegmentedButtonRowuFdPcIQ(Modifier.this, f2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* renamed from: MultiChoiceSegmentedButtonRow-uFdPcIQ, reason: not valid java name */
    public static final void m2481MultiChoiceSegmentedButtonRowuFdPcIQ(Modifier modifier, float f, final Function3<? super MultiChoiceSegmentedButtonRowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(155922315);
        ComposerKt.sourceInformation(startRestartGroup, "C(MultiChoiceSegmentedButtonRow)P(1,2:c#ui.unit.Dp)304@13910L391:SegmentedButton.kt#uh7d8r");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i5 = i2 & 2;
        if (i5 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changed(f) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= startRestartGroup.changedInstance(function3) ? 256 : 128;
        }
        if ((i3 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (i4 != 0) {
                modifier = Modifier.INSTANCE;
            }
            if (i5 != 0) {
                f = SegmentedButtonDefaults.INSTANCE.m2479getBorderWidthD9Ej5fM();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(155922315, i3, -1, "androidx.compose.material3.MultiChoiceSegmentedButtonRow (SegmentedButton.kt:303)");
            }
            Modifier width = IntrinsicKt.width(SizeKt.m913defaultMinSizeVpY3zN4$default(modifier, 0.0f, OutlinedSegmentedButtonTokens.INSTANCE.m3318getContainerHeightD9Ej5fM(), 1, null), IntrinsicSize.Min);
            Arrangement.HorizontalOrVertical m788spacedBy0680j_4 = Arrangement.INSTANCE.m788spacedBy0680j_4(Dp.m6389constructorimpl(-f));
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            startRestartGroup.startReplaceableGroup(693286680);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(m788spacedBy0680j_4, centerVertically, startRestartGroup, 48);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(width);
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
            Updater.m3600setimpl(m3593constructorimpl, rowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -326681643, "C92@4661L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 573415822, "C311@14214L57,312@14286L9:SegmentedButton.kt#uh7d8r");
            startRestartGroup.startReplaceableGroup(573415834);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):SegmentedButton.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new MultiChoiceSegmentedButtonScopeWrapper(rowScopeInstance);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            function3.invoke((MultiChoiceSegmentedButtonScopeWrapper) rememberedValue, startRestartGroup, Integer.valueOf(((i3 >> 3) & 112) | 6));
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        final Modifier modifier2 = modifier;
        final float f2 = f;
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SegmentedButtonKt$MultiChoiceSegmentedButtonRow$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i6) {
                    SegmentedButtonKt.m2481MultiChoiceSegmentedButtonRowuFdPcIQ(Modifier.this, f2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SegmentedButtonContent(final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(1464121570);
        ComposerKt.sourceInformation(startRestartGroup, "C(SegmentedButtonContent)P(1)322@14458L637:SegmentedButton.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(function22) ? 32 : 16;
        }
        if ((i2 & 19) != 18 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1464121570, i2, -1, "androidx.compose.material3.SegmentedButtonContent (SegmentedButton.kt:321)");
            }
            Alignment center = Alignment.INSTANCE.getCenter();
            Modifier padding = PaddingKt.padding(Modifier.INSTANCE, ButtonDefaults.INSTANCE.getTextButtonContentPadding());
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, startRestartGroup, 6);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(padding);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 372432274, "C327@14644L10,328@14718L371:SegmentedButton.kt#uh7d8r");
            TextKt.ProvideTextStyle(TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), OutlinedSegmentedButtonTokens.INSTANCE.getLabelTextFont()), ComposableLambdaKt.composableLambda(startRestartGroup, 1420592651, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SegmentedButtonKt$SegmentedButtonContent$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    ComposerKt.sourceInformation(composer2, "C329@14773L24,330@14830L55,332@14899L180:SegmentedButton.kt#uh7d8r");
                    if ((i3 & 3) != 2 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1420592651, i3, -1, "androidx.compose.material3.SegmentedButtonContent.<anonymous>.<anonymous> (SegmentedButton.kt:329)");
                        }
                        composer2.startReplaceableGroup(773894976);
                        ComposerKt.sourceInformation(composer2, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
                        composer2.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(composer2, "CC(remember):Composables.kt#9igjgp");
                        Object rememberedValue = composer2.rememberedValue();
                        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                            Object compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer2));
                            composer2.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                            rememberedValue = compositionScopedCoroutineScopeCanceller;
                        }
                        composer2.endReplaceableGroup();
                        CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
                        composer2.endReplaceableGroup();
                        composer2.startReplaceableGroup(-1468900584);
                        ComposerKt.sourceInformation(composer2, "CC(remember):SegmentedButton.kt#9igjgp");
                        Object rememberedValue2 = composer2.rememberedValue();
                        if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue2 = new SegmentedButtonContentMeasurePolicy(coroutineScope);
                            composer2.updateRememberedValue(rememberedValue2);
                        }
                        composer2.endReplaceableGroup();
                        Modifier height = IntrinsicKt.height(Modifier.INSTANCE, IntrinsicSize.Min);
                        List listOf = CollectionsKt.listOf((Object[]) new Function2[]{function2, function22});
                        composer2.startReplaceableGroup(1399185516);
                        ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)171@6874L62,168@6760L182:Layout.kt#80mrfh");
                        Function2<Composer, Integer, Unit> combineAsVirtualLayouts = LayoutKt.combineAsVirtualLayouts(listOf);
                        composer2.startReplaceableGroup(1157296644);
                        ComposerKt.sourceInformation(composer2, "CC(remember)P(1):Composables.kt#9igjgp");
                        SegmentedButtonContentMeasurePolicy segmentedButtonContentMeasurePolicy = (SegmentedButtonContentMeasurePolicy) rememberedValue2;
                        boolean changed = composer2.changed(segmentedButtonContentMeasurePolicy);
                        Object rememberedValue3 = composer2.rememberedValue();
                        if (changed || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue3 = MultiContentMeasurePolicyKt.createMeasurePolicy(segmentedButtonContentMeasurePolicy);
                            composer2.updateRememberedValue(rememberedValue3);
                        }
                        composer2.endReplaceableGroup();
                        MeasurePolicy measurePolicy = (MeasurePolicy) rememberedValue3;
                        composer2.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                        CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                        Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(height);
                        if (!(composer2.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer2.startReusableNode();
                        if (composer2.getInserting()) {
                            composer2.createNode(constructor2);
                        } else {
                            composer2.useNode();
                        }
                        Composer m3593constructorimpl2 = Updater.m3593constructorimpl(composer2);
                        Updater.m3600setimpl(m3593constructorimpl2, measurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (m3593constructorimpl2.getInserting() || !Intrinsics.areEqual(m3593constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                            m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                            m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                        }
                        modifierMaterializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer2)), composer2, 0);
                        composer2.startReplaceableGroup(2058660585);
                        combineAsVirtualLayouts.invoke(composer2, 0);
                        composer2.endReplaceableGroup();
                        composer2.endNode();
                        composer2.endReplaceableGroup();
                        composer2.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            }), startRestartGroup, 48);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
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
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SegmentedButtonKt$SegmentedButtonContent$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    SegmentedButtonKt.SegmentedButtonContent(function2, function22, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    private static final State<Integer> interactionCountAsState(InteractionSource interactionSource, Composer composer, int i) {
        composer.startReplaceableGroup(281890131);
        ComposerKt.sourceInformation(composer, "C(interactionCountAsState)399@17334L33,400@17393L500,400@17372L521:SegmentedButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(281890131, i, -1, "androidx.compose.material3.interactionCountAsState (SegmentedButton.kt:398)");
        }
        composer.startReplaceableGroup(-1372284393);
        ComposerKt.sourceInformation(composer, "CC(remember):SegmentedButton.kt#9igjgp");
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = SnapshotIntStateKt.mutableIntStateOf(0);
            composer.updateRememberedValue(rememberedValue);
        }
        MutableIntState mutableIntState = (MutableIntState) rememberedValue;
        composer.endReplaceableGroup();
        composer.startReplaceableGroup(-1372284334);
        ComposerKt.sourceInformation(composer, "CC(remember):SegmentedButton.kt#9igjgp");
        int i2 = i & 14;
        boolean z = ((i2 ^ 6) > 4 && composer.changed(interactionSource)) || (i & 6) == 4;
        SegmentedButtonKt$interactionCountAsState$1$1 rememberedValue2 = composer.rememberedValue();
        if (z || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
            rememberedValue2 = new SegmentedButtonKt$interactionCountAsState$1$1(interactionSource, mutableIntState, null);
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceableGroup();
        EffectsKt.LaunchedEffect(interactionSource, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue2, composer, i2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return mutableIntState;
    }

    private static final Modifier interactionZIndex(Modifier modifier, final boolean z, final State<Integer> state) {
        return LayoutModifierKt.layout(modifier, new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: androidx.compose.material3.SegmentedButtonKt$interactionZIndex$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ MeasureResult invoke(MeasureScope measureScope, Measurable measurable, Constraints constraints) {
                return m2483invoke3p2s80s(measureScope, measurable, constraints.getValue());
            }

            /* renamed from: invoke-3p2s80s, reason: not valid java name */
            public final MeasureResult m2483invoke3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
                final Placeable mo5333measureBRTryo0 = measurable.mo5333measureBRTryo0(j);
                int width = mo5333measureBRTryo0.getWidth();
                int height = mo5333measureBRTryo0.getHeight();
                final State<Integer> state2 = state;
                final boolean z2 = z;
                return MeasureScope.layout$default(measureScope, width, height, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.SegmentedButtonKt$interactionZIndex$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                        invoke2(placementScope);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Placeable.PlacementScope placementScope) {
                        placementScope.place(mo5333measureBRTryo0, 0, 0, state2.getValue().floatValue() + (z2 ? 5.0f : 0.0f));
                    }
                }, 4, null);
            }
        });
    }
}
