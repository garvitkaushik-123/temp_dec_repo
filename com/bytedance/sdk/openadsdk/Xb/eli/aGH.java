package com.bytedance.sdk.openadsdk.Xb.eli;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.adjust.sdk.Constants;
import com.bytedance.sdk.component.wC.wC;
import com.bytedance.sdk.openadsdk.Xb.eli.eli;
import com.bytedance.sdk.openadsdk.core.dV;
import com.bytedance.sdk.openadsdk.core.model.KM;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.nlS.MGA;
import com.bytedance.sdk.openadsdk.utils.cyF;
import com.bytedance.sdk.openadsdk.utils.dZ;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class aGH {
    private static volatile aGH DbA;
    private final Handler eli;
    private int Os = 0;
    private int aGH = 2;
    private int ui = Constants.ONE_HOUR;
    private final ArrayList<DbA> MGA = new ArrayList<>();

    public static aGH eli() {
        if (DbA == null) {
            synchronized (aGH.class) {
                if (DbA == null) {
                    DbA = new aGH();
                }
            }
        }
        return DbA;
    }

    private aGH() {
        cyF.DbA(new wC("pag_pre_render_init") { // from class: com.bytedance.sdk.openadsdk.Xb.eli.aGH.1
            @Override // java.lang.Runnable
            public void run() {
                aGH.this.Os = com.bytedance.sdk.openadsdk.bf.eli.eli("plb_pre_render_enable", 0);
                aGH.this.aGH = com.bytedance.sdk.openadsdk.bf.eli.eli("plb_pre_render_max_count", 2);
                if (aGH.this.aGH <= 0 || aGH.this.aGH > 4) {
                    aGH.this.aGH = 2;
                }
                aGH.this.ui = com.bytedance.sdk.openadsdk.bf.eli.eli("plb_pre_render_alive_time", Constants.ONE_HOUR);
                if (aGH.this.ui <= 0 || aGH.this.ui > 3600000) {
                    aGH.this.ui = Constants.ONE_HOUR;
                }
            }
        });
        this.eli = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.bytedance.sdk.openadsdk.Xb.eli.aGH.2
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                if (!(message.obj instanceof DbA)) {
                    return false;
                }
                aGH.this.MGA.remove(message.obj);
                ((DbA) message.obj).aGH();
                return true;
            }
        });
    }

    public void eli(final ev evVar) {
        if (DbA() && evVar != null && KM.MGA(evVar)) {
            final String fO = evVar.fO();
            if (TextUtils.isEmpty(fO)) {
                return;
            }
            cyF.eli(new Runnable() { // from class: com.bytedance.sdk.openadsdk.Xb.eli.aGH.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (aGH.this.MGA.size() >= aGH.this.aGH) {
                            new Object[]{"inUse size is : ", Integer.valueOf(aGH.this.MGA.size()), ", recycle last old plb"};
                            DbA dbA = (DbA) aGH.this.MGA.remove(0);
                            if (dbA != null) {
                                aGH.this.eli.removeMessages(dbA.wC().hashCode());
                                dbA.aGH();
                            }
                        }
                        evVar.nlS(true);
                        Context eli = dV.eli();
                        ev evVar2 = evVar;
                        final DbA dbA2 = new DbA(eli, evVar2, evVar2.WO(), true, new FrameLayout(dV.eli()), fO);
                        aGH.this.MGA.add(dbA2);
                        dbA2.kb();
                        Message obtain = Message.obtain();
                        obtain.what = fO.hashCode();
                        obtain.obj = dbA2;
                        aGH.this.eli.sendMessageDelayed(obtain, aGH.this.ui);
                        dbA2.eli(new eli.InterfaceC0160eli() { // from class: com.bytedance.sdk.openadsdk.Xb.eli.aGH.3.1
                            @Override // com.bytedance.sdk.openadsdk.Xb.eli.eli.InterfaceC0160eli
                            public void eli() {
                                aGH.this.eli.removeMessages(fO.hashCode());
                                aGH.this.MGA.remove(dbA2);
                                dbA2.aGH();
                            }
                        });
                        ev evVar3 = evVar;
                        com.bytedance.sdk.openadsdk.aGH.Os.eli(evVar3, dZ.Os(evVar3.XU().getDurationSlotType()), "PL_start_pre_render", new com.bytedance.sdk.openadsdk.Dfc.Os.eli() { // from class: com.bytedance.sdk.openadsdk.Xb.eli.aGH.3.2
                            @Override // com.bytedance.sdk.openadsdk.Dfc.Os.eli
                            public JSONObject eli() {
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    jSONObject.put("is_pre_render", 1);
                                } catch (JSONException unused) {
                                }
                                return jSONObject;
                            }
                        });
                    } catch (Throwable th) {
                        new Object[]{"preRenderPlayable exception is ", th.getMessage()};
                    }
                }
            });
        }
    }

    public DbA eli(ev evVar, FrameLayout frameLayout, MGA mga) {
        DbA dbA;
        if (DbA() && evVar.XU() != null && !TextUtils.isEmpty(evVar.XU().getBidAdm()) && KM.MGA(evVar) && frameLayout != null) {
            String fO = evVar.fO();
            if (TextUtils.isEmpty(fO)) {
                return null;
            }
            int i = 0;
            while (true) {
                if (i >= this.MGA.size()) {
                    i = -1;
                    dbA = null;
                    break;
                }
                dbA = this.MGA.get(i);
                if (fO.equals(dbA.wC())) {
                    break;
                }
                i++;
            }
            if (dbA != null) {
                this.eli.removeMessages(fO.hashCode());
                this.MGA.remove(i);
                new Object[]{"getPreRenderPlayable success, size:", Integer.valueOf(this.MGA.size())};
                evVar.nlS(true);
                dbA.eli(frameLayout, mga);
                com.bytedance.sdk.openadsdk.aGH.Os.eli(evVar, dZ.Os(evVar.XU().getDurationSlotType()), "PL_use_pre_render", new com.bytedance.sdk.openadsdk.Dfc.Os.eli() { // from class: com.bytedance.sdk.openadsdk.Xb.eli.aGH.4
                    @Override // com.bytedance.sdk.openadsdk.Dfc.Os.eli
                    public JSONObject eli() {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("is_pre_render", 1);
                        } catch (JSONException unused) {
                        }
                        return jSONObject;
                    }
                });
                return dbA;
            }
        }
        return null;
    }

    public boolean DbA() {
        return this.Os == 1;
    }
}
