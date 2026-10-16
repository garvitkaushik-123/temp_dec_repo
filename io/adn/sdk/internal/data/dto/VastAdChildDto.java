package io.adn.sdk.internal.data.dto;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VastDto.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006"}, d2 = {"Lio/adn/sdk/internal/data/dto/VastAdChildDto;", "", "InLine", "Wrapper", "Lio/adn/sdk/internal/data/dto/VastAdChildDto$InLine;", "Lio/adn/sdk/internal/data/dto/VastAdChildDto$Wrapper;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public interface VastAdChildDto {

    /* compiled from: VastDto.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÇ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH×\u0003J\t\u0010\u000e\u001a\u00020\u000fH×\u0001J\t\u0010\u0010\u001a\u00020\u0011H×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lio/adn/sdk/internal/data/dto/VastAdChildDto$InLine;", "Lio/adn/sdk/internal/data/dto/VastAdChildDto;", "inline", "Lio/adn/sdk/internal/data/dto/VastInLineDto;", "<init>", "(Lio/adn/sdk/internal/data/dto/VastInLineDto;)V", "getInline", "()Lio/adn/sdk/internal/data/dto/VastInLineDto;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class InLine implements VastAdChildDto {
        public static final int $stable = 8;
        private final VastInLineDto inline;

        public static /* synthetic */ InLine copy$default(InLine inLine, VastInLineDto vastInLineDto, int i, Object obj) {
            if ((i & 1) != 0) {
                vastInLineDto = inLine.inline;
            }
            return inLine.copy(vastInLineDto);
        }

        /* renamed from: component1, reason: from getter */
        public final VastInLineDto getInline() {
            return this.inline;
        }

        public final InLine copy(VastInLineDto inline) {
            Intrinsics.checkNotNullParameter(inline, "inline");
            return new InLine(inline);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof InLine) && Intrinsics.areEqual(this.inline, ((InLine) other).inline);
        }

        public int hashCode() {
            return this.inline.hashCode();
        }

        public String toString() {
            return "InLine(inline=" + this.inline + ')';
        }

        public InLine(VastInLineDto inline) {
            Intrinsics.checkNotNullParameter(inline, "inline");
            this.inline = inline;
        }

        public final VastInLineDto getInline() {
            return this.inline;
        }
    }

    /* compiled from: VastDto.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÇ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH×\u0003J\t\u0010\u000e\u001a\u00020\u000fH×\u0001J\t\u0010\u0010\u001a\u00020\u0011H×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lio/adn/sdk/internal/data/dto/VastAdChildDto$Wrapper;", "Lio/adn/sdk/internal/data/dto/VastAdChildDto;", "wrapper", "Lio/adn/sdk/internal/data/dto/VastWrapperDto;", "<init>", "(Lio/adn/sdk/internal/data/dto/VastWrapperDto;)V", "getWrapper", "()Lio/adn/sdk/internal/data/dto/VastWrapperDto;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Wrapper implements VastAdChildDto {
        public static final int $stable = 8;
        private final VastWrapperDto wrapper;

        public static /* synthetic */ Wrapper copy$default(Wrapper wrapper, VastWrapperDto vastWrapperDto, int i, Object obj) {
            if ((i & 1) != 0) {
                vastWrapperDto = wrapper.wrapper;
            }
            return wrapper.copy(vastWrapperDto);
        }

        /* renamed from: component1, reason: from getter */
        public final VastWrapperDto getWrapper() {
            return this.wrapper;
        }

        public final Wrapper copy(VastWrapperDto wrapper) {
            Intrinsics.checkNotNullParameter(wrapper, "wrapper");
            return new Wrapper(wrapper);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Wrapper) && Intrinsics.areEqual(this.wrapper, ((Wrapper) other).wrapper);
        }

        public int hashCode() {
            return this.wrapper.hashCode();
        }

        public String toString() {
            return "Wrapper(wrapper=" + this.wrapper + ')';
        }

        public Wrapper(VastWrapperDto wrapper) {
            Intrinsics.checkNotNullParameter(wrapper, "wrapper");
            this.wrapper = wrapper;
        }

        public final VastWrapperDto getWrapper() {
            return this.wrapper;
        }
    }
}
