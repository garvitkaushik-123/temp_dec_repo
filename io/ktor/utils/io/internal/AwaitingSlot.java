package io.ktor.utils.io.internal;

import androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;

/* compiled from: AwaitingSlot.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0000\b\u0000\u0018\u00002\u00020\u0010B\u0007¢\u0006\u0004\b\u0001\u0010\u0002J\u0017\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\u0002J!\u0010\f\u001a\u00020\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0086@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ!\u0010\u000e\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0082@ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"Lio/ktor/utils/io/internal/AwaitingSlot;", "<init>", "()V", "", "cause", "", "cancel", "(Ljava/lang/Throwable;)V", CampaignEx.JSON_NATIVE_VIDEO_RESUME, "Lkotlin/Function0;", "", "sleepCondition", "sleep", "(Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "trySuspend", "ktor-io", ""}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class AwaitingSlot {
    private static final /* synthetic */ AtomicReferenceFieldUpdater suspension$FU = AtomicReferenceFieldUpdater.newUpdater(AwaitingSlot.class, Object.class, "suspension");
    private volatile /* synthetic */ Object suspension = null;

    /* JADX WARN: Removed duplicated region for block: B:12:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object sleep(Function0<Boolean> function0, Continuation<? super Unit> continuation) {
        AwaitingSlot$sleep$1 awaitingSlot$sleep$1;
        Object obj;
        int i;
        AwaitingSlot awaitingSlot;
        if (continuation instanceof AwaitingSlot$sleep$1) {
            awaitingSlot$sleep$1 = (AwaitingSlot$sleep$1) continuation;
            if ((awaitingSlot$sleep$1.label & Integer.MIN_VALUE) != 0) {
                awaitingSlot$sleep$1.label -= Integer.MIN_VALUE;
                obj = awaitingSlot$sleep$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = awaitingSlot$sleep$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    awaitingSlot$sleep$1.L$0 = this;
                    awaitingSlot$sleep$1.label = 1;
                    obj = trySuspend(function0, awaitingSlot$sleep$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    awaitingSlot = this;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    awaitingSlot = (AwaitingSlot) awaitingSlot$sleep$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                if (!((Boolean) obj).booleanValue()) {
                    return Unit.INSTANCE;
                }
                awaitingSlot.resume();
                return Unit.INSTANCE;
            }
        }
        awaitingSlot$sleep$1 = new AwaitingSlot$sleep$1(this, continuation);
        obj = awaitingSlot$sleep$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = awaitingSlot$sleep$1.label;
        if (i != 0) {
        }
        if (!((Boolean) obj).booleanValue()) {
        }
    }

    public final void resume() {
        CompletableJob completableJob = (CompletableJob) suspension$FU.getAndSet(this, null);
        if (completableJob != null) {
            completableJob.complete();
        }
    }

    public final void cancel(Throwable cause) {
        CompletableJob completableJob = (CompletableJob) suspension$FU.getAndSet(this, null);
        if (completableJob == null) {
            return;
        }
        if (cause != null) {
            completableJob.completeExceptionally(cause);
        } else {
            completableJob.complete();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object trySuspend(Function0<Boolean> function0, Continuation<? super Boolean> continuation) {
        AwaitingSlot$trySuspend$1 awaitingSlot$trySuspend$1;
        int i;
        CompletableJob Job$default;
        int i2;
        if (continuation instanceof AwaitingSlot$trySuspend$1) {
            awaitingSlot$trySuspend$1 = (AwaitingSlot$trySuspend$1) continuation;
            if ((awaitingSlot$trySuspend$1.label & Integer.MIN_VALUE) != 0) {
                awaitingSlot$trySuspend$1.label -= Integer.MIN_VALUE;
                Object obj = awaitingSlot$trySuspend$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = awaitingSlot$trySuspend$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Job$default = JobKt__JobKt.Job$default((Job) null, 1, (Object) null);
                    if (AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(suspension$FU, this, null, Job$default) && function0.invoke().booleanValue()) {
                        awaitingSlot$trySuspend$1.I$0 = 1;
                        awaitingSlot$trySuspend$1.label = 1;
                        if (Job$default.join(awaitingSlot$trySuspend$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    i2 = awaitingSlot$trySuspend$1.I$0;
                    ResultKt.throwOnFailure(obj);
                }
                return Boxing.boxBoolean(i2 != 0);
            }
        }
        awaitingSlot$trySuspend$1 = new AwaitingSlot$trySuspend$1(this, continuation);
        Object obj2 = awaitingSlot$trySuspend$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = awaitingSlot$trySuspend$1.label;
        if (i != 0) {
        }
        return Boxing.boxBoolean(i2 != 0);
    }
}
