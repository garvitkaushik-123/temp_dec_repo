package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.rewardedcountdowntimer;

import adn.analytics.Analytics;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.profileinstaller.ProfileVerifier;
import com.google.android.exoplayer2.C;
import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.UInt;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: classes6.dex */
public final class c {

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.rewardedcountdowntimer.RewardedCountDownTimerKt$RewardedCountDownTimer$1$1", f = "RewardedCountDownTimer.kt", i = {}, l = {Analytics.AnalyticsData.BOOT_TIME_FIELD_NUMBER, 84, 96}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f6029a;
        public final /* synthetic */ Animatable<Float, AnimationVector1D> b;
        public final /* synthetic */ float c;
        public final /* synthetic */ int d;
        public final /* synthetic */ MutableState<Boolean> e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Animatable<Float, AnimationVector1D> animatable, float f, int i, MutableState<Boolean> mutableState, Continuation<? super a> continuation) {
            super(2, continuation);
            this.b = animatable;
            this.c = f;
            this.d = i;
            this.e = mutableState;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new a(this.b, this.c, this.d, this.e, continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:25:0x0083, code lost:
        
            if (androidx.compose.animation.core.Animatable.animateTo$default(r5, r6, r7, null, null, r13, 12, null) == r0) goto L31;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x0092, code lost:
        
            if (r14.stop(r13) == r0) goto L31;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f6029a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Animatable<Float, AnimationVector1D> animatable = this.b;
                Float boxFloat = Boxing.boxFloat(this.c);
                this.f6029a = 1;
                if (animatable.snapTo(boxFloat, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    if (i == 2) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        if (i != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
            }
            if (!c.a(this.e) || this.b.getValue().floatValue() <= 0.0f) {
                Animatable<Float, AnimationVector1D> animatable2 = this.b;
                this.f6029a = 3;
            } else {
                long m10336constructorimpl = UInt.m10336constructorimpl(this.d * 1000) & 4294967295L;
                Animatable<Float, AnimationVector1D> animatable3 = this.b;
                Float boxFloat2 = Boxing.boxFloat(0.0f);
                TweenSpec tween$default = AnimationSpecKt.tween$default((int) m10336constructorimpl, 0, EasingKt.getLinearEasing(), 2, null);
                this.f6029a = 2;
                try {
                } catch (CancellationException unused) {
                    Unit unit = Unit.INSTANCE;
                    return Unit.INSTANCE;
                }
            }
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.rewardedcountdowntimer.RewardedCountDownTimerKt$RewardedCountDownTimer$2$1", f = "RewardedCountDownTimer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f6030a;
        public final /* synthetic */ int b;
        public final /* synthetic */ Function0<Unit> c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(int i, Function0<Unit> function0, Continuation<? super b> continuation) {
            super(2, continuation);
            this.b = i;
            this.c = function0;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new b(this.b, this.c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f6030a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            if (this.b == 0) {
                this.c.invoke();
            }
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.rewardedcountdowntimer.RewardedCountDownTimerKt$RewardedCountDownTimer$3$1$observer$1$1", f = "RewardedCountDownTimer.kt", i = {}, l = {112}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.rewardedcountdowntimer.c$c, reason: collision with other inner class name */
    public static final class C0520c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f6031a;
        public final /* synthetic */ Animatable<Float, AnimationVector1D> b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0520c(Animatable<Float, AnimationVector1D> animatable, Continuation<? super C0520c> continuation) {
            super(2, continuation);
            this.b = animatable;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C0520c) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C0520c(this.b, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f6031a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Animatable<Float, AnimationVector1D> animatable = this.b;
                this.f6031a = 1;
                if (animatable.stop(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public static final class d implements DisposableEffectResult {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LifecycleOwner f6032a;
        public final /* synthetic */ LifecycleEventObserver b;

        public d(LifecycleOwner lifecycleOwner, LifecycleEventObserver lifecycleEventObserver) {
            this.f6032a = lifecycleOwner;
            this.b = lifecycleEventObserver;
        }

        @Override // androidx.compose.runtime.DisposableEffectResult
        public void dispose() {
            this.f6032a.getLifecycle().removeObserver(this.b);
        }
    }

    public /* synthetic */ class e {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6033a;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            try {
                iArr[Lifecycle.Event.ON_STOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Lifecycle.Event.ON_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f6033a = iArr;
        }
    }

    public static final Unit a(long j, long j2, Modifier modifier, float f, float f2, Function0 function0, LifecycleOwner lifecycleOwner, CoroutineScope coroutineScope, int i, int i2, int i3, int i4, Composer composer, int i5) {
        a(j, j2, modifier, f, f2, function0, lifecycleOwner, coroutineScope, i, i2, composer, i3 | 1, i4);
        return Unit.INSTANCE;
    }

    public static final Unit b(String str, SemanticsPropertyReceiver semantics) {
        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
        SemanticsPropertiesKt.setContentDescription(semantics, str);
        SemanticsPropertiesKt.setTestTag(semantics, str);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x042c  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x055f  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0430  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x028d  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0420  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void a(final long j, final long j2, Modifier modifier, float f, float f2, final Function0<Unit> onTimerFinish, LifecycleOwner lifecycleOwner, CoroutineScope coroutineScope, final int i, final int i2, Composer composer, final int i3, final int i4) {
        int i5;
        Modifier modifier2;
        int i6;
        float f3;
        int i7;
        Modifier modifier3;
        float m6389constructorimpl;
        LifecycleOwner lifecycleOwner2;
        LifecycleOwner lifecycleOwner3;
        CoroutineScope coroutineScope2;
        int i8;
        float f4;
        float f5;
        boolean changed;
        Object rememberedValue;
        MutableState mutableState;
        Object rememberedValue2;
        Composer.Companion companion;
        LifecycleOwner lifecycleOwner4;
        float coerceAtMost;
        Object rememberedValue3;
        Object obj;
        Animatable animatable;
        UInt m10330boximpl;
        boolean changed2;
        Object aVar;
        float f6;
        float f7;
        UInt uInt;
        final CoroutineScope coroutineScope3;
        Continuation continuation;
        final LifecycleOwner lifecycleOwner5;
        final MutableState mutableState2;
        final Animatable animatable2;
        int i9;
        boolean changed3;
        Object rememberedValue4;
        boolean changed4;
        Object rememberedValue5;
        boolean changed5;
        Object rememberedValue6;
        final float f8;
        boolean changed6;
        Object rememberedValue7;
        CoroutineScope coroutineScope4;
        float f9;
        Modifier modifier4;
        Composer composer2;
        Object obj2;
        boolean z;
        float f10;
        boolean changed7;
        Object rememberedValue8;
        Composer composer3;
        final CoroutineScope coroutineScope5;
        final Modifier modifier5;
        final float f11;
        final float f12;
        final LifecycleOwner lifecycleOwner6;
        int i10;
        Intrinsics.checkNotNullParameter(onTimerFinish, "onTimerFinish");
        Composer startRestartGroup = composer.startRestartGroup(806078257);
        if ((i4 & 1) != 0) {
            i5 = i3 | 6;
        } else if ((i3 & 6) == 0) {
            i5 = (startRestartGroup.changed(j) ? 4 : 2) | i3;
        } else {
            i5 = i3;
        }
        if ((i4 & 2) != 0) {
            i5 |= 48;
        } else if ((i3 & 48) == 0) {
            i5 |= startRestartGroup.changed(j2) ? 32 : 16;
        }
        int i11 = i4 & 4;
        if (i11 != 0) {
            i5 |= 384;
        } else if ((i3 & 384) == 0) {
            modifier2 = modifier;
            i5 |= startRestartGroup.changed(modifier2) ? 256 : 128;
            i6 = i4 & 8;
            if (i6 == 0) {
                i5 |= 3072;
            } else if ((i3 & 3072) == 0) {
                f3 = f;
                i5 |= startRestartGroup.changed(f3) ? 2048 : 1024;
                i7 = i4 & 16;
                if (i7 != 0) {
                    i5 |= 24576;
                } else if ((i3 & 24576) == 0) {
                    i5 |= startRestartGroup.changed(f2) ? 16384 : 8192;
                    if ((i4 & 32) == 0) {
                        i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        i5 |= startRestartGroup.changed(onTimerFinish) ? 131072 : 65536;
                    }
                    if ((i3 & 1572864) == 0) {
                        i5 |= ((i4 & 64) == 0 && startRestartGroup.changed(lifecycleOwner)) ? 1048576 : 524288;
                    }
                    if ((i3 & 12582912) == 0) {
                        if ((i4 & 128) == 0 && startRestartGroup.changed(coroutineScope)) {
                            i10 = 8388608;
                            i5 |= i10;
                        }
                        i10 = 4194304;
                        i5 |= i10;
                    }
                    if ((i4 & 256) == 0) {
                        i5 |= 100663296;
                    } else if ((i3 & 100663296) == 0) {
                        i5 |= startRestartGroup.changed(i) ? 67108864 : 33554432;
                    }
                    if ((i4 & 512) == 0) {
                        i5 |= C.ENCODING_PCM_32BIT;
                    } else if ((i3 & C.ENCODING_PCM_32BIT) == 0) {
                        i5 |= startRestartGroup.changed(i2) ? 536870912 : 268435456;
                    }
                    int i12 = i5;
                    if ((306783379 & i5) == 306783378 || !startRestartGroup.getSkipping()) {
                        startRestartGroup.startDefaults();
                        if ((i3 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                            modifier3 = i11 == 0 ? Modifier.INSTANCE : modifier2;
                            if (i6 != 0) {
                                f3 = Dp.m6389constructorimpl(7);
                            }
                            m6389constructorimpl = i7 == 0 ? Dp.m6389constructorimpl(30) : f2;
                            if ((i4 & 64) == 0) {
                                lifecycleOwner2 = (LifecycleOwner) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner());
                                i12 &= -3670017;
                            } else {
                                lifecycleOwner2 = lifecycleOwner;
                            }
                            if ((i4 & 128) == 0) {
                                startRestartGroup.startReplaceableGroup(773894976);
                                startRestartGroup.startReplaceableGroup(-492369756);
                                Object rememberedValue9 = startRestartGroup.rememberedValue();
                                if (rememberedValue9 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue9 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup));
                                    startRestartGroup.updateRememberedValue(rememberedValue9);
                                }
                                startRestartGroup.endReplaceableGroup();
                                CoroutineScope coroutineScope6 = ((CompositionScopedCoroutineScopeCanceller) rememberedValue9).getCoroutineScope();
                                startRestartGroup.endReplaceableGroup();
                                LifecycleOwner lifecycleOwner7 = lifecycleOwner2;
                                coroutineScope2 = coroutineScope6;
                                lifecycleOwner3 = lifecycleOwner7;
                                i8 = i12 & (-29360129);
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    f4 = f3;
                                    f5 = m6389constructorimpl;
                                } else {
                                    f4 = f3;
                                    f5 = m6389constructorimpl;
                                    ComposerKt.traceEventStart(806078257, i8, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.rewardedcountdowntimer.RewardedCountDownTimer (RewardedCountDownTimer.kt:65)");
                                }
                                startRestartGroup.startReplaceableGroup(1215962344);
                                changed = startRestartGroup.changed(lifecycleOwner3);
                                rememberedValue = startRestartGroup.rememberedValue();
                                if (!changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                    MutableState mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
                                    startRestartGroup.updateRememberedValue(mutableStateOf$default);
                                    rememberedValue = mutableStateOf$default;
                                }
                                mutableState = (MutableState) rememberedValue;
                                startRestartGroup.endReplaceableGroup();
                                Object[] objArr = new Object[0];
                                startRestartGroup.startReplaceableGroup(1215965773);
                                rememberedValue2 = startRestartGroup.rememberedValue();
                                companion = Composer.INSTANCE;
                                lifecycleOwner4 = lifecycleOwner3;
                                if (rememberedValue2 == companion.getEmpty()) {
                                    rememberedValue2 = new Function0() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.rewardedcountdowntimer.c$$ExternalSyntheticLambda0
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            return c.a();
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(rememberedValue2);
                                }
                                startRestartGroup.endReplaceableGroup();
                                MutableState mutableState3 = (MutableState) RememberSaveableKt.m3680rememberSaveable(objArr, (Saver) null, (String) null, (Function0) rememberedValue2, startRestartGroup, 3072, 6);
                                coerceAtMost = RangesKt.coerceAtMost(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.rewardedcountdowntimer.a.a(i2, i), b(mutableState3));
                                startRestartGroup.startReplaceableGroup(1215971412);
                                rememberedValue3 = startRestartGroup.rememberedValue();
                                int i13 = i8;
                                if (rememberedValue3 != companion.getEmpty()) {
                                    obj = AnimatableKt.Animatable$default(coerceAtMost, 0.0f, 2, null);
                                    startRestartGroup.updateRememberedValue(obj);
                                } else {
                                    obj = rememberedValue3;
                                }
                                animatable = (Animatable) obj;
                                startRestartGroup.endReplaceableGroup();
                                a((MutableState<Float>) mutableState3, ((Number) animatable.getValue()).floatValue());
                                Boolean valueOf = Boolean.valueOf(a(mutableState));
                                m10330boximpl = UInt.m10330boximpl(i2);
                                startRestartGroup.startReplaceableGroup(1215976719);
                                changed2 = startRestartGroup.changed(animatable) | startRestartGroup.changed(coerceAtMost) | startRestartGroup.changed(mutableState) | startRestartGroup.changed(i2);
                                Object rememberedValue10 = startRestartGroup.rememberedValue();
                                if (!changed2 || rememberedValue10 == companion.getEmpty()) {
                                    f6 = f4;
                                    f7 = f5;
                                    uInt = m10330boximpl;
                                    coroutineScope3 = coroutineScope2;
                                    continuation = null;
                                    lifecycleOwner5 = lifecycleOwner4;
                                    mutableState2 = mutableState;
                                    aVar = new a(animatable, coerceAtMost, i2, mutableState2, null);
                                    animatable2 = animatable;
                                    i9 = i2;
                                    startRestartGroup.updateRememberedValue(aVar);
                                } else {
                                    f6 = f4;
                                    f7 = f5;
                                    uInt = m10330boximpl;
                                    coroutineScope3 = coroutineScope2;
                                    animatable2 = animatable;
                                    continuation = null;
                                    aVar = rememberedValue10;
                                    mutableState2 = mutableState;
                                    i9 = i2;
                                    lifecycleOwner5 = lifecycleOwner4;
                                }
                                startRestartGroup.endReplaceableGroup();
                                EffectsKt.LaunchedEffect(valueOf, uInt, (Function2) aVar, startRestartGroup, (i13 >> 24) & 112);
                                UInt m10330boximpl2 = UInt.m10330boximpl(i9);
                                startRestartGroup.startReplaceableGroup(1216002114);
                                changed3 = startRestartGroup.changed(i9) | startRestartGroup.changed(onTimerFinish);
                                rememberedValue4 = startRestartGroup.rememberedValue();
                                if (!changed3 || rememberedValue4 == companion.getEmpty()) {
                                    rememberedValue4 = new b(i9, onTimerFinish, continuation);
                                    startRestartGroup.updateRememberedValue(rememberedValue4);
                                }
                                startRestartGroup.endReplaceableGroup();
                                EffectsKt.LaunchedEffect(m10330boximpl2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue4, startRestartGroup, (i13 >> 27) & 14);
                                startRestartGroup.startReplaceableGroup(1216006815);
                                changed4 = startRestartGroup.changed(mutableState2) | startRestartGroup.changed(coroutineScope3) | startRestartGroup.changed(animatable2) | startRestartGroup.changed(lifecycleOwner5);
                                rememberedValue5 = startRestartGroup.rememberedValue();
                                if (!changed4 || rememberedValue5 == companion.getEmpty()) {
                                    rememberedValue5 = new Function1() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.rewardedcountdowntimer.c$$ExternalSyntheticLambda1
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj3) {
                                            return c.a(LifecycleOwner.this, coroutineScope3, animatable2, mutableState2, (DisposableEffectScope) obj3);
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(rememberedValue5);
                                }
                                startRestartGroup.endReplaceableGroup();
                                EffectsKt.DisposableEffect(lifecycleOwner5, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) rememberedValue5, startRestartGroup, (i13 >> 18) & 14);
                                Alignment center = Alignment.INSTANCE.getCenter();
                                Modifier m526backgroundbw27NRU = BackgroundKt.m526backgroundbw27NRU(ClipKt.clip(SizeKt.m928size3ABfNKs(modifier3, f7), RoundedCornerShapeKt.m1149RoundedCornerShape0680j_4(Dp.m6389constructorimpl(20))), Color.m4062copywmQWz5c$default(Color.INSTANCE.m4100getWhite0d7_KjU(), 0.9f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.getCircleShape());
                                startRestartGroup.startReplaceableGroup(1216040072);
                                final String str = "timer_container";
                                changed5 = startRestartGroup.changed("timer_container");
                                rememberedValue6 = startRestartGroup.rememberedValue();
                                if (!changed5 || rememberedValue6 == companion.getEmpty()) {
                                    rememberedValue6 = new Function1() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.rewardedcountdowntimer.c$$ExternalSyntheticLambda2
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj3) {
                                            return c.a(str, (SemanticsPropertyReceiver) obj3);
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(rememberedValue6);
                                }
                                startRestartGroup.endReplaceableGroup();
                                Modifier semantics$default = SemanticsModifierKt.semantics$default(m526backgroundbw27NRU, false, (Function1) rememberedValue6, 1, continuation);
                                startRestartGroup.startReplaceableGroup(733328855);
                                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, startRestartGroup, 6);
                                startRestartGroup.startReplaceableGroup(-1323940314);
                                Density density = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                                LayoutDirection layoutDirection = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                ViewConfiguration viewConfiguration = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                                Function0<ComposeUiNode> constructor = companion2.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(semantics$default);
                                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                startRestartGroup.startReusableNode();
                                if (startRestartGroup.getInserting()) {
                                    startRestartGroup.useNode();
                                } else {
                                    startRestartGroup.createNode(constructor);
                                }
                                startRestartGroup.disableReusing();
                                Composer m3593constructorimpl = Updater.m3593constructorimpl(startRestartGroup);
                                Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, companion2.getSetMeasurePolicy());
                                Updater.m3600setimpl(m3593constructorimpl, density, companion2.getSetDensity());
                                Updater.m3600setimpl(m3593constructorimpl, layoutDirection, companion2.getSetLayoutDirection());
                                Updater.m3600setimpl(m3593constructorimpl, viewConfiguration, companion2.getSetViewConfiguration());
                                startRestartGroup.enableReusing();
                                materializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
                                startRestartGroup.startReplaceableGroup(2058660585);
                                startRestartGroup.startReplaceableGroup(-2137368960);
                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                Modifier.Companion companion3 = Modifier.INSTANCE;
                                Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(companion3, 0.0f, 1, null);
                                startRestartGroup.startReplaceableGroup(1205646178);
                                f8 = f6;
                                changed6 = startRestartGroup.changed(j) | startRestartGroup.changed(f8) | startRestartGroup.changed(animatable2) | startRestartGroup.changed(j2);
                                rememberedValue7 = startRestartGroup.rememberedValue();
                                if (!changed6 || rememberedValue7 == companion.getEmpty()) {
                                    coroutineScope4 = coroutineScope3;
                                    f9 = f7;
                                    modifier4 = modifier3;
                                    final Animatable animatable3 = animatable2;
                                    composer2 = startRestartGroup;
                                    obj2 = null;
                                    z = false;
                                    rememberedValue7 = new Function1() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.rewardedcountdowntimer.c$$ExternalSyntheticLambda3
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj3) {
                                            return c.a(j, f8, animatable3, j2, (DrawScope) obj3);
                                        }
                                    };
                                    f10 = f8;
                                    composer2.updateRememberedValue(rememberedValue7);
                                } else {
                                    f10 = f8;
                                    coroutineScope4 = coroutineScope3;
                                    f9 = f7;
                                    modifier4 = modifier3;
                                    composer2 = startRestartGroup;
                                    obj2 = null;
                                    z = false;
                                }
                                composer2.endReplaceableGroup();
                                CanvasKt.Canvas(fillMaxSize$default, (Function1) rememberedValue7, composer2, 6);
                                String unsignedString = Integer.toUnsignedString(i9);
                                TextStyle button = MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getButton();
                                long d2 = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.a.d();
                                int m6281getCentere0LSkKk = TextAlign.INSTANCE.m6281getCentere0LSkKk();
                                composer2.startReplaceableGroup(1205681512);
                                final String str2 = "countdown_timer_text";
                                changed7 = composer2.changed("countdown_timer_text");
                                rememberedValue8 = composer2.rememberedValue();
                                if (!changed7 || rememberedValue8 == companion.getEmpty()) {
                                    rememberedValue8 = new Function1() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.rewardedcountdowntimer.c$$ExternalSyntheticLambda4
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj3) {
                                            return c.b(str2, (SemanticsPropertyReceiver) obj3);
                                        }
                                    };
                                    composer2.updateRememberedValue(rememberedValue8);
                                }
                                composer2.endReplaceableGroup();
                                LifecycleOwner lifecycleOwner8 = lifecycleOwner5;
                                composer3 = composer2;
                                TextKt.m1844TextfLXpl1I(unsignedString, SemanticsModifierKt.semantics$default(companion3, z, (Function1) rememberedValue8, 1, obj2), j2, d2, null, null, null, 0L, null, TextAlign.m6274boximpl(m6281getCentere0LSkKk), 0L, 0, false, 1, null, button, composer3, ((i13 << 3) & 896) | 3072, 3072, 24048);
                                composer3.endReplaceableGroup();
                                composer3.endReplaceableGroup();
                                composer3.endNode();
                                composer3.endReplaceableGroup();
                                composer3.endReplaceableGroup();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                coroutineScope5 = coroutineScope4;
                                modifier5 = modifier4;
                                f11 = f9;
                                f12 = f10;
                                lifecycleOwner6 = lifecycleOwner8;
                            } else {
                                lifecycleOwner3 = lifecycleOwner2;
                            }
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            if ((i4 & 64) != 0) {
                                i12 &= -3670017;
                            }
                            if ((i4 & 128) != 0) {
                                i12 &= -29360129;
                            }
                            m6389constructorimpl = f2;
                            lifecycleOwner3 = lifecycleOwner;
                            modifier3 = modifier2;
                        }
                        i8 = i12;
                        coroutineScope2 = coroutineScope;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        startRestartGroup.startReplaceableGroup(1215962344);
                        changed = startRestartGroup.changed(lifecycleOwner3);
                        rememberedValue = startRestartGroup.rememberedValue();
                        if (!changed) {
                        }
                        MutableState mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
                        startRestartGroup.updateRememberedValue(mutableStateOf$default2);
                        rememberedValue = mutableStateOf$default2;
                        mutableState = (MutableState) rememberedValue;
                        startRestartGroup.endReplaceableGroup();
                        Object[] objArr2 = new Object[0];
                        startRestartGroup.startReplaceableGroup(1215965773);
                        rememberedValue2 = startRestartGroup.rememberedValue();
                        companion = Composer.INSTANCE;
                        lifecycleOwner4 = lifecycleOwner3;
                        if (rememberedValue2 == companion.getEmpty()) {
                        }
                        startRestartGroup.endReplaceableGroup();
                        MutableState mutableState32 = (MutableState) RememberSaveableKt.m3680rememberSaveable(objArr2, (Saver) null, (String) null, (Function0) rememberedValue2, startRestartGroup, 3072, 6);
                        coerceAtMost = RangesKt.coerceAtMost(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.rewardedcountdowntimer.a.a(i2, i), b(mutableState32));
                        startRestartGroup.startReplaceableGroup(1215971412);
                        rememberedValue3 = startRestartGroup.rememberedValue();
                        int i132 = i8;
                        if (rememberedValue3 != companion.getEmpty()) {
                        }
                        animatable = (Animatable) obj;
                        startRestartGroup.endReplaceableGroup();
                        a((MutableState<Float>) mutableState32, ((Number) animatable.getValue()).floatValue());
                        Boolean valueOf2 = Boolean.valueOf(a(mutableState));
                        m10330boximpl = UInt.m10330boximpl(i2);
                        startRestartGroup.startReplaceableGroup(1215976719);
                        changed2 = startRestartGroup.changed(animatable) | startRestartGroup.changed(coerceAtMost) | startRestartGroup.changed(mutableState) | startRestartGroup.changed(i2);
                        Object rememberedValue102 = startRestartGroup.rememberedValue();
                        if (changed2) {
                        }
                        f6 = f4;
                        f7 = f5;
                        uInt = m10330boximpl;
                        coroutineScope3 = coroutineScope2;
                        continuation = null;
                        lifecycleOwner5 = lifecycleOwner4;
                        mutableState2 = mutableState;
                        aVar = new a(animatable, coerceAtMost, i2, mutableState2, null);
                        animatable2 = animatable;
                        i9 = i2;
                        startRestartGroup.updateRememberedValue(aVar);
                        startRestartGroup.endReplaceableGroup();
                        EffectsKt.LaunchedEffect(valueOf2, uInt, (Function2) aVar, startRestartGroup, (i132 >> 24) & 112);
                        UInt m10330boximpl22 = UInt.m10330boximpl(i9);
                        startRestartGroup.startReplaceableGroup(1216002114);
                        changed3 = startRestartGroup.changed(i9) | startRestartGroup.changed(onTimerFinish);
                        rememberedValue4 = startRestartGroup.rememberedValue();
                        if (!changed3) {
                        }
                        rememberedValue4 = new b(i9, onTimerFinish, continuation);
                        startRestartGroup.updateRememberedValue(rememberedValue4);
                        startRestartGroup.endReplaceableGroup();
                        EffectsKt.LaunchedEffect(m10330boximpl22, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue4, startRestartGroup, (i132 >> 27) & 14);
                        startRestartGroup.startReplaceableGroup(1216006815);
                        changed4 = startRestartGroup.changed(mutableState2) | startRestartGroup.changed(coroutineScope3) | startRestartGroup.changed(animatable2) | startRestartGroup.changed(lifecycleOwner5);
                        rememberedValue5 = startRestartGroup.rememberedValue();
                        if (!changed4) {
                        }
                        rememberedValue5 = new Function1() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.rewardedcountdowntimer.c$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj3) {
                                return c.a(LifecycleOwner.this, coroutineScope3, animatable2, mutableState2, (DisposableEffectScope) obj3);
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue5);
                        startRestartGroup.endReplaceableGroup();
                        EffectsKt.DisposableEffect(lifecycleOwner5, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) rememberedValue5, startRestartGroup, (i132 >> 18) & 14);
                        Alignment center2 = Alignment.INSTANCE.getCenter();
                        Modifier m526backgroundbw27NRU2 = BackgroundKt.m526backgroundbw27NRU(ClipKt.clip(SizeKt.m928size3ABfNKs(modifier3, f7), RoundedCornerShapeKt.m1149RoundedCornerShape0680j_4(Dp.m6389constructorimpl(20))), Color.m4062copywmQWz5c$default(Color.INSTANCE.m4100getWhite0d7_KjU(), 0.9f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.getCircleShape());
                        startRestartGroup.startReplaceableGroup(1216040072);
                        final String str3 = "timer_container";
                        changed5 = startRestartGroup.changed("timer_container");
                        rememberedValue6 = startRestartGroup.rememberedValue();
                        if (!changed5) {
                        }
                        rememberedValue6 = new Function1() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.rewardedcountdowntimer.c$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj3) {
                                return c.a(str3, (SemanticsPropertyReceiver) obj3);
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue6);
                        startRestartGroup.endReplaceableGroup();
                        Modifier semantics$default2 = SemanticsModifierKt.semantics$default(m526backgroundbw27NRU2, false, (Function1) rememberedValue6, 1, continuation);
                        startRestartGroup.startReplaceableGroup(733328855);
                        MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(center2, false, startRestartGroup, 6);
                        startRestartGroup.startReplaceableGroup(-1323940314);
                        Density density2 = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                        LayoutDirection layoutDirection2 = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                        ViewConfiguration viewConfiguration2 = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                        ComposeUiNode.Companion companion22 = ComposeUiNode.INSTANCE;
                        Function0<ComposeUiNode> constructor2 = companion22.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf2 = LayoutKt.materializerOf(semantics$default2);
                        if (!(startRestartGroup.getApplier() instanceof Applier)) {
                        }
                        startRestartGroup.startReusableNode();
                        if (startRestartGroup.getInserting()) {
                        }
                        startRestartGroup.disableReusing();
                        Composer m3593constructorimpl2 = Updater.m3593constructorimpl(startRestartGroup);
                        Updater.m3600setimpl(m3593constructorimpl2, rememberBoxMeasurePolicy2, companion22.getSetMeasurePolicy());
                        Updater.m3600setimpl(m3593constructorimpl2, density2, companion22.getSetDensity());
                        Updater.m3600setimpl(m3593constructorimpl2, layoutDirection2, companion22.getSetLayoutDirection());
                        Updater.m3600setimpl(m3593constructorimpl2, viewConfiguration2, companion22.getSetViewConfiguration());
                        startRestartGroup.enableReusing();
                        materializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
                        startRestartGroup.startReplaceableGroup(2058660585);
                        startRestartGroup.startReplaceableGroup(-2137368960);
                        BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                        Modifier.Companion companion32 = Modifier.INSTANCE;
                        Modifier fillMaxSize$default2 = SizeKt.fillMaxSize$default(companion32, 0.0f, 1, null);
                        startRestartGroup.startReplaceableGroup(1205646178);
                        f8 = f6;
                        changed6 = startRestartGroup.changed(j) | startRestartGroup.changed(f8) | startRestartGroup.changed(animatable2) | startRestartGroup.changed(j2);
                        rememberedValue7 = startRestartGroup.rememberedValue();
                        if (changed6) {
                        }
                        coroutineScope4 = coroutineScope3;
                        f9 = f7;
                        modifier4 = modifier3;
                        final Animatable animatable32 = animatable2;
                        composer2 = startRestartGroup;
                        obj2 = null;
                        z = false;
                        rememberedValue7 = new Function1() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.rewardedcountdowntimer.c$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj3) {
                                return c.a(j, f8, animatable32, j2, (DrawScope) obj3);
                            }
                        };
                        f10 = f8;
                        composer2.updateRememberedValue(rememberedValue7);
                        composer2.endReplaceableGroup();
                        CanvasKt.Canvas(fillMaxSize$default2, (Function1) rememberedValue7, composer2, 6);
                        String unsignedString2 = Integer.toUnsignedString(i9);
                        TextStyle button2 = MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getButton();
                        long d22 = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.a.d();
                        int m6281getCentere0LSkKk2 = TextAlign.INSTANCE.m6281getCentere0LSkKk();
                        composer2.startReplaceableGroup(1205681512);
                        final String str22 = "countdown_timer_text";
                        changed7 = composer2.changed("countdown_timer_text");
                        rememberedValue8 = composer2.rememberedValue();
                        if (!changed7) {
                        }
                        rememberedValue8 = new Function1() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.rewardedcountdowntimer.c$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj3) {
                                return c.b(str22, (SemanticsPropertyReceiver) obj3);
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue8);
                        composer2.endReplaceableGroup();
                        LifecycleOwner lifecycleOwner82 = lifecycleOwner5;
                        composer3 = composer2;
                        TextKt.m1844TextfLXpl1I(unsignedString2, SemanticsModifierKt.semantics$default(companion32, z, (Function1) rememberedValue8, 1, obj2), j2, d22, null, null, null, 0L, null, TextAlign.m6274boximpl(m6281getCentere0LSkKk2), 0L, 0, false, 1, null, button2, composer3, ((i132 << 3) & 896) | 3072, 3072, 24048);
                        composer3.endReplaceableGroup();
                        composer3.endReplaceableGroup();
                        composer3.endNode();
                        composer3.endReplaceableGroup();
                        composer3.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        coroutineScope5 = coroutineScope4;
                        modifier5 = modifier4;
                        f11 = f9;
                        f12 = f10;
                        lifecycleOwner6 = lifecycleOwner82;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        f11 = f2;
                        lifecycleOwner6 = lifecycleOwner;
                        composer3 = startRestartGroup;
                        f12 = f3;
                        modifier5 = modifier2;
                        coroutineScope5 = coroutineScope;
                    }
                    ScopeUpdateScope endRestartGroup = composer3.endRestartGroup();
                    if (endRestartGroup != null) {
                        endRestartGroup.updateScope(new Function2() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.rewardedcountdowntimer.c$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj3, Object obj4) {
                                return c.a(j, j2, modifier5, f12, f11, onTimerFinish, lifecycleOwner6, coroutineScope5, i, i2, i3, i4, (Composer) obj3, ((Integer) obj4).intValue());
                            }
                        });
                        return;
                    }
                    return;
                }
                if ((i4 & 32) == 0) {
                }
                if ((i3 & 1572864) == 0) {
                }
                if ((i3 & 12582912) == 0) {
                }
                if ((i4 & 256) == 0) {
                }
                if ((i4 & 512) == 0) {
                }
                int i122 = i5;
                if ((306783379 & i5) == 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i3 & 1) != 0) {
                }
                if (i11 == 0) {
                }
                if (i6 != 0) {
                }
                if (i7 == 0) {
                }
                if ((i4 & 64) == 0) {
                }
                if ((i4 & 128) == 0) {
                }
            }
            f3 = f;
            i7 = i4 & 16;
            if (i7 != 0) {
            }
            if ((i4 & 32) == 0) {
            }
            if ((i3 & 1572864) == 0) {
            }
            if ((i3 & 12582912) == 0) {
            }
            if ((i4 & 256) == 0) {
            }
            if ((i4 & 512) == 0) {
            }
            int i1222 = i5;
            if ((306783379 & i5) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i3 & 1) != 0) {
            }
            if (i11 == 0) {
            }
            if (i6 != 0) {
            }
            if (i7 == 0) {
            }
            if ((i4 & 64) == 0) {
            }
            if ((i4 & 128) == 0) {
            }
        }
        modifier2 = modifier;
        i6 = i4 & 8;
        if (i6 == 0) {
        }
        f3 = f;
        i7 = i4 & 16;
        if (i7 != 0) {
        }
        if ((i4 & 32) == 0) {
        }
        if ((i3 & 1572864) == 0) {
        }
        if ((i3 & 12582912) == 0) {
        }
        if ((i4 & 256) == 0) {
        }
        if ((i4 & 512) == 0) {
        }
        int i12222 = i5;
        if ((306783379 & i5) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i3 & 1) != 0) {
        }
        if (i11 == 0) {
        }
        if (i6 != 0) {
        }
        if (i7 == 0) {
        }
        if ((i4 & 64) == 0) {
        }
        if ((i4 & 128) == 0) {
        }
    }

    public static final float b(MutableState<Float> mutableState) {
        return mutableState.getValue().floatValue();
    }

    public static final void a(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    public static final void a(MutableState<Float> mutableState, float f) {
        mutableState.setValue(Float.valueOf(f));
    }

    public static final MutableState a() {
        return SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(1.0f), null, 2, null);
    }

    public static final DisposableEffectResult a(LifecycleOwner lifecycleOwner, final CoroutineScope coroutineScope, final Animatable animatable, final MutableState mutableState, DisposableEffectScope DisposableEffect) {
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        LifecycleEventObserver lifecycleEventObserver = new LifecycleEventObserver() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.rewardedcountdowntimer.c$$ExternalSyntheticLambda6
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner2, Lifecycle.Event event) {
                c.a(CoroutineScope.this, animatable, mutableState, lifecycleOwner2, event);
            }
        };
        lifecycleOwner.getLifecycle().addObserver(lifecycleEventObserver);
        return new d(lifecycleOwner, lifecycleEventObserver);
    }

    public static final void a(CoroutineScope coroutineScope, Animatable animatable, MutableState mutableState, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<unused var>");
        Intrinsics.checkNotNullParameter(event, "event");
        int i = e.f6033a[event.ordinal()];
        if (i == 1) {
            a((MutableState<Boolean>) mutableState, false);
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new C0520c(animatable, null), 3, null);
        } else if (i == 2 && ((Number) animatable.getValue()).floatValue() > 0.0f) {
            a((MutableState<Boolean>) mutableState, true);
        }
    }

    public static final Unit a(String str, SemanticsPropertyReceiver semantics) {
        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
        SemanticsPropertiesKt.setContentDescription(semantics, str);
        SemanticsPropertiesKt.setTestTag(semantics, str);
        return Unit.INSTANCE;
    }

    public static final Unit a(long j, float f, Animatable animatable, long j2, DrawScope Canvas) {
        Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
        long Size = androidx.compose.ui.geometry.SizeKt.Size(Size.m3891getWidthimpl(Canvas.mo4612getSizeNHjbRc()), Size.m3888getHeightimpl(Canvas.mo4612getSizeNHjbRc()));
        float f2 = Canvas.mo630toPx0680j_4(f);
        StrokeCap.Companion companion = StrokeCap.INSTANCE;
        DrawScope.m4592drawArcyD3GUKo$default(Canvas, j, 360.0f, 360.0f, false, 0L, Size, 0.0f, new Stroke(f2, 0.0f, companion.m4416getRoundKaPHkGw(), 0, null, 26, null), null, 0, 848, null);
        if (((Number) animatable.getValue()).floatValue() > 0.0f) {
            DrawScope.m4592drawArcyD3GUKo$default(Canvas, j2, 270.0f, RangesKt.coerceAtLeast(((Number) animatable.getValue()).floatValue(), 0.0f) * (-360.0f), false, 0L, androidx.compose.ui.geometry.SizeKt.Size(Size.m3891getWidthimpl(Canvas.mo4612getSizeNHjbRc()), Size.m3888getHeightimpl(Canvas.mo4612getSizeNHjbRc())), 0.0f, new Stroke(Canvas.mo630toPx0680j_4(f), 0.0f, companion.m4416getRoundKaPHkGw(), 0, null, 26, null), null, 0, 848, null);
        }
        return Unit.INSTANCE;
    }

    public static final boolean a(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }
}
