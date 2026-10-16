package com.mbridge.msdk.foundation.download.download;

import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.directory.e;
import com.mbridge.msdk.foundation.same.image.b;
import com.mbridge.msdk.foundation.tools.n0;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes6.dex */
public class ResDownloadCheckManager {
    private static ConcurrentHashMap<String, Boolean> recordImageMap = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Boolean> campaignStateMap;
    private ConcurrentHashMap<String, Boolean> preLoadSuccessedMap;
    private ConcurrentHashMap<String, Boolean> recordVideoMap;
    private ConcurrentHashMap<String, Boolean> recordZipMap;

    private static final class Holder {
        public static ResDownloadCheckManager instance = new ResDownloadCheckManager();

        private Holder() {
        }
    }

    private void addImageUrlToMap(List<String> list) {
        ConcurrentHashMap<String, Boolean> concurrentHashMap;
        if (list == null || list.size() == 0) {
            return;
        }
        for (String str : list) {
            if (!TextUtils.isEmpty(str) && (concurrentHashMap = recordImageMap) != null && !concurrentHashMap.containsKey(str)) {
                boolean c = b.a(c.m().d()).c(str);
                if (!TextUtils.isEmpty(str)) {
                    recordImageMap.put(str, Boolean.valueOf(c));
                }
            }
        }
    }

    private void addUrlToMap(CampaignEx campaignEx) {
        List<CampaignEx.c.a> a2;
        ConcurrentHashMap<String, Boolean> concurrentHashMap;
        ConcurrentHashMap<String, Boolean> concurrentHashMap2;
        if (campaignEx != null) {
            String videoUrlEncode = campaignEx.getVideoUrlEncode();
            if (!TextUtils.isEmpty(videoUrlEncode) && (concurrentHashMap2 = this.recordVideoMap) != null && !concurrentHashMap2.containsKey(videoUrlEncode)) {
                this.recordVideoMap.put(videoUrlEncode, Boolean.FALSE);
            }
            String str = campaignEx.getendcard_url();
            if (!TextUtils.isEmpty(str) && (concurrentHashMap = this.recordZipMap) != null && !concurrentHashMap.containsKey(str)) {
                this.recordZipMap.put(str, Boolean.FALSE);
            }
            CampaignEx.c rewardTemplateMode = campaignEx.getRewardTemplateMode();
            if (rewardTemplateMode == null || (a2 = rewardTemplateMode.a()) == null) {
                return;
            }
            for (CampaignEx.c.a aVar : a2) {
                if (aVar != null) {
                    addImageUrlToMap(aVar.f4236a);
                }
            }
        }
    }

    private boolean checkImageUrlState(boolean z, String str) {
        boolean checkState = checkState(recordImageMap, str);
        if (checkState || b.a(c.m().d()).c(str)) {
            return true;
        }
        return checkState;
    }

    private boolean checkState(ConcurrentHashMap<String, Boolean> concurrentHashMap, String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        if (concurrentHashMap == null) {
            new ConcurrentHashMap().put(str, Boolean.FALSE);
            return false;
        }
        if (concurrentHashMap.containsKey(str)) {
            return concurrentHashMap.get(str).booleanValue();
        }
        concurrentHashMap.put(str, Boolean.FALSE);
        return false;
    }

    private boolean checkZipState(boolean z, String str) {
        boolean checkState = checkState(this.recordZipMap, str);
        if (checkState || !z || TextUtils.isEmpty(H5DownLoadManager.getInstance().getH5ResAddress(str))) {
            return checkState;
        }
        this.recordZipMap.put(str, Boolean.TRUE);
        return true;
    }

    public static ResDownloadCheckManager getInstance() {
        return Holder.instance;
    }

    private boolean getIsEffectivePath(String str) {
        File file = new File(e.b(com.mbridge.msdk.foundation.same.directory.c.MBRIDGE_VC) + File.separator + n0.d(str));
        try {
            if (file.exists() && file.isFile()) {
                return file.canRead();
            }
            return false;
        } catch (Throwable th) {
            if (!MBridgeConstans.DEBUG) {
                return false;
            }
            th.printStackTrace();
            return false;
        }
    }

    private void updateCampaignState(String str, boolean z) {
        if (this.campaignStateMap == null) {
            this.campaignStateMap = new ConcurrentHashMap<>();
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.campaignStateMap.put(str, Boolean.valueOf(z));
    }

    public boolean checkImageState(boolean z, CampaignEx.c cVar) {
        List<CampaignEx.c.a> a2;
        List<String> list;
        if (cVar != null && (a2 = cVar.a()) != null) {
            for (CampaignEx.c.a aVar : a2) {
                if (aVar != null && (list = aVar.f4236a) != null) {
                    Iterator<String> it = list.iterator();
                    while (it.hasNext()) {
                        if (!checkImageUrlState(z, it.next())) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public boolean checkPreLoadState(String str) {
        if (!TextUtils.isEmpty(str) && this.preLoadSuccessedMap.containsKey(str)) {
            return this.preLoadSuccessedMap.get(str).booleanValue();
        }
        return false;
    }

    public boolean containsVideoKey(String str) {
        if (this.recordVideoMap == null || TextUtils.isEmpty(str) || !this.recordVideoMap.containsKey(str)) {
            return false;
        }
        return this.recordVideoMap.get(str).booleanValue();
    }

    public boolean containsZipKey(String str) {
        if (this.recordZipMap == null || TextUtils.isEmpty(str) || !this.recordZipMap.containsKey(str)) {
            return false;
        }
        return this.recordZipMap.get(str).booleanValue();
    }

    public void removePreLoadState(String str) {
        if (this.preLoadSuccessedMap.containsKey(str)) {
            this.preLoadSuccessedMap.remove(str);
        }
    }

    public void setCampaignList(CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList) {
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() == 0) {
            return;
        }
        Iterator<CampaignEx> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            CampaignEx next = it.next();
            if (next != null) {
                addUrlToMap(next);
                updateCampaignState(next.getId(), false);
            }
        }
    }

    public void setImageDownloadDone(String str, boolean z) {
        if (recordImageMap == null) {
            recordImageMap = new ConcurrentHashMap<>();
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        recordImageMap.put(str, Boolean.valueOf(z));
    }

    public void setTemplatePreLoadDone(String str, boolean z) {
        if (this.preLoadSuccessedMap == null) {
            this.preLoadSuccessedMap = new ConcurrentHashMap<>();
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.preLoadSuccessedMap.put(str, Boolean.valueOf(z));
    }

    public void setVideoDownloadDone(String str, boolean z) {
        if (this.recordVideoMap == null) {
            this.recordVideoMap = new ConcurrentHashMap<>();
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.recordVideoMap.put(str, Boolean.valueOf(z));
    }

    public void setZipDownloadDone(String str, boolean z) {
        if (this.recordZipMap == null) {
            this.recordZipMap = new ConcurrentHashMap<>();
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.recordZipMap.put(str, Boolean.valueOf(z));
    }

    private ResDownloadCheckManager() {
        this.campaignStateMap = new ConcurrentHashMap<>();
        this.preLoadSuccessedMap = new ConcurrentHashMap<>();
        this.recordVideoMap = new ConcurrentHashMap<>();
        this.recordZipMap = new ConcurrentHashMap<>();
    }

    public void setCampaignList(CampaignEx campaignEx) {
        if (campaignEx != null) {
            addUrlToMap(campaignEx);
            updateCampaignState(campaignEx.getId(), false);
        }
    }
}
