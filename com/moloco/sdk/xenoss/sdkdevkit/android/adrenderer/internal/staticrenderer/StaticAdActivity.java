package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import androidx.activity.ComponentActivity;
import androidx.activity.compose.ComponentActivityKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.unit.Dp;
import com.ironsource.C3207n2;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.f;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.r;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.z;
import com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function9;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000 \n2\u00020\u0001:\u0001\nB\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\t\u0010\u0003¨\u0006\u000b"}, d2 = {"Lcom/moloco/sdk/xenoss/sdkdevkit/android/adrenderer/internal/staticrenderer/StaticAdActivity;", "Landroidx/activity/ComponentActivity;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "onDestroy", "a", "moloco-sdk_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes6.dex */
public final class StaticAdActivity extends ComponentActivity {
    public static final int b = 0;
    public static Function9<? super Context, ? super WebView, ? super Integer, ? super MutableStateFlow<Boolean>, ? super Function1<? super a.AbstractC0571a.c, Unit>, ? super Function0<Unit>, ? super z, ? super Dp, ? super Boolean, ? extends View> c;
    public static a d;
    public static StaticAdActivity e;
    public static Function0<Unit> f;
    public static z h;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final MutableStateFlow<Boolean> g = StateFlowKt.MutableStateFlow(Boolean.FALSE);

    /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.StaticAdActivity$a, reason: from kotlin metadata */
    public static final class Companion {

        @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.StaticAdActivity$Companion", f = "StaticAdActivity.kt", i = {0}, l = {99}, m = C3207n2.v, n = {"this"}, s = {"L$0"})
        /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.StaticAdActivity$a$a, reason: collision with other inner class name */
        public static final class C0491a extends ContinuationImpl {

            /* renamed from: a, reason: collision with root package name */
            public Object f5930a;
            public /* synthetic */ Object b;
            public int d;

            public C0491a(Continuation<? super C0491a> continuation) {
                super(continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                this.b = obj;
                this.d |= Integer.MIN_VALUE;
                return Companion.this.a(null, null, null, null, null, this);
            }
        }

        @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.StaticAdActivity$Companion$show$3", f = "StaticAdActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.StaticAdActivity$a$b */
        public static final class b extends SuspendLambda implements Function2<Boolean, Continuation<? super Boolean>, Object> {

            /* renamed from: a, reason: collision with root package name */
            public int f5931a;
            public /* synthetic */ boolean b;

            public b(Continuation<? super b> continuation) {
                super(2, continuation);
            }

            public final Object a(boolean z, Continuation<? super Boolean> continuation) {
                return ((b) create(Boolean.valueOf(z), continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                b bVar = new b(continuation);
                bVar.b = ((Boolean) obj).booleanValue();
                return bVar;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Boolean bool, Continuation<? super Boolean> continuation) {
                return a(bool.booleanValue(), continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.f5931a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Boxing.boxBoolean(this.b);
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }

        public final void a() {
            StaticAdActivity.g.setValue(Boolean.TRUE);
        }

        public final void a(a.AbstractC0571a.c cVar) {
            a aVar = StaticAdActivity.d;
            if (aVar != null) {
                aVar.a(cVar);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0097 A[DONT_GENERATE] */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0037  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object a(Context context, a aVar, Function0<Unit> function0, f fVar, z zVar, Continuation<? super Unit> continuation) {
            C0491a c0491a;
            int i;
            try {
                if (continuation instanceof C0491a) {
                    c0491a = (C0491a) continuation;
                    int i2 = c0491a.d;
                    if ((i2 & Integer.MIN_VALUE) != 0) {
                        c0491a.d = i2 - Integer.MIN_VALUE;
                        Object obj = c0491a.b;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        i = c0491a.d;
                        if (i != 0) {
                            ResultKt.throwOnFailure(obj);
                            StaticAdActivity.h = zVar;
                            Companion companion = StaticAdActivity.INSTANCE;
                            StaticAdActivity.d = aVar;
                            StaticAdActivity.c = fVar.a();
                            StaticAdActivity.f = function0;
                            Intent intent = new Intent(context, (Class<?>) StaticAdActivity.class);
                            r.a(intent, fVar.b());
                            intent.setFlags(268435456);
                            context.startActivity(intent);
                            MutableStateFlow mutableStateFlow = StaticAdActivity.g;
                            b bVar = new b(null);
                            c0491a.f5930a = this;
                            c0491a.d = 1;
                            obj = FlowKt.first(mutableStateFlow, bVar, c0491a);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                        }
                        ((Boolean) obj).booleanValue();
                        return Unit.INSTANCE;
                    }
                }
                if (i != 0) {
                }
                ((Boolean) obj).booleanValue();
                return Unit.INSTANCE;
            } finally {
                StaticAdActivity.g.setValue(Boxing.boxBoolean(false));
                Companion companion2 = StaticAdActivity.INSTANCE;
                StaticAdActivity.f = null;
                StaticAdActivity.d = null;
                StaticAdActivity.c = null;
                StaticAdActivity staticAdActivity = StaticAdActivity.e;
                if (staticAdActivity != null) {
                    staticAdActivity.finish();
                }
            }
            c0491a = new C0491a(continuation);
            Object obj2 = c0491a.b;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            i = c0491a.d;
        }
    }

    public static final class b implements Function2<Composer, Integer, Unit> {
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.a b;
        public final /* synthetic */ Function9<Context, WebView, Integer, MutableStateFlow<Boolean>, Function1<? super a.AbstractC0571a.c, Unit>, Function0<Unit>, z, Dp, Boolean, View> c;

        public /* synthetic */ class a extends FunctionReferenceImpl implements Function1<a.AbstractC0571a.c, Unit> {
            public a(Object obj) {
                super(1, obj, Companion.class, "onButtonRendered", "onButtonRendered(Lcom/moloco/sdk/xenoss/sdkdevkit/android/core/services/CustomUserEventBuilderService$UserInteraction$Button;)V", 0);
            }

            public final void a(a.AbstractC0571a.c p0) {
                Intrinsics.checkNotNullParameter(p0, "p0");
                ((Companion) this.receiver).a(p0);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(a.AbstractC0571a.c cVar) {
                a(cVar);
                return Unit.INSTANCE;
            }
        }

        /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.StaticAdActivity$b$b, reason: collision with other inner class name */
        public /* synthetic */ class C0492b extends FunctionReferenceImpl implements Function0<Unit> {
            public C0492b(Object obj) {
                super(0, obj, Companion.class, "dismiss", "dismiss()V", 0);
            }

            public final void a() {
                ((Companion) this.receiver).a();
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                a();
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.a aVar, Function9<? super Context, ? super WebView, ? super Integer, ? super MutableStateFlow<Boolean>, ? super Function1<? super a.AbstractC0571a.c, Unit>, ? super Function0<Unit>, ? super z, ? super Dp, ? super Boolean, ? extends View> function9) {
            this.b = aVar;
            this.c = function9;
        }

        public final void a(Composer composer, int i) {
            if ((i & 3) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1193619358, i, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.StaticAdActivity.onCreate.<anonymous> (StaticAdActivity.kt:38)");
            }
            StaticAdActivity staticAdActivity = StaticAdActivity.this;
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.a aVar = this.b;
            Intent intent = staticAdActivity.getIntent();
            Intrinsics.checkNotNullExpressionValue(intent, "getIntent(...)");
            int c = r.c(intent);
            Companion companion = StaticAdActivity.INSTANCE;
            composer.startReplaceableGroup(-1212657475);
            boolean changed = composer.changed(companion);
            Object rememberedValue = composer.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new a(companion);
                composer.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceableGroup();
            Function1 function1 = (Function1) ((KFunction) rememberedValue);
            composer.startReplaceableGroup(-1212655916);
            boolean changed2 = composer.changed(companion);
            Object rememberedValue2 = composer.rememberedValue();
            if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new C0492b(companion);
                composer.updateRememberedValue(rememberedValue2);
            }
            composer.endReplaceableGroup();
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.b.a(staticAdActivity, aVar, c, function1, (Function0) ((KFunction) rememberedValue2), this.c, StaticAdActivity.h, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            a(composer, num.intValue());
            return Unit.INSTANCE;
        }
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        com.moloco.sdk.internal.android_context.b.a(getApplicationContext());
        e = this;
        Function9<? super Context, ? super WebView, ? super Integer, ? super MutableStateFlow<Boolean>, ? super Function1<? super a.AbstractC0571a.c, Unit>, ? super Function0<Unit>, ? super z, ? super Dp, ? super Boolean, ? extends View> function9 = c;
        a aVar = d;
        if (aVar == null) {
            MolocoLogger.info$default(MolocoLogger.INSTANCE, "StaticAdActivity", "can't display ad: WebView is missing", null, false, 12, null);
            INSTANCE.a();
        } else if (function9 != null) {
            ComponentActivityKt.setContent$default(this, null, ComposableLambdaKt.composableLambdaInstance(1193619358, true, new b(aVar, function9)), 1, null);
        } else {
            MolocoLogger.info$default(MolocoLogger.INSTANCE, "StaticAdActivity", "can't display ad: StaticRenderer is missing", null, false, 12, null);
            INSTANCE.a();
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        Function0<Unit> function0 = f;
        if (function0 != null) {
            function0.invoke();
        }
        e = null;
    }
}
