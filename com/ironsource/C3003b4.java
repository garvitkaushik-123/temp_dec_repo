package com.ironsource;

import android.text.TextUtils;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.AbstractAdapter;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBaseInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBaseWrapper;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterConsentInterface;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.ExceptionsKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* renamed from: com.ironsource.b4, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3003b4 {

    /* renamed from: a, reason: collision with root package name */
    private Boolean f3193a;
    private final InterfaceC3381x7 b = C3334ub.s.d().i();

    public final Boolean a() {
        return this.f3193a;
    }

    public final InterfaceC3381x7 b() {
        return this.b;
    }

    public final void a(boolean z) {
        this.f3193a = Boolean.valueOf(z);
    }

    public final void a(ConcurrentHashMap<String, AbstractAdapter> adapters, ConcurrentHashMap<String, AdapterBaseWrapper> networkAdapters) {
        Unit unit;
        Intrinsics.checkNotNullParameter(adapters, "adapters");
        Intrinsics.checkNotNullParameter(networkAdapters, "networkAdapters");
        for (AbstractAdapter adapter : adapters.values()) {
            Intrinsics.checkNotNullExpressionValue(adapter, "adapter");
            a(adapter, (NetworkSettings) null);
        }
        for (AdapterBaseWrapper adapterBaseWrapper : networkAdapters.values()) {
            AdapterBaseInterface adapterBaseInterface = adapterBaseWrapper.getAdapterBaseInterface();
            if (adapterBaseInterface != null) {
                a(adapterBaseInterface, adapterBaseWrapper.getSettings());
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                IronLog.INTERNAL.error("adapter is null");
            }
        }
    }

    public final void a(AdapterBaseInterface adapter, NetworkSettings networkSettings) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        try {
            Boolean a2 = a(networkSettings);
            if (a2 == null || !(adapter instanceof AdapterConsentInterface)) {
                return;
            }
            ((AdapterConsentInterface) adapter).setConsent(a2.booleanValue());
        } catch (Throwable th) {
            C3260q4.d().a(th);
            String str = "error while setting consent of " + (networkSettings != null ? networkSettings.getProviderName() : null) + ": " + th.getLocalizedMessage();
            a(str);
            IronLog.INTERNAL.error(str);
        }
    }

    public final void a(AbstractAdapter adapter, NetworkSettings networkSettings) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        try {
            Boolean a2 = a(networkSettings);
            if (a2 != null) {
                adapter.setNewConsent(a2.booleanValue());
            }
        } catch (Throwable th) {
            C3260q4.d().a(th);
            String str = "error while setting consent of " + adapter.getProviderName() + ": " + th.getLocalizedMessage();
            a(str);
            IronLog.INTERNAL.error(str);
        }
    }

    private final Boolean a(NetworkSettings networkSettings) {
        if (networkSettings != null && !networkSettings.isCustomNetwork()) {
            if (networkSettings.getApplicationSettings().has(C3020c4.f3210a)) {
                return Boolean.valueOf(networkSettings.getApplicationSettings().optBoolean(C3020c4.f3210a));
            }
            return this.f3193a;
        }
        return this.f3193a;
    }

    private final void a(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("reason", str);
            }
            C3400y9.i().a(new C3413z5(A5.TROUBLESHOOTING_CONSENT_INTERNAL_ERROR, jSONObject));
        } catch (Exception e) {
            C3260q4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
    }

    public final void a(int i) {
        JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(false);
        try {
            mediationAdditionalData.put(IronSourceConstants.EVENTS_EXT1, i + ";" + this.b.F(ContextProvider.getInstance().getApplicationContext()));
        } catch (Exception e) {
            C3260q4.d().a(e);
            IronLog.INTERNAL.error(ExceptionsKt.stackTraceToString(e));
        }
        C3334ub.s.d().q().a(new C3413z5(A5.CONSENT_TCF_CODE, mediationAdditionalData));
    }

    public final void a(int i, ConcurrentHashMap<String, NetworkSettings> providerSettings) {
        JSONObject applicationSettings;
        Intrinsics.checkNotNullParameter(providerSettings, "providerSettings");
        String F = this.b.F(ContextProvider.getInstance().getApplicationContext());
        IronLog ironLog = IronLog.API;
        ironLog.general("TCF Additional Consent: " + F);
        ironLog.general("CMP ID: " + i);
        ironLog.general("Network Consent Reporting:");
        ironLog.general("----------------------------");
        Collection<NetworkSettings> values = providerSettings.values();
        Intrinsics.checkNotNullExpressionValue(values, "providerSettings.values");
        ArrayList arrayList = new ArrayList();
        for (Object obj : values) {
            NetworkSettings networkSettings = (NetworkSettings) obj;
            if (networkSettings.getProviderDefaultInstance() != null && !Intrinsics.areEqual(networkSettings.getProviderDefaultInstance(), IronSourceConstants.SUPERSONIC_CONFIG_NAME) && (applicationSettings = networkSettings.getApplicationSettings()) != null && applicationSettings.has(C3020c4.f3210a)) {
                arrayList.add(obj);
            }
        }
        HashSet hashSet = new HashSet();
        ArrayList<NetworkSettings> arrayList2 = new ArrayList();
        for (Object obj2 : arrayList) {
            if (hashSet.add(((NetworkSettings) obj2).getProviderDefaultInstance())) {
                arrayList2.add(obj2);
            }
        }
        for (NetworkSettings networkSettings2 : arrayList2) {
            IronLog ironLog2 = IronLog.API;
            String providerDefaultInstance = networkSettings2.getProviderDefaultInstance();
            JSONObject applicationSettings2 = networkSettings2.getApplicationSettings();
            ironLog2.general(providerDefaultInstance + ": " + (applicationSettings2 != null ? Boolean.valueOf(applicationSettings2.optBoolean(C3020c4.f3210a)) : null));
        }
    }
}
