package com.sourcepoint.cmplibrary.data.local;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonPrimitive;

/* compiled from: DataStorageCcpa.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010:\u001a\u00020;H\u0016J\b\u0010<\u001a\u00020;H\u0016J\b\u0010=\u001a\u00020;H\u0016J\n\u0010>\u001a\u0004\u0018\u00010\u0006H\u0016J\n\u0010?\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010@\u001a\u00020\u0006H\u0016J\u0010\u0010A\u001a\u00020;2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010B\u001a\u00020;2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010C\u001a\u00020;2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016R(\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00068V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR(\u0010\f\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00068V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR(\u0010\u000f\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00068V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000bR(\u0010\u0012\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00068V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u000bR(\u0010\u0015\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00068V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\t\"\u0004\b\u0017\u0010\u000bR(\u0010\u0018\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00068V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\t\"\u0004\b\u001a\u0010\u000bR$\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0005\u001a\u00020\u001b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R(\u0010\"\u001a\u0004\u0018\u00010!2\b\u0010\u0005\u001a\u0004\u0018\u00010!8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R(\u0010'\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00068V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b(\u0010\t\"\u0004\b)\u0010\u000bRD\u0010,\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010+\u0018\u00010*2\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010+\u0018\u00010*8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001b\u00101\u001a\u0002028VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b3\u00104R(\u00107\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00068V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b8\u0010\t\"\u0004\b9\u0010\u000b¨\u0006D"}, d2 = {"Lcom/sourcepoint/cmplibrary/data/local/DataStorageCcpaImpl;", "Lcom/sourcepoint/cmplibrary/data/local/DataStorageCcpa;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "value", "", "ccpaChildPmId", "getCcpaChildPmId", "()Ljava/lang/String;", "setCcpaChildPmId", "(Ljava/lang/String;)V", "ccpaConsentUuid", "getCcpaConsentUuid", "setCcpaConsentUuid", "ccpaDateCreated", "getCcpaDateCreated", "setCcpaDateCreated", "ccpaExpirationDate", "getCcpaExpirationDate", "setCcpaExpirationDate", "ccpaMessageMetaData", "getCcpaMessageMetaData", "setCcpaMessageMetaData", "ccpaPostChoiceResp", "getCcpaPostChoiceResp", "setCcpaPostChoiceResp", "", "ccpaSampleRate", "getCcpaSampleRate", "()D", "setCcpaSampleRate", "(D)V", "", "ccpaSampled", "getCcpaSampled", "()Ljava/lang/Boolean;", "setCcpaSampled", "(Ljava/lang/Boolean;)V", "ccpaStatus", "getCcpaStatus", "setCcpaStatus", "", "", "gppData", "getGppData", "()Ljava/util/Map;", "setGppData", "(Ljava/util/Map;)V", "preference", "Landroid/content/SharedPreferences;", "getPreference", "()Landroid/content/SharedPreferences;", "preference$delegate", "Lkotlin/Lazy;", "uspstring", "getUspstring", "setUspstring", "clearCcpaConsent", "", "clearGppData", "deleteCcpaConsent", "getCcpa", "getCcpaConsentResp", "getCcpaMessage", "saveCcpa", "saveCcpaConsentResp", "saveCcpaMessage", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
final class DataStorageCcpaImpl implements DataStorageCcpa {

    /* renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;

    public DataStorageCcpaImpl(final Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.preference = LazyKt.lazy(new Function0<SharedPreferences>() { // from class: com.sourcepoint.cmplibrary.data.local.DataStorageCcpaImpl$preference$2
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

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageCcpa, com.sourcepoint.cmplibrary.data.local.DataStorageUSNat
    public SharedPreferences getPreference() {
        Object value = this.preference.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (SharedPreferences) value;
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageCcpa
    public void saveCcpa(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        getPreference().edit().putString("sp.ccpa.key", value).apply();
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageCcpa
    public String getCcpa() {
        return getPreference().getString("sp.ccpa.key", null);
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageCcpa
    public String getCcpaChildPmId() {
        return getPreference().getString("sp.ccpa.key.childPmId", null);
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageCcpa
    public void setCcpaChildPmId(String str) {
        getPreference().edit().putString("sp.ccpa.key.childPmId", str).apply();
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageCcpa
    public void saveCcpaConsentResp(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        getPreference().edit().putString("sp.ccpa.consent.resp", value).apply();
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageCcpa
    public String getUspstring() {
        return getPreference().getString("IABUSPrivacy_String", null);
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageCcpa
    public void setUspstring(String str) {
        getPreference().edit().putString("IABUSPrivacy_String", str).apply();
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageCcpa
    public String getCcpaConsentUuid() {
        return getPreference().getString("sp.ccpa.consentUUID", null);
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageCcpa
    public void setCcpaConsentUuid(String str) {
        if (str != null) {
            getPreference().edit().putString("sp.ccpa.consentUUID", str).apply();
        }
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageCcpa
    public String getCcpaDateCreated() {
        return getPreference().getString("sp.ccpa.key.date.created", null);
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageCcpa
    public void setCcpaDateCreated(String str) {
        if (str != null) {
            getPreference().edit().putString("sp.ccpa.key.date.created", str).apply();
        }
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageCcpa
    public double getCcpaSampleRate() {
        return getPreference().getFloat("sp.ccpa.key.sampling", 1.0f);
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageCcpa
    public void setCcpaSampleRate(double d) {
        DataStorageImplKt.putFloat(getPreference(), "sp.ccpa.key.sampling", Float.valueOf((float) d));
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageCcpa
    public Boolean getCcpaSampled() {
        return DataStorageImplKt.getBoolean(getPreference(), "sp.ccpa.key.sampling.result");
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageCcpa
    public void setCcpaSampled(Boolean bool) {
        DataStorageImplKt.putBoolean(getPreference(), "sp.ccpa.key.sampling.result", bool);
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageCcpa
    public String getCcpaExpirationDate() {
        return getPreference().getString("sp.ccpa.key.expiration.date", null);
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageCcpa
    public void setCcpaExpirationDate(String str) {
        if (str != null) {
            getPreference().edit().putString("sp.ccpa.key.expiration.date", str).apply();
        }
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageCcpa
    public Map<String, Object> getGppData() {
        TreeMap treeMap = new TreeMap();
        Map<String, ?> all = getPreference().getAll();
        Intrinsics.checkNotNullExpressionValue(all, "getAll(...)");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, ?> entry : all.entrySet()) {
            String key = entry.getKey();
            Intrinsics.checkNotNullExpressionValue(key, "<get-key>(...)");
            if (StringsKt.startsWith$default(key, "IABGPP_", false, 2, (Object) null)) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            Object key2 = entry2.getKey();
            Intrinsics.checkNotNullExpressionValue(key2, "<get-key>(...)");
            treeMap.put(key2, entry2.getValue());
        }
        if (treeMap.isEmpty()) {
            return null;
        }
        return treeMap;
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageCcpa
    public void setGppData(Map<String, ? extends Object> map) {
        String content;
        Integer intOrNull;
        SharedPreferences.Editor edit = getPreference().edit();
        if (map != null) {
            for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
                Object value = entry.getValue();
                JsonPrimitive jsonPrimitive = value instanceof JsonPrimitive ? (JsonPrimitive) value : null;
                if (jsonPrimitive != null ? jsonPrimitive.isString() : false) {
                    if (jsonPrimitive != null && (content = jsonPrimitive.getContent()) != null) {
                        edit.putString(entry.getKey(), content);
                    }
                } else if (jsonPrimitive != null && (intOrNull = JsonElementKt.getIntOrNull(jsonPrimitive)) != null) {
                    edit.putInt(entry.getKey(), intOrNull.intValue());
                }
            }
        }
        edit.apply();
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageCcpa
    public void clearGppData() {
        Map<String, ?> all = getPreference().getAll();
        Intrinsics.checkNotNullExpressionValue(all, "getAll(...)");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, ?> entry : all.entrySet()) {
            String key = entry.getKey();
            Intrinsics.checkNotNullExpressionValue(key, "<get-key>(...)");
            if (StringsKt.startsWith$default(key, "IABGPP_", false, 2, (Object) null)) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        Set keySet = linkedHashMap.keySet();
        SharedPreferences.Editor edit = getPreference().edit();
        Iterator it = keySet.iterator();
        while (it.hasNext()) {
            edit.remove((String) it.next());
        }
        edit.apply();
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageCcpa
    public void saveCcpaMessage(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        getPreference().edit().putString("sp.ccpa.json.message", value).apply();
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageCcpa
    public String getCcpaConsentResp() {
        return getPreference().getString("sp.ccpa.consent.resp", null);
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageCcpa
    public String getCcpaMessage() {
        String string = getPreference().getString("sp.ccpa.json.message", "");
        Intrinsics.checkNotNull(string);
        return string;
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageCcpa
    public void clearCcpaConsent() {
        getPreference().edit().remove("sp.ccpa.consent.resp").apply();
        getPreference().edit().remove("IABUSPrivacy_String").apply();
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageCcpa
    public String getCcpaPostChoiceResp() {
        return getPreference().getString("sp.ccpa.key.post.choice", null);
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageCcpa
    public void setCcpaPostChoiceResp(String str) {
        getPreference().edit().putString("sp.ccpa.key.post.choice", str).apply();
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageCcpa
    public String getCcpaStatus() {
        return getPreference().getString("sp.ccpa.key.v7.status", null);
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageCcpa
    public void setCcpaStatus(String str) {
        getPreference().edit().putString("sp.ccpa.key.v7.status", str).apply();
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageCcpa
    public String getCcpaMessageMetaData() {
        return getPreference().getString("sp.ccpa.key.message.metadata", null);
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageCcpa
    public void setCcpaMessageMetaData(String str) {
        getPreference().edit().putString("sp.ccpa.key.message.metadata", str).apply();
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageCcpa
    public void deleteCcpaConsent() {
        clearGppData();
        getPreference().edit().remove("sp.ccpa.key").remove("sp.key.ccpa").remove("sp.ccpa.key.applies").remove("sp.ccpa.consent.resp").remove("sp.ccpa.json.message").remove("sp.ccpa.consentUUID").remove("sp.ccpa.key.childPmId").remove("IABUSPrivacy_String").remove("sp.ccpa.key.message.subcategory").remove("sp.ccpa.key.post.choice").remove("sp.ccpa.key.v7.status").remove("sp.ccpa.key.message.metadata").remove("sp.ccpa.key.date.created").remove("sp.ccpa.key.sampling").remove("sp.ccpa.key.sampling.result").remove("sp.ccpa.key.consent.status").remove("sp.ccpa.key.expiration.date").apply();
    }
}
