package com.vungle.ads.internal.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ErrorInfo.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/vungle/ads/internal/model/ErrorInfo;", "", "description", "", "errorIsTerminal", "", "isRetryCode", "(Ljava/lang/String;ZZ)V", "getDescription", "()Ljava/lang/String;", "getErrorIsTerminal", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes7.dex */
public final /* data */ class ErrorInfo {
    private final String description;
    private final boolean errorIsTerminal;
    private final boolean isRetryCode;

    public static /* synthetic */ ErrorInfo copy$default(ErrorInfo errorInfo, String str, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = errorInfo.description;
        }
        if ((i & 2) != 0) {
            z = errorInfo.errorIsTerminal;
        }
        if ((i & 4) != 0) {
            z2 = errorInfo.isRetryCode;
        }
        return errorInfo.copy(str, z, z2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getErrorIsTerminal() {
        return this.errorIsTerminal;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getIsRetryCode() {
        return this.isRetryCode;
    }

    public final ErrorInfo copy(String description, boolean errorIsTerminal, boolean isRetryCode) {
        Intrinsics.checkNotNullParameter(description, "description");
        return new ErrorInfo(description, errorIsTerminal, isRetryCode);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ErrorInfo)) {
            return false;
        }
        ErrorInfo errorInfo = (ErrorInfo) other;
        return Intrinsics.areEqual(this.description, errorInfo.description) && this.errorIsTerminal == errorInfo.errorIsTerminal && this.isRetryCode == errorInfo.isRetryCode;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.description.hashCode() * 31;
        boolean z = this.errorIsTerminal;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int i2 = (hashCode + i) * 31;
        boolean z2 = this.isRetryCode;
        return i2 + (z2 ? 1 : z2 ? 1 : 0);
    }

    public String toString() {
        return "ErrorInfo(description=" + this.description + ", errorIsTerminal=" + this.errorIsTerminal + ", isRetryCode=" + this.isRetryCode + ')';
    }

    public ErrorInfo(String description, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(description, "description");
        this.description = description;
        this.errorIsTerminal = z;
        this.isRetryCode = z2;
    }

    public /* synthetic */ ErrorInfo(String str, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? false : z, (i & 4) != 0 ? false : z2);
    }

    public final String getDescription() {
        return this.description;
    }

    public final boolean getErrorIsTerminal() {
        return this.errorIsTerminal;
    }

    public final boolean isRetryCode() {
        return this.isRetryCode;
    }
}
