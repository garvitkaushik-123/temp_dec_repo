package io.bidmachine.analytics.internal;

import android.content.Context;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.impressionData.ImpressionData;
import com.ironsource.mediationsdk.impressionData.ImpressionDataListener;
import io.bidmachine.analytics.internal.AbstractC3565e;
import io.bidmachine.analytics.internal.AbstractC3567g;
import io.bidmachine.analytics.internal.q0;
import java.util.Locale;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public final class A extends AbstractC3565e {
    public static final a j = new a(null);
    private final String h = "isimp";
    private b i;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private a() {
        }
    }

    public static final class b implements ImpressionDataListener {

        /* renamed from: a, reason: collision with root package name */
        private final InterfaceC3566f f6652a;

        public b(InterfaceC3566f interfaceC3566f) {
            this.f6652a = interfaceC3566f;
        }

        @Override // com.ironsource.mediationsdk.impressionData.ImpressionDataListener
        public void onImpressionSuccess(ImpressionData impressionData) {
            if (impressionData == null) {
                return;
            }
            try {
                Result.Companion companion = Result.INSTANCE;
                JSONObject allData = impressionData.getAllData();
                if (allData == null || allData.length() <= 0) {
                    this.f6652a.a(new q0("isimp", q0.a.MONITOR_NO_CONTENT, null, 4, null));
                    return;
                }
                try {
                    this.f6652a.a(s0.a(allData));
                } catch (Throwable th) {
                    this.f6652a.a(new q0("isimp", q0.a.MONITOR_BAD_CONTENT, s0.a(th)));
                }
                Result.m10241constructorimpl(Unit.INSTANCE);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m10241constructorimpl(ResultKt.createFailure(th2));
            }
        }
    }

    @Override // io.bidmachine.analytics.internal.AbstractC3570j
    public String a() {
        return this.h;
    }

    @Override // io.bidmachine.analytics.internal.AbstractC3565e
    public AbstractC3565e.a c(Map map) {
        String obj;
        String upperCase;
        Object obj2 = map.get("adFormat");
        if (obj2 == null || (obj = obj2.toString()) == null || (upperCase = obj.toUpperCase(Locale.US)) == null) {
            return null;
        }
        int hashCode = upperCase.hashCode();
        if (hashCode != -1466654086) {
            if (hashCode != -1372958932) {
                if (hashCode != 1666382058) {
                    if (hashCode == 1951953708 && upperCase.equals("BANNER")) {
                        return AbstractC3565e.a.BANNER;
                    }
                } else if (upperCase.equals("REWARDED_VIDEO")) {
                    return AbstractC3565e.a.REWARDED;
                }
            } else if (upperCase.equals("INTERSTITIAL")) {
                return AbstractC3565e.a.INTERSTITIAL;
            }
        } else if (upperCase.equals("NATIVEAD")) {
            return AbstractC3565e.a.NATIVE;
        }
        return null;
    }

    @Override // io.bidmachine.analytics.internal.AbstractC3570j
    public void d(Context context) {
    }

    @Override // io.bidmachine.analytics.internal.AbstractC3570j
    public void e(Context context) {
        b bVar = this.i;
        if (bVar != null) {
            IronSource.removeImpressionDataListener(bVar);
        }
    }

    @Override // io.bidmachine.analytics.internal.AbstractC3565e, io.bidmachine.analytics.internal.AbstractC3570j
    public void f(Context context) {
        super.f(context);
        b bVar = this.i;
        if (bVar != null) {
            IronSource.addImpressionDataListener(bVar);
        }
    }

    @Override // io.bidmachine.analytics.internal.AbstractC3570j
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(AbstractC3567g.a aVar) {
        super.b(aVar);
        this.i = new b(this);
    }

    @Override // io.bidmachine.analytics.internal.AbstractC3565e
    public AbstractC3565e.b b(Map map) {
        String obj;
        Float a2 = a0.a(map.get("revenue"));
        if (a2 != null) {
            float floatValue = a2.floatValue();
            Object obj2 = map.get("adNetwork");
            if (obj2 != null && (obj = obj2.toString()) != null) {
                return new AbstractC3565e.b(0, floatValue, obj, 1, null);
            }
        }
        return null;
    }
}
