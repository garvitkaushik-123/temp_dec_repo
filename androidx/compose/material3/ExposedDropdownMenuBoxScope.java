package androidx.compose.material3;

import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.material3.internal.ExposedDropdownMenuPopup_androidKt;
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
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b'\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002JU\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\u001c\u0010\r\u001a\u0018\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00040\u000e¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0002\u0010\u0012J\u0016\u0010\u0013\u001a\u00020\n*\u00020\n2\b\b\u0002\u0010\u0014\u001a\u00020\u0006H&J\f\u0010\u0015\u001a\u00020\n*\u00020\nH&¨\u0006\u0016"}, d2 = {"Landroidx/compose/material3/ExposedDropdownMenuBoxScope;", "", "()V", "ExposedDropdownMenu", "", "expanded", "", "onDismissRequest", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "scrollState", "Landroidx/compose/foundation/ScrollState;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/ScrollState;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "exposedDropdownSize", "matchTextFieldWidth", "menuAnchor", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class ExposedDropdownMenuBoxScope {
    public static final int $stable = 0;

    public abstract Modifier exposedDropdownSize(Modifier modifier, boolean z);

    public abstract Modifier menuAnchor(Modifier modifier);

    public static /* synthetic */ Modifier exposedDropdownSize$default(ExposedDropdownMenuBoxScope exposedDropdownMenuBoxScope, Modifier modifier, boolean z, int i, Object obj) {
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
    /* JADX WARN: Removed duplicated region for block: B:29:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void ExposedDropdownMenu(boolean z, final Function0<Unit> function0, Modifier modifier, ScrollState scrollState, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
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
        Composer startRestartGroup = composer.startRestartGroup(1729549851);
        ComposerKt.sourceInformation(startRestartGroup, "C(ExposedDropdownMenu)P(1,3,2,4)266@12013L21,278@12512L42,282@12711L51,283@12802L7,284@12850L309,293@13173L489:ExposedDropdownMenu.android.kt#uh7d8r");
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
            function02 = function0;
            i3 |= startRestartGroup.changedInstance(function02) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= 384;
            } else if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= startRestartGroup.changed(modifier2) ? 256 : 128;
                if ((i & 3072) == 0) {
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
                } else if ((i & 24576) == 0) {
                    function32 = function3;
                    i3 |= startRestartGroup.changedInstance(function32) ? 16384 : 8192;
                    if ((i2 & 32) == 0) {
                        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        exposedDropdownMenuBoxScope = this;
                    } else {
                        exposedDropdownMenuBoxScope = this;
                        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                            i3 |= startRestartGroup.changed(exposedDropdownMenuBoxScope) ? 131072 : 65536;
                        }
                    }
                    if ((74899 & i3) == 74898 || !startRestartGroup.getSkipping()) {
                        startRestartGroup.startDefaults();
                        if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                            Modifier.Companion companion = i4 == 0 ? Modifier.INSTANCE : modifier2;
                            if ((i2 & 8) == 0) {
                                i3 &= -7169;
                                modifier3 = companion;
                                rememberScrollState = ScrollKt.rememberScrollState(0, startRestartGroup, 0, 1);
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1729549851, i3, -1, "androidx.compose.material3.ExposedDropdownMenuBoxScope.ExposedDropdownMenu (ExposedDropdownMenu.android.kt:268)");
                                }
                                startRestartGroup.startReplaceableGroup(1950029224);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ExposedDropdownMenu.android.kt#9igjgp");
                                rememberedValue = startRestartGroup.rememberedValue();
                                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue = new MutableTransitionState(false);
                                    startRestartGroup.updateRememberedValue(rememberedValue);
                                }
                                mutableTransitionState = (MutableTransitionState) rememberedValue;
                                startRestartGroup.endReplaceableGroup();
                                mutableTransitionState.setTargetState(Boolean.valueOf(z2));
                                if (!((Boolean) mutableTransitionState.getCurrentState()).booleanValue() || ((Boolean) mutableTransitionState.getTargetState()).booleanValue()) {
                                    startRestartGroup.startReplaceableGroup(1950029423);
                                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ExposedDropdownMenu.android.kt#9igjgp");
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
                                    startRestartGroup.startReplaceableGroup(1950029562);
                                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ExposedDropdownMenu.android.kt#9igjgp");
                                    changed = startRestartGroup.changed(density);
                                    rememberedValue3 = startRestartGroup.rememberedValue();
                                    if (!changed || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue3 = new DropdownMenuPositionProvider(DpOffset.INSTANCE.m6460getZeroRKDOV3M(), density, 0, new Function2<IntRect, IntRect, Unit>() { // from class: androidx.compose.material3.ExposedDropdownMenuBoxScope$ExposedDropdownMenu$popupPositionProvider$1$1
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
                                    ExposedDropdownMenuPopup_androidKt.ExposedDropdownMenuPopup(function02, (DropdownMenuPositionProvider) rememberedValue3, ComposableLambdaKt.composableLambda(startRestartGroup, 723773237, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ExposedDropdownMenuBoxScope$ExposedDropdownMenu$1
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
                                            ComposerKt.sourceInformation(composer2, "C297@13346L302:ExposedDropdownMenu.android.kt#uh7d8r");
                                            if ((i6 & 3) != 2 || !composer2.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(723773237, i6, -1, "androidx.compose.material3.ExposedDropdownMenuBoxScope.ExposedDropdownMenu.<anonymous> (ExposedDropdownMenu.android.kt:297)");
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
                        startRestartGroup.startReplaceableGroup(1950029224);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ExposedDropdownMenu.android.kt#9igjgp");
                        rememberedValue = startRestartGroup.rememberedValue();
                        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                        }
                        mutableTransitionState = (MutableTransitionState) rememberedValue;
                        startRestartGroup.endReplaceableGroup();
                        mutableTransitionState.setTargetState(Boolean.valueOf(z2));
                        if (!((Boolean) mutableTransitionState.getCurrentState()).booleanValue()) {
                        }
                        startRestartGroup.startReplaceableGroup(1950029423);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ExposedDropdownMenu.android.kt#9igjgp");
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
                        startRestartGroup.startReplaceableGroup(1950029562);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ExposedDropdownMenu.android.kt#9igjgp");
                        changed = startRestartGroup.changed(density2);
                        rememberedValue3 = startRestartGroup.rememberedValue();
                        if (!changed) {
                        }
                        rememberedValue3 = new DropdownMenuPositionProvider(DpOffset.INSTANCE.m6460getZeroRKDOV3M(), density2, 0, new Function2<IntRect, IntRect, Unit>() { // from class: androidx.compose.material3.ExposedDropdownMenuBoxScope$ExposedDropdownMenu$popupPositionProvider$1$1
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
                        ExposedDropdownMenuPopup_androidKt.ExposedDropdownMenuPopup(function02, (DropdownMenuPositionProvider) rememberedValue3, ComposableLambdaKt.composableLambda(startRestartGroup, 723773237, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ExposedDropdownMenuBoxScope$ExposedDropdownMenu$1
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
                                ComposerKt.sourceInformation(composer2, "C297@13346L302:ExposedDropdownMenu.android.kt#uh7d8r");
                                if ((i6 & 3) != 2 || !composer2.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(723773237, i6, -1, "androidx.compose.material3.ExposedDropdownMenuBoxScope.ExposedDropdownMenu.<anonymous> (ExposedDropdownMenu.android.kt:297)");
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
                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ExposedDropdownMenuBoxScope$ExposedDropdownMenu$2
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
                if ((74899 & i3) == 74898) {
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
            if ((i & 3072) == 0) {
            }
            if ((i2 & 16) != 0) {
            }
            function32 = function3;
            if ((i2 & 32) == 0) {
            }
            if ((74899 & i3) == 74898) {
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
        if ((i & 3072) == 0) {
        }
        if ((i2 & 16) != 0) {
        }
        function32 = function3;
        if ((i2 & 32) == 0) {
        }
        if ((74899 & i3) == 74898) {
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
