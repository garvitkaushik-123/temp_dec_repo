package io.adn.sdk.internal.domain.model.analytics;

import com.ironsource.V5;
import io.adn.sdk.internal.common.utils.DateKt;
import io.adn.sdk.internal.domain.constants.AnalyticsConstants;
import io.adn.sdk.internal.domain.error.AdError;
import io.adn.sdk.internal.domain.error.AdException;
import io.adn.sdk.internal.domain.error.AdJsonParseException;
import io.adn.sdk.internal.domain.model.ad.BidExtra;
import io.adn.sdk.internal.domain.model.ad.DismissOrigin;
import io.adn.sdk.internal.domain.model.ad.FullscreenAdEntityKt;
import io.adn.sdk.internal.domain.model.ad.FullscreenAdScene;
import io.adn.sdk.internal.domain.model.ad.NativeAdAsset;
import io.adn.sdk.internal.domain.model.ad.NativeAdEntity;
import io.adn.sdk.internal.domain.model.ad.NativeAdEntityKt;
import io.adn.sdk.internal.domain.model.ad.SceneAsset;
import io.adn.sdk.internal.domain.model.ui.RenderingState;
import io.adn.sdk.publisher.AdnAdPlacement;
import io.adn.sdk.publisher.AdnClickElement;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DiagnosticEventBuilder.kt */
@Metadata(d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b1\u0018\u00002\u00020\u0001:\u000f>?@ABCDEFGHIJKLB\u0011\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#J\u0015\u0010$\u001a\u00020!2\b\u0010%\u001a\u0004\u0018\u00010&¢\u0006\u0002\u0010'J\u0006\u0010(\u001a\u00020)J\u0006\u0010*\u001a\u00020)J\u0006\u0010+\u001a\u00020)J\u000e\u0010,\u001a\u00020)2\u0006\u0010-\u001a\u00020.J&\u0010(\u001a\u00020)2\u0006\u0010/\u001a\u00020\u000e2\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000100H\u0002J\u0018\u0010/\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u00101\u001a\u00020\u000eH\u0002J\u000f\u00102\u001a\u0004\u0018\u000103H\u0002¢\u0006\u0002\u00104J#\u00105\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u0001002\u0006\u00106\u001a\u000207H\u0000¢\u0006\u0002\b8J#\u00105\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u0001002\u0006\u00109\u001a\u00020:H\u0000¢\u0006\u0002\b8J\u0013\u0010;\u001a\u0004\u0018\u00010\u000e*\u00020<H\u0000¢\u0006\u0002\b=R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0084\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000eX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0017X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f\u0082\u0001\u000fMNOPQRSTUVWXYZ[¨\u0006\\"}, d2 = {"Lio/adn/sdk/internal/domain/model/analytics/DiagnosticEventBuilder;", "", "eventType", "Lio/adn/sdk/internal/domain/model/analytics/DiagnosticEventType;", "<init>", "(Lio/adn/sdk/internal/domain/model/analytics/DiagnosticEventType;)V", "startTime", "", "getStartTime", "()Ljava/lang/Long;", "setStartTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "sdkInitDate", "", "sdkSessionId", "adPlacement", "getAdPlacement", "()Ljava/lang/String;", "setAdPlacement", "(Ljava/lang/String;)V", "bidId", "tags", "", "getTags", "()Ljava/util/Map;", "reportState", "Lio/adn/sdk/internal/domain/model/analytics/DiagnosticReportState;", "getReportState", "()Lio/adn/sdk/internal/domain/model/analytics/DiagnosticReportState;", "setReportState", "(Lio/adn/sdk/internal/domain/model/analytics/DiagnosticReportState;)V", "updateData", "", "diagnosticAdCache", "Lio/adn/sdk/internal/domain/model/analytics/DiagnosticAdCache;", "enrichWithThermalState", "thermalState", "", "(Ljava/lang/Integer;)V", "build", "Lio/adn/sdk/internal/domain/model/analytics/DiagnosticEvent;", "buildStart", "buildSuccess", "buildFailure", "adException", "Lio/adn/sdk/internal/domain/error/AdException;", "name", "", "suffix", "duration", "", "()Ljava/lang/Double;", "diagnosticInfo", "scene", "Lio/adn/sdk/internal/domain/model/ad/FullscreenAdScene;", "diagnosticInfo$adn_sdk_release", "ad", "Lio/adn/sdk/internal/domain/model/ad/NativeAdEntity;", "toDiagnosticError", "Lio/adn/sdk/internal/domain/model/ui/RenderingState;", "toDiagnosticError$adn_sdk_release", "AdLoading", "AdRequest", "FullscreenSceneLoading", "NativeAdShow", "FullscreenAdShow", "FullscreenSceneShow", "FullscreenSceneSkipped", "TokenGeneration", "FullscreenAdClick", "NativeAdClick", "NativeAdReadyForInteraction", "NativeAdDestroyed", "OmidSdkInit", "OmidScriptDownload", "OmidSession", "Lio/adn/sdk/internal/domain/model/analytics/DiagnosticEventBuilder$AdLoading;", "Lio/adn/sdk/internal/domain/model/analytics/DiagnosticEventBuilder$AdRequest;", "Lio/adn/sdk/internal/domain/model/analytics/DiagnosticEventBuilder$FullscreenAdClick;", "Lio/adn/sdk/internal/domain/model/analytics/DiagnosticEventBuilder$FullscreenAdShow;", "Lio/adn/sdk/internal/domain/model/analytics/DiagnosticEventBuilder$FullscreenSceneLoading;", "Lio/adn/sdk/internal/domain/model/analytics/DiagnosticEventBuilder$FullscreenSceneShow;", "Lio/adn/sdk/internal/domain/model/analytics/DiagnosticEventBuilder$FullscreenSceneSkipped;", "Lio/adn/sdk/internal/domain/model/analytics/DiagnosticEventBuilder$NativeAdClick;", "Lio/adn/sdk/internal/domain/model/analytics/DiagnosticEventBuilder$NativeAdDestroyed;", "Lio/adn/sdk/internal/domain/model/analytics/DiagnosticEventBuilder$NativeAdReadyForInteraction;", "Lio/adn/sdk/internal/domain/model/analytics/DiagnosticEventBuilder$NativeAdShow;", "Lio/adn/sdk/internal/domain/model/analytics/DiagnosticEventBuilder$OmidScriptDownload;", "Lio/adn/sdk/internal/domain/model/analytics/DiagnosticEventBuilder$OmidSdkInit;", "Lio/adn/sdk/internal/domain/model/analytics/DiagnosticEventBuilder$OmidSession;", "Lio/adn/sdk/internal/domain/model/analytics/DiagnosticEventBuilder$TokenGeneration;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public abstract class DiagnosticEventBuilder {
    public static final int $stable = 8;
    private String adPlacement;
    private String bidId;
    private final DiagnosticEventType eventType;
    private DiagnosticReportState reportState;
    private String sdkInitDate;
    private String sdkSessionId;
    private Long startTime;
    private final Map<String, Object> tags;

    public /* synthetic */ DiagnosticEventBuilder(DiagnosticEventType diagnosticEventType, DefaultConstructorMarker defaultConstructorMarker) {
        this(diagnosticEventType);
    }

    private DiagnosticEventBuilder(DiagnosticEventType diagnosticEventType) {
        this.eventType = diagnosticEventType;
        this.tags = new LinkedHashMap();
        this.reportState = DiagnosticReportState.None;
    }

    protected final Long getStartTime() {
        return this.startTime;
    }

    protected final void setStartTime(Long l) {
        this.startTime = l;
    }

    protected final String getAdPlacement() {
        return this.adPlacement;
    }

    protected final void setAdPlacement(String str) {
        this.adPlacement = str;
    }

    protected final Map<String, Object> getTags() {
        return this.tags;
    }

    public final DiagnosticReportState getReportState() {
        return this.reportState;
    }

    public final void setReportState(DiagnosticReportState diagnosticReportState) {
        Intrinsics.checkNotNullParameter(diagnosticReportState, "<set-?>");
        this.reportState = diagnosticReportState;
    }

    /* compiled from: DiagnosticEventBuilder.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lio/adn/sdk/internal/domain/model/analytics/DiagnosticEventBuilder$AdLoading;", "Lio/adn/sdk/internal/domain/model/analytics/DiagnosticEventBuilder;", "<init>", "()V", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class AdLoading extends DiagnosticEventBuilder {
        public static final int $stable = 0;

        public AdLoading() {
            super(DiagnosticEventType.AdLoading, null);
        }
    }

    /* compiled from: DiagnosticEventBuilder.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lio/adn/sdk/internal/domain/model/analytics/DiagnosticEventBuilder$AdRequest;", "Lio/adn/sdk/internal/domain/model/analytics/DiagnosticEventBuilder;", "<init>", "()V", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class AdRequest extends DiagnosticEventBuilder {
        public static final int $stable = 0;

        public AdRequest() {
            super(DiagnosticEventType.AdRequest, null);
        }
    }

    /* compiled from: DiagnosticEventBuilder.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"Lio/adn/sdk/internal/domain/model/analytics/DiagnosticEventBuilder$FullscreenSceneLoading;", "Lio/adn/sdk/internal/domain/model/analytics/DiagnosticEventBuilder;", "scene", "Lio/adn/sdk/internal/domain/model/ad/FullscreenAdScene;", "<init>", "(Lio/adn/sdk/internal/domain/model/ad/FullscreenAdScene;)V", "updateIsCachedProperty", "", "asset", "Lio/adn/sdk/internal/domain/model/ad/SceneAsset;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class FullscreenSceneLoading extends DiagnosticEventBuilder {
        public static final int $stable = 0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FullscreenSceneLoading(FullscreenAdScene scene) {
            super(DiagnosticEventType.SceneLoading, null);
            Intrinsics.checkNotNullParameter(scene, "scene");
            getTags().putAll(diagnosticInfo$adn_sdk_release(scene));
        }

        public final void updateIsCachedProperty(SceneAsset asset) {
            boolean fromCache;
            Intrinsics.checkNotNullParameter(asset, "asset");
            Map<String, Object> tags = getTags();
            if (asset instanceof SceneAsset.Html.FileBased) {
                fromCache = ((SceneAsset.Html.FileBased) asset).getResource().getFromCache();
            } else {
                fromCache = asset instanceof SceneAsset.Media ? ((SceneAsset.Media) asset).getResource().getFromCache() : false;
            }
            tags.put(AnalyticsConstants.IS_CACHED, Boolean.valueOf(fromCache));
        }
    }

    /* compiled from: DiagnosticEventBuilder.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\b\u001a\u00020\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lio/adn/sdk/internal/domain/model/analytics/DiagnosticEventBuilder$NativeAdShow;", "Lio/adn/sdk/internal/domain/model/analytics/DiagnosticEventBuilder;", "ad", "Lio/adn/sdk/internal/domain/model/ad/NativeAdEntity;", "<init>", "(Lio/adn/sdk/internal/domain/model/ad/NativeAdEntity;)V", "getAd", "()Lio/adn/sdk/internal/domain/model/ad/NativeAdEntity;", "resetState", "", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class NativeAdShow extends DiagnosticEventBuilder {
        public static final int $stable = 8;
        private final NativeAdEntity ad;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NativeAdShow(NativeAdEntity ad) {
            super(DiagnosticEventType.AdShow, null);
            Intrinsics.checkNotNullParameter(ad, "ad");
            this.ad = ad;
            getTags().putAll(diagnosticInfo$adn_sdk_release(ad));
        }

        public final NativeAdEntity getAd() {
            return this.ad;
        }

        public final void resetState() {
            setReportState(DiagnosticReportState.None);
            setStartTime(null);
        }
    }

    /* compiled from: DiagnosticEventBuilder.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lio/adn/sdk/internal/domain/model/analytics/DiagnosticEventBuilder$FullscreenAdShow;", "Lio/adn/sdk/internal/domain/model/analytics/DiagnosticEventBuilder;", "<init>", "()V", "updateCloseSourceProperty", "", "closeOrigin", "Lio/adn/sdk/internal/domain/model/ad/DismissOrigin;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class FullscreenAdShow extends DiagnosticEventBuilder {
        public static final int $stable = 0;

        /* compiled from: DiagnosticEventBuilder.kt */
        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[DismissOrigin.values().length];
                try {
                    iArr[DismissOrigin.User.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[DismissOrigin.System.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public FullscreenAdShow() {
            super(DiagnosticEventType.AdShow, null);
        }

        public final void updateCloseSourceProperty(DismissOrigin closeOrigin) {
            String str;
            Intrinsics.checkNotNullParameter(closeOrigin, "closeOrigin");
            Map<String, Object> tags = getTags();
            int i = WhenMappings.$EnumSwitchMapping$0[closeOrigin.ordinal()];
            if (i == 1) {
                str = AnalyticsConstants.SOURCE_USER_TYPE;
            } else {
                if (i != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                str = AnalyticsConstants.SOURCE_SYSTEM_TYPE;
            }
            tags.put("source", str);
        }
    }

    /* compiled from: DiagnosticEventBuilder.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"Lio/adn/sdk/internal/domain/model/analytics/DiagnosticEventBuilder$FullscreenSceneShow;", "Lio/adn/sdk/internal/domain/model/analytics/DiagnosticEventBuilder;", "scene", "Lio/adn/sdk/internal/domain/model/ad/FullscreenAdScene;", "<init>", "(Lio/adn/sdk/internal/domain/model/ad/FullscreenAdScene;)V", "updateAutoCloseProperty", "", "isAutoClosed", "", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class FullscreenSceneShow extends DiagnosticEventBuilder {
        public static final int $stable = 0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FullscreenSceneShow(FullscreenAdScene scene) {
            super(DiagnosticEventType.SceneShow, null);
            Intrinsics.checkNotNullParameter(scene, "scene");
            getTags().putAll(diagnosticInfo$adn_sdk_release(scene));
        }

        public final void updateAutoCloseProperty(boolean isAutoClosed) {
            getTags().put(AnalyticsConstants.AUTO_CLOSED, Boolean.valueOf(isAutoClosed));
        }
    }

    /* compiled from: DiagnosticEventBuilder.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/adn/sdk/internal/domain/model/analytics/DiagnosticEventBuilder$FullscreenSceneSkipped;", "Lio/adn/sdk/internal/domain/model/analytics/DiagnosticEventBuilder;", "scene", "Lio/adn/sdk/internal/domain/model/ad/FullscreenAdScene;", "state", "Lio/adn/sdk/internal/domain/model/ui/RenderingState;", "<init>", "(Lio/adn/sdk/internal/domain/model/ad/FullscreenAdScene;Lio/adn/sdk/internal/domain/model/ui/RenderingState;)V", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class FullscreenSceneSkipped extends DiagnosticEventBuilder {
        public static final int $stable = 0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FullscreenSceneSkipped(FullscreenAdScene scene, RenderingState state) {
            super(DiagnosticEventType.SceneSkipped, null);
            Intrinsics.checkNotNullParameter(scene, "scene");
            Intrinsics.checkNotNullParameter(state, "state");
            getTags().putAll(diagnosticInfo$adn_sdk_release(scene));
            String diagnosticError$adn_sdk_release = toDiagnosticError$adn_sdk_release(state);
            if (diagnosticError$adn_sdk_release != null) {
                getTags().put(AnalyticsConstants.ERROR_NAME, diagnosticError$adn_sdk_release);
            }
        }
    }

    /* compiled from: DiagnosticEventBuilder.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lio/adn/sdk/internal/domain/model/analytics/DiagnosticEventBuilder$TokenGeneration;", "Lio/adn/sdk/internal/domain/model/analytics/DiagnosticEventBuilder;", "<init>", "()V", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class TokenGeneration extends DiagnosticEventBuilder {
        public static final int $stable = 0;

        public TokenGeneration() {
            super(DiagnosticEventType.AdTokenGeneration, null);
        }
    }

    /* compiled from: DiagnosticEventBuilder.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"Lio/adn/sdk/internal/domain/model/analytics/DiagnosticEventBuilder$FullscreenAdClick;", "Lio/adn/sdk/internal/domain/model/analytics/DiagnosticEventBuilder;", "scene", "Lio/adn/sdk/internal/domain/model/ad/FullscreenAdScene;", "<init>", "(Lio/adn/sdk/internal/domain/model/ad/FullscreenAdScene;)V", "updateElementIdProperty", "", "element", "Lio/adn/sdk/publisher/AdnClickElement;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class FullscreenAdClick extends DiagnosticEventBuilder {
        public static final int $stable = 0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FullscreenAdClick(FullscreenAdScene scene) {
            super(DiagnosticEventType.AdClick, null);
            Intrinsics.checkNotNullParameter(scene, "scene");
            getTags().putAll(diagnosticInfo$adn_sdk_release(scene));
            getTags().put(AnalyticsConstants.IS_CLICKTHROUGH, true);
            getTags().put("source", AnalyticsConstants.SOURCE_USER_TYPE);
        }

        public final void updateElementIdProperty(AdnClickElement element) {
            Intrinsics.checkNotNullParameter(element, "element");
            getTags().put(AnalyticsConstants.ELEMENT_ID, element.getKey());
        }
    }

    /* compiled from: DiagnosticEventBuilder.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Lio/adn/sdk/internal/domain/model/analytics/DiagnosticEventBuilder$NativeAdClick;", "Lio/adn/sdk/internal/domain/model/analytics/DiagnosticEventBuilder;", "ad", "Lio/adn/sdk/internal/domain/model/ad/NativeAdEntity;", "<init>", "(Lio/adn/sdk/internal/domain/model/ad/NativeAdEntity;)V", "getAd", "()Lio/adn/sdk/internal/domain/model/ad/NativeAdEntity;", "updateElementIdProperty", "", "element", "Lio/adn/sdk/publisher/AdnClickElement;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class NativeAdClick extends DiagnosticEventBuilder {
        public static final int $stable = 8;
        private final NativeAdEntity ad;

        public final NativeAdEntity getAd() {
            return this.ad;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NativeAdClick(NativeAdEntity ad) {
            super(DiagnosticEventType.AdClick, null);
            Intrinsics.checkNotNullParameter(ad, "ad");
            this.ad = ad;
            getTags().putAll(diagnosticInfo$adn_sdk_release(ad));
            getTags().put(AnalyticsConstants.IS_CLICKTHROUGH, true);
            getTags().put("source", AnalyticsConstants.SOURCE_USER_TYPE);
        }

        public final void updateElementIdProperty(AdnClickElement element) {
            Intrinsics.checkNotNullParameter(element, "element");
            getTags().put(AnalyticsConstants.ELEMENT_ID, element.getKey());
        }
    }

    /* compiled from: DiagnosticEventBuilder.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/adn/sdk/internal/domain/model/analytics/DiagnosticEventBuilder$NativeAdReadyForInteraction;", "Lio/adn/sdk/internal/domain/model/analytics/DiagnosticEventBuilder;", "ad", "Lio/adn/sdk/internal/domain/model/ad/NativeAdEntity;", "<init>", "(Lio/adn/sdk/internal/domain/model/ad/NativeAdEntity;)V", "getAd", "()Lio/adn/sdk/internal/domain/model/ad/NativeAdEntity;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class NativeAdReadyForInteraction extends DiagnosticEventBuilder {
        public static final int $stable = 8;
        private final NativeAdEntity ad;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NativeAdReadyForInteraction(NativeAdEntity ad) {
            super(DiagnosticEventType.AdReadyForInteraction, null);
            Intrinsics.checkNotNullParameter(ad, "ad");
            this.ad = ad;
            getTags().putAll(diagnosticInfo$adn_sdk_release(ad));
        }

        public final NativeAdEntity getAd() {
            return this.ad;
        }
    }

    /* compiled from: DiagnosticEventBuilder.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/adn/sdk/internal/domain/model/analytics/DiagnosticEventBuilder$NativeAdDestroyed;", "Lio/adn/sdk/internal/domain/model/analytics/DiagnosticEventBuilder;", "ad", "Lio/adn/sdk/internal/domain/model/ad/NativeAdEntity;", "<init>", "(Lio/adn/sdk/internal/domain/model/ad/NativeAdEntity;)V", "getAd", "()Lio/adn/sdk/internal/domain/model/ad/NativeAdEntity;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class NativeAdDestroyed extends DiagnosticEventBuilder {
        public static final int $stable = 8;
        private final NativeAdEntity ad;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NativeAdDestroyed(NativeAdEntity ad) {
            super(DiagnosticEventType.AdDestroyed, null);
            Intrinsics.checkNotNullParameter(ad, "ad");
            this.ad = ad;
            getTags().putAll(diagnosticInfo$adn_sdk_release(ad));
        }

        public final NativeAdEntity getAd() {
            return this.ad;
        }
    }

    /* compiled from: DiagnosticEventBuilder.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lio/adn/sdk/internal/domain/model/analytics/DiagnosticEventBuilder$OmidSdkInit;", "Lio/adn/sdk/internal/domain/model/analytics/DiagnosticEventBuilder;", "<init>", "()V", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class OmidSdkInit extends DiagnosticEventBuilder {
        public static final int $stable = 0;

        public OmidSdkInit() {
            super(DiagnosticEventType.OmidInit, null);
        }
    }

    /* compiled from: DiagnosticEventBuilder.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lio/adn/sdk/internal/domain/model/analytics/DiagnosticEventBuilder$OmidScriptDownload;", "Lio/adn/sdk/internal/domain/model/analytics/DiagnosticEventBuilder;", V5.c.f3091a, "", "<init>", "(Ljava/lang/String;)V", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class OmidScriptDownload extends DiagnosticEventBuilder {
        public static final int $stable = 0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OmidScriptDownload(String fileUrl) {
            super(DiagnosticEventType.OmidScriptDownload, null);
            Intrinsics.checkNotNullParameter(fileUrl, "fileUrl");
            getTags().put(AnalyticsConstants.FILE_URL, fileUrl);
        }
    }

    /* compiled from: DiagnosticEventBuilder.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lio/adn/sdk/internal/domain/model/analytics/DiagnosticEventBuilder$OmidSession;", "Lio/adn/sdk/internal/domain/model/analytics/DiagnosticEventBuilder;", "sceneType", "", "<init>", "(Ljava/lang/String;)V", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class OmidSession extends DiagnosticEventBuilder {
        public static final int $stable = 0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OmidSession(String sceneType) {
            super(DiagnosticEventType.OmidSession, null);
            Intrinsics.checkNotNullParameter(sceneType, "sceneType");
            getTags().put(AnalyticsConstants.SCENE_TYPE, sceneType);
        }
    }

    public final void updateData(DiagnosticAdCache diagnosticAdCache) {
        Intrinsics.checkNotNullParameter(diagnosticAdCache, "diagnosticAdCache");
        BidExtra bidExtra = diagnosticAdCache.getBidExtra();
        if (bidExtra != null) {
            this.bidId = bidExtra.getBidId();
        }
        this.sdkInitDate = diagnosticAdCache.getInitStartDate();
        this.sdkSessionId = diagnosticAdCache.getSessionId();
        AdnAdPlacement adPlacement = diagnosticAdCache.getAdPlacement();
        this.adPlacement = adPlacement != null ? adPlacement.getValue() : null;
        Map<String, Object> map = this.tags;
        map.put(AnalyticsConstants.SHOW_STARTED, diagnosticAdCache.getShowStartDate());
        map.put(AnalyticsConstants.SCENE_EXPECTED_COUNT, diagnosticAdCache.getExpectedSceneCount());
    }

    public final void enrichWithThermalState(Integer thermalState) {
        if (thermalState != null) {
            this.tags.put(AnalyticsConstants.THERMAL_STATE, Integer.valueOf(thermalState.intValue()));
        }
    }

    public final DiagnosticEvent build() {
        return build(this.eventType.getValue(), MapsKt.toMap(this.tags));
    }

    public final DiagnosticEvent buildStart() {
        this.startTime = Long.valueOf(System.currentTimeMillis());
        return build(name(this.eventType, "start"), MapsKt.toMap(this.tags));
    }

    public final DiagnosticEvent buildSuccess() {
        String name = name(this.eventType, "success");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.putAll(this.tags);
        linkedHashMap.put("duration", duration());
        Unit unit = Unit.INSTANCE;
        return build(name, linkedHashMap);
    }

    public final DiagnosticEvent buildFailure(AdException adException) {
        Intrinsics.checkNotNullParameter(adException, "adException");
        String name = name(this.eventType, AnalyticsConstants.EVENT_FAILURE);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.putAll(this.tags);
        linkedHashMap.put(AnalyticsConstants.ERROR_NAME, adException.getError().toDiagnosticError());
        linkedHashMap.put("error_description", adException.getMessage());
        if (adException instanceof AdJsonParseException) {
            linkedHashMap.put(AnalyticsConstants.DEBUG_DATA, ((AdJsonParseException) adException).getPayload());
        }
        linkedHashMap.put("duration", duration());
        Unit unit = Unit.INSTANCE;
        return build(name, linkedHashMap);
    }

    private final DiagnosticEvent build(String name, Map<String, ? extends Object> tags) {
        return new DiagnosticEvent(null, null, name, this.sdkSessionId, this.sdkInitDate, this.adPlacement, this.bidId, tags, 3, null);
    }

    private final String name(DiagnosticEventType eventType, String suffix) {
        return eventType.getValue() + '_' + suffix;
    }

    private final Double duration() {
        Long l = this.startTime;
        if (l != null) {
            return Double.valueOf(DateKt.durationSecond(l.longValue()));
        }
        return null;
    }

    public final Map<String, Object> diagnosticInfo$adn_sdk_release(FullscreenAdScene scene) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        return MapsKt.mapOf(TuplesKt.to(AnalyticsConstants.SCENE_INDEX, Integer.valueOf(scene.getIndex())), TuplesKt.to(AnalyticsConstants.ASSET_ID, scene.getId()), TuplesKt.to(AnalyticsConstants.SCENE_TYPE, FullscreenAdEntityKt.creativeAnalyticsType(scene)));
    }

    public final Map<String, Object> diagnosticInfo$adn_sdk_release(NativeAdEntity ad) {
        Intrinsics.checkNotNullParameter(ad, "ad");
        Pair[] pairArr = new Pair[3];
        pairArr[0] = TuplesKt.to(AnalyticsConstants.SCENE_INDEX, 0);
        NativeAdAsset.Media mainMedia = ad.getMainMedia();
        pairArr[1] = TuplesKt.to(AnalyticsConstants.ASSET_ID, mainMedia != null ? Integer.valueOf(mainMedia.getId()) : null);
        pairArr[2] = TuplesKt.to(AnalyticsConstants.SCENE_TYPE, NativeAdEntityKt.mainCreativeAnalyticsType(ad));
        return MapsKt.mapOf(pairArr);
    }

    public final String toDiagnosticError$adn_sdk_release(RenderingState renderingState) {
        Intrinsics.checkNotNullParameter(renderingState, "<this>");
        if (renderingState instanceof RenderingState.Failure) {
            return ((RenderingState.Failure) renderingState).getException().getError().toDiagnosticError();
        }
        if (Intrinsics.areEqual(renderingState, RenderingState.Progress.INSTANCE)) {
            return AdError.AssetNotReady.toDiagnosticError();
        }
        if (Intrinsics.areEqual(renderingState, RenderingState.Success.INSTANCE)) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }
}
