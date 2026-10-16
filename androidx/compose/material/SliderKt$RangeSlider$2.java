package androidx.compose.material;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: Slider.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u000b¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/layout/BoxWithConstraintsScope;", "invoke", "(Landroidx/compose/foundation/layout/BoxWithConstraintsScope;Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class SliderKt$RangeSlider$2 extends Lambda implements Function3<BoxWithConstraintsScope, Composer, Integer, Unit> {
    final /* synthetic */ SliderColors $colors;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ MutableInteractionSource $endInteractionSource;
    final /* synthetic */ Function0<Unit> $onValueChangeFinished;
    final /* synthetic */ State<Function1<ClosedFloatingPointRange<Float>, Unit>> $onValueChangeState;
    final /* synthetic */ MutableInteractionSource $startInteractionSource;
    final /* synthetic */ int $steps;
    final /* synthetic */ List<Float> $tickFractions;
    final /* synthetic */ ClosedFloatingPointRange<Float> $value;
    final /* synthetic */ ClosedFloatingPointRange<Float> $valueRange;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    SliderKt$RangeSlider$2(ClosedFloatingPointRange<Float> closedFloatingPointRange, ClosedFloatingPointRange<Float> closedFloatingPointRange2, State<? extends Function1<? super ClosedFloatingPointRange<Float>, Unit>> state, MutableInteractionSource mutableInteractionSource, MutableInteractionSource mutableInteractionSource2, boolean z, int i, Function0<Unit> function0, List<Float> list, SliderColors sliderColors) {
        super(3);
        this.$valueRange = closedFloatingPointRange;
        this.$value = closedFloatingPointRange2;
        this.$onValueChangeState = state;
        this.$startInteractionSource = mutableInteractionSource;
        this.$endInteractionSource = mutableInteractionSource2;
        this.$enabled = z;
        this.$steps = i;
        this.$onValueChangeFinished = function0;
        this.$tickFractions = list;
        this.$colors = sliderColors;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer, Integer num) {
        invoke(boxWithConstraintsScope, composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer, int i) {
        BoxWithConstraintsScope boxWithConstraintsScope2;
        int i2;
        final MutableFloatState mutableFloatState;
        final MutableFloatState mutableFloatState2;
        Modifier rangeSliderPressDragModifier;
        float calcFraction;
        float calcFraction2;
        Modifier sliderSemantics;
        Modifier sliderSemantics2;
        ComposerKt.sourceInformation(composer, "C318@14281L7,*323@14442L7,334@14870L60,335@14958L67,337@15035L164,344@15208L169,352@15399L24,353@15455L964,377@16442L904,433@18848L340:Slider.kt#jmzs0o");
        if ((i & 14) == 0) {
            boxWithConstraintsScope2 = boxWithConstraintsScope;
            i2 = i | (composer.changed(boxWithConstraintsScope2) ? 4 : 2);
        } else {
            boxWithConstraintsScope2 = boxWithConstraintsScope;
            i2 = i;
        }
        if ((i2 & 91) != 18 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(652589923, i2, -1, "androidx.compose.material.RangeSlider.<anonymous> (Slider.kt:318)");
            }
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = composer.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd(composer);
            boolean z = consume == LayoutDirection.Rtl;
            float m6345getMaxWidthimpl = Constraints.m6345getMaxWidthimpl(boxWithConstraintsScope2.mo815getConstraintsmsEJaDk());
            final Ref.FloatRef floatRef = new Ref.FloatRef();
            final Ref.FloatRef floatRef2 = new Ref.FloatRef();
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume2 = composer.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd(composer);
            Density density = (Density) consume2;
            floatRef.element = m6345getMaxWidthimpl - density.mo630toPx0680j_4(SliderKt.getThumbRadius());
            floatRef2.element = density.mo630toPx0680j_4(SliderKt.getThumbRadius());
            ClosedFloatingPointRange<Float> closedFloatingPointRange = this.$value;
            ClosedFloatingPointRange<Float> closedFloatingPointRange2 = this.$valueRange;
            composer.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = PrimitiveSnapshotStateKt.mutableFloatStateOf(invoke$scaleToOffset(closedFloatingPointRange2, floatRef2, floatRef, closedFloatingPointRange.getStart().floatValue()));
                composer.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceableGroup();
            final MutableFloatState mutableFloatState3 = (MutableFloatState) rememberedValue;
            ClosedFloatingPointRange<Float> closedFloatingPointRange3 = this.$value;
            ClosedFloatingPointRange<Float> closedFloatingPointRange4 = this.$valueRange;
            composer.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
            Object rememberedValue2 = composer.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = PrimitiveSnapshotStateKt.mutableFloatStateOf(invoke$scaleToOffset(closedFloatingPointRange4, floatRef2, floatRef, closedFloatingPointRange3.getEndInclusive().floatValue()));
                composer.updateRememberedValue(rememberedValue2);
            }
            composer.endReplaceableGroup();
            final MutableFloatState mutableFloatState4 = (MutableFloatState) rememberedValue2;
            SliderKt.CorrectValueSideEffect(new AnonymousClass2(this.$valueRange, floatRef2, floatRef), this.$valueRange, RangesKt.rangeTo(floatRef2.element, floatRef.element), mutableFloatState3, this.$value.getStart().floatValue(), composer, 3072);
            SliderKt.CorrectValueSideEffect(new AnonymousClass3(this.$valueRange, floatRef2, floatRef), this.$valueRange, RangesKt.rangeTo(floatRef2.element, floatRef.element), mutableFloatState4, this.$value.getEndInclusive().floatValue(), composer, 3072);
            composer.startReplaceableGroup(773894976);
            ComposerKt.sourceInformation(composer, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
            composer.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
            Object rememberedValue3 = composer.rememberedValue();
            if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                Object compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer));
                composer.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                rememberedValue3 = compositionScopedCoroutineScopeCanceller;
            }
            composer.endReplaceableGroup();
            final CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue3).getCoroutineScope();
            composer.endReplaceableGroup();
            final List<Float> list = this.$tickFractions;
            final Function0<Unit> function0 = this.$onValueChangeFinished;
            final State<Function1<ClosedFloatingPointRange<Float>, Unit>> state = this.$onValueChangeState;
            final ClosedFloatingPointRange<Float> closedFloatingPointRange5 = this.$valueRange;
            State rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(new Function1<Boolean, Unit>() { // from class: androidx.compose.material.SliderKt$RangeSlider$2$gestureEndAction$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z2) {
                    float snapValueToTick;
                    float floatValue = (z2 ? MutableFloatState.this : mutableFloatState4).getFloatValue();
                    snapValueToTick = SliderKt.snapValueToTick(floatValue, list, floatRef2.element, floatRef.element);
                    if (floatValue != snapValueToTick) {
                        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass1(floatValue, snapValueToTick, function0, z2, MutableFloatState.this, mutableFloatState4, state, floatRef2, floatRef, closedFloatingPointRange5, null), 3, null);
                        return;
                    }
                    Function0<Unit> function02 = function0;
                    if (function02 != null) {
                        function02.invoke();
                    }
                }

                /* compiled from: Slider.kt */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                @DebugMetadata(c = "androidx.compose.material.SliderKt$RangeSlider$2$gestureEndAction$1$1", f = "Slider.kt", i = {}, l = {364}, m = "invokeSuspend", n = {}, s = {})
                /* renamed from: androidx.compose.material.SliderKt$RangeSlider$2$gestureEndAction$1$1, reason: invalid class name */
                static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ float $current;
                    final /* synthetic */ boolean $isStart;
                    final /* synthetic */ Ref.FloatRef $maxPx;
                    final /* synthetic */ Ref.FloatRef $minPx;
                    final /* synthetic */ Function0<Unit> $onValueChangeFinished;
                    final /* synthetic */ State<Function1<ClosedFloatingPointRange<Float>, Unit>> $onValueChangeState;
                    final /* synthetic */ MutableFloatState $rawOffsetEnd;
                    final /* synthetic */ MutableFloatState $rawOffsetStart;
                    final /* synthetic */ float $target;
                    final /* synthetic */ ClosedFloatingPointRange<Float> $valueRange;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    AnonymousClass1(float f, float f2, Function0<Unit> function0, boolean z, MutableFloatState mutableFloatState, MutableFloatState mutableFloatState2, State<? extends Function1<? super ClosedFloatingPointRange<Float>, Unit>> state, Ref.FloatRef floatRef, Ref.FloatRef floatRef2, ClosedFloatingPointRange<Float> closedFloatingPointRange, Continuation<? super AnonymousClass1> continuation) {
                        super(2, continuation);
                        this.$current = f;
                        this.$target = f2;
                        this.$onValueChangeFinished = function0;
                        this.$isStart = z;
                        this.$rawOffsetStart = mutableFloatState;
                        this.$rawOffsetEnd = mutableFloatState2;
                        this.$onValueChangeState = state;
                        this.$minPx = floatRef;
                        this.$maxPx = floatRef2;
                        this.$valueRange = closedFloatingPointRange;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new AnonymousClass1(this.$current, this.$target, this.$onValueChangeFinished, this.$isStart, this.$rawOffsetStart, this.$rawOffsetEnd, this.$onValueChangeState, this.$minPx, this.$maxPx, this.$valueRange, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        TweenSpec tweenSpec;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            Animatable Animatable$default = AnimatableKt.Animatable$default(this.$current, 0.0f, 2, null);
                            Float boxFloat = Boxing.boxFloat(this.$target);
                            tweenSpec = SliderKt.SliderToTickAnimation;
                            TweenSpec tweenSpec2 = tweenSpec;
                            Float boxFloat2 = Boxing.boxFloat(0.0f);
                            final boolean z = this.$isStart;
                            final MutableFloatState mutableFloatState = this.$rawOffsetStart;
                            final MutableFloatState mutableFloatState2 = this.$rawOffsetEnd;
                            final State<Function1<ClosedFloatingPointRange<Float>, Unit>> state = this.$onValueChangeState;
                            final Ref.FloatRef floatRef = this.$minPx;
                            final Ref.FloatRef floatRef2 = this.$maxPx;
                            final ClosedFloatingPointRange<Float> closedFloatingPointRange = this.$valueRange;
                            this.label = 1;
                            if (Animatable$default.animateTo(boxFloat, tweenSpec2, boxFloat2, new Function1<Animatable<Float, AnimationVector1D>, Unit>() { // from class: androidx.compose.material.SliderKt.RangeSlider.2.gestureEndAction.1.1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Animatable<Float, AnimationVector1D> animatable) {
                                    invoke2(animatable);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(Animatable<Float, AnimationVector1D> animatable) {
                                    ClosedFloatingPointRange<Float> invoke$scaleToUserValue;
                                    (z ? mutableFloatState : mutableFloatState2).setFloatValue(animatable.getValue().floatValue());
                                    Function1<ClosedFloatingPointRange<Float>, Unit> value = state.getValue();
                                    invoke$scaleToUserValue = SliderKt$RangeSlider$2.invoke$scaleToUserValue(floatRef, floatRef2, closedFloatingPointRange, RangesKt.rangeTo(mutableFloatState.getFloatValue(), mutableFloatState2.getFloatValue()));
                                    value.invoke(invoke$scaleToUserValue);
                                }
                            }, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                        }
                        Function0<Unit> function0 = this.$onValueChangeFinished;
                        if (function0 != null) {
                            function0.invoke();
                        }
                        return Unit.INSTANCE;
                    }
                }
            }, composer, 0);
            composer.startReplaceableGroup(17280602);
            boolean changed = composer.changed(mutableFloatState3) | composer.changed(mutableFloatState4) | composer.changed(this.$valueRange) | composer.changed(floatRef2.element) | composer.changed(floatRef.element) | composer.changed(this.$value) | composer.changed(this.$onValueChangeState);
            final ClosedFloatingPointRange<Float> closedFloatingPointRange6 = this.$value;
            final State<Function1<ClosedFloatingPointRange<Float>, Unit>> state2 = this.$onValueChangeState;
            final ClosedFloatingPointRange<Float> closedFloatingPointRange7 = this.$valueRange;
            Object rememberedValue4 = composer.rememberedValue();
            if (changed || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                mutableFloatState = mutableFloatState3;
                mutableFloatState2 = mutableFloatState4;
                rememberedValue4 = (Function2) new Function2<Boolean, Float, Unit>() { // from class: androidx.compose.material.SliderKt$RangeSlider$2$onDrag$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Float f) {
                        invoke(bool.booleanValue(), f.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z2, float f) {
                        ClosedFloatingPointRange<Float> rangeTo;
                        ClosedFloatingPointRange<Float> invoke$scaleToUserValue;
                        if (z2) {
                            MutableFloatState mutableFloatState5 = MutableFloatState.this;
                            mutableFloatState5.setFloatValue(mutableFloatState5.getFloatValue() + f);
                            mutableFloatState2.setFloatValue(SliderKt$RangeSlider$2.invoke$scaleToOffset(closedFloatingPointRange7, floatRef2, floatRef, closedFloatingPointRange6.getEndInclusive().floatValue()));
                            float floatValue = mutableFloatState2.getFloatValue();
                            rangeTo = RangesKt.rangeTo(RangesKt.coerceIn(MutableFloatState.this.getFloatValue(), floatRef2.element, floatValue), floatValue);
                        } else {
                            MutableFloatState mutableFloatState6 = mutableFloatState2;
                            mutableFloatState6.setFloatValue(mutableFloatState6.getFloatValue() + f);
                            MutableFloatState.this.setFloatValue(SliderKt$RangeSlider$2.invoke$scaleToOffset(closedFloatingPointRange7, floatRef2, floatRef, closedFloatingPointRange6.getStart().floatValue()));
                            float floatValue2 = MutableFloatState.this.getFloatValue();
                            rangeTo = RangesKt.rangeTo(floatValue2, RangesKt.coerceIn(mutableFloatState2.getFloatValue(), floatValue2, floatRef.element));
                        }
                        Function1<ClosedFloatingPointRange<Float>, Unit> value = state2.getValue();
                        invoke$scaleToUserValue = SliderKt$RangeSlider$2.invoke$scaleToUserValue(floatRef2, floatRef, closedFloatingPointRange7, rangeTo);
                        value.invoke(invoke$scaleToUserValue);
                    }
                };
                composer.updateRememberedValue(rememberedValue4);
            } else {
                mutableFloatState = mutableFloatState3;
                mutableFloatState2 = mutableFloatState4;
            }
            composer.endReplaceableGroup();
            rangeSliderPressDragModifier = SliderKt.rangeSliderPressDragModifier(Modifier.INSTANCE, this.$startInteractionSource, this.$endInteractionSource, mutableFloatState, mutableFloatState2, this.$enabled, z, m6345getMaxWidthimpl, this.$valueRange, rememberUpdatedState, SnapshotStateKt.rememberUpdatedState((Function2) rememberedValue4, composer, 0));
            final float coerceIn = RangesKt.coerceIn(this.$value.getStart().floatValue(), this.$valueRange.getStart().floatValue(), this.$value.getEndInclusive().floatValue());
            final float coerceIn2 = RangesKt.coerceIn(this.$value.getEndInclusive().floatValue(), this.$value.getStart().floatValue(), this.$valueRange.getEndInclusive().floatValue());
            calcFraction = SliderKt.calcFraction(this.$valueRange.getStart().floatValue(), this.$valueRange.getEndInclusive().floatValue(), coerceIn);
            calcFraction2 = SliderKt.calcFraction(this.$valueRange.getStart().floatValue(), this.$valueRange.getEndInclusive().floatValue(), coerceIn2);
            int floor = (int) Math.floor(this.$steps * calcFraction2);
            int floor2 = (int) Math.floor(this.$steps * (1.0f - calcFraction));
            Modifier.Companion companion = Modifier.INSTANCE;
            boolean z2 = this.$enabled;
            composer.startReplaceableGroup(17282478);
            boolean changed2 = composer.changed(this.$onValueChangeState) | composer.changed(coerceIn2);
            final State<Function1<ClosedFloatingPointRange<Float>, Unit>> state3 = this.$onValueChangeState;
            Object rememberedValue5 = composer.rememberedValue();
            if (changed2 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                rememberedValue5 = (Function1) new Function1<Float, Unit>() { // from class: androidx.compose.material.SliderKt$RangeSlider$2$startThumbSemantics$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Float f) {
                        invoke(f.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(float f) {
                        state3.getValue().invoke(RangesKt.rangeTo(f, coerceIn2));
                    }
                };
                composer.updateRememberedValue(rememberedValue5);
            }
            composer.endReplaceableGroup();
            sliderSemantics = SliderKt.sliderSemantics(companion, coerceIn, z2, (Function1) rememberedValue5, this.$onValueChangeFinished, RangesKt.rangeTo(this.$valueRange.getStart().floatValue(), coerceIn2), floor);
            Modifier.Companion companion2 = Modifier.INSTANCE;
            boolean z3 = this.$enabled;
            composer.startReplaceableGroup(17282768);
            boolean changed3 = composer.changed(this.$onValueChangeState) | composer.changed(coerceIn);
            final State<Function1<ClosedFloatingPointRange<Float>, Unit>> state4 = this.$onValueChangeState;
            Object rememberedValue6 = composer.rememberedValue();
            if (changed3 || rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                rememberedValue6 = (Function1) new Function1<Float, Unit>() { // from class: androidx.compose.material.SliderKt$RangeSlider$2$endThumbSemantics$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Float f) {
                        invoke(f.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(float f) {
                        state4.getValue().invoke(RangesKt.rangeTo(coerceIn, f));
                    }
                };
                composer.updateRememberedValue(rememberedValue6);
            }
            composer.endReplaceableGroup();
            sliderSemantics2 = SliderKt.sliderSemantics(companion2, coerceIn2, z3, (Function1) rememberedValue6, this.$onValueChangeFinished, RangesKt.rangeTo(coerceIn, this.$valueRange.getEndInclusive().floatValue()), floor2);
            SliderKt.RangeSliderImpl(this.$enabled, calcFraction, calcFraction2, this.$tickFractions, this.$colors, floatRef.element - floatRef2.element, this.$startInteractionSource, this.$endInteractionSource, rangeSliderPressDragModifier, sliderSemantics, sliderSemantics2, composer, 14159872, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ClosedFloatingPointRange<Float> invoke$scaleToUserValue(Ref.FloatRef floatRef, Ref.FloatRef floatRef2, ClosedFloatingPointRange<Float> closedFloatingPointRange, ClosedFloatingPointRange<Float> closedFloatingPointRange2) {
        ClosedFloatingPointRange<Float> scale;
        scale = SliderKt.scale(floatRef.element, floatRef2.element, (ClosedFloatingPointRange<Float>) closedFloatingPointRange2, closedFloatingPointRange.getStart().floatValue(), closedFloatingPointRange.getEndInclusive().floatValue());
        return scale;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float invoke$scaleToOffset(ClosedFloatingPointRange<Float> closedFloatingPointRange, Ref.FloatRef floatRef, Ref.FloatRef floatRef2, float f) {
        float scale;
        scale = SliderKt.scale(closedFloatingPointRange.getStart().floatValue(), closedFloatingPointRange.getEndInclusive().floatValue(), f, floatRef.element, floatRef2.element);
        return scale;
    }

    /* compiled from: Slider.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* renamed from: androidx.compose.material.SliderKt$RangeSlider$2$2, reason: invalid class name */
    /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<Float, Float> {
        final /* synthetic */ Ref.FloatRef $maxPx;
        final /* synthetic */ Ref.FloatRef $minPx;
        final /* synthetic */ ClosedFloatingPointRange<Float> $valueRange;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(ClosedFloatingPointRange<Float> closedFloatingPointRange, Ref.FloatRef floatRef, Ref.FloatRef floatRef2) {
            super(1, Intrinsics.Kotlin.class, "scaleToOffset", "invoke$scaleToOffset(Lkotlin/ranges/ClosedFloatingPointRange;Lkotlin/jvm/internal/Ref$FloatRef;Lkotlin/jvm/internal/Ref$FloatRef;F)F", 0);
            this.$valueRange = closedFloatingPointRange;
            this.$minPx = floatRef;
            this.$maxPx = floatRef2;
        }

        public final Float invoke(float f) {
            return Float.valueOf(SliderKt$RangeSlider$2.invoke$scaleToOffset(this.$valueRange, this.$minPx, this.$maxPx, f));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Float invoke(Float f) {
            return invoke(f.floatValue());
        }
    }

    /* compiled from: Slider.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* renamed from: androidx.compose.material.SliderKt$RangeSlider$2$3, reason: invalid class name */
    /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function1<Float, Float> {
        final /* synthetic */ Ref.FloatRef $maxPx;
        final /* synthetic */ Ref.FloatRef $minPx;
        final /* synthetic */ ClosedFloatingPointRange<Float> $valueRange;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(ClosedFloatingPointRange<Float> closedFloatingPointRange, Ref.FloatRef floatRef, Ref.FloatRef floatRef2) {
            super(1, Intrinsics.Kotlin.class, "scaleToOffset", "invoke$scaleToOffset(Lkotlin/ranges/ClosedFloatingPointRange;Lkotlin/jvm/internal/Ref$FloatRef;Lkotlin/jvm/internal/Ref$FloatRef;F)F", 0);
            this.$valueRange = closedFloatingPointRange;
            this.$minPx = floatRef;
            this.$maxPx = floatRef2;
        }

        public final Float invoke(float f) {
            return Float.valueOf(SliderKt$RangeSlider$2.invoke$scaleToOffset(this.$valueRange, this.$minPx, this.$maxPx, f));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Float invoke(Float f) {
            return invoke(f.floatValue());
        }
    }
}
