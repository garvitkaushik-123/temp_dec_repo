package com.ironsource;

import com.ironsource.mediationsdk.logger.IronLog;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public final class S6 {

    /* renamed from: a, reason: collision with root package name */
    private final J9 f3046a;

    public S6(J9 globalDataWriter) {
        Intrinsics.checkNotNullParameter(globalDataWriter, "globalDataWriter");
        this.f3046a = globalDataWriter;
    }

    public final void a(JSONObject metaDataJson) {
        Intrinsics.checkNotNullParameter(metaDataJson, "metaDataJson");
        if (metaDataJson.has(com.ironsource.mediationsdk.metadata.a.i)) {
            try {
                Object remove = metaDataJson.remove(com.ironsource.mediationsdk.metadata.a.i);
                Intrinsics.checkNotNull(remove, "null cannot be cast to non-null type java.util.ArrayList<*>{ kotlin.collections.TypeAliasesKt.ArrayList<*> }");
                ArrayList arrayList = (ArrayList) remove;
                if (arrayList.isEmpty()) {
                    return;
                }
                Object obj = arrayList.get(0);
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f3046a.e((String) obj);
            } catch (ClassCastException e) {
                C3260q4.d().a(e);
                IronLog.INTERNAL.error("got the following error " + e.getMessage());
            }
        }
    }
}
