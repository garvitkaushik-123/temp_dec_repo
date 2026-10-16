package com.inmobi.media;

import com.inmobi.unifiedId.InMobiUnifiedIdInterface;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.inmobi.media.ye, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2964ye {

    /* renamed from: a, reason: collision with root package name */
    public final Be f2767a;
    public final LinkedHashSet b;

    public C2964ye(Be networkRequest, LinkedHashSet inMobiUnifiedIdInterfaceSet) {
        Intrinsics.checkNotNullParameter(networkRequest, "networkRequest");
        Intrinsics.checkNotNullParameter(inMobiUnifiedIdInterfaceSet, "inMobiUnifiedIdInterfaceSet");
        this.f2767a = networkRequest;
        this.b = inMobiUnifiedIdInterfaceSet;
    }

    public final void a(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        synchronized (AbstractC2945xe.class) {
            if (this.f2767a.A.get()) {
                return;
            }
            AbstractC2945xe.a();
            Q5.b(AbstractC2980ze.a(jSONObject, Q5.b()));
            JSONObject a2 = AbstractC2980ze.a(Q5.b());
            for (InMobiUnifiedIdInterface inMobiUnifiedIdInterface : this.b) {
                if (a2 == null) {
                    AbstractC2980ze.a(inMobiUnifiedIdInterface, null, new Error(InMobiUnifiedIdInterface.NO_LOCAL_DATA_PRESENT));
                } else {
                    AbstractC2980ze.a(inMobiUnifiedIdInterface, a2, null);
                }
            }
            this.b.clear();
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void a(I9 i9) {
        EnumC2790o4 enumC2790o4;
        synchronized (AbstractC2945xe.class) {
            if (i9 != null) {
                try {
                    enumC2790o4 = i9.f2315a;
                } catch (Throwable th) {
                    throw th;
                }
            } else {
                enumC2790o4 = null;
            }
            Objects.toString(enumC2790o4);
            Objects.toString(i9 != null ? i9.f2315a : null);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (i9 != null) {
                linkedHashMap.put(IronSourceConstants.EVENTS_ERROR_CODE, i9.f2315a);
            }
            Pd pd = Pd.f2401a;
            Pd.b("UnifiedIdNetworkResponseFailure", linkedHashMap, Td.f2443a);
            if (this.f2767a.A.get()) {
                return;
            }
            AbstractC2945xe.a();
            a();
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void a() {
        JSONObject a2 = AbstractC2980ze.a(Q5.b());
        try {
            if (a2 != null) {
                try {
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if (a2.has("ufids") && a2.getJSONArray("ufids").length() > 0) {
                    Iterator it = this.b.iterator();
                    while (it.hasNext()) {
                        AbstractC2980ze.a((InMobiUnifiedIdInterface) it.next(), a2, null);
                    }
                }
            }
            Iterator it2 = this.b.iterator();
            while (it2.hasNext()) {
                AbstractC2980ze.a((InMobiUnifiedIdInterface) it2.next(), null, new Error(InMobiUnifiedIdInterface.NETWORK_FAILURE_AND_NO_LOCAL_DATA_PRESENT));
            }
        } finally {
            this.b.clear();
        }
    }
}
