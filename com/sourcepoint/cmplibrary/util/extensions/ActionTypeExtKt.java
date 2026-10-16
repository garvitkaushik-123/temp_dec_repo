package com.sourcepoint.cmplibrary.util.extensions;

import com.sourcepoint.cmplibrary.model.exposed.ActionType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ActionTypeExt.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"isAcceptOrRejectAll", "", "Lcom/sourcepoint/cmplibrary/model/exposed/ActionType;", "cmplibrary_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ActionTypeExtKt {
    public static final boolean isAcceptOrRejectAll(ActionType actionType) {
        Intrinsics.checkNotNullParameter(actionType, "<this>");
        return actionType == ActionType.ACCEPT_ALL || actionType == ActionType.REJECT_ALL;
    }
}
