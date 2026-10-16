package com.bytedance.sdk.openadsdk.core.nlS.eli;

import android.app.Activity;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Looper;
import android.os.Message;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import com.bykv.vk.openvk.eli.eli.eli.aGH.Os;
import com.bytedance.sdk.component.utils.Ue;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.aGH.kb;
import com.bytedance.sdk.openadsdk.aGH.ui.DbA.Dfc;
import com.bytedance.sdk.openadsdk.core.dV;
import com.bytedance.sdk.openadsdk.core.du.MGA;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.core.nlS.DbA.ui;
import com.bytedance.sdk.openadsdk.core.widget.QX;
import com.bytedance.sdk.openadsdk.dV.aGH;
import com.bytedance.sdk.openadsdk.utils.dZ;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public abstract class eli implements Os, Ue.eli, com.bytedance.sdk.openadsdk.core.nlS.DbA.eli {
    protected boolean CMM;
    protected boolean GB;
    protected Os.eli KM;
    protected com.bytedance.sdk.openadsdk.core.nlS.aGH.Os MGA;
    protected WeakReference<Os.DbA> Ue;
    protected MGA VM;
    protected DbA Vy;
    protected SurfaceHolder aGH;
    protected boolean aqO;
    private long cyF;
    protected final Context du;
    protected boolean gG;
    protected ui kb;
    protected long nro;
    protected long oWW;
    protected SurfaceTexture ui;
    protected final ViewGroup ujq;
    protected final ev wC;
    protected String eli = "TTAD.VideoController";
    protected final int DbA = 100;
    protected final Ue Os = new Ue(Looper.getMainLooper(), this);
    protected long FC = 0;
    protected long aAs = 0;
    protected final List<Runnable> nlS = new ArrayList();
    protected boolean NU = false;
    protected boolean nn = false;
    protected boolean Dfc = true;
    protected boolean dV = false;
    protected boolean nGm = false;
    protected boolean QX = false;
    protected AtomicBoolean Xb = new AtomicBoolean(false);
    protected AtomicBoolean bf = new AtomicBoolean(false);
    protected boolean ev = true;
    protected boolean qj = false;
    protected Runnable Cp = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nlS.eli.eli.1
        @Override // java.lang.Runnable
        public void run() {
            new Object[]{"resumeVideo: run ", Boolean.valueOf(eli.this.NU)};
            eli.this.Xb();
        }
    };
    private long eU = 0;
    private boolean dZ = true;
    private int SSo = 1;
    private final AtomicBoolean Uv = new AtomicBoolean(false);

    @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.Os
    public boolean Dfc() {
        return true;
    }

    @Override // com.bytedance.sdk.component.utils.Ue.eli
    public void eli(Message message) {
    }

    public void eli(com.bykv.vk.openvk.eli.eli.eli.aGH.DbA dbA, View view, boolean z) {
    }

    public void eli(Os.aGH agh) {
    }

    public long dV() {
        return this.oWW;
    }

    public eli(Context context, ev evVar, ViewGroup viewGroup) {
        this.wC = evVar;
        this.du = context;
        this.ujq = viewGroup;
        this.eli += hashCode();
    }

    protected void nGm() {
        if (this.MGA == null) {
            return;
        }
        if (aqO()) {
            SurfaceTexture surfaceTexture = this.ui;
            if (surfaceTexture == null || surfaceTexture == this.MGA.Xb()) {
                return;
            }
            this.MGA.eli(this.ui);
            return;
        }
        SurfaceHolder surfaceHolder = this.aGH;
        if (surfaceHolder == null || surfaceHolder == this.MGA.QX()) {
            return;
        }
        this.MGA.eli(this.aGH);
    }

    @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.Os
    public boolean eli(com.bykv.vk.openvk.eli.eli.eli.Os.Os os) {
        if (!ev.MGA(this.wC)) {
            return false;
        }
        com.bytedance.sdk.openadsdk.dV.Os.eli(new aGH() { // from class: com.bytedance.sdk.openadsdk.core.nlS.eli.eli.2
            @Override // com.bytedance.sdk.openadsdk.dV.aGH
            public com.bytedance.sdk.openadsdk.dV.DbA.eli generatorModel() {
                com.bytedance.sdk.openadsdk.dV.DbA.eli eliVar = new com.bytedance.sdk.openadsdk.dV.DbA.eli();
                try {
                    eliVar.DbA("video_player");
                    eliVar.aGH(dZ.eli(eli.this.wC));
                    eliVar.eli(BuildConfig.VERSION_NAME);
                } catch (Throwable unused) {
                }
                return eliVar;
            }
        });
        return false;
    }

    private boolean aqO() {
        ui uiVar = this.kb;
        if (uiVar != null) {
            return uiVar.NU() instanceof com.bykv.vk.openvk.eli.eli.eli.MGA.aGH;
        }
        return false;
    }

    @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.Os
    public long MGA() {
        return this.FC;
    }

    public void DbA(long j) {
        this.FC = j;
        this.aAs = Math.max(this.aAs, j);
    }

    protected void eli(Runnable runnable) {
        if (this.kb.CMM() && this.NU) {
            runnable.run();
        } else {
            DbA(runnable);
        }
    }

    protected void DbA(Runnable runnable) {
        this.nlS.add(runnable);
    }

    protected void QX() {
        if (this.nlS.isEmpty()) {
            return;
        }
        Iterator it = new ArrayList(this.nlS).iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        this.nlS.clear();
    }

    @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.eli
    public void eli(com.bykv.vk.openvk.eli.eli.eli.aGH.DbA dbA, SurfaceHolder surfaceHolder) {
        this.NU = true;
        this.aGH = surfaceHolder;
        com.bytedance.sdk.openadsdk.core.nlS.aGH.Os os = this.MGA;
        if (os == null) {
            return;
        }
        os.eli(surfaceHolder);
        QX();
    }

    @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.eli
    public void DbA(com.bykv.vk.openvk.eli.eli.eli.aGH.DbA dbA, SurfaceHolder surfaceHolder) {
        this.NU = false;
        this.aGH = null;
        com.bytedance.sdk.openadsdk.core.nlS.aGH.Os os = this.MGA;
        if (os != null) {
            os.eli(false);
        }
    }

    @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.eli
    public void eli(com.bykv.vk.openvk.eli.eli.eli.aGH.DbA dbA, SurfaceTexture surfaceTexture) {
        this.NU = true;
        this.ui = surfaceTexture;
        com.bytedance.sdk.openadsdk.core.nlS.aGH.Os os = this.MGA;
        if (os != null) {
            os.eli(surfaceTexture);
            this.MGA.eli(this.NU);
        }
        QX();
    }

    @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.eli
    public void DbA(com.bykv.vk.openvk.eli.eli.eli.aGH.DbA dbA, SurfaceTexture surfaceTexture) {
        this.NU = false;
        com.bytedance.sdk.openadsdk.core.nlS.aGH.Os os = this.MGA;
        if (os != null) {
            os.eli(false);
        }
        this.ui = null;
        QX();
    }

    protected void Xb() {
        this.Os.postAtFrontOfQueue(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nlS.eli.eli.3
            @Override // java.lang.Runnable
            public void run() {
                if (eli.this.MGA != null) {
                    new Object[]{"resumeVideo: execResumePlay", Boolean.valueOf(eli.this.NU)};
                    eli.this.MGA.aAs();
                }
            }
        });
    }

    @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.Os
    public com.bykv.vk.openvk.eli.eli.eli.eli du() {
        return this.MGA;
    }

    @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.Os
    /* renamed from: bf, reason: merged with bridge method [inline-methods] */
    public final ui nlS() {
        return this.kb;
    }

    public boolean CMM() {
        return this.Dfc;
    }

    public void eli(boolean z) {
        this.Dfc = z;
        ui uiVar = this.kb;
        if (uiVar != null) {
            uiVar.aGH(z);
        }
    }

    public void Os(long j) {
        this.eU = j;
    }

    public boolean ev() {
        return this.dV;
    }

    public void aGH(long j) {
        this.nro = j;
    }

    @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.Os
    public final long kb() {
        com.bytedance.sdk.openadsdk.core.nlS.aGH.Os os = this.MGA;
        if (os == null) {
            return 0L;
        }
        return os.Dfc();
    }

    @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.Os
    public final int wC() {
        com.bytedance.sdk.openadsdk.core.nlS.aGH.Os os = this.MGA;
        if (os == null) {
            return 0;
        }
        return os.aqO();
    }

    public boolean Vy() {
        return this.aqO;
    }

    @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.Os
    public final void eli(final boolean z, String str) {
        this.aqO = z;
        com.bytedance.sdk.openadsdk.core.nlS.aGH.Os os = this.MGA;
        if (os != null) {
            os.DbA(z);
            com.bytedance.sdk.openadsdk.aGH.ui.eli.eli.eli(this.kb, z, str);
        }
        if (this.VM != null) {
            if (com.bykv.vk.openvk.eli.eli.DbA.DbA.eli.eli()) {
                this.VM.eli(z);
            } else {
                this.Os.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nlS.eli.eli.4
                    @Override // java.lang.Runnable
                    public void run() {
                        eli.this.VM.eli(z);
                    }
                });
            }
        }
    }

    @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.Os
    public final long FC() {
        com.bytedance.sdk.openadsdk.core.nlS.aGH.Os os = this.MGA;
        if (os == null) {
            return 0L;
        }
        return os.dV();
    }

    @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.Os
    public boolean NU() {
        return this.nn;
    }

    public final void DbA(boolean z) {
        this.nn = z;
    }

    protected void Os(boolean z) {
        this.QX = z;
    }

    public boolean gG() {
        return this.dZ;
    }

    public final void aGH(boolean z) {
        this.dZ = z;
    }

    public void DbA(com.bykv.vk.openvk.eli.eli.eli.Os.Os os) {
        DbA dbA = (DbA) os;
        this.Vy = dbA;
        this.aqO = dbA.du();
        os.aGH(String.valueOf(this.wC.RTg()));
    }

    @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.Os
    public final boolean nn() {
        return this.gG;
    }

    @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.Os
    public final int aAs() {
        return com.bykv.vk.openvk.eli.eli.DbA.aGH.eli.eli(this.aAs, this.nro);
    }

    public void ui(boolean z) {
        this.ev = z;
    }

    @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.eli
    public final void DbA(com.bykv.vk.openvk.eli.eli.eli.aGH.DbA dbA, View view) {
        DbA(dbA, view, false, false);
    }

    public final void DbA(com.bykv.vk.openvk.eli.eli.eli.aGH.DbA dbA, View view, boolean z, boolean z2) {
        Os(!this.QX);
        Context context = this.du;
        if (context != null && (context instanceof Activity)) {
            if (this.QX) {
                eli(z ? 8 : 0);
                ui uiVar = this.kb;
                if (uiVar != null) {
                    uiVar.eli(this.ujq);
                    this.kb.Os(false);
                }
            } else {
                eli(1);
                ui uiVar2 = this.kb;
                if (uiVar2 != null) {
                    uiVar2.DbA(this.ujq);
                    this.kb.Os(false);
                }
            }
            WeakReference<Os.DbA> weakReference = this.Ue;
            Os.DbA dbA2 = weakReference != null ? weakReference.get() : null;
            if (dbA2 != null) {
                dbA2.eli(this.QX);
            }
        }
    }

    public final void eli(Os.DbA dbA) {
        this.Ue = new WeakReference<>(dbA);
    }

    @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.eli
    public final void ui(com.bykv.vk.openvk.eli.eli.eli.aGH.DbA dbA, View view) {
        eli(dbA, view, false);
    }

    public final boolean ujq() {
        com.bytedance.sdk.openadsdk.core.nlS.aGH.Os os = this.MGA;
        return os == null || os.DbA();
    }

    public final boolean Ue() {
        com.bytedance.sdk.openadsdk.core.nlS.aGH.Os os = this.MGA;
        return os != null && os.MGA();
    }

    public final void eli(int i) {
        Context context = this.du;
        if (context == null) {
            return;
        }
        boolean z = i == 0 || i == 8;
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            try {
                activity.setRequestedOrientation(i);
            } catch (Throwable unused) {
            }
            if (!z) {
                activity.getWindow().setFlags(1024, 1024);
            } else {
                activity.getWindow().clearFlags(1024);
            }
        }
    }

    @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.eli
    public final void Os(com.bykv.vk.openvk.eli.eli.eli.aGH.DbA dbA, View view) {
        ui uiVar = this.kb;
        if (uiVar != null) {
            uiVar.FC();
        }
        eli(true, 3);
    }

    @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.eli
    public final void eli(com.bykv.vk.openvk.eli.eli.eli.aGH.DbA dbA, View view, boolean z, boolean z2) {
        if (this.Dfc) {
            DbA();
        }
        if (z && !this.Dfc && !ujq()) {
            this.kb.DbA(!Ue(), false);
            this.kb.eli(z2, true, false);
        }
        com.bytedance.sdk.openadsdk.core.nlS.aGH.Os os = this.MGA;
        if (os != null && os.MGA()) {
            this.kb.MGA();
            this.kb.ui();
        } else {
            this.kb.MGA();
        }
    }

    @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.eli
    public final void aGH(com.bykv.vk.openvk.eli.eli.eli.aGH.DbA dbA, View view) {
        if (this.QX) {
            Os(false);
            ui uiVar = this.kb;
            if (uiVar != null) {
                uiVar.DbA(this.ujq);
            }
            eli(1);
            return;
        }
        eli(true, 3);
    }

    @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.eli
    public final void eli(com.bykv.vk.openvk.eli.eli.eli.aGH.DbA dbA, int i, boolean z) {
        if (this.du == null) {
            return;
        }
        long j = (long) (((i * r0) * 1.0f) / 100.0f);
        if (this.nro > 0) {
            this.cyF = (int) j;
        } else {
            this.cyF = 0L;
        }
        ui uiVar = this.kb;
        if (uiVar != null) {
            uiVar.eli(this.cyF);
        }
    }

    @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.eli
    public final void eli(com.bykv.vk.openvk.eli.eli.eli.aGH.DbA dbA, int i) {
        if (this.MGA == null) {
            return;
        }
        eli(this.cyF, Os(i));
    }

    @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.eli
    public final void DbA(com.bykv.vk.openvk.eli.eli.eli.aGH.DbA dbA, int i) {
        ui uiVar = this.kb;
        if (uiVar != null) {
            uiVar.MGA();
        }
    }

    private void eli(long j, boolean z) {
        if (this.MGA == null) {
            return;
        }
        if (z) {
            eU();
        }
        this.MGA.eli(j);
    }

    private boolean Os(int i) {
        return this.kb.DbA(i);
    }

    private void eU() {
        ui uiVar = this.kb;
        if (uiVar != null) {
            uiVar.aGH(0);
            this.kb.eli(false, false);
            this.kb.Os(false);
            this.kb.ui();
            this.kb.kb();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void KM() {
        if (ev.MGA(this.wC) && this.bf.compareAndSet(false, true)) {
            com.bytedance.sdk.openadsdk.dV.Os.DbA(new aGH() { // from class: com.bytedance.sdk.openadsdk.core.nlS.eli.eli.5
                @Override // com.bytedance.sdk.openadsdk.dV.aGH
                public com.bytedance.sdk.openadsdk.dV.DbA.eli generatorModel() {
                    com.bytedance.sdk.openadsdk.dV.DbA.eli eliVar = new com.bytedance.sdk.openadsdk.dV.DbA.eli();
                    try {
                        eliVar.DbA("video_player");
                        eliVar.aGH(dZ.eli(eli.this.wC));
                        eliVar.eli(BuildConfig.VERSION_NAME);
                    } catch (Throwable unused) {
                    }
                    return eliVar;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void eli(kb kbVar) {
        boolean z = false;
        if (this.Xb.compareAndSet(false, true)) {
            this.qj = true;
            MGA mga = this.VM;
            if (mga != null) {
                mga.eli(FC(), Vy());
            }
            Dfc.eli eliVar = new Dfc.eli();
            eliVar.eli(gG());
            eliVar.aGH(FC());
            com.bytedance.sdk.openadsdk.core.nlS.aGH.Os os = this.MGA;
            if (os != null && os.nn()) {
                z = true;
            }
            eliVar.DbA(z);
            eliVar.Os(this.GB);
            com.bytedance.sdk.openadsdk.aGH.ui.eli.eli.eli(dV.eli(), this.kb, eliVar, kbVar);
        }
    }

    protected final void VM() {
        this.qj = true;
        Dfc.eli eliVar = new Dfc.eli();
        eliVar.DbA(MGA());
        eliVar.aGH(FC() / qj());
        eliVar.Os(kb());
        eliVar.Os(this.GB);
        com.bytedance.sdk.openadsdk.aGH.ui.eli.eli.DbA(nlS(), eliVar);
    }

    protected final void GB() {
        this.qj = true;
        Dfc.eli eliVar = new Dfc.eli();
        eliVar.DbA(MGA());
        eliVar.aGH(FC() / qj());
        eliVar.Os(kb());
        eliVar.eli(dV());
        eliVar.Os(this.GB);
        com.bytedance.sdk.openadsdk.aGH.ui.eli.eli.eli(this.kb, eliVar);
    }

    protected final void DbA(kb kbVar) {
        this.qj = true;
        Dfc.eli eliVar = new Dfc.eli();
        eliVar.DbA(MGA());
        eliVar.aGH(FC() / qj());
        eliVar.Os(kb());
        eliVar.aGH(wC());
        eliVar.eli(dV());
        eliVar.Os(this.GB);
        com.bytedance.sdk.openadsdk.aGH.ui.eli.eli.DbA(this.kb, eliVar, kbVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void eli(com.bykv.vk.openvk.eli.eli.eli.Os.eli eliVar) {
        this.qj = true;
        Dfc.eli eliVar2 = new Dfc.eli();
        eliVar2.Os(kb());
        eliVar2.aGH(FC() / qj());
        eliVar2.DbA(MGA());
        eliVar2.eli(eliVar);
        eliVar2.Os(this.GB);
        com.bytedance.sdk.openadsdk.aGH.ui.eli.eli.Os(nlS(), eliVar2);
    }

    protected final void oWW() {
        this.qj = true;
        com.bytedance.sdk.openadsdk.aGH.ui.eli.eli.eli(this.wC, this.kb, this.Vy);
    }

    public int qj() {
        return this.SSo;
    }

    public void DbA(int i) {
        this.SSo = i;
    }

    @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.Os
    public final void eli(Os.eli eliVar) {
        this.KM = eliVar;
    }

    /* renamed from: com.bytedance.sdk.openadsdk.core.nlS.eli.eli$6, reason: invalid class name */
    static /* synthetic */ class AnonymousClass6 {
        static final /* synthetic */ int[] eli;

        static {
            int[] iArr = new int[QX.eli.values().length];
            eli = iArr;
            try {
                iArr[QX.eli.PAUSE_VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                eli[QX.eli.RELEASE_VIDEO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                eli[QX.eli.START_VIDEO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.DbA.eli
    public final void eli(QX.eli eliVar, String str) {
        int i = AnonymousClass6.eli[eliVar.ordinal()];
        if (i == 1) {
            DbA();
            return;
        }
        if (i == 2) {
            aGH();
        } else {
            if (i != 3) {
                return;
            }
            Os();
            this.dV = false;
            this.nGm = true;
        }
    }

    public final long nro() {
        return MGA() + kb();
    }

    @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.Os
    public final void DbA() {
        com.bytedance.sdk.openadsdk.core.nlS.aGH.Os os = this.MGA;
        if (os != null) {
            os.du();
        }
        if (this.CMM || !this.Xb.get()) {
            return;
        }
        GB();
    }

    @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.Os
    public void eli(long j) {
        this.oWW = j;
    }

    @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.Os
    public boolean eli(float f) {
        com.bytedance.sdk.openadsdk.core.nlS.aGH.Os os = this.MGA;
        if (os != null) {
            return os.eli(f);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void Cp() {
        com.bytedance.sdk.openadsdk.aGH.eli.aGH.eli(com.bytedance.sdk.openadsdk.Vy.eli.eli(this.wC.ID(), true, this.wC), 5, this.wC.umh());
    }

    public final void ui(long j) {
        this.FC = j;
        this.aAs = Math.max(this.aAs, j);
        ui uiVar = this.kb;
        if (uiVar != null) {
            uiVar.eli();
        }
        com.bytedance.sdk.openadsdk.core.nlS.aGH.Os os = this.MGA;
        if (os != null) {
            os.eli(true, this.FC, this.aqO);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eli(long j, long j2) {
        if (!this.Uv.get() && com.bytedance.sdk.openadsdk.MGA.eli.eli().Os() && (j * 1.0d) / j2 > 0.3d) {
            this.Uv.set(true);
            if (this.wC != null) {
                com.bytedance.sdk.openadsdk.MGA.DbA.eli().eli("videoPercent30", this.wC);
            }
        }
    }

    @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.Os
    public void eli(SurfaceTexture surfaceTexture) {
        this.GB = true;
    }

    public boolean cyF() {
        return this.GB;
    }
}
