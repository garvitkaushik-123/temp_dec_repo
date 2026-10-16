package com.sourcepoint.cmplibrary.core.nativemessage;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NativeModel.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J=\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u001d"}, d2 = {"Lcom/sourcepoint/cmplibrary/core/nativemessage/NativeStyle;", "", "fontFamily", "", "fontWeight", "", "fontSize", "color", "backgroundColor", "(Ljava/lang/String;FFLjava/lang/String;Ljava/lang/String;)V", "getBackgroundColor", "()Ljava/lang/String;", "getColor", "getFontFamily", "getFontSize", "()F", "getFontWeight", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class NativeStyle {
    private final String backgroundColor;
    private final String color;
    private final String fontFamily;
    private final float fontSize;
    private final float fontWeight;

    public static /* synthetic */ NativeStyle copy$default(NativeStyle nativeStyle, String str, float f, float f2, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = nativeStyle.fontFamily;
        }
        if ((i & 2) != 0) {
            f = nativeStyle.fontWeight;
        }
        if ((i & 4) != 0) {
            f2 = nativeStyle.fontSize;
        }
        if ((i & 8) != 0) {
            str2 = nativeStyle.color;
        }
        if ((i & 16) != 0) {
            str3 = nativeStyle.backgroundColor;
        }
        String str4 = str3;
        float f3 = f2;
        return nativeStyle.copy(str, f, f3, str2, str4);
    }

    /* renamed from: component1, reason: from getter */
    public final String getFontFamily() {
        return this.fontFamily;
    }

    /* renamed from: component2, reason: from getter */
    public final float getFontWeight() {
        return this.fontWeight;
    }

    /* renamed from: component3, reason: from getter */
    public final float getFontSize() {
        return this.fontSize;
    }

    /* renamed from: component4, reason: from getter */
    public final String getColor() {
        return this.color;
    }

    /* renamed from: component5, reason: from getter */
    public final String getBackgroundColor() {
        return this.backgroundColor;
    }

    public final NativeStyle copy(String fontFamily, float fontWeight, float fontSize, String color, String backgroundColor) {
        Intrinsics.checkNotNullParameter(fontFamily, "fontFamily");
        Intrinsics.checkNotNullParameter(backgroundColor, "backgroundColor");
        return new NativeStyle(fontFamily, fontWeight, fontSize, color, backgroundColor);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NativeStyle)) {
            return false;
        }
        NativeStyle nativeStyle = (NativeStyle) other;
        return Intrinsics.areEqual(this.fontFamily, nativeStyle.fontFamily) && Float.compare(this.fontWeight, nativeStyle.fontWeight) == 0 && Float.compare(this.fontSize, nativeStyle.fontSize) == 0 && Intrinsics.areEqual(this.color, nativeStyle.color) && Intrinsics.areEqual(this.backgroundColor, nativeStyle.backgroundColor);
    }

    public int hashCode() {
        int hashCode = ((((this.fontFamily.hashCode() * 31) + Float.hashCode(this.fontWeight)) * 31) + Float.hashCode(this.fontSize)) * 31;
        String str = this.color;
        return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.backgroundColor.hashCode();
    }

    public String toString() {
        return "NativeStyle(fontFamily=" + this.fontFamily + ", fontWeight=" + this.fontWeight + ", fontSize=" + this.fontSize + ", color=" + this.color + ", backgroundColor=" + this.backgroundColor + ")";
    }

    public NativeStyle(String fontFamily, float f, float f2, String str, String backgroundColor) {
        Intrinsics.checkNotNullParameter(fontFamily, "fontFamily");
        Intrinsics.checkNotNullParameter(backgroundColor, "backgroundColor");
        this.fontFamily = fontFamily;
        this.fontWeight = f;
        this.fontSize = f2;
        this.color = str;
        this.backgroundColor = backgroundColor;
    }

    public final String getFontFamily() {
        return this.fontFamily;
    }

    public final float getFontWeight() {
        return this.fontWeight;
    }

    public final float getFontSize() {
        return this.fontSize;
    }

    public final String getColor() {
        return this.color;
    }

    public final String getBackgroundColor() {
        return this.backgroundColor;
    }
}
