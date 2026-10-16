package io.adn.sdk.internal.data.dto;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: EventTrackerDto.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 +2\u00020\u0001:\u0002*+B/\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nBC\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\t\u0010\u000eJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\bHÆ\u0003J>\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÇ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010 \u001a\u00020\u0003H×\u0001J\t\u0010!\u001a\u00020\u0006H×\u0001J%\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00002\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0001¢\u0006\u0002\b)R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0012\u0010\u0010R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006,"}, d2 = {"Lio/adn/sdk/internal/data/dto/EventTrackerDto;", "", "event", "", "method", "url", "", "ext", "Lio/adn/sdk/internal/data/dto/AdMeasurementVerificationResourceDto;", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Lio/adn/sdk/internal/data/dto/AdMeasurementVerificationResourceDto;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Lio/adn/sdk/internal/data/dto/AdMeasurementVerificationResourceDto;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getEvent", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMethod", "getUrl", "()Ljava/lang/String;", "getExt", "()Lio/adn/sdk/internal/data/dto/AdMeasurementVerificationResourceDto;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Lio/adn/sdk/internal/data/dto/AdMeasurementVerificationResourceDto;)Lio/adn/sdk/internal/data/dto/EventTrackerDto;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$adn_sdk_release", "$serializer", "Companion", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@Serializable
/* loaded from: classes7.dex */
public final /* data */ class EventTrackerDto {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Integer event;
    private final AdMeasurementVerificationResourceDto ext;
    private final Integer method;
    private final String url;

    public static /* synthetic */ EventTrackerDto copy$default(EventTrackerDto eventTrackerDto, Integer num, Integer num2, String str, AdMeasurementVerificationResourceDto adMeasurementVerificationResourceDto, int i, Object obj) {
        if ((i & 1) != 0) {
            num = eventTrackerDto.event;
        }
        if ((i & 2) != 0) {
            num2 = eventTrackerDto.method;
        }
        if ((i & 4) != 0) {
            str = eventTrackerDto.url;
        }
        if ((i & 8) != 0) {
            adMeasurementVerificationResourceDto = eventTrackerDto.ext;
        }
        return eventTrackerDto.copy(num, num2, str, adMeasurementVerificationResourceDto);
    }

    /* renamed from: component1, reason: from getter */
    public final Integer getEvent() {
        return this.event;
    }

    /* renamed from: component2, reason: from getter */
    public final Integer getMethod() {
        return this.method;
    }

    /* renamed from: component3, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* renamed from: component4, reason: from getter */
    public final AdMeasurementVerificationResourceDto getExt() {
        return this.ext;
    }

    public final EventTrackerDto copy(Integer event, Integer method, String url, AdMeasurementVerificationResourceDto ext) {
        return new EventTrackerDto(event, method, url, ext);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EventTrackerDto)) {
            return false;
        }
        EventTrackerDto eventTrackerDto = (EventTrackerDto) other;
        return Intrinsics.areEqual(this.event, eventTrackerDto.event) && Intrinsics.areEqual(this.method, eventTrackerDto.method) && Intrinsics.areEqual(this.url, eventTrackerDto.url) && Intrinsics.areEqual(this.ext, eventTrackerDto.ext);
    }

    public int hashCode() {
        Integer num = this.event;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.method;
        int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str = this.url;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        AdMeasurementVerificationResourceDto adMeasurementVerificationResourceDto = this.ext;
        return hashCode3 + (adMeasurementVerificationResourceDto != null ? adMeasurementVerificationResourceDto.hashCode() : 0);
    }

    public String toString() {
        return "EventTrackerDto(event=" + this.event + ", method=" + this.method + ", url=" + this.url + ", ext=" + this.ext + ')';
    }

    /* compiled from: EventTrackerDto.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0007¨\u0006\u0007"}, d2 = {"Lio/adn/sdk/internal/data/dto/EventTrackerDto$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lio/adn/sdk/internal/data/dto/EventTrackerDto;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<EventTrackerDto> serializer() {
            return EventTrackerDto$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ EventTrackerDto(int i, Integer num, Integer num2, String str, AdMeasurementVerificationResourceDto adMeasurementVerificationResourceDto, SerializationConstructorMarker serializationConstructorMarker) {
        if (15 != (i & 15)) {
            PluginExceptionsKt.throwMissingFieldException(i, 15, EventTrackerDto$$serializer.INSTANCE.getDescriptor());
        }
        this.event = num;
        this.method = num2;
        this.url = str;
        this.ext = adMeasurementVerificationResourceDto;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$adn_sdk_release(EventTrackerDto self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeNullableSerializableElement(serialDesc, 0, IntSerializer.INSTANCE, self.event);
        output.encodeNullableSerializableElement(serialDesc, 1, IntSerializer.INSTANCE, self.method);
        output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.url);
        output.encodeNullableSerializableElement(serialDesc, 3, AdMeasurementVerificationResourceDto$$serializer.INSTANCE, self.ext);
    }

    public EventTrackerDto(Integer num, Integer num2, String str, AdMeasurementVerificationResourceDto adMeasurementVerificationResourceDto) {
        this.event = num;
        this.method = num2;
        this.url = str;
        this.ext = adMeasurementVerificationResourceDto;
    }

    public final Integer getEvent() {
        return this.event;
    }

    public final Integer getMethod() {
        return this.method;
    }

    public final String getUrl() {
        return this.url;
    }

    public final AdMeasurementVerificationResourceDto getExt() {
        return this.ext;
    }
}
