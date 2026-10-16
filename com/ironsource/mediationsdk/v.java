package com.ironsource.mediationsdk;

import com.ironsource.A5;
import com.ironsource.C3400y9;
import com.ironsource.C3413z5;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBaseWrapper;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterNetworkDataInterface;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public final class v implements AdapterNetworkData {

    /* renamed from: a, reason: collision with root package name */
    private final String f3580a;
    private final JSONObject b;

    public v(String networkName, JSONObject data) {
        Intrinsics.checkNotNullParameter(networkName, "networkName");
        Intrinsics.checkNotNullParameter(data, "data");
        this.f3580a = networkName;
        this.b = new JSONObject(data.toString());
    }

    private final void b(Collection<? extends AdapterBaseWrapper> collection) {
        List filterNotNull = CollectionsKt.filterNotNull(collection);
        ArrayList arrayList = new ArrayList();
        for (Object obj : filterNotNull) {
            if (c.a(this.f3580a, (AdapterBaseWrapper) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((AdapterBaseWrapper) it.next()).getAdapterBaseInterface());
        }
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : arrayList2) {
            if (obj2 instanceof AdapterNetworkDataInterface) {
                arrayList3.add(obj2);
            }
        }
        Iterator it2 = arrayList3.iterator();
        while (it2.hasNext()) {
            ((AdapterNetworkDataInterface) it2.next()).setNetworkData(this);
        }
    }

    public final String a() {
        return this.f3580a;
    }

    @Override // com.ironsource.mediationsdk.AdapterNetworkData
    public JSONObject allData() {
        return this.b;
    }

    @Override // com.ironsource.mediationsdk.AdapterNetworkData
    public <T> T dataByKeyIgnoreCase(String desiredKey, Class<T> valueType) {
        T t;
        Intrinsics.checkNotNullParameter(desiredKey, "desiredKey");
        Intrinsics.checkNotNullParameter(valueType, "valueType");
        Iterator<String> keys = allData().keys();
        Intrinsics.checkNotNullExpressionValue(keys, "allData()\n          .keys()");
        Iterator<T> it = SequencesKt.asSequence(keys).iterator();
        while (true) {
            if (!it.hasNext()) {
                t = (T) null;
                break;
            }
            t = it.next();
            if (StringsKt.equals((String) t, desiredKey, true)) {
                break;
            }
        }
        String str = t;
        if (str != null) {
            Object opt = allData().opt(str);
            if (!valueType.isInstance(opt)) {
                opt = null;
            }
            if (opt != null) {
                return valueType.cast(opt);
            }
        }
        return null;
    }

    @Override // com.ironsource.mediationsdk.AdapterNetworkData
    public JSONObject networkDataByAdUnit(IronSource.AD_UNIT adUnit) {
        Intrinsics.checkNotNullParameter(adUnit, "adUnit");
        JSONObject optJSONObject = this.b.optJSONObject(adUnit.toString());
        return optJSONObject == null ? new JSONObject() : optJSONObject;
    }

    public String toString() {
        return "NetworkData(networkName=" + this.f3580a + ", networkData=" + this.b + ")";
    }

    public final void a(Collection<? extends AbstractAdapter> adapters, Collection<? extends AdapterBaseWrapper> networkAdapters) {
        Intrinsics.checkNotNullParameter(adapters, "adapters");
        Intrinsics.checkNotNullParameter(networkAdapters, "networkAdapters");
        try {
            a(adapters);
            b(networkAdapters);
        } catch (Exception e) {
            IronLog.INTERNAL.error("error while setting network data: " + e.getMessage());
        }
    }

    private final void a(Collection<? extends AbstractAdapter> collection) {
        List filterNotNull = CollectionsKt.filterNotNull(collection);
        ArrayList arrayList = new ArrayList();
        for (Object obj : filterNotNull) {
            if (c.a(this.f3580a, (AbstractAdapter) obj)) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((AbstractAdapter) it.next()).setNetworkData(this);
        }
    }

    public final void b() {
        Iterator<String> keys = this.b.keys();
        Intrinsics.checkNotNullExpressionValue(keys, "networkData.keys()");
        C3400y9.i().a(new C3413z5(A5.SET_NETWORK_DATA, IronSourceUtils.getMediationAdditionalData(false).put(IronSourceConstants.EVENTS_EXT1, this.f3580a + " - " + CollectionsKt.joinToString$default(SequencesKt.toList(SequencesKt.asSequence(keys)), ",", null, null, 0, null, null, 62, null))));
    }
}
