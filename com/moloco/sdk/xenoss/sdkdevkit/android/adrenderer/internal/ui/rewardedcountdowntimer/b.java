package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.rewardedcountdowntimer;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
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
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnRemeasuredModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.profileinstaller.ProfileVerifier;
import com.google.android.exoplayer2.C;
import com.vungle.ads.internal.protos.Sdk;
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
public final class b {

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.rewardedcountdowntimer.RewardedCountDownTimerCustomKt$RewardedCountDownTimerCustom$1$1", f = "RewardedCountDownTimerCustom.kt", i = {}, l = {92}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f6024a;
        public final /* synthetic */ Animatable<Float, AnimationVector1D> b;
        public final /* synthetic */ int c;
        public final /* synthetic */ MutableState<Boolean> d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Animatable<Float, AnimationVector1D> animatable, int i, MutableState<Boolean> mutableState, Continuation<? super a> continuation) {
            super(2, continuation);
            this.b = animatable;
            this.c = i;
            this.d = mutableState;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new a(this.b, this.c, this.d, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f6024a;
            try {
            } catch (CancellationException unused) {
                Unit unit = Unit.INSTANCE;
            }
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (b.b(this.d) && this.b.getValue().floatValue() > 0.0f) {
                    long m10336constructorimpl = UInt.m10336constructorimpl(this.c * 1000) & 4294967295L;
                    Animatable<Float, AnimationVector1D> animatable = this.b;
                    Float boxFloat = Boxing.boxFloat(0.0f);
                    TweenSpec tween$default = AnimationSpecKt.tween$default((int) m10336constructorimpl, 0, EasingKt.getLinearEasing(), 2, null);
                    this.f6024a = 1;
                    if (Animatable.animateTo$default(animatable, boxFloat, tween$default, null, null, this, 12, null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.rewardedcountdowntimer.RewardedCountDownTimerCustomKt$RewardedCountDownTimerCustom$2$1", f = "RewardedCountDownTimerCustom.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.rewardedcountdowntimer.b$b, reason: collision with other inner class name */
    public static final class C0519b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f6025a;
        public final /* synthetic */ int b;
        public final /* synthetic */ Function0<Unit> c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0519b(int i, Function0<Unit> function0, Continuation<? super C0519b> continuation) {
            super(2, continuation);
            this.b = i;
            this.c = function0;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C0519b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C0519b(this.b, this.c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f6025a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            if (this.b == 0) {
                this.c.invoke();
            }
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.rewardedcountdowntimer.RewardedCountDownTimerCustomKt$RewardedCountDownTimerCustom$3$1$observer$1$1", f = "RewardedCountDownTimerCustom.kt", i = {}, l = {Sdk.SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE}, m = "invokeSuspend", n = {}, s = {})
    public static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f6026a;
        public final /* synthetic */ Animatable<Float, AnimationVector1D> b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Animatable<Float, AnimationVector1D> animatable, Continuation<? super c> continuation) {
            super(2, continuation);
            this.b = animatable;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((c) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new c(this.b, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f6026a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Animatable<Float, AnimationVector1D> animatable = this.b;
                this.f6026a = 1;
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
        public final /* synthetic */ LifecycleOwner f6027a;
        public final /* synthetic */ LifecycleEventObserver b;

        public d(LifecycleOwner lifecycleOwner, LifecycleEventObserver lifecycleEventObserver) {
            this.f6027a = lifecycleOwner;
            this.b = lifecycleEventObserver;
        }

        @Override // androidx.compose.runtime.DisposableEffectResult
        public void dispose() {
            this.f6027a.getLifecycle().removeObserver(this.b);
        }
    }

    public /* synthetic */ class e {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6028a;

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
            f6028a = iArr;
        }
    }

    public static final Unit a(long j, long j2, Modifier modifier, float f, float f2, Function0 function0, String str, LifecycleOwner lifecycleOwner, CoroutineScope coroutineScope, int i, int i2, int i3, int i4, int i5, Composer composer, int i6) {
        a(j, j2, modifier, f, f2, function0, str, lifecycleOwner, coroutineScope, i, i2, composer, i3 | 1, i4, i5);
        return Unit.INSTANCE;
    }

    public static final Unit b(String str, SemanticsPropertyReceiver semantics) {
        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
        SemanticsPropertiesKt.setContentDescription(semantics, str);
        SemanticsPropertiesKt.setTestTag(semantics, str);
        return Unit.INSTANCE;
    }

    public static final float c(MutableState<Float> mutableState) {
        return mutableState.getValue().floatValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x03e3  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x03ef  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0592  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x059e  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x065a  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x05a2  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x03f3  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0286  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x02c4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void a(final long j, final long j2, Modifier modifier, float f, float f2, final Function0<Unit> onTimerFinish, final String customTimerString, LifecycleOwner lifecycleOwner, CoroutineScope coroutineScope, final int i, final int i2, Composer composer, final int i3, final int i4, final int i5) {
        int i6;
        Modifier modifier2;
        int i7;
        float f3;
        int i8;
        float f4;
        int i9;
        LifecycleOwner lifecycleOwner2;
        Modifier modifier3;
        float f5;
        final LifecycleOwner lifecycleOwner3;
        int i10;
        CoroutineScope coroutineScope2;
        Object rememberedValue;
        Composer.Companion companion;
        boolean changed;
        Object rememberedValue2;
        int i11;
        Object rememberedValue3;
        float f6;
        Object rememberedValue4;
        boolean changed2;
        Object rememberedValue5;
        boolean changed3;
        Object rememberedValue6;
        boolean changed4;
        Object rememberedValue7;
        boolean changed5;
        Object rememberedValue8;
        float f7;
        boolean changed6;
        Object rememberedValue9;
        boolean changed7;
        Object rememberedValue10;
        boolean changed8;
        Object rememberedValue11;
        float f8;
        final float f9;
        final float f10;
        final float f11;
        final Modifier modifier4;
        final CoroutineScope coroutineScope3;
        final LifecycleOwner lifecycleOwner4;
        int i12;
        int i13;
        Intrinsics.checkNotNullParameter(onTimerFinish, "onTimerFinish");
        Intrinsics.checkNotNullParameter(customTimerString, "customTimerString");
        Composer startRestartGroup = composer.startRestartGroup(-1791099148);
        if ((i5 & 1) != 0) {
            i6 = i3 | 6;
        } else if ((i3 & 6) == 0) {
            i6 = (startRestartGroup.changed(j) ? 4 : 2) | i3;
        } else {
            i6 = i3;
        }
        if ((i5 & 2) != 0) {
            i6 |= 48;
        } else if ((i3 & 48) == 0) {
            i6 |= startRestartGroup.changed(j2) ? 32 : 16;
        }
        int i14 = i5 & 4;
        if (i14 != 0) {
            i6 |= 384;
        } else if ((i3 & 384) == 0) {
            modifier2 = modifier;
            i6 |= startRestartGroup.changed(modifier2) ? 256 : 128;
            i7 = i5 & 8;
            if (i7 == 0) {
                i6 |= 3072;
            } else if ((i3 & 3072) == 0) {
                f3 = f;
                i6 |= startRestartGroup.changed(f3) ? 2048 : 1024;
                i8 = i5 & 16;
                if (i8 != 0) {
                    i6 |= 24576;
                } else if ((i3 & 24576) == 0) {
                    f4 = f2;
                    i6 |= startRestartGroup.changed(f4) ? 16384 : 8192;
                    if ((i5 & 32) == 0) {
                        i6 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        i6 |= startRestartGroup.changed(onTimerFinish) ? 131072 : 65536;
                    }
                    if ((i5 & 64) == 0) {
                        i6 |= 1572864;
                    } else if ((i3 & 1572864) == 0) {
                        i6 |= startRestartGroup.changed(customTimerString) ? 1048576 : 524288;
                    }
                    if ((i3 & 12582912) == 0) {
                        if ((i5 & 128) == 0 && startRestartGroup.changed(lifecycleOwner)) {
                            i13 = 8388608;
                            i6 |= i13;
                        }
                        i13 = 4194304;
                        i6 |= i13;
                    }
                    if ((100663296 & i3) == 0) {
                        if ((i5 & 256) == 0 && startRestartGroup.changed(coroutineScope)) {
                            i12 = 67108864;
                            i6 |= i12;
                        }
                        i12 = 33554432;
                        i6 |= i12;
                    }
                    if ((i5 & 512) == 0) {
                        i6 |= C.ENCODING_PCM_32BIT;
                    } else if ((i3 & C.ENCODING_PCM_32BIT) == 0) {
                        i6 |= startRestartGroup.changed(i) ? 536870912 : 268435456;
                    }
                    if ((i5 & 1024) == 0) {
                        i9 = i4 | 6;
                    } else if ((i4 & 6) == 0) {
                        i9 = i4 | (startRestartGroup.changed(i2) ? 4 : 2);
                    } else {
                        i9 = i4;
                    }
                    if ((i6 & 306783379) != 306783378 && (i9 & 3) == 2 && startRestartGroup.getSkipping()) {
                        startRestartGroup.skipToGroupEnd();
                        coroutineScope3 = coroutineScope;
                        f10 = f3;
                        modifier4 = modifier2;
                        f11 = f4;
                        lifecycleOwner4 = lifecycleOwner;
                    } else {
                        startRestartGroup.startDefaults();
                        if ((i3 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                            Modifier modifier5 = i14 == 0 ? Modifier.INSTANCE : modifier2;
                            if (i7 != 0) {
                                f3 = Dp.m6389constructorimpl(5);
                            }
                            float m6389constructorimpl = i8 == 0 ? Dp.m6389constructorimpl(30) : f4;
                            if ((i5 & 128) == 0) {
                                lifecycleOwner2 = (LifecycleOwner) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner());
                                i6 &= -29360129;
                            } else {
                                lifecycleOwner2 = lifecycleOwner;
                            }
                            if ((i5 & 256) == 0) {
                                startRestartGroup.startReplaceableGroup(773894976);
                                startRestartGroup.startReplaceableGroup(-492369756);
                                Object rememberedValue12 = startRestartGroup.rememberedValue();
                                if (rememberedValue12 == Composer.INSTANCE.getEmpty()) {
                                    CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup));
                                    startRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                                    rememberedValue12 = compositionScopedCoroutineScopeCanceller;
                                }
                                startRestartGroup.endReplaceableGroup();
                                CoroutineScope coroutineScope4 = ((CompositionScopedCoroutineScopeCanceller) rememberedValue12).getCoroutineScope();
                                startRestartGroup.endReplaceableGroup();
                                modifier3 = modifier5;
                                f5 = m6389constructorimpl;
                                i10 = i6 & (-234881025);
                                coroutineScope2 = coroutineScope4;
                                lifecycleOwner3 = lifecycleOwner2;
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1791099148, i10, i9, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.rewardedcountdowntimer.RewardedCountDownTimerCustom (RewardedCountDownTimerCustom.kt:71)");
                                }
                                startRestartGroup.startReplaceableGroup(-1077277275);
                                rememberedValue = startRestartGroup.rememberedValue();
                                companion = Composer.INSTANCE;
                                if (rememberedValue == companion.getEmpty()) {
                                    rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(IntSize.m6551boximpl(IntSize.INSTANCE.m6564getZeroYbymL2g()), null, 2, null);
                                    startRestartGroup.updateRememberedValue(rememberedValue);
                                }
                                final MutableState mutableState = (MutableState) rememberedValue;
                                startRestartGroup.endReplaceableGroup();
                                startRestartGroup.startReplaceableGroup(-1077275047);
                                changed = startRestartGroup.changed(lifecycleOwner3);
                                rememberedValue2 = startRestartGroup.rememberedValue();
                                if (!changed || rememberedValue2 == companion.getEmpty()) {
                                    i11 = i9;
                                    rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
                                    startRestartGroup.updateRememberedValue(rememberedValue2);
                                } else {
                                    i11 = i9;
                                }
                                final MutableState mutableState2 = (MutableState) rememberedValue2;
                                startRestartGroup.endReplaceableGroup();
                                final CoroutineScope coroutineScope5 = coroutineScope2;
                                Object[] objArr = new Object[0];
                                startRestartGroup.startReplaceableGroup(-1077271618);
                                rememberedValue3 = startRestartGroup.rememberedValue();
                                if (rememberedValue3 == companion.getEmpty()) {
                                    rememberedValue3 = new Function0() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.rewardedcountdowntimer.b$$ExternalSyntheticLambda0
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            return b.a();
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(rememberedValue3);
                                }
                                startRestartGroup.endReplaceableGroup();
                                int i15 = i10;
                                f6 = f3;
                                MutableState mutableState3 = (MutableState) RememberSaveableKt.m3680rememberSaveable(objArr, (Saver) null, (String) null, (Function0) rememberedValue3, startRestartGroup, 3072, 6);
                                float coerceAtMost = RangesKt.coerceAtMost(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.rewardedcountdowntimer.a.a(i2, i), c(mutableState3));
                                startRestartGroup.startReplaceableGroup(-1077265979);
                                rememberedValue4 = startRestartGroup.rememberedValue();
                                if (rememberedValue4 == companion.getEmpty()) {
                                    rememberedValue4 = AnimatableKt.Animatable$default(coerceAtMost, 0.0f, 2, null);
                                    startRestartGroup.updateRememberedValue(rememberedValue4);
                                }
                                final Animatable animatable = (Animatable) rememberedValue4;
                                startRestartGroup.endReplaceableGroup();
                                a((MutableState<Float>) mutableState3, ((Number) animatable.getValue()).floatValue());
                                Boolean valueOf = Boolean.valueOf(b(mutableState2));
                                UInt m10330boximpl = UInt.m10330boximpl(i2);
                                startRestartGroup.startReplaceableGroup(-1077260769);
                                changed2 = startRestartGroup.changed(mutableState2) | startRestartGroup.changed(animatable) | startRestartGroup.changed(i2);
                                rememberedValue5 = startRestartGroup.rememberedValue();
                                if (!changed2 || rememberedValue5 == companion.getEmpty()) {
                                    rememberedValue5 = new a(animatable, i2, mutableState2, null);
                                    startRestartGroup.updateRememberedValue(rememberedValue5);
                                }
                                startRestartGroup.endReplaceableGroup();
                                EffectsKt.LaunchedEffect(valueOf, m10330boximpl, (Function2) rememberedValue5, startRestartGroup, (i11 << 3) & 112);
                                UInt m10330boximpl2 = UInt.m10330boximpl(i2);
                                startRestartGroup.startReplaceableGroup(-1077238381);
                                changed3 = startRestartGroup.changed(i2) | startRestartGroup.changed(onTimerFinish);
                                rememberedValue6 = startRestartGroup.rememberedValue();
                                if (!changed3 || rememberedValue6 == companion.getEmpty()) {
                                    rememberedValue6 = new C0519b(i2, onTimerFinish, null);
                                    startRestartGroup.updateRememberedValue(rememberedValue6);
                                }
                                startRestartGroup.endReplaceableGroup();
                                EffectsKt.LaunchedEffect(m10330boximpl2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue6, startRestartGroup, i11 & 14);
                                startRestartGroup.startReplaceableGroup(-1077233680);
                                changed4 = startRestartGroup.changed(mutableState2) | startRestartGroup.changed(coroutineScope5) | startRestartGroup.changed(animatable) | startRestartGroup.changed(lifecycleOwner3);
                                rememberedValue7 = startRestartGroup.rememberedValue();
                                if (!changed4 || rememberedValue7 == companion.getEmpty()) {
                                    rememberedValue7 = new Function1() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.rewardedcountdowntimer.b$$ExternalSyntheticLambda1
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return b.a(LifecycleOwner.this, coroutineScope5, animatable, mutableState2, (DisposableEffectScope) obj);
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(rememberedValue7);
                                }
                                startRestartGroup.endReplaceableGroup();
                                EffectsKt.DisposableEffect(lifecycleOwner3, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) rememberedValue7, startRestartGroup, (i15 >> 21) & 14);
                                Alignment.Companion companion2 = Alignment.INSTANCE;
                                Alignment.Vertical centerVertically = companion2.getCenterVertically();
                                Arrangement.HorizontalOrVertical m788spacedBy0680j_4 = Arrangement.INSTANCE.m788spacedBy0680j_4(Dp.m6389constructorimpl(8));
                                startRestartGroup.startReplaceableGroup(693286680);
                                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(m788spacedBy0680j_4, centerVertically, startRestartGroup, 54);
                                startRestartGroup.startReplaceableGroup(-1323940314);
                                Density density = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                                LayoutDirection layoutDirection = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                ViewConfiguration viewConfiguration = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
                                Function0<ComposeUiNode> constructor = companion3.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(modifier3);
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
                                Updater.m3600setimpl(m3593constructorimpl, rowMeasurePolicy, companion3.getSetMeasurePolicy());
                                Updater.m3600setimpl(m3593constructorimpl, density, companion3.getSetDensity());
                                Updater.m3600setimpl(m3593constructorimpl, layoutDirection, companion3.getSetLayoutDirection());
                                Updater.m3600setimpl(m3593constructorimpl, viewConfiguration, companion3.getSetViewConfiguration());
                                startRestartGroup.enableReusing();
                                materializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
                                startRestartGroup.startReplaceableGroup(2058660585);
                                startRestartGroup.startReplaceableGroup(-678309503);
                                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                                String a2 = com.moloco.sdk.internal.utils.b.a(customTimerString, i2);
                                LifecycleOwner lifecycleOwner5 = lifecycleOwner3;
                                long d2 = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.a.d();
                                int m6286getStarte0LSkKk = TextAlign.INSTANCE.m6286getStarte0LSkKk();
                                Modifier.Companion companion4 = Modifier.INSTANCE;
                                startRestartGroup.startReplaceableGroup(-447509319);
                                final String str = "custom_countdown_timer_text";
                                changed5 = startRestartGroup.changed("custom_countdown_timer_text");
                                rememberedValue8 = startRestartGroup.rememberedValue();
                                if (!changed5 || rememberedValue8 == companion.getEmpty()) {
                                    rememberedValue8 = new Function1() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.rewardedcountdowntimer.b$$ExternalSyntheticLambda2
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return b.a(str, (SemanticsPropertyReceiver) obj);
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(rememberedValue8);
                                }
                                startRestartGroup.endReplaceableGroup();
                                f7 = f5;
                                TextKt.m1844TextfLXpl1I(a2, SemanticsModifierKt.semantics$default(companion4, false, (Function1) rememberedValue8, 1, null), j2, d2, null, null, null, 0L, null, TextAlign.m6274boximpl(m6286getStarte0LSkKk), 0L, 0, false, 2, null, null, startRestartGroup, ((i15 << 3) & 896) | 3072, 3072, 56816);
                                startRestartGroup = startRestartGroup;
                                Alignment center = companion2.getCenter();
                                Modifier m879padding3ABfNKs = PaddingKt.m879padding3ABfNKs(SizeKt.m928size3ABfNKs(companion4, f7), Dp.m6389constructorimpl(2));
                                startRestartGroup.startReplaceableGroup(-447496148);
                                changed6 = startRestartGroup.changed(mutableState);
                                rememberedValue9 = startRestartGroup.rememberedValue();
                                if (!changed6 || rememberedValue9 == companion.getEmpty()) {
                                    rememberedValue9 = new Function1() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.rewardedcountdowntimer.b$$ExternalSyntheticLambda3
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return b.a(MutableState.this, (IntSize) obj);
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(rememberedValue9);
                                }
                                startRestartGroup.endReplaceableGroup();
                                Modifier m526backgroundbw27NRU = BackgroundKt.m526backgroundbw27NRU(OnRemeasuredModifierKt.onSizeChanged(m879padding3ABfNKs, (Function1) rememberedValue9), Color.m4062copywmQWz5c$default(Color.INSTANCE.m4100getWhite0d7_KjU(), 0.9f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.getCircleShape());
                                startRestartGroup.startReplaceableGroup(-447490964);
                                final String str2 = "custom_timer_container";
                                changed7 = startRestartGroup.changed("custom_timer_container");
                                rememberedValue10 = startRestartGroup.rememberedValue();
                                if (!changed7 || rememberedValue10 == companion.getEmpty()) {
                                    rememberedValue10 = new Function1() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.rewardedcountdowntimer.b$$ExternalSyntheticLambda4
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return b.b(str2, (SemanticsPropertyReceiver) obj);
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(rememberedValue10);
                                }
                                startRestartGroup.endReplaceableGroup();
                                Modifier semantics$default = SemanticsModifierKt.semantics$default(m526backgroundbw27NRU, false, (Function1) rememberedValue10, 1, null);
                                startRestartGroup.startReplaceableGroup(733328855);
                                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, startRestartGroup, 6);
                                startRestartGroup.startReplaceableGroup(-1323940314);
                                Density density2 = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                                LayoutDirection layoutDirection2 = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                ViewConfiguration viewConfiguration2 = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf2 = LayoutKt.materializerOf(semantics$default);
                                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                startRestartGroup.startReusableNode();
                                if (startRestartGroup.getInserting()) {
                                    startRestartGroup.useNode();
                                } else {
                                    startRestartGroup.createNode(constructor2);
                                }
                                startRestartGroup.disableReusing();
                                Composer m3593constructorimpl2 = Updater.m3593constructorimpl(startRestartGroup);
                                Updater.m3600setimpl(m3593constructorimpl2, rememberBoxMeasurePolicy, companion3.getSetMeasurePolicy());
                                Updater.m3600setimpl(m3593constructorimpl2, density2, companion3.getSetDensity());
                                Updater.m3600setimpl(m3593constructorimpl2, layoutDirection2, companion3.getSetLayoutDirection());
                                Updater.m3600setimpl(m3593constructorimpl2, viewConfiguration2, companion3.getSetViewConfiguration());
                                startRestartGroup.enableReusing();
                                materializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
                                startRestartGroup.startReplaceableGroup(2058660585);
                                startRestartGroup.startReplaceableGroup(-2137368960);
                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(companion4, 0.0f, 1, null);
                                startRestartGroup.startReplaceableGroup(-1178261722);
                                changed8 = startRestartGroup.changed(j) | startRestartGroup.changed(mutableState) | startRestartGroup.changed(f6) | startRestartGroup.changed(animatable) | startRestartGroup.changed(j2);
                                rememberedValue11 = startRestartGroup.rememberedValue();
                                if (!changed8 || rememberedValue11 == companion.getEmpty()) {
                                    f8 = f7;
                                    f9 = f6;
                                    Function1 function1 = new Function1() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.rewardedcountdowntimer.b$$ExternalSyntheticLambda5
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return b.a(j, f9, animatable, j2, mutableState, (DrawScope) obj);
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(function1);
                                    rememberedValue11 = function1;
                                } else {
                                    f8 = f7;
                                    f9 = f6;
                                }
                                startRestartGroup.endReplaceableGroup();
                                CanvasKt.Canvas(fillMaxSize$default, (Function1) rememberedValue11, startRestartGroup, 6);
                                startRestartGroup.endReplaceableGroup();
                                startRestartGroup.endReplaceableGroup();
                                startRestartGroup.endNode();
                                startRestartGroup.endReplaceableGroup();
                                startRestartGroup.endReplaceableGroup();
                                startRestartGroup.endReplaceableGroup();
                                startRestartGroup.endReplaceableGroup();
                                startRestartGroup.endNode();
                                startRestartGroup.endReplaceableGroup();
                                startRestartGroup.endReplaceableGroup();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                f10 = f9;
                                f11 = f8;
                                modifier4 = modifier3;
                                coroutineScope3 = coroutineScope5;
                                lifecycleOwner4 = lifecycleOwner5;
                            } else {
                                modifier3 = modifier5;
                                f5 = m6389constructorimpl;
                                lifecycleOwner3 = lifecycleOwner2;
                            }
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            if ((i5 & 128) != 0) {
                                i6 &= -29360129;
                            }
                            if ((i5 & 256) != 0) {
                                i6 &= -234881025;
                            }
                            lifecycleOwner3 = lifecycleOwner;
                            modifier3 = modifier2;
                            f5 = f4;
                        }
                        i10 = i6;
                        coroutineScope2 = coroutineScope;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        startRestartGroup.startReplaceableGroup(-1077277275);
                        rememberedValue = startRestartGroup.rememberedValue();
                        companion = Composer.INSTANCE;
                        if (rememberedValue == companion.getEmpty()) {
                        }
                        final MutableState mutableState4 = (MutableState) rememberedValue;
                        startRestartGroup.endReplaceableGroup();
                        startRestartGroup.startReplaceableGroup(-1077275047);
                        changed = startRestartGroup.changed(lifecycleOwner3);
                        rememberedValue2 = startRestartGroup.rememberedValue();
                        if (changed) {
                        }
                        i11 = i9;
                        rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
                        startRestartGroup.updateRememberedValue(rememberedValue2);
                        final MutableState mutableState22 = (MutableState) rememberedValue2;
                        startRestartGroup.endReplaceableGroup();
                        final CoroutineScope coroutineScope52 = coroutineScope2;
                        Object[] objArr2 = new Object[0];
                        startRestartGroup.startReplaceableGroup(-1077271618);
                        rememberedValue3 = startRestartGroup.rememberedValue();
                        if (rememberedValue3 == companion.getEmpty()) {
                        }
                        startRestartGroup.endReplaceableGroup();
                        int i152 = i10;
                        f6 = f3;
                        MutableState mutableState32 = (MutableState) RememberSaveableKt.m3680rememberSaveable(objArr2, (Saver) null, (String) null, (Function0) rememberedValue3, startRestartGroup, 3072, 6);
                        float coerceAtMost2 = RangesKt.coerceAtMost(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.rewardedcountdowntimer.a.a(i2, i), c(mutableState32));
                        startRestartGroup.startReplaceableGroup(-1077265979);
                        rememberedValue4 = startRestartGroup.rememberedValue();
                        if (rememberedValue4 == companion.getEmpty()) {
                        }
                        final Animatable animatable2 = (Animatable) rememberedValue4;
                        startRestartGroup.endReplaceableGroup();
                        a((MutableState<Float>) mutableState32, ((Number) animatable2.getValue()).floatValue());
                        Boolean valueOf2 = Boolean.valueOf(b(mutableState22));
                        UInt m10330boximpl3 = UInt.m10330boximpl(i2);
                        startRestartGroup.startReplaceableGroup(-1077260769);
                        changed2 = startRestartGroup.changed(mutableState22) | startRestartGroup.changed(animatable2) | startRestartGroup.changed(i2);
                        rememberedValue5 = startRestartGroup.rememberedValue();
                        if (!changed2) {
                        }
                        rememberedValue5 = new a(animatable2, i2, mutableState22, null);
                        startRestartGroup.updateRememberedValue(rememberedValue5);
                        startRestartGroup.endReplaceableGroup();
                        EffectsKt.LaunchedEffect(valueOf2, m10330boximpl3, (Function2) rememberedValue5, startRestartGroup, (i11 << 3) & 112);
                        UInt m10330boximpl22 = UInt.m10330boximpl(i2);
                        startRestartGroup.startReplaceableGroup(-1077238381);
                        changed3 = startRestartGroup.changed(i2) | startRestartGroup.changed(onTimerFinish);
                        rememberedValue6 = startRestartGroup.rememberedValue();
                        if (!changed3) {
                        }
                        rememberedValue6 = new C0519b(i2, onTimerFinish, null);
                        startRestartGroup.updateRememberedValue(rememberedValue6);
                        startRestartGroup.endReplaceableGroup();
                        EffectsKt.LaunchedEffect(m10330boximpl22, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue6, startRestartGroup, i11 & 14);
                        startRestartGroup.startReplaceableGroup(-1077233680);
                        changed4 = startRestartGroup.changed(mutableState22) | startRestartGroup.changed(coroutineScope52) | startRestartGroup.changed(animatable2) | startRestartGroup.changed(lifecycleOwner3);
                        rememberedValue7 = startRestartGroup.rememberedValue();
                        if (!changed4) {
                        }
                        rememberedValue7 = new Function1() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.rewardedcountdowntimer.b$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return b.a(LifecycleOwner.this, coroutineScope52, animatable2, mutableState22, (DisposableEffectScope) obj);
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue7);
                        startRestartGroup.endReplaceableGroup();
                        EffectsKt.DisposableEffect(lifecycleOwner3, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) rememberedValue7, startRestartGroup, (i152 >> 21) & 14);
                        Alignment.Companion companion22 = Alignment.INSTANCE;
                        Alignment.Vertical centerVertically2 = companion22.getCenterVertically();
                        Arrangement.HorizontalOrVertical m788spacedBy0680j_42 = Arrangement.INSTANCE.m788spacedBy0680j_4(Dp.m6389constructorimpl(8));
                        startRestartGroup.startReplaceableGroup(693286680);
                        MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(m788spacedBy0680j_42, centerVertically2, startRestartGroup, 54);
                        startRestartGroup.startReplaceableGroup(-1323940314);
                        Density density3 = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                        LayoutDirection layoutDirection3 = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                        ViewConfiguration viewConfiguration3 = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                        ComposeUiNode.Companion companion32 = ComposeUiNode.INSTANCE;
                        Function0<ComposeUiNode> constructor3 = companion32.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf3 = LayoutKt.materializerOf(modifier3);
                        if (!(startRestartGroup.getApplier() instanceof Applier)) {
                        }
                        startRestartGroup.startReusableNode();
                        if (startRestartGroup.getInserting()) {
                        }
                        startRestartGroup.disableReusing();
                        Composer m3593constructorimpl3 = Updater.m3593constructorimpl(startRestartGroup);
                        Updater.m3600setimpl(m3593constructorimpl3, rowMeasurePolicy2, companion32.getSetMeasurePolicy());
                        Updater.m3600setimpl(m3593constructorimpl3, density3, companion32.getSetDensity());
                        Updater.m3600setimpl(m3593constructorimpl3, layoutDirection3, companion32.getSetLayoutDirection());
                        Updater.m3600setimpl(m3593constructorimpl3, viewConfiguration3, companion32.getSetViewConfiguration());
                        startRestartGroup.enableReusing();
                        materializerOf3.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
                        startRestartGroup.startReplaceableGroup(2058660585);
                        startRestartGroup.startReplaceableGroup(-678309503);
                        RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                        String a22 = com.moloco.sdk.internal.utils.b.a(customTimerString, i2);
                        LifecycleOwner lifecycleOwner52 = lifecycleOwner3;
                        long d22 = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.a.d();
                        int m6286getStarte0LSkKk2 = TextAlign.INSTANCE.m6286getStarte0LSkKk();
                        Modifier.Companion companion42 = Modifier.INSTANCE;
                        startRestartGroup.startReplaceableGroup(-447509319);
                        final String str3 = "custom_countdown_timer_text";
                        changed5 = startRestartGroup.changed("custom_countdown_timer_text");
                        rememberedValue8 = startRestartGroup.rememberedValue();
                        if (!changed5) {
                        }
                        rememberedValue8 = new Function1() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.rewardedcountdowntimer.b$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return b.a(str3, (SemanticsPropertyReceiver) obj);
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue8);
                        startRestartGroup.endReplaceableGroup();
                        f7 = f5;
                        TextKt.m1844TextfLXpl1I(a22, SemanticsModifierKt.semantics$default(companion42, false, (Function1) rememberedValue8, 1, null), j2, d22, null, null, null, 0L, null, TextAlign.m6274boximpl(m6286getStarte0LSkKk2), 0L, 0, false, 2, null, null, startRestartGroup, ((i152 << 3) & 896) | 3072, 3072, 56816);
                        startRestartGroup = startRestartGroup;
                        Alignment center2 = companion22.getCenter();
                        Modifier m879padding3ABfNKs2 = PaddingKt.m879padding3ABfNKs(SizeKt.m928size3ABfNKs(companion42, f7), Dp.m6389constructorimpl(2));
                        startRestartGroup.startReplaceableGroup(-447496148);
                        changed6 = startRestartGroup.changed(mutableState4);
                        rememberedValue9 = startRestartGroup.rememberedValue();
                        if (!changed6) {
                        }
                        rememberedValue9 = new Function1() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.rewardedcountdowntimer.b$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return b.a(MutableState.this, (IntSize) obj);
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue9);
                        startRestartGroup.endReplaceableGroup();
                        Modifier m526backgroundbw27NRU2 = BackgroundKt.m526backgroundbw27NRU(OnRemeasuredModifierKt.onSizeChanged(m879padding3ABfNKs2, (Function1) rememberedValue9), Color.m4062copywmQWz5c$default(Color.INSTANCE.m4100getWhite0d7_KjU(), 0.9f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.getCircleShape());
                        startRestartGroup.startReplaceableGroup(-447490964);
                        final String str22 = "custom_timer_container";
                        changed7 = startRestartGroup.changed("custom_timer_container");
                        rememberedValue10 = startRestartGroup.rememberedValue();
                        if (!changed7) {
                        }
                        rememberedValue10 = new Function1() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.rewardedcountdowntimer.b$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return b.b(str22, (SemanticsPropertyReceiver) obj);
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue10);
                        startRestartGroup.endReplaceableGroup();
                        Modifier semantics$default2 = SemanticsModifierKt.semantics$default(m526backgroundbw27NRU2, false, (Function1) rememberedValue10, 1, null);
                        startRestartGroup.startReplaceableGroup(733328855);
                        MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(center2, false, startRestartGroup, 6);
                        startRestartGroup.startReplaceableGroup(-1323940314);
                        Density density22 = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                        LayoutDirection layoutDirection22 = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                        ViewConfiguration viewConfiguration22 = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                        Function0<ComposeUiNode> constructor22 = companion32.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf22 = LayoutKt.materializerOf(semantics$default2);
                        if (!(startRestartGroup.getApplier() instanceof Applier)) {
                        }
                        startRestartGroup.startReusableNode();
                        if (startRestartGroup.getInserting()) {
                        }
                        startRestartGroup.disableReusing();
                        Composer m3593constructorimpl22 = Updater.m3593constructorimpl(startRestartGroup);
                        Updater.m3600setimpl(m3593constructorimpl22, rememberBoxMeasurePolicy2, companion32.getSetMeasurePolicy());
                        Updater.m3600setimpl(m3593constructorimpl22, density22, companion32.getSetDensity());
                        Updater.m3600setimpl(m3593constructorimpl22, layoutDirection22, companion32.getSetLayoutDirection());
                        Updater.m3600setimpl(m3593constructorimpl22, viewConfiguration22, companion32.getSetViewConfiguration());
                        startRestartGroup.enableReusing();
                        materializerOf22.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
                        startRestartGroup.startReplaceableGroup(2058660585);
                        startRestartGroup.startReplaceableGroup(-2137368960);
                        BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                        Modifier fillMaxSize$default2 = SizeKt.fillMaxSize$default(companion42, 0.0f, 1, null);
                        startRestartGroup.startReplaceableGroup(-1178261722);
                        changed8 = startRestartGroup.changed(j) | startRestartGroup.changed(mutableState4) | startRestartGroup.changed(f6) | startRestartGroup.changed(animatable2) | startRestartGroup.changed(j2);
                        rememberedValue11 = startRestartGroup.rememberedValue();
                        if (changed8) {
                        }
                        f8 = f7;
                        f9 = f6;
                        Function1 function12 = new Function1() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.rewardedcountdowntimer.b$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return b.a(j, f9, animatable2, j2, mutableState4, (DrawScope) obj);
                            }
                        };
                        startRestartGroup.updateRememberedValue(function12);
                        rememberedValue11 = function12;
                        startRestartGroup.endReplaceableGroup();
                        CanvasKt.Canvas(fillMaxSize$default2, (Function1) rememberedValue11, startRestartGroup, 6);
                        startRestartGroup.endReplaceableGroup();
                        startRestartGroup.endReplaceableGroup();
                        startRestartGroup.endNode();
                        startRestartGroup.endReplaceableGroup();
                        startRestartGroup.endReplaceableGroup();
                        startRestartGroup.endReplaceableGroup();
                        startRestartGroup.endReplaceableGroup();
                        startRestartGroup.endNode();
                        startRestartGroup.endReplaceableGroup();
                        startRestartGroup.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        f10 = f9;
                        f11 = f8;
                        modifier4 = modifier3;
                        coroutineScope3 = coroutineScope52;
                        lifecycleOwner4 = lifecycleOwner52;
                    }
                    ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                        endRestartGroup.updateScope(new Function2() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.rewardedcountdowntimer.b$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return b.a(j, j2, modifier4, f10, f11, onTimerFinish, customTimerString, lifecycleOwner4, coroutineScope3, i, i2, i3, i4, i5, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                        return;
                    }
                    return;
                }
                f4 = f2;
                if ((i5 & 32) == 0) {
                }
                if ((i5 & 64) == 0) {
                }
                if ((i3 & 12582912) == 0) {
                }
                if ((100663296 & i3) == 0) {
                }
                if ((i5 & 512) == 0) {
                }
                if ((i5 & 1024) == 0) {
                }
                if ((i6 & 306783379) != 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i3 & 1) != 0) {
                }
                if (i14 == 0) {
                }
                if (i7 != 0) {
                }
                if (i8 == 0) {
                }
                if ((i5 & 128) == 0) {
                }
                if ((i5 & 256) == 0) {
                }
            }
            f3 = f;
            i8 = i5 & 16;
            if (i8 != 0) {
            }
            f4 = f2;
            if ((i5 & 32) == 0) {
            }
            if ((i5 & 64) == 0) {
            }
            if ((i3 & 12582912) == 0) {
            }
            if ((100663296 & i3) == 0) {
            }
            if ((i5 & 512) == 0) {
            }
            if ((i5 & 1024) == 0) {
            }
            if ((i6 & 306783379) != 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i3 & 1) != 0) {
            }
            if (i14 == 0) {
            }
            if (i7 != 0) {
            }
            if (i8 == 0) {
            }
            if ((i5 & 128) == 0) {
            }
            if ((i5 & 256) == 0) {
            }
        }
        modifier2 = modifier;
        i7 = i5 & 8;
        if (i7 == 0) {
        }
        f3 = f;
        i8 = i5 & 16;
        if (i8 != 0) {
        }
        f4 = f2;
        if ((i5 & 32) == 0) {
        }
        if ((i5 & 64) == 0) {
        }
        if ((i3 & 12582912) == 0) {
        }
        if ((100663296 & i3) == 0) {
        }
        if ((i5 & 512) == 0) {
        }
        if ((i5 & 1024) == 0) {
        }
        if ((i6 & 306783379) != 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i3 & 1) != 0) {
        }
        if (i14 == 0) {
        }
        if (i7 != 0) {
        }
        if (i8 == 0) {
        }
        if ((i5 & 128) == 0) {
        }
        if ((i5 & 256) == 0) {
        }
    }

    public static final boolean b(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    public static final void a(MutableState<IntSize> mutableState, long j) {
        mutableState.setValue(IntSize.m6551boximpl(j));
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
        LifecycleEventObserver lifecycleEventObserver = new LifecycleEventObserver() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.rewardedcountdowntimer.b$$ExternalSyntheticLambda7
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner2, Lifecycle.Event event) {
                b.a(CoroutineScope.this, animatable, mutableState, lifecycleOwner2, event);
            }
        };
        lifecycleOwner.getLifecycle().addObserver(lifecycleEventObserver);
        return new d(lifecycleOwner, lifecycleEventObserver);
    }

    public static final void a(CoroutineScope coroutineScope, Animatable animatable, MutableState mutableState, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<unused var>");
        Intrinsics.checkNotNullParameter(event, "event");
        int i = e.f6028a[event.ordinal()];
        if (i == 1) {
            a((MutableState<Boolean>) mutableState, false);
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new c(animatable, null), 3, null);
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

    public static final Unit a(MutableState mutableState, IntSize intSize) {
        a((MutableState<IntSize>) mutableState, intSize.getPackedValue());
        return Unit.INSTANCE;
    }

    public static final Unit a(long j, float f, Animatable animatable, long j2, MutableState mutableState, DrawScope Canvas) {
        Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
        long Size = androidx.compose.ui.geometry.SizeKt.Size(IntSize.m6559getWidthimpl(a(mutableState)), IntSize.m6558getHeightimpl(a(mutableState)));
        float f2 = Canvas.mo630toPx0680j_4(f);
        StrokeCap.Companion companion = StrokeCap.INSTANCE;
        DrawScope.m4592drawArcyD3GUKo$default(Canvas, j, 360.0f, 360.0f, false, 0L, Size, 0.0f, new Stroke(f2, 0.0f, companion.m4416getRoundKaPHkGw(), 0, null, 26, null), null, 0, 848, null);
        if (((Number) animatable.getValue()).floatValue() > 0.0f) {
            DrawScope.m4592drawArcyD3GUKo$default(Canvas, j2, 270.0f, RangesKt.coerceAtLeast(((Number) animatable.getValue()).floatValue(), 0.0f) * (-360.0f), false, 0L, androidx.compose.ui.geometry.SizeKt.Size(IntSize.m6559getWidthimpl(a(mutableState)), IntSize.m6558getHeightimpl(a(mutableState))), 0.0f, new Stroke(Canvas.mo630toPx0680j_4(f), 0.0f, companion.m4416getRoundKaPHkGw(), 0, null, 26, null), null, 0, 848, null);
        }
        return Unit.INSTANCE;
    }

    public static final long a(MutableState<IntSize> mutableState) {
        return mutableState.getValue().getPackedValue();
    }
}
