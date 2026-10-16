package io.adn.sdk.internal.domain.error;

import com.vungle.ads.internal.protos.Sdk;
import io.adn.sdk.publisher.AdnAdError;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: AdErrors.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b'\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010,\u001a\u00020-J\u0006\u0010.\u001a\u00020\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+¨\u0006/"}, d2 = {"Lio/adn/sdk/internal/domain/error/AdError;", "", "code", "", "value", "", "<init>", "(Ljava/lang/String;IILjava/lang/String;)V", "getCode", "()I", "getValue", "()Ljava/lang/String;", "SdkNotInit", "SdkInitError", "LoadTimeout", "BadRequest", "ParseResponseError", "VastXmlParsingError", "NoCreativesError", "NoImpressionTrackersError", "NoClickTrackingError", "AssetDownloadError", "AssetNotReady", "AssetPreloadError", "AssetCacheError", "NoCompanionCreativesError", "VastLinearNotSupportedMediaError", "VastWrapperXmlLoadError", "VastWrapperError", "VastWrapperLimitError", "VastWrapperNoAdsError", "WebviewLoadError", "HttpRequestError", "NoFillError", "ProtoFieldConversionError", "AssetRenderingError", "AdRenderingError", "OmidVerificationScriptLoadError", "OmidConfigurationFailure", "OmidContextFailure", "OmidSessionFailure", "OmidAdEventFailure", "OmidMediaEventFailure", "UnknownError", "toExternalError", "Lio/adn/sdk/publisher/AdnAdError;", "toDiagnosticError", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class AdError {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ AdError[] $VALUES;
    private final int code;
    private final String value;
    public static final AdError SdkNotInit = new AdError("SdkNotInit", 0, 1, "SDK_NOT_INIT");
    public static final AdError SdkInitError = new AdError("SdkInitError", 1, 2, "SDK_INIT_ERROR");
    public static final AdError LoadTimeout = new AdError("LoadTimeout", 2, 101, "LOAD_TIMEOUT");
    public static final AdError BadRequest = new AdError("BadRequest", 3, 102, "BAD_REQUEST");
    public static final AdError ParseResponseError = new AdError("ParseResponseError", 4, 103, "PARSE_RESPONSE_ERROR");
    public static final AdError VastXmlParsingError = new AdError("VastXmlParsingError", 5, 202, "VAST_XML_PARSING_ERROR");
    public static final AdError NoCreativesError = new AdError("NoCreativesError", 6, 104, "NO_CREATIVES_ERROR");
    public static final AdError NoImpressionTrackersError = new AdError("NoImpressionTrackersError", 7, 105, "NO_IMPRESSION_TRACKERS_ERROR");
    public static final AdError NoClickTrackingError = new AdError("NoClickTrackingError", 8, 106, "NO_CLICK_TRACKING");
    public static final AdError AssetDownloadError = new AdError("AssetDownloadError", 9, 107, "ASSET_DOWNLOAD_ERROR");
    public static final AdError AssetNotReady = new AdError("AssetNotReady", 10, 108, "ASSET_NOT_READY");
    public static final AdError AssetPreloadError = new AdError("AssetPreloadError", 11, 109, "ASSET_PRELOAD_ERROR");
    public static final AdError AssetCacheError = new AdError("AssetCacheError", 12, 110, "ASSET_SAVING_ERROR");
    public static final AdError NoCompanionCreativesError = new AdError("NoCompanionCreativesError", 13, 111, "NO_COMPANION_CREATIVES_ERROR");
    public static final AdError VastLinearNotSupportedMediaError = new AdError("VastLinearNotSupportedMediaError", 14, 204, "VAST_LINEAR_NOT_SUPPORTED_MEDIA_ERROR");
    public static final AdError VastWrapperXmlLoadError = new AdError("VastWrapperXmlLoadError", 15, 206, "VAST_WRAPPER_XML_LOAD_ERROR");
    public static final AdError VastWrapperError = new AdError("VastWrapperError", 16, 207, "VAST_WRAPPER_ERROR");
    public static final AdError VastWrapperLimitError = new AdError("VastWrapperLimitError", 17, 208, "VAST_WRAPPER_LIMIT_ERROR");
    public static final AdError VastWrapperNoAdsError = new AdError("VastWrapperNoAdsError", 18, 209, "VAST_WRAPPER_NO_ADS_ERROR");
    public static final AdError WebviewLoadError = new AdError("WebviewLoadError", 19, Sdk.SDKError.Reason.MRAID_ERROR_VALUE, "WEBVIEW_LOAD_ERROR");
    public static final AdError HttpRequestError = new AdError("HttpRequestError", 20, Sdk.SDKError.Reason.INVALID_IFA_STATUS_VALUE, "HTTP_REQUEST_ERROR");
    public static final AdError NoFillError = new AdError("NoFillError", 21, 303, "NO_FILL_ERROR");
    public static final AdError ProtoFieldConversionError = new AdError("ProtoFieldConversionError", 22, Sdk.SDKError.Reason.AD_EXPIRED_VALUE, "Proto field conversion error");
    public static final AdError AssetRenderingError = new AdError("AssetRenderingError", 23, 403, "ASSET_RENDERING_ERROR");
    public static final AdError AdRenderingError = new AdError("AdRenderingError", 24, 404, "AD_ALL_ASSET_RENDERING_ERROR");
    public static final AdError OmidVerificationScriptLoadError = new AdError("OmidVerificationScriptLoadError", 25, 501, "VERIFICATION_SCRIPT_LOAD_ERROR");
    public static final AdError OmidConfigurationFailure = new AdError("OmidConfigurationFailure", 26, 502, "CONFIGURATION_FAILURE");
    public static final AdError OmidContextFailure = new AdError("OmidContextFailure", 27, 503, "CONTEXT_FAILURE");
    public static final AdError OmidSessionFailure = new AdError("OmidSessionFailure", 28, 504, "SESSION_FAILURE");
    public static final AdError OmidAdEventFailure = new AdError("OmidAdEventFailure", 29, 505, "AD_EVENT_FAILURE");
    public static final AdError OmidMediaEventFailure = new AdError("OmidMediaEventFailure", 30, 506, "MEDIA_EVENT_FAILURE");
    public static final AdError UnknownError = new AdError("UnknownError", 31, -1, "UNKNOWN_ERROR");

    /* compiled from: AdErrors.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AdError.values().length];
            try {
                iArr[AdError.SdkNotInit.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AdError.SdkInitError.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AdError.LoadTimeout.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AdError.NoFillError.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[AdError.HttpRequestError.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[AdError.BadRequest.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static final /* synthetic */ AdError[] $values() {
        return new AdError[]{SdkNotInit, SdkInitError, LoadTimeout, BadRequest, ParseResponseError, VastXmlParsingError, NoCreativesError, NoImpressionTrackersError, NoClickTrackingError, AssetDownloadError, AssetNotReady, AssetPreloadError, AssetCacheError, NoCompanionCreativesError, VastLinearNotSupportedMediaError, VastWrapperXmlLoadError, VastWrapperError, VastWrapperLimitError, VastWrapperNoAdsError, WebviewLoadError, HttpRequestError, NoFillError, ProtoFieldConversionError, AssetRenderingError, AdRenderingError, OmidVerificationScriptLoadError, OmidConfigurationFailure, OmidContextFailure, OmidSessionFailure, OmidAdEventFailure, OmidMediaEventFailure, UnknownError};
    }

    public static EnumEntries<AdError> getEntries() {
        return $ENTRIES;
    }

    private AdError(String str, int i, int i2, String str2) {
        this.code = i2;
        this.value = str2;
    }

    public final int getCode() {
        return this.code;
    }

    public final String getValue() {
        return this.value;
    }

    static {
        AdError[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public final AdnAdError toExternalError() {
        switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
            case 1:
                return AdnAdError.SdkNotInitialized.INSTANCE;
            case 2:
                return AdnAdError.SdkInitFailure.INSTANCE;
            case 3:
                return AdnAdError.Timeout.INSTANCE;
            case 4:
                return AdnAdError.NoFill.INSTANCE;
            case 5:
                return AdnAdError.ServerError.INSTANCE;
            case 6:
                return AdnAdError.BadRequest.INSTANCE;
            default:
                return new AdnAdError.InternalError(this.code);
        }
    }

    public final String toDiagnosticError() {
        return this.value;
    }

    public static AdError valueOf(String str) {
        return (AdError) Enum.valueOf(AdError.class, str);
    }

    public static AdError[] values() {
        return (AdError[]) $VALUES.clone();
    }
}
