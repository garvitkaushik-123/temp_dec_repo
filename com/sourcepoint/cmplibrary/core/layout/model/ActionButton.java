package com.sourcepoint.cmplibrary.core.layout.model;

import android.widget.Button;
import com.ironsource.Y1;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ActionButton.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J'\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0007HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001e"}, d2 = {"Lcom/sourcepoint/cmplibrary/core/layout/model/ActionButton;", "", "button", "Landroid/widget/Button;", "choiceType", "", "choiceId", "", "(Landroid/widget/Button;ILjava/lang/String;)V", "getButton", "()Landroid/widget/Button;", "setButton", "(Landroid/widget/Button;)V", "getChoiceId", "()Ljava/lang/String;", "setChoiceId", "(Ljava/lang/String;)V", "getChoiceType", "()I", "setChoiceType", "(I)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class ActionButton {
    private Button button;
    private String choiceId;
    private int choiceType;

    public static /* synthetic */ ActionButton copy$default(ActionButton actionButton, Button button, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            button = actionButton.button;
        }
        if ((i2 & 2) != 0) {
            i = actionButton.choiceType;
        }
        if ((i2 & 4) != 0) {
            str = actionButton.choiceId;
        }
        return actionButton.copy(button, i, str);
    }

    /* renamed from: component1, reason: from getter */
    public final Button getButton() {
        return this.button;
    }

    /* renamed from: component2, reason: from getter */
    public final int getChoiceType() {
        return this.choiceType;
    }

    /* renamed from: component3, reason: from getter */
    public final String getChoiceId() {
        return this.choiceId;
    }

    public final ActionButton copy(Button button, int choiceType, String choiceId) {
        Intrinsics.checkNotNullParameter(button, "button");
        Intrinsics.checkNotNullParameter(choiceId, "choiceId");
        return new ActionButton(button, choiceType, choiceId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ActionButton)) {
            return false;
        }
        ActionButton actionButton = (ActionButton) other;
        return Intrinsics.areEqual(this.button, actionButton.button) && this.choiceType == actionButton.choiceType && Intrinsics.areEqual(this.choiceId, actionButton.choiceId);
    }

    public int hashCode() {
        return (((this.button.hashCode() * 31) + Integer.hashCode(this.choiceType)) * 31) + this.choiceId.hashCode();
    }

    public String toString() {
        return "ActionButton(button=" + this.button + ", choiceType=" + this.choiceType + ", choiceId=" + this.choiceId + ")";
    }

    public ActionButton(Button button, int i, String choiceId) {
        Intrinsics.checkNotNullParameter(button, "button");
        Intrinsics.checkNotNullParameter(choiceId, "choiceId");
        this.button = button;
        this.choiceType = i;
        this.choiceId = choiceId;
    }

    public final Button getButton() {
        return this.button;
    }

    public final void setButton(Button button) {
        Intrinsics.checkNotNullParameter(button, "<set-?>");
        this.button = button;
    }

    public final int getChoiceType() {
        return this.choiceType;
    }

    public final void setChoiceType(int i) {
        this.choiceType = i;
    }

    public /* synthetic */ ActionButton(Button button, int i, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(button, (i2 & 2) != 0 ? -1 : i, (i2 & 4) != 0 ? Y1.f : str);
    }

    public final String getChoiceId() {
        return this.choiceId;
    }

    public final void setChoiceId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.choiceId = str;
    }
}
