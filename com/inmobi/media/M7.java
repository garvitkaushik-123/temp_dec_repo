package com.inmobi.media;

import android.content.Context;
import android.content.Intent;
import android.util.SparseArray;
import com.inmobi.ads.rendering.InMobiAdActivity;
import com.inmobi.commons.core.configs.AdConfig;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class M7 extends G1 {
    public final /* synthetic */ T7 d;
    public final /* synthetic */ T7 e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public M7(T7 t7, T7 t72) {
        super(t7);
        this.d = t7;
        this.e = t72;
    }

    @Override // com.inmobi.media.G1
    public final void a() {
        JSONObject e;
        T7 t7 = this.d;
        if (t7.C == null) {
            InterfaceC2971z5 interfaceC2971z5 = t7.j;
            if (interfaceC2971z5 != null) {
                String TAG = t7.m;
                Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                ((A5) interfaceC2971z5).c(TAG, "prepareFullscreenContainer");
            }
            C2811p8 c2811p8 = t7.b;
            JSONArray jSONArray = c2811p8.f;
            if (jSONArray != null && !B2.a(jSONArray) && (e = c2811p8.e()) != null) {
                C2811p8 dataModel = new C2811p8(t7.f2437a, e, c2811p8, t7.f2437a == 0, t7.s, t7.j);
                dataModel.q = c2811p8.q;
                Context context = (Context) t7.x.get();
                if (dataModel.f() && context != null) {
                    String adImpressionId = t7.getImpressionId();
                    Set set = t7.d;
                    AdConfig adConfig = t7.s;
                    long j = t7.e;
                    boolean z = t7.f;
                    String creativeId = t7.getCreativeId();
                    S6 s6 = t7.i;
                    InterfaceC2971z5 interfaceC2971z52 = t7.j;
                    Intrinsics.checkNotNullParameter(context, "context");
                    Intrinsics.checkNotNullParameter(dataModel, "dataModel");
                    Intrinsics.checkNotNullParameter(adImpressionId, "adImpressionId");
                    Intrinsics.checkNotNullParameter(adConfig, "adConfig");
                    Intrinsics.checkNotNullParameter(creativeId, "creativeId");
                    T7 c2562a9 = dataModel.c().contains("VIDEO") ? new C2562a9(context, (byte) 0, dataModel, adImpressionId, set, adConfig, j, z, creativeId, null, s6, interfaceC2971z52) : new T7(context, (byte) 0, dataModel, adImpressionId, set, adConfig, j, z, creativeId, null, s6, interfaceC2971z52);
                    t7.C = c2562a9;
                    c2562a9.v = t7;
                    P0 p0 = t7.w;
                    if (p0 != null) {
                        c2562a9.w = p0;
                    }
                }
            }
        }
        T7 container = this.d.C;
        if (container != null) {
            SparseArray sparseArray = InMobiAdActivity.k;
            Intrinsics.checkNotNullParameter(container, "container");
            int hashCode = container.hashCode();
            InMobiAdActivity.k.put(hashCode, container);
            Intent intent = new Intent((Context) this.d.x.get(), (Class<?>) InMobiAdActivity.class);
            intent.putExtra("com.inmobi.ads.rendering.InMobiAdActivity.EXTRA_AD_CONTAINER_INDEX", hashCode);
            intent.putExtra("com.inmobi.ads.rendering.InMobiAdActivity.EXTRA_AD_ACTIVITY_TYPE", 102);
            intent.putExtra("com.inmobi.ads.rendering.InMobiAdActivity.EXTRA_AD_ACTIVITY_IS_FULL_SCREEN", true);
            intent.putExtra("com.inmobi.ads.rendering.InMobiAdActivity.EXTRA_AD_CONTAINER_TYPE", 201);
            Context context2 = (Context) this.d.x.get();
            T7 t72 = this.d;
            if (t72.D) {
                t72.G = intent;
            } else if (context2 != null) {
                Uc.f2453a.a(context2, intent);
            }
        }
    }

    @Override // com.inmobi.media.G1
    public final void c() {
        super.c();
        P0 p0 = this.e.w;
        if (p0 != null) {
            p0.c();
        }
    }
}
