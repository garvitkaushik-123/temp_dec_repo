package com.bytedance.sdk.openadsdk.core;

import com.bytedance.sdk.component.embedapplog.IDefaultEncrypt;
import com.bytedance.sdk.component.embedapplog.PangleEncryptConstant;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Vy implements IDefaultEncrypt {
    private final PangleEncryptConstant.CryptDataScene eli;

    public Vy(PangleEncryptConstant.CryptDataScene cryptDataScene) {
        this.eli = cryptDataScene;
    }

    @Override // com.bytedance.sdk.component.embedapplog.IDefaultEncrypt
    public JSONObject encrypt(JSONObject jSONObject, int i) {
        gG.eli(1, this.eli, i);
        return com.bytedance.sdk.component.utils.eli.eli(jSONObject);
    }
}
