package com.applovin.impl.sdk;

import android.os.Bundle;
import android.view.View;
import androidx.autofill.HintConstants;
import com.applovin.communicator.AppLovinCommunicator;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorPublisher;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.impl.a3;
import com.applovin.impl.b6;
import com.applovin.impl.b8;
import com.applovin.impl.communicator.CommunicatorMessageImpl;
import com.applovin.impl.e3;
import com.applovin.impl.e7;
import com.applovin.impl.g5;
import com.applovin.impl.k7;
import com.applovin.impl.n0;
import com.applovin.impl.sdk.network.d;
import com.applovin.impl.sdk.utils.BundleUtils;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.t3;
import com.applovin.impl.v2;
import com.applovin.impl.v4;
import com.applovin.impl.y2;
import com.applovin.impl.z2;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.AppLovinWebViewActivity;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.ironsource.C3040d4;
import com.ironsource.C3337ue;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import io.adn.sdk.internal.data.repository.BidTokenRepositoryKt;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class j implements AppLovinCommunicatorSubscriber, AppLovinCommunicatorPublisher {

    /* renamed from: a, reason: collision with root package name */
    private final k f694a;
    private final AppLovinCommunicator b;

    j(k kVar) {
        this.f694a = kVar;
        AppLovinCommunicator appLovinCommunicator = AppLovinCommunicator.getInstance(k.o());
        this.b = appLovinCommunicator;
        if (((Boolean) kVar.a(v4.b7)).booleanValue()) {
            appLovinCommunicator.a(kVar);
            appLovinCommunicator.subscribe(this, e7.f446a);
        }
    }

    public void a(JSONObject jSONObject, boolean z) {
        if (b("safedk_init") && com.applovin.impl.j.c()) {
            Bundle bundle = new Bundle();
            bundle.putString(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.f694a.j0());
            bundle.putString("applovin_random_token", this.f694a.i0());
            bundle.putString("compass_random_token", this.f694a.v());
            bundle.putString("device_type", AppLovinSdkUtils.isTablet(k.o()) ? "tablet" : HintConstants.AUTOFILL_HINT_PHONE);
            bundle.putString("init_success", String.valueOf(z));
            bundle.putParcelableArrayList("installed_mediation_adapters", JsonUtils.toBundle(t3.b(this.f694a)));
            JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONObject, "communicator_settings", (JSONObject) null);
            Bundle bundle2 = (Bundle) bundle.clone();
            bundle2.putString("user_id", this.f694a.x0().e());
            JSONObject jSONObject3 = JsonUtils.getJSONObject(jSONObject2, "safedk_settings", new JSONObject());
            if (!((Boolean) this.f694a.a(v4.c7)).booleanValue()) {
                JSONObject jSONObject4 = new JSONObject();
                JsonUtils.putBoolean(jSONObject4, "deactivated", true);
                JsonUtils.putJSONObject(jSONObject3, "safeDKDeactivation", jSONObject4);
            }
            bundle2.putBundle("settings", JsonUtils.toBundle(jSONObject3));
            this.f694a.O();
            if (o.a()) {
                this.f694a.O().a("CommunicatorService", "Sending \"safedk_init\" message: " + bundle);
            }
            a(bundle2, "safedk_init");
        }
    }

    public void b(String str, String str2) {
        if (b("user_info") && com.applovin.impl.j.c()) {
            Bundle bundle = new Bundle(2);
            bundle.putString("user_id", StringUtils.emptyIfNull(str));
            bundle.putString("applovin_random_token", str2);
            a(bundle, "user_info");
        }
    }

    @Override // com.applovin.communicator.AppLovinCommunicatorEntity
    public String getCommunicatorId() {
        return "applovin_sdk";
    }

    @Override // com.applovin.communicator.AppLovinCommunicatorSubscriber
    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        Map<String, Object> map;
        long j;
        int i;
        long j2;
        Map<String, Object> map2;
        if (((Boolean) this.f694a.a(v4.b7)).booleanValue()) {
            if ("send_http_request".equalsIgnoreCase(appLovinCommunicatorMessage.getTopic())) {
                Bundle messageData = appLovinCommunicatorMessage.getMessageData();
                Map<String, String> stringMap = BundleUtils.toStringMap(messageData.getBundle("query_params"));
                Map<String, Object> map3 = BundleUtils.toMap(messageData.getBundle("post_body"));
                Map<String, String> stringMap2 = BundleUtils.toStringMap(messageData.getBundle("headers"));
                String string = messageData.getString("id", "");
                if (!map3.containsKey(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY)) {
                    map3.put(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.f694a.j0());
                }
                this.f694a.f0().e(new d.b().d(messageData.getString("url")).a(messageData.getString("backup_url")).b(stringMap).c(map3).a(stringMap2).a(((Boolean) this.f694a.a(v4.a5)).booleanValue()).b(string).a());
                return;
            }
            if (!"send_http_request_v2".equalsIgnoreCase(appLovinCommunicatorMessage.getTopic())) {
                if ("set_ad_request_query_params".equalsIgnoreCase(appLovinCommunicatorMessage.getTopic())) {
                    this.f694a.k().addCustomQueryParams(k7.a((Map) BundleUtils.toMap(appLovinCommunicatorMessage.getMessageData())));
                    return;
                } else if ("set_ad_request_post_body".equalsIgnoreCase(appLovinCommunicatorMessage.getTopic())) {
                    this.f694a.k().setCustomPostBody(BundleUtils.toJSONObject(appLovinCommunicatorMessage.getMessageData()));
                    return;
                } else {
                    if ("set_mediate_request_post_body_data".equalsIgnoreCase(appLovinCommunicatorMessage.getTopic())) {
                        this.f694a.X().setCustomPostBodyData(BundleUtils.toJSONObject(appLovinCommunicatorMessage.getMessageData()));
                        return;
                    }
                    return;
                }
            }
            Bundle messageData2 = appLovinCommunicatorMessage.getMessageData();
            String string2 = messageData2.getString("http_method", "POST");
            long millis = messageData2.containsKey("timeout_sec") ? TimeUnit.SECONDS.toMillis(messageData2.getLong("timeout_sec")) : ((Long) this.f694a.a(v4.h3)).longValue();
            int i2 = messageData2.getInt("retry_count", ((Integer) this.f694a.a(v4.i3)).intValue());
            long millis2 = messageData2.containsKey("retry_delay_sec") ? TimeUnit.SECONDS.toMillis(messageData2.getLong("retry_delay_sec")) : ((Long) this.f694a.a(v4.j3)).longValue();
            Map<String, String> stringMap3 = BundleUtils.toStringMap(messageData2.getBundle("query_params"));
            if ("GET".equalsIgnoreCase(string2)) {
                if (messageData2.getBoolean("include_data_collector_info", true)) {
                    map2 = null;
                    stringMap3.putAll(BundleUtils.toStringMap(CollectionUtils.toBundle(this.f694a.B().a((Map) null, false, false))));
                } else {
                    map2 = null;
                }
                j = millis;
                i = i2;
                j2 = millis2;
                map = map2;
            } else {
                map = BundleUtils.toMap(messageData2.getBundle("post_body"));
                if (messageData2.getBoolean("include_data_collector_info", true)) {
                    Map E = this.f694a.B().E();
                    Map o = this.f694a.B().o();
                    j2 = millis2;
                    if (o.containsKey("idfv") && o.containsKey("idfv_scope")) {
                        i = i2;
                        String str = (String) o.get("idfv");
                        j = millis;
                        Integer num = (Integer) o.get("idfv_scope");
                        num.intValue();
                        o.remove("idfv");
                        o.remove("idfv_scope");
                        E.put("idfv", str);
                        E.put("idfv_scope", num);
                    } else {
                        j = millis;
                        i = i2;
                    }
                    E.put("server_installed_at", this.f694a.a(v4.o));
                    E.put(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.f694a.j0());
                    map.put(MBridgeConstans.DYNAMIC_VIEW_WX_APP, E);
                    map.put(C3040d4.h.G, o);
                } else {
                    j = millis;
                    i = i2;
                    j2 = millis2;
                }
            }
            this.f694a.r0().a((g5) new n0(appLovinCommunicatorMessage.getPublisherId(), com.applovin.impl.sdk.network.a.a(this.f694a).b(messageData2.getString("url")).a(messageData2.getString("backup_url")).b(stringMap3).c(string2).a((Map) BundleUtils.toStringMap(messageData2.getBundle("headers"))).a(map != null ? new JSONObject(map) : null).c((int) j).a(i).b((int) j2).a((Object) new JSONObject()).a(messageData2.getBoolean("is_encoding_enabled", false)).a(), this.f694a), b6.b.OTHER);
        }
    }

    public void b(v2 v2Var, String str) {
        if (b("max_ad_events")) {
            Bundle a2 = a(v2Var);
            a2.putString("type", str);
            this.f694a.O();
            if (o.a()) {
                this.f694a.O().a("CommunicatorService", "Sending \"max_ad_events\" message: " + a2);
            }
            a(a2, "max_ad_events");
        }
    }

    public void b(v2 v2Var) {
        if (b(com.moloco.sdk.internal.ilrd.provider.a.k)) {
            Bundle a2 = a(v2Var);
            a2.putAll(JsonUtils.toBundle(v2Var.O()));
            a2.putString("country_code", this.f694a.w().getCountryCode());
            a(a2, com.moloco.sdk.internal.ilrd.provider.a.k);
        }
    }

    public void b(List list) {
        if (b("test_mode_networks_updated")) {
            if (list == null || list.isEmpty()) {
                a(Bundle.EMPTY, "test_mode_networks_updated");
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("test_mode_networks", new ArrayList<>(list));
            a(bundle, "test_mode_networks_updated");
        }
    }

    public void a(v2 v2Var, String str) {
        if (b("ad_callback_blocked_after_hidden")) {
            Bundle a2 = a(v2Var);
            a2.putString("callback_name", str);
            a(a2, "ad_callback_blocked_after_hidden");
        }
    }

    private boolean b(String str) {
        if (((Boolean) this.f694a.a(v4.b7)).booleanValue()) {
            return this.f694a.c(v4.a7).contains(str) || this.b.hasSubscriber(str);
        }
        return false;
    }

    public void a(MaxAdapter.InitializationStatus initializationStatus, String str) {
        if (b("adapter_initialization_status")) {
            Bundle bundle = new Bundle();
            bundle.putString("adapter_class", str);
            bundle.putInt("init_status", initializationStatus.getCode());
            a(bundle, "adapter_initialization_status");
        }
    }

    public void a() {
        if (b("privacy_setting_updated")) {
            a(new Bundle(), "privacy_setting_updated");
        }
    }

    public void a(String str, String str2) {
        if (b("network_sdk_version_updated")) {
            Bundle bundle = new Bundle();
            bundle.putString("adapter_class", str2);
            bundle.putString(BidTokenRepositoryKt.SDK_VERSION, str);
            a(bundle, "network_sdk_version_updated");
        }
    }

    public void a(List list) {
        if (b("live_networks_updated")) {
            if (list == null || list.isEmpty()) {
                a(Bundle.EMPTY, "live_networks_updated");
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("live_networks", new ArrayList<>(list));
            a(bundle, "live_networks_updated");
        }
    }

    public void a(String str, String str2, String str3) {
        if (b("responses")) {
            String maybeConvertToIndentedString = JsonUtils.maybeConvertToIndentedString(str3, 2);
            String maybeConvertToIndentedString2 = JsonUtils.maybeConvertToIndentedString(str, 2);
            Bundle bundle = new Bundle();
            bundle.putString("request_url", str2);
            bundle.putString("request_body", maybeConvertToIndentedString);
            bundle.putString(C3337ue.n, maybeConvertToIndentedString2);
            a(bundle, "responses");
        }
    }

    public void a(String str, String str2, int i, Object obj, String str3, boolean z) {
        if (b("receive_http_response")) {
            Bundle bundle = new Bundle();
            bundle.putString("id", str);
            bundle.putString("url", str2);
            bundle.putInt("code", i);
            bundle.putBundle("body", JsonUtils.toBundle(obj));
            bundle.putBoolean("success", z);
            BundleUtils.putString("error_message", str3, bundle);
            a(bundle, "receive_http_response");
        }
    }

    public void a(Bundle bundle, String str) {
        if (b(str)) {
            this.b.getMessagingService().publish(CommunicatorMessageImpl.create(bundle, str, this, this.f694a.c(v4.a7).contains(str)));
        }
    }

    public boolean a(String str) {
        return e7.f446a.contains(str);
    }

    private Bundle a(v2 v2Var) {
        View view;
        Bundle bundle = new Bundle();
        bundle.putString("id", v2Var.P());
        bundle.putString("network_name", v2Var.c());
        bundle.putString("max_ad_unit_id", v2Var.getAdUnitId());
        bundle.putString("third_party_ad_placement_id", v2Var.Q());
        bundle.putString(FirebaseAnalytics.Param.AD_FORMAT, v2Var.getFormat().getLabel());
        BundleUtils.putStringIfValid(CampaignEx.JSON_KEY_CREATIVE_ID, v2Var.getCreativeId(), bundle);
        BundleUtils.putStringIfValid("adomain", v2Var.v(), bundle);
        BundleUtils.putStringIfValid("dsp_name", v2Var.getDspName(), bundle);
        if ("CUSTOM_NETWORK_SDK".equalsIgnoreCase(v2Var.c())) {
            bundle.putString("custom_sdk_network_name", v2Var.getNetworkName());
        }
        bundle.putAll(JsonUtils.toBundle(v2Var.x()));
        if (v2Var instanceof e3) {
            if (v2Var instanceof y2) {
                view = ((y2) v2Var).y();
            } else {
                if (v2Var instanceof a3) {
                    a3 a3Var = (a3) v2Var;
                    if (!a3Var.r0()) {
                        view = a3Var.m0() != null ? a3Var.m0() : a3Var.n0();
                    }
                }
                view = null;
            }
            bundle.putString("ad_view", view != null ? b8.a(view) : "N/A");
            return bundle;
        }
        if (v2Var instanceof z2) {
            Bundle bundle2 = ((z2) v2Var).k0().getBundle("applovin_ad_view_info");
            bundle.putString("ad_view", BundleUtils.getString("ad_view_address", "N/A", bundle2));
            bundle.putString("video_view", BundleUtils.getString("video_view_address", "N/A", bundle2));
        }
        return bundle;
    }
}
