package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.events.handlers;

import com.moloco.sdk.internal.MolocoLogger;
import java.util.Set;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public final class h implements com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.events.a {
    public static final int d = 8;

    /* renamed from: a, reason: collision with root package name */
    public final CoroutineScope f5988a;
    public final MutableSharedFlow<Boolean> b;
    public final SharedFlow<Boolean> c;

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.events.handlers.RequiredContentEventHandler$handleEvent$1", f = "RequiredContentEventHandler.kt", i = {}, l = {33}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f5989a;

        public a(Continuation<? super a> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return h.this.new a(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f5989a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MolocoLogger.info$default(MolocoLogger.INSTANCE, h.this.b(), "Content loaded event emitting", null, false, 12, null);
                MutableSharedFlow mutableSharedFlow = h.this.b;
                Boolean boxBoolean = Boxing.boxBoolean(true);
                this.f5989a = 1;
                if (mutableSharedFlow.emit(boxBoolean, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            MolocoLogger.info$default(MolocoLogger.INSTANCE, h.this.b(), "Content loaded event emitted", null, false, 12, null);
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.events.handlers.RequiredContentEventHandler$handleEvent$2", f = "RequiredContentEventHandler.kt", i = {}, l = {39}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f5990a;

        public b(Continuation<? super b> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return h.this.new b(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f5990a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MutableSharedFlow mutableSharedFlow = h.this.b;
                Boolean boxBoolean = Boxing.boxBoolean(false);
                this.f5990a = 1;
                if (mutableSharedFlow.emit(boxBoolean, this) == coroutine_suspended) {
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

    /* JADX WARN: Multi-variable type inference failed */
    public h() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.events.a
    public String b() {
        return "RequiredContentEventHandler";
    }

    public final SharedFlow<Boolean> c() {
        return this.c;
    }

    public h(CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.f5988a = scope;
        MutableSharedFlow<Boolean> MutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(1, 0, null, 6, null);
        this.b = MutableSharedFlow$default;
        this.c = MutableSharedFlow$default;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.events.a
    public Set<String> a() {
        return SetsKt.setOf((Object[]) new String[]{"requiredContentLoaded", "requiredContentError"});
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.events.a
    public void a(JSONObject event) {
        Intrinsics.checkNotNullParameter(event, "event");
        String string = event.getString("event");
        if (Intrinsics.areEqual(string, "requiredContentLoaded")) {
            BuildersKt__Builders_commonKt.launch$default(this.f5988a, null, null, new a(null), 3, null);
        } else if (Intrinsics.areEqual(string, "requiredContentError")) {
            BuildersKt__Builders_commonKt.launch$default(this.f5988a, null, null, new b(null), 3, null);
        } else {
            MolocoLogger.debug$default(MolocoLogger.INSTANCE, b(), "Event not handled: " + string, false, 4, null);
            Unit unit = Unit.INSTANCE;
        }
    }

    public /* synthetic */ h(CoroutineScope coroutineScope, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CoroutineScopeKt.CoroutineScope(com.moloco.sdk.internal.scheduling.b.a().getMain()) : coroutineScope);
    }
}
