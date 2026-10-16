package androidx.compose.material3;

import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.window.AndroidPopup_androidKt;
import androidx.compose.ui.window.PopupProperties;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* compiled from: AndroidMenu.android.kt */
@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001an\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\u001c\u0010\u000e\u001a\u0018\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u0012H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001ad\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\r2\u001c\u0010\u000e\u001a\u0018\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u0012H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u008e\u0001\u0010\u0017\u001a\u00020\u00012\u0011\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00112\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u00112\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u00112\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"H\u0007¢\u0006\u0002\u0010#\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006$"}, d2 = {"DropdownMenu", "", "expanded", "", "onDismissRequest", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "offset", "Landroidx/compose/ui/unit/DpOffset;", "scrollState", "Landroidx/compose/foundation/ScrollState;", "properties", "Landroidx/compose/ui/window/PopupProperties;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "DropdownMenu-4kj-_NE", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;JLandroidx/compose/foundation/ScrollState;Landroidx/compose/ui/window/PopupProperties;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "DropdownMenu-ILWXrKs", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;JLandroidx/compose/ui/window/PopupProperties;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "DropdownMenuItem", "text", "onClick", "leadingIcon", "trailingIcon", "enabled", "colors", "Landroidx/compose/material3/MenuItemColors;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/material3/MenuItemColors;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AndroidMenu_androidKt {
    /* JADX WARN: Removed duplicated region for block: B:103:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x00a2  */
    /* renamed from: DropdownMenu-4kj-_NE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1882DropdownMenu4kj_NE(boolean z, final Function0<Unit> function0, Modifier modifier, long j, ScrollState scrollState, PopupProperties popupProperties, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        boolean z2;
        int i3;
        int i4;
        Modifier modifier2;
        int i5;
        long j2;
        ScrollState scrollState2;
        int i6;
        PopupProperties popupProperties2;
        Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function32;
        final Modifier modifier3;
        long j3;
        PopupProperties popupProperties3;
        final ScrollState scrollState3;
        Object rememberedValue;
        boolean z3;
        final MutableTransitionState mutableTransitionState;
        Object rememberedValue2;
        boolean changed;
        Object rememberedValue3;
        final PopupProperties popupProperties4;
        Composer composer2;
        final ScrollState scrollState4;
        final Modifier modifier4;
        final long j4;
        ScopeUpdateScope endRestartGroup;
        int i7;
        Composer startRestartGroup = composer.startRestartGroup(-1137929566);
        ComposerKt.sourceInformation(startRestartGroup, "C(DropdownMenu)P(1,4,2,3:c#ui.unit.DpOffset,6,5)88@4529L21,92@4697L42,96@4884L51,97@4971L7,98@5015L281,107@5306L441:AndroidMenu.android.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            z2 = z;
        } else {
            z2 = z;
            if ((i & 6) == 0) {
                i3 = (startRestartGroup.changed(z2) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changedInstance(function0) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= 384;
            } else if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= startRestartGroup.changed(modifier2) ? 256 : 128;
                i5 = i2 & 8;
                if (i5 != 0) {
                    i3 |= 3072;
                } else if ((i & 3072) == 0) {
                    j2 = j;
                    i3 |= startRestartGroup.changed(j2) ? 2048 : 1024;
                    if ((i & 24576) != 0) {
                        if ((i2 & 16) == 0) {
                            scrollState2 = scrollState;
                            if (startRestartGroup.changed(scrollState2)) {
                                i7 = 16384;
                                i3 |= i7;
                            }
                        } else {
                            scrollState2 = scrollState;
                        }
                        i7 = 8192;
                        i3 |= i7;
                    } else {
                        scrollState2 = scrollState;
                    }
                    i6 = i2 & 32;
                    if (i6 == 0) {
                        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((196608 & i) == 0) {
                        popupProperties2 = popupProperties;
                        i3 |= startRestartGroup.changed(popupProperties2) ? 131072 : 65536;
                        if ((i2 & 64) != 0) {
                            i3 |= 1572864;
                            function32 = function3;
                        } else {
                            function32 = function3;
                            if ((i & 1572864) == 0) {
                                i3 |= startRestartGroup.changedInstance(function32) ? 1048576 : 524288;
                            }
                        }
                        if ((i3 & 599187) == 599186 || !startRestartGroup.getSkipping()) {
                            startRestartGroup.startDefaults();
                            if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                if (i4 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i5 != 0) {
                                    float f = 0;
                                    j2 = DpKt.m6410DpOffsetYgX7TsA(Dp.m6389constructorimpl(f), Dp.m6389constructorimpl(f));
                                }
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                    scrollState2 = ScrollKt.rememberScrollState(0, startRestartGroup, 0, 1);
                                }
                                if (i6 != 0) {
                                    modifier3 = modifier2;
                                    j3 = j2;
                                    popupProperties3 = new PopupProperties(true, false, false, null, false, false, 62, null);
                                    scrollState3 = scrollState2;
                                    startRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1137929566, i3, -1, "androidx.compose.material3.DropdownMenu (AndroidMenu.android.kt:91)");
                                    }
                                    startRestartGroup.startReplaceableGroup(463006278);
                                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):AndroidMenu.android.kt#9igjgp");
                                    rememberedValue = startRestartGroup.rememberedValue();
                                    if (rememberedValue != Composer.INSTANCE.getEmpty()) {
                                        z3 = false;
                                        rememberedValue = new MutableTransitionState(false);
                                        startRestartGroup.updateRememberedValue(rememberedValue);
                                    } else {
                                        z3 = false;
                                    }
                                    mutableTransitionState = (MutableTransitionState) rememberedValue;
                                    startRestartGroup.endReplaceableGroup();
                                    mutableTransitionState.setTargetState(Boolean.valueOf(z2));
                                    if (!((Boolean) mutableTransitionState.getCurrentState()).booleanValue() || ((Boolean) mutableTransitionState.getTargetState()).booleanValue()) {
                                        startRestartGroup.startReplaceableGroup(463006465);
                                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):AndroidMenu.android.kt#9igjgp");
                                        rememberedValue2 = startRestartGroup.rememberedValue();
                                        if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TransformOrigin.m4440boximpl(TransformOrigin.INSTANCE.m4453getCenterSzJe1aQ()), null, 2, null);
                                            startRestartGroup.updateRememberedValue(rememberedValue2);
                                        }
                                        final MutableState mutableState = (MutableState) rememberedValue2;
                                        startRestartGroup.endReplaceableGroup();
                                        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                        Object consume = startRestartGroup.consume(localDensity);
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        Density density = (Density) consume;
                                        startRestartGroup.startReplaceableGroup(463006596);
                                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):AndroidMenu.android.kt#9igjgp");
                                        if ((i3 & 7168) == 2048) {
                                            z3 = true;
                                        }
                                        changed = z3 | startRestartGroup.changed(density);
                                        rememberedValue3 = startRestartGroup.rememberedValue();
                                        if (!changed || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue3 = new DropdownMenuPositionProvider(j3, density, 0, new Function2<IntRect, IntRect, Unit>() { // from class: androidx.compose.material3.AndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1$1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(2);
                                                }

                                                @Override // kotlin.jvm.functions.Function2
                                                public /* bridge */ /* synthetic */ Unit invoke(IntRect intRect, IntRect intRect2) {
                                                    invoke2(intRect, intRect2);
                                                    return Unit.INSTANCE;
                                                }

                                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                public final void invoke2(IntRect intRect, IntRect intRect2) {
                                                    mutableState.setValue(TransformOrigin.m4440boximpl(MenuKt.calculateTransformOrigin(intRect, intRect2)));
                                                }
                                            }, 4, null);
                                            startRestartGroup.updateRememberedValue(rememberedValue3);
                                        }
                                        startRestartGroup.endReplaceableGroup();
                                        final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function33 = function32;
                                        AndroidPopup_androidKt.Popup((DropdownMenuPositionProvider) rememberedValue3, function0, popupProperties3, ComposableLambdaKt.composableLambda(startRestartGroup, -848116919, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidMenu_androidKt$DropdownMenu$1
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

                                            public final void invoke(Composer composer3, int i8) {
                                                ComposerKt.sourceInformation(composer3, "C112@5481L256:AndroidMenu.android.kt#uh7d8r");
                                                if ((i8 & 3) != 2 || !composer3.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-848116919, i8, -1, "androidx.compose.material3.DropdownMenu.<anonymous> (AndroidMenu.android.kt:112)");
                                                    }
                                                    MenuKt.DropdownMenuContent(mutableTransitionState, mutableState, scrollState3, modifier3, function33, composer3, MutableTransitionState.$stable | 48, 0);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                composer3.skipToGroupEnd();
                                            }
                                        }), startRestartGroup, (i3 & 112) | 3072 | ((i3 >> 9) & 896), 0);
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    popupProperties4 = popupProperties3;
                                    composer2 = startRestartGroup;
                                    scrollState4 = scrollState3;
                                    modifier4 = modifier3;
                                    j4 = j3;
                                }
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                }
                            }
                            modifier3 = modifier2;
                            j3 = j2;
                            scrollState3 = scrollState2;
                            popupProperties3 = popupProperties2;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            startRestartGroup.startReplaceableGroup(463006278);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):AndroidMenu.android.kt#9igjgp");
                            rememberedValue = startRestartGroup.rememberedValue();
                            if (rememberedValue != Composer.INSTANCE.getEmpty()) {
                            }
                            mutableTransitionState = (MutableTransitionState) rememberedValue;
                            startRestartGroup.endReplaceableGroup();
                            mutableTransitionState.setTargetState(Boolean.valueOf(z2));
                            if (!((Boolean) mutableTransitionState.getCurrentState()).booleanValue()) {
                            }
                            startRestartGroup.startReplaceableGroup(463006465);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):AndroidMenu.android.kt#9igjgp");
                            rememberedValue2 = startRestartGroup.rememberedValue();
                            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            }
                            final MutableState<TransformOrigin> mutableState2 = (MutableState) rememberedValue2;
                            startRestartGroup.endReplaceableGroup();
                            ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            Object consume2 = startRestartGroup.consume(localDensity2);
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            Density density2 = (Density) consume2;
                            startRestartGroup.startReplaceableGroup(463006596);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):AndroidMenu.android.kt#9igjgp");
                            if ((i3 & 7168) == 2048) {
                            }
                            changed = z3 | startRestartGroup.changed(density2);
                            rememberedValue3 = startRestartGroup.rememberedValue();
                            if (!changed) {
                            }
                            rememberedValue3 = new DropdownMenuPositionProvider(j3, density2, 0, new Function2<IntRect, IntRect, Unit>() { // from class: androidx.compose.material3.AndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(IntRect intRect, IntRect intRect2) {
                                    invoke2(intRect, intRect2);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(IntRect intRect, IntRect intRect2) {
                                    mutableState2.setValue(TransformOrigin.m4440boximpl(MenuKt.calculateTransformOrigin(intRect, intRect2)));
                                }
                            }, 4, null);
                            startRestartGroup.updateRememberedValue(rememberedValue3);
                            startRestartGroup.endReplaceableGroup();
                            final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function332 = function32;
                            AndroidPopup_androidKt.Popup((DropdownMenuPositionProvider) rememberedValue3, function0, popupProperties3, ComposableLambdaKt.composableLambda(startRestartGroup, -848116919, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidMenu_androidKt$DropdownMenu$1
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

                                public final void invoke(Composer composer3, int i8) {
                                    ComposerKt.sourceInformation(composer3, "C112@5481L256:AndroidMenu.android.kt#uh7d8r");
                                    if ((i8 & 3) != 2 || !composer3.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-848116919, i8, -1, "androidx.compose.material3.DropdownMenu.<anonymous> (AndroidMenu.android.kt:112)");
                                        }
                                        MenuKt.DropdownMenuContent(mutableTransitionState, mutableState2, scrollState3, modifier3, function332, composer3, MutableTransitionState.$stable | 48, 0);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer3.skipToGroupEnd();
                                }
                            }), startRestartGroup, (i3 & 112) | 3072 | ((i3 >> 9) & 896), 0);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            popupProperties4 = popupProperties3;
                            composer2 = startRestartGroup;
                            scrollState4 = scrollState3;
                            modifier4 = modifier3;
                            j4 = j3;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            composer2 = startRestartGroup;
                            modifier4 = modifier2;
                            j4 = j2;
                            scrollState4 = scrollState2;
                            popupProperties4 = popupProperties2;
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            final boolean z4 = z2;
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidMenu_androidKt$DropdownMenu$2
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

                                public final void invoke(Composer composer3, int i8) {
                                    AndroidMenu_androidKt.m1882DropdownMenu4kj_NE(z4, function0, modifier4, j4, scrollState4, popupProperties4, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    popupProperties2 = popupProperties;
                    if ((i2 & 64) != 0) {
                    }
                    if ((i3 & 599187) == 599186) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i4 != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if ((i2 & 16) != 0) {
                    }
                    if (i6 != 0) {
                    }
                    modifier3 = modifier2;
                    j3 = j2;
                    scrollState3 = scrollState2;
                    popupProperties3 = popupProperties2;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    startRestartGroup.startReplaceableGroup(463006278);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):AndroidMenu.android.kt#9igjgp");
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (rememberedValue != Composer.INSTANCE.getEmpty()) {
                    }
                    mutableTransitionState = (MutableTransitionState) rememberedValue;
                    startRestartGroup.endReplaceableGroup();
                    mutableTransitionState.setTargetState(Boolean.valueOf(z2));
                    if (!((Boolean) mutableTransitionState.getCurrentState()).booleanValue()) {
                    }
                    startRestartGroup.startReplaceableGroup(463006465);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):AndroidMenu.android.kt#9igjgp");
                    rememberedValue2 = startRestartGroup.rememberedValue();
                    if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    }
                    final MutableState<TransformOrigin> mutableState22 = (MutableState) rememberedValue2;
                    startRestartGroup.endReplaceableGroup();
                    ProvidableCompositionLocal<Density> localDensity22 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume22 = startRestartGroup.consume(localDensity22);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    Density density22 = (Density) consume22;
                    startRestartGroup.startReplaceableGroup(463006596);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):AndroidMenu.android.kt#9igjgp");
                    if ((i3 & 7168) == 2048) {
                    }
                    changed = z3 | startRestartGroup.changed(density22);
                    rememberedValue3 = startRestartGroup.rememberedValue();
                    if (!changed) {
                    }
                    rememberedValue3 = new DropdownMenuPositionProvider(j3, density22, 0, new Function2<IntRect, IntRect, Unit>() { // from class: androidx.compose.material3.AndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(IntRect intRect, IntRect intRect2) {
                            invoke2(intRect, intRect2);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(IntRect intRect, IntRect intRect2) {
                            mutableState22.setValue(TransformOrigin.m4440boximpl(MenuKt.calculateTransformOrigin(intRect, intRect2)));
                        }
                    }, 4, null);
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                    startRestartGroup.endReplaceableGroup();
                    final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3322 = function32;
                    AndroidPopup_androidKt.Popup((DropdownMenuPositionProvider) rememberedValue3, function0, popupProperties3, ComposableLambdaKt.composableLambda(startRestartGroup, -848116919, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidMenu_androidKt$DropdownMenu$1
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

                        public final void invoke(Composer composer3, int i8) {
                            ComposerKt.sourceInformation(composer3, "C112@5481L256:AndroidMenu.android.kt#uh7d8r");
                            if ((i8 & 3) != 2 || !composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-848116919, i8, -1, "androidx.compose.material3.DropdownMenu.<anonymous> (AndroidMenu.android.kt:112)");
                                }
                                MenuKt.DropdownMenuContent(mutableTransitionState, mutableState22, scrollState3, modifier3, function3322, composer3, MutableTransitionState.$stable | 48, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer3.skipToGroupEnd();
                        }
                    }), startRestartGroup, (i3 & 112) | 3072 | ((i3 >> 9) & 896), 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    popupProperties4 = popupProperties3;
                    composer2 = startRestartGroup;
                    scrollState4 = scrollState3;
                    modifier4 = modifier3;
                    j4 = j3;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                j2 = j;
                if ((i & 24576) != 0) {
                }
                i6 = i2 & 32;
                if (i6 == 0) {
                }
                popupProperties2 = popupProperties;
                if ((i2 & 64) != 0) {
                }
                if ((i3 & 599187) == 599186) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i4 != 0) {
                }
                if (i5 != 0) {
                }
                if ((i2 & 16) != 0) {
                }
                if (i6 != 0) {
                }
                modifier3 = modifier2;
                j3 = j2;
                scrollState3 = scrollState2;
                popupProperties3 = popupProperties2;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                startRestartGroup.startReplaceableGroup(463006278);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):AndroidMenu.android.kt#9igjgp");
                rememberedValue = startRestartGroup.rememberedValue();
                if (rememberedValue != Composer.INSTANCE.getEmpty()) {
                }
                mutableTransitionState = (MutableTransitionState) rememberedValue;
                startRestartGroup.endReplaceableGroup();
                mutableTransitionState.setTargetState(Boolean.valueOf(z2));
                if (!((Boolean) mutableTransitionState.getCurrentState()).booleanValue()) {
                }
                startRestartGroup.startReplaceableGroup(463006465);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):AndroidMenu.android.kt#9igjgp");
                rememberedValue2 = startRestartGroup.rememberedValue();
                if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                }
                final MutableState<TransformOrigin> mutableState222 = (MutableState) rememberedValue2;
                startRestartGroup.endReplaceableGroup();
                ProvidableCompositionLocal<Density> localDensity222 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume222 = startRestartGroup.consume(localDensity222);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                Density density222 = (Density) consume222;
                startRestartGroup.startReplaceableGroup(463006596);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):AndroidMenu.android.kt#9igjgp");
                if ((i3 & 7168) == 2048) {
                }
                changed = z3 | startRestartGroup.changed(density222);
                rememberedValue3 = startRestartGroup.rememberedValue();
                if (!changed) {
                }
                rememberedValue3 = new DropdownMenuPositionProvider(j3, density222, 0, new Function2<IntRect, IntRect, Unit>() { // from class: androidx.compose.material3.AndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(IntRect intRect, IntRect intRect2) {
                        invoke2(intRect, intRect2);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(IntRect intRect, IntRect intRect2) {
                        mutableState222.setValue(TransformOrigin.m4440boximpl(MenuKt.calculateTransformOrigin(intRect, intRect2)));
                    }
                }, 4, null);
                startRestartGroup.updateRememberedValue(rememberedValue3);
                startRestartGroup.endReplaceableGroup();
                final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function33222 = function32;
                AndroidPopup_androidKt.Popup((DropdownMenuPositionProvider) rememberedValue3, function0, popupProperties3, ComposableLambdaKt.composableLambda(startRestartGroup, -848116919, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidMenu_androidKt$DropdownMenu$1
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

                    public final void invoke(Composer composer3, int i8) {
                        ComposerKt.sourceInformation(composer3, "C112@5481L256:AndroidMenu.android.kt#uh7d8r");
                        if ((i8 & 3) != 2 || !composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-848116919, i8, -1, "androidx.compose.material3.DropdownMenu.<anonymous> (AndroidMenu.android.kt:112)");
                            }
                            MenuKt.DropdownMenuContent(mutableTransitionState, mutableState222, scrollState3, modifier3, function33222, composer3, MutableTransitionState.$stable | 48, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer3.skipToGroupEnd();
                    }
                }), startRestartGroup, (i3 & 112) | 3072 | ((i3 >> 9) & 896), 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                popupProperties4 = popupProperties3;
                composer2 = startRestartGroup;
                scrollState4 = scrollState3;
                modifier4 = modifier3;
                j4 = j3;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            modifier2 = modifier;
            i5 = i2 & 8;
            if (i5 != 0) {
            }
            j2 = j;
            if ((i & 24576) != 0) {
            }
            i6 = i2 & 32;
            if (i6 == 0) {
            }
            popupProperties2 = popupProperties;
            if ((i2 & 64) != 0) {
            }
            if ((i3 & 599187) == 599186) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i4 != 0) {
            }
            if (i5 != 0) {
            }
            if ((i2 & 16) != 0) {
            }
            if (i6 != 0) {
            }
            modifier3 = modifier2;
            j3 = j2;
            scrollState3 = scrollState2;
            popupProperties3 = popupProperties2;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.startReplaceableGroup(463006278);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):AndroidMenu.android.kt#9igjgp");
            rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue != Composer.INSTANCE.getEmpty()) {
            }
            mutableTransitionState = (MutableTransitionState) rememberedValue;
            startRestartGroup.endReplaceableGroup();
            mutableTransitionState.setTargetState(Boolean.valueOf(z2));
            if (!((Boolean) mutableTransitionState.getCurrentState()).booleanValue()) {
            }
            startRestartGroup.startReplaceableGroup(463006465);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):AndroidMenu.android.kt#9igjgp");
            rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
            }
            final MutableState<TransformOrigin> mutableState2222 = (MutableState) rememberedValue2;
            startRestartGroup.endReplaceableGroup();
            ProvidableCompositionLocal<Density> localDensity2222 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume2222 = startRestartGroup.consume(localDensity2222);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Density density2222 = (Density) consume2222;
            startRestartGroup.startReplaceableGroup(463006596);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):AndroidMenu.android.kt#9igjgp");
            if ((i3 & 7168) == 2048) {
            }
            changed = z3 | startRestartGroup.changed(density2222);
            rememberedValue3 = startRestartGroup.rememberedValue();
            if (!changed) {
            }
            rememberedValue3 = new DropdownMenuPositionProvider(j3, density2222, 0, new Function2<IntRect, IntRect, Unit>() { // from class: androidx.compose.material3.AndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(IntRect intRect, IntRect intRect2) {
                    invoke2(intRect, intRect2);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(IntRect intRect, IntRect intRect2) {
                    mutableState2222.setValue(TransformOrigin.m4440boximpl(MenuKt.calculateTransformOrigin(intRect, intRect2)));
                }
            }, 4, null);
            startRestartGroup.updateRememberedValue(rememberedValue3);
            startRestartGroup.endReplaceableGroup();
            final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function332222 = function32;
            AndroidPopup_androidKt.Popup((DropdownMenuPositionProvider) rememberedValue3, function0, popupProperties3, ComposableLambdaKt.composableLambda(startRestartGroup, -848116919, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidMenu_androidKt$DropdownMenu$1
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

                public final void invoke(Composer composer3, int i8) {
                    ComposerKt.sourceInformation(composer3, "C112@5481L256:AndroidMenu.android.kt#uh7d8r");
                    if ((i8 & 3) != 2 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-848116919, i8, -1, "androidx.compose.material3.DropdownMenu.<anonymous> (AndroidMenu.android.kt:112)");
                        }
                        MenuKt.DropdownMenuContent(mutableTransitionState, mutableState2222, scrollState3, modifier3, function332222, composer3, MutableTransitionState.$stable | 48, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            }), startRestartGroup, (i3 & 112) | 3072 | ((i3 >> 9) & 896), 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            popupProperties4 = popupProperties3;
            composer2 = startRestartGroup;
            scrollState4 = scrollState3;
            modifier4 = modifier3;
            j4 = j3;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        modifier2 = modifier;
        i5 = i2 & 8;
        if (i5 != 0) {
        }
        j2 = j;
        if ((i & 24576) != 0) {
        }
        i6 = i2 & 32;
        if (i6 == 0) {
        }
        popupProperties2 = popupProperties;
        if ((i2 & 64) != 0) {
        }
        if ((i3 & 599187) == 599186) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i4 != 0) {
        }
        if (i5 != 0) {
        }
        if ((i2 & 16) != 0) {
        }
        if (i6 != 0) {
        }
        modifier3 = modifier2;
        j3 = j2;
        scrollState3 = scrollState2;
        popupProperties3 = popupProperties2;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        startRestartGroup.startReplaceableGroup(463006278);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):AndroidMenu.android.kt#9igjgp");
        rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue != Composer.INSTANCE.getEmpty()) {
        }
        mutableTransitionState = (MutableTransitionState) rememberedValue;
        startRestartGroup.endReplaceableGroup();
        mutableTransitionState.setTargetState(Boolean.valueOf(z2));
        if (!((Boolean) mutableTransitionState.getCurrentState()).booleanValue()) {
        }
        startRestartGroup.startReplaceableGroup(463006465);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):AndroidMenu.android.kt#9igjgp");
        rememberedValue2 = startRestartGroup.rememberedValue();
        if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
        }
        final MutableState<TransformOrigin> mutableState22222 = (MutableState) rememberedValue2;
        startRestartGroup.endReplaceableGroup();
        ProvidableCompositionLocal<Density> localDensity22222 = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume22222 = startRestartGroup.consume(localDensity22222);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        Density density22222 = (Density) consume22222;
        startRestartGroup.startReplaceableGroup(463006596);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):AndroidMenu.android.kt#9igjgp");
        if ((i3 & 7168) == 2048) {
        }
        changed = z3 | startRestartGroup.changed(density22222);
        rememberedValue3 = startRestartGroup.rememberedValue();
        if (!changed) {
        }
        rememberedValue3 = new DropdownMenuPositionProvider(j3, density22222, 0, new Function2<IntRect, IntRect, Unit>() { // from class: androidx.compose.material3.AndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(IntRect intRect, IntRect intRect2) {
                invoke2(intRect, intRect2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(IntRect intRect, IntRect intRect2) {
                mutableState22222.setValue(TransformOrigin.m4440boximpl(MenuKt.calculateTransformOrigin(intRect, intRect2)));
            }
        }, 4, null);
        startRestartGroup.updateRememberedValue(rememberedValue3);
        startRestartGroup.endReplaceableGroup();
        final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3322222 = function32;
        AndroidPopup_androidKt.Popup((DropdownMenuPositionProvider) rememberedValue3, function0, popupProperties3, ComposableLambdaKt.composableLambda(startRestartGroup, -848116919, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidMenu_androidKt$DropdownMenu$1
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

            public final void invoke(Composer composer3, int i8) {
                ComposerKt.sourceInformation(composer3, "C112@5481L256:AndroidMenu.android.kt#uh7d8r");
                if ((i8 & 3) != 2 || !composer3.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-848116919, i8, -1, "androidx.compose.material3.DropdownMenu.<anonymous> (AndroidMenu.android.kt:112)");
                    }
                    MenuKt.DropdownMenuContent(mutableTransitionState, mutableState22222, scrollState3, modifier3, function3322222, composer3, MutableTransitionState.$stable | 48, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer3.skipToGroupEnd();
            }
        }), startRestartGroup, (i3 & 112) | 3072 | ((i3 >> 9) & 896), 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        popupProperties4 = popupProperties3;
        composer2 = startRestartGroup;
        scrollState4 = scrollState3;
        modifier4 = modifier3;
        j4 = j3;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0069  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Replaced by a DropdownMenu function with a ScrollState parameter", replaceWith = @ReplaceWith(expression = "DropdownMenu(expanded,onDismissRequest, modifier, offset, rememberScrollState(), properties, content)", imports = {"androidx.compose.foundation.rememberScrollState"}))
    /* renamed from: DropdownMenu-ILWXrKs, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void m1883DropdownMenuILWXrKs(final boolean z, final Function0 function0, Modifier modifier, long j, PopupProperties popupProperties, final Function3 function3, Composer composer, final int i, final int i2) {
        boolean z2;
        int i3;
        Function0 function02;
        Modifier modifier2;
        int i4;
        long j2;
        int i5;
        PopupProperties popupProperties2;
        Function3 function32;
        Composer composer2;
        final Modifier modifier3;
        final long j3;
        final PopupProperties popupProperties3;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(354826666);
        ComposerKt.sourceInformation(startRestartGroup, "C(DropdownMenu)P(1,4,2,3:c#ui.unit.DpOffset,5)146@6601L21,141@6457L219:AndroidMenu.android.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            z2 = z;
        } else {
            z2 = z;
            if ((i & 6) == 0) {
                i3 = (startRestartGroup.changed(z2) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
            function02 = function0;
        } else {
            function02 = function0;
            if ((i & 48) == 0) {
                i3 |= startRestartGroup.changedInstance(function02) ? 32 : 16;
            }
        }
        int i6 = i2 & 4;
        if (i6 != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 256 : 128;
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                j2 = j;
                i3 |= startRestartGroup.changed(j2) ? 2048 : 1024;
                i5 = i2 & 16;
                if (i5 != 0) {
                    i3 |= 24576;
                } else if ((i & 24576) == 0) {
                    popupProperties2 = popupProperties;
                    i3 |= startRestartGroup.changed(popupProperties2) ? 16384 : 8192;
                    if ((i2 & 32) == 0) {
                        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        function32 = function3;
                        i3 |= startRestartGroup.changedInstance(function32) ? 131072 : 65536;
                        if ((74899 & i3) == 74898 || !startRestartGroup.getSkipping()) {
                            Modifier.Companion companion = i6 != 0 ? Modifier.INSTANCE : modifier2;
                            if (i4 != 0) {
                                float f = 0;
                                j2 = DpKt.m6410DpOffsetYgX7TsA(Dp.m6389constructorimpl(f), Dp.m6389constructorimpl(f));
                            }
                            PopupProperties popupProperties4 = i5 != 0 ? new PopupProperties(true, false, false, null, false, false, 62, null) : popupProperties2;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(354826666, i3, -1, "androidx.compose.material3.DropdownMenu (AndroidMenu.android.kt:141)");
                            }
                            int i7 = i3 & 8190;
                            int i8 = i3 << 3;
                            composer2 = startRestartGroup;
                            Modifier modifier4 = companion;
                            long j4 = j2;
                            m1882DropdownMenu4kj_NE(z2, function02, modifier4, j4, ScrollKt.rememberScrollState(0, startRestartGroup, 0, 1), popupProperties4, function32, composer2, i7 | (458752 & i8) | (i8 & 3670016), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier4;
                            j3 = j4;
                            popupProperties3 = popupProperties4;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            composer2 = startRestartGroup;
                            modifier3 = modifier2;
                            j3 = j2;
                            popupProperties3 = popupProperties2;
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidMenu_androidKt$DropdownMenu$3
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

                                public final void invoke(Composer composer3, int i9) {
                                    AndroidMenu_androidKt.m1883DropdownMenuILWXrKs(z, function0, modifier3, j3, popupProperties3, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    function32 = function3;
                    if ((74899 & i3) == 74898) {
                    }
                    if (i6 != 0) {
                    }
                    if (i4 != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    int i72 = i3 & 8190;
                    int i82 = i3 << 3;
                    composer2 = startRestartGroup;
                    Modifier modifier42 = companion;
                    long j42 = j2;
                    m1882DropdownMenu4kj_NE(z2, function02, modifier42, j42, ScrollKt.rememberScrollState(0, startRestartGroup, 0, 1), popupProperties4, function32, composer2, i72 | (458752 & i82) | (i82 & 3670016), 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    modifier3 = modifier42;
                    j3 = j42;
                    popupProperties3 = popupProperties4;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                popupProperties2 = popupProperties;
                if ((i2 & 32) == 0) {
                }
                function32 = function3;
                if ((74899 & i3) == 74898) {
                }
                if (i6 != 0) {
                }
                if (i4 != 0) {
                }
                if (i5 != 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                int i722 = i3 & 8190;
                int i822 = i3 << 3;
                composer2 = startRestartGroup;
                Modifier modifier422 = companion;
                long j422 = j2;
                m1882DropdownMenu4kj_NE(z2, function02, modifier422, j422, ScrollKt.rememberScrollState(0, startRestartGroup, 0, 1), popupProperties4, function32, composer2, i722 | (458752 & i822) | (i822 & 3670016), 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier3 = modifier422;
                j3 = j422;
                popupProperties3 = popupProperties4;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            j2 = j;
            i5 = i2 & 16;
            if (i5 != 0) {
            }
            popupProperties2 = popupProperties;
            if ((i2 & 32) == 0) {
            }
            function32 = function3;
            if ((74899 & i3) == 74898) {
            }
            if (i6 != 0) {
            }
            if (i4 != 0) {
            }
            if (i5 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            int i7222 = i3 & 8190;
            int i8222 = i3 << 3;
            composer2 = startRestartGroup;
            Modifier modifier4222 = companion;
            long j4222 = j2;
            m1882DropdownMenu4kj_NE(z2, function02, modifier4222, j4222, ScrollKt.rememberScrollState(0, startRestartGroup, 0, 1), popupProperties4, function32, composer2, i7222 | (458752 & i8222) | (i8222 & 3670016), 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier3 = modifier4222;
            j3 = j4222;
            popupProperties3 = popupProperties4;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        j2 = j;
        i5 = i2 & 16;
        if (i5 != 0) {
        }
        popupProperties2 = popupProperties;
        if ((i2 & 32) == 0) {
        }
        function32 = function3;
        if ((74899 & i3) == 74898) {
        }
        if (i6 != 0) {
        }
        if (i4 != 0) {
        }
        if (i5 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        int i72222 = i3 & 8190;
        int i82222 = i3 << 3;
        composer2 = startRestartGroup;
        Modifier modifier42222 = companion;
        long j42222 = j2;
        m1882DropdownMenu4kj_NE(z2, function02, modifier42222, j42222, ScrollKt.rememberScrollState(0, startRestartGroup, 0, 1), popupProperties4, function32, composer2, i72222 | (458752 & i82222) | (i82222 & 3670016), 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier3 = modifier42222;
        j3 = j42222;
        popupProperties3 = popupProperties4;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x00de  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void DropdownMenuItem(final Function2<? super Composer, ? super Integer, Unit> function2, final Function0<Unit> function0, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, boolean z, MenuItemColors menuItemColors, PaddingValues paddingValues, MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2) {
        Function2<? super Composer, ? super Integer, Unit> function24;
        int i3;
        Function0<Unit> function02;
        Modifier modifier2;
        int i4;
        Function2<? super Composer, ? super Integer, Unit> function25;
        int i5;
        Function2<? super Composer, ? super Integer, Unit> function26;
        int i6;
        boolean z2;
        MenuItemColors menuItemColors2;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        MutableInteractionSource mutableInteractionSource2;
        PaddingValues paddingValues2;
        Composer composer2;
        final Modifier modifier3;
        final Function2<? super Composer, ? super Integer, Unit> function27;
        final Function2<? super Composer, ? super Integer, Unit> function28;
        final boolean z3;
        final MenuItemColors menuItemColors3;
        final PaddingValues paddingValues3;
        final MutableInteractionSource mutableInteractionSource3;
        ScopeUpdateScope endRestartGroup;
        int i12;
        Composer startRestartGroup = composer.startRestartGroup(1826340448);
        ComposerKt.sourceInformation(startRestartGroup, "C(DropdownMenuItem)P(7,6,5,4,8,2)186@8615L12,188@8760L39,190@8809L319:AndroidMenu.android.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            function24 = function2;
        } else {
            function24 = function2;
            if ((i & 6) == 0) {
                i3 = (startRestartGroup.changedInstance(function24) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
            function02 = function0;
        } else {
            function02 = function0;
            if ((i & 48) == 0) {
                i3 |= startRestartGroup.changedInstance(function02) ? 32 : 16;
            }
        }
        int i13 = i2 & 4;
        if (i13 != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 256 : 128;
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                function25 = function22;
                i3 |= startRestartGroup.changedInstance(function25) ? 2048 : 1024;
                i5 = i2 & 16;
                if (i5 != 0) {
                    i3 |= 24576;
                } else if ((i & 24576) == 0) {
                    function26 = function23;
                    i3 |= startRestartGroup.changedInstance(function26) ? 16384 : 8192;
                    i6 = i2 & 32;
                    if (i6 == 0) {
                        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((196608 & i) == 0) {
                        z2 = z;
                        i3 |= startRestartGroup.changed(z2) ? 131072 : 65536;
                        if ((1572864 & i) == 0) {
                            if ((i2 & 64) == 0) {
                                menuItemColors2 = menuItemColors;
                                if (startRestartGroup.changed(menuItemColors2)) {
                                    i12 = 1048576;
                                    i3 |= i12;
                                }
                            } else {
                                menuItemColors2 = menuItemColors;
                            }
                            i12 = 524288;
                            i3 |= i12;
                        } else {
                            menuItemColors2 = menuItemColors;
                        }
                        i7 = i2 & 128;
                        if (i7 != 0) {
                            i3 |= 12582912;
                        } else if ((i & 12582912) == 0) {
                            i8 = i7;
                            i3 |= startRestartGroup.changed(paddingValues) ? 8388608 : 4194304;
                            i9 = i2 & 256;
                            if (i9 == 0) {
                                i3 |= 100663296;
                            } else if ((i & 100663296) == 0) {
                                i10 = i9;
                                i3 |= startRestartGroup.changed(mutableInteractionSource) ? 67108864 : 33554432;
                                int i14 = i3;
                                if ((i3 & 38347923) == 38347922 || !startRestartGroup.getSkipping()) {
                                    startRestartGroup.startDefaults();
                                    if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                        if (i13 != 0) {
                                            modifier2 = Modifier.INSTANCE;
                                        }
                                        if (i4 != 0) {
                                            function25 = null;
                                        }
                                        if (i5 != 0) {
                                            function26 = null;
                                        }
                                        if (i6 != 0) {
                                            z2 = true;
                                        }
                                        if ((i2 & 64) != 0) {
                                            i11 = i14 & (-3670017);
                                            menuItemColors2 = MenuDefaults.INSTANCE.itemColors(startRestartGroup, 6);
                                        } else {
                                            i11 = i14;
                                        }
                                        PaddingValues dropdownMenuItemContentPadding = i8 != 0 ? MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding() : paddingValues;
                                        if (i10 != 0) {
                                            startRestartGroup.startReplaceableGroup(1989948114);
                                            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):AndroidMenu.android.kt#9igjgp");
                                            Object rememberedValue = startRestartGroup.rememberedValue();
                                            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                                rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                                startRestartGroup.updateRememberedValue(rememberedValue);
                                            }
                                            startRestartGroup.endReplaceableGroup();
                                            paddingValues2 = dropdownMenuItemContentPadding;
                                            mutableInteractionSource2 = (MutableInteractionSource) rememberedValue;
                                        } else {
                                            mutableInteractionSource2 = mutableInteractionSource;
                                            paddingValues2 = dropdownMenuItemContentPadding;
                                        }
                                    } else {
                                        startRestartGroup.skipToGroupEnd();
                                        if ((i2 & 64) != 0) {
                                            i11 = i14 & (-3670017);
                                            paddingValues2 = paddingValues;
                                            mutableInteractionSource2 = mutableInteractionSource;
                                        } else {
                                            paddingValues2 = paddingValues;
                                            mutableInteractionSource2 = mutableInteractionSource;
                                            i11 = i14;
                                        }
                                    }
                                    Function2<? super Composer, ? super Integer, Unit> function29 = function26;
                                    boolean z4 = z2;
                                    MenuItemColors menuItemColors4 = menuItemColors2;
                                    Modifier modifier4 = modifier2;
                                    Function2<? super Composer, ? super Integer, Unit> function210 = function25;
                                    startRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1826340448, i11, -1, "androidx.compose.material3.DropdownMenuItem (AndroidMenu.android.kt:189)");
                                    }
                                    composer2 = startRestartGroup;
                                    MenuKt.DropdownMenuItemContent(function24, function02, modifier4, function210, function29, z4, menuItemColors4, paddingValues2, mutableInteractionSource2, composer2, i11 & 268435454);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    modifier3 = modifier4;
                                    function27 = function210;
                                    function28 = function29;
                                    z3 = z4;
                                    menuItemColors3 = menuItemColors4;
                                    paddingValues3 = paddingValues2;
                                    mutableInteractionSource3 = mutableInteractionSource2;
                                } else {
                                    startRestartGroup.skipToGroupEnd();
                                    mutableInteractionSource3 = mutableInteractionSource;
                                    composer2 = startRestartGroup;
                                    modifier3 = modifier2;
                                    function27 = function25;
                                    function28 = function26;
                                    z3 = z2;
                                    menuItemColors3 = menuItemColors2;
                                    paddingValues3 = paddingValues;
                                }
                                endRestartGroup = composer2.endRestartGroup();
                                if (endRestartGroup != null) {
                                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidMenu_androidKt$DropdownMenuItem$2
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

                                        public final void invoke(Composer composer3, int i15) {
                                            AndroidMenu_androidKt.DropdownMenuItem(function2, function0, modifier3, function27, function28, z3, menuItemColors3, paddingValues3, mutableInteractionSource3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            i10 = i9;
                            int i142 = i3;
                            if ((i3 & 38347923) == 38347922) {
                            }
                            startRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                            }
                            if (i13 != 0) {
                            }
                            if (i4 != 0) {
                            }
                            if (i5 != 0) {
                            }
                            if (i6 != 0) {
                            }
                            if ((i2 & 64) != 0) {
                            }
                            if (i8 != 0) {
                            }
                            if (i10 != 0) {
                            }
                            Function2<? super Composer, ? super Integer, Unit> function292 = function26;
                            boolean z42 = z2;
                            MenuItemColors menuItemColors42 = menuItemColors2;
                            Modifier modifier42 = modifier2;
                            Function2<? super Composer, ? super Integer, Unit> function2102 = function25;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            composer2 = startRestartGroup;
                            MenuKt.DropdownMenuItemContent(function24, function02, modifier42, function2102, function292, z42, menuItemColors42, paddingValues2, mutableInteractionSource2, composer2, i11 & 268435454);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            modifier3 = modifier42;
                            function27 = function2102;
                            function28 = function292;
                            z3 = z42;
                            menuItemColors3 = menuItemColors42;
                            paddingValues3 = paddingValues2;
                            mutableInteractionSource3 = mutableInteractionSource2;
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup != null) {
                            }
                        }
                        i8 = i7;
                        i9 = i2 & 256;
                        if (i9 == 0) {
                        }
                        i10 = i9;
                        int i1422 = i3;
                        if ((i3 & 38347923) == 38347922) {
                        }
                        startRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                        }
                        if (i13 != 0) {
                        }
                        if (i4 != 0) {
                        }
                        if (i5 != 0) {
                        }
                        if (i6 != 0) {
                        }
                        if ((i2 & 64) != 0) {
                        }
                        if (i8 != 0) {
                        }
                        if (i10 != 0) {
                        }
                        Function2<? super Composer, ? super Integer, Unit> function2922 = function26;
                        boolean z422 = z2;
                        MenuItemColors menuItemColors422 = menuItemColors2;
                        Modifier modifier422 = modifier2;
                        Function2<? super Composer, ? super Integer, Unit> function21022 = function25;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        composer2 = startRestartGroup;
                        MenuKt.DropdownMenuItemContent(function24, function02, modifier422, function21022, function2922, z422, menuItemColors422, paddingValues2, mutableInteractionSource2, composer2, i11 & 268435454);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        modifier3 = modifier422;
                        function27 = function21022;
                        function28 = function2922;
                        z3 = z422;
                        menuItemColors3 = menuItemColors422;
                        paddingValues3 = paddingValues2;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                        }
                    }
                    z2 = z;
                    if ((1572864 & i) == 0) {
                    }
                    i7 = i2 & 128;
                    if (i7 != 0) {
                    }
                    i8 = i7;
                    i9 = i2 & 256;
                    if (i9 == 0) {
                    }
                    i10 = i9;
                    int i14222 = i3;
                    if ((i3 & 38347923) == 38347922) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i13 != 0) {
                    }
                    if (i4 != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if (i6 != 0) {
                    }
                    if ((i2 & 64) != 0) {
                    }
                    if (i8 != 0) {
                    }
                    if (i10 != 0) {
                    }
                    Function2<? super Composer, ? super Integer, Unit> function29222 = function26;
                    boolean z4222 = z2;
                    MenuItemColors menuItemColors4222 = menuItemColors2;
                    Modifier modifier4222 = modifier2;
                    Function2<? super Composer, ? super Integer, Unit> function210222 = function25;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    composer2 = startRestartGroup;
                    MenuKt.DropdownMenuItemContent(function24, function02, modifier4222, function210222, function29222, z4222, menuItemColors4222, paddingValues2, mutableInteractionSource2, composer2, i11 & 268435454);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    modifier3 = modifier4222;
                    function27 = function210222;
                    function28 = function29222;
                    z3 = z4222;
                    menuItemColors3 = menuItemColors4222;
                    paddingValues3 = paddingValues2;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                function26 = function23;
                i6 = i2 & 32;
                if (i6 == 0) {
                }
                z2 = z;
                if ((1572864 & i) == 0) {
                }
                i7 = i2 & 128;
                if (i7 != 0) {
                }
                i8 = i7;
                i9 = i2 & 256;
                if (i9 == 0) {
                }
                i10 = i9;
                int i142222 = i3;
                if ((i3 & 38347923) == 38347922) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i13 != 0) {
                }
                if (i4 != 0) {
                }
                if (i5 != 0) {
                }
                if (i6 != 0) {
                }
                if ((i2 & 64) != 0) {
                }
                if (i8 != 0) {
                }
                if (i10 != 0) {
                }
                Function2<? super Composer, ? super Integer, Unit> function292222 = function26;
                boolean z42222 = z2;
                MenuItemColors menuItemColors42222 = menuItemColors2;
                Modifier modifier42222 = modifier2;
                Function2<? super Composer, ? super Integer, Unit> function2102222 = function25;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                composer2 = startRestartGroup;
                MenuKt.DropdownMenuItemContent(function24, function02, modifier42222, function2102222, function292222, z42222, menuItemColors42222, paddingValues2, mutableInteractionSource2, composer2, i11 & 268435454);
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier3 = modifier42222;
                function27 = function2102222;
                function28 = function292222;
                z3 = z42222;
                menuItemColors3 = menuItemColors42222;
                paddingValues3 = paddingValues2;
                mutableInteractionSource3 = mutableInteractionSource2;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            function25 = function22;
            i5 = i2 & 16;
            if (i5 != 0) {
            }
            function26 = function23;
            i6 = i2 & 32;
            if (i6 == 0) {
            }
            z2 = z;
            if ((1572864 & i) == 0) {
            }
            i7 = i2 & 128;
            if (i7 != 0) {
            }
            i8 = i7;
            i9 = i2 & 256;
            if (i9 == 0) {
            }
            i10 = i9;
            int i1422222 = i3;
            if ((i3 & 38347923) == 38347922) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i13 != 0) {
            }
            if (i4 != 0) {
            }
            if (i5 != 0) {
            }
            if (i6 != 0) {
            }
            if ((i2 & 64) != 0) {
            }
            if (i8 != 0) {
            }
            if (i10 != 0) {
            }
            Function2<? super Composer, ? super Integer, Unit> function2922222 = function26;
            boolean z422222 = z2;
            MenuItemColors menuItemColors422222 = menuItemColors2;
            Modifier modifier422222 = modifier2;
            Function2<? super Composer, ? super Integer, Unit> function21022222 = function25;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            composer2 = startRestartGroup;
            MenuKt.DropdownMenuItemContent(function24, function02, modifier422222, function21022222, function2922222, z422222, menuItemColors422222, paddingValues2, mutableInteractionSource2, composer2, i11 & 268435454);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier3 = modifier422222;
            function27 = function21022222;
            function28 = function2922222;
            z3 = z422222;
            menuItemColors3 = menuItemColors422222;
            paddingValues3 = paddingValues2;
            mutableInteractionSource3 = mutableInteractionSource2;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        function25 = function22;
        i5 = i2 & 16;
        if (i5 != 0) {
        }
        function26 = function23;
        i6 = i2 & 32;
        if (i6 == 0) {
        }
        z2 = z;
        if ((1572864 & i) == 0) {
        }
        i7 = i2 & 128;
        if (i7 != 0) {
        }
        i8 = i7;
        i9 = i2 & 256;
        if (i9 == 0) {
        }
        i10 = i9;
        int i14222222 = i3;
        if ((i3 & 38347923) == 38347922) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i13 != 0) {
        }
        if (i4 != 0) {
        }
        if (i5 != 0) {
        }
        if (i6 != 0) {
        }
        if ((i2 & 64) != 0) {
        }
        if (i8 != 0) {
        }
        if (i10 != 0) {
        }
        Function2<? super Composer, ? super Integer, Unit> function29222222 = function26;
        boolean z4222222 = z2;
        MenuItemColors menuItemColors4222222 = menuItemColors2;
        Modifier modifier4222222 = modifier2;
        Function2<? super Composer, ? super Integer, Unit> function210222222 = function25;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        composer2 = startRestartGroup;
        MenuKt.DropdownMenuItemContent(function24, function02, modifier4222222, function210222222, function29222222, z4222222, menuItemColors4222222, paddingValues2, mutableInteractionSource2, composer2, i11 & 268435454);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier3 = modifier4222222;
        function27 = function210222222;
        function28 = function29222222;
        z3 = z4222222;
        menuItemColors3 = menuItemColors4222222;
        paddingValues3 = paddingValues2;
        mutableInteractionSource3 = mutableInteractionSource2;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }
}
