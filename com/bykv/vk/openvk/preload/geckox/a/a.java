package com.bykv.vk.openvk.preload.geckox.a;

import android.accounts.NetworkErrorException;
import android.content.Context;
import com.bykv.vk.openvk.preload.geckox.logger.GeckoLogger;
import com.bykv.vk.openvk.preload.geckox.model.Common;
import com.bykv.vk.openvk.preload.geckox.model.ComponentModel;
import com.bykv.vk.openvk.preload.geckox.net.Response;
import com.bykv.vk.openvk.preload.geckox.statistic.model.StatisticModel;
import com.bykv.vk.openvk.preload.geckox.utils.e;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: AbandonChannelClenUtils.java */
/* loaded from: classes3.dex */
public final class a {
    public static void a(Context context, Map<String, ComponentModel.b> map, File file, com.bykv.vk.openvk.preload.geckox.e.a aVar) {
        final ArrayList arrayList;
        ComponentModel.b value;
        if (map == null || map.isEmpty()) {
            return;
        }
        try {
            arrayList = new ArrayList();
            for (Map.Entry<String, ComponentModel.b> entry : map.entrySet()) {
                File file2 = new File(file, entry.getKey());
                if (file2.isDirectory() && (value = entry.getValue()) != null && value.f968a != null && !value.f968a.isEmpty()) {
                    List<ComponentModel.a> list = value.f968a;
                    HashSet hashSet = new HashSet();
                    Iterator<ComponentModel.a> it = list.iterator();
                    while (it.hasNext()) {
                        String str = it.next().f967a;
                        if (!hashSet.contains(str)) {
                            hashSet.add(str);
                            new File(file2, str);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            arrayList = null;
        }
        if (arrayList == null) {
            return;
        }
        com.bykv.vk.openvk.preload.geckox.utils.c.a().execute(new Runnable() { // from class: com.bykv.vk.openvk.preload.geckox.a.a.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    List list2 = arrayList;
                    if (list2 != null && !list2.isEmpty()) {
                        Iterator it2 = list2.iterator();
                        if (it2.hasNext()) {
                            it2.next();
                            throw null;
                        }
                    }
                } catch (Exception e2) {
                    GeckoLogger.w("clean-channel", "", e2);
                }
            }
        });
    }

    public static List<StatisticModel.PackageStatisticModel> a(Context context) {
        return b.a(context).a();
    }

    public static void a(com.bykv.vk.openvk.preload.geckox.b bVar) {
        if (bVar.c()) {
            Common common = new Common(bVar.k(), bVar.o(), bVar.r(), com.bykv.vk.openvk.preload.geckox.utils.a.b(bVar.a()), e.a(bVar.a()), bVar.l(), bVar.m());
            StatisticModel statisticModel = new StatisticModel();
            statisticModel.common = common;
            statisticModel.packages.addAll(b.a(bVar.a()).a());
            if (statisticModel.packages.isEmpty()) {
                return;
            }
            String str = "https://" + bVar.j() + "/gecko/server/packages/stats";
            try {
                Response doPost = bVar.i().doPost(str, com.bykv.vk.openvk.preload.geckox.c.b.a().b().a(statisticModel));
                if (doPost.code != 200) {
                    throw new NetworkErrorException("net work get failed, code: " + doPost.code + ", url:" + str);
                }
                if (new JSONObject(doPost.body).getInt("status") != 0) {
                    throw new RuntimeException("upload failed");
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
