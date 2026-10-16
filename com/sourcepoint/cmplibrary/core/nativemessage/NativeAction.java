package com.sourcepoint.cmplibrary.core.nativemessage;

import com.sourcepoint.cmplibrary.exception.CampaignType;
import com.sourcepoint.cmplibrary.model.exposed.NativeMessageActionType;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NativeModel.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\u0015\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\tHÆ\u0003J\t\u0010\u001b\u001a\u00020\u000bHÆ\u0003JG\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006#"}, d2 = {"Lcom/sourcepoint/cmplibrary/core/nativemessage/NativeAction;", "", "text", "", "style", "Lcom/sourcepoint/cmplibrary/core/nativemessage/NativeStyle;", "customField", "", "choiceType", "Lcom/sourcepoint/cmplibrary/model/exposed/NativeMessageActionType;", "legislation", "Lcom/sourcepoint/cmplibrary/exception/CampaignType;", "(Ljava/lang/String;Lcom/sourcepoint/cmplibrary/core/nativemessage/NativeStyle;Ljava/util/Map;Lcom/sourcepoint/cmplibrary/model/exposed/NativeMessageActionType;Lcom/sourcepoint/cmplibrary/exception/CampaignType;)V", "getChoiceType", "()Lcom/sourcepoint/cmplibrary/model/exposed/NativeMessageActionType;", "getCustomField", "()Ljava/util/Map;", "getLegislation", "()Lcom/sourcepoint/cmplibrary/exception/CampaignType;", "getStyle", "()Lcom/sourcepoint/cmplibrary/core/nativemessage/NativeStyle;", "getText", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class NativeAction {
    private final NativeMessageActionType choiceType;
    private final Map<String, String> customField;
    private final CampaignType legislation;
    private final NativeStyle style;
    private final String text;

    public static /* synthetic */ NativeAction copy$default(NativeAction nativeAction, String str, NativeStyle nativeStyle, Map map, NativeMessageActionType nativeMessageActionType, CampaignType campaignType, int i, Object obj) {
        if ((i & 1) != 0) {
            str = nativeAction.text;
        }
        if ((i & 2) != 0) {
            nativeStyle = nativeAction.style;
        }
        if ((i & 4) != 0) {
            map = nativeAction.customField;
        }
        if ((i & 8) != 0) {
            nativeMessageActionType = nativeAction.choiceType;
        }
        if ((i & 16) != 0) {
            campaignType = nativeAction.legislation;
        }
        CampaignType campaignType2 = campaignType;
        Map map2 = map;
        return nativeAction.copy(str, nativeStyle, map2, nativeMessageActionType, campaignType2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getText() {
        return this.text;
    }

    /* renamed from: component2, reason: from getter */
    public final NativeStyle getStyle() {
        return this.style;
    }

    public final Map<String, String> component3() {
        return this.customField;
    }

    /* renamed from: component4, reason: from getter */
    public final NativeMessageActionType getChoiceType() {
        return this.choiceType;
    }

    /* renamed from: component5, reason: from getter */
    public final CampaignType getLegislation() {
        return this.legislation;
    }

    public final NativeAction copy(String text, NativeStyle style, Map<String, String> customField, NativeMessageActionType choiceType, CampaignType legislation) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(customField, "customField");
        Intrinsics.checkNotNullParameter(choiceType, "choiceType");
        Intrinsics.checkNotNullParameter(legislation, "legislation");
        return new NativeAction(text, style, customField, choiceType, legislation);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NativeAction)) {
            return false;
        }
        NativeAction nativeAction = (NativeAction) other;
        return Intrinsics.areEqual(this.text, nativeAction.text) && Intrinsics.areEqual(this.style, nativeAction.style) && Intrinsics.areEqual(this.customField, nativeAction.customField) && this.choiceType == nativeAction.choiceType && this.legislation == nativeAction.legislation;
    }

    public int hashCode() {
        return (((((((this.text.hashCode() * 31) + this.style.hashCode()) * 31) + this.customField.hashCode()) * 31) + this.choiceType.hashCode()) * 31) + this.legislation.hashCode();
    }

    public String toString() {
        return "NativeAction(text=" + this.text + ", style=" + this.style + ", customField=" + this.customField + ", choiceType=" + this.choiceType + ", legislation=" + this.legislation + ")";
    }

    public NativeAction(String text, NativeStyle style, Map<String, String> customField, NativeMessageActionType choiceType, CampaignType legislation) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(customField, "customField");
        Intrinsics.checkNotNullParameter(choiceType, "choiceType");
        Intrinsics.checkNotNullParameter(legislation, "legislation");
        this.text = text;
        this.style = style;
        this.customField = customField;
        this.choiceType = choiceType;
        this.legislation = legislation;
    }

    public final String getText() {
        return this.text;
    }

    public final NativeStyle getStyle() {
        return this.style;
    }

    public /* synthetic */ NativeAction(String str, NativeStyle nativeStyle, Map map, NativeMessageActionType nativeMessageActionType, CampaignType campaignType, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, nativeStyle, (i & 4) != 0 ? MapsKt.emptyMap() : map, (i & 8) != 0 ? NativeMessageActionType.UNKNOWN : nativeMessageActionType, campaignType);
    }

    public final Map<String, String> getCustomField() {
        return this.customField;
    }

    public final NativeMessageActionType getChoiceType() {
        return this.choiceType;
    }

    public final CampaignType getLegislation() {
        return this.legislation;
    }
}
