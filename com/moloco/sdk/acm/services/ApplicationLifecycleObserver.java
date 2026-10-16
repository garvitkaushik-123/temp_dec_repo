package com.moloco.sdk.acm.services;

import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;
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

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/moloco/sdk/acm/services/ApplicationLifecycleObserver;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "Lcom/moloco/sdk/acm/eventprocessing/c;", "dbWorkRequest", "Lkotlinx/coroutines/CoroutineScope;", "scope", "<init>", "(Lcom/moloco/sdk/acm/eventprocessing/c;Lkotlinx/coroutines/CoroutineScope;)V", "Landroidx/lifecycle/LifecycleOwner;", "owner", "", "onStop", "(Landroidx/lifecycle/LifecycleOwner;)V", "a", "Lcom/moloco/sdk/acm/eventprocessing/c;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lkotlinx/coroutines/CoroutineScope;", "moloco-android-client-metrics_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes6.dex */
public final class ApplicationLifecycleObserver implements DefaultLifecycleObserver {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final com.moloco.sdk.acm.eventprocessing.c dbWorkRequest;

    /* renamed from: b, reason: from kotlin metadata */
    public final CoroutineScope scope;

    @DebugMetadata(c = "com.moloco.sdk.acm.services.ApplicationLifecycleObserver$onStop$1", f = "ApplicationLifecycleTracker.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f5354a;

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
            return ApplicationLifecycleObserver.this.new a(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f5354a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            ApplicationLifecycleObserver.this.dbWorkRequest.a();
            return Unit.INSTANCE;
        }
    }

    public ApplicationLifecycleObserver(com.moloco.sdk.acm.eventprocessing.c dbWorkRequest, CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(dbWorkRequest, "dbWorkRequest");
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.dbWorkRequest = dbWorkRequest;
        this.scope = scope;
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onStop(LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        super.onStop(owner);
        e.a(e.f5359a, d.f5358a, "Application onStop", false, 4, null);
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new a(null), 3, null);
    }
}
