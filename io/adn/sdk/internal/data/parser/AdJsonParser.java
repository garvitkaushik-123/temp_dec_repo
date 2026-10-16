package io.adn.sdk.internal.data.parser;

import io.adn.sdk.internal.common.logger.Logger;
import io.adn.sdk.internal.data.dto.BidResponseDto;
import io.adn.sdk.internal.data.dto.NativeAdDto;
import io.adn.sdk.internal.domain.error.AdError;
import io.adn.sdk.internal.domain.error.AdException;
import io.adn.sdk.internal.domain.error.AdJsonParseException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.json.Json;

/* compiled from: AdJsonParser.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lio/adn/sdk/internal/data/parser/AdJsonParser;", "", "json", "Lkotlinx/serialization/json/Json;", "<init>", "(Lkotlinx/serialization/json/Json;)V", "parseBidResponse", "Lio/adn/sdk/internal/data/dto/BidResponseDto;", "bidPayload", "", "parseNativeAdContent", "Lio/adn/sdk/internal/data/dto/NativeAdDto;", "content", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class AdJsonParser {
    public static final int $stable = 8;
    private final Json json;

    public AdJsonParser(Json json) {
        Intrinsics.checkNotNullParameter(json, "json");
        this.json = json;
    }

    public final BidResponseDto parseBidResponse(String bidPayload) {
        Object m10241constructorimpl;
        String str = bidPayload;
        if (str == null || str.length() == 0) {
            throw new AdException(AdError.BadRequest, null, 2, null);
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            AdJsonParser adJsonParser = this;
            Logger.INSTANCE.internal("AdJsonParser", "Bid Response\n" + bidPayload);
            Json json = this.json;
            KSerializer<Object> serializer = SerializersKt.serializer(json.getSerializersModule(), Reflection.typeOf(BidResponseDto.class));
            Intrinsics.checkNotNull(serializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
            m10241constructorimpl = Result.m10241constructorimpl((BidResponseDto) json.decodeFromString(serializer, bidPayload));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
        Throwable m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(m10241constructorimpl);
        if (m10244exceptionOrNullimpl == null) {
            return (BidResponseDto) m10241constructorimpl;
        }
        Logger.INSTANCE.e("AdJsonParser", m10244exceptionOrNullimpl);
        throw new AdJsonParseException(m10244exceptionOrNullimpl.getMessage(), bidPayload);
    }

    public final NativeAdDto parseNativeAdContent(String content) {
        Object m10241constructorimpl;
        Intrinsics.checkNotNullParameter(content, "content");
        try {
            Result.Companion companion = Result.INSTANCE;
            AdJsonParser adJsonParser = this;
            Json json = this.json;
            KSerializer<Object> serializer = SerializersKt.serializer(json.getSerializersModule(), Reflection.typeOf(NativeAdDto.class));
            Intrinsics.checkNotNull(serializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
            m10241constructorimpl = Result.m10241constructorimpl((NativeAdDto) json.decodeFromString(serializer, content));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
        Throwable m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(m10241constructorimpl);
        if (m10244exceptionOrNullimpl != null) {
            Logger.INSTANCE.e("AdJsonParser", m10244exceptionOrNullimpl);
            throw new AdJsonParseException(m10244exceptionOrNullimpl.getMessage(), content);
        }
        return (NativeAdDto) m10241constructorimpl;
    }
}
