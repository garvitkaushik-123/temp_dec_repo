package com.ironsource;

import android.text.TextUtils;
import com.ironsource.AbstractC3242p3;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.IronSourceSegment;
import com.ironsource.mediationsdk.ads.nativead.internal.InternalNativeAdListener;
import com.ironsource.mediationsdk.adunit.adapter.internal.BaseAdAdapter;
import com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdListener;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public final class Ib extends AbstractC3242p3<Mb, AdapterAdListener> implements Q0 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Ib(List<? extends NetworkSettings> list, C3419zb configs, String str, Z9 publisherDataHolder, IronSourceSegment ironSourceSegment) {
        super(new Jb(str, list, configs), publisherDataHolder, ironSourceSegment);
        Intrinsics.checkNotNullParameter(configs, "configs");
        Intrinsics.checkNotNullParameter(publisherDataHolder, "publisherDataHolder");
    }

    @Override // com.ironsource.AbstractC3242p3
    protected void G() {
    }

    @Override // com.ironsource.AbstractC3242p3
    protected boolean H() {
        return false;
    }

    public final void M() {
        Mf mf;
        int intValue;
        C3115hb c3115hb;
        IronLog.INTERNAL.verbose();
        try {
            Mb mb = (Mb) this.f3628a.d();
            if (mb != null) {
                Integer r = mb.r();
                if (r == null) {
                    intValue = this.C.a(this.o.b());
                } else {
                    Intrinsics.checkNotNullExpressionValue(r, "it.sessionDepth ?: sessi…epth(mManagerData.adUnit)");
                    intValue = r.intValue();
                }
                D0 d0 = this.s;
                if (d0 != null && (c3115hb = d0.f) != null) {
                    c3115hb.a(intValue);
                }
                mb.P();
                this.f3628a.a(null);
                this.f3628a.b(null);
            }
            this.i = null;
            a(AbstractC3242p3.f.NONE);
        } catch (Throwable th) {
            C3260q4.d().a(th);
            String str = "destroyNativeAd - exception = " + th.getLocalizedMessage();
            IronLog.INTERNAL.error(b(str));
            D0 d02 = this.s;
            if (d02 == null || (mf = d02.j) == null) {
                return;
            }
            mf.g(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ironsource.AbstractC3242p3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Mb a(NetworkSettings providerSettings, BaseAdAdapter<?, AdapterAdListener> adapter, int i, String currentAuctionId, C3207n2 item) {
        Intrinsics.checkNotNullParameter(providerSettings, "providerSettings");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(currentAuctionId, "currentAuctionId");
        Intrinsics.checkNotNullParameter(item, "item");
        return new Mb(this, new C3171l0(IronSource.AD_UNIT.NATIVE_AD, this.o.o(), i, this.g, currentAuctionId, this.e, this.f, providerSettings, this.o.n()), adapter, this.i, item, this);
    }

    @Override // com.ironsource.AbstractC3242p3
    protected K0 g() {
        return new C3142j5();
    }

    @Override // com.ironsource.AbstractC3242p3
    protected String l() {
        return "NA";
    }

    @Override // com.ironsource.AbstractC3242p3
    protected String o() {
        return IronSourceConstants.OPW_NT_MANAGER_NAME;
    }

    @Override // com.ironsource.AbstractC3242p3
    protected boolean v() {
        return false;
    }

    public final void a(Placement placement) {
        String format;
        int b;
        IronLog.INTERNAL.verbose("placement = " + placement);
        if (placement == null || TextUtils.isEmpty(placement.getPlacementName())) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            format = String.format("can't load native ad - %s", Arrays.copyOf(new Object[]{placement == null ? "placement is null" : "placement name is empty"}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            b = C3408z0.b(this.o.b());
        } else if (this.E.c(ContextProvider.getInstance().getApplicationContext(), placement, this.o.b())) {
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            format = String.format("placement %s is capped", Arrays.copyOf(new Object[]{placement.getPlacementName()}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            b = C3408z0.f(this.o.b());
        } else {
            format = null;
            b = 510;
        }
        if (TextUtils.isEmpty(format)) {
            this.i = placement;
            A();
        } else {
            IronLog.API.error(b(format));
            a(b, format, false);
        }
    }

    @Override // com.ironsource.AbstractC3242p3
    protected JSONObject b(NetworkSettings providerSettings) {
        Intrinsics.checkNotNullParameter(providerSettings, "providerSettings");
        JSONObject nativeAdSettings = providerSettings.getNativeAdSettings();
        Intrinsics.checkNotNullExpressionValue(nativeAdSettings, "providerSettings.nativeAdSettings");
        return nativeAdSettings;
    }

    public final void a(InternalNativeAdListener nativeAdListener) {
        Intrinsics.checkNotNullParameter(nativeAdListener, "nativeAdListener");
        a(new Hb(nativeAdListener));
    }

    @Override // com.ironsource.AbstractC3242p3
    protected void a(AbstractC3292s3<?> abstractC3292s3, AdInfo adInfo) {
        if (abstractC3292s3 instanceof Mb) {
            Mb mb = (Mb) abstractC3292s3;
            this.t.a(mb.Q(), mb.R(), adInfo);
        }
    }

    @Override // com.ironsource.AbstractC3242p3
    protected void a(IronSourceError ironSourceError) {
        this.t.a(ironSourceError);
    }

    @Override // com.ironsource.AbstractC3242p3, com.ironsource.C0
    public Map<String, Object> a(A0 event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Map<String, Object> data = super.a(event);
        Placement placement = this.i;
        if (placement != null) {
            Intrinsics.checkNotNullExpressionValue(data, "data");
            data.put("placement", placement.getPlacementName());
        }
        UUID uuid = this.w;
        if (uuid != null) {
            Intrinsics.checkNotNullExpressionValue(data, "data");
            data.put("objectId", uuid);
        }
        Intrinsics.checkNotNullExpressionValue(data, "data");
        return data;
    }
}
