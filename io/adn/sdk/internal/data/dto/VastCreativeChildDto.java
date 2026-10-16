package io.adn.sdk.internal.data.dto;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VastDto.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006"}, d2 = {"Lio/adn/sdk/internal/data/dto/VastCreativeChildDto;", "", "Linear", "Companions", "Lio/adn/sdk/internal/data/dto/VastCreativeChildDto$Companions;", "Lio/adn/sdk/internal/data/dto/VastCreativeChildDto$Linear;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public interface VastCreativeChildDto {

    /* compiled from: VastDto.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÇ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH×\u0003J\t\u0010\u000e\u001a\u00020\u000fH×\u0001J\t\u0010\u0010\u001a\u00020\u0011H×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lio/adn/sdk/internal/data/dto/VastCreativeChildDto$Linear;", "Lio/adn/sdk/internal/data/dto/VastCreativeChildDto;", "linear", "Lio/adn/sdk/internal/data/dto/VastLinearDto;", "<init>", "(Lio/adn/sdk/internal/data/dto/VastLinearDto;)V", "getLinear", "()Lio/adn/sdk/internal/data/dto/VastLinearDto;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Linear implements VastCreativeChildDto {
        public static final int $stable = 8;
        private final VastLinearDto linear;

        public static /* synthetic */ Linear copy$default(Linear linear, VastLinearDto vastLinearDto, int i, Object obj) {
            if ((i & 1) != 0) {
                vastLinearDto = linear.linear;
            }
            return linear.copy(vastLinearDto);
        }

        /* renamed from: component1, reason: from getter */
        public final VastLinearDto getLinear() {
            return this.linear;
        }

        public final Linear copy(VastLinearDto linear) {
            Intrinsics.checkNotNullParameter(linear, "linear");
            return new Linear(linear);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Linear) && Intrinsics.areEqual(this.linear, ((Linear) other).linear);
        }

        public int hashCode() {
            return this.linear.hashCode();
        }

        public String toString() {
            return "Linear(linear=" + this.linear + ')';
        }

        public Linear(VastLinearDto linear) {
            Intrinsics.checkNotNullParameter(linear, "linear");
            this.linear = linear;
        }

        public final VastLinearDto getLinear() {
            return this.linear;
        }
    }

    /* compiled from: VastDto.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÇ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH×\u0003J\t\u0010\u000f\u001a\u00020\u0010H×\u0001J\t\u0010\u0011\u001a\u00020\u0012H×\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lio/adn/sdk/internal/data/dto/VastCreativeChildDto$Companions;", "Lio/adn/sdk/internal/data/dto/VastCreativeChildDto;", "companions", "", "Lio/adn/sdk/internal/data/dto/VastCompanionDto;", "<init>", "(Ljava/util/List;)V", "getCompanions", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Companions implements VastCreativeChildDto {
        public static final int $stable = 8;
        private final List<VastCompanionDto> companions;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Companions copy$default(Companions companions, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = companions.companions;
            }
            return companions.copy(list);
        }

        public final List<VastCompanionDto> component1() {
            return this.companions;
        }

        public final Companions copy(List<VastCompanionDto> companions) {
            Intrinsics.checkNotNullParameter(companions, "companions");
            return new Companions(companions);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Companions) && Intrinsics.areEqual(this.companions, ((Companions) other).companions);
        }

        public int hashCode() {
            return this.companions.hashCode();
        }

        public String toString() {
            return "Companions(companions=" + this.companions + ')';
        }

        public Companions(List<VastCompanionDto> companions) {
            Intrinsics.checkNotNullParameter(companions, "companions");
            this.companions = companions;
        }

        public final List<VastCompanionDto> getCompanions() {
            return this.companions;
        }
    }
}
