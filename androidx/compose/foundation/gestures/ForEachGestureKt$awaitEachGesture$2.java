package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.JobKt;

/* compiled from: ForEachGesture.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.ForEachGestureKt$awaitEachGesture$2", f = "ForEachGesture.kt", i = {0, 1, 2}, l = {104, 107, 112}, m = "invokeSuspend", n = {"$this$awaitPointerEventScope", "$this$awaitPointerEventScope", "$this$awaitPointerEventScope"}, s = {"L$0", "L$0", "L$0"})
/* loaded from: classes.dex */
final class ForEachGestureKt$awaitEachGesture$2 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> $block;
    final /* synthetic */ CoroutineContext $currentContext;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    ForEachGestureKt$awaitEachGesture$2(CoroutineContext coroutineContext, Function2<? super AwaitPointerEventScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super ForEachGestureKt$awaitEachGesture$2> continuation) {
        super(2, continuation);
        this.$currentContext = coroutineContext;
        this.$block = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ForEachGestureKt$awaitEachGesture$2 forEachGestureKt$awaitEachGesture$2 = new ForEachGestureKt$awaitEachGesture$2(this.$currentContext, this.$block, continuation);
        forEachGestureKt$awaitEachGesture$2.L$0 = obj;
        return forEachGestureKt$awaitEachGesture$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
        return ((ForEachGestureKt$awaitEachGesture$2) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x005c, code lost:
    
        if (r8 != r0) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0076, code lost:
    
        if (r8 == r0) goto L34;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0043 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0079  */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v2, types: [androidx.compose.ui.input.pointer.AwaitPointerEventScope, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v3, types: [androidx.compose.ui.input.pointer.AwaitPointerEventScope, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x005c -> B:8:0x0028). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x0076 -> B:8:0x0028). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        AwaitPointerEventScope awaitPointerEventScope;
        AwaitPointerEventScope awaitPointerEventScope2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r1 = this.label;
        try {
        } catch (CancellationException e) {
            e = e;
            if (!JobKt.isActive(this.$currentContext)) {
            }
        }
        if (r1 == 0) {
            ResultKt.throwOnFailure(obj);
            awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
            if (!JobKt.isActive(this.$currentContext)) {
            }
        } else {
            if (r1 != 1) {
                if (r1 == 2) {
                    AwaitPointerEventScope awaitPointerEventScope3 = (AwaitPointerEventScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    awaitPointerEventScope2 = awaitPointerEventScope3;
                } else {
                    if (r1 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AwaitPointerEventScope awaitPointerEventScope4 = (AwaitPointerEventScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    awaitPointerEventScope2 = awaitPointerEventScope4;
                }
                awaitPointerEventScope = awaitPointerEventScope2;
                if (!JobKt.isActive(this.$currentContext)) {
                    try {
                    } catch (CancellationException e2) {
                        r1 = awaitPointerEventScope;
                        e = e2;
                        if (!JobKt.isActive(this.$currentContext)) {
                            this.L$0 = r1;
                            this.label = 3;
                            Object awaitAllPointersUp = ForEachGestureKt.awaitAllPointersUp((AwaitPointerEventScope) r1, this);
                            awaitPointerEventScope2 = r1;
                        } else {
                            throw e;
                        }
                    }
                    Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> function2 = this.$block;
                    this.L$0 = awaitPointerEventScope;
                    this.label = 1;
                    if (function2.invoke(awaitPointerEventScope, this) != coroutine_suspended) {
                        r1 = awaitPointerEventScope;
                        this.L$0 = r1;
                        this.label = 2;
                        Object awaitAllPointersUp2 = ForEachGestureKt.awaitAllPointersUp((AwaitPointerEventScope) r1, this);
                        awaitPointerEventScope2 = r1;
                    }
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
            AwaitPointerEventScope awaitPointerEventScope5 = (AwaitPointerEventScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            r1 = awaitPointerEventScope5;
            this.L$0 = r1;
            this.label = 2;
            Object awaitAllPointersUp22 = ForEachGestureKt.awaitAllPointersUp((AwaitPointerEventScope) r1, this);
            awaitPointerEventScope2 = r1;
        }
    }
}
