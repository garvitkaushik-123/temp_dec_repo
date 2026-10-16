package com.sourcepoint.cmplibrary.core.layout.model;

import android.view.View;
import android.widget.Button;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.sourcepoint.cmplibrary.model.exposed.ActionType;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ActionButton.kt */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\b\u0002\u001aH\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00070\u00062\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\n¨\u0006\f"}, d2 = {"toActionButton", "Lcom/sourcepoint/cmplibrary/core/layout/model/ActionButton;", "Landroid/widget/Button;", "actionType", "Lcom/sourcepoint/cmplibrary/model/exposed/ActionType;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlin/Function1;", "", "map", "", "", "visibilityType", "cmplibrary_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ActionButtonKt {
    public static /* synthetic */ ActionButton toActionButton$default(Button button, ActionType actionType, Function1 function1, Map map, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            map = null;
        }
        if ((i2 & 8) != 0) {
            i = 4;
        }
        return toActionButton(button, actionType, function1, map, i);
    }

    public static final ActionButton toActionButton(Button button, ActionType actionType, final Function1<? super ActionButton, Unit> listener, Map<Integer, ActionButton> map, int i) {
        Intrinsics.checkNotNullParameter(button, "<this>");
        Intrinsics.checkNotNullParameter(actionType, "actionType");
        Intrinsics.checkNotNullParameter(listener, "listener");
        button.setVisibility(i);
        final ActionButton actionButton = new ActionButton(button, actionType.getCode(), null, 4, null);
        actionButton.getButton().setOnClickListener(new View.OnClickListener() { // from class: com.sourcepoint.cmplibrary.core.layout.model.ActionButtonKt$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ActionButtonKt.toActionButton$lambda$1$lambda$0(Function1.this, actionButton, view);
            }
        });
        if (map != null) {
            map.put(Integer.valueOf(actionType.getCode()), actionButton);
        }
        return actionButton;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void toActionButton$lambda$1$lambda$0(Function1 listener, ActionButton this_apply, View view) {
        Intrinsics.checkNotNullParameter(listener, "$listener");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        listener.invoke(this_apply);
    }
}
