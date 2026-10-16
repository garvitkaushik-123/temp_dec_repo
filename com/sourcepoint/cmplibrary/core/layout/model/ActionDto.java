package com.sourcepoint.cmplibrary.core.layout.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONObject;

/* compiled from: NativeMessageDto.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\u0018\u00002\u00020\u0001BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bR\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lcom/sourcepoint/cmplibrary/core/layout/model/ActionDto;", "", "choiceId", "", "choiceType", "customFields", "Lorg/json/JSONObject;", "style", "Lcom/sourcepoint/cmplibrary/core/layout/model/StyleDto;", "text", "", "(Ljava/lang/Integer;Ljava/lang/Integer;Lorg/json/JSONObject;Lcom/sourcepoint/cmplibrary/core/layout/model/StyleDto;Ljava/lang/String;)V", "getChoiceId", "()Ljava/lang/Integer;", "setChoiceId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getChoiceType", "setChoiceType", "getCustomFields", "()Lorg/json/JSONObject;", "setCustomFields", "(Lorg/json/JSONObject;)V", "getStyle", "()Lcom/sourcepoint/cmplibrary/core/layout/model/StyleDto;", "setStyle", "(Lcom/sourcepoint/cmplibrary/core/layout/model/StyleDto;)V", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ActionDto {
    private Integer choiceId;
    private Integer choiceType;
    private JSONObject customFields;
    private StyleDto style;
    private String text;

    public ActionDto() {
        this(null, null, null, null, null, 31, null);
    }

    public ActionDto(Integer num, Integer num2, JSONObject jSONObject, StyleDto styleDto, String str) {
        this.choiceId = num;
        this.choiceType = num2;
        this.customFields = jSONObject;
        this.style = styleDto;
        this.text = str;
    }

    public /* synthetic */ ActionDto(Integer num, Integer num2, JSONObject jSONObject, StyleDto styleDto, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : jSONObject, (i & 8) != 0 ? null : styleDto, (i & 16) != 0 ? null : str);
    }

    public final Integer getChoiceId() {
        return this.choiceId;
    }

    public final void setChoiceId(Integer num) {
        this.choiceId = num;
    }

    public final Integer getChoiceType() {
        return this.choiceType;
    }

    public final void setChoiceType(Integer num) {
        this.choiceType = num;
    }

    public final JSONObject getCustomFields() {
        return this.customFields;
    }

    public final void setCustomFields(JSONObject jSONObject) {
        this.customFields = jSONObject;
    }

    public final StyleDto getStyle() {
        return this.style;
    }

    public final void setStyle(StyleDto styleDto) {
        this.style = styleDto;
    }

    public final String getText() {
        return this.text;
    }

    public final void setText(String str) {
        this.text = str;
    }
}
