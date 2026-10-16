package com.vungle.ads.internal.omsdk;

import android.util.Base64;
import android.view.View;
import com.iab.omid.library.vungle.Omid;
import com.iab.omid.library.vungle.adsession.AdEvents;
import com.iab.omid.library.vungle.adsession.AdSession;
import com.iab.omid.library.vungle.adsession.AdSessionConfiguration;
import com.iab.omid.library.vungle.adsession.AdSessionContext;
import com.iab.omid.library.vungle.adsession.CreativeType;
import com.iab.omid.library.vungle.adsession.ImpressionType;
import com.iab.omid.library.vungle.adsession.Owner;
import com.iab.omid.library.vungle.adsession.Partner;
import com.iab.omid.library.vungle.adsession.VerificationScriptResource;
import com.mbridge.msdk.MBridgeConstans;
import com.vungle.ads.BuildConfig;
import com.vungle.ads.internal.model.OmSdkData;
import com.vungle.ads.internal.util.Logger;
import java.net.URL;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.Charsets;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;

/* compiled from: NativeOMTracker.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\rR\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/vungle/ads/internal/omsdk/NativeOMTracker;", "", "omSdkData", "", "omSdkJS", "(Ljava/lang/String;Ljava/lang/String;)V", "adEvents", "Lcom/iab/omid/library/vungle/adsession/AdEvents;", "adSession", "Lcom/iab/omid/library/vungle/adsession/AdSession;", "json", "Lkotlinx/serialization/json/Json;", "impressionOccurred", "", "start", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "Landroid/view/View;", "stop", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes7.dex */
public final class NativeOMTracker {
    private AdEvents adEvents;
    private AdSession adSession;
    private final Json json;

    public NativeOMTracker(String omSdkData, String omSdkJS) {
        OmSdkData omSdkData2;
        Intrinsics.checkNotNullParameter(omSdkData, "omSdkData");
        Intrinsics.checkNotNullParameter(omSdkJS, "omSdkJS");
        Json Json$default = JsonKt.Json$default(null, new Function1<JsonBuilder, Unit>() { // from class: com.vungle.ads.internal.omsdk.NativeOMTracker$json$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(JsonBuilder jsonBuilder) {
                invoke2(jsonBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(JsonBuilder Json) {
                Intrinsics.checkNotNullParameter(Json, "$this$Json");
                Json.setIgnoreUnknownKeys(true);
                Json.setEncodeDefaults(true);
                Json.setExplicitNulls(false);
            }
        }, 1, null);
        this.json = Json$default;
        try {
            AdSessionConfiguration createAdSessionConfiguration = AdSessionConfiguration.createAdSessionConfiguration(CreativeType.NATIVE_DISPLAY, ImpressionType.BEGIN_TO_RENDER, Owner.NATIVE, Owner.NONE, false);
            Partner createPartner = Partner.createPartner(BuildConfig.OMSDK_PARTNER_NAME, BuildConfig.VERSION_NAME);
            byte[] decode = Base64.decode(omSdkData, 0);
            if (decode != null) {
                String str = new String(decode, Charsets.UTF_8);
                Json json = Json$default;
                KSerializer<Object> serializer = SerializersKt.serializer(json.getSerializersModule(), Reflection.typeOf(OmSdkData.class));
                Intrinsics.checkNotNull(serializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                omSdkData2 = (OmSdkData) json.decodeFromString(serializer, str);
            } else {
                omSdkData2 = null;
            }
            VerificationScriptResource verificationScriptResource = VerificationScriptResource.createVerificationScriptResourceWithParameters(omSdkData2 != null ? omSdkData2.getVendorKey() : null, new URL(omSdkData2 != null ? omSdkData2.getVendorURL() : null), omSdkData2 != null ? omSdkData2.getParams() : null);
            Intrinsics.checkNotNullExpressionValue(verificationScriptResource, "verificationScriptResource");
            this.adSession = AdSession.createAdSession(createAdSessionConfiguration, AdSessionContext.createNativeAdSessionContext(createPartner, omSdkJS, CollectionsKt.listOf(verificationScriptResource), null, null));
        } catch (Exception e) {
            Logger.INSTANCE.e("NativeOMTracker", "error occured when create omsdk adSession:", e);
        }
    }

    public final void start(View view) {
        AdSession adSession;
        Intrinsics.checkNotNullParameter(view, "view");
        if (!Omid.isActive() || (adSession = this.adSession) == null) {
            return;
        }
        adSession.registerAdView(view);
        adSession.start();
        AdEvents createAdEvents = AdEvents.createAdEvents(adSession);
        this.adEvents = createAdEvents;
        if (createAdEvents != null) {
            createAdEvents.loaded();
        }
    }

    public final void stop() {
        AdSession adSession = this.adSession;
        if (adSession != null) {
            adSession.finish();
        }
        this.adSession = null;
    }

    public final void impressionOccurred() {
        AdEvents adEvents = this.adEvents;
        if (adEvents != null) {
            adEvents.impressionOccurred();
        }
    }
}
