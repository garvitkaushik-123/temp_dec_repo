package com.bytedance.sdk.openadsdk.activity;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.activity.DbA;
import com.bytedance.sdk.openadsdk.component.reward.eli.nlS;
import com.bytedance.sdk.openadsdk.component.reward.top.TopLayoutDislike2;
import com.bytedance.sdk.openadsdk.core.CMM;
import com.bytedance.sdk.openadsdk.core.Xb;
import com.bytedance.sdk.openadsdk.core.bf;
import com.bytedance.sdk.openadsdk.core.dV;
import com.bytedance.sdk.openadsdk.core.model.KM;
import com.bytedance.sdk.openadsdk.core.model.Vy;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.core.model.ujq;
import com.bytedance.sdk.openadsdk.core.nn;
import com.bytedance.sdk.openadsdk.core.widget.PAGLogoView;
import com.bytedance.sdk.openadsdk.utils.SSo;
import com.bytedance.sdk.openadsdk.utils.cyF;
import com.google.firebase.messaging.Constants;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class aGH extends com.bytedance.sdk.openadsdk.activity.Os implements Handler.Callback {
    private boolean CMM;
    private Vy.eli Cp;
    private final boolean Dfc;
    private final Handler FC;
    private JSONObject FS;
    private DbA.ui GB;
    private int KM;
    private final eli MGA;
    private final HashSet<String> NU;
    private MGA QI;
    private boolean QX;
    private FrameLayout SSo;
    private Message TfR;
    private boolean Ue;
    private boolean Uv;
    private wC VM;
    private boolean Vy;
    private boolean WfR;
    private int Xb;
    private long Yw;
    private long Za;
    private final FrameLayout aAs;
    private final HashSet<Integer> aqO;
    private int bf;
    private int cyF;
    private final PAGLogoView dV;
    private boolean dZ;
    private final boolean du;
    private JSONObject eU;
    private int ev;
    private int gG;
    private long ikX;
    private JSONObject jh;
    private final LinearLayoutManager kb;
    private boolean mm;
    private final ArrayList<Message> nGm;
    private final AtomicBoolean nlS;
    private final boolean nn;
    private boolean nro;
    private int oWW;
    private View oc;
    private boolean ow;
    private com.bytedance.sdk.openadsdk.activity.ui qj;
    private boolean qyC;
    private boolean rQ;
    private boolean tGZ;
    private final RecyclerView ui;
    private boolean ujq;
    private final TopLayoutDislike2 wC;

    @Override // com.bytedance.sdk.openadsdk.activity.Os
    public com.bytedance.sdk.openadsdk.component.reward.top.Os NU() {
        return null;
    }

    public aGH(final Activity activity, final ev evVar, final com.bytedance.sdk.openadsdk.activity.DbA dbA) {
        super(activity, evVar, dbA);
        Vy nlS;
        this.FC = new Handler(Looper.getMainLooper(), this);
        boolean z = false;
        this.nlS = new AtomicBoolean(false);
        this.NU = new HashSet<>();
        this.aqO = new HashSet<>();
        this.nGm = new ArrayList<>();
        this.Xb = 5;
        this.bf = 3;
        this.KM = -1;
        int i = 1;
        this.GB = new DbA.ui(1, null);
        boolean z2 = evVar.mm() == 44;
        this.nn = z2;
        boolean Txb = evVar.Txb();
        this.du = Txb;
        this.Dfc = nlS.eli(activity, evVar) == 1;
        com.bytedance.sdk.openadsdk.core.ui.Os os = new com.bytedance.sdk.openadsdk.core.ui.Os(activity) { // from class: com.bytedance.sdk.openadsdk.activity.aGH.1
            @Override // android.view.ViewGroup, android.view.View
            public boolean dispatchTouchEvent(MotionEvent motionEvent) {
                aGH.this.FS = null;
                return super.dispatchTouchEvent(motionEvent);
            }
        };
        this.aAs = os;
        if (Build.VERSION.SDK_INT >= 35) {
            os.setFitsSystemWindows(true);
        }
        activity.setContentView(os);
        com.bytedance.sdk.openadsdk.core.model.eli Os2 = evVar.Os();
        if (Os2 != null && (nlS = Os2.nlS()) != null) {
            this.nro = nlS.Dfc();
            this.Cp = nlS.MGA();
            this.oWW = Math.max(0, nlS.FC());
            this.ujq = nlS.nn();
            this.Vy = nlS.du();
            this.ev = nlS.wC();
            this.eU = nlS.nlS();
            this.CMM = nlS.aAs();
            this.QX = nlS.eli();
            this.dZ = this.ev > 0;
            this.Xb = nlS.aGH();
            this.bf = nlS.ui();
            this.FS = nlS.DbA();
            this.jh = nlS.Os();
            if (!this.Vy) {
                this.nro = false;
            }
        }
        if (Txb) {
            this.gG = (int) ((1.0f - (Math.max(0, Math.min(100, evVar.tLO() < 0 ? dV.aGH().gG(String.valueOf(evVar.RTg())).MGA : r3)) / 100.0f)) * this.oWW);
        }
        RecyclerView recyclerView = new RecyclerView(activity);
        this.ui = recyclerView;
        Vy.eli eliVar = this.Cp;
        if (eliVar != null) {
            int Os3 = eliVar.Os();
            int aGH = this.Cp.aGH();
            if (Os3 > 0 || aGH > 0) {
                recyclerView.setPadding(SSo.DbA(activity, Os3), 0, SSo.DbA(activity, aGH), 0);
            }
            int DbA2 = this.Cp.DbA();
            int eli2 = this.Cp.eli();
            int ui2 = this.Cp.ui();
            if (DbA2 > 0 || ui2 > 0 || eli2 > 0) {
                final int DbA3 = SSo.DbA(activity, DbA2);
                final int DbA4 = SSo.DbA(activity, eli2);
                final int DbA5 = SSo.DbA(activity, ui2);
                recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.bytedance.sdk.openadsdk.activity.aGH.12
                    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
                    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView2, RecyclerView.State state) {
                        int childAdapterPosition = recyclerView2.getChildAdapterPosition(view);
                        int itemCount = recyclerView2.getAdapter().getItemCount();
                        if (childAdapterPosition == 0) {
                            rect.top = DbA3;
                        } else {
                            rect.top = DbA5 / 2;
                        }
                        if (childAdapterPosition == itemCount - 1) {
                            rect.bottom = DbA4;
                        } else {
                            rect.bottom = DbA5 / 2;
                        }
                    }
                });
            }
        }
        os.addView(recyclerView, new FrameLayout.LayoutParams(-1, -1));
        TopLayoutDislike2 topLayoutDislike2 = new TopLayoutDislike2(activity);
        this.wC = topLayoutDislike2;
        os.addView(topLayoutDislike2, new FrameLayout.LayoutParams(-1, -2));
        topLayoutDislike2.load(evVar);
        topLayoutDislike2.setShowDislike(true);
        topLayoutDislike2.setShowSound(true);
        boolean aqO = dV.aGH().aqO(String.valueOf(evVar.RTg()));
        this.Ue = aqO;
        topLayoutDislike2.setSoundMute(aqO);
        topLayoutDislike2.setListener(new com.bytedance.sdk.openadsdk.component.reward.top.DbA() { // from class: com.bytedance.sdk.openadsdk.activity.aGH.13
            @Override // com.bytedance.sdk.openadsdk.component.reward.top.DbA
            public void aGH(View view) {
            }

            @Override // com.bytedance.sdk.openadsdk.component.reward.top.DbA
            public void eli(View view) {
                com.bytedance.sdk.openadsdk.core.du.aGH eli3;
                ev evVar2 = evVar;
                com.bytedance.sdk.openadsdk.aGH.Os.eli("skip", evVar2, evVar2.aGH(), (Map<String, Object>) null);
                com.bytedance.sdk.openadsdk.core.model.aGH UCq = evVar.UCq();
                if (UCq != null && (eli3 = UCq.eli()) != null) {
                    eli3.MGA(0L);
                    eli3.ui(0L);
                }
                aGH.this.Vy();
            }

            @Override // com.bytedance.sdk.openadsdk.component.reward.top.DbA
            public void eli(View view, String str) {
                if (aGH.this.VM != null) {
                    aGH.this.VM.eli(str);
                    aGH.this.Ue = !r1.Ue;
                }
            }

            @Override // com.bytedance.sdk.openadsdk.component.reward.top.DbA
            public void DbA(View view) {
                if (aGH.this.VM != null) {
                    aGH.this.VM.c_();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.component.reward.top.DbA
            public void Os(View view) {
                dbA.aGH();
            }
        });
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity, i, z) { // from class: com.bytedance.sdk.openadsdk.activity.aGH.14
            @Override // androidx.recyclerview.widget.LinearLayoutManager
            protected void calculateExtraLayoutSpace(RecyclerView.State state, int[] iArr) {
                super.calculateExtraLayoutSpace(state, iArr);
                int height = aGH.this.ui.getHeight();
                iArr[0] = height;
                iArr[1] = height;
            }
        };
        this.kb = linearLayoutManager;
        recyclerView.setLayoutManager(linearLayoutManager);
        eli eliVar2 = new eli(this, evVar.ro());
        this.MGA = eliVar2;
        recyclerView.setAdapter(eliVar2);
        if (!this.dZ && !this.CMM) {
            eliVar2.eli(com.bytedance.sdk.component.utils.ev.eli(activity, "tt_list_end_tip"));
        }
        if (z2) {
            new PagerSnapHelper().attachToRecyclerView(recyclerView);
        } else if (this.Vy) {
            new com.bytedance.sdk.openadsdk.component.reward.view.eli().attachToRecyclerView(recyclerView);
        }
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.bytedance.sdk.openadsdk.activity.aGH.15
            private final Rect DbA = new Rect();
            private int Os = -1;
            private int aGH;

            private void eli() {
                int aGH2;
                View findViewByPosition;
                if (aGH.this.QX && (aGH2 = aGH.this.MGA.aGH()) != 0) {
                    int findFirstVisibleItemPosition = aGH.this.kb.findFirstVisibleItemPosition();
                    int findLastVisibleItemPosition = aGH.this.kb.findLastVisibleItemPosition();
                    if (findLastVisibleItemPosition % aGH2 > this.Os) {
                        for (int i2 = findFirstVisibleItemPosition; i2 <= findLastVisibleItemPosition; i2++) {
                            int i3 = i2 % aGH2;
                            if (i3 > this.Os) {
                                if ((i2 == findFirstVisibleItemPosition || i2 == findLastVisibleItemPosition) && (findViewByPosition = aGH.this.kb.findViewByPosition(i2)) != null) {
                                    this.DbA.setEmpty();
                                    findViewByPosition.getGlobalVisibleRect(this.DbA);
                                    int height = findViewByPosition.getHeight();
                                    if (height > 0) {
                                        if ((this.DbA.height() * 1.0f) / height < 0.5f) {
                                        }
                                    }
                                }
                                RecyclerView.ViewHolder findViewHolderForAdapterPosition = aGH.this.ui.findViewHolderForAdapterPosition(i2);
                                if (findViewHolderForAdapterPosition instanceof DbA) {
                                    ((DbA) findViewHolderForAdapterPosition).Os.VM();
                                }
                                if (i3 > this.Os) {
                                    this.Os = i3;
                                }
                            }
                        }
                    }
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView2, int i2, int i3) {
                super.onScrolled(recyclerView2, i2, i3);
                if (i3 == 0) {
                    return;
                }
                eli();
                int findLastVisibleItemPosition = aGH.this.kb.findLastVisibleItemPosition();
                if (i3 > 0 && aGH.this.dZ && aGH.this.ev > 0 && findLastVisibleItemPosition >= aGH.this.MGA.eli() - aGH.this.ev) {
                    aGH.this.bf();
                }
                if (this.aGH != findLastVisibleItemPosition) {
                    this.aGH = findLastVisibleItemPosition;
                    if (aGH.this.aqO.isEmpty() || !aGH.this.aqO.contains(Integer.valueOf(findLastVisibleItemPosition))) {
                        if (aGH.this.WfR) {
                            aGH.this.WfR = false;
                            RecyclerView.ViewHolder findViewHolderForAdapterPosition = recyclerView2.findViewHolderForAdapterPosition(findLastVisibleItemPosition);
                            if (findViewHolderForAdapterPosition instanceof DbA) {
                                DbA dbA2 = (DbA) findViewHolderForAdapterPosition;
                                if (dbA2.Os instanceof com.bytedance.sdk.openadsdk.activity.eli) {
                                    dbA2.Os.ui(true);
                                    ((com.bytedance.sdk.openadsdk.activity.eli) dbA2.Os).GB();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    aGH.this.aqO.remove(Integer.valueOf(findLastVisibleItemPosition));
                    RecyclerView.ViewHolder findViewHolderForAdapterPosition2 = recyclerView2.findViewHolderForAdapterPosition(findLastVisibleItemPosition);
                    if (findViewHolderForAdapterPosition2 instanceof DbA) {
                        DbA dbA3 = (DbA) findViewHolderForAdapterPosition2;
                        dbA3.Os.ui(true);
                        dbA3.Os.oWW();
                    }
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView2, int i2) {
                super.onScrollStateChanged(recyclerView2, i2);
                int findFirstCompletelyVisibleItemPosition = aGH.this.kb.findFirstCompletelyVisibleItemPosition();
                aGH.this.kb.findFirstVisibleItemPosition();
                int findLastVisibleItemPosition = aGH.this.kb.findLastVisibleItemPosition();
                if (findFirstCompletelyVisibleItemPosition < 0) {
                    return;
                }
                if (i2 == 0 && findFirstCompletelyVisibleItemPosition != aGH.this.KM) {
                    boolean z3 = findFirstCompletelyVisibleItemPosition == aGH.this.cyF;
                    aGH agh = aGH.this;
                    agh.eli(findFirstCompletelyVisibleItemPosition, agh.nro && z3);
                    if (aGH.this.nro && !z3 && aGH.this.ujq) {
                        aGH.this.nro = false;
                    }
                    if (aGH.this.QI != null) {
                        aGH.this.QI.aGH();
                        aGH.this.QI = null;
                    }
                }
                if (i2 == 0) {
                    aGH.this.cyF = -1;
                }
                if (!aGH.this.dZ || aGH.this.ev <= 0 || findLastVisibleItemPosition < aGH.this.MGA.eli() - aGH.this.ev) {
                    return;
                }
                aGH.this.bf();
            }
        });
        GB();
        final int Xb = Xb();
        recyclerView.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.activity.aGH.16
            @Override // java.lang.Runnable
            public void run() {
                if (com.bytedance.sdk.component.utils.DbA.eli(activity)) {
                    return;
                }
                aGH.this.eli(Xb, true);
            }
        });
        PAGLogoView createPAGLogoViewByMaterial = PAGLogoView.createPAGLogoViewByMaterial(activity, evVar);
        this.dV = createPAGLogoViewByMaterial;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 83;
        layoutParams.leftMargin = SSo.DbA(activity, 16.0f);
        os.addView(createPAGLogoViewByMaterial, layoutParams);
        createPAGLogoViewByMaterial.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.aGH.17
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Context context = view.getContext();
                ev evVar2 = evVar;
                TTWebsiteActivity.eli(context, evVar2, evVar2.aGH());
            }
        });
    }

    private static int eli(int i, int i2, int i3) {
        if (i < 0) {
            i = 0;
        }
        for (int i4 = 0; i4 < i2; i4++) {
            int i5 = i3 + i4;
            if (i5 % i2 == i) {
                return i5;
            }
            int i6 = i3 - i4;
            if (i6 % i2 == i) {
                return i6;
            }
        }
        return i3;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.Os
    public void eli(Bundle bundle) {
        super.eli(bundle);
        KM();
    }

    private int Xb() {
        if (!this.CMM || this.MGA.Os() || this.nlS.get() || this.dZ) {
            return 0;
        }
        int eli2 = eli(this.KM, this.MGA.aGH(), LockFreeTaskQueueCore.MAX_CAPACITY_MASK);
        this.MGA.eli(this.KM, eli2);
        if (this.KM < 0) {
            this.ui.scrollToPosition(eli2);
            return eli2;
        }
        this.KM = eli2;
        return eli2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bf() {
        if (this.nlS.compareAndSet(false, true)) {
            AdSlot XU = this.DbA.XU();
            ujq ujqVar = new ujq();
            ujqVar.MGA = true;
            if (this.DbA.RY() != null || this.DbA.hg() != null) {
                ujqVar.FC = 2;
            }
            ujqVar.kb = this.eU;
            this.MGA.eli(com.bytedance.sdk.component.utils.ev.eli(this.eli, "tt_loading_more"));
            if (com.bytedance.sdk.openadsdk.utils.DbA.eli()) {
                dV.Os().eli(XU, ujqVar, this.DbA.bBQ(), (Xb) new bf() { // from class: com.bytedance.sdk.openadsdk.activity.aGH.18
                    @Override // com.bytedance.sdk.openadsdk.core.bf, com.bytedance.sdk.openadsdk.core.CMM.eli
                    public void eli(int i, String str) {
                        aGH.this.eli(i, str);
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.bf, com.bytedance.sdk.openadsdk.core.CMM.eli
                    public void eli(com.bytedance.sdk.openadsdk.core.model.eli eliVar, com.bytedance.sdk.openadsdk.core.model.Os os) {
                        aGH.this.eli(eliVar, os);
                    }
                });
            } else {
                dV.Os().eli(XU, ujqVar, this.DbA.bBQ(), new CMM.eli() { // from class: com.bytedance.sdk.openadsdk.activity.aGH.19
                    @Override // com.bytedance.sdk.openadsdk.core.CMM.eli
                    public void eli(int i, String str) {
                        aGH.this.eli(i, str);
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.CMM.eli
                    public void eli(com.bytedance.sdk.openadsdk.core.model.eli eliVar, com.bytedance.sdk.openadsdk.core.model.Os os) {
                        aGH.this.eli(eliVar, os);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eli(int i, String str) {
        this.dZ = false;
        ev();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eli(com.bytedance.sdk.openadsdk.core.model.eli eliVar, com.bytedance.sdk.openadsdk.core.model.Os os) {
        this.dZ = false;
        if (eliVar.aGH() != null && !eliVar.aGH().isEmpty()) {
            eli(eliVar);
            return;
        }
        os.eli(-3);
        os.Os(1);
        com.bytedance.sdk.openadsdk.core.model.Os.eli(os);
        ev();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CMM() {
        if (this.dZ) {
            return;
        }
        if (this.CMM) {
            Xb();
        } else {
            cyF.eli(new Runnable() { // from class: com.bytedance.sdk.openadsdk.activity.aGH.2
                @Override // java.lang.Runnable
                public void run() {
                    if (com.bytedance.sdk.component.utils.DbA.eli(aGH.this.eli)) {
                        return;
                    }
                    aGH.this.MGA.eli(com.bytedance.sdk.component.utils.ev.eli(dV.eli(), "tt_list_end_tip"));
                }
            });
        }
    }

    private void eli(final com.bytedance.sdk.openadsdk.core.model.eli eliVar) {
        Vy nlS = eliVar.nlS();
        if (nlS != null) {
            this.eU = nlS.nlS();
            this.dZ = nlS.NU();
        }
        if (!this.nn) {
            for (ev evVar : eliVar.aGH()) {
                if (evVar.nY() != null && ev.ui(evVar)) {
                    com.bytedance.sdk.openadsdk.core.nlS.eli.DbA eli2 = ev.eli(CacheDirFactory.getICacheDir(evVar.Sz()).eli(), evVar);
                    eli2.eli("material_meta", evVar);
                    eli2.eli("ad_slot", evVar.XU());
                    com.bytedance.sdk.openadsdk.core.nlS.ui.eli.eli(eli2, new com.bykv.vk.openvk.eli.eli.eli.ui.DbA() { // from class: com.bytedance.sdk.openadsdk.activity.aGH.3
                        @Override // com.bykv.vk.openvk.eli.eli.eli.ui.eli.InterfaceC0111eli
                        public void eli(com.bykv.vk.openvk.eli.eli.eli.Os.Os os, int i) {
                        }

                        @Override // com.bykv.vk.openvk.eli.eli.eli.ui.eli.InterfaceC0111eli
                        public void eli(com.bykv.vk.openvk.eli.eli.eli.Os.Os os, int i, String str) {
                        }
                    });
                }
            }
        }
        cyF.eli(new Runnable() { // from class: com.bytedance.sdk.openadsdk.activity.aGH.4
            @Override // java.lang.Runnable
            public void run() {
                if (com.bytedance.sdk.component.utils.DbA.eli(aGH.this.eli)) {
                    return;
                }
                aGH.this.nlS.set(false);
                aGH.this.MGA.eli("");
                aGH.this.MGA.eli(eliVar.aGH());
                aGH.this.CMM();
            }
        });
    }

    private void ev() {
        cyF.eli(new Runnable() { // from class: com.bytedance.sdk.openadsdk.activity.aGH.5
            @Override // java.lang.Runnable
            public void run() {
                if (com.bytedance.sdk.component.utils.DbA.eli(aGH.this.eli)) {
                    return;
                }
                aGH.this.nlS.set(false);
                if (aGH.this.CMM) {
                    aGH.this.MGA.eli("");
                    aGH.this.CMM();
                } else {
                    aGH.this.MGA.eli(com.bytedance.sdk.component.utils.ev.eli(dV.eli(), "tt_list_end_tip"));
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.activity.Os
    /* renamed from: QX, reason: merged with bridge method [inline-methods] */
    public com.bytedance.sdk.openadsdk.activity.eli nn() {
        RecyclerView.ViewHolder findViewHolderForAdapterPosition = this.ui.findViewHolderForAdapterPosition(this.KM + 1);
        if (!(findViewHolderForAdapterPosition instanceof DbA)) {
            return null;
        }
        wC eli2 = ((DbA) findViewHolderForAdapterPosition).eli();
        if (eli2 instanceof com.bytedance.sdk.openadsdk.activity.eli) {
            return (com.bytedance.sdk.openadsdk.activity.eli) eli2;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vy() {
        com.bytedance.sdk.openadsdk.activity.ui uiVar = this.qj;
        if (uiVar != null && uiVar.GB()) {
            DbA(this.qj);
            this.aAs.removeView(this.ui);
            this.wC.setVisibility(8);
            this.dV.setVisibility(8);
            return;
        }
        this.aGH.aGH();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eli(int i, boolean z) {
        int i2;
        RecyclerView.ViewHolder findViewHolderForAdapterPosition = this.ui.findViewHolderForAdapterPosition(i);
        if (findViewHolderForAdapterPosition == null || !(findViewHolderForAdapterPosition instanceof DbA) || (i2 = this.KM) == i) {
            return;
        }
        eli(i2, i, z);
        this.KM = i;
        this.Za = SystemClock.elapsedRealtime();
        wC eli2 = ((DbA) findViewHolderForAdapterPosition).eli();
        DbA(eli2);
        this.NU.add(eli2.FC.Uv());
        if (this.dZ && this.ev > 0 && this.KM >= this.MGA.eli() - this.ev) {
            bf();
        }
        com.bytedance.sdk.openadsdk.activity.eli nn = nn();
        if (nn != null) {
            if (!this.nn && this.kb.findLastVisibleItemPosition() >= this.KM + 1) {
                nn.ui(true);
            }
            this.aqO.add(Integer.valueOf(this.KM + 1));
            nn.GB();
            this.WfR = false;
            return;
        }
        this.WfR = true;
    }

    private void eli(int i, int i2, boolean z) {
        String str;
        if (i < 0 || i2 < 0 || i == i2) {
            return;
        }
        if (z) {
            str = "auto_down";
        } else {
            str = i2 > i ? "down" : "up";
        }
        final String str2 = str;
        final long elapsedRealtime = (SystemClock.elapsedRealtime() - this.Za) / 1000;
        List<ev> ui2 = this.MGA.ui();
        final int size = i % ui2.size();
        final int size2 = i2 % ui2.size();
        ev evVar = ui2.get(size);
        com.bytedance.sdk.openadsdk.aGH.Os.eli(System.currentTimeMillis(), evVar, evVar.aGH(), "slide", new com.bytedance.sdk.openadsdk.Dfc.Os.eli() { // from class: com.bytedance.sdk.openadsdk.activity.aGH.6
            @Override // com.bytedance.sdk.openadsdk.Dfc.Os.eli
            public JSONObject eli() {
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put(Constants.MessagePayloadKeys.FROM, size + 1);
                    jSONObject3.put("to", size2 + 1);
                    jSONObject3.put("direction", str2);
                    jSONObject3.put("click_user_remaining", elapsedRealtime);
                    jSONObject2.put("pag_json_data", jSONObject3.toString());
                    jSONObject.put("ad_extra_data", jSONObject2);
                } catch (Exception unused) {
                }
                return jSONObject;
            }
        });
    }

    private void DbA(wC wCVar) {
        Iterator<wC> it = this.MGA.DbA().iterator();
        while (it.hasNext()) {
            wC next = it.next();
            if (next != wCVar) {
                next.eli(this.VM, wCVar, this.GB);
            }
        }
        com.bytedance.sdk.openadsdk.activity.ui uiVar = this.qj;
        if (uiVar != null && uiVar != wCVar) {
            uiVar.eli(this.VM, wCVar, this.GB);
        }
        wC wCVar2 = this.VM;
        this.VM = wCVar;
        if (wCVar2 != null) {
            wCVar2.NU = false;
            wCVar2.NU();
            wCVar2.aGH();
        }
        wCVar.NU = true;
        wCVar.DbA(this.eli, new DbA.ui(1, null));
        com.bytedance.sdk.openadsdk.component.reward.view.FC eli2 = wCVar.eli();
        if (eli2.getVisibility() != 0) {
            eli2.setVisibility(0);
        }
        if (eli2.getParent() == null) {
            this.aAs.addView(eli2, new FrameLayout.LayoutParams(-1, -1));
        }
        this.aGH.DbA(wCVar);
        if (wCVar.d_() != this.Ue) {
            wCVar.eli("card_sync");
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.Os
    public void eli(Activity activity) {
        super.eli(activity);
        SSo.eli(activity);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.Os
    public void eli(final wC wCVar, wC wCVar2, DbA.ui uiVar) {
        long j;
        if (wCVar != this.VM) {
            return;
        }
        if (wCVar.Ue() || KM.DbA(wCVar.FC)) {
            j = 500;
        } else {
            j = wCVar.FC.ke() != null ? r6.Os() * 1000 : 0L;
        }
        MGA mga = this.QI;
        if (mga != null) {
            mga.aGH();
        }
        MGA mga2 = new MGA(Math.max(500L, j)) { // from class: com.bytedance.sdk.openadsdk.activity.aGH.7
            @Override // com.bytedance.sdk.openadsdk.activity.aGH.MGA
            void eli() {
                if (com.bytedance.sdk.component.utils.DbA.eli(aGH.this.eli)) {
                    return;
                }
                aGH.this.Os(wCVar);
            }
        };
        this.QI = mga2;
        mga2.ui();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Os(wC wCVar) {
        wC wCVar2 = this.VM;
        if (wCVar != wCVar2) {
            return;
        }
        if (this.nro) {
            if (this.KM < this.MGA.eli() - 1) {
                int i = this.KM + 1;
                this.cyF = i;
                if (this.nn) {
                    this.ui.smoothScrollToPosition(i);
                } else {
                    eli(i);
                }
            } else {
                this.cyF = 0;
                this.ui.scrollToPosition(0);
                this.ui.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.activity.aGH.8
                    @Override // java.lang.Runnable
                    public void run() {
                        if (com.bytedance.sdk.component.utils.DbA.eli(aGH.this.eli)) {
                            return;
                        }
                        aGH agh = aGH.this;
                        agh.eli(agh.cyF, true);
                    }
                });
            }
        } else if (this.mm) {
            wCVar2.Os();
        } else {
            wCVar2.cyF();
        }
        this.QI = null;
        this.mm = false;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (this.ow) {
            this.nGm.add(this.FC.obtainMessage(message.what, message.arg1, message.arg2, message.obj));
            return false;
        }
        int i = message.what;
        if (i == 1) {
            int i2 = this.oWW;
            if (i2 > 0) {
                if (i2 <= this.gG) {
                    ujq();
                }
                TopLayoutDislike2 topLayoutDislike2 = this.wC;
                StringBuilder sb = new StringBuilder();
                int i3 = this.oWW;
                this.oWW = i3 - 1;
                topLayoutDislike2.setSkipText(sb.append(i3).append("s").toString());
                if (this.oWW >= 0) {
                    this.FC.removeMessages(message.what);
                    this.FC.sendEmptyMessageDelayed(message.what, 1000L);
                }
            } else {
                ujq();
                if (ui()) {
                    this.wC.showSkipButton();
                } else {
                    this.wC.showCloseButton();
                }
            }
        } else if (i == 3) {
            VM();
        } else if (i == 4) {
            gG();
        }
        return false;
    }

    private void eli(int i) {
        RecyclerView.ViewHolder findViewHolderForAdapterPosition;
        int findFirstVisibleItemPosition = this.kb.findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = this.kb.findLastVisibleItemPosition();
        if (i < findFirstVisibleItemPosition) {
            this.ui.smoothScrollToPosition(i);
            return;
        }
        if (i <= findLastVisibleItemPosition) {
            int i2 = i - findFirstVisibleItemPosition;
            int childCount = this.ui.getChildCount();
            if (i2 <= 0 || i2 >= childCount || (findViewHolderForAdapterPosition = this.ui.findViewHolderForAdapterPosition(i - 1)) == null) {
                return;
            }
            this.ui.smoothScrollBy(0, findViewHolderForAdapterPosition.itemView.getBottom());
            return;
        }
        this.ui.smoothScrollToPosition(this.cyF);
    }

    private void gG() {
        FrameLayout frameLayout = this.SSo;
        if (frameLayout == null) {
            return;
        }
        ViewParent parent = frameLayout.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.SSo);
        }
        this.SSo = null;
        wC wCVar = this.VM;
        if (wCVar instanceof com.bytedance.sdk.openadsdk.activity.eli) {
            ((com.bytedance.sdk.openadsdk.activity.eli) wCVar).nro();
        }
        qj();
        Message message = this.TfR;
        if (message != null) {
            handleMessage(message);
            this.TfR = null;
        }
    }

    private void ujq() {
        wC wCVar;
        if (!this.du || this.aGH.NU() || (wCVar = this.VM) == null) {
            return;
        }
        wCVar.ikX();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.Os
    public void Os() {
        super.Os();
        this.ow = true;
        wC wCVar = this.VM;
        if (wCVar != null) {
            wCVar.NU();
        }
        nro();
        this.mm = this.QI != null;
        this.FC.removeMessages(3);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.Os
    public void eli(boolean z) {
        super.eli(z);
        wC wCVar = this.VM;
        if (wCVar != null) {
            wCVar.Os(z);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.Os
    public void DbA() {
        super.DbA();
        this.ow = false;
        this.qyC = false;
        wC wCVar = this.VM;
        if (wCVar != null && !this.mm) {
            wCVar.Os();
        }
        if (this.ikX == 0) {
            this.ikX = SystemClock.elapsedRealtime();
        }
        qj();
        Ue();
        Iterator<Message> it = this.nGm.iterator();
        while (it.hasNext()) {
            handleMessage(it.next());
        }
        this.nGm.clear();
    }

    private void Ue() {
        if (this.Uv || this.FS == null) {
            return;
        }
        this.FC.removeMessages(3);
        this.FC.sendEmptyMessageDelayed(3, this.Xb * 1000);
    }

    private void KM() {
        if (this.FS == null) {
            return;
        }
        new com.bytedance.sdk.openadsdk.core.aAs.FC.eli(this.eli).eli(this.FS, com.bytedance.sdk.openadsdk.core.wC.eli.DbA.DbA(), this.jh, new com.bytedance.sdk.openadsdk.core.aAs.kb.aGH() { // from class: com.bytedance.sdk.openadsdk.activity.aGH.9
            @Override // com.bytedance.sdk.openadsdk.core.aAs.kb.aGH
            public void eli(int i, String str) {
                aGH.this.rQ = true;
            }

            @Override // com.bytedance.sdk.openadsdk.core.aAs.kb.aGH
            public void eli(com.bytedance.adsdk.ugeno.DbA.Os<View> os) {
                View du = os.du();
                ViewGroup viewGroup = (ViewGroup) du.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(du);
                }
                aGH.this.oc = du;
                if (aGH.this.SSo != null) {
                    aGH.this.SSo.addView(du, new FrameLayout.LayoutParams(-1, -1));
                }
            }
        });
    }

    private void VM() {
        if (this.SSo != null || this.FS == null || this.rQ) {
            return;
        }
        this.Uv = true;
        this.SSo = new com.bytedance.sdk.openadsdk.core.ui.Os(this.eli) { // from class: com.bytedance.sdk.openadsdk.activity.aGH.10
            @Override // android.view.ViewGroup, android.view.View
            public boolean dispatchTouchEvent(MotionEvent motionEvent) {
                aGH.this.FC.removeMessages(4);
                aGH.this.FC.sendEmptyMessage(4);
                return super.dispatchTouchEvent(motionEvent);
            }
        };
        View view = this.oc;
        if (view != null && view.getParent() == null) {
            this.SSo.addView(this.oc, new FrameLayout.LayoutParams(-1, -1));
        }
        this.aAs.addView(this.SSo, new FrameLayout.LayoutParams(-1, -1));
        this.FC.sendEmptyMessageDelayed(4, this.bf * 1000);
        wC wCVar = this.VM;
        if (wCVar instanceof com.bytedance.sdk.openadsdk.activity.eli) {
            ((com.bytedance.sdk.openadsdk.activity.eli) wCVar).qj();
        }
        nro();
    }

    private void GB() {
        Vy nlS;
        com.bytedance.sdk.openadsdk.core.model.eli Os2 = this.DbA.Os();
        if (Os2 == null || (nlS = Os2.nlS()) == null || TextUtils.isEmpty(nlS.kb())) {
            return;
        }
        this.qj = new com.bytedance.sdk.openadsdk.activity.ui(this.aGH, this.DbA, -1, 1, false, false, true);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.Os
    public boolean eli(wC wCVar, int i) {
        com.bytedance.sdk.openadsdk.activity.ui uiVar = this.qj;
        return uiVar != null && uiVar == wCVar;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.Os
    public void eli(View view) {
        super.eli(view);
        if (view.getParent() != null) {
            return;
        }
        view.setVisibility(4);
        this.aAs.addView(view, 0);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.Os
    public boolean MGA() {
        return this.Ue;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.Os
    public wC nlS() {
        return this.VM;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.Os
    public boolean ui() {
        return this.qj != null;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.Os
    public void aGH() {
        super.aGH();
        wC wCVar = this.VM;
        if (wCVar != null) {
            wCVar.FS();
        }
        com.bytedance.sdk.openadsdk.activity.ui uiVar = this.qj;
        if (uiVar != null) {
            uiVar.Xb();
        }
        Iterator<wC> it = this.MGA.DbA().iterator();
        while (it.hasNext()) {
            it.next().Xb();
        }
        this.FC.removeCallbacksAndMessages(null);
        MGA mga = this.QI;
        if (mga != null) {
            mga.aGH();
            this.QI = null;
        }
        wC wCVar2 = this.VM;
        if (wCVar2 == null || wCVar2.ev() || this.DbA.JF()) {
            return;
        }
        nn.DbA().post(new DbA.Os(this.DbA));
    }

    private boolean oWW() {
        FrameLayout frameLayout = this.SSo;
        return (frameLayout == null || frameLayout.getParent() == null) ? false : true;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.Os
    public void DbA(wC wCVar, int i) {
        wC wCVar2 = this.VM;
        if (wCVar != wCVar2) {
            return;
        }
        if (i == 2) {
            nro();
            return;
        }
        if (i == 1) {
            if (oWW()) {
                wC wCVar3 = this.VM;
                if (wCVar3 instanceof com.bytedance.sdk.openadsdk.activity.eli) {
                    ((com.bytedance.sdk.openadsdk.activity.eli) wCVar3).qj();
                    return;
                }
                return;
            }
            qj();
            return;
        }
        if (i == 3 || i == 4) {
            try {
                wCVar2.ujq().ev.GB();
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.Xb.Os("CardsLayoutManager", th);
            }
        }
    }

    private void qj() {
        if (this.Yw != 0) {
            wC wCVar = this.VM;
            if (wCVar != null && KM.DbA(wCVar.FC)) {
                int currentTimeMillis = this.oWW - ((int) ((System.currentTimeMillis() - this.Yw) / 1000));
                this.oWW = currentTimeMillis;
                if (currentTimeMillis < 0) {
                    this.oWW = 0;
                }
            }
            this.Yw = 0L;
        }
        if (this.oWW >= 0) {
            this.FC.removeMessages(1);
            this.FC.sendEmptyMessage(1);
        }
        MGA mga = this.QI;
        if (mga != null) {
            mga.Os();
        }
    }

    private void nro() {
        if (this.qyC) {
            this.Yw = System.currentTimeMillis();
        }
        this.FC.removeMessages(1);
        MGA mga = this.QI;
        if (mga != null) {
            mga.DbA();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.Os
    public int du() {
        return this.NU.size();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.Os
    public List<ev> aqO() {
        return this.MGA.ui();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.Os
    public void dV() {
        if (this.tGZ) {
            return;
        }
        this.tGZ = true;
        final long elapsedRealtime = SystemClock.elapsedRealtime() - this.ikX;
        com.bytedance.sdk.openadsdk.aGH.Os.eli(System.currentTimeMillis(), this.DbA, this.DbA.aGH(), "first_ad_loaded", new com.bytedance.sdk.openadsdk.Dfc.Os.eli() { // from class: com.bytedance.sdk.openadsdk.activity.aGH.11
            @Override // com.bytedance.sdk.openadsdk.Dfc.Os.eli
            public JSONObject eli() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("duration", elapsedRealtime);
                } catch (Throwable unused) {
                }
                return jSONObject;
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.activity.Os
    public void eli(Map<String, Object> map, wC wCVar, float f, float f2) {
        Object obj = map.get("pag_json_data");
        if (obj == null) {
            obj = new JSONObject();
        }
        if (obj instanceof JSONObject) {
            try {
                com.bytedance.sdk.openadsdk.component.reward.view.FC eli2 = wCVar.eli();
                ((JSONObject) obj).put("width", eli2.getWidth());
                ((JSONObject) obj).put("height", eli2.getHeight());
                int i = wCVar.du;
                int i2 = 1;
                ((JSONObject) obj).put("click_feed_top", i == this.kb.findFirstVisibleItemPosition() ? 1 : 0);
                JSONObject jSONObject = (JSONObject) obj;
                if (i != this.MGA.aGH()) {
                    i2 = 0;
                }
                jSONObject.put("click_on_final", i2);
                ((JSONObject) obj).put("click_countdown_remaining", this.oWW);
                ((JSONObject) obj).put("click_user_remaining", i == this.KM ? (SystemClock.elapsedRealtime() - this.Za) / 1000 : 0L);
                map.put("pag_json_data", obj.toString());
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.activity.aGH$aGH, reason: collision with other inner class name */
    private static class C0167aGH {
        public ev DbA;
        public String Os;
        public int eli = 0;

        public C0167aGH(ev evVar) {
            this.DbA = evVar;
        }

        public C0167aGH(String str) {
            this.Os = str;
        }
    }

    private static class Os extends ui {
        private final TextView eli;

        public Os(View view) {
            super(view);
            com.bytedance.sdk.openadsdk.core.ui.wC wCVar = new com.bytedance.sdk.openadsdk.core.ui.wC(view.getContext());
            this.eli = wCVar;
            wCVar.setTextColor(Color.parseColor("#99FFFFFF"));
            wCVar.setTextSize(14.0f);
            wCVar.setGravity(17);
            wCVar.setPadding(0, 24, 0, 24);
            ((FrameLayout) view).addView(wCVar, new FrameLayout.LayoutParams(-1, -2));
        }

        @Override // com.bytedance.sdk.openadsdk.activity.aGH.ui
        public void eli(aGH agh, C0167aGH c0167aGH, int i) {
            this.eli.setText(c0167aGH.Os);
        }
    }

    private static class DbA extends ui {
        private final com.bytedance.sdk.openadsdk.component.reward.view.DbA DbA;
        private wC Os;
        private final eli eli;

        public DbA(eli eliVar, View view) {
            super(view);
            this.eli = eliVar;
            this.DbA = (com.bytedance.sdk.openadsdk.component.reward.view.DbA) view;
        }

        public wC eli() {
            return this.Os;
        }

        @Override // com.bytedance.sdk.openadsdk.activity.aGH.ui
        public void eli(aGH agh, C0167aGH c0167aGH, int i) {
            int bindingAdapterPosition = getBindingAdapterPosition();
            Activity activity = agh.eli;
            if (!com.bytedance.sdk.component.utils.DbA.eli(activity) && this.Os == null) {
                ev evVar = c0167aGH.DbA;
                com.bytedance.sdk.openadsdk.activity.DbA dbA = agh.aGH;
                this.Os = evVar.Txb() ? new kb(dbA, evVar, bindingAdapterPosition, i, false) : new com.bytedance.sdk.openadsdk.activity.MGA(dbA, evVar, bindingAdapterPosition, i, false);
                DbA.ui uiVar = new DbA.ui(1, null);
                uiVar.aGH = agh.Ue;
                this.Os.DbA(activity, uiVar);
                this.eli.eli(this.Os);
                com.bytedance.sdk.openadsdk.component.reward.view.FC eli = this.Os.eli();
                if (eli == null) {
                    return;
                }
                ViewParent parent = eli.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(eli);
                }
                if (!agh.nn) {
                    float akP = evVar.akP();
                    if (akP > 0.0f) {
                        this.DbA.setWidthAndHeightRatio(akP);
                    } else {
                        this.DbA.setWidthOrHeightInParentRatio(0.8f);
                    }
                }
                this.DbA.eli(eli, new FrameLayout.LayoutParams(-1, -1));
                this.DbA.setScene(this.Os);
            }
        }

        public void DbA() {
            wC wCVar = this.Os;
            if (wCVar == null) {
                return;
            }
            wCVar.Xb();
            this.Os = null;
            this.DbA.eli();
        }
    }

    private static abstract class ui extends RecyclerView.ViewHolder {
        public abstract void eli(aGH agh, C0167aGH c0167aGH, int i);

        public ui(View view) {
            super(view);
        }
    }

    private static class eli extends RecyclerView.Adapter<ui> {
        private final aGH Os;
        private boolean aGH;
        private boolean ui;
        private final ArrayList<C0167aGH> eli = new ArrayList<>();
        private final ArrayList<wC> DbA = new ArrayList<>();

        public eli(aGH agh, List<ev> list) {
            this.Os = agh;
            for (int i = 0; i < list.size(); i++) {
                ev evVar = list.get(i);
                this.eli.add(new C0167aGH(evVar));
                if (i != 0) {
                    evVar.cxQ();
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: eli, reason: merged with bridge method [inline-methods] */
        public ui onCreateViewHolder(ViewGroup viewGroup, int i) {
            if (i == -1) {
                com.bytedance.sdk.openadsdk.core.ui.Os os = new com.bytedance.sdk.openadsdk.core.ui.Os(viewGroup.getContext());
                os.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
                return new Os(os);
            }
            com.bytedance.sdk.openadsdk.component.reward.view.DbA dbA = new com.bytedance.sdk.openadsdk.component.reward.view.DbA(viewGroup.getContext(), this.Os.Dfc, this.Os.nn, SSo.DbA(viewGroup.getContext(), 10.0f));
            dbA.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            return new DbA(this, dbA);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: eli, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(ui uiVar, int i) {
            if (i >= this.eli.size()) {
                i %= this.eli.size();
            }
            uiVar.eli(this.Os, this.eli.get(i), i);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: eli, reason: merged with bridge method [inline-methods] */
        public void onViewAttachedToWindow(ui uiVar) {
            super.onViewAttachedToWindow(uiVar);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: DbA, reason: merged with bridge method [inline-methods] */
        public void onViewDetachedFromWindow(ui uiVar) {
            wC wCVar;
            super.onViewDetachedFromWindow(uiVar);
            if (!(uiVar instanceof DbA) || (wCVar = ((DbA) uiVar).Os) == null) {
                return;
            }
            wCVar.ujq().ev.jh();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: Os, reason: merged with bridge method [inline-methods] */
        public void onViewRecycled(ui uiVar) {
            super.onViewRecycled(uiVar);
            if (uiVar instanceof DbA) {
                DbA dbA = (DbA) uiVar;
                wC wCVar = dbA.Os;
                if (wCVar != null) {
                    this.DbA.remove(wCVar);
                    dbA.DbA();
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            return this.eli.get(i % this.eli.size()).eli == 0 ? 1 : -1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            if (this.ui) {
                return Integer.MAX_VALUE;
            }
            return this.eli.size();
        }

        public int eli() {
            int itemCount = getItemCount();
            return this.aGH ? itemCount - 1 : itemCount;
        }

        public void eli(String str) {
            int size = this.eli.size();
            C0167aGH c0167aGH = size > 0 ? this.eli.get(size - 1) : null;
            boolean isEmpty = TextUtils.isEmpty(str);
            if (c0167aGH == null || c0167aGH.eli != 1) {
                if (isEmpty) {
                    return;
                }
                this.eli.add(new C0167aGH(str));
                notifyItemInserted(size);
                this.aGH = true;
                return;
            }
            if (!isEmpty) {
                c0167aGH.Os = str;
                notifyItemChanged(size - 1);
            } else {
                this.eli.remove(c0167aGH);
                notifyItemRemoved(size - 1);
                this.aGH = false;
            }
        }

        public void eli(wC wCVar) {
            this.DbA.add(wCVar);
        }

        public ArrayList<wC> DbA() {
            return this.DbA;
        }

        public void eli(List<ev> list) {
            int size = this.eli.size();
            if (this.aGH) {
                size--;
            }
            for (int i = 0; i < list.size(); i++) {
                ev evVar = list.get(i);
                this.eli.add(size + i, new C0167aGH(evVar));
                evVar.cxQ();
            }
            notifyItemRangeInserted(size, list.size());
        }

        public void eli(int i, int i2) {
            if (this.ui) {
                return;
            }
            this.ui = true;
            if (i < 0) {
                i = 0;
            }
            int size = this.eli.size();
            notifyItemRangeInserted(size, (Integer.MAX_VALUE - i2) - (size - i));
            notifyItemRangeInserted(0, i2 - i);
        }

        public boolean Os() {
            return this.ui;
        }

        public int aGH() {
            return this.aGH ? this.eli.size() - 1 : this.eli.size();
        }

        public List<ev> ui() {
            ArrayList arrayList = new ArrayList();
            Iterator<C0167aGH> it = this.eli.iterator();
            while (it.hasNext()) {
                C0167aGH next = it.next();
                if (next.eli == 0) {
                    arrayList.add(next.DbA);
                }
            }
            return arrayList;
        }
    }

    static abstract class MGA implements Runnable {
        private final long DbA;
        private long Os;
        private long aGH;
        private final Handler eli = new Handler(Looper.getMainLooper());

        abstract void eli();

        public MGA(long j) {
            this.DbA = j;
        }

        public void DbA() {
            this.eli.removeCallbacks(this);
            this.aGH += SystemClock.elapsedRealtime() - this.Os;
        }

        public void Os() {
            long j = this.DbA - this.aGH;
            if (j < 0) {
                return;
            }
            this.eli.removeCallbacks(this);
            this.eli.postDelayed(this, j);
            this.Os = SystemClock.elapsedRealtime();
        }

        public void aGH() {
            this.eli.removeCallbacks(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            eli();
        }

        public void ui() {
            this.eli.postDelayed(this, this.DbA);
            this.Os = SystemClock.elapsedRealtime();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.Os
    public int FC() {
        return this.oWW;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.Os
    public void nGm() {
        super.nGm();
        this.qyC = true;
    }
}
