package androidx.compose.material3;

import androidx.compose.animation.ColorVectorConverterKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.internal.FloatCompanionObject;

/* compiled from: TextFieldImpl.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\t\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JÇ\u0001\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u000b¢\u0006\u0002\b\f2\u0006\u0010\r\u001a\u00020\u000e2z\u0010\u000f\u001av\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00040\u0010¢\u0006\u0002\b\fH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001b²\u0006\n\u0010\u0014\u001a\u00020\u0011X\u008a\u0084\u0002²\u0006\n\u0010\u0017\u001a\u00020\u0011X\u008a\u0084\u0002²\u0006\n\u0010\u0018\u001a\u00020\u0011X\u008a\u0084\u0002²\u0006\n\u0010\u0015\u001a\u00020\bX\u008a\u0084\u0002²\u0006\n\u0010\u0016\u001a\u00020\bX\u008a\u0084\u0002"}, d2 = {"Landroidx/compose/material3/TextFieldTransitionScope;", "", "()V", "Transition", "", "inputState", "Landroidx/compose/material3/InputPhase;", "focusedTextStyleColor", "Landroidx/compose/ui/graphics/Color;", "unfocusedTextStyleColor", "contentColor", "Lkotlin/Function1;", "Landroidx/compose/runtime/Composable;", "showLabel", "", "content", "Lkotlin/Function5;", "", "Lkotlin/ParameterName;", "name", "labelProgress", "labelTextStyleColor", "labelContentColor", "placeholderOpacity", "prefixSuffixOpacity", "Transition-DTcfvLk", "(Landroidx/compose/material3/InputPhase;JJLkotlin/jvm/functions/Function3;ZLkotlin/jvm/functions/Function7;Landroidx/compose/runtime/Composer;I)V", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class TextFieldTransitionScope {
    public static final TextFieldTransitionScope INSTANCE = new TextFieldTransitionScope();

    /* compiled from: TextFieldImpl.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[InputPhase.values().length];
            try {
                iArr[InputPhase.Focused.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[InputPhase.UnfocusedEmpty.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[InputPhase.UnfocusedNotEmpty.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private TextFieldTransitionScope() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:187:0x023a, code lost:
    
        if (r33 != false) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:192:0x01f0, code lost:
    
        if (r33 != false) goto L99;
     */
    /* JADX WARN: Removed duplicated region for block: B:101:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x02a3  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x02b3  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x02cc  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x02fa  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0311  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0363  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0371  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x037c  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x039b  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x03d2  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x03e1  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x03ec  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0408  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0417  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0422  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0495  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0540  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x041a  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x03e4  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0374  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0217  */
    /* renamed from: Transition-DTcfvLk, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m2779TransitionDTcfvLk(final InputPhase inputPhase, final long j, final long j2, final Function3<? super InputPhase, ? super Composer, ? super Integer, Color> function3, final boolean z, final Function7<? super Float, ? super Color, ? super Color, ? super Float, ? super Float, ? super Composer, ? super Integer, Unit> function7, Composer composer, final int i) {
        int i2;
        Function7<? super Float, ? super Color, ? super Color, ? super Float, ? super Float, ? super Composer, ? super Integer, Unit> function72;
        float f;
        Float f2;
        InputPhase inputPhase2;
        int i3;
        int i4;
        float f3;
        int i5;
        float f4;
        Float f5;
        int i6;
        float f6;
        int i7;
        float f7;
        int i8;
        boolean changed;
        Object rememberedValue;
        boolean changed2;
        Object rememberedValue2;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-995111872);
        ComposerKt.sourceInformation(startRestartGroup, "C(Transition)P(3,2:c#ui.graphics.Color,5:c#ui.graphics.Color,1,4)313@12767L59,315@12868L325,326@13240L1101,354@14389L354,365@14791L299,375@15136L186,381@15332L174:TextFieldImpl.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(inputPhase) ? 4 : 2) | i;
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
            i2 |= startRestartGroup.changedInstance(function3) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= startRestartGroup.changed(z) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            function72 = function7;
            i2 |= startRestartGroup.changedInstance(function72) ? 131072 : 65536;
        } else {
            function72 = function7;
        }
        if ((74899 & i2) == 74898 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-995111872, i2, -1, "androidx.compose.material3.TextFieldTransitionScope.Transition (TextFieldImpl.kt:309)");
            }
            Transition updateTransition = TransitionKt.updateTransition(inputPhase, "TextFieldInputState", startRestartGroup, (i2 & 14) | 48, 0);
            TextFieldTransitionScope$Transition$labelProgress$2 textFieldTransitionScope$Transition$labelProgress$2 = new Function3<Transition.Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.material3.TextFieldTransitionScope$Transition$labelProgress$2
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ FiniteAnimationSpec<Float> invoke(Transition.Segment<InputPhase> segment, Composer composer3, Integer num) {
                    return invoke(segment, composer3, num.intValue());
                }

                public final FiniteAnimationSpec<Float> invoke(Transition.Segment<InputPhase> segment, Composer composer3, int i9) {
                    composer3.startReplaceableGroup(-4765522);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-4765522, i9, -1, "androidx.compose.material3.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:317)");
                    }
                    TweenSpec tween$default = AnimationSpecKt.tween$default(150, 0, null, 6, null);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer3.endReplaceableGroup();
                    return tween$default;
                }
            };
            startRestartGroup.startReplaceableGroup(-1338768149);
            ComposerKt.sourceInformation(startRestartGroup, "CC(animateFloat)P(2)1165@46369L78:Transition.kt#pdpnli");
            TwoWayConverter<Float, AnimationVector1D> vectorConverter = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
            startRestartGroup.startReplaceableGroup(-142660079);
            ComposerKt.sourceInformation(startRestartGroup, "CC(animateValue)P(3,2)1082@42932L32,1083@42987L31,1084@43043L23,1086@43079L89:Transition.kt#pdpnli");
            InputPhase inputPhase3 = (InputPhase) updateTransition.getCurrentState();
            startRestartGroup.startReplaceableGroup(240378898);
            ComposerKt.sourceInformation(startRestartGroup, "C:TextFieldImpl.kt#uh7d8r");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(240378898, 0, -1, "androidx.compose.material3.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:319)");
            }
            int i9 = WhenMappings.$EnumSwitchMapping$0[inputPhase3.ordinal()];
            float f8 = 1.0f;
            if (i9 != 1) {
                if (i9 == 2) {
                    f = 0.0f;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    startRestartGroup.endReplaceableGroup();
                    Float valueOf = Float.valueOf(f);
                    InputPhase inputPhase4 = (InputPhase) updateTransition.getTargetState();
                    startRestartGroup.startReplaceableGroup(240378898);
                    ComposerKt.sourceInformation(startRestartGroup, "C:TextFieldImpl.kt#uh7d8r");
                    if (ComposerKt.isTraceInProgress()) {
                        f2 = valueOf;
                        inputPhase2 = inputPhase4;
                        i3 = -1;
                    } else {
                        f2 = valueOf;
                        inputPhase2 = inputPhase4;
                        i3 = -1;
                        ComposerKt.traceEventStart(240378898, 0, -1, "androidx.compose.material3.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:319)");
                    }
                    i4 = WhenMappings.$EnumSwitchMapping$0[inputPhase2.ordinal()];
                    if (i4 != 1) {
                        if (i4 == 2) {
                            f3 = 0.0f;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            startRestartGroup.endReplaceableGroup();
                            State createTransitionAnimation = TransitionKt.createTransitionAnimation(updateTransition, f2, Float.valueOf(f3), textFieldTransitionScope$Transition$labelProgress$2.invoke((TextFieldTransitionScope$Transition$labelProgress$2) updateTransition.getSegment(), (Transition.Segment) startRestartGroup, (Composer) 0), vectorConverter, "LabelProgress", startRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
                            startRestartGroup.endReplaceableGroup();
                            startRestartGroup.endReplaceableGroup();
                            TextFieldTransitionScope$Transition$placeholderOpacity$2 textFieldTransitionScope$Transition$placeholderOpacity$2 = new Function3<Transition.Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.material3.TextFieldTransitionScope$Transition$placeholderOpacity$2
                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ FiniteAnimationSpec<Float> invoke(Transition.Segment<InputPhase> segment, Composer composer3, Integer num) {
                                    return invoke(segment, composer3, num.intValue());
                                }

                                public final FiniteAnimationSpec<Float> invoke(Transition.Segment<InputPhase> segment, Composer composer3, int i10) {
                                    TweenSpec tween;
                                    composer3.startReplaceableGroup(-1635067817);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1635067817, i10, -1, "androidx.compose.material3.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:329)");
                                    }
                                    if (segment.isTransitioningTo(InputPhase.Focused, InputPhase.UnfocusedEmpty)) {
                                        tween = AnimationSpecKt.tween$default(67, 0, EasingKt.getLinearEasing(), 2, null);
                                    } else if (segment.isTransitioningTo(InputPhase.UnfocusedEmpty, InputPhase.Focused) || segment.isTransitioningTo(InputPhase.UnfocusedNotEmpty, InputPhase.UnfocusedEmpty)) {
                                        tween = AnimationSpecKt.tween(83, 67, EasingKt.getLinearEasing());
                                    } else {
                                        tween = AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    composer3.endReplaceableGroup();
                                    return tween;
                                }
                            };
                            startRestartGroup.startReplaceableGroup(-1338768149);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(animateFloat)P(2)1165@46369L78:Transition.kt#pdpnli");
                            TwoWayConverter<Float, AnimationVector1D> vectorConverter2 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
                            startRestartGroup.startReplaceableGroup(-142660079);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(animateValue)P(3,2)1082@42932L32,1083@42987L31,1084@43043L23,1086@43079L89:Transition.kt#pdpnli");
                            InputPhase inputPhase5 = (InputPhase) updateTransition.getCurrentState();
                            startRestartGroup.startReplaceableGroup(2067512179);
                            ComposerKt.sourceInformation(startRestartGroup, "C:TextFieldImpl.kt#uh7d8r");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(2067512179, 0, i3, "androidx.compose.material3.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:347)");
                            }
                            i5 = WhenMappings.$EnumSwitchMapping$0[inputPhase5.ordinal()];
                            if (i5 != 1) {
                                if (i5 != 2) {
                                    if (i5 != 3) {
                                        throw new NoWhenBranchMatchedException();
                                    }
                                }
                                f4 = 0.0f;
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                startRestartGroup.endReplaceableGroup();
                                Float valueOf2 = Float.valueOf(f4);
                                InputPhase inputPhase6 = (InputPhase) updateTransition.getTargetState();
                                startRestartGroup.startReplaceableGroup(2067512179);
                                ComposerKt.sourceInformation(startRestartGroup, "C:TextFieldImpl.kt#uh7d8r");
                                if (ComposerKt.isTraceInProgress()) {
                                    f5 = valueOf2;
                                } else {
                                    f5 = valueOf2;
                                    ComposerKt.traceEventStart(2067512179, 0, i3, "androidx.compose.material3.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:347)");
                                }
                                i6 = WhenMappings.$EnumSwitchMapping$0[inputPhase6.ordinal()];
                                if (i6 != 1) {
                                    if (i6 != 2) {
                                        if (i6 != 3) {
                                            throw new NoWhenBranchMatchedException();
                                        }
                                    }
                                    f6 = 0.0f;
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    startRestartGroup.endReplaceableGroup();
                                    State createTransitionAnimation2 = TransitionKt.createTransitionAnimation(updateTransition, f5, Float.valueOf(f6), textFieldTransitionScope$Transition$placeholderOpacity$2.invoke((TextFieldTransitionScope$Transition$placeholderOpacity$2) updateTransition.getSegment(), (Transition.Segment) startRestartGroup, (Composer) 0), vectorConverter2, "PlaceholderOpacity", startRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
                                    startRestartGroup.endReplaceableGroup();
                                    startRestartGroup.endReplaceableGroup();
                                    TextFieldTransitionScope$Transition$prefixSuffixOpacity$2 textFieldTransitionScope$Transition$prefixSuffixOpacity$2 = new Function3<Transition.Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.material3.TextFieldTransitionScope$Transition$prefixSuffixOpacity$2
                                        @Override // kotlin.jvm.functions.Function3
                                        public /* bridge */ /* synthetic */ FiniteAnimationSpec<Float> invoke(Transition.Segment<InputPhase> segment, Composer composer3, Integer num) {
                                            return invoke(segment, composer3, num.intValue());
                                        }

                                        public final FiniteAnimationSpec<Float> invoke(Transition.Segment<InputPhase> segment, Composer composer3, int i10) {
                                            composer3.startReplaceableGroup(1189967029);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1189967029, i10, -1, "androidx.compose.material3.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:356)");
                                            }
                                            TweenSpec tween$default = AnimationSpecKt.tween$default(150, 0, null, 6, null);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                            composer3.endReplaceableGroup();
                                            return tween$default;
                                        }
                                    };
                                    startRestartGroup.startReplaceableGroup(-1338768149);
                                    ComposerKt.sourceInformation(startRestartGroup, "CC(animateFloat)P(2)1165@46369L78:Transition.kt#pdpnli");
                                    TwoWayConverter<Float, AnimationVector1D> vectorConverter3 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
                                    startRestartGroup.startReplaceableGroup(-142660079);
                                    ComposerKt.sourceInformation(startRestartGroup, "CC(animateValue)P(3,2)1082@42932L32,1083@42987L31,1084@43043L23,1086@43079L89:Transition.kt#pdpnli");
                                    InputPhase inputPhase7 = (InputPhase) updateTransition.getCurrentState();
                                    startRestartGroup.startReplaceableGroup(5829913);
                                    ComposerKt.sourceInformation(startRestartGroup, "C:TextFieldImpl.kt#uh7d8r");
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(5829913, 0, i3, "androidx.compose.material3.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:358)");
                                    }
                                    i7 = WhenMappings.$EnumSwitchMapping$0[inputPhase7.ordinal()];
                                    if (i7 != 1) {
                                        if (i7 != 2) {
                                            if (i7 != 3) {
                                                throw new NoWhenBranchMatchedException();
                                            }
                                        } else if (z) {
                                            f7 = 0.0f;
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                            startRestartGroup.endReplaceableGroup();
                                            Float valueOf3 = Float.valueOf(f7);
                                            InputPhase inputPhase8 = (InputPhase) updateTransition.getTargetState();
                                            startRestartGroup.startReplaceableGroup(5829913);
                                            ComposerKt.sourceInformation(startRestartGroup, "C:TextFieldImpl.kt#uh7d8r");
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(5829913, 0, i3, "androidx.compose.material3.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:358)");
                                            }
                                            i8 = WhenMappings.$EnumSwitchMapping$0[inputPhase8.ordinal()];
                                            if (i8 != 1) {
                                                if (i8 != 2) {
                                                    if (i8 != 3) {
                                                        throw new NoWhenBranchMatchedException();
                                                    }
                                                } else if (z) {
                                                    f8 = 0.0f;
                                                }
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                            startRestartGroup.endReplaceableGroup();
                                            State createTransitionAnimation3 = TransitionKt.createTransitionAnimation(updateTransition, valueOf3, Float.valueOf(f8), textFieldTransitionScope$Transition$prefixSuffixOpacity$2.invoke((TextFieldTransitionScope$Transition$prefixSuffixOpacity$2) updateTransition.getSegment(), (Transition.Segment) startRestartGroup, (Composer) 0), vectorConverter3, "PrefixSuffixOpacity", startRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
                                            startRestartGroup.endReplaceableGroup();
                                            startRestartGroup.endReplaceableGroup();
                                            TextFieldTransitionScope$Transition$labelTextStyleColor$2 textFieldTransitionScope$Transition$labelTextStyleColor$2 = new Function3<Transition.Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Color>>() { // from class: androidx.compose.material3.TextFieldTransitionScope$Transition$labelTextStyleColor$2
                                                @Override // kotlin.jvm.functions.Function3
                                                public /* bridge */ /* synthetic */ FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> segment, Composer composer3, Integer num) {
                                                    return invoke(segment, composer3, num.intValue());
                                                }

                                                public final FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> segment, Composer composer3, int i10) {
                                                    composer3.startReplaceableGroup(2041936647);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(2041936647, i10, -1, "androidx.compose.material3.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:366)");
                                                    }
                                                    TweenSpec tween$default = AnimationSpecKt.tween$default(150, 0, null, 6, null);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                    composer3.endReplaceableGroup();
                                                    return tween$default;
                                                }
                                            };
                                            startRestartGroup.startReplaceableGroup(-1939694975);
                                            ComposerKt.sourceInformation(startRestartGroup, "CC(animateColor)P(2)68@3220L31,69@3287L70,73@3370L70:Transition.kt#xbi5r1");
                                            InputPhase inputPhase9 = (InputPhase) updateTransition.getTargetState();
                                            startRestartGroup.startReplaceableGroup(-1468066062);
                                            ComposerKt.sourceInformation(startRestartGroup, "C:TextFieldImpl.kt#uh7d8r");
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1468066062, 0, i3, "androidx.compose.material3.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:369)");
                                            }
                                            long j3 = WhenMappings.$EnumSwitchMapping$0[inputPhase9.ordinal()] != 1 ? j : j2;
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                            startRestartGroup.endReplaceableGroup();
                                            ColorSpace m4067getColorSpaceimpl = Color.m4067getColorSpaceimpl(j3);
                                            startRestartGroup.startReplaceableGroup(1157296644);
                                            ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1):Composables.kt#9igjgp");
                                            changed = startRestartGroup.changed(m4067getColorSpaceimpl);
                                            rememberedValue = startRestartGroup.rememberedValue();
                                            if (!changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                                rememberedValue = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.INSTANCE).invoke(m4067getColorSpaceimpl);
                                                startRestartGroup.updateRememberedValue(rememberedValue);
                                            }
                                            startRestartGroup.endReplaceableGroup();
                                            TwoWayConverter twoWayConverter = (TwoWayConverter) rememberedValue;
                                            startRestartGroup.startReplaceableGroup(-142660079);
                                            ComposerKt.sourceInformation(startRestartGroup, "CC(animateValue)P(3,2)1082@42932L32,1083@42987L31,1084@43043L23,1086@43079L89:Transition.kt#pdpnli");
                                            InputPhase inputPhase10 = (InputPhase) updateTransition.getCurrentState();
                                            startRestartGroup.startReplaceableGroup(-1468066062);
                                            ComposerKt.sourceInformation(startRestartGroup, "C:TextFieldImpl.kt#uh7d8r");
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1468066062, 0, i3, "androidx.compose.material3.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:369)");
                                            }
                                            long j4 = WhenMappings.$EnumSwitchMapping$0[inputPhase10.ordinal()] != 1 ? j : j2;
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                            startRestartGroup.endReplaceableGroup();
                                            Color m4053boximpl = Color.m4053boximpl(j4);
                                            InputPhase inputPhase11 = (InputPhase) updateTransition.getTargetState();
                                            startRestartGroup.startReplaceableGroup(-1468066062);
                                            ComposerKt.sourceInformation(startRestartGroup, "C:TextFieldImpl.kt#uh7d8r");
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1468066062, 0, i3, "androidx.compose.material3.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:369)");
                                            }
                                            long j5 = WhenMappings.$EnumSwitchMapping$0[inputPhase11.ordinal()] != 1 ? j : j2;
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                            startRestartGroup.endReplaceableGroup();
                                            State createTransitionAnimation4 = TransitionKt.createTransitionAnimation(updateTransition, m4053boximpl, Color.m4053boximpl(j5), textFieldTransitionScope$Transition$labelTextStyleColor$2.invoke((TextFieldTransitionScope$Transition$labelTextStyleColor$2) updateTransition.getSegment(), (Transition.Segment) startRestartGroup, (Composer) 0), twoWayConverter, "LabelTextStyleColor", startRestartGroup, 229376);
                                            startRestartGroup.endReplaceableGroup();
                                            startRestartGroup.endReplaceableGroup();
                                            TextFieldTransitionScope$Transition$labelContentColor$2 textFieldTransitionScope$Transition$labelContentColor$2 = new Function3<Transition.Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Color>>() { // from class: androidx.compose.material3.TextFieldTransitionScope$Transition$labelContentColor$2
                                                @Override // kotlin.jvm.functions.Function3
                                                public /* bridge */ /* synthetic */ FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> segment, Composer composer3, Integer num) {
                                                    return invoke(segment, composer3, num.intValue());
                                                }

                                                public final FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> segment, Composer composer3, int i10) {
                                                    composer3.startReplaceableGroup(766065458);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(766065458, i10, -1, "androidx.compose.material3.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:376)");
                                                    }
                                                    TweenSpec tween$default = AnimationSpecKt.tween$default(150, 0, null, 6, null);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                    composer3.endReplaceableGroup();
                                                    return tween$default;
                                                }
                                            };
                                            int i10 = (i2 & 7168) | 384;
                                            startRestartGroup.startReplaceableGroup(-1939694975);
                                            ComposerKt.sourceInformation(startRestartGroup, "CC(animateColor)P(2)68@3220L31,69@3287L70,73@3370L70:Transition.kt#xbi5r1");
                                            ColorSpace m4067getColorSpaceimpl2 = Color.m4067getColorSpaceimpl(function3.invoke(updateTransition.getTargetState(), startRestartGroup, Integer.valueOf((i10 >> 6) & 112)).m4073unboximpl());
                                            startRestartGroup.startReplaceableGroup(1157296644);
                                            ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1):Composables.kt#9igjgp");
                                            changed2 = startRestartGroup.changed(m4067getColorSpaceimpl2);
                                            rememberedValue2 = startRestartGroup.rememberedValue();
                                            if (!changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                rememberedValue2 = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.INSTANCE).invoke(m4067getColorSpaceimpl2);
                                                startRestartGroup.updateRememberedValue(rememberedValue2);
                                            }
                                            startRestartGroup.endReplaceableGroup();
                                            startRestartGroup.startReplaceableGroup(-142660079);
                                            ComposerKt.sourceInformation(startRestartGroup, "CC(animateValue)P(3,2)1082@42932L32,1083@42987L31,1084@43043L23,1086@43079L89:Transition.kt#pdpnli");
                                            int i11 = ((((i10 << 3) & 57344) | 3136) >> 9) & 112;
                                            composer2 = startRestartGroup;
                                            State createTransitionAnimation5 = TransitionKt.createTransitionAnimation(updateTransition, function3.invoke(updateTransition.getCurrentState(), startRestartGroup, Integer.valueOf(i11)), function3.invoke(updateTransition.getTargetState(), startRestartGroup, Integer.valueOf(i11)), textFieldTransitionScope$Transition$labelContentColor$2.invoke((TextFieldTransitionScope$Transition$labelContentColor$2) updateTransition.getSegment(), (Transition.Segment) startRestartGroup, (Composer) 0), (TwoWayConverter) rememberedValue2, "LabelContentColor", composer2, 229376);
                                            composer2.endReplaceableGroup();
                                            composer2.endReplaceableGroup();
                                            function72.invoke(Float.valueOf(Transition_DTcfvLk$lambda$1(createTransitionAnimation)), Color.m4053boximpl(Transition_DTcfvLk$lambda$7(createTransitionAnimation4)), Color.m4053boximpl(Transition_DTcfvLk$lambda$8(createTransitionAnimation5)), Float.valueOf(Transition_DTcfvLk$lambda$3(createTransitionAnimation2)), Float.valueOf(Transition_DTcfvLk$lambda$5(createTransitionAnimation3)), composer2, Integer.valueOf(458752 & i2));
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }
                                    f7 = 1.0f;
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    startRestartGroup.endReplaceableGroup();
                                    Float valueOf32 = Float.valueOf(f7);
                                    InputPhase inputPhase82 = (InputPhase) updateTransition.getTargetState();
                                    startRestartGroup.startReplaceableGroup(5829913);
                                    ComposerKt.sourceInformation(startRestartGroup, "C:TextFieldImpl.kt#uh7d8r");
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    i8 = WhenMappings.$EnumSwitchMapping$0[inputPhase82.ordinal()];
                                    if (i8 != 1) {
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    startRestartGroup.endReplaceableGroup();
                                    State createTransitionAnimation32 = TransitionKt.createTransitionAnimation(updateTransition, valueOf32, Float.valueOf(f8), textFieldTransitionScope$Transition$prefixSuffixOpacity$2.invoke((TextFieldTransitionScope$Transition$prefixSuffixOpacity$2) updateTransition.getSegment(), (Transition.Segment) startRestartGroup, (Composer) 0), vectorConverter3, "PrefixSuffixOpacity", startRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
                                    startRestartGroup.endReplaceableGroup();
                                    startRestartGroup.endReplaceableGroup();
                                    TextFieldTransitionScope$Transition$labelTextStyleColor$2 textFieldTransitionScope$Transition$labelTextStyleColor$22 = new Function3<Transition.Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Color>>() { // from class: androidx.compose.material3.TextFieldTransitionScope$Transition$labelTextStyleColor$2
                                        @Override // kotlin.jvm.functions.Function3
                                        public /* bridge */ /* synthetic */ FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> segment, Composer composer3, Integer num) {
                                            return invoke(segment, composer3, num.intValue());
                                        }

                                        public final FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> segment, Composer composer3, int i102) {
                                            composer3.startReplaceableGroup(2041936647);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(2041936647, i102, -1, "androidx.compose.material3.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:366)");
                                            }
                                            TweenSpec tween$default = AnimationSpecKt.tween$default(150, 0, null, 6, null);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                            composer3.endReplaceableGroup();
                                            return tween$default;
                                        }
                                    };
                                    startRestartGroup.startReplaceableGroup(-1939694975);
                                    ComposerKt.sourceInformation(startRestartGroup, "CC(animateColor)P(2)68@3220L31,69@3287L70,73@3370L70:Transition.kt#xbi5r1");
                                    InputPhase inputPhase92 = (InputPhase) updateTransition.getTargetState();
                                    startRestartGroup.startReplaceableGroup(-1468066062);
                                    ComposerKt.sourceInformation(startRestartGroup, "C:TextFieldImpl.kt#uh7d8r");
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    if (WhenMappings.$EnumSwitchMapping$0[inputPhase92.ordinal()] != 1) {
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    startRestartGroup.endReplaceableGroup();
                                    ColorSpace m4067getColorSpaceimpl3 = Color.m4067getColorSpaceimpl(j3);
                                    startRestartGroup.startReplaceableGroup(1157296644);
                                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1):Composables.kt#9igjgp");
                                    changed = startRestartGroup.changed(m4067getColorSpaceimpl3);
                                    rememberedValue = startRestartGroup.rememberedValue();
                                    if (!changed) {
                                    }
                                    rememberedValue = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.INSTANCE).invoke(m4067getColorSpaceimpl3);
                                    startRestartGroup.updateRememberedValue(rememberedValue);
                                    startRestartGroup.endReplaceableGroup();
                                    TwoWayConverter twoWayConverter2 = (TwoWayConverter) rememberedValue;
                                    startRestartGroup.startReplaceableGroup(-142660079);
                                    ComposerKt.sourceInformation(startRestartGroup, "CC(animateValue)P(3,2)1082@42932L32,1083@42987L31,1084@43043L23,1086@43079L89:Transition.kt#pdpnli");
                                    InputPhase inputPhase102 = (InputPhase) updateTransition.getCurrentState();
                                    startRestartGroup.startReplaceableGroup(-1468066062);
                                    ComposerKt.sourceInformation(startRestartGroup, "C:TextFieldImpl.kt#uh7d8r");
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    if (WhenMappings.$EnumSwitchMapping$0[inputPhase102.ordinal()] != 1) {
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    startRestartGroup.endReplaceableGroup();
                                    Color m4053boximpl2 = Color.m4053boximpl(j4);
                                    InputPhase inputPhase112 = (InputPhase) updateTransition.getTargetState();
                                    startRestartGroup.startReplaceableGroup(-1468066062);
                                    ComposerKt.sourceInformation(startRestartGroup, "C:TextFieldImpl.kt#uh7d8r");
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    if (WhenMappings.$EnumSwitchMapping$0[inputPhase112.ordinal()] != 1) {
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    startRestartGroup.endReplaceableGroup();
                                    State createTransitionAnimation42 = TransitionKt.createTransitionAnimation(updateTransition, m4053boximpl2, Color.m4053boximpl(j5), textFieldTransitionScope$Transition$labelTextStyleColor$22.invoke((TextFieldTransitionScope$Transition$labelTextStyleColor$2) updateTransition.getSegment(), (Transition.Segment) startRestartGroup, (Composer) 0), twoWayConverter2, "LabelTextStyleColor", startRestartGroup, 229376);
                                    startRestartGroup.endReplaceableGroup();
                                    startRestartGroup.endReplaceableGroup();
                                    TextFieldTransitionScope$Transition$labelContentColor$2 textFieldTransitionScope$Transition$labelContentColor$22 = new Function3<Transition.Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Color>>() { // from class: androidx.compose.material3.TextFieldTransitionScope$Transition$labelContentColor$2
                                        @Override // kotlin.jvm.functions.Function3
                                        public /* bridge */ /* synthetic */ FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> segment, Composer composer3, Integer num) {
                                            return invoke(segment, composer3, num.intValue());
                                        }

                                        public final FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> segment, Composer composer3, int i102) {
                                            composer3.startReplaceableGroup(766065458);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(766065458, i102, -1, "androidx.compose.material3.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:376)");
                                            }
                                            TweenSpec tween$default = AnimationSpecKt.tween$default(150, 0, null, 6, null);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                            composer3.endReplaceableGroup();
                                            return tween$default;
                                        }
                                    };
                                    int i102 = (i2 & 7168) | 384;
                                    startRestartGroup.startReplaceableGroup(-1939694975);
                                    ComposerKt.sourceInformation(startRestartGroup, "CC(animateColor)P(2)68@3220L31,69@3287L70,73@3370L70:Transition.kt#xbi5r1");
                                    ColorSpace m4067getColorSpaceimpl22 = Color.m4067getColorSpaceimpl(function3.invoke(updateTransition.getTargetState(), startRestartGroup, Integer.valueOf((i102 >> 6) & 112)).m4073unboximpl());
                                    startRestartGroup.startReplaceableGroup(1157296644);
                                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1):Composables.kt#9igjgp");
                                    changed2 = startRestartGroup.changed(m4067getColorSpaceimpl22);
                                    rememberedValue2 = startRestartGroup.rememberedValue();
                                    if (!changed2) {
                                    }
                                    rememberedValue2 = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.INSTANCE).invoke(m4067getColorSpaceimpl22);
                                    startRestartGroup.updateRememberedValue(rememberedValue2);
                                    startRestartGroup.endReplaceableGroup();
                                    startRestartGroup.startReplaceableGroup(-142660079);
                                    ComposerKt.sourceInformation(startRestartGroup, "CC(animateValue)P(3,2)1082@42932L32,1083@42987L31,1084@43043L23,1086@43079L89:Transition.kt#pdpnli");
                                    int i112 = ((((i102 << 3) & 57344) | 3136) >> 9) & 112;
                                    composer2 = startRestartGroup;
                                    State createTransitionAnimation52 = TransitionKt.createTransitionAnimation(updateTransition, function3.invoke(updateTransition.getCurrentState(), startRestartGroup, Integer.valueOf(i112)), function3.invoke(updateTransition.getTargetState(), startRestartGroup, Integer.valueOf(i112)), textFieldTransitionScope$Transition$labelContentColor$22.invoke((TextFieldTransitionScope$Transition$labelContentColor$2) updateTransition.getSegment(), (Transition.Segment) startRestartGroup, (Composer) 0), (TwoWayConverter) rememberedValue2, "LabelContentColor", composer2, 229376);
                                    composer2.endReplaceableGroup();
                                    composer2.endReplaceableGroup();
                                    function72.invoke(Float.valueOf(Transition_DTcfvLk$lambda$1(createTransitionAnimation)), Color.m4053boximpl(Transition_DTcfvLk$lambda$7(createTransitionAnimation42)), Color.m4053boximpl(Transition_DTcfvLk$lambda$8(createTransitionAnimation52)), Float.valueOf(Transition_DTcfvLk$lambda$3(createTransitionAnimation2)), Float.valueOf(Transition_DTcfvLk$lambda$5(createTransitionAnimation32)), composer2, Integer.valueOf(458752 & i2));
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                }
                                f6 = 1.0f;
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                startRestartGroup.endReplaceableGroup();
                                State createTransitionAnimation22 = TransitionKt.createTransitionAnimation(updateTransition, f5, Float.valueOf(f6), textFieldTransitionScope$Transition$placeholderOpacity$2.invoke((TextFieldTransitionScope$Transition$placeholderOpacity$2) updateTransition.getSegment(), (Transition.Segment) startRestartGroup, (Composer) 0), vectorConverter2, "PlaceholderOpacity", startRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
                                startRestartGroup.endReplaceableGroup();
                                startRestartGroup.endReplaceableGroup();
                                TextFieldTransitionScope$Transition$prefixSuffixOpacity$2 textFieldTransitionScope$Transition$prefixSuffixOpacity$22 = new Function3<Transition.Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.material3.TextFieldTransitionScope$Transition$prefixSuffixOpacity$2
                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ FiniteAnimationSpec<Float> invoke(Transition.Segment<InputPhase> segment, Composer composer3, Integer num) {
                                        return invoke(segment, composer3, num.intValue());
                                    }

                                    public final FiniteAnimationSpec<Float> invoke(Transition.Segment<InputPhase> segment, Composer composer3, int i103) {
                                        composer3.startReplaceableGroup(1189967029);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1189967029, i103, -1, "androidx.compose.material3.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:356)");
                                        }
                                        TweenSpec tween$default = AnimationSpecKt.tween$default(150, 0, null, 6, null);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                        composer3.endReplaceableGroup();
                                        return tween$default;
                                    }
                                };
                                startRestartGroup.startReplaceableGroup(-1338768149);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(animateFloat)P(2)1165@46369L78:Transition.kt#pdpnli");
                                TwoWayConverter<Float, AnimationVector1D> vectorConverter32 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
                                startRestartGroup.startReplaceableGroup(-142660079);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(animateValue)P(3,2)1082@42932L32,1083@42987L31,1084@43043L23,1086@43079L89:Transition.kt#pdpnli");
                                InputPhase inputPhase72 = (InputPhase) updateTransition.getCurrentState();
                                startRestartGroup.startReplaceableGroup(5829913);
                                ComposerKt.sourceInformation(startRestartGroup, "C:TextFieldImpl.kt#uh7d8r");
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                i7 = WhenMappings.$EnumSwitchMapping$0[inputPhase72.ordinal()];
                                if (i7 != 1) {
                                }
                                f7 = 1.0f;
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                startRestartGroup.endReplaceableGroup();
                                Float valueOf322 = Float.valueOf(f7);
                                InputPhase inputPhase822 = (InputPhase) updateTransition.getTargetState();
                                startRestartGroup.startReplaceableGroup(5829913);
                                ComposerKt.sourceInformation(startRestartGroup, "C:TextFieldImpl.kt#uh7d8r");
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                i8 = WhenMappings.$EnumSwitchMapping$0[inputPhase822.ordinal()];
                                if (i8 != 1) {
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                startRestartGroup.endReplaceableGroup();
                                State createTransitionAnimation322 = TransitionKt.createTransitionAnimation(updateTransition, valueOf322, Float.valueOf(f8), textFieldTransitionScope$Transition$prefixSuffixOpacity$22.invoke((TextFieldTransitionScope$Transition$prefixSuffixOpacity$2) updateTransition.getSegment(), (Transition.Segment) startRestartGroup, (Composer) 0), vectorConverter32, "PrefixSuffixOpacity", startRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
                                startRestartGroup.endReplaceableGroup();
                                startRestartGroup.endReplaceableGroup();
                                TextFieldTransitionScope$Transition$labelTextStyleColor$2 textFieldTransitionScope$Transition$labelTextStyleColor$222 = new Function3<Transition.Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Color>>() { // from class: androidx.compose.material3.TextFieldTransitionScope$Transition$labelTextStyleColor$2
                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> segment, Composer composer3, Integer num) {
                                        return invoke(segment, composer3, num.intValue());
                                    }

                                    public final FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> segment, Composer composer3, int i1022) {
                                        composer3.startReplaceableGroup(2041936647);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(2041936647, i1022, -1, "androidx.compose.material3.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:366)");
                                        }
                                        TweenSpec tween$default = AnimationSpecKt.tween$default(150, 0, null, 6, null);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                        composer3.endReplaceableGroup();
                                        return tween$default;
                                    }
                                };
                                startRestartGroup.startReplaceableGroup(-1939694975);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(animateColor)P(2)68@3220L31,69@3287L70,73@3370L70:Transition.kt#xbi5r1");
                                InputPhase inputPhase922 = (InputPhase) updateTransition.getTargetState();
                                startRestartGroup.startReplaceableGroup(-1468066062);
                                ComposerKt.sourceInformation(startRestartGroup, "C:TextFieldImpl.kt#uh7d8r");
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                if (WhenMappings.$EnumSwitchMapping$0[inputPhase922.ordinal()] != 1) {
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                startRestartGroup.endReplaceableGroup();
                                ColorSpace m4067getColorSpaceimpl32 = Color.m4067getColorSpaceimpl(j3);
                                startRestartGroup.startReplaceableGroup(1157296644);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1):Composables.kt#9igjgp");
                                changed = startRestartGroup.changed(m4067getColorSpaceimpl32);
                                rememberedValue = startRestartGroup.rememberedValue();
                                if (!changed) {
                                }
                                rememberedValue = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.INSTANCE).invoke(m4067getColorSpaceimpl32);
                                startRestartGroup.updateRememberedValue(rememberedValue);
                                startRestartGroup.endReplaceableGroup();
                                TwoWayConverter twoWayConverter22 = (TwoWayConverter) rememberedValue;
                                startRestartGroup.startReplaceableGroup(-142660079);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(animateValue)P(3,2)1082@42932L32,1083@42987L31,1084@43043L23,1086@43079L89:Transition.kt#pdpnli");
                                InputPhase inputPhase1022 = (InputPhase) updateTransition.getCurrentState();
                                startRestartGroup.startReplaceableGroup(-1468066062);
                                ComposerKt.sourceInformation(startRestartGroup, "C:TextFieldImpl.kt#uh7d8r");
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                if (WhenMappings.$EnumSwitchMapping$0[inputPhase1022.ordinal()] != 1) {
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                startRestartGroup.endReplaceableGroup();
                                Color m4053boximpl22 = Color.m4053boximpl(j4);
                                InputPhase inputPhase1122 = (InputPhase) updateTransition.getTargetState();
                                startRestartGroup.startReplaceableGroup(-1468066062);
                                ComposerKt.sourceInformation(startRestartGroup, "C:TextFieldImpl.kt#uh7d8r");
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                if (WhenMappings.$EnumSwitchMapping$0[inputPhase1122.ordinal()] != 1) {
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                startRestartGroup.endReplaceableGroup();
                                State createTransitionAnimation422 = TransitionKt.createTransitionAnimation(updateTransition, m4053boximpl22, Color.m4053boximpl(j5), textFieldTransitionScope$Transition$labelTextStyleColor$222.invoke((TextFieldTransitionScope$Transition$labelTextStyleColor$2) updateTransition.getSegment(), (Transition.Segment) startRestartGroup, (Composer) 0), twoWayConverter22, "LabelTextStyleColor", startRestartGroup, 229376);
                                startRestartGroup.endReplaceableGroup();
                                startRestartGroup.endReplaceableGroup();
                                TextFieldTransitionScope$Transition$labelContentColor$2 textFieldTransitionScope$Transition$labelContentColor$222 = new Function3<Transition.Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Color>>() { // from class: androidx.compose.material3.TextFieldTransitionScope$Transition$labelContentColor$2
                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> segment, Composer composer3, Integer num) {
                                        return invoke(segment, composer3, num.intValue());
                                    }

                                    public final FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> segment, Composer composer3, int i1022) {
                                        composer3.startReplaceableGroup(766065458);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(766065458, i1022, -1, "androidx.compose.material3.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:376)");
                                        }
                                        TweenSpec tween$default = AnimationSpecKt.tween$default(150, 0, null, 6, null);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                        composer3.endReplaceableGroup();
                                        return tween$default;
                                    }
                                };
                                int i1022 = (i2 & 7168) | 384;
                                startRestartGroup.startReplaceableGroup(-1939694975);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(animateColor)P(2)68@3220L31,69@3287L70,73@3370L70:Transition.kt#xbi5r1");
                                ColorSpace m4067getColorSpaceimpl222 = Color.m4067getColorSpaceimpl(function3.invoke(updateTransition.getTargetState(), startRestartGroup, Integer.valueOf((i1022 >> 6) & 112)).m4073unboximpl());
                                startRestartGroup.startReplaceableGroup(1157296644);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1):Composables.kt#9igjgp");
                                changed2 = startRestartGroup.changed(m4067getColorSpaceimpl222);
                                rememberedValue2 = startRestartGroup.rememberedValue();
                                if (!changed2) {
                                }
                                rememberedValue2 = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.INSTANCE).invoke(m4067getColorSpaceimpl222);
                                startRestartGroup.updateRememberedValue(rememberedValue2);
                                startRestartGroup.endReplaceableGroup();
                                startRestartGroup.startReplaceableGroup(-142660079);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(animateValue)P(3,2)1082@42932L32,1083@42987L31,1084@43043L23,1086@43079L89:Transition.kt#pdpnli");
                                int i1122 = ((((i1022 << 3) & 57344) | 3136) >> 9) & 112;
                                composer2 = startRestartGroup;
                                State createTransitionAnimation522 = TransitionKt.createTransitionAnimation(updateTransition, function3.invoke(updateTransition.getCurrentState(), startRestartGroup, Integer.valueOf(i1122)), function3.invoke(updateTransition.getTargetState(), startRestartGroup, Integer.valueOf(i1122)), textFieldTransitionScope$Transition$labelContentColor$222.invoke((TextFieldTransitionScope$Transition$labelContentColor$2) updateTransition.getSegment(), (Transition.Segment) startRestartGroup, (Composer) 0), (TwoWayConverter) rememberedValue2, "LabelContentColor", composer2, 229376);
                                composer2.endReplaceableGroup();
                                composer2.endReplaceableGroup();
                                function72.invoke(Float.valueOf(Transition_DTcfvLk$lambda$1(createTransitionAnimation)), Color.m4053boximpl(Transition_DTcfvLk$lambda$7(createTransitionAnimation422)), Color.m4053boximpl(Transition_DTcfvLk$lambda$8(createTransitionAnimation522)), Float.valueOf(Transition_DTcfvLk$lambda$3(createTransitionAnimation22)), Float.valueOf(Transition_DTcfvLk$lambda$5(createTransitionAnimation322)), composer2, Integer.valueOf(458752 & i2));
                                if (ComposerKt.isTraceInProgress()) {
                                }
                            }
                            f4 = 1.0f;
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            startRestartGroup.endReplaceableGroup();
                            Float valueOf22 = Float.valueOf(f4);
                            InputPhase inputPhase62 = (InputPhase) updateTransition.getTargetState();
                            startRestartGroup.startReplaceableGroup(2067512179);
                            ComposerKt.sourceInformation(startRestartGroup, "C:TextFieldImpl.kt#uh7d8r");
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            i6 = WhenMappings.$EnumSwitchMapping$0[inputPhase62.ordinal()];
                            if (i6 != 1) {
                            }
                            f6 = 1.0f;
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            startRestartGroup.endReplaceableGroup();
                            State createTransitionAnimation222 = TransitionKt.createTransitionAnimation(updateTransition, f5, Float.valueOf(f6), textFieldTransitionScope$Transition$placeholderOpacity$2.invoke((TextFieldTransitionScope$Transition$placeholderOpacity$2) updateTransition.getSegment(), (Transition.Segment) startRestartGroup, (Composer) 0), vectorConverter2, "PlaceholderOpacity", startRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
                            startRestartGroup.endReplaceableGroup();
                            startRestartGroup.endReplaceableGroup();
                            TextFieldTransitionScope$Transition$prefixSuffixOpacity$2 textFieldTransitionScope$Transition$prefixSuffixOpacity$222 = new Function3<Transition.Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.material3.TextFieldTransitionScope$Transition$prefixSuffixOpacity$2
                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ FiniteAnimationSpec<Float> invoke(Transition.Segment<InputPhase> segment, Composer composer3, Integer num) {
                                    return invoke(segment, composer3, num.intValue());
                                }

                                public final FiniteAnimationSpec<Float> invoke(Transition.Segment<InputPhase> segment, Composer composer3, int i103) {
                                    composer3.startReplaceableGroup(1189967029);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1189967029, i103, -1, "androidx.compose.material3.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:356)");
                                    }
                                    TweenSpec tween$default = AnimationSpecKt.tween$default(150, 0, null, 6, null);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    composer3.endReplaceableGroup();
                                    return tween$default;
                                }
                            };
                            startRestartGroup.startReplaceableGroup(-1338768149);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(animateFloat)P(2)1165@46369L78:Transition.kt#pdpnli");
                            TwoWayConverter<Float, AnimationVector1D> vectorConverter322 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
                            startRestartGroup.startReplaceableGroup(-142660079);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(animateValue)P(3,2)1082@42932L32,1083@42987L31,1084@43043L23,1086@43079L89:Transition.kt#pdpnli");
                            InputPhase inputPhase722 = (InputPhase) updateTransition.getCurrentState();
                            startRestartGroup.startReplaceableGroup(5829913);
                            ComposerKt.sourceInformation(startRestartGroup, "C:TextFieldImpl.kt#uh7d8r");
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            i7 = WhenMappings.$EnumSwitchMapping$0[inputPhase722.ordinal()];
                            if (i7 != 1) {
                            }
                            f7 = 1.0f;
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            startRestartGroup.endReplaceableGroup();
                            Float valueOf3222 = Float.valueOf(f7);
                            InputPhase inputPhase8222 = (InputPhase) updateTransition.getTargetState();
                            startRestartGroup.startReplaceableGroup(5829913);
                            ComposerKt.sourceInformation(startRestartGroup, "C:TextFieldImpl.kt#uh7d8r");
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            i8 = WhenMappings.$EnumSwitchMapping$0[inputPhase8222.ordinal()];
                            if (i8 != 1) {
                            }
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            startRestartGroup.endReplaceableGroup();
                            State createTransitionAnimation3222 = TransitionKt.createTransitionAnimation(updateTransition, valueOf3222, Float.valueOf(f8), textFieldTransitionScope$Transition$prefixSuffixOpacity$222.invoke((TextFieldTransitionScope$Transition$prefixSuffixOpacity$2) updateTransition.getSegment(), (Transition.Segment) startRestartGroup, (Composer) 0), vectorConverter322, "PrefixSuffixOpacity", startRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
                            startRestartGroup.endReplaceableGroup();
                            startRestartGroup.endReplaceableGroup();
                            TextFieldTransitionScope$Transition$labelTextStyleColor$2 textFieldTransitionScope$Transition$labelTextStyleColor$2222 = new Function3<Transition.Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Color>>() { // from class: androidx.compose.material3.TextFieldTransitionScope$Transition$labelTextStyleColor$2
                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> segment, Composer composer3, Integer num) {
                                    return invoke(segment, composer3, num.intValue());
                                }

                                public final FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> segment, Composer composer3, int i10222) {
                                    composer3.startReplaceableGroup(2041936647);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(2041936647, i10222, -1, "androidx.compose.material3.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:366)");
                                    }
                                    TweenSpec tween$default = AnimationSpecKt.tween$default(150, 0, null, 6, null);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    composer3.endReplaceableGroup();
                                    return tween$default;
                                }
                            };
                            startRestartGroup.startReplaceableGroup(-1939694975);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(animateColor)P(2)68@3220L31,69@3287L70,73@3370L70:Transition.kt#xbi5r1");
                            InputPhase inputPhase9222 = (InputPhase) updateTransition.getTargetState();
                            startRestartGroup.startReplaceableGroup(-1468066062);
                            ComposerKt.sourceInformation(startRestartGroup, "C:TextFieldImpl.kt#uh7d8r");
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            if (WhenMappings.$EnumSwitchMapping$0[inputPhase9222.ordinal()] != 1) {
                            }
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            startRestartGroup.endReplaceableGroup();
                            ColorSpace m4067getColorSpaceimpl322 = Color.m4067getColorSpaceimpl(j3);
                            startRestartGroup.startReplaceableGroup(1157296644);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1):Composables.kt#9igjgp");
                            changed = startRestartGroup.changed(m4067getColorSpaceimpl322);
                            rememberedValue = startRestartGroup.rememberedValue();
                            if (!changed) {
                            }
                            rememberedValue = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.INSTANCE).invoke(m4067getColorSpaceimpl322);
                            startRestartGroup.updateRememberedValue(rememberedValue);
                            startRestartGroup.endReplaceableGroup();
                            TwoWayConverter twoWayConverter222 = (TwoWayConverter) rememberedValue;
                            startRestartGroup.startReplaceableGroup(-142660079);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(animateValue)P(3,2)1082@42932L32,1083@42987L31,1084@43043L23,1086@43079L89:Transition.kt#pdpnli");
                            InputPhase inputPhase10222 = (InputPhase) updateTransition.getCurrentState();
                            startRestartGroup.startReplaceableGroup(-1468066062);
                            ComposerKt.sourceInformation(startRestartGroup, "C:TextFieldImpl.kt#uh7d8r");
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            if (WhenMappings.$EnumSwitchMapping$0[inputPhase10222.ordinal()] != 1) {
                            }
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            startRestartGroup.endReplaceableGroup();
                            Color m4053boximpl222 = Color.m4053boximpl(j4);
                            InputPhase inputPhase11222 = (InputPhase) updateTransition.getTargetState();
                            startRestartGroup.startReplaceableGroup(-1468066062);
                            ComposerKt.sourceInformation(startRestartGroup, "C:TextFieldImpl.kt#uh7d8r");
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            if (WhenMappings.$EnumSwitchMapping$0[inputPhase11222.ordinal()] != 1) {
                            }
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            startRestartGroup.endReplaceableGroup();
                            State createTransitionAnimation4222 = TransitionKt.createTransitionAnimation(updateTransition, m4053boximpl222, Color.m4053boximpl(j5), textFieldTransitionScope$Transition$labelTextStyleColor$2222.invoke((TextFieldTransitionScope$Transition$labelTextStyleColor$2) updateTransition.getSegment(), (Transition.Segment) startRestartGroup, (Composer) 0), twoWayConverter222, "LabelTextStyleColor", startRestartGroup, 229376);
                            startRestartGroup.endReplaceableGroup();
                            startRestartGroup.endReplaceableGroup();
                            TextFieldTransitionScope$Transition$labelContentColor$2 textFieldTransitionScope$Transition$labelContentColor$2222 = new Function3<Transition.Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Color>>() { // from class: androidx.compose.material3.TextFieldTransitionScope$Transition$labelContentColor$2
                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> segment, Composer composer3, Integer num) {
                                    return invoke(segment, composer3, num.intValue());
                                }

                                public final FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> segment, Composer composer3, int i10222) {
                                    composer3.startReplaceableGroup(766065458);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(766065458, i10222, -1, "androidx.compose.material3.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:376)");
                                    }
                                    TweenSpec tween$default = AnimationSpecKt.tween$default(150, 0, null, 6, null);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    composer3.endReplaceableGroup();
                                    return tween$default;
                                }
                            };
                            int i10222 = (i2 & 7168) | 384;
                            startRestartGroup.startReplaceableGroup(-1939694975);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(animateColor)P(2)68@3220L31,69@3287L70,73@3370L70:Transition.kt#xbi5r1");
                            ColorSpace m4067getColorSpaceimpl2222 = Color.m4067getColorSpaceimpl(function3.invoke(updateTransition.getTargetState(), startRestartGroup, Integer.valueOf((i10222 >> 6) & 112)).m4073unboximpl());
                            startRestartGroup.startReplaceableGroup(1157296644);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1):Composables.kt#9igjgp");
                            changed2 = startRestartGroup.changed(m4067getColorSpaceimpl2222);
                            rememberedValue2 = startRestartGroup.rememberedValue();
                            if (!changed2) {
                            }
                            rememberedValue2 = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.INSTANCE).invoke(m4067getColorSpaceimpl2222);
                            startRestartGroup.updateRememberedValue(rememberedValue2);
                            startRestartGroup.endReplaceableGroup();
                            startRestartGroup.startReplaceableGroup(-142660079);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(animateValue)P(3,2)1082@42932L32,1083@42987L31,1084@43043L23,1086@43079L89:Transition.kt#pdpnli");
                            int i11222 = ((((i10222 << 3) & 57344) | 3136) >> 9) & 112;
                            composer2 = startRestartGroup;
                            State createTransitionAnimation5222 = TransitionKt.createTransitionAnimation(updateTransition, function3.invoke(updateTransition.getCurrentState(), startRestartGroup, Integer.valueOf(i11222)), function3.invoke(updateTransition.getTargetState(), startRestartGroup, Integer.valueOf(i11222)), textFieldTransitionScope$Transition$labelContentColor$2222.invoke((TextFieldTransitionScope$Transition$labelContentColor$2) updateTransition.getSegment(), (Transition.Segment) startRestartGroup, (Composer) 0), (TwoWayConverter) rememberedValue2, "LabelContentColor", composer2, 229376);
                            composer2.endReplaceableGroup();
                            composer2.endReplaceableGroup();
                            function72.invoke(Float.valueOf(Transition_DTcfvLk$lambda$1(createTransitionAnimation)), Color.m4053boximpl(Transition_DTcfvLk$lambda$7(createTransitionAnimation4222)), Color.m4053boximpl(Transition_DTcfvLk$lambda$8(createTransitionAnimation5222)), Float.valueOf(Transition_DTcfvLk$lambda$3(createTransitionAnimation222)), Float.valueOf(Transition_DTcfvLk$lambda$5(createTransitionAnimation3222)), composer2, Integer.valueOf(458752 & i2));
                            if (ComposerKt.isTraceInProgress()) {
                            }
                        } else if (i4 != 3) {
                            throw new NoWhenBranchMatchedException();
                        }
                    }
                    f3 = 1.0f;
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    startRestartGroup.endReplaceableGroup();
                    State createTransitionAnimation6 = TransitionKt.createTransitionAnimation(updateTransition, f2, Float.valueOf(f3), textFieldTransitionScope$Transition$labelProgress$2.invoke((TextFieldTransitionScope$Transition$labelProgress$2) updateTransition.getSegment(), (Transition.Segment) startRestartGroup, (Composer) 0), vectorConverter, "LabelProgress", startRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endReplaceableGroup();
                    TextFieldTransitionScope$Transition$placeholderOpacity$2 textFieldTransitionScope$Transition$placeholderOpacity$22 = new Function3<Transition.Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.material3.TextFieldTransitionScope$Transition$placeholderOpacity$2
                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ FiniteAnimationSpec<Float> invoke(Transition.Segment<InputPhase> segment, Composer composer3, Integer num) {
                            return invoke(segment, composer3, num.intValue());
                        }

                        public final FiniteAnimationSpec<Float> invoke(Transition.Segment<InputPhase> segment, Composer composer3, int i103) {
                            TweenSpec tween;
                            composer3.startReplaceableGroup(-1635067817);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1635067817, i103, -1, "androidx.compose.material3.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:329)");
                            }
                            if (segment.isTransitioningTo(InputPhase.Focused, InputPhase.UnfocusedEmpty)) {
                                tween = AnimationSpecKt.tween$default(67, 0, EasingKt.getLinearEasing(), 2, null);
                            } else if (segment.isTransitioningTo(InputPhase.UnfocusedEmpty, InputPhase.Focused) || segment.isTransitioningTo(InputPhase.UnfocusedNotEmpty, InputPhase.UnfocusedEmpty)) {
                                tween = AnimationSpecKt.tween(83, 67, EasingKt.getLinearEasing());
                            } else {
                                tween = AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer3.endReplaceableGroup();
                            return tween;
                        }
                    };
                    startRestartGroup.startReplaceableGroup(-1338768149);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(animateFloat)P(2)1165@46369L78:Transition.kt#pdpnli");
                    TwoWayConverter<Float, AnimationVector1D> vectorConverter22 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
                    startRestartGroup.startReplaceableGroup(-142660079);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(animateValue)P(3,2)1082@42932L32,1083@42987L31,1084@43043L23,1086@43079L89:Transition.kt#pdpnli");
                    InputPhase inputPhase52 = (InputPhase) updateTransition.getCurrentState();
                    startRestartGroup.startReplaceableGroup(2067512179);
                    ComposerKt.sourceInformation(startRestartGroup, "C:TextFieldImpl.kt#uh7d8r");
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    i5 = WhenMappings.$EnumSwitchMapping$0[inputPhase52.ordinal()];
                    if (i5 != 1) {
                    }
                    f4 = 1.0f;
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    startRestartGroup.endReplaceableGroup();
                    Float valueOf222 = Float.valueOf(f4);
                    InputPhase inputPhase622 = (InputPhase) updateTransition.getTargetState();
                    startRestartGroup.startReplaceableGroup(2067512179);
                    ComposerKt.sourceInformation(startRestartGroup, "C:TextFieldImpl.kt#uh7d8r");
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    i6 = WhenMappings.$EnumSwitchMapping$0[inputPhase622.ordinal()];
                    if (i6 != 1) {
                    }
                    f6 = 1.0f;
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    startRestartGroup.endReplaceableGroup();
                    State createTransitionAnimation2222 = TransitionKt.createTransitionAnimation(updateTransition, f5, Float.valueOf(f6), textFieldTransitionScope$Transition$placeholderOpacity$22.invoke((TextFieldTransitionScope$Transition$placeholderOpacity$2) updateTransition.getSegment(), (Transition.Segment) startRestartGroup, (Composer) 0), vectorConverter22, "PlaceholderOpacity", startRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endReplaceableGroup();
                    TextFieldTransitionScope$Transition$prefixSuffixOpacity$2 textFieldTransitionScope$Transition$prefixSuffixOpacity$2222 = new Function3<Transition.Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.material3.TextFieldTransitionScope$Transition$prefixSuffixOpacity$2
                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ FiniteAnimationSpec<Float> invoke(Transition.Segment<InputPhase> segment, Composer composer3, Integer num) {
                            return invoke(segment, composer3, num.intValue());
                        }

                        public final FiniteAnimationSpec<Float> invoke(Transition.Segment<InputPhase> segment, Composer composer3, int i103) {
                            composer3.startReplaceableGroup(1189967029);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1189967029, i103, -1, "androidx.compose.material3.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:356)");
                            }
                            TweenSpec tween$default = AnimationSpecKt.tween$default(150, 0, null, 6, null);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer3.endReplaceableGroup();
                            return tween$default;
                        }
                    };
                    startRestartGroup.startReplaceableGroup(-1338768149);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(animateFloat)P(2)1165@46369L78:Transition.kt#pdpnli");
                    TwoWayConverter<Float, AnimationVector1D> vectorConverter3222 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
                    startRestartGroup.startReplaceableGroup(-142660079);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(animateValue)P(3,2)1082@42932L32,1083@42987L31,1084@43043L23,1086@43079L89:Transition.kt#pdpnli");
                    InputPhase inputPhase7222 = (InputPhase) updateTransition.getCurrentState();
                    startRestartGroup.startReplaceableGroup(5829913);
                    ComposerKt.sourceInformation(startRestartGroup, "C:TextFieldImpl.kt#uh7d8r");
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    i7 = WhenMappings.$EnumSwitchMapping$0[inputPhase7222.ordinal()];
                    if (i7 != 1) {
                    }
                    f7 = 1.0f;
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    startRestartGroup.endReplaceableGroup();
                    Float valueOf32222 = Float.valueOf(f7);
                    InputPhase inputPhase82222 = (InputPhase) updateTransition.getTargetState();
                    startRestartGroup.startReplaceableGroup(5829913);
                    ComposerKt.sourceInformation(startRestartGroup, "C:TextFieldImpl.kt#uh7d8r");
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    i8 = WhenMappings.$EnumSwitchMapping$0[inputPhase82222.ordinal()];
                    if (i8 != 1) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    startRestartGroup.endReplaceableGroup();
                    State createTransitionAnimation32222 = TransitionKt.createTransitionAnimation(updateTransition, valueOf32222, Float.valueOf(f8), textFieldTransitionScope$Transition$prefixSuffixOpacity$2222.invoke((TextFieldTransitionScope$Transition$prefixSuffixOpacity$2) updateTransition.getSegment(), (Transition.Segment) startRestartGroup, (Composer) 0), vectorConverter3222, "PrefixSuffixOpacity", startRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endReplaceableGroup();
                    TextFieldTransitionScope$Transition$labelTextStyleColor$2 textFieldTransitionScope$Transition$labelTextStyleColor$22222 = new Function3<Transition.Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Color>>() { // from class: androidx.compose.material3.TextFieldTransitionScope$Transition$labelTextStyleColor$2
                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> segment, Composer composer3, Integer num) {
                            return invoke(segment, composer3, num.intValue());
                        }

                        public final FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> segment, Composer composer3, int i102222) {
                            composer3.startReplaceableGroup(2041936647);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(2041936647, i102222, -1, "androidx.compose.material3.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:366)");
                            }
                            TweenSpec tween$default = AnimationSpecKt.tween$default(150, 0, null, 6, null);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer3.endReplaceableGroup();
                            return tween$default;
                        }
                    };
                    startRestartGroup.startReplaceableGroup(-1939694975);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(animateColor)P(2)68@3220L31,69@3287L70,73@3370L70:Transition.kt#xbi5r1");
                    InputPhase inputPhase92222 = (InputPhase) updateTransition.getTargetState();
                    startRestartGroup.startReplaceableGroup(-1468066062);
                    ComposerKt.sourceInformation(startRestartGroup, "C:TextFieldImpl.kt#uh7d8r");
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    if (WhenMappings.$EnumSwitchMapping$0[inputPhase92222.ordinal()] != 1) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    startRestartGroup.endReplaceableGroup();
                    ColorSpace m4067getColorSpaceimpl3222 = Color.m4067getColorSpaceimpl(j3);
                    startRestartGroup.startReplaceableGroup(1157296644);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1):Composables.kt#9igjgp");
                    changed = startRestartGroup.changed(m4067getColorSpaceimpl3222);
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (!changed) {
                    }
                    rememberedValue = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.INSTANCE).invoke(m4067getColorSpaceimpl3222);
                    startRestartGroup.updateRememberedValue(rememberedValue);
                    startRestartGroup.endReplaceableGroup();
                    TwoWayConverter twoWayConverter2222 = (TwoWayConverter) rememberedValue;
                    startRestartGroup.startReplaceableGroup(-142660079);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(animateValue)P(3,2)1082@42932L32,1083@42987L31,1084@43043L23,1086@43079L89:Transition.kt#pdpnli");
                    InputPhase inputPhase102222 = (InputPhase) updateTransition.getCurrentState();
                    startRestartGroup.startReplaceableGroup(-1468066062);
                    ComposerKt.sourceInformation(startRestartGroup, "C:TextFieldImpl.kt#uh7d8r");
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    if (WhenMappings.$EnumSwitchMapping$0[inputPhase102222.ordinal()] != 1) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    startRestartGroup.endReplaceableGroup();
                    Color m4053boximpl2222 = Color.m4053boximpl(j4);
                    InputPhase inputPhase112222 = (InputPhase) updateTransition.getTargetState();
                    startRestartGroup.startReplaceableGroup(-1468066062);
                    ComposerKt.sourceInformation(startRestartGroup, "C:TextFieldImpl.kt#uh7d8r");
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    if (WhenMappings.$EnumSwitchMapping$0[inputPhase112222.ordinal()] != 1) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    startRestartGroup.endReplaceableGroup();
                    State createTransitionAnimation42222 = TransitionKt.createTransitionAnimation(updateTransition, m4053boximpl2222, Color.m4053boximpl(j5), textFieldTransitionScope$Transition$labelTextStyleColor$22222.invoke((TextFieldTransitionScope$Transition$labelTextStyleColor$2) updateTransition.getSegment(), (Transition.Segment) startRestartGroup, (Composer) 0), twoWayConverter2222, "LabelTextStyleColor", startRestartGroup, 229376);
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endReplaceableGroup();
                    TextFieldTransitionScope$Transition$labelContentColor$2 textFieldTransitionScope$Transition$labelContentColor$22222 = new Function3<Transition.Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Color>>() { // from class: androidx.compose.material3.TextFieldTransitionScope$Transition$labelContentColor$2
                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> segment, Composer composer3, Integer num) {
                            return invoke(segment, composer3, num.intValue());
                        }

                        public final FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> segment, Composer composer3, int i102222) {
                            composer3.startReplaceableGroup(766065458);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(766065458, i102222, -1, "androidx.compose.material3.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:376)");
                            }
                            TweenSpec tween$default = AnimationSpecKt.tween$default(150, 0, null, 6, null);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer3.endReplaceableGroup();
                            return tween$default;
                        }
                    };
                    int i102222 = (i2 & 7168) | 384;
                    startRestartGroup.startReplaceableGroup(-1939694975);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(animateColor)P(2)68@3220L31,69@3287L70,73@3370L70:Transition.kt#xbi5r1");
                    ColorSpace m4067getColorSpaceimpl22222 = Color.m4067getColorSpaceimpl(function3.invoke(updateTransition.getTargetState(), startRestartGroup, Integer.valueOf((i102222 >> 6) & 112)).m4073unboximpl());
                    startRestartGroup.startReplaceableGroup(1157296644);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1):Composables.kt#9igjgp");
                    changed2 = startRestartGroup.changed(m4067getColorSpaceimpl22222);
                    rememberedValue2 = startRestartGroup.rememberedValue();
                    if (!changed2) {
                    }
                    rememberedValue2 = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.INSTANCE).invoke(m4067getColorSpaceimpl22222);
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.startReplaceableGroup(-142660079);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(animateValue)P(3,2)1082@42932L32,1083@42987L31,1084@43043L23,1086@43079L89:Transition.kt#pdpnli");
                    int i112222 = ((((i102222 << 3) & 57344) | 3136) >> 9) & 112;
                    composer2 = startRestartGroup;
                    State createTransitionAnimation52222 = TransitionKt.createTransitionAnimation(updateTransition, function3.invoke(updateTransition.getCurrentState(), startRestartGroup, Integer.valueOf(i112222)), function3.invoke(updateTransition.getTargetState(), startRestartGroup, Integer.valueOf(i112222)), textFieldTransitionScope$Transition$labelContentColor$22222.invoke((TextFieldTransitionScope$Transition$labelContentColor$2) updateTransition.getSegment(), (Transition.Segment) startRestartGroup, (Composer) 0), (TwoWayConverter) rememberedValue2, "LabelContentColor", composer2, 229376);
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    function72.invoke(Float.valueOf(Transition_DTcfvLk$lambda$1(createTransitionAnimation6)), Color.m4053boximpl(Transition_DTcfvLk$lambda$7(createTransitionAnimation42222)), Color.m4053boximpl(Transition_DTcfvLk$lambda$8(createTransitionAnimation52222)), Float.valueOf(Transition_DTcfvLk$lambda$3(createTransitionAnimation2222)), Float.valueOf(Transition_DTcfvLk$lambda$5(createTransitionAnimation32222)), composer2, Integer.valueOf(458752 & i2));
                    if (ComposerKt.isTraceInProgress()) {
                    }
                } else if (i9 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
            }
            f = 1.0f;
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.endReplaceableGroup();
            Float valueOf4 = Float.valueOf(f);
            InputPhase inputPhase42 = (InputPhase) updateTransition.getTargetState();
            startRestartGroup.startReplaceableGroup(240378898);
            ComposerKt.sourceInformation(startRestartGroup, "C:TextFieldImpl.kt#uh7d8r");
            if (ComposerKt.isTraceInProgress()) {
            }
            i4 = WhenMappings.$EnumSwitchMapping$0[inputPhase2.ordinal()];
            if (i4 != 1) {
            }
            f3 = 1.0f;
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.endReplaceableGroup();
            State createTransitionAnimation62 = TransitionKt.createTransitionAnimation(updateTransition, f2, Float.valueOf(f3), textFieldTransitionScope$Transition$labelProgress$2.invoke((TextFieldTransitionScope$Transition$labelProgress$2) updateTransition.getSegment(), (Transition.Segment) startRestartGroup, (Composer) 0), vectorConverter, "LabelProgress", startRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            TextFieldTransitionScope$Transition$placeholderOpacity$2 textFieldTransitionScope$Transition$placeholderOpacity$222 = new Function3<Transition.Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.material3.TextFieldTransitionScope$Transition$placeholderOpacity$2
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ FiniteAnimationSpec<Float> invoke(Transition.Segment<InputPhase> segment, Composer composer3, Integer num) {
                    return invoke(segment, composer3, num.intValue());
                }

                public final FiniteAnimationSpec<Float> invoke(Transition.Segment<InputPhase> segment, Composer composer3, int i103) {
                    TweenSpec tween;
                    composer3.startReplaceableGroup(-1635067817);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1635067817, i103, -1, "androidx.compose.material3.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:329)");
                    }
                    if (segment.isTransitioningTo(InputPhase.Focused, InputPhase.UnfocusedEmpty)) {
                        tween = AnimationSpecKt.tween$default(67, 0, EasingKt.getLinearEasing(), 2, null);
                    } else if (segment.isTransitioningTo(InputPhase.UnfocusedEmpty, InputPhase.Focused) || segment.isTransitioningTo(InputPhase.UnfocusedNotEmpty, InputPhase.UnfocusedEmpty)) {
                        tween = AnimationSpecKt.tween(83, 67, EasingKt.getLinearEasing());
                    } else {
                        tween = AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer3.endReplaceableGroup();
                    return tween;
                }
            };
            startRestartGroup.startReplaceableGroup(-1338768149);
            ComposerKt.sourceInformation(startRestartGroup, "CC(animateFloat)P(2)1165@46369L78:Transition.kt#pdpnli");
            TwoWayConverter<Float, AnimationVector1D> vectorConverter222 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
            startRestartGroup.startReplaceableGroup(-142660079);
            ComposerKt.sourceInformation(startRestartGroup, "CC(animateValue)P(3,2)1082@42932L32,1083@42987L31,1084@43043L23,1086@43079L89:Transition.kt#pdpnli");
            InputPhase inputPhase522 = (InputPhase) updateTransition.getCurrentState();
            startRestartGroup.startReplaceableGroup(2067512179);
            ComposerKt.sourceInformation(startRestartGroup, "C:TextFieldImpl.kt#uh7d8r");
            if (ComposerKt.isTraceInProgress()) {
            }
            i5 = WhenMappings.$EnumSwitchMapping$0[inputPhase522.ordinal()];
            if (i5 != 1) {
            }
            f4 = 1.0f;
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.endReplaceableGroup();
            Float valueOf2222 = Float.valueOf(f4);
            InputPhase inputPhase6222 = (InputPhase) updateTransition.getTargetState();
            startRestartGroup.startReplaceableGroup(2067512179);
            ComposerKt.sourceInformation(startRestartGroup, "C:TextFieldImpl.kt#uh7d8r");
            if (ComposerKt.isTraceInProgress()) {
            }
            i6 = WhenMappings.$EnumSwitchMapping$0[inputPhase6222.ordinal()];
            if (i6 != 1) {
            }
            f6 = 1.0f;
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.endReplaceableGroup();
            State createTransitionAnimation22222 = TransitionKt.createTransitionAnimation(updateTransition, f5, Float.valueOf(f6), textFieldTransitionScope$Transition$placeholderOpacity$222.invoke((TextFieldTransitionScope$Transition$placeholderOpacity$2) updateTransition.getSegment(), (Transition.Segment) startRestartGroup, (Composer) 0), vectorConverter222, "PlaceholderOpacity", startRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            TextFieldTransitionScope$Transition$prefixSuffixOpacity$2 textFieldTransitionScope$Transition$prefixSuffixOpacity$22222 = new Function3<Transition.Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.material3.TextFieldTransitionScope$Transition$prefixSuffixOpacity$2
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ FiniteAnimationSpec<Float> invoke(Transition.Segment<InputPhase> segment, Composer composer3, Integer num) {
                    return invoke(segment, composer3, num.intValue());
                }

                public final FiniteAnimationSpec<Float> invoke(Transition.Segment<InputPhase> segment, Composer composer3, int i103) {
                    composer3.startReplaceableGroup(1189967029);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1189967029, i103, -1, "androidx.compose.material3.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:356)");
                    }
                    TweenSpec tween$default = AnimationSpecKt.tween$default(150, 0, null, 6, null);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer3.endReplaceableGroup();
                    return tween$default;
                }
            };
            startRestartGroup.startReplaceableGroup(-1338768149);
            ComposerKt.sourceInformation(startRestartGroup, "CC(animateFloat)P(2)1165@46369L78:Transition.kt#pdpnli");
            TwoWayConverter<Float, AnimationVector1D> vectorConverter32222 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
            startRestartGroup.startReplaceableGroup(-142660079);
            ComposerKt.sourceInformation(startRestartGroup, "CC(animateValue)P(3,2)1082@42932L32,1083@42987L31,1084@43043L23,1086@43079L89:Transition.kt#pdpnli");
            InputPhase inputPhase72222 = (InputPhase) updateTransition.getCurrentState();
            startRestartGroup.startReplaceableGroup(5829913);
            ComposerKt.sourceInformation(startRestartGroup, "C:TextFieldImpl.kt#uh7d8r");
            if (ComposerKt.isTraceInProgress()) {
            }
            i7 = WhenMappings.$EnumSwitchMapping$0[inputPhase72222.ordinal()];
            if (i7 != 1) {
            }
            f7 = 1.0f;
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.endReplaceableGroup();
            Float valueOf322222 = Float.valueOf(f7);
            InputPhase inputPhase822222 = (InputPhase) updateTransition.getTargetState();
            startRestartGroup.startReplaceableGroup(5829913);
            ComposerKt.sourceInformation(startRestartGroup, "C:TextFieldImpl.kt#uh7d8r");
            if (ComposerKt.isTraceInProgress()) {
            }
            i8 = WhenMappings.$EnumSwitchMapping$0[inputPhase822222.ordinal()];
            if (i8 != 1) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.endReplaceableGroup();
            State createTransitionAnimation322222 = TransitionKt.createTransitionAnimation(updateTransition, valueOf322222, Float.valueOf(f8), textFieldTransitionScope$Transition$prefixSuffixOpacity$22222.invoke((TextFieldTransitionScope$Transition$prefixSuffixOpacity$2) updateTransition.getSegment(), (Transition.Segment) startRestartGroup, (Composer) 0), vectorConverter32222, "PrefixSuffixOpacity", startRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            TextFieldTransitionScope$Transition$labelTextStyleColor$2 textFieldTransitionScope$Transition$labelTextStyleColor$222222 = new Function3<Transition.Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Color>>() { // from class: androidx.compose.material3.TextFieldTransitionScope$Transition$labelTextStyleColor$2
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> segment, Composer composer3, Integer num) {
                    return invoke(segment, composer3, num.intValue());
                }

                public final FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> segment, Composer composer3, int i1022222) {
                    composer3.startReplaceableGroup(2041936647);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2041936647, i1022222, -1, "androidx.compose.material3.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:366)");
                    }
                    TweenSpec tween$default = AnimationSpecKt.tween$default(150, 0, null, 6, null);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer3.endReplaceableGroup();
                    return tween$default;
                }
            };
            startRestartGroup.startReplaceableGroup(-1939694975);
            ComposerKt.sourceInformation(startRestartGroup, "CC(animateColor)P(2)68@3220L31,69@3287L70,73@3370L70:Transition.kt#xbi5r1");
            InputPhase inputPhase922222 = (InputPhase) updateTransition.getTargetState();
            startRestartGroup.startReplaceableGroup(-1468066062);
            ComposerKt.sourceInformation(startRestartGroup, "C:TextFieldImpl.kt#uh7d8r");
            if (ComposerKt.isTraceInProgress()) {
            }
            if (WhenMappings.$EnumSwitchMapping$0[inputPhase922222.ordinal()] != 1) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.endReplaceableGroup();
            ColorSpace m4067getColorSpaceimpl32222 = Color.m4067getColorSpaceimpl(j3);
            startRestartGroup.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1):Composables.kt#9igjgp");
            changed = startRestartGroup.changed(m4067getColorSpaceimpl32222);
            rememberedValue = startRestartGroup.rememberedValue();
            if (!changed) {
            }
            rememberedValue = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.INSTANCE).invoke(m4067getColorSpaceimpl32222);
            startRestartGroup.updateRememberedValue(rememberedValue);
            startRestartGroup.endReplaceableGroup();
            TwoWayConverter twoWayConverter22222 = (TwoWayConverter) rememberedValue;
            startRestartGroup.startReplaceableGroup(-142660079);
            ComposerKt.sourceInformation(startRestartGroup, "CC(animateValue)P(3,2)1082@42932L32,1083@42987L31,1084@43043L23,1086@43079L89:Transition.kt#pdpnli");
            InputPhase inputPhase1022222 = (InputPhase) updateTransition.getCurrentState();
            startRestartGroup.startReplaceableGroup(-1468066062);
            ComposerKt.sourceInformation(startRestartGroup, "C:TextFieldImpl.kt#uh7d8r");
            if (ComposerKt.isTraceInProgress()) {
            }
            if (WhenMappings.$EnumSwitchMapping$0[inputPhase1022222.ordinal()] != 1) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.endReplaceableGroup();
            Color m4053boximpl22222 = Color.m4053boximpl(j4);
            InputPhase inputPhase1122222 = (InputPhase) updateTransition.getTargetState();
            startRestartGroup.startReplaceableGroup(-1468066062);
            ComposerKt.sourceInformation(startRestartGroup, "C:TextFieldImpl.kt#uh7d8r");
            if (ComposerKt.isTraceInProgress()) {
            }
            if (WhenMappings.$EnumSwitchMapping$0[inputPhase1122222.ordinal()] != 1) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.endReplaceableGroup();
            State createTransitionAnimation422222 = TransitionKt.createTransitionAnimation(updateTransition, m4053boximpl22222, Color.m4053boximpl(j5), textFieldTransitionScope$Transition$labelTextStyleColor$222222.invoke((TextFieldTransitionScope$Transition$labelTextStyleColor$2) updateTransition.getSegment(), (Transition.Segment) startRestartGroup, (Composer) 0), twoWayConverter22222, "LabelTextStyleColor", startRestartGroup, 229376);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            TextFieldTransitionScope$Transition$labelContentColor$2 textFieldTransitionScope$Transition$labelContentColor$222222 = new Function3<Transition.Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Color>>() { // from class: androidx.compose.material3.TextFieldTransitionScope$Transition$labelContentColor$2
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> segment, Composer composer3, Integer num) {
                    return invoke(segment, composer3, num.intValue());
                }

                public final FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> segment, Composer composer3, int i1022222) {
                    composer3.startReplaceableGroup(766065458);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(766065458, i1022222, -1, "androidx.compose.material3.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:376)");
                    }
                    TweenSpec tween$default = AnimationSpecKt.tween$default(150, 0, null, 6, null);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer3.endReplaceableGroup();
                    return tween$default;
                }
            };
            int i1022222 = (i2 & 7168) | 384;
            startRestartGroup.startReplaceableGroup(-1939694975);
            ComposerKt.sourceInformation(startRestartGroup, "CC(animateColor)P(2)68@3220L31,69@3287L70,73@3370L70:Transition.kt#xbi5r1");
            ColorSpace m4067getColorSpaceimpl222222 = Color.m4067getColorSpaceimpl(function3.invoke(updateTransition.getTargetState(), startRestartGroup, Integer.valueOf((i1022222 >> 6) & 112)).m4073unboximpl());
            startRestartGroup.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1):Composables.kt#9igjgp");
            changed2 = startRestartGroup.changed(m4067getColorSpaceimpl222222);
            rememberedValue2 = startRestartGroup.rememberedValue();
            if (!changed2) {
            }
            rememberedValue2 = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.INSTANCE).invoke(m4067getColorSpaceimpl222222);
            startRestartGroup.updateRememberedValue(rememberedValue2);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(-142660079);
            ComposerKt.sourceInformation(startRestartGroup, "CC(animateValue)P(3,2)1082@42932L32,1083@42987L31,1084@43043L23,1086@43079L89:Transition.kt#pdpnli");
            int i1122222 = ((((i1022222 << 3) & 57344) | 3136) >> 9) & 112;
            composer2 = startRestartGroup;
            State createTransitionAnimation522222 = TransitionKt.createTransitionAnimation(updateTransition, function3.invoke(updateTransition.getCurrentState(), startRestartGroup, Integer.valueOf(i1122222)), function3.invoke(updateTransition.getTargetState(), startRestartGroup, Integer.valueOf(i1122222)), textFieldTransitionScope$Transition$labelContentColor$222222.invoke((TextFieldTransitionScope$Transition$labelContentColor$2) updateTransition.getSegment(), (Transition.Segment) startRestartGroup, (Composer) 0), (TwoWayConverter) rememberedValue2, "LabelContentColor", composer2, 229376);
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            function72.invoke(Float.valueOf(Transition_DTcfvLk$lambda$1(createTransitionAnimation62)), Color.m4053boximpl(Transition_DTcfvLk$lambda$7(createTransitionAnimation422222)), Color.m4053boximpl(Transition_DTcfvLk$lambda$8(createTransitionAnimation522222)), Float.valueOf(Transition_DTcfvLk$lambda$3(createTransitionAnimation22222)), Float.valueOf(Transition_DTcfvLk$lambda$5(createTransitionAnimation322222)), composer2, Integer.valueOf(458752 & i2));
            if (ComposerKt.isTraceInProgress()) {
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldTransitionScope$Transition$1
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

                public final void invoke(Composer composer3, int i12) {
                    TextFieldTransitionScope.this.m2779TransitionDTcfvLk(inputPhase, j, j2, function3, z, function7, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    private static final float Transition_DTcfvLk$lambda$1(State<Float> state) {
        return state.getValue().floatValue();
    }

    private static final float Transition_DTcfvLk$lambda$3(State<Float> state) {
        return state.getValue().floatValue();
    }

    private static final float Transition_DTcfvLk$lambda$5(State<Float> state) {
        return state.getValue().floatValue();
    }

    private static final long Transition_DTcfvLk$lambda$7(State<Color> state) {
        return state.getValue().m4073unboximpl();
    }

    private static final long Transition_DTcfvLk$lambda$8(State<Color> state) {
        return state.getValue().m4073unboximpl();
    }
}
