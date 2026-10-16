package com.ironsource;

import android.text.TextUtils;
import com.ironsource.AbstractC3222o0;
import com.ironsource.D0;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.model.Placement;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* loaded from: classes6.dex */
public final class Nb extends AbstractC3222o0 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Nb(C3205n0 adTools, Ob adUnitData, Pb listener) {
        super(adTools, adUnitData, listener, null, 8, null);
        String format;
        int b;
        Intrinsics.checkNotNullParameter(adTools, "adTools");
        Intrinsics.checkNotNullParameter(adUnitData, "adUnitData");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Placement g = g();
        IronLog.INTERNAL.verbose("placement = " + g);
        if (g == null || TextUtils.isEmpty(g.getPlacementName())) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            format = String.format("can't load native ad - %s", Arrays.copyOf(new Object[]{g == null ? "placement is null" : "placement name is empty"}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            b = C3408z0.b(adUnitData.b().a());
        } else {
            format = null;
            b = 510;
        }
        if (format != null) {
            IronLog.API.error(a(format));
            a(b, format);
        }
    }

    @Override // com.ironsource.AbstractC3222o0
    protected C a() {
        return new C() { // from class: com.ironsource.Nb$$ExternalSyntheticLambda0
            @Override // com.ironsource.C
            public final AbstractC3407z a(A a2, G g) {
                AbstractC3407z a3;
                a3 = Nb.a(Nb.this, a2, g);
                return a3;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AbstractC3407z a(Nb this$0, A adInstanceData, G adInstancePayload) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adInstanceData, "adInstanceData");
        Intrinsics.checkNotNullParameter(adInstancePayload, "adInstancePayload");
        return new Fb(new V0(this$0.f(), D0.b.PROVIDER), adInstanceData, adInstancePayload, new AbstractC3222o0.a());
    }
}
