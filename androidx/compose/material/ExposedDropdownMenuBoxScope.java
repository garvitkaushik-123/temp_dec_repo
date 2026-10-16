package androidx.compose.material;

import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.material.internal.ExposedDropdownMenuPopup_androidKt;
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
import androidx.compose.ui.unit.DpOffset;
import androidx.compose.ui.unit.IntRect;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* compiled from: ExposedDropdownMenu.android.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001JU\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00030\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0017¢\u0006\u0002\u0010\u0011J\u0016\u0010\u0012\u001a\u00020\t*\u00020\t2\b\b\u0002\u0010\u0013\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0014À\u0006\u0003"}, d2 = {"Landroidx/compose/material/ExposedDropdownMenuBoxScope;", "", "ExposedDropdownMenu", "", "expanded", "", "onDismissRequest", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "scrollState", "Landroidx/compose/foundation/ScrollState;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/ScrollState;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "exposedDropdownSize", "matchTextFieldWidth", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public interface ExposedDropdownMenuBoxScope {
    Modifier exposedDropdownSize(Modifier modifier, boolean z);

    /* compiled from: ExposedDropdownMenu.android.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static void ExposedDropdownMenu(ExposedDropdownMenuBoxScope exposedDropdownMenuBoxScope, boolean z, Function0<Unit> function0, Modifier modifier, ScrollState scrollState, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, int i, int i2) {
            ExposedDropdownMenuBoxScope.super.ExposedDropdownMenu(z, function0, modifier, scrollState, function3, composer, i, i2);
        }
    }

    static /* synthetic */ Modifier exposedDropdownSize$default(ExposedDropdownMenuBoxScope exposedDropdownMenuBoxScope, Modifier modifier, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: exposedDropdownSize");
        }
        if ((i & 1) != 0) {
            z = true;
        }
        return exposedDropdownMenuBoxScope.exposedDropdownSize(modifier, z);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    default void ExposedDropdownMenu(boolean z, final Function0<Unit> function0, Modifier modifier, ScrollState scrollState, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        boolean z2;
        int i3;
        Function0<Unit> function02;
        int i4;
        Modifier modifier2;
        ScrollState scrollState2;
        Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function32;
        final ExposedDropdownMenuBoxScope exposedDropdownMenuBoxScope;
        final Modifier modifier3;
        final ScrollState rememberScrollState;
        Object rememberedValue;
        final MutableTransitionState mutableTransitionState;
        Object rememberedValue2;
        boolean changed;
        Object rememberedValue3;
        final ScrollState scrollState3;
        int i5;
        Composer startRestartGroup = composer.startRestartGroup(63962088);
        ComposerKt.sourceInformation(startRestartGroup, "C(ExposedDropdownMenu)P(1,3,2,4)236@9131L21,248@9631L42,252@9833L51,253@9924L7,261@10224L491:ExposedDropdownMenu.android.kt#jmzs0o");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            z2 = z;
        } else {
            z2 = z;
            if ((i & 14) == 0) {
                i3 = (startRestartGroup.changed(z2) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 112) == 0) {
            function02 = function0;
            i3 |= startRestartGroup.changedInstance(function02) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= 384;
            } else if ((i & 896) == 0) {
                modifier2 = modifier;
                i3 |= startRestartGroup.changed(modifier2) ? 256 : 128;
                if ((i & 7168) == 0) {
                    if ((i2 & 8) == 0) {
                        scrollState2 = scrollState;
                        if (startRestartGroup.changed(scrollState2)) {
                            i5 = 2048;
                            i3 |= i5;
                        }
                    } else {
                        scrollState2 = scrollState;
                    }
                    i5 = 1024;
                    i3 |= i5;
                } else {
                    scrollState2 = scrollState;
                }
                if ((i2 & 16) != 0) {
                    i3 |= 24576;
                } else if ((57344 & i) == 0) {
                    function32 = function3;
                    i3 |= startRestartGroup.changedInstance(function32) ? 16384 : 8192;
                    if ((i2 & 32) == 0) {
                        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        exposedDropdownMenuBoxScope = this;
                    } else {
                        exposedDropdownMenuBoxScope = this;
                        if ((458752 & i) == 0) {
                            i3 |= startRestartGroup.changed(exposedDropdownMenuBoxScope) ? 131072 : 65536;
                        }
                    }
                    if ((374491 & i3) == 74898 || !startRestartGroup.getSkipping()) {
                        startRestartGroup.startDefaults();
                        if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                            Modifier.Companion companion = i4 == 0 ? Modifier.INSTANCE : modifier2;
                            if ((i2 & 8) == 0) {
                                i3 &= -7169;
                                modifier3 = companion;
                                rememberScrollState = ScrollKt.rememberScrollState(0, startRestartGroup, 0, 1);
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(63962088, i3, -1, "androidx.compose.material.ExposedDropdownMenuBoxScope.ExposedDropdownMenu (ExposedDropdownMenu.android.kt:238)");
                                }
                                startRestartGroup.startReplaceableGroup(-492369756);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                                rememberedValue = startRestartGroup.rememberedValue();
                                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue = new MutableTransitionState(false);
                                    startRestartGroup.updateRememberedValue(rememberedValue);
                                }
                                startRestartGroup.endReplaceableGroup();
                                mutableTransitionState = (MutableTransitionState) rememberedValue;
                                mutableTransitionState.setTargetState(Boolean.valueOf(z2));
                                if (!((Boolean) mutableTransitionState.getCurrentState()).booleanValue() || ((Boolean) mutableTransitionState.getTargetState()).booleanValue()) {
                                    startRestartGroup.startReplaceableGroup(-492369756);
                                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                                    rememberedValue2 = startRestartGroup.rememberedValue();
                                    if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TransformOrigin.m4440boximpl(TransformOrigin.INSTANCE.m4453getCenterSzJe1aQ()), null, 2, null);
                                        startRestartGroup.updateRememberedValue(rememberedValue2);
                                    }
                                    startRestartGroup.endReplaceableGroup();
                                    final MutableState mutableState = (MutableState) rememberedValue2;
                                    ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                    Object consume = startRestartGroup.consume(localDensity);
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    Density density = (Density) consume;
                                    long m6460getZeroRKDOV3M = DpOffset.INSTANCE.m6460getZeroRKDOV3M();
                                    startRestartGroup.startReplaceableGroup(1959168883);
                                    changed = startRestartGroup.changed(mutableState);
                                    rememberedValue3 = startRestartGroup.rememberedValue();
                                    if (!changed || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue3 = (Function2) new Function2<IntRect, IntRect, Unit>() { // from class: androidx.compose.material.ExposedDropdownMenuBoxScope$ExposedDropdownMenu$popupPositionProvider$1$1
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
                                        };
                                        startRestartGroup.updateRememberedValue(rememberedValue3);
                                    }
                                    startRestartGroup.endReplaceableGroup();
                                    final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function33 = function32;
                                    ExposedDropdownMenuPopup_androidKt.ExposedDropdownMenuPopup(function02, new DropdownMenuPositionProvider(m6460getZeroRKDOV3M, density, (Function2) rememberedValue3, null), ComposableLambdaKt.composableLambda(startRestartGroup, 1001349006, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ExposedDropdownMenuBoxScope$ExposedDropdownMenu$1
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
                                            ComposerKt.sourceInformation(composer2, "C265@10397L304:ExposedDropdownMenu.android.kt#jmzs0o");
                                            if ((i6 & 11) != 2 || !composer2.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(1001349006, i6, -1, "androidx.compose.material.ExposedDropdownMenuBoxScope.ExposedDropdownMenu.<anonymous> (ExposedDropdownMenu.android.kt:265)");
                                                }
                                                MenuKt.DropdownMenuContent(mutableTransitionState, mutableState, rememberScrollState, ExposedDropdownMenuBoxScope.exposedDropdownSize$default(exposedDropdownMenuBoxScope, modifier3, false, 1, null), function33, composer2, MutableTransitionState.$stable | 48, 0);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            composer2.skipToGroupEnd();
                                        }
                                    }), startRestartGroup, ((i3 >> 3) & 14) | 384, 0);
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                scrollState3 = rememberScrollState;
                            } else {
                                modifier3 = companion;
                            }
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            if ((i2 & 8) != 0) {
                                i3 &= -7169;
                            }
                            modifier3 = modifier2;
                        }
                        rememberScrollState = scrollState2;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        startRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                        rememberedValue = startRestartGroup.rememberedValue();
                        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                        }
                        startRestartGroup.endReplaceableGroup();
                        mutableTransitionState = (MutableTransitionState) rememberedValue;
                        mutableTransitionState.setTargetState(Boolean.valueOf(z2));
                        if (!((Boolean) mutableTransitionState.getCurrentState()).booleanValue()) {
                        }
                        startRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                        rememberedValue2 = startRestartGroup.rememberedValue();
                        if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        }
                        startRestartGroup.endReplaceableGroup();
                        final MutableState<TransformOrigin> mutableState2 = (MutableState) rememberedValue2;
                        ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object consume2 = startRestartGroup.consume(localDensity2);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        Density density2 = (Density) consume2;
                        long m6460getZeroRKDOV3M2 = DpOffset.INSTANCE.m6460getZeroRKDOV3M();
                        startRestartGroup.startReplaceableGroup(1959168883);
                        changed = startRestartGroup.changed(mutableState2);
                        rememberedValue3 = startRestartGroup.rememberedValue();
                        if (!changed) {
                        }
                        rememberedValue3 = (Function2) new Function2<IntRect, IntRect, Unit>() { // from class: androidx.compose.material.ExposedDropdownMenuBoxScope$ExposedDropdownMenu$popupPositionProvider$1$1
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
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue3);
                        startRestartGroup.endReplaceableGroup();
                        final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function332 = function32;
                        ExposedDropdownMenuPopup_androidKt.ExposedDropdownMenuPopup(function02, new DropdownMenuPositionProvider(m6460getZeroRKDOV3M2, density2, (Function2) rememberedValue3, null), ComposableLambdaKt.composableLambda(startRestartGroup, 1001349006, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ExposedDropdownMenuBoxScope$ExposedDropdownMenu$1
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
                                ComposerKt.sourceInformation(composer2, "C265@10397L304:ExposedDropdownMenu.android.kt#jmzs0o");
                                if ((i6 & 11) != 2 || !composer2.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1001349006, i6, -1, "androidx.compose.material.ExposedDropdownMenuBoxScope.ExposedDropdownMenu.<anonymous> (ExposedDropdownMenu.android.kt:265)");
                                    }
                                    MenuKt.DropdownMenuContent(mutableTransitionState, mutableState2, rememberScrollState, ExposedDropdownMenuBoxScope.exposedDropdownSize$default(exposedDropdownMenuBoxScope, modifier3, false, 1, null), function332, composer2, MutableTransitionState.$stable | 48, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer2.skipToGroupEnd();
                            }
                        }), startRestartGroup, ((i3 >> 3) & 14) | 384, 0);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        scrollState3 = rememberScrollState;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        modifier3 = modifier2;
                        scrollState3 = scrollState2;
                    }
                    ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                        final boolean z3 = z2;
                        final Modifier modifier4 = modifier3;
                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ExposedDropdownMenuBoxScope$ExposedDropdownMenu$2
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
                                ExposedDropdownMenuBoxScope.this.ExposedDropdownMenu(z3, function0, modifier4, scrollState3, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                        return;
                    }
                    return;
                }
                function32 = function3;
                if ((i2 & 32) == 0) {
                }
                if ((374491 & i3) == 74898) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i4 == 0) {
                }
                if ((i2 & 8) == 0) {
                }
            }
            modifier2 = modifier;
            if ((i & 7168) == 0) {
            }
            if ((i2 & 16) != 0) {
            }
            function32 = function3;
            if ((i2 & 32) == 0) {
            }
            if ((374491 & i3) == 74898) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i4 == 0) {
            }
            if ((i2 & 8) == 0) {
            }
        }
        function02 = function0;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        modifier2 = modifier;
        if ((i & 7168) == 0) {
        }
        if ((i2 & 16) != 0) {
        }
        function32 = function3;
        if ((i2 & 32) == 0) {
        }
        if ((374491 & i3) == 74898) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i4 == 0) {
        }
        if ((i2 & 8) == 0) {
        }
    }
}
