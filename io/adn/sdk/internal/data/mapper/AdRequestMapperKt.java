package io.adn.sdk.internal.data.mapper;

import io.adn.sdk.internal.common.utils.ConversionsKt;
import io.adn.sdk.internal.data.api.local.LocalDataSource;
import io.adn.sdk.internal.data.dto.AdRequestBody;
import io.adn.sdk.internal.data.dto.AppInfoDto;
import io.adn.sdk.internal.data.dto.DeviceInfoDto;
import io.adn.sdk.internal.data.dto.ImpressionDto;
import io.adn.sdk.internal.data.dto.NativeDto;
import io.adn.sdk.internal.data.dto.RegsDto;
import io.adn.sdk.internal.data.dto.RegsExtDto;
import io.adn.sdk.internal.data.dto.UserDataDto;
import io.adn.sdk.internal.data.dto.UserDto;
import io.adn.sdk.internal.data.dto.VideoDto;
import io.adn.sdk.internal.domain.model.metrics.ScreenSize;
import io.adn.sdk.publisher.AdnAdPlacement;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AdRequestMapper.kt */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\u001a\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0002\u001a\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bH\u0002\"\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"buildAdRequestBody", "Lio/adn/sdk/internal/data/dto/AdRequestBody;", "localDataSource", "Lio/adn/sdk/internal/data/api/local/LocalDataSource;", "token", "", "adPlacement", "Lio/adn/sdk/publisher/AdnAdPlacement;", "buildImpressionDto", "Lio/adn/sdk/internal/data/dto/ImpressionDto;", "screenSize", "Lio/adn/sdk/internal/domain/model/metrics/ScreenSize;", "buildDeviceType", "", "OS_NAME", "TABLET_DEVICE_TYPE", "PHONE_DEVICE_TYPE", "adn-sdk_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class AdRequestMapperKt {
    private static final String OS_NAME = "android";
    private static final int PHONE_DEVICE_TYPE = 4;
    private static final int TABLET_DEVICE_TYPE = 5;

    /* compiled from: AdRequestMapper.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AdnAdPlacement.values().length];
            try {
                iArr[AdnAdPlacement.REWARDED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AdnAdPlacement.INTERSTITIAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final AdRequestBody buildAdRequestBody(LocalDataSource localDataSource, String token, AdnAdPlacement adPlacement) {
        Intrinsics.checkNotNullParameter(localDataSource, "localDataSource");
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(adPlacement, "adPlacement");
        ScreenSize screenSize = localDataSource.getSystemInfo().screenSize();
        String randomUUID = ConversionsKt.randomUUID();
        AppInfoDto appInfoDto = new AppInfoDto(localDataSource.getAppInfo().getAppBundleId(), localDataSource.getAppInfo().getAppVersion());
        String osVersion = localDataSource.getSystemInfo().getOsVersion();
        String manufacturer = localDataSource.getSystemInfo().getManufacturer();
        if (manufacturer == null) {
            manufacturer = "";
        }
        return new AdRequestBody(randomUUID, appInfoDto, new DeviceInfoDto("android", osVersion, manufacturer, localDataSource.getSystemInfo().getModel(), localDataSource.getSystemInfo().locale(), buildDeviceType(screenSize)), new RegsDto(new RegsExtDto(ConversionsKt.toInt(!localDataSource.getExternalData().getPrivacyInfo().canUseData()))), CollectionsKt.listOf(buildImpressionDto(adPlacement, screenSize)), new UserDto(CollectionsKt.listOf(new UserDataDto(token))));
    }

    private static final ImpressionDto buildImpressionDto(AdnAdPlacement adnAdPlacement, ScreenSize screenSize) {
        int i = WhenMappings.$EnumSwitchMapping$0[adnAdPlacement.ordinal()];
        return new ImpressionDto("1", (i == 1 || i == 2) ? new VideoDto(CollectionsKt.listOf("video/mp4"), screenSize.getWidthDp(), screenSize.getHeightDp()) : null, adnAdPlacement == AdnAdPlacement.NATIVE ? new NativeDto("{\"native\":{\"assets\":[]}}") : null, adnAdPlacement != AdnAdPlacement.REWARDED ? 0 : 1);
    }

    private static final int buildDeviceType(ScreenSize screenSize) {
        return Math.min(screenSize.getWidthDp(), screenSize.getHeightDp()) >= 600 ? 5 : 4;
    }
}
