package com.mbridge.msdk.video.dynview.util.draw;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.foundation.tools.z;
import com.mbridge.msdk.video.dynview.c;
import com.mbridge.msdk.video.dynview.shape.a;
import java.util.List;
import java.util.Map;

/* compiled from: ChoiceOneDrawBitBg.java */
/* loaded from: classes6.dex */
public class a {
    private static volatile a d;

    /* renamed from: a, reason: collision with root package name */
    private View f5063a;
    private Bitmap b;
    private Bitmap c;

    /* compiled from: ChoiceOneDrawBitBg.java */
    /* renamed from: com.mbridge.msdk.video.dynview.util.draw.a$a, reason: collision with other inner class name */
    class RunnableC0411a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Bitmap f5064a;
        final /* synthetic */ int b;
        final /* synthetic */ float c;
        final /* synthetic */ float d;

        /* compiled from: ChoiceOneDrawBitBg.java */
        /* renamed from: com.mbridge.msdk.video.dynview.util.draw.a$a$a, reason: collision with other inner class name */
        class RunnableC0412a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ a.b f5065a;

            RunnableC0412a(a.b bVar) {
                this.f5065a = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (a.this.f5063a == null || this.f5065a.a() == null) {
                    return;
                }
                a.this.f5063a.setBackground(this.f5065a.a());
            }
        }

        RunnableC0411a(Bitmap bitmap, int i, float f, float f2) {
            this.f5064a = bitmap;
            this.b = i;
            this.c = f;
            this.d = f2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Bitmap a2 = z.a(this.f5064a, 10);
                Bitmap a3 = z.a(this.f5064a, 10);
                a.b a4 = com.mbridge.msdk.video.dynview.shape.a.a();
                a4.a(this.b).b(a2).a(a3);
                if (this.b == 2) {
                    float f = this.c;
                    float f2 = this.d;
                    if (f > f2) {
                        a4.b(f).a(this.d);
                    } else {
                        a4.b(f2).a(this.c);
                    }
                } else {
                    a4.b(this.c).a(this.d);
                }
                if (a.this.f5063a != null) {
                    a.this.f5063a.post(new RunnableC0412a(a4));
                }
            } catch (Exception e) {
                p0.b("ChoiceOneDrawBitBg", e.getMessage());
            }
        }
    }

    private a() {
    }

    public void b() {
        if (this.f5063a != null) {
            this.f5063a = null;
        }
        Bitmap bitmap = this.b;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.b.recycle();
            this.b = null;
        }
        Bitmap bitmap2 = this.c;
        if (bitmap2 == null || bitmap2.isRecycled()) {
            return;
        }
        this.c.recycle();
        this.c = null;
    }

    public static a a() {
        a aVar;
        if (d != null) {
            return d;
        }
        synchronized (a.class) {
            if (d == null) {
                d = new a();
            }
            aVar = d;
        }
        return aVar;
    }

    public void a(Map<String, Bitmap> map, c cVar, View view) {
        if (view == null || cVar == null || map == null || map.size() == 0 || map.size() < 2 || cVar.b() == null || cVar.b().size() < 2) {
            return;
        }
        this.f5063a = view;
        int h = cVar.h();
        float m = cVar.m();
        float k = cVar.k();
        try {
            List<CampaignEx> b = cVar.b();
            String md5 = b.get(0) != null ? SameMD5.getMD5(b.get(0).getImageUrl()) : "";
            String md52 = b.get(1) != null ? SameMD5.getMD5(b.get(1).getImageUrl()) : "";
            Bitmap bitmap = null;
            Bitmap bitmap2 = (TextUtils.isEmpty(md5) || !map.containsKey(md5)) ? null : map.get(md5);
            if (!TextUtils.isEmpty(md52) && map.containsKey(md52)) {
                bitmap = map.get(md52);
            }
            Bitmap bitmap3 = bitmap;
            if (bitmap2 == null || bitmap2.isRecycled() || bitmap3 == null || bitmap3.isRecycled()) {
                return;
            }
            a(h, m, k, bitmap2, bitmap3);
        } catch (Exception e) {
            p0.b("ChoiceOneDrawBitBg", e.getMessage());
        }
    }

    private synchronized void a(int i, float f, float f2, Bitmap bitmap, Bitmap bitmap2) {
        try {
            try {
                try {
                    com.mbridge.msdk.foundation.same.threadpool.a.a().execute(new RunnableC0411a(bitmap, i, f, f2));
                } catch (Exception e) {
                    e = e;
                    p0.a("ChoiceOneDrawBitBg", e.getMessage());
                }
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
        } catch (Throwable th2) {
            th = th2;
            throw th;
        }
    }
}
