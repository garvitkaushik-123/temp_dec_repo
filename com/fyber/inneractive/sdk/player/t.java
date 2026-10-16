package com.fyber.inneractive.sdk.player;

import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.external.InneractiveInfrastructureError;
import com.fyber.inneractive.sdk.external.InneractiveVideoError;
import com.fyber.inneractive.sdk.flow.r0;
import com.fyber.inneractive.sdk.flow.u;
import com.fyber.inneractive.sdk.model.vast.x;
import com.fyber.inneractive.sdk.network.w;
import com.fyber.inneractive.sdk.player.enums.VideoClickOrigin;
import com.fyber.inneractive.sdk.util.IAlog;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class t implements q {

    /* renamed from: a, reason: collision with root package name */
    public final b f1638a;
    public final InneractiveAdRequest b;
    public final com.fyber.inneractive.sdk.response.g c;
    public final s d;
    public com.fyber.inneractive.sdk.model.vast.r e;
    public a f;
    public boolean g = false;
    public final com.fyber.inneractive.sdk.config.global.r h;

    public t(com.fyber.inneractive.sdk.response.g gVar, InneractiveAdRequest inneractiveAdRequest, r0 r0Var, s sVar) {
        this.b = inneractiveAdRequest;
        this.c = gVar;
        this.d = sVar;
        this.h = r0Var.c;
        this.f1638a = new b(r0Var);
    }

    public final void a() {
        a aVar = this.f;
        if (aVar == null) {
            s sVar = this.d;
            InneractiveInfrastructureError inneractiveInfrastructureError = new InneractiveInfrastructureError(InneractiveErrorCode.SDK_INTERNAL_ERROR, com.fyber.inneractive.sdk.flow.i.COULD_NOT_LOAD_USING_FLOW_MANAGER, new Exception("loadNextMediaFile flowManager is null"));
            u uVar = (u) sVar;
            uVar.b(inneractiveInfrastructureError);
            uVar.a(inneractiveInfrastructureError);
            return;
        }
        com.fyber.inneractive.sdk.model.vast.r rVar = this.e;
        n nVar = (n) aVar;
        nVar.l = this;
        if (rVar != null) {
            String str = rVar.g;
            nVar.n = rVar;
            nVar.k++;
            nVar.h = false;
            nVar.j = false;
            IAlog.a("IAMediaPlayerFlowManager: playNextMediaFile - loading video url: %s", str);
            IAlog.a("IAMediaPlayerFlowManager: start - start fetching video frame", new Object[0]);
            if (nVar.i) {
                return;
            }
            nVar.f1617a.a(str, nVar.m);
        }
    }

    public final void b() {
        try {
            this.f = this.f1638a.a();
        } catch (Throwable th) {
            s sVar = this.d;
            InneractiveInfrastructureError inneractiveInfrastructureError = new InneractiveInfrastructureError(InneractiveErrorCode.SDK_INTERNAL_ERROR, com.fyber.inneractive.sdk.flow.i.COULD_NOT_CREATE_FLOW_MANAGER, th);
            u uVar = (u) sVar;
            uVar.b(inneractiveInfrastructureError);
            uVar.a(inneractiveInfrastructureError);
        }
    }

    public final void a(InneractiveVideoError inneractiveVideoError, JSONObject jSONObject, boolean z) {
        JSONObject jSONObject2;
        InneractiveErrorCode inneractiveErrorCode;
        com.fyber.inneractive.sdk.network.t tVar;
        com.fyber.inneractive.sdk.model.vast.b bVar;
        com.fyber.inneractive.sdk.network.t tVar2;
        if (jSONObject != null || inneractiveVideoError == null) {
            jSONObject2 = jSONObject;
        } else {
            jSONObject2 = new JSONObject();
            ((n) this.f).b(inneractiveVideoError, jSONObject2);
        }
        com.fyber.inneractive.sdk.flow.i iVar = com.fyber.inneractive.sdk.flow.i.UNSPECIFIED;
        if (inneractiveVideoError != null) {
            InneractiveVideoError.Error playerError = inneractiveVideoError.getPlayerError();
            int i = r.f1637a[playerError.ordinal()];
            if (i == 1) {
                tVar2 = com.fyber.inneractive.sdk.network.t.VAST_ERROR_NO_MEDIA_FILES;
            } else if (i == 2) {
                tVar2 = com.fyber.inneractive.sdk.network.t.VAST_ERROR_FAILED_PLAYING_MEDIA_FILE;
            } else if (i == 3) {
                tVar2 = com.fyber.inneractive.sdk.network.t.VAST_ERROR_FAILED_PLAYING_ALL_MEDIA_FILES;
            } else if (i == 4) {
                tVar2 = com.fyber.inneractive.sdk.network.t.VAST_ERROR_PRE_BUFFER_TIMEOUT;
            } else if (i != 5) {
                IAlog.a("IAReportError, Does not know player error " + playerError.getErrorString(), new Object[0]);
                tVar2 = com.fyber.inneractive.sdk.network.t.VAST_UNKNOWN_PLAYER_ERROR;
            } else {
                tVar2 = com.fyber.inneractive.sdk.network.t.VAST_ERROR_BUFFER_TIMEOUT;
            }
            InneractiveAdRequest inneractiveAdRequest = this.b;
            com.fyber.inneractive.sdk.response.g gVar = this.c;
            JSONArray b = this.h.b();
            w wVar = new w(gVar);
            wVar.b = tVar2;
            wVar.f1340a = inneractiveAdRequest;
            wVar.d = b;
            if (jSONObject2 != null) {
                try {
                    wVar.f.put(new JSONObject(jSONObject2.toString()));
                } catch (Exception unused) {
                }
            }
            wVar.a((String) null);
        }
        if (InneractiveErrorCode.NON_SECURE_CONTENT_DETECTED == null) {
            com.fyber.inneractive.sdk.network.t tVar3 = com.fyber.inneractive.sdk.network.t.VPAID_ERROR_UNSECURE_CONTENT;
            InneractiveAdRequest inneractiveAdRequest2 = this.b;
            com.fyber.inneractive.sdk.response.g gVar2 = this.c;
            JSONArray b2 = this.h.b();
            w wVar2 = new w(gVar2);
            wVar2.b = tVar3;
            wVar2.f1340a = inneractiveAdRequest2;
            wVar2.d = b2;
            wVar2.a((String) null);
        }
        if (inneractiveVideoError != null) {
            IAlog.a("got onMediaPlayerLoadError with: " + inneractiveVideoError.getPlayerError(), new Object[0]);
            if (z) {
                inneractiveErrorCode = InneractiveErrorCode.LOAD_TIMEOUT;
                iVar = com.fyber.inneractive.sdk.flow.i.VIDEO_AD_LOAD_TIMEOUT;
            } else {
                inneractiveErrorCode = null;
            }
            IAlog.a("got onMediaPlayerLoadError with: " + inneractiveVideoError.description(), new Object[0]);
            if (inneractiveVideoError.getPlayerError().isFatal()) {
                inneractiveErrorCode = InneractiveErrorCode.SERVER_INVALID_RESPONSE;
                iVar = com.fyber.inneractive.sdk.flow.i.VIDEO_FATAL_ERROR;
            }
            if (inneractiveErrorCode == null) {
                inneractiveErrorCode = InneractiveErrorCode.SERVER_INVALID_RESPONSE;
                iVar = com.fyber.inneractive.sdk.flow.i.VIDEO_ERROR_UNSPECIFIED;
            }
        } else {
            inneractiveErrorCode = null;
        }
        if (z) {
            return;
        }
        this.e = null;
        com.fyber.inneractive.sdk.response.g gVar3 = this.c;
        if (gVar3 != null && (bVar = gVar3.O) != null) {
            this.e = (com.fyber.inneractive.sdk.model.vast.r) bVar.d.poll();
        }
        if (this.e == null) {
            InneractiveVideoError.Error playerError2 = new InneractiveVideoError(InneractiveVideoError.Error.ERROR_FAILED_PLAYING_ALL_MEDIA_FILES).getPlayerError();
            int i2 = r.f1637a[playerError2.ordinal()];
            if (i2 == 1) {
                tVar = com.fyber.inneractive.sdk.network.t.VAST_ERROR_NO_MEDIA_FILES;
            } else if (i2 == 2) {
                tVar = com.fyber.inneractive.sdk.network.t.VAST_ERROR_FAILED_PLAYING_MEDIA_FILE;
            } else if (i2 == 3) {
                tVar = com.fyber.inneractive.sdk.network.t.VAST_ERROR_FAILED_PLAYING_ALL_MEDIA_FILES;
            } else if (i2 == 4) {
                tVar = com.fyber.inneractive.sdk.network.t.VAST_ERROR_PRE_BUFFER_TIMEOUT;
            } else if (i2 != 5) {
                IAlog.a("IAReportError, Does not know player error " + playerError2.getErrorString(), new Object[0]);
                tVar = com.fyber.inneractive.sdk.network.t.VAST_UNKNOWN_PLAYER_ERROR;
            } else {
                tVar = com.fyber.inneractive.sdk.network.t.VAST_ERROR_BUFFER_TIMEOUT;
            }
            InneractiveAdRequest inneractiveAdRequest3 = this.b;
            com.fyber.inneractive.sdk.response.g gVar4 = this.c;
            JSONArray b3 = this.h.b();
            w wVar3 = new w(gVar4);
            wVar3.b = tVar;
            wVar3.f1340a = inneractiveAdRequest3;
            wVar3.d = b3;
            wVar3.a((String) null);
            s sVar = this.d;
            if (sVar != null) {
                if (inneractiveVideoError != null) {
                    InneractiveInfrastructureError inneractiveInfrastructureError = new InneractiveInfrastructureError(inneractiveErrorCode, iVar, inneractiveVideoError.getCause());
                    u uVar = (u) sVar;
                    uVar.b(inneractiveInfrastructureError);
                    uVar.a(inneractiveInfrastructureError);
                    return;
                }
                InneractiveInfrastructureError inneractiveInfrastructureError2 = new InneractiveInfrastructureError(inneractiveErrorCode, com.fyber.inneractive.sdk.flow.i.VIDEO_ERROR_NULL);
                u uVar2 = (u) sVar;
                uVar2.b(inneractiveInfrastructureError2);
                uVar2.a(inneractiveInfrastructureError2);
                return;
            }
            return;
        }
        if (this.g) {
            return;
        }
        b();
        a();
    }

    public final void a(String str, String... strArr) {
        a aVar = this.f;
        if (aVar != null) {
            n nVar = (n) aVar;
            if ("TRACKING_COMPLETED".equalsIgnoreCase(str)) {
                nVar.r = true;
                return;
            }
            if ("EVENT_TRACKING".equalsIgnoreCase(str)) {
                for (String str2 : strArr) {
                    nVar.a(nVar.p, VideoClickOrigin.InvalidOrigin, x.a(str2));
                }
            }
        }
    }
}
