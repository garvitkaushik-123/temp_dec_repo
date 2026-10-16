package com.ironsource.mediationsdk;

import android.text.TextUtils;
import com.ironsource.A5;
import com.ironsource.C3003b4;
import com.ironsource.C3260q4;
import com.ironsource.C3400y9;
import com.ironsource.C3413z5;
import com.ironsource.Tb;
import com.ironsource.environment.StringUtils;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adunit.adapter.AdapterDebugInterface;
import com.ironsource.mediationsdk.adunit.adapter.BaseAdapter;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterAPSDataInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBaseInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBaseWrapper;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterMetaDataInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.BaseAdAdapter;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.unity3d.mediation.adapters.levelplay.LevelPlayBaseAdapter;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class c {
    private static final String k = "IronSource";
    private static final String l = "com.ironsource.adapters";
    private static final String m = "aps";
    private static final c n = new c();
    private static final Object o = new Object();
    private String c;
    private String d;
    private Boolean e;
    private final AtomicBoolean h = new AtomicBoolean(false);
    private C3003b4 i = new C3003b4();
    private final Tb j = new Tb();

    /* renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap<String, AbstractAdapter> f3500a = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, AdapterBaseWrapper> b = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, List<String>> f = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<IronSource.AD_UNIT, JSONObject> g = new ConcurrentHashMap<>();

    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3501a;

        static {
            int[] iArr = new int[IronSource.AD_UNIT.values().length];
            f3501a = iArr;
            try {
                iArr[IronSource.AD_UNIT.REWARDED_VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3501a[IronSource.AD_UNIT.INTERSTITIAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3501a[IronSource.AD_UNIT.BANNER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3501a[IronSource.AD_UNIT.NATIVE_AD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static c b() {
        return n;
    }

    public AbstractAdapter a(NetworkSettings networkSettings) {
        return a(b(networkSettings), networkSettings.getProviderTypeForReflection());
    }

    public void c(String str, List<String> list) {
        synchronized (o) {
            this.f.put(str, list);
            if (!this.f3500a.isEmpty()) {
                IronSourceUtils.sendAutomationLog("setMetaData key = " + str + ", values = " + list);
                b(str, list);
            }
            a(str, list);
        }
    }

    public ConcurrentHashMap<String, List<String>> d() {
        return this.f;
    }

    public ConcurrentHashMap<String, AdapterBaseWrapper> e() {
        return this.b;
    }

    public void f() {
        this.f3500a.clear();
        this.b.clear();
    }

    public void b(String str, String str2) {
        this.c = str;
        this.d = str2;
    }

    public AbstractAdapter a(NetworkSettings networkSettings, JSONObject jSONObject, boolean z) {
        String str;
        String b = b(networkSettings);
        String providerTypeForReflection = z ? "IronSource" : networkSettings.getProviderTypeForReflection();
        synchronized (o) {
            if (this.f3500a.containsKey(b)) {
                return this.f3500a.get(b);
            }
            AbstractAdapter a2 = a(b, providerTypeForReflection);
            if (a2 == null) {
                b(b + " adapter was not loaded");
                return null;
            }
            a2.setProviderNetworkKey(networkSettings.getProviderNetworkKey());
            try {
                str = a2.getCoreSDKVersion();
            } catch (Throwable th) {
                C3260q4.d().a(th);
                String str2 = "error while retrieving coreSDKVersion " + a2.getProviderName() + ": " + th.getLocalizedMessage();
                a(A5.TROUBLESHOOTING_ADAPTER_REPOSITORY_INTERNAL_ERROR, str2);
                IronLog.INTERNAL.error(str2);
                str = "Unknown";
            }
            c(b + " was allocated (adapter version: " + a2.getVersion() + ", sdk version: " + str + ")");
            c(a2);
            this.j.a(a2);
            a(a2);
            this.i.a(a2, networkSettings);
            b(a2);
            a(jSONObject, a2, providerTypeForReflection);
            this.f3500a.put(b, a2);
            return a2;
        }
    }

    public void b(boolean z) {
        synchronized (o) {
            this.i.a(z);
            this.i.a(this.f3500a, this.b);
        }
    }

    private void b(AdapterBaseInterface adapterBaseInterface) {
        Boolean bool = this.e;
        if (bool == null || !(adapterBaseInterface instanceof AdapterDebugInterface)) {
            return;
        }
        try {
            ((AdapterDebugInterface) adapterBaseInterface).setAdapterDebug(bool.booleanValue());
        } catch (Exception e) {
            C3260q4.d().a(e);
            String str = "error while setting adapterDebug of " + adapterBaseInterface.getClass().getSimpleName() + ": " + e.getLocalizedMessage();
            a(A5.TROUBLESHOOTING_ADAPTER_REPOSITORY_INTERNAL_ERROR, str);
            c(str);
        }
    }

    private void c(final AdapterBaseInterface adapterBaseInterface) {
        if (adapterBaseInterface == null) {
            return;
        }
        for (final String str : this.f.keySet()) {
            final List<String> list = this.f.get(str);
            if (list != null && (adapterBaseInterface instanceof AdapterMetaDataInterface)) {
                a(new Runnable() { // from class: com.ironsource.mediationsdk.c$$ExternalSyntheticLambda3
                    @Override // java.lang.Runnable
                    public final void run() {
                        c.b(AdapterBaseInterface.this, str, list);
                    }
                }, adapterBaseInterface.getClass().getSimpleName());
            }
        }
    }

    private void b(AbstractAdapter abstractAdapter) {
        Boolean bool = this.e;
        if (bool != null) {
            try {
                abstractAdapter.setAdapterDebug(bool);
            } catch (Throwable th) {
                C3260q4.d().a(th);
                String str = "error while setting adapterDebug of " + abstractAdapter.getProviderName() + ": " + th.getLocalizedMessage();
                a(A5.TROUBLESHOOTING_ADAPTER_REPOSITORY_INTERNAL_ERROR, str);
                c(str);
            }
        }
    }

    private void c(final AbstractAdapter abstractAdapter) {
        if (abstractAdapter == null) {
            return;
        }
        for (final String str : this.f.keySet()) {
            final List<String> list = this.f.get(str);
            if (list != null) {
                a(new Runnable() { // from class: com.ironsource.mediationsdk.c$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        c.b(AbstractAdapter.this, str, list);
                    }
                }, abstractAdapter.getProviderName());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(AdapterBaseInterface adapterBaseInterface, String str, List list) {
        ((AdapterMetaDataInterface) adapterBaseInterface).setMetaData(str, list);
        IronSourceUtils.sendAutomationLog(adapterBaseInterface.getClass().getSimpleName() + "Adapter setMetaData key = " + str + ", values = " + list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(AbstractAdapter abstractAdapter, String str, List list) {
        abstractAdapter.setMetaData(str, list);
        IronSourceUtils.sendAutomationLog(abstractAdapter.getProviderName() + "Adapter setMetaData key = " + str + ", values = " + list);
    }

    private void b(final String str, final List<String> list) {
        for (final AbstractAdapter abstractAdapter : this.f3500a.values()) {
            a(new Runnable() { // from class: com.ironsource.mediationsdk.c$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    c.a(AbstractAdapter.this, str, list);
                }
            }, abstractAdapter.getProviderName());
        }
    }

    private String c(NetworkSettings networkSettings, IronSource.AD_UNIT ad_unit, UUID uuid) {
        return (uuid != null ? uuid.toString() : "") + "-" + ad_unit.toString() + "-" + networkSettings.getProviderName();
    }

    private void c(NetworkSettings networkSettings) {
        IronLog.INTERNAL.error("Missing package definition for " + networkSettings.getProviderTypeForReflection());
    }

    private void c(String str) {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, "AdapterRepository: " + str, 0);
    }

    public ConcurrentHashMap<String, LevelPlayBaseAdapter> c() {
        ConcurrentHashMap<String, LevelPlayBaseAdapter> concurrentHashMap = new ConcurrentHashMap<>();
        for (String str : this.b.keySet()) {
            AdapterBaseWrapper adapterBaseWrapper = this.b.get(str);
            if (adapterBaseWrapper != null && (adapterBaseWrapper.getAdapterBaseInterface() instanceof LevelPlayBaseAdapter)) {
                concurrentHashMap.put(str, (LevelPlayBaseAdapter) adapterBaseWrapper.getAdapterBaseInterface());
            }
        }
        return concurrentHashMap;
    }

    private String b(NetworkSettings networkSettings) {
        if (networkSettings.isMultipleInstances()) {
            return networkSettings.getProviderDefaultInstance();
        }
        return networkSettings.getProviderName();
    }

    public AdapterBaseInterface b(NetworkSettings networkSettings, IronSource.AD_UNIT ad_unit, UUID uuid) {
        String c;
        String providerTypeForReflection;
        if (networkSettings.isCustomNetwork()) {
            c = b(networkSettings);
        } else {
            c = c(networkSettings, ad_unit, uuid);
        }
        if (this.b.containsKey(c)) {
            return this.b.get(c).getAdapterBaseInterface();
        }
        if (networkSettings.isCustomNetwork()) {
            providerTypeForReflection = networkSettings.getCustomNetworkAdapterName(null);
        } else {
            providerTypeForReflection = networkSettings.getProviderTypeForReflection();
        }
        AdapterBaseInterface a2 = a(c, providerTypeForReflection, networkSettings);
        return (a2 != null || networkSettings.isCustomNetwork()) ? a2 : a(networkSettings, ad_unit, c);
    }

    private void a(JSONObject jSONObject, AbstractAdapter abstractAdapter, String str) {
        if (str.equalsIgnoreCase("IronSource") && this.h.compareAndSet(false, true)) {
            c("SDK5 earlyInit  <" + str + ">");
            try {
                abstractAdapter.earlyInit(this.c, this.d, jSONObject);
            } catch (Exception e) {
                C3260q4.d().a(e);
                String str2 = "error while calling early init for " + abstractAdapter.getProviderName() + ": " + e.getLocalizedMessage();
                a(A5.TROUBLESHOOTING_ADAPTER_REPOSITORY_INTERNAL_ERROR, str2);
                IronLog.INTERNAL.error(str2);
            }
        }
    }

    private AbstractAdapter a(String str, String str2) {
        try {
            Class<?> cls = Class.forName(a(str2));
            return (AbstractAdapter) cls.getMethod(IronSourceConstants.START_ADAPTER, String.class).invoke(cls, str);
        } catch (Exception e) {
            String str3 = "Error while loading adapter - exception = " + e.getLocalizedMessage();
            a(A5.TROUBLESHOOTING_ADAPTER_REPOSITORY_INTERNAL_ERROR, str3);
            b(str3);
            return null;
        }
    }

    private JSONObject b(NetworkSettings networkSettings, IronSource.AD_UNIT ad_unit) {
        int i = a.f3501a[ad_unit.ordinal()];
        if (i == 1) {
            return networkSettings.getRewardedVideoSettings();
        }
        if (i == 2) {
            return networkSettings.getInterstitialSettings();
        }
        if (i == 3) {
            return networkSettings.getBannerSettings();
        }
        if (i != 4) {
            return null;
        }
        return networkSettings.getNativeAdSettings();
    }

    private static String a(String str) {
        return "com.ironsource.adapters." + StringUtils.toLowerCase(str) + "." + str + "Adapter";
    }

    private String a(String str, IronSource.AD_UNIT ad_unit) {
        return "com.ironsource.adapters." + StringUtils.toLowerCase(str) + "." + StringUtils.toLowerCase(a(ad_unit)) + "." + str + a(ad_unit) + "Adapter";
    }

    public void b(v vVar) {
        if (a(vVar)) {
            this.j.a(vVar);
            vVar.a(this.f3500a.values(), this.b.values());
            vVar.b();
            if (StringUtils.toLowerCase(vVar.a()).equals(m)) {
                a(vVar.allData());
            }
        }
    }

    private String a(IronSource.AD_UNIT ad_unit) {
        if (ad_unit == null) {
            return null;
        }
        int i = a.f3501a[ad_unit.ordinal()];
        if (i == 1) {
            return "Rewarded";
        }
        if (i == 2) {
            return "Interstitial";
        }
        if (i == 3) {
            return "Banner";
        }
        if (i != 4) {
            return null;
        }
        return "NativeAd";
    }

    private void b(String str) {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, "AdapterRepository: " + str, 3);
    }

    public void a(boolean z) {
        synchronized (o) {
            this.e = Boolean.valueOf(z);
            Iterator<AbstractAdapter> it = this.f3500a.values().iterator();
            while (it.hasNext()) {
                b(it.next());
            }
            Iterator<AdapterBaseWrapper> it2 = this.b.values().iterator();
            while (it2.hasNext()) {
                b(it2.next().getAdapterBaseInterface());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(AbstractAdapter abstractAdapter, String str, List list) {
        abstractAdapter.setMetaData(str, list);
        IronSourceUtils.sendAutomationLog(abstractAdapter.getProviderName() + "Adapter setMetaData key = " + str + ", values = " + list);
    }

    private void a(final String str, final List<String> list) {
        for (AdapterBaseWrapper adapterBaseWrapper : this.b.values()) {
            final AdapterBaseInterface adapterBaseInterface = adapterBaseWrapper.getAdapterBaseInterface();
            if (!adapterBaseWrapper.getSettings().isCustomNetwork() && (adapterBaseInterface instanceof AdapterMetaDataInterface)) {
                a(new Runnable() { // from class: com.ironsource.mediationsdk.c$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        c.a(AdapterBaseInterface.this, str, list);
                    }
                }, adapterBaseInterface.getClass().getSimpleName());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(AdapterBaseInterface adapterBaseInterface, String str, List list) {
        ((AdapterMetaDataInterface) adapterBaseInterface).setMetaData(str, list);
        IronSourceUtils.sendAutomationLog(adapterBaseInterface.getClass().getSimpleName() + "Adapter setMetaData key = " + str + ", values = " + list);
    }

    private void a(Runnable runnable, String str) {
        try {
            runnable.run();
        } catch (Throwable th) {
            C3260q4.d().a(th);
            String str2 = "Error while setting meta-data for adapter " + str + ": " + th.getLocalizedMessage();
            a(A5.TROUBLESHOOTING_ADAPTER_REPOSITORY_INTERNAL_ERROR, str2);
            c(str2);
        }
    }

    private void a(AdapterBaseInterface adapterBaseInterface) {
        if (!(adapterBaseInterface instanceof SetAPSInterface) || this.g.size() == 0) {
            return;
        }
        for (IronSource.AD_UNIT ad_unit : this.g.keySet()) {
            try {
                JSONObject jSONObject = this.g.get(ad_unit);
                if (jSONObject != null && jSONObject.length() > 0) {
                    ((SetAPSInterface) adapterBaseInterface).setAPSData(ad_unit, jSONObject);
                }
            } catch (Exception e) {
                C3260q4.d().a(e);
                String str = "error while setting aps data: " + e.getLocalizedMessage();
                a(A5.TROUBLESHOOTING_ADAPTER_REPOSITORY_SET_NETWORK_DATA_INTERNAL_ERROR, str);
                c(str);
            }
        }
        this.g.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void a(AbstractAdapter abstractAdapter) {
        if (!StringUtils.toLowerCase(abstractAdapter.getProviderName()).equals(m) || this.g.size() == 0) {
            return;
        }
        for (IronSource.AD_UNIT ad_unit : this.g.keySet()) {
            try {
                JSONObject jSONObject = this.g.get(ad_unit);
                if (jSONObject != null && jSONObject.length() > 0 && (abstractAdapter instanceof SetAPSInterface)) {
                    ((SetAPSInterface) abstractAdapter).setAPSData(ad_unit, jSONObject);
                }
            } catch (Exception e) {
                C3260q4.d().a(e);
                String str = "error while setting aps data: " + e.getLocalizedMessage();
                a(A5.TROUBLESHOOTING_ADAPTER_REPOSITORY_SET_NETWORK_DATA_INTERNAL_ERROR, str);
                c(str);
            }
        }
        this.g.clear();
    }

    private u a(NetworkSettings networkSettings, IronSource.AD_UNIT ad_unit, String str) {
        AbstractAdapter a2 = a(networkSettings, b(networkSettings, ad_unit), false);
        if (a2 != null) {
            u uVar = new u(a2);
            this.b.put(str, new AdapterBaseWrapper(uVar, networkSettings));
            return uVar;
        }
        String str2 = "error creating network adapter " + networkSettings.getProviderName();
        a(A5.TROUBLESHOOTING_ADAPTER_REPOSITORY_INTERNAL_ERROR, str2);
        IronLog.INTERNAL.error(str2);
        return null;
    }

    private void a(String str, AdapterBaseInterface adapterBaseInterface, NetworkSettings networkSettings) {
        if (!networkSettings.isCustomNetwork()) {
            c(adapterBaseInterface);
            a(adapterBaseInterface);
        }
        this.i.a(adapterBaseInterface, networkSettings);
        b(adapterBaseInterface);
        this.j.a(new AdapterBaseWrapper(adapterBaseInterface, networkSettings));
        this.b.put(str, new AdapterBaseWrapper(adapterBaseInterface, networkSettings));
    }

    private AdapterBaseInterface a(String str, String str2, NetworkSettings networkSettings) {
        String a2;
        if (networkSettings.isCustomNetwork() && TextUtils.isEmpty(networkSettings.getCustomNetworkPackage())) {
            IronLog.INTERNAL.error("missing package definition for " + str);
            return null;
        }
        if (networkSettings.isCustomNetwork()) {
            a2 = networkSettings.getCustomNetworkPackage() + "." + str2;
        } else {
            a2 = a(str2);
        }
        try {
            BaseAdapter baseAdapter = (BaseAdapter) Class.forName(a2).newInstance();
            IronLog.INTERNAL.info(a2 + " was allocated (adapter version: " + baseAdapter.getAdapterVersion() + ", sdk version: " + baseAdapter.getNetworkSDKVersion() + ")");
            a(str, baseAdapter, networkSettings);
            return baseAdapter;
        } catch (Exception unused) {
            if (networkSettings.isCustomNetwork()) {
                String str3 = "failed to load " + a2;
                IronLog.INTERNAL.error(str3);
                a(A5.TROUBLESHOOTING_ADAPTER_REPOSITORY_INTERNAL_ERROR, str3);
            }
            return null;
        }
    }

    public BaseAdAdapter<?, ?> a(NetworkSettings networkSettings, IronSource.AD_UNIT ad_unit, UUID uuid) {
        BaseAdAdapter<?, ?> a2 = a(networkSettings, ad_unit);
        if (a2 != null || networkSettings.isCustomNetwork()) {
            return a2;
        }
        AbstractAdapter a3 = a(networkSettings);
        if (a3 != null) {
            return com.ironsource.mediationsdk.a.a(a3, networkSettings, ad_unit, uuid);
        }
        String str = "error creating ad adapter " + networkSettings.getProviderName();
        a(A5.TROUBLESHOOTING_ADAPTER_REPOSITORY_INTERNAL_ERROR, str);
        IronLog.INTERNAL.error(str);
        return null;
    }

    private BaseAdAdapter<?, ?> a(NetworkSettings networkSettings, IronSource.AD_UNIT ad_unit) {
        boolean isCustomNetwork = networkSettings.isCustomNetwork();
        if (isCustomNetwork && TextUtils.isEmpty(networkSettings.getCustomNetworkPackage())) {
            c(networkSettings);
            return null;
        }
        String a2 = a(networkSettings, ad_unit, isCustomNetwork, a(networkSettings, ad_unit, isCustomNetwork));
        try {
            return a(a2, networkSettings);
        } catch (Exception e) {
            if (isCustomNetwork) {
                a(e, a2);
            }
            return null;
        }
    }

    private String a(NetworkSettings networkSettings, IronSource.AD_UNIT ad_unit, boolean z) {
        if (z) {
            return networkSettings.getCustomNetworkAdapterName(ad_unit);
        }
        return networkSettings.getProviderTypeForReflection();
    }

    private String a(NetworkSettings networkSettings, IronSource.AD_UNIT ad_unit, boolean z, String str) {
        if (z) {
            return networkSettings.getCustomNetworkPackage() + "." + str;
        }
        return a(str, ad_unit);
    }

    private BaseAdAdapter<?, ?> a(String str, NetworkSettings networkSettings) throws Exception {
        return (BaseAdAdapter) Class.forName(str).getConstructor(NetworkSettings.class).newInstance(networkSettings);
    }

    private void a(Exception exc, String str) {
        String str2 = "Failed to load adapter class: " + str;
        IronLog.INTERNAL.error(str2);
        a(A5.TROUBLESHOOTING_ADAPTER_REPOSITORY_INTERNAL_ERROR, str2 + " - " + exc.getMessage());
    }

    private void a(A5 a5, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("reason", str);
            }
            C3400y9.i().a(new C3413z5(a5, jSONObject));
        } catch (Exception e) {
            C3260q4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
    }

    private boolean a(v vVar) {
        if (vVar.allData().length() == 0) {
            a(A5.TROUBLESHOOTING_ADAPTER_REPOSITORY_SET_NETWORK_DATA_INTERNAL_ERROR, "empty network data");
            b("empty network data");
            return false;
        }
        if (!TextUtils.isEmpty(vVar.a())) {
            return true;
        }
        a(A5.TROUBLESHOOTING_ADAPTER_REPOSITORY_SET_NETWORK_DATA_INTERNAL_ERROR, "empty network key");
        b("empty network key");
        return false;
    }

    private void a(JSONObject jSONObject) {
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            JSONObject optJSONObject = jSONObject.optJSONObject(next);
            IronSource.AD_UNIT ad_unit = IronSource.AD_UNIT.BANNER;
            if (next.equalsIgnoreCase(ad_unit.toString())) {
                a(ad_unit, optJSONObject);
            } else {
                IronSource.AD_UNIT ad_unit2 = IronSource.AD_UNIT.INTERSTITIAL;
                if (next.equalsIgnoreCase(ad_unit2.toString())) {
                    a(ad_unit2, optJSONObject);
                } else {
                    IronSource.AD_UNIT ad_unit3 = IronSource.AD_UNIT.REWARDED_VIDEO;
                    if (next.equalsIgnoreCase(ad_unit3.toString())) {
                        a(ad_unit3, optJSONObject);
                    }
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void a(IronSource.AD_UNIT ad_unit, JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.length() != 0) {
            try {
                JSONObject jSONObject2 = new JSONObject(jSONObject.toString());
                if (!this.f3500a.isEmpty()) {
                    for (AbstractAdapter abstractAdapter : this.f3500a.values()) {
                        if (StringUtils.toLowerCase(abstractAdapter.getProviderName()).equals(m) && (abstractAdapter instanceof SetAPSInterface)) {
                            ((SetAPSInterface) abstractAdapter).setAPSData(ad_unit, jSONObject2);
                            return;
                        }
                    }
                }
                for (AdapterBaseWrapper adapterBaseWrapper : this.b.values()) {
                    if (StringUtils.toLowerCase(adapterBaseWrapper.getSettings().getProviderTypeForReflection()).equals(m)) {
                        AdapterBaseInterface adapterBaseInterface = adapterBaseWrapper.getAdapterBaseInterface();
                        if (adapterBaseInterface != null) {
                            ((AdapterAPSDataInterface) adapterBaseInterface).setAPSData(ad_unit, jSONObject2);
                            return;
                        }
                        return;
                    }
                }
                synchronized (o) {
                    this.g.put(ad_unit, jSONObject2);
                }
                return;
            } catch (Exception e) {
                C3260q4.d().a(e);
                String str = "error while setting APSData: " + e.getLocalizedMessage();
                a(A5.TROUBLESHOOTING_ADAPTER_REPOSITORY_SET_NETWORK_DATA_INTERNAL_ERROR, str);
                b(str);
                return;
            }
        }
        a(A5.TROUBLESHOOTING_ADAPTER_REPOSITORY_SET_NETWORK_DATA_INTERNAL_ERROR, "APSData is empty");
        b("APSData is empty");
    }

    public ConcurrentHashMap<String, AbstractAdapter> a() {
        return this.f3500a;
    }

    public static boolean a(String str, AdapterBaseWrapper adapterBaseWrapper) {
        return (adapterBaseWrapper == null || adapterBaseWrapper.getSettings().getProviderNetworkKey() == null || !adapterBaseWrapper.getSettings().getProviderNetworkKey().equalsIgnoreCase(str)) ? false : true;
    }

    public static boolean a(String str, AbstractAdapter abstractAdapter) {
        return (abstractAdapter == null || abstractAdapter.getProviderNetworkKey() == null || !abstractAdapter.getProviderNetworkKey().equalsIgnoreCase(str)) ? false : true;
    }
}
