package io.adn.sdk.internal.data.dto;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VastDto.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001f\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÇ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u0010\u001a\u00020\u0011H×\u0001J\t\u0010\u0012\u001a\u00020\u0003H×\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lio/adn/sdk/internal/data/dto/VastVideoClickDto;", "", "id", "", "url", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getUrl", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final /* data */ class VastVideoClickDto {
    public static final int $stable = 0;
    private final String id;
    private final String url;

    public static /* synthetic */ VastVideoClickDto copy$default(VastVideoClickDto vastVideoClickDto, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = vastVideoClickDto.id;
        }
        if ((i & 2) != 0) {
            str2 = vastVideoClickDto.url;
        }
        return vastVideoClickDto.copy(str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    public final VastVideoClickDto copy(String id, String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return new VastVideoClickDto(id, url);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VastVideoClickDto)) {
            return false;
        }
        VastVideoClickDto vastVideoClickDto = (VastVideoClickDto) other;
        return Intrinsics.areEqual(this.id, vastVideoClickDto.id) && Intrinsics.areEqual(this.url, vastVideoClickDto.url);
    }

    public int hashCode() {
        String str = this.id;
        return ((str == null ? 0 : str.hashCode()) * 31) + this.url.hashCode();
    }

    public String toString() {
        return "VastVideoClickDto(id=" + this.id + ", url=" + this.url + ')';
    }

    public VastVideoClickDto(String str, String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.id = str;
        this.url = url;
    }

    public final String getId() {
        return this.id;
    }

    public final String getUrl() {
        return this.url;
    }
}
