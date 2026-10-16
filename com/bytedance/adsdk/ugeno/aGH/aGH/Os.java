package com.bytedance.adsdk.ugeno.aGH.aGH;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.aGH.MGA;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public abstract class Os {
    protected com.bytedance.adsdk.ugeno.DbA.Os DbA;
    protected String FC;
    protected String MGA;
    protected com.bytedance.adsdk.ugeno.aGH.MGA Os;
    protected Context aAs;
    protected MGA.eli aGH;
    protected com.bytedance.adsdk.ugeno.aGH.du eli;
    protected String kb;
    protected Map<String, String> ui;
    protected String wC;

    public abstract boolean eli(Object... objArr);

    public Os(Context context) {
        this.aAs = context;
    }

    public void Os() {
        this.aGH = this.Os.eli();
        com.bytedance.adsdk.ugeno.aGH.MGA mga = this.Os;
        if (mga == null) {
            return;
        }
        MGA.eli eli2 = mga.eli();
        this.aGH = eli2;
        if (eli2 == null) {
            return;
        }
        this.ui = eli2.Os();
        this.MGA = this.aGH.DbA();
        this.kb = this.aGH.eli();
        this.wC = this.aGH.aGH();
        this.FC = this.aGH.ui();
    }

    public String aGH() {
        return this.MGA;
    }

    public String ui() {
        return this.wC;
    }

    public void eli(com.bytedance.adsdk.ugeno.DbA.Os os) {
        this.DbA = os;
    }

    public void eli(com.bytedance.adsdk.ugeno.aGH.MGA mga) {
        this.Os = mga;
    }

    public void eli(com.bytedance.adsdk.ugeno.aGH.du duVar) {
        this.eli = duVar;
    }

    public static class eli {
        public static Os eli(Context context, com.bytedance.adsdk.ugeno.DbA.Os os, JSONObject jSONObject, JSONObject jSONObject2) {
            com.bytedance.adsdk.ugeno.aGH.MGA eli;
            MGA.eli eli2;
            com.bytedance.adsdk.ugeno.aGH.kb eli3;
            if (os == null || jSONObject == null || (eli = com.bytedance.adsdk.ugeno.aGH.MGA.eli(jSONObject, jSONObject2)) == null || (eli2 = eli.eli()) == null) {
                return null;
            }
            String eli4 = eli2.eli();
            if (TextUtils.equals(eli4, "custom")) {
                aGH agh = new aGH(context);
                agh.eli(os);
                agh.eli(eli);
                agh.Os();
                return agh;
            }
            if (TextUtils.isEmpty(eli4) || TextUtils.equals(eli4, "global")) {
                eli3 = com.bytedance.adsdk.ugeno.aGH.aAs.eli(eli2.DbA());
            } else {
                eli3 = com.bytedance.adsdk.ugeno.aGH.aAs.eli(eli2.ui());
            }
            if (eli3 == null) {
                return null;
            }
            Os eli5 = eli3.eli(context);
            eli5.eli(os);
            eli5.eli(eli);
            eli5.Os();
            return eli5;
        }
    }
}
