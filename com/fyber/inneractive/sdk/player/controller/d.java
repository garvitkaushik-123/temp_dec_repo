package com.fyber.inneractive.sdk.player.controller;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.WebSettings;
import com.fyber.inneractive.sdk.R;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.external.InneractiveInfrastructureError;
import com.fyber.inneractive.sdk.ui.IAmraidWebViewController;
import com.fyber.inneractive.sdk.util.f1;
import com.fyber.inneractive.sdk.util.j0;
import com.fyber.inneractive.sdk.web.i1;

/* loaded from: classes4.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public i1 f1359a;
    public final com.fyber.inneractive.sdk.web.c0 b;
    public final UnitDisplayType c;
    public final com.fyber.inneractive.sdk.web.z d;
    public final boolean e;

    public d(Context context, com.fyber.inneractive.sdk.flow.vast.a aVar, com.fyber.inneractive.sdk.model.vast.i iVar, com.fyber.inneractive.sdk.flow.endcard.q qVar) {
        this.b = com.fyber.inneractive.sdk.web.c0.INLINE;
        com.fyber.inneractive.sdk.web.z zVar = com.fyber.inneractive.sdk.web.z.ENABLED;
        this.d = zVar;
        UnitDisplayType unitDisplayType = aVar.f1243a;
        boolean z = aVar.b;
        this.c = unitDisplayType;
        this.e = z;
        int i = c.f1357a[unitDisplayType.ordinal()];
        if (i == 1 || i == 2) {
            this.d = zVar;
            if (z) {
                this.b = com.fyber.inneractive.sdk.web.c0.INTERSTITIAL;
            }
        } else {
            this.d = zVar;
        }
        try {
            UnitDisplayType unitDisplayType2 = aVar.f1243a;
            boolean z2 = !(unitDisplayType2 == null || unitDisplayType2.isFullscreenUnit()) || IAConfigManager.O.u.b.a(true, "use_fraud_detection_fullscreen");
            i1 bVar = iVar == com.fyber.inneractive.sdk.model.vast.i.FMP_End_Card ? new com.fyber.inneractive.sdk.web.b(qVar, z2) : new IAmraidWebViewController(z2, this.b, this.d, com.fyber.inneractive.sdk.web.d0.AD_CONTROLLED, true, null, null);
            this.f1359a = bVar;
            com.fyber.inneractive.sdk.web.m mVar = bVar.b;
            if (mVar != null) {
                int i2 = c.b[iVar.ordinal()];
                if (i2 == 1) {
                    mVar.setId(R.id.ia_inneractive_vast_endcard_static);
                } else if (i2 == 2) {
                    mVar.setId(R.id.ia_inneractive_vast_endcard_html);
                } else if (i2 == 3) {
                    mVar.setId(R.id.ia_inneractive_vast_endcard_html);
                } else if (i2 == 4) {
                    mVar.setId(R.id.ia_inneractive_vast_endcard_iframe);
                }
            }
            i1 i1Var = this.f1359a;
            com.fyber.inneractive.sdk.web.m mVar2 = i1Var.b;
            if (mVar2 != null) {
                j0.f1762a.a(context, mVar2, i1Var);
            }
            i1 i1Var2 = this.f1359a;
            i1Var2.b.setTapListener(i1Var2);
            f1 a2 = com.fyber.inneractive.sdk.renderers.k.a(aVar.c, aVar.d, aVar.e);
            this.f1359a.setAdDefaultSize(a2.f1758a, a2.b);
        } catch (Throwable unused) {
            this.f1359a = null;
        }
    }

    public final void a(String str, com.fyber.inneractive.sdk.web.g gVar, boolean z) {
        com.fyber.inneractive.sdk.flow.x xVar;
        if (this.f1359a == null || TextUtils.isEmpty(str)) {
            gVar.a(null, new InneractiveInfrastructureError(InneractiveErrorCode.UNSPECIFIED, com.fyber.inneractive.sdk.flow.i.NO_WEBVIEW_CONTROLLER_AVAILABLE));
            return;
        }
        i1 i1Var = this.f1359a;
        UnitDisplayType unitDisplayType = this.c;
        boolean z2 = false;
        i1Var.setAutoplayMRAIDVideos(unitDisplayType != null && unitDisplayType.isFullscreenUnit());
        this.f1359a.setCenteringTagsRequired(false);
        i1 i1Var2 = this.f1359a;
        if (i1Var2 != null && (xVar = i1Var2.s) != null && (IAConfigManager.O.k || xVar.f)) {
            z2 = true;
        }
        i1Var2.setMuteMraidVideo(z2);
        i1 i1Var3 = this.f1359a;
        int i = com.fyber.inneractive.sdk.config.k.f1102a;
        String property = System.getProperty("ia.testEnvironmentConfiguration.name");
        String str2 = TextUtils.isEmpty(property) ? "wv.inner-active.mobi/simpleM2M/" : property + ".inner-active.mobi/simpleM2M/";
        UnitDisplayType unitDisplayType2 = this.c;
        boolean z3 = this.e;
        StringBuilder sb = new StringBuilder();
        if (unitDisplayType2 != null && unitDisplayType2.isFullscreenUnit() && !z3) {
            sb.append("<script type=\"text/javascript\">  var IaCloseBtnHelper = (function initIaCloseBtnHelper(){    var styleContent = '.celtra-close-button {display:none !important;} .close-button {display:none !important;}';    function getStyle(doc){      var style = doc.createElement('style');      style.type = 'text/css';      if (style.styleSheet){        style.styleSheet.cssText = styleContent;      } else {        style.appendChild(doc.createTextNode(styleContent));      }      return style;    }    function onDomReady(){      var iframes = window.document.getElementsByTagName('iframe'),          i = 0,          len = iframes && iframes.length || 0;      for(; i < len; ++i){        if(!iframes[i].src){          try {            iframes[i].contentDocument.body.appendChild(getStyle(iframes[i].contentDocument));          }catch(e){          }}}}    function registerWindowEvents(){      window.addEventListener('load', function onWindowLoad(){        window.removeEventListener('load', onWindowLoad);        onDomReady();      });    }    return {      init: function init(){        if(window.document.readyState != 'complete'){          registerWindowEvents();        }else{          onDomReady();        }}}})();  IaCloseBtnHelper.init();</script>");
        }
        String sb2 = sb.toString();
        UnitDisplayType unitDisplayType3 = this.c;
        StringBuilder sb3 = new StringBuilder();
        if (unitDisplayType3 != null && !unitDisplayType3.isFullscreenUnit()) {
            if (unitDisplayType3 == UnitDisplayType.BANNER) {
                sb3.append(" body {display: flex;} #iawrapper { position:unset !important; display: unset !important; } ");
            } else {
                sb3.append(" #iawrapper { position:unset !important; display: unset !important; }");
            }
        }
        String sb4 = sb3.toString();
        i1Var3.f = gVar;
        try {
            i1Var3.h();
            com.fyber.inneractive.sdk.web.e eVar = new com.fyber.inneractive.sdk.web.e(i1Var3, str, z, sb2, sb4, str2);
            i1Var3.o = eVar;
            eVar.a().post(new com.fyber.inneractive.sdk.util.c(eVar));
        } catch (Throwable th) {
            InneractiveInfrastructureError inneractiveInfrastructureError = new InneractiveInfrastructureError(InneractiveErrorCode.SDK_INTERNAL_ERROR, com.fyber.inneractive.sdk.flow.i.COULD_NOT_CONFIGURE_WEBVIEW, th);
            com.fyber.inneractive.sdk.web.g gVar2 = i1Var3.f;
            if (gVar2 != null) {
                gVar2.a(i1Var3, inneractiveInfrastructureError);
            }
            i1Var3.b(true);
        }
    }

    public final void a() {
        com.fyber.inneractive.sdk.web.m mVar;
        i1 i1Var = this.f1359a;
        if (i1Var == null || (mVar = i1Var.b) == null) {
            return;
        }
        WebSettings settings = mVar.getSettings();
        settings.setMediaPlaybackRequiresUserGesture(false);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
    }
}
