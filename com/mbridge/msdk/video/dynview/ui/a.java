package com.mbridge.msdk.video.dynview.ui;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.mbridge.msdk.dycreator.wrapper.DyAdType;
import com.mbridge.msdk.dycreator.wrapper.DyOption;
import com.mbridge.msdk.dycreator.wrapper.DynamicViewCreator;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.h0;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.video.dynview.listener.e;
import com.mbridge.msdk.video.dynview.listener.h;
import com.mbridge.msdk.video.dynview.wrapper.c;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: MBridgeUI.java */
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f5055a = false;

    public a(Context context, List<CampaignEx> list, h hVar, Map<String, Object> map) {
        a(new c().a(context, list), hVar, map);
    }

    private void a(com.mbridge.msdk.video.dynview.c cVar, h hVar, Map<String, Object> map) {
        View inflate;
        if (hVar == null) {
            return;
        }
        if (cVar == null) {
            hVar.a(com.mbridge.msdk.video.dynview.error.a.NOT_FOUND_VIEWOPTION);
            return;
        }
        if (cVar.c() == null) {
            hVar.a(com.mbridge.msdk.video.dynview.error.a.NOT_FOUND_CONTEXT);
            return;
        }
        if (TextUtils.isEmpty(cVar.f())) {
            hVar.a(com.mbridge.msdk.video.dynview.error.a.NOT_FOUND_LAYOUTNAME);
            return;
        }
        try {
            if (cVar.d() != null) {
                inflate = DynamicViewCreator.getInstance().createDynamicView(new DyOption.Builder().campaignEx((cVar.b() == null || cVar.b().size() <= 0) ? null : cVar.b().get(0)).fileDirs(cVar.d()).dyAdType(DyAdType.REWARD).orientation(cVar.h()).templateType(cVar.g()).build());
                if (inflate != null) {
                    f5055a = true;
                } else {
                    f5055a = false;
                    inflate = LayoutInflater.from(cVar.c()).inflate(h0.a(cVar.c(), cVar.f(), "layout"), (ViewGroup) null);
                }
            } else {
                f5055a = false;
                inflate = LayoutInflater.from(cVar.c()).inflate(h0.a(cVar.c(), cVar.f(), "layout"), (ViewGroup) null);
            }
            if (map == null) {
                map = new HashMap<>();
            }
            map.put("is_dy_success", Boolean.valueOf(f5055a));
            com.mbridge.msdk.video.dynview.energize.b.a().a(inflate, cVar, map);
            com.mbridge.msdk.video.dynview.energize.a.a().a(inflate, cVar, map, new C0409a(hVar));
        } catch (Exception e) {
            p0.b("MBridgeUI", e.getMessage());
            hVar.a(com.mbridge.msdk.video.dynview.error.a.VIEW_CREATE_ERROR);
        }
    }

    public a(com.mbridge.msdk.video.dynview.c cVar, h hVar, Map<String, Object> map) {
        a(cVar, hVar, map);
    }

    /* compiled from: MBridgeUI.java */
    /* renamed from: com.mbridge.msdk.video.dynview.ui.a$a, reason: collision with other inner class name */
    class C0409a implements e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ h f5056a;

        C0409a(h hVar) {
            this.f5056a = hVar;
        }

        @Override // com.mbridge.msdk.video.dynview.listener.e
        public void a(View view, List<View> list) {
            com.mbridge.msdk.video.dynview.a aVar = new com.mbridge.msdk.video.dynview.a();
            aVar.a(view);
            aVar.a(list);
            aVar.a(a.f5055a);
            this.f5056a.a(aVar);
        }

        @Override // com.mbridge.msdk.video.dynview.listener.e
        public void a(com.mbridge.msdk.video.dynview.error.a aVar) {
            this.f5056a.a(aVar);
        }
    }
}
