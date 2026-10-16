package androidx.compose.material;

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
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.FloatCompanionObject;

/* compiled from: TextFieldImpl.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\b\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J²\u0001\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u000b¢\u0006\u0002\b\f2\u0006\u0010\r\u001a\u00020\u000e2e\u0010\u000f\u001aa\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00040\u0010¢\u0006\u0002\b\fH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001a²\u0006\n\u0010\u0014\u001a\u00020\u0011X\u008a\u0084\u0002²\u0006\n\u0010\u0017\u001a\u00020\u0011X\u008a\u0084\u0002²\u0006\n\u0010\u0015\u001a\u00020\bX\u008a\u0084\u0002²\u0006\n\u0010\u0016\u001a\u00020\bX\u008a\u0084\u0002"}, d2 = {"Landroidx/compose/material/TextFieldTransitionScope;", "", "()V", "Transition", "", "inputState", "Landroidx/compose/material/InputPhase;", "focusedTextStyleColor", "Landroidx/compose/ui/graphics/Color;", "unfocusedTextStyleColor", "contentColor", "Lkotlin/Function1;", "Landroidx/compose/runtime/Composable;", "showLabel", "", "content", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "labelProgress", "labelTextStyleColor", "labelContentColor", "placeholderOpacity", "Transition-DTcfvLk", "(Landroidx/compose/material/InputPhase;JJLkotlin/jvm/functions/Function3;ZLkotlin/jvm/functions/Function6;Landroidx/compose/runtime/Composer;I)V", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

    /* JADX WARN: Code restructure failed: missing block: B:154:0x023c, code lost:
    
        if (r32 != false) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x01f0, code lost:
    
        if (r32 != false) goto L99;
     */
    /* JADX WARN: Removed duplicated region for block: B:101:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0247  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0297  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x02a6  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x02b1  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x02d0  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0308  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0317  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0322  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x033e  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x034d  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0358  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x03c9  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0472  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0350  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x031a  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x02a9  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0217  */
    /* renamed from: Transition-DTcfvLk, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m1840TransitionDTcfvLk(final InputPhase inputPhase, final long j, final long j2, final Function3<? super InputPhase, ? super Composer, ? super Integer, Color> function3, final boolean z, final Function6<? super Float, ? super Color, ? super Color, ? super Float, ? super Composer, ? super Integer, Unit> function6, Composer composer, final int i) {
        int i2;
        float f;
        Float f2;
        InputPhase inputPhase2;
        int i3;
        int i4;
        float f3;
        int i5;
        float f4;
        State state;
        int i6;
        float f5;
        boolean changed;
        Object rememberedValue;
        boolean changed2;
        Object rememberedValue2;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(1988729962);
        ComposerKt.sourceInformation(startRestartGroup, "C(Transition)P(3,2:c#ui.graphics.Color,5:c#ui.graphics.Color,1,4)270@10987L59,272@11088L325,283@11460L1101,311@12609L299,321@12954L186,327@13150L140:TextFieldImpl.kt#jmzs0o");
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changed(inputPhase) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= startRestartGroup.changed(j) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= startRestartGroup.changed(j2) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i2 |= startRestartGroup.changedInstance(function3) ? 2048 : 1024;
        }
        if ((i & 57344) == 0) {
            i2 |= startRestartGroup.changed(z) ? 16384 : 8192;
        }
        if ((458752 & i) == 0) {
            i2 |= startRestartGroup.changedInstance(function6) ? 131072 : 65536;
        }
        if ((374491 & i2) == 74898 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1988729962, i2, -1, "androidx.compose.material.TextFieldTransitionScope.Transition (TextFieldImpl.kt:266)");
            }
            Transition updateTransition = TransitionKt.updateTransition(inputPhase, "TextFieldInputState", startRestartGroup, (i2 & 14) | 48, 0);
            TextFieldTransitionScope$Transition$labelProgress$2 textFieldTransitionScope$Transition$labelProgress$2 = new Function3<Transition.Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.material.TextFieldTransitionScope$Transition$labelProgress$2
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ FiniteAnimationSpec<Float> invoke(Transition.Segment<InputPhase> segment, Composer composer3, Integer num) {
                    return invoke(segment, composer3, num.intValue());
                }

                public final FiniteAnimationSpec<Float> invoke(Transition.Segment<InputPhase> segment, Composer composer3, int i7) {
                    composer3.startReplaceableGroup(-611722692);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-611722692, i7, -1, "androidx.compose.material.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:274)");
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
            startRestartGroup.startReplaceableGroup(-1158004136);
            ComposerKt.sourceInformation(startRestartGroup, "C:TextFieldImpl.kt#jmzs0o");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1158004136, 0, -1, "androidx.compose.material.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:276)");
            }
            int i7 = WhenMappings.$EnumSwitchMapping$0[inputPhase3.ordinal()];
            if (i7 != 1) {
                if (i7 == 2) {
                    f = 0.0f;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    startRestartGroup.endReplaceableGroup();
                    Float valueOf = Float.valueOf(f);
                    InputPhase inputPhase4 = (InputPhase) updateTransition.getTargetState();
                    startRestartGroup.startReplaceableGroup(-1158004136);
                    ComposerKt.sourceInformation(startRestartGroup, "C:TextFieldImpl.kt#jmzs0o");
                    if (ComposerKt.isTraceInProgress()) {
                        f2 = valueOf;
                        inputPhase2 = inputPhase4;
                        i3 = -1;
                    } else {
                        f2 = valueOf;
                        inputPhase2 = inputPhase4;
                        i3 = -1;
                        ComposerKt.traceEventStart(-1158004136, 0, -1, "androidx.compose.material.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:276)");
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
                            TextFieldTransitionScope$Transition$placeholderOpacity$2 textFieldTransitionScope$Transition$placeholderOpacity$2 = new Function3<Transition.Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.material.TextFieldTransitionScope$Transition$placeholderOpacity$2
                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ FiniteAnimationSpec<Float> invoke(Transition.Segment<InputPhase> segment, Composer composer3, Integer num) {
                                    return invoke(segment, composer3, num.intValue());
                                }

                                public final FiniteAnimationSpec<Float> invoke(Transition.Segment<InputPhase> segment, Composer composer3, int i8) {
                                    TweenSpec tween;
                                    composer3.startReplaceableGroup(-1079955085);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1079955085, i8, -1, "androidx.compose.material.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:286)");
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
                            startRestartGroup.startReplaceableGroup(-1376159017);
                            ComposerKt.sourceInformation(startRestartGroup, "C:TextFieldImpl.kt#jmzs0o");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1376159017, 0, i3, "androidx.compose.material.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:304)");
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
                                startRestartGroup.startReplaceableGroup(-1376159017);
                                ComposerKt.sourceInformation(startRestartGroup, "C:TextFieldImpl.kt#jmzs0o");
                                if (ComposerKt.isTraceInProgress()) {
                                    state = createTransitionAnimation;
                                } else {
                                    state = createTransitionAnimation;
                                    ComposerKt.traceEventStart(-1376159017, 0, i3, "androidx.compose.material.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:304)");
                                }
                                i6 = WhenMappings.$EnumSwitchMapping$0[inputPhase6.ordinal()];
                                if (i6 != 1) {
                                    if (i6 != 2) {
                                        if (i6 != 3) {
                                            throw new NoWhenBranchMatchedException();
                                        }
                                    }
                                    f5 = 0.0f;
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    startRestartGroup.endReplaceableGroup();
                                    State createTransitionAnimation2 = TransitionKt.createTransitionAnimation(updateTransition, valueOf2, Float.valueOf(f5), textFieldTransitionScope$Transition$placeholderOpacity$2.invoke((TextFieldTransitionScope$Transition$placeholderOpacity$2) updateTransition.getSegment(), (Transition.Segment) startRestartGroup, (Composer) 0), vectorConverter2, "PlaceholderOpacity", startRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
                                    startRestartGroup.endReplaceableGroup();
                                    startRestartGroup.endReplaceableGroup();
                                    TextFieldTransitionScope$Transition$labelTextStyleColor$2 textFieldTransitionScope$Transition$labelTextStyleColor$2 = new Function3<Transition.Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Color>>() { // from class: androidx.compose.material.TextFieldTransitionScope$Transition$labelTextStyleColor$2
                                        @Override // kotlin.jvm.functions.Function3
                                        public /* bridge */ /* synthetic */ FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> segment, Composer composer3, Integer num) {
                                            return invoke(segment, composer3, num.intValue());
                                        }

                                        public final FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> segment, Composer composer3, int i8) {
                                            composer3.startReplaceableGroup(-130058045);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-130058045, i8, -1, "androidx.compose.material.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:312)");
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
                                    InputPhase inputPhase7 = (InputPhase) updateTransition.getTargetState();
                                    startRestartGroup.startReplaceableGroup(-1490209928);
                                    ComposerKt.sourceInformation(startRestartGroup, "C:TextFieldImpl.kt#jmzs0o");
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1490209928, 0, i3, "androidx.compose.material.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:315)");
                                    }
                                    long j3 = WhenMappings.$EnumSwitchMapping$0[inputPhase7.ordinal()] == 1 ? j : j2;
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
                                    InputPhase inputPhase8 = (InputPhase) updateTransition.getCurrentState();
                                    startRestartGroup.startReplaceableGroup(-1490209928);
                                    ComposerKt.sourceInformation(startRestartGroup, "C:TextFieldImpl.kt#jmzs0o");
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1490209928, 0, i3, "androidx.compose.material.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:315)");
                                    }
                                    long j4 = WhenMappings.$EnumSwitchMapping$0[inputPhase8.ordinal()] == 1 ? j : j2;
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    startRestartGroup.endReplaceableGroup();
                                    Color m4053boximpl = Color.m4053boximpl(j4);
                                    InputPhase inputPhase9 = (InputPhase) updateTransition.getTargetState();
                                    startRestartGroup.startReplaceableGroup(-1490209928);
                                    ComposerKt.sourceInformation(startRestartGroup, "C:TextFieldImpl.kt#jmzs0o");
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1490209928, 0, i3, "androidx.compose.material.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:315)");
                                    }
                                    long j5 = WhenMappings.$EnumSwitchMapping$0[inputPhase9.ordinal()] == 1 ? j : j2;
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    startRestartGroup.endReplaceableGroup();
                                    State createTransitionAnimation3 = TransitionKt.createTransitionAnimation(updateTransition, m4053boximpl, Color.m4053boximpl(j5), textFieldTransitionScope$Transition$labelTextStyleColor$2.invoke((TextFieldTransitionScope$Transition$labelTextStyleColor$2) updateTransition.getSegment(), (Transition.Segment) startRestartGroup, (Composer) 0), twoWayConverter, "LabelTextStyleColor", startRestartGroup, 229376);
                                    startRestartGroup.endReplaceableGroup();
                                    startRestartGroup.endReplaceableGroup();
                                    TextFieldTransitionScope$Transition$labelContentColor$2 textFieldTransitionScope$Transition$labelContentColor$2 = new Function3<Transition.Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Color>>() { // from class: androidx.compose.material.TextFieldTransitionScope$Transition$labelContentColor$2
                                        @Override // kotlin.jvm.functions.Function3
                                        public /* bridge */ /* synthetic */ FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> segment, Composer composer3, Integer num) {
                                            return invoke(segment, composer3, num.intValue());
                                        }

                                        public final FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> segment, Composer composer3, int i8) {
                                            composer3.startReplaceableGroup(-32667848);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-32667848, i8, -1, "androidx.compose.material.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:322)");
                                            }
                                            TweenSpec tween$default = AnimationSpecKt.tween$default(150, 0, null, 6, null);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                            composer3.endReplaceableGroup();
                                            return tween$default;
                                        }
                                    };
                                    int i8 = (i2 & 7168) | 384;
                                    startRestartGroup.startReplaceableGroup(-1939694975);
                                    ComposerKt.sourceInformation(startRestartGroup, "CC(animateColor)P(2)68@3220L31,69@3287L70,73@3370L70:Transition.kt#xbi5r1");
                                    ColorSpace m4067getColorSpaceimpl2 = Color.m4067getColorSpaceimpl(function3.invoke(updateTransition.getTargetState(), startRestartGroup, Integer.valueOf((i8 >> 6) & 112)).m4073unboximpl());
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
                                    int i9 = ((((i8 << 3) & 57344) | 3136) >> 9) & 112;
                                    State createTransitionAnimation4 = TransitionKt.createTransitionAnimation(updateTransition, function3.invoke(updateTransition.getCurrentState(), startRestartGroup, Integer.valueOf(i9)), function3.invoke(updateTransition.getTargetState(), startRestartGroup, Integer.valueOf(i9)), textFieldTransitionScope$Transition$labelContentColor$2.invoke((TextFieldTransitionScope$Transition$labelContentColor$2) updateTransition.getSegment(), (Transition.Segment) startRestartGroup, (Composer) 0), (TwoWayConverter) rememberedValue2, "LabelContentColor", startRestartGroup, 229376);
                                    startRestartGroup.endReplaceableGroup();
                                    startRestartGroup.endReplaceableGroup();
                                    function6.invoke(Float.valueOf(Transition_DTcfvLk$lambda$1(state)), Color.m4053boximpl(Transition_DTcfvLk$lambda$5(createTransitionAnimation3)), Color.m4053boximpl(Transition_DTcfvLk$lambda$6(createTransitionAnimation4)), Float.valueOf(Transition_DTcfvLk$lambda$3(createTransitionAnimation2)), startRestartGroup, Integer.valueOf((i2 >> 3) & 57344));
                                    composer2 = startRestartGroup;
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                                f5 = 1.0f;
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                startRestartGroup.endReplaceableGroup();
                                State createTransitionAnimation22 = TransitionKt.createTransitionAnimation(updateTransition, valueOf2, Float.valueOf(f5), textFieldTransitionScope$Transition$placeholderOpacity$2.invoke((TextFieldTransitionScope$Transition$placeholderOpacity$2) updateTransition.getSegment(), (Transition.Segment) startRestartGroup, (Composer) 0), vectorConverter2, "PlaceholderOpacity", startRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
                                startRestartGroup.endReplaceableGroup();
                                startRestartGroup.endReplaceableGroup();
                                TextFieldTransitionScope$Transition$labelTextStyleColor$2 textFieldTransitionScope$Transition$labelTextStyleColor$22 = new Function3<Transition.Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Color>>() { // from class: androidx.compose.material.TextFieldTransitionScope$Transition$labelTextStyleColor$2
                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> segment, Composer composer3, Integer num) {
                                        return invoke(segment, composer3, num.intValue());
                                    }

                                    public final FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> segment, Composer composer3, int i82) {
                                        composer3.startReplaceableGroup(-130058045);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-130058045, i82, -1, "androidx.compose.material.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:312)");
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
                                InputPhase inputPhase72 = (InputPhase) updateTransition.getTargetState();
                                startRestartGroup.startReplaceableGroup(-1490209928);
                                ComposerKt.sourceInformation(startRestartGroup, "C:TextFieldImpl.kt#jmzs0o");
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                if (WhenMappings.$EnumSwitchMapping$0[inputPhase72.ordinal()] == 1) {
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
                                InputPhase inputPhase82 = (InputPhase) updateTransition.getCurrentState();
                                startRestartGroup.startReplaceableGroup(-1490209928);
                                ComposerKt.sourceInformation(startRestartGroup, "C:TextFieldImpl.kt#jmzs0o");
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                if (WhenMappings.$EnumSwitchMapping$0[inputPhase82.ordinal()] == 1) {
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                startRestartGroup.endReplaceableGroup();
                                Color m4053boximpl2 = Color.m4053boximpl(j4);
                                InputPhase inputPhase92 = (InputPhase) updateTransition.getTargetState();
                                startRestartGroup.startReplaceableGroup(-1490209928);
                                ComposerKt.sourceInformation(startRestartGroup, "C:TextFieldImpl.kt#jmzs0o");
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                if (WhenMappings.$EnumSwitchMapping$0[inputPhase92.ordinal()] == 1) {
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                startRestartGroup.endReplaceableGroup();
                                State createTransitionAnimation32 = TransitionKt.createTransitionAnimation(updateTransition, m4053boximpl2, Color.m4053boximpl(j5), textFieldTransitionScope$Transition$labelTextStyleColor$22.invoke((TextFieldTransitionScope$Transition$labelTextStyleColor$2) updateTransition.getSegment(), (Transition.Segment) startRestartGroup, (Composer) 0), twoWayConverter2, "LabelTextStyleColor", startRestartGroup, 229376);
                                startRestartGroup.endReplaceableGroup();
                                startRestartGroup.endReplaceableGroup();
                                TextFieldTransitionScope$Transition$labelContentColor$2 textFieldTransitionScope$Transition$labelContentColor$22 = new Function3<Transition.Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Color>>() { // from class: androidx.compose.material.TextFieldTransitionScope$Transition$labelContentColor$2
                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> segment, Composer composer3, Integer num) {
                                        return invoke(segment, composer3, num.intValue());
                                    }

                                    public final FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> segment, Composer composer3, int i82) {
                                        composer3.startReplaceableGroup(-32667848);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-32667848, i82, -1, "androidx.compose.material.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:322)");
                                        }
                                        TweenSpec tween$default = AnimationSpecKt.tween$default(150, 0, null, 6, null);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                        composer3.endReplaceableGroup();
                                        return tween$default;
                                    }
                                };
                                int i82 = (i2 & 7168) | 384;
                                startRestartGroup.startReplaceableGroup(-1939694975);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(animateColor)P(2)68@3220L31,69@3287L70,73@3370L70:Transition.kt#xbi5r1");
                                ColorSpace m4067getColorSpaceimpl22 = Color.m4067getColorSpaceimpl(function3.invoke(updateTransition.getTargetState(), startRestartGroup, Integer.valueOf((i82 >> 6) & 112)).m4073unboximpl());
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
                                int i92 = ((((i82 << 3) & 57344) | 3136) >> 9) & 112;
                                State createTransitionAnimation42 = TransitionKt.createTransitionAnimation(updateTransition, function3.invoke(updateTransition.getCurrentState(), startRestartGroup, Integer.valueOf(i92)), function3.invoke(updateTransition.getTargetState(), startRestartGroup, Integer.valueOf(i92)), textFieldTransitionScope$Transition$labelContentColor$22.invoke((TextFieldTransitionScope$Transition$labelContentColor$2) updateTransition.getSegment(), (Transition.Segment) startRestartGroup, (Composer) 0), (TwoWayConverter) rememberedValue2, "LabelContentColor", startRestartGroup, 229376);
                                startRestartGroup.endReplaceableGroup();
                                startRestartGroup.endReplaceableGroup();
                                function6.invoke(Float.valueOf(Transition_DTcfvLk$lambda$1(state)), Color.m4053boximpl(Transition_DTcfvLk$lambda$5(createTransitionAnimation32)), Color.m4053boximpl(Transition_DTcfvLk$lambda$6(createTransitionAnimation42)), Float.valueOf(Transition_DTcfvLk$lambda$3(createTransitionAnimation22)), startRestartGroup, Integer.valueOf((i2 >> 3) & 57344));
                                composer2 = startRestartGroup;
                                if (ComposerKt.isTraceInProgress()) {
                                }
                            }
                            f4 = 1.0f;
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            startRestartGroup.endReplaceableGroup();
                            Float valueOf22 = Float.valueOf(f4);
                            InputPhase inputPhase62 = (InputPhase) updateTransition.getTargetState();
                            startRestartGroup.startReplaceableGroup(-1376159017);
                            ComposerKt.sourceInformation(startRestartGroup, "C:TextFieldImpl.kt#jmzs0o");
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            i6 = WhenMappings.$EnumSwitchMapping$0[inputPhase62.ordinal()];
                            if (i6 != 1) {
                            }
                            f5 = 1.0f;
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            startRestartGroup.endReplaceableGroup();
                            State createTransitionAnimation222 = TransitionKt.createTransitionAnimation(updateTransition, valueOf22, Float.valueOf(f5), textFieldTransitionScope$Transition$placeholderOpacity$2.invoke((TextFieldTransitionScope$Transition$placeholderOpacity$2) updateTransition.getSegment(), (Transition.Segment) startRestartGroup, (Composer) 0), vectorConverter2, "PlaceholderOpacity", startRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
                            startRestartGroup.endReplaceableGroup();
                            startRestartGroup.endReplaceableGroup();
                            TextFieldTransitionScope$Transition$labelTextStyleColor$2 textFieldTransitionScope$Transition$labelTextStyleColor$222 = new Function3<Transition.Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Color>>() { // from class: androidx.compose.material.TextFieldTransitionScope$Transition$labelTextStyleColor$2
                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> segment, Composer composer3, Integer num) {
                                    return invoke(segment, composer3, num.intValue());
                                }

                                public final FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> segment, Composer composer3, int i822) {
                                    composer3.startReplaceableGroup(-130058045);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-130058045, i822, -1, "androidx.compose.material.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:312)");
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
                            InputPhase inputPhase722 = (InputPhase) updateTransition.getTargetState();
                            startRestartGroup.startReplaceableGroup(-1490209928);
                            ComposerKt.sourceInformation(startRestartGroup, "C:TextFieldImpl.kt#jmzs0o");
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            if (WhenMappings.$EnumSwitchMapping$0[inputPhase722.ordinal()] == 1) {
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
                            InputPhase inputPhase822 = (InputPhase) updateTransition.getCurrentState();
                            startRestartGroup.startReplaceableGroup(-1490209928);
                            ComposerKt.sourceInformation(startRestartGroup, "C:TextFieldImpl.kt#jmzs0o");
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            if (WhenMappings.$EnumSwitchMapping$0[inputPhase822.ordinal()] == 1) {
                            }
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            startRestartGroup.endReplaceableGroup();
                            Color m4053boximpl22 = Color.m4053boximpl(j4);
                            InputPhase inputPhase922 = (InputPhase) updateTransition.getTargetState();
                            startRestartGroup.startReplaceableGroup(-1490209928);
                            ComposerKt.sourceInformation(startRestartGroup, "C:TextFieldImpl.kt#jmzs0o");
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            if (WhenMappings.$EnumSwitchMapping$0[inputPhase922.ordinal()] == 1) {
                            }
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            startRestartGroup.endReplaceableGroup();
                            State createTransitionAnimation322 = TransitionKt.createTransitionAnimation(updateTransition, m4053boximpl22, Color.m4053boximpl(j5), textFieldTransitionScope$Transition$labelTextStyleColor$222.invoke((TextFieldTransitionScope$Transition$labelTextStyleColor$2) updateTransition.getSegment(), (Transition.Segment) startRestartGroup, (Composer) 0), twoWayConverter22, "LabelTextStyleColor", startRestartGroup, 229376);
                            startRestartGroup.endReplaceableGroup();
                            startRestartGroup.endReplaceableGroup();
                            TextFieldTransitionScope$Transition$labelContentColor$2 textFieldTransitionScope$Transition$labelContentColor$222 = new Function3<Transition.Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Color>>() { // from class: androidx.compose.material.TextFieldTransitionScope$Transition$labelContentColor$2
                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> segment, Composer composer3, Integer num) {
                                    return invoke(segment, composer3, num.intValue());
                                }

                                public final FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> segment, Composer composer3, int i822) {
                                    composer3.startReplaceableGroup(-32667848);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-32667848, i822, -1, "androidx.compose.material.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:322)");
                                    }
                                    TweenSpec tween$default = AnimationSpecKt.tween$default(150, 0, null, 6, null);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    composer3.endReplaceableGroup();
                                    return tween$default;
                                }
                            };
                            int i822 = (i2 & 7168) | 384;
                            startRestartGroup.startReplaceableGroup(-1939694975);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(animateColor)P(2)68@3220L31,69@3287L70,73@3370L70:Transition.kt#xbi5r1");
                            ColorSpace m4067getColorSpaceimpl222 = Color.m4067getColorSpaceimpl(function3.invoke(updateTransition.getTargetState(), startRestartGroup, Integer.valueOf((i822 >> 6) & 112)).m4073unboximpl());
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
                            int i922 = ((((i822 << 3) & 57344) | 3136) >> 9) & 112;
                            State createTransitionAnimation422 = TransitionKt.createTransitionAnimation(updateTransition, function3.invoke(updateTransition.getCurrentState(), startRestartGroup, Integer.valueOf(i922)), function3.invoke(updateTransition.getTargetState(), startRestartGroup, Integer.valueOf(i922)), textFieldTransitionScope$Transition$labelContentColor$222.invoke((TextFieldTransitionScope$Transition$labelContentColor$2) updateTransition.getSegment(), (Transition.Segment) startRestartGroup, (Composer) 0), (TwoWayConverter) rememberedValue2, "LabelContentColor", startRestartGroup, 229376);
                            startRestartGroup.endReplaceableGroup();
                            startRestartGroup.endReplaceableGroup();
                            function6.invoke(Float.valueOf(Transition_DTcfvLk$lambda$1(state)), Color.m4053boximpl(Transition_DTcfvLk$lambda$5(createTransitionAnimation322)), Color.m4053boximpl(Transition_DTcfvLk$lambda$6(createTransitionAnimation422)), Float.valueOf(Transition_DTcfvLk$lambda$3(createTransitionAnimation222)), startRestartGroup, Integer.valueOf((i2 >> 3) & 57344));
                            composer2 = startRestartGroup;
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
                    State createTransitionAnimation5 = TransitionKt.createTransitionAnimation(updateTransition, f2, Float.valueOf(f3), textFieldTransitionScope$Transition$labelProgress$2.invoke((TextFieldTransitionScope$Transition$labelProgress$2) updateTransition.getSegment(), (Transition.Segment) startRestartGroup, (Composer) 0), vectorConverter, "LabelProgress", startRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endReplaceableGroup();
                    TextFieldTransitionScope$Transition$placeholderOpacity$2 textFieldTransitionScope$Transition$placeholderOpacity$22 = new Function3<Transition.Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.material.TextFieldTransitionScope$Transition$placeholderOpacity$2
                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ FiniteAnimationSpec<Float> invoke(Transition.Segment<InputPhase> segment, Composer composer3, Integer num) {
                            return invoke(segment, composer3, num.intValue());
                        }

                        public final FiniteAnimationSpec<Float> invoke(Transition.Segment<InputPhase> segment, Composer composer3, int i83) {
                            TweenSpec tween;
                            composer3.startReplaceableGroup(-1079955085);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1079955085, i83, -1, "androidx.compose.material.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:286)");
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
                    startRestartGroup.startReplaceableGroup(-1376159017);
                    ComposerKt.sourceInformation(startRestartGroup, "C:TextFieldImpl.kt#jmzs0o");
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
                    startRestartGroup.startReplaceableGroup(-1376159017);
                    ComposerKt.sourceInformation(startRestartGroup, "C:TextFieldImpl.kt#jmzs0o");
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    i6 = WhenMappings.$EnumSwitchMapping$0[inputPhase622.ordinal()];
                    if (i6 != 1) {
                    }
                    f5 = 1.0f;
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    startRestartGroup.endReplaceableGroup();
                    State createTransitionAnimation2222 = TransitionKt.createTransitionAnimation(updateTransition, valueOf222, Float.valueOf(f5), textFieldTransitionScope$Transition$placeholderOpacity$22.invoke((TextFieldTransitionScope$Transition$placeholderOpacity$2) updateTransition.getSegment(), (Transition.Segment) startRestartGroup, (Composer) 0), vectorConverter22, "PlaceholderOpacity", startRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endReplaceableGroup();
                    TextFieldTransitionScope$Transition$labelTextStyleColor$2 textFieldTransitionScope$Transition$labelTextStyleColor$2222 = new Function3<Transition.Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Color>>() { // from class: androidx.compose.material.TextFieldTransitionScope$Transition$labelTextStyleColor$2
                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> segment, Composer composer3, Integer num) {
                            return invoke(segment, composer3, num.intValue());
                        }

                        public final FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> segment, Composer composer3, int i8222) {
                            composer3.startReplaceableGroup(-130058045);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-130058045, i8222, -1, "androidx.compose.material.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:312)");
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
                    InputPhase inputPhase7222 = (InputPhase) updateTransition.getTargetState();
                    startRestartGroup.startReplaceableGroup(-1490209928);
                    ComposerKt.sourceInformation(startRestartGroup, "C:TextFieldImpl.kt#jmzs0o");
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    if (WhenMappings.$EnumSwitchMapping$0[inputPhase7222.ordinal()] == 1) {
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
                    InputPhase inputPhase8222 = (InputPhase) updateTransition.getCurrentState();
                    startRestartGroup.startReplaceableGroup(-1490209928);
                    ComposerKt.sourceInformation(startRestartGroup, "C:TextFieldImpl.kt#jmzs0o");
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    if (WhenMappings.$EnumSwitchMapping$0[inputPhase8222.ordinal()] == 1) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    startRestartGroup.endReplaceableGroup();
                    Color m4053boximpl222 = Color.m4053boximpl(j4);
                    InputPhase inputPhase9222 = (InputPhase) updateTransition.getTargetState();
                    startRestartGroup.startReplaceableGroup(-1490209928);
                    ComposerKt.sourceInformation(startRestartGroup, "C:TextFieldImpl.kt#jmzs0o");
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    if (WhenMappings.$EnumSwitchMapping$0[inputPhase9222.ordinal()] == 1) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    startRestartGroup.endReplaceableGroup();
                    State createTransitionAnimation3222 = TransitionKt.createTransitionAnimation(updateTransition, m4053boximpl222, Color.m4053boximpl(j5), textFieldTransitionScope$Transition$labelTextStyleColor$2222.invoke((TextFieldTransitionScope$Transition$labelTextStyleColor$2) updateTransition.getSegment(), (Transition.Segment) startRestartGroup, (Composer) 0), twoWayConverter222, "LabelTextStyleColor", startRestartGroup, 229376);
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endReplaceableGroup();
                    TextFieldTransitionScope$Transition$labelContentColor$2 textFieldTransitionScope$Transition$labelContentColor$2222 = new Function3<Transition.Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Color>>() { // from class: androidx.compose.material.TextFieldTransitionScope$Transition$labelContentColor$2
                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> segment, Composer composer3, Integer num) {
                            return invoke(segment, composer3, num.intValue());
                        }

                        public final FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> segment, Composer composer3, int i8222) {
                            composer3.startReplaceableGroup(-32667848);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-32667848, i8222, -1, "androidx.compose.material.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:322)");
                            }
                            TweenSpec tween$default = AnimationSpecKt.tween$default(150, 0, null, 6, null);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer3.endReplaceableGroup();
                            return tween$default;
                        }
                    };
                    int i8222 = (i2 & 7168) | 384;
                    startRestartGroup.startReplaceableGroup(-1939694975);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(animateColor)P(2)68@3220L31,69@3287L70,73@3370L70:Transition.kt#xbi5r1");
                    ColorSpace m4067getColorSpaceimpl2222 = Color.m4067getColorSpaceimpl(function3.invoke(updateTransition.getTargetState(), startRestartGroup, Integer.valueOf((i8222 >> 6) & 112)).m4073unboximpl());
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
                    int i9222 = ((((i8222 << 3) & 57344) | 3136) >> 9) & 112;
                    State createTransitionAnimation4222 = TransitionKt.createTransitionAnimation(updateTransition, function3.invoke(updateTransition.getCurrentState(), startRestartGroup, Integer.valueOf(i9222)), function3.invoke(updateTransition.getTargetState(), startRestartGroup, Integer.valueOf(i9222)), textFieldTransitionScope$Transition$labelContentColor$2222.invoke((TextFieldTransitionScope$Transition$labelContentColor$2) updateTransition.getSegment(), (Transition.Segment) startRestartGroup, (Composer) 0), (TwoWayConverter) rememberedValue2, "LabelContentColor", startRestartGroup, 229376);
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endReplaceableGroup();
                    function6.invoke(Float.valueOf(Transition_DTcfvLk$lambda$1(state)), Color.m4053boximpl(Transition_DTcfvLk$lambda$5(createTransitionAnimation3222)), Color.m4053boximpl(Transition_DTcfvLk$lambda$6(createTransitionAnimation4222)), Float.valueOf(Transition_DTcfvLk$lambda$3(createTransitionAnimation2222)), startRestartGroup, Integer.valueOf((i2 >> 3) & 57344));
                    composer2 = startRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                    }
                } else if (i7 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
            }
            f = 1.0f;
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.endReplaceableGroup();
            Float valueOf3 = Float.valueOf(f);
            InputPhase inputPhase42 = (InputPhase) updateTransition.getTargetState();
            startRestartGroup.startReplaceableGroup(-1158004136);
            ComposerKt.sourceInformation(startRestartGroup, "C:TextFieldImpl.kt#jmzs0o");
            if (ComposerKt.isTraceInProgress()) {
            }
            i4 = WhenMappings.$EnumSwitchMapping$0[inputPhase2.ordinal()];
            if (i4 != 1) {
            }
            f3 = 1.0f;
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.endReplaceableGroup();
            State createTransitionAnimation52 = TransitionKt.createTransitionAnimation(updateTransition, f2, Float.valueOf(f3), textFieldTransitionScope$Transition$labelProgress$2.invoke((TextFieldTransitionScope$Transition$labelProgress$2) updateTransition.getSegment(), (Transition.Segment) startRestartGroup, (Composer) 0), vectorConverter, "LabelProgress", startRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            TextFieldTransitionScope$Transition$placeholderOpacity$2 textFieldTransitionScope$Transition$placeholderOpacity$222 = new Function3<Transition.Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.material.TextFieldTransitionScope$Transition$placeholderOpacity$2
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ FiniteAnimationSpec<Float> invoke(Transition.Segment<InputPhase> segment, Composer composer3, Integer num) {
                    return invoke(segment, composer3, num.intValue());
                }

                public final FiniteAnimationSpec<Float> invoke(Transition.Segment<InputPhase> segment, Composer composer3, int i83) {
                    TweenSpec tween;
                    composer3.startReplaceableGroup(-1079955085);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1079955085, i83, -1, "androidx.compose.material.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:286)");
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
            startRestartGroup.startReplaceableGroup(-1376159017);
            ComposerKt.sourceInformation(startRestartGroup, "C:TextFieldImpl.kt#jmzs0o");
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
            startRestartGroup.startReplaceableGroup(-1376159017);
            ComposerKt.sourceInformation(startRestartGroup, "C:TextFieldImpl.kt#jmzs0o");
            if (ComposerKt.isTraceInProgress()) {
            }
            i6 = WhenMappings.$EnumSwitchMapping$0[inputPhase6222.ordinal()];
            if (i6 != 1) {
            }
            f5 = 1.0f;
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.endReplaceableGroup();
            State createTransitionAnimation22222 = TransitionKt.createTransitionAnimation(updateTransition, valueOf2222, Float.valueOf(f5), textFieldTransitionScope$Transition$placeholderOpacity$222.invoke((TextFieldTransitionScope$Transition$placeholderOpacity$2) updateTransition.getSegment(), (Transition.Segment) startRestartGroup, (Composer) 0), vectorConverter222, "PlaceholderOpacity", startRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            TextFieldTransitionScope$Transition$labelTextStyleColor$2 textFieldTransitionScope$Transition$labelTextStyleColor$22222 = new Function3<Transition.Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Color>>() { // from class: androidx.compose.material.TextFieldTransitionScope$Transition$labelTextStyleColor$2
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> segment, Composer composer3, Integer num) {
                    return invoke(segment, composer3, num.intValue());
                }

                public final FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> segment, Composer composer3, int i82222) {
                    composer3.startReplaceableGroup(-130058045);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-130058045, i82222, -1, "androidx.compose.material.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:312)");
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
            InputPhase inputPhase72222 = (InputPhase) updateTransition.getTargetState();
            startRestartGroup.startReplaceableGroup(-1490209928);
            ComposerKt.sourceInformation(startRestartGroup, "C:TextFieldImpl.kt#jmzs0o");
            if (ComposerKt.isTraceInProgress()) {
            }
            if (WhenMappings.$EnumSwitchMapping$0[inputPhase72222.ordinal()] == 1) {
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
            InputPhase inputPhase82222 = (InputPhase) updateTransition.getCurrentState();
            startRestartGroup.startReplaceableGroup(-1490209928);
            ComposerKt.sourceInformation(startRestartGroup, "C:TextFieldImpl.kt#jmzs0o");
            if (ComposerKt.isTraceInProgress()) {
            }
            if (WhenMappings.$EnumSwitchMapping$0[inputPhase82222.ordinal()] == 1) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.endReplaceableGroup();
            Color m4053boximpl2222 = Color.m4053boximpl(j4);
            InputPhase inputPhase92222 = (InputPhase) updateTransition.getTargetState();
            startRestartGroup.startReplaceableGroup(-1490209928);
            ComposerKt.sourceInformation(startRestartGroup, "C:TextFieldImpl.kt#jmzs0o");
            if (ComposerKt.isTraceInProgress()) {
            }
            if (WhenMappings.$EnumSwitchMapping$0[inputPhase92222.ordinal()] == 1) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.endReplaceableGroup();
            State createTransitionAnimation32222 = TransitionKt.createTransitionAnimation(updateTransition, m4053boximpl2222, Color.m4053boximpl(j5), textFieldTransitionScope$Transition$labelTextStyleColor$22222.invoke((TextFieldTransitionScope$Transition$labelTextStyleColor$2) updateTransition.getSegment(), (Transition.Segment) startRestartGroup, (Composer) 0), twoWayConverter2222, "LabelTextStyleColor", startRestartGroup, 229376);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            TextFieldTransitionScope$Transition$labelContentColor$2 textFieldTransitionScope$Transition$labelContentColor$22222 = new Function3<Transition.Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Color>>() { // from class: androidx.compose.material.TextFieldTransitionScope$Transition$labelContentColor$2
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> segment, Composer composer3, Integer num) {
                    return invoke(segment, composer3, num.intValue());
                }

                public final FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> segment, Composer composer3, int i82222) {
                    composer3.startReplaceableGroup(-32667848);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-32667848, i82222, -1, "androidx.compose.material.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:322)");
                    }
                    TweenSpec tween$default = AnimationSpecKt.tween$default(150, 0, null, 6, null);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer3.endReplaceableGroup();
                    return tween$default;
                }
            };
            int i82222 = (i2 & 7168) | 384;
            startRestartGroup.startReplaceableGroup(-1939694975);
            ComposerKt.sourceInformation(startRestartGroup, "CC(animateColor)P(2)68@3220L31,69@3287L70,73@3370L70:Transition.kt#xbi5r1");
            ColorSpace m4067getColorSpaceimpl22222 = Color.m4067getColorSpaceimpl(function3.invoke(updateTransition.getTargetState(), startRestartGroup, Integer.valueOf((i82222 >> 6) & 112)).m4073unboximpl());
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
            int i92222 = ((((i82222 << 3) & 57344) | 3136) >> 9) & 112;
            State createTransitionAnimation42222 = TransitionKt.createTransitionAnimation(updateTransition, function3.invoke(updateTransition.getCurrentState(), startRestartGroup, Integer.valueOf(i92222)), function3.invoke(updateTransition.getTargetState(), startRestartGroup, Integer.valueOf(i92222)), textFieldTransitionScope$Transition$labelContentColor$22222.invoke((TextFieldTransitionScope$Transition$labelContentColor$2) updateTransition.getSegment(), (Transition.Segment) startRestartGroup, (Composer) 0), (TwoWayConverter) rememberedValue2, "LabelContentColor", startRestartGroup, 229376);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            function6.invoke(Float.valueOf(Transition_DTcfvLk$lambda$1(state)), Color.m4053boximpl(Transition_DTcfvLk$lambda$5(createTransitionAnimation32222)), Color.m4053boximpl(Transition_DTcfvLk$lambda$6(createTransitionAnimation42222)), Float.valueOf(Transition_DTcfvLk$lambda$3(createTransitionAnimation22222)), startRestartGroup, Integer.valueOf((i2 >> 3) & 57344));
            composer2 = startRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldTransitionScope$Transition$1
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

                public final void invoke(Composer composer3, int i10) {
                    TextFieldTransitionScope.this.m1840TransitionDTcfvLk(inputPhase, j, j2, function3, z, function6, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
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

    private static final long Transition_DTcfvLk$lambda$5(State<Color> state) {
        return state.getValue().m4073unboximpl();
    }

    private static final long Transition_DTcfvLk$lambda$6(State<Color> state) {
        return state.getValue().m4073unboximpl();
    }
}
