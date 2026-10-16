package com.bykv.vk.openvk.preload.geckox.d;

import android.accounts.NetworkErrorException;
import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.bykv.vk.openvk.preload.geckox.logger.GeckoLogger;
import com.bykv.vk.openvk.preload.geckox.model.CheckRequestBodyModel;
import com.bykv.vk.openvk.preload.geckox.model.Common;
import com.bykv.vk.openvk.preload.geckox.model.ComponentModel;
import com.bykv.vk.openvk.preload.geckox.model.UpdatePackage;
import com.bykv.vk.openvk.preload.geckox.net.Response;
import java.io.File;
import java.io.FileFilter;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: GetServerChannelVersionInterceptorMulti.java */
/* loaded from: classes3.dex */
public class c extends com.bykv.vk.openvk.preload.b.d<Map<String, List<Pair<String, Long>>>, List<UpdatePackage>> {
    private com.bykv.vk.openvk.preload.geckox.b d;
    private Map<String, Map<String, Object>> e;
    private Map<String, List<CheckRequestBodyModel.TargetChannel>> f;
    private com.bykv.vk.openvk.preload.geckox.e.a g;
    private String h;
    private com.bykv.vk.openvk.preload.geckox.buffer.a.a i = new com.bykv.vk.openvk.preload.geckox.buffer.a.a();

    @Override // com.bykv.vk.openvk.preload.b.d
    protected final void a(Object... objArr) {
        super.a(objArr);
        this.d = (com.bykv.vk.openvk.preload.geckox.b) objArr[0];
        this.e = (Map) objArr[1];
        this.f = (Map) objArr[2];
        this.g = (com.bykv.vk.openvk.preload.geckox.e.a) objArr[3];
        this.h = (String) objArr[4];
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.bykv.vk.openvk.preload.b.d
    public Object a(com.bykv.vk.openvk.preload.b.b<List<UpdatePackage>> bVar, Map<String, List<Pair<String, Long>>> map) throws Throwable {
        List<Pair<String, com.bykv.vk.openvk.preload.geckox.g.a>> list;
        GeckoLogger.d("gecko-debug-tag", "start get server channel version[v3]... local channel version:", map);
        Map<String, List<UpdatePackage>> a2 = a(map);
        com.bykv.vk.openvk.preload.geckox.statistic.c.a(this.d, this.i);
        Iterator<Map.Entry<String, List<UpdatePackage>>> it = a2.entrySet().iterator();
        while (it.hasNext()) {
            Iterator<UpdatePackage> it2 = it.next().getValue().iterator();
            while (it2.hasNext()) {
                UpdatePackage next = it2.next();
                long localVersion = next.getLocalVersion();
                long version = next.getVersion();
                if (version < localVersion) {
                    GeckoLogger.d("gecko-debug-tag", next.getChannel(), "rollback：", Long.valueOf(localVersion), "->", Long.valueOf(version));
                    File[] listFiles = new File(this.d.n(), next.getAccessKey() + File.separator + next.getChannel()).listFiles(new FileFilter() { // from class: com.bykv.vk.openvk.preload.geckox.d.c.1
                        @Override // java.io.FileFilter
                        public final boolean accept(File file) {
                            return file.isDirectory();
                        }
                    });
                    if (listFiles != null && listFiles.length != 0) {
                        for (File file : listFiles) {
                            try {
                                long parseLong = Long.parseLong(file.getName());
                                if (parseLong > version) {
                                    final File file2 = new File(file.getParent(), file.getName() + "--pending-delete");
                                    file.renameTo(file2);
                                    com.bykv.vk.openvk.preload.geckox.utils.c.a().execute(new Runnable() { // from class: com.bykv.vk.openvk.preload.geckox.d.c.2
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            com.bykv.vk.openvk.preload.geckox.utils.b.a(file2);
                                        }
                                    });
                                } else if (parseLong == version) {
                                    it2.remove();
                                }
                            } catch (Exception unused) {
                            }
                        }
                    }
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<String, List<UpdatePackage>>> it3 = a2.entrySet().iterator();
        while (it3.hasNext()) {
            arrayList.addAll(it3.next().getValue());
        }
        Object obj = null;
        try {
            list = c(arrayList);
            try {
                obj = bVar.a((com.bykv.vk.openvk.preload.b.b<List<UpdatePackage>>) arrayList);
                b(list);
                GeckoLogger.d("gecko-debug-tag", "all channel update finished");
            } catch (Throwable th) {
                th = th;
                try {
                    GeckoLogger.e("gecko-debug-tag", "filterChannel:", th);
                    a(arrayList);
                    return obj;
                } finally {
                    b(list);
                    GeckoLogger.d("gecko-debug-tag", "all channel update finished");
                }
            }
        } catch (Throwable th2) {
            th = th2;
            list = null;
        }
        a(arrayList);
        return obj;
    }

    private void a(List<UpdatePackage> list) {
        if (list.isEmpty()) {
            return;
        }
        for (UpdatePackage updatePackage : list) {
            com.bykv.vk.openvk.preload.geckox.a.c.a(new File(new File(this.d.n(), updatePackage.getAccessKey()), updatePackage.getChannel()).getAbsolutePath());
        }
    }

    private static void b(List<Pair<String, com.bykv.vk.openvk.preload.geckox.g.a>> list) {
        if (list == null) {
            return;
        }
        Iterator<Pair<String, com.bykv.vk.openvk.preload.geckox.g.a>> it = list.iterator();
        while (it.hasNext()) {
            try {
                ((com.bykv.vk.openvk.preload.geckox.g.a) it.next().second).a();
            } catch (Exception e) {
                GeckoLogger.e("gecko-debug-tag", "releaseLock:", e);
            }
        }
    }

    private List<Pair<String, com.bykv.vk.openvk.preload.geckox.g.a>> c(List<UpdatePackage> list) {
        if (list.isEmpty()) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (UpdatePackage updatePackage : list) {
            try {
                File file = new File(new File(this.d.n(), updatePackage.getAccessKey()), updatePackage.getChannel());
                if (file.isFile()) {
                    com.bykv.vk.openvk.preload.geckox.utils.b.a(file);
                }
                if (!file.mkdirs() && !file.isDirectory()) {
                    GeckoLogger.d("gecko-debug-tag", "can not create channel dir：", file.getAbsolutePath());
                    throw new RuntimeException("can not create channel dir:" + file.getAbsolutePath());
                }
                com.bykv.vk.openvk.preload.geckox.g.a a2 = com.bykv.vk.openvk.preload.geckox.g.a.a(file.getAbsolutePath() + File.separator + "update.lock");
                if (a2 != null) {
                    arrayList.add(new Pair(updatePackage.getChannel(), a2));
                    arrayList2.add(updatePackage);
                } else {
                    com.bykv.vk.openvk.preload.geckox.e.a aVar = this.g;
                    updatePackage.getChannel();
                }
            } catch (Exception e) {
                GeckoLogger.e("gecko-debug-tag", "filterChannel:", e);
                updatePackage.getChannel();
                com.bykv.vk.openvk.preload.geckox.e.a aVar2 = this.g;
            }
        }
        list.clear();
        list.addAll(arrayList2);
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Map<String, List<UpdatePackage>> a(Map<String, List<Pair<String, Long>>> map) throws Exception {
        String b2 = b(map);
        String str = "https://" + this.d.j() + "/gecko/server/v3/package";
        try {
            this.i.f = com.bykv.vk.openvk.preload.geckox.utils.e.a(this.d.a());
            Response doPost = this.d.i().doPost(str, b2);
            this.i.g = doPost.code;
            this.i.d = doPost.msg;
            com.bykv.vk.openvk.preload.geckox.buffer.a.a aVar = this.i;
            Map<String, String> map2 = doPost.headers;
            String str2 = "";
            if (map2 != null && !map2.isEmpty()) {
                String str3 = map2.get("x-tt-logid");
                if (TextUtils.isEmpty(str3)) {
                    str3 = map2.get("X-Tt-Logid");
                    if (TextUtils.isEmpty(str3)) {
                        String str4 = map2.get("X-TT-LOGID");
                        if (!TextUtils.isEmpty(str4)) {
                            str2 = str4;
                        }
                    }
                }
                str2 = str3;
            }
            aVar.e = str2;
            if (doPost.code == 200) {
                String str5 = doPost.body;
                GeckoLogger.d("gecko-debug-tag", "response:", str5);
                try {
                    com.bykv.vk.openvk.preload.geckox.model.Response response = (com.bykv.vk.openvk.preload.geckox.model.Response) (str5 == null ? null : com.bykv.vk.openvk.preload.geckox.c.b.a().b().a(new StringReader(str5), new com.bykv.vk.openvk.preload.a.c.a<com.bykv.vk.openvk.preload.geckox.model.Response<ComponentModel>>() { // from class: com.bykv.vk.openvk.preload.geckox.d.c.3
                    }.b()));
                    if (response.status == 0) {
                        if (response.data == 0) {
                            this.i.d = "check update error：response.data==null";
                            com.bykv.vk.openvk.preload.geckox.statistic.c.a(this.d, this.i);
                            throw new a("check update error：response.data==null");
                        }
                        com.bykv.vk.openvk.preload.geckox.a.a.a(this.d.a(), ((ComponentModel) response.data).getUniversalStrategies(), this.d.n(), this.g);
                        Map<String, List<UpdatePackage>> packages = ((ComponentModel) response.data).getPackages();
                        if (packages == null || packages.isEmpty()) {
                            com.bykv.vk.openvk.preload.geckox.a.a.a(this.d);
                            return new HashMap();
                        }
                        for (String str6 : this.d.e()) {
                            List<UpdatePackage> list = packages.get(str6);
                            if (list != null && !list.isEmpty()) {
                                for (UpdatePackage updatePackage : list) {
                                    updatePackage.setAccessKey(str6);
                                    updatePackage.setLocalVersion(a(map.get(str6), updatePackage.getChannel()));
                                }
                            }
                        }
                        return packages;
                    }
                    if (response.status == 2000) {
                        com.bykv.vk.openvk.preload.geckox.a.a.a(this.d);
                        return new HashMap();
                    }
                    String str7 = "check update error，unknow status code，response.status：" + response.status;
                    this.i.d = str7;
                    com.bykv.vk.openvk.preload.geckox.statistic.c.a(this.d, this.i);
                    throw new a(str7);
                } catch (Throwable th) {
                    this.i.d = "json parse failed：" + th.getMessage();
                    com.bykv.vk.openvk.preload.geckox.statistic.c.a(this.d, this.i);
                    throw new b("json parse failed：" + str5 + " caused by:" + th.getMessage(), th);
                }
            }
            throw new NetworkErrorException("net work get failed, code: " + doPost.code + ", url:" + str);
        } catch (Exception e) {
            com.bykv.vk.openvk.preload.geckox.statistic.c.a(this.d, this.i);
            throw new C0114c("request failed：url:" + str + ", caused by:" + e.getMessage(), e);
        }
    }

    private static long a(List<Pair<String, Long>> list, String str) {
        for (Pair<String, Long> pair : list) {
            if (((String) pair.first).equals(str)) {
                return ((Long) pair.second).longValue();
            }
        }
        return 0L;
    }

    private String b(Map<String, List<Pair<String, Long>>> map) {
        List<CheckRequestBodyModel.TargetChannel> list;
        CheckRequestBodyModel checkRequestBodyModel = new CheckRequestBodyModel();
        Context a2 = this.d.a();
        checkRequestBodyModel.setCommon(new Common(this.d.k(), this.d.o(), this.d.r(), com.bykv.vk.openvk.preload.geckox.utils.a.b(a2), com.bykv.vk.openvk.preload.geckox.utils.e.a(a2), this.d.l(), this.d.m()));
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, List<Pair<String, Long>>> entry : map.entrySet()) {
            HashMap hashMap2 = new HashMap();
            for (Pair<String, Long> pair : entry.getValue()) {
                CheckRequestBodyModel.LocalChannel localChannel = new CheckRequestBodyModel.LocalChannel();
                localChannel.localVersion = (Long) pair.second;
                hashMap2.put(pair.first, localChannel);
            }
            hashMap.put(entry.getKey(), hashMap2);
        }
        try {
            com.bykv.vk.openvk.preload.a.d b2 = com.bykv.vk.openvk.preload.geckox.c.b.a().b();
            this.i.f945a = b2.a(hashMap);
            checkRequestBodyModel.setLocal(hashMap);
            HashMap hashMap3 = new HashMap();
            for (String str : this.d.e()) {
                CheckRequestBodyModel.Group group = new CheckRequestBodyModel.Group();
                group.groupName = this.h;
                Map<String, List<CheckRequestBodyModel.TargetChannel>> map2 = this.f;
                if (map2 != null && !map2.isEmpty() && (list = this.f.get(str)) != null && !list.isEmpty()) {
                    group.targetChannels = new ArrayList();
                    group.targetChannels.addAll(list);
                }
                hashMap3.put(str, group);
            }
            this.i.b = b2.a(hashMap3);
            checkRequestBodyModel.setDeployments(hashMap3);
            Map<String, Map<String, Object>> map3 = this.e;
            if (map3 != null) {
                this.i.c = b2.a(map3);
                checkRequestBodyModel.setCustom(this.e);
            }
            return b2.a(checkRequestBodyModel);
        } catch (Throwable unused) {
            return "";
        }
    }

    /* compiled from: GetServerChannelVersionInterceptorMulti.java */
    /* renamed from: com.bykv.vk.openvk.preload.geckox.d.c$c, reason: collision with other inner class name */
    public static class C0114c extends RuntimeException {
        C0114c(String str, Throwable th) {
            super(str, th);
        }
    }

    /* compiled from: GetServerChannelVersionInterceptorMulti.java */
    public static class b extends RuntimeException {
        b(String str, Throwable th) {
            super(str, th);
        }
    }

    /* compiled from: GetServerChannelVersionInterceptorMulti.java */
    public static class a extends RuntimeException {
        a(String str) {
            super(str);
        }
    }
}
