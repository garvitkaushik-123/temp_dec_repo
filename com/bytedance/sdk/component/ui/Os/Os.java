package com.bytedance.sdk.component.ui.Os;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ImageView;
import com.bytedance.sdk.component.ui.FC;
import com.bytedance.sdk.component.ui.QX;
import com.bytedance.sdk.component.ui.aAs;
import com.bytedance.sdk.component.ui.aqO;
import com.bytedance.sdk.component.ui.bf;
import com.bytedance.sdk.component.ui.du;
import com.bytedance.sdk.component.ui.nn;
import com.bytedance.sdk.component.ui.wC;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes3.dex */
public class Os implements FC {
    private int CMM;
    private String DbA;
    private boolean Dfc;
    private int FC;
    private boolean GB;
    private boolean KM;
    private ImageView.ScaleType MGA;
    private volatile boolean NU;
    private String Os;
    private final Handler QX;
    private int Ue;
    private ExecutorService VM;
    private com.bytedance.sdk.component.ui.Os.eli Vy;
    private boolean Xb;
    private wC aAs;
    private String aGH;
    private QX aqO;
    private com.bytedance.sdk.component.ui.kb bf;
    private int dV;
    private int du;
    Future<?> eli;
    private MGA ev;
    private com.bytedance.sdk.component.ui.DbA gG;
    private Bitmap.Config kb;
    private Queue<com.bytedance.sdk.component.ui.ui.FC> nGm;
    private WeakReference<ImageView> nlS;
    private boolean nn;
    private nn oWW;
    private aqO ui;
    private int ujq;
    private int wC;

    private Os(DbA dbA) {
        this.nGm = new LinkedBlockingQueue();
        this.QX = new Handler(Looper.getMainLooper());
        this.Xb = true;
        this.DbA = dbA.aGH;
        this.ui = new eli(dbA.eli);
        this.nlS = new WeakReference<>(dbA.DbA);
        this.MGA = dbA.ui;
        this.kb = dbA.MGA;
        this.wC = dbA.kb;
        this.FC = dbA.wC;
        this.du = dbA.FC;
        this.dV = dbA.aAs;
        this.aqO = dbA.du;
        this.gG = eli(dbA);
        if (!TextUtils.isEmpty(dbA.Os)) {
            DbA(dbA.Os);
            eli(dbA.Os);
        }
        this.nn = dbA.nlS;
        this.Dfc = dbA.NU;
        this.ev = dbA.aqO;
        this.aAs = dbA.dV;
        this.Ue = dbA.QX;
        this.ujq = dbA.nGm;
        this.VM = dbA.bf;
        this.KM = dbA.Xb;
        this.GB = dbA.CMM;
        this.oWW = dbA.ev;
        this.nGm.add(new com.bytedance.sdk.component.ui.ui.Os());
    }

    private com.bytedance.sdk.component.ui.DbA eli(DbA dbA) {
        if (dbA.Dfc != null) {
            return dbA.Dfc;
        }
        if (!TextUtils.isEmpty(dbA.nn)) {
            return com.bytedance.sdk.component.ui.Os.eli.eli.eli(new File(dbA.nn));
        }
        return com.bytedance.sdk.component.ui.Os.eli.eli.aAs();
    }

    public int MGA() {
        return this.ujq;
    }

    public int kb() {
        return this.Ue;
    }

    @Override // com.bytedance.sdk.component.ui.FC
    public String eli() {
        return this.DbA;
    }

    public aqO wC() {
        return this.ui;
    }

    public String FC() {
        return this.aGH;
    }

    public void eli(String str) {
        this.aGH = str;
    }

    public String aAs() {
        return this.Os;
    }

    @Override // com.bytedance.sdk.component.ui.FC
    public Bitmap.Config ui() {
        return this.kb;
    }

    public void DbA(String str) {
        WeakReference<ImageView> weakReference = this.nlS;
        if (weakReference != null && weakReference.get() != null) {
            this.nlS.get().setTag(1094453505, str);
        }
        this.Os = str;
    }

    @Override // com.bytedance.sdk.component.ui.FC
    public ImageView.ScaleType aGH() {
        return this.MGA;
    }

    public Bitmap.Config du() {
        return this.kb;
    }

    @Override // com.bytedance.sdk.component.ui.FC
    public int DbA() {
        return this.wC;
    }

    @Override // com.bytedance.sdk.component.ui.FC
    public int Os() {
        return this.FC;
    }

    public int nlS() {
        return this.du;
    }

    public boolean NU() {
        return this.nn;
    }

    public boolean nn() {
        return this.Dfc;
    }

    public void eli(boolean z) {
        this.Xb = z;
    }

    public boolean Dfc() {
        return this.Xb;
    }

    public com.bytedance.sdk.component.ui.kb aqO() {
        return this.bf;
    }

    public void eli(com.bytedance.sdk.component.ui.kb kbVar) {
        this.bf = kbVar;
    }

    public int dV() {
        return this.CMM;
    }

    public void eli(int i) {
        this.CMM = i;
    }

    public void eli(com.bytedance.sdk.component.ui.Os.eli eliVar) {
        this.Vy = eliVar;
    }

    public MGA nGm() {
        return this.ev;
    }

    public com.bytedance.sdk.component.ui.DbA QX() {
        return this.gG;
    }

    public boolean eli(com.bytedance.sdk.component.ui.ui.FC fc) {
        if (this.NU) {
            return false;
        }
        return this.nGm.add(fc);
    }

    public boolean Xb() {
        return this.KM;
    }

    public nn bf() {
        return this.oWW;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FC ev() {
        try {
            if (this.ev == null) {
                aqO aqo = this.ui;
                if (aqo != null) {
                    aqo.eli(1005, "not init !", null);
                    return this;
                }
            } else {
                String eli2 = eli();
                if (TextUtils.isEmpty(eli2)) {
                    aqO aqo2 = this.ui;
                    if (aqo2 != null) {
                        aqo2.eli(2000, "url is empty", null);
                        return this;
                    }
                } else {
                    bf ui = this.ev.ui();
                    if (!eli2.startsWith("http://") && !eli2.startsWith("https://") && ui != null) {
                        ui.eli(1006, "url is not validate ".concat(String.valueOf(eli2)));
                    }
                    ExecutorService kb = this.VM == null ? this.ev.kb() : null;
                    Runnable runnable = new Runnable() { // from class: com.bytedance.sdk.component.ui.Os.Os.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.bytedance.sdk.component.ui.ui.FC fc;
                            while (!Os.this.NU && (fc = (com.bytedance.sdk.component.ui.ui.FC) Os.this.nGm.poll()) != null) {
                                try {
                                    if (Os.this.aqO != null) {
                                        Os.this.aqO.eli(fc.eli(), Os.this);
                                    }
                                    fc.eli(Os.this);
                                    if (Os.this.aqO != null) {
                                        Os.this.aqO.DbA(fc.eli(), Os.this);
                                    }
                                } catch (Throwable th) {
                                    Os.this.eli(2000, th.getMessage(), th);
                                    if (Os.this.aqO != null) {
                                        Os.this.aqO.DbA("exception", Os.this);
                                        return;
                                    }
                                    return;
                                }
                            }
                            if (Os.this.NU) {
                                Os.this.eli(1003, "canceled", null);
                            }
                        }
                    };
                    if (this.GB) {
                        runnable.run();
                        return this;
                    }
                    ExecutorService executorService = this.VM;
                    if (executorService != null) {
                        this.eli = executorService.submit(runnable);
                        return this;
                    }
                    if (kb != null) {
                        this.eli = kb.submit(runnable);
                        return this;
                    }
                }
            }
        } catch (Exception e) {
            Log.e("ImageRequest", e.getMessage());
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eli(int i, String str, Throwable th) {
        new com.bytedance.sdk.component.ui.ui.wC(i, str, th).eli(this);
        this.nGm.clear();
    }

    public String CMM() {
        return aAs() + nlS();
    }

    public static class DbA implements aAs {
        private boolean CMM;
        private ImageView DbA;
        private com.bytedance.sdk.component.ui.DbA Dfc;
        private Bitmap.Config MGA;
        private boolean NU;
        private String Os;
        private int QX;
        private boolean Xb;
        private String aGH;
        private MGA aqO;
        private ExecutorService bf;
        private wC dV;
        private QX du;
        private aqO eli;
        private nn ev;
        private int kb;
        private int nGm;
        private boolean nlS;
        private String nn;
        private ImageView.ScaleType ui;
        private int wC;
        private int FC = 1;
        private int aAs = 5;

        public DbA(MGA mga) {
            this.aqO = mga;
        }

        public aAs Os(String str) {
            this.aGH = str;
            return this;
        }

        @Override // com.bytedance.sdk.component.ui.aAs
        public aAs eli(String str) {
            this.Os = str;
            return this;
        }

        @Override // com.bytedance.sdk.component.ui.aAs
        public aAs eli(ImageView.ScaleType scaleType) {
            this.ui = scaleType;
            return this;
        }

        @Override // com.bytedance.sdk.component.ui.aAs
        public aAs eli(Bitmap.Config config) {
            this.MGA = config;
            return this;
        }

        @Override // com.bytedance.sdk.component.ui.aAs
        public aAs eli(int i) {
            this.kb = i;
            return this;
        }

        @Override // com.bytedance.sdk.component.ui.aAs
        public aAs DbA(int i) {
            this.wC = i;
            return this;
        }

        @Override // com.bytedance.sdk.component.ui.aAs
        public aAs Os(int i) {
            this.FC = i;
            return this;
        }

        @Override // com.bytedance.sdk.component.ui.aAs
        public aAs eli(QX qx) {
            this.du = qx;
            return this;
        }

        @Override // com.bytedance.sdk.component.ui.aAs
        public aAs eli(boolean z) {
            this.NU = z;
            return this;
        }

        @Override // com.bytedance.sdk.component.ui.aAs
        public aAs DbA(String str) {
            this.nn = str;
            return this;
        }

        @Override // com.bytedance.sdk.component.ui.aAs
        public FC eli(aqO aqo, int i) {
            this.aAs = i;
            return eli(aqo);
        }

        @Override // com.bytedance.sdk.component.ui.aAs
        public FC eli(aqO aqo) {
            this.eli = aqo;
            return new Os(this).ev();
        }

        @Override // com.bytedance.sdk.component.ui.aAs
        public FC eli(ImageView imageView) {
            this.DbA = imageView;
            return new Os(this).ev();
        }

        @Override // com.bytedance.sdk.component.ui.aAs
        public aAs eli(wC wCVar) {
            this.dV = wCVar;
            return this;
        }

        @Override // com.bytedance.sdk.component.ui.aAs
        public aAs aGH(int i) {
            this.nGm = i;
            return this;
        }

        @Override // com.bytedance.sdk.component.ui.aAs
        public aAs ui(int i) {
            this.QX = i;
            return this;
        }
    }

    private class eli implements aqO {
        private aqO DbA;

        public eli(aqO aqo) {
            this.DbA = aqo;
        }

        @Override // com.bytedance.sdk.component.ui.aqO
        public void eli(final du duVar) {
            final ImageView imageView = (ImageView) Os.this.nlS.get();
            if (imageView != null && Os.this.du != 3 && eli(imageView) && (duVar.DbA() instanceof Bitmap)) {
                final Bitmap bitmap = (Bitmap) duVar.DbA();
                Os.this.QX.post(new Runnable() { // from class: com.bytedance.sdk.component.ui.Os.Os.eli.1
                    @Override // java.lang.Runnable
                    public void run() {
                        imageView.setImageBitmap(bitmap);
                    }
                });
            }
            try {
                if (Os.this.aAs != null && (duVar.DbA() instanceof Bitmap)) {
                    wC wCVar = Os.this.aAs;
                    Bitmap bitmap2 = (Bitmap) duVar.DbA();
                    Bitmap bitmap3 = bitmap2;
                    Bitmap eli = wCVar.eli(bitmap2);
                    if (eli != null) {
                        duVar.eli(eli);
                    }
                }
            } catch (Throwable unused) {
            }
            if (Os.this.dV == 5) {
                Os.this.QX.postAtFrontOfQueue(new Runnable() { // from class: com.bytedance.sdk.component.ui.Os.Os.eli.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (eli.this.DbA != null) {
                            eli.this.DbA.eli(duVar);
                        }
                    }
                });
                return;
            }
            aqO aqo = this.DbA;
            if (aqo != null) {
                aqo.eli(duVar);
            }
        }

        private boolean eli(ImageView imageView) {
            Object tag;
            return (imageView == null || (tag = imageView.getTag(1094453505)) == null || !tag.equals(Os.this.Os)) ? false : true;
        }

        @Override // com.bytedance.sdk.component.ui.aqO
        public void eli(final int i, final String str, final Throwable th) {
            if (Os.this.dV == 5) {
                Os.this.QX.post(new Runnable() { // from class: com.bytedance.sdk.component.ui.Os.Os.eli.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (eli.this.DbA != null) {
                            eli.this.DbA.eli(i, str, th);
                        }
                    }
                });
                return;
            }
            aqO aqo = this.DbA;
            if (aqo != null) {
                aqo.eli(i, str, th);
            }
        }
    }
}
