package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.ToggleableKt;
import androidx.compose.material.ripple.RippleKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.CornerRadiusKt;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.state.ToggleableState;
import androidx.compose.ui.state.ToggleableStateKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.util.MathHelpersKt;
import androidx.profileinstaller.ProfileVerifier;
import com.vungle.ads.internal.protos.Sdk;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FloatCompanionObject;

/* compiled from: Checkbox.kt */
@Metadata(d1 = {"\u0000h\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aS\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\f\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u000e2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0007¢\u0006\u0002\u0010\u0018\u001a-\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017H\u0003¢\u0006\u0002\u0010\u001c\u001aM\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u001b2\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010 2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u000e2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0007¢\u0006\u0002\u0010!\u001a6\u0010\"\u001a\u00020\f*\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020(H\u0002ø\u0001\u0000¢\u0006\u0004\b*\u0010+\u001a>\u0010,\u001a\u00020\f*\u00020#2\u0006\u0010-\u001a\u00020%2\u0006\u0010.\u001a\u00020(2\u0006\u0010/\u001a\u00020(2\u0006\u00100\u001a\u00020(2\u0006\u00101\u001a\u000202H\u0002ø\u0001\u0000¢\u0006\u0004\b3\u00104\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006\"\u0010\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006\"\u0010\u0010\b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006\"\u0010\u0010\t\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006\"\u0010\u0010\n\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00065²\u0006\n\u00106\u001a\u00020(X\u008a\u0084\u0002²\u0006\n\u00107\u001a\u00020(X\u008a\u0084\u0002²\u0006\n\u0010-\u001a\u00020%X\u008a\u0084\u0002²\u0006\n\u0010$\u001a\u00020%X\u008a\u0084\u0002²\u0006\n\u0010&\u001a\u00020%X\u008a\u0084\u0002"}, d2 = {"BoxInDuration", "", "BoxOutDuration", "CheckAnimationDuration", "CheckboxDefaultPadding", "Landroidx/compose/ui/unit/Dp;", "F", "CheckboxRippleRadius", "CheckboxSize", "RadiusSize", "StrokeWidth", "Checkbox", "", "checked", "", "onCheckedChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "colors", "Landroidx/compose/material/CheckboxColors;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/material/CheckboxColors;Landroidx/compose/runtime/Composer;II)V", "CheckboxImpl", "value", "Landroidx/compose/ui/state/ToggleableState;", "(ZLandroidx/compose/ui/state/ToggleableState;Landroidx/compose/ui/Modifier;Landroidx/compose/material/CheckboxColors;Landroidx/compose/runtime/Composer;I)V", "TriStateCheckbox", "state", "onClick", "Lkotlin/Function0;", "(Landroidx/compose/ui/state/ToggleableState;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/material/CheckboxColors;Landroidx/compose/runtime/Composer;II)V", "drawBox", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "boxColor", "Landroidx/compose/ui/graphics/Color;", "borderColor", "radius", "", "strokeWidth", "drawBox-1wkBAMs", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JJFF)V", "drawCheck", "checkColor", "checkFraction", "crossCenterGravitation", "strokeWidthPx", "drawingCache", "Landroidx/compose/material/CheckDrawingCache;", "drawCheck-3IgeMak", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JFFFLandroidx/compose/material/CheckDrawingCache;)V", "material_release", "checkDrawFraction", "checkCenterGravitationShiftFraction"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CheckboxKt {
    private static final int BoxInDuration = 50;
    private static final int BoxOutDuration = 100;
    private static final int CheckAnimationDuration = 100;
    private static final float CheckboxDefaultPadding;
    private static final float CheckboxRippleRadius = Dp.m6389constructorimpl(24);
    private static final float CheckboxSize = Dp.m6389constructorimpl(20);
    private static final float RadiusSize;
    private static final float StrokeWidth;

    /* compiled from: Checkbox.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ToggleableState.values().length];
            try {
                iArr[ToggleableState.On.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ToggleableState.Off.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ToggleableState.Indeterminate.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0065  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void Checkbox(final boolean z, final Function1<? super Boolean, Unit> function1, Modifier modifier, boolean z2, MutableInteractionSource mutableInteractionSource, CheckboxColors checkboxColors, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        boolean z3;
        int i5;
        MutableInteractionSource mutableInteractionSource2;
        CheckboxColors checkboxColors2;
        MutableInteractionSource mutableInteractionSource3;
        Modifier modifier3;
        MutableInteractionSource mutableInteractionSource4;
        CheckboxColors checkboxColors3;
        boolean z4;
        Function0 function0;
        final Modifier modifier4;
        final boolean z5;
        final MutableInteractionSource mutableInteractionSource5;
        final CheckboxColors checkboxColors4;
        ScopeUpdateScope endRestartGroup;
        int i6;
        Composer startRestartGroup = composer.startRestartGroup(-2118660998);
        ComposerKt.sourceInformation(startRestartGroup, "C(Checkbox)P(!1,5,4,2,3)90@4153L39,91@4240L8,93@4257L284:Checkbox.kt#jmzs0o");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (startRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 112) == 0) {
            i3 |= startRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        int i7 = i2 & 4;
        if (i7 != 0) {
            i3 |= 384;
        } else if ((i & 896) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 256 : 128;
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else if ((i & 7168) == 0) {
                z3 = z2;
                i3 |= startRestartGroup.changed(z3) ? 2048 : 1024;
                i5 = i2 & 16;
                if (i5 != 0) {
                    i3 |= 24576;
                } else if ((57344 & i) == 0) {
                    mutableInteractionSource2 = mutableInteractionSource;
                    i3 |= startRestartGroup.changed(mutableInteractionSource2) ? 16384 : 8192;
                    if ((458752 & i) != 0) {
                        if ((i2 & 32) == 0) {
                            checkboxColors2 = checkboxColors;
                            if (startRestartGroup.changed(checkboxColors2)) {
                                i6 = 131072;
                                i3 |= i6;
                            }
                        } else {
                            checkboxColors2 = checkboxColors;
                        }
                        i6 = 65536;
                        i3 |= i6;
                    } else {
                        checkboxColors2 = checkboxColors;
                    }
                    if ((374491 & i3) == 74898 || !startRestartGroup.getSkipping()) {
                        startRestartGroup.startDefaults();
                        if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                            Modifier.Companion companion = i7 == 0 ? Modifier.INSTANCE : modifier2;
                            boolean z6 = i4 == 0 ? true : z3;
                            if (i5 == 0) {
                                startRestartGroup.startReplaceableGroup(-492369756);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                                Object rememberedValue = startRestartGroup.rememberedValue();
                                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    startRestartGroup.updateRememberedValue(rememberedValue);
                                }
                                startRestartGroup.endReplaceableGroup();
                                mutableInteractionSource3 = (MutableInteractionSource) rememberedValue;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            if ((i2 & 32) == 0) {
                                CheckboxColors m1581colorszjMxDiM = CheckboxDefaults.INSTANCE.m1581colorszjMxDiM(0L, 0L, 0L, 0L, 0L, startRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                                startRestartGroup = startRestartGroup;
                                i3 &= -458753;
                                modifier3 = companion;
                                z4 = z6;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                checkboxColors3 = m1581colorszjMxDiM;
                            } else {
                                modifier3 = companion;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                checkboxColors3 = checkboxColors2;
                                z4 = z6;
                            }
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                            }
                            mutableInteractionSource4 = mutableInteractionSource2;
                            checkboxColors3 = checkboxColors2;
                            modifier3 = modifier2;
                            z4 = z3;
                        }
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2118660998, i3, -1, "androidx.compose.material.Checkbox (Checkbox.kt:92)");
                        }
                        ToggleableState ToggleableState = ToggleableStateKt.ToggleableState(z);
                        if (function1 == null) {
                            startRestartGroup.startReplaceableGroup(2084314017);
                            boolean changedInstance = startRestartGroup.changedInstance(function1) | startRestartGroup.changed(z);
                            Object rememberedValue2 = startRestartGroup.rememberedValue();
                            if (changedInstance || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue2 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material.CheckboxKt$Checkbox$2$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public /* bridge */ /* synthetic */ Unit invoke() {
                                        invoke2();
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2() {
                                        function1.invoke(Boolean.valueOf(!z));
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue2);
                            }
                            function0 = (Function0) rememberedValue2;
                            startRestartGroup.endReplaceableGroup();
                        } else {
                            function0 = null;
                        }
                        TriStateCheckbox(ToggleableState, function0, modifier3, z4, mutableInteractionSource4, checkboxColors3, startRestartGroup, i3 & 524160, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier4 = modifier3;
                        z5 = z4;
                        mutableInteractionSource5 = mutableInteractionSource4;
                        checkboxColors4 = checkboxColors3;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        modifier4 = modifier2;
                        z5 = z3;
                        mutableInteractionSource5 = mutableInteractionSource2;
                        checkboxColors4 = checkboxColors2;
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.CheckboxKt$Checkbox$3
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

                            public final void invoke(Composer composer2, int i8) {
                                CheckboxKt.Checkbox(z, function1, modifier4, z5, mutableInteractionSource5, checkboxColors4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                        return;
                    }
                    return;
                }
                mutableInteractionSource2 = mutableInteractionSource;
                if ((458752 & i) != 0) {
                }
                if ((374491 & i3) == 74898) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i7 == 0) {
                }
                if (i4 == 0) {
                }
                if (i5 == 0) {
                }
                if ((i2 & 32) == 0) {
                }
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                ToggleableState ToggleableState2 = ToggleableStateKt.ToggleableState(z);
                if (function1 == null) {
                }
                TriStateCheckbox(ToggleableState2, function0, modifier3, z4, mutableInteractionSource4, checkboxColors3, startRestartGroup, i3 & 524160, 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier4 = modifier3;
                z5 = z4;
                mutableInteractionSource5 = mutableInteractionSource4;
                checkboxColors4 = checkboxColors3;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            z3 = z2;
            i5 = i2 & 16;
            if (i5 != 0) {
            }
            mutableInteractionSource2 = mutableInteractionSource;
            if ((458752 & i) != 0) {
            }
            if ((374491 & i3) == 74898) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i7 == 0) {
            }
            if (i4 == 0) {
            }
            if (i5 == 0) {
            }
            if ((i2 & 32) == 0) {
            }
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            ToggleableState ToggleableState22 = ToggleableStateKt.ToggleableState(z);
            if (function1 == null) {
            }
            TriStateCheckbox(ToggleableState22, function0, modifier3, z4, mutableInteractionSource4, checkboxColors3, startRestartGroup, i3 & 524160, 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier4 = modifier3;
            z5 = z4;
            mutableInteractionSource5 = mutableInteractionSource4;
            checkboxColors4 = checkboxColors3;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        z3 = z2;
        i5 = i2 & 16;
        if (i5 != 0) {
        }
        mutableInteractionSource2 = mutableInteractionSource;
        if ((458752 & i) != 0) {
        }
        if ((374491 & i3) == 74898) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i7 == 0) {
        }
        if (i4 == 0) {
        }
        if (i5 == 0) {
        }
        if ((i2 & 32) == 0) {
        }
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        ToggleableState ToggleableState222 = ToggleableStateKt.ToggleableState(z);
        if (function1 == null) {
        }
        TriStateCheckbox(ToggleableState222, function0, modifier3, z4, mutableInteractionSource4, checkboxColors3, startRestartGroup, i3 & 524160, 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier4 = modifier3;
        z5 = z4;
        mutableInteractionSource5 = mutableInteractionSource4;
        checkboxColors4 = checkboxColors3;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void TriStateCheckbox(final ToggleableState toggleableState, final Function0<Unit> function0, Modifier modifier, boolean z, MutableInteractionSource mutableInteractionSource, CheckboxColors checkboxColors, Composer composer, final int i, final int i2) {
        ToggleableState toggleableState2;
        int i3;
        Modifier modifier2;
        int i4;
        boolean z2;
        int i5;
        MutableInteractionSource mutableInteractionSource2;
        CheckboxColors checkboxColors2;
        MutableInteractionSource mutableInteractionSource3;
        Modifier modifier3;
        boolean z3;
        MutableInteractionSource mutableInteractionSource4;
        CheckboxColors checkboxColors3;
        int i6;
        boolean z4;
        Modifier.Companion companion;
        Modifier.Companion companion2;
        final CheckboxColors checkboxColors4;
        final Modifier modifier4;
        final boolean z5;
        int i7;
        Composer startRestartGroup = composer.startRestartGroup(2031255194);
        ComposerKt.sourceInformation(startRestartGroup, "C(TriStateCheckbox)P(5,4,3,1,2)136@6460L39,137@6547L8,155@7071L412:Checkbox.kt#jmzs0o");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            toggleableState2 = toggleableState;
        } else if ((i & 14) == 0) {
            toggleableState2 = toggleableState;
            i3 = (startRestartGroup.changed(toggleableState2) ? 4 : 2) | i;
        } else {
            toggleableState2 = toggleableState;
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 112) == 0) {
            i3 |= startRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        int i8 = i2 & 4;
        if (i8 != 0) {
            i3 |= 384;
        } else if ((i & 896) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 256 : 128;
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else if ((i & 7168) == 0) {
                z2 = z;
                i3 |= startRestartGroup.changed(z2) ? 2048 : 1024;
                i5 = i2 & 16;
                if (i5 != 0) {
                    i3 |= 24576;
                } else if ((57344 & i) == 0) {
                    mutableInteractionSource2 = mutableInteractionSource;
                    i3 |= startRestartGroup.changed(mutableInteractionSource2) ? 16384 : 8192;
                    if ((458752 & i) != 0) {
                        if ((i2 & 32) == 0) {
                            checkboxColors2 = checkboxColors;
                            if (startRestartGroup.changed(checkboxColors2)) {
                                i7 = 131072;
                                i3 |= i7;
                            }
                        } else {
                            checkboxColors2 = checkboxColors;
                        }
                        i7 = 65536;
                        i3 |= i7;
                    } else {
                        checkboxColors2 = checkboxColors;
                    }
                    if ((374491 & i3) == 74898 || !startRestartGroup.getSkipping()) {
                        startRestartGroup.startDefaults();
                        if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                            Modifier.Companion companion3 = i8 == 0 ? Modifier.INSTANCE : modifier2;
                            boolean z6 = i4 == 0 ? true : z2;
                            if (i5 == 0) {
                                startRestartGroup.startReplaceableGroup(-492369756);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                                Object rememberedValue = startRestartGroup.rememberedValue();
                                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    startRestartGroup.updateRememberedValue(rememberedValue);
                                }
                                startRestartGroup.endReplaceableGroup();
                                mutableInteractionSource3 = (MutableInteractionSource) rememberedValue;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            if ((i2 & 32) == 0) {
                                CheckboxColors m1581colorszjMxDiM = CheckboxDefaults.INSTANCE.m1581colorszjMxDiM(0L, 0L, 0L, 0L, 0L, startRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                                startRestartGroup = startRestartGroup;
                                i3 &= -458753;
                                modifier3 = companion3;
                                z3 = z6;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                checkboxColors3 = m1581colorszjMxDiM;
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(2031255194, i3, -1, "androidx.compose.material.TriStateCheckbox (Checkbox.kt:138)");
                                }
                                startRestartGroup.startReplaceableGroup(-1517549514);
                                ComposerKt.sourceInformation(startRestartGroup, "147@6884L120");
                                if (function0 == null) {
                                    i6 = i3;
                                    companion = ToggleableKt.m1128triStateToggleableO2vRcR0(Modifier.INSTANCE, toggleableState2, mutableInteractionSource4, RippleKt.m1870rememberRipple9IZ8Weo(false, CheckboxRippleRadius, 0L, startRestartGroup, 54, 4), z3, Role.m5709boximpl(Role.INSTANCE.m5717getCheckboxo7Vup1c()), function0);
                                    mutableInteractionSource2 = mutableInteractionSource4;
                                    z4 = z3;
                                } else {
                                    mutableInteractionSource2 = mutableInteractionSource4;
                                    i6 = i3;
                                    z4 = z3;
                                    companion = Modifier.INSTANCE;
                                }
                                startRestartGroup.endReplaceableGroup();
                                if (function0 == null) {
                                    companion2 = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.INSTANCE);
                                } else {
                                    companion2 = Modifier.INSTANCE;
                                }
                                CheckboxColors checkboxColors5 = checkboxColors3;
                                CheckboxImpl(z4, toggleableState, PaddingKt.m879padding3ABfNKs(modifier3.then(companion2).then(companion), CheckboxDefaultPadding), checkboxColors5, startRestartGroup, ((i6 >> 9) & 14) | ((i6 << 3) & 112) | ((i6 >> 6) & 7168));
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                checkboxColors4 = checkboxColors5;
                                modifier4 = modifier3;
                                z5 = z4;
                            } else {
                                modifier3 = companion3;
                                z3 = z6;
                                mutableInteractionSource4 = mutableInteractionSource3;
                            }
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                            }
                            modifier3 = modifier2;
                            z3 = z2;
                            mutableInteractionSource4 = mutableInteractionSource2;
                        }
                        checkboxColors3 = checkboxColors2;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        startRestartGroup.startReplaceableGroup(-1517549514);
                        ComposerKt.sourceInformation(startRestartGroup, "147@6884L120");
                        if (function0 == null) {
                        }
                        startRestartGroup.endReplaceableGroup();
                        if (function0 == null) {
                        }
                        CheckboxColors checkboxColors52 = checkboxColors3;
                        CheckboxImpl(z4, toggleableState, PaddingKt.m879padding3ABfNKs(modifier3.then(companion2).then(companion), CheckboxDefaultPadding), checkboxColors52, startRestartGroup, ((i6 >> 9) & 14) | ((i6 << 3) & 112) | ((i6 >> 6) & 7168));
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        checkboxColors4 = checkboxColors52;
                        modifier4 = modifier3;
                        z5 = z4;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        modifier4 = modifier2;
                        z5 = z2;
                        checkboxColors4 = checkboxColors2;
                    }
                    final MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource2;
                    ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.CheckboxKt$TriStateCheckbox$2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i9) {
                                CheckboxKt.TriStateCheckbox(ToggleableState.this, function0, modifier4, z5, mutableInteractionSource5, checkboxColors4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                        return;
                    }
                    return;
                }
                mutableInteractionSource2 = mutableInteractionSource;
                if ((458752 & i) != 0) {
                }
                if ((374491 & i3) == 74898) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i8 == 0) {
                }
                if (i4 == 0) {
                }
                if (i5 == 0) {
                }
                if ((i2 & 32) == 0) {
                }
            }
            z2 = z;
            i5 = i2 & 16;
            if (i5 != 0) {
            }
            mutableInteractionSource2 = mutableInteractionSource;
            if ((458752 & i) != 0) {
            }
            if ((374491 & i3) == 74898) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i8 == 0) {
            }
            if (i4 == 0) {
            }
            if (i5 == 0) {
            }
            if ((i2 & 32) == 0) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        z2 = z;
        i5 = i2 & 16;
        if (i5 != 0) {
        }
        mutableInteractionSource2 = mutableInteractionSource;
        if ((458752 & i) != 0) {
        }
        if ((374491 & i3) == 74898) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i8 == 0) {
        }
        if (i4 == 0) {
        }
        if (i5 == 0) {
        }
        if ((i2 & 32) == 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x02bc  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x02eb  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x020f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void CheckboxImpl(final boolean z, final ToggleableState toggleableState, final Modifier modifier, final CheckboxColors checkboxColors, Composer composer, final int i) {
        int i2;
        float f;
        Transition transition;
        int i3;
        float f2;
        int i4;
        int i5;
        int i6;
        float f3;
        int i7;
        Object rememberedValue;
        boolean changed;
        Object rememberedValue2;
        Composer startRestartGroup = composer.startRestartGroup(-2118895727);
        ComposerKt.sourceInformation(startRestartGroup, "C(CheckboxImpl)P(1,3,2)264@11068L23,265@11132L443,281@11635L458,296@12115L32,297@12177L21,298@12226L24,299@12281L27,300@12313L586:Checkbox.kt#jmzs0o");
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= startRestartGroup.changed(toggleableState) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= startRestartGroup.changed(modifier) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i2 |= startRestartGroup.changed(checkboxColors) ? 2048 : 1024;
        }
        int i8 = i2;
        if ((i8 & 5851) == 1170 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2118895727, i8, -1, "androidx.compose.material.CheckboxImpl (Checkbox.kt:263)");
            }
            int i9 = i8 >> 3;
            int i10 = i9 & 14;
            Transition updateTransition = TransitionKt.updateTransition(toggleableState, (String) null, startRestartGroup, i10, 2);
            CheckboxKt$CheckboxImpl$checkDrawFraction$2 checkboxKt$CheckboxImpl$checkDrawFraction$2 = new Function3<Transition.Segment<ToggleableState>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.material.CheckboxKt$CheckboxImpl$checkDrawFraction$2
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ FiniteAnimationSpec<Float> invoke(Transition.Segment<ToggleableState> segment, Composer composer2, Integer num) {
                    return invoke(segment, composer2, num.intValue());
                }

                public final FiniteAnimationSpec<Float> invoke(Transition.Segment<ToggleableState> segment, Composer composer2, int i11) {
                    SpringSpec snap;
                    composer2.startReplaceableGroup(-1707702900);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1707702900, i11, -1, "androidx.compose.material.CheckboxImpl.<anonymous> (Checkbox.kt:267)");
                    }
                    if (segment.getInitialState() == ToggleableState.Off) {
                        snap = AnimationSpecKt.tween$default(100, 0, null, 6, null);
                    } else {
                        snap = segment.getTargetState() == ToggleableState.Off ? AnimationSpecKt.snap(100) : AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer2.endReplaceableGroup();
                    return snap;
                }
            };
            startRestartGroup.startReplaceableGroup(-1338768149);
            ComposerKt.sourceInformation(startRestartGroup, "CC(animateFloat)P(2)1165@46369L78:Transition.kt#pdpnli");
            TwoWayConverter<Float, AnimationVector1D> vectorConverter = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
            startRestartGroup.startReplaceableGroup(-142660079);
            ComposerKt.sourceInformation(startRestartGroup, "CC(animateValue)P(3,2)1082@42932L32,1083@42987L31,1084@43043L23,1086@43079L89:Transition.kt#pdpnli");
            ToggleableState toggleableState2 = (ToggleableState) updateTransition.getCurrentState();
            startRestartGroup.startReplaceableGroup(-1798345588);
            ComposerKt.sourceInformation(startRestartGroup, "C:Checkbox.kt#jmzs0o");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1798345588, 0, -1, "androidx.compose.material.CheckboxImpl.<anonymous> (Checkbox.kt:274)");
            }
            int i11 = WhenMappings.$EnumSwitchMapping$0[toggleableState2.ordinal()];
            float f4 = 0.0f;
            if (i11 != 1) {
                if (i11 == 2) {
                    f = 0.0f;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    startRestartGroup.endReplaceableGroup();
                    Float valueOf = Float.valueOf(f);
                    ToggleableState toggleableState3 = (ToggleableState) updateTransition.getTargetState();
                    startRestartGroup.startReplaceableGroup(-1798345588);
                    ComposerKt.sourceInformation(startRestartGroup, "C:Checkbox.kt#jmzs0o");
                    if (ComposerKt.isTraceInProgress()) {
                        transition = updateTransition;
                    } else {
                        transition = updateTransition;
                        ComposerKt.traceEventStart(-1798345588, 0, -1, "androidx.compose.material.CheckboxImpl.<anonymous> (Checkbox.kt:274)");
                    }
                    i3 = WhenMappings.$EnumSwitchMapping$0[toggleableState3.ordinal()];
                    if (i3 != 1) {
                        if (i3 == 2) {
                            f2 = 0.0f;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            startRestartGroup.endReplaceableGroup();
                            Transition transition2 = transition;
                            final State createTransitionAnimation = TransitionKt.createTransitionAnimation(transition2, valueOf, Float.valueOf(f2), checkboxKt$CheckboxImpl$checkDrawFraction$2.invoke((CheckboxKt$CheckboxImpl$checkDrawFraction$2) transition.getSegment(), (Transition.Segment) startRestartGroup, (Composer) 0), vectorConverter, "FloatAnimation", startRestartGroup, 0);
                            startRestartGroup.endReplaceableGroup();
                            startRestartGroup.endReplaceableGroup();
                            CheckboxKt$CheckboxImpl$checkCenterGravitationShiftFraction$2 checkboxKt$CheckboxImpl$checkCenterGravitationShiftFraction$2 = new Function3<Transition.Segment<ToggleableState>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.material.CheckboxKt$CheckboxImpl$checkCenterGravitationShiftFraction$2
                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ FiniteAnimationSpec<Float> invoke(Transition.Segment<ToggleableState> segment, Composer composer2, Integer num) {
                                    return invoke(segment, composer2, num.intValue());
                                }

                                public final FiniteAnimationSpec<Float> invoke(Transition.Segment<ToggleableState> segment, Composer composer2, int i12) {
                                    TweenSpec snap;
                                    composer2.startReplaceableGroup(1075283605);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1075283605, i12, -1, "androidx.compose.material.CheckboxImpl.<anonymous> (Checkbox.kt:283)");
                                    }
                                    if (segment.getInitialState() == ToggleableState.Off) {
                                        snap = AnimationSpecKt.snap$default(0, 1, null);
                                    } else {
                                        snap = segment.getTargetState() == ToggleableState.Off ? AnimationSpecKt.snap(100) : AnimationSpecKt.tween$default(100, 0, null, 6, null);
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    composer2.endReplaceableGroup();
                                    return snap;
                                }
                            };
                            startRestartGroup.startReplaceableGroup(-1338768149);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(animateFloat)P(2)1165@46369L78:Transition.kt#pdpnli");
                            TwoWayConverter<Float, AnimationVector1D> vectorConverter2 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
                            startRestartGroup.startReplaceableGroup(-142660079);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(animateValue)P(3,2)1082@42932L32,1083@42987L31,1084@43043L23,1086@43079L89:Transition.kt#pdpnli");
                            ToggleableState toggleableState4 = (ToggleableState) transition2.getCurrentState();
                            startRestartGroup.startReplaceableGroup(-2098942571);
                            ComposerKt.sourceInformation(startRestartGroup, "C:Checkbox.kt#jmzs0o");
                            if (ComposerKt.isTraceInProgress()) {
                                i4 = -1;
                                ComposerKt.traceEventStart(-2098942571, 0, -1, "androidx.compose.material.CheckboxImpl.<anonymous> (Checkbox.kt:290)");
                            } else {
                                i4 = -1;
                            }
                            i5 = WhenMappings.$EnumSwitchMapping$0[toggleableState4.ordinal()];
                            if (i5 != 1 || i5 == 2) {
                                i6 = 3;
                                f3 = 0.0f;
                            } else {
                                i6 = 3;
                                if (i5 != 3) {
                                    throw new NoWhenBranchMatchedException();
                                }
                                f3 = 1.0f;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            startRestartGroup.endReplaceableGroup();
                            Float valueOf2 = Float.valueOf(f3);
                            ToggleableState toggleableState5 = (ToggleableState) transition2.getTargetState();
                            startRestartGroup.startReplaceableGroup(-2098942571);
                            ComposerKt.sourceInformation(startRestartGroup, "C:Checkbox.kt#jmzs0o");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-2098942571, 0, i4, "androidx.compose.material.CheckboxImpl.<anonymous> (Checkbox.kt:290)");
                            }
                            i7 = WhenMappings.$EnumSwitchMapping$0[toggleableState5.ordinal()];
                            if (i7 != 1 && i7 != 2) {
                                if (i7 == i6) {
                                    throw new NoWhenBranchMatchedException();
                                }
                                f4 = 1.0f;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            startRestartGroup.endReplaceableGroup();
                            final State createTransitionAnimation2 = TransitionKt.createTransitionAnimation(transition2, valueOf2, Float.valueOf(f4), checkboxKt$CheckboxImpl$checkCenterGravitationShiftFraction$2.invoke((CheckboxKt$CheckboxImpl$checkCenterGravitationShiftFraction$2) transition2.getSegment(), (Transition.Segment) startRestartGroup, (Composer) 0), vectorConverter2, "FloatAnimation", startRestartGroup, 0);
                            startRestartGroup.endReplaceableGroup();
                            startRestartGroup.endReplaceableGroup();
                            startRestartGroup.startReplaceableGroup(-492369756);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                            rememberedValue = startRestartGroup.rememberedValue();
                            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                rememberedValue = new CheckDrawingCache(null, null, null, 7, null);
                                startRestartGroup.updateRememberedValue(rememberedValue);
                            }
                            startRestartGroup.endReplaceableGroup();
                            final CheckDrawingCache checkDrawingCache = (CheckDrawingCache) rememberedValue;
                            final State<Color> checkmarkColor = checkboxColors.checkmarkColor(toggleableState, startRestartGroup, i10 | ((i8 >> 6) & 112));
                            int i12 = (i9 & 896) | (i8 & 126);
                            final State<Color> boxColor = checkboxColors.boxColor(z, toggleableState, startRestartGroup, i12);
                            final State<Color> borderColor = checkboxColors.borderColor(z, toggleableState, startRestartGroup, i12);
                            Modifier m920requiredSize3ABfNKs = SizeKt.m920requiredSize3ABfNKs(SizeKt.wrapContentSize$default(modifier, Alignment.INSTANCE.getCenter(), false, 2, null), CheckboxSize);
                            startRestartGroup.startReplaceableGroup(2084322042);
                            changed = startRestartGroup.changed(boxColor) | startRestartGroup.changed(borderColor) | startRestartGroup.changed(checkmarkColor) | startRestartGroup.changed(createTransitionAnimation) | startRestartGroup.changed(createTransitionAnimation2) | startRestartGroup.changed(checkDrawingCache);
                            rememberedValue2 = startRestartGroup.rememberedValue();
                            if (!changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue2 = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.CheckboxKt$CheckboxImpl$1$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                                        invoke2(drawScope);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(DrawScope drawScope) {
                                        float f5;
                                        long CheckboxImpl$lambda$9;
                                        long CheckboxImpl$lambda$10;
                                        float f6;
                                        long CheckboxImpl$lambda$8;
                                        float CheckboxImpl$lambda$4;
                                        float CheckboxImpl$lambda$6;
                                        f5 = CheckboxKt.StrokeWidth;
                                        float floor = (float) Math.floor(drawScope.mo630toPx0680j_4(f5));
                                        CheckboxImpl$lambda$9 = CheckboxKt.CheckboxImpl$lambda$9(boxColor);
                                        CheckboxImpl$lambda$10 = CheckboxKt.CheckboxImpl$lambda$10(borderColor);
                                        f6 = CheckboxKt.RadiusSize;
                                        CheckboxKt.m1584drawBox1wkBAMs(drawScope, CheckboxImpl$lambda$9, CheckboxImpl$lambda$10, drawScope.mo630toPx0680j_4(f6), floor);
                                        CheckboxImpl$lambda$8 = CheckboxKt.CheckboxImpl$lambda$8(checkmarkColor);
                                        CheckboxImpl$lambda$4 = CheckboxKt.CheckboxImpl$lambda$4(createTransitionAnimation);
                                        CheckboxImpl$lambda$6 = CheckboxKt.CheckboxImpl$lambda$6(createTransitionAnimation2);
                                        CheckboxKt.m1585drawCheck3IgeMak(drawScope, CheckboxImpl$lambda$8, CheckboxImpl$lambda$4, CheckboxImpl$lambda$6, floor, CheckDrawingCache.this);
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue2);
                            }
                            startRestartGroup.endReplaceableGroup();
                            CanvasKt.Canvas(m920requiredSize3ABfNKs, (Function1) rememberedValue2, startRestartGroup, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        } else if (i3 != 3) {
                            throw new NoWhenBranchMatchedException();
                        }
                    }
                    f2 = 1.0f;
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    startRestartGroup.endReplaceableGroup();
                    Transition transition22 = transition;
                    final State<Float> createTransitionAnimation3 = TransitionKt.createTransitionAnimation(transition22, valueOf, Float.valueOf(f2), checkboxKt$CheckboxImpl$checkDrawFraction$2.invoke((CheckboxKt$CheckboxImpl$checkDrawFraction$2) transition.getSegment(), (Transition.Segment) startRestartGroup, (Composer) 0), vectorConverter, "FloatAnimation", startRestartGroup, 0);
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endReplaceableGroup();
                    CheckboxKt$CheckboxImpl$checkCenterGravitationShiftFraction$2 checkboxKt$CheckboxImpl$checkCenterGravitationShiftFraction$22 = new Function3<Transition.Segment<ToggleableState>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.material.CheckboxKt$CheckboxImpl$checkCenterGravitationShiftFraction$2
                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ FiniteAnimationSpec<Float> invoke(Transition.Segment<ToggleableState> segment, Composer composer2, Integer num) {
                            return invoke(segment, composer2, num.intValue());
                        }

                        public final FiniteAnimationSpec<Float> invoke(Transition.Segment<ToggleableState> segment, Composer composer2, int i122) {
                            TweenSpec snap;
                            composer2.startReplaceableGroup(1075283605);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1075283605, i122, -1, "androidx.compose.material.CheckboxImpl.<anonymous> (Checkbox.kt:283)");
                            }
                            if (segment.getInitialState() == ToggleableState.Off) {
                                snap = AnimationSpecKt.snap$default(0, 1, null);
                            } else {
                                snap = segment.getTargetState() == ToggleableState.Off ? AnimationSpecKt.snap(100) : AnimationSpecKt.tween$default(100, 0, null, 6, null);
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer2.endReplaceableGroup();
                            return snap;
                        }
                    };
                    startRestartGroup.startReplaceableGroup(-1338768149);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(animateFloat)P(2)1165@46369L78:Transition.kt#pdpnli");
                    TwoWayConverter<Float, AnimationVector1D> vectorConverter22 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
                    startRestartGroup.startReplaceableGroup(-142660079);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(animateValue)P(3,2)1082@42932L32,1083@42987L31,1084@43043L23,1086@43079L89:Transition.kt#pdpnli");
                    ToggleableState toggleableState42 = (ToggleableState) transition22.getCurrentState();
                    startRestartGroup.startReplaceableGroup(-2098942571);
                    ComposerKt.sourceInformation(startRestartGroup, "C:Checkbox.kt#jmzs0o");
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    i5 = WhenMappings.$EnumSwitchMapping$0[toggleableState42.ordinal()];
                    if (i5 != 1) {
                    }
                    i6 = 3;
                    f3 = 0.0f;
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    startRestartGroup.endReplaceableGroup();
                    Float valueOf22 = Float.valueOf(f3);
                    ToggleableState toggleableState52 = (ToggleableState) transition22.getTargetState();
                    startRestartGroup.startReplaceableGroup(-2098942571);
                    ComposerKt.sourceInformation(startRestartGroup, "C:Checkbox.kt#jmzs0o");
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    i7 = WhenMappings.$EnumSwitchMapping$0[toggleableState52.ordinal()];
                    if (i7 != 1) {
                        if (i7 == i6) {
                        }
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    startRestartGroup.endReplaceableGroup();
                    final State<Float> createTransitionAnimation22 = TransitionKt.createTransitionAnimation(transition22, valueOf22, Float.valueOf(f4), checkboxKt$CheckboxImpl$checkCenterGravitationShiftFraction$22.invoke((CheckboxKt$CheckboxImpl$checkCenterGravitationShiftFraction$2) transition22.getSegment(), (Transition.Segment) startRestartGroup, (Composer) 0), vectorConverter22, "FloatAnimation", startRestartGroup, 0);
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                    }
                    startRestartGroup.endReplaceableGroup();
                    final CheckDrawingCache checkDrawingCache2 = (CheckDrawingCache) rememberedValue;
                    final State<Color> checkmarkColor2 = checkboxColors.checkmarkColor(toggleableState, startRestartGroup, i10 | ((i8 >> 6) & 112));
                    int i122 = (i9 & 896) | (i8 & 126);
                    final State<Color> boxColor2 = checkboxColors.boxColor(z, toggleableState, startRestartGroup, i122);
                    final State<Color> borderColor2 = checkboxColors.borderColor(z, toggleableState, startRestartGroup, i122);
                    Modifier m920requiredSize3ABfNKs2 = SizeKt.m920requiredSize3ABfNKs(SizeKt.wrapContentSize$default(modifier, Alignment.INSTANCE.getCenter(), false, 2, null), CheckboxSize);
                    startRestartGroup.startReplaceableGroup(2084322042);
                    changed = startRestartGroup.changed(boxColor2) | startRestartGroup.changed(borderColor2) | startRestartGroup.changed(checkmarkColor2) | startRestartGroup.changed(createTransitionAnimation3) | startRestartGroup.changed(createTransitionAnimation22) | startRestartGroup.changed(checkDrawingCache2);
                    rememberedValue2 = startRestartGroup.rememberedValue();
                    if (!changed) {
                    }
                    rememberedValue2 = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.CheckboxKt$CheckboxImpl$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                            invoke2(drawScope);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(DrawScope drawScope) {
                            float f5;
                            long CheckboxImpl$lambda$9;
                            long CheckboxImpl$lambda$10;
                            float f6;
                            long CheckboxImpl$lambda$8;
                            float CheckboxImpl$lambda$4;
                            float CheckboxImpl$lambda$6;
                            f5 = CheckboxKt.StrokeWidth;
                            float floor = (float) Math.floor(drawScope.mo630toPx0680j_4(f5));
                            CheckboxImpl$lambda$9 = CheckboxKt.CheckboxImpl$lambda$9(boxColor2);
                            CheckboxImpl$lambda$10 = CheckboxKt.CheckboxImpl$lambda$10(borderColor2);
                            f6 = CheckboxKt.RadiusSize;
                            CheckboxKt.m1584drawBox1wkBAMs(drawScope, CheckboxImpl$lambda$9, CheckboxImpl$lambda$10, drawScope.mo630toPx0680j_4(f6), floor);
                            CheckboxImpl$lambda$8 = CheckboxKt.CheckboxImpl$lambda$8(checkmarkColor2);
                            CheckboxImpl$lambda$4 = CheckboxKt.CheckboxImpl$lambda$4(createTransitionAnimation3);
                            CheckboxImpl$lambda$6 = CheckboxKt.CheckboxImpl$lambda$6(createTransitionAnimation22);
                            CheckboxKt.m1585drawCheck3IgeMak(drawScope, CheckboxImpl$lambda$8, CheckboxImpl$lambda$4, CheckboxImpl$lambda$6, floor, CheckDrawingCache.this);
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                    startRestartGroup.endReplaceableGroup();
                    CanvasKt.Canvas(m920requiredSize3ABfNKs2, (Function1) rememberedValue2, startRestartGroup, 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                } else if (i11 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
            }
            f = 1.0f;
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.endReplaceableGroup();
            Float valueOf3 = Float.valueOf(f);
            ToggleableState toggleableState32 = (ToggleableState) updateTransition.getTargetState();
            startRestartGroup.startReplaceableGroup(-1798345588);
            ComposerKt.sourceInformation(startRestartGroup, "C:Checkbox.kt#jmzs0o");
            if (ComposerKt.isTraceInProgress()) {
            }
            i3 = WhenMappings.$EnumSwitchMapping$0[toggleableState32.ordinal()];
            if (i3 != 1) {
            }
            f2 = 1.0f;
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.endReplaceableGroup();
            Transition transition222 = transition;
            final State<Float> createTransitionAnimation32 = TransitionKt.createTransitionAnimation(transition222, valueOf3, Float.valueOf(f2), checkboxKt$CheckboxImpl$checkDrawFraction$2.invoke((CheckboxKt$CheckboxImpl$checkDrawFraction$2) transition.getSegment(), (Transition.Segment) startRestartGroup, (Composer) 0), vectorConverter, "FloatAnimation", startRestartGroup, 0);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            CheckboxKt$CheckboxImpl$checkCenterGravitationShiftFraction$2 checkboxKt$CheckboxImpl$checkCenterGravitationShiftFraction$222 = new Function3<Transition.Segment<ToggleableState>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.material.CheckboxKt$CheckboxImpl$checkCenterGravitationShiftFraction$2
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ FiniteAnimationSpec<Float> invoke(Transition.Segment<ToggleableState> segment, Composer composer2, Integer num) {
                    return invoke(segment, composer2, num.intValue());
                }

                public final FiniteAnimationSpec<Float> invoke(Transition.Segment<ToggleableState> segment, Composer composer2, int i1222) {
                    TweenSpec snap;
                    composer2.startReplaceableGroup(1075283605);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1075283605, i1222, -1, "androidx.compose.material.CheckboxImpl.<anonymous> (Checkbox.kt:283)");
                    }
                    if (segment.getInitialState() == ToggleableState.Off) {
                        snap = AnimationSpecKt.snap$default(0, 1, null);
                    } else {
                        snap = segment.getTargetState() == ToggleableState.Off ? AnimationSpecKt.snap(100) : AnimationSpecKt.tween$default(100, 0, null, 6, null);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer2.endReplaceableGroup();
                    return snap;
                }
            };
            startRestartGroup.startReplaceableGroup(-1338768149);
            ComposerKt.sourceInformation(startRestartGroup, "CC(animateFloat)P(2)1165@46369L78:Transition.kt#pdpnli");
            TwoWayConverter<Float, AnimationVector1D> vectorConverter222 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
            startRestartGroup.startReplaceableGroup(-142660079);
            ComposerKt.sourceInformation(startRestartGroup, "CC(animateValue)P(3,2)1082@42932L32,1083@42987L31,1084@43043L23,1086@43079L89:Transition.kt#pdpnli");
            ToggleableState toggleableState422 = (ToggleableState) transition222.getCurrentState();
            startRestartGroup.startReplaceableGroup(-2098942571);
            ComposerKt.sourceInformation(startRestartGroup, "C:Checkbox.kt#jmzs0o");
            if (ComposerKt.isTraceInProgress()) {
            }
            i5 = WhenMappings.$EnumSwitchMapping$0[toggleableState422.ordinal()];
            if (i5 != 1) {
            }
            i6 = 3;
            f3 = 0.0f;
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.endReplaceableGroup();
            Float valueOf222 = Float.valueOf(f3);
            ToggleableState toggleableState522 = (ToggleableState) transition222.getTargetState();
            startRestartGroup.startReplaceableGroup(-2098942571);
            ComposerKt.sourceInformation(startRestartGroup, "C:Checkbox.kt#jmzs0o");
            if (ComposerKt.isTraceInProgress()) {
            }
            i7 = WhenMappings.$EnumSwitchMapping$0[toggleableState522.ordinal()];
            if (i7 != 1) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.endReplaceableGroup();
            final State<Float> createTransitionAnimation222 = TransitionKt.createTransitionAnimation(transition222, valueOf222, Float.valueOf(f4), checkboxKt$CheckboxImpl$checkCenterGravitationShiftFraction$222.invoke((CheckboxKt$CheckboxImpl$checkCenterGravitationShiftFraction$2) transition222.getSegment(), (Transition.Segment) startRestartGroup, (Composer) 0), vectorConverter222, "FloatAnimation", startRestartGroup, 0);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
            rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            }
            startRestartGroup.endReplaceableGroup();
            final CheckDrawingCache checkDrawingCache22 = (CheckDrawingCache) rememberedValue;
            final State<Color> checkmarkColor22 = checkboxColors.checkmarkColor(toggleableState, startRestartGroup, i10 | ((i8 >> 6) & 112));
            int i1222 = (i9 & 896) | (i8 & 126);
            final State<Color> boxColor22 = checkboxColors.boxColor(z, toggleableState, startRestartGroup, i1222);
            final State<Color> borderColor22 = checkboxColors.borderColor(z, toggleableState, startRestartGroup, i1222);
            Modifier m920requiredSize3ABfNKs22 = SizeKt.m920requiredSize3ABfNKs(SizeKt.wrapContentSize$default(modifier, Alignment.INSTANCE.getCenter(), false, 2, null), CheckboxSize);
            startRestartGroup.startReplaceableGroup(2084322042);
            changed = startRestartGroup.changed(boxColor22) | startRestartGroup.changed(borderColor22) | startRestartGroup.changed(checkmarkColor22) | startRestartGroup.changed(createTransitionAnimation32) | startRestartGroup.changed(createTransitionAnimation222) | startRestartGroup.changed(checkDrawingCache22);
            rememberedValue2 = startRestartGroup.rememberedValue();
            if (!changed) {
            }
            rememberedValue2 = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.CheckboxKt$CheckboxImpl$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                    invoke2(drawScope);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(DrawScope drawScope) {
                    float f5;
                    long CheckboxImpl$lambda$9;
                    long CheckboxImpl$lambda$10;
                    float f6;
                    long CheckboxImpl$lambda$8;
                    float CheckboxImpl$lambda$4;
                    float CheckboxImpl$lambda$6;
                    f5 = CheckboxKt.StrokeWidth;
                    float floor = (float) Math.floor(drawScope.mo630toPx0680j_4(f5));
                    CheckboxImpl$lambda$9 = CheckboxKt.CheckboxImpl$lambda$9(boxColor22);
                    CheckboxImpl$lambda$10 = CheckboxKt.CheckboxImpl$lambda$10(borderColor22);
                    f6 = CheckboxKt.RadiusSize;
                    CheckboxKt.m1584drawBox1wkBAMs(drawScope, CheckboxImpl$lambda$9, CheckboxImpl$lambda$10, drawScope.mo630toPx0680j_4(f6), floor);
                    CheckboxImpl$lambda$8 = CheckboxKt.CheckboxImpl$lambda$8(checkmarkColor22);
                    CheckboxImpl$lambda$4 = CheckboxKt.CheckboxImpl$lambda$4(createTransitionAnimation32);
                    CheckboxImpl$lambda$6 = CheckboxKt.CheckboxImpl$lambda$6(createTransitionAnimation222);
                    CheckboxKt.m1585drawCheck3IgeMak(drawScope, CheckboxImpl$lambda$8, CheckboxImpl$lambda$4, CheckboxImpl$lambda$6, floor, CheckDrawingCache.this);
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue2);
            startRestartGroup.endReplaceableGroup();
            CanvasKt.Canvas(m920requiredSize3ABfNKs22, (Function1) rememberedValue2, startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.CheckboxKt$CheckboxImpl$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i13) {
                    CheckboxKt.CheckboxImpl(z, toggleableState, modifier, checkboxColors, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: drawBox-1wkBAMs, reason: not valid java name */
    public static final void m1584drawBox1wkBAMs(DrawScope drawScope, long j, long j2, float f, float f2) {
        float f3 = f2 / 2.0f;
        Stroke stroke = new Stroke(f2, 0.0f, 0, 0, null, 30, null);
        float m3891getWidthimpl = Size.m3891getWidthimpl(drawScope.mo4612getSizeNHjbRc());
        if (Color.m4064equalsimpl0(j, j2)) {
            DrawScope.m4609drawRoundRectuAw5IA$default(drawScope, j, 0L, androidx.compose.ui.geometry.SizeKt.Size(m3891getWidthimpl, m3891getWidthimpl), CornerRadiusKt.CornerRadius$default(f, 0.0f, 2, null), Fill.INSTANCE, 0.0f, null, 0, Sdk.SDKError.Reason.BIDPAYLOAD_TEMPLATE_TYPE_MISMATCH_ERROR_VALUE, null);
            return;
        }
        float f4 = m3891getWidthimpl - (2 * f2);
        DrawScope.m4609drawRoundRectuAw5IA$default(drawScope, j, OffsetKt.Offset(f2, f2), androidx.compose.ui.geometry.SizeKt.Size(f4, f4), CornerRadiusKt.CornerRadius$default(Math.max(0.0f, f - f2), 0.0f, 2, null), Fill.INSTANCE, 0.0f, null, 0, 224, null);
        float f5 = m3891getWidthimpl - f2;
        DrawScope.m4609drawRoundRectuAw5IA$default(drawScope, j2, OffsetKt.Offset(f3, f3), androidx.compose.ui.geometry.SizeKt.Size(f5, f5), CornerRadiusKt.CornerRadius$default(f - f3, 0.0f, 2, null), stroke, 0.0f, null, 0, 224, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: drawCheck-3IgeMak, reason: not valid java name */
    public static final void m1585drawCheck3IgeMak(DrawScope drawScope, long j, float f, float f2, float f3, CheckDrawingCache checkDrawingCache) {
        Stroke stroke = new Stroke(f3, 0.0f, StrokeCap.INSTANCE.m4417getSquareKaPHkGw(), 0, null, 26, null);
        float m3891getWidthimpl = Size.m3891getWidthimpl(drawScope.mo4612getSizeNHjbRc());
        float lerp = MathHelpersKt.lerp(0.4f, 0.5f, f2);
        float lerp2 = MathHelpersKt.lerp(0.7f, 0.5f, f2);
        float lerp3 = MathHelpersKt.lerp(0.5f, 0.5f, f2);
        float lerp4 = MathHelpersKt.lerp(0.3f, 0.5f, f2);
        checkDrawingCache.getCheckPath().reset();
        checkDrawingCache.getCheckPath().moveTo(0.2f * m3891getWidthimpl, lerp3 * m3891getWidthimpl);
        checkDrawingCache.getCheckPath().lineTo(lerp * m3891getWidthimpl, lerp2 * m3891getWidthimpl);
        checkDrawingCache.getCheckPath().lineTo(0.8f * m3891getWidthimpl, m3891getWidthimpl * lerp4);
        checkDrawingCache.getPathMeasure().setPath(checkDrawingCache.getCheckPath(), false);
        checkDrawingCache.getPathToDraw().reset();
        checkDrawingCache.getPathMeasure().getSegment(0.0f, checkDrawingCache.getPathMeasure().getLength() * f, checkDrawingCache.getPathToDraw(), true);
        DrawScope.m4603drawPathLG529CI$default(drawScope, checkDrawingCache.getPathToDraw(), j, 0.0f, stroke, null, 0, 52, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float CheckboxImpl$lambda$4(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float CheckboxImpl$lambda$6(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long CheckboxImpl$lambda$8(State<Color> state) {
        return state.getValue().m4073unboximpl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long CheckboxImpl$lambda$9(State<Color> state) {
        return state.getValue().m4073unboximpl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long CheckboxImpl$lambda$10(State<Color> state) {
        return state.getValue().m4073unboximpl();
    }

    static {
        float f = 2;
        CheckboxDefaultPadding = Dp.m6389constructorimpl(f);
        StrokeWidth = Dp.m6389constructorimpl(f);
        RadiusSize = Dp.m6389constructorimpl(f);
    }
}
