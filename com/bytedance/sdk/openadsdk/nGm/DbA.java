package com.bytedance.sdk.openadsdk.nGm;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.bytedance.sdk.component.DbA.eli.aGH;
import com.bytedance.sdk.component.DbA.eli.eli.eli.aAs;
import com.bytedance.sdk.component.DbA.eli.eli.eli.ui;
import com.bytedance.sdk.component.DbA.eli.nlS;
import com.bytedance.sdk.component.DbA.eli.nn;
import com.bytedance.sdk.component.DbA.eli.wC;
import com.bytedance.sdk.component.embedapplog.PangleEncryptConstant;
import com.bytedance.sdk.component.embedapplog.PangleEncryptManager;
import com.bytedance.sdk.component.kb.eli;
import com.bytedance.sdk.component.pglcrypt.PglCryptUtils;
import com.bytedance.sdk.component.ui.aqO;
import com.bytedance.sdk.component.ui.du;
import com.bytedance.sdk.openadsdk.core.Vy;
import com.bytedance.sdk.openadsdk.core.dV;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.core.model.nGm;
import com.bytedance.sdk.openadsdk.core.settings.NU;
import com.bytedance.sdk.openadsdk.nGm.eli.Os;
import com.bytedance.sdk.openadsdk.utils.SSo;
import com.bytedance.sdk.openadsdk.utils.cyF;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.pgl.ssdk.ces.out.PglSSConfig;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class DbA {
    private static volatile DbA eli;
    private final com.bytedance.sdk.component.kb.eli DbA;
    private Os Os;
    private final Map<String, JSONObject> aGH = new HashMap();

    public int eli() {
        try {
            return com.bytedance.sdk.openadsdk.bf.eli.eli("net_time_out", 10000);
        } catch (Throwable unused) {
            return 10000;
        }
    }

    public static DbA DbA() {
        if (eli == null) {
            synchronized (DbA.class) {
                if (eli == null) {
                    eli = new DbA(dV.eli());
                }
            }
        }
        return eli;
    }

    private DbA(Context context) {
        long eli2 = eli();
        com.bytedance.sdk.component.kb.eli eli3 = new eli.C0146eli().eli(eli2, TimeUnit.MILLISECONDS).DbA(eli2, TimeUnit.MILLISECONDS).Os(eli2, TimeUnit.MILLISECONDS).eli(new eli()).eli(true).eli();
        this.DbA = eli3;
        com.bytedance.sdk.component.DbA.eli.eli.eli.eli.eli(new aAs() { // from class: com.bytedance.sdk.openadsdk.nGm.DbA.1
            @Override // com.bytedance.sdk.component.DbA.eli.eli.eli.aAs
            public ExecutorService eli() {
                if (NU.nY().Hm()) {
                    return cyF.du();
                }
                return null;
            }

            @Override // com.bytedance.sdk.component.DbA.eli.eli.eli.aAs
            public boolean DbA() {
                return NU.nY().Hm();
            }
        });
        com.bytedance.sdk.component.kb.eli.eli(new ui() { // from class: com.bytedance.sdk.openadsdk.nGm.DbA.2
            @Override // com.bytedance.sdk.component.DbA.eli.eli.eli.ui
            public boolean eli() {
                return com.bytedance.sdk.openadsdk.bf.eli.eli("net_http_protocol", 0) == 1;
            }
        });
        aGH eli4 = eli3.MGA().eli();
        if (eli4 != null) {
            eli4.eli(32);
        }
    }

    public class eli implements wC {
        public eli() {
        }

        @Override // com.bytedance.sdk.component.DbA.eli.wC
        public nn eli(wC.eli eliVar) throws IOException {
            JSONObject eli;
            nlS eli2 = eliVar.eli();
            if (eli2.DbA() != null && !eli2.DbA().aGH().isEmpty()) {
                List<String> aGH = eli2.DbA().aGH();
                StringBuilder sb = new StringBuilder();
                Iterator<String> it = aGH.iterator();
                while (it.hasNext()) {
                    sb.append(RemoteSettings.FORWARD_SLASH_STRING).append(it.next());
                }
                String sb2 = sb.toString();
                if (!TextUtils.isEmpty(sb2) && sb2.equals("/monitor/collect/c/session")) {
                    return eliVar.eli(eli2);
                }
            }
            nlS.eli FC = eli2.FC();
            String DbA = com.bytedance.sdk.openadsdk.multipro.aGH.aGH.DbA("ttopenadsdk", PglSSConfig.CUSTOMINFO_KEY_IPV6, "");
            if (!TextUtils.isEmpty(DbA) && (eli = DbA.this.eli(DbA)) != null) {
                FC.DbA("transfer-param", eli.optString(PglCryptUtils.KEY_MESSAGE));
                if (eli.optInt("cypher") == 4) {
                    FC.DbA("cypher", "4");
                } else {
                    FC.DbA("cypher", "3");
                }
            }
            try {
                FC.DbA("x-pangle-target-idc", NU.nY().Bnk());
            } catch (Throwable unused) {
            }
            return eliVar.eli(FC.DbA());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject eli(String str) {
        JSONObject jSONObject = this.aGH.get(str);
        if (jSONObject != null) {
            return jSONObject;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("ipv6", str);
        } catch (JSONException unused) {
        }
        JSONObject encryptType4 = PangleEncryptManager.encryptType4(jSONObject2, new Vy(PangleEncryptConstant.CryptDataScene.UNKNOWN));
        this.aGH.put(str, encryptType4);
        return encryptType4;
    }

    public com.bytedance.sdk.component.kb.eli Os() {
        return this.DbA;
    }

    public Os aGH() {
        ui();
        return this.Os;
    }

    public void eli(String str, int i, int i2, ImageView imageView, ev evVar) {
        com.bytedance.sdk.openadsdk.FC.aGH.eli(str).eli(i).DbA(i2).ui(SSo.ui(dV.eli())).aGH(SSo.Os(dV.eli())).Os(1).eli(com.bytedance.sdk.openadsdk.FC.Os.eli(evVar, str, imageView));
    }

    public void eli(int i, final ImageView imageView, final ev evVar) {
        if (evVar == null || !TextUtils.isEmpty(evVar.aqO())) {
            com.bytedance.sdk.openadsdk.FC.aGH.eli(evVar.aqO()).eli(i).DbA(i).ui(SSo.ui(dV.eli())).aGH(SSo.Os(dV.eli())).Os(1).eli(com.bytedance.sdk.openadsdk.FC.Os.eli(evVar, evVar.aqO(), imageView));
            if (imageView != null) {
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.nGm.DbA.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (imageView.getDrawable() != null) {
                            Intent intent = new Intent();
                            String dV = evVar.dV();
                            intent.setAction("android.intent.action.VIEW");
                            intent.setData(Uri.parse(dV));
                            try {
                                com.bytedance.sdk.component.utils.DbA.eli(dV.eli(), intent, null);
                            } catch (Exception unused) {
                            }
                        }
                    }
                });
            }
        }
    }

    public void eli(nGm ngm, ImageView imageView, ev evVar) {
        if (ngm == null || TextUtils.isEmpty(ngm.eli()) || imageView == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.FC.aGH.eli(ngm).Os(1).eli(com.bytedance.sdk.openadsdk.FC.Os.eli(evVar, ngm.eli(), imageView));
    }

    public void eli(nGm ngm, ImageView imageView, ev evVar, aqO aqo) {
        if (ngm == null || TextUtils.isEmpty(ngm.eli()) || imageView == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.FC.aGH.eli(ngm).Os(1).eli(com.bytedance.sdk.openadsdk.FC.Os.eli(evVar, ngm.eli(), imageView, aqo));
    }

    public void eli(String str, View view) {
        if (view == null || TextUtils.isEmpty(str)) {
            return;
        }
        final WeakReference weakReference = new WeakReference(view);
        com.bytedance.sdk.openadsdk.FC.aGH.eli(str).Os(2).eli(new com.bytedance.sdk.component.ui.wC() { // from class: com.bytedance.sdk.openadsdk.nGm.DbA.5
            @Override // com.bytedance.sdk.component.ui.wC
            public Bitmap eli(Bitmap bitmap) {
                View view2 = (View) weakReference.get();
                if (view2 == null) {
                    return null;
                }
                return com.bytedance.sdk.component.adexpress.aGH.eli.eli(view2.getContext(), bitmap, 10);
            }
        }).eli(new aqO() { // from class: com.bytedance.sdk.openadsdk.nGm.DbA.4
            @Override // com.bytedance.sdk.component.ui.aqO
            public void eli(int i, String str2, Throwable th) {
            }

            @Override // com.bytedance.sdk.component.ui.aqO
            public void eli(du duVar) {
                final View view2;
                if (duVar == null) {
                    return;
                }
                final Object DbA = duVar.DbA();
                if (!(DbA instanceof Bitmap) || (view2 = (View) weakReference.get()) == null) {
                    return;
                }
                if (cyF.MGA()) {
                    if (view2 instanceof ImageView) {
                        ((ImageView) view2).setImageDrawable(new BitmapDrawable(view2.getResources(), (Bitmap) DbA));
                        return;
                    } else {
                        view2.setBackground(new BitmapDrawable(view2.getResources(), (Bitmap) DbA));
                        return;
                    }
                }
                view2.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.nGm.DbA.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        View view3 = view2;
                        if (view3 instanceof ImageView) {
                            ((ImageView) view3).setImageDrawable(new BitmapDrawable(view2.getResources(), (Bitmap) DbA));
                        } else {
                            view3.setBackground(new BitmapDrawable(view2.getResources(), (Bitmap) DbA));
                        }
                    }
                });
            }
        });
    }

    private void ui() {
        if (this.Os == null) {
            this.Os = new Os();
        }
    }
}
