package io.adn.sdk.internal.data.dto;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VastDto.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÇ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u0010\u001a\u00020\u0011H×\u0001J\t\u0010\u0012\u001a\u00020\u0003H×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lio/adn/sdk/internal/data/dto/VastCustomEventDto;", "", "name", "", "url", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getUrl", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final /* data */ class VastCustomEventDto {
    public static final int $stable = 0;
    private final String name;
    private final String url;

    public static /* synthetic */ VastCustomEventDto copy$default(VastCustomEventDto vastCustomEventDto, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = vastCustomEventDto.name;
        }
        if ((i & 2) != 0) {
            str2 = vastCustomEventDto.url;
        }
        return vastCustomEventDto.copy(str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component2, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    public final VastCustomEventDto copy(String name, String url) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(url, "url");
        return new VastCustomEventDto(name, url);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VastCustomEventDto)) {
            return false;
        }
        VastCustomEventDto vastCustomEventDto = (VastCustomEventDto) other;
        return Intrinsics.areEqual(this.name, vastCustomEventDto.name) && Intrinsics.areEqual(this.url, vastCustomEventDto.url);
    }

    public int hashCode() {
        return (this.name.hashCode() * 31) + this.url.hashCode();
    }

    public String toString() {
        return "VastCustomEventDto(name=" + this.name + ", url=" + this.url + ')';
    }

    public VastCustomEventDto(String name, String url) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(url, "url");
        this.name = name;
        this.url = url;
    }

    public final String getName() {
        return this.name;
    }

    public final String getUrl() {
        return this.url;
    }
}
