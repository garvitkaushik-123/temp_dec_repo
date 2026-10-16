package com.mbridge.msdk.mbnative.controller;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.room.RoomMasterTable;
import com.iab.omid.library.mmadbridge.adsession.AdEvents;
import com.iab.omid.library.mmadbridge.adsession.AdSession;
import com.iab.omid.library.mmadbridge.adsession.FriendlyObstructionPurpose;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.download.H5DownLoadManager;
import com.mbridge.msdk.foundation.download.download.HTMLResourceManager;
import com.mbridge.msdk.foundation.download.download.ResourceManager;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.same.c;
import com.mbridge.msdk.foundation.same.task.a;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.a1;
import com.mbridge.msdk.foundation.tools.j0;
import com.mbridge.msdk.foundation.tools.l0;
import com.mbridge.msdk.foundation.tools.n0;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.foundation.tools.u0;
import com.mbridge.msdk.mbnative.controller.c;
import com.mbridge.msdk.nativex.view.MBMediaView;
import com.mbridge.msdk.out.Campaign;
import com.mbridge.msdk.out.Frame;
import com.mbridge.msdk.out.NativeListener;
import com.unity3d.services.core.fid.Constants;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class NativeController extends com.mbridge.msdk.mbnative.controller.a {
    private static final String c0 = "NativeController";
    public static Map<String, Long> d0 = new HashMap();
    private static boolean e0;
    private int A;
    private int B;
    private com.mbridge.msdk.foundation.same.task.b C;
    private List<com.mbridge.msdk.mbnative.controller.c> D;
    private List<c.d> E;
    private CopyOnWriteArrayList<com.mbridge.msdk.foundation.same.task.a> F;
    private Hashtable<String, AdSession> G;
    private int H;
    private int I;
    private n J;
    private boolean K;
    private boolean L;
    private Timer M;
    private String N;
    private String O;
    private ViewTreeObserver.OnGlobalLayoutListener P;
    private com.mbridge.msdk.setting.l Q;
    private long R;
    private int S;
    private int T;
    private boolean U;
    private int V;
    private int W;
    private boolean X;
    private List<Campaign> Y;
    private String Z;
    private AdSession a0;
    protected List<Integer> b;
    private AdEvents b0;
    protected List<Integer> c;
    Map<String, Object> d;
    private com.mbridge.msdk.setting.j e;
    private com.mbridge.msdk.mbnative.listener.a f;
    private NativeListener.NativeTrackingListener g;
    private Context h;
    private String i;
    private String j;
    private Queue<Integer> k;
    private Queue<Long> l;
    private String m;
    private com.mbridge.msdk.foundation.same.report.h n;
    private String o;
    private com.mbridge.msdk.click.a p;
    private int q;
    private int r;
    private int s;
    private int t;
    private String u;
    private boolean v;
    private boolean w;
    private boolean x;
    private int y;
    private int z;

    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f4492a;
        final /* synthetic */ NativeListener.NativeAdListener b;
        final /* synthetic */ int c;

        a(List list, NativeListener.NativeAdListener nativeAdListener, int i) {
            this.f4492a = list;
            this.b = nativeAdListener;
            this.c = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            List list = this.f4492a;
            if (list != null && list.size() > 0) {
                CampaignEx campaignEx = (CampaignEx) this.f4492a.get(0);
                NativeController.this.O = campaignEx.getRequestId();
                NativeController.this.Y = this.f4492a;
            }
            NativeController.this.v = true;
            this.b.onAdLoaded(this.f4492a, this.c);
            com.mbridge.msdk.mbnative.report.a.a(NativeController.this.h, (List<Campaign>) this.f4492a, NativeController.this.i);
        }
    }

    class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.mbridge.msdk.mbnative.listener.a f4493a;
        final /* synthetic */ CampaignEx b;
        final /* synthetic */ String c;

        b(com.mbridge.msdk.mbnative.listener.a aVar, CampaignEx campaignEx, String str) {
            this.f4493a = aVar;
            this.b = campaignEx;
            this.c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f4493a.a(this.b, this.c);
        }
    }

    class c implements com.mbridge.msdk.foundation.same.image.c {
        c() {
        }

        @Override // com.mbridge.msdk.foundation.same.image.c
        public void onFailedLoad(String str, String str2) {
        }

        @Override // com.mbridge.msdk.foundation.same.image.c
        public void onSuccessLoad(Bitmap bitmap, String str) {
        }
    }

    class d extends TimerTask {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f4495a;
        final /* synthetic */ o b;
        final /* synthetic */ List c;

        d(long j, o oVar, List list) {
            this.f4495a = j;
            this.b = oVar;
            this.c = list;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            boolean z;
            if (System.currentTimeMillis() - this.f4495a >= 60000) {
                this.b.a();
                NativeController.this.c();
                return;
            }
            int s = l0.s(NativeController.this.h);
            int q = NativeController.this.h().q();
            if (s != 9 && q == 2) {
                this.b.a();
                NativeController.this.c();
                return;
            }
            if (q == 3) {
                this.b.a();
                NativeController.this.c();
                return;
            }
            loop0: while (true) {
                z = false;
                for (Campaign campaign : this.c) {
                    String id = campaign.getId();
                    if (campaign instanceof CampaignEx) {
                        CampaignEx campaignEx = (CampaignEx) campaign;
                        id = id + campaignEx.getVideoUrlEncode() + campaignEx.getBidToken();
                    }
                    com.mbridge.msdk.videocommon.download.a a2 = com.mbridge.msdk.videocommon.download.b.getInstance().a(NativeController.this.i, id);
                    if (a2 != null && com.mbridge.msdk.videocommon.download.l.a(a2, NativeController.this.h().C())) {
                        z = true;
                    }
                }
                break loop0;
            }
            if (z) {
                this.b.a();
                NativeController.this.c();
            }
        }
    }

    class e implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ImageView f4496a;
        final /* synthetic */ View b;

        e(ImageView imageView, View view) {
            this.f4496a = imageView;
            this.b = view;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (this.f4496a != null) {
                this.f4496a.setLayoutParams(new FrameLayout.LayoutParams(this.b.getWidth(), this.b.getHeight()));
            }
        }
    }

    class f extends com.mbridge.msdk.widget.a {
        final /* synthetic */ CampaignEx b;

        f(CampaignEx campaignEx) {
            this.b = campaignEx;
        }

        @Override // com.mbridge.msdk.widget.a
        protected void a(View view) {
            NativeController.this.b(view.getContext(), this.b);
        }
    }

    class g extends com.mbridge.msdk.widget.a {
        final /* synthetic */ CampaignEx b;

        g(CampaignEx campaignEx) {
            this.b = campaignEx;
        }

        @Override // com.mbridge.msdk.widget.a
        protected void a(View view) {
            NativeController.this.b(view.getContext(), this.b);
        }
    }

    class h implements com.mbridge.msdk.widget.dialog.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CampaignEx f4497a;

        h(CampaignEx campaignEx) {
            this.f4497a = campaignEx;
        }

        @Override // com.mbridge.msdk.widget.dialog.b
        public void a() {
        }

        @Override // com.mbridge.msdk.widget.dialog.b
        public void b() {
            NativeController.this.p.a(this.f4497a, NativeController.this.f);
            NativeController.this.b(this.f4497a);
        }

        @Override // com.mbridge.msdk.widget.dialog.b
        public void c() {
        }
    }

    class i extends com.mbridge.msdk.widget.a {
        final /* synthetic */ CampaignEx b;

        i(CampaignEx campaignEx) {
            this.b = campaignEx;
        }

        @Override // com.mbridge.msdk.widget.a
        protected void a(View view) {
            NativeController.this.b(view.getContext(), this.b);
        }
    }

    class j implements a.InterfaceC0340a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ s f4498a;

        j(s sVar) {
            this.f4498a = sVar;
        }

        @Override // com.mbridge.msdk.foundation.same.task.a.InterfaceC0340a
        public void a(a.b bVar) {
            if (bVar != a.b.FINISH || NativeController.this.F == null || NativeController.this.F.size() <= 0 || !NativeController.this.F.contains(this.f4498a)) {
                return;
            }
            NativeController.this.F.remove(this.f4498a);
        }
    }

    class k implements c.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CampaignEx f4499a;

        k(CampaignEx campaignEx) {
            this.f4499a = campaignEx;
        }

        @Override // com.mbridge.msdk.mbnative.controller.c.d
        public void a(ArrayList<View> arrayList, ArrayList<View> arrayList2) {
            if (arrayList == null || arrayList.isEmpty()) {
                return;
            }
            com.mbridge.msdk.mbnative.report.b.a(this.f4499a, NativeController.this.h, NativeController.this.i, NativeController.this.f);
        }
    }

    class l implements o {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f4500a;
        final /* synthetic */ int b;
        final /* synthetic */ com.mbridge.msdk.mbnative.listener.a c;
        final /* synthetic */ List d;

        l(List list, int i, com.mbridge.msdk.mbnative.listener.a aVar, List list2) {
            this.f4500a = list;
            this.b = i;
            this.c = aVar;
            this.d = list2;
        }

        @Override // com.mbridge.msdk.mbnative.controller.NativeController.o
        public void a() {
            List a2 = NativeController.this.a((List<Campaign>) this.f4500a, true);
            if (a2 == null || a2.size() <= 0) {
                NativeController.this.a(this.c, "has no ads", (CampaignEx) this.d.get(0));
            } else {
                NativeController.this.a((List<Campaign>) a2, this.b, this.c);
            }
        }
    }

    class m implements o {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f4501a;
        final /* synthetic */ int b;
        final /* synthetic */ com.mbridge.msdk.mbnative.listener.a c;

        m(List list, int i, com.mbridge.msdk.mbnative.listener.a aVar) {
            this.f4501a = list;
            this.b = i;
            this.c = aVar;
        }

        @Override // com.mbridge.msdk.mbnative.controller.NativeController.o
        public void a() {
            List a2 = NativeController.this.a((List<Campaign>) this.f4501a, false);
            if (a2 == null || a2.size() <= 0) {
                NativeController.this.a(this.c, "has no ads", (CampaignEx) null);
            } else {
                NativeController.this.a((List<Campaign>) a2, this.b, this.c);
            }
        }
    }

    public class n extends com.mbridge.msdk.mbnative.service.net.b implements com.mbridge.msdk.foundation.same.task.d {
        private Runnable d;
        private boolean c = false;
        private boolean e = true;
        private List<String> f = null;

        class a extends c.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ CampaignEx f4502a;

            a(CampaignEx campaignEx, com.mbridge.msdk.foundation.same.report.metrics.callback.a aVar) {
                this.f4502a = campaignEx;
            }

            @Override // com.mbridge.msdk.foundation.same.c.a
            public void a(String str, com.mbridge.msdk.foundation.same.report.metrics.c cVar) {
                com.mbridge.msdk.mbnative.report.a.a(str, cVar, this.f4502a, NativeController.this.h, (com.mbridge.msdk.foundation.same.report.metrics.callback.a) null);
            }
        }

        public n() {
        }

        @Override // com.mbridge.msdk.foundation.same.task.d
        public void a(boolean z) {
            this.c = z;
        }

        public void b(boolean z) {
            this.e = z;
        }

        @Override // com.mbridge.msdk.mbnative.service.net.b
        public void a(List<com.mbridge.msdk.tracker.network.g> list, CampaignUnit campaignUnit) {
            Integer num;
            boolean z = true;
            NativeController.this.U = true;
            com.mbridge.msdk.foundation.db.j a2 = com.mbridge.msdk.foundation.db.j.a(com.mbridge.msdk.foundation.db.g.a(NativeController.this.h));
            a2.a();
            Runnable runnable = this.d;
            if (runnable != null) {
                NativeController.this.f4508a.removeCallbacks(runnable);
            }
            if (com.mbridge.msdk.util.b.a()) {
                NativeController.this.a(campaignUnit);
            }
            if (campaignUnit == null || campaignUnit.getAds() == null || campaignUnit.getAds().size() <= 0) {
                this.unitId = "0_" + this.unitId;
                com.mbridge.msdk.mbnative.controller.d.b(NativeController.this.s, this.unitId);
                NativeController.this.t = 0;
                return;
            }
            NativeController.this.o = campaignUnit.getSessionId();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            int i = 2;
            if (NativeController.this.S <= 0) {
                if (NativeController.this.S == -3) {
                    NativeController.this.S = campaignUnit.getAds().size();
                } else {
                    NativeController nativeController = NativeController.this;
                    nativeController.S = nativeController.r;
                }
                if (NativeController.this.V != 0 && campaignUnit.getTemplate() == 2) {
                    NativeController nativeController2 = NativeController.this;
                    nativeController2.S = nativeController2.V;
                }
                if (NativeController.this.W != 0 && campaignUnit.getTemplate() == 3) {
                    NativeController nativeController3 = NativeController.this;
                    nativeController3.S = nativeController3.W;
                }
            }
            com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
            eVar.a("adtp", 42);
            if (TextUtils.isEmpty(b())) {
                eVar.a(CampaignEx.JSON_KEY_HB, 0);
            } else {
                eVar.a(CampaignEx.JSON_KEY_HB, 1);
            }
            com.mbridge.msdk.foundation.same.report.metrics.c a3 = com.mbridge.msdk.foundation.same.report.metrics.d.b().a(true, b(), eVar, campaignUnit.getAds().get(0), this.unitId);
            int i2 = 0;
            while (i2 < campaignUnit.getAds().size()) {
                CampaignEx campaignEx = campaignUnit.getAds().get(i2);
                campaignEx.setLocalRequestId(a3.o());
                campaignEx.setCampaignUnitId(this.unitId);
                if (!TextUtils.isEmpty(NativeController.this.N)) {
                    campaignEx.setBidToken(NativeController.this.N);
                    campaignEx.setIsBidCampaign(z);
                }
                if (NativeController.e0) {
                    campaignEx.loadIconUrlAsyncWithBlock(null);
                    campaignEx.loadImageUrlAsyncWithBlock(null);
                }
                boolean c = u0.c(NativeController.this.h, campaignEx.getPackageName());
                NativeController nativeController4 = NativeController.this;
                nativeController4.a(nativeController4.h, campaignEx);
                if (i2 < NativeController.this.r && campaignEx.getOfferType() != 99) {
                    if (u0.c(campaignEx)) {
                        campaignEx.setRtinsType(c ? 1 : i);
                    }
                    if (com.mbridge.msdk.foundation.same.c.b(NativeController.this.h, campaignEx)) {
                        arrayList.add(campaignEx);
                        if (!TextUtils.isEmpty(campaignEx.getVideoUrlEncode())) {
                            arrayList3.add(campaignEx);
                        }
                    } else {
                        u0.a(this.unitId, campaignEx, com.mbridge.msdk.foundation.same.a.x);
                        NativeController.this.Z = "APP ALREADY INSTALLED";
                    }
                    a(campaignEx, null, null);
                }
                if (i2 < NativeController.this.S && campaignEx.getOfferType() != 99) {
                    if (u0.c(campaignEx)) {
                        campaignEx.setRtinsType(c ? 1 : 2);
                    }
                    if (!c) {
                        arrayList2.add(campaignEx);
                    } else if (u0.c(campaignEx)) {
                        arrayList2.add(campaignEx);
                    }
                }
                if (!a2.a(campaignEx.getId())) {
                    com.mbridge.msdk.foundation.entity.g gVar = new com.mbridge.msdk.foundation.entity.g();
                    gVar.a(campaignEx.getId());
                    gVar.b(campaignEx.getFca());
                    gVar.c(campaignEx.getFcb());
                    gVar.a(0);
                    gVar.d(0);
                    gVar.a(System.currentTimeMillis());
                    a2.b(gVar);
                }
                com.mbridge.msdk.click.c.a(NativeController.this.h, campaignEx.getMaitve(), campaignEx.getMaitve_src());
                i2++;
                z = true;
                i = 2;
            }
            NativeController.this.d(arrayList3);
            int type = campaignUnit.getAds().get(0) != null ? campaignUnit.getAds().get(0).getType() : 1;
            com.mbridge.msdk.mbnative.cache.b<String, List<Campaign>> a4 = com.mbridge.msdk.mbnative.cache.c.a(type);
            if (a4 != null) {
                a4.a((com.mbridge.msdk.mbnative.cache.b<String, List<Campaign>>) this.unitId, (String) arrayList2, NativeController.this.N);
            }
            if (arrayList.size() == 0) {
                if (NativeController.this.Z.contains("INSTALLED")) {
                    NativeController.this.a("APP ALREADY INSTALLED", a(), b(), campaignUnit.getAds().get(0));
                    new com.mbridge.msdk.foundation.error.b(880021, "APP ALREADY INSTALLED");
                    return;
                } else {
                    NativeController.this.a("v3 response error", a(), b(), campaignUnit.getAds().get(0));
                    new com.mbridge.msdk.foundation.error.b(880003);
                    return;
                }
            }
            NativeController nativeController5 = NativeController.this;
            nativeController5.c((List<Campaign>) nativeController5.a(type, (List<Campaign>) nativeController5.a(arrayList)));
            if (com.mbridge.msdk.mbnative.controller.d.g().containsKey(this.unitId) && Boolean.TRUE.equals(com.mbridge.msdk.mbnative.controller.d.g().get(this.unitId))) {
                com.mbridge.msdk.mbnative.controller.d.a(NativeController.this.s, this.unitId);
                return;
            }
            int intValue = (!com.mbridge.msdk.mbnative.controller.d.d().containsKey(this.unitId) || (num = com.mbridge.msdk.mbnative.controller.d.d().get(this.unitId)) == null) ? 1 : num.intValue();
            int i3 = NativeController.this.r + NativeController.this.t;
            NativeController.this.t = i3 <= intValue ? i3 : 0;
        }

        public void b(List<String> list) {
            this.f = list;
        }

        private void a(CampaignEx campaignEx, com.mbridge.msdk.foundation.same.report.metrics.c cVar, com.mbridge.msdk.foundation.same.report.metrics.callback.a aVar) {
            try {
                com.mbridge.msdk.foundation.same.c.a(campaignEx, NativeController.this.h, cVar, new a(campaignEx, aVar));
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    e.printStackTrace();
                }
            }
        }

        @Override // com.mbridge.msdk.mbnative.service.net.b
        public void a(int i, String str) {
            NativeController.this.U = true;
            if (this.c) {
                if (NativeController.this.v || !this.e) {
                    return;
                }
                NativeController.this.a(str, a(), b(), (CampaignEx) null);
                return;
            }
            if (i == -1) {
                com.mbridge.msdk.mbnative.controller.d.b(NativeController.this.s, this.unitId);
                NativeController.this.t = 0;
            }
            Runnable runnable = this.d;
            if (runnable != null) {
                NativeController.this.f4508a.removeCallbacks(runnable);
            }
            if (NativeController.this.v) {
                return;
            }
            if (a() == 1 || this.e) {
                NativeController.this.a(str, a(), b(), (CampaignEx) null);
            }
        }

        public void a(Runnable runnable) {
            this.d = runnable;
        }

        @Override // com.mbridge.msdk.mbnative.service.net.b
        public void a(List<Frame> list) {
            if (this.c) {
                return;
            }
            Runnable runnable = this.d;
            if (runnable != null) {
                NativeController.this.f4508a.removeCallbacks(runnable);
            }
            if (list == null || list.size() == 0) {
                if (NativeController.this.f != null) {
                    NativeController.this.v = true;
                    NativeController.this.f.onAdLoadError("frame is empty");
                    return;
                }
                return;
            }
            Iterator<Frame> it = list.iterator();
            while (it.hasNext()) {
                List<CampaignEx> campaigns = it.next().getCampaigns();
                if (campaigns == null || campaigns.size() == 0) {
                    if (NativeController.this.f != null) {
                        NativeController.this.v = true;
                        NativeController.this.f.onAdLoadError("ads in frame is empty");
                        return;
                    }
                    return;
                }
                for (CampaignEx campaignEx : campaigns) {
                    if (NativeController.e0) {
                        campaignEx.loadImageUrlAsyncWithBlock(null);
                        campaignEx.loadIconUrlAsyncWithBlock(null);
                    }
                }
            }
            if (NativeController.this.f != null) {
                NativeController.this.f.onAdFramesLoaded(list);
            }
        }
    }

    public interface o {
        void a();
    }

    public class p implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private int f4503a;
        private com.mbridge.msdk.foundation.same.task.d b;
        private int c;
        private String d;

        public p(int i, com.mbridge.msdk.foundation.same.task.d dVar, int i2, String str) {
            this.f4503a = i;
            this.b = dVar;
            this.c = i2;
            this.d = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.b.a(true);
            int i = this.f4503a;
            if (i == 1) {
                NativeController.this.U = true;
                NativeController.this.a("REQUEST_TIMEOUT", this.c, this.d, (CampaignEx) null);
            } else {
                if (i != 2) {
                    return;
                }
                if (!NativeController.this.v || this.c == 1) {
                    NativeController.this.a("REQUEST_TIMEOUT", this.c, this.d, (CampaignEx) null);
                }
            }
        }
    }

    private static class q implements H5DownLoadManager.IH5SourceDownloadListener {

        /* renamed from: a, reason: collision with root package name */
        private String f4504a;
        private CampaignEx b;
        private long c = System.currentTimeMillis();
        private boolean d;

        public q(String str, CampaignEx campaignEx, boolean z) {
            this.d = true;
            this.f4504a = str;
            this.b = campaignEx;
            this.d = z;
        }

        @Override // com.mbridge.msdk.foundation.download.download.H5DownLoadManager.H5ResDownloadListerInter
        public void onFailed(String str, String str2) {
            try {
                if (this.d) {
                    long currentTimeMillis = System.currentTimeMillis() - this.c;
                    com.mbridge.msdk.foundation.db.n.a(com.mbridge.msdk.foundation.db.g.a(com.mbridge.msdk.foundation.controller.c.m().d()));
                    com.mbridge.msdk.foundation.entity.n nVar = new com.mbridge.msdk.foundation.entity.n("2000043", 3, currentTimeMillis + "", str, this.b.getId(), this.f4504a, str2, "2");
                    nVar.n(this.b.getRequestId());
                    nVar.k(this.b.getCurrentLocalRid());
                    nVar.o(this.b.getRequestIdNotice());
                    CampaignEx campaignEx = this.b;
                    if (campaignEx != null && !TextUtils.isEmpty(campaignEx.getId())) {
                        nVar.b(this.b.getId());
                    }
                    CampaignEx campaignEx2 = this.b;
                    if (campaignEx2 != null) {
                        nVar.a(campaignEx2.getAdSpaceT());
                    }
                    nVar.a("1");
                    com.mbridge.msdk.foundation.same.report.g.a(nVar, this.f4504a, this.b);
                }
            } catch (Exception e) {
                p0.b(NativeController.c0, com.mbridge.msdk.mbnative.common.a.a(e));
            }
        }

        @Override // com.mbridge.msdk.foundation.download.download.H5DownLoadManager.H5ResDownloadListerInter
        public void onSuccess(String str, String str2, boolean z) {
            try {
                if (this.d) {
                    long currentTimeMillis = System.currentTimeMillis() - this.c;
                    com.mbridge.msdk.foundation.db.n.a(com.mbridge.msdk.foundation.db.g.a(com.mbridge.msdk.foundation.controller.c.m().d()));
                    com.mbridge.msdk.foundation.entity.n nVar = new com.mbridge.msdk.foundation.entity.n("2000043", 1, currentTimeMillis + "", str, this.b.getId(), this.f4504a, "", "2");
                    CampaignEx campaignEx = this.b;
                    if (campaignEx != null && !TextUtils.isEmpty(campaignEx.getId())) {
                        nVar.b(this.b.getId());
                    }
                    CampaignEx campaignEx2 = this.b;
                    if (campaignEx2 != null) {
                        nVar.n(campaignEx2.getRequestId());
                        nVar.o(this.b.getRequestIdNotice());
                        nVar.k(this.b.getCurrentLocalRid());
                        nVar.a(this.b.getAdSpaceT());
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        nVar.q(str2);
                    }
                    nVar.a("1");
                    com.mbridge.msdk.foundation.same.report.g.a(nVar, this.f4504a, this.b);
                }
            } catch (Exception e) {
                p0.b(NativeController.c0, com.mbridge.msdk.mbnative.common.a.a(e));
            }
        }
    }

    protected static class r extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<NativeController> f4505a;

        public r(NativeController nativeController) {
            this.f4505a = new WeakReference<>(nativeController);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            WeakReference<NativeController> weakReference;
            NativeController nativeController;
            super.handleMessage(message);
            try {
                if (message.what == 0 && (weakReference = this.f4505a) != null && (nativeController = weakReference.get()) != null) {
                    nativeController.n.a(message.arg1, (String) message.obj);
                }
                if (message.what == 1) {
                    WeakReference<NativeController> weakReference2 = this.f4505a;
                    NativeController nativeController2 = (weakReference2 == null || weakReference2.get() == null) ? null : this.f4505a.get();
                    if (nativeController2 != null) {
                        nativeController2.w = true;
                        List<Campaign> a2 = nativeController2.a(nativeController2.i, nativeController2.r, nativeController2.N);
                        if (nativeController2.v) {
                            return;
                        }
                        nativeController2.c(a2);
                    }
                }
            } catch (Exception e) {
                p0.b(NativeController.c0, com.mbridge.msdk.mbnative.common.a.a(e));
            }
        }
    }

    private static class s extends com.mbridge.msdk.foundation.same.task.a {

        /* renamed from: a, reason: collision with root package name */
        private CampaignEx f4506a;
        private WeakReference<View> b;
        private WeakReference<List<View>> c;
        private WeakReference<NativeController> d;
        private WeakReference<AdSession> e;

        public s(CampaignEx campaignEx, View view, List<View> list, NativeController nativeController, AdSession adSession) {
            this.f4506a = campaignEx;
            this.b = new WeakReference<>(view);
            this.c = new WeakReference<>(list);
            this.d = new WeakReference<>(nativeController);
            this.e = new WeakReference<>(adSession);
        }

        @Override // com.mbridge.msdk.foundation.same.task.a
        public void cancelTask() {
        }

        @Override // com.mbridge.msdk.foundation.same.task.a
        public void pauseTask(boolean z) {
        }

        @Override // com.mbridge.msdk.foundation.same.task.a
        public void runTask() {
            WeakReference<View> weakReference;
            try {
                if (this.d == null || (weakReference = this.b) == null || this.c == null) {
                    return;
                }
                View view = weakReference.get();
                List<View> list = this.c.get();
                NativeController nativeController = this.d.get();
                WeakReference<AdSession> weakReference2 = this.e;
                AdSession adSession = weakReference2 != null ? weakReference2.get() : null;
                if (view == null || nativeController == null) {
                    return;
                }
                nativeController.a(this.f4506a, view, list, adSession);
            } catch (Exception e) {
                p0.b(NativeController.c0, com.mbridge.msdk.mbnative.common.a.a(e));
            }
        }
    }

    private static final class t implements H5DownLoadManager.ZipDownloadListener {

        /* renamed from: a, reason: collision with root package name */
        String f4507a;
        CampaignEx b;
        private long c = System.currentTimeMillis();
        private boolean d;

        public t(String str, CampaignEx campaignEx, boolean z) {
            this.d = true;
            this.f4507a = str;
            this.b = campaignEx;
            this.d = z;
        }

        @Override // com.mbridge.msdk.foundation.download.download.H5DownLoadManager.H5ResDownloadListerInter
        public void onFailed(String str, String str2) {
            try {
                if (this.d) {
                    long currentTimeMillis = System.currentTimeMillis() - this.c;
                    com.mbridge.msdk.foundation.db.n.a(com.mbridge.msdk.foundation.db.g.a(com.mbridge.msdk.foundation.controller.c.m().d()));
                    com.mbridge.msdk.foundation.entity.n nVar = new com.mbridge.msdk.foundation.entity.n("2000043", 3, currentTimeMillis + "", str2, this.b.getId(), this.f4507a, str, "1");
                    CampaignEx campaignEx = this.b;
                    if (campaignEx != null && !TextUtils.isEmpty(campaignEx.getId())) {
                        nVar.b(this.b.getId());
                    }
                    CampaignEx campaignEx2 = this.b;
                    if (campaignEx2 != null) {
                        nVar.n(campaignEx2.getRequestId());
                        nVar.k(this.b.getCurrentLocalRid());
                        nVar.o(this.b.getRequestIdNotice());
                        nVar.a(this.b.getAdSpaceT());
                    }
                    nVar.a("2");
                    com.mbridge.msdk.foundation.same.report.g.a(nVar, this.f4507a, this.b);
                }
            } catch (Exception e) {
                p0.b(NativeController.c0, com.mbridge.msdk.mbnative.common.a.a(e));
            }
        }

        @Override // com.mbridge.msdk.foundation.download.download.H5DownLoadManager.H5ResDownloadListerInter
        public void onSuccess(String str, String str2, boolean z) {
            try {
                if (this.d) {
                    long currentTimeMillis = System.currentTimeMillis() - this.c;
                    com.mbridge.msdk.foundation.db.n.a(com.mbridge.msdk.foundation.db.g.a(com.mbridge.msdk.foundation.controller.c.m().d()));
                    com.mbridge.msdk.foundation.entity.n nVar = new com.mbridge.msdk.foundation.entity.n("2000043", 1, currentTimeMillis + "", str, this.b.getId(), this.f4507a, "", "1");
                    CampaignEx campaignEx = this.b;
                    if (campaignEx != null && !TextUtils.isEmpty(campaignEx.getId())) {
                        nVar.b(this.b.getId());
                    }
                    CampaignEx campaignEx2 = this.b;
                    if (campaignEx2 != null) {
                        nVar.n(campaignEx2.getRequestId());
                        nVar.k(this.b.getCurrentLocalRid());
                        nVar.o(this.b.getRequestIdNotice());
                        nVar.a(this.b.getAdSpaceT());
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        nVar.q(str2);
                    }
                    nVar.a("2");
                    com.mbridge.msdk.foundation.same.report.g.a(nVar, this.f4507a, this.b);
                }
            } catch (Exception e) {
                p0.b(NativeController.c0, com.mbridge.msdk.mbnative.common.a.a(e));
            }
        }
    }

    public NativeController(com.mbridge.msdk.mbnative.listener.a aVar, NativeListener.NativeTrackingListener nativeTrackingListener, Map<String, Object> map, Context context) {
        int i2;
        Object obj;
        this.q = 1;
        this.r = 1;
        this.s = -1;
        this.t = 0;
        this.v = false;
        this.w = false;
        this.x = false;
        this.y = 0;
        this.z = 0;
        this.A = 0;
        this.B = 0;
        this.F = new CopyOnWriteArrayList<>();
        this.G = new Hashtable<>();
        this.H = 1;
        this.I = 2;
        this.N = "";
        this.O = "";
        this.Z = "";
        this.h = context;
        this.d = map;
        this.e = new com.mbridge.msdk.setting.j();
        this.f = aVar;
        this.g = nativeTrackingListener;
        this.D = new ArrayList();
        this.E = new ArrayList();
        String str = (String) map.get(MBridgeConstans.PROPERTIES_UNIT_ID);
        this.i = str;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!map.containsKey(MBridgeConstans.PLACEMENT_ID) || map.get(MBridgeConstans.PLACEMENT_ID) == null) {
            this.j = "";
        } else {
            this.j = (String) map.get(MBridgeConstans.PLACEMENT_ID);
        }
        if (map.containsKey(MBridgeConstans.PREIMAGE) && (obj = map.get(MBridgeConstans.PREIMAGE)) != null) {
            e0 = ((Boolean) obj).booleanValue();
        }
        this.k = new LinkedList();
        this.l = new LinkedList();
        this.C = new com.mbridge.msdk.foundation.same.task.b(this.h);
        if (Looper.myLooper() == null) {
            Looper.prepare();
        }
        this.f4508a = new r(this);
        if (map.containsKey(MBridgeConstans.PROPERTIES_API_REUQEST_CATEGORY)) {
            this.u = (String) map.get(MBridgeConstans.PROPERTIES_API_REUQEST_CATEGORY);
        }
        try {
            boolean equals = com.mbridge.msdk.mbnative.controller.d.g().containsKey(this.i) ? Boolean.TRUE.equals(com.mbridge.msdk.mbnative.controller.d.g().get(this.i)) : false;
            Object obj2 = map.get("ad_num");
            Object obj3 = map.get(MBridgeConstans.PROPERTIES_AD_FRAME_NUM);
            if (!equals) {
                if (map.containsKey("ad_num") && obj2 != null) {
                    try {
                        i2 = ((Integer) obj2).intValue();
                    } catch (Exception e2) {
                        if (MBridgeConstans.DEBUG) {
                            p0.b(c0, e2.getMessage());
                        }
                        i2 = 1;
                    }
                    i2 = i2 < 1 ? 1 : i2;
                    i2 = i2 > 10 ? 10 : i2;
                    this.r = i2;
                    this.q = i2;
                }
                if (map.containsKey(MBridgeConstans.PROPERTIES_AD_FRAME_NUM) && obj3 != null) {
                    try {
                        this.A = ((Integer) obj3).intValue();
                    } catch (Exception e3) {
                        if (MBridgeConstans.DEBUG) {
                            p0.b(c0, e3.getMessage());
                        }
                    }
                }
            } else if (com.mbridge.msdk.mbnative.controller.d.c().containsKey(this.i)) {
                Integer num = com.mbridge.msdk.mbnative.controller.d.c().get(this.i);
                if (num != null) {
                    this.r = num.intValue();
                }
                if (map.containsKey("ad_num") && obj2 != null) {
                    int intValue = ((Integer) obj2).intValue();
                    this.y = intValue;
                    this.q = intValue;
                }
                if (map.containsKey(MBridgeConstans.PROPERTIES_AD_FRAME_NUM) && obj3 != null) {
                    int intValue2 = ((Integer) obj3).intValue();
                    this.z = intValue2;
                    this.A = intValue2;
                }
            }
        } catch (Exception e4) {
            p0.b(c0, com.mbridge.msdk.mbnative.common.a.a(e4));
        }
        this.n = new com.mbridge.msdk.foundation.same.report.h(this.h);
        this.p = new com.mbridge.msdk.click.a(this.h, this.i);
        try {
            int i3 = MBMediaView.p0;
            this.L = true;
            Map<String, Object> map2 = this.d;
            if (map2 != null && (map2.containsKey(MBridgeConstans.NATIVE_VIDEO_WIDTH) || this.d.containsKey(MBridgeConstans.NATIVE_VIDEO_HEIGHT) || map.containsKey(MBridgeConstans.NATIVE_VIDEO_SUPPORT))) {
                this.K = true;
            }
            com.mbridge.msdk.mbnative.controller.e.a(this.h, this.i);
            n0.a();
            if (TextUtils.isEmpty(this.i)) {
                return;
            }
            com.mbridge.msdk.foundation.db.e.a(com.mbridge.msdk.foundation.db.g.a(this.h)).a();
            int a2 = a(map.containsKey(MBridgeConstans.NATIVE_INFO) ? (String) map.get(MBridgeConstans.NATIVE_INFO) : null);
            List<Campaign> a3 = a(this.i, a2 <= 0 ? this.q : a2);
            if (a3 != null) {
                ArrayList arrayList = new ArrayList();
                for (int i4 = 0; i4 < a3.size(); i4++) {
                    CampaignEx campaignEx = (CampaignEx) a3.get(i4);
                    if (!TextUtils.isEmpty(campaignEx.getVideoUrlEncode())) {
                        arrayList.add(campaignEx);
                    }
                }
                if (arrayList.size() > 0) {
                    Object invoke = com.mbridge.msdk.videocommon.download.b.class.getMethod(Constants.GET_INSTANCE, new Class[0]).invoke(null, new Object[0]);
                    com.mbridge.msdk.videocommon.download.b.class.getMethod("createUnitCache", Context.class, String.class, CopyOnWriteArrayList.class, Integer.TYPE, com.mbridge.msdk.videocommon.listener.a.class).invoke(invoke, context, this.i, new CopyOnWriteArrayList(arrayList), 1, null);
                    com.mbridge.msdk.videocommon.download.b.class.getMethod("load", String.class).invoke(invoke, this.i);
                }
            }
        } catch (Throwable unused) {
            p0.b(c0, "please import the nativex aar");
        }
    }

    private List<Campaign> e(List<Campaign> list) {
        if (list != null) {
            CampaignEx campaignEx = null;
            for (int size = list.size() - 1; size >= 0; size--) {
                try {
                    campaignEx = (CampaignEx) list.get(size);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                if (campaignEx != null && TextUtils.isEmpty(campaignEx.getVideoUrlEncode())) {
                    Campaign remove = list.remove(size);
                    com.mbridge.msdk.mbnative.cache.c.a(campaignEx.getType()).a(this.i, remove, this.N);
                    p0.a(c0, "remove no videoURL ads:" + remove);
                }
            }
        }
        return list;
    }

    private void f() {
        try {
            if (this.m == null) {
                return;
            }
            JSONArray jSONArray = new JSONArray(this.m);
            if (jSONArray.length() > 0) {
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject = (JSONObject) jSONArray.opt(i2);
                    int optInt = jSONObject.optInt("id", 0);
                    if (2 == optInt) {
                        this.V = jSONObject.optInt("ad_num");
                        if (this.T > 0) {
                            jSONObject.remove("ad_num");
                            jSONObject.put("ad_num", this.T);
                        }
                    } else if (3 == optInt) {
                        this.W = jSONObject.optInt("ad_num");
                        if (this.T > 0) {
                            jSONObject.remove("ad_num");
                            jSONObject.put("ad_num", this.T);
                        }
                    }
                }
            }
            this.H = Math.max(this.V, this.W);
            this.m = jSONArray.toString();
        } catch (JSONException e2) {
            p0.b(c0, com.mbridge.msdk.mbnative.common.a.a(e2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.mbridge.msdk.setting.l h() {
        com.mbridge.msdk.setting.l e2 = com.mbridge.msdk.setting.h.b().e("", this.i);
        this.Q = e2;
        if (e2 == null) {
            this.Q = com.mbridge.msdk.setting.l.i(this.i);
        }
        return this.Q;
    }

    public String g() {
        return this.O;
    }

    public void i() {
        com.mbridge.msdk.foundation.same.task.a next;
        com.mbridge.msdk.foundation.same.task.b bVar = this.C;
        if (bVar != null) {
            bVar.a();
            this.C = null;
        }
        Hashtable<String, AdSession> hashtable = this.G;
        if (hashtable != null) {
            for (AdSession adSession : hashtable.values()) {
                if (adSession != null) {
                    adSession.finish();
                }
            }
            this.G.clear();
        }
        Handler handler = this.f4508a;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.g = null;
        this.p.c();
        try {
            Context context = this.h;
            if (context != null) {
                com.mbridge.msdk.foundation.same.image.b.a(context).b();
            }
            List<com.mbridge.msdk.mbnative.controller.c> list = this.D;
            if (list != null && list.size() > 0) {
                Iterator<com.mbridge.msdk.mbnative.controller.c> it = this.D.iterator();
                while (it.hasNext()) {
                    it.next().a();
                }
                this.D.clear();
                this.D = null;
            }
            List<c.d> list2 = this.E;
            if (list2 != null && list2.size() > 0) {
                for (c.d dVar : this.E) {
                }
                this.E.clear();
                this.E = null;
            }
            CopyOnWriteArrayList<com.mbridge.msdk.foundation.same.task.a> copyOnWriteArrayList = this.F;
            if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) {
                return;
            }
            Iterator<com.mbridge.msdk.foundation.same.task.a> it2 = this.F.iterator();
            if (it2.hasNext() && (next = it2.next()) != null) {
                next.cancel();
                this.f4508a.removeCallbacks(next);
            }
            this.F.clear();
        } catch (Exception unused) {
        }
    }

    public void j() {
        List<Integer> list = this.b;
        if (list != null && list.size() > 0) {
            Queue<Integer> queue = this.k;
            if (queue != null && queue.size() > 0) {
                this.k.clear();
            }
            for (Integer num : this.b) {
                Queue<Integer> queue2 = this.k;
                if (queue2 != null) {
                    queue2.add(num);
                }
            }
        }
        List<Integer> list2 = this.c;
        if (list2 == null || list2.size() <= 0) {
            return;
        }
        Queue<Long> queue3 = this.l;
        if (queue3 != null && queue3.size() > 0) {
            this.l.clear();
        }
        for (Integer num2 : this.c) {
            Queue<Long> queue4 = this.l;
            if (queue4 != null) {
                queue4.add(Long.valueOf(num2.intValue() * 1000));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(List<CampaignEx> list) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    try {
                        int i2 = MBMediaView.p0;
                        Object invoke = com.mbridge.msdk.videocommon.download.b.class.getMethod(Constants.GET_INSTANCE, new Class[0]).invoke(null, new Object[0]);
                        if (invoke != null) {
                            com.mbridge.msdk.videocommon.download.b.class.getMethod("createUnitCache", Context.class, String.class, CopyOnWriteArrayList.class, Integer.TYPE, com.mbridge.msdk.videocommon.listener.a.class).invoke(invoke, this.h, this.i, new CopyOnWriteArrayList(list), 1, null);
                            com.mbridge.msdk.videocommon.download.b.class.getMethod("load", String.class).invoke(invoke, this.i);
                        }
                        Iterator<CampaignEx> it = list.iterator();
                        while (it.hasNext()) {
                            CampaignEx next = it.next();
                            if (next != null && !TextUtils.isEmpty(next.getImageUrl())) {
                                com.mbridge.msdk.foundation.same.image.b.a(com.mbridge.msdk.foundation.controller.c.m().d()).a(next.getImageUrl(), new c());
                            }
                            String str = "";
                            if (next != null) {
                                try {
                                    str = next.getendcard_url();
                                } catch (Exception unused) {
                                }
                            }
                            com.mbridge.msdk.foundation.same.report.metrics.c cVar = new com.mbridge.msdk.foundation.same.report.metrics.c();
                            cVar.a(next);
                            if (!TextUtils.isEmpty(str)) {
                                cVar.f((next == null || next.getAabEntity() == null) ? 0 : next.getAabEntity().h3c);
                                if (str.contains(".zip") && str.contains(ResourceManager.KEY_MD5FILENAME)) {
                                    H5DownLoadManager.getInstance().downloadH5Res(cVar, str, new t(this.i, next, TextUtils.isEmpty(H5DownLoadManager.getInstance().getH5ResAddress(str))));
                                } else {
                                    H5DownLoadManager.getInstance().downloadH5Res(cVar, str, new q(this.i, next, TextUtils.isEmpty(HTMLResourceManager.getInstance().getHtmlContentFromUrl(str))));
                                }
                            }
                        }
                    } catch (Throwable unused2) {
                        p0.b(c0, "please import the videocommon and nativex aar");
                    }
                }
            } catch (Throwable th) {
                if (MBridgeConstans.DEBUG) {
                    th.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(List<Campaign> list) {
        if (!TextUtils.isEmpty(this.N) && list != null && list.size() == 0) {
            return false;
        }
        if (list == null || list.size() <= 0) {
            return false;
        }
        com.mbridge.msdk.mbnative.listener.a aVar = this.f;
        if (aVar == null) {
            return true;
        }
        CampaignEx campaignEx = (CampaignEx) list.get(0);
        if (campaignEx != null && campaignEx.isActiveOm()) {
            AdSession a2 = a(campaignEx);
            this.a0 = a2;
            if (a2 != null) {
                a2.start();
                AdEvents createAdEvents = AdEvents.createAdEvents(this.a0);
                this.b0 = createAdEvents;
                createAdEvents.loaded();
            }
        }
        int template = campaignEx != null ? campaignEx.getTemplate() : 2;
        com.mbridge.msdk.foundation.db.j a3 = com.mbridge.msdk.foundation.db.j.a(com.mbridge.msdk.foundation.db.g.a(this.h));
        a3.a();
        for (int i2 = 0; i2 < list.size(); i2++) {
            CampaignEx campaignEx2 = (CampaignEx) list.get(i2);
            if (!a3.a(campaignEx2.getId())) {
                com.mbridge.msdk.foundation.entity.g gVar = new com.mbridge.msdk.foundation.entity.g();
                gVar.a(campaignEx2.getId());
                gVar.b(campaignEx2.getFca());
                gVar.c(campaignEx2.getFcb());
                gVar.a(0);
                gVar.d(0);
                gVar.a(System.currentTimeMillis());
                a3.b(gVar);
            }
        }
        if (this.L && this.K) {
            if (h().m() == 3) {
                List<Campaign> e2 = e(list);
                if (list.size() > 0) {
                    a(list, new l(e2, template, aVar, list));
                    return true;
                }
                a(aVar, "has no ads", (CampaignEx) null);
                return true;
            }
            List<Campaign> b2 = b(list);
            if (b2 != null && b2.size() > 0) {
                a(b2, new m(list, template, aVar));
                return true;
            }
            a(list, template, aVar);
            return true;
        }
        if (list.size() > 0) {
            Iterator<Campaign> it = list.iterator();
            while (it.hasNext()) {
                it.next().setVideoLength(0);
            }
            a(list, template, aVar);
            return true;
        }
        a(aVar, "has no ads", (CampaignEx) null);
        return true;
    }

    public static boolean b(Map<String, Object> map) {
        if (map == null) {
            return false;
        }
        try {
            if (map.containsKey(MBridgeConstans.APP_ID) && map.containsKey(MBridgeConstans.APP_KEY) && map.containsKey(MBridgeConstans.KEY_WORD)) {
                return map.get(MBridgeConstans.KEY_WORD) != null;
            }
            return false;
        } catch (Exception e2) {
            p0.b(c0, com.mbridge.msdk.mbnative.common.a.a(e2));
            return false;
        }
    }

    public void b(int i2, String str) {
        com.mbridge.msdk.mbnative.listener.a aVar;
        Long poll;
        Queue<Integer> queue = this.k;
        if (queue != null && queue.size() > 0) {
            Integer poll2 = this.k.poll();
            int intValue = poll2 != null ? poll2.intValue() : 1;
            this.R = MBridgeConstans.REQUEST_TIME_OUT;
            Queue<Long> queue2 = this.l;
            if (queue2 != null && queue2.size() > 0 && (poll = this.l.poll()) != null) {
                this.R = poll.longValue();
            }
            b(intValue, this.R, i2, str);
            return;
        }
        if (this.v || (aVar = this.f) == null) {
            return;
        }
        this.v = true;
        aVar.onAdLoadError("no ad source");
    }

    public static List<String> a(Map<String, Object> map) {
        Exception e2;
        ArrayList arrayList = null;
        try {
            if (!(map.get(MBridgeConstans.KEY_WORD) instanceof String)) {
                return null;
            }
            String str = (String) map.get(MBridgeConstans.KEY_WORD);
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() == 0) {
                return null;
            }
            ArrayList arrayList2 = new ArrayList();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                try {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                    if (optJSONObject != null) {
                        String optString = optJSONObject.optString("p");
                        if (!TextUtils.isEmpty(optString)) {
                            arrayList2.add(optString);
                        }
                    }
                } catch (Exception e3) {
                    e2 = e3;
                    arrayList = arrayList2;
                    p0.b(c0, com.mbridge.msdk.mbnative.common.a.a(e2));
                    return arrayList;
                }
            }
            return arrayList2;
        } catch (Exception e4) {
            e2 = e4;
        }
    }

    public String e() {
        ArrayList arrayList = new ArrayList();
        List<Campaign> list = this.Y;
        if (list != null) {
            for (Campaign campaign : list) {
                CampaignEx campaignEx = new CampaignEx();
                campaignEx.setCreativeId(campaign.getCreativeId());
                arrayList.add(campaignEx);
            }
        }
        return com.mbridge.msdk.foundation.same.c.b(arrayList);
    }

    public void b(int i2, long j2, int i3, String str) {
        com.mbridge.msdk.mbnative.cache.b<String, List<Campaign>> a2;
        if (i3 == 0 && (a2 = com.mbridge.msdk.mbnative.cache.c.a(i2)) != null) {
            if ((i2 == 1 || i2 == 2) && this.d.containsKey(MBridgeConstans.NATIVE_INFO)) {
                this.r = this.H;
            } else {
                this.r = this.q;
            }
            if (c(a(i2, a(a2.a((com.mbridge.msdk.mbnative.cache.b<String, List<Campaign>>) this.i, this.r))))) {
                return;
            }
        }
        if (i2 == 1) {
            a(j2, i3, true, this.i, str);
        } else if (i2 != 2) {
            a(i2, j2, i3, str);
        } else {
            a(2, j2, i3, str);
        }
    }

    public List<Campaign> a(String str, int i2) {
        com.mbridge.msdk.mbnative.cache.b<String, List<Campaign>> a2;
        com.mbridge.msdk.setting.l e2 = com.mbridge.msdk.setting.h.b().e("", str);
        this.Q = e2;
        if (e2 == null) {
            this.Q = com.mbridge.msdk.setting.l.i(str);
        }
        List<Integer> b2 = this.Q.b();
        this.b = b2;
        if (b2 == null || b2.size() <= 0 || !this.b.contains(1) || (a2 = com.mbridge.msdk.mbnative.cache.c.a(1)) == null) {
            return null;
        }
        return a2.a((com.mbridge.msdk.mbnative.cache.b<String, List<Campaign>>) str, i2);
    }

    private int a(String str) {
        if (str != null) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() > 0) {
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        JSONObject jSONObject = (JSONObject) jSONArray.opt(i2);
                        if (2 == jSONObject.optInt("id", 0)) {
                            return jSONObject.optInt("ad_num");
                        }
                    }
                }
            } catch (Exception e2) {
                p0.b(c0, com.mbridge.msdk.mbnative.common.a.a(e2));
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context, CampaignEx campaignEx) {
        NativeController nativeController;
        CampaignEx campaignEx2;
        if (campaignEx != null) {
            try {
                if (campaignEx.needShowIDialog() && com.mbridge.msdk.util.b.a()) {
                    h hVar = new h(campaignEx);
                    if (com.mbridge.msdk.click.c.a(campaignEx) && campaignEx.needShowIDialog()) {
                        nativeController = this;
                        campaignEx2 = campaignEx;
                        try {
                            if (nativeController.a(this.p, context, campaignEx2, this.i, hVar)) {
                                return;
                            }
                            b(campaignEx2);
                            nativeController.f.onAdClick(campaignEx2);
                            return;
                        } catch (Throwable th) {
                            th = th;
                            p0.a(c0, th.getMessage());
                            nativeController.p.a(campaignEx2, nativeController.f);
                            b(campaignEx2);
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                nativeController = this;
                campaignEx2 = campaignEx;
            }
        }
        nativeController = this;
        campaignEx2 = campaignEx;
        nativeController.p.a(campaignEx2, nativeController.f);
        b(campaignEx2);
    }

    public void a(String str, String str2) {
        this.e.a(this.h, str, str2, this.i);
    }

    public void a(int i2, String str) {
        boolean z = false;
        this.v = false;
        this.w = false;
        this.x = false;
        this.U = false;
        this.N = str;
        this.f.a(!TextUtils.isEmpty(str));
        this.J = null;
        Map<String, Long> map = d0;
        if (map != null && map.size() > 0) {
            d0.clear();
        }
        if (com.mbridge.msdk.mbnative.controller.d.g() != null && com.mbridge.msdk.mbnative.controller.d.g().containsKey(this.i)) {
            z = Boolean.TRUE.equals(com.mbridge.msdk.mbnative.controller.d.g().get(this.i));
        }
        a(z, i2);
    }

    public void d() {
        n0.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        Timer timer = this.M;
        if (timer != null) {
            timer.cancel();
            this.M = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(CampaignEx campaignEx) {
        if (campaignEx == null || campaignEx.isReportClick()) {
            return;
        }
        campaignEx.setReportClick(true);
        if (campaignEx.getNativeVideoTracking() == null || campaignEx.getNativeVideoTracking().d() == null) {
            return;
        }
        com.mbridge.msdk.click.a.a(this.h, campaignEx, campaignEx.getCampaignUnitId(), campaignEx.getNativeVideoTracking().d(), false, false);
    }

    public void b(Campaign campaign, View view) {
        b(campaign, view, null);
    }

    public void b(Campaign campaign, View view, List<View> list) {
        Class<MBMediaView> cls;
        if (view != null && this.P != null) {
            try {
                view.getViewTreeObserver().removeOnGlobalLayoutListener(this.P);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (campaign != null) {
            int type = campaign.getType();
            if (type == 1 || type == 2) {
                try {
                    cls = MBMediaView.class;
                    int i2 = MBMediaView.p0;
                } catch (Throwable unused) {
                    cls = null;
                }
                if (list == null || list.size() <= 0) {
                    if (view != null) {
                        a(view, cls);
                    }
                } else {
                    Iterator<View> it = list.iterator();
                    while (it.hasNext()) {
                        a(it.next(), cls);
                    }
                }
            }
        }
    }

    private List<Campaign> b(List<Campaign> list) {
        ArrayList arrayList = null;
        if (list != null) {
            for (Campaign campaign : list) {
                if (campaign instanceof CampaignEx) {
                    CampaignEx campaignEx = (CampaignEx) campaign;
                    if (TextUtils.isEmpty(campaignEx.getImageUrl()) && !TextUtils.isEmpty(campaignEx.getVideoUrlEncode())) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(campaign);
                    }
                }
            }
        }
        return arrayList;
    }

    private void a(boolean z, int i2) {
        boolean z2;
        NativeController nativeController;
        int i3;
        if (!z || i2 != 1 || !a(i2)) {
            String b2 = com.mbridge.msdk.foundation.controller.c.m().b();
            String c2 = com.mbridge.msdk.foundation.controller.c.m().c();
            if (this.d.containsKey(MBridgeConstans.APP_ID) && this.d.containsKey(MBridgeConstans.APP_KEY) && this.d.containsKey(MBridgeConstans.KEY_WORD)) {
                b2 = (String) this.d.get(MBridgeConstans.APP_ID);
                c2 = (String) this.d.get(MBridgeConstans.APP_KEY);
            }
            a(b2, c2);
            com.mbridge.msdk.setting.l e2 = com.mbridge.msdk.setting.h.b().e(b2, this.i);
            this.Q = e2;
            if (e2 == null) {
                this.Q = com.mbridge.msdk.setting.l.i(this.i);
            }
            com.mbridge.msdk.mbnative.controller.d.d().put(this.i, Integer.valueOf(this.Q.y() * this.r));
            this.b = this.Q.b();
            this.c = this.Q.c();
            this.T = this.Q.f();
            this.S = this.Q.e();
            this.r = this.q;
            List<Integer> list = this.b;
            if (list != null && list.size() != 0) {
                try {
                    z2 = com.mbridge.msdk.mbsignalcommon.webEnvCheck.a.b(com.mbridge.msdk.foundation.controller.c.m().d());
                } catch (Exception unused) {
                    z2 = false;
                }
                if (!z2) {
                    com.mbridge.msdk.mbnative.listener.a aVar = this.f;
                    if (aVar != null) {
                        aVar.onAdLoadError("webview is not available");
                    }
                } else {
                    if (this.d.containsKey(MBridgeConstans.NATIVE_INFO) && this.m == null) {
                        this.m = (String) this.d.get(MBridgeConstans.NATIVE_INFO);
                        f();
                    }
                    if ((this.b.contains(1) && this.b.get(0).intValue() != 1) || i2 != 0 || !c(a(this.i, this.r, this.N))) {
                        this.X = true;
                        if (this.b.contains(1) && i2 == 0 && this.b.get(0).intValue() != 1) {
                            int intValue = this.b.get(0).intValue();
                            com.mbridge.msdk.mbnative.cache.b<String, List<Campaign>> a2 = com.mbridge.msdk.mbnative.cache.c.a(intValue);
                            if (intValue == 2 && this.d.containsKey(MBridgeConstans.NATIVE_INFO)) {
                                this.r = this.H;
                            } else {
                                this.r = this.q;
                            }
                            if (a2 == null || !c(a(intValue, a(a2.a((com.mbridge.msdk.mbnative.cache.b<String, List<Campaign>>) this.i, this.r))))) {
                                this.X = false;
                                try {
                                    nativeController = this;
                                    i3 = i2;
                                    try {
                                        nativeController.a(this.c.get(this.b.indexOf(1)).intValue() * 1000, i3, false, this.i, this.N);
                                    } catch (Exception unused2) {
                                    }
                                } catch (Exception unused3) {
                                }
                                nativeController.f4508a.sendEmptyMessageDelayed(1, nativeController.Q.K() * 1000);
                                j();
                                b(i3, nativeController.N);
                            }
                        }
                        nativeController = this;
                        i3 = i2;
                        nativeController.f4508a.sendEmptyMessageDelayed(1, nativeController.Q.K() * 1000);
                        j();
                        b(i3, nativeController.N);
                    }
                }
            } else {
                com.mbridge.msdk.mbnative.listener.a aVar2 = this.f;
                if (aVar2 != null) {
                    this.v = true;
                    aVar2.onAdLoadError("do not have sorceList");
                }
            }
        }
    }

    public boolean a(int i2) {
        int i3;
        int i4;
        int i5;
        com.mbridge.msdk.mbnative.listener.a aVar;
        int i6 = 0;
        if (com.mbridge.msdk.mbnative.controller.d.g().containsKey(this.i) && Boolean.TRUE.equals(com.mbridge.msdk.mbnative.controller.d.g().get(this.i))) {
            Map<String, Map<Long, Object>> f2 = com.mbridge.msdk.mbnative.controller.d.f();
            Map<Long, Object> map = f2.get(i2 + "_" + this.i);
            Integer num = com.mbridge.msdk.mbnative.controller.d.c().get(this.i);
            com.mbridge.msdk.setting.g d2 = com.mbridge.msdk.setting.h.b().d(com.mbridge.msdk.foundation.controller.c.m().b());
            if (num != null) {
                this.r = num.intValue();
            }
            if (map != null && map.size() > 0) {
                Long next = map.keySet().iterator().next();
                long currentTimeMillis = System.currentTimeMillis();
                if (d2 == null) {
                    d2 = com.mbridge.msdk.setting.h.b().a();
                }
                if (currentTimeMillis - next.longValue() >= d2.Z() * 1000) {
                    f2.remove(i2 + "_" + this.i);
                } else {
                    if (i2 == 1) {
                        List<Frame> list = (List) map.get(next);
                        if (list == null || list.size() <= 0 || (aVar = this.f) == null) {
                            return false;
                        }
                        if (this.A >= list.size()) {
                            f2.remove(i2 + "_" + this.i);
                            aVar.onAdFramesLoaded(list);
                            return true;
                        }
                        if (this.A == 0) {
                            return false;
                        }
                        List<Frame> subList = list.subList(0, this.z);
                        aVar.onAdFramesLoaded(list);
                        list.removeAll(subList);
                        map.put(next, subList);
                        ArrayList arrayList = new ArrayList();
                        for (Frame frame : list) {
                            if (i6 >= this.A) {
                                arrayList.add(frame);
                            }
                            i6++;
                        }
                        map.put(next, arrayList);
                        f2.put(i2 + "_" + this.i, map);
                        aVar.onAdFramesLoaded(subList);
                        return true;
                    }
                    List list2 = (List) map.get(next);
                    if (list2 != null && list2.size() > 0) {
                        List<Campaign> arrayList2 = new ArrayList<>();
                        if (((CampaignEx) list2.get(0)).getType() == 1) {
                            if (TextUtils.isEmpty(this.m)) {
                                i3 = Math.min(this.y, list2.size());
                            } else {
                                try {
                                    JSONArray jSONArray = new JSONArray(this.m);
                                    if (jSONArray.length() > 0) {
                                        i4 = 0;
                                        i5 = 0;
                                        for (int i7 = 0; i7 < jSONArray.length(); i7++) {
                                            JSONObject jSONObject = (JSONObject) jSONArray.opt(i7);
                                            int optInt = jSONObject.optInt("id", 0);
                                            if (2 == optInt) {
                                                i4 = jSONObject.optInt("ad_num");
                                            } else if (3 == optInt) {
                                                i5 = jSONObject.optInt("ad_num");
                                            }
                                        }
                                    } else {
                                        i4 = 0;
                                        i5 = 0;
                                    }
                                    if (3 == ((CampaignEx) list2.get(0)).getTemplate()) {
                                        i3 = Math.min(i5, list2.size());
                                    } else {
                                        i3 = Math.min(i4, list2.size());
                                    }
                                } catch (Exception unused) {
                                    p0.b(c0, "load from catch error in get nativeinfo adnum");
                                    i3 = 0;
                                }
                            }
                            if (i3 <= 0) {
                                return false;
                            }
                            Iterator it = list2.iterator();
                            while (it.hasNext() && i6 != i3) {
                                CampaignEx campaignEx = (CampaignEx) it.next();
                                campaignEx.getTemplate();
                                arrayList2.add(campaignEx);
                                it.remove();
                                i6++;
                            }
                        } else {
                            int min = Math.min(this.y, list2.size());
                            if (min > 0) {
                                Iterator it2 = list2.iterator();
                                while (it2.hasNext() && i6 != min) {
                                    CampaignEx campaignEx2 = (CampaignEx) it2.next();
                                    campaignEx2.getTemplate();
                                    arrayList2.add(campaignEx2);
                                    it2.remove();
                                    i6++;
                                }
                            }
                        }
                        c(arrayList2);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public NativeController() {
        this.q = 1;
        this.r = 1;
        this.s = -1;
        this.t = 0;
        this.v = false;
        this.w = false;
        this.x = false;
        this.y = 0;
        this.z = 0;
        this.A = 0;
        this.B = 0;
        this.F = new CopyOnWriteArrayList<>();
        this.G = new Hashtable<>();
        this.H = 1;
        this.I = 2;
        this.N = "";
        this.O = "";
        this.Z = "";
    }

    public void a(String str, int i2, String str2, CampaignEx campaignEx) {
        Queue<Integer> queue = this.k;
        if ((queue != null && queue.size() <= 0) || this.k == null) {
            com.mbridge.msdk.mbnative.listener.a aVar = this.f;
            if (aVar == null || this.v) {
                return;
            }
            this.v = true;
            aVar.a(campaignEx, str);
            return;
        }
        b(i2, str2);
    }

    @Override // com.mbridge.msdk.mbnative.controller.a
    public synchronized void a(int i2, long j2, int i3, String str) {
        com.mbridge.msdk.foundation.same.net.wrapper.c cVar;
        com.mbridge.msdk.foundation.entity.k kVar;
        try {
            if (this.d.containsKey(MBridgeConstans.NATIVE_INFO)) {
                this.r = Math.max(this.V, this.W);
            }
            if (i3 == 0) {
                com.mbridge.msdk.mbnative.cache.b<String, List<Campaign>> a2 = com.mbridge.msdk.mbnative.cache.c.a(i2);
                if (a2 != null && c(a(1, a(a2.a((com.mbridge.msdk.mbnative.cache.b<String, List<Campaign>>) this.i, this.r))))) {
                    return;
                }
                n nVar = this.J;
                if (nVar != null && !this.U) {
                    nVar.b(true);
                }
                if (this.U && !this.v) {
                    a("mb load failed", i3, str, (CampaignEx) null);
                }
                if (!this.X) {
                    return;
                }
            }
            int i4 = this.s;
            if (i4 == -1) {
                this.s = i2;
            } else if (i4 != i2) {
                this.t = 0;
            }
            com.mbridge.msdk.foundation.db.e.a(com.mbridge.msdk.foundation.db.g.a(this.h)).a();
            com.mbridge.msdk.foundation.same.net.wrapper.c aVar = new com.mbridge.msdk.mbnative.service.net.a(this.h);
            com.mbridge.msdk.foundation.same.net.wrapper.e eVar = new com.mbridge.msdk.foundation.same.net.wrapper.e();
            String b2 = com.mbridge.msdk.foundation.controller.c.m().b();
            String c2 = com.mbridge.msdk.foundation.controller.c.m().c();
            Map<String, Object> map = this.d;
            if (map != null && map.containsKey(MBridgeConstans.APP_ID) && this.d.containsKey(MBridgeConstans.APP_KEY) && this.d.containsKey(MBridgeConstans.KEY_WORD) && this.d.get(MBridgeConstans.KEY_WORD) != null) {
                if (this.d.get(MBridgeConstans.APP_ID) instanceof String) {
                    b2 = (String) this.d.get(MBridgeConstans.APP_ID);
                }
                if (this.d.get(MBridgeConstans.APP_KEY) instanceof String) {
                    c2 = (String) this.d.get(MBridgeConstans.APP_KEY);
                }
                String str2 = this.d.get(MBridgeConstans.KEY_WORD) instanceof String ? (String) this.d.get(MBridgeConstans.KEY_WORD) : null;
                if (!TextUtils.isEmpty(str2)) {
                    eVar.a("smart", j0.b(str2));
                }
            }
            eVar.a(MBridgeConstans.APP_ID, b2);
            eVar.a(MBridgeConstans.PROPERTIES_UNIT_ID, this.i);
            if (!TextUtils.isEmpty(this.j)) {
                eVar.a(MBridgeConstans.PLACEMENT_ID, this.j);
            }
            eVar.a("req_type", "2");
            if (!TextUtils.isEmpty(this.u)) {
                eVar.a("category", this.u);
            }
            eVar.a("sign", SameMD5.getMD5(b2 + c2));
            if (this.T > 0 && i3 == 0) {
                eVar.a("ad_num", this.T + "");
            } else {
                eVar.a("ad_num", this.q + "");
            }
            String d2 = u0.d(this.i);
            if (!TextUtils.isEmpty(d2)) {
                eVar.a(com.mbridge.msdk.foundation.same.report.j.b, d2);
            }
            eVar.a("only_impression", "1");
            eVar.a("ping_mode", "1");
            if (this.A != 0) {
                eVar.a("frame_num", this.A + "");
            }
            if (!TextUtils.isEmpty(this.m)) {
                eVar.a(MBridgeConstans.NATIVE_INFO, this.m);
                if (i2 == 1) {
                    eVar.a("tnum", this.H + "");
                }
            } else if (i2 == 1) {
                eVar.a("tnum", this.q + "");
            }
            a(eVar, i2);
            String a3 = com.mbridge.msdk.foundation.same.buffer.b.a(this.i, "native");
            if (!TextUtils.isEmpty(a3)) {
                eVar.a(com.mbridge.msdk.foundation.same.net.wrapper.e.g, a3);
            }
            if (this.d.containsKey(MBridgeConstans.NATIVE_VIDEO_WIDTH) && (this.d.get(MBridgeConstans.NATIVE_VIDEO_WIDTH) instanceof Integer)) {
                eVar.a("video_width", ((Integer) this.d.get(MBridgeConstans.NATIVE_VIDEO_WIDTH)).intValue() + "");
            }
            if (this.d.containsKey(MBridgeConstans.NATIVE_VIDEO_HEIGHT) && (this.d.get(MBridgeConstans.NATIVE_VIDEO_HEIGHT) instanceof Integer)) {
                eVar.a("video_height", ((Integer) this.d.get(MBridgeConstans.NATIVE_VIDEO_HEIGHT)).intValue() + "");
            }
            if (this.d.containsKey(MBridgeConstans.NATIVE_VIDEO_SUPPORT) && (this.d.get(MBridgeConstans.NATIVE_VIDEO_SUPPORT) instanceof Boolean)) {
                ((Boolean) this.d.get(MBridgeConstans.NATIVE_VIDEO_SUPPORT)).booleanValue();
            }
            eVar.a("video_version", "2.0");
            if (com.mbridge.msdk.setting.h.b().d(com.mbridge.msdk.foundation.controller.c.m().b()) == null) {
                com.mbridge.msdk.setting.h.b().a();
            }
            if (!b(this.d)) {
                JSONArray b3 = u0.b(this.h, this.i);
                if (b3.length() > 0) {
                    eVar.a(com.mbridge.msdk.foundation.same.net.wrapper.e.h, u0.a(b3));
                }
            }
            if (com.mbridge.msdk.mbnative.controller.d.g().containsKey(this.i) && com.mbridge.msdk.mbnative.controller.d.g().get(this.i).booleanValue() && com.mbridge.msdk.mbnative.controller.d.e().get(this.i) != null && (kVar = com.mbridge.msdk.mbnative.controller.d.e().get(this.i)) != null) {
                if (i2 == 1) {
                    this.t = kVar.a();
                } else if (i2 == 2) {
                    this.t = kVar.b();
                }
            }
            eVar.a("offset", this.t + "");
            eVar.a("ad_type", RoomMasterTable.DEFAULT_ID);
            eVar.a(CampaignEx.JSON_KEY_AD_SOURCE_ID, i2 + "");
            if (!TextUtils.isEmpty(this.o)) {
                eVar.a(com.mbridge.msdk.foundation.same.net.wrapper.e.i, this.o);
            }
            n nVar2 = new n();
            nVar2.b(a(this.d));
            nVar2.setUnitId(this.i);
            nVar2.setPlacementId(this.j);
            nVar2.setAdType(42);
            nVar2.b(true);
            p pVar = new p(1, nVar2, i3, str);
            nVar2.a(pVar);
            nVar2.a(i3);
            nVar2.a(str);
            if (i3 == 0) {
                if (!TextUtils.isEmpty(str)) {
                    eVar.a("token", str);
                }
                aVar.choiceV3OrV5BySetting(1, eVar, nVar2, str, com.mbridge.msdk.foundation.same.c.a(j2, 30000L));
                cVar = aVar;
            } else {
                cVar = aVar;
            }
            if (i3 == 1) {
                cVar.getLoadOrSetting(1, com.mbridge.msdk.foundation.same.net.utils.d.h().b0, eVar, nVar2, "campaign", com.mbridge.msdk.foundation.same.c.a(j2, 30000L));
            }
            this.f4508a.postDelayed(pVar, j2);
        } catch (Exception e2) {
            String str3 = c0;
            p0.b(str3, com.mbridge.msdk.mbnative.common.a.a(e2));
            p0.b(str3, e2.getMessage());
        }
    }

    private void a(View view, CampaignEx campaignEx) {
        BitmapDrawable a2;
        ImageView imageView;
        if (!(view instanceof FrameLayout) || (a2 = com.mbridge.msdk.foundation.controller.c.m().a(this.i, campaignEx.getAdType())) == null) {
            return;
        }
        try {
            int childCount = ((ViewGroup) view).getChildCount();
            int i2 = 0;
            while (true) {
                if (i2 >= childCount) {
                    imageView = null;
                    break;
                }
                View childAt = ((ViewGroup) view).getChildAt(i2);
                if ((childAt instanceof ImageView) && childAt.getTag() != null && "mb_wm".equals((String) childAt.getTag())) {
                    ((ImageView) childAt).setLayoutParams(new FrameLayout.LayoutParams(view.getWidth(), view.getHeight()));
                    imageView = (ImageView) childAt;
                    break;
                }
                i2++;
            }
            if (imageView == null) {
                imageView = new ImageView(com.mbridge.msdk.foundation.controller.c.m().d());
                imageView.setTag("mb_wm");
                u0.a(imageView, a2, view.getResources().getDisplayMetrics());
                if (imageView.getParent() == null) {
                    ((FrameLayout) view).addView(imageView, new FrameLayout.LayoutParams(view.getWidth(), view.getHeight()));
                }
                AdSession adSession = this.a0;
                if (adSession != null) {
                    adSession.addFriendlyObstruction(imageView, FriendlyObstructionPurpose.OTHER, null);
                }
            }
            this.P = new e(imageView, view);
            view.getViewTreeObserver().addOnGlobalLayoutListener(this.P);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void a(Campaign campaign, View view, List<View> list) {
        Class<MBMediaView> cls;
        try {
            a(view, (CampaignEx) campaign);
            NativeListener.NativeTrackingListener nativeTrackingListener = this.g;
            if (nativeTrackingListener != null) {
                this.p.a(nativeTrackingListener);
            }
            com.mbridge.msdk.mbnative.cache.c.a(campaign.getType()).a(this.i, campaign, this.N);
            CampaignEx campaignEx = (CampaignEx) campaign;
            try {
                cls = MBMediaView.class;
                int i2 = MBMediaView.p0;
            } catch (Throwable unused) {
                cls = null;
            }
            com.mbridge.msdk.foundation.same.buffer.b.a(this.i, campaignEx, "native");
            if (view != null) {
                if (cls != null && cls.isInstance(view)) {
                    return;
                }
                a1.a(view, campaignEx.getLocalRequestId(), campaignEx.getLocalAllowTrackClick());
                view.setOnClickListener(new f(campaignEx));
            }
            if (list != null && list.size() > 0) {
                for (View view2 : list) {
                    if (cls != null && cls.isInstance(view2)) {
                        break;
                    }
                    a1.a(view2, campaignEx.getLocalRequestId(), campaignEx.getLocalAllowTrackClick());
                    view2.setOnClickListener(new g(campaignEx));
                }
            }
            if (campaignEx.isReport()) {
                return;
            }
            a(campaignEx, view, list);
            Log.e(c0, "sendImpression" + campaignEx);
        } catch (Exception unused2) {
            p0.b(c0, "registerview exception!");
        }
    }

    public void a(Campaign campaign, View view) {
        try {
            NativeListener.NativeTrackingListener nativeTrackingListener = this.g;
            if (nativeTrackingListener != null) {
                this.p.a(nativeTrackingListener);
            }
            com.mbridge.msdk.mbnative.cache.c.a(campaign.getType()).a(this.i, campaign, this.N);
            CampaignEx campaignEx = (CampaignEx) campaign;
            com.mbridge.msdk.foundation.same.buffer.b.a(this.i, campaignEx, "native");
            a1.a(view, campaignEx.getLocalRequestId(), campaignEx.getLocalAllowTrackClick());
            i iVar = new i(campaignEx);
            try {
                int i2 = MBMediaView.p0;
                a(campaignEx, view, iVar, MBMediaView.class);
            } catch (Throwable unused) {
                a(campaignEx, view, iVar, (Class) null);
            }
            if (!com.mbridge.msdk.util.b.a()) {
                a(view, (CampaignEx) campaign);
            }
            if (campaignEx.isReport()) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(view);
            a(campaignEx, view, (List<View>) arrayList);
            p0.c(c0, "sendImpression" + campaignEx);
        } catch (Exception unused2) {
            p0.b(c0, "registerview exception!");
        }
    }

    private AdSession a(CampaignEx campaignEx) {
        if (this.G == null) {
            this.G = new Hashtable<>();
        }
        String requestIdNotice = campaignEx.getRequestIdNotice();
        AdSession adSession = this.G.get(requestIdNotice);
        if (adSession == null && campaignEx.isActiveOm() && TextUtils.isEmpty(campaignEx.getVideoUrlEncode())) {
            adSession = com.mbridge.msdk.omsdk.b.a(this.h, true, campaignEx.getOmid(), campaignEx.getRequestId(), campaignEx.getId(), this.i, "", campaignEx.getRequestIdNotice());
        }
        if (adSession != null) {
            this.G.put(requestIdNotice, adSession);
        }
        return adSession;
    }

    private void a(CampaignEx campaignEx, View view, List<View> list) {
        Exception exc;
        AdSession adSession;
        AdSession adSession2;
        int s2;
        try {
            if (this.h == null || campaignEx == null) {
                adSession = null;
            } else {
                try {
                    adSession = a(campaignEx);
                    if (adSession != null) {
                        adSession.registerAdView(view);
                        adSession.start();
                    }
                } catch (Exception e2) {
                    exc = e2;
                    p0.b(c0, com.mbridge.msdk.mbnative.common.a.a(exc));
                }
            }
            adSession2 = adSession;
            com.mbridge.msdk.setting.l lVar = this.Q;
            s2 = lVar != null ? lVar.s() : 0;
            if (campaignEx != null) {
                if (campaignEx.getImpReportType() == 1) {
                    s2 = 0;
                }
            }
        } catch (Exception e3) {
            e = e3;
        }
        try {
            s sVar = new s(campaignEx, view, list, this, adSession2);
            if (this.F == null) {
                this.F = new CopyOnWriteArrayList<>();
            }
            this.F.add(sVar);
            sVar.setOnStateChangeListener(new j(sVar));
            Handler handler = this.f4508a;
            if (handler != null) {
                handler.postDelayed(sVar, s2 * 1000);
            }
        } catch (Exception e4) {
            e = e4;
            exc = e;
            p0.b(c0, com.mbridge.msdk.mbnative.common.a.a(exc));
        }
    }

    private void a(CampaignEx campaignEx, View view, View.OnClickListener onClickListener, Class cls) {
        if (view == null || onClickListener == null) {
            return;
        }
        if (cls != null) {
            try {
                if (cls.isInstance(view)) {
                    return;
                }
            } catch (Throwable unused) {
                return;
            }
        }
        view.setOnClickListener(onClickListener);
        a1.a(view, campaignEx.getLocalRequestId(), campaignEx.getLocalAllowTrackClick());
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                a(campaignEx, viewGroup.getChildAt(i2), onClickListener, cls);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CampaignEx campaignEx, View view, List<View> list, AdSession adSession) {
        try {
            k kVar = new k(campaignEx);
            com.mbridge.msdk.mbnative.controller.c cVar = new com.mbridge.msdk.mbnative.controller.c(list, kVar, new Handler(Looper.getMainLooper()), campaignEx.getImpReportType());
            cVar.a(view);
            List<com.mbridge.msdk.mbnative.controller.c> list2 = this.D;
            if (list2 != null) {
                list2.add(cVar);
            }
            List<c.d> list3 = this.E;
            if (list3 != null) {
                list3.add(kVar);
            }
            AdEvents adEvents = this.b0;
            if (adEvents != null) {
                adEvents.impressionOccurred();
            }
        } catch (Exception unused) {
        }
    }

    private void a(View view, Class cls) {
        if (view == null) {
            return;
        }
        if (cls != null) {
            try {
                if (cls.isInstance(view)) {
                    return;
                }
            } catch (Throwable unused) {
                return;
            }
        }
        view.setOnClickListener(null);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                a(viewGroup.getChildAt(i2), cls);
            }
        }
    }

    public List<Campaign> a(String str, int i2, String str2) {
        int i3;
        int i4;
        List<Campaign> list = null;
        if (this.b != null) {
            ArrayList arrayList = new ArrayList(this.b);
            for (int i5 = 0; i5 < arrayList.size(); i5++) {
                com.mbridge.msdk.mbnative.cache.b<String, List<Campaign>> a2 = com.mbridge.msdk.mbnative.cache.c.a(((Integer) arrayList.get(i5)).intValue());
                if (a2 != null) {
                    if ((((Integer) arrayList.get(i5)).intValue() == 1 || ((Integer) arrayList.get(i5)).intValue() == 2) && this.d.containsKey(MBridgeConstans.NATIVE_INFO)) {
                        i4 = this.H;
                    } else {
                        i4 = this.q;
                    }
                    list = a(((Integer) arrayList.get(i5)).intValue(), a2.a((com.mbridge.msdk.mbnative.cache.b<String, List<Campaign>>) str, i4));
                    if (list != null) {
                        break;
                    }
                }
            }
            if (list == null) {
                for (int i6 = 0; i6 < arrayList.size(); i6++) {
                    com.mbridge.msdk.mbnative.cache.b<String, List<Campaign>> a3 = com.mbridge.msdk.mbnative.cache.c.a(((Integer) arrayList.get(i6)).intValue());
                    if ((((Integer) arrayList.get(i6)).intValue() == 1 || ((Integer) arrayList.get(i6)).intValue() == 2) && this.d.containsKey(MBridgeConstans.NATIVE_INFO)) {
                        i3 = this.H;
                    } else {
                        i3 = this.q;
                    }
                    list = a(((Integer) arrayList.get(i6)).intValue(), a3.b(str, i3));
                    if (list != null) {
                        break;
                    }
                }
            }
        }
        return a(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<Campaign> list, int i2, NativeListener.NativeAdListener nativeAdListener) {
        this.f4508a.post(new a(list, nativeAdListener, i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.mbridge.msdk.mbnative.listener.a aVar, String str, CampaignEx campaignEx) {
        this.f4508a.post(new b(aVar, campaignEx, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<Campaign> a(int i2, List<Campaign> list) {
        if (i2 == 1 && this.d.containsKey(MBridgeConstans.NATIVE_INFO) && list != null && list.size() > 0) {
            CampaignEx campaignEx = (CampaignEx) list.get(0);
            int template = campaignEx != null ? campaignEx.getTemplate() : 1;
            if (template == 2) {
                int size = list.size();
                int i3 = this.V;
                if (size >= i3) {
                    return list.subList(0, i3);
                }
            } else if (template == 3) {
                int size2 = list.size();
                int i4 = this.W;
                if (size2 >= i4) {
                    return list.subList(0, i4);
                }
            }
        }
        return list;
    }

    private void a(List<Campaign> list, o oVar) {
        c();
        long currentTimeMillis = System.currentTimeMillis();
        Timer timer = new Timer();
        this.M = timer;
        timer.schedule(new d(currentTimeMillis, oVar, list), 0L, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<Campaign> a(List<Campaign> list, boolean z) {
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                Campaign campaign = list.get(size);
                String id = campaign.getId();
                boolean z2 = campaign instanceof CampaignEx;
                if (z2) {
                    CampaignEx campaignEx = (CampaignEx) campaign;
                    id = id + campaignEx.getVideoUrlEncode() + campaignEx.getBidToken();
                }
                com.mbridge.msdk.videocommon.download.a a2 = com.mbridge.msdk.videocommon.download.b.getInstance().a(this.i, id);
                if (z) {
                    if (a2 == null || !com.mbridge.msdk.videocommon.download.l.a(a2, h().C())) {
                        com.mbridge.msdk.mbnative.cache.c.a(campaign.getType()).a(this.i, list.remove(size), this.N);
                    }
                } else if (z2) {
                    CampaignEx campaignEx2 = (CampaignEx) campaign;
                    if (TextUtils.isEmpty(campaignEx2.getImageUrl()) && !TextUtils.isEmpty(campaignEx2.getVideoUrlEncode()) && (a2 == null || !com.mbridge.msdk.videocommon.download.l.a(a2, h().C()))) {
                        com.mbridge.msdk.mbnative.cache.c.a(campaign.getType()).a(this.i, list.remove(size), this.N);
                    }
                }
            }
        }
        return list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<Campaign> a(List<Campaign> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        ArrayList arrayList2 = new ArrayList(list.size());
        for (Campaign campaign : list) {
            if (campaign instanceof CampaignEx) {
                CampaignEx campaignEx = (CampaignEx) campaign;
                if (TextUtils.isEmpty(this.N) && TextUtils.isEmpty(campaignEx.getBidToken()) && !campaignEx.isBidCampaign()) {
                    arrayList2.add(campaignEx);
                } else if (!TextUtils.isEmpty(this.N) && TextUtils.equals(campaignEx.getBidToken(), this.N)) {
                    arrayList.add(campaign);
                }
            } else {
                arrayList2.add(campaign);
            }
        }
        return TextUtils.isEmpty(this.N) ? arrayList2 : arrayList;
    }
}
