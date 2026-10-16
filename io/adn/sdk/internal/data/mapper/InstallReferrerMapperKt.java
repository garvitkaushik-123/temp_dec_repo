package io.adn.sdk.internal.data.mapper;

import android.net.Uri;
import com.android.installreferrer.api.ReferrerDetails;
import io.adn.sdk.internal.domain.model.ad.AttributionSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* compiled from: InstallReferrerMapper.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0002\"\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"mapToInstallReferrerAttributionSource", "Lio/adn/sdk/internal/domain/model/ad/AttributionSource;", "referrerDetails", "Lcom/android/installreferrer/api/ReferrerDetails;", "processAdnCallbackUrl", "", "callbackUrl", "installTimestamp", "", "ADN_CALLBACK_PARAM_KEY", "ADN_CALLBACK_PLACEHOLDER", "Lkotlin/text/Regex;", "adn-sdk_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class InstallReferrerMapperKt {
    private static final String ADN_CALLBACK_PARAM_KEY = "adn_cb";
    private static final Regex ADN_CALLBACK_PLACEHOLDER = new Regex("\\[INSTALLED_AT]");

    public static final AttributionSource mapToInstallReferrerAttributionSource(ReferrerDetails referrerDetails) {
        Intrinsics.checkNotNullParameter(referrerDetails, "referrerDetails");
        String queryParameter = Uri.parse("scheme://referrer?" + referrerDetails.getInstallReferrer()).getQueryParameter(ADN_CALLBACK_PARAM_KEY);
        if (queryParameter != null) {
            return new AttributionSource.Adn(processAdnCallbackUrl(queryParameter, referrerDetails.getInstallBeginTimestampSeconds()));
        }
        return AttributionSource.ThirdParty.INSTANCE;
    }

    private static final String processAdnCallbackUrl(String str, long j) {
        return ADN_CALLBACK_PLACEHOLDER.replace(str, String.valueOf(j));
    }
}
