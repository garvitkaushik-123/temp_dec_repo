package com.sourcepoint.cmplibrary.data.local;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: DataStorageUSNat.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010!\u001a\u00020\"H\u0016R\u001b\u0010\u0005\u001a\u00020\u00068VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR(\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\f8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R(\u0010\u0012\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\f8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R$\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\u00158V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR(\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u000b\u001a\u0004\u0018\u00010\u001b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006#"}, d2 = {"Lcom/sourcepoint/cmplibrary/data/local/DataStorageUSNatImpl;", "Lcom/sourcepoint/cmplibrary/data/local/DataStorageUSNat;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "preference", "Landroid/content/SharedPreferences;", "getPreference", "()Landroid/content/SharedPreferences;", "preference$delegate", "Lkotlin/Lazy;", "value", "", "usNatConsentData", "getUsNatConsentData", "()Ljava/lang/String;", "setUsNatConsentData", "(Ljava/lang/String;)V", "usnatChildPmId", "getUsnatChildPmId", "setUsnatChildPmId", "", "usnatSampleRate", "getUsnatSampleRate", "()D", "setUsnatSampleRate", "(D)V", "", "usnatSampled", "getUsnatSampled", "()Ljava/lang/Boolean;", "setUsnatSampled", "(Ljava/lang/Boolean;)V", "deleteUsNatConsent", "", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
final class DataStorageUSNatImpl implements DataStorageUSNat {

    /* renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;

    public DataStorageUSNatImpl(final Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.preference = LazyKt.lazy(new Function0<SharedPreferences>() { // from class: com.sourcepoint.cmplibrary.data.local.DataStorageUSNatImpl$preference$2
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

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageUSNat
    public SharedPreferences getPreference() {
        Object value = this.preference.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (SharedPreferences) value;
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageUSNat
    public String getUsNatConsentData() {
        return getPreference().getString("sp.usnat.key.consent.status", null);
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageUSNat
    public void setUsNatConsentData(String str) {
        DataStorageImplKt.putString(getPreference(), "sp.usnat.key.consent.status", str);
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageUSNat
    public String getUsnatChildPmId() {
        return getPreference().getString("sp.usnat.key.childPmId", null);
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageUSNat
    public void setUsnatChildPmId(String str) {
        DataStorageImplKt.putString(getPreference(), "sp.usnat.key.childPmId", str);
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageUSNat
    public double getUsnatSampleRate() {
        return getPreference().getFloat("sp.usnat.key.sampling", 1.0f);
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageUSNat
    public void setUsnatSampleRate(double d) {
        DataStorageImplKt.putFloat(getPreference(), "sp.usnat.key.sampling", Float.valueOf((float) d));
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageUSNat
    public Boolean getUsnatSampled() {
        return DataStorageImplKt.getBoolean(getPreference(), "sp.usnat.key.sampling.result");
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageUSNat
    public void setUsnatSampled(Boolean bool) {
        DataStorageImplKt.putBoolean(getPreference(), "sp.usnat.key.sampling.result", bool);
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageUSNat
    public void deleteUsNatConsent() {
        SharedPreferences.Editor edit = getPreference().edit();
        edit.remove("sp.usnat.key.consent.status");
        edit.remove("sp.usnat.key.childPmId");
        edit.remove("sp.usnat.key.sampling.result");
        edit.remove("sp.usnat.key.sampling");
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
        Iterator it = linkedHashMap.keySet().iterator();
        while (it.hasNext()) {
            edit.remove((String) it.next());
        }
        edit.apply();
    }
}
