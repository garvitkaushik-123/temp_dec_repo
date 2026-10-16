package com.sourcepoint.cmplibrary.core.nativemessage;

import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NativeModel.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0015\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0003J7\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/sourcepoint/cmplibrary/core/nativemessage/NativeComponent;", "", "text", "", "style", "Lcom/sourcepoint/cmplibrary/core/nativemessage/NativeStyle;", "customField", "", "(Ljava/lang/String;Lcom/sourcepoint/cmplibrary/core/nativemessage/NativeStyle;Ljava/util/Map;)V", "getCustomField", "()Ljava/util/Map;", "getStyle", "()Lcom/sourcepoint/cmplibrary/core/nativemessage/NativeStyle;", "getText", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class NativeComponent {
    private final Map<String, String> customField;
    private final NativeStyle style;
    private final String text;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ NativeComponent copy$default(NativeComponent nativeComponent, String str, NativeStyle nativeStyle, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            str = nativeComponent.text;
        }
        if ((i & 2) != 0) {
            nativeStyle = nativeComponent.style;
        }
        if ((i & 4) != 0) {
            map = nativeComponent.customField;
        }
        return nativeComponent.copy(str, nativeStyle, map);
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

    public final NativeComponent copy(String text, NativeStyle style, Map<String, String> customField) {
        Intrinsics.checkNotNullParameter(customField, "customField");
        return new NativeComponent(text, style, customField);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NativeComponent)) {
            return false;
        }
        NativeComponent nativeComponent = (NativeComponent) other;
        return Intrinsics.areEqual(this.text, nativeComponent.text) && Intrinsics.areEqual(this.style, nativeComponent.style) && Intrinsics.areEqual(this.customField, nativeComponent.customField);
    }

    public int hashCode() {
        String str = this.text;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        NativeStyle nativeStyle = this.style;
        return ((hashCode + (nativeStyle != null ? nativeStyle.hashCode() : 0)) * 31) + this.customField.hashCode();
    }

    public String toString() {
        return "NativeComponent(text=" + this.text + ", style=" + this.style + ", customField=" + this.customField + ")";
    }

    public NativeComponent(String str, NativeStyle nativeStyle, Map<String, String> customField) {
        Intrinsics.checkNotNullParameter(customField, "customField");
        this.text = str;
        this.style = nativeStyle;
        this.customField = customField;
    }

    public final String getText() {
        return this.text;
    }

    public final NativeStyle getStyle() {
        return this.style;
    }

    public /* synthetic */ NativeComponent(String str, NativeStyle nativeStyle, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, nativeStyle, (i & 4) != 0 ? MapsKt.emptyMap() : map);
    }

    public final Map<String, String> getCustomField() {
        return this.customField;
    }
}
