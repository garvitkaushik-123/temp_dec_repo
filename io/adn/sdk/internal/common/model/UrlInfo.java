package io.adn.sdk.internal.common.model;

import kotlin.Metadata;

/* compiled from: UrlInfo.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J'\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÇ\u0001J\u0013\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u000f\u001a\u00020\u0010H×\u0001J\t\u0010\u0011\u001a\u00020\u0012H×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\b¨\u0006\u0013"}, d2 = {"Lio/adn/sdk/internal/common/model/UrlInfo;", "", "isValid", "", "isHttp", "isDeeplink", "<init>", "(ZZZ)V", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final /* data */ class UrlInfo {
    public static final int $stable = 0;
    private final boolean isDeeplink;
    private final boolean isHttp;
    private final boolean isValid;

    public static /* synthetic */ UrlInfo copy$default(UrlInfo urlInfo, boolean z, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            z = urlInfo.isValid;
        }
        if ((i & 2) != 0) {
            z2 = urlInfo.isHttp;
        }
        if ((i & 4) != 0) {
            z3 = urlInfo.isDeeplink;
        }
        return urlInfo.copy(z, z2, z3);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getIsValid() {
        return this.isValid;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getIsHttp() {
        return this.isHttp;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getIsDeeplink() {
        return this.isDeeplink;
    }

    public final UrlInfo copy(boolean isValid, boolean isHttp, boolean isDeeplink) {
        return new UrlInfo(isValid, isHttp, isDeeplink);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UrlInfo)) {
            return false;
        }
        UrlInfo urlInfo = (UrlInfo) other;
        return this.isValid == urlInfo.isValid && this.isHttp == urlInfo.isHttp && this.isDeeplink == urlInfo.isDeeplink;
    }

    public int hashCode() {
        return (((Boolean.hashCode(this.isValid) * 31) + Boolean.hashCode(this.isHttp)) * 31) + Boolean.hashCode(this.isDeeplink);
    }

    public String toString() {
        return "UrlInfo(isValid=" + this.isValid + ", isHttp=" + this.isHttp + ", isDeeplink=" + this.isDeeplink + ')';
    }

    public UrlInfo(boolean z, boolean z2, boolean z3) {
        this.isValid = z;
        this.isHttp = z2;
        this.isDeeplink = z3;
    }

    public final boolean isValid() {
        return this.isValid;
    }

    public final boolean isHttp() {
        return this.isHttp;
    }

    public final boolean isDeeplink() {
        return this.isDeeplink;
    }
}
