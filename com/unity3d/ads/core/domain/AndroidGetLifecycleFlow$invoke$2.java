package com.unity3d.ads.core.domain;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;

/* compiled from: AndroidGetLifecycleFlow.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", "Lcom/unity3d/ads/core/domain/LifecycleEvent;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.core.domain.AndroidGetLifecycleFlow$invoke$2", f = "AndroidGetLifecycleFlow.kt", i = {}, l = {64}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
final class AndroidGetLifecycleFlow$invoke$2 extends SuspendLambda implements Function2<ProducerScope<? super LifecycleEvent>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AndroidGetLifecycleFlow this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AndroidGetLifecycleFlow$invoke$2(AndroidGetLifecycleFlow androidGetLifecycleFlow, Continuation<? super AndroidGetLifecycleFlow$invoke$2> continuation) {
        super(2, continuation);
        this.this$0 = androidGetLifecycleFlow;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AndroidGetLifecycleFlow$invoke$2 androidGetLifecycleFlow$invoke$2 = new AndroidGetLifecycleFlow$invoke$2(this.this$0, continuation);
        androidGetLifecycleFlow$invoke$2.L$0 = obj;
        return androidGetLifecycleFlow$invoke$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(ProducerScope<? super LifecycleEvent> producerScope, Continuation<? super Unit> continuation) {
        return ((AndroidGetLifecycleFlow$invoke$2) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.unity3d.ads.core.domain.AndroidGetLifecycleFlow$invoke$2$listener$1] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Context context;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final ProducerScope producerScope = (ProducerScope) this.L$0;
            final ?? r1 = new Application.ActivityLifecycleCallbacks() { // from class: com.unity3d.ads.core.domain.AndroidGetLifecycleFlow$invoke$2$listener$1
                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityCreated(Activity activity, Bundle bundle) {
                    Intrinsics.checkNotNullParameter(activity, "activity");
                    BuildersKt__Builders_commonKt.launch$default(producerScope, null, null, new AndroidGetLifecycleFlow$invoke$2$listener$1$onActivityCreated$1(producerScope, activity, bundle, null), 3, null);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStarted(Activity activity) {
                    Intrinsics.checkNotNullParameter(activity, "activity");
                    BuildersKt__Builders_commonKt.launch$default(producerScope, null, null, new AndroidGetLifecycleFlow$invoke$2$listener$1$onActivityStarted$1(producerScope, activity, null), 3, null);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityResumed(Activity activity) {
                    Intrinsics.checkNotNullParameter(activity, "activity");
                    BuildersKt__Builders_commonKt.launch$default(producerScope, null, null, new AndroidGetLifecycleFlow$invoke$2$listener$1$onActivityResumed$1(producerScope, activity, null), 3, null);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityPaused(Activity activity) {
                    Intrinsics.checkNotNullParameter(activity, "activity");
                    BuildersKt__Builders_commonKt.launch$default(producerScope, null, null, new AndroidGetLifecycleFlow$invoke$2$listener$1$onActivityPaused$1(producerScope, activity, null), 3, null);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStopped(Activity activity) {
                    Intrinsics.checkNotNullParameter(activity, "activity");
                    BuildersKt__Builders_commonKt.launch$default(producerScope, null, null, new AndroidGetLifecycleFlow$invoke$2$listener$1$onActivityStopped$1(producerScope, activity, null), 3, null);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                    Intrinsics.checkNotNullParameter(activity, "activity");
                    Intrinsics.checkNotNullParameter(bundle, "bundle");
                    BuildersKt__Builders_commonKt.launch$default(producerScope, null, null, new AndroidGetLifecycleFlow$invoke$2$listener$1$onActivitySaveInstanceState$1(producerScope, activity, bundle, null), 3, null);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityDestroyed(Activity activity) {
                    Intrinsics.checkNotNullParameter(activity, "activity");
                    BuildersKt__Builders_commonKt.launch$default(producerScope, null, null, new AndroidGetLifecycleFlow$invoke$2$listener$1$onActivityDestroyed$1(producerScope, activity, null), 3, null);
                }
            };
            context = this.this$0.applicationContext;
            ((Application) context).registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks) r1);
            final AndroidGetLifecycleFlow androidGetLifecycleFlow = this.this$0;
            this.label = 1;
            if (ProduceKt.awaitClose(producerScope, new Function0<Unit>() { // from class: com.unity3d.ads.core.domain.AndroidGetLifecycleFlow$invoke$2.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Context context2;
                    context2 = AndroidGetLifecycleFlow.this.applicationContext;
                    ((Application) context2).unregisterActivityLifecycleCallbacks(r1);
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
        return Unit.INSTANCE;
    }
}
