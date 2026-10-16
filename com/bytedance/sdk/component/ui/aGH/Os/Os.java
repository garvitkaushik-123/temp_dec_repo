package com.bytedance.sdk.component.ui.aGH.Os;

import android.graphics.Bitmap;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
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
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/* loaded from: classes3.dex */
public class Os implements FC {
    private MGA CMM;
    private String DbA;
    private boolean Dfc;
    private int FC;
    private nn KM;
    private ImageView.ScaleType MGA;
    private volatile boolean NU;
    private String Os;
    private boolean QX;
    private boolean Ue;
    private byte[] VM;
    private int Vy;
    private com.bytedance.sdk.component.ui.kb Xb;
    private wC aAs;
    private String aGH;
    private QX aqO;
    private int bf;
    private int dV;
    private int du;
    Future<?> eli;
    private com.bytedance.sdk.component.ui.DbA ev;
    private int gG;
    private Bitmap.Config kb;
    private final Handler nGm;
    private WeakReference<ImageView> nlS;
    private boolean nn;
    private aqO ui;
    private ExecutorService ujq;
    private int wC;

    private Os(DbA dbA) {
        this.nGm = new Handler(Looper.getMainLooper());
        this.QX = true;
        this.VM = null;
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
        this.ev = eli(dbA);
        if (!TextUtils.isEmpty(dbA.Os)) {
            DbA(dbA.Os);
            eli(dbA.Os);
        }
        this.nn = dbA.nlS;
        this.Dfc = dbA.NU;
        this.CMM = dbA.aqO;
        this.aAs = dbA.dV;
        this.gG = dbA.QX;
        this.Vy = dbA.nGm;
        this.ujq = dbA.Xb;
        this.Ue = dbA.bf;
        this.KM = dbA.CMM;
    }

    private com.bytedance.sdk.component.ui.DbA eli(DbA dbA) {
        if (dbA.Dfc != null) {
            return dbA.Dfc;
        }
        if (!TextUtils.isEmpty(dbA.nn)) {
            return com.bytedance.sdk.component.ui.aGH.Os.eli.DbA.eli(new File(dbA.nn));
        }
        return com.bytedance.sdk.component.ui.aGH.Os.eli.DbA.aAs();
    }

    public int MGA() {
        return this.Vy;
    }

    public int kb() {
        return this.gG;
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

    public void eli(boolean z) {
        this.QX = z;
    }

    public boolean NU() {
        return this.QX;
    }

    public void eli(byte[] bArr) {
        this.VM = bArr;
    }

    public byte[] nn() {
        return this.VM;
    }

    public com.bytedance.sdk.component.ui.kb Dfc() {
        return this.Xb;
    }

    public int aqO() {
        return this.bf;
    }

    public void eli(int i) {
        this.bf = i;
    }

    public MGA dV() {
        return this.CMM;
    }

    public com.bytedance.sdk.component.ui.DbA nGm() {
        return this.ev;
    }

    public nn QX() {
        return this.KM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FC bf() {
        try {
            if (this.CMM == null) {
                aqO aqo = this.ui;
                if (aqo != null) {
                    aqo.eli(1005, "not init !", null);
                    return this;
                }
            } else {
                String eli2 = eli();
                if (TextUtils.isEmpty(eli2)) {
                    this.ui.eli(2000, "url is empty", null);
                    return this;
                }
                bf MGA = this.CMM.MGA();
                if (!eli2.startsWith("http://") && !eli2.startsWith("https://") && MGA != null) {
                    MGA.eli(1006, "url is not validate ".concat(String.valueOf(eli2)));
                }
                ExecutorService ui = this.ujq == null ? this.CMM.ui() : null;
                Runnable runnable = new Runnable() { // from class: com.bytedance.sdk.component.ui.aGH.Os.Os.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Os os = Os.this;
                        com.bytedance.sdk.component.ui.aGH.Os.eli eliVar = new com.bytedance.sdk.component.ui.aGH.Os.eli(os, os.aqO);
                        try {
                            ArrayList arrayList = new ArrayList();
                            arrayList.add(new com.bytedance.sdk.component.ui.aGH.DbA.DbA());
                            arrayList.add(new com.bytedance.sdk.component.ui.aGH.DbA.ui());
                            arrayList.add(new com.bytedance.sdk.component.ui.aGH.DbA.eli());
                            arrayList.add(new com.bytedance.sdk.component.ui.aGH.DbA.Os());
                            arrayList.add(new com.bytedance.sdk.component.ui.aGH.DbA.aGH());
                            for (int i = 0; i < arrayList.size(); i++) {
                                if (Os.this.NU) {
                                    eliVar.eli(1003, "canceled", null);
                                    return;
                                }
                                com.bytedance.sdk.component.ui.aGH.DbA.MGA mga = (com.bytedance.sdk.component.ui.aGH.DbA.MGA) arrayList.get(i);
                                if (Os.this.aqO != null && mga != null && !"data_intercept".equals(mga.eli())) {
                                    Os.this.aqO.eli(mga.eli(), Os.this);
                                }
                                Os os2 = Os.this;
                                boolean eli3 = mga.eli(os2, os2.aqO, eliVar);
                                if (Os.this.aqO != null && !"data_intercept".equals(mga.eli())) {
                                    Os.this.aqO.DbA(mga.eli(), Os.this);
                                }
                                if (!eli3) {
                                    return;
                                }
                            }
                        } catch (Throwable th) {
                            eliVar.eli(2000, th.getMessage(), th);
                        }
                    }
                };
                if (this.Ue) {
                    runnable.run();
                    return this;
                }
                ExecutorService executorService = this.ujq;
                if (executorService != null) {
                    this.eli = executorService.submit(runnable);
                    return this;
                }
                if (ui != null) {
                    this.eli = ui.submit(runnable);
                    return this;
                }
            }
        } catch (Exception e) {
            Log.e("ImageRequest", e.getMessage());
        }
        return this;
    }

    public String Xb() {
        return aAs() + nlS();
    }

    public static class DbA implements aAs {
        private nn CMM;
        private ImageView DbA;
        private com.bytedance.sdk.component.ui.DbA Dfc;
        private Bitmap.Config MGA;
        private boolean NU;
        private String Os;
        private int QX;
        private ExecutorService Xb;
        private String aGH;
        private MGA aqO;
        private boolean bf;
        private wC dV;
        private QX du;
        private aqO eli;
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
            return new Os(this).bf();
        }

        @Override // com.bytedance.sdk.component.ui.aAs
        public FC eli(ImageView imageView) {
            this.DbA = imageView;
            return new Os(this).bf();
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
            if (imageView != null && Os.this.du != 3 && eli(imageView)) {
                Object DbA = duVar.DbA();
                if (DbA instanceof Bitmap) {
                    final Bitmap bitmap = (Bitmap) duVar.DbA();
                    Os.this.nGm.post(new Runnable() { // from class: com.bytedance.sdk.component.ui.aGH.Os.Os.eli.1
                        @Override // java.lang.Runnable
                        public void run() {
                            imageView.setImageBitmap(bitmap);
                        }
                    });
                } else if (DbA instanceof Drawable) {
                    final Drawable drawable = (Drawable) duVar.DbA();
                    Os.this.nGm.post(new Runnable() { // from class: com.bytedance.sdk.component.ui.aGH.Os.Os.eli.2
                        @Override // java.lang.Runnable
                        public void run() {
                            Drawable drawable2 = drawable;
                            if (drawable2 instanceof AnimatedImageDrawable) {
                                ((AnimatedImageDrawable) drawable2).start();
                            }
                            imageView.setImageDrawable(drawable);
                        }
                    });
                }
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
                Os.this.nGm.postAtFrontOfQueue(new Runnable() { // from class: com.bytedance.sdk.component.ui.aGH.Os.Os.eli.3
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
                Os.this.nGm.post(new Runnable() { // from class: com.bytedance.sdk.component.ui.aGH.Os.Os.eli.4
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
