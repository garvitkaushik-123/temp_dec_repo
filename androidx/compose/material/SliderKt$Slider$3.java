package androidx.compose.material;

import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.Orientation;
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
import com.vungle.ads.internal.protos.Sdk;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
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
final class SliderKt$Slider$3 extends Lambda implements Function3<BoxWithConstraintsScope, Composer, Integer, Unit> {
    final /* synthetic */ SliderColors $colors;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ Function0<Unit> $onValueChangeFinished;
    final /* synthetic */ State<Function1<Float, Unit>> $onValueChangeState;
    final /* synthetic */ List<Float> $tickFractions;
    final /* synthetic */ float $value;
    final /* synthetic */ ClosedFloatingPointRange<Float> $valueRange;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    SliderKt$Slider$3(ClosedFloatingPointRange<Float> closedFloatingPointRange, float f, MutableInteractionSource mutableInteractionSource, boolean z, List<Float> list, SliderColors sliderColors, State<? extends Function1<? super Float, Unit>> state, Function0<Unit> function0) {
        super(3);
        this.$valueRange = closedFloatingPointRange;
        this.$value = f;
        this.$interactionSource = mutableInteractionSource;
        this.$enabled = z;
        this.$tickFractions = list;
        this.$colors = sliderColors;
        this.$onValueChangeState = state;
        this.$onValueChangeFinished = function0;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer, Integer num) {
        invoke(boxWithConstraintsScope, composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer, int i) {
        BoxWithConstraintsScope boxWithConstraintsScope2;
        int i2;
        MutableFloatState mutableFloatState;
        Ref.FloatRef floatRef;
        Ref.FloatRef floatRef2;
        Modifier sliderTapModifier;
        float calcFraction;
        ComposerKt.sourceInformation(composer, "C179@8337L7,*184@8498L7,195@8912L24,196@8961L54,197@9042L36,199@9109L392,208@9511L83,210@9627L623,246@11085L209:Slider.kt#jmzs0o");
        if ((i & 14) == 0) {
            boxWithConstraintsScope2 = boxWithConstraintsScope;
            i2 = i | (composer.changed(boxWithConstraintsScope2) ? 4 : 2);
        } else {
            boxWithConstraintsScope2 = boxWithConstraintsScope;
            i2 = i;
        }
        if ((i2 & 91) == 18 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2085116814, i2, -1, "androidx.compose.material.Slider.<anonymous> (Slider.kt:179)");
        }
        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(localLayoutDirection);
        ComposerKt.sourceInformationMarkerEnd(composer);
        boolean z = consume == LayoutDirection.Rtl;
        float m6345getMaxWidthimpl = Constraints.m6345getMaxWidthimpl(boxWithConstraintsScope2.mo815getConstraintsmsEJaDk());
        final Ref.FloatRef floatRef3 = new Ref.FloatRef();
        final Ref.FloatRef floatRef4 = new Ref.FloatRef();
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume2 = composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd(composer);
        Density density = (Density) consume2;
        floatRef3.element = Math.max(m6345getMaxWidthimpl - density.mo630toPx0680j_4(SliderKt.getThumbRadius()), 0.0f);
        floatRef4.element = Math.min(density.mo630toPx0680j_4(SliderKt.getThumbRadius()), floatRef3.element);
        composer.startReplaceableGroup(773894976);
        ComposerKt.sourceInformation(composer, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
        composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            Object compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer));
            composer.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
            rememberedValue = compositionScopedCoroutineScopeCanceller;
        }
        composer.endReplaceableGroup();
        final CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
        composer.endReplaceableGroup();
        float f = this.$value;
        ClosedFloatingPointRange<Float> closedFloatingPointRange = this.$valueRange;
        composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
        Object rememberedValue2 = composer.rememberedValue();
        if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
            rememberedValue2 = PrimitiveSnapshotStateKt.mutableFloatStateOf(invoke$scaleToOffset(closedFloatingPointRange, floatRef4, floatRef3, f));
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceableGroup();
        final MutableFloatState mutableFloatState2 = (MutableFloatState) rememberedValue2;
        composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
        Object rememberedValue3 = composer.rememberedValue();
        if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
            rememberedValue3 = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
            composer.updateRememberedValue(rememberedValue3);
        }
        composer.endReplaceableGroup();
        final MutableFloatState mutableFloatState3 = (MutableFloatState) rememberedValue3;
        Object valueOf = Float.valueOf(floatRef4.element);
        Object valueOf2 = Float.valueOf(floatRef3.element);
        final ClosedFloatingPointRange<Float> closedFloatingPointRange2 = this.$valueRange;
        final State<Function1<Float, Unit>> state = this.$onValueChangeState;
        composer.startReplaceableGroup(1618982084);
        ComposerKt.sourceInformation(composer, "CC(remember)P(1,2,3):Composables.kt#9igjgp");
        boolean changed = composer.changed(valueOf) | composer.changed(valueOf2) | composer.changed(closedFloatingPointRange2);
        Object rememberedValue4 = composer.rememberedValue();
        if (changed || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
            mutableFloatState = mutableFloatState3;
            floatRef = floatRef4;
            floatRef2 = floatRef3;
            rememberedValue4 = new SliderDraggableState(new Function1<Float, Unit>() { // from class: androidx.compose.material.SliderKt$Slider$3$draggableState$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Float f2) {
                    invoke(f2.floatValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(float f2) {
                    float invoke$scaleToUserValue;
                    MutableFloatState mutableFloatState4 = MutableFloatState.this;
                    mutableFloatState4.setFloatValue(mutableFloatState4.getFloatValue() + f2 + mutableFloatState3.getFloatValue());
                    mutableFloatState3.setFloatValue(0.0f);
                    float coerceIn = RangesKt.coerceIn(MutableFloatState.this.getFloatValue(), floatRef4.element, floatRef3.element);
                    Function1<Float, Unit> value = state.getValue();
                    invoke$scaleToUserValue = SliderKt$Slider$3.invoke$scaleToUserValue(floatRef4, floatRef3, closedFloatingPointRange2, coerceIn);
                    value.invoke(Float.valueOf(invoke$scaleToUserValue));
                }
            });
            composer.updateRememberedValue(rememberedValue4);
        } else {
            floatRef2 = floatRef3;
            floatRef = floatRef4;
            mutableFloatState = mutableFloatState3;
        }
        composer.endReplaceableGroup();
        final SliderDraggableState sliderDraggableState = (SliderDraggableState) rememberedValue4;
        SliderKt.CorrectValueSideEffect(new AnonymousClass2(this.$valueRange, floatRef, floatRef2), this.$valueRange, RangesKt.rangeTo(floatRef.element, floatRef2.element), mutableFloatState2, this.$value, composer, 3072);
        final List<Float> list = this.$tickFractions;
        final Function0<Unit> function0 = this.$onValueChangeFinished;
        final Ref.FloatRef floatRef5 = floatRef2;
        final Ref.FloatRef floatRef6 = floatRef;
        State rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(new Function1<Float, Unit>() { // from class: androidx.compose.material.SliderKt$Slider$3$gestureEndAction$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Float f2) {
                invoke(f2.floatValue());
                return Unit.INSTANCE;
            }

            public final void invoke(float f2) {
                float snapValueToTick;
                Function0<Unit> function02;
                float floatValue = MutableFloatState.this.getFloatValue();
                snapValueToTick = SliderKt.snapValueToTick(floatValue, list, floatRef6.element, floatRef5.element);
                if (floatValue != snapValueToTick) {
                    BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass1(sliderDraggableState, floatValue, snapValueToTick, f2, function0, null), 3, null);
                } else {
                    if (sliderDraggableState.isDragging() || (function02 = function0) == null) {
                        return;
                    }
                    function02.invoke();
                }
            }

            /* compiled from: Slider.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.material.SliderKt$Slider$3$gestureEndAction$1$1", f = "Slider.kt", i = {}, l = {Sdk.SDKError.Reason.AD_RESPONSE_INVALID_TEMPLATE_TYPE_VALUE}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: androidx.compose.material.SliderKt$Slider$3$gestureEndAction$1$1, reason: invalid class name */
            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ float $current;
                final /* synthetic */ SliderDraggableState $draggableState;
                final /* synthetic */ Function0<Unit> $onValueChangeFinished;
                final /* synthetic */ float $target;
                final /* synthetic */ float $velocity;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(SliderDraggableState sliderDraggableState, float f, float f2, float f3, Function0<Unit> function0, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.$draggableState = sliderDraggableState;
                    this.$current = f;
                    this.$target = f2;
                    this.$velocity = f3;
                    this.$onValueChangeFinished = function0;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass1(this.$draggableState, this.$current, this.$target, this.$velocity, this.$onValueChangeFinished, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object animateToTarget;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        this.label = 1;
                        animateToTarget = SliderKt.animateToTarget(this.$draggableState, this.$current, this.$target, this.$velocity, this);
                        if (animateToTarget == coroutine_suspended) {
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
        SliderDraggableState sliderDraggableState2 = sliderDraggableState;
        sliderTapModifier = SliderKt.sliderTapModifier(Modifier.INSTANCE, sliderDraggableState2, this.$interactionSource, m6345getMaxWidthimpl, z, mutableFloatState2, rememberUpdatedState, mutableFloatState, this.$enabled);
        Modifier.Companion companion = Modifier.INSTANCE;
        Orientation orientation = Orientation.Horizontal;
        boolean isDragging = sliderDraggableState.isDragging();
        Modifier.Companion companion2 = companion;
        boolean z2 = this.$enabled;
        boolean z3 = z;
        MutableInteractionSource mutableInteractionSource = this.$interactionSource;
        composer.startReplaceableGroup(17274857);
        boolean changed2 = composer.changed(rememberUpdatedState);
        Object rememberedValue5 = composer.rememberedValue();
        if (changed2 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
            rememberedValue5 = (Function3) new SliderKt$Slider$3$drag$1$1(rememberUpdatedState, null);
            composer.updateRememberedValue(rememberedValue5);
        }
        composer.endReplaceableGroup();
        Modifier draggable$default = DraggableKt.draggable$default(companion2, sliderDraggableState2, orientation, z2, mutableInteractionSource, isDragging, null, (Function3) rememberedValue5, z3, 32, null);
        calcFraction = SliderKt.calcFraction(this.$valueRange.getStart().floatValue(), this.$valueRange.getEndInclusive().floatValue(), RangesKt.coerceIn(this.$value, this.$valueRange.getStart().floatValue(), this.$valueRange.getEndInclusive().floatValue()));
        SliderKt.SliderImpl(this.$enabled, calcFraction, this.$tickFractions, this.$colors, floatRef5.element - floatRef6.element, this.$interactionSource, sliderTapModifier.then(draggable$default), composer, 512);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float invoke$scaleToUserValue(Ref.FloatRef floatRef, Ref.FloatRef floatRef2, ClosedFloatingPointRange<Float> closedFloatingPointRange, float f) {
        float scale;
        scale = SliderKt.scale(floatRef.element, floatRef2.element, f, closedFloatingPointRange.getStart().floatValue(), closedFloatingPointRange.getEndInclusive().floatValue());
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
    /* renamed from: androidx.compose.material.SliderKt$Slider$3$2, reason: invalid class name */
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
            return Float.valueOf(SliderKt$Slider$3.invoke$scaleToOffset(this.$valueRange, this.$minPx, this.$maxPx, f));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Float invoke(Float f) {
            return invoke(f.floatValue());
        }
    }
}
