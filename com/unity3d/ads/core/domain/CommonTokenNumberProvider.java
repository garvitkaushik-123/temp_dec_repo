package com.unity3d.ads.core.domain;

import com.unity3d.ads.core.data.repository.SessionRepository;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CommonTokenNumberProvider.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u000b\u001a\u00020\u0006H\u0096\u0002R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/unity3d/ads/core/domain/CommonTokenNumberProvider;", "Lcom/unity3d/ads/core/domain/TokenNumberProvider;", "sessionRepository", "Lcom/unity3d/ads/core/data/repository/SessionRepository;", "(Lcom/unity3d/ads/core/data/repository/SessionRepository;)V", "number", "", "getNumber", "()I", "number$delegate", "Lkotlin/Lazy;", "invoke", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class CommonTokenNumberProvider implements TokenNumberProvider {

    /* renamed from: number$delegate, reason: from kotlin metadata */
    private final Lazy number;

    public CommonTokenNumberProvider(final SessionRepository sessionRepository) {
        Intrinsics.checkNotNullParameter(sessionRepository, "sessionRepository");
        this.number = LazyKt.lazy(new Function0<Integer>() { // from class: com.unity3d.ads.core.domain.CommonTokenNumberProvider$number$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                return Integer.valueOf(SessionRepository.this.getHeaderBiddingTokenCounter());
            }
        });
    }

    private final int getNumber() {
        return ((Number) this.number.getValue()).intValue();
    }

    @Override // com.unity3d.ads.core.domain.TokenNumberProvider
    public int invoke() {
        return getNumber();
    }
}
