package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose;

import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.profileinstaller.ProfileVerifier;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.K;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.h;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i;
import com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: classes6.dex */
public final class h {

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.LinearKt$Linear$1$1", f = "Linear.kt", i = {}, l = {43}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f6219a;
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.k b;

        @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.LinearKt$Linear$1$1$1", f = "Linear.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.h$a$a, reason: collision with other inner class name */
        public static final class C0548a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

            /* renamed from: a, reason: collision with root package name */
            public int f6220a;
            public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.k b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0548a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.k kVar, Continuation<? super C0548a> continuation) {
                super(2, continuation);
                this.b = kVar;
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C0548a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C0548a(this.b, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.f6220a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.b.b();
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.k kVar, Continuation<? super a> continuation) {
            super(2, continuation);
            this.b = kVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new a(this.b, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f6219a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineContext main = com.moloco.sdk.internal.scheduling.b.a().getMain();
                C0548a c0548a = new C0548a(this.b, null);
                this.f6219a = 1;
                if (BuildersKt.withContext(main, c0548a, this) == coroutine_suspended) {
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

    public /* synthetic */ class b extends FunctionReferenceImpl implements Function1<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.l, Unit> {
        public b(Object obj) {
            super(1, obj, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.k.class, "onError", "onError(Lcom/moloco/sdk/xenoss/sdkdevkit/android/adrenderer/internal/errors/VastAdShowError;)V", 0);
        }

        public final void a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.l p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.k) this.receiver).a(p0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.l lVar) {
            a(lVar);
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.LinearKt$Linear$2$5$1", f = "Linear.kt", i = {}, l = {93}, m = "invokeSuspend", n = {}, s = {})
    public static final class c extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f6221a;
        public /* synthetic */ Object b;
        public final /* synthetic */ Function0<Unit> c;
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.k d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Function0<Unit> function0, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.k kVar, Continuation<? super c> continuation) {
            super(2, continuation);
            this.c = function0;
            this.d = kVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
            return ((c) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            c cVar = new c(this.c, this.d, continuation);
            cVar.b = obj;
            return cVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f6221a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                PointerInputScope pointerInputScope = (PointerInputScope) this.b;
                final Function0<Unit> function0 = this.c;
                final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.k kVar = this.d;
                Function2 function2 = new Function2() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.h$c$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        return h.c.a(Function0.this, kVar, (Offset) obj2, (Offset) obj3);
                    }
                };
                this.f6221a = 1;
                if (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.touch.b.a(pointerInputScope, function2, this) == coroutine_suspended) {
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

        public static final Unit a(Function0 function0, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.k kVar, Offset offset, Offset offset2) {
            if (function0 != null) {
                function0.invoke();
            } else {
                kVar.b(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.c.f6046a.a(offset.getPackedValue()));
            }
            return Unit.INSTANCE;
        }
    }

    public /* synthetic */ class d extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
        public d(Object obj) {
            super(1, obj, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.k.class, "onMuteChange", "onMuteChange(Z)V", 0);
        }

        public final void a(boolean z) {
            ((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.k) this.receiver).c(z);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            a(bool.booleanValue());
            return Unit.INSTANCE;
        }
    }

    public /* synthetic */ class e extends FunctionReferenceImpl implements Function0<Unit> {
        public e(Object obj) {
            super(0, obj, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.k.class, "onVastPrivacyIconDisplayed", "onVastPrivacyIconDisplayed()V", 0);
        }

        public final void a() {
            ((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.k) this.receiver).i();
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    public /* synthetic */ class f extends FunctionReferenceImpl implements Function0<Unit> {
        public f(Object obj) {
            super(0, obj, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.k.class, "onVastPrivacyIconClick", "onVastPrivacyIconClick()V", 0);
        }

        public final void a() {
            ((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.k) this.receiver).v();
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    public static final class g implements Function6<BoxScope, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j, Function0<? extends Unit>, Function0<? extends Unit>, Composer, Integer, Unit> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Alignment f6222a;
        public final /* synthetic */ PaddingValues b;

        public static final class a implements Function3<AnimatedVisibilityScope, Composer, Integer, Unit> {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j f6223a;
            public final /* synthetic */ Function0<Unit> b;
            public final /* synthetic */ Function0<Unit> c;

            public a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j jVar, Function0<Unit> function0, Function0<Unit> function02) {
                this.f6223a = jVar;
                this.b = function0;
                this.c = function02;
            }

            public final void a(AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i) {
                Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(989733896, i, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.defaultVastIcon.<anonymous>.<anonymous> (Linear.kt:155)");
                }
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j jVar = this.f6223a;
                if (jVar != null) {
                    l.a(jVar, this.b, this.c, null, composer, 0, 8);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer, Integer num) {
                a(animatedVisibilityScope, composer, num.intValue());
                return Unit.INSTANCE;
            }
        }

        public g(Alignment alignment, PaddingValues paddingValues) {
            this.f6222a = alignment;
            this.b = paddingValues;
        }

        public final void a(BoxScope boxScope, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j jVar, Function0<Unit> onDisplayed, Function0<Unit> onClick, Composer composer, int i) {
            int i2;
            Intrinsics.checkNotNullParameter(boxScope, "<this>");
            Intrinsics.checkNotNullParameter(onDisplayed, "onDisplayed");
            Intrinsics.checkNotNullParameter(onClick, "onClick");
            if ((i & 6) == 0) {
                i2 = (composer.changed(boxScope) ? 4 : 2) | i;
            } else {
                i2 = i;
            }
            if ((i & 48) == 0) {
                i2 |= composer.changed(jVar) ? 32 : 16;
            }
            if ((i & 384) == 0) {
                i2 |= composer.changed(onDisplayed) ? 256 : 128;
            }
            if ((i & 3072) == 0) {
                i2 |= composer.changed(onClick) ? 2048 : 1024;
            }
            if ((i2 & 9363) == 9362 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-903645392, i2, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.defaultVastIcon.<anonymous> (Linear.kt:149)");
            }
            AnimatedVisibilityKt.AnimatedVisibility(jVar != null, PaddingKt.padding(boxScope.align(Modifier.INSTANCE, this.f6222a), this.b), (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.composableLambda(composer, 989733896, true, new a(jVar, onDisplayed, onClick)), composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 28);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }

        @Override // kotlin.jvm.functions.Function6
        public /* bridge */ /* synthetic */ Unit invoke(BoxScope boxScope, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j jVar, Function0<? extends Unit> function0, Function0<? extends Unit> function02, Composer composer, Integer num) {
            a(boxScope, jVar, function0, function02, composer, num.intValue());
            return Unit.INSTANCE;
        }
    }

    public static final Unit a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.k kVar, Function0 function0, Modifier modifier, Function7 function7, Function5 function5, Function6 function6, Function7 function72, K k, Function0 function02, int i, int i2, Composer composer, int i3) {
        a(kVar, function0, modifier, function7, function5, function6, function72, k, function02, composer, i | 1, i2);
        return Unit.INSTANCE;
    }

    public static final void b(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    public static final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i c(MutableState<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i> mutableState) {
        return mutableState.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x047f  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x04a0  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0516  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0410  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0521  */
    /* JADX WARN: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x03a9  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x040d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void a(final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.k viewModel, final Function0<Unit> function0, Modifier modifier, final Function7<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function2<? super a.AbstractC0571a.c, ? super a.AbstractC0571a.c.EnumC0573a, Unit>, ? super Function1<? super Boolean, Unit>, ? super Composer, ? super Integer, Unit> function7, final Function5<? super BoxScope, ? super Boolean, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, ? super Composer, ? super Integer, Unit> function5, final Function6<? super BoxScope, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j, ? super Function0<Unit>, ? super Function0<Unit>, ? super Composer, ? super Integer, Unit> function6, final Function7<? super BoxScope, ? super Boolean, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, ? super Function1<? super Boolean, Unit>, ? super Function0<Unit>, ? super Composer, ? super Integer, Unit> function72, final K viewVisibilityTracker, final Function0<Unit> onShouldReplay, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        boolean changed;
        Object rememberedValue;
        Object rememberedValue2;
        Composer.Companion companion;
        final MutableState mutableState;
        Object rememberedValue3;
        final MutableState mutableState2;
        Object rememberedValue4;
        boolean changed2;
        Object rememberedValue5;
        boolean changed3;
        Object rememberedValue6;
        boolean changed4;
        Object rememberedValue7;
        boolean changed5;
        Object rememberedValue8;
        boolean changed6;
        Object rememberedValue9;
        CoroutineContext coroutineContext;
        Composer composer2;
        CoroutineContext coroutineContext2;
        int i4;
        final Modifier modifier3;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(viewVisibilityTracker, "viewVisibilityTracker");
        Intrinsics.checkNotNullParameter(onShouldReplay, "onShouldReplay");
        Composer startRestartGroup = composer.startRestartGroup(-1913678167);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(viewModel) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changed(function0) ? 32 : 16;
        }
        int i5 = i2 & 4;
        if (i5 != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 256 : 128;
            if ((i2 & 8) == 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                i3 |= startRestartGroup.changed(function7) ? 2048 : 1024;
            }
            if ((i2 & 16) == 0) {
                i3 |= 24576;
            } else if ((i & 24576) == 0) {
                i3 |= startRestartGroup.changed(function5) ? 16384 : 8192;
            }
            if ((i2 & 32) == 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                i3 |= startRestartGroup.changed(function6) ? 131072 : 65536;
            }
            if ((i2 & 64) == 0) {
                i3 |= 1572864;
            } else if ((i & 1572864) == 0) {
                i3 |= startRestartGroup.changed(function72) ? 1048576 : 524288;
            }
            if ((i2 & 128) == 0) {
                i3 |= 12582912;
            } else if ((i & 12582912) == 0) {
                i3 |= startRestartGroup.changed(viewVisibilityTracker) ? 8388608 : 4194304;
            }
            if ((i2 & 256) == 0) {
                i3 |= 100663296;
            } else if ((i & 100663296) == 0) {
                i3 |= startRestartGroup.changed(onShouldReplay) ? 67108864 : 33554432;
            }
            if ((38347923 & i3) == 38347922 || !startRestartGroup.getSkipping()) {
                Modifier modifier4 = i5 == 0 ? Modifier.INSTANCE : modifier2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1913678167, i3, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.Linear (Linear.kt:40)");
                }
                Unit unit = Unit.INSTANCE;
                startRestartGroup.startReplaceableGroup(1664827545);
                changed = startRestartGroup.changed(viewModel);
                rememberedValue = startRestartGroup.rememberedValue();
                if (!changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new a(viewModel, null);
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceableGroup();
                EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue, startRestartGroup, 6);
                startRestartGroup.startReplaceableGroup(733328855);
                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(-1323940314);
                Density density = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                Function0<ComposeUiNode> constructor = companion2.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(modifier4);
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
                State collectAsState = SnapshotStateKt.collectAsState(viewModel.Q(), null, startRestartGroup, 0, 1);
                State collectAsState2 = SnapshotStateKt.collectAsState(viewModel.r(), null, startRestartGroup, 0, 1);
                startRestartGroup.startReplaceableGroup(1087103523);
                rememberedValue2 = startRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                if (rememberedValue2 == companion.getEmpty()) {
                    rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                mutableState = (MutableState) rememberedValue2;
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.startReplaceableGroup(1087106315);
                rememberedValue3 = startRestartGroup.rememberedValue();
                if (rememberedValue3 == companion.getEmpty()) {
                    rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(i.b.b, null, 2, null);
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                }
                mutableState2 = (MutableState) rememberedValue3;
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.startReplaceableGroup(1087112304);
                rememberedValue4 = startRestartGroup.rememberedValue();
                if (rememberedValue4 == companion.getEmpty()) {
                    rememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m(Boolean.TRUE), null, 2, null);
                    startRestartGroup.updateRememberedValue(rememberedValue4);
                }
                final MutableState mutableState3 = (MutableState) rememberedValue4;
                startRestartGroup.endReplaceableGroup();
                int i6 = i3;
                String H = viewModel.H();
                boolean M = viewModel.M();
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m<Boolean> a2 = a((MutableState<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m<Boolean>>) mutableState3);
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m<Long> a3 = a((State<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m<Long>>) collectAsState);
                boolean b2 = b((State<Boolean>) collectAsState2);
                startRestartGroup.startReplaceableGroup(1087122634);
                changed2 = startRestartGroup.changed(viewModel) | startRestartGroup.changed(mutableState);
                rememberedValue5 = startRestartGroup.rememberedValue();
                if (!changed2 || rememberedValue5 == companion.getEmpty()) {
                    rememberedValue5 = new Function1() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.h$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return h.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.k.this, mutableState, ((Boolean) obj).booleanValue());
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue5);
                }
                Function1 function1 = (Function1) rememberedValue5;
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.startReplaceableGroup(1087126542);
                changed3 = startRestartGroup.changed(viewModel);
                rememberedValue6 = startRestartGroup.rememberedValue();
                if (!changed3 || rememberedValue6 == companion.getEmpty()) {
                    rememberedValue6 = new Function1() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.h$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return h.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.k.this, ((Boolean) obj).booleanValue());
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue6);
                }
                Function1 function12 = (Function1) rememberedValue6;
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.startReplaceableGroup(1087134824);
                changed4 = startRestartGroup.changed(viewModel) | startRestartGroup.changed(mutableState2);
                rememberedValue7 = startRestartGroup.rememberedValue();
                if (!changed4 || rememberedValue7 == companion.getEmpty()) {
                    rememberedValue7 = new Function1() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.h$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return h.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.k.this, mutableState2, (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i) obj);
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue7);
                }
                Function1 function13 = (Function1) rememberedValue7;
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.startReplaceableGroup(1087138431);
                changed5 = startRestartGroup.changed(viewModel);
                rememberedValue8 = startRestartGroup.rememberedValue();
                if (!changed5 || rememberedValue8 == companion.getEmpty()) {
                    rememberedValue8 = new b(viewModel);
                    startRestartGroup.updateRememberedValue(rememberedValue8);
                }
                startRestartGroup.endReplaceableGroup();
                Function1 function14 = (Function1) ((KFunction) rememberedValue8);
                Modifier matchParentSize = boxScopeInstance.matchParentSize(Modifier.INSTANCE);
                startRestartGroup.startReplaceableGroup(1087142612);
                changed6 = startRestartGroup.changed(function0) | startRestartGroup.changed(viewModel);
                rememberedValue9 = startRestartGroup.rememberedValue();
                if (!changed6 || rememberedValue9 == companion.getEmpty()) {
                    coroutineContext = null;
                    rememberedValue9 = new c(function0, viewModel, null);
                    startRestartGroup.updateRememberedValue(rememberedValue9);
                } else {
                    coroutineContext = null;
                }
                startRestartGroup.endReplaceableGroup();
                CoroutineContext coroutineContext3 = coroutineContext;
                q.a(H, M, a2, a3, b2, function1, function12, viewVisibilityTracker, function13, function14, SuspendingPointerInputFilterKt.pointerInput(matchParentSize, unit, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue9), startRestartGroup, i6 & 29360128, 0, 0);
                composer2 = startRestartGroup;
                composer2.startReplaceableGroup(1087152169);
                if (function72 != null) {
                    composer2.startReplaceableGroup(1376164556);
                    boolean changed7 = composer2.changed(mutableState3);
                    Object rememberedValue10 = composer2.rememberedValue();
                    if (changed7 || rememberedValue10 == companion.getEmpty()) {
                        rememberedValue10 = new Function1() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.h$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return h.a(MutableState.this, ((Boolean) obj).booleanValue());
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue10);
                    }
                    composer2.endReplaceableGroup();
                    function72.invoke(boxScopeInstance, Boolean.valueOf(b((MutableState<Boolean>) mutableState)), c((MutableState<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i>) mutableState2), (Function1) rememberedValue10, onShouldReplay, composer2, Integer.valueOf(((i6 >> 12) & 57344) | 3078));
                }
                composer2.endReplaceableGroup();
                boolean z = (b((MutableState<Boolean>) mutableState) && (c((MutableState<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i>) mutableState2) instanceof i.a)) ? false : true;
                composer2.startReplaceableGroup(1087171337);
                if (function7 != null) {
                    coroutineContext2 = coroutineContext3;
                    i4 = 1;
                } else {
                    Boolean valueOf = Boolean.valueOf(z);
                    Boolean valueOf2 = Boolean.valueOf(b((State<Boolean>) collectAsState2));
                    composer2.startReplaceableGroup(1376183992);
                    boolean changed8 = composer2.changed(viewModel);
                    Object rememberedValue11 = composer2.rememberedValue();
                    if (changed8 || rememberedValue11 == companion.getEmpty()) {
                        rememberedValue11 = new Function2() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.h$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return h.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.k.this, (a.AbstractC0571a.c) obj, (a.AbstractC0571a.c.EnumC0573a) obj2);
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue11);
                    }
                    Function2 function2 = (Function2) rememberedValue11;
                    composer2.endReplaceableGroup();
                    composer2.startReplaceableGroup(1376189411);
                    boolean changed9 = composer2.changed(viewModel);
                    Object rememberedValue12 = composer2.rememberedValue();
                    if (changed9 || rememberedValue12 == companion.getEmpty()) {
                        rememberedValue12 = new d(viewModel);
                        composer2.updateRememberedValue(rememberedValue12);
                    }
                    composer2.endReplaceableGroup();
                    coroutineContext2 = coroutineContext3;
                    i4 = 1;
                    function7.invoke(boxScopeInstance, valueOf, valueOf2, function2, (KFunction) rememberedValue12, composer2, 6);
                    composer2 = composer2;
                }
                composer2.endReplaceableGroup();
                composer2.startReplaceableGroup(1087179946);
                if (function5 != null) {
                    function5.invoke(boxScopeInstance, Boolean.valueOf(b((MutableState<Boolean>) mutableState)), c((MutableState<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i>) mutableState2), composer2, 6);
                }
                composer2.endReplaceableGroup();
                composer2.startReplaceableGroup(1087182738);
                if (function6 != null) {
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j c2 = c((State<? extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j>) SnapshotStateKt.collectAsState(viewModel.O(), coroutineContext2, composer2, 0, i4));
                    composer2.startReplaceableGroup(1376198609);
                    boolean changed10 = composer2.changed(viewModel);
                    Object rememberedValue13 = composer2.rememberedValue();
                    if (changed10 || rememberedValue13 == companion.getEmpty()) {
                        rememberedValue13 = new e(viewModel);
                        composer2.updateRememberedValue(rememberedValue13);
                    }
                    KFunction kFunction = (KFunction) rememberedValue13;
                    composer2.endReplaceableGroup();
                    composer2.startReplaceableGroup(1376200365);
                    boolean changed11 = composer2.changed(viewModel);
                    Object rememberedValue14 = composer2.rememberedValue();
                    if (changed11 || rememberedValue14 == companion.getEmpty()) {
                        rememberedValue14 = new f(viewModel);
                        composer2.updateRememberedValue(rememberedValue14);
                    }
                    composer2.endReplaceableGroup();
                    Composer composer3 = composer2;
                    function6.invoke(boxScopeInstance, c2, kFunction, (KFunction) rememberedValue14, composer3, 6);
                    composer2 = composer3;
                }
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                composer2.endNode();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
            } else {
                startRestartGroup.skipToGroupEnd();
                composer2 = startRestartGroup;
                modifier3 = modifier2;
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
                endRestartGroup.updateScope(new Function2() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.h$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return h.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.k.this, function0, modifier3, function7, function5, function6, function72, viewVisibilityTracker, onShouldReplay, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
                return;
            }
            return;
        }
        modifier2 = modifier;
        if ((i2 & 8) == 0) {
        }
        if ((i2 & 16) == 0) {
        }
        if ((i2 & 32) == 0) {
        }
        if ((i2 & 64) == 0) {
        }
        if ((i2 & 128) == 0) {
        }
        if ((i2 & 256) == 0) {
        }
        if ((38347923 & i3) == 38347922) {
        }
        if (i5 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        Unit unit2 = Unit.INSTANCE;
        startRestartGroup.startReplaceableGroup(1664827545);
        changed = startRestartGroup.changed(viewModel);
        rememberedValue = startRestartGroup.rememberedValue();
        if (!changed) {
        }
        rememberedValue = new a(viewModel, null);
        startRestartGroup.updateRememberedValue(rememberedValue);
        startRestartGroup.endReplaceableGroup();
        EffectsKt.LaunchedEffect(unit2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue, startRestartGroup, 6);
        startRestartGroup.startReplaceableGroup(733328855);
        MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(-1323940314);
        Density density2 = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
        LayoutDirection layoutDirection2 = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration2 = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
        ComposeUiNode.Companion companion22 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor2 = companion22.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf2 = LayoutKt.materializerOf(modifier4);
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
        State collectAsState3 = SnapshotStateKt.collectAsState(viewModel.Q(), null, startRestartGroup, 0, 1);
        State collectAsState22 = SnapshotStateKt.collectAsState(viewModel.r(), null, startRestartGroup, 0, 1);
        startRestartGroup.startReplaceableGroup(1087103523);
        rememberedValue2 = startRestartGroup.rememberedValue();
        companion = Composer.INSTANCE;
        if (rememberedValue2 == companion.getEmpty()) {
        }
        mutableState = (MutableState) rememberedValue2;
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.startReplaceableGroup(1087106315);
        rememberedValue3 = startRestartGroup.rememberedValue();
        if (rememberedValue3 == companion.getEmpty()) {
        }
        mutableState2 = (MutableState) rememberedValue3;
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.startReplaceableGroup(1087112304);
        rememberedValue4 = startRestartGroup.rememberedValue();
        if (rememberedValue4 == companion.getEmpty()) {
        }
        final MutableState mutableState32 = (MutableState) rememberedValue4;
        startRestartGroup.endReplaceableGroup();
        int i62 = i3;
        String H2 = viewModel.H();
        boolean M2 = viewModel.M();
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m<Boolean> a22 = a((MutableState<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m<Boolean>>) mutableState32);
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m<Long> a32 = a((State<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m<Long>>) collectAsState3);
        boolean b22 = b((State<Boolean>) collectAsState22);
        startRestartGroup.startReplaceableGroup(1087122634);
        changed2 = startRestartGroup.changed(viewModel) | startRestartGroup.changed(mutableState);
        rememberedValue5 = startRestartGroup.rememberedValue();
        if (!changed2) {
        }
        rememberedValue5 = new Function1() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.h$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return h.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.k.this, mutableState, ((Boolean) obj).booleanValue());
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue5);
        Function1 function15 = (Function1) rememberedValue5;
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.startReplaceableGroup(1087126542);
        changed3 = startRestartGroup.changed(viewModel);
        rememberedValue6 = startRestartGroup.rememberedValue();
        if (!changed3) {
        }
        rememberedValue6 = new Function1() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.h$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return h.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.k.this, ((Boolean) obj).booleanValue());
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue6);
        Function1 function122 = (Function1) rememberedValue6;
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.startReplaceableGroup(1087134824);
        changed4 = startRestartGroup.changed(viewModel) | startRestartGroup.changed(mutableState2);
        rememberedValue7 = startRestartGroup.rememberedValue();
        if (!changed4) {
        }
        rememberedValue7 = new Function1() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.h$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return h.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.k.this, mutableState2, (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i) obj);
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue7);
        Function1 function132 = (Function1) rememberedValue7;
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.startReplaceableGroup(1087138431);
        changed5 = startRestartGroup.changed(viewModel);
        rememberedValue8 = startRestartGroup.rememberedValue();
        if (!changed5) {
        }
        rememberedValue8 = new b(viewModel);
        startRestartGroup.updateRememberedValue(rememberedValue8);
        startRestartGroup.endReplaceableGroup();
        Function1 function142 = (Function1) ((KFunction) rememberedValue8);
        Modifier matchParentSize2 = boxScopeInstance2.matchParentSize(Modifier.INSTANCE);
        startRestartGroup.startReplaceableGroup(1087142612);
        changed6 = startRestartGroup.changed(function0) | startRestartGroup.changed(viewModel);
        rememberedValue9 = startRestartGroup.rememberedValue();
        if (changed6) {
        }
        coroutineContext = null;
        rememberedValue9 = new c(function0, viewModel, null);
        startRestartGroup.updateRememberedValue(rememberedValue9);
        startRestartGroup.endReplaceableGroup();
        CoroutineContext coroutineContext32 = coroutineContext;
        q.a(H2, M2, a22, a32, b22, function15, function122, viewVisibilityTracker, function132, function142, SuspendingPointerInputFilterKt.pointerInput(matchParentSize2, unit2, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue9), startRestartGroup, i62 & 29360128, 0, 0);
        composer2 = startRestartGroup;
        composer2.startReplaceableGroup(1087152169);
        if (function72 != null) {
        }
        composer2.endReplaceableGroup();
        if (b((MutableState<Boolean>) mutableState)) {
        }
        composer2.startReplaceableGroup(1087171337);
        if (function7 != null) {
        }
        composer2.endReplaceableGroup();
        composer2.startReplaceableGroup(1087179946);
        if (function5 != null) {
        }
        composer2.endReplaceableGroup();
        composer2.startReplaceableGroup(1087182738);
        if (function6 != null) {
        }
        composer2.endReplaceableGroup();
        composer2.endReplaceableGroup();
        composer2.endReplaceableGroup();
        composer2.endNode();
        composer2.endReplaceableGroup();
        composer2.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier3 = modifier4;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    public static final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j c(State<? extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j> state) {
        return state.getValue();
    }

    public static final boolean b(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    public static final boolean b(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    public static final Unit a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.k kVar, MutableState mutableState, boolean z) {
        kVar.d(z);
        b(mutableState, z);
        return Unit.INSTANCE;
    }

    public static final Unit a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.k kVar, boolean z) {
        if (z) {
            kVar.F();
        } else {
            kVar.G();
        }
        return Unit.INSTANCE;
    }

    public static final Unit a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.k kVar, MutableState mutableState, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i it) {
        Intrinsics.checkNotNullParameter(it, "it");
        kVar.a(it);
        a((MutableState<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i>) mutableState, it);
        return Unit.INSTANCE;
    }

    public static final Unit a(MutableState mutableState, boolean z) {
        a((MutableState<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m<Boolean>>) mutableState, (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m<Boolean>) new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m(Boolean.valueOf(z)));
        return Unit.INSTANCE;
    }

    public static final Unit a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.k kVar, a.AbstractC0571a.c button, a.AbstractC0571a.c.EnumC0573a buttonType) {
        Intrinsics.checkNotNullParameter(button, "button");
        Intrinsics.checkNotNullParameter(buttonType, "buttonType");
        kVar.a(button);
        kVar.a(buttonType);
        return Unit.INSTANCE;
    }

    public static final Function6<BoxScope, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j, Function0<Unit>, Function0<Unit>, Composer, Integer, Unit> a(Alignment alignment, PaddingValues paddingValues, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-1318345093);
        if ((i2 & 1) != 0) {
            alignment = Alignment.INSTANCE.getBottomStart();
        }
        if ((i2 & 2) != 0) {
            paddingValues = PaddingKt.m872PaddingValues0680j_4(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.a.a());
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1318345093, i, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.defaultVastIcon (Linear.kt:148)");
        }
        ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer, -903645392, true, new g(alignment, paddingValues));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return composableLambda;
    }

    public static final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m<Long> a(State<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m<Long>> state) {
        return state.getValue();
    }

    public static final void a(MutableState<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i> mutableState, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i iVar) {
        mutableState.setValue(iVar);
    }

    public static final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m<Boolean> a(MutableState<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m<Boolean>> mutableState) {
        return mutableState.getValue();
    }

    public static final void a(MutableState<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m<Boolean>> mutableState, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m<Boolean> mVar) {
        mutableState.setValue(mVar);
    }
}
