package io.adn.sdk.internal.data.repository;

import com.ironsource.mediationsdk.utils.IronSourceConstants;
import io.adn.sdk.internal.domain.error.AdError;
import io.adn.sdk.internal.domain.error.AdException;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VastLoader.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\b\u0001\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\r\u001a\u00020\u000eR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lio/adn/sdk/internal/data/repository/VastException;", "Lio/adn/sdk/internal/domain/error/AdException;", "error", "Lio/adn/sdk/internal/domain/error/AdError;", "errorUrls", "", "", "<init>", "(Lio/adn/sdk/internal/domain/error/AdError;Ljava/util/List;)V", "getError", "()Lio/adn/sdk/internal/domain/error/AdError;", "getErrorUrls", "()Ljava/util/List;", IronSourceConstants.EVENTS_ERROR_CODE, "", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class VastException extends AdException {
    public static final int $stable = 8;
    private final AdError error;
    private final List<String> errorUrls;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VastException(AdError error, List<String> list) {
        super(error, null, 2, null);
        Intrinsics.checkNotNullParameter(error, "error");
        this.error = error;
        this.errorUrls = list;
    }

    public /* synthetic */ VastException(AdError adError, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(adError, (i & 2) != 0 ? null : list);
    }

    @Override // io.adn.sdk.internal.domain.error.AdException
    public AdError getError() {
        return this.error;
    }

    public final List<String> getErrorUrls() {
        return this.errorUrls;
    }

    public final int errorCode() {
        return getError().getCode();
    }
}
