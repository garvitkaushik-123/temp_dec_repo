package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* loaded from: classes6.dex */
public final class u implements com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.k {
    public static final int j = 8;

    /* renamed from: a, reason: collision with root package name */
    public final View f5912a;
    public final CoroutineScope b;
    public Job c;
    public final View.OnLayoutChangeListener d;
    public final MutableStateFlow<Boolean> e;
    public final StateFlow<Boolean> f;
    public final s g;
    public final MutableStateFlow<a> h;
    public final StateFlow<a> i;

    public static final class a {
        public static final int b = 8;

        /* renamed from: a, reason: collision with root package name */
        public final s f5913a;

        public a(s value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.f5913a = value;
        }

        public final s a() {
            return this.f5913a;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.MraidViewVisualMetricsTracker$layoutChangeListener$1$1", f = "MraidViewVisualMetricsTracker.kt", i = {}, l = {41}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f5914a;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;
        public final /* synthetic */ int e;
        public final /* synthetic */ int f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(int i, int i2, int i3, int i4, Continuation<? super b> continuation) {
            super(2, continuation);
            this.c = i;
            this.d = i2;
            this.e = i3;
            this.f = i4;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return u.this.new b(this.c, this.d, this.e, this.f, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f5914a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.f5914a = 1;
                if (DelayKt.delay(200L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            u.this.o();
            u.this.a(this.c, this.d, this.e, this.f);
            return Unit.INSTANCE;
        }
    }

    public u(View view, Context context, CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.f5912a = view;
        this.b = CoroutineScopeKt.plus(scope, com.moloco.sdk.internal.scheduling.b.a().getMain());
        View.OnLayoutChangeListener onLayoutChangeListener = new View.OnLayoutChangeListener() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.u$$ExternalSyntheticLambda0
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view2, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                u.a(u.this, view2, i, i2, i3, i4, i5, i6, i7, i8);
            }
        };
        this.d = onLayoutChangeListener;
        view.addOnLayoutChangeListener(onLayoutChangeListener);
        MutableStateFlow<Boolean> MutableStateFlow = StateFlowKt.MutableStateFlow(Boolean.FALSE);
        this.e = MutableStateFlow;
        this.f = MutableStateFlow;
        s sVar = new s(context);
        this.g = sVar;
        MutableStateFlow<a> MutableStateFlow2 = StateFlowKt.MutableStateFlow(new a(sVar));
        this.h = MutableStateFlow2;
        this.i = MutableStateFlow2;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.k
    public void destroy() {
        Job job = this.c;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.f5912a.removeOnLayoutChangeListener(this.d);
    }

    public final StateFlow<a> k() {
        return this.i;
    }

    public final StateFlow<Boolean> m() {
        return this.f;
    }

    public final void o() {
        this.e.setValue(Boolean.valueOf(this.f5912a.isShown()));
    }

    public static final void a(u uVar, View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        Job launch$default;
        Job job = uVar.c;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        launch$default = BuildersKt__Builders_commonKt.launch$default(uVar.b, null, null, uVar.new b(i, i2, i3, i4, null), 3, null);
        uVar.c = launch$default;
    }

    public final void a(int i, int i2, int i3, int i4) {
        Rect rect = new Rect(i, i2, i3, i4);
        int width = rect.width();
        int height = rect.height();
        s sVar = this.g;
        sVar.a(i, i2, width, height);
        sVar.b(i, i2, width, height);
        sVar.c(i, i2, width, height);
        sVar.a(width, height);
        this.h.setValue(new a(this.g));
    }
}
