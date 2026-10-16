package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* compiled from: TimePicker.kt */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.TimePickerState$update$2", f = "TimePicker.kt", i = {}, l = {689, 691}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
final class TimePickerState$update$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $fromTap;
    final /* synthetic */ float $value;
    int label;
    final /* synthetic */ TimePickerState this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TimePickerState$update$2(TimePickerState timePickerState, float f, boolean z, Continuation<? super TimePickerState$update$2> continuation) {
        super(1, continuation);
        this.this$0 = timePickerState;
        this.$value = f;
        this.$fromTap = z;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new TimePickerState$update$2(this.this$0, this.$value, this.$fromTap, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((TimePickerState$update$2) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x008e, code lost:
    
        if (r7.this$0.getCurrentAngle$material3_release().snapTo(kotlin.coroutines.jvm.internal.Boxing.boxFloat(r7.this$0.getMinuteAngle$material3_release()), r7) == r0) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x00ae, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00ac, code lost:
    
        if (r8.snapTo(kotlin.coroutines.jvm.internal.Boxing.boxFloat(r1), r7) == r0) goto L24;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        int minute;
        int minute2;
        int minute3;
        float offsetHour;
        int hour;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (Selection.m2501equalsimpl0(this.this$0.m2829getSelectionJiIwxys$material3_release(), Selection.INSTANCE.m2505getHourJiIwxys())) {
                TimePickerState timePickerState = this.this$0;
                hour = timePickerState.toHour(this.$value);
                timePickerState.setHourAngle$material3_release((hour % 12) * 0.5235988f);
            } else if (this.$fromTap) {
                TimePickerState timePickerState2 = this.this$0;
                minute2 = timePickerState2.toMinute(this.$value);
                minute3 = this.this$0.toMinute(this.$value);
                timePickerState2.setMinuteAngle$material3_release((minute2 - (minute3 % 5)) * 0.10471976f);
            } else {
                TimePickerState timePickerState3 = this.this$0;
                minute = timePickerState3.toMinute(this.$value);
                timePickerState3.setMinuteAngle$material3_release(minute * 0.10471976f);
            }
            if (this.$fromTap) {
                this.label = 1;
            } else {
                Animatable<Float, AnimationVector1D> currentAngle$material3_release = this.this$0.getCurrentAngle$material3_release();
                offsetHour = this.this$0.offsetHour(this.$value);
                this.label = 2;
            }
        } else {
            if (i != 1 && i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
