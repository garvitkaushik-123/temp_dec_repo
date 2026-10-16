package com.fyber.inneractive.sdk.player;

import android.content.Context;
import android.text.TextUtils;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.enums.Skip;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.config.global.features.u;
import com.fyber.inneractive.sdk.config.s0;
import com.fyber.inneractive.sdk.config.t0;
import com.fyber.inneractive.sdk.external.InneractiveAdManager;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveVideoError;
import com.fyber.inneractive.sdk.flow.r0;
import com.fyber.inneractive.sdk.model.vast.x;
import com.fyber.inneractive.sdk.network.w;
import com.fyber.inneractive.sdk.player.enums.VideoClickOrigin;
import com.fyber.inneractive.sdk.util.IAlog;
import io.bidmachine.iab.vast.tags.VastAttributes;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public abstract class f implements com.fyber.inneractive.sdk.player.controller.p, com.fyber.inneractive.sdk.player.controller.o {

    /* renamed from: a, reason: collision with root package name */
    public com.fyber.inneractive.sdk.player.controller.q f1617a;
    public r0 b;
    public InneractiveAdRequest c;
    public com.fyber.inneractive.sdk.measurement.e d;
    public com.fyber.inneractive.sdk.measurement.f e;
    public q l;
    public int m;
    public com.fyber.inneractive.sdk.model.vast.r n;
    public p f = null;
    public boolean g = true;
    public boolean h = false;
    public volatile boolean i = false;
    public boolean j = false;
    public int k = 0;
    public final c o = new c(this);

    /* JADX WARN: Removed duplicated region for block: B:10:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x004b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public f(Context context, com.fyber.inneractive.sdk.config.global.r rVar) {
        Boolean c;
        boolean booleanValue;
        com.fyber.inneractive.sdk.player.controller.q qVar;
        com.fyber.inneractive.sdk.player.controller.q qVar2 = null;
        if (rVar != null) {
            try {
                c = ((u) rVar.a(u.class)).c("use_fmp_cache_mechanism");
            } catch (Throwable th) {
                if (IAlog.f1749a <= 3) {
                    IAlog.a("Failed creating exo player", new Object[0]);
                    th.printStackTrace();
                }
            }
            if (c != null) {
                booleanValue = c.booleanValue();
                qVar2 = new com.fyber.inneractive.sdk.player.controller.f(context, booleanValue, rVar);
                qVar2 = qVar2 == null ? new com.fyber.inneractive.sdk.player.controller.a(context) : qVar2;
                this.f1617a = qVar2;
                if (!qVar2.b.contains(this)) {
                    qVar2.b.add(this);
                }
                qVar = this.f1617a;
                if (!qVar.c.contains(this)) {
                    qVar.c.add(this);
                }
                this.f1617a.f = this.o;
            }
        }
        booleanValue = false;
        qVar2 = new com.fyber.inneractive.sdk.player.controller.f(context, booleanValue, rVar);
        if (qVar2 == null) {
        }
        this.f1617a = qVar2;
        if (!qVar2.b.contains(this)) {
        }
        qVar = this.f1617a;
        if (!qVar.c.contains(this)) {
        }
        this.f1617a.f = this.o;
    }

    public abstract void a(InneractiveVideoError inneractiveVideoError, JSONObject jSONObject);

    @Override // com.fyber.inneractive.sdk.player.controller.p
    public final void a(com.fyber.inneractive.sdk.player.mediaplayer.o oVar) {
        IAlog.a("IMediaPlayerFlowManager: onPlayerError called with: %s", oVar.getMessage());
        a(new InneractiveVideoError(InneractiveVideoError.Error.ERROR_FAILED_PLAYING_MEDIA_FILE, oVar), new JSONObject());
        if (this.h) {
            IAlog.a("IMediaPlayerFlowManager: onPlayerError video was prepared. This is a critical error. Aborting!", new Object[0]);
            a(new InneractiveVideoError(InneractiveVideoError.Error.ERROR_FAILED_PLAYING_ALL_MEDIA_FILES, oVar), new JSONObject());
        }
    }

    public abstract void a(com.fyber.inneractive.sdk.response.i iVar, VideoClickOrigin videoClickOrigin, x... xVarArr);

    @Override // com.fyber.inneractive.sdk.player.controller.p
    public final void c(boolean z) {
        try {
            r0 r0Var = this.b;
            com.fyber.inneractive.sdk.response.g gVar = r0Var != null ? (com.fyber.inneractive.sdk.response.g) r0Var.b : null;
            com.fyber.inneractive.sdk.network.u uVar = com.fyber.inneractive.sdk.network.u.VAST_MEDIA_LOAD_RETRY_ATTEMPTED;
            InneractiveAdRequest inneractiveAdRequest = this.c;
            r0 r0Var2 = this.b;
            JSONArray b = r0Var2 == null ? null : r0Var2.c.b();
            w wVar = new w(gVar);
            wVar.c = uVar;
            wVar.f1340a = inneractiveAdRequest;
            wVar.d = b;
            if (this.n != null && gVar != null) {
                wVar.f.put(new com.fyber.inneractive.sdk.network.x().a(String.valueOf(z), "waudio").a(this.n.g, "url").a(this.n.e, VastAttributes.BITRATE).a(TextUtils.isEmpty(this.n.d) ? "na" : this.n.d, "mime").a(this.n.f1293a, "delivery").a(Integer.valueOf(this.k), "media_file_index").a(this.f1617a.d(), "player").f1342a);
            }
            wVar.a((String) null);
        } catch (Exception unused) {
        }
    }

    public static boolean a(int i, int i2, s0 s0Var) {
        if (i2 == 1 || InneractiveAdManager.isCurrentUserAChild()) {
            return true;
        }
        if (i <= 15999) {
            return false;
        }
        t0 t0Var = s0Var != null ? ((com.fyber.inneractive.sdk.config.r0) s0Var).f : null;
        return (t0Var == null || t0Var.h == Skip.DEFAULT || t0Var.j == UnitDisplayType.REWARDED) ? false : true;
    }

    public static int a(f fVar) {
        com.fyber.inneractive.sdk.response.e eVar;
        r0 r0Var = fVar.b;
        if (r0Var == null || (eVar = r0Var.b) == null) {
            return -1;
        }
        return ((com.fyber.inneractive.sdk.response.g) eVar).y;
    }

    public final void a() {
        com.fyber.inneractive.sdk.measurement.f fVar = this.e;
        if (fVar != null) {
            if (fVar.f1269a != null) {
                IAlog.a("%s destroy", "OMVideo");
                try {
                    fVar.f1269a.finish();
                } catch (Throwable th) {
                    fVar.a(th);
                }
            }
            fVar.b = null;
            fVar.f1269a = null;
            fVar.c = null;
        }
    }

    public static boolean a(com.fyber.inneractive.sdk.config.global.r rVar, com.fyber.inneractive.sdk.ignite.m mVar) {
        mVar.getClass();
        if (mVar != com.fyber.inneractive.sdk.ignite.m.TRUE_SINGLE_TAP || !IAConfigManager.O.E.n() || rVar == null || rVar.a(com.fyber.inneractive.sdk.config.global.features.n.class) == null) {
            return false;
        }
        Boolean c = ((com.fyber.inneractive.sdk.config.global.features.n) rVar.a(com.fyber.inneractive.sdk.config.global.features.n.class)).c("enable_app_info_button");
        return c != null ? c.booleanValue() : true;
    }
}
