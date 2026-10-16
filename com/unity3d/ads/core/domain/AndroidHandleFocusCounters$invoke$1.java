package com.unity3d.ads.core.domain;

import android.app.Activity;
import com.unity3d.ads.core.data.repository.FocusState;
import com.unity3d.ads.core.data.repository.SessionRepository;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Reflection;

/* compiled from: AndroidHandleFocusCounters.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "event", "Lcom/unity3d/ads/core/data/repository/FocusState;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.core.domain.AndroidHandleFocusCounters$invoke$1", f = "AndroidHandleFocusCounters.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
final class AndroidHandleFocusCounters$invoke$1 extends SuspendLambda implements Function2<FocusState, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AndroidHandleFocusCounters this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AndroidHandleFocusCounters$invoke$1(AndroidHandleFocusCounters androidHandleFocusCounters, Continuation<? super AndroidHandleFocusCounters$invoke$1> continuation) {
        super(2, continuation);
        this.this$0 = androidHandleFocusCounters;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AndroidHandleFocusCounters$invoke$1 androidHandleFocusCounters$invoke$1 = new AndroidHandleFocusCounters$invoke$1(this.this$0, continuation);
        androidHandleFocusCounters$invoke$1.L$0 = obj;
        return androidHandleFocusCounters$invoke$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FocusState focusState, Continuation<? super Unit> continuation) {
        return ((AndroidHandleFocusCounters$invoke$1) create(focusState, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String str;
        AndroidGetIsAdActivity androidGetIsAdActivity;
        SessionRepository sessionRepository;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            FocusState focusState = (FocusState) this.L$0;
            this.this$0.onFocusStateChange(focusState);
            Activity activity = focusState.getActivity().get();
            if (activity == null || (str = Reflection.getOrCreateKotlinClass(activity.getClass()).getQualifiedName()) == null) {
                str = "unknown_activity_name";
            }
            androidGetIsAdActivity = this.this$0.isAdActivity;
            if (!androidGetIsAdActivity.invoke(str)) {
                return Unit.INSTANCE;
            }
            sessionRepository = this.this$0.sessionRepository;
            sessionRepository.incrementGlobalAdsFocusChangeCount();
            if (focusState instanceof FocusState.Focused) {
                this.this$0.onResume(str);
            } else if (focusState instanceof FocusState.Unfocused) {
                this.this$0.onPause(str);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
