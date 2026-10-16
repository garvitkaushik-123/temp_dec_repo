package adn.analytics;

import adn.analytics.Analytics;
import com.ironsource.C3057e4;
import com.ironsource.N6;
import io.adn.sdk.internal.data.repository.BidTokenRepositoryKt;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: AdnDataConverter.kt */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J&\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002J6\u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002J\u001e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002J\u001e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002J\u001e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0014\u001a\u00020\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002J\u001e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002J$\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010\u001e\u001a\u00020\u001f2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002J$\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u001c2\u0006\u0010\u001e\u001a\u00020\u001f2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002J\u0016\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001c2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010#\u001a\u00020$2\u0006\u0010\u0010\u001a\u00020\u000eH\u0002J\u0010\u0010%\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007H\u0002¨\u0006&"}, d2 = {"Ladn/analytics/AdnDataConverter;", "", "<init>", "()V", "convertToProto", "Ladn/analytics/ProtoConversionResult;", "jsonData", "Lorg/json/JSONObject;", "mapKnownFields", "", "builder", "Ladn/analytics/Analytics$AnalyticsData$Builder;", "errors", "", "", "setFieldValue", "fieldName", "value", "convertPerformanceMetrics", "Ladn/analytics/Analytics$PerformanceMetrics;", "json", "convertAttribution", "Ladn/analytics/Analytics$Attribution;", "convertRevenueGeneration", "Ladn/analytics/Analytics$RevenueGeneration;", "convertLastClick", "Ladn/analytics/Analytics$LastClick;", "convertAdInfoList", "", "Ladn/analytics/Analytics$AdInfo;", "jsonArray", "Lorg/json/JSONArray;", "convertPurchaseList", "Ladn/analytics/Analytics$Purchase;", "convertStringList", "isKnownField", "", "extractUnknownFields", "adn-protos"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AdnDataConverter {
    public final ProtoConversionResult convertToProto(JSONObject jsonData) {
        Intrinsics.checkNotNullParameter(jsonData, "jsonData");
        ArrayList arrayList = new ArrayList();
        Analytics.AnalyticsData.Builder newBuilder = Analytics.AnalyticsData.newBuilder();
        Intrinsics.checkNotNull(newBuilder);
        mapKnownFields(newBuilder, jsonData, arrayList);
        JSONObject extractUnknownFields = extractUnknownFields(jsonData);
        if (extractUnknownFields.length() > 0) {
            newBuilder.setExtraSignals(extractUnknownFields.toString());
        }
        String encodeToString = Base64.getEncoder().encodeToString(newBuilder.build().toByteArray());
        Intrinsics.checkNotNull(encodeToString);
        return new ProtoConversionResult(encodeToString, arrayList);
    }

    private final void mapKnownFields(Analytics.AnalyticsData.Builder builder, JSONObject jsonData, List<String> errors) {
        Analytics.AnalyticsData.Builder builder2;
        JSONObject jSONObject;
        List<String> list;
        Iterator<String> keys = jsonData.keys();
        Intrinsics.checkNotNullExpressionValue(keys, "keys(...)");
        while (keys.hasNext()) {
            String next = keys.next();
            Object obj = jsonData.get(next);
            Intrinsics.checkNotNull(next);
            if (isKnownField(next)) {
                Intrinsics.checkNotNull(obj);
                builder2 = builder;
                jSONObject = jsonData;
                list = errors;
                setFieldValue(builder2, next, obj, jSONObject, list);
            } else {
                builder2 = builder;
                jSONObject = jsonData;
                list = errors;
            }
            builder = builder2;
            jsonData = jSONObject;
            errors = list;
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final void setFieldValue(Analytics.AnalyticsData.Builder builder, String fieldName, Object value, JSONObject jsonData, List<String> errors) {
        String stringOrNullWithError;
        String stringOrNullWithError2;
        Long longOrNullWithError;
        Integer intOrNullWithError;
        Integer intOrNullWithError2;
        Integer intOrNullWithError3;
        String stringOrNullWithError3;
        String stringOrNullWithError4;
        Integer intOrNullWithError4;
        Integer intOrNullWithError5;
        String stringOrNullWithError5;
        Integer intOrNullWithError6;
        Integer intOrNullWithError7;
        Integer intOrNullWithError8;
        Integer intOrNullWithError9;
        String stringOrNullWithError6;
        String stringOrNullWithError7;
        Integer intOrNullWithError10;
        String stringOrNullWithError8;
        String stringOrNullWithError9;
        Integer intOrNullWithError11;
        String stringOrNullWithError10;
        String stringOrNullWithError11;
        Integer intOrNullWithError12;
        Integer intOrNullWithError13;
        Integer intOrNullWithError14;
        Integer intOrNullWithError15;
        String stringOrNullWithError12;
        Integer intOrNullWithError16;
        String stringOrNullWithError13;
        Integer intOrNullWithError17;
        Integer intOrNullWithError18;
        String stringOrNullWithError14;
        String stringOrNullWithError15;
        String stringOrNullWithError16;
        String stringOrNullWithError17;
        Integer intOrNullWithError19;
        Integer intOrNullWithError20;
        Integer intOrNullWithError21;
        Integer intOrNullWithError22;
        Integer intOrNullWithError23;
        Long longOrNullWithError2;
        String stringOrNullWithError18;
        Integer intOrNullWithError24;
        String stringOrNullWithError19;
        Integer intOrNullWithError25;
        Integer intOrNullWithError26;
        Integer intOrNullWithError27;
        Integer intOrNullWithError28;
        Integer intOrNullWithError29;
        String stringOrNullWithError20;
        Integer intOrNullWithError30;
        String stringOrNullWithError21;
        Long longOrNullWithError3;
        String stringOrNullWithError22;
        String stringOrNullWithError23;
        String stringOrNullWithError24;
        String stringOrNullWithError25;
        Integer intOrNullWithError31;
        Integer intOrNullWithError32;
        Integer intOrNullWithError33;
        String stringOrNullWithError26;
        Integer intOrNullWithError34;
        String stringOrNullWithError27;
        switch (fieldName.hashCode()) {
            case -2133529830:
                if (fieldName.equals(BidTokenRepositoryKt.DEVICE_MANUFACTURER) && (stringOrNullWithError = JSONExtensionsKt.getStringOrNullWithError(jsonData, BidTokenRepositoryKt.DEVICE_MANUFACTURER, errors)) != null) {
                    builder.setDeviceManufacturer(stringOrNullWithError);
                    break;
                }
                break;
            case -2103038138:
                if (fieldName.equals("keyboard_lang") && (value instanceof JSONArray)) {
                    builder.addAllKeyboardLang(convertStringList((JSONArray) value));
                    break;
                }
                break;
            case -2063374335:
                if (fieldName.equals("idfa_authorization_status") && (stringOrNullWithError2 = JSONExtensionsKt.getStringOrNullWithError(jsonData, "idfa_authorization_status", errors)) != null) {
                    builder.setIdfaAuthorizationStatus(stringOrNullWithError2);
                    break;
                }
                break;
            case -2012489734:
                if (fieldName.equals("boot_time") && (longOrNullWithError = JSONExtensionsKt.getLongOrNullWithError(jsonData, "boot_time", errors)) != null) {
                    builder.setBootTime(longOrNullWithError.longValue());
                    break;
                }
                break;
            case -2005243075:
                if (fieldName.equals("session_count_since_install") && (intOrNullWithError = JSONExtensionsKt.getIntOrNullWithError(jsonData, "session_count_since_install", errors)) != null) {
                    builder.setSessionCountSinceInstall(intOrNullWithError.intValue());
                    break;
                }
                break;
            case -1985731377:
                if (fieldName.equals("limit_ad_tracking") && (intOrNullWithError2 = JSONExtensionsKt.getIntOrNullWithError(jsonData, "limit_ad_tracking", errors)) != null) {
                    builder.setLimitAdTracking(intOrNullWithError2.intValue());
                    break;
                }
                break;
            case -1914850316:
                if (fieldName.equals("fs_count_since_install") && (intOrNullWithError3 = JSONExtensionsKt.getIntOrNullWithError(jsonData, "fs_count_since_install", errors)) != null) {
                    builder.setFsCountSinceInstall(intOrNullWithError3.intValue());
                    break;
                }
                break;
            case -1894544806:
                if (fieldName.equals("appstore_id") && (stringOrNullWithError3 = JSONExtensionsKt.getStringOrNullWithError(jsonData, "appstore_id", errors)) != null) {
                    builder.setAppstoreId(stringOrNullWithError3);
                    break;
                }
                break;
            case -1892786311:
                if (fieldName.equals(BidTokenRepositoryKt.APPSET_ID) && (stringOrNullWithError4 = JSONExtensionsKt.getStringOrNullWithError(jsonData, BidTokenRepositoryKt.APPSET_ID, errors)) != null) {
                    builder.setAppsetId(stringOrNullWithError4);
                    break;
                }
                break;
            case -1878563112:
                if (fieldName.equals("purchase_since_install") && (value instanceof JSONArray)) {
                    builder.addAllPurchaseSinceInstall(convertPurchaseList((JSONArray) value, errors));
                    break;
                }
                break;
            case -1877516040:
                if (fieldName.equals("play_time") && (intOrNullWithError4 = JSONExtensionsKt.getIntOrNullWithError(jsonData, "play_time", errors)) != null) {
                    builder.setPlayTime(intOrNullWithError4.intValue());
                    break;
                }
                break;
            case -1675841692:
                if (fieldName.equals(BidTokenRepositoryKt.IS_WALKING) && (intOrNullWithError5 = JSONExtensionsKt.getIntOrNullWithError(jsonData, BidTokenRepositoryKt.IS_WALKING, errors)) != null) {
                    builder.setIsWalking(intOrNullWithError5.intValue());
                    break;
                }
                break;
            case -1439500848:
                if (fieldName.equals("orientation") && (stringOrNullWithError5 = JSONExtensionsKt.getStringOrNullWithError(jsonData, "orientation", errors)) != null) {
                    builder.setOrientation(stringOrNullWithError5);
                    break;
                }
                break;
            case -1301856945:
                if (fieldName.equals("app_open_count_since_install") && (intOrNullWithError6 = JSONExtensionsKt.getIntOrNullWithError(jsonData, "app_open_count_since_install", errors)) != null) {
                    builder.setAppOpenCountSinceInstall(intOrNullWithError6.intValue());
                    break;
                }
                break;
            case -1243419086:
                if (fieldName.equals(BidTokenRepositoryKt.AIRPLANE_MODE_ENABLE) && (intOrNullWithError7 = JSONExtensionsKt.getIntOrNullWithError(jsonData, BidTokenRepositoryKt.AIRPLANE_MODE_ENABLE, errors)) != null) {
                    builder.setAirplaneModeEnable(intOrNullWithError7.intValue());
                    break;
                }
                break;
            case -1180321488:
                if (fieldName.equals("test_mode") && (intOrNullWithError8 = JSONExtensionsKt.getIntOrNullWithError(jsonData, "test_mode", errors)) != null) {
                    builder.setTestMode(intOrNullWithError8.intValue());
                    break;
                }
                break;
            case -1158732020:
                if (fieldName.equals(BidTokenRepositoryKt.TOKEN_INDEX) && (intOrNullWithError9 = JSONExtensionsKt.getIntOrNullWithError(jsonData, BidTokenRepositoryKt.TOKEN_INDEX, errors)) != null) {
                    builder.setTokenIndex(intOrNullWithError9.intValue());
                    break;
                }
                break;
            case -1116479123:
                if (fieldName.equals("perf_metrics") && (value instanceof JSONObject)) {
                    builder.setPerfMetrics(convertPerformanceMetrics((JSONObject) value, errors));
                    break;
                }
                break;
            case -1070294806:
                if (fieldName.equals("mmp_id") && (stringOrNullWithError6 = JSONExtensionsKt.getStringOrNullWithError(jsonData, "mmp_id", errors)) != null) {
                    builder.setMmpId(stringOrNullWithError6);
                    break;
                }
                break;
            case -1051027723:
                if (fieldName.equals("van_impression_id") && (stringOrNullWithError7 = JSONExtensionsKt.getStringOrNullWithError(jsonData, "van_impression_id", errors)) != null) {
                    builder.setVanImpressionId(stringOrNullWithError7);
                    break;
                }
                break;
            case -991902997:
                if (fieldName.equals("fs_load_index") && (intOrNullWithError10 = JSONExtensionsKt.getIntOrNullWithError(jsonData, "fs_load_index", errors)) != null) {
                    builder.setFsLoadIndex(intOrNullWithError10.intValue());
                    break;
                }
                break;
            case -920070642:
                if (fieldName.equals("unity_version") && (stringOrNullWithError8 = JSONExtensionsKt.getStringOrNullWithError(jsonData, "unity_version", errors)) != null) {
                    builder.setUnityVersion(stringOrNullWithError8);
                    break;
                }
                break;
            case -901870406:
                if (fieldName.equals(BidTokenRepositoryKt.APP_VERSION) && (stringOrNullWithError9 = JSONExtensionsKt.getStringOrNullWithError(jsonData, BidTokenRepositoryKt.APP_VERSION, errors)) != null) {
                    builder.setAppVersion(stringOrNullWithError9);
                    break;
                }
                break;
            case -884237580:
                if (fieldName.equals("rv_click_count_since_install") && (intOrNullWithError11 = JSONExtensionsKt.getIntOrNullWithError(jsonData, "rv_click_count_since_install", errors)) != null) {
                    builder.setRvClickCountSinceInstall(intOrNullWithError11.intValue());
                    break;
                }
                break;
            case -791182228:
                if (fieldName.equals("vsauce_version") && (stringOrNullWithError10 = JSONExtensionsKt.getStringOrNullWithError(jsonData, "vsauce_version", errors)) != null) {
                    builder.setVsauceVersion(stringOrNullWithError10);
                    break;
                }
                break;
            case -737079109:
                if (fieldName.equals("van_fs_impression_id") && (stringOrNullWithError11 = JSONExtensionsKt.getStringOrNullWithError(jsonData, "van_fs_impression_id", errors)) != null) {
                    builder.setVanFsImpressionId(stringOrNullWithError11);
                    break;
                }
                break;
            case -715052970:
                if (fieldName.equals(BidTokenRepositoryKt.DARK_MODE_ENABLE) && (intOrNullWithError12 = JSONExtensionsKt.getIntOrNullWithError(jsonData, BidTokenRepositoryKt.DARK_MODE_ENABLE, errors)) != null) {
                    builder.setDarkModeEnable(intOrNullWithError12.intValue());
                    break;
                }
                break;
            case -712241091:
                if (fieldName.equals("fs_click_count_since_install") && (intOrNullWithError13 = JSONExtensionsKt.getIntOrNullWithError(jsonData, "fs_click_count_since_install", errors)) != null) {
                    builder.setFsClickCountSinceInstall(intOrNullWithError13.intValue());
                    break;
                }
                break;
            case -705389848:
                if (fieldName.equals("total_time") && (intOrNullWithError14 = JSONExtensionsKt.getIntOrNullWithError(jsonData, "total_time", errors)) != null) {
                    builder.setTotalTime(intOrNullWithError14.intValue());
                    break;
                }
                break;
            case -636025018:
                if (fieldName.equals("game_count_success") && (intOrNullWithError15 = JSONExtensionsKt.getIntOrNullWithError(jsonData, "game_count_success", errors)) != null) {
                    builder.setGameCountSuccess(intOrNullWithError15.intValue());
                    break;
                }
                break;
            case -591076352:
                if (fieldName.equals(BidTokenRepositoryKt.DEVICE_MODEL) && (stringOrNullWithError12 = JSONExtensionsKt.getStringOrNullWithError(jsonData, BidTokenRepositoryKt.DEVICE_MODEL, errors)) != null) {
                    builder.setDeviceModel(stringOrNullWithError12);
                    break;
                }
                break;
            case -574678453:
                if (fieldName.equals("rev_gen_since_install") && (value instanceof JSONObject)) {
                    builder.setRevGenSinceInstall(convertRevenueGeneration((JSONObject) value, errors));
                    break;
                }
                break;
            case -506065267:
                if (fieldName.equals("prev_x_session_desc") && (value instanceof JSONArray)) {
                    builder.addAllPrevXSessionDesc(convertAdInfoList((JSONArray) value, errors));
                    break;
                }
                break;
            case -398953015:
                if (fieldName.equals(BidTokenRepositoryKt.ADS_CONSENT_GIVEN) && (intOrNullWithError16 = JSONExtensionsKt.getIntOrNullWithError(jsonData, BidTokenRepositoryKt.ADS_CONSENT_GIVEN, errors)) != null) {
                    builder.setAdsConsentGiven(intOrNullWithError16.intValue());
                    break;
                }
                break;
            case -376724013:
                if (fieldName.equals(BidTokenRepositoryKt.SDK_VERSION) && (stringOrNullWithError13 = JSONExtensionsKt.getStringOrNullWithError(jsonData, BidTokenRepositoryKt.SDK_VERSION, errors)) != null) {
                    builder.setSdkVersion(stringOrNullWithError13);
                    break;
                }
                break;
            case -331239923:
                if (fieldName.equals(BidTokenRepositoryKt.BATTERY) && (intOrNullWithError17 = JSONExtensionsKt.getIntOrNullWithError(jsonData, BidTokenRepositoryKt.BATTERY, errors)) != null) {
                    builder.setBattery(intOrNullWithError17.intValue());
                    break;
                }
                break;
            case -309882753:
                if (fieldName.equals(C3057e4.c) && (value instanceof JSONObject)) {
                    builder.setAttribution(convertAttribution((JSONObject) value, errors));
                    break;
                }
                break;
            case 111209:
                if (fieldName.equals(BidTokenRepositoryKt.PPI) && (intOrNullWithError18 = JSONExtensionsKt.getIntOrNullWithError(jsonData, BidTokenRepositoryKt.PPI, errors)) != null) {
                    builder.setPpi(intOrNullWithError18.intValue());
                    break;
                }
                break;
            case 3076014:
                if (fieldName.equals("date") && (stringOrNullWithError14 = JSONExtensionsKt.getStringOrNullWithError(jsonData, "date", errors)) != null) {
                    builder.setDate(stringOrNullWithError14);
                    break;
                }
                break;
            case 3165045:
                if (fieldName.equals("gaid") && (stringOrNullWithError15 = JSONExtensionsKt.getStringOrNullWithError(jsonData, "gaid", errors)) != null) {
                    builder.setGaid(stringOrNullWithError15);
                    break;
                }
                break;
            case 3227414:
                if (fieldName.equals("idfa") && (stringOrNullWithError16 = JSONExtensionsKt.getStringOrNullWithError(jsonData, "idfa", errors)) != null) {
                    builder.setIdfa(stringOrNullWithError16);
                    break;
                }
                break;
            case 3227435:
                if (fieldName.equals("idfv") && (stringOrNullWithError17 = JSONExtensionsKt.getStringOrNullWithError(jsonData, "idfv", errors)) != null) {
                    builder.setIdfv(stringOrNullWithError17);
                    break;
                }
                break;
            case 32330731:
                if (fieldName.equals("rv_count_since_install") && (intOrNullWithError19 = JSONExtensionsKt.getIntOrNullWithError(jsonData, "rv_count_since_install", errors)) != null) {
                    builder.setRvCountSinceInstall(intOrNullWithError19.intValue());
                    break;
                }
                break;
            case 169476372:
                if (fieldName.equals("rv_load_index") && (intOrNullWithError20 = JSONExtensionsKt.getIntOrNullWithError(jsonData, "rv_load_index", errors)) != null) {
                    builder.setRvLoadIndex(intOrNullWithError20.intValue());
                    break;
                }
                break;
            case 211021465:
                if (fieldName.equals("game_count_since_install") && (intOrNullWithError21 = JSONExtensionsKt.getIntOrNullWithError(jsonData, "game_count_since_install", errors)) != null) {
                    builder.setGameCountSinceInstall(intOrNullWithError21.intValue());
                    break;
                }
                break;
            case 233163615:
                if (fieldName.equals(BidTokenRepositoryKt.BATTERY_SAVER_ENABLE) && (intOrNullWithError22 = JSONExtensionsKt.getIntOrNullWithError(jsonData, BidTokenRepositoryKt.BATTERY_SAVER_ENABLE, errors)) != null) {
                    builder.setBatterySaverEnable(intOrNullWithError22.intValue());
                    break;
                }
                break;
            case 236765710:
                if (fieldName.equals("appset_id_scope") && (intOrNullWithError23 = JSONExtensionsKt.getIntOrNullWithError(jsonData, "appset_id_scope", errors)) != null) {
                    builder.setAppsetIdScope(intOrNullWithError23.intValue());
                    break;
                }
                break;
            case 268009407:
                if (fieldName.equals(BidTokenRepositoryKt.TOTAL_DISK_SPACE) && (longOrNullWithError2 = JSONExtensionsKt.getLongOrNullWithError(jsonData, BidTokenRepositoryKt.TOTAL_DISK_SPACE, errors)) != null) {
                    builder.setTotalDiskSpace(longOrNullWithError2.longValue());
                    break;
                }
                break;
            case 315869876:
                if (fieldName.equals("session_start_date") && (stringOrNullWithError18 = JSONExtensionsKt.getStringOrNullWithError(jsonData, "session_start_date", errors)) != null) {
                    builder.setSessionStartDate(stringOrNullWithError18);
                    break;
                }
                break;
            case 482684016:
                if (fieldName.equals("global_token_index") && (intOrNullWithError24 = JSONExtensionsKt.getIntOrNullWithError(jsonData, "global_token_index", errors)) != null) {
                    builder.setGlobalTokenIndex(intOrNullWithError24.intValue());
                    break;
                }
                break;
            case 546687337:
                if (fieldName.equals(BidTokenRepositoryKt.UTC_DATE) && (stringOrNullWithError19 = JSONExtensionsKt.getStringOrNullWithError(jsonData, BidTokenRepositoryKt.UTC_DATE, errors)) != null) {
                    builder.setUtcDate(stringOrNullWithError19);
                    break;
                }
                break;
            case 548539380:
                if (fieldName.equals(BidTokenRepositoryKt.BATT_CHARGE) && (intOrNullWithError25 = JSONExtensionsKt.getIntOrNullWithError(jsonData, BidTokenRepositoryKt.BATT_CHARGE, errors)) != null) {
                    builder.setBattCharge(intOrNullWithError25.intValue());
                    break;
                }
                break;
            case 795320962:
                if (fieldName.equals(BidTokenRepositoryKt.HEADSET) && (intOrNullWithError26 = JSONExtensionsKt.getIntOrNullWithError(jsonData, BidTokenRepositoryKt.HEADSET, errors)) != null) {
                    builder.setHeadset(intOrNullWithError26.intValue());
                    break;
                }
                break;
            case 852440176:
                if (fieldName.equals("first_x_session_desc") && (value instanceof JSONArray)) {
                    builder.addAllFirstXSessionDesc(convertAdInfoList((JSONArray) value, errors));
                    break;
                }
                break;
            case 955499138:
                if (fieldName.equals("game_count") && (intOrNullWithError27 = JSONExtensionsKt.getIntOrNullWithError(jsonData, "game_count", errors)) != null) {
                    builder.setGameCount(intOrNullWithError27.intValue());
                    break;
                }
                break;
            case 1099656628:
                if (fieldName.equals("rev_gen") && (value instanceof JSONObject)) {
                    builder.setRevGen(convertRevenueGeneration((JSONObject) value, errors));
                    break;
                }
                break;
            case 1134750666:
                if (fieldName.equals("last_x_session_desc") && (value instanceof JSONArray)) {
                    builder.addAllLastXSessionDesc(convertAdInfoList((JSONArray) value, errors));
                    break;
                }
                break;
            case 1181857858:
                if (fieldName.equals("is_premium") && (intOrNullWithError28 = JSONExtensionsKt.getIntOrNullWithError(jsonData, "is_premium", errors)) != null) {
                    builder.setIsPremium(intOrNullWithError28.intValue());
                    break;
                }
                break;
            case 1189730995:
                if (fieldName.equals(BidTokenRepositoryKt.SOUND_ENABLE) && (intOrNullWithError29 = JSONExtensionsKt.getIntOrNullWithError(jsonData, BidTokenRepositoryKt.SOUND_ENABLE, errors)) != null) {
                    builder.setSoundEnable(intOrNullWithError29.intValue());
                    break;
                }
                break;
            case 1303229442:
                if (fieldName.equals(BidTokenRepositoryKt.LOCAL_DATE) && (stringOrNullWithError20 = JSONExtensionsKt.getStringOrNullWithError(jsonData, BidTokenRepositoryKt.LOCAL_DATE, errors)) != null) {
                    builder.setLocalDate(stringOrNullWithError20);
                    break;
                }
                break;
            case 1352079726:
                if (fieldName.equals("count_req") && (intOrNullWithError30 = JSONExtensionsKt.getIntOrNullWithError(jsonData, "count_req", errors)) != null) {
                    builder.setCountReq(intOrNullWithError30.intValue());
                    break;
                }
                break;
            case 1586557284:
                if (fieldName.equals("has_last_click") && (value instanceof JSONObject)) {
                    builder.setHasLastClick(convertLastClick((JSONObject) value, errors));
                    break;
                }
                break;
            case 1661853540:
                if (fieldName.equals("session_id") && (stringOrNullWithError21 = JSONExtensionsKt.getStringOrNullWithError(jsonData, "session_id", errors)) != null) {
                    builder.setSessionId(stringOrNullWithError21);
                    break;
                }
                break;
            case 1667652378:
                if (fieldName.equals(BidTokenRepositoryKt.AVAILABLE_DISK_SPACE) && (longOrNullWithError3 = JSONExtensionsKt.getLongOrNullWithError(jsonData, BidTokenRepositoryKt.AVAILABLE_DISK_SPACE, errors)) != null) {
                    builder.setAvailableDiskSpace(longOrNullWithError3.longValue());
                    break;
                }
                break;
            case 1703890892:
                if (fieldName.equals("plugin_version") && (stringOrNullWithError22 = JSONExtensionsKt.getStringOrNullWithError(jsonData, "plugin_version", errors)) != null) {
                    builder.setPluginVersion(stringOrNullWithError22);
                    break;
                }
                break;
            case 1785759987:
                if (fieldName.equals("van_user_id") && (stringOrNullWithError23 = JSONExtensionsKt.getStringOrNullWithError(jsonData, "van_user_id", errors)) != null) {
                    builder.setVanUserId(stringOrNullWithError23);
                    break;
                }
                break;
            case 1923312055:
                if (fieldName.equals("connectivity") && (stringOrNullWithError24 = JSONExtensionsKt.getStringOrNullWithError(jsonData, "connectivity", errors)) != null) {
                    builder.setConnectivity(stringOrNullWithError24);
                    break;
                }
                break;
            case 1954133490:
                if (fieldName.equals("van_rv_impression_id") && (stringOrNullWithError25 = JSONExtensionsKt.getStringOrNullWithError(jsonData, "van_rv_impression_id", errors)) != null) {
                    builder.setVanRvImpressionId(stringOrNullWithError25);
                    break;
                }
                break;
            case 1968882350:
                if (fieldName.equals("bluetooth") && (intOrNullWithError31 = JSONExtensionsKt.getIntOrNullWithError(jsonData, "bluetooth", errors)) != null) {
                    builder.setBluetooth(intOrNullWithError31.intValue());
                    break;
                }
                break;
            case 2021914822:
                if (fieldName.equals(BidTokenRepositoryKt.DO_NOT_DIST) && (intOrNullWithError32 = JSONExtensionsKt.getIntOrNullWithError(jsonData, BidTokenRepositoryKt.DO_NOT_DIST, errors)) != null) {
                    builder.setDoNotDist(intOrNullWithError32.intValue());
                    break;
                }
                break;
            case 2022357618:
                if (fieldName.equals("do_not_sell") && (intOrNullWithError33 = JSONExtensionsKt.getIntOrNullWithError(jsonData, "do_not_sell", errors)) != null) {
                    builder.setDoNotSell(intOrNullWithError33.intValue());
                    break;
                }
                break;
            case 2034879442:
                if (fieldName.equals("install_date") && (stringOrNullWithError26 = JSONExtensionsKt.getStringOrNullWithError(jsonData, "install_date", errors)) != null) {
                    builder.setInstallDate(stringOrNullWithError26);
                    break;
                }
                break;
            case 2048798132:
                if (fieldName.equals("has_skip_prior_rv") && (intOrNullWithError34 = JSONExtensionsKt.getIntOrNullWithError(jsonData, "has_skip_prior_rv", errors)) != null) {
                    builder.setHasSkipPriorRv(intOrNullWithError34.intValue());
                    break;
                }
                break;
            case 2134893632:
                if (fieldName.equals("prev_session_start_date") && (stringOrNullWithError27 = JSONExtensionsKt.getStringOrNullWithError(jsonData, "prev_session_start_date", errors)) != null) {
                    builder.setPrevSessionStartDate(stringOrNullWithError27);
                    break;
                }
                break;
        }
    }

    private final Analytics.PerformanceMetrics convertPerformanceMetrics(JSONObject json, List<String> errors) {
        Analytics.PerformanceMetrics.Builder newBuilder = Analytics.PerformanceMetrics.newBuilder();
        Integer intOrNullWithError = JSONExtensionsKt.getIntOrNullWithError(json, "bad_frames", errors);
        if (intOrNullWithError != null) {
            newBuilder.setBadFrames(intOrNullWithError.intValue());
        }
        Integer intOrNullWithError2 = JSONExtensionsKt.getIntOrNullWithError(json, "terrible_frames", errors);
        if (intOrNullWithError2 != null) {
            newBuilder.setTerribleFrames(intOrNullWithError2.intValue());
        }
        Analytics.PerformanceMetrics build = newBuilder.build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        return build;
    }

    private final Analytics.Attribution convertAttribution(JSONObject json, List<String> errors) {
        Analytics.Attribution.Builder newBuilder = Analytics.Attribution.newBuilder();
        String stringOrNullWithError = JSONExtensionsKt.getStringOrNullWithError(json, "network", errors);
        if (stringOrNullWithError != null) {
            newBuilder.setNetwork(stringOrNullWithError);
        }
        Double doubleOrNullWithError = JSONExtensionsKt.getDoubleOrNullWithError(json, "cost_amount", errors);
        if (doubleOrNullWithError != null) {
            newBuilder.setCostAmount(doubleOrNullWithError.doubleValue());
        }
        String stringOrNullWithError2 = JSONExtensionsKt.getStringOrNullWithError(json, "campaign", errors);
        if (stringOrNullWithError2 != null) {
            newBuilder.setCampaign(stringOrNullWithError2);
        }
        String stringOrNullWithError3 = JSONExtensionsKt.getStringOrNullWithError(json, "cost_type", errors);
        if (stringOrNullWithError3 != null) {
            newBuilder.setCostType(stringOrNullWithError3);
        }
        String stringOrNullWithError4 = JSONExtensionsKt.getStringOrNullWithError(json, "cost_currency", errors);
        if (stringOrNullWithError4 != null) {
            newBuilder.setCostCurrency(stringOrNullWithError4);
        }
        Analytics.Attribution build = newBuilder.build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        return build;
    }

    private final Analytics.RevenueGeneration convertRevenueGeneration(JSONObject json, List<String> errors) {
        Analytics.RevenueGeneration.Builder newBuilder = Analytics.RevenueGeneration.newBuilder();
        Double doubleOrNullWithError = JSONExtensionsKt.getDoubleOrNullWithError(json, N6.T0, errors);
        if (doubleOrNullWithError != null) {
            newBuilder.setFs(doubleOrNullWithError.doubleValue());
        }
        Double doubleOrNullWithError2 = JSONExtensionsKt.getDoubleOrNullWithError(json, "rv", errors);
        if (doubleOrNullWithError2 != null) {
            newBuilder.setRv(doubleOrNullWithError2.doubleValue());
        }
        Analytics.RevenueGeneration build = newBuilder.build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        return build;
    }

    private final Analytics.LastClick convertLastClick(JSONObject json, List<String> errors) {
        Analytics.LastClick.Builder newBuilder = Analytics.LastClick.newBuilder();
        Integer intOrNullWithError = JSONExtensionsKt.getIntOrNullWithError(json, N6.T0, errors);
        if (intOrNullWithError != null) {
            newBuilder.setFs(intOrNullWithError.intValue());
        }
        Integer intOrNullWithError2 = JSONExtensionsKt.getIntOrNullWithError(json, "rv", errors);
        if (intOrNullWithError2 != null) {
            newBuilder.setRv(intOrNullWithError2.intValue());
        }
        Analytics.LastClick build = newBuilder.build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        return build;
    }

    private final List<Analytics.AdInfo> convertAdInfoList(JSONArray jsonArray, List<String> errors) {
        IntRange until = RangesKt.until(0, jsonArray.length());
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(until, 10));
        Iterator<Integer> it = until.iterator();
        while (it.hasNext()) {
            JSONObject jSONObject = jsonArray.getJSONObject(((IntIterator) it).nextInt());
            Analytics.AdInfo.Builder newBuilder = Analytics.AdInfo.newBuilder();
            Intrinsics.checkNotNull(jSONObject);
            String stringOrNullWithError = JSONExtensionsKt.getStringOrNullWithError(jSONObject, "placement", errors);
            if (stringOrNullWithError != null) {
                newBuilder.setPlacement(stringOrNullWithError);
            }
            String stringOrNullWithError2 = JSONExtensionsKt.getStringOrNullWithError(jSONObject, "crea_id", errors);
            if (stringOrNullWithError2 != null) {
                newBuilder.setCreaId(stringOrNullWithError2);
            }
            String stringOrNullWithError3 = JSONExtensionsKt.getStringOrNullWithError(jSONObject, "ad_network", errors);
            if (stringOrNullWithError3 != null) {
                newBuilder.setAdNetwork(stringOrNullWithError3);
            }
            Double doubleOrNullWithError = JSONExtensionsKt.getDoubleOrNullWithError(jSONObject, "cpm", errors);
            if (doubleOrNullWithError != null) {
                newBuilder.setCpm(doubleOrNullWithError.doubleValue());
            }
            String stringOrNullWithError4 = JSONExtensionsKt.getStringOrNullWithError(jSONObject, "date", errors);
            if (stringOrNullWithError4 != null) {
                newBuilder.setDate(stringOrNullWithError4);
            }
            Integer intOrNullWithError = JSONExtensionsKt.getIntOrNullWithError(jSONObject, "duration", errors);
            if (intOrNullWithError != null) {
                newBuilder.setDuration(intOrNullWithError.intValue());
            }
            Integer intOrNullWithError2 = JSONExtensionsKt.getIntOrNullWithError(jSONObject, "is_shown", errors);
            if (intOrNullWithError2 != null) {
                newBuilder.setIsShown(intOrNullWithError2.intValue());
            }
            Integer intOrNullWithError3 = JSONExtensionsKt.getIntOrNullWithError(jSONObject, "is_clicked", errors);
            if (intOrNullWithError3 != null) {
                newBuilder.setIsClicked(intOrNullWithError3.intValue());
            }
            Integer intOrNullWithError4 = JSONExtensionsKt.getIntOrNullWithError(jSONObject, "is_skipped", errors);
            if (intOrNullWithError4 != null) {
                newBuilder.setIsSkipped(intOrNullWithError4.intValue());
            }
            String stringOrNullWithError5 = JSONExtensionsKt.getStringOrNullWithError(jSONObject, "promoted_app_id", errors);
            if (stringOrNullWithError5 != null) {
                newBuilder.setPromotedAppId(stringOrNullWithError5);
            }
            String stringOrNullWithError6 = JSONExtensionsKt.getStringOrNullWithError(jSONObject, "review_crea_id", errors);
            if (stringOrNullWithError6 != null) {
                newBuilder.setReviewCreaId(stringOrNullWithError6);
            }
            arrayList.add(newBuilder.build());
        }
        return arrayList;
    }

    private final List<Analytics.Purchase> convertPurchaseList(JSONArray jsonArray, List<String> errors) {
        IntRange until = RangesKt.until(0, jsonArray.length());
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(until, 10));
        Iterator<Integer> it = until.iterator();
        while (it.hasNext()) {
            JSONObject jSONObject = jsonArray.getJSONObject(((IntIterator) it).nextInt());
            Analytics.Purchase.Builder newBuilder = Analytics.Purchase.newBuilder();
            Intrinsics.checkNotNull(jSONObject);
            String stringOrNullWithError = JSONExtensionsKt.getStringOrNullWithError(jSONObject, "id", errors);
            if (stringOrNullWithError != null) {
                newBuilder.setId(stringOrNullWithError);
            }
            String stringOrNullWithError2 = JSONExtensionsKt.getStringOrNullWithError(jSONObject, "type", errors);
            if (stringOrNullWithError2 != null) {
                newBuilder.setType(stringOrNullWithError2);
            }
            Double doubleOrNullWithError = JSONExtensionsKt.getDoubleOrNullWithError(jSONObject, "price", errors);
            if (doubleOrNullWithError != null) {
                newBuilder.setPrice(doubleOrNullWithError.doubleValue());
            }
            String stringOrNullWithError3 = JSONExtensionsKt.getStringOrNullWithError(jSONObject, "currency", errors);
            if (stringOrNullWithError3 != null) {
                newBuilder.setCurrency(stringOrNullWithError3);
            }
            arrayList.add(newBuilder.build());
        }
        return arrayList;
    }

    private final List<String> convertStringList(JSONArray jsonArray) {
        IntRange until = RangesKt.until(0, jsonArray.length());
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(until, 10));
        Iterator<Integer> it = until.iterator();
        while (it.hasNext()) {
            arrayList.add(jsonArray.getString(((IntIterator) it).nextInt()));
        }
        return arrayList;
    }

    private final boolean isKnownField(String fieldName) {
        Set set;
        set = AdnDataConverterKt.KNOWN_FIELDS;
        return set.contains(fieldName);
    }

    private final JSONObject extractUnknownFields(JSONObject jsonData) {
        JSONObject jSONObject = new JSONObject();
        Iterator<String> keys = jsonData.keys();
        Intrinsics.checkNotNullExpressionValue(keys, "keys(...)");
        while (keys.hasNext()) {
            String next = keys.next();
            Intrinsics.checkNotNull(next);
            if (!isKnownField(next)) {
                jSONObject.put(next, jsonData.get(next));
            }
        }
        return jSONObject;
    }
}
