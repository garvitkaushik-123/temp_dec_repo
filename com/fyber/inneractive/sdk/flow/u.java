package com.fyber.inneractive.sdk.flow;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.external.InneractiveInfrastructureError;
import com.fyber.inneractive.sdk.external.InneractiveVideoError;
import com.fyber.inneractive.sdk.util.IAlog;
import com.iab.omid.library.fyber.adsession.AdEvents;
import com.iab.omid.library.fyber.adsession.AdSession;
import com.iab.omid.library.fyber.adsession.AdSessionConfiguration;
import com.iab.omid.library.fyber.adsession.AdSessionContext;
import com.iab.omid.library.fyber.adsession.CreativeType;
import com.iab.omid.library.fyber.adsession.ImpressionType;
import com.iab.omid.library.fyber.adsession.Owner;
import com.iab.omid.library.fyber.adsession.Partner;
import com.iab.omid.library.fyber.adsession.media.MediaEvents;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;

/* loaded from: classes4.dex */
public final class u extends k implements com.fyber.inneractive.sdk.player.s {
    public com.fyber.inneractive.sdk.player.t m;
    public String n;
    public final t o = new t(this);

    @Override // com.fyber.inneractive.sdk.flow.k, com.fyber.inneractive.sdk.interfaces.b
    public final void a() {
        com.fyber.inneractive.sdk.model.vast.b bVar;
        if (this.m != null) {
            com.fyber.inneractive.sdk.response.e eVar = this.b;
            this.m.a((eVar == null || (bVar = ((com.fyber.inneractive.sdk.response.g) eVar).O) == null) ? null : bVar.d.size() == 0 ? new InneractiveVideoError(InneractiveVideoError.Error.ERROR_FAILED_PLAYING_ALL_MEDIA_FILES, null) : new InneractiveVideoError(InneractiveVideoError.Error.ERROR_FAILED_PLAYING_MEDIA_FILE, null), null, true);
        }
        IAlog.a("%s: IAAdContentLoaderImpl : cancel load ad content retry task", IAlog.a(this));
        com.fyber.inneractive.sdk.util.r.b.removeCallbacks(this.l);
        this.k.a();
        super.a();
    }

    @Override // com.fyber.inneractive.sdk.flow.k
    public final String d() {
        return "send_failed_vast_creatives";
    }

    @Override // com.fyber.inneractive.sdk.flow.k
    public final void g() {
        com.fyber.inneractive.sdk.model.vast.b bVar;
        AdSessionConfiguration adSessionConfiguration;
        String str;
        com.fyber.inneractive.sdk.network.t tVar;
        com.fyber.inneractive.sdk.model.vast.b bVar2;
        IAlog.a(IAlog.a(this) + "start called", new Object[0]);
        com.fyber.inneractive.sdk.config.s0 e = e();
        com.fyber.inneractive.sdk.response.e eVar = this.b;
        AdSessionContext adSessionContext = null;
        com.fyber.inneractive.sdk.model.vast.b bVar3 = eVar == null ? null : ((com.fyber.inneractive.sdk.response.g) eVar).O;
        if (bVar3 != null && bVar3.d.size() < bVar3.i) {
            bVar3.d.clear();
            bVar3.g.clear();
            bVar3.d.addAll(bVar3.k);
            bVar3.g.addAll(bVar3.l);
        }
        r0 r0Var = new r0(e, this.g, (com.fyber.inneractive.sdk.response.g) this.b, this.f1207a);
        this.c = r0Var;
        com.fyber.inneractive.sdk.response.g gVar = (com.fyber.inneractive.sdk.response.g) this.b;
        com.fyber.inneractive.sdk.player.t tVar2 = new com.fyber.inneractive.sdk.player.t(gVar, this.f1207a, r0Var, this);
        this.m = tVar2;
        r0 r0Var2 = (r0) this.c;
        r0Var2.i = tVar2;
        r0Var2.f = this.h;
        this.n = bVar3 != null ? bVar3.n : null;
        tVar2.e = null;
        if (gVar != null && (bVar2 = gVar.O) != null) {
            tVar2.e = (com.fyber.inneractive.sdk.model.vast.r) bVar2.d.poll();
        }
        if (tVar2.e == null) {
            InneractiveVideoError.Error playerError = new InneractiveVideoError(InneractiveVideoError.Error.ERROR_FAILED_PLAYING_ALL_MEDIA_FILES).getPlayerError();
            int i = com.fyber.inneractive.sdk.player.r.f1637a[playerError.ordinal()];
            if (i == 1) {
                tVar = com.fyber.inneractive.sdk.network.t.VAST_ERROR_NO_MEDIA_FILES;
            } else if (i == 2) {
                tVar = com.fyber.inneractive.sdk.network.t.VAST_ERROR_FAILED_PLAYING_MEDIA_FILE;
            } else if (i == 3) {
                tVar = com.fyber.inneractive.sdk.network.t.VAST_ERROR_FAILED_PLAYING_ALL_MEDIA_FILES;
            } else if (i == 4) {
                tVar = com.fyber.inneractive.sdk.network.t.VAST_ERROR_PRE_BUFFER_TIMEOUT;
            } else if (i != 5) {
                IAlog.a("IAReportError, Does not know player error " + playerError.getErrorString(), new Object[0]);
                tVar = com.fyber.inneractive.sdk.network.t.VAST_UNKNOWN_PLAYER_ERROR;
            } else {
                tVar = com.fyber.inneractive.sdk.network.t.VAST_ERROR_BUFFER_TIMEOUT;
            }
            InneractiveAdRequest inneractiveAdRequest = tVar2.b;
            com.fyber.inneractive.sdk.response.g gVar2 = tVar2.c;
            JSONArray b = tVar2.h.b();
            com.fyber.inneractive.sdk.network.w wVar = new com.fyber.inneractive.sdk.network.w(gVar2);
            wVar.b = tVar;
            wVar.f1340a = inneractiveAdRequest;
            wVar.d = b;
            wVar.a((String) null);
            InneractiveInfrastructureError inneractiveInfrastructureError = new InneractiveInfrastructureError(InneractiveErrorCode.SDK_INTERNAL_ERROR, i.VAST_NO_MEDIA_FILES);
            b(inneractiveInfrastructureError);
            a(inneractiveInfrastructureError);
        } else {
            tVar2.b();
            com.fyber.inneractive.sdk.player.a aVar = tVar2.f;
            if (aVar != null) {
                com.fyber.inneractive.sdk.player.n nVar = (com.fyber.inneractive.sdk.player.n) aVar;
                com.fyber.inneractive.sdk.measurement.e eVar2 = nVar.d;
                if (eVar2 != null) {
                    com.fyber.inneractive.sdk.measurement.f fVar = new com.fyber.inneractive.sdk.measurement.f();
                    ArrayList arrayList = nVar.p.e;
                    r0 r0Var3 = nVar.b;
                    try {
                        try {
                            CreativeType creativeType = CreativeType.VIDEO;
                            ImpressionType impressionType = ImpressionType.UNSPECIFIED;
                            Owner owner = Owner.NATIVE;
                            adSessionConfiguration = AdSessionConfiguration.createAdSessionConfiguration(creativeType, impressionType, owner, owner, false);
                        } catch (Throwable th) {
                            fVar.a(th);
                            adSessionConfiguration = null;
                        }
                        ArrayList a2 = fVar.a(arrayList);
                        Partner partner = eVar2.e;
                        if (partner != null && (str = eVar2.b) != null) {
                            try {
                                adSessionContext = AdSessionContext.createNativeAdSessionContext(partner, str, a2, "", "");
                            } catch (Throwable th2) {
                                fVar.a(th2);
                            }
                        }
                        AdSession createAdSession = AdSession.createAdSession(adSessionConfiguration, adSessionContext);
                        fVar.f1269a = createAdSession;
                        fVar.b = AdEvents.createAdEvents(createAdSession);
                        fVar.c = MediaEvents.createMediaEvents(fVar.f1269a);
                        fVar.f1269a.start();
                        fVar.f = r0Var3;
                    } catch (Throwable th3) {
                        fVar.a(th3);
                    }
                    nVar.e = fVar;
                    nVar.f = new com.fyber.inneractive.sdk.player.p(fVar);
                }
                if (nVar.e == null && (bVar = nVar.p) != null) {
                    Iterator it = bVar.e.iterator();
                    while (it.hasNext()) {
                        com.fyber.inneractive.sdk.measurement.h hVar = (com.fyber.inneractive.sdk.measurement.h) it.next();
                        com.fyber.inneractive.sdk.measurement.i iVar = com.fyber.inneractive.sdk.measurement.i.ERROR_DURING_RESOURCE_LOAD;
                        com.fyber.inneractive.sdk.model.vast.x xVar = com.fyber.inneractive.sdk.model.vast.x.EVENT_VERIFICATION_NOT_EXECUTED;
                        com.fyber.inneractive.sdk.player.n.a(new com.fyber.inneractive.sdk.measurement.g(hVar.a(xVar), iVar), xVar);
                    }
                }
            }
            tVar2.a();
        }
        if (TextUtils.isEmpty(this.n)) {
            return;
        }
        IAConfigManager.O.s.b(new com.fyber.inneractive.sdk.network.t0(this.o, com.fyber.inneractive.sdk.util.o.f1770a, new com.fyber.inneractive.sdk.cache.k(this.n)));
    }

    public final com.fyber.inneractive.sdk.player.ui.remote.g i() {
        com.fyber.inneractive.sdk.player.a aVar;
        com.fyber.inneractive.sdk.player.t tVar = this.m;
        if (tVar == null || (aVar = tVar.f) == null) {
            return null;
        }
        com.fyber.inneractive.sdk.player.n nVar = (com.fyber.inneractive.sdk.player.n) aVar;
        if (nVar.u != null) {
            return nVar.u;
        }
        return null;
    }

    @Override // com.fyber.inneractive.sdk.flow.k, com.fyber.inneractive.sdk.interfaces.c
    public final void cancel() {
        IAlog.a("%s: IAAdContentLoaderImpl : cancel load ad content retry task", IAlog.a(this));
        com.fyber.inneractive.sdk.util.r.b.removeCallbacks(this.l);
        this.k.a();
    }

    public final void a(Exception exc, String str, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("description", str);
        if (exc != null) {
            hashMap.put("exception", exc.getMessage());
        }
        if (i() != null) {
            i().f1653a.a();
        }
        com.fyber.inneractive.sdk.network.events.a.a(com.fyber.inneractive.sdk.network.t.VAST_ERROR_DVC_FAILURE, com.fyber.inneractive.sdk.network.events.b.TEMPLATE_ERROR.name(), this.n, this.f1207a, this.b, hashMap, Boolean.valueOf(z));
    }
}
