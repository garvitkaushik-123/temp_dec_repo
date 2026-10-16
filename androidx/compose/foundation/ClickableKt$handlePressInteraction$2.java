package androidx.compose.foundation;

import androidx.compose.foundation.AbstractClickableNode;
import androidx.compose.foundation.gestures.PressGestureScope;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import com.vungle.ads.internal.protos.Sdk;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;

/* compiled from: Clickable.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.ClickableKt$handlePressInteraction$2", f = "Clickable.kt", i = {0, 1, 2}, l = {307, Sdk.SDKError.Reason.ASSET_FAILED_TO_DELETE_VALUE, Sdk.SDKError.Reason.GENERATE_JSON_DATA_ERROR_VALUE, Sdk.SDKError.Reason.AD_CLOSED_TEMPLATE_ERROR_VALUE, 326}, m = "invokeSuspend", n = {"delayJob", "success", "release"}, s = {"L$0", "Z$0", "L$0"})
/* loaded from: classes.dex */
final class ClickableKt$handlePressInteraction$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Boolean> $delayPressInteraction;
    final /* synthetic */ AbstractClickableNode.InteractionData $interactionData;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ long $pressPoint;
    final /* synthetic */ PressGestureScope $this_handlePressInteraction;
    private /* synthetic */ Object L$0;
    boolean Z$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ClickableKt$handlePressInteraction$2(PressGestureScope pressGestureScope, long j, MutableInteractionSource mutableInteractionSource, AbstractClickableNode.InteractionData interactionData, Function0<Boolean> function0, Continuation<? super ClickableKt$handlePressInteraction$2> continuation) {
        super(2, continuation);
        this.$this_handlePressInteraction = pressGestureScope;
        this.$pressPoint = j;
        this.$interactionSource = mutableInteractionSource;
        this.$interactionData = interactionData;
        this.$delayPressInteraction = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ClickableKt$handlePressInteraction$2 clickableKt$handlePressInteraction$2 = new ClickableKt$handlePressInteraction$2(this.$this_handlePressInteraction, this.$pressPoint, this.$interactionSource, this.$interactionData, this.$delayPressInteraction, continuation);
        clickableKt$handlePressInteraction$2.L$0 = obj;
        return clickableKt$handlePressInteraction$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ClickableKt$handlePressInteraction$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x00c1, code lost:
    
        if (r17.$interactionSource.emit(r2, r17) != r1) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00e9, code lost:
    
        if (r4.emit(r5, r17) == r1) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0070, code lost:
    
        if (r7 == r1) goto L41;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0093  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Job launch$default;
        Object tryAwaitRelease;
        PressInteraction.Cancel cancel;
        boolean z;
        PressInteraction.Release release;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            launch$default = BuildersKt__Builders_commonKt.launch$default((CoroutineScope) this.L$0, null, null, new ClickableKt$handlePressInteraction$2$delayJob$1(this.$delayPressInteraction, this.$pressPoint, this.$interactionSource, this.$interactionData, null), 3, null);
            this.L$0 = launch$default;
            this.label = 1;
            tryAwaitRelease = this.$this_handlePressInteraction.tryAwaitRelease(this);
        } else if (i == 1) {
            launch$default = (Job) this.L$0;
            ResultKt.throwOnFailure(obj);
            tryAwaitRelease = obj;
        } else {
            if (i == 2) {
                z = this.Z$0;
                ResultKt.throwOnFailure(obj);
                if (z) {
                    PressInteraction.Press press = new PressInteraction.Press(this.$pressPoint, null);
                    PressInteraction.Release release2 = new PressInteraction.Release(press);
                    this.L$0 = release2;
                    this.label = 3;
                    if (this.$interactionSource.emit(press, this) != coroutine_suspended) {
                        release = release2;
                        this.L$0 = null;
                        this.label = 4;
                    }
                    return coroutine_suspended;
                }
                this.$interactionData.setPressInteraction(null);
                return Unit.INSTANCE;
            }
            if (i != 3) {
                if (i != 4 && i != 5) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.$interactionData.setPressInteraction(null);
                return Unit.INSTANCE;
            }
            release = (PressInteraction.Release) this.L$0;
            ResultKt.throwOnFailure(obj);
            this.L$0 = null;
            this.label = 4;
        }
        boolean booleanValue = ((Boolean) tryAwaitRelease).booleanValue();
        if (launch$default.isActive()) {
            this.L$0 = null;
            this.Z$0 = booleanValue;
            this.label = 2;
            if (JobKt.cancelAndJoin(launch$default, this) != coroutine_suspended) {
                z = booleanValue;
                if (z) {
                }
                this.$interactionData.setPressInteraction(null);
                return Unit.INSTANCE;
            }
        } else {
            PressInteraction.Press pressInteraction = this.$interactionData.getPressInteraction();
            if (pressInteraction != null) {
                MutableInteractionSource mutableInteractionSource = this.$interactionSource;
                if (booleanValue) {
                    cancel = new PressInteraction.Release(pressInteraction);
                } else {
                    cancel = new PressInteraction.Cancel(pressInteraction);
                }
                this.L$0 = null;
                this.label = 5;
            }
            this.$interactionData.setPressInteraction(null);
            return Unit.INSTANCE;
        }
        return coroutine_suspended;
    }
}
