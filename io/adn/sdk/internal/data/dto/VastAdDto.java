package io.adn.sdk.internal.data.dto;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VastDto.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0081\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J0\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÇ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u0019\u001a\u00020\u0005H×\u0001J\t\u0010\u001a\u001a\u00020\u0003H×\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lio/adn/sdk/internal/data/dto/VastAdDto;", "", "id", "", "sequence", "", "child", "Lio/adn/sdk/internal/data/dto/VastAdChildDto;", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Lio/adn/sdk/internal/data/dto/VastAdChildDto;)V", "getId", "()Ljava/lang/String;", "getSequence", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getChild", "()Lio/adn/sdk/internal/data/dto/VastAdChildDto;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Lio/adn/sdk/internal/data/dto/VastAdChildDto;)Lio/adn/sdk/internal/data/dto/VastAdDto;", "equals", "", "other", "hashCode", "toString", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final /* data */ class VastAdDto {
    public static final int $stable = 8;
    private final VastAdChildDto child;
    private final String id;
    private final Integer sequence;

    public static /* synthetic */ VastAdDto copy$default(VastAdDto vastAdDto, String str, Integer num, VastAdChildDto vastAdChildDto, int i, Object obj) {
        if ((i & 1) != 0) {
            str = vastAdDto.id;
        }
        if ((i & 2) != 0) {
            num = vastAdDto.sequence;
        }
        if ((i & 4) != 0) {
            vastAdChildDto = vastAdDto.child;
        }
        return vastAdDto.copy(str, num, vastAdChildDto);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final Integer getSequence() {
        return this.sequence;
    }

    /* renamed from: component3, reason: from getter */
    public final VastAdChildDto getChild() {
        return this.child;
    }

    public final VastAdDto copy(String id, Integer sequence, VastAdChildDto child) {
        Intrinsics.checkNotNullParameter(child, "child");
        return new VastAdDto(id, sequence, child);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VastAdDto)) {
            return false;
        }
        VastAdDto vastAdDto = (VastAdDto) other;
        return Intrinsics.areEqual(this.id, vastAdDto.id) && Intrinsics.areEqual(this.sequence, vastAdDto.sequence) && Intrinsics.areEqual(this.child, vastAdDto.child);
    }

    public int hashCode() {
        String str = this.id;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.sequence;
        return ((hashCode + (num != null ? num.hashCode() : 0)) * 31) + this.child.hashCode();
    }

    public String toString() {
        return "VastAdDto(id=" + this.id + ", sequence=" + this.sequence + ", child=" + this.child + ')';
    }

    public VastAdDto(String str, Integer num, VastAdChildDto child) {
        Intrinsics.checkNotNullParameter(child, "child");
        this.id = str;
        this.sequence = num;
        this.child = child;
    }

    public final String getId() {
        return this.id;
    }

    public final Integer getSequence() {
        return this.sequence;
    }

    public final VastAdChildDto getChild() {
        return this.child;
    }
}
