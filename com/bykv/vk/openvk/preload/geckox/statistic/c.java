package com.bykv.vk.openvk.preload.geckox.statistic;

import android.accounts.NetworkErrorException;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bykv.vk.openvk.preload.geckox.logger.GeckoLogger;
import com.bykv.vk.openvk.preload.geckox.model.Common;
import com.bykv.vk.openvk.preload.geckox.net.Response;
import com.bykv.vk.openvk.preload.geckox.statistic.model.StatisticModel;
import com.bykv.vk.openvk.preload.geckox.utils.e;
import com.ironsource.C3114ha;
import com.ironsource.N6;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import io.adn.sdk.internal.data.repository.BidTokenRepositoryKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import org.json.JSONObject;

/* compiled from: UploadStatistic.java */
/* loaded from: classes3.dex */
public final class c {
    public static void a(com.bykv.vk.openvk.preload.geckox.b bVar, com.bykv.vk.openvk.preload.geckox.buffer.a.a aVar) {
        IStatisticMonitor q = bVar.q();
        if (q != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("params_for_special", "gecko");
                jSONObject.put("device_id", bVar.r());
                jSONObject.put(N6.F, 0);
                jSONObject.put(BidTokenRepositoryKt.APP_VERSION, bVar.o());
                jSONObject.put("api_version", "v3");
                jSONObject.put(C3114ha.b, bVar.k());
                jSONObject.put("x_tt_logid", aVar.e);
                jSONObject.put("http_status", aVar.g);
                jSONObject.put("err_msg", aVar.d);
                if (TextUtils.isEmpty(aVar.e)) {
                    jSONObject.put("deployments_info", aVar.b);
                    jSONObject.put("local_info", aVar.f945a);
                    jSONObject.put("custom_info", aVar.c);
                } else {
                    jSONObject.put("deployments_info", "");
                    jSONObject.put("local_info", "");
                    jSONObject.put("custom_info", "");
                }
                jSONObject.put("os_version", new StringBuilder().append(Build.VERSION.SDK_INT).toString());
                jSONObject.put("device_platform", "android");
                jSONObject.put(BidTokenRepositoryKt.DEVICE_MODEL, Build.MODEL);
                jSONObject.put(CampaignEx.KEY_ACTIVITY_PATH_AND_NAME, aVar.f);
                q.upload("geckosdk_query_pkgs", jSONObject);
            } catch (Throwable th) {
                GeckoLogger.w("gecko-debug-tag", "UploadStatistic.upload:", th);
            }
        }
    }

    private static Integer a(List<StatisticModel.PackageStatisticModel.DownloadFailRecords> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        return Integer.valueOf(list.size());
    }

    private static void a(com.bykv.vk.openvk.preload.geckox.statistic.model.a aVar, List<StatisticModel.PackageStatisticModel> list) {
        if (aVar.z && aVar.A) {
            StatisticModel.PackageStatisticModel packageStatisticModel = new StatisticModel.PackageStatisticModel();
            list.add(packageStatisticModel);
            packageStatisticModel.statsType = 0;
            packageStatisticModel.accessKey = aVar.f974a;
            packageStatisticModel.groupName = aVar.b;
            packageStatisticModel.channel = aVar.c;
            packageStatisticModel.ac = aVar.n;
            packageStatisticModel.id = aVar.p;
            packageStatisticModel.downloadRetryTimes = a(aVar.u);
            packageStatisticModel.downloadUrl = aVar.t;
            packageStatisticModel.downloadFailRecords = b(aVar.u);
            packageStatisticModel.downloadDuration = Long.valueOf(aVar.w - aVar.v);
            if (aVar.B) {
                StatisticModel.PackageStatisticModel packageStatisticModel2 = new StatisticModel.PackageStatisticModel();
                list.add(packageStatisticModel2);
                packageStatisticModel2.accessKey = aVar.f974a;
                packageStatisticModel2.groupName = aVar.b;
                packageStatisticModel2.statsType = 2;
                packageStatisticModel2.id = aVar.p;
                packageStatisticModel2.channel = aVar.c;
                packageStatisticModel2.activeCheckDuration = Long.valueOf(aVar.x - aVar.w);
                packageStatisticModel2.applyDuration = Long.valueOf(aVar.y - aVar.x);
                return;
            }
            StatisticModel.PackageStatisticModel packageStatisticModel3 = new StatisticModel.PackageStatisticModel();
            list.add(packageStatisticModel3);
            packageStatisticModel3.statsType = 3;
            packageStatisticModel3.accessKey = aVar.f974a;
            packageStatisticModel3.groupName = aVar.b;
            packageStatisticModel3.errCode = "500";
            packageStatisticModel3.id = aVar.p;
            packageStatisticModel3.channel = aVar.c;
            packageStatisticModel3.errMsg = aVar.D;
            return;
        }
        StatisticModel.PackageStatisticModel packageStatisticModel4 = new StatisticModel.PackageStatisticModel();
        list.add(packageStatisticModel4);
        packageStatisticModel4.statsType = 1;
        packageStatisticModel4.accessKey = aVar.f974a;
        packageStatisticModel4.groupName = aVar.b;
        packageStatisticModel4.channel = aVar.c;
        packageStatisticModel4.ac = aVar.n;
        packageStatisticModel4.id = aVar.p;
        packageStatisticModel4.downloadRetryTimes = a(aVar.u);
        packageStatisticModel4.downloadUrl = aVar.t;
        packageStatisticModel4.downloadFailRecords = b(aVar.u);
        if (!aVar.z) {
            packageStatisticModel4.errCode = "300";
            if (aVar.u == null || aVar.u.isEmpty()) {
                return;
            }
            packageStatisticModel4.errMsg = aVar.u.get(0).reason;
            return;
        }
        if (aVar.A) {
            return;
        }
        packageStatisticModel4.errCode = "450";
        packageStatisticModel4.errMsg = aVar.C;
    }

    private static List<StatisticModel.PackageStatisticModel.DownloadFailRecords> b(List<StatisticModel.PackageStatisticModel.DownloadFailRecords> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list;
    }

    public static void a(final com.bykv.vk.openvk.preload.geckox.b bVar, a aVar) {
        StatisticModel statisticModel;
        ArrayList arrayList = new ArrayList();
        for (com.bykv.vk.openvk.preload.geckox.statistic.model.a aVar2 : aVar.a()) {
            if (aVar2.d != null || aVar2.f != 0) {
                if (aVar2.h && aVar2.i) {
                    StatisticModel.PackageStatisticModel packageStatisticModel = new StatisticModel.PackageStatisticModel();
                    arrayList.add(packageStatisticModel);
                    packageStatisticModel.statsType = 100;
                    packageStatisticModel.groupName = aVar2.b;
                    packageStatisticModel.accessKey = aVar2.f974a;
                    packageStatisticModel.channel = aVar2.c;
                    packageStatisticModel.ac = aVar2.n;
                    packageStatisticModel.id = aVar2.p;
                    packageStatisticModel.patchId = aVar2.o;
                    packageStatisticModel.downloadRetryTimes = a(aVar2.e);
                    packageStatisticModel.downloadUrl = aVar2.d;
                    packageStatisticModel.downloadFailRecords = b(aVar2.e);
                    packageStatisticModel.downloadDuration = Long.valueOf(aVar2.g - aVar2.f);
                    if (!aVar2.j) {
                        StatisticModel.PackageStatisticModel packageStatisticModel2 = new StatisticModel.PackageStatisticModel();
                        arrayList.add(packageStatisticModel2);
                        packageStatisticModel2.statsType = 100;
                        packageStatisticModel2.channel = aVar2.c;
                        packageStatisticModel2.errCode = "403";
                        packageStatisticModel2.errMsg = aVar2.r;
                        packageStatisticModel2.ac = aVar2.n;
                        packageStatisticModel2.patchId = aVar2.o;
                        packageStatisticModel2.id = aVar2.p;
                        packageStatisticModel2.downloadRetryTimes = a(aVar2.e);
                        packageStatisticModel2.downloadUrl = aVar2.d;
                        packageStatisticModel2.downloadFailRecords = b(aVar2.e);
                    } else if (aVar2.k) {
                        StatisticModel.PackageStatisticModel packageStatisticModel3 = new StatisticModel.PackageStatisticModel();
                        arrayList.add(packageStatisticModel3);
                        packageStatisticModel3.accessKey = aVar2.f974a;
                        packageStatisticModel3.groupName = aVar2.b;
                        packageStatisticModel3.statsType = 102;
                        packageStatisticModel3.patchId = aVar2.o;
                        packageStatisticModel3.id = aVar2.p;
                        packageStatisticModel3.channel = aVar2.c;
                        packageStatisticModel3.activeCheckDuration = Long.valueOf(aVar2.l - aVar2.g);
                        packageStatisticModel3.applyDuration = Long.valueOf(aVar2.m - aVar2.l);
                    } else {
                        StatisticModel.PackageStatisticModel packageStatisticModel4 = new StatisticModel.PackageStatisticModel();
                        arrayList.add(packageStatisticModel4);
                        packageStatisticModel4.accessKey = aVar2.f974a;
                        packageStatisticModel4.groupName = aVar2.b;
                        packageStatisticModel4.statsType = 103;
                        packageStatisticModel4.errCode = "501";
                        packageStatisticModel4.channel = aVar2.c;
                        packageStatisticModel4.patchId = aVar2.o;
                        packageStatisticModel4.id = aVar2.p;
                        packageStatisticModel4.errMsg = aVar2.s;
                        a(aVar2, arrayList);
                    }
                } else {
                    StatisticModel.PackageStatisticModel packageStatisticModel5 = new StatisticModel.PackageStatisticModel();
                    arrayList.add(packageStatisticModel5);
                    packageStatisticModel5.statsType = 101;
                    packageStatisticModel5.accessKey = aVar2.f974a;
                    packageStatisticModel5.groupName = aVar2.b;
                    packageStatisticModel5.channel = aVar2.c;
                    packageStatisticModel5.ac = aVar2.n;
                    packageStatisticModel5.patchId = aVar2.o;
                    packageStatisticModel5.id = aVar2.p;
                    packageStatisticModel5.downloadRetryTimes = a(aVar2.e);
                    packageStatisticModel5.downloadUrl = aVar2.d;
                    packageStatisticModel5.downloadFailRecords = b(aVar2.e);
                    if (!aVar2.h) {
                        packageStatisticModel5.errCode = "301";
                        if (aVar2.e != null && !aVar2.e.isEmpty()) {
                            packageStatisticModel5.errMsg = aVar2.e.get(0).reason;
                        }
                    } else if (!aVar2.i) {
                        packageStatisticModel5.errCode = "402";
                        packageStatisticModel5.errMsg = aVar2.q;
                    }
                    a(aVar2, arrayList);
                }
            }
            a(aVar2, arrayList);
        }
        Context a2 = bVar.a();
        arrayList.addAll(com.bykv.vk.openvk.preload.geckox.a.a.a(a2));
        if (arrayList.isEmpty()) {
            statisticModel = null;
        } else {
            Common common = new Common(bVar.k(), bVar.o(), bVar.r(), com.bykv.vk.openvk.preload.geckox.utils.a.b(a2), e.a(a2), bVar.l(), bVar.m());
            statisticModel = new StatisticModel();
            statisticModel.common = common;
            statisticModel.packages = arrayList;
            String uuid = UUID.randomUUID().toString();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((StatisticModel.PackageStatisticModel) it.next()).logId = uuid;
            }
        }
        if (statisticModel == null || statisticModel.packages == null) {
            return;
        }
        IStatisticMonitor q = bVar.q();
        if (q != null) {
            try {
                for (StatisticModel.PackageStatisticModel packageStatisticModel6 : statisticModel.packages) {
                    Common common2 = statisticModel.common;
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("params_for_special", "gecko");
                    jSONObject.put("region", common2.region);
                    jSONObject.put("err_code", packageStatisticModel6.errCode);
                    jSONObject.put("err_msg", packageStatisticModel6.errMsg);
                    jSONObject.put(BidTokenRepositoryKt.SDK_VERSION, common2.sdkVersion);
                    jSONObject.put("access_key", packageStatisticModel6.accessKey);
                    jSONObject.put("stats_type", packageStatisticModel6.statsType);
                    jSONObject.put("device_id", common2.deviceId);
                    jSONObject.put("patch_id", packageStatisticModel6.patchId == null ? 0L : packageStatisticModel6.patchId.longValue());
                    jSONObject.put("group_name", packageStatisticModel6.groupName);
                    jSONObject.put(N6.F, common2.os);
                    jSONObject.put(BidTokenRepositoryKt.APP_VERSION, common2.appVersion);
                    jSONObject.put(BidTokenRepositoryKt.DEVICE_MODEL, common2.deviceModel);
                    jSONObject.put("channel", packageStatisticModel6.channel);
                    jSONObject.put("id", packageStatisticModel6.id == null ? 0L : packageStatisticModel6.id.longValue());
                    jSONObject.put(CampaignEx.KEY_ACTIVITY_PATH_AND_NAME, common2.ac);
                    jSONObject.put("download_retry_times", packageStatisticModel6.downloadRetryTimes == null ? 0 : packageStatisticModel6.downloadRetryTimes.intValue());
                    Object obj = "";
                    jSONObject.put(DownloadModel.DOWNLOAD_URL, packageStatisticModel6.downloadUrl == null ? "" : packageStatisticModel6.downloadUrl);
                    jSONObject.put("download_duration", packageStatisticModel6.downloadDuration);
                    if (packageStatisticModel6.downloadFailRecords != null) {
                        obj = packageStatisticModel6.downloadFailRecords;
                    }
                    jSONObject.put("download_fail_records", obj);
                    jSONObject.put("log_id", packageStatisticModel6.logId);
                    jSONObject.put("active_check_duration", packageStatisticModel6.activeCheckDuration == null ? 0L : packageStatisticModel6.activeCheckDuration.longValue());
                    jSONObject.put("apply_duration", packageStatisticModel6.applyDuration == null ? 0L : packageStatisticModel6.applyDuration.longValue());
                    q.upload("geckosdk_update_stats", jSONObject);
                }
            } catch (Throwable th) {
                GeckoLogger.w("gecko-debug-tag", "UploadStatistic.upload:", th);
            }
        }
        if (bVar.c()) {
            try {
                final String a3 = com.bykv.vk.openvk.preload.geckox.c.b.a().b().a(statisticModel);
                if (TextUtils.isEmpty(a3)) {
                    return;
                }
                final String str = "https://" + bVar.j() + "/gecko/server/packages/stats";
                com.bykv.vk.openvk.preload.geckox.b.g().execute(new Runnable() { // from class: com.bykv.vk.openvk.preload.geckox.statistic.c.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        Response doPost;
                        for (int i = 0; i < 3; i++) {
                            try {
                                doPost = com.bykv.vk.openvk.preload.geckox.b.this.i().doPost(str, a3);
                            } catch (Exception e) {
                                GeckoLogger.w("gecko-debug-tag", "upload statistic:", e);
                            }
                            if (doPost.code != 200) {
                                throw new NetworkErrorException("net work get failed, code: " + doPost.code + ", url:" + str);
                            }
                            if (new JSONObject(doPost.body).getInt("status") == 0) {
                                return;
                            }
                        }
                    }
                });
            } catch (Throwable unused) {
            }
        }
    }
}
