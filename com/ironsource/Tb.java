package com.ironsource;

import com.ironsource.mediationsdk.AbstractAdapter;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBaseInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBaseWrapper;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterNetworkDataInterface;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public final class Tb {

    /* renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap<String, JSONObject> f3060a;

    /* JADX WARN: Multi-variable type inference failed */
    public Tb() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    private final ConcurrentHashMap<String, JSONObject> a() {
        return this.f3060a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Tb) && Intrinsics.areEqual(this.f3060a, ((Tb) obj).f3060a);
    }

    public int hashCode() {
        return this.f3060a.hashCode();
    }

    public String toString() {
        return "NetworkDataStore(networkDataMap=" + this.f3060a + ")";
    }

    public Tb(ConcurrentHashMap<String, JSONObject> networkDataMap) {
        Intrinsics.checkNotNullParameter(networkDataMap, "networkDataMap");
        this.f3060a = networkDataMap;
    }

    public final Tb a(ConcurrentHashMap<String, JSONObject> networkDataMap) {
        Intrinsics.checkNotNullParameter(networkDataMap, "networkDataMap");
        return new Tb(networkDataMap);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Tb a(Tb tb, ConcurrentHashMap concurrentHashMap, int i, Object obj) {
        if ((i & 1) != 0) {
            concurrentHashMap = tb.f3060a;
        }
        return tb.a((ConcurrentHashMap<String, JSONObject>) concurrentHashMap);
    }

    public /* synthetic */ Tb(ConcurrentHashMap concurrentHashMap, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new ConcurrentHashMap() : concurrentHashMap);
    }

    public final void a(com.ironsource.mediationsdk.v networkData) {
        Intrinsics.checkNotNullParameter(networkData, "networkData");
        if (!this.f3060a.containsKey(networkData.a())) {
            this.f3060a.put(networkData.a(), networkData.allData());
            return;
        }
        try {
            ConcurrentHashMap<String, JSONObject> concurrentHashMap = this.f3060a;
            String a2 = networkData.a();
            JSONObject jSONObject = this.f3060a.get(networkData.a());
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            JSONObject deepMergeJSONObjects = IronSourceUtils.deepMergeJSONObjects(jSONObject, networkData.allData());
            Intrinsics.checkNotNullExpressionValue(deepMergeJSONObjects, "deepMergeJSONObjects(\n  …), networkData.allData())");
            concurrentHashMap.put(a2, deepMergeJSONObjects);
        } catch (Exception e) {
            IronLog.INTERNAL.error("error while merging network data: " + e.getMessage());
        }
    }

    public final void a(AbstractAdapter adapter) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Set<Map.Entry<String, JSONObject>> entrySet = this.f3060a.entrySet();
        Intrinsics.checkNotNullExpressionValue(entrySet, "networkDataMap.entries");
        ArrayList<Map.Entry> arrayList = new ArrayList();
        for (Object obj : entrySet) {
            if (com.ironsource.mediationsdk.c.a((String) ((Map.Entry) obj).getKey(), adapter)) {
                arrayList.add(obj);
            }
        }
        for (Map.Entry entry : arrayList) {
            Object key = entry.getKey();
            Intrinsics.checkNotNullExpressionValue(key, "it.key");
            Object value = entry.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "it.value");
            adapter.setNetworkData(new com.ironsource.mediationsdk.v((String) key, (JSONObject) value));
        }
    }

    public final void a(AdapterBaseWrapper adapterBaseWrapper) {
        Set<Map.Entry<String, JSONObject>> entrySet = this.f3060a.entrySet();
        Intrinsics.checkNotNullExpressionValue(entrySet, "networkDataMap.entries");
        ArrayList<Map.Entry> arrayList = new ArrayList();
        for (Object obj : entrySet) {
            if (com.ironsource.mediationsdk.c.a((String) ((Map.Entry) obj).getKey(), adapterBaseWrapper)) {
                arrayList.add(obj);
            }
        }
        for (Map.Entry entry : arrayList) {
            AdapterBaseInterface adapterBaseInterface = adapterBaseWrapper != null ? adapterBaseWrapper.getAdapterBaseInterface() : null;
            Intrinsics.checkNotNull(adapterBaseInterface, "null cannot be cast to non-null type com.ironsource.mediationsdk.adunit.adapter.internal.AdapterNetworkDataInterface");
            Object key = entry.getKey();
            Intrinsics.checkNotNullExpressionValue(key, "it.key");
            Object value = entry.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "it.value");
            ((AdapterNetworkDataInterface) adapterBaseInterface).setNetworkData(new com.ironsource.mediationsdk.v((String) key, (JSONObject) value));
        }
    }
}
