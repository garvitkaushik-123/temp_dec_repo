package io.adn.sdk.internal.domain.model.ad;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PostClickData.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0081\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\tHÆ\u0003J=\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\tHÇ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u001d\u001a\u00020\u0005H×\u0001J\t\u0010\u001e\u001a\u00020\u0003H×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lio/adn/sdk/internal/domain/model/ad/PostClickData;", "", "name", "", "sessionIndex", "", "pageIndex", "url", "timeSpent", "", "<init>", "(Ljava/lang/String;IILjava/lang/String;J)V", "getName", "()Ljava/lang/String;", "getSessionIndex", "()I", "getPageIndex", "getUrl", "getTimeSpent", "()J", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final /* data */ class PostClickData {
    public static final int $stable = 0;
    private final String name;
    private final int pageIndex;
    private final int sessionIndex;
    private final long timeSpent;
    private final String url;

    public static /* synthetic */ PostClickData copy$default(PostClickData postClickData, String str, int i, int i2, String str2, long j, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = postClickData.name;
        }
        if ((i3 & 2) != 0) {
            i = postClickData.sessionIndex;
        }
        if ((i3 & 4) != 0) {
            i2 = postClickData.pageIndex;
        }
        if ((i3 & 8) != 0) {
            str2 = postClickData.url;
        }
        if ((i3 & 16) != 0) {
            j = postClickData.timeSpent;
        }
        long j2 = j;
        return postClickData.copy(str, i, i2, str2, j2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component2, reason: from getter */
    public final int getSessionIndex() {
        return this.sessionIndex;
    }

    /* renamed from: component3, reason: from getter */
    public final int getPageIndex() {
        return this.pageIndex;
    }

    /* renamed from: component4, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* renamed from: component5, reason: from getter */
    public final long getTimeSpent() {
        return this.timeSpent;
    }

    public final PostClickData copy(String name, int sessionIndex, int pageIndex, String url, long timeSpent) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new PostClickData(name, sessionIndex, pageIndex, url, timeSpent);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PostClickData)) {
            return false;
        }
        PostClickData postClickData = (PostClickData) other;
        return Intrinsics.areEqual(this.name, postClickData.name) && this.sessionIndex == postClickData.sessionIndex && this.pageIndex == postClickData.pageIndex && Intrinsics.areEqual(this.url, postClickData.url) && this.timeSpent == postClickData.timeSpent;
    }

    public int hashCode() {
        int hashCode = ((((this.name.hashCode() * 31) + Integer.hashCode(this.sessionIndex)) * 31) + Integer.hashCode(this.pageIndex)) * 31;
        String str = this.url;
        return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + Long.hashCode(this.timeSpent);
    }

    public String toString() {
        return "PostClickData(name=" + this.name + ", sessionIndex=" + this.sessionIndex + ", pageIndex=" + this.pageIndex + ", url=" + this.url + ", timeSpent=" + this.timeSpent + ')';
    }

    public PostClickData(String name, int i, int i2, String str, long j) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
        this.sessionIndex = i;
        this.pageIndex = i2;
        this.url = str;
        this.timeSpent = j;
    }

    public final String getName() {
        return this.name;
    }

    public final int getSessionIndex() {
        return this.sessionIndex;
    }

    public final int getPageIndex() {
        return this.pageIndex;
    }

    public final String getUrl() {
        return this.url;
    }

    public final long getTimeSpent() {
        return this.timeSpent;
    }
}
