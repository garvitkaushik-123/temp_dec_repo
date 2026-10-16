package com.bytedance.sdk.component.eli;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.sdk.component.eli.kb;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public abstract class eli {
    protected NU DbA;
    protected wC Os;
    protected Context eli;
    kb kb;
    protected String ui;
    protected Handler aGH = new Handler(Looper.getMainLooper());
    protected volatile boolean MGA = false;
    private final Map<String, kb> wC = new HashMap();

    protected abstract void DbA(aAs aas);

    protected abstract Context eli(aAs aas);

    protected abstract String eli();

    protected abstract void eli(String str);

    protected eli() {
    }

    protected void invokeMethod(final String str) {
        if (this.MGA) {
            return;
        }
        this.aGH.post(new Runnable() { // from class: com.bytedance.sdk.component.eli.eli.1
            @Override // java.lang.Runnable
            public void run() {
                aqO aqo;
                if (eli.this.MGA) {
                    return;
                }
                try {
                    aqo = eli.this.eli(new JSONObject(str));
                } catch (Exception unused) {
                    aqo = null;
                }
                if (aqO.eli(aqo)) {
                    new StringBuilder("By pass invalid call: ").append(aqo);
                    if (aqo != null) {
                        eli.this.DbA(Vy.eli(new nGm(aqo.eli, "Failed to parse invocation.")), aqo);
                        return;
                    }
                    return;
                }
                eli.this.eli(aqo);
            }
        });
    }

    protected void eli(String str, aqO aqo) {
        eli(str);
    }

    protected void DbA() {
        this.kb.eli();
        Iterator<kb> it = this.wC.values().iterator();
        while (it.hasNext()) {
            it.next().eli();
        }
        this.aGH.removeCallbacksAndMessages(null);
        this.MGA = true;
    }

    protected final void eli(aqO aqo) {
        String eli;
        if (this.MGA || (eli = eli()) == null) {
            return;
        }
        kb DbA = DbA(aqo.kb);
        if (DbA == null) {
            new StringBuilder("Received call with unknown namespace, ").append(aqo);
            if (this.DbA != null) {
                eli();
            }
            DbA(Vy.eli(new nGm(-4, "Namespace " + aqo.kb + " unknown.")), aqo);
            return;
        }
        MGA mga = new MGA();
        mga.DbA = eli;
        mga.eli = this.eli;
        mga.Os = DbA;
        try {
            kb.eli eli2 = DbA.eli(aqo, mga);
            if (eli2 == null) {
                new StringBuilder("Received call but not registered, ").append(aqo);
                if (this.DbA != null) {
                    eli();
                }
                DbA(Vy.eli(new nGm(-2, "Function " + aqo.aGH + " is not registered.")), aqo);
                return;
            }
            if (eli2.eli) {
                DbA(eli2.DbA, aqo);
            }
            if (this.DbA != null) {
                eli();
            }
        } catch (Exception e) {
            new StringBuilder("call finished with error, ").append(aqo);
            DbA(Vy.eli(e), aqo);
        }
    }

    final void eli(aAs aas, bf bfVar) {
        this.eli = eli(aas);
        this.Os = aas.aGH;
        this.DbA = aas.FC;
        this.kb = new kb(aas, this, bfVar);
        this.ui = aas.du;
        DbA(aas);
    }

    final void DbA(String str, aqO aqo) {
        JSONObject jSONObject;
        if (this.MGA || TextUtils.isEmpty(aqo.MGA)) {
            return;
        }
        if (!str.startsWith("{") || !str.endsWith("}")) {
            FC.eli(new IllegalArgumentException("Illegal callback data: ".concat(String.valueOf(str))));
        }
        String str2 = aqo.MGA;
        try {
            jSONObject = new JSONObject(str);
        } catch (Exception unused) {
            jSONObject = new JSONObject();
        }
        eli(Dfc.eli().eli("__msg_type", "callback").eli("__callback_id", aqo.MGA).eli("__params", jSONObject).DbA(), aqo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public aqO eli(JSONObject jSONObject) {
        String optString;
        Object opt;
        if (this.MGA) {
            return null;
        }
        String optString2 = jSONObject.optString("__callback_id");
        String optString3 = jSONObject.optString("func");
        if (eli() == null) {
            return null;
        }
        try {
            String string = jSONObject.getString("__msg_type");
            String str = "";
            try {
                opt = jSONObject.opt("params");
            } catch (Throwable unused) {
                optString = jSONObject.optString("params");
            }
            if (opt != null) {
                if (opt instanceof JSONObject) {
                    optString = String.valueOf((JSONObject) opt);
                    String string2 = jSONObject.getString("JSSDK");
                    String optString4 = jSONObject.optString("namespace");
                    return aqO.eli().eli(string2).DbA(string).Os(optString3).aGH(optString).ui(optString2).MGA(optString4).kb(jSONObject.optString("__iframe_url")).eli();
                }
                if (opt instanceof String) {
                    str = (String) opt;
                } else {
                    str = String.valueOf(opt);
                }
            }
            optString = str;
            String string22 = jSONObject.getString("JSSDK");
            String optString42 = jSONObject.optString("namespace");
            return aqO.eli().eli(string22).DbA(string).Os(optString3).aGH(optString).ui(optString2).MGA(optString42).kb(jSONObject.optString("__iframe_url")).eli();
        } catch (JSONException unused2) {
            return aqO.eli(optString2, -1);
        }
    }

    private kb DbA(String str) {
        if (TextUtils.equals(str, this.ui) || TextUtils.isEmpty(str)) {
            return this.kb;
        }
        return this.wC.get(str);
    }
}
