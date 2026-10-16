package com.fyber.inneractive.sdk.flow;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.external.InneractiveInfrastructureError;
import com.fyber.inneractive.sdk.ui.IAmraidWebViewController;
import com.fyber.inneractive.sdk.util.IAlog;
import com.iab.omid.library.fyber.adsession.AdSession;

/* loaded from: classes4.dex */
public final class s extends k {
    public IAmraidWebViewController m;
    public final q n = new q(this);

    @Override // com.fyber.inneractive.sdk.flow.k
    public final InneractiveInfrastructureError c() {
        com.fyber.inneractive.sdk.network.timeouts.content.a aVar = this.j;
        if (aVar != null) {
            int i = this.i;
            if (aVar.g) {
                i = aVar.f1338a - i;
            }
            r1 = (i == aVar.f1338a ? aVar.h : 0) + (aVar.b * i) + aVar.d;
        }
        return new InneractiveInfrastructureError(InneractiveErrorCode.LOAD_TIMEOUT, i.WEBVIEW_LOAD_TIMEOUT, new Exception("LoadTimeout after " + r1 + " ms"));
    }

    @Override // com.fyber.inneractive.sdk.flow.k
    public final String d() {
        return "send_failed_display_creatives";
    }

    @Override // com.fyber.inneractive.sdk.flow.k
    public final void g() {
        com.fyber.inneractive.sdk.web.z zVar;
        String str;
        o0 o0Var = new o0(e(), this.g);
        this.c = o0Var;
        com.fyber.inneractive.sdk.response.e eVar = this.b;
        com.fyber.inneractive.sdk.response.f fVar = (com.fyber.inneractive.sdk.response.f) eVar;
        o0Var.b = fVar;
        o0Var.f = this.h;
        com.fyber.inneractive.sdk.measurement.e eVar2 = null;
        UnitDisplayType unitDisplayType = eVar != null ? fVar.p : null;
        com.fyber.inneractive.sdk.web.c0 c0Var = com.fyber.inneractive.sdk.web.c0.INLINE;
        if (unitDisplayType == null) {
            this.n.a(null, new InneractiveInfrastructureError(InneractiveErrorCode.SDK_INTERNAL_ERROR, i.EMPTY_UNIT_DISPLAY_TYPE, new Exception("Unit display type was not found")));
            return;
        }
        int i = r.f1214a[unitDisplayType.ordinal()];
        if (i == 1 || i == 2) {
            zVar = com.fyber.inneractive.sdk.web.z.ENABLED;
            InneractiveAdRequest inneractiveAdRequest = this.f1207a;
            if (inneractiveAdRequest == null || inneractiveAdRequest.getAllowFullscreen()) {
                c0Var = com.fyber.inneractive.sdk.web.c0.INTERSTITIAL;
            }
        } else {
            zVar = com.fyber.inneractive.sdk.web.z.ENABLED;
        }
        com.fyber.inneractive.sdk.web.c0 c0Var2 = c0Var;
        com.fyber.inneractive.sdk.web.z zVar2 = zVar;
        com.fyber.inneractive.sdk.response.e eVar3 = this.b;
        boolean z = (eVar3 == null || (str = ((com.fyber.inneractive.sdk.response.f) eVar3).N) == null || str.contains("iaNotifyLoadFinished")) ? false : true;
        IAConfigManager iAConfigManager = IAConfigManager.O;
        boolean z2 = !unitDisplayType.isFullscreenUnit() || iAConfigManager.u.b.a(true, "use_fraud_detection_fullscreen");
        try {
            com.fyber.inneractive.sdk.web.d0 d0Var = com.fyber.inneractive.sdk.web.d0.AD_CONTROLLED;
            com.fyber.inneractive.sdk.config.global.r rVar = this.g;
            if (rVar != null) {
                Boolean c = ((com.fyber.inneractive.sdk.config.global.features.l) rVar.a(com.fyber.inneractive.sdk.config.global.features.l.class)).c(com.ironsource.mediationsdk.metadata.a.j);
                boolean booleanValue = c != null ? c.booleanValue() : false;
                IAlog.a("OMSDK AB %s", String.valueOf(booleanValue));
                if (booleanValue) {
                    eVar2 = iAConfigManager.K;
                }
            }
            IAmraidWebViewController iAmraidWebViewController = new IAmraidWebViewController(z2, c0Var2, zVar2, d0Var, z, eVar2, this.g);
            this.m = iAmraidWebViewController;
            iAmraidWebViewController.setAdContent(this.c);
            this.m.setAdRequest(this.f1207a);
            IAmraidWebViewController iAmraidWebViewController2 = this.m;
            o0 o0Var2 = (o0) this.c;
            o0Var2.getClass();
            iAmraidWebViewController2.setMuteMraidVideo(iAConfigManager.k || o0Var2.f);
            ((o0) this.c).i = this.m;
            com.fyber.inneractive.sdk.response.e eVar4 = this.b;
            if (eVar4 != null) {
                UnitDisplayType unitDisplayType2 = ((com.fyber.inneractive.sdk.response.f) eVar4).p;
                InneractiveAdRequest inneractiveAdRequest2 = this.f1207a;
                boolean z3 = inneractiveAdRequest2 == null || inneractiveAdRequest2.getAllowFullscreen();
                StringBuilder sb = new StringBuilder();
                if (unitDisplayType2 != null && unitDisplayType2.isFullscreenUnit() && !z3) {
                    sb.append("<script type=\"text/javascript\">  var IaCloseBtnHelper = (function initIaCloseBtnHelper(){    var styleContent = '.celtra-close-button {display:none !important;} .close-button {display:none !important;}';    function getStyle(doc){      var style = doc.createElement('style');      style.type = 'text/css';      if (style.styleSheet){        style.styleSheet.cssText = styleContent;      } else {        style.appendChild(doc.createTextNode(styleContent));      }      return style;    }    function onDomReady(){      var iframes = window.document.getElementsByTagName('iframe'),          i = 0,          len = iframes && iframes.length || 0;      for(; i < len; ++i){        if(!iframes[i].src){          try {            iframes[i].contentDocument.body.appendChild(getStyle(iframes[i].contentDocument));          }catch(e){          }}}}    function registerWindowEvents(){      window.addEventListener('load', function onWindowLoad(){        window.removeEventListener('load', onWindowLoad);        onDomReady();      });    }    return {      init: function init(){        if(window.document.readyState != 'complete'){          registerWindowEvents();        }else{          onDomReady();        }}}})();  IaCloseBtnHelper.init();</script>");
                }
                String sb2 = sb.toString();
                StringBuilder sb3 = new StringBuilder();
                if (unitDisplayType2 != null && !unitDisplayType2.isFullscreenUnit()) {
                    if (unitDisplayType2 == UnitDisplayType.BANNER) {
                        sb3.append(" body {display: flex;} #iawrapper { position:unset !important; display: unset !important; } ");
                    } else {
                        sb3.append(" #iawrapper { position:unset !important; display: unset !important; }");
                    }
                }
                String sb4 = sb3.toString();
                this.m.setAutoplayMRAIDVideos(unitDisplayType.isFullscreenUnit() || UnitDisplayType.MRECT.equals(unitDisplayType));
                IAmraidWebViewController iAmraidWebViewController3 = this.m;
                int i2 = com.fyber.inneractive.sdk.config.k.f1102a;
                String property = System.getProperty("ia.testEnvironmentConfiguration.name");
                String str2 = TextUtils.isEmpty(property) ? "wv.inner-active.mobi/simpleM2M/" : property + ".inner-active.mobi/simpleM2M/";
                String str3 = "" + ((com.fyber.inneractive.sdk.response.f) this.b).N;
                iAmraidWebViewController3.f = this.n;
                try {
                    iAmraidWebViewController3.h();
                    com.fyber.inneractive.sdk.web.e eVar5 = new com.fyber.inneractive.sdk.web.e(iAmraidWebViewController3, str3, true, sb2, sb4, str2);
                    iAmraidWebViewController3.o = eVar5;
                    eVar5.a().post(new com.fyber.inneractive.sdk.util.c(eVar5));
                } catch (Throwable th) {
                    InneractiveInfrastructureError inneractiveInfrastructureError = new InneractiveInfrastructureError(InneractiveErrorCode.SDK_INTERNAL_ERROR, i.COULD_NOT_CONFIGURE_WEBVIEW, th);
                    com.fyber.inneractive.sdk.web.g gVar = iAmraidWebViewController3.f;
                    if (gVar != null) {
                        gVar.a(iAmraidWebViewController3, inneractiveInfrastructureError);
                    }
                    iAmraidWebViewController3.b(true);
                }
            }
        } catch (Throwable th2) {
            a(new InneractiveInfrastructureError(InneractiveErrorCode.SDK_INTERNAL_ERROR, i.COULD_NOT_CREATE_WEBVIEW_CONTROLLER, th2));
        }
    }

    @Override // com.fyber.inneractive.sdk.flow.k, com.fyber.inneractive.sdk.interfaces.b
    public final void a() {
        IAmraidWebViewController iAmraidWebViewController;
        AdSession adSession;
        IAlog.a("%s : IAMraidContentLoader : destroyController", IAlog.a(this));
        if (this.c != null && (iAmraidWebViewController = this.m) != null) {
            com.fyber.inneractive.sdk.measurement.tracker.e eVar = iAmraidWebViewController.I;
            if (eVar != null && (adSession = eVar.f1273a) != null) {
                try {
                    adSession.finish();
                } catch (Throwable unused) {
                }
                com.fyber.inneractive.sdk.util.r.b.postDelayed(new com.fyber.inneractive.sdk.measurement.tracker.c(eVar), 1000);
                eVar.f1273a = null;
                eVar.b = null;
            }
            this.m.e();
            this.m = null;
        }
        super.a();
    }

    @Override // com.fyber.inneractive.sdk.flow.k, com.fyber.inneractive.sdk.interfaces.c
    public final void cancel() {
        IAmraidWebViewController iAmraidWebViewController;
        AdSession adSession;
        IAlog.a("%s : IAMraidContentLoader : destroyController", IAlog.a(this));
        if (this.c != null && (iAmraidWebViewController = this.m) != null) {
            com.fyber.inneractive.sdk.measurement.tracker.e eVar = iAmraidWebViewController.I;
            if (eVar != null && (adSession = eVar.f1273a) != null) {
                try {
                    adSession.finish();
                } catch (Throwable unused) {
                }
                com.fyber.inneractive.sdk.util.r.b.postDelayed(new com.fyber.inneractive.sdk.measurement.tracker.c(eVar), 1000);
                eVar.f1273a = null;
                eVar.b = null;
            }
            this.m.e();
            this.m = null;
        }
        this.k.a();
        IAlog.a("%s: IAAdContentLoaderImpl : cancel load ad content retry task", IAlog.a(this));
        com.fyber.inneractive.sdk.util.r.b.removeCallbacks(this.l);
        this.f1207a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
    }
}
