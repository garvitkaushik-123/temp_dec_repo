package com.bytedance.sdk.openadsdk.FC;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.component.ui.aqO;
import com.bytedance.sdk.component.ui.du;
import com.bytedance.sdk.openadsdk.ApmHelper;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.utils.dZ;
import com.ironsource.Y1;
import com.ironsource.unity.androidbridge.AndroidBridgeConstants;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class DbA<T> implements aqO<T> {
    private final String DbA;
    private final aqO<T> Os;
    private final ev aGH;
    private final long eli = SystemClock.elapsedRealtime();

    public DbA(final ev evVar, String str, aqO<T> aqo) {
        this.Os = aqo;
        this.aGH = evVar;
        this.DbA = str;
        if (aGH.DbA()) {
            com.bytedance.sdk.openadsdk.dV.Os.eli(new com.bytedance.sdk.openadsdk.dV.aGH() { // from class: com.bytedance.sdk.openadsdk.FC.DbA.1
                @Override // com.bytedance.sdk.openadsdk.dV.aGH
                public com.bytedance.sdk.openadsdk.dV.DbA.eli generatorModel() {
                    com.bytedance.sdk.openadsdk.dV.DbA.eli eliVar = new com.bytedance.sdk.openadsdk.dV.DbA.eli();
                    eliVar.DbA("load_img");
                    ev evVar2 = evVar;
                    if (evVar2 != null) {
                        eliVar.Os(evVar2.oWW(Y1.f));
                        eliVar.aGH(dZ.Os(evVar.bBQ()));
                    }
                    eliVar.eli(BuildConfig.VERSION_NAME);
                    return eliVar;
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.ui.aqO
    public void eli(du<T> duVar) {
        aqO<T> aqo = this.Os;
        if (aqo != null) {
            aqo.eli(duVar);
        }
        if (this.aGH != null) {
            final long elapsedRealtime = SystemClock.elapsedRealtime() - this.eli;
            final int kb = duVar.kb() / 1024;
            final int i = duVar.MGA() ? 1 : 0;
            com.bytedance.sdk.openadsdk.Dfc.Os.eli("load_image_success", false, new com.bytedance.sdk.openadsdk.Dfc.DbA() { // from class: com.bytedance.sdk.openadsdk.FC.DbA.2
                @Override // com.bytedance.sdk.openadsdk.Dfc.DbA
                public com.bytedance.sdk.openadsdk.Dfc.eli.Os getLogStats() throws Exception {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("duration", elapsedRealtime);
                    jSONObject.put("url", DbA.this.DbA);
                    jSONObject.put("preload_size", kb);
                    jSONObject.put("local_cache", i);
                    jSONObject.put("image_mode", DbA.this.aGH.GR());
                    jSONObject.put("use_new_img", aGH.DbA() ? 1 : 0);
                    return com.bytedance.sdk.openadsdk.Dfc.eli.aGH.DbA().eli("load_image_success").eli(DbA.this.aGH.bBQ()).DbA(jSONObject.toString());
                }
            });
            if (aGH.DbA()) {
                com.bytedance.sdk.openadsdk.dV.Os.DbA(new com.bytedance.sdk.openadsdk.dV.aGH() { // from class: com.bytedance.sdk.openadsdk.FC.DbA.3
                    @Override // com.bytedance.sdk.openadsdk.dV.aGH
                    public com.bytedance.sdk.openadsdk.dV.DbA.eli generatorModel() {
                        com.bytedance.sdk.openadsdk.dV.DbA.eli eliVar = new com.bytedance.sdk.openadsdk.dV.DbA.eli();
                        eliVar.DbA("load_img");
                        if (DbA.this.aGH != null) {
                            eliVar.Os(DbA.this.aGH.oWW(Y1.f));
                            eliVar.aGH(dZ.Os(DbA.this.aGH.bBQ()));
                        }
                        eliVar.eli(BuildConfig.VERSION_NAME);
                        return eliVar;
                    }
                });
            }
        }
    }

    @Override // com.bytedance.sdk.component.ui.aqO
    public void eli(final int i, final String str, final Throwable th) {
        aqO<T> aqo = this.Os;
        if (aqo != null) {
            aqo.eli(i, str, th);
        }
        ev evVar = this.aGH;
        if (evVar != null) {
            if (!TextUtils.isEmpty(dZ.eli(evVar))) {
                final long elapsedRealtime = SystemClock.elapsedRealtime() - this.eli;
                com.bytedance.sdk.openadsdk.Dfc.Os.eli("load_image_error", false, new com.bytedance.sdk.openadsdk.Dfc.DbA() { // from class: com.bytedance.sdk.openadsdk.FC.DbA.4
                    @Override // com.bytedance.sdk.openadsdk.Dfc.DbA
                    public com.bytedance.sdk.openadsdk.Dfc.eli.Os getLogStats() throws Exception {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("duration", elapsedRealtime);
                        jSONObject.put("url", DbA.this.DbA);
                        jSONObject.put(AndroidBridgeConstants.ERROR_CODE, i);
                        Throwable th2 = th;
                        if (th2 instanceof NullPointerException) {
                            ApmHelper.reportCustomError("image load fail", "image_load", th2);
                        }
                        jSONObject.put("error_message", str);
                        jSONObject.put("image_mode", DbA.this.aGH.GR());
                        jSONObject.put("use_new_img", aGH.DbA() ? 1 : 0);
                        return com.bytedance.sdk.openadsdk.Dfc.eli.aGH.DbA().eli("load_image_error").eli(DbA.this.aGH.bBQ()).DbA(jSONObject.toString());
                    }
                });
            }
            if (aGH.DbA()) {
                com.bytedance.sdk.openadsdk.dV.Os.Os(new com.bytedance.sdk.openadsdk.dV.aGH() { // from class: com.bytedance.sdk.openadsdk.FC.DbA.5
                    @Override // com.bytedance.sdk.openadsdk.dV.aGH
                    public com.bytedance.sdk.openadsdk.dV.DbA.eli generatorModel() {
                        com.bytedance.sdk.openadsdk.dV.DbA.eli eliVar = new com.bytedance.sdk.openadsdk.dV.DbA.eli();
                        eliVar.DbA("load_img");
                        if (DbA.this.aGH != null) {
                            eliVar.Os(DbA.this.aGH.oWW(Y1.f));
                            eliVar.aGH(dZ.Os(DbA.this.aGH.bBQ()));
                        }
                        eliVar.eli(BuildConfig.VERSION_NAME);
                        return eliVar;
                    }
                });
            }
        }
    }
}
