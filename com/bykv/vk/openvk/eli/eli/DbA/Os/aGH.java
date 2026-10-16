package com.bykv.vk.openvk.eli.eli.DbA.Os;

import android.graphics.SurfaceTexture;
import android.media.PlaybackParams;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.bykv.vk.openvk.eli.eli.DbA.Os.Os;
import com.bykv.vk.openvk.eli.eli.eli.eli;
import com.bytedance.sdk.component.utils.Ue;
import com.bytedance.sdk.component.utils.Xb;
import com.bytedance.sdk.component.wC.FC;
import com.vungle.ads.internal.protos.Sdk;
import java.io.File;
import java.io.FileInputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class aGH implements Os.DbA, Os.MGA, Os.InterfaceC0108Os, Os.aGH, Os.eli, Os.kb, Os.ui, com.bykv.vk.openvk.eli.eli.eli.eli, Ue.eli {
    private static final SparseIntArray eli = new SparseIntArray();
    private volatile boolean Cp;
    private SurfaceHolder MGA;
    private boolean NU;
    private boolean Ue;
    private boolean Uv;
    private ArrayList<Runnable> Vy;
    private Ue aqO;
    private boolean ev;
    private boolean nlS;
    private SurfaceTexture ui;
    private final boolean DbA = false;
    private final List<WeakReference<eli.InterfaceC0110eli>> Os = new CopyOnWriteArrayList();
    private final eli aGH = new eli();
    private int kb = 0;
    private int wC = 3;
    private boolean FC = false;
    private volatile Os aAs = null;
    private boolean du = false;
    private volatile int nn = 201;
    private long Dfc = -1;
    private boolean dV = false;
    private long nGm = 0;
    private long QX = Long.MIN_VALUE;
    private long Xb = 0;
    private long bf = 0;
    private long CMM = 0;
    private int gG = 0;
    private String ujq = "0";
    private com.bykv.vk.openvk.eli.eli.eli.Os.Os KM = null;
    private boolean VM = false;
    private CountDownLatch GB = new CountDownLatch(1);
    private volatile int oWW = 200;
    private AtomicBoolean qj = new AtomicBoolean(false);
    private Surface nro = null;
    private long cyF = 0;
    private long eU = 0;
    private boolean dZ = false;
    private final Runnable SSo = new Runnable() { // from class: com.bykv.vk.openvk.eli.eli.DbA.Os.aGH.1
        @Override // java.lang.Runnable
        public void run() {
            if (aGH.this.aAs == null) {
                return;
            }
            long nGm = aGH.this.nGm();
            if (nGm > 0 && aGH.this.MGA() && aGH.this.QX != Long.MIN_VALUE) {
                try {
                    if (aGH.this.QX == nGm) {
                        if (!aGH.this.dV && aGH.this.Xb >= 400) {
                            aGH.this.DbA(701, 800);
                            aGH.this.dV = true;
                        }
                        aGH.this.Xb += aGH.this.oWW;
                    } else {
                        if (aGH.this.dV) {
                            aGH.this.nGm += aGH.this.Xb;
                            aGH.this.DbA(702, 800);
                            new Object[]{"handleMsg:  bufferingDuration =", Long.valueOf(aGH.this.nGm), "  bufferCount =", Integer.valueOf(aGH.this.kb)};
                        }
                        aGH.this.Xb = 0L;
                        aGH.this.dV = false;
                    }
                } catch (Throwable th) {
                    th.getMessage();
                }
            }
            if (aGH.this.dV() > 0) {
                if (aGH.this.QX != nGm) {
                    if (com.bykv.vk.openvk.eli.eli.eli.Os.ui()) {
                        new Object[]{"run: lastCur = ", Long.valueOf(aGH.this.QX), "  curPosition = ", Long.valueOf(nGm)};
                    }
                    aGH agh = aGH.this;
                    agh.eli(nGm, agh.dV());
                }
                aGH.this.QX = nGm;
            }
            if (!aGH.this.DbA()) {
                if (aGH.this.aqO != null) {
                    aGH.this.aqO.postDelayed(this, aGH.this.oWW);
                }
            } else {
                aGH agh2 = aGH.this;
                agh2.eli(agh2.dV(), aGH.this.dV());
            }
        }
    };

    private boolean eli(int i, int i2) {
        boolean z = i == -1010 || i == -1007 || i == -1004 || i == -110 || i == 100 || i == 200;
        if (i2 == 1 || i2 == 700 || i2 == 800) {
            return true;
        }
        return z;
    }

    public aGH() {
        eli("SSMediaPlayerWrapper");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eli(long j, long j2) {
        long j3;
        long j4;
        for (WeakReference<eli.InterfaceC0110eli> weakReference : this.Os) {
            if (weakReference == null || weakReference.get() == null) {
                j3 = j;
                j4 = j2;
            } else {
                j3 = j;
                j4 = j2;
                weakReference.get().eli(this, j3, j4);
            }
            j = j3;
            j2 = j4;
        }
    }

    private void eli(String str) {
        this.gG = 0;
        this.aqO = com.bytedance.sdk.component.wC.eli.eli.eli().eli(this, FC.THREAD_NAME_PRE.concat(String.valueOf(str)));
        this.dZ = true;
        CMM();
    }

    private void bf() {
        this.nGm = 0L;
        this.kb = 0;
        this.Xb = 0L;
        this.dV = false;
        this.QX = Long.MIN_VALUE;
    }

    public void eli(final boolean z) {
        if (wC()) {
            return;
        }
        this.Ue = z;
        if (this.aAs != null) {
            this.aAs.eli(z);
            return;
        }
        Ue ue = this.aqO;
        if (ue != null) {
            ue.post(new Runnable() { // from class: com.bykv.vk.openvk.eli.eli.DbA.Os.aGH.9
                @Override // java.lang.Runnable
                public void run() {
                    if (aGH.this.aAs != null) {
                        aGH.this.aAs.eli(z);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CMM() {
        Ue ue = this.aqO;
        if (ue != null) {
            ue.post(new Runnable() { // from class: com.bykv.vk.openvk.eli.eli.DbA.Os.aGH.10
                @Override // java.lang.Runnable
                public void run() {
                    if (aGH.this.aAs == null) {
                        try {
                            aGH.this.aAs = new DbA();
                        } catch (Throwable th) {
                            th.getMessage();
                        }
                        if (aGH.this.aAs == null) {
                            return;
                        }
                        Os unused = aGH.this.aAs;
                        aGH.this.ujq = "0";
                        aGH.this.aAs.eli((Os.ui) aGH.this);
                        aGH.this.aAs.eli((Os.DbA) aGH.this);
                        aGH.this.aAs.eli((Os.InterfaceC0108Os) aGH.this);
                        aGH.this.aAs.eli((Os.eli) aGH.this);
                        aGH.this.aAs.eli((Os.MGA) aGH.this);
                        aGH.this.aAs.eli((Os.aGH) aGH.this);
                        aGH.this.aAs.eli((Os.kb) aGH.this);
                        try {
                            aGH.this.aAs.Os(false);
                        } catch (Throwable unused2) {
                        }
                        aGH.this.du = false;
                    }
                }
            });
        }
    }

    public void FC() {
        if (wC() || this.aAs == null) {
            return;
        }
        this.qj.set(true);
        if (this.nn != 206) {
            bf();
            this.Cp = false;
            this.aGH.eli(true);
            DbA(0L);
            Ue ue = this.aqO;
            if (ue != null) {
                ue.removeCallbacks(this.SSo);
                this.aqO.postDelayed(this.SSo, this.oWW);
            }
        }
        this.GB.countDown();
    }

    public void eli(boolean z, long j, boolean z2) {
        if (wC()) {
            return;
        }
        CMM();
        this.VM = z2;
        this.qj.set(true);
        this.Cp = false;
        DbA(z2);
        if (z) {
            this.Dfc = j;
            ev();
        } else {
            DbA(j);
        }
        Ue ue = this.aqO;
        if (ue != null) {
            ue.removeCallbacks(this.SSo);
            this.aqO.postDelayed(this.SSo, this.oWW);
        }
        this.GB.countDown();
    }

    private void DbA(long j) {
        this.aGH.eli(j);
        if (this.Ue) {
            DbA(this.aGH);
        } else if (DbA(this.KM)) {
            DbA(this.aGH);
        } else {
            eli(this.aGH);
        }
    }

    private boolean DbA(com.bykv.vk.openvk.eli.eli.eli.Os.Os os) {
        return os != null && os.kb();
    }

    public void aAs() {
        if (wC() || this.aqO == null) {
            return;
        }
        this.qj.set(true);
        this.aqO.post(new Runnable() { // from class: com.bykv.vk.openvk.eli.eli.DbA.Os.aGH.11
            @Override // java.lang.Runnable
            public void run() {
                if (!aGH.this.kb() || aGH.this.aAs == null) {
                    return;
                }
                try {
                    aGH.this.aAs.MGA();
                    for (WeakReference weakReference : aGH.this.Os) {
                        if (weakReference != null && weakReference.get() != null) {
                            ((eli.InterfaceC0110eli) weakReference.get()).ui(aGH.this);
                        }
                    }
                    aGH.this.nn = 206;
                } catch (Throwable th) {
                    new Object[]{"play: catch exception ", th.getMessage()};
                }
            }
        });
    }

    public void du() {
        Ue ue;
        if (wC() || (ue = this.aqO) == null) {
            return;
        }
        ue.removeMessages(100);
        this.Cp = true;
        if (!this.dZ) {
            if (this.ev || DbA(this.KM)) {
                Ue ue2 = this.aqO;
                if (ue2 != null) {
                    ue2.sendEmptyMessage(101);
                    return;
                }
                return;
            }
            eli(new Runnable() { // from class: com.bykv.vk.openvk.eli.eli.DbA.Os.aGH.12
                @Override // java.lang.Runnable
                public void run() {
                    if (aGH.this.aqO != null) {
                        aGH.this.aqO.sendEmptyMessage(101);
                    }
                }
            });
            return;
        }
        if (this.FC || DbA(this.KM)) {
            Ue ue3 = this.aqO;
            if (ue3 != null) {
                ue3.sendEmptyMessage(101);
                return;
            }
            return;
        }
        eli(new Runnable() { // from class: com.bykv.vk.openvk.eli.eli.DbA.Os.aGH.13
            @Override // java.lang.Runnable
            public void run() {
                if (aGH.this.aqO != null) {
                    aGH.this.aqO.sendEmptyMessage(101);
                }
            }
        });
    }

    public void nlS() {
        if (wC()) {
            return;
        }
        this.NU = true;
        oWW();
        Ue ue = this.aqO;
        if (ue != null) {
            try {
                ue.removeCallbacksAndMessages(null);
                if (this.aAs != null) {
                    this.aqO.sendEmptyMessage(103);
                }
                gG();
            } catch (Throwable unused) {
                gG();
            }
        }
    }

    private void ev() {
        DbA(new Runnable() { // from class: com.bykv.vk.openvk.eli.eli.DbA.Os.aGH.14
            @Override // java.lang.Runnable
            public void run() {
                if (aGH.this.aqO != null) {
                    aGH.this.aqO.sendEmptyMessage(104);
                }
            }
        });
    }

    public void eli(final long j) {
        if (wC()) {
            return;
        }
        if (this.nn == 207 || this.nn == 206 || this.nn == 209) {
            DbA(new Runnable() { // from class: com.bykv.vk.openvk.eli.eli.DbA.Os.aGH.2
                @Override // java.lang.Runnable
                public void run() {
                    if (aGH.this.aqO != null) {
                        aGH.this.aqO.obtainMessage(106, Long.valueOf(j)).sendToTarget();
                    }
                }
            });
        }
    }

    @Override // com.bykv.vk.openvk.eli.eli.eli.eli
    public boolean eli() {
        return this.FC;
    }

    public void eli(final SurfaceTexture surfaceTexture) {
        if (wC()) {
            return;
        }
        this.ui = surfaceTexture;
        eli(true);
        DbA(new Runnable() { // from class: com.bykv.vk.openvk.eli.eli.DbA.Os.aGH.3
            @Override // java.lang.Runnable
            public void run() {
                aGH.this.CMM();
                if (aGH.this.aqO != null) {
                    aGH.this.aqO.obtainMessage(111, surfaceTexture).sendToTarget();
                }
            }
        });
    }

    public void eli(final SurfaceHolder surfaceHolder) {
        if (wC()) {
            return;
        }
        this.MGA = surfaceHolder;
        eli(true);
        DbA(new Runnable() { // from class: com.bykv.vk.openvk.eli.eli.DbA.Os.aGH.4
            @Override // java.lang.Runnable
            public void run() {
                aGH.this.CMM();
                if (aGH.this.aqO != null) {
                    aGH.this.aqO.obtainMessage(110, surfaceHolder).sendToTarget();
                }
            }
        });
    }

    public void eli(final com.bykv.vk.openvk.eli.eli.eli.Os.Os os) {
        if (wC()) {
            return;
        }
        this.KM = os;
        if (os != null) {
            this.dZ = this.dZ && !os.kb();
        }
        DbA(new Runnable() { // from class: com.bykv.vk.openvk.eli.eli.DbA.Os.aGH.5
            @Override // java.lang.Runnable
            public void run() {
                aGH.this.CMM();
                if (aGH.this.aqO != null) {
                    aGH.this.aqO.obtainMessage(107, os).sendToTarget();
                }
            }
        });
    }

    @Override // com.bykv.vk.openvk.eli.eli.eli.eli
    public boolean MGA() {
        Ue ue;
        return (this.nn == 206 || ((ue = this.aqO) != null && ue.hasMessages(100))) && !this.Cp;
    }

    @Override // com.bykv.vk.openvk.eli.eli.eli.eli
    public boolean Os() {
        return NU() || MGA() || kb();
    }

    @Override // com.bykv.vk.openvk.eli.eli.eli.eli
    public boolean kb() {
        Ue ue;
        return ((this.nn != 207 && !this.Cp) || (ue = this.aqO) == null || ue.hasMessages(100)) ? false : true;
    }

    @Override // com.bykv.vk.openvk.eli.eli.eli.eli
    public boolean wC() {
        return this.NU;
    }

    public boolean NU() {
        return this.nn == 205;
    }

    @Override // com.bykv.vk.openvk.eli.eli.eli.eli
    public boolean DbA() {
        return this.nn == 209;
    }

    @Override // com.bytedance.sdk.component.utils.Ue.eli
    public void eli(Message message) {
        int i = this.nn;
        int i2 = message.what;
        if (this.aAs != null) {
            try {
                switch (message.what) {
                    case 100:
                        if (this.nn == 205 || this.nn == 207 || this.nn == 209) {
                            this.aAs.MGA();
                            this.CMM = SystemClock.elapsedRealtime();
                            this.nn = 206;
                            long j = this.Dfc;
                            if (j > 0) {
                                new Object[]{"[video] OP_START, seekTo:", Long.valueOf(j), Integer.valueOf(this.wC)};
                                this.aAs.eli(this.Dfc, this.wC);
                                this.Dfc = -1L;
                            }
                            if (this.KM != null) {
                                DbA(this.VM);
                                return;
                            }
                            return;
                        }
                        break;
                    case 101:
                        if (this.dV) {
                            this.nGm += this.Xb;
                        }
                        this.dV = false;
                        this.Xb = 0L;
                        this.QX = Long.MIN_VALUE;
                        if (this.nn == 206 || this.nn == 207 || this.nn == 209) {
                            this.aAs.wC();
                            this.nn = 207;
                            this.Cp = false;
                            for (WeakReference<eli.InterfaceC0110eli> weakReference : this.Os) {
                                if (weakReference != null && weakReference.get() != null) {
                                    weakReference.get().aGH(this);
                                }
                            }
                            return;
                        }
                        break;
                    case 102:
                        this.aAs.NU();
                        this.nn = 201;
                        return;
                    case 103:
                        try {
                            Vy();
                        } catch (Throwable unused) {
                        }
                        for (WeakReference<eli.InterfaceC0110eli> weakReference2 : this.Os) {
                            if (weakReference2 != null && weakReference2.get() != null) {
                                weakReference2.get().Os(this);
                            }
                        }
                        this.nn = 203;
                        return;
                    case 104:
                        if (this.nn == 202 || this.nn == 208) {
                            this.aAs.FC();
                            return;
                        }
                        break;
                    case 105:
                        if (this.nn == 205 || this.nn == 206 || this.nn == 208 || this.nn == 207 || this.nn == 209) {
                            this.aAs.kb();
                            this.nn = 208;
                            return;
                        }
                        break;
                    case 106:
                        if (this.nn == 206 || this.nn == 207 || this.nn == 209) {
                            this.aAs.eli(((Long) message.obj).longValue(), this.wC);
                            return;
                        }
                        break;
                    case 107:
                        bf();
                        if (this.nn == 201 || this.nn == 203) {
                            com.bykv.vk.openvk.eli.eli.eli.Os.Os os = (com.bykv.vk.openvk.eli.eli.eli.Os.Os) message.obj;
                            if (TextUtils.isEmpty(os.ui())) {
                                os.eli(com.bykv.vk.openvk.eli.eli.eli.Os.DbA());
                            }
                            if (os.gG()) {
                                this.aAs.eli(os.aqO());
                                os.aqO();
                            } else {
                                File file = new File(os.ui(), os.dV());
                                if (file.exists()) {
                                    eli(os, file);
                                } else {
                                    Os(os);
                                }
                            }
                            this.nn = 202;
                            return;
                        }
                        break;
                    case 108:
                    case 109:
                    default:
                        return;
                    case 110:
                        this.aAs.eli((SurfaceHolder) message.obj);
                        this.aAs.DbA(true);
                        this.GB.await(1L, TimeUnit.SECONDS);
                        GB();
                        return;
                    case 111:
                        this.nro = new Surface((SurfaceTexture) message.obj);
                        this.aAs.eli(this.nro);
                        this.aAs.DbA(true);
                        this.GB.await(1L, TimeUnit.SECONDS);
                        GB();
                        return;
                }
                this.nn = 200;
                if (this.du) {
                    return;
                }
                com.bykv.vk.openvk.eli.eli.eli.Os.eli eliVar = new com.bykv.vk.openvk.eli.eli.eli.Os.eli(308, i2);
                eliVar.eli(i + "," + i2);
                for (WeakReference<eli.InterfaceC0110eli> weakReference3 : this.Os) {
                    if (weakReference3 != null && weakReference3.get() != null) {
                        weakReference3.get().eli(this, eliVar);
                    }
                }
                this.du = true;
            } catch (Throwable unused2) {
            }
        }
    }

    private void eli(com.bykv.vk.openvk.eli.eli.eli.Os.Os os, File file) {
        if (os.eli()) {
            DbA(os, file);
        } else {
            eli(file);
        }
    }

    private void eli(File file) {
        file.getAbsolutePath();
        try {
            if (com.bykv.vk.openvk.eli.eli.eli.Os.Os()) {
                DbA(file.getAbsolutePath());
            } else {
                this.aAs.eli(file.getAbsolutePath());
            }
        } catch (Throwable unused) {
        }
    }

    private void DbA(com.bykv.vk.openvk.eli.eli.eli.Os.Os os, File file) {
        try {
            String eli2 = com.bykv.vk.openvk.eli.eli.eli.kb.eli.eli(file);
            if (os.dV().equals(eli2)) {
                eli(file);
                return;
            }
            JSONObject Os = os.Os();
            boolean DbA = os.DbA();
            if (Os != null) {
                Os.put("file_hash", os.dV());
                Os.put("file_real_hash", eli2);
                Os.put("is_change_play_type", DbA ? 1 : 0);
                Os.put("error_real_code", Sdk.SDKError.Reason.ASSET_FAILED_TO_DELETE_VALUE);
                Os.put("error_real_msg", "md5_not_match");
            }
            if (DbA) {
                boolean delete = file.delete();
                if (Os != null) {
                    Os.put("delete_cache_file", delete ? 1 : 0);
                }
                if (delete) {
                    Os(os);
                    return;
                }
            }
            eli(file);
        } catch (Throwable unused) {
        }
    }

    private void Os(com.bykv.vk.openvk.eli.eli.eli.Os.Os os) throws Throwable {
        os.aqO();
        this.aAs.eli(os);
        os.aqO();
    }

    private void DbA(String str) throws Throwable {
        FileInputStream fileInputStream = new FileInputStream(str);
        this.aAs.eli(fileInputStream.getFD());
        fileInputStream.close();
    }

    private void Vy() {
        if (this.aAs == null) {
            return;
        }
        try {
            this.aAs.NU();
        } catch (Throwable unused) {
        }
        this.aAs.eli((Os.DbA) null);
        this.aAs.eli((Os.kb) null);
        this.aAs.eli((Os.eli) null);
        this.aAs.eli((Os.aGH) null);
        this.aAs.eli((Os.InterfaceC0108Os) null);
        this.aAs.eli((Os.ui) null);
        this.aAs.eli((Os.MGA) null);
        try {
            this.aAs.nlS();
        } catch (Throwable unused2) {
        }
    }

    private void gG() {
        Ue ue = this.aqO;
        if (ue == null || ue.getLooper() == null) {
            return;
        }
        try {
            this.aqO.post(new Runnable() { // from class: com.bykv.vk.openvk.eli.eli.DbA.Os.aGH.6
                @Override // java.lang.Runnable
                public void run() {
                    if (aGH.this.aqO == null || aGH.this.aqO.getLooper() == null) {
                        return;
                    }
                    try {
                        com.bytedance.sdk.component.wC.eli.eli.eli().eli(aGH.this.aqO);
                        aGH.this.aqO = null;
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    @Override // com.bykv.vk.openvk.eli.eli.DbA.Os.Os.eli
    public void eli(Os os, int i) {
        if (this.aAs != os) {
            return;
        }
        for (WeakReference<eli.InterfaceC0110eli> weakReference : this.Os) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().DbA(this, i);
            }
        }
    }

    private void ujq() {
        SparseIntArray sparseIntArray = eli;
        Integer valueOf = Integer.valueOf(sparseIntArray.get(this.gG));
        if (valueOf == null) {
            sparseIntArray.put(this.gG, 1);
        } else {
            sparseIntArray.put(this.gG, valueOf.intValue() + 1);
        }
    }

    @Override // com.bykv.vk.openvk.eli.eli.DbA.Os.Os.DbA
    public void eli(Os os) {
        this.nn = 209;
        eli.delete(this.gG);
        Ue ue = this.aqO;
        if (ue != null) {
            ue.removeCallbacks(this.SSo);
        }
        for (WeakReference<eli.InterfaceC0110eli> weakReference : this.Os) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().eli(this);
            }
        }
    }

    @Override // com.bykv.vk.openvk.eli.eli.DbA.Os.Os.InterfaceC0108Os
    public boolean eli(Os os, int i, int i2) {
        ujq();
        this.nn = 200;
        Ue ue = this.aqO;
        if (ue != null) {
            ue.removeCallbacks(this.SSo);
        }
        if (eli(i, i2)) {
            gG();
        }
        if (!this.qj.get()) {
            return true;
        }
        this.qj.set(false);
        com.bykv.vk.openvk.eli.eli.eli.Os.eli eliVar = new com.bykv.vk.openvk.eli.eli.eli.Os.eli(i, i2);
        for (WeakReference<eli.InterfaceC0110eli> weakReference : this.Os) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().eli(this, eliVar);
            }
        }
        return true;
    }

    @Override // com.bykv.vk.openvk.eli.eli.DbA.Os.Os.aGH
    public boolean DbA(Os os, int i, int i2) {
        if (this.aAs != os) {
            return false;
        }
        if (i2 == -1004) {
            com.bykv.vk.openvk.eli.eli.eli.Os.eli eliVar = new com.bykv.vk.openvk.eli.eli.eli.Os.eli(i, i2);
            for (WeakReference<eli.InterfaceC0110eli> weakReference : this.Os) {
                if (weakReference != null && weakReference.get() != null) {
                    weakReference.get().eli(this, eliVar);
                }
            }
        }
        DbA(i, i2);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DbA(int i, int i2) {
        if (i == 701) {
            this.cyF = SystemClock.elapsedRealtime();
            this.kb++;
            for (WeakReference<eli.InterfaceC0110eli> weakReference : this.Os) {
                if (weakReference != null && weakReference.get() != null) {
                    weakReference.get().eli(this, Integer.MAX_VALUE, 0, 0);
                }
            }
            new Object[]{"bufferCount = ", Integer.valueOf(this.kb)};
            return;
        }
        if (i == 702) {
            if (this.cyF > 0) {
                this.eU += SystemClock.elapsedRealtime() - this.cyF;
                this.cyF = 0L;
            }
            for (WeakReference<eli.InterfaceC0110eli> weakReference2 : this.Os) {
                if (weakReference2 != null && weakReference2.get() != null) {
                    weakReference2.get().eli((com.bykv.vk.openvk.eli.eli.eli.eli) this, Integer.MAX_VALUE);
                }
            }
            new Object[]{"bufferCount = ", Integer.valueOf(this.kb), " mBufferTotalTime = ", Long.valueOf(this.eU)};
            return;
        }
        if (this.dZ && i == 3) {
            GB();
            Ue();
            DbA(this.VM);
        } else if (i == 805) {
            this.Uv = true;
        }
    }

    public boolean nn() {
        return this.Uv;
    }

    @Override // com.bykv.vk.openvk.eli.eli.DbA.Os.Os.ui
    public void DbA(Os os) {
        if (wC()) {
            return;
        }
        this.nn = 205;
        try {
            com.bykv.vk.openvk.eli.eli.eli.Os.Os os2 = this.KM;
            if (os2 != null) {
                float Dfc = os2.Dfc();
                if (Dfc > 0.0f) {
                    com.bykv.vk.openvk.eli.eli.eli.DbA dbA = new com.bykv.vk.openvk.eli.eli.eli.DbA();
                    dbA.eli(Dfc);
                    this.aAs.eli(dbA);
                }
            }
        } catch (Throwable unused) {
        }
        if (this.aqO != null) {
            if (this.Cp) {
                KM();
            } else {
                Ue ue = this.aqO;
                ue.sendMessage(ue.obtainMessage(100, -1, -1));
            }
        }
        eli.delete(this.gG);
        boolean z = this.dZ;
        boolean z2 = this.ev;
        if (!z && !z2) {
            Ue();
            this.ev = true;
        }
        for (WeakReference<eli.InterfaceC0110eli> weakReference : this.Os) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().DbA(this);
            }
        }
    }

    private void Ue() {
        this.FC = true;
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.CMM;
        for (WeakReference<eli.InterfaceC0110eli> weakReference : this.Os) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().eli(this, elapsedRealtime);
            }
        }
    }

    private void KM() {
        Ue ue = this.aqO;
        if (ue != null) {
            ue.post(new Runnable() { // from class: com.bykv.vk.openvk.eli.eli.DbA.Os.aGH.7
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        aGH.this.aAs.wC();
                        aGH.this.nn = 207;
                        aGH.this.Cp = false;
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    @Override // com.bykv.vk.openvk.eli.eli.DbA.Os.Os.MGA
    public void Os(Os os) {
        for (WeakReference<eli.InterfaceC0110eli> weakReference : this.Os) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().eli((com.bykv.vk.openvk.eli.eli.eli.eli) this, true);
            }
        }
    }

    private void eli(Runnable runnable) {
        try {
            if (this.Vy == null) {
                this.Vy = new ArrayList<>();
            }
            this.Vy.add(runnable);
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    private void VM() {
        if (this.nlS) {
            return;
        }
        this.nlS = true;
        Iterator it = new ArrayList(this.Vy).iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        this.Vy.clear();
        this.nlS = false;
    }

    private void GB() {
        ArrayList<Runnable> arrayList = this.Vy;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        VM();
    }

    private void oWW() {
        ArrayList<Runnable> arrayList = this.Vy;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        this.Vy.clear();
    }

    private void DbA(Runnable runnable) {
        if (runnable == null || wC()) {
            return;
        }
        if (!this.NU) {
            runnable.run();
        } else {
            eli(runnable);
        }
    }

    public void DbA(final boolean z) {
        Ue ue;
        if (wC() || (ue = this.aqO) == null) {
            return;
        }
        ue.post(new Runnable() { // from class: com.bykv.vk.openvk.eli.eli.DbA.Os.aGH.8
            @Override // java.lang.Runnable
            public void run() {
                if (aGH.this.wC() || aGH.this.aAs == null) {
                    return;
                }
                try {
                    aGH.this.VM = z;
                    aGH.this.aAs.aGH(z);
                } catch (Throwable unused) {
                }
            }
        });
    }

    public long Dfc() {
        if (this.dV) {
            long j = this.Xb;
            if (j > 0) {
                return this.nGm + j;
            }
        }
        return this.nGm;
    }

    @Override // com.bykv.vk.openvk.eli.eli.eli.eli
    public int aGH() {
        if (this.aAs == null || wC()) {
            return 0;
        }
        return this.aAs.nn();
    }

    @Override // com.bykv.vk.openvk.eli.eli.eli.eli
    public int ui() {
        if (this.aAs == null || wC()) {
            return 0;
        }
        return this.aAs.Dfc();
    }

    public int aqO() {
        return this.kb;
    }

    @Override // com.bykv.vk.openvk.eli.eli.DbA.Os.Os.kb
    public void eli(Os os, int i, int i2, int i3, int i4) {
        for (WeakReference<eli.InterfaceC0110eli> weakReference : this.Os) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().eli((com.bykv.vk.openvk.eli.eli.eli.eli) this, i, i2);
            }
        }
    }

    public long dV() {
        long j = this.bf;
        if (j != 0) {
            return j;
        }
        if (this.nn == 206 || this.nn == 207) {
            try {
                this.bf = this.aAs.du();
            } catch (Throwable unused) {
            }
        }
        return this.bf;
    }

    public long nGm() {
        if (wC()) {
            return 0L;
        }
        if (this.nn == 206 || this.nn == 207) {
            try {
                return this.aAs.aAs();
            } catch (Throwable unused) {
            }
        }
        return 0L;
    }

    public void eli(eli.InterfaceC0110eli interfaceC0110eli) {
        if (interfaceC0110eli == null) {
            return;
        }
        for (WeakReference<eli.InterfaceC0110eli> weakReference : this.Os) {
            if (weakReference != null && weakReference.get() == interfaceC0110eli) {
                return;
            }
        }
        this.Os.add(new WeakReference<>(interfaceC0110eli));
    }

    public void eli(int i) {
        if (wC()) {
            return;
        }
        this.oWW = i;
    }

    public SurfaceHolder QX() {
        return this.MGA;
    }

    public SurfaceTexture Xb() {
        return this.ui;
    }

    public void DbA(int i) {
        this.wC = i;
    }

    public boolean eli(float f) {
        PlaybackParams playbackParams;
        if (f <= 0.0f) {
            return false;
        }
        try {
            if (this.aAs == null || !Os()) {
                return false;
            }
            try {
                playbackParams = this.aAs.ui();
            } catch (Throwable th) {
                Xb.Os("CSJ_VIDEO_MEDIA", "getPlaybackParams error:" + th.getMessage());
                playbackParams = null;
            }
            if ((playbackParams != null ? playbackParams.getSpeed() : 0.0f) == f) {
                return true;
            }
            com.bykv.vk.openvk.eli.eli.eli.DbA dbA = new com.bykv.vk.openvk.eli.eli.eli.DbA();
            dbA.eli(f);
            this.aAs.eli(dbA);
            return true;
        } catch (Throwable th2) {
            Xb.eli("CSJ_VIDEO_MEDIA", "setPlaySpeedRatio error: ", th2);
            return false;
        }
    }

    class eli implements Runnable {
        private long DbA;
        private boolean Os;

        eli() {
        }

        public void eli(boolean z) {
            this.Os = z;
        }

        public void eli(long j) {
            this.DbA = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (aGH.this.aAs != null) {
                try {
                    if (!this.Os) {
                        long aAs = aGH.this.aAs.aAs();
                        aGH.this.Dfc = Math.max(this.DbA, aAs);
                    }
                    long unused = aGH.this.Dfc;
                } catch (Throwable th) {
                    new StringBuilder("[video] MediaPlayerProxy#start  error: getCurrentPosition :").append(th);
                }
            }
            if (aGH.this.aqO != null) {
                aGH.this.aqO.sendEmptyMessageDelayed(100, 0L);
            }
        }
    }
}
