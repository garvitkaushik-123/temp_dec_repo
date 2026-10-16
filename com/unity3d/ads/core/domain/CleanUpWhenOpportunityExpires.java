package com.unity3d.ads.core.domain;

import com.unity3d.ads.core.data.model.AdObject;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.SupervisorKt;

/* compiled from: CleanUpWhenOpportunityExpires.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0011\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0086\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/unity3d/ads/core/domain/CleanUpWhenOpportunityExpires;", "", "defaultDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lkotlinx/coroutines/CoroutineDispatcher;)V", "coroutineExceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "", "adObject", "Lcom/unity3d/ads/core/data/model/AdObject;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class CleanUpWhenOpportunityExpires {
    private final CoroutineExceptionHandler coroutineExceptionHandler;
    private final CoroutineScope coroutineScope;

    public CleanUpWhenOpportunityExpires(CoroutineDispatcher defaultDispatcher) {
        Intrinsics.checkNotNullParameter(defaultDispatcher, "defaultDispatcher");
        CleanUpWhenOpportunityExpires$special$$inlined$CoroutineExceptionHandler$1 cleanUpWhenOpportunityExpires$special$$inlined$CoroutineExceptionHandler$1 = new CleanUpWhenOpportunityExpires$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.INSTANCE);
        this.coroutineExceptionHandler = cleanUpWhenOpportunityExpires$special$$inlined$CoroutineExceptionHandler$1;
        this.coroutineScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(defaultDispatcher).plus(cleanUpWhenOpportunityExpires$special$$inlined$CoroutineExceptionHandler$1));
    }

    public final void invoke(AdObject adObject) {
        final Job launch$default;
        Intrinsics.checkNotNullParameter(adObject, "adObject");
        if (adObject.getAdPlayer() != null) {
            launch$default = BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new CleanUpWhenOpportunityExpires$invoke$job$1(adObject, null), 3, null);
            JobKt.getJob(adObject.getAdPlayer().getScope().getCoroutineContext()).invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: com.unity3d.ads.core.domain.CleanUpWhenOpportunityExpires$invoke$2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                    invoke2(th);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable th) {
                    Job.DefaultImpls.cancel$default(Job.this, (CancellationException) null, 1, (Object) null);
                }
            });
            return;
        }
        throw new IllegalArgumentException("AdObject does not have an adPlayer.".toString());
    }
}
