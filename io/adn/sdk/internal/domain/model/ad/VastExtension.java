package io.adn.sdk.internal.domain.model.ad;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VastAdEntity.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÇ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u0012\u001a\u00020\u0013H×\u0001J\t\u0010\u0014\u001a\u00020\u0003H×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lio/adn/sdk/internal/domain/model/ad/VastExtension;", "", "name", "", "customEvents", "", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "getName", "()Ljava/lang/String;", "getCustomEvents", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final /* data */ class VastExtension {
    public static final int $stable = 8;
    private final List<String> customEvents;
    private final String name;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ VastExtension copy$default(VastExtension vastExtension, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = vastExtension.name;
        }
        if ((i & 2) != 0) {
            list = vastExtension.customEvents;
        }
        return vastExtension.copy(str, list);
    }

    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final List<String> component2() {
        return this.customEvents;
    }

    public final VastExtension copy(String name, List<String> customEvents) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(customEvents, "customEvents");
        return new VastExtension(name, customEvents);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VastExtension)) {
            return false;
        }
        VastExtension vastExtension = (VastExtension) other;
        return Intrinsics.areEqual(this.name, vastExtension.name) && Intrinsics.areEqual(this.customEvents, vastExtension.customEvents);
    }

    public int hashCode() {
        return (this.name.hashCode() * 31) + this.customEvents.hashCode();
    }

    public String toString() {
        return "VastExtension(name=" + this.name + ", customEvents=" + this.customEvents + ')';
    }

    public VastExtension(String name, List<String> customEvents) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(customEvents, "customEvents");
        this.name = name;
        this.customEvents = customEvents;
    }

    public final String getName() {
        return this.name;
    }

    public final List<String> getCustomEvents() {
        return this.customEvents;
    }
}
