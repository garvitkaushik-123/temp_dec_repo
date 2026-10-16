package io.adn.sdk.internal.ui.utils;

import android.view.View;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;

/* compiled from: ViewVisibilityTracker.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.adn.sdk.internal.ui.utils.ViewVisibilityTracker$start$1", f = "ViewVisibilityTracker.kt", i = {0}, l = {35}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
/* loaded from: classes7.dex */
final class ViewVisibilityTracker$start$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Float, Unit> $onVisiblePercentChanged;
    final /* synthetic */ View $view;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ViewVisibilityTracker this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    ViewVisibilityTracker$start$1(ViewVisibilityTracker viewVisibilityTracker, View view, Function1<? super Float, Unit> function1, Continuation<? super ViewVisibilityTracker$start$1> continuation) {
        super(2, continuation);
        this.this$0 = viewVisibilityTracker;
        this.$view = view;
        this.$onVisiblePercentChanged = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ViewVisibilityTracker$start$1 viewVisibilityTracker$start$1 = new ViewVisibilityTracker$start$1(this.this$0, this.$view, this.$onVisiblePercentChanged, continuation);
        viewVisibilityTracker$start$1.L$0 = obj;
        return viewVisibilityTracker$start$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ViewVisibilityTracker$start$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0055  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0041 -> B:5:0x0044). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope;
        long j;
        float f;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
            this.this$0.state = TrackerState.Active;
            coroutineScope = coroutineScope2;
            if (CoroutineScopeKt.isActive(coroutineScope)) {
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            coroutineScope = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            float visiblePercent = ViewKt.getVisiblePercent(this.$view);
            f = this.this$0.lastVisiblePercent;
            if (visiblePercent != f) {
                this.this$0.lastVisiblePercent = visiblePercent;
                this.$onVisiblePercentChanged.invoke(Boxing.boxFloat(visiblePercent));
            }
            if (CoroutineScopeKt.isActive(coroutineScope)) {
                j = this.this$0.intervalMs;
                this.L$0 = coroutineScope;
                this.label = 1;
                if (DelayKt.delay(j, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                float visiblePercent2 = ViewKt.getVisiblePercent(this.$view);
                f = this.this$0.lastVisiblePercent;
                if (visiblePercent2 != f) {
                }
                if (CoroutineScopeKt.isActive(coroutineScope)) {
                    return Unit.INSTANCE;
                }
            }
        }
    }
}
