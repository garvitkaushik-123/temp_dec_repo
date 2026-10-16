package com.sourcepoint.cmplibrary.core.layout.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.Regex;

/* compiled from: NativeMessageDto.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000e\u0018\u00002\u00020\u0001BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0014\u001a\u00020\u0003H\u0002R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006\u0015"}, d2 = {"Lcom/sourcepoint/cmplibrary/core/layout/model/StyleDto;", "", "pBackgroundColor", "", "color", "fontFamily", "fontSize", "", "fontWeight", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "backgroundColor", "getBackgroundColor", "()Ljava/lang/String;", "getColor", "getFontFamily", "getFontSize", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getFontWeight", "getSixDigitHexValue", "colorString", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class StyleDto {
    private final String backgroundColor;
    private final String color;
    private final String fontFamily;
    private final Integer fontSize;
    private final String fontWeight;

    public StyleDto() {
        this(null, null, null, null, null, 31, null);
    }

    public StyleDto(String str, String str2, String str3, Integer num, String str4) {
        this.color = str2;
        this.fontFamily = str3;
        this.fontSize = num;
        this.fontWeight = str4;
        this.backgroundColor = str != null ? getSixDigitHexValue(str) : null;
    }

    public /* synthetic */ StyleDto(String str, String str2, String str3, Integer num, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : num, (i & 16) != 0 ? null : str4);
    }

    public final String getColor() {
        return this.color;
    }

    public final String getFontFamily() {
        return this.fontFamily;
    }

    public final Integer getFontSize() {
        return this.fontSize;
    }

    public final String getFontWeight() {
        return this.fontWeight;
    }

    public final String getBackgroundColor() {
        return this.backgroundColor;
    }

    private final String getSixDigitHexValue(String colorString) {
        if (colorString.length() != 4) {
            return colorString;
        }
        return new Regex("#([0-9a-fA-F])([0-9a-fA-F])([0-9a-fA-F])").replace(colorString, "#$1$1$2$2$3$3");
    }
}
