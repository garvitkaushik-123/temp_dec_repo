package io.adn.sdk.internal.data.dto;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VastDto.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÇ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u0013\u001a\u00020\u0014H×\u0001J\t\u0010\u0015\u001a\u00020\u0003H×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lio/adn/sdk/internal/data/dto/VastExtensionDto;", "", "type", "", "customEvents", "", "Lio/adn/sdk/internal/data/dto/VastCustomEventDto;", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "getType", "()Ljava/lang/String;", "getCustomEvents", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final /* data */ class VastExtensionDto {
    public static final int $stable = 8;
    private final List<VastCustomEventDto> customEvents;
    private final String type;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ VastExtensionDto copy$default(VastExtensionDto vastExtensionDto, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = vastExtensionDto.type;
        }
        if ((i & 2) != 0) {
            list = vastExtensionDto.customEvents;
        }
        return vastExtensionDto.copy(str, list);
    }

    /* renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    public final List<VastCustomEventDto> component2() {
        return this.customEvents;
    }

    public final VastExtensionDto copy(String type, List<VastCustomEventDto> customEvents) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(customEvents, "customEvents");
        return new VastExtensionDto(type, customEvents);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VastExtensionDto)) {
            return false;
        }
        VastExtensionDto vastExtensionDto = (VastExtensionDto) other;
        return Intrinsics.areEqual(this.type, vastExtensionDto.type) && Intrinsics.areEqual(this.customEvents, vastExtensionDto.customEvents);
    }

    public int hashCode() {
        return (this.type.hashCode() * 31) + this.customEvents.hashCode();
    }

    public String toString() {
        return "VastExtensionDto(type=" + this.type + ", customEvents=" + this.customEvents + ')';
    }

    public VastExtensionDto(String type, List<VastCustomEventDto> customEvents) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(customEvents, "customEvents");
        this.type = type;
        this.customEvents = customEvents;
    }

    public final String getType() {
        return this.type;
    }

    public final List<VastCustomEventDto> getCustomEvents() {
        return this.customEvents;
    }
}
