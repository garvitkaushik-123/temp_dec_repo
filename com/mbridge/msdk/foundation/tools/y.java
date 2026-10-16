package com.mbridge.msdk.foundation.tools;

import android.net.Uri;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.DownloadError;
import com.mbridge.msdk.foundation.download.DownloadMessage;
import com.mbridge.msdk.foundation.download.DownloadPriority;
import com.mbridge.msdk.foundation.download.DownloadResourceType;
import com.mbridge.msdk.foundation.download.MBDownloadManager;
import com.mbridge.msdk.foundation.download.OnDownloadStateListener;
import com.mbridge.msdk.foundation.download.resource.MBResourceManager;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/* compiled from: DynamicViewResourceManager.java */
/* loaded from: classes6.dex */
public class y {

    /* renamed from: a, reason: collision with root package name */
    static final List<String> f4385a;

    /* compiled from: DynamicViewResourceManager.java */
    class a implements OnDownloadStateListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f4386a;
        final /* synthetic */ String b;
        final /* synthetic */ c c;
        final /* synthetic */ String d;
        final /* synthetic */ String e;

        a(String str, String str2, c cVar, String str3, String str4) {
            this.f4386a = str;
            this.b = str2;
            this.c = cVar;
            this.d = str3;
            this.e = str4;
        }

        @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
        public void onCancelDownload(DownloadMessage downloadMessage) {
        }

        @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
        public void onDownloadComplete(DownloadMessage downloadMessage) {
            String str;
            try {
                String str2 = this.f4386a + File.separator + this.b;
                String str3 = this.f4386a;
                MBResourceManager.getInstance().unZip(str2, str3);
                if (this.c == null) {
                    return;
                }
                try {
                    if (downloadMessage != null) {
                        try {
                            str = (String) downloadMessage.getExtra("responseHeaders");
                        } catch (Throwable th) {
                            p0.b("DynamicViewResourceManager", th.getMessage());
                        }
                        this.c.a(this.d, str3, this.e, str, false);
                        return;
                    }
                    this.c.a(this.d, str3, this.e, str, false);
                    return;
                } catch (Exception e) {
                    p0.b("DynamicViewResourceManager", e.getMessage());
                    return;
                }
                str = "";
            } catch (Exception unused) {
            }
        }

        @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
        public void onDownloadError(DownloadMessage downloadMessage, DownloadError downloadError) {
            c cVar = this.c;
            if (cVar != null) {
                try {
                    cVar.a(this.d, downloadError);
                } catch (Exception e) {
                    p0.b("DynamicViewResourceManager", e.getMessage());
                }
            }
        }

        @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
        public void onDownloadStart(DownloadMessage downloadMessage) {
        }
    }

    /* compiled from: DynamicViewResourceManager.java */
    class b implements OnDownloadStateListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f4387a;
        final /* synthetic */ String b;

        b(String str, String str2) {
            this.f4387a = str;
            this.b = str2;
        }

        @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
        public void onCancelDownload(DownloadMessage downloadMessage) {
        }

        @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
        public void onDownloadComplete(DownloadMessage downloadMessage) {
            try {
                MBResourceManager.getInstance().unZip(this.f4387a + File.separator + this.b, this.f4387a);
            } catch (Exception unused) {
            }
        }

        @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
        public void onDownloadError(DownloadMessage downloadMessage, DownloadError downloadError) {
        }

        @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
        public void onDownloadStart(DownloadMessage downloadMessage) {
        }
    }

    /* compiled from: DynamicViewResourceManager.java */
    public interface c {
        void a(String str, DownloadError downloadError);

        void a(String str, String str2, String str3, String str4, boolean z);
    }

    static {
        ArrayList arrayList = new ArrayList(4);
        f4385a = arrayList;
        arrayList.add("mbridge_splash_native_template_v_v1.xml");
        arrayList.add("mbridge_splash_native_template_h_v1.xml");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(16:(3:3|4|5)|6|(2:7|8)|(11:(21:10|(1:67)|14|15|(10:17|18|19|(2:(1:(1:23)(2:57|58))|61)(1:62)|59|25|26|(6:43|44|45|46|47|48)(1:(4:31|32|33|34)(1:42))|35|36)|65|18|19|(0)(0)|59|25|26|(1:28)|43|44|45|46|47|48|35|36)|26|(0)|43|44|45|46|47|48|35|36)|69|(1:12)|67|14|15|(0)|65|18|19|(0)(0)|59|25) */
    /* JADX WARN: Can't wrap try/catch for region: R(27:(3:3|4|5)|6|7|8|(21:10|(1:67)|14|15|(10:17|18|19|(2:(1:(1:23)(2:57|58))|61)(1:62)|59|25|26|(6:43|44|45|46|47|48)(1:(4:31|32|33|34)(1:42))|35|36)|65|18|19|(0)(0)|59|25|26|(1:28)|43|44|45|46|47|48|35|36)|69|(1:12)|67|14|15|(0)|65|18|19|(0)(0)|59|25|26|(0)|43|44|45|46|47|48|35|36) */
    /* JADX WARN: Can't wrap try/catch for region: R(29:3|4|5|6|7|8|(21:10|(1:67)|14|15|(10:17|18|19|(2:(1:(1:23)(2:57|58))|61)(1:62)|59|25|26|(6:43|44|45|46|47|48)(1:(4:31|32|33|34)(1:42))|35|36)|65|18|19|(0)(0)|59|25|26|(1:28)|43|44|45|46|47|48|35|36)|69|(1:12)|67|14|15|(0)|65|18|19|(0)(0)|59|25|26|(0)|43|44|45|46|47|48|35|36) */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x008c, code lost:
    
        if (r13 != 5) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0101, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0105, code lost:
    
        com.mbridge.msdk.foundation.tools.p0.b("DynamicViewResourceManager", r0.getMessage());
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0103, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0104, code lost:
    
        r5 = r17;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x006a A[Catch: Exception -> 0x006f, TRY_LEAVE, TryCatch #0 {Exception -> 0x006f, blocks: (B:15:0x0064, B:17:0x006a), top: B:14:0x0064 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00a0 A[Catch: Exception -> 0x00a7, TRY_LEAVE, TryCatch #3 {Exception -> 0x00a7, blocks: (B:58:0x0090, B:61:0x0098, B:62:0x00a0), top: B:19:0x0085 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(int i, String str, String str2, c cVar, CampaignEx campaignEx) {
        String str3;
        File file;
        String str4;
        com.mbridge.msdk.foundation.same.report.metrics.e eVar;
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            str3 = b(i, str, str2);
        } catch (Exception unused) {
            str3 = "";
        }
        String str5 = com.mbridge.msdk.foundation.same.directory.e.b(com.mbridge.msdk.foundation.same.directory.c.MBRIDGE_700_XML) + File.separator;
        try {
            if (!TextUtils.isEmpty(str3)) {
                file = new File(str5, str3);
                if (file != null || !file.exists()) {
                    file = new File(str5 + File.separator + str3.replace(".xml", ""), str3);
                }
                if (file.exists()) {
                    str4 = file.getPath();
                    eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
                    eVar.a("scenes", "1");
                    eVar.a("url", str2);
                    if (i != 0) {
                        if (i != 1) {
                            if (i == 2) {
                                eVar.a("resource_type", 3);
                            }
                        }
                        eVar.a("resource_type", 2);
                    } else {
                        eVar.a("resource_type", 1);
                    }
                    if (!TextUtils.isEmpty(str4) || TextUtils.isEmpty(str3)) {
                        String path = new URL(str2).getPath();
                        String substring = path.substring(path.lastIndexOf(47) + 1);
                        CampaignEx campaignEx2 = campaignEx;
                        a(str2, substring, str5, substring.replace(".zip", ""), cVar, campaignEx2, i);
                        eVar.a("cache", 2);
                        com.mbridge.msdk.foundation.same.report.metrics.d.b().a("m_download_start", campaignEx2, eVar);
                    } else {
                        if (cVar == null) {
                            return;
                        }
                        try {
                            cVar.a(str2, str4, str3, null, true);
                        } catch (Exception e) {
                            p0.b("DynamicViewResourceManager", e.getMessage());
                        }
                        eVar.a("cache", 1);
                        com.mbridge.msdk.foundation.same.report.metrics.d.b().a("m_download_start", campaignEx, eVar);
                    }
                    return;
                }
                str4 = "";
                eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
                eVar.a("scenes", "1");
                eVar.a("url", str2);
                if (i != 0) {
                }
                if (TextUtils.isEmpty(str4)) {
                }
                String path2 = new URL(str2).getPath();
                String substring2 = path2.substring(path2.lastIndexOf(47) + 1);
                CampaignEx campaignEx22 = campaignEx;
                a(str2, substring2, str5, substring2.replace(".zip", ""), cVar, campaignEx22, i);
                eVar.a("cache", 2);
                com.mbridge.msdk.foundation.same.report.metrics.d.b().a("m_download_start", campaignEx22, eVar);
                return;
            }
            if (TextUtils.isEmpty(str4)) {
            }
            String path22 = new URL(str2).getPath();
            String substring22 = path22.substring(path22.lastIndexOf(47) + 1);
            CampaignEx campaignEx222 = campaignEx;
            a(str2, substring22, str5, substring22.replace(".zip", ""), cVar, campaignEx222, i);
            eVar.a("cache", 2);
            com.mbridge.msdk.foundation.same.report.metrics.d.b().a("m_download_start", campaignEx222, eVar);
            return;
        } catch (Exception unused2) {
            return;
        }
        file = null;
        if (file != null) {
        }
        file = new File(str5 + File.separator + str3.replace(".xml", ""), str3);
        if (file.exists()) {
        }
        str4 = "";
        eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
        eVar.a("scenes", "1");
        eVar.a("url", str2);
        if (i != 0) {
        }
    }

    private static String b(int i, String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            try {
                String path = new URL(str2).getPath();
                String substring = path.substring(path.lastIndexOf(47) + 1);
                if (!TextUtils.isEmpty(substring)) {
                    return substring.replace(".zip", "");
                }
            } catch (Exception unused) {
            }
        }
        return "";
    }

    private static String b(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                String path = new URL(str).getPath();
                String substring = path.substring(path.lastIndexOf(47) + 1);
                if (!TextUtils.isEmpty(substring)) {
                    String replace = substring.replace(".zip", "");
                    List<String> list = f4385a;
                    if (list != null) {
                        if (!list.contains(replace)) {
                            return replace;
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
        return "";
    }

    public static String a(int i, String str, String str2) {
        String str3;
        File file;
        if (TextUtils.isEmpty(str2)) {
            return "";
        }
        try {
            str3 = b(i, str, str2);
        } catch (Exception unused) {
            str3 = "";
        }
        String str4 = com.mbridge.msdk.foundation.same.directory.e.b(com.mbridge.msdk.foundation.same.directory.c.MBRIDGE_700_XML) + File.separator;
        if (!TextUtils.isEmpty(str3)) {
            file = new File(str4, str3);
            if (file != null || !file.exists()) {
                file = new File(str4 + File.separator + str3.replace(".xml", ""), str3);
            }
            return file.getPath();
        }
        file = null;
        if (file != null) {
        }
        file = new File(str4 + File.separator + str3.replace(".xml", ""), str3);
        return file.getPath();
    }

    public static String a(String str) {
        String str2;
        String str3;
        File file;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            String queryParameter = Uri.parse(str).getQueryParameter(MBridgeConstans.DYNAMIC_VIEW_KEY_NATMP);
            if (!TextUtils.isEmpty(queryParameter)) {
                if (!queryParameter.equals("1")) {
                    return "";
                }
            }
        } catch (Throwable unused) {
        }
        try {
            str2 = b(str);
        } catch (Exception unused2) {
            str2 = "";
        }
        if (TextUtils.isEmpty(str2)) {
            return "";
        }
        try {
            str3 = com.mbridge.msdk.foundation.same.directory.e.b(com.mbridge.msdk.foundation.same.directory.c.MBRIDGE_700_XML) + File.separator;
            file = new File(str3, str2);
        } catch (Exception unused3) {
        }
        if (file.isFile() && file.exists()) {
            return file.getPath();
        }
        String path = new URL(str).getPath();
        a(str, path.substring(path.lastIndexOf(47) + 1), str3, str2);
        return "";
    }

    private static final void a(String str, String str2, String str3, String str4, c cVar, CampaignEx campaignEx, int i) throws Exception {
        p0.a("test_zip_download ", "start download path： " + str3 + str2);
        DownloadMessage<?> downloadMessage = new DownloadMessage<>(campaignEx, str, str2, 100, DownloadResourceType.DOWNLOAD_RESOURCE_TYPE_OTHER);
        downloadMessage.addExtra("resource_type", Integer.valueOf(i));
        MBDownloadManager.getInstance().download(downloadMessage).withReadTimeout(com.mbridge.msdk.foundation.same.a.u).withConnectTimeout(com.mbridge.msdk.foundation.same.a.t).withTimeout(60000L).withWriteTimeout(com.mbridge.msdk.foundation.same.a.s).with("download_scene", "download_dynamic_view").withDownloadPriority(DownloadPriority.MEDIUM).withHttpRetryCounter(1).withDirectoryPathInternal(str3).withDownloadStateListener(new a(str3, str2, cVar, str, str4)).build().start();
    }

    private static final void a(String str, String str2, String str3, String str4) throws Exception {
        MBDownloadManager.getInstance().download(new DownloadMessage<>(new Object(), str, str2, 100, DownloadResourceType.DOWNLOAD_RESOURCE_TYPE_OTHER)).withReadTimeout(com.mbridge.msdk.foundation.same.a.u).withConnectTimeout(com.mbridge.msdk.foundation.same.a.o).with("download_scene", "download_dynamic_view").withWriteTimeout(com.mbridge.msdk.foundation.same.a.s).withTimeout(60000L).withDownloadPriority(DownloadPriority.MEDIUM).withHttpRetryCounter(1).withDirectoryPathInternal(str3).withDownloadStateListener(new b(str3, str2)).build().start();
    }
}
