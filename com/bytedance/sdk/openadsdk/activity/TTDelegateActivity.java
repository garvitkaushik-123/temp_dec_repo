package com.bytedance.sdk.openadsdk.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import com.bytedance.sdk.component.utils.Dfc;
import com.bytedance.sdk.openadsdk.core.KM;
import com.bytedance.sdk.openadsdk.core.Os.kb;
import com.bytedance.sdk.openadsdk.core.Ue;
import com.bytedance.sdk.openadsdk.core.dV;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.core.nn;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class TTDelegateActivity extends TTBaseActivity {
    private static final Map<String, kb.eli> aGH = Collections.synchronizedMap(new HashMap());
    private Intent DbA;
    private KM Os;
    ev eli = null;

    public static void eli(ev evVar, String str, kb.eli eliVar) {
        if (evVar == null) {
            return;
        }
        Intent intent = new Intent(dV.eli(), (Class<?>) TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 6);
        intent.putExtra("closed_listener_key", str);
        if (com.bytedance.sdk.openadsdk.multipro.DbA.Os()) {
            intent.putExtra("ext_info", evVar.eu());
            intent.putExtra("filter_words", com.bytedance.sdk.openadsdk.tool.eli.eli(evVar.mS()));
            intent.putExtra("creative_info", evVar.iOb().toString());
        } else {
            intent.putExtra("meta_index", Ue.eli().eli(evVar));
        }
        if (eliVar != null) {
            if (com.bytedance.sdk.openadsdk.multipro.DbA.Os()) {
                com.bytedance.sdk.openadsdk.core.FC.DbA().eli(str, eliVar);
            } else {
                aGH.put(str, eliVar);
            }
        }
        com.bytedance.sdk.component.utils.DbA.eli(dV.eli(), intent, null);
    }

    public static void eli(ev evVar, String str) {
        eli(evVar, str, null);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!nn.ui()) {
            finish();
            return;
        }
        aGH();
        this.DbA = getIntent();
        if (dV.eli() == null) {
            dV.DbA(this);
        }
    }

    private void aGH() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = 0.0f;
        window.setAttributes(attributes);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (dV.eli() == null) {
            dV.DbA(this);
        }
        setIntent(intent);
        this.DbA = intent;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        KM km = this.Os;
        if ((km == null || ((com.bytedance.sdk.openadsdk.Os.Os) km).eli == null || !((com.bytedance.sdk.openadsdk.Os.Os) this.Os).eli.isShowing()) && this.DbA != null) {
            ui();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        KM km = this.Os;
        if (km != null) {
            km.DbA();
        }
    }

    private void ui() {
        String eu;
        String eli;
        String str;
        int intExtra = this.DbA.getIntExtra("type", 0);
        if (intExtra != 1) {
            if (intExtra == 6) {
                if (com.bytedance.sdk.openadsdk.multipro.DbA.Os()) {
                    eu = this.DbA.getStringExtra("ext_info");
                    eli = this.DbA.getStringExtra("filter_words");
                    str = this.DbA.getStringExtra("creative_info");
                } else {
                    if (this.eli == null) {
                        this.eli = Ue.eli().eli(Ue.eli(this.DbA));
                    }
                    ev evVar = this.eli;
                    if (evVar == null) {
                        finish();
                        return;
                    } else {
                        eu = evVar.eu();
                        eli = com.bytedance.sdk.openadsdk.tool.eli.eli(this.eli.mS());
                        str = "";
                    }
                }
                eli(eu, eli, this.DbA.getStringExtra("closed_listener_key"), str, this.eli);
                return;
            }
            finish();
        }
    }

    private void eli(String str, String str2, final String str3, String str4, ev evVar) {
        TTDelegateActivity tTDelegateActivity;
        if (str2 == null || str == null || this.Os != null) {
            tTDelegateActivity = this;
        } else {
            tTDelegateActivity = this;
            com.bytedance.sdk.openadsdk.Os.Os os = new com.bytedance.sdk.openadsdk.Os.Os(tTDelegateActivity, str, com.bytedance.sdk.openadsdk.tool.eli.eli(str2), str4, evVar);
            tTDelegateActivity.Os = os;
            os.eli(str3);
            tTDelegateActivity.Os.eli(new KM.eli() { // from class: com.bytedance.sdk.openadsdk.activity.TTDelegateActivity.1
                @Override // com.bytedance.sdk.openadsdk.core.KM.eli
                public void eli(int i, String str5) {
                    kb.eli ui;
                    if (TTDelegateActivity.aGH != null && TTDelegateActivity.aGH.size() > 0 && !TextUtils.isEmpty(str3) && !com.bytedance.sdk.openadsdk.multipro.DbA.Os()) {
                        kb.eli eliVar = (kb.eli) TTDelegateActivity.aGH.get(str3);
                        if (eliVar != null) {
                            eliVar.eli();
                        }
                    } else if (!TextUtils.isEmpty(str3) && (ui = com.bytedance.sdk.openadsdk.core.FC.DbA().ui(str3)) != null) {
                        ui.eli();
                        com.bytedance.sdk.openadsdk.core.FC.DbA().MGA(str3);
                    }
                    TTDelegateActivity.this.eli(str3);
                    TTDelegateActivity.this.finish();
                }

                @Override // com.bytedance.sdk.openadsdk.core.KM.eli
                public void eli() {
                    if (!((com.bytedance.sdk.openadsdk.Os.Os) TTDelegateActivity.this.Os).Os()) {
                        TTDelegateActivity.this.eli(str3);
                        TTDelegateActivity.this.finish();
                    }
                    ((com.bytedance.sdk.openadsdk.Os.Os) TTDelegateActivity.this.Os).eli(false);
                }
            });
        }
        KM km = tTDelegateActivity.Os;
        if (km != null) {
            km.eli();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eli(String str) {
        Map<String, kb.eli> map = aGH;
        if (map == null || TextUtils.isEmpty(str)) {
            return;
        }
        map.remove(str);
        if (Dfc.aGH()) {
            map.size();
        }
    }
}
