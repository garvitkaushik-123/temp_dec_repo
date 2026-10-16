package com.mbridge.msdk.video.dynview.wrapper;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.ironsource.C3040d4;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.dycreator.baseview.MBHeatLevelLayoutView;
import com.mbridge.msdk.dycreator.baseview.MBStarLevelLayoutView;
import com.mbridge.msdk.dycreator.baseview.cusview.MBCusRoundImageView;
import com.mbridge.msdk.dycreator.baseview.cusview.MBRotationView;
import com.mbridge.msdk.dycreator.baseview.cusview.MBridgeImageView;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.b1;
import com.mbridge.msdk.foundation.tools.h0;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.foundation.tools.u0;
import com.mbridge.msdk.foundation.tools.z;
import com.mbridge.msdk.video.dynview.shape.a;
import com.mbridge.msdk.video.dynview.widget.MBridgeLevelLayoutView;
import com.mbridge.msdk.videocommon.view.RoundImageView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: DataEnergizeWrapper.java */
/* loaded from: classes6.dex */
public class a {
    private static boolean m = false;

    /* renamed from: a, reason: collision with root package name */
    private com.mbridge.msdk.video.dynview.util.time.b f5074a;
    private Map<String, Bitmap> b;
    private volatile boolean c;
    private String d = "#FFFFFFFF";
    private String e = "#60000000";
    private String f = "#FF5F5F5F";
    private String g = "#90ECECEC";
    private volatile long h = 0;
    private com.mbridge.msdk.video.dynview.util.time.a i = null;
    private boolean j = false;
    private int k = 0;
    public com.mbridge.msdk.video.dynview.inter.a l = new c();

    /* compiled from: DataEnergizeWrapper.java */
    /* renamed from: com.mbridge.msdk.video.dynview.wrapper.a$a, reason: collision with other inner class name */
    class C0413a implements com.mbridge.msdk.video.dynview.util.time.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ TextView f5075a;
        final /* synthetic */ String b;
        final /* synthetic */ CampaignEx c;
        final /* synthetic */ Map d;

        C0413a(TextView textView, String str, CampaignEx campaignEx, Map map) {
            this.f5075a = textView;
            this.b = str;
            this.c = campaignEx;
            this.d = map;
        }

        @Override // com.mbridge.msdk.video.dynview.util.time.a
        public void onFinish() {
            this.c.setShowType(com.mbridge.msdk.foundation.same.report.metrics.a.c);
            a.this.b(this.d);
        }

        @Override // com.mbridge.msdk.video.dynview.util.time.a
        public void onTick(long j) {
            a.this.k = (int) (j / 1000);
            this.f5075a.setText(com.mbridge.msdk.video.dynview.util.a.a(a.this.k, this.f5075a.getContext()));
            a.this.h++;
            if (TextUtils.isEmpty(this.b) || !this.b.equals("1")) {
                return;
            }
            com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
            eVar.a("type", "choseFromTwoHeartbeat");
            eVar.a("xtSecond", "countTimeForReport");
            eVar.a("autoPlayCountDownTime", "mLeftOverCountTime");
            com.mbridge.msdk.video.module.report.a.a("2000103", this.c, eVar);
        }
    }

    /* compiled from: DataEnergizeWrapper.java */
    class c implements com.mbridge.msdk.video.dynview.inter.a {
        c() {
        }

        @Override // com.mbridge.msdk.video.dynview.inter.a
        public void a() {
            if (!a.this.j || a.this.f5074a == null) {
                return;
            }
            a.this.f5074a.a(a.this.k * 1000, a.this.i);
            a.this.j = false;
        }

        @Override // com.mbridge.msdk.video.dynview.inter.a
        public void b() {
            if (a.this.f5074a != null) {
                a.this.f5074a.a();
                a.this.j = true;
            }
        }

        @Override // com.mbridge.msdk.video.dynview.inter.a
        public void c() {
            if (a.this.f5074a != null) {
                a.this.f5074a.a();
                a.this.j = true;
            }
        }
    }

    /* compiled from: DataEnergizeWrapper.java */
    class d extends com.mbridge.msdk.widget.a {
        final /* synthetic */ Map b;
        final /* synthetic */ List c;

        d(Map map, List list) {
            this.b = map;
            this.c = list;
        }

        @Override // com.mbridge.msdk.widget.a
        protected void a(View view) {
            if (a.this.c) {
                return;
            }
            a.this.c = true;
            a.this.a(this.b, (List<CampaignEx>) this.c, 0);
        }
    }

    /* compiled from: DataEnergizeWrapper.java */
    class e extends com.mbridge.msdk.widget.a {
        final /* synthetic */ Map b;
        final /* synthetic */ List c;

        e(Map map, List list) {
            this.b = map;
            this.c = list;
        }

        @Override // com.mbridge.msdk.widget.a
        protected void a(View view) {
            if (a.this.c) {
                return;
            }
            a.this.c = true;
            a.this.a(this.b, (List<CampaignEx>) this.c, 1);
        }
    }

    /* compiled from: DataEnergizeWrapper.java */
    class f implements AdapterView.OnItemClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Map f5078a;
        final /* synthetic */ List b;

        f(Map map, List list) {
            this.f5078a = map;
            this.b = list;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            a.this.a(this.f5078a, (List<CampaignEx>) this.b, i);
        }
    }

    /* compiled from: DataEnergizeWrapper.java */
    class g implements AdapterView.OnItemClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Map f5079a;
        final /* synthetic */ List b;

        g(Map map, List list) {
            this.f5079a = map;
            this.b = list;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            a.this.a(this.f5079a, (List<CampaignEx>) this.b, i);
        }
    }

    /* compiled from: DataEnergizeWrapper.java */
    class h implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Map f5080a;

        h(Map map) {
            this.f5080a = map;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.a(this.f5080a);
        }
    }

    /* compiled from: DataEnergizeWrapper.java */
    class i implements com.mbridge.msdk.foundation.same.image.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f5081a;
        final /* synthetic */ ImageView b;

        /* compiled from: DataEnergizeWrapper.java */
        /* renamed from: com.mbridge.msdk.video.dynview.wrapper.a$i$a, reason: collision with other inner class name */
        class RunnableC0414a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Bitmap f5082a;

            /* compiled from: DataEnergizeWrapper.java */
            /* renamed from: com.mbridge.msdk.video.dynview.wrapper.a$i$a$a, reason: collision with other inner class name */
            class RunnableC0415a implements Runnable {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ Bitmap f5083a;

                RunnableC0415a(Bitmap bitmap) {
                    this.f5083a = bitmap;
                }

                @Override // java.lang.Runnable
                public void run() {
                    i.this.b.setImageBitmap(this.f5083a);
                }
            }

            RunnableC0414a(Bitmap bitmap) {
                this.f5082a = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    i.this.b.post(new RunnableC0415a(z.a(this.f5082a, 10)));
                } catch (Exception e) {
                    p0.b("DataEnergizeWrapper", e.getMessage());
                }
            }
        }

        i(int i, ImageView imageView) {
            this.f5081a = i;
            this.b = imageView;
        }

        @Override // com.mbridge.msdk.foundation.same.image.c
        public void onFailedLoad(String str, String str2) {
            try {
                int a2 = h0.a(this.b.getContext(), "mbridge_icon_play_bg", "drawable");
                this.b.setBackgroundColor(Color.parseColor(a.this.f));
                this.b.setImageResource(a2);
                this.b.setScaleType(ImageView.ScaleType.CENTER);
            } catch (Exception e) {
                p0.a("DataEnergizeWrapper", e.getMessage());
            }
        }

        @Override // com.mbridge.msdk.foundation.same.image.c
        public void onSuccessLoad(Bitmap bitmap, String str) {
            if (bitmap == null || bitmap.isRecycled()) {
                int a2 = h0.a(this.b.getContext(), "mbridge_icon_play_bg", "drawable");
                this.b.setBackgroundColor(Color.parseColor(a.this.f));
                this.b.setImageResource(a2);
                this.b.setScaleType(ImageView.ScaleType.CENTER);
                return;
            }
            int i = this.f5081a;
            if (i != 501 && i != 802) {
                this.b.setImageBitmap(bitmap);
            } else {
                com.mbridge.msdk.foundation.same.threadpool.a.a().execute(new RunnableC0414a(bitmap));
            }
        }
    }

    /* compiled from: DataEnergizeWrapper.java */
    class j implements com.mbridge.msdk.foundation.same.image.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ImageView f5084a;
        final /* synthetic */ String b;
        final /* synthetic */ com.mbridge.msdk.video.dynview.c c;
        final /* synthetic */ View d;

        j(ImageView imageView, String str, com.mbridge.msdk.video.dynview.c cVar, View view) {
            this.f5084a = imageView;
            this.b = str;
            this.c = cVar;
            this.d = view;
        }

        @Override // com.mbridge.msdk.foundation.same.image.c
        public void onFailedLoad(String str, String str2) {
        }

        @Override // com.mbridge.msdk.foundation.same.image.c
        public void onSuccessLoad(Bitmap bitmap, String str) {
            ImageView imageView;
            if (bitmap == null || bitmap.isRecycled() || (imageView = this.f5084a) == null) {
                return;
            }
            imageView.setImageBitmap(bitmap);
            if (a.this.b != null) {
                a.this.b.put(SameMD5.getMD5(this.b), bitmap);
                a.this.a(this.c, this.d);
            }
        }
    }

    /* compiled from: DataEnergizeWrapper.java */
    class k extends com.mbridge.msdk.widget.a {
        final /* synthetic */ CampaignEx b;
        final /* synthetic */ Map c;

        k(CampaignEx campaignEx, Map map) {
            this.b = campaignEx;
            this.c = map;
        }

        @Override // com.mbridge.msdk.widget.a
        protected void a(View view) {
            if (a.this.c) {
                return;
            }
            a.this.c = true;
            this.b.setShowType(com.mbridge.msdk.foundation.same.report.metrics.a.d);
            a.this.b(this.c);
        }
    }

    public void c(com.mbridge.msdk.video.dynview.c cVar, View view, Map map, com.mbridge.msdk.video.dynview.listener.e eVar) {
        try {
            if (this.b == null) {
                this.b = new HashMap();
            }
            List<CampaignEx> b2 = cVar.b();
            if (view.getContext() == null) {
                eVar.a(com.mbridge.msdk.video.dynview.error.a.NOT_FOUND_CONTEXT);
                return;
            }
            if (map != null && map.containsKey("is_dy_success")) {
                m = ((Boolean) map.get("is_dy_success")).booleanValue();
            }
            for (CampaignEx campaignEx : b2) {
                if (campaignEx != null) {
                    campaignEx.setECTemplateRenderSucc(m);
                }
            }
            ListView listView = (ListView) view.findViewById(a(m, "mbridge_order_view_lv"));
            GridView gridView = (GridView) view.findViewById(a(m, "mbridge_order_view_h_lv"));
            ImageView imageView = (ImageView) view.findViewById(a(m, "mbridge_order_view_iv_close"));
            com.mbridge.msdk.video.dynview.ordercamp.adapter.a aVar = new com.mbridge.msdk.video.dynview.ordercamp.adapter.a(b2);
            if (cVar.h() == 1) {
                if (listView != null) {
                    a(listView, cVar);
                    listView.setAdapter((ListAdapter) aVar);
                    listView.setOnItemClickListener(new f(map, b2));
                }
            } else if (gridView != null) {
                int m2 = (int) cVar.m();
                int size = m2 / b2.size();
                int i2 = size / 9;
                int i3 = i2 / 2;
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) gridView.getLayoutParams();
                layoutParams.width = m2 - (i2 * 2);
                gridView.setLayoutParams(layoutParams);
                gridView.setColumnWidth((size - i2) - (i3 / 2));
                gridView.setHorizontalSpacing(i3);
                gridView.setStretchMode(0);
                gridView.setNumColumns(b2.size());
                gridView.setAdapter((ListAdapter) aVar);
                gridView.setOnItemClickListener(new g(map, b2));
            }
            if (imageView != null) {
                imageView.setOnClickListener(new h(map));
            }
            if (eVar != null) {
                eVar.a(view, null);
            }
        } catch (Exception unused) {
            if (eVar != null) {
                eVar.a(com.mbridge.msdk.video.dynview.error.a.NOT_FOUND_VIEWOPTION);
            }
        }
    }

    /* compiled from: DataEnergizeWrapper.java */
    class b implements com.mbridge.msdk.foundation.feedback.a {
        b() {
        }

        @Override // com.mbridge.msdk.foundation.feedback.a
        public void a() {
            if (a.this.f5074a != null) {
                a.this.f5074a.a();
                a.this.j = true;
            }
        }

        @Override // com.mbridge.msdk.foundation.feedback.a
        public void close() {
            if (!a.this.j || a.this.f5074a == null) {
                return;
            }
            a.this.f5074a.a(a.this.k * 1000, a.this.i);
            a.this.j = false;
        }

        @Override // com.mbridge.msdk.foundation.feedback.a
        public void a(String str) {
            if (!a.this.j || a.this.f5074a == null) {
                return;
            }
            a.this.f5074a.a(a.this.k * 1000, a.this.i);
            a.this.j = false;
        }
    }

    public void b(com.mbridge.msdk.video.dynview.c cVar, View view, Map map, com.mbridge.msdk.video.dynview.listener.e eVar) {
        if (eVar == null) {
            return;
        }
        if (cVar == null) {
            eVar.a(com.mbridge.msdk.video.dynview.error.a.NOT_FOUND_VIEWOPTION);
            return;
        }
        if (map != null && map.containsKey("is_dy_success")) {
            m = ((Boolean) map.get("is_dy_success")).booleanValue();
        }
        boolean z = m;
        LinearLayout linearLayout = z ? (LinearLayout) view.findViewById(a(z, "mbridge_reward_heat_mllv")) : null;
        ImageView imageView = (ImageView) view.findViewById(a(m, "mbridge_reward_icon_riv"));
        TextView textView = (TextView) view.findViewById(a(m, "mbridge_reward_title_tv"));
        LinearLayout linearLayout2 = (LinearLayout) view.findViewById(a(m, "mbridge_reward_stars_mllv"));
        TextView textView2 = (TextView) view.findViewById(a(m, "mbridge_reward_click_tv"));
        ImageView imageView2 = (ImageView) view.findViewById(a(m, "mbridge_videoview_bg"));
        TextView textView3 = (TextView) view.findViewById(a(m, "mbridge_reward_desc_tv"));
        View view2 = (RelativeLayout) view.findViewById(a(m, "mbridge_reward_bottom_layout"));
        List<View> arrayList = new ArrayList<>();
        List<CampaignEx> b2 = cVar.b();
        if (b2 != null && b2.size() > 0) {
            CampaignEx campaignEx = b2.get(0);
            if (campaignEx != null) {
                if (imageView != null) {
                    if (m) {
                        if (imageView instanceof MBCusRoundImageView) {
                            ((MBCusRoundImageView) imageView).setCustomBorder(30, 30, 30, 30, 10, -1);
                        }
                    } else {
                        ((RoundImageView) imageView).setBorderRadius(10);
                    }
                    a(campaignEx.getIconUrl(), imageView);
                }
                if (textView != null) {
                    textView.setText(campaignEx.getAppName());
                }
                if (textView3 != null) {
                    textView3.setText(campaignEx.getAppDesc());
                }
                if (linearLayout2 != null) {
                    double rating = campaignEx.getRating();
                    if (rating <= 0.0d) {
                        rating = 5.0d;
                    }
                    if (m) {
                        if (linearLayout2 instanceof MBStarLevelLayoutView) {
                            MBStarLevelLayoutView mBStarLevelLayoutView = (MBStarLevelLayoutView) linearLayout2;
                            mBStarLevelLayoutView.setRating((int) rating);
                            mBStarLevelLayoutView.setOrientation(0);
                        }
                        if (linearLayout instanceof MBHeatLevelLayoutView) {
                            ((MBHeatLevelLayoutView) linearLayout).setHeatCount(campaignEx.getNumberRating());
                        }
                    } else {
                        ((MBridgeLevelLayoutView) linearLayout2).setRatingAndUser(rating, campaignEx.getNumberRating());
                    }
                }
                if (textView2 != null) {
                    textView2.setText(campaignEx.getAdCall());
                }
                int l = cVar.l();
                if (l == 102 || l == 202 || l == 302) {
                    if (textView2 != null) {
                        arrayList.add(textView2);
                    }
                } else if (l == 802) {
                    if (imageView != null) {
                        arrayList.add(imageView);
                    }
                    if (textView2 != null) {
                        arrayList.add(textView2);
                    }
                    a(imageView2, campaignEx.getImageUrl(), l);
                } else if (l != 902) {
                    if (l != 904) {
                        if (l == 5002010) {
                            if (cVar.p() && view2 != null && view2.getVisibility() == 0) {
                                arrayList.add(view2);
                            } else {
                                if (imageView != null) {
                                    arrayList.add(imageView);
                                }
                                if (textView2 != null) {
                                    arrayList.add(textView2);
                                }
                            }
                        }
                    } else if (cVar.p()) {
                        arrayList.add(view);
                    }
                } else if (TextUtils.isEmpty(cVar.n()) || !cVar.n().equals("dsp") || !TextUtils.isEmpty(campaignEx.getClickURL())) {
                    arrayList.add(view);
                }
                eVar.a(view, arrayList);
                return;
            }
            eVar.a(com.mbridge.msdk.video.dynview.error.a.CAMPAIGNEX_IS_NULL);
            return;
        }
        eVar.a(com.mbridge.msdk.video.dynview.error.a.CAMPAIGNEX_IS_NULL);
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x02a7  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x02b5  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x02be  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x02d8  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0303  */
    /* JADX WARN: Removed duplicated region for block: B:81:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(com.mbridge.msdk.video.dynview.c cVar, View view, Map map, com.mbridge.msdk.video.dynview.listener.e eVar) {
        CampaignEx campaignEx;
        CampaignEx campaignEx2;
        RoundImageView roundImageView;
        RoundImageView roundImageView2;
        ImageView imageView;
        ImageView imageView2;
        ImageView imageView3;
        RoundImageView roundImageView3;
        int i2;
        int i3;
        RoundImageView roundImageView4;
        ImageView imageView4;
        ImageView imageView5;
        if (this.b == null) {
            this.b = new HashMap();
        }
        List<CampaignEx> b2 = cVar.b();
        if (view == null) {
            eVar.a(com.mbridge.msdk.video.dynview.error.a.NOT_FOUND_ROOTVIEW);
            return;
        }
        Context context = view.getContext();
        if (context == null) {
            eVar.a(com.mbridge.msdk.video.dynview.error.a.NOT_FOUND_CONTEXT);
            return;
        }
        if (b2 == null || b2.size() <= 1) {
            campaignEx = null;
            campaignEx2 = null;
        } else {
            campaignEx = b2.get(0);
            campaignEx.setShowIndex(com.mbridge.msdk.foundation.same.report.metrics.a.f4327a);
            campaignEx2 = b2.get(1);
            campaignEx2.setShowIndex(com.mbridge.msdk.foundation.same.report.metrics.a.b);
        }
        if (campaignEx == null && eVar != null) {
            eVar.a(com.mbridge.msdk.video.dynview.error.a.CAMPAIGNEX_IS_NULL);
            return;
        }
        if (campaignEx2 == null && eVar != null) {
            eVar.a(com.mbridge.msdk.video.dynview.error.a.CAMPAIGNEX_IS_NULL);
            return;
        }
        if (map != null && map.containsKey("is_dy_success")) {
            m = ((Boolean) map.get("is_dy_success")).booleanValue();
        }
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(a(m, "mbridge_top_item_rl"));
        MBridgeImageView mBridgeImageView = (MBridgeImageView) view.findViewById(a(m, "mbridge_top_iv"));
        MBRotationView mBRotationView = (MBRotationView) view.findViewById(a(m, "mbridge_top_ration"));
        TextView textView = (TextView) view.findViewById(a(m, "mbridge_top_title_tv"));
        RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(a(m, "mbridge_bottom_item_rl"));
        MBRotationView mBRotationView2 = (MBRotationView) view.findViewById(a(m, "mbridge_bottom_ration"));
        MBridgeImageView mBridgeImageView2 = (MBridgeImageView) view.findViewById(a(m, "mbridge_bottom_iv"));
        boolean z = m;
        CampaignEx campaignEx3 = campaignEx;
        if (z) {
            ImageView imageView6 = (MBCusRoundImageView) view.findViewById(a(z, "mbridge_top_icon_iv"));
            imageView2 = (MBCusRoundImageView) view.findViewById(a(m, "mbridge_bottom_icon_iv"));
            roundImageView2 = null;
            imageView = imageView6;
            roundImageView = null;
        } else {
            roundImageView = (RoundImageView) view.findViewById(a(z, "mbridge_top_icon_iv"));
            roundImageView2 = (RoundImageView) view.findViewById(a(m, "mbridge_bottom_icon_iv"));
            imageView = null;
            imageView2 = null;
        }
        CampaignEx campaignEx4 = campaignEx2;
        TextView textView2 = (TextView) view.findViewById(a(m, "mbridge_bottom_title_tv"));
        RoundImageView roundImageView5 = roundImageView2;
        ImageView imageView7 = (ImageView) view.findViewById(a(m, "mbridge_reward_choice_one_like_iv"));
        if (relativeLayout != null) {
            relativeLayout.setOnClickListener(new d(map, b2));
        }
        if (mBridgeImageView != null) {
            imageView3 = imageView7;
            roundImageView3 = roundImageView5;
            mBridgeImageView.setCustomBorder(20, 20, 0, 0, 10, -16777216);
            a(campaignEx3.getImageUrl(), mBridgeImageView, cVar, view);
            if (mBRotationView != null) {
                if (campaignEx3.getCanStart2C1Anim()) {
                    if (!TextUtils.isEmpty(campaignEx3.getIconUrl())) {
                        ImageView imageView8 = new ImageView(cVar.c());
                        imageView8.setLayoutParams(new FrameLayout.LayoutParams(-1, u0.a(cVar.c(), 200.0f)));
                        imageView8.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        mBRotationView.addView(imageView8);
                        a(campaignEx3.getIconUrl(), imageView8);
                        mBRotationView.setWidthRatio(0.45f);
                        mBRotationView.setHeightRatio(0.9f);
                        mBRotationView.setAutoscroll(true);
                    } else {
                        mBRotationView.setWidthRatio(1.0f);
                        mBRotationView.setHeightRatio(1.0f);
                        i2 = 0;
                        mBRotationView.setAutoscroll(false);
                    }
                } else {
                    i2 = 0;
                    mBRotationView.setWidthRatio(1.0f);
                    mBRotationView.setHeightRatio(1.0f);
                    mBRotationView.setAutoscroll(false);
                }
                if (roundImageView != null) {
                    roundImageView.setType(i2);
                    a(campaignEx3.getIconUrl(), roundImageView);
                }
                if (imageView != null) {
                    a(campaignEx3.getIconUrl(), imageView);
                }
                if (textView != null) {
                    if (!TextUtils.isEmpty(campaignEx3.getAppName())) {
                        textView.setText(campaignEx3.getAppName());
                    } else {
                        textView.setVisibility(8);
                    }
                }
                if (relativeLayout2 != null) {
                    relativeLayout2.setOnClickListener(new e(map, b2));
                }
                if (mBridgeImageView2 != null) {
                    mBridgeImageView2.setCustomBorder(20, 20, 0, 0, 10, -16777216);
                    a(campaignEx4.getImageUrl(), mBridgeImageView2, cVar, view);
                    if (mBRotationView2 != null) {
                        if (campaignEx4.getCanStart2C1Anim()) {
                            if (!TextUtils.isEmpty(campaignEx4.getIconUrl())) {
                                ImageView imageView9 = new ImageView(cVar.c());
                                imageView9.setLayoutParams(new FrameLayout.LayoutParams(-1, u0.a(cVar.c(), 200.0f)));
                                imageView9.setScaleType(ImageView.ScaleType.CENTER_CROP);
                                mBRotationView2.addView(imageView9);
                                a(campaignEx4.getIconUrl(), imageView9);
                                mBRotationView2.setWidthRatio(0.45f);
                                mBRotationView2.setHeightRatio(0.9f);
                                mBRotationView2.setAutoscroll(true);
                                roundImageView4 = roundImageView3;
                                i3 = 0;
                                if (roundImageView4 != null) {
                                    roundImageView4.setType(i3);
                                    a(campaignEx4.getIconUrl(), roundImageView4);
                                }
                                imageView4 = imageView2;
                                if (imageView4 != null) {
                                    a(campaignEx4.getIconUrl(), imageView4);
                                }
                                if (textView2 != null) {
                                    textView2.setText(campaignEx4.getAppName());
                                }
                                a(campaignEx3.getCMPTEntryUrl(), context, view, cVar.h(), map, campaignEx3);
                                imageView5 = imageView3;
                                if (imageView5 != null) {
                                    if (cVar.h() == 1) {
                                        imageView5.setImageResource(h0.a(context.getApplicationContext(), com.mbridge.msdk.video.dynview.util.a.a(context, 1), "drawable"));
                                    } else {
                                        imageView5.setImageResource(h0.a(context.getApplicationContext(), com.mbridge.msdk.video.dynview.util.a.a(context, 2), "drawable"));
                                    }
                                }
                                if (eVar == null) {
                                    eVar.a(view, null);
                                    return;
                                }
                                return;
                            }
                            mBRotationView2.setWidthRatio(1.0f);
                            mBRotationView2.setHeightRatio(1.0f);
                            i3 = 0;
                            mBRotationView2.setAutoscroll(false);
                        } else {
                            i3 = 0;
                            mBRotationView2.setWidthRatio(1.0f);
                            mBRotationView2.setHeightRatio(1.0f);
                            mBRotationView2.setAutoscroll(false);
                        }
                        roundImageView4 = roundImageView3;
                        if (roundImageView4 != null) {
                        }
                        imageView4 = imageView2;
                        if (imageView4 != null) {
                        }
                        if (textView2 != null) {
                        }
                        a(campaignEx3.getCMPTEntryUrl(), context, view, cVar.h(), map, campaignEx3);
                        imageView5 = imageView3;
                        if (imageView5 != null) {
                        }
                        if (eVar == null) {
                        }
                    }
                }
                i3 = 0;
                roundImageView4 = roundImageView3;
                if (roundImageView4 != null) {
                }
                imageView4 = imageView2;
                if (imageView4 != null) {
                }
                if (textView2 != null) {
                }
                a(campaignEx3.getCMPTEntryUrl(), context, view, cVar.h(), map, campaignEx3);
                imageView5 = imageView3;
                if (imageView5 != null) {
                }
                if (eVar == null) {
                }
            }
        } else {
            imageView3 = imageView7;
            roundImageView3 = roundImageView5;
        }
        i2 = 0;
        if (roundImageView != null) {
        }
        if (imageView != null) {
        }
        if (textView != null) {
        }
        if (relativeLayout2 != null) {
        }
        if (mBridgeImageView2 != null) {
        }
        i3 = 0;
        roundImageView4 = roundImageView3;
        if (roundImageView4 != null) {
        }
        imageView4 = imageView2;
        if (imageView4 != null) {
        }
        if (textView2 != null) {
        }
        a(campaignEx3.getCMPTEntryUrl(), context, view, cVar.h(), map, campaignEx3);
        imageView5 = imageView3;
        if (imageView5 != null) {
        }
        if (eVar == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Map map) {
        if (map != null) {
            try {
                if (map.containsKey("choice_one_callback") && (map.get("choice_one_callback") instanceof com.mbridge.msdk.video.dynview.listener.d)) {
                    ((com.mbridge.msdk.video.dynview.listener.d) map.get("choice_one_callback")).a();
                    b();
                }
            } catch (Exception e2) {
                p0.b("DataEnergizeWrapper", e2.getMessage());
            }
        }
    }

    private void b(com.mbridge.msdk.video.dynview.c cVar, View view) {
        a.b a2 = com.mbridge.msdk.video.dynview.shape.a.a();
        a2.a(cVar.h()).a(true);
        if (cVar.h() != 2) {
            a2.b(cVar.m()).a(cVar.k());
        } else if (cVar.m() > cVar.k()) {
            a2.b(cVar.m()).a(cVar.k());
        } else {
            a2.b(cVar.k()).a(cVar.m());
        }
        if (view.getBackground() == null) {
            view.setBackground(a2.a());
        }
    }

    public void a(com.mbridge.msdk.video.dynview.c cVar, View view, com.mbridge.msdk.video.dynview.listener.e eVar) {
        if (eVar == null) {
            return;
        }
        if (cVar == null) {
            eVar.a(com.mbridge.msdk.video.dynview.error.a.NOT_FOUND_VIEWOPTION);
            return;
        }
        try {
            ImageView imageView = (ImageView) view.findViewById(h0.a(com.mbridge.msdk.foundation.controller.c.m().d(), "mbridge_iv_adbanner_bg", "id"));
            if (imageView != null) {
                imageView.setBackgroundColor(Color.parseColor(this.g));
            }
            ImageView imageView2 = (ImageView) view.findViewById(h0.a(com.mbridge.msdk.foundation.controller.c.m().d(), "mbridge_iv_adbanner", "id"));
            if (imageView2 != null) {
                imageView2.setBackgroundColor(Color.parseColor(this.g));
            }
            eVar.a(view, new ArrayList());
        } catch (Exception e2) {
            p0.a("DataEnergizeWrapper", e2.getMessage());
            eVar.a(com.mbridge.msdk.video.dynview.error.a.NOT_FOUND_VIEWOPTION);
        }
    }

    private void b() {
        com.mbridge.msdk.video.dynview.util.draw.a.a().b();
        com.mbridge.msdk.video.dynview.util.time.b bVar = this.f5074a;
        if (bVar != null) {
            bVar.a();
            this.f5074a = null;
        }
        com.mbridge.msdk.video.dynview.energize.a.a().f5032a = null;
        if (this.l != null) {
            this.l = null;
        }
        Map<String, Bitmap> map = this.b;
        if (map != null) {
            if (map.entrySet() != null) {
                try {
                    Iterator<Map.Entry<String, Bitmap>> it = this.b.entrySet().iterator();
                    while (it.hasNext()) {
                        Map.Entry<String, Bitmap> next = it.next();
                        if (next != null && next.getValue() != null && !next.getValue().isRecycled()) {
                            next.getValue().recycle();
                        }
                        it.remove();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            this.b.clear();
        }
    }

    private void a(String str, ImageView imageView) {
        if (TextUtils.isEmpty(str) || imageView == null) {
            return;
        }
        a(imageView, str, -1);
    }

    private void a(ImageView imageView, String str, int i2) {
        if (TextUtils.isEmpty(str) || imageView == null) {
            return;
        }
        com.mbridge.msdk.foundation.same.image.b.a(imageView.getContext()).a(str, new i(i2, imageView));
    }

    private void a(String str, ImageView imageView, com.mbridge.msdk.video.dynview.c cVar, View view) {
        com.mbridge.msdk.foundation.same.image.b.a(imageView.getContext()).a(str, new j(imageView, str, cVar, view));
        try {
            Bitmap a2 = a();
            if (a2 == null || a2.isRecycled()) {
                return;
            }
            b(cVar, view);
        } catch (Exception e2) {
            p0.b("DataEnergizeWrapper", e2.getMessage());
        }
    }

    private void a(String str, Context context, View view, int i2, Map map, CampaignEx campaignEx) {
        CampaignEx campaignEx2;
        String a2 = b1.a(str, "cltp");
        String a3 = b1.a(str, "xt");
        long parseLong = !TextUtils.isEmpty(a2) ? Long.parseLong(a2) : 0L;
        if (parseLong != 0) {
            if (map != null && map.containsKey("is_dy_success")) {
                m = ((Boolean) map.get("is_dy_success")).booleanValue();
            }
            TextView textView = (TextView) view.findViewById(a(m, "mbridge_choice_one_countdown_tv"));
            if (textView != null) {
                textView.setTextSize(11.0f);
                textView.setTextColor(Color.parseColor(this.d));
                String str2 = this.e;
                com.mbridge.msdk.video.dynview.util.drawable.a.a(textView, 1, 12, str2, str2);
                textView.setVisibility(0);
                textView.setOnClickListener(new k(campaignEx, map));
                campaignEx2 = campaignEx;
                this.i = new C0413a(textView, a3, campaignEx2, map);
                com.mbridge.msdk.video.dynview.util.time.b a4 = new com.mbridge.msdk.video.dynview.util.time.b().b(parseLong * 1000).a(1000L).a(this.i);
                this.f5074a = a4;
                a4.c();
            } else {
                campaignEx2 = campaignEx;
            }
            ImageView imageView = (ImageView) view.findViewById(a(m, "mbridge_iv_link"));
            if (campaignEx2 == null) {
                return;
            }
            if (campaignEx2.getAdchoice() != null) {
                campaignEx2.getAdchoice().g("");
            }
            u0.a(4, imageView, campaignEx2, com.mbridge.msdk.foundation.controller.c.m().d(), false, new b());
        }
    }

    private void a(ListView listView, com.mbridge.msdk.video.dynview.c cVar) {
        if (listView == null || cVar == null) {
            return;
        }
        try {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) listView.getLayoutParams();
            if (layoutParams == null) {
                return;
            }
            layoutParams.height = -1;
            float k2 = (cVar.k() - u0.a(com.mbridge.msdk.foundation.controller.c.m().d(), 720.0f)) / 2.0f;
            int a2 = u0.a(com.mbridge.msdk.foundation.controller.c.m().d(), 10.0f);
            int i2 = (int) k2;
            layoutParams.setMargins(a2, i2, a2, i2);
            listView.setLayoutParams(layoutParams);
        } catch (Exception e2) {
            p0.b("DataEnergizeWrapper", e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Map map, List<CampaignEx> list, int i2) {
        if (map == null || list == null || list.size() <= 1) {
            return;
        }
        if (map.containsKey("choice_one_callback") && (map.get("choice_one_callback") instanceof com.mbridge.msdk.video.dynview.listener.d)) {
            com.mbridge.msdk.video.dynview.listener.d dVar = (com.mbridge.msdk.video.dynview.listener.d) map.get("choice_one_callback");
            if (dVar != null) {
                dVar.a(list.get(i2));
                try {
                    CampaignEx campaignEx = list.get(i2);
                    com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
                    eVar.a("click", "0");
                    eVar.a("time", Long.valueOf(this.h));
                    eVar.a("choose_cid", campaignEx.getId());
                    eVar.a(C3040d4.h.L, Integer.valueOf(i2));
                    eVar.a("type", "choseFromTwoSelect");
                    com.mbridge.msdk.video.module.report.a.a("2000103", campaignEx, eVar);
                } catch (Exception e2) {
                    if (MBridgeConstans.DEBUG) {
                        e2.printStackTrace();
                    }
                }
            }
            b();
            return;
        }
        if (map.containsKey("order_view_callback") && (map.get("order_view_callback") instanceof com.mbridge.msdk.video.dynview.listener.c)) {
            com.mbridge.msdk.video.dynview.listener.c cVar = (com.mbridge.msdk.video.dynview.listener.c) map.get("order_view_callback");
            if (cVar != null) {
                cVar.a(list.get(i2), i2);
            }
            b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Map map) {
        if (map != null) {
            try {
                if (map.containsKey("order_view_callback") && (map.get("order_view_callback") instanceof com.mbridge.msdk.video.dynview.listener.c)) {
                    ((com.mbridge.msdk.video.dynview.listener.c) map.get("order_view_callback")).close();
                    b();
                }
            } catch (Exception e2) {
                p0.b("DataEnergizeWrapper", e2.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.mbridge.msdk.video.dynview.c cVar, View view) {
        Map<String, Bitmap> map = this.b;
        if (map == null || map.size() <= 1) {
            return;
        }
        new com.mbridge.msdk.video.dynview.ui.b().a(this.b, cVar, view);
    }

    private int a(boolean z, String str) {
        try {
            if (z) {
                if (TextUtils.isEmpty(str)) {
                    return -1;
                }
                return str.hashCode();
            }
            return h0.a(com.mbridge.msdk.foundation.controller.c.m().d(), str, "id");
        } catch (Exception e2) {
            p0.b("DataEnergizeWrapper", e2.getMessage());
            return -1;
        }
    }

    private Bitmap a() {
        Bitmap bitmap = null;
        try {
            bitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_4444);
            bitmap.eraseColor(Color.parseColor(this.g));
            return bitmap;
        } catch (Exception e2) {
            if (MBridgeConstans.DEBUG) {
                e2.printStackTrace();
            }
            return bitmap;
        }
    }
}
