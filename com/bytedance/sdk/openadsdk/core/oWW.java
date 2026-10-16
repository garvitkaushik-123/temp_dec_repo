package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.component.embedapplog.PangleEncryptConstant;
import com.bytedance.sdk.component.embedapplog.PangleEncryptManager;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerSize;
import com.bytedance.sdk.openadsdk.api.bidding.PAGBiddingRequest;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;
import com.bytedance.sdk.openadsdk.utils.SSo;
import com.bytedance.sdk.openadsdk.utils.dZ;
import com.ironsource.N6;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.pgl.ssdk.ces.out.PglSSConfig;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class oWW implements VM {
    private static final Map<Integer, String> Os = new HashMap<Integer, String>(12) { // from class: com.bytedance.sdk.openadsdk.core.oWW.1
        {
            put(1, "abtest");
            put(2, "user_data");
            put(3, "gaid");
            put(4, "apk-sign");
            put(5, "screen_scale");
            put(6, "app_set_id_scope");
            put(7, "app_set_id");
            put(8, "installed_source");
            put(9, "app_running_time");
            put(10, VastAttributes.VENDOR);
            put(11, N6.B);
            put(12, "user_agent_device");
            put(13, "user_agent_webview");
            put(14, "sys_compiling_time");
            put(15, "sec_did");
            put(16, "url");
            put(17, "X-Argus");
            put(18, "X-Ladon");
            put(19, "X-Khronos");
            put(20, "X-Gorgon");
            put(21, "pangle_m");
            put(22, "screen_height");
            put(23, "screen_width");
            put(24, "rom_version");
            put(25, "carrier_name");
            put(26, "os_version");
            put(27, "conn_type");
            put(28, "boot");
            put(29, "feature_data");
            put(30, "t_ver");
            put(31, CampaignEx.JSON_KEY_AAB);
            put(32, "w_ver");
            put(33, "is_fold");
            put(34, "abi");
            put(35, "is_multi");
        }
    };
    String eli = "com.union_test.internationad";
    String DbA = "8025677";
    private int aGH = 0;

    @Override // com.bytedance.sdk.openadsdk.core.VM
    /* renamed from: aGH, reason: merged with bridge method [inline-methods] */
    public oWW eli(String str) {
        FC.DbA().eli(str);
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.core.VM
    /* renamed from: ui, reason: merged with bridge method [inline-methods] */
    public oWW DbA(String str) {
        FC.DbA().Os(str);
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.core.VM
    public VM eli(int i) {
        FC.DbA().MGA(i);
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.core.VM
    public VM eli() {
        com.bytedance.sdk.component.utils.Dfc.eli("PangleSDK-7503");
        com.bykv.vk.openvk.eli.eli.eli.kb.Os.eli("PangleSDK-7503");
        com.bytedance.sdk.component.utils.Xb.eli("PangleSDK-7503");
        com.bytedance.sdk.component.utils.Dfc.DbA();
        com.bytedance.sdk.component.kb.eli.eli();
        com.bykv.vk.openvk.eli.eli.eli.kb.Os.eli();
        com.bytedance.sdk.component.utils.Xb.eli();
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.core.VM
    public VM DbA(int i) {
        FC.DbA().aGH(i);
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.core.VM
    public int DbA() {
        return FC.DbA().aAs();
    }

    @Override // com.bytedance.sdk.openadsdk.core.VM
    public VM ui(int i) {
        FC.DbA().ui(i);
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.core.VM
    public int ui() {
        return FC.DbA().du();
    }

    @Override // com.bytedance.sdk.openadsdk.core.VM
    public String Os() {
        return BuildConfig.VERSION_NAME;
    }

    /* JADX WARN: Code restructure failed: missing block: B:79:0x004a, code lost:
    
        if (com.bytedance.sdk.openadsdk.core.dV.aGH().KM(r5) == false) goto L18;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x005a A[Catch: all -> 0x02cf, TryCatch #0 {all -> 0x02cf, blocks: (B:3:0x000a, B:5:0x0017, B:7:0x001d, B:8:0x0023, B:10:0x0031, B:13:0x004c, B:16:0x0050, B:18:0x005a, B:20:0x005e, B:23:0x0082, B:24:0x0096, B:26:0x00b1, B:29:0x00d0, B:30:0x00bf, B:31:0x00d7, B:33:0x00ef, B:34:0x0106, B:36:0x0123, B:38:0x0130, B:39:0x0139, B:41:0x020a, B:42:0x021a, B:45:0x0236, B:47:0x0241, B:49:0x0253, B:51:0x0260, B:54:0x026e, B:56:0x0274, B:58:0x0281, B:60:0x0297, B:62:0x029d, B:63:0x02a0, B:66:0x02a8, B:67:0x02bf, B:73:0x00f5, B:75:0x0101, B:76:0x003c, B:78:0x0042), top: B:2:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005e A[Catch: all -> 0x02cf, TryCatch #0 {all -> 0x02cf, blocks: (B:3:0x000a, B:5:0x0017, B:7:0x001d, B:8:0x0023, B:10:0x0031, B:13:0x004c, B:16:0x0050, B:18:0x005a, B:20:0x005e, B:23:0x0082, B:24:0x0096, B:26:0x00b1, B:29:0x00d0, B:30:0x00bf, B:31:0x00d7, B:33:0x00ef, B:34:0x0106, B:36:0x0123, B:38:0x0130, B:39:0x0139, B:41:0x020a, B:42:0x021a, B:45:0x0236, B:47:0x0241, B:49:0x0253, B:51:0x0260, B:54:0x026e, B:56:0x0274, B:58:0x0281, B:60:0x0297, B:62:0x029d, B:63:0x02a0, B:66:0x02a8, B:67:0x02bf, B:73:0x00f5, B:75:0x0101, B:76:0x003c, B:78:0x0042), top: B:2:0x000a }] */
    @Override // com.bytedance.sdk.openadsdk.core.VM
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String eli(PAGBiddingRequest pAGBiddingRequest) {
        int i;
        try {
            dZ.aAs("getBiddingToken");
            com.bytedance.sdk.openadsdk.core.FC.Os.eli();
            MGA();
            String adxId = (pAGBiddingRequest == null || pAGBiddingRequest.getAdxId() == null) ? "" : pAGBiddingRequest.getAdxId();
            if (TextUtils.equals(adxId, FC.DbA().Vy())) {
                if (!dV.aGH().hg()) {
                    wC();
                    return "";
                }
                if (!FC.DbA().nlS()) {
                    wC();
                    return "";
                }
                JSONObject jSONObject = new JSONObject();
                boolean z = true;
                jSONObject.put("is_init", nn.ui() ? 1 : 0);
                String FC = dV.aGH().FC();
                String nGm = dV.aGH().nGm();
                if (FC != null && nGm != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("version", FC);
                    jSONObject2.put("param", nGm);
                    jSONObject.put("abtest", jSONObject2);
                }
                jSONObject.put("language", nlS.DbA());
                jSONObject.put("ad_sdk_version", BuildConfig.VERSION_NAME);
                jSONObject.put("package_name", dZ.MGA());
                if (pAGBiddingRequest != null) {
                    jSONObject.put("user_data", ev.eli(TextUtils.isEmpty(pAGBiddingRequest.getSlotId()) ? null : new AdSlot.Builder().setCodeId(pAGBiddingRequest.getSlotId()).build()));
                }
                jSONObject.put("ts", System.currentTimeMillis() / 1000);
                String DbA = com.bytedance.sdk.openadsdk.multipro.aGH.aGH.DbA("ttopenadsdk", PglSSConfig.CUSTOMINFO_KEY_IPV6, "");
                if (!DbA.isEmpty()) {
                    jSONObject.put("ipv6", DbA);
                } else {
                    String DbA2 = com.bytedance.sdk.openadsdk.multipro.aGH.aGH.DbA("ttopenadsdk", "key_ipv4", "");
                    if (!DbA2.isEmpty()) {
                        jSONObject.put("ipv4", DbA2);
                    }
                }
                jSONObject.put("adx_id", adxId);
                Object Bnk = dV.aGH().Bnk();
                jSONObject.put("target_region", Bnk);
                if (jSONObject.toString().getBytes().length <= 2680) {
                    com.bytedance.sdk.openadsdk.core.settings.MGA aGH = dV.aGH();
                    com.bytedance.sdk.openadsdk.QX.eli.DbA.eli.eli().eli(jSONObject);
                    if (pAGBiddingRequest != null) {
                        jSONObject.put("banner", DbA(pAGBiddingRequest));
                    }
                    jSONObject.put("app_reg", aGH.vb() ? 1 : 0);
                    Context eli = dV.eli();
                    jSONObject.put("apk-sign", com.bytedance.sdk.openadsdk.common.DbA.kb());
                    jSONObject.put("screen_scale", SSo.MGA(eli));
                    jSONObject.put("app_set_id_scope", com.bytedance.sdk.openadsdk.core.settings.aGH.DbA());
                    jSONObject.put("app_set_id", com.bytedance.sdk.openadsdk.core.settings.aGH.Os());
                    jSONObject.put("installed_source", com.bytedance.sdk.openadsdk.core.settings.aGH.aGH());
                    jSONObject.put("app_running_time", (System.currentTimeMillis() - nn.eli()) / 1000);
                    jSONObject.put("js_render_ver", com.bytedance.sdk.openadsdk.core.wC.nlS.DbA());
                    jSONObject.put("js_render_v3_ver", com.bytedance.sdk.openadsdk.core.wC.nlS.Os());
                    jSONObject.put("gp_v_name", DeviceUtils.ui(eli));
                    jSONObject.put("gp_v_code", DeviceUtils.MGA(eli));
                    jSONObject.put(VastAttributes.VENDOR, Build.MANUFACTURER);
                    jSONObject.put(N6.B, Build.MODEL);
                    jSONObject.put("user_agent_device", dZ.DbA());
                    jSONObject.put("user_agent_webview", dZ.aGH());
                    jSONObject.put("sys_compiling_time", nlS.DbA(eli));
                    jSONObject.put("screen_height", SSo.ui(eli));
                    jSONObject.put("screen_width", SSo.Os(eli));
                    jSONObject.put("rom_version", com.bytedance.sdk.openadsdk.utils.Ue.eli());
                    jSONObject.put("carrier_name", com.bytedance.sdk.openadsdk.utils.VM.eli());
                    jSONObject.put("os_version", Build.VERSION.RELEASE);
                    jSONObject.put("conn_type", dZ.wC(eli));
                    if (aGH.ujq("boot")) {
                        jSONObject.put("boot", String.valueOf(System.currentTimeMillis() - SystemClock.elapsedRealtime()));
                    }
                    dZ.eli(jSONObject);
                    com.bytedance.sdk.openadsdk.core.FC.Os.eli(jSONObject);
                    com.bytedance.sdk.openadsdk.utils.wC.eli(jSONObject, eli);
                    jSONObject.put("is_multi", com.bytedance.sdk.openadsdk.multipro.DbA.Os());
                    i = Os.size();
                } else {
                    i = 2;
                }
                while (i > 0 && jSONObject.toString().getBytes().length > 2680) {
                    jSONObject.remove(Os.get(Integer.valueOf(i)));
                    i--;
                }
                com.bytedance.sdk.openadsdk.MGA.DbA.eli().eli(jSONObject);
                if (!com.bytedance.sdk.openadsdk.core.settings.NU.CH() || !com.bytedance.sdk.openadsdk.core.settings.NU.nY().eli(PangleEncryptConstant.CryptDataScene.BIDDING_TOKEN)) {
                    z = false;
                }
                JSONObject eli2 = eli(jSONObject, z);
                while (i > 0 && eli2.toString().getBytes().length > 4096) {
                    jSONObject.remove(Os.get(Integer.valueOf(i)));
                    eli2 = eli(jSONObject, z);
                    i--;
                }
                if (eli2.length() > 0) {
                    eli2.put("target_region", Bnk);
                }
                if (com.bytedance.sdk.component.utils.Dfc.aGH()) {
                    new StringBuilder("bidding token: ").append(eli2).append("\nbidding token length: ");
                    int length = eli2.toString().getBytes().length;
                }
                new StringBuilder("bidding token: ").append(eli2);
                kb();
                return eli2.toString();
            }
            if (FC()) {
            }
            if (!FC.DbA().nlS()) {
            }
        } catch (Throwable unused) {
            wC();
            return "";
        }
    }

    private boolean FC() {
        return "TX".equals(com.bytedance.sdk.openadsdk.core.settings.NU.nY().Cp()) || TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.settings.NU.nY().Cp());
    }

    private JSONObject DbA(PAGBiddingRequest pAGBiddingRequest) {
        try {
            PAGBannerSize bannerSize = pAGBiddingRequest.getBannerSize();
            if (bannerSize != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("width", bannerSize.getWidth());
                if (bannerSize.getType() == 3) {
                    jSONObject.put("height", bannerSize.getMaxHeight());
                } else {
                    jSONObject.put("height", bannerSize.getHeight());
                }
                jSONObject.put("type", bannerSize.getType());
                return jSONObject;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    private JSONObject eli(JSONObject jSONObject, boolean z) {
        JSONObject eli;
        if (z) {
            eli = PangleEncryptManager.encryptType4(jSONObject, new Vy(PangleEncryptConstant.CryptDataScene.BIDDING_TOKEN));
            gG.eli(eli);
        } else {
            eli = com.bytedance.sdk.component.utils.eli.eli(jSONObject);
        }
        return eli != null ? eli : new JSONObject();
    }

    @Override // com.bytedance.sdk.openadsdk.core.VM
    public boolean eli(String str, int i, String str2, String str3, String str4) {
        if (!this.eli.equals(dV.eli().getPackageName()) || !this.DbA.equals(FC.DbA().aGH()) || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            com.bytedance.sdk.openadsdk.component.reward.aAs.eli(str, i, str2, str3, str4);
            return true;
        } catch (Throwable unused) {
            return true;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.VM
    public VM Os(int i) {
        this.aGH = i;
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.core.VM
    public int aGH() {
        return this.aGH;
    }

    @Override // com.bytedance.sdk.openadsdk.core.VM
    public VM aGH(int i) {
        FC.DbA().Os(i);
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.core.VM
    public VM Os(String str) {
        FC.DbA().wC(str);
        return this;
    }

    public static void MGA() {
        try {
            com.bytedance.sdk.openadsdk.dV.Os.eli(new com.bytedance.sdk.openadsdk.dV.aGH() { // from class: com.bytedance.sdk.openadsdk.core.oWW.2
                @Override // com.bytedance.sdk.openadsdk.dV.aGH
                public com.bytedance.sdk.openadsdk.dV.DbA.eli generatorModel() {
                    com.bytedance.sdk.openadsdk.dV.DbA.eli eliVar = new com.bytedance.sdk.openadsdk.dV.DbA.eli();
                    eliVar.DbA("bidding_token");
                    return eliVar;
                }
            });
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.Xb.Os("TTAdManagerImpl", th.getMessage());
        }
    }

    public static void kb() {
        try {
            com.bytedance.sdk.openadsdk.dV.Os.DbA(new com.bytedance.sdk.openadsdk.dV.aGH() { // from class: com.bytedance.sdk.openadsdk.core.oWW.3
                @Override // com.bytedance.sdk.openadsdk.dV.aGH
                public com.bytedance.sdk.openadsdk.dV.DbA.eli generatorModel() {
                    com.bytedance.sdk.openadsdk.dV.DbA.eli eliVar = new com.bytedance.sdk.openadsdk.dV.DbA.eli();
                    eliVar.DbA("bidding_token");
                    return eliVar;
                }
            });
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.Xb.Os("TTAdManagerImpl", th.getMessage());
        }
    }

    public static void wC() {
        try {
            com.bytedance.sdk.openadsdk.dV.Os.Os(new com.bytedance.sdk.openadsdk.dV.aGH() { // from class: com.bytedance.sdk.openadsdk.core.oWW.4
                @Override // com.bytedance.sdk.openadsdk.dV.aGH
                public com.bytedance.sdk.openadsdk.dV.DbA.eli generatorModel() {
                    com.bytedance.sdk.openadsdk.dV.DbA.eli eliVar = new com.bytedance.sdk.openadsdk.dV.DbA.eli();
                    eliVar.DbA("bidding_token");
                    return eliVar;
                }
            });
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.Xb.Os("TTAdManagerImpl", th.getMessage());
        }
    }
}
