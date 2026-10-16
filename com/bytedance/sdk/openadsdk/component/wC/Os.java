package com.bytedance.sdk.openadsdk.component.wC;

import android.content.Context;
import android.widget.FrameLayout;
import com.bykv.vk.openvk.eli.eli.eli.aGH.Os;
import com.bytedance.sdk.component.utils.Xb;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.aGH.ui.DbA.Dfc;
import com.bytedance.sdk.openadsdk.core.DbA.eli;
import com.bytedance.sdk.openadsdk.core.model.ev;

/* loaded from: classes3.dex */
public class Os implements eli.InterfaceC0172eli {
    private FrameLayout DbA;
    private ev Os;
    private DbA aGH;
    private Context eli;
    private boolean ui = false;

    public Os(Context context) {
        this.eli = context.getApplicationContext();
    }

    public void eli(FrameLayout frameLayout, ev evVar) {
        this.DbA = frameLayout;
        this.Os = evVar;
        this.aGH = new DbA(this.eli, this.DbA, this.Os);
    }

    public boolean eli() {
        com.bytedance.sdk.openadsdk.core.nlS.eli.DbA eli = ev.eli(CacheDirFactory.getICacheDir(0).DbA(), this.Os);
        eli.DbA(this.Os.umh());
        eli.DbA(this.DbA.getWidth());
        eli.Os(this.DbA.getHeight());
        eli.Os(this.Os.eu());
        eli.eli(0L);
        eli.eli(true);
        return this.aGH.eli(eli);
    }

    public DbA DbA() {
        return this.aGH;
    }

    public void eli(boolean z) {
        this.ui = z;
    }

    public boolean Os() {
        return this.ui;
    }

    public boolean aGH() {
        DbA dbA = this.aGH;
        return (dbA == null || dbA.du() == null || !this.aGH.du().DbA()) ? false : true;
    }

    public boolean ui() {
        DbA dbA = this.aGH;
        return (dbA == null || dbA.du() == null || !this.aGH.du().MGA()) ? false : true;
    }

    public boolean MGA() {
        DbA dbA = this.aGH;
        return (dbA == null || dbA.du() == null || !this.aGH.du().kb()) ? false : true;
    }

    public boolean kb() {
        DbA dbA = this.aGH;
        return dbA != null && dbA.nn();
    }

    public void eli(Os.eli eliVar) {
        DbA dbA = this.aGH;
        if (dbA != null) {
            dbA.eli(eliVar);
        }
    }

    public boolean eli(FrameLayout frameLayout, com.bytedance.sdk.openadsdk.component.eli eliVar, ev evVar) {
        eli(frameLayout, evVar);
        eli(eliVar);
        try {
            return eli();
        } catch (Throwable th) {
            Xb.Os("TTAppOpenVideoManager", "open_ad", "ttAppOpenAd playVideo error: " + th.getMessage());
            return false;
        }
    }

    public boolean eli(float f) {
        try {
            DbA dbA = this.aGH;
            if (dbA != null) {
                return dbA.eli(f);
            }
            return false;
        } catch (Throwable th) {
            Xb.Os("TTAppOpenVideoManager", "open_ad", "setPlaybackSpeed error: " + th.getMessage());
            return false;
        }
    }

    public void wC() {
        try {
            if (ui()) {
                this.aGH.DbA();
            }
        } catch (Throwable th) {
            Xb.Os("TTAppOpenVideoManager", "open_ad", "AppOpenVideoManager onPause throw Exception :" + th.getMessage());
        }
    }

    public void FC() {
        try {
            if (MGA()) {
                du();
            }
        } catch (Throwable th) {
            Xb.Os("TTAppOpenVideoManager", "onContinue throw Exception :" + th.getMessage());
        }
    }

    public void aAs() {
        DbA dbA = this.aGH;
        if (dbA == null) {
            return;
        }
        dbA.aGH();
        this.aGH = null;
    }

    public void du() {
        DbA dbA = this.aGH;
        if (dbA != null) {
            dbA.Os();
        }
    }

    public void nlS() {
        DbA dbA = this.aGH;
        if (dbA == null) {
            return;
        }
        this.eli = null;
        dbA.aGH();
        this.aGH = null;
    }

    public long NU() {
        DbA dbA = this.aGH;
        if (dbA != null) {
            return dbA.MGA();
        }
        return 0L;
    }

    public long nn() {
        DbA dbA = this.aGH;
        if (dbA != null) {
            return dbA.kb();
        }
        return 0L;
    }

    public long Dfc() {
        DbA dbA = this.aGH;
        if (dbA != null) {
            return dbA.FC() + this.aGH.kb();
        }
        return 0L;
    }

    public void eli(int i) {
        if (this.aGH != null) {
            Dfc.eli eliVar = new Dfc.eli();
            eliVar.DbA(NU());
            eliVar.aGH(Dfc());
            eliVar.Os(nn());
            eliVar.Os(i);
            eliVar.aGH(this.aGH.wC());
            eliVar.eli(this.aGH.dV());
            this.aGH.eli(eliVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.DbA.eli.InterfaceC0172eli
    public long getVideoProgress() {
        return NU();
    }
}
