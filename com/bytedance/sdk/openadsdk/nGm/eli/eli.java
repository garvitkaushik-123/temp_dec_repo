package com.bytedance.sdk.openadsdk.nGm.eli;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bytedance.sdk.component.ui.aAs;
import com.bytedance.sdk.component.ui.aqO;
import com.bytedance.sdk.component.ui.du;
import com.bytedance.sdk.component.ui.wC;
import com.bytedance.sdk.openadsdk.FC.aGH;
import com.bytedance.sdk.openadsdk.core.dV;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.utils.SSo;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.Map;

/* loaded from: classes3.dex */
public class eli {

    /* renamed from: com.bytedance.sdk.openadsdk.nGm.eli.eli$eli, reason: collision with other inner class name */
    public interface InterfaceC0211eli {
        void eli(int i, String str, Throwable th);

        void eli(String str, DbA dbA);
    }

    public void eli(com.bytedance.sdk.openadsdk.nGm.eli eliVar, final InterfaceC0211eli interfaceC0211eli, int i, int i2, ImageView.ScaleType scaleType, String str, final int i3, ev evVar) {
        aAs eli = aGH.eli(eliVar.eli).eli(eliVar.DbA).eli(i).DbA(i2).ui(SSo.ui(dV.eli())).aGH(SSo.Os(dV.eli())).DbA(str).eli(scaleType).eli(!TextUtils.isEmpty(str));
        if (i3 > 0) {
            eli.Os(2).eli(new wC() { // from class: com.bytedance.sdk.openadsdk.nGm.eli.eli.1
                @Override // com.bytedance.sdk.component.ui.wC
                public Bitmap eli(Bitmap bitmap) {
                    return com.bytedance.sdk.component.adexpress.aGH.eli.eli(dV.eli(), bitmap, i3);
                }
            });
        } else {
            eli.Os(1);
        }
        eli.eli(new com.bytedance.sdk.openadsdk.FC.DbA(evVar, eliVar.eli, new aqO() { // from class: com.bytedance.sdk.openadsdk.nGm.eli.eli.2
            @Override // com.bytedance.sdk.component.ui.aqO
            public void eli(du duVar) {
                eli.this.eli(duVar, interfaceC0211eli);
            }

            @Override // com.bytedance.sdk.component.ui.aqO
            public void eli(int i4, String str2, Throwable th) {
                eli.this.eli(i4, str2, th, interfaceC0211eli);
            }
        }));
    }

    protected void eli(du duVar, InterfaceC0211eli interfaceC0211eli) {
        if (interfaceC0211eli != null) {
            Object DbA = duVar.DbA();
            int eli = eli(duVar);
            if (DbA instanceof Drawable) {
                interfaceC0211eli.eli(duVar.eli(), new DbA((Drawable) DbA, eli));
                return;
            }
            if (DbA instanceof byte[]) {
                interfaceC0211eli.eli(duVar.eli(), new DbA((byte[]) DbA, eli));
                return;
            }
            if (DbA instanceof Bitmap) {
                interfaceC0211eli.eli(duVar.eli(), new DbA((Bitmap) DbA, duVar.Os() instanceof Bitmap ? (Bitmap) duVar.Os() : null, eli));
            } else {
                interfaceC0211eli.eli(0, "not bitmap or gif result!", null);
            }
        }
    }

    private int eli(du duVar) {
        Object obj;
        Map<String, String> aGH = duVar.aGH();
        if (aGH == null || (obj = aGH.get(CampaignEx.JSON_KEY_IMAGE_SIZE)) == null || !(obj instanceof Integer)) {
            return 0;
        }
        return ((Integer) obj).intValue();
    }

    protected void eli(int i, String str, Throwable th, InterfaceC0211eli interfaceC0211eli) {
        if (interfaceC0211eli != null) {
            interfaceC0211eli.eli(i, str, th);
        }
    }
}
