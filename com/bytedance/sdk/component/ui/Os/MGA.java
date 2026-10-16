package com.bytedance.sdk.component.ui.Os;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.bytedance.sdk.component.ui.NU;
import com.bytedance.sdk.component.ui.Xb;
import com.bytedance.sdk.component.ui.bf;
import com.bytedance.sdk.component.ui.dV;
import com.bytedance.sdk.component.ui.nGm;
import com.bytedance.sdk.component.ui.nlS;
import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;

/* loaded from: classes3.dex */
public class MGA {
    private final NU DbA;
    private com.bytedance.sdk.component.ui.aGH MGA;
    private nlS kb;
    private ExecutorService wC;
    private Map<String, List<Os>> eli = new ConcurrentHashMap();
    private Map<String, dV> Os = new HashMap();
    private Map<String, nGm> aGH = new HashMap();
    private Map<String, com.bytedance.sdk.component.ui.Os> ui = new HashMap();

    public MGA(Context context, NU nu) {
        this.DbA = (NU) kb.eli(nu);
        com.bytedance.sdk.component.ui.Os.eli.eli.eli(context, nu.wC());
    }

    public Collection<dV> eli() {
        return this.Os.values();
    }

    public Collection<nGm> DbA() {
        return this.aGH.values();
    }

    public Collection<com.bytedance.sdk.component.ui.Os> Os() {
        return this.ui.values();
    }

    public dV eli(com.bytedance.sdk.component.ui.DbA dbA) {
        if (dbA == null) {
            dbA = com.bytedance.sdk.component.ui.Os.eli.eli.aAs();
        }
        String file = dbA.wC().toString();
        dV dVVar = this.Os.get(file);
        if (dVVar != null) {
            return dVVar;
        }
        dV aGH = aGH(dbA);
        this.Os.put(file, aGH);
        return aGH;
    }

    private dV aGH(com.bytedance.sdk.component.ui.DbA dbA) {
        dV ui = this.DbA.ui();
        if (ui != null) {
            return com.bytedance.sdk.component.ui.Os.eli.DbA.eli.eli(ui);
        }
        return com.bytedance.sdk.component.ui.Os.eli.DbA.eli.eli(dbA.DbA());
    }

    public nGm DbA(com.bytedance.sdk.component.ui.DbA dbA) {
        if (dbA == null) {
            dbA = com.bytedance.sdk.component.ui.Os.eli.eli.aAs();
        }
        String file = dbA.wC().toString();
        nGm ngm = this.aGH.get(file);
        if (ngm != null) {
            return ngm;
        }
        nGm ui = ui(dbA);
        this.aGH.put(file, ui);
        return ui;
    }

    private nGm ui(com.bytedance.sdk.component.ui.DbA dbA) {
        nGm MGA = this.DbA.MGA();
        return MGA != null ? MGA : com.bytedance.sdk.component.ui.Os.eli.DbA.ui.eli(dbA.DbA());
    }

    public com.bytedance.sdk.component.ui.Os Os(com.bytedance.sdk.component.ui.DbA dbA) {
        if (dbA == null) {
            dbA = com.bytedance.sdk.component.ui.Os.eli.eli.aAs();
        }
        String file = dbA.wC().toString();
        com.bytedance.sdk.component.ui.Os os = this.ui.get(file);
        if (os != null) {
            return os;
        }
        com.bytedance.sdk.component.ui.Os MGA = MGA(dbA);
        this.ui.put(file, MGA);
        return MGA;
    }

    public com.bytedance.sdk.component.ui.Os eli(String str) {
        return Os(com.bytedance.sdk.component.ui.Os.eli.eli.eli(new File(str)));
    }

    private com.bytedance.sdk.component.ui.Os MGA(com.bytedance.sdk.component.ui.DbA dbA) {
        com.bytedance.sdk.component.ui.Os kb = this.DbA.kb();
        return kb != null ? kb : new com.bytedance.sdk.component.ui.Os.eli.eli.DbA(dbA.wC(), dbA.eli(), kb());
    }

    public com.bytedance.sdk.component.ui.aGH aGH() {
        if (this.MGA == null) {
            this.MGA = FC();
        }
        return this.MGA;
    }

    public bf ui() {
        NU nu = this.DbA;
        if (nu != null) {
            return nu.FC();
        }
        return null;
    }

    private com.bytedance.sdk.component.ui.aGH FC() {
        com.bytedance.sdk.component.ui.aGH aGH = this.DbA.aGH();
        return aGH == null ? new com.bytedance.sdk.component.ui.DbA.eli() : aGH;
    }

    public nlS MGA() {
        if (this.kb == null) {
            this.kb = aAs();
        }
        return this.kb;
    }

    private nlS aAs() {
        nlS eli = this.DbA.eli();
        return eli != null ? eli : com.bytedance.sdk.component.ui.eli.DbA.eli();
    }

    public ExecutorService kb() {
        ExecutorService eli;
        Xb Os = this.DbA.Os();
        if (Os != null && (eli = Os.eli()) != null) {
            return eli;
        }
        if (this.wC == null) {
            this.wC = du();
        }
        return this.wC;
    }

    private ExecutorService du() {
        ExecutorService DbA = this.DbA.DbA();
        return DbA != null ? DbA : com.bytedance.sdk.component.ui.eli.Os.eli();
    }

    public Map<String, List<Os>> wC() {
        return this.eli;
    }

    public com.bytedance.sdk.component.ui.Os.DbA.eli eli(Os os) {
        ImageView.ScaleType aGH = os.aGH();
        if (aGH == null) {
            aGH = com.bytedance.sdk.component.ui.Os.DbA.eli.eli;
        }
        ImageView.ScaleType scaleType = aGH;
        Bitmap.Config du = os.du();
        if (du == null) {
            du = com.bytedance.sdk.component.ui.Os.DbA.eli.DbA;
        }
        return new com.bytedance.sdk.component.ui.Os.DbA.eli(os.DbA(), os.Os(), scaleType, du, os.MGA(), os.kb());
    }
}
