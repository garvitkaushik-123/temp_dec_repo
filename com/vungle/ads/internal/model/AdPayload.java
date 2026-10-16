package com.vungle.ads.internal.model;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.unity.androidbridge.AndroidBridgeConstants;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.b;
import com.vungle.ads.AdConfig;
import com.vungle.ads.TpatError;
import com.vungle.ads.internal.Constants;
import com.vungle.ads.internal.model.AdAsset;
import com.vungle.ads.internal.protos.Sdk;
import com.vungle.ads.internal.util.FileUtility;
import com.vungle.ads.internal.util.LogEntry;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Regex;
import kotlinx.serialization.ContextualSerializer;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.Transient;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementBuildersKt;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonObjectBuilder;
import kotlinx.serialization.json.JsonTransformingSerializer;

/* compiled from: AdPayload.kt */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u0000 w2\u00020\u0001:\u000bstuvwxyz{|}Bo\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0001\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0016\b\u0001\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\u0016\b\u0001\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010\u0012B#\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\u0013J\u0006\u0010<\u001a\u00020\u0003J\u0006\u0010=\u001a\u00020\u000fJ\b\u0010>\u001a\u0004\u0018\u00010 J\u0006\u0010?\u001a\u00020\u0003J\b\u0010@\u001a\u0004\u0018\u00010\u000bJ\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u0006\u0010A\u001a\u00020BJ\b\u0010C\u001a\u0004\u0018\u00010\u000bJ\b\u0010D\u001a\u0004\u0018\u00010\u000bJ\u0006\u0010E\u001a\u00020\u000bJ\u0014\u0010F\u001a\b\u0012\u0004\u0012\u00020G0\u00052\u0006\u0010H\u001a\u00020%J\u0012\u0010I\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\rJ\b\u0010J\u001a\u0004\u0018\u00010\u000bJ\u0015\u0010K\u001a\u00020\u00032\b\u0010L\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010MJ.\u0010N\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00052\u0006\u0010O\u001a\u00020\u000b2\n\b\u0002\u0010P\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010\u000bJ\b\u0010R\u001a\u0004\u0018\u00010\u000bJ\b\u0010S\u001a\u0004\u0018\u00010TJ\u000e\u0010U\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0005J\u0006\u0010V\u001a\u00020\u000fJ\u0006\u0010W\u001a\u00020\u000fJ\u0006\u0010X\u001a\u00020\u000fJ\u0006\u0010Y\u001a\u00020\u000fJ\u000e\u0010Z\u001a\u00020\u000f2\u0006\u0010[\u001a\u00020\u000bJ\u0006\u0010\\\u001a\u00020\u000fJ\u0006\u0010]\u001a\u00020\u000fJ\b\u0010^\u001a\u0004\u0018\u00010\u000bJ\u0006\u0010_\u001a\u00020`J&\u0010a\u001a\u00020`2\u0006\u0010b\u001a\u00020\u000b2\u0006\u0010c\u001a\u00020\u000b2\u0006\u0010d\u001a\u00020\u000b2\u0006\u0010e\u001a\u00020\u000bJ\b\u0010f\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010g\u001a\u00020`2\b\u0010h\u001a\u0004\u0018\u00010GJ\u0012\u0010i\u001a\u00020\u000b2\b\u0010P\u001a\u0004\u0018\u00010\u000bH\u0002J!\u0010j\u001a\u00020`2\u0006\u0010k\u001a\u00020\u00002\u0006\u0010l\u001a\u00020m2\u0006\u0010n\u001a\u00020oHÇ\u0001J\u001e\u0010p\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010q\u001a\u00020\u000b2\b\u0010r\u001a\u0004\u0018\u00010\u000bH\u0002R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R&\u0010\u0017\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0016\u0010\u001f\u001a\u0004\u0018\u00010 8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b#\u0010\u001aR*\u0010&\u001a\u0004\u0018\u00010%2\b\u0010$\u001a\u0004\u0018\u00010%8\u0006@BX\u0087\u000e¢\u0006\u000e\n\u0000\u0012\u0004\b'\u0010\u001a\u001a\u0004\b(\u0010)R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b.\u0010\u001aR0\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b/\u0010\u001a\u001a\u0004\b0\u00101\"\u0004\b2\u00103R&\u00104\u001a\u0004\u0018\u0001058\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b6\u0010\u001a\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R$\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\n8\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0000\u0012\u0004\b;\u0010\u001a¨\u0006~"}, d2 = {"Lcom/vungle/ads/internal/model/AdPayload;", "", "seen1", "", b.JSON_KEY_ADS, "", "Lcom/vungle/ads/internal/model/AdPayload$PlacementAdUnit;", "config", "Lcom/vungle/ads/internal/model/ConfigPayload;", "mraidFiles", "Ljava/util/concurrent/ConcurrentHashMap;", "", "incentivizedTextSettings", "", "assetsFullyDownloaded", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Lcom/vungle/ads/internal/model/ConfigPayload;Ljava/util/concurrent/ConcurrentHashMap;Ljava/util/Map;ZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/util/List;Lcom/vungle/ads/internal/model/ConfigPayload;)V", "ad", "getAd", "()Lcom/vungle/ads/internal/model/AdPayload$PlacementAdUnit;", "adConfig", "Lcom/vungle/ads/AdConfig;", "getAdConfig$annotations", "()V", "getAdConfig", "()Lcom/vungle/ads/AdConfig;", "setAdConfig", "(Lcom/vungle/ads/AdConfig;)V", "adMarkup", "Lcom/vungle/ads/internal/model/AdPayload$AdUnit;", "getAdMarkup", "()Lcom/vungle/ads/internal/model/AdPayload$AdUnit;", "getAds$annotations", "<set-?>", "Ljava/io/File;", "assetDirectory", "getAssetDirectory$annotations", "getAssetDirectory", "()Ljava/io/File;", "getAssetsFullyDownloaded", "()Z", "setAssetsFullyDownloaded", "(Z)V", "getConfig$annotations", "getIncentivizedTextSettings$annotations", "getIncentivizedTextSettings", "()Ljava/util/Map;", "setIncentivizedTextSettings", "(Ljava/util/Map;)V", "logEntry", "Lcom/vungle/ads/internal/util/LogEntry;", "getLogEntry$vungle_ads_release$annotations", "getLogEntry$vungle_ads_release", "()Lcom/vungle/ads/internal/util/LogEntry;", "setLogEntry$vungle_ads_release", "(Lcom/vungle/ads/internal/util/LogEntry;)V", "getMraidFiles$annotations", "adHeight", "adLoadOptimizationEnabled", "adUnit", "adWidth", "advAppId", "createMRAIDArgs", "Lkotlinx/serialization/json/JsonObject;", "eventId", "getAdSource", "getCreativeId", "getDownloadableAssets", "Lcom/vungle/ads/internal/model/AdAsset;", "dir", "getMRAIDArgsInMap", "getMediationName", "getShowCloseDelay", "incentivized", "(Ljava/lang/Boolean;)I", "getTpatUrls", "event", "value", "secondValue", "getViewMasterVersion", "getWebViewSettings", "Lcom/vungle/ads/internal/model/AdPayload$WebViewSettings;", "getWinNotifications", "hasExpired", "heartbeatEnabled", "isCacheableAssetsRequired", "isClickCoordinatesTrackingEnabled", "isCriticalAsset", "failingUrl", "isNativeTemplateType", "omEnabled", "placementId", "setAssetFullyDownloaded", "", "setIncentivizedText", "title", "body", "keepWatching", "close", "templateType", "updateAdAssetPath", "adAsset", "valueOrEmpty", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "complexReplace", "oldValue", "newValue", "$serializer", "AdSizeInfo", "AdUnit", "CacheableReplacement", "Companion", "PlacementAdUnit", "TemplateSettings", "TpatSerializer", "ViewAbility", "ViewAbilityInfo", "WebViewSettings", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Serializable
/* loaded from: classes7.dex */
public final class AdPayload {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String FILE_SCHEME = "file://";
    public static final String INCENTIVIZED_BODY_TEXT = "INCENTIVIZED_BODY_TEXT";
    public static final String INCENTIVIZED_CLOSE_TEXT = "INCENTIVIZED_CLOSE_TEXT";
    public static final String INCENTIVIZED_CONTINUE_TEXT = "INCENTIVIZED_CONTINUE_TEXT";
    public static final String INCENTIVIZED_TITLE_TEXT = "INCENTIVIZED_TITLE_TEXT";
    public static final String KEY_TEMPLATE = "template";
    public static final String KEY_VM = "vmURL";
    public static final String TPAT_CLICK_COORDINATES_URLS = "video.clickCoordinates";
    private static final String UNKNOWN = "unknown";
    private AdConfig adConfig;
    private final List<PlacementAdUnit> ads;
    private File assetDirectory;
    private boolean assetsFullyDownloaded;
    private final ConfigPayload config;
    private Map<String, String> incentivizedTextSettings;
    private LogEntry logEntry;
    private ConcurrentHashMap<String, String> mraidFiles;

    /* JADX WARN: Multi-variable type inference failed */
    public AdPayload() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @Transient
    public static /* synthetic */ void getAdConfig$annotations() {
    }

    @SerialName(b.JSON_KEY_ADS)
    private static /* synthetic */ void getAds$annotations() {
    }

    @Transient
    public static /* synthetic */ void getAssetDirectory$annotations() {
    }

    @SerialName("config")
    private static /* synthetic */ void getConfig$annotations() {
    }

    public static /* synthetic */ void getIncentivizedTextSettings$annotations() {
    }

    @Transient
    public static /* synthetic */ void getLogEntry$vungle_ads_release$annotations() {
    }

    private static /* synthetic */ void getMraidFiles$annotations() {
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ AdPayload(int i, @SerialName("ads") List list, @SerialName("config") ConfigPayload configPayload, ConcurrentHashMap concurrentHashMap, Map map, boolean z, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.ads = null;
        } else {
            this.ads = list;
        }
        if ((i & 2) == 0) {
            this.config = null;
        } else {
            this.config = configPayload;
        }
        if ((i & 4) == 0) {
            this.mraidFiles = new ConcurrentHashMap<>();
        } else {
            this.mraidFiles = concurrentHashMap;
        }
        if ((i & 8) == 0) {
            this.incentivizedTextSettings = new HashMap();
        } else {
            this.incentivizedTextSettings = map;
        }
        if ((i & 16) == 0) {
            this.assetsFullyDownloaded = false;
        } else {
            this.assetsFullyDownloaded = z;
        }
        this.adConfig = null;
        this.logEntry = null;
        this.assetDirectory = null;
    }

    public AdPayload(List<PlacementAdUnit> list, ConfigPayload configPayload) {
        this.ads = list;
        this.config = configPayload;
        this.mraidFiles = new ConcurrentHashMap<>();
        this.incentivizedTextSettings = new HashMap();
    }

    @JvmStatic
    public static final void write$Self(AdPayload self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Intrinsics.checkNotNullParameter(self, "self");
        Intrinsics.checkNotNullParameter(output, "output");
        Intrinsics.checkNotNullParameter(serialDesc, "serialDesc");
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.ads != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, new ArrayListSerializer(AdPayload$PlacementAdUnit$$serializer.INSTANCE), self.ads);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.config != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, ConfigPayload$$serializer.INSTANCE, self.config);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || !Intrinsics.areEqual(self.mraidFiles, new ConcurrentHashMap())) {
            output.encodeSerializableElement(serialDesc, 2, new ContextualSerializer(Reflection.getOrCreateKotlinClass(ConcurrentHashMap.class), null, new KSerializer[]{StringSerializer.INSTANCE, StringSerializer.INSTANCE}), self.mraidFiles);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || !Intrinsics.areEqual(self.incentivizedTextSettings, new HashMap())) {
            output.encodeSerializableElement(serialDesc, 3, new LinkedHashMapSerializer(StringSerializer.INSTANCE, StringSerializer.INSTANCE), self.incentivizedTextSettings);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.assetsFullyDownloaded) {
            output.encodeBooleanElement(serialDesc, 4, self.assetsFullyDownloaded);
        }
    }

    public /* synthetic */ AdPayload(List list, ConfigPayload configPayload, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : configPayload);
    }

    /* compiled from: AdPayload.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eHÆ\u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/vungle/ads/internal/model/AdPayload$Companion;", "", "()V", "FILE_SCHEME", "", AdPayload.INCENTIVIZED_BODY_TEXT, AdPayload.INCENTIVIZED_CLOSE_TEXT, AdPayload.INCENTIVIZED_CONTINUE_TEXT, AdPayload.INCENTIVIZED_TITLE_TEXT, "KEY_TEMPLATE", "KEY_VM", "TPAT_CLICK_COORDINATES_URLS", "UNKNOWN", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/vungle/ads/internal/model/AdPayload;", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<AdPayload> serializer() {
            return AdPayload$$serializer.INSTANCE;
        }
    }

    private final PlacementAdUnit getAd() {
        List<PlacementAdUnit> list = this.ads;
        if (list != null) {
            if (!list.isEmpty()) {
                return list.get(0);
            }
        }
        return null;
    }

    private final AdUnit getAdMarkup() {
        PlacementAdUnit ad = getAd();
        if (ad != null) {
            return ad.getAdMarkup();
        }
        return null;
    }

    public final String placementId() {
        PlacementAdUnit ad = getAd();
        if (ad != null) {
            return ad.getPlacementReferenceId();
        }
        return null;
    }

    public final String eventId() {
        AdUnit adMarkup = getAdMarkup();
        if (adMarkup != null) {
            return adMarkup.getId();
        }
        return null;
    }

    public final String advAppId() {
        AdUnit adMarkup = getAdMarkup();
        if (adMarkup != null) {
            return adMarkup.getAdvAppId();
        }
        return null;
    }

    public final int adWidth() {
        AdSizeInfo adSizeInfo;
        Integer width;
        AdUnit adMarkup = getAdMarkup();
        if (adMarkup == null || (adSizeInfo = adMarkup.getAdSizeInfo()) == null || (width = adSizeInfo.getWidth()) == null) {
            return 0;
        }
        return width.intValue();
    }

    public final int adHeight() {
        AdSizeInfo adSizeInfo;
        Integer height;
        AdUnit adMarkup = getAdMarkup();
        if (adMarkup == null || (adSizeInfo = adMarkup.getAdSizeInfo()) == null || (height = adSizeInfo.getHeight()) == null) {
            return 0;
        }
        return height.intValue();
    }

    public final AdUnit adUnit() {
        return getAdMarkup();
    }

    /* renamed from: config, reason: from getter */
    public final ConfigPayload getConfig() {
        return this.config;
    }

    public final boolean adLoadOptimizationEnabled() {
        Boolean adLoadOptimizationEnabled;
        AdUnit adMarkup = getAdMarkup();
        if (adMarkup == null || (adLoadOptimizationEnabled = adMarkup.getAdLoadOptimizationEnabled()) == null) {
            return true;
        }
        return adLoadOptimizationEnabled.booleanValue();
    }

    public final boolean isCacheableAssetsRequired() {
        Boolean isCacheableAssetsRequired;
        AdUnit adMarkup = getAdMarkup();
        if (adMarkup == null || (isCacheableAssetsRequired = adMarkup.isCacheableAssetsRequired()) == null) {
            return true;
        }
        return isCacheableAssetsRequired.booleanValue();
    }

    public final Map<String, String> getIncentivizedTextSettings() {
        return this.incentivizedTextSettings;
    }

    public final void setIncentivizedTextSettings(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.incentivizedTextSettings = map;
    }

    public final boolean getAssetsFullyDownloaded() {
        return this.assetsFullyDownloaded;
    }

    public final void setAssetsFullyDownloaded(boolean z) {
        this.assetsFullyDownloaded = z;
    }

    public final AdConfig getAdConfig() {
        return this.adConfig;
    }

    public final void setAdConfig(AdConfig adConfig) {
        this.adConfig = adConfig;
    }

    /* renamed from: getLogEntry$vungle_ads_release, reason: from getter */
    public final LogEntry getLogEntry() {
        return this.logEntry;
    }

    public final void setLogEntry$vungle_ads_release(LogEntry logEntry) {
        this.logEntry = logEntry;
    }

    public final File getAssetDirectory() {
        return this.assetDirectory;
    }

    public final boolean omEnabled() {
        ViewAbility viewAbility;
        ViewAbilityInfo om;
        Boolean isEnabled;
        AdUnit adMarkup = getAdMarkup();
        if (adMarkup == null || (viewAbility = adMarkup.getViewAbility()) == null || (om = viewAbility.getOm()) == null || (isEnabled = om.isEnabled()) == null) {
            return false;
        }
        return isEnabled.booleanValue();
    }

    public final boolean isClickCoordinatesTrackingEnabled() {
        Boolean clickCoordinatesEnabled;
        AdUnit adMarkup = getAdMarkup();
        if (adMarkup == null || (clickCoordinatesEnabled = adMarkup.getClickCoordinatesEnabled()) == null) {
            return false;
        }
        return clickCoordinatesEnabled.booleanValue();
    }

    public final boolean isCriticalAsset(String failingUrl) {
        TemplateSettings templateSettings;
        Map<String, CacheableReplacement> cacheableReplacements;
        Intrinsics.checkNotNullParameter(failingUrl, "failingUrl");
        if (!isNativeTemplateType()) {
            AdUnit adMarkup = getAdMarkup();
            if (Intrinsics.areEqual(adMarkup != null ? adMarkup.getTemplateURL() : null, failingUrl)) {
                return true;
            }
        }
        AdUnit adMarkup2 = getAdMarkup();
        if (adMarkup2 == null || (templateSettings = adMarkup2.getTemplateSettings()) == null || (cacheableReplacements = templateSettings.getCacheableReplacements()) == null) {
            return false;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, CacheableReplacement> entry : cacheableReplacements.entrySet()) {
            if (Intrinsics.areEqual(entry.getValue().getUrl(), failingUrl)) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return !linkedHashMap.isEmpty();
    }

    public final boolean heartbeatEnabled() {
        Boolean templateHeartbeatCheck;
        AdUnit adMarkup = getAdMarkup();
        if (adMarkup == null || (templateHeartbeatCheck = adMarkup.getTemplateHeartbeatCheck()) == null) {
            return false;
        }
        return templateHeartbeatCheck.booleanValue();
    }

    public final List<AdAsset> getDownloadableAssets(File dir) {
        TemplateSettings templateSettings;
        Map<String, CacheableReplacement> cacheableReplacements;
        boolean z;
        String templateURL;
        String vmURL;
        Intrinsics.checkNotNullParameter(dir, "dir");
        this.assetDirectory = dir;
        ArrayList arrayList = new ArrayList();
        if (!isNativeTemplateType()) {
            AdUnit adMarkup = getAdMarkup();
            if (adMarkup != null && (vmURL = adMarkup.getVmURL()) != null) {
                if (FileUtility.INSTANCE.isValidUrl(vmURL)) {
                    String filePath = new File(dir, Constants.AD_INDEX_FILE_NAME).getAbsolutePath();
                    Intrinsics.checkNotNullExpressionValue(filePath, "filePath");
                    arrayList.add(new AdAsset(KEY_VM, vmURL, filePath, AdAsset.FileType.ASSET, true));
                }
            } else {
                AdUnit adMarkup2 = getAdMarkup();
                if (adMarkup2 != null && (templateURL = adMarkup2.getTemplateURL()) != null && FileUtility.INSTANCE.isValidUrl(templateURL)) {
                    String filePath2 = new File(dir, "template").getAbsolutePath();
                    Intrinsics.checkNotNullExpressionValue(filePath2, "filePath");
                    arrayList.add(new AdAsset("template", templateURL, filePath2, AdAsset.FileType.ZIP, true));
                }
            }
        }
        AdUnit adMarkup3 = getAdMarkup();
        if (adMarkup3 != null && (templateSettings = adMarkup3.getTemplateSettings()) != null && (cacheableReplacements = templateSettings.getCacheableReplacements()) != null) {
            for (Map.Entry<String, CacheableReplacement> entry : cacheableReplacements.entrySet()) {
                CacheableReplacement value = entry.getValue();
                if (value.getUrl() != null && FileUtility.INSTANCE.isValidUrl(value.getUrl())) {
                    Boolean required = value.getRequired();
                    boolean booleanValue = required != null ? required.booleanValue() : false;
                    if (!isNativeTemplateType() && adLoadOptimizationEnabled()) {
                        z = !isCacheableAssetsRequired() ? false : booleanValue;
                    } else {
                        z = true;
                    }
                    String filePath3 = new File(dir, FileUtility.INSTANCE.guessFileName(value.getUrl(), value.getExtension())).getAbsolutePath();
                    String key = entry.getKey();
                    String url = value.getUrl();
                    Intrinsics.checkNotNullExpressionValue(filePath3, "filePath");
                    arrayList.add(new AdAsset(key, url, filePath3, AdAsset.FileType.ASSET, z));
                }
            }
        }
        if (arrayList.size() > 1) {
            CollectionsKt.sortWith(arrayList, new Comparator() { // from class: com.vungle.ads.internal.model.AdPayload$getDownloadableAssets$$inlined$sortByDescending$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(Boolean.valueOf(((AdAsset) t2).getIsRequired()), Boolean.valueOf(((AdAsset) t).getIsRequired()));
                }
            });
        }
        return arrayList;
    }

    public static /* synthetic */ List getTpatUrls$default(AdPayload adPayload, String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            str3 = null;
        }
        return adPayload.getTpatUrls(str, str2, str3);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final List<String> getTpatUrls(String event, String value, String secondValue) {
        Map<String, List<String>> tpat;
        Map<String, List<String>> tpat2;
        Intrinsics.checkNotNullParameter(event, "event");
        AdUnit adMarkup = getAdMarkup();
        if (adMarkup != null && (tpat2 = adMarkup.getTpat()) != null && !tpat2.containsKey(event)) {
            new TpatError(Sdk.SDKError.Reason.INVALID_TPAT_KEY, "Arbitrary tpat key: " + event).setLogEntry$vungle_ads_release(this.logEntry).logErrorNoReturnValue$vungle_ads_release();
            return null;
        }
        AdUnit adMarkup2 = getAdMarkup();
        List<String> list = (adMarkup2 == null || (tpat = adMarkup2.getTpat()) == null) ? null : tpat.get(event);
        List<String> list2 = list;
        if (list2 == null || list2.isEmpty()) {
            new TpatError(Sdk.SDKError.Reason.EMPTY_TPAT_ERROR, "Empty tpat key: " + event).setLogEntry$vungle_ads_release(this.logEntry).logErrorNoReturnValue$vungle_ads_release();
            return null;
        }
        switch (event.hashCode()) {
            case -2125915830:
                if (event.equals(Constants.CHECKPOINT_0)) {
                    List<String> list3 = list;
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
                    Iterator<T> it = list3.iterator();
                    while (it.hasNext()) {
                        arrayList.add(complexReplace(complexReplace(complexReplace((String) it.next(), Constants.REMOTE_PLAY_KEY, String.valueOf(!this.assetsFullyDownloaded)), Constants.NETWORK_OPERATOR_KEY, value), Constants.DEVICE_VOLUME_KEY, secondValue));
                    }
                    return arrayList;
                }
                return list;
            case -747709511:
                if (event.equals(Constants.VIDEO_LENGTH_TPAT)) {
                    List<String> list4 = list;
                    ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list4, 10));
                    Iterator<T> it2 = list4.iterator();
                    while (it2.hasNext()) {
                        arrayList2.add(complexReplace((String) it2.next(), Constants.VIDEO_LENGTH_KEY, value));
                    }
                    return arrayList2;
                }
                return list;
            case -132489083:
                if (event.equals(Constants.AD_LOAD_DURATION)) {
                    List<String> list5 = list;
                    ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list5, 10));
                    Iterator<T> it3 = list5.iterator();
                    while (it3.hasNext()) {
                        arrayList3.add(complexReplace((String) it3.next(), Constants.AD_LOAD_DURATION_KEY, value));
                    }
                    return arrayList3;
                }
                return list;
            case 1516630125:
                if (event.equals(Constants.AD_CLOSE)) {
                    List<String> list6 = list;
                    ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list6, 10));
                    Iterator<T> it4 = list6.iterator();
                    while (it4.hasNext()) {
                        arrayList4.add(complexReplace(complexReplace((String) it4.next(), Constants.AD_DURATION_KEY, value), Constants.DEVICE_VOLUME_KEY, secondValue));
                    }
                    return arrayList4;
                }
                return list;
            case 1940309120:
                if (event.equals(Constants.DEEPLINK_CLICK)) {
                    List<String> list7 = list;
                    ArrayList arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list7, 10));
                    Iterator<T> it5 = list7.iterator();
                    while (it5.hasNext()) {
                        arrayList5.add(complexReplace((String) it5.next(), Constants.DEEPLINK_SUCCESS_KEY, value));
                    }
                    return arrayList5;
                }
                return list;
            default:
                return list;
        }
    }

    public final boolean hasExpired() {
        Integer expiry;
        AdUnit adMarkup = getAdMarkup();
        return (adMarkup == null || (expiry = adMarkup.getExpiry()) == null || ((long) expiry.intValue()) >= System.currentTimeMillis() / 1000) ? false : true;
    }

    public final List<String> getWinNotifications() {
        AdUnit adMarkup = getAdMarkup();
        if (adMarkup != null) {
            return adMarkup.getNotification();
        }
        return null;
    }

    public final boolean isNativeTemplateType() {
        return Intrinsics.areEqual(templateType(), "native");
    }

    public final String templateType() {
        AdUnit adMarkup = getAdMarkup();
        if (adMarkup != null) {
            return adMarkup.getTemplateType();
        }
        return null;
    }

    public final void setIncentivizedText(String title, String body, String keepWatching, String close) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.checkNotNullParameter(keepWatching, "keepWatching");
        Intrinsics.checkNotNullParameter(close, "close");
        if (title.length() > 0) {
            this.incentivizedTextSettings.put(INCENTIVIZED_TITLE_TEXT, title);
        }
        if (body.length() > 0) {
            this.incentivizedTextSettings.put(INCENTIVIZED_BODY_TEXT, body);
        }
        if (keepWatching.length() > 0) {
            this.incentivizedTextSettings.put(INCENTIVIZED_CONTINUE_TEXT, keepWatching);
        }
        if (close.length() > 0) {
            this.incentivizedTextSettings.put(INCENTIVIZED_CLOSE_TEXT, close);
        }
    }

    public final void setAssetFullyDownloaded() {
        this.assetsFullyDownloaded = true;
    }

    public final Map<String, String> getMRAIDArgsInMap() {
        TemplateSettings templateSettings;
        Map<String, CacheableReplacement> cacheableReplacements;
        TemplateSettings templateSettings2;
        Map<String, String> normalReplacements;
        AdUnit adMarkup = getAdMarkup();
        if ((adMarkup != null ? adMarkup.getTemplateSettings() : null) == null) {
            throw new IllegalArgumentException("Advertisement does not have MRAID Arguments!".toString());
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        AdUnit adMarkup2 = getAdMarkup();
        if (adMarkup2 != null && (templateSettings2 = adMarkup2.getTemplateSettings()) != null && (normalReplacements = templateSettings2.getNormalReplacements()) != null) {
            linkedHashMap.putAll(normalReplacements);
        }
        AdUnit adMarkup3 = getAdMarkup();
        if (adMarkup3 != null && (templateSettings = adMarkup3.getTemplateSettings()) != null && (cacheableReplacements = templateSettings.getCacheableReplacements()) != null) {
            for (Map.Entry<String, CacheableReplacement> entry : cacheableReplacements.entrySet()) {
                String url = entry.getValue().getUrl();
                if (url != null) {
                    linkedHashMap.put(entry.getKey(), url);
                }
            }
        }
        if (!this.mraidFiles.isEmpty()) {
            linkedHashMap.putAll(this.mraidFiles);
        }
        if (!this.incentivizedTextSettings.isEmpty()) {
            linkedHashMap.putAll(this.incentivizedTextSettings);
        }
        return linkedHashMap;
    }

    public final JsonObject createMRAIDArgs() {
        Map<String, String> mRAIDArgsInMap = getMRAIDArgsInMap();
        JsonObjectBuilder jsonObjectBuilder = new JsonObjectBuilder();
        for (Map.Entry<String, String> entry : mRAIDArgsInMap.entrySet()) {
            JsonElementBuildersKt.put(jsonObjectBuilder, entry.getKey(), entry.getValue());
        }
        return jsonObjectBuilder.build();
    }

    public final int getShowCloseDelay(Boolean incentivized) {
        Integer showClose;
        int intValue;
        Integer showCloseIncentivized;
        if (Intrinsics.areEqual((Object) incentivized, (Object) true)) {
            AdUnit adMarkup = getAdMarkup();
            if (adMarkup == null || (showCloseIncentivized = adMarkup.getShowCloseIncentivized()) == null) {
                return 0;
            }
            intValue = showCloseIncentivized.intValue();
        } else {
            AdUnit adMarkup2 = getAdMarkup();
            if (adMarkup2 == null || (showClose = adMarkup2.getShowClose()) == null) {
                return 0;
            }
            intValue = showClose.intValue();
        }
        return intValue * 1000;
    }

    public final String getCreativeId() {
        String creativeId;
        AdUnit adMarkup = getAdMarkup();
        return (adMarkup == null || (creativeId = adMarkup.getCreativeId()) == null) ? "unknown" : creativeId;
    }

    public final String getAdSource() {
        AdUnit adMarkup = getAdMarkup();
        if (adMarkup != null) {
            return adMarkup.getAdSource();
        }
        return null;
    }

    public final String getMediationName() {
        AdUnit adMarkup = getAdMarkup();
        if (adMarkup != null) {
            return adMarkup.getMediationName();
        }
        return null;
    }

    public final String getViewMasterVersion() {
        AdUnit adMarkup = getAdMarkup();
        if (adMarkup != null) {
            return adMarkup.getVmVersion();
        }
        return null;
    }

    public final WebViewSettings getWebViewSettings() {
        AdUnit adMarkup = getAdMarkup();
        if (adMarkup != null) {
            return adMarkup.getWebViewSettings();
        }
        return null;
    }

    private final String valueOrEmpty(String value) {
        return value == null ? "" : value;
    }

    private final String complexReplace(String str, String str2, String str3) {
        String quote = Pattern.quote(str2);
        Intrinsics.checkNotNullExpressionValue(quote, "quote(oldValue)");
        return new Regex(quote).replace(str, valueOrEmpty(str3));
    }

    public final synchronized void updateAdAssetPath(AdAsset adAsset) {
        if (adAsset != null) {
            if (!Intrinsics.areEqual("template", adAsset.getAdIdentifier())) {
                File file = new File(adAsset.getLocalPath());
                if (file.exists()) {
                    this.mraidFiles.put(adAsset.getAdIdentifier(), FILE_SCHEME + file.getPath());
                }
            }
        }
    }

    /* compiled from: AdPayload.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 #2\u00020\u0001:\u0002\"#B1\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB\u001d\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003J!\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001J!\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!HÇ\u0001R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u0012¨\u0006$"}, d2 = {"Lcom/vungle/ads/internal/model/AdPayload$PlacementAdUnit;", "", "seen1", "", "placementReferenceId", "", "adMarkup", "Lcom/vungle/ads/internal/model/AdPayload$AdUnit;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lcom/vungle/ads/internal/model/AdPayload$AdUnit;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Lcom/vungle/ads/internal/model/AdPayload$AdUnit;)V", "getAdMarkup$annotations", "()V", "getAdMarkup", "()Lcom/vungle/ads/internal/model/AdPayload$AdUnit;", "getPlacementReferenceId$annotations", "getPlacementReferenceId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @Serializable
    public static final /* data */ class PlacementAdUnit {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final AdUnit adMarkup;
        private final String placementReferenceId;

        /* JADX WARN: Multi-variable type inference failed */
        public PlacementAdUnit() {
            this((String) null, (AdUnit) (0 == true ? 1 : 0), 3, (DefaultConstructorMarker) (0 == true ? 1 : 0));
        }

        public static /* synthetic */ PlacementAdUnit copy$default(PlacementAdUnit placementAdUnit, String str, AdUnit adUnit, int i, Object obj) {
            if ((i & 1) != 0) {
                str = placementAdUnit.placementReferenceId;
            }
            if ((i & 2) != 0) {
                adUnit = placementAdUnit.adMarkup;
            }
            return placementAdUnit.copy(str, adUnit);
        }

        @SerialName("ad_markup")
        public static /* synthetic */ void getAdMarkup$annotations() {
        }

        @SerialName("placement_reference_id")
        public static /* synthetic */ void getPlacementReferenceId$annotations() {
        }

        /* renamed from: component1, reason: from getter */
        public final String getPlacementReferenceId() {
            return this.placementReferenceId;
        }

        /* renamed from: component2, reason: from getter */
        public final AdUnit getAdMarkup() {
            return this.adMarkup;
        }

        public final PlacementAdUnit copy(String placementReferenceId, AdUnit adMarkup) {
            return new PlacementAdUnit(placementReferenceId, adMarkup);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PlacementAdUnit)) {
                return false;
            }
            PlacementAdUnit placementAdUnit = (PlacementAdUnit) other;
            return Intrinsics.areEqual(this.placementReferenceId, placementAdUnit.placementReferenceId) && Intrinsics.areEqual(this.adMarkup, placementAdUnit.adMarkup);
        }

        public int hashCode() {
            String str = this.placementReferenceId;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            AdUnit adUnit = this.adMarkup;
            return hashCode + (adUnit != null ? adUnit.hashCode() : 0);
        }

        public String toString() {
            return "PlacementAdUnit(placementReferenceId=" + this.placementReferenceId + ", adMarkup=" + this.adMarkup + ')';
        }

        /* compiled from: AdPayload.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/vungle/ads/internal/model/AdPayload$PlacementAdUnit$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/vungle/ads/internal/model/AdPayload$PlacementAdUnit;", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<PlacementAdUnit> serializer() {
                return AdPayload$PlacementAdUnit$$serializer.INSTANCE;
            }
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ PlacementAdUnit(int i, @SerialName("placement_reference_id") String str, @SerialName("ad_markup") AdUnit adUnit, SerializationConstructorMarker serializationConstructorMarker) {
            if ((i & 1) == 0) {
                this.placementReferenceId = null;
            } else {
                this.placementReferenceId = str;
            }
            if ((i & 2) == 0) {
                this.adMarkup = null;
            } else {
                this.adMarkup = adUnit;
            }
        }

        public PlacementAdUnit(String str, AdUnit adUnit) {
            this.placementReferenceId = str;
            this.adMarkup = adUnit;
        }

        @JvmStatic
        public static final void write$Self(PlacementAdUnit self, CompositeEncoder output, SerialDescriptor serialDesc) {
            Intrinsics.checkNotNullParameter(self, "self");
            Intrinsics.checkNotNullParameter(output, "output");
            Intrinsics.checkNotNullParameter(serialDesc, "serialDesc");
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.placementReferenceId != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.placementReferenceId);
            }
            if (!output.shouldEncodeElementDefault(serialDesc, 1) && self.adMarkup == null) {
                return;
            }
            output.encodeNullableSerializableElement(serialDesc, 1, AdPayload$AdUnit$$serializer.INSTANCE, self.adMarkup);
        }

        public /* synthetic */ PlacementAdUnit(String str, AdUnit adUnit, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : adUnit);
        }

        public final String getPlacementReferenceId() {
            return this.placementReferenceId;
        }

        public final AdUnit getAdMarkup() {
            return this.adMarkup;
        }
    }

    /* compiled from: AdPayload.kt */
    @Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\bk\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u009d\u00012\u00020\u0001:\u0004\u009c\u0001\u009d\u0001B\u0093\u0003\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\u001c\b\u0001\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0014\u0018\u00010\u0013\u0012\n\b\u0001\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0001\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0014\u0012\u0010\b\u0001\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0014\u0012\n\b\u0001\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0001\u0010\u001c\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u001d\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u001e\u001a\u0004\u0018\u00010\u001f\u0012\n\b\u0001\u0010 \u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010!\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\"\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010#\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010$\u001a\u0004\u0018\u00010%\u0012\n\b\u0001\u0010&\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0001\u0010'\u001a\u0004\u0018\u00010(\u0012\b\u0010)\u001a\u0004\u0018\u00010*¢\u0006\u0002\u0010+Bÿ\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\u001c\b\u0002\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0014\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0014\u0012\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(¢\u0006\u0002\u0010,J\u000b\u0010r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010s\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010t\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010FJ\u0010\u0010u\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010FJ\u001d\u0010v\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0014\u0018\u00010\u0013HÆ\u0003J\u000b\u0010w\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010x\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010y\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010z\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0014HÆ\u0003J\u0011\u0010{\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0014HÆ\u0003J\u000b\u0010|\u001a\u0004\u0018\u00010\u001bHÆ\u0003J\u000b\u0010}\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010~\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u007f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u001fHÆ\u0003J\f\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010FJ\u0011\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010FJ\f\u0010\u0085\u0001\u001a\u0004\u0018\u00010%HÆ\u0003J\u0011\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u00100J\f\u0010\u0087\u0001\u001a\u0004\u0018\u00010(HÆ\u0003J\f\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010FJ\f\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u00100J\u0011\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u00100J\u0011\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u00100J\f\u0010\u008e\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u008a\u0003\u0010\u008f\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\u001c\b\u0002\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0014\u0018\u00010\u00132\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00142\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00142\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(HÆ\u0001¢\u0006\u0003\u0010\u0090\u0001J\u0015\u0010\u0091\u0001\u001a\u00020\u000b2\t\u0010\u0092\u0001\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\n\u0010\u0093\u0001\u001a\u00020\u0003HÖ\u0001J\n\u0010\u0094\u0001\u001a\u00020\u0005HÖ\u0001J(\u0010\u0095\u0001\u001a\u00030\u0096\u00012\u0007\u0010\u0097\u0001\u001a\u00020\u00002\b\u0010\u0098\u0001\u001a\u00030\u0099\u00012\b\u0010\u009a\u0001\u001a\u00030\u009b\u0001HÇ\u0001R \u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u00101\u0012\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b2\u0010.\u001a\u0004\b3\u00104R\u001e\u0010$\u001a\u0004\u0018\u00010%8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b5\u0010.\u001a\u0004\b6\u00107R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b8\u0010.\u001a\u0004\b9\u00104R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b:\u0010.\u001a\u0004\b;\u00104R\u001e\u0010!\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b<\u0010.\u001a\u0004\b=\u00104R \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u00101\u0012\u0004\b>\u0010.\u001a\u0004\b?\u00100R\u001e\u0010 \u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b@\u0010.\u001a\u0004\bA\u00104R\u001e\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bB\u0010.\u001a\u0004\bC\u00104R \u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010G\u0012\u0004\bD\u0010.\u001a\u0004\bE\u0010FR \u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010G\u0012\u0004\bH\u0010.\u001a\u0004\bI\u0010FR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bJ\u0010.\u001a\u0004\bK\u00104R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bL\u0010.\u001a\u0004\bM\u00104R \u0010&\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u00101\u0012\u0004\bN\u0010.\u001a\u0004\b&\u00100R$\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bO\u0010.\u001a\u0004\bP\u0010QR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bR\u0010.\u001a\u0004\bS\u00104R$\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bT\u0010.\u001a\u0004\bU\u0010QR \u0010\"\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010G\u0012\u0004\bV\u0010.\u001a\u0004\bW\u0010FR \u0010#\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010G\u0012\u0004\bX\u0010.\u001a\u0004\bY\u0010FR \u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010G\u0012\u0004\bZ\u0010.\u001a\u0004\b[\u0010FR \u0010\r\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u00101\u0012\u0004\b\\\u0010.\u001a\u0004\b]\u00100R\u001e\u0010\u001e\u001a\u0004\u0018\u00010\u001f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b^\u0010.\u001a\u0004\b_\u0010`R\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\ba\u0010.\u001a\u0004\bb\u00104R\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bc\u0010.\u001a\u0004\bd\u00104R0\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0014\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\be\u0010.\u001a\u0004\bf\u0010gR\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u001b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bh\u0010.\u001a\u0004\bi\u0010jR\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bk\u0010.\u001a\u0004\bl\u00104R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bm\u0010.\u001a\u0004\bn\u00104R\u001e\u0010'\u001a\u0004\u0018\u00010(8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bo\u0010.\u001a\u0004\bp\u0010q¨\u0006\u009e\u0001"}, d2 = {"Lcom/vungle/ads/internal/model/AdPayload$AdUnit;", "", "seen1", "", "id", "", "adType", "adSource", "expiry", "deeplinkUrl", "clickCoordinatesEnabled", "", "adLoadOptimizationEnabled", "templateHeartbeatCheck", "mediationName", "info", "sleep", IronSourceConstants.EVENTS_ERROR_CODE, "tpat", "", "", AdPayload.KEY_VM, "vmVersion", "adMarketId", "notification", "loadAdUrls", "viewAbility", "Lcom/vungle/ads/internal/model/AdPayload$ViewAbility;", "templateURL", "templateType", "templateSettings", "Lcom/vungle/ads/internal/model/AdPayload$TemplateSettings;", "creativeId", "advAppId", "showClose", "showCloseIncentivized", "adSizeInfo", "Lcom/vungle/ads/internal/model/AdPayload$AdSizeInfo;", "isCacheableAssetsRequired", "webViewSettings", "Lcom/vungle/ads/internal/model/AdPayload$WebViewSettings;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Lcom/vungle/ads/internal/model/AdPayload$ViewAbility;Ljava/lang/String;Ljava/lang/String;Lcom/vungle/ads/internal/model/AdPayload$TemplateSettings;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/vungle/ads/internal/model/AdPayload$AdSizeInfo;Ljava/lang/Boolean;Lcom/vungle/ads/internal/model/AdPayload$WebViewSettings;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Lcom/vungle/ads/internal/model/AdPayload$ViewAbility;Ljava/lang/String;Ljava/lang/String;Lcom/vungle/ads/internal/model/AdPayload$TemplateSettings;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/vungle/ads/internal/model/AdPayload$AdSizeInfo;Ljava/lang/Boolean;Lcom/vungle/ads/internal/model/AdPayload$WebViewSettings;)V", "getAdLoadOptimizationEnabled$annotations", "()V", "getAdLoadOptimizationEnabled", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getAdMarketId$annotations", "getAdMarketId", "()Ljava/lang/String;", "getAdSizeInfo$annotations", "getAdSizeInfo", "()Lcom/vungle/ads/internal/model/AdPayload$AdSizeInfo;", "getAdSource$annotations", "getAdSource", "getAdType$annotations", "getAdType", "getAdvAppId$annotations", "getAdvAppId", "getClickCoordinatesEnabled$annotations", "getClickCoordinatesEnabled", "getCreativeId$annotations", "getCreativeId", "getDeeplinkUrl$annotations", "getDeeplinkUrl", "getErrorCode$annotations", "getErrorCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getExpiry$annotations", "getExpiry", "getId$annotations", "getId", "getInfo$annotations", "getInfo", "isCacheableAssetsRequired$annotations", "getLoadAdUrls$annotations", "getLoadAdUrls", "()Ljava/util/List;", "getMediationName$annotations", "getMediationName", "getNotification$annotations", "getNotification", "getShowClose$annotations", "getShowClose", "getShowCloseIncentivized$annotations", "getShowCloseIncentivized", "getSleep$annotations", "getSleep", "getTemplateHeartbeatCheck$annotations", "getTemplateHeartbeatCheck", "getTemplateSettings$annotations", "getTemplateSettings", "()Lcom/vungle/ads/internal/model/AdPayload$TemplateSettings;", "getTemplateType$annotations", "getTemplateType", "getTemplateURL$annotations", "getTemplateURL", "getTpat$annotations", "getTpat", "()Ljava/util/Map;", "getViewAbility$annotations", "getViewAbility", "()Lcom/vungle/ads/internal/model/AdPayload$ViewAbility;", "getVmURL$annotations", "getVmURL", "getVmVersion$annotations", "getVmVersion", "getWebViewSettings$annotations", "getWebViewSettings", "()Lcom/vungle/ads/internal/model/AdPayload$WebViewSettings;", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Lcom/vungle/ads/internal/model/AdPayload$ViewAbility;Ljava/lang/String;Ljava/lang/String;Lcom/vungle/ads/internal/model/AdPayload$TemplateSettings;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/vungle/ads/internal/model/AdPayload$AdSizeInfo;Ljava/lang/Boolean;Lcom/vungle/ads/internal/model/AdPayload$WebViewSettings;)Lcom/vungle/ads/internal/model/AdPayload$AdUnit;", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @Serializable
    public static final /* data */ class AdUnit {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Boolean adLoadOptimizationEnabled;
        private final String adMarketId;
        private final AdSizeInfo adSizeInfo;
        private final String adSource;
        private final String adType;
        private final String advAppId;
        private final Boolean clickCoordinatesEnabled;
        private final String creativeId;
        private final String deeplinkUrl;
        private final Integer errorCode;
        private final Integer expiry;
        private final String id;
        private final String info;
        private final Boolean isCacheableAssetsRequired;
        private final List<String> loadAdUrls;
        private final String mediationName;
        private final List<String> notification;
        private final Integer showClose;
        private final Integer showCloseIncentivized;
        private final Integer sleep;
        private final Boolean templateHeartbeatCheck;
        private final TemplateSettings templateSettings;
        private final String templateType;
        private final String templateURL;
        private final Map<String, List<String>> tpat;
        private final ViewAbility viewAbility;
        private final String vmURL;
        private final String vmVersion;
        private final WebViewSettings webViewSettings;

        public AdUnit() {
            this((String) null, (String) null, (String) null, (Integer) null, (String) null, (Boolean) null, (Boolean) null, (Boolean) null, (String) null, (String) null, (Integer) null, (Integer) null, (Map) null, (String) null, (String) null, (String) null, (List) null, (List) null, (ViewAbility) null, (String) null, (String) null, (TemplateSettings) null, (String) null, (String) null, (Integer) null, (Integer) null, (AdSizeInfo) null, (Boolean) null, (WebViewSettings) null, 536870911, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ AdUnit copy$default(AdUnit adUnit, String str, String str2, String str3, Integer num, String str4, Boolean bool, Boolean bool2, Boolean bool3, String str5, String str6, Integer num2, Integer num3, Map map, String str7, String str8, String str9, List list, List list2, ViewAbility viewAbility, String str10, String str11, TemplateSettings templateSettings, String str12, String str13, Integer num4, Integer num5, AdSizeInfo adSizeInfo, Boolean bool4, WebViewSettings webViewSettings, int i, Object obj) {
            WebViewSettings webViewSettings2;
            Boolean bool5;
            String str14 = (i & 1) != 0 ? adUnit.id : str;
            String str15 = (i & 2) != 0 ? adUnit.adType : str2;
            String str16 = (i & 4) != 0 ? adUnit.adSource : str3;
            Integer num6 = (i & 8) != 0 ? adUnit.expiry : num;
            String str17 = (i & 16) != 0 ? adUnit.deeplinkUrl : str4;
            Boolean bool6 = (i & 32) != 0 ? adUnit.clickCoordinatesEnabled : bool;
            Boolean bool7 = (i & 64) != 0 ? adUnit.adLoadOptimizationEnabled : bool2;
            Boolean bool8 = (i & 128) != 0 ? adUnit.templateHeartbeatCheck : bool3;
            String str18 = (i & 256) != 0 ? adUnit.mediationName : str5;
            String str19 = (i & 512) != 0 ? adUnit.info : str6;
            Integer num7 = (i & 1024) != 0 ? adUnit.sleep : num2;
            Integer num8 = (i & 2048) != 0 ? adUnit.errorCode : num3;
            Map map2 = (i & 4096) != 0 ? adUnit.tpat : map;
            String str20 = (i & 8192) != 0 ? adUnit.vmURL : str7;
            String str21 = str14;
            String str22 = (i & 16384) != 0 ? adUnit.vmVersion : str8;
            String str23 = (i & 32768) != 0 ? adUnit.adMarketId : str9;
            List list3 = (i & 65536) != 0 ? adUnit.notification : list;
            List list4 = (i & 131072) != 0 ? adUnit.loadAdUrls : list2;
            ViewAbility viewAbility2 = (i & 262144) != 0 ? adUnit.viewAbility : viewAbility;
            String str24 = (i & 524288) != 0 ? adUnit.templateURL : str10;
            String str25 = (i & 1048576) != 0 ? adUnit.templateType : str11;
            TemplateSettings templateSettings2 = (i & 2097152) != 0 ? adUnit.templateSettings : templateSettings;
            String str26 = (i & 4194304) != 0 ? adUnit.creativeId : str12;
            String str27 = (i & 8388608) != 0 ? adUnit.advAppId : str13;
            Integer num9 = (i & 16777216) != 0 ? adUnit.showClose : num4;
            Integer num10 = (i & 33554432) != 0 ? adUnit.showCloseIncentivized : num5;
            AdSizeInfo adSizeInfo2 = (i & 67108864) != 0 ? adUnit.adSizeInfo : adSizeInfo;
            Boolean bool9 = (i & 134217728) != 0 ? adUnit.isCacheableAssetsRequired : bool4;
            if ((i & 268435456) != 0) {
                bool5 = bool9;
                webViewSettings2 = adUnit.webViewSettings;
            } else {
                webViewSettings2 = webViewSettings;
                bool5 = bool9;
            }
            return adUnit.copy(str21, str15, str16, num6, str17, bool6, bool7, bool8, str18, str19, num7, num8, map2, str20, str22, str23, list3, list4, viewAbility2, str24, str25, templateSettings2, str26, str27, num9, num10, adSizeInfo2, bool5, webViewSettings2);
        }

        @SerialName("ad_load_optimization")
        public static /* synthetic */ void getAdLoadOptimizationEnabled$annotations() {
        }

        @SerialName("ad_market_id")
        public static /* synthetic */ void getAdMarketId$annotations() {
        }

        @SerialName("ad_size")
        public static /* synthetic */ void getAdSizeInfo$annotations() {
        }

        @SerialName(FirebaseAnalytics.Param.AD_SOURCE)
        public static /* synthetic */ void getAdSource$annotations() {
        }

        @SerialName("ad_type")
        public static /* synthetic */ void getAdType$annotations() {
        }

        @SerialName(MBridgeConstans.APP_ID)
        public static /* synthetic */ void getAdvAppId$annotations() {
        }

        @SerialName("click_coordinates_enabled")
        public static /* synthetic */ void getClickCoordinatesEnabled$annotations() {
        }

        @SerialName(CampaignEx.JSON_KEY_CREATIVE_ID)
        public static /* synthetic */ void getCreativeId$annotations() {
        }

        @SerialName("deeplink_url")
        public static /* synthetic */ void getDeeplinkUrl$annotations() {
        }

        @SerialName(AndroidBridgeConstants.ERROR_CODE)
        public static /* synthetic */ void getErrorCode$annotations() {
        }

        @SerialName("expiry")
        public static /* synthetic */ void getExpiry$annotations() {
        }

        @SerialName("id")
        public static /* synthetic */ void getId$annotations() {
        }

        @SerialName("info")
        public static /* synthetic */ void getInfo$annotations() {
        }

        @SerialName(Constants.LOAD_AD)
        public static /* synthetic */ void getLoadAdUrls$annotations() {
        }

        @SerialName("mediation_name")
        public static /* synthetic */ void getMediationName$annotations() {
        }

        @SerialName("notification")
        public static /* synthetic */ void getNotification$annotations() {
        }

        @SerialName("show_close")
        public static /* synthetic */ void getShowClose$annotations() {
        }

        @SerialName("show_close_incentivized")
        public static /* synthetic */ void getShowCloseIncentivized$annotations() {
        }

        @SerialName("sleep")
        public static /* synthetic */ void getSleep$annotations() {
        }

        @SerialName("template_heartbeat_check")
        public static /* synthetic */ void getTemplateHeartbeatCheck$annotations() {
        }

        @SerialName("template_settings")
        public static /* synthetic */ void getTemplateSettings$annotations() {
        }

        @SerialName("template_type")
        public static /* synthetic */ void getTemplateType$annotations() {
        }

        @SerialName("template_url")
        public static /* synthetic */ void getTemplateURL$annotations() {
        }

        @Serializable(with = TpatSerializer.class)
        public static /* synthetic */ void getTpat$annotations() {
        }

        @SerialName("viewability")
        public static /* synthetic */ void getViewAbility$annotations() {
        }

        @SerialName("vm_url")
        public static /* synthetic */ void getVmURL$annotations() {
        }

        @SerialName("vm_version")
        public static /* synthetic */ void getVmVersion$annotations() {
        }

        @SerialName("webview_settings")
        public static /* synthetic */ void getWebViewSettings$annotations() {
        }

        @SerialName("cacheable_assets_required")
        public static /* synthetic */ void isCacheableAssetsRequired$annotations() {
        }

        /* renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* renamed from: component10, reason: from getter */
        public final String getInfo() {
            return this.info;
        }

        /* renamed from: component11, reason: from getter */
        public final Integer getSleep() {
            return this.sleep;
        }

        /* renamed from: component12, reason: from getter */
        public final Integer getErrorCode() {
            return this.errorCode;
        }

        public final Map<String, List<String>> component13() {
            return this.tpat;
        }

        /* renamed from: component14, reason: from getter */
        public final String getVmURL() {
            return this.vmURL;
        }

        /* renamed from: component15, reason: from getter */
        public final String getVmVersion() {
            return this.vmVersion;
        }

        /* renamed from: component16, reason: from getter */
        public final String getAdMarketId() {
            return this.adMarketId;
        }

        public final List<String> component17() {
            return this.notification;
        }

        public final List<String> component18() {
            return this.loadAdUrls;
        }

        /* renamed from: component19, reason: from getter */
        public final ViewAbility getViewAbility() {
            return this.viewAbility;
        }

        /* renamed from: component2, reason: from getter */
        public final String getAdType() {
            return this.adType;
        }

        /* renamed from: component20, reason: from getter */
        public final String getTemplateURL() {
            return this.templateURL;
        }

        /* renamed from: component21, reason: from getter */
        public final String getTemplateType() {
            return this.templateType;
        }

        /* renamed from: component22, reason: from getter */
        public final TemplateSettings getTemplateSettings() {
            return this.templateSettings;
        }

        /* renamed from: component23, reason: from getter */
        public final String getCreativeId() {
            return this.creativeId;
        }

        /* renamed from: component24, reason: from getter */
        public final String getAdvAppId() {
            return this.advAppId;
        }

        /* renamed from: component25, reason: from getter */
        public final Integer getShowClose() {
            return this.showClose;
        }

        /* renamed from: component26, reason: from getter */
        public final Integer getShowCloseIncentivized() {
            return this.showCloseIncentivized;
        }

        /* renamed from: component27, reason: from getter */
        public final AdSizeInfo getAdSizeInfo() {
            return this.adSizeInfo;
        }

        /* renamed from: component28, reason: from getter */
        public final Boolean getIsCacheableAssetsRequired() {
            return this.isCacheableAssetsRequired;
        }

        /* renamed from: component29, reason: from getter */
        public final WebViewSettings getWebViewSettings() {
            return this.webViewSettings;
        }

        /* renamed from: component3, reason: from getter */
        public final String getAdSource() {
            return this.adSource;
        }

        /* renamed from: component4, reason: from getter */
        public final Integer getExpiry() {
            return this.expiry;
        }

        /* renamed from: component5, reason: from getter */
        public final String getDeeplinkUrl() {
            return this.deeplinkUrl;
        }

        /* renamed from: component6, reason: from getter */
        public final Boolean getClickCoordinatesEnabled() {
            return this.clickCoordinatesEnabled;
        }

        /* renamed from: component7, reason: from getter */
        public final Boolean getAdLoadOptimizationEnabled() {
            return this.adLoadOptimizationEnabled;
        }

        /* renamed from: component8, reason: from getter */
        public final Boolean getTemplateHeartbeatCheck() {
            return this.templateHeartbeatCheck;
        }

        /* renamed from: component9, reason: from getter */
        public final String getMediationName() {
            return this.mediationName;
        }

        public final AdUnit copy(String id, String adType, String adSource, Integer expiry, String deeplinkUrl, Boolean clickCoordinatesEnabled, Boolean adLoadOptimizationEnabled, Boolean templateHeartbeatCheck, String mediationName, String info, Integer sleep, Integer errorCode, Map<String, ? extends List<String>> tpat, String vmURL, String vmVersion, String adMarketId, List<String> notification, List<String> loadAdUrls, ViewAbility viewAbility, String templateURL, String templateType, TemplateSettings templateSettings, String creativeId, String advAppId, Integer showClose, Integer showCloseIncentivized, AdSizeInfo adSizeInfo, Boolean isCacheableAssetsRequired, WebViewSettings webViewSettings) {
            return new AdUnit(id, adType, adSource, expiry, deeplinkUrl, clickCoordinatesEnabled, adLoadOptimizationEnabled, templateHeartbeatCheck, mediationName, info, sleep, errorCode, tpat, vmURL, vmVersion, adMarketId, notification, loadAdUrls, viewAbility, templateURL, templateType, templateSettings, creativeId, advAppId, showClose, showCloseIncentivized, adSizeInfo, isCacheableAssetsRequired, webViewSettings);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AdUnit)) {
                return false;
            }
            AdUnit adUnit = (AdUnit) other;
            return Intrinsics.areEqual(this.id, adUnit.id) && Intrinsics.areEqual(this.adType, adUnit.adType) && Intrinsics.areEqual(this.adSource, adUnit.adSource) && Intrinsics.areEqual(this.expiry, adUnit.expiry) && Intrinsics.areEqual(this.deeplinkUrl, adUnit.deeplinkUrl) && Intrinsics.areEqual(this.clickCoordinatesEnabled, adUnit.clickCoordinatesEnabled) && Intrinsics.areEqual(this.adLoadOptimizationEnabled, adUnit.adLoadOptimizationEnabled) && Intrinsics.areEqual(this.templateHeartbeatCheck, adUnit.templateHeartbeatCheck) && Intrinsics.areEqual(this.mediationName, adUnit.mediationName) && Intrinsics.areEqual(this.info, adUnit.info) && Intrinsics.areEqual(this.sleep, adUnit.sleep) && Intrinsics.areEqual(this.errorCode, adUnit.errorCode) && Intrinsics.areEqual(this.tpat, adUnit.tpat) && Intrinsics.areEqual(this.vmURL, adUnit.vmURL) && Intrinsics.areEqual(this.vmVersion, adUnit.vmVersion) && Intrinsics.areEqual(this.adMarketId, adUnit.adMarketId) && Intrinsics.areEqual(this.notification, adUnit.notification) && Intrinsics.areEqual(this.loadAdUrls, adUnit.loadAdUrls) && Intrinsics.areEqual(this.viewAbility, adUnit.viewAbility) && Intrinsics.areEqual(this.templateURL, adUnit.templateURL) && Intrinsics.areEqual(this.templateType, adUnit.templateType) && Intrinsics.areEqual(this.templateSettings, adUnit.templateSettings) && Intrinsics.areEqual(this.creativeId, adUnit.creativeId) && Intrinsics.areEqual(this.advAppId, adUnit.advAppId) && Intrinsics.areEqual(this.showClose, adUnit.showClose) && Intrinsics.areEqual(this.showCloseIncentivized, adUnit.showCloseIncentivized) && Intrinsics.areEqual(this.adSizeInfo, adUnit.adSizeInfo) && Intrinsics.areEqual(this.isCacheableAssetsRequired, adUnit.isCacheableAssetsRequired) && Intrinsics.areEqual(this.webViewSettings, adUnit.webViewSettings);
        }

        public int hashCode() {
            String str = this.id;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.adType;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.adSource;
            int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            Integer num = this.expiry;
            int hashCode4 = (hashCode3 + (num == null ? 0 : num.hashCode())) * 31;
            String str4 = this.deeplinkUrl;
            int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
            Boolean bool = this.clickCoordinatesEnabled;
            int hashCode6 = (hashCode5 + (bool == null ? 0 : bool.hashCode())) * 31;
            Boolean bool2 = this.adLoadOptimizationEnabled;
            int hashCode7 = (hashCode6 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
            Boolean bool3 = this.templateHeartbeatCheck;
            int hashCode8 = (hashCode7 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
            String str5 = this.mediationName;
            int hashCode9 = (hashCode8 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.info;
            int hashCode10 = (hashCode9 + (str6 == null ? 0 : str6.hashCode())) * 31;
            Integer num2 = this.sleep;
            int hashCode11 = (hashCode10 + (num2 == null ? 0 : num2.hashCode())) * 31;
            Integer num3 = this.errorCode;
            int hashCode12 = (hashCode11 + (num3 == null ? 0 : num3.hashCode())) * 31;
            Map<String, List<String>> map = this.tpat;
            int hashCode13 = (hashCode12 + (map == null ? 0 : map.hashCode())) * 31;
            String str7 = this.vmURL;
            int hashCode14 = (hashCode13 + (str7 == null ? 0 : str7.hashCode())) * 31;
            String str8 = this.vmVersion;
            int hashCode15 = (hashCode14 + (str8 == null ? 0 : str8.hashCode())) * 31;
            String str9 = this.adMarketId;
            int hashCode16 = (hashCode15 + (str9 == null ? 0 : str9.hashCode())) * 31;
            List<String> list = this.notification;
            int hashCode17 = (hashCode16 + (list == null ? 0 : list.hashCode())) * 31;
            List<String> list2 = this.loadAdUrls;
            int hashCode18 = (hashCode17 + (list2 == null ? 0 : list2.hashCode())) * 31;
            ViewAbility viewAbility = this.viewAbility;
            int hashCode19 = (hashCode18 + (viewAbility == null ? 0 : viewAbility.hashCode())) * 31;
            String str10 = this.templateURL;
            int hashCode20 = (hashCode19 + (str10 == null ? 0 : str10.hashCode())) * 31;
            String str11 = this.templateType;
            int hashCode21 = (hashCode20 + (str11 == null ? 0 : str11.hashCode())) * 31;
            TemplateSettings templateSettings = this.templateSettings;
            int hashCode22 = (hashCode21 + (templateSettings == null ? 0 : templateSettings.hashCode())) * 31;
            String str12 = this.creativeId;
            int hashCode23 = (hashCode22 + (str12 == null ? 0 : str12.hashCode())) * 31;
            String str13 = this.advAppId;
            int hashCode24 = (hashCode23 + (str13 == null ? 0 : str13.hashCode())) * 31;
            Integer num4 = this.showClose;
            int hashCode25 = (hashCode24 + (num4 == null ? 0 : num4.hashCode())) * 31;
            Integer num5 = this.showCloseIncentivized;
            int hashCode26 = (hashCode25 + (num5 == null ? 0 : num5.hashCode())) * 31;
            AdSizeInfo adSizeInfo = this.adSizeInfo;
            int hashCode27 = (hashCode26 + (adSizeInfo == null ? 0 : adSizeInfo.hashCode())) * 31;
            Boolean bool4 = this.isCacheableAssetsRequired;
            int hashCode28 = (hashCode27 + (bool4 == null ? 0 : bool4.hashCode())) * 31;
            WebViewSettings webViewSettings = this.webViewSettings;
            return hashCode28 + (webViewSettings != null ? webViewSettings.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("AdUnit(id=");
            sb.append(this.id).append(", adType=").append(this.adType).append(", adSource=").append(this.adSource).append(", expiry=").append(this.expiry).append(", deeplinkUrl=").append(this.deeplinkUrl).append(", clickCoordinatesEnabled=").append(this.clickCoordinatesEnabled).append(", adLoadOptimizationEnabled=").append(this.adLoadOptimizationEnabled).append(", templateHeartbeatCheck=").append(this.templateHeartbeatCheck).append(", mediationName=").append(this.mediationName).append(", info=").append(this.info).append(", sleep=").append(this.sleep).append(", errorCode=");
            sb.append(this.errorCode).append(", tpat=").append(this.tpat).append(", vmURL=").append(this.vmURL).append(", vmVersion=").append(this.vmVersion).append(", adMarketId=").append(this.adMarketId).append(", notification=").append(this.notification).append(", loadAdUrls=").append(this.loadAdUrls).append(", viewAbility=").append(this.viewAbility).append(", templateURL=").append(this.templateURL).append(", templateType=").append(this.templateType).append(", templateSettings=").append(this.templateSettings).append(", creativeId=").append(this.creativeId);
            sb.append(", advAppId=").append(this.advAppId).append(", showClose=").append(this.showClose).append(", showCloseIncentivized=").append(this.showCloseIncentivized).append(", adSizeInfo=").append(this.adSizeInfo).append(", isCacheableAssetsRequired=").append(this.isCacheableAssetsRequired).append(", webViewSettings=").append(this.webViewSettings).append(')');
            return sb.toString();
        }

        /* compiled from: AdPayload.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/vungle/ads/internal/model/AdPayload$AdUnit$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/vungle/ads/internal/model/AdPayload$AdUnit;", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<AdUnit> serializer() {
                return AdPayload$AdUnit$$serializer.INSTANCE;
            }
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ AdUnit(int i, @SerialName("id") String str, @SerialName("ad_type") String str2, @SerialName("ad_source") String str3, @SerialName("expiry") Integer num, @SerialName("deeplink_url") String str4, @SerialName("click_coordinates_enabled") Boolean bool, @SerialName("ad_load_optimization") Boolean bool2, @SerialName("template_heartbeat_check") Boolean bool3, @SerialName("mediation_name") String str5, @SerialName("info") String str6, @SerialName("sleep") Integer num2, @SerialName("error_code") Integer num3, @Serializable(with = TpatSerializer.class) Map map, @SerialName("vm_url") String str7, @SerialName("vm_version") String str8, @SerialName("ad_market_id") String str9, @SerialName("notification") List list, @SerialName("load_ad") List list2, @SerialName("viewability") ViewAbility viewAbility, @SerialName("template_url") String str10, @SerialName("template_type") String str11, @SerialName("template_settings") TemplateSettings templateSettings, @SerialName("creative_id") String str12, @SerialName("app_id") String str13, @SerialName("show_close") Integer num4, @SerialName("show_close_incentivized") Integer num5, @SerialName("ad_size") AdSizeInfo adSizeInfo, @SerialName("cacheable_assets_required") Boolean bool4, @SerialName("webview_settings") WebViewSettings webViewSettings, SerializationConstructorMarker serializationConstructorMarker) {
            if ((i & 1) == 0) {
                this.id = null;
            } else {
                this.id = str;
            }
            if ((i & 2) == 0) {
                this.adType = null;
            } else {
                this.adType = str2;
            }
            if ((i & 4) == 0) {
                this.adSource = null;
            } else {
                this.adSource = str3;
            }
            if ((i & 8) == 0) {
                this.expiry = null;
            } else {
                this.expiry = num;
            }
            if ((i & 16) == 0) {
                this.deeplinkUrl = null;
            } else {
                this.deeplinkUrl = str4;
            }
            if ((i & 32) == 0) {
                this.clickCoordinatesEnabled = null;
            } else {
                this.clickCoordinatesEnabled = bool;
            }
            if ((i & 64) == 0) {
                this.adLoadOptimizationEnabled = null;
            } else {
                this.adLoadOptimizationEnabled = bool2;
            }
            if ((i & 128) == 0) {
                this.templateHeartbeatCheck = null;
            } else {
                this.templateHeartbeatCheck = bool3;
            }
            if ((i & 256) == 0) {
                this.mediationName = null;
            } else {
                this.mediationName = str5;
            }
            if ((i & 512) == 0) {
                this.info = null;
            } else {
                this.info = str6;
            }
            if ((i & 1024) == 0) {
                this.sleep = null;
            } else {
                this.sleep = num2;
            }
            if ((i & 2048) == 0) {
                this.errorCode = null;
            } else {
                this.errorCode = num3;
            }
            if ((i & 4096) == 0) {
                this.tpat = null;
            } else {
                this.tpat = map;
            }
            if ((i & 8192) == 0) {
                this.vmURL = null;
            } else {
                this.vmURL = str7;
            }
            if ((i & 16384) == 0) {
                this.vmVersion = null;
            } else {
                this.vmVersion = str8;
            }
            if ((32768 & i) == 0) {
                this.adMarketId = null;
            } else {
                this.adMarketId = str9;
            }
            if ((65536 & i) == 0) {
                this.notification = null;
            } else {
                this.notification = list;
            }
            if ((131072 & i) == 0) {
                this.loadAdUrls = null;
            } else {
                this.loadAdUrls = list2;
            }
            if ((262144 & i) == 0) {
                this.viewAbility = null;
            } else {
                this.viewAbility = viewAbility;
            }
            if ((524288 & i) == 0) {
                this.templateURL = null;
            } else {
                this.templateURL = str10;
            }
            if ((1048576 & i) == 0) {
                this.templateType = null;
            } else {
                this.templateType = str11;
            }
            if ((2097152 & i) == 0) {
                this.templateSettings = null;
            } else {
                this.templateSettings = templateSettings;
            }
            if ((4194304 & i) == 0) {
                this.creativeId = null;
            } else {
                this.creativeId = str12;
            }
            if ((8388608 & i) == 0) {
                this.advAppId = null;
            } else {
                this.advAppId = str13;
            }
            this.showClose = (16777216 & i) == 0 ? 0 : num4;
            this.showCloseIncentivized = (33554432 & i) == 0 ? 0 : num5;
            if ((67108864 & i) == 0) {
                this.adSizeInfo = null;
            } else {
                this.adSizeInfo = adSizeInfo;
            }
            if ((134217728 & i) == 0) {
                this.isCacheableAssetsRequired = null;
            } else {
                this.isCacheableAssetsRequired = bool4;
            }
            if ((i & 268435456) == 0) {
                this.webViewSettings = null;
            } else {
                this.webViewSettings = webViewSettings;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public AdUnit(String str, String str2, String str3, Integer num, String str4, Boolean bool, Boolean bool2, Boolean bool3, String str5, String str6, Integer num2, Integer num3, Map<String, ? extends List<String>> map, String str7, String str8, String str9, List<String> list, List<String> list2, ViewAbility viewAbility, String str10, String str11, TemplateSettings templateSettings, String str12, String str13, Integer num4, Integer num5, AdSizeInfo adSizeInfo, Boolean bool4, WebViewSettings webViewSettings) {
            this.id = str;
            this.adType = str2;
            this.adSource = str3;
            this.expiry = num;
            this.deeplinkUrl = str4;
            this.clickCoordinatesEnabled = bool;
            this.adLoadOptimizationEnabled = bool2;
            this.templateHeartbeatCheck = bool3;
            this.mediationName = str5;
            this.info = str6;
            this.sleep = num2;
            this.errorCode = num3;
            this.tpat = map;
            this.vmURL = str7;
            this.vmVersion = str8;
            this.adMarketId = str9;
            this.notification = list;
            this.loadAdUrls = list2;
            this.viewAbility = viewAbility;
            this.templateURL = str10;
            this.templateType = str11;
            this.templateSettings = templateSettings;
            this.creativeId = str12;
            this.advAppId = str13;
            this.showClose = num4;
            this.showCloseIncentivized = num5;
            this.adSizeInfo = adSizeInfo;
            this.isCacheableAssetsRequired = bool4;
            this.webViewSettings = webViewSettings;
        }

        @JvmStatic
        public static final void write$Self(AdUnit self, CompositeEncoder output, SerialDescriptor serialDesc) {
            Integer num;
            Integer num2;
            Intrinsics.checkNotNullParameter(self, "self");
            Intrinsics.checkNotNullParameter(output, "output");
            Intrinsics.checkNotNullParameter(serialDesc, "serialDesc");
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.id != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.id);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.adType != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.adType);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.adSource != null) {
                output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.adSource);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 3) || self.expiry != null) {
                output.encodeNullableSerializableElement(serialDesc, 3, IntSerializer.INSTANCE, self.expiry);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 4) || self.deeplinkUrl != null) {
                output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.deeplinkUrl);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 5) || self.clickCoordinatesEnabled != null) {
                output.encodeNullableSerializableElement(serialDesc, 5, BooleanSerializer.INSTANCE, self.clickCoordinatesEnabled);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 6) || self.adLoadOptimizationEnabled != null) {
                output.encodeNullableSerializableElement(serialDesc, 6, BooleanSerializer.INSTANCE, self.adLoadOptimizationEnabled);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 7) || self.templateHeartbeatCheck != null) {
                output.encodeNullableSerializableElement(serialDesc, 7, BooleanSerializer.INSTANCE, self.templateHeartbeatCheck);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 8) || self.mediationName != null) {
                output.encodeNullableSerializableElement(serialDesc, 8, StringSerializer.INSTANCE, self.mediationName);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 9) || self.info != null) {
                output.encodeNullableSerializableElement(serialDesc, 9, StringSerializer.INSTANCE, self.info);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 10) || self.sleep != null) {
                output.encodeNullableSerializableElement(serialDesc, 10, IntSerializer.INSTANCE, self.sleep);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 11) || self.errorCode != null) {
                output.encodeNullableSerializableElement(serialDesc, 11, IntSerializer.INSTANCE, self.errorCode);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 12) || self.tpat != null) {
                output.encodeNullableSerializableElement(serialDesc, 12, TpatSerializer.INSTANCE, self.tpat);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 13) || self.vmURL != null) {
                output.encodeNullableSerializableElement(serialDesc, 13, StringSerializer.INSTANCE, self.vmURL);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 14) || self.vmVersion != null) {
                output.encodeNullableSerializableElement(serialDesc, 14, StringSerializer.INSTANCE, self.vmVersion);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 15) || self.adMarketId != null) {
                output.encodeNullableSerializableElement(serialDesc, 15, StringSerializer.INSTANCE, self.adMarketId);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 16) || self.notification != null) {
                output.encodeNullableSerializableElement(serialDesc, 16, new ArrayListSerializer(StringSerializer.INSTANCE), self.notification);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 17) || self.loadAdUrls != null) {
                output.encodeNullableSerializableElement(serialDesc, 17, new ArrayListSerializer(StringSerializer.INSTANCE), self.loadAdUrls);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 18) || self.viewAbility != null) {
                output.encodeNullableSerializableElement(serialDesc, 18, AdPayload$ViewAbility$$serializer.INSTANCE, self.viewAbility);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 19) || self.templateURL != null) {
                output.encodeNullableSerializableElement(serialDesc, 19, StringSerializer.INSTANCE, self.templateURL);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 20) || self.templateType != null) {
                output.encodeNullableSerializableElement(serialDesc, 20, StringSerializer.INSTANCE, self.templateType);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 21) || self.templateSettings != null) {
                output.encodeNullableSerializableElement(serialDesc, 21, AdPayload$TemplateSettings$$serializer.INSTANCE, self.templateSettings);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 22) || self.creativeId != null) {
                output.encodeNullableSerializableElement(serialDesc, 22, StringSerializer.INSTANCE, self.creativeId);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 23) || self.advAppId != null) {
                output.encodeNullableSerializableElement(serialDesc, 23, StringSerializer.INSTANCE, self.advAppId);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 24) || (num2 = self.showClose) == null || num2.intValue() != 0) {
                output.encodeNullableSerializableElement(serialDesc, 24, IntSerializer.INSTANCE, self.showClose);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 25) || (num = self.showCloseIncentivized) == null || num.intValue() != 0) {
                output.encodeNullableSerializableElement(serialDesc, 25, IntSerializer.INSTANCE, self.showCloseIncentivized);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 26) || self.adSizeInfo != null) {
                output.encodeNullableSerializableElement(serialDesc, 26, AdPayload$AdSizeInfo$$serializer.INSTANCE, self.adSizeInfo);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 27) || self.isCacheableAssetsRequired != null) {
                output.encodeNullableSerializableElement(serialDesc, 27, BooleanSerializer.INSTANCE, self.isCacheableAssetsRequired);
            }
            if (!output.shouldEncodeElementDefault(serialDesc, 28) && self.webViewSettings == null) {
                return;
            }
            output.encodeNullableSerializableElement(serialDesc, 28, AdPayload$WebViewSettings$$serializer.INSTANCE, self.webViewSettings);
        }

        public final String getId() {
            return this.id;
        }

        public final String getAdType() {
            return this.adType;
        }

        public final String getAdSource() {
            return this.adSource;
        }

        public final Integer getExpiry() {
            return this.expiry;
        }

        public final String getDeeplinkUrl() {
            return this.deeplinkUrl;
        }

        public final Boolean getClickCoordinatesEnabled() {
            return this.clickCoordinatesEnabled;
        }

        public final Boolean getAdLoadOptimizationEnabled() {
            return this.adLoadOptimizationEnabled;
        }

        public final Boolean getTemplateHeartbeatCheck() {
            return this.templateHeartbeatCheck;
        }

        public final String getMediationName() {
            return this.mediationName;
        }

        public final String getInfo() {
            return this.info;
        }

        public final Integer getSleep() {
            return this.sleep;
        }

        public final Integer getErrorCode() {
            return this.errorCode;
        }

        public final Map<String, List<String>> getTpat() {
            return this.tpat;
        }

        public final String getVmURL() {
            return this.vmURL;
        }

        public final String getVmVersion() {
            return this.vmVersion;
        }

        public final String getAdMarketId() {
            return this.adMarketId;
        }

        public final List<String> getNotification() {
            return this.notification;
        }

        public final List<String> getLoadAdUrls() {
            return this.loadAdUrls;
        }

        public final ViewAbility getViewAbility() {
            return this.viewAbility;
        }

        public final String getTemplateURL() {
            return this.templateURL;
        }

        public final String getTemplateType() {
            return this.templateType;
        }

        public final TemplateSettings getTemplateSettings() {
            return this.templateSettings;
        }

        public final String getCreativeId() {
            return this.creativeId;
        }

        public final String getAdvAppId() {
            return this.advAppId;
        }

        public /* synthetic */ AdUnit(String str, String str2, String str3, Integer num, String str4, Boolean bool, Boolean bool2, Boolean bool3, String str5, String str6, Integer num2, Integer num3, Map map, String str7, String str8, String str9, List list, List list2, ViewAbility viewAbility, String str10, String str11, TemplateSettings templateSettings, String str12, String str13, Integer num4, Integer num5, AdSizeInfo adSizeInfo, Boolean bool4, WebViewSettings webViewSettings, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : num, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : bool, (i & 64) != 0 ? null : bool2, (i & 128) != 0 ? null : bool3, (i & 256) != 0 ? null : str5, (i & 512) != 0 ? null : str6, (i & 1024) != 0 ? null : num2, (i & 2048) != 0 ? null : num3, (i & 4096) != 0 ? null : map, (i & 8192) != 0 ? null : str7, (i & 16384) != 0 ? null : str8, (i & 32768) != 0 ? null : str9, (i & 65536) != 0 ? null : list, (i & 131072) != 0 ? null : list2, (i & 262144) != 0 ? null : viewAbility, (i & 524288) != 0 ? null : str10, (i & 1048576) != 0 ? null : str11, (i & 2097152) != 0 ? null : templateSettings, (i & 4194304) != 0 ? null : str12, (i & 8388608) != 0 ? null : str13, (i & 16777216) != 0 ? 0 : num4, (i & 33554432) != 0 ? 0 : num5, (i & 67108864) != 0 ? null : adSizeInfo, (i & 134217728) != 0 ? null : bool4, (i & 268435456) != 0 ? null : webViewSettings);
        }

        public final Integer getShowClose() {
            return this.showClose;
        }

        public final Integer getShowCloseIncentivized() {
            return this.showCloseIncentivized;
        }

        public final AdSizeInfo getAdSizeInfo() {
            return this.adSizeInfo;
        }

        public final Boolean isCacheableAssetsRequired() {
            return this.isCacheableAssetsRequired;
        }

        public final WebViewSettings getWebViewSettings() {
            return this.webViewSettings;
        }
    }

    /* compiled from: AdPayload.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00040\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0014¨\u0006\t"}, d2 = {"Lcom/vungle/ads/internal/model/AdPayload$TpatSerializer;", "Lkotlinx/serialization/json/JsonTransformingSerializer;", "", "", "", "()V", "transformDeserialize", "Lkotlinx/serialization/json/JsonElement;", "element", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class TpatSerializer extends JsonTransformingSerializer<Map<String, ? extends List<? extends String>>> {
        public static final TpatSerializer INSTANCE = new TpatSerializer();

        private TpatSerializer() {
            super(BuiltinSerializersKt.MapSerializer(BuiltinSerializersKt.serializer(StringCompanionObject.INSTANCE), BuiltinSerializersKt.ListSerializer(BuiltinSerializersKt.serializer(StringCompanionObject.INSTANCE))));
        }

        @Override // kotlinx.serialization.json.JsonTransformingSerializer
        protected JsonElement transformDeserialize(JsonElement element) {
            Intrinsics.checkNotNullParameter(element, "element");
            JsonObject jsonObject = JsonElementKt.getJsonObject(element);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
                if (!Intrinsics.areEqual(entry.getKey(), "moat")) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            return new JsonObject(linkedHashMap);
        }
    }

    /* compiled from: AdPayload.kt */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 #2\u00020\u0001:\u0002\"#BI\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\b\u0001\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0016\b\u0001\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bB5\u0012\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005¢\u0006\u0002\u0010\fJ\u0017\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u0017\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005HÆ\u0003J9\u0010\u0015\u001a\u00020\u00002\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0006HÖ\u0001J!\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!HÇ\u0001R*\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R*\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010¨\u0006$"}, d2 = {"Lcom/vungle/ads/internal/model/AdPayload$TemplateSettings;", "", "seen1", "", "normalReplacements", "", "", "cacheableReplacements", "Lcom/vungle/ads/internal/model/AdPayload$CacheableReplacement;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/Map;Ljava/util/Map;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/util/Map;Ljava/util/Map;)V", "getCacheableReplacements$annotations", "()V", "getCacheableReplacements", "()Ljava/util/Map;", "getNormalReplacements$annotations", "getNormalReplacements", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @Serializable
    public static final /* data */ class TemplateSettings {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Map<String, CacheableReplacement> cacheableReplacements;
        private final Map<String, String> normalReplacements;

        /* JADX WARN: Multi-variable type inference failed */
        public TemplateSettings() {
            this((Map) null, (Map) (0 == true ? 1 : 0), 3, (DefaultConstructorMarker) (0 == true ? 1 : 0));
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ TemplateSettings copy$default(TemplateSettings templateSettings, Map map, Map map2, int i, Object obj) {
            if ((i & 1) != 0) {
                map = templateSettings.normalReplacements;
            }
            if ((i & 2) != 0) {
                map2 = templateSettings.cacheableReplacements;
            }
            return templateSettings.copy(map, map2);
        }

        @SerialName("cacheable_replacements")
        public static /* synthetic */ void getCacheableReplacements$annotations() {
        }

        @SerialName("normal_replacements")
        public static /* synthetic */ void getNormalReplacements$annotations() {
        }

        public final Map<String, String> component1() {
            return this.normalReplacements;
        }

        public final Map<String, CacheableReplacement> component2() {
            return this.cacheableReplacements;
        }

        public final TemplateSettings copy(Map<String, String> normalReplacements, Map<String, CacheableReplacement> cacheableReplacements) {
            return new TemplateSettings(normalReplacements, cacheableReplacements);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TemplateSettings)) {
                return false;
            }
            TemplateSettings templateSettings = (TemplateSettings) other;
            return Intrinsics.areEqual(this.normalReplacements, templateSettings.normalReplacements) && Intrinsics.areEqual(this.cacheableReplacements, templateSettings.cacheableReplacements);
        }

        public int hashCode() {
            Map<String, String> map = this.normalReplacements;
            int hashCode = (map == null ? 0 : map.hashCode()) * 31;
            Map<String, CacheableReplacement> map2 = this.cacheableReplacements;
            return hashCode + (map2 != null ? map2.hashCode() : 0);
        }

        public String toString() {
            return "TemplateSettings(normalReplacements=" + this.normalReplacements + ", cacheableReplacements=" + this.cacheableReplacements + ')';
        }

        /* compiled from: AdPayload.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/vungle/ads/internal/model/AdPayload$TemplateSettings$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/vungle/ads/internal/model/AdPayload$TemplateSettings;", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<TemplateSettings> serializer() {
                return AdPayload$TemplateSettings$$serializer.INSTANCE;
            }
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ TemplateSettings(int i, @SerialName("normal_replacements") Map map, @SerialName("cacheable_replacements") Map map2, SerializationConstructorMarker serializationConstructorMarker) {
            if ((i & 1) == 0) {
                this.normalReplacements = null;
            } else {
                this.normalReplacements = map;
            }
            if ((i & 2) == 0) {
                this.cacheableReplacements = null;
            } else {
                this.cacheableReplacements = map2;
            }
        }

        public TemplateSettings(Map<String, String> map, Map<String, CacheableReplacement> map2) {
            this.normalReplacements = map;
            this.cacheableReplacements = map2;
        }

        @JvmStatic
        public static final void write$Self(TemplateSettings self, CompositeEncoder output, SerialDescriptor serialDesc) {
            Intrinsics.checkNotNullParameter(self, "self");
            Intrinsics.checkNotNullParameter(output, "output");
            Intrinsics.checkNotNullParameter(serialDesc, "serialDesc");
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.normalReplacements != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, new LinkedHashMapSerializer(StringSerializer.INSTANCE, StringSerializer.INSTANCE), self.normalReplacements);
            }
            if (!output.shouldEncodeElementDefault(serialDesc, 1) && self.cacheableReplacements == null) {
                return;
            }
            output.encodeNullableSerializableElement(serialDesc, 1, new LinkedHashMapSerializer(StringSerializer.INSTANCE, AdPayload$CacheableReplacement$$serializer.INSTANCE), self.cacheableReplacements);
        }

        public /* synthetic */ TemplateSettings(Map map, Map map2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : map, (i & 2) != 0 ? null : map2);
        }

        public final Map<String, String> getNormalReplacements() {
            return this.normalReplacements;
        }

        public final Map<String, CacheableReplacement> getCacheableReplacements() {
            return this.cacheableReplacements;
        }
    }

    /* compiled from: AdPayload.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 $2\u00020\u0001:\u0002#$B7\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bB)\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\fJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0010J2\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001J!\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"HÇ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000e¨\u0006%"}, d2 = {"Lcom/vungle/ads/internal/model/AdPayload$CacheableReplacement;", "", "seen1", "", "url", "", "extension", VastAttributes.REQUIRED, "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "getExtension", "()Ljava/lang/String;", "getRequired", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getUrl", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/vungle/ads/internal/model/AdPayload$CacheableReplacement;", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @Serializable
    public static final /* data */ class CacheableReplacement {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String extension;
        private final Boolean required;
        private final String url;

        public CacheableReplacement() {
            this((String) null, (String) null, (Boolean) null, 7, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ CacheableReplacement copy$default(CacheableReplacement cacheableReplacement, String str, String str2, Boolean bool, int i, Object obj) {
            if ((i & 1) != 0) {
                str = cacheableReplacement.url;
            }
            if ((i & 2) != 0) {
                str2 = cacheableReplacement.extension;
            }
            if ((i & 4) != 0) {
                bool = cacheableReplacement.required;
            }
            return cacheableReplacement.copy(str, str2, bool);
        }

        /* renamed from: component1, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        /* renamed from: component2, reason: from getter */
        public final String getExtension() {
            return this.extension;
        }

        /* renamed from: component3, reason: from getter */
        public final Boolean getRequired() {
            return this.required;
        }

        public final CacheableReplacement copy(String url, String extension, Boolean required) {
            return new CacheableReplacement(url, extension, required);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CacheableReplacement)) {
                return false;
            }
            CacheableReplacement cacheableReplacement = (CacheableReplacement) other;
            return Intrinsics.areEqual(this.url, cacheableReplacement.url) && Intrinsics.areEqual(this.extension, cacheableReplacement.extension) && Intrinsics.areEqual(this.required, cacheableReplacement.required);
        }

        public int hashCode() {
            String str = this.url;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.extension;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            Boolean bool = this.required;
            return hashCode2 + (bool != null ? bool.hashCode() : 0);
        }

        public String toString() {
            return "CacheableReplacement(url=" + this.url + ", extension=" + this.extension + ", required=" + this.required + ')';
        }

        /* compiled from: AdPayload.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/vungle/ads/internal/model/AdPayload$CacheableReplacement$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/vungle/ads/internal/model/AdPayload$CacheableReplacement;", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<CacheableReplacement> serializer() {
                return AdPayload$CacheableReplacement$$serializer.INSTANCE;
            }
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ CacheableReplacement(int i, String str, String str2, Boolean bool, SerializationConstructorMarker serializationConstructorMarker) {
            if ((i & 1) == 0) {
                this.url = null;
            } else {
                this.url = str;
            }
            if ((i & 2) == 0) {
                this.extension = null;
            } else {
                this.extension = str2;
            }
            if ((i & 4) == 0) {
                this.required = null;
            } else {
                this.required = bool;
            }
        }

        public CacheableReplacement(String str, String str2, Boolean bool) {
            this.url = str;
            this.extension = str2;
            this.required = bool;
        }

        @JvmStatic
        public static final void write$Self(CacheableReplacement self, CompositeEncoder output, SerialDescriptor serialDesc) {
            Intrinsics.checkNotNullParameter(self, "self");
            Intrinsics.checkNotNullParameter(output, "output");
            Intrinsics.checkNotNullParameter(serialDesc, "serialDesc");
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.url != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.url);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.extension != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.extension);
            }
            if (!output.shouldEncodeElementDefault(serialDesc, 2) && self.required == null) {
                return;
            }
            output.encodeNullableSerializableElement(serialDesc, 2, BooleanSerializer.INSTANCE, self.required);
        }

        public /* synthetic */ CacheableReplacement(String str, String str2, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : bool);
        }

        public final String getExtension() {
            return this.extension;
        }

        public final Boolean getRequired() {
            return this.required;
        }

        public final String getUrl() {
            return this.url;
        }
    }

    /* compiled from: AdPayload.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u001c2\u00020\u0001:\u0002\u001b\u001cB#\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB\u0011\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\tJ\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0015\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J!\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aHÇ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/vungle/ads/internal/model/AdPayload$ViewAbility;", "", "seen1", "", "om", "Lcom/vungle/ads/internal/model/AdPayload$ViewAbilityInfo;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/vungle/ads/internal/model/AdPayload$ViewAbilityInfo;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lcom/vungle/ads/internal/model/AdPayload$ViewAbilityInfo;)V", "getOm", "()Lcom/vungle/ads/internal/model/AdPayload$ViewAbilityInfo;", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @Serializable
    public static final /* data */ class ViewAbility {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final ViewAbilityInfo om;

        /* JADX WARN: Multi-variable type inference failed */
        public ViewAbility() {
            this((ViewAbilityInfo) null, 1, (DefaultConstructorMarker) (0 == true ? 1 : 0));
        }

        public static /* synthetic */ ViewAbility copy$default(ViewAbility viewAbility, ViewAbilityInfo viewAbilityInfo, int i, Object obj) {
            if ((i & 1) != 0) {
                viewAbilityInfo = viewAbility.om;
            }
            return viewAbility.copy(viewAbilityInfo);
        }

        /* renamed from: component1, reason: from getter */
        public final ViewAbilityInfo getOm() {
            return this.om;
        }

        public final ViewAbility copy(ViewAbilityInfo om) {
            return new ViewAbility(om);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ViewAbility) && Intrinsics.areEqual(this.om, ((ViewAbility) other).om);
        }

        public int hashCode() {
            ViewAbilityInfo viewAbilityInfo = this.om;
            if (viewAbilityInfo == null) {
                return 0;
            }
            return viewAbilityInfo.hashCode();
        }

        public String toString() {
            return "ViewAbility(om=" + this.om + ')';
        }

        /* compiled from: AdPayload.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/vungle/ads/internal/model/AdPayload$ViewAbility$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/vungle/ads/internal/model/AdPayload$ViewAbility;", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<ViewAbility> serializer() {
                return AdPayload$ViewAbility$$serializer.INSTANCE;
            }
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ ViewAbility(int i, ViewAbilityInfo viewAbilityInfo, SerializationConstructorMarker serializationConstructorMarker) {
            if ((i & 1) == 0) {
                this.om = null;
            } else {
                this.om = viewAbilityInfo;
            }
        }

        public ViewAbility(ViewAbilityInfo viewAbilityInfo) {
            this.om = viewAbilityInfo;
        }

        @JvmStatic
        public static final void write$Self(ViewAbility self, CompositeEncoder output, SerialDescriptor serialDesc) {
            Intrinsics.checkNotNullParameter(self, "self");
            Intrinsics.checkNotNullParameter(output, "output");
            Intrinsics.checkNotNullParameter(serialDesc, "serialDesc");
            if (!output.shouldEncodeElementDefault(serialDesc, 0) && self.om == null) {
                return;
            }
            output.encodeNullableSerializableElement(serialDesc, 0, AdPayload$ViewAbilityInfo$$serializer.INSTANCE, self.om);
        }

        public /* synthetic */ ViewAbility(ViewAbilityInfo viewAbilityInfo, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : viewAbilityInfo);
        }

        public final ViewAbilityInfo getOm() {
            return this.om;
        }
    }

    /* compiled from: AdPayload.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 #2\u00020\u0001:\u0002\"#B1\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB\u001d\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003J&\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0007HÖ\u0001J!\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!HÇ\u0001R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0012\u0012\u0004\b\u0010\u0010\r\u001a\u0004\b\u0004\u0010\u0011¨\u0006$"}, d2 = {"Lcom/vungle/ads/internal/model/AdPayload$ViewAbilityInfo;", "", "seen1", "", "isEnabled", "", "extraVast", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Boolean;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/Boolean;Ljava/lang/String;)V", "getExtraVast$annotations", "()V", "getExtraVast", "()Ljava/lang/String;", "isEnabled$annotations", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "copy", "(Ljava/lang/Boolean;Ljava/lang/String;)Lcom/vungle/ads/internal/model/AdPayload$ViewAbilityInfo;", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @Serializable
    public static final /* data */ class ViewAbilityInfo {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String extraVast;
        private final Boolean isEnabled;

        /* JADX WARN: Multi-variable type inference failed */
        public ViewAbilityInfo() {
            this((Boolean) null, (String) (0 == true ? 1 : 0), 3, (DefaultConstructorMarker) (0 == true ? 1 : 0));
        }

        public static /* synthetic */ ViewAbilityInfo copy$default(ViewAbilityInfo viewAbilityInfo, Boolean bool, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                bool = viewAbilityInfo.isEnabled;
            }
            if ((i & 2) != 0) {
                str = viewAbilityInfo.extraVast;
            }
            return viewAbilityInfo.copy(bool, str);
        }

        @SerialName("extra_vast")
        public static /* synthetic */ void getExtraVast$annotations() {
        }

        @SerialName("is_enabled")
        public static /* synthetic */ void isEnabled$annotations() {
        }

        /* renamed from: component1, reason: from getter */
        public final Boolean getIsEnabled() {
            return this.isEnabled;
        }

        /* renamed from: component2, reason: from getter */
        public final String getExtraVast() {
            return this.extraVast;
        }

        public final ViewAbilityInfo copy(Boolean isEnabled, String extraVast) {
            return new ViewAbilityInfo(isEnabled, extraVast);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewAbilityInfo)) {
                return false;
            }
            ViewAbilityInfo viewAbilityInfo = (ViewAbilityInfo) other;
            return Intrinsics.areEqual(this.isEnabled, viewAbilityInfo.isEnabled) && Intrinsics.areEqual(this.extraVast, viewAbilityInfo.extraVast);
        }

        public int hashCode() {
            Boolean bool = this.isEnabled;
            int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
            String str = this.extraVast;
            return hashCode + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            return "ViewAbilityInfo(isEnabled=" + this.isEnabled + ", extraVast=" + this.extraVast + ')';
        }

        /* compiled from: AdPayload.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/vungle/ads/internal/model/AdPayload$ViewAbilityInfo$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/vungle/ads/internal/model/AdPayload$ViewAbilityInfo;", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<ViewAbilityInfo> serializer() {
                return AdPayload$ViewAbilityInfo$$serializer.INSTANCE;
            }
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ ViewAbilityInfo(int i, @SerialName("is_enabled") Boolean bool, @SerialName("extra_vast") String str, SerializationConstructorMarker serializationConstructorMarker) {
            if ((i & 1) == 0) {
                this.isEnabled = null;
            } else {
                this.isEnabled = bool;
            }
            if ((i & 2) == 0) {
                this.extraVast = null;
            } else {
                this.extraVast = str;
            }
        }

        public ViewAbilityInfo(Boolean bool, String str) {
            this.isEnabled = bool;
            this.extraVast = str;
        }

        @JvmStatic
        public static final void write$Self(ViewAbilityInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
            Intrinsics.checkNotNullParameter(self, "self");
            Intrinsics.checkNotNullParameter(output, "output");
            Intrinsics.checkNotNullParameter(serialDesc, "serialDesc");
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.isEnabled != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, BooleanSerializer.INSTANCE, self.isEnabled);
            }
            if (!output.shouldEncodeElementDefault(serialDesc, 1) && self.extraVast == null) {
                return;
            }
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.extraVast);
        }

        public /* synthetic */ ViewAbilityInfo(Boolean bool, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : bool, (i & 2) != 0 ? null : str);
        }

        public final Boolean isEnabled() {
            return this.isEnabled;
        }

        public final String getExtraVast() {
            return this.extraVast;
        }
    }

    /* compiled from: AdPayload.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 #2\u00020\u0001:\u0002\"#B1\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB\u001d\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ&\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J!\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!HÇ\u0001R \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u000e\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u000e\u0012\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\r¨\u0006$"}, d2 = {"Lcom/vungle/ads/internal/model/AdPayload$AdSizeInfo;", "", "seen1", "", "width", "height", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Integer;Ljava/lang/Integer;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "getHeight$annotations", "()V", "getHeight", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getWidth$annotations", "getWidth", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/vungle/ads/internal/model/AdPayload$AdSizeInfo;", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @Serializable
    public static final /* data */ class AdSizeInfo {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Integer height;
        private final Integer width;

        /* JADX WARN: Multi-variable type inference failed */
        public AdSizeInfo() {
            this((Integer) null, (Integer) (0 == true ? 1 : 0), 3, (DefaultConstructorMarker) (0 == true ? 1 : 0));
        }

        public static /* synthetic */ AdSizeInfo copy$default(AdSizeInfo adSizeInfo, Integer num, Integer num2, int i, Object obj) {
            if ((i & 1) != 0) {
                num = adSizeInfo.width;
            }
            if ((i & 2) != 0) {
                num2 = adSizeInfo.height;
            }
            return adSizeInfo.copy(num, num2);
        }

        @SerialName("h")
        public static /* synthetic */ void getHeight$annotations() {
        }

        @SerialName("w")
        public static /* synthetic */ void getWidth$annotations() {
        }

        /* renamed from: component1, reason: from getter */
        public final Integer getWidth() {
            return this.width;
        }

        /* renamed from: component2, reason: from getter */
        public final Integer getHeight() {
            return this.height;
        }

        public final AdSizeInfo copy(Integer width, Integer height) {
            return new AdSizeInfo(width, height);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AdSizeInfo)) {
                return false;
            }
            AdSizeInfo adSizeInfo = (AdSizeInfo) other;
            return Intrinsics.areEqual(this.width, adSizeInfo.width) && Intrinsics.areEqual(this.height, adSizeInfo.height);
        }

        public int hashCode() {
            Integer num = this.width;
            int hashCode = (num == null ? 0 : num.hashCode()) * 31;
            Integer num2 = this.height;
            return hashCode + (num2 != null ? num2.hashCode() : 0);
        }

        public String toString() {
            return "AdSizeInfo(width=" + this.width + ", height=" + this.height + ')';
        }

        /* compiled from: AdPayload.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/vungle/ads/internal/model/AdPayload$AdSizeInfo$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/vungle/ads/internal/model/AdPayload$AdSizeInfo;", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<AdSizeInfo> serializer() {
                return AdPayload$AdSizeInfo$$serializer.INSTANCE;
            }
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ AdSizeInfo(int i, @SerialName("w") Integer num, @SerialName("h") Integer num2, SerializationConstructorMarker serializationConstructorMarker) {
            this.width = (i & 1) == 0 ? 0 : num;
            if ((i & 2) == 0) {
                this.height = 0;
            } else {
                this.height = num2;
            }
        }

        public AdSizeInfo(Integer num, Integer num2) {
            this.width = num;
            this.height = num2;
        }

        @JvmStatic
        public static final void write$Self(AdSizeInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
            Integer num;
            Integer num2;
            Intrinsics.checkNotNullParameter(self, "self");
            Intrinsics.checkNotNullParameter(output, "output");
            Intrinsics.checkNotNullParameter(serialDesc, "serialDesc");
            if (output.shouldEncodeElementDefault(serialDesc, 0) || (num2 = self.width) == null || num2.intValue() != 0) {
                output.encodeNullableSerializableElement(serialDesc, 0, IntSerializer.INSTANCE, self.width);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || (num = self.height) == null || num.intValue() != 0) {
                output.encodeNullableSerializableElement(serialDesc, 1, IntSerializer.INSTANCE, self.height);
            }
        }

        public /* synthetic */ AdSizeInfo(Integer num, Integer num2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? 0 : num, (i & 2) != 0 ? 0 : num2);
        }

        public final Integer getWidth() {
            return this.width;
        }

        public final Integer getHeight() {
            return this.height;
        }
    }

    /* compiled from: AdPayload.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 #2\u00020\u0001:\u0002\"#B1\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tB\u001d\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\nJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ&\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J!\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!HÇ\u0001R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u000f\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR \u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u000f\u0012\u0004\b\u0010\u0010\f\u001a\u0004\b\u0011\u0010\u000e¨\u0006$"}, d2 = {"Lcom/vungle/ads/internal/model/AdPayload$WebViewSettings;", "", "seen1", "", "allowFileAccessFromFileUrls", "", "allowUniversalAccessFromFileUrls", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Boolean;Ljava/lang/Boolean;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getAllowFileAccessFromFileUrls$annotations", "()V", "getAllowFileAccessFromFileUrls", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getAllowUniversalAccessFromFileUrls$annotations", "getAllowUniversalAccessFromFileUrls", "component1", "component2", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/vungle/ads/internal/model/AdPayload$WebViewSettings;", "equals", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @Serializable
    public static final /* data */ class WebViewSettings {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Boolean allowFileAccessFromFileUrls;
        private final Boolean allowUniversalAccessFromFileUrls;

        /* JADX WARN: Multi-variable type inference failed */
        public WebViewSettings() {
            this((Boolean) null, (Boolean) (0 == true ? 1 : 0), 3, (DefaultConstructorMarker) (0 == true ? 1 : 0));
        }

        public static /* synthetic */ WebViewSettings copy$default(WebViewSettings webViewSettings, Boolean bool, Boolean bool2, int i, Object obj) {
            if ((i & 1) != 0) {
                bool = webViewSettings.allowFileAccessFromFileUrls;
            }
            if ((i & 2) != 0) {
                bool2 = webViewSettings.allowUniversalAccessFromFileUrls;
            }
            return webViewSettings.copy(bool, bool2);
        }

        @SerialName("allow_file_access_from_file_urls")
        public static /* synthetic */ void getAllowFileAccessFromFileUrls$annotations() {
        }

        @SerialName("allow_universal_access_from_file_urls")
        public static /* synthetic */ void getAllowUniversalAccessFromFileUrls$annotations() {
        }

        /* renamed from: component1, reason: from getter */
        public final Boolean getAllowFileAccessFromFileUrls() {
            return this.allowFileAccessFromFileUrls;
        }

        /* renamed from: component2, reason: from getter */
        public final Boolean getAllowUniversalAccessFromFileUrls() {
            return this.allowUniversalAccessFromFileUrls;
        }

        public final WebViewSettings copy(Boolean allowFileAccessFromFileUrls, Boolean allowUniversalAccessFromFileUrls) {
            return new WebViewSettings(allowFileAccessFromFileUrls, allowUniversalAccessFromFileUrls);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof WebViewSettings)) {
                return false;
            }
            WebViewSettings webViewSettings = (WebViewSettings) other;
            return Intrinsics.areEqual(this.allowFileAccessFromFileUrls, webViewSettings.allowFileAccessFromFileUrls) && Intrinsics.areEqual(this.allowUniversalAccessFromFileUrls, webViewSettings.allowUniversalAccessFromFileUrls);
        }

        public int hashCode() {
            Boolean bool = this.allowFileAccessFromFileUrls;
            int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
            Boolean bool2 = this.allowUniversalAccessFromFileUrls;
            return hashCode + (bool2 != null ? bool2.hashCode() : 0);
        }

        public String toString() {
            return "WebViewSettings(allowFileAccessFromFileUrls=" + this.allowFileAccessFromFileUrls + ", allowUniversalAccessFromFileUrls=" + this.allowUniversalAccessFromFileUrls + ')';
        }

        /* compiled from: AdPayload.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/vungle/ads/internal/model/AdPayload$WebViewSettings$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/vungle/ads/internal/model/AdPayload$WebViewSettings;", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<WebViewSettings> serializer() {
                return AdPayload$WebViewSettings$$serializer.INSTANCE;
            }
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ WebViewSettings(int i, @SerialName("allow_file_access_from_file_urls") Boolean bool, @SerialName("allow_universal_access_from_file_urls") Boolean bool2, SerializationConstructorMarker serializationConstructorMarker) {
            if ((i & 1) == 0) {
                this.allowFileAccessFromFileUrls = null;
            } else {
                this.allowFileAccessFromFileUrls = bool;
            }
            if ((i & 2) == 0) {
                this.allowUniversalAccessFromFileUrls = null;
            } else {
                this.allowUniversalAccessFromFileUrls = bool2;
            }
        }

        public WebViewSettings(Boolean bool, Boolean bool2) {
            this.allowFileAccessFromFileUrls = bool;
            this.allowUniversalAccessFromFileUrls = bool2;
        }

        @JvmStatic
        public static final void write$Self(WebViewSettings self, CompositeEncoder output, SerialDescriptor serialDesc) {
            Intrinsics.checkNotNullParameter(self, "self");
            Intrinsics.checkNotNullParameter(output, "output");
            Intrinsics.checkNotNullParameter(serialDesc, "serialDesc");
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.allowFileAccessFromFileUrls != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, BooleanSerializer.INSTANCE, self.allowFileAccessFromFileUrls);
            }
            if (!output.shouldEncodeElementDefault(serialDesc, 1) && self.allowUniversalAccessFromFileUrls == null) {
                return;
            }
            output.encodeNullableSerializableElement(serialDesc, 1, BooleanSerializer.INSTANCE, self.allowUniversalAccessFromFileUrls);
        }

        public /* synthetic */ WebViewSettings(Boolean bool, Boolean bool2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : bool, (i & 2) != 0 ? null : bool2);
        }

        public final Boolean getAllowFileAccessFromFileUrls() {
            return this.allowFileAccessFromFileUrls;
        }

        public final Boolean getAllowUniversalAccessFromFileUrls() {
            return this.allowUniversalAccessFromFileUrls;
        }
    }
}
