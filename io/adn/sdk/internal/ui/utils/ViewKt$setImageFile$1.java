package io.adn.sdk.internal.ui.utils;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: View.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.adn.sdk.internal.ui.utils.ViewKt", f = "View.kt", i = {0}, l = {65}, m = "setImageFile", n = {"$this$setImageFile_u24lambda_u246"}, s = {"L$0"})
/* loaded from: classes7.dex */
final class ViewKt$setImageFile$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    ViewKt$setImageFile$1(Continuation<? super ViewKt$setImageFile$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ViewKt.setImageFile(null, null, this);
    }
}
