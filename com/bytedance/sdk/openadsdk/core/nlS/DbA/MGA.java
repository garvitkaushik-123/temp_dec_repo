package com.bytedance.sdk.openadsdk.core.nlS.DbA;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bykv.vk.openvk.eli.eli.eli.aGH.Os;
import com.bytedance.sdk.component.utils.Ue;
import com.bytedance.sdk.component.utils.nGm;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.aGH.kb;
import com.bytedance.sdk.openadsdk.aGH.ui.DbA.Dfc;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd;
import com.bytedance.sdk.openadsdk.core.FC;
import com.bytedance.sdk.openadsdk.core.dV;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.core.nlS.DbA.Os;
import com.bytedance.sdk.openadsdk.core.nn;
import com.bytedance.sdk.openadsdk.core.nro;
import com.bytedance.sdk.openadsdk.core.wC.Vy;
import com.bytedance.sdk.openadsdk.utils.SSo;
import com.bytedance.sdk.openadsdk.utils.cyF;
import com.bytedance.sdk.openadsdk.utils.dZ;
import com.iab.omid.library.bytedance2.adsession.FriendlyObstructionPurpose;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public class MGA extends com.bytedance.sdk.openadsdk.core.ui.Os implements Os.eli, Ue.eli, Os.eli {
    private static final Integer CMM = 0;
    private static final Integer ev = 1;
    private boolean Cp;
    protected Os DbA;
    protected boolean Dfc;
    protected ImageView FC;
    private final Runnable FS;
    private final boolean GB;
    private boolean KM;
    public kb MGA;
    protected int NU;
    protected FrameLayout Os;
    private boolean QX;
    private ViewTreeObserver.OnGlobalLayoutListener SSo;
    private boolean Ue;
    private final AtomicBoolean Uv;
    private long VM;
    private String Vy;
    private boolean Xb;
    private final ViewTreeObserver.OnScrollChangedListener Za;
    protected ImageView aAs;
    protected boolean aGH;
    public DbA aqO;
    private String bf;
    private final String cyF;
    private final Context dV;
    private Os.InterfaceC0109Os dZ;
    protected boolean du;
    private View eU;
    protected final ev eli;
    private boolean gG;
    private final AtomicBoolean jh;
    protected RelativeLayout kb;
    private ViewGroup nGm;
    protected String nlS;
    boolean nn;
    private long nro;
    private final Handler oWW;
    private boolean qj;
    public boolean ui;
    private boolean ujq;
    protected ImageView wC;

    public interface DbA {
        void eli(boolean z, long j, long j2, long j3, boolean z2);
    }

    public interface eli {
        void eli(View view, int i);
    }

    @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.Os.eli
    public void DbA(long j, int i) {
    }

    public void setAdCreativeClickListener(eli eliVar) {
        Os os = this.DbA;
        if (os != null) {
            os.eli(eliVar);
        }
    }

    public void setVideoPlayCallback(com.bytedance.sdk.openadsdk.core.nlS.DbA.DbA dbA) {
        Os os = this.DbA;
        if (os != null) {
            os.eli(dbA);
        }
    }

    public void setControllerStatusCallBack(DbA dbA) {
        this.aqO = dbA;
    }

    @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.Os.eli
    public void eli(long j, int i) {
        Os.InterfaceC0109Os interfaceC0109Os = this.dZ;
        if (interfaceC0109Os != null) {
            interfaceC0109Os.j_();
        }
    }

    private void aGH() {
        eli(0L, 0);
        this.dZ = null;
    }

    @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.Os.eli
    public void eli() {
        new Object[]{"embeded_ad", "onTimeOut、、、、、、、、"};
    }

    @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.Os.eli
    public void eli(long j, long j2) {
        Os.InterfaceC0109Os interfaceC0109Os = this.dZ;
        if (interfaceC0109Os != null) {
            interfaceC0109Os.eli(j, j2);
        }
    }

    public MGA(Context context, ev evVar, boolean z, kb kbVar) {
        this(context, evVar, z, "embeded_ad", false, false, kbVar);
    }

    public MGA(Context context, ev evVar, String str, boolean z, boolean z2, kb kbVar) {
        this(context, evVar, false, str, z, z2, kbVar);
    }

    public MGA(Context context, ev evVar, kb kbVar) {
        this(context, evVar, false, kbVar);
    }

    public MGA(Context context, ev evVar, boolean z, String str, boolean z2, boolean z3, kb kbVar) {
        super(context);
        this.QX = true;
        this.aGH = true;
        this.Xb = false;
        this.ui = false;
        this.gG = true;
        this.ujq = false;
        this.Ue = true;
        this.du = true;
        this.nlS = "embeded_ad";
        this.NU = 50;
        this.KM = true;
        this.GB = false;
        this.oWW = new Ue(nn.DbA().getLooper(), this);
        this.Cp = false;
        this.cyF = Build.MODEL;
        this.nn = false;
        this.Dfc = true;
        this.Uv = new AtomicBoolean(false);
        this.FS = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nlS.DbA.MGA.4
            @Override // java.lang.Runnable
            public void run() {
                MGA mga = MGA.this;
                mga.eli(mga.qj, MGA.CMM.intValue());
            }
        };
        this.jh = new AtomicBoolean(false);
        this.Za = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.bytedance.sdk.openadsdk.core.nlS.DbA.MGA.6
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                MGA.this.nGm();
            }
        };
        try {
            if (evVar.fI()) {
                this.Vy = CacheDirFactory.getICacheDir(0).DbA();
            }
        } catch (Throwable unused) {
        }
        if (kbVar != null) {
            this.MGA = kbVar;
        }
        this.nlS = str;
        this.dV = context;
        this.eli = evVar;
        this.Xb = z;
        setContentDescription("NativeVideoTsView");
        this.ujq = z2;
        this.Ue = z3;
        DbA();
        ui();
    }

    protected void DbA() {
        ev evVar = this.eli;
        if (evVar == null) {
            return;
        }
        int RTg = evVar.RTg();
        int DbA2 = dV.aGH().DbA(RTg);
        int Os = nGm.Os(dV.eli());
        if (DbA2 == 1) {
            this.QX = dZ.aGH(Os);
        } else if (DbA2 == 2) {
            this.QX = dZ.ui(Os) || dZ.aGH(Os) || dZ.MGA(Os);
        } else if (DbA2 == 3) {
            this.QX = false;
        } else if (DbA2 == 4) {
            this.nn = true;
        } else if (DbA2 == 5) {
            this.QX = dZ.aGH(Os) || dZ.MGA(Os);
        }
        if (!this.Xb) {
            if (!this.ui || !Vy.DbA(this.nlS)) {
                this.aGH = dV.aGH().DbA(String.valueOf(RTg));
            }
        } else {
            this.aGH = false;
        }
        if ("open_ad".equals(this.nlS)) {
            this.QX = true;
            this.aGH = true;
        }
        if (Vy.DbA(this.nlS)) {
            this.aGH = true;
        }
        Os os = this.DbA;
        if (os != null) {
            os.aGH(this.QX);
        }
        this.ui = true;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        DbA dbA;
        Os os;
        if (!this.Xb && (dbA = this.aqO) != null && (os = this.DbA) != null) {
            dbA.eli(os.NU(), this.DbA.FC(), this.DbA.nro(), this.DbA.MGA(), this.QX);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    private View eli(Context context) {
        FrameLayout frameLayout = new FrameLayout(context);
        new FrameLayout.LayoutParams(-1, -1).gravity = 17;
        frameLayout.setVisibility(8);
        this.nGm = frameLayout;
        FrameLayout frameLayout2 = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        frameLayout2.setLayoutParams(layoutParams);
        frameLayout.addView(frameLayout2);
        this.Os = frameLayout2;
        View view = new View(context);
        view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        frameLayout.addView(view);
        this.eU = view;
        return frameLayout;
    }

    private RelativeLayout DbA(Context context) {
        com.bytedance.sdk.openadsdk.core.ui.kb kbVar = new com.bytedance.sdk.openadsdk.core.ui.kb(context);
        kbVar.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        kbVar.setVisibility(8);
        com.bytedance.sdk.openadsdk.core.ui.aGH agh = new com.bytedance.sdk.openadsdk.core.ui.aGH(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        agh.setLayoutParams(layoutParams);
        agh.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.wC = agh;
        com.bytedance.sdk.openadsdk.core.ui.aGH agh2 = new com.bytedance.sdk.openadsdk.core.ui.aGH(context);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        agh2.setLayoutParams(layoutParams2);
        agh2.setVisibility(8);
        agh2.setBackground(com.bytedance.sdk.component.utils.ev.Os(context, "tt_new_play_video"));
        this.aAs = agh2;
        kbVar.addView(agh);
        kbVar.addView(agh2);
        return kbVar;
    }

    private void ui() {
        addView(eli(this.dV));
        QX();
        addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.bytedance.sdk.openadsdk.core.nlS.DbA.MGA.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                MGA.this.nGm();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                MGA.this.nGm();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nGm() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Handler handler = this.oWW;
        if (handler == null || elapsedRealtime - this.nro <= 500) {
            return;
        }
        this.nro = elapsedRealtime;
        handler.sendEmptyMessageDelayed(1, 500L);
    }

    public void setVideoAdClickListenerTTNativeAd(PAGNativeAd pAGNativeAd) {
        Os os = this.DbA;
        if (os != null) {
            os.eli(pAGNativeAd);
        }
    }

    public void kb() {
        View view;
        if (this.dV == null || (view = this.eU) == null || view.getParent() == null || this.eli == null || this.kb != null) {
            return;
        }
        ViewParent parent = this.eU.getParent();
        RelativeLayout DbA2 = DbA(this.dV);
        if (parent != null && (parent instanceof ViewGroup)) {
            eli(DbA2, (ViewGroup) parent, this.eU);
        }
        this.kb = DbA2;
        if (this.du) {
            SSo.eli((View) this.aAs, 0);
        }
        if (this.eli.nY() != null && this.eli.nY().aAs() != null) {
            com.bytedance.sdk.openadsdk.nGm.DbA.DbA().eli(this.eli.nY().aAs(), this.eli.nY().Os(), this.eli.nY().DbA(), this.wC, this.eli);
        }
        ImageView imageView = this.aAs;
        if (imageView != null) {
            imageView.setClickable(true);
            this.aAs.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.nlS.DbA.MGA.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    MGA.this.Os();
                }
            });
        }
    }

    private void eli(View view, ViewGroup viewGroup, View view2) {
        int indexOfChild = viewGroup.indexOfChild(view2);
        viewGroup.removeViewInLayout(view2);
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        if (layoutParams != null) {
            viewGroup.addView(view, indexOfChild, layoutParams);
        } else {
            viewGroup.addView(view, indexOfChild);
        }
    }

    private void QX() {
        this.DbA = new Os(this.dV, this.Os, this.eli, this.nlS, !qj(), this.ujq, this.Ue, this.MGA);
        Xb();
        if (this.SSo == null) {
            this.SSo = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.bytedance.sdk.openadsdk.core.nlS.DbA.MGA.3
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    if (MGA.this.nGm == null || MGA.this.nGm.getViewTreeObserver() == null || MGA.this.DbA == null) {
                        return;
                    }
                    MGA.this.DbA.eli(MGA.this.nGm.getWidth(), MGA.this.nGm.getHeight());
                    MGA.this.nGm.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    MGA.this.SSo = null;
                }
            };
            this.nGm.getViewTreeObserver().addOnGlobalLayoutListener(this.SSo);
        }
    }

    public void setVideoAdLoadListener(Os.aGH agh) {
        Os os = this.DbA;
        if (os != null) {
            os.eli(agh);
        }
    }

    public boolean eli(long j, boolean z, boolean z2) {
        boolean z3 = false;
        this.nGm.setVisibility(0);
        this.VM = j;
        if (!qj()) {
            return true;
        }
        this.DbA.eli(false);
        ev evVar = this.eli;
        if (evVar != null && evVar.nY() != null) {
            com.bytedance.sdk.openadsdk.core.nlS.eli.DbA eli2 = ev.eli(CacheDirFactory.getICacheDir(this.eli.Sz()).Os(), this.eli);
            eli2.DbA(this.eli.umh());
            eli2.DbA(this.nGm.getWidth());
            eli2.Os(this.nGm.getHeight());
            eli2.Os(this.eli.eu());
            eli2.eli(j);
            eli2.eli(FC());
            eli(eli2);
            if (z2) {
                this.DbA.DbA(eli2);
                return true;
            }
            z3 = this.DbA.eli(eli2);
        }
        if (((j > 0 && !z && !z2) || (j > 0 && z)) && this.DbA != null) {
            Dfc.eli eliVar = new Dfc.eli();
            eliVar.DbA(this.DbA.MGA());
            eliVar.aGH(this.DbA.FC());
            eliVar.Os(this.DbA.kb());
            eliVar.Os(this.DbA.cyF());
            com.bytedance.sdk.openadsdk.aGH.ui.eli.eli.DbA(this.DbA.nlS(), eliVar);
        }
        return z3;
    }

    private void Xb() {
        Os os = this.DbA;
        if (os == null) {
            return;
        }
        os.aGH(this.QX);
        this.DbA.eli((Os.eli) this);
        this.DbA.eli((Os.eli) this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        bf();
        if (this.Dfc) {
            getViewTreeObserver().addOnScrollChangedListener(this.Za);
        }
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        bf();
    }

    private void bf() {
        Os os = this.DbA;
        if (os == null) {
            QX();
        } else if ((os instanceof Os) && !qj()) {
            this.DbA.aqO();
        }
        if (this.DbA == null || !this.Uv.get()) {
            return;
        }
        this.Uv.set(false);
        DbA();
        if (wC()) {
            SSo.eli((View) this.kb, 8);
            ImageView imageView = this.FC;
            if (imageView != null) {
                SSo.eli((View) imageView, 8);
            }
            ev evVar = this.eli;
            if (evVar == null || evVar.nY() == null) {
                return;
            }
            com.bytedance.sdk.openadsdk.core.nlS.eli.DbA eli2 = ev.eli(CacheDirFactory.getICacheDir(this.eli.Sz()).Os(), this.eli);
            eli2.DbA(this.eli.umh());
            eli2.DbA(this.nGm.getWidth());
            eli2.Os(this.nGm.getHeight());
            eli2.Os(this.eli.eu());
            eli2.eli(0L);
            eli2.eli(FC());
            eli(eli2);
            this.DbA.eli(eli2);
            this.DbA.DbA(false);
            return;
        }
        if (this.DbA.NU()) {
            this.DbA.NU();
            DbA(true);
        } else {
            kb();
            SSo.eli((View) this.kb, 0);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        CMM();
        if (this.Dfc) {
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnScrollChangedListener(this.Za);
            }
            ViewGroup viewGroup = this.nGm;
            if (viewGroup == null || this.SSo == null) {
                return;
            }
            ViewTreeObserver viewTreeObserver2 = viewGroup.getViewTreeObserver();
            if (viewTreeObserver2.isAlive()) {
                viewTreeObserver2.removeOnGlobalLayoutListener(this.SSo);
                this.SSo = null;
            }
        }
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        CMM();
    }

    private void CMM() {
        this.aqO = null;
        if ((this.DbA instanceof Os) && !qj()) {
            this.DbA.eU();
        }
        du();
        eli(false);
        ev();
    }

    private void ev() {
        if (!this.Uv.get()) {
            this.Uv.set(true);
            Os os = this.DbA;
            if (os != null) {
                os.eli(true, 3);
            }
        }
        this.jh.set(false);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 4 || i == 8) {
            ev();
        }
    }

    @Override // com.bytedance.sdk.component.utils.Ue.eli
    public void eli(Message message) {
        if (message.what == 1) {
            Vy();
        }
    }

    private void Vy() {
        this.qj = nlS();
        cyF.eli(this.FS);
    }

    private boolean gG() {
        ev evVar = this.eli;
        if (evVar == null) {
            return false;
        }
        return evVar.MBb();
    }

    private boolean ujq() {
        if (qj() || !gG()) {
            return false;
        }
        return com.bytedance.sdk.openadsdk.multipro.aGH.eli.eli("sp_multi_native_video_data", "key_video_is_from_detail_page", false) || com.bytedance.sdk.openadsdk.multipro.aGH.eli.eli("sp_multi_native_video_data", "key_video_isfromvideodetailpage", false);
    }

    private void Ue() {
        if (qj() || !gG()) {
            return;
        }
        com.bytedance.sdk.openadsdk.multipro.aGH.eli.eli("sp_multi_native_video_data", "key_video_isfromvideodetailpage", Boolean.FALSE);
        com.bytedance.sdk.openadsdk.multipro.aGH.eli.eli("sp_multi_native_video_data", "key_video_is_from_detail_page", Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eli(boolean z, int i) {
        if (this.eli == null || this.DbA == null) {
            return;
        }
        boolean ujq = ujq();
        Ue();
        if (ujq && this.DbA.NU()) {
            this.DbA.NU();
            DbA(true);
            aGH();
            return;
        }
        if (z && this.gG && !this.DbA.NU() && !this.DbA.ev()) {
            if (this.DbA.du() != null && this.DbA.du().kb()) {
                if (this.QX || i == 1) {
                    Os os = this.DbA;
                    if (os != null) {
                        eli(os.Vy(), "changeVideoStatus");
                    }
                    if ("ALP-AL00".equals(this.cyF)) {
                        this.DbA.Os();
                    } else {
                        if (!FC.DbA().Dfc()) {
                            ujq = true;
                        }
                        this.DbA.kb(ujq);
                    }
                    eli(false);
                    Os.InterfaceC0109Os interfaceC0109Os = this.dZ;
                    if (interfaceC0109Os != null) {
                        interfaceC0109Os.i_();
                        return;
                    }
                    return;
                }
                return;
            }
            if (this.QX && this.DbA.du() == null) {
                if (!this.Uv.get()) {
                    this.Uv.set(true);
                }
                this.jh.set(false);
                bf();
                return;
            }
            return;
        }
        if (this.DbA.du() == null || !this.DbA.du().MGA()) {
            return;
        }
        this.DbA.DbA();
        eli(true);
        Os.InterfaceC0109Os interfaceC0109Os2 = this.dZ;
        if (interfaceC0109Os2 != null) {
            interfaceC0109Os2.h_();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        Os os;
        Os os2;
        Os os3;
        Os os4;
        if (!"open_ad".equals(this.nlS)) {
            this.gG = z;
            super.onWindowFocusChanged(z);
            com.bytedance.sdk.openadsdk.Vy.eli.Os.eli(this.eli, z);
            VM();
            if (this.Dfc) {
                if (ujq() && (os4 = this.DbA) != null && os4.NU()) {
                    Ue();
                    SSo.eli((View) this.kb, 8);
                    DbA(true);
                    aGH();
                    return;
                }
                DbA();
                if (qj() || !wC() || (os2 = this.DbA) == null || os2.ev()) {
                    if (wC()) {
                        return;
                    }
                    if (!z && (os = this.DbA) != null && os.du() != null && this.DbA.du().MGA()) {
                        KM();
                        eli(false, CMM.intValue());
                        return;
                    } else {
                        if (z) {
                            this.oWW.obtainMessage(1).sendToTarget();
                            return;
                        }
                        return;
                    }
                }
                if (this.oWW != null) {
                    if (z && (os3 = this.DbA) != null && !os3.NU()) {
                        this.oWW.obtainMessage(1).sendToTarget();
                        return;
                    } else {
                        KM();
                        eli(false, CMM.intValue());
                        return;
                    }
                }
                return;
            }
            return;
        }
        KM();
    }

    private void KM() {
        this.oWW.removeMessages(1);
        nn.Os().removeCallbacks(this.FS);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        Os os;
        ev evVar;
        Os os2;
        Os os3;
        super.onWindowVisibilityChanged(i);
        VM();
        if (ujq() && (os3 = this.DbA) != null && os3.NU()) {
            Ue();
            SSo.eli((View) this.kb, 8);
            DbA(true);
            aGH();
            return;
        }
        DbA();
        if (qj() || !wC() || (os = this.DbA) == null || os.ev() || (evVar = this.eli) == null) {
            return;
        }
        if (this.KM && evVar.nY() != null) {
            this.eli.nY();
            com.bytedance.sdk.openadsdk.core.nlS.eli.DbA eli2 = ev.eli(CacheDirFactory.getICacheDir(this.eli.Sz()).Os(), this.eli);
            eli2.DbA(this.eli.umh());
            eli2.DbA(this.nGm.getWidth());
            eli2.Os(this.nGm.getHeight());
            eli2.Os(this.eli.eu());
            eli2.eli(this.VM);
            eli2.eli(FC());
            eli(eli2);
            this.DbA.eli(eli2);
            this.KM = false;
            SSo.eli((View) this.kb, 8);
        }
        if (i != 0 || !this.Dfc || this.oWW == null || (os2 = this.DbA) == null || os2.NU()) {
            return;
        }
        this.oWW.obtainMessage(1).sendToTarget();
    }

    private void VM() {
        if (this.DbA == null || qj()) {
            return;
        }
        if ((!gG() || com.bytedance.sdk.openadsdk.multipro.aGH.eli.eli("sp_multi_native_video_data", "key_video_is_update_flag", false)) && gG()) {
            long FC = this.DbA.FC();
            long kb = this.DbA.kb() + FC;
            boolean eli2 = com.bytedance.sdk.openadsdk.multipro.aGH.eli.eli("sp_multi_native_video_data", "key_native_video_complete", false);
            long eli3 = com.bytedance.sdk.openadsdk.multipro.aGH.eli.eli("sp_multi_native_video_data", "key_video_current_play_position", 0L);
            long eli4 = com.bytedance.sdk.openadsdk.multipro.aGH.eli.eli("sp_multi_native_video_data", "key_video_total_play_duration", kb);
            long eli5 = com.bytedance.sdk.openadsdk.multipro.aGH.eli.eli("sp_multi_native_video_data", "key_video_duration", FC);
            com.bytedance.sdk.openadsdk.multipro.aGH.eli.eli("sp_multi_native_video_data", "key_video_is_update_flag", Boolean.FALSE);
            this.DbA.DbA(eli2);
            this.DbA.DbA(eli3);
            this.DbA.Os(eli4);
            this.DbA.aGH(eli5);
        }
    }

    public Os getNativeVideoController() {
        return this.DbA;
    }

    public boolean wC() {
        return this.QX;
    }

    public void setIsAutoPlay(boolean z) {
        if (this.Cp) {
            return;
        }
        int DbA2 = dV.aGH().DbA(this.eli.RTg());
        if (z && DbA2 != 4 && (!nGm.ui(this.dV) ? !(!nGm.MGA(this.dV) ? nGm.aGH(this.dV) : GB() || oWW()) : !GB())) {
            z = false;
        }
        this.QX = z;
        Os os = this.DbA;
        if (os != null) {
            os.aGH(z);
        }
        if (!this.QX) {
            kb();
            RelativeLayout relativeLayout = this.kb;
            if (relativeLayout != null) {
                SSo.eli((View) relativeLayout, 0);
                ev evVar = this.eli;
                if (evVar != null && evVar.nY() != null) {
                    com.bytedance.sdk.openadsdk.nGm.DbA.DbA().eli(this.eli.nY().aAs(), this.eli.nY().Os(), this.eli.nY().DbA(), this.wC, this.eli);
                }
            }
        } else {
            SSo.eli((View) this.kb, 8);
        }
        this.Cp = true;
    }

    private boolean GB() {
        return 2 == dV.aGH().DbA(this.eli.RTg());
    }

    private boolean oWW() {
        return 5 == dV.aGH().DbA(this.eli.RTg());
    }

    public boolean FC() {
        return this.aGH;
    }

    public void eli(boolean z, String str) {
        if (Vy.DbA(this.nlS)) {
            z = true;
        }
        this.aGH = z;
        Os os = this.DbA;
        if (os != null) {
            os.eli(z, str);
        }
    }

    private boolean qj() {
        return this.Xb;
    }

    public void setVideoAdInteractionListener(Os.InterfaceC0109Os interfaceC0109Os) {
        this.dZ = interfaceC0109Os;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.DbA.Os.eli
    public void MGA() {
        Os.InterfaceC0109Os interfaceC0109Os = this.dZ;
        if (interfaceC0109Os != null) {
            interfaceC0109Os.g_();
        }
    }

    public void setNeedNativeVideoPlayBtnVisible(boolean z) {
        this.du = z;
    }

    public void setNeedSelfManagerVideo(boolean z) {
        this.Dfc = z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.DbA.Os.eli
    public void eli(int i) {
        DbA();
    }

    protected void Os() {
        if (NU()) {
            return;
        }
        Dfc();
    }

    protected void eli(boolean z) {
        if (this.FC == null) {
            this.FC = new ImageView(getContext());
            if (FC.DbA().aqO() != null) {
                this.FC.setImageBitmap(FC.DbA().aqO());
            } else {
                this.FC.setImageResource(com.bytedance.sdk.component.utils.ev.aGH(dV.eli(), "tt_new_play_video"));
            }
            this.FC.setScaleType(ImageView.ScaleType.FIT_XY);
            int DbA2 = SSo.DbA(getContext(), this.NU);
            int DbA3 = SSo.DbA(getContext(), 10.0f);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(DbA2, DbA2);
            layoutParams.gravity = 17;
            layoutParams.rightMargin = DbA3;
            layoutParams.bottomMargin = DbA3;
            this.nGm.addView(this.FC, layoutParams);
            this.FC.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.nlS.DbA.MGA.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MGA.this.Dfc();
                }
            });
        }
        if (z) {
            this.FC.setVisibility(0);
        } else {
            this.FC.setVisibility(8);
        }
    }

    public void DbA(boolean z) {
        Os os = this.DbA;
        if (os != null) {
            os.DbA(z);
            ui bf = this.DbA.nlS();
            if (bf != null) {
                bf.DbA();
                View Os = bf.Os();
                if (Os != null) {
                    if (Os.getParent() != null) {
                        ((ViewGroup) Os.getParent()).removeView(Os);
                    }
                    Os.setVisibility(0);
                    addView(Os);
                    bf.eli((ui) this.eli, new WeakReference<>(this.dV), false);
                }
            }
        }
    }

    public void aAs() {
        Os os = this.DbA;
        if (os != null) {
            ui bf = os.nlS();
            if (bf != null) {
                bf.eli();
            }
            nro();
        }
    }

    public void du() {
        ui bf;
        Os os = this.DbA;
        if (os == null || (bf = os.nlS()) == null) {
            return;
        }
        bf.eli();
        View Os = bf.Os();
        if (Os != null) {
            Os.setVisibility(8);
            if (Os.getParent() != null) {
                ((ViewGroup) Os.getParent()).removeView(Os);
            }
        }
    }

    private void nro() {
        SSo.ui(this.FC);
        SSo.ui(this.kb);
    }

    public void setVideoCacheUrl(String str) {
        this.bf = str;
    }

    boolean nlS() {
        return nro.eli(this, 50, Vy.DbA(this.nlS) ? 1 : 5, false);
    }

    public boolean NU() {
        boolean z = false;
        if (nGm.Os(dV.eli()) == 0) {
            return false;
        }
        if (this.DbA.du() != null && this.DbA.du().MGA()) {
            eli(false, CMM.intValue());
            Handler handler = this.oWW;
            z = true;
            if (handler != null) {
                handler.removeMessages(1);
            }
        }
        return z;
    }

    public void nn() {
        if (getNativeVideoController() == null || !(getNativeVideoController() instanceof Os)) {
            return;
        }
        Os nativeVideoController = getNativeVideoController();
        nativeVideoController.eli(nativeVideoController.nlS(), this);
    }

    public void Dfc() {
        if (nGm.Os(dV.eli()) != 0 && nlS()) {
            if (this.DbA.du() != null) {
                if (this.DbA.du().kb()) {
                    eli(true, ev.intValue());
                    DbA();
                    Handler handler = this.oWW;
                    if (handler != null) {
                        handler.sendEmptyMessageDelayed(1, 500L);
                        return;
                    }
                    return;
                }
                if (this.DbA.du().DbA() && !this.Dfc) {
                    aAs();
                    Os os = this.DbA;
                    if (os instanceof Os) {
                        os.SSo();
                        return;
                    }
                    return;
                }
            }
            if (wC() || this.jh.get()) {
                return;
            }
            this.jh.set(true);
            nro();
            ev evVar = this.eli;
            if (evVar != null && evVar.nY() != null) {
                nro();
                this.eli.nY();
                com.bytedance.sdk.openadsdk.core.nlS.eli.DbA eli2 = ev.eli(CacheDirFactory.getICacheDir(this.eli.Sz()).Os(), this.eli);
                eli2.DbA(this.eli.umh());
                eli2.DbA(this.nGm.getWidth());
                eli2.Os(this.nGm.getHeight());
                eli2.Os(this.eli.eu());
                eli2.eli(this.VM);
                eli2.eli(FC());
                eli2.eli(CacheDirFactory.getICacheDir(this.eli.Sz()).Os());
                eli(eli2);
                this.DbA.eli(eli2);
            }
            Handler handler2 = this.oWW;
            if (handler2 != null) {
                handler2.sendEmptyMessageDelayed(1, 500L);
            }
            eli(false);
        }
    }

    public double getCurrentPlayTime() {
        if (this.DbA != null) {
            return (r0.MGA() * 1.0d) / 1000.0d;
        }
        return 0.0d;
    }

    public void aqO() {
        com.bytedance.sdk.openadsdk.core.model.aGH UCq;
        com.bytedance.sdk.openadsdk.core.du.aGH eli2;
        ev evVar = this.eli;
        if (evVar == null || (UCq = evVar.UCq()) == null || (eli2 = UCq.eli()) == null) {
            return;
        }
        eli2.ui(this.VM);
    }

    public com.bytedance.sdk.openadsdk.core.du.MGA eli(List<Pair<View, FriendlyObstructionPurpose>> list) {
        Os os = this.DbA;
        if (os instanceof Os) {
            return os.eli(this, list);
        }
        return null;
    }

    private void eli(com.bykv.vk.openvk.eli.eli.eli.Os.Os os) {
        try {
            if (this.eli.fI()) {
                os.eli(this.Vy);
            }
        } catch (Throwable unused) {
        }
    }
}
