package com.sourcepoint.cmplibrary.data.local;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.sourcepoint.cmplibrary.model.JsonToMapExtKt;
import com.sourcepoint.cmplibrary.util.FunctionalUtilsKt;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonPrimitive;
import org.json.JSONObject;

/* compiled from: DataStorageGdpr.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\f\b\u0002\u0018\u0000 @2\u00020\u0001:\u0001@B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u00104\u001a\u000205H\u0016J\b\u00106\u001a\u000205H\u0016J\b\u00107\u001a\u000205H\u0016J\b\u00108\u001a\u000205H\u0016J\n\u00109\u001a\u0004\u0018\u00010\u0006H\u0016J\n\u0010:\u001a\u0004\u0018\u00010\u0006H\u0016J\n\u0010;\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010<\u001a\u00020\u0006H\u0016J\u0012\u0010=\u001a\u0002052\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010>\u001a\u0002052\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010?\u001a\u0002052\u0006\u0010\u0005\u001a\u00020\u0006H\u0016R(\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00068V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR(\u0010\f\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00068V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR(\u0010\u000f\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00068V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000bR(\u0010\u0012\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00068V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u000bR(\u0010\u0015\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00068V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\t\"\u0004\b\u0017\u0010\u000bR(\u0010\u0018\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00068V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\t\"\u0004\b\u001a\u0010\u000bR$\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0005\u001a\u00020\u001b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R(\u0010\"\u001a\u0004\u0018\u00010!2\b\u0010\u0005\u001a\u0004\u0018\u00010!8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001b\u0010'\u001a\u00020(8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b)\u0010*R@\u0010/\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010.0-2\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010.0-8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b0\u00101\"\u0004\b2\u00103¨\u0006A"}, d2 = {"Lcom/sourcepoint/cmplibrary/data/local/DataStorageGdprImpl;", "Lcom/sourcepoint/cmplibrary/data/local/DataStorageGdpr;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "value", "", "gdprChildPmId", "getGdprChildPmId", "()Ljava/lang/String;", "setGdprChildPmId", "(Ljava/lang/String;)V", "gdprConsentUuid", "getGdprConsentUuid", "setGdprConsentUuid", "gdprDateCreated", "getGdprDateCreated", "setGdprDateCreated", "gdprExpirationDate", "getGdprExpirationDate", "setGdprExpirationDate", "gdprMessageMetaData", "getGdprMessageMetaData", "setGdprMessageMetaData", "gdprPostChoiceResp", "getGdprPostChoiceResp", "setGdprPostChoiceResp", "", "gdprSampleRate", "getGdprSampleRate", "()D", "setGdprSampleRate", "(D)V", "", "gdprSampled", "getGdprSampled", "()Ljava/lang/Boolean;", "setGdprSampled", "(Ljava/lang/Boolean;)V", "preference", "Landroid/content/SharedPreferences;", "getPreference", "()Landroid/content/SharedPreferences;", "preference$delegate", "Lkotlin/Lazy;", "", "", "tcData", "getTcData", "()Ljava/util/Map;", "setTcData", "(Ljava/util/Map;)V", "clearGdprConsent", "", "clearInternalData", "clearTCData", "deleteGdprConsent", "getAuthId", "getGdpr", "getGdprConsentResp", "getGdprMessage", "saveAuthId", "saveGdpr", "saveGdprConsentResp", "Companion", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
final class DataStorageGdprImpl implements DataStorageGdpr {
    public static final String KEY_GDPR = "sp.gdpr.key";
    public static final String KEY_GDPR_OLD = "sp.key.gdpr";

    /* renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;

    public DataStorageGdprImpl(final Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.preference = LazyKt.lazy(new Function0<SharedPreferences>() { // from class: com.sourcepoint.cmplibrary.data.local.DataStorageGdprImpl$preference$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPreferences invoke() {
                return PreferenceManager.getDefaultSharedPreferences(context);
            }
        });
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageGdpr, com.sourcepoint.cmplibrary.data.local.DataStorageCcpa, com.sourcepoint.cmplibrary.data.local.DataStorageUSNat
    public SharedPreferences getPreference() {
        Object value = this.preference.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (SharedPreferences) value;
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageGdpr
    public String getGdprChildPmId() {
        return getPreference().getString("sp.gdpr.key.childPmId", null);
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageGdpr
    public void setGdprChildPmId(String str) {
        getPreference().edit().putString("sp.gdpr.key.childPmId", str).apply();
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageGdpr
    public void saveGdpr(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        getPreference().edit().putString(KEY_GDPR, value).apply();
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageGdpr
    public String getGdpr() {
        return getPreference().getString(KEY_GDPR, null);
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageGdpr
    public Map<String, Object> getTcData() {
        TreeMap treeMap = new TreeMap();
        Map<String, ?> all = getPreference().getAll();
        Intrinsics.checkNotNullExpressionValue(all, "getAll(...)");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, ?> entry : all.entrySet()) {
            if (StringsKt.startsWith$default(entry.getKey(), "IABTCF_", false, 2, (Object) null)) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            treeMap.put(entry2.getKey(), entry2.getValue());
        }
        return treeMap;
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageGdpr
    public void setTcData(Map<String, ? extends Object> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        SharedPreferences.Editor edit = getPreference().edit();
        for (Map.Entry<String, ? extends Object> entry : value.entrySet()) {
            Object value2 = entry.getValue();
            JsonPrimitive jsonPrimitive = value2 instanceof JsonPrimitive ? (JsonPrimitive) value2 : null;
            if (jsonPrimitive != null && jsonPrimitive.getIsString()) {
                String contentOrNull = JsonElementKt.getContentOrNull(jsonPrimitive);
                if (contentOrNull != null) {
                    edit.putString(entry.getKey(), contentOrNull);
                }
            } else if ((jsonPrimitive != null ? JsonElementKt.getIntOrNull(jsonPrimitive) : null) != null) {
                edit.putInt(entry.getKey(), JsonElementKt.getInt(jsonPrimitive));
            } else if ((jsonPrimitive != null ? JsonElementKt.getBooleanOrNull(jsonPrimitive) : null) != null) {
                edit.putBoolean(entry.getKey(), JsonElementKt.getBoolean(jsonPrimitive));
            } else if ((jsonPrimitive != null ? JsonElementKt.getFloatOrNull(jsonPrimitive) : null) != null) {
                edit.putFloat(entry.getKey(), JsonElementKt.getFloat(jsonPrimitive));
            } else if ((jsonPrimitive != null ? JsonElementKt.getLongOrNull(jsonPrimitive) : null) != null) {
                edit.putLong(entry.getKey(), JsonElementKt.getLong(jsonPrimitive));
            }
        }
        edit.apply();
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageGdpr
    public void saveAuthId(String value) {
        getPreference().edit().putString("sp.gdpr.authId", value).apply();
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageGdpr
    public void saveGdprConsentResp(final String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        FunctionalUtilsKt.check(new Function0<Unit>() { // from class: com.sourcepoint.cmplibrary.data.local.DataStorageGdprImpl$saveGdprConsentResp$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                Map<String, ? extends Object> map = JsonToMapExtKt.getMap(JsonToMapExtKt.toTreeMap(new JSONObject(value)), "TCData");
                if (map == null) {
                    return null;
                }
                this.setTcData(map);
                return Unit.INSTANCE;
            }
        });
        getPreference().edit().putString("sp.gdpr.consent.resp", value).apply();
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageGdpr
    public String getAuthId() {
        return getPreference().getString("sp.gdpr.authId", null);
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageGdpr
    public String getGdprConsentResp() {
        return getPreference().getString("sp.gdpr.consent.resp", null);
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageGdpr
    public String getGdprMessage() {
        String string = getPreference().getString("sp.gdpr.json.message", "");
        Intrinsics.checkNotNull(string);
        return string;
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageGdpr
    public void clearInternalData() {
        getPreference().edit().remove("sp.gdpr.consentUUID").remove("sp.gdpr.metaData").remove("sp.gdpr.euconsent").remove("sp.gdpr.authId").apply();
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageGdpr
    public String getGdprPostChoiceResp() {
        return getPreference().getString("sp.gdpr.key.post.choice", null);
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageGdpr
    public void setGdprPostChoiceResp(String str) {
        getPreference().edit().putString("sp.gdpr.key.post.choice", str).apply();
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageGdpr
    public String getGdprDateCreated() {
        return getPreference().getString("sp.gdpr.key.date.created", null);
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageGdpr
    public void setGdprDateCreated(String str) {
        getPreference().edit().putString("sp.gdpr.key.date.created", str).apply();
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageGdpr
    public double getGdprSampleRate() {
        return getPreference().getFloat("sp.gdpr.key.sampling", 1.0f);
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageGdpr
    public void setGdprSampleRate(double d) {
        DataStorageImplKt.putFloat(getPreference(), "sp.gdpr.key.sampling", Float.valueOf((float) d));
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageGdpr
    public Boolean getGdprSampled() {
        return DataStorageImplKt.getBoolean(getPreference(), "sp.gdpr.key.sampling.result");
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageGdpr
    public void setGdprSampled(Boolean bool) {
        DataStorageImplKt.putBoolean(getPreference(), "sp.gdpr.key.sampling.result", bool);
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageGdpr
    public String getGdprExpirationDate() {
        return getPreference().getString("sp.gdpr.key.expiration.date", null);
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageGdpr
    public void setGdprExpirationDate(String str) {
        if (str != null) {
            getPreference().edit().putString("sp.gdpr.key.expiration.date", str).apply();
        }
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageGdpr
    public String getGdprConsentUuid() {
        return getPreference().getString("sp.gdpr.consentUUID", null);
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageGdpr
    public void setGdprConsentUuid(String str) {
        if (str != null) {
            getPreference().edit().putString("sp.gdpr.consentUUID", str).apply();
        }
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageGdpr
    public String getGdprMessageMetaData() {
        return getPreference().getString("sp.gdpr.key.message.metadata", null);
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageGdpr
    public void setGdprMessageMetaData(String str) {
        getPreference().edit().putString("sp.gdpr.key.message.metadata", str).apply();
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageGdpr
    public void deleteGdprConsent() {
        Map<String, ?> all = getPreference().getAll();
        Intrinsics.checkNotNullExpressionValue(all, "getAll(...)");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, ?> entry : all.entrySet()) {
            String key = entry.getKey();
            Intrinsics.checkNotNullExpressionValue(key, "<get-key>(...)");
            if (StringsKt.startsWith$default(key, "IABTCF_", false, 2, (Object) null)) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        Set keySet = linkedHashMap.keySet();
        SharedPreferences.Editor edit = getPreference().edit();
        edit.remove("sp.gdpr.consentUUID");
        edit.remove("sp.gdpr.metaData");
        edit.remove("sp.gdpr.euconsent");
        edit.remove("sp.gdpr.userConsent");
        edit.remove("sp.gdpr.authId");
        edit.remove("");
        edit.remove("IABTCF_CmpSdkID");
        edit.remove("IABTCF_CmpSdkVersion");
        edit.remove("");
        edit.remove("{}");
        edit.remove(DataStorageGdpr.INSTANCE.getDEFAULT_AUTH_ID());
        edit.remove("sp.gdpr.key.applies");
        edit.remove("sp.key.gdpr.applies");
        edit.remove("sp.gdpr.consent.resp");
        edit.remove("sp.gdpr.json.message");
        edit.remove("sp.gdpr.key.message.subcategory");
        edit.remove("sp.key.gdpr.message.subcategory");
        edit.remove("TCData");
        edit.remove(KEY_GDPR);
        edit.remove(KEY_GDPR_OLD);
        edit.remove("sp.gdpr.key.childPmId");
        edit.remove("sp.gdpr.key.post.choice");
        edit.remove("sp.gdpr.key.date.created");
        edit.remove("sp.gdpr.key.message.metadata");
        edit.remove("sp.gdpr.key.sampling");
        edit.remove("sp.gdpr.key.sampling.result");
        edit.remove("sp.gdpr.key.consent.status");
        Iterator it = keySet.iterator();
        while (it.hasNext()) {
            edit.remove((String) it.next());
        }
        edit.apply();
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageGdpr
    public void clearGdprConsent() {
        clearTCData();
        getPreference().edit().remove("sp.gdpr.consent.resp").apply();
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageGdpr
    public void clearTCData() {
        SharedPreferences.Editor edit = getPreference().edit();
        Map<String, ?> all = getPreference().getAll();
        Intrinsics.checkNotNullExpressionValue(all, "getAll(...)");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, ?> entry : all.entrySet()) {
            String key = entry.getKey();
            Intrinsics.checkNotNullExpressionValue(key, "<get-key>(...)");
            if (StringsKt.startsWith$default(key, "IABTCF_", false, 2, (Object) null)) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        Iterator it = linkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            edit.remove((String) ((Map.Entry) it.next()).getKey());
        }
        edit.apply();
    }
}
