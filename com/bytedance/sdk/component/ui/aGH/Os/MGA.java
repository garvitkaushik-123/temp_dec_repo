package com.bytedance.sdk.component.ui.aGH.Os;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.bytedance.sdk.component.ui.NU;
import com.bytedance.sdk.component.ui.Xb;
import com.bytedance.sdk.component.ui.bf;
import com.bytedance.sdk.component.ui.dV;
import com.bytedance.sdk.component.ui.nGm;
import java.io.File;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;

/* loaded from: classes3.dex */
public class MGA {
    private final NU DbA;
    private Context FC;
    private com.bytedance.sdk.component.ui.aGH MGA;
    private volatile dV Os;
    private volatile nGm aGH;
    private ExecutorService kb;
    private ExecutorService wC;
    private Map<String, List<Os>> eli = new ConcurrentHashMap();
    private Map<String, com.bytedance.sdk.component.ui.Os> ui = new ConcurrentHashMap();

    public MGA(Context context, NU nu) {
        this.DbA = (NU) kb.eli(nu);
        this.FC = context;
        com.bytedance.sdk.component.ui.aGH.Os.eli.DbA.eli(context, nu.wC());
    }

    public Context eli() {
        return this.FC;
    }

    public nGm DbA() {
        return this.aGH;
    }

    public Collection<com.bytedance.sdk.component.ui.Os> Os() {
        return this.ui.values();
    }

    public dV eli(com.bytedance.sdk.component.ui.DbA dbA) {
        if (dbA == null) {
            dbA = com.bytedance.sdk.component.ui.aGH.Os.eli.DbA.aAs();
        }
        if (this.Os == null) {
            synchronized (com.bytedance.sdk.component.ui.aGH.Os.eli.DbA.Os.class) {
                if (this.Os == null) {
                    this.Os = new com.bytedance.sdk.component.ui.aGH.Os.eli.DbA.Os(new com.bytedance.sdk.component.ui.aGH.Os.eli.DbA.eli(dbA.DbA(), dbA.Os()));
                }
            }
        }
        return this.Os;
    }

    public nGm DbA(com.bytedance.sdk.component.ui.DbA dbA) {
        if (dbA == null) {
            dbA = com.bytedance.sdk.component.ui.aGH.Os.eli.DbA.aAs();
        }
        if (this.aGH == null) {
            synchronized (com.bytedance.sdk.component.ui.aGH.Os.eli.DbA.DbA.class) {
                if (this.aGH == null) {
                    this.aGH = new com.bytedance.sdk.component.ui.aGH.Os.eli.DbA.DbA(dbA.DbA(), dbA.aGH());
                }
            }
        }
        return this.aGH;
    }

    public com.bytedance.sdk.component.ui.Os Os(com.bytedance.sdk.component.ui.DbA dbA) {
        if (dbA == null) {
            dbA = com.bytedance.sdk.component.ui.aGH.Os.eli.DbA.aAs();
        }
        String file = dbA.wC().toString();
        com.bytedance.sdk.component.ui.Os os = this.ui.get(file);
        if (os != null) {
            return os;
        }
        com.bytedance.sdk.component.ui.Os aGH = aGH(dbA);
        this.ui.put(file, aGH);
        return aGH;
    }

    public com.bytedance.sdk.component.ui.Os eli(String str) {
        return Os(com.bytedance.sdk.component.ui.aGH.Os.eli.DbA.eli(new File(str)));
    }

    private com.bytedance.sdk.component.ui.Os aGH(com.bytedance.sdk.component.ui.DbA dbA) {
        com.bytedance.sdk.component.ui.Os kb = this.DbA.kb();
        return kb != null ? kb : new com.bytedance.sdk.component.ui.aGH.Os.eli.eli.DbA(dbA.wC(), dbA.eli());
    }

    public com.bytedance.sdk.component.ui.aGH aGH() {
        if (this.MGA == null) {
            this.MGA = aAs();
        }
        return this.MGA;
    }

    private com.bytedance.sdk.component.ui.aGH aAs() {
        com.bytedance.sdk.component.ui.aGH aGH = this.DbA.aGH();
        return aGH == null ? new com.bytedance.sdk.component.ui.DbA.eli() : aGH;
    }

    public ExecutorService ui() {
        ExecutorService eli;
        Xb Os = this.DbA.Os();
        if (Os != null && (eli = Os.eli()) != null) {
            return eli;
        }
        if (this.kb == null) {
            this.kb = du();
        }
        return this.kb;
    }

    public bf MGA() {
        NU nu = this.DbA;
        if (nu != null) {
            return nu.FC();
        }
        return null;
    }

    public boolean kb() {
        NU nu = this.DbA;
        if (nu != null) {
            return nu.aAs();
        }
        return false;
    }

    public ExecutorService wC() {
        ExecutorService DbA;
        Xb Os = this.DbA.Os();
        if (Os != null && (DbA = Os.DbA()) != null) {
            return DbA;
        }
        if (this.wC == null) {
            this.wC = com.bytedance.sdk.component.ui.aGH.eli.DbA.eli();
        }
        return this.wC;
    }

    private ExecutorService du() {
        ExecutorService DbA = this.DbA.DbA();
        return DbA != null ? DbA : com.bytedance.sdk.component.ui.aGH.eli.DbA.eli();
    }

    public Map<String, List<Os>> FC() {
        return this.eli;
    }

    public com.bytedance.sdk.component.ui.aGH.Os.DbA.DbA eli(Os os) {
        ImageView.ScaleType aGH = os.aGH();
        if (aGH == null) {
            aGH = com.bytedance.sdk.component.ui.aGH.Os.DbA.DbA.eli;
        }
        ImageView.ScaleType scaleType = aGH;
        Bitmap.Config du = os.du();
        if (du == null) {
            du = com.bytedance.sdk.component.ui.aGH.Os.DbA.DbA.DbA;
        }
        return new com.bytedance.sdk.component.ui.aGH.Os.DbA.DbA(os.DbA(), os.Os(), scaleType, du, os.MGA(), os.kb());
    }
}
