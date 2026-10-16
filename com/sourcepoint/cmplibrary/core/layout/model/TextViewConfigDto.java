package com.sourcepoint.cmplibrary.core.layout.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: NativeMessageDto.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003J-\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0007HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001f"}, d2 = {"Lcom/sourcepoint/cmplibrary/core/layout/model/TextViewConfigDto;", "", "customFields", "Lorg/json/JSONObject;", "style", "Lcom/sourcepoint/cmplibrary/core/layout/model/StyleDto;", "text", "", "(Lorg/json/JSONObject;Lcom/sourcepoint/cmplibrary/core/layout/model/StyleDto;Ljava/lang/String;)V", "getCustomFields", "()Lorg/json/JSONObject;", "setCustomFields", "(Lorg/json/JSONObject;)V", "getStyle", "()Lcom/sourcepoint/cmplibrary/core/layout/model/StyleDto;", "setStyle", "(Lcom/sourcepoint/cmplibrary/core/layout/model/StyleDto;)V", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class TextViewConfigDto {
    private JSONObject customFields;
    private StyleDto style;
    private String text;

    public TextViewConfigDto() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ TextViewConfigDto copy$default(TextViewConfigDto textViewConfigDto, JSONObject jSONObject, StyleDto styleDto, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            jSONObject = textViewConfigDto.customFields;
        }
        if ((i & 2) != 0) {
            styleDto = textViewConfigDto.style;
        }
        if ((i & 4) != 0) {
            str = textViewConfigDto.text;
        }
        return textViewConfigDto.copy(jSONObject, styleDto, str);
    }

    /* renamed from: component1, reason: from getter */
    public final JSONObject getCustomFields() {
        return this.customFields;
    }

    /* renamed from: component2, reason: from getter */
    public final StyleDto getStyle() {
        return this.style;
    }

    /* renamed from: component3, reason: from getter */
    public final String getText() {
        return this.text;
    }

    public final TextViewConfigDto copy(JSONObject customFields, StyleDto style, String text) {
        return new TextViewConfigDto(customFields, style, text);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TextViewConfigDto)) {
            return false;
        }
        TextViewConfigDto textViewConfigDto = (TextViewConfigDto) other;
        return Intrinsics.areEqual(this.customFields, textViewConfigDto.customFields) && Intrinsics.areEqual(this.style, textViewConfigDto.style) && Intrinsics.areEqual(this.text, textViewConfigDto.text);
    }

    public int hashCode() {
        JSONObject jSONObject = this.customFields;
        int hashCode = (jSONObject == null ? 0 : jSONObject.hashCode()) * 31;
        StyleDto styleDto = this.style;
        int hashCode2 = (hashCode + (styleDto == null ? 0 : styleDto.hashCode())) * 31;
        String str = this.text;
        return hashCode2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "TextViewConfigDto(customFields=" + this.customFields + ", style=" + this.style + ", text=" + this.text + ")";
    }

    public TextViewConfigDto(JSONObject jSONObject, StyleDto styleDto, String str) {
        this.customFields = jSONObject;
        this.style = styleDto;
        this.text = str;
    }

    public /* synthetic */ TextViewConfigDto(JSONObject jSONObject, StyleDto styleDto, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : jSONObject, (i & 2) != 0 ? null : styleDto, (i & 4) != 0 ? null : str);
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
