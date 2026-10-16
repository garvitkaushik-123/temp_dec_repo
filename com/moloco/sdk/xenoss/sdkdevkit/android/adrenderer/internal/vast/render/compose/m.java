package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.MaterialThemeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.CornerRadiusKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.Dp;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: classes6.dex */
public final class m {

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastProgressBarKt$VastProgressBar$1$1", f = "VastProgressBar.kt", i = {}, l = {43, 45, 53}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f6232a;
        public final /* synthetic */ Animatable<Float, AnimationVector1D> b;
        public final /* synthetic */ float c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Animatable<Float, AnimationVector1D> animatable, float f, boolean z, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i iVar, Continuation<? super a> continuation) {
            super(2, continuation);
            this.b = animatable;
            this.c = f;
            this.d = z;
            this.e = iVar;
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

        /* JADX WARN: Code restructure failed: missing block: B:20:0x006a, code lost:
        
            if (androidx.compose.animation.core.Animatable.animateTo$default(r5, r6, r7, null, null, r13, 12, null) == r0) goto L24;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x0076, code lost:
        
            if (r14.stop(r13) == r0) goto L24;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f6232a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Animatable<Float, AnimationVector1D> animatable = this.b;
                Float boxFloat = Boxing.boxFloat(this.c);
                this.f6232a = 1;
                if (animatable.snapTo(boxFloat, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    if (i == 2) {
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    Unit unit = Unit.INSTANCE;
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
            }
            if (this.d && (this.e instanceof i.c)) {
                Animatable<Float, AnimationVector1D> animatable2 = this.b;
                Float boxFloat2 = Boxing.boxFloat(1.0f);
                TweenSpec tween$default = AnimationSpecKt.tween$default(m.c(this.e), 0, EasingKt.getLinearEasing(), 2, null);
                this.f6232a = 2;
            } else {
                Animatable<Float, AnimationVector1D> animatable3 = this.b;
                this.f6232a = 3;
            }
            return coroutine_suspended;
        }
    }

    public static final Unit a(int i, Composer composer, int i2) {
        a(composer, i | 1);
        return Unit.INSTANCE;
    }

    public static final float b(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i iVar) {
        if (iVar instanceof i.a) {
            return 100.0f;
        }
        if (iVar instanceof i.c) {
            if (((i.c) iVar).d() == 0) {
                return 0.0f;
            }
            return (float) (r4.c() / r4.d());
        }
        if ((iVar instanceof i.d) || Intrinsics.areEqual(iVar, i.b.b)) {
            return 0.0f;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final int c(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i iVar) {
        if (!(iVar instanceof i.a)) {
            if (iVar instanceof i.c) {
                i.c cVar = (i.c) iVar;
                if (cVar.d() != 0) {
                    return RangesKt.coerceAtLeast((int) (cVar.d() - cVar.c()), 0);
                }
            } else if (!(iVar instanceof i.d) && !Intrinsics.areEqual(iVar, i.b.b)) {
                throw new NoWhenBranchMatchedException();
            }
        }
        return 0;
    }

    public static final Unit a(boolean z, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i iVar, Modifier modifier, long j, int i, int i2, Composer composer, int i3) {
        a(z, iVar, modifier, j, composer, i | 1, i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x00a2, code lost:
    
        if ((r29 & 8) != 0) goto L64;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0079  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void a(final boolean z, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i iVar, Modifier modifier, long j, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        long j2;
        float f;
        float m6389constructorimpl;
        Object rememberedValue;
        Composer.Companion companion;
        float max;
        Object rememberedValue2;
        Animatable animatable;
        boolean changed;
        Object aVar;
        float f2;
        final Animatable animatable2;
        int i4;
        final float f3;
        final long j3;
        boolean changed2;
        Object rememberedValue3;
        final Modifier modifier3;
        ScopeUpdateScope endRestartGroup;
        int i5;
        final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i progress = iVar;
        Intrinsics.checkNotNullParameter(progress, "progress");
        Composer startRestartGroup = composer.startRestartGroup(632891183);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changed(progress) ? 32 : 16;
        }
        int i6 = i2 & 4;
        if (i6 != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 256 : 128;
            if ((i & 3072) != 0) {
                if ((i2 & 8) == 0) {
                    j2 = j;
                    if (startRestartGroup.changed(j2)) {
                        i5 = 2048;
                        i3 |= i5;
                    }
                } else {
                    j2 = j;
                }
                i5 = 1024;
                i3 |= i5;
            } else {
                j2 = j;
            }
            if ((i3 & 1171) != 1170 && startRestartGroup.getSkipping()) {
                startRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                j3 = j2;
            } else {
                startRestartGroup.startDefaults();
                if ((i & 1) == 0 && !startRestartGroup.getDefaultsInvalid()) {
                    startRestartGroup.skipToGroupEnd();
                } else {
                    if (i6 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i2 & 8) != 0) {
                        j2 = MaterialTheme.INSTANCE.getColors(startRestartGroup, MaterialTheme.$stable).m1603getPrimary0d7_KjU();
                        i3 &= -7169;
                    }
                    int i7 = i3;
                    Modifier modifier4 = modifier2;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(632891183, i7, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastProgressBar (VastProgressBar.kt:30)");
                    }
                    f = 4;
                    m6389constructorimpl = Dp.m6389constructorimpl(f);
                    Object[] objArr = new Object[0];
                    startRestartGroup.startReplaceableGroup(-1652713005);
                    rememberedValue = startRestartGroup.rememberedValue();
                    companion = Composer.INSTANCE;
                    if (rememberedValue == companion.getEmpty()) {
                        rememberedValue = new Function0() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.m$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return m.a();
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue);
                    }
                    startRestartGroup.endReplaceableGroup();
                    long j4 = j2;
                    MutableState mutableState = (MutableState) RememberSaveableKt.m3680rememberSaveable(objArr, (Saver) null, (String) null, (Function0) rememberedValue, startRestartGroup, 3072, 6);
                    max = Math.max(b(progress), a((MutableState<Float>) mutableState));
                    startRestartGroup.startReplaceableGroup(-1652708774);
                    rememberedValue2 = startRestartGroup.rememberedValue();
                    if (rememberedValue2 == companion.getEmpty()) {
                        rememberedValue2 = AnimatableKt.Animatable$default(max, 0.0f, 2, null);
                        startRestartGroup.updateRememberedValue(rememberedValue2);
                    }
                    animatable = (Animatable) rememberedValue2;
                    startRestartGroup.endReplaceableGroup();
                    a((MutableState<Float>) mutableState, ((Number) animatable.getValue()).floatValue());
                    Boolean valueOf = Boolean.valueOf(z);
                    startRestartGroup.startReplaceableGroup(-1652703908);
                    changed = startRestartGroup.changed(animatable) | startRestartGroup.changed(max) | startRestartGroup.changed(z) | startRestartGroup.changed(progress);
                    Object rememberedValue4 = startRestartGroup.rememberedValue();
                    if (!changed || rememberedValue4 == companion.getEmpty()) {
                        f2 = f;
                        animatable2 = animatable;
                        i4 = 0;
                        f3 = m6389constructorimpl;
                        aVar = new a(animatable2, max, z, progress, null);
                        progress = progress;
                        startRestartGroup.updateRememberedValue(aVar);
                    } else {
                        f2 = f;
                        aVar = rememberedValue4;
                        f3 = m6389constructorimpl;
                        animatable2 = animatable;
                        i4 = 0;
                    }
                    startRestartGroup.endReplaceableGroup();
                    EffectsKt.LaunchedEffect(progress, valueOf, (Function2) aVar, startRestartGroup, ((i7 >> 3) & 14) | ((i7 << 3) & 112));
                    Modifier m914height3ABfNKs = SizeKt.m914height3ABfNKs(modifier4, Dp.m6389constructorimpl(f2));
                    startRestartGroup.startReplaceableGroup(-1652687792);
                    j3 = j4;
                    changed2 = startRestartGroup.changed(animatable2) | startRestartGroup.changed(f3) | startRestartGroup.changed(j3);
                    rememberedValue3 = startRestartGroup.rememberedValue();
                    if (!changed2 || rememberedValue3 == companion.getEmpty()) {
                        rememberedValue3 = new Function1() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.m$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return m.a(Animatable.this, f3, j3, (DrawScope) obj);
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue3);
                    }
                    startRestartGroup.endReplaceableGroup();
                    BoxKt.Box(DrawModifierKt.drawBehind(m914height3ABfNKs, (Function1) rememberedValue3), startRestartGroup, i4);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                }
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
                endRestartGroup.updateScope(new Function2() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.m$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return m.a(z, progress, modifier3, j3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
                return;
            }
            return;
        }
        modifier2 = modifier;
        if ((i & 3072) != 0) {
        }
        if ((i3 & 1171) != 1170) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) == 0) {
        }
        if (i6 != 0) {
        }
        if ((i2 & 8) != 0) {
        }
        int i72 = i3;
        Modifier modifier42 = modifier2;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        f = 4;
        m6389constructorimpl = Dp.m6389constructorimpl(f);
        Object[] objArr2 = new Object[0];
        startRestartGroup.startReplaceableGroup(-1652713005);
        rememberedValue = startRestartGroup.rememberedValue();
        companion = Composer.INSTANCE;
        if (rememberedValue == companion.getEmpty()) {
        }
        startRestartGroup.endReplaceableGroup();
        long j42 = j2;
        MutableState mutableState2 = (MutableState) RememberSaveableKt.m3680rememberSaveable(objArr2, (Saver) null, (String) null, (Function0) rememberedValue, startRestartGroup, 3072, 6);
        max = Math.max(b(progress), a((MutableState<Float>) mutableState2));
        startRestartGroup.startReplaceableGroup(-1652708774);
        rememberedValue2 = startRestartGroup.rememberedValue();
        if (rememberedValue2 == companion.getEmpty()) {
        }
        animatable = (Animatable) rememberedValue2;
        startRestartGroup.endReplaceableGroup();
        a((MutableState<Float>) mutableState2, ((Number) animatable.getValue()).floatValue());
        Boolean valueOf2 = Boolean.valueOf(z);
        startRestartGroup.startReplaceableGroup(-1652703908);
        changed = startRestartGroup.changed(animatable) | startRestartGroup.changed(max) | startRestartGroup.changed(z) | startRestartGroup.changed(progress);
        Object rememberedValue42 = startRestartGroup.rememberedValue();
        if (changed) {
        }
        f2 = f;
        animatable2 = animatable;
        i4 = 0;
        f3 = m6389constructorimpl;
        aVar = new a(animatable2, max, z, progress, null);
        progress = progress;
        startRestartGroup.updateRememberedValue(aVar);
        startRestartGroup.endReplaceableGroup();
        EffectsKt.LaunchedEffect(progress, valueOf2, (Function2) aVar, startRestartGroup, ((i72 >> 3) & 14) | ((i72 << 3) & 112));
        Modifier m914height3ABfNKs2 = SizeKt.m914height3ABfNKs(modifier42, Dp.m6389constructorimpl(f2));
        startRestartGroup.startReplaceableGroup(-1652687792);
        j3 = j42;
        changed2 = startRestartGroup.changed(animatable2) | startRestartGroup.changed(f3) | startRestartGroup.changed(j3);
        rememberedValue3 = startRestartGroup.rememberedValue();
        if (!changed2) {
        }
        rememberedValue3 = new Function1() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.m$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return m.a(Animatable.this, f3, j3, (DrawScope) obj);
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue3);
        startRestartGroup.endReplaceableGroup();
        BoxKt.Box(DrawModifierKt.drawBehind(m914height3ABfNKs2, (Function1) rememberedValue3), startRestartGroup, i4);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier3 = modifier42;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    public static final void a(MutableState<Float> mutableState, float f) {
        mutableState.setValue(Float.valueOf(f));
    }

    public static final MutableState a() {
        return SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(0.0f), null, 2, null);
    }

    public static final Unit a(Animatable animatable, float f, long j, DrawScope drawBehind) {
        Intrinsics.checkNotNullParameter(drawBehind, "$this$drawBehind");
        DrawScope.m4609drawRoundRectuAw5IA$default(drawBehind, j, 0L, androidx.compose.ui.geometry.SizeKt.Size(((Number) animatable.getValue()).floatValue() * Size.m3891getWidthimpl(drawBehind.mo4612getSizeNHjbRc()), Size.m3888getHeightimpl(drawBehind.mo4612getSizeNHjbRc())), CornerRadiusKt.CornerRadius(f, f), null, 0.0f, null, 0, 242, null);
        return Unit.INSTANCE;
    }

    public static final void a(Composer composer, final int i) {
        Composer startRestartGroup = composer.startRestartGroup(1397199635);
        if (i == 0 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1397199635, i, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.Preview (VastProgressBar.kt:98)");
            }
            MaterialThemeKt.MaterialTheme(null, null, null, e.f6214a.a(), startRestartGroup, 3072, 7);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.m$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return m.a(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final float a(MutableState<Float> mutableState) {
        return mutableState.getValue().floatValue();
    }
}
