package com.bytedance.sdk.openadsdk.core.aAs.FC;

import android.content.Context;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.adsdk.ugeno.DbA.Os;
import com.bytedance.adsdk.ugeno.aGH.MGA;
import com.bytedance.adsdk.ugeno.core.Dfc;
import com.bytedance.adsdk.ugeno.core.NU;
import com.bytedance.adsdk.ugeno.core.aqO;
import com.bytedance.adsdk.ugeno.core.du;
import com.bytedance.adsdk.ugeno.core.nlS;
import com.bytedance.sdk.openadsdk.core.aAs.kb.aGH;
import com.bytedance.sdk.openadsdk.utils.cyF;
import com.vungle.ads.internal.protos.Sdk;
import io.bidmachine.media3.extractor.ts.TsExtractor;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class eli implements Dfc, aqO {
    private nlS DbA;
    private Os Os;
    private Context eli;

    @Override // com.bytedance.adsdk.ugeno.core.aqO
    public void eli(Os os, MotionEvent motionEvent) {
    }

    @Override // com.bytedance.adsdk.ugeno.core.Dfc
    public void eli(Os os, String str, MGA.eli eliVar) {
    }

    @Override // com.bytedance.adsdk.ugeno.core.Dfc
    public void eli(NU nu, Dfc.DbA dbA, Dfc.eli eliVar) {
    }

    public eli(Context context) {
        this.eli = context;
    }

    public void eli(final JSONObject jSONObject, final JSONObject jSONObject2, final JSONObject jSONObject3, final aGH agh) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            DbA(jSONObject, jSONObject2, jSONObject3, agh);
        } else {
            cyF.eli(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.aAs.FC.eli.1
                @Override // java.lang.Runnable
                public void run() {
                    eli.this.DbA(jSONObject, jSONObject2, jSONObject3, agh);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DbA(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, aGH agh) {
        this.DbA = new nlS(this.eli);
        eli();
        this.DbA.eli((Dfc) this);
        this.DbA.eli((aqO) this);
        if (jSONObject == null || jSONObject2 == null) {
            if (agh != null) {
                agh.eli(Sdk.SDKError.Reason.OMSDK_JS_WRITE_FAILED_VALUE, "template or data is null");
                return;
            }
            return;
        }
        try {
            Os<View> eli = this.DbA.eli(jSONObject, jSONObject2, jSONObject3);
            this.Os = eli;
            if (eli != null) {
                agh.eli(eli);
            } else if (agh != null) {
                agh.eli(3000, "ugen render fail");
            }
        } catch (NoClassDefFoundError unused) {
            if (agh != null) {
                agh.eli(138, "ugen render yoga error");
            }
        } catch (UnsatisfiedLinkError unused2) {
            if (agh != null) {
                agh.eli(TsExtractor.TS_STREAM_TYPE_DTS_UHD, "ugen render yoga error");
            }
        } catch (Throwable unused3) {
            if (agh != null) {
                agh.eli(138, "ugen render error");
            }
        }
    }

    private void eli() {
        du duVar = new du();
        duVar.eli(this.eli);
        this.DbA.eli("page", duVar);
    }
}
