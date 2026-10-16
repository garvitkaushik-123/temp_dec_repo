package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzdrs {
    public static final zzfyq zza;
    public static final zzfyq zzb;
    private final String zzc;
    private final zzdrr zzd;
    private final zzdrr zze;

    static {
        zzdrr zzdrrVar = zzdrr.PUBLIC_API_CALL;
        zzdrr zzdrrVar2 = zzdrr.PUBLIC_API_CALLBACK;
        zzdrs zzdrsVar = new zzdrs("tqgt", zzdrrVar, zzdrrVar2);
        zzdrr zzdrrVar3 = zzdrr.DYNAMITE_ENTER;
        zzdrs zzdrsVar2 = new zzdrs("l.dl", zzdrrVar, zzdrrVar3);
        zzdrr zzdrrVar4 = zzdrr.READ_FROM_DISK_START;
        zzdrs zzdrsVar3 = new zzdrs("l.rccde", zzdrrVar3, zzdrrVar4);
        zzdrs zzdrsVar4 = new zzdrs("l.rfd", zzdrrVar4, zzdrr.READ_FROM_DISK_END);
        zzdrr zzdrrVar5 = zzdrr.CLIENT_SIGNALS_START;
        zzdrs zzdrsVar5 = new zzdrs("l.rcc", zzdrrVar3, zzdrrVar5);
        zzdrr zzdrrVar6 = zzdrr.CLIENT_SIGNALS_END;
        zzdrs zzdrsVar6 = new zzdrs("l.cs", zzdrrVar5, zzdrrVar6);
        zzdrs zzdrsVar7 = new zzdrs("l.cts", zzdrrVar6, zzdrr.SERVICE_CONNECTED);
        zzdrr zzdrrVar7 = zzdrr.GMS_SIGNALS_START;
        zzdrr zzdrrVar8 = zzdrr.GMS_SIGNALS_END;
        zzdrs zzdrsVar8 = new zzdrs("l.gs", zzdrrVar7, zzdrrVar8);
        zzdrr zzdrrVar9 = zzdrr.GET_SIGNALS_SDKCORE_START;
        zzdrs zzdrsVar9 = new zzdrs("l.jse", zzdrrVar8, zzdrrVar9);
        zzdrr zzdrrVar10 = zzdrr.GET_SIGNALS_SDKCORE_END;
        zzdrs zzdrsVar10 = new zzdrs("l.gs-sdkcore", zzdrrVar9, zzdrrVar10);
        zzdrs zzdrsVar11 = new zzdrs("l.gs-pp", zzdrrVar10, zzdrrVar2);
        zzdrr zzdrrVar11 = zzdrr.RENDERING_START;
        zzdrs zzdrsVar12 = new zzdrs("l.render", zzdrrVar11, zzdrrVar2);
        zzdrr zzdrrVar12 = zzdrr.RENDERING_WEBVIEW_CREATION_START;
        zzdrs zzdrsVar13 = new zzdrs("l.render.pre", zzdrrVar11, zzdrrVar12);
        zzdrr zzdrrVar13 = zzdrr.RENDERING_WEBVIEW_CREATION_END;
        zzdrs zzdrsVar14 = new zzdrs("l.render.wvc", zzdrrVar12, zzdrrVar13);
        zzdrs zzdrsVar15 = new zzdrs("l.render.acc", zzdrrVar13, zzdrr.RENDERING_AD_COMPONENT_CREATION_END);
        zzdrs zzdrsVar16 = new zzdrs("l.render.cfg-wv", zzdrr.RENDERING_CONFIGURE_WEBVIEW_START, zzdrr.RENDERING_CONFIGURE_WEBVIEW_END);
        zzdrr zzdrrVar14 = zzdrr.RENDERING_WEBVIEW_LOAD_HTML_START;
        zzdrr zzdrrVar15 = zzdrr.RENDERING_WEBVIEW_LOAD_HTML_END;
        zza = zzfyq.zzt(zzdrsVar, zzdrsVar2, zzdrsVar3, zzdrsVar4, zzdrsVar5, zzdrsVar6, zzdrsVar7, zzdrsVar8, zzdrsVar9, zzdrsVar10, zzdrsVar11, zzdrsVar12, zzdrsVar13, zzdrsVar14, zzdrsVar15, zzdrsVar16, new zzdrs("l.render.wvlh", zzdrrVar14, zzdrrVar15), new zzdrs("l.render.post", zzdrrVar15, zzdrrVar2), new zzdrs("l.sodv", zzdrr.SIGNAL_ON_DISK_VALIDATION_START, zzdrr.SIGNAL_ON_DISK_VALIDATION_END), new zzdrs("l.sodck", zzdrr.SIGNAL_ON_DISK_CACHE_KEY_START, zzdrr.SIGNAL_ON_DISK_CACHE_KEY_END), new zzdrs("l.sodrar", zzdrr.SIGNAL_ON_DISK_READ_AND_REMOVE_START, zzdrr.SIGNAL_ON_DISK_READ_AND_REMOVE_END), new zzdrs("l.soddc", zzdrr.SIGNAL_ON_DISK_DECODE_START, zzdrr.SIGNAL_ON_DISK_DECODE_END));
        zzdrr zzdrrVar16 = zzdrr.PUBLIC_API_CALL;
        zzdrr zzdrrVar17 = zzdrr.PUBLIC_API_CALLBACK;
        zzdrs zzdrsVar17 = new zzdrs("l.al", zzdrrVar16, zzdrrVar17);
        zzdrr zzdrrVar18 = zzdrr.DYNAMITE_ENTER;
        zzdrs zzdrsVar18 = new zzdrs("l.al2", zzdrrVar18, zzdrrVar17);
        zzdrs zzdrsVar19 = new zzdrs("l.dl", zzdrrVar16, zzdrrVar18);
        zzdrr zzdrrVar19 = zzdrr.CLIENT_SIGNALS_START;
        zzdrs zzdrsVar20 = new zzdrs("l.rcc", zzdrrVar18, zzdrrVar19);
        zzdrr zzdrrVar20 = zzdrr.CLIENT_SIGNALS_END;
        zzdrs zzdrsVar21 = new zzdrs("l.cs", zzdrrVar19, zzdrrVar20);
        zzdrs zzdrsVar22 = new zzdrs("l.cts", zzdrrVar20, zzdrr.SERVICE_CONNECTED);
        zzdrr zzdrrVar21 = zzdrr.GMS_SIGNALS_START;
        zzdrr zzdrrVar22 = zzdrr.GMS_SIGNALS_END;
        zzdrs zzdrsVar23 = new zzdrs("l.gs", zzdrrVar21, zzdrrVar22);
        zzdrr zzdrrVar23 = zzdrr.GET_AD_DICTIONARY_SDKCORE_START;
        zzdrs zzdrsVar24 = new zzdrs("l.jse", zzdrrVar22, zzdrrVar23);
        zzdrr zzdrrVar24 = zzdrr.GET_AD_DICTIONARY_SDKCORE_END;
        zzdrs zzdrsVar25 = new zzdrs("l.gad-js", zzdrrVar23, zzdrrVar24);
        zzdrr zzdrrVar25 = zzdrr.HTTP_RESPONSE_READY;
        zzdrs zzdrsVar26 = new zzdrs("l.http", zzdrrVar24, zzdrrVar25);
        zzdrr zzdrrVar26 = zzdrr.SCAR_PRELOADER_READY;
        zzdrs zzdrsVar27 = new zzdrs("l.slas.pre", zzdrrVar16, zzdrrVar26);
        zzdrr zzdrrVar27 = zzdrr.SCAR_PRELOADER_PROCESSING_DONE;
        zzdrs zzdrsVar28 = new zzdrs("l.slas.prel.p", zzdrrVar26, zzdrrVar27);
        zzdrr zzdrrVar28 = zzdrr.NORMALIZATION_AD_RESPONSE_START;
        zzdrs zzdrsVar29 = new zzdrs("l.jse-nml", zzdrrVar25, zzdrrVar28);
        zzdrs zzdrsVar30 = new zzdrs("l.jse-nml", zzdrrVar27, zzdrrVar28);
        zzdrr zzdrrVar29 = zzdrr.NORMALIZATION_AD_RESPONSE_END;
        zzdrs zzdrsVar31 = new zzdrs("l.nml-js", zzdrrVar28, zzdrrVar29);
        zzdrr zzdrrVar30 = zzdrr.BINDER_CALL_START;
        zzdrs zzdrsVar32 = new zzdrs("l.nml-gmsg", zzdrrVar29, zzdrrVar30);
        zzdrr zzdrrVar31 = zzdrr.SERVER_RESPONSE_PARSE_START;
        zzdrs zzdrsVar33 = new zzdrs("l.nml-gmsg.s2s", zzdrrVar29, zzdrrVar31);
        zzdrs zzdrsVar34 = new zzdrs("l.binder", zzdrrVar30, zzdrrVar31);
        zzdrr zzdrrVar32 = zzdrr.RENDERING_START;
        zzdrs zzdrsVar35 = new zzdrs("l.sr", zzdrrVar31, zzdrrVar32);
        zzdrs zzdrsVar36 = new zzdrs("l.render", zzdrrVar32, zzdrrVar17);
        zzdrs zzdrsVar37 = new zzdrs("l.t2", zzdrr.RENDERING_ADSTRING_TYPE2_FETCH_START, zzdrr.RENDERING_ADSTRING_TYPE2_FETCH_END);
        zzdrr zzdrrVar33 = zzdrr.RENDERING_NATIVE_ADS_NATIVE_JS_WEBVIEW_START;
        zzdrr zzdrrVar34 = zzdrr.RENDERING_NATIVE_ADS_PREPROCESS_START;
        zzdrs zzdrsVar38 = new zzdrs("l.render.na.js", zzdrrVar33, zzdrrVar34);
        zzdrs zzdrsVar39 = new zzdrs("l.render.na.prep", zzdrrVar34, zzdrr.RENDERING_NATIVE_ADS_PREPROCESS_END);
        zzdrs zzdrsVar40 = new zzdrs("l.render.na.lna", zzdrr.RENDERING_NATIVE_ASSETS_LOADING_START, zzdrr.RENDERING_NATIVE_ASSETS_LOADING_END);
        zzdrr zzdrrVar35 = zzdrr.RENDERING_WEBVIEW_CREATION_START;
        zzdrr zzdrrVar36 = zzdrr.RENDERING_WEBVIEW_CREATION_END;
        zzdrs zzdrsVar41 = new zzdrs("l.render.wvc", zzdrrVar35, zzdrrVar36);
        zzdrs zzdrsVar42 = new zzdrs("l.render.acc", zzdrrVar36, zzdrr.RENDERING_AD_COMPONENT_CREATION_END);
        zzdrr zzdrrVar37 = zzdrr.RENDERING_CONFIGURE_WEBVIEW_START;
        zzdrr zzdrrVar38 = zzdrr.RENDERING_CONFIGURE_WEBVIEW_END;
        zzdrs zzdrsVar43 = new zzdrs("l.render.cfg-wv", zzdrrVar37, zzdrrVar38);
        zzdrs zzdrsVar44 = new zzdrs("l.render.pre", zzdrrVar32, zzdrrVar35);
        zzdrr zzdrrVar39 = zzdrr.RENDERING_WEBVIEW_LOAD_HTML_END;
        zzdrs zzdrsVar45 = new zzdrs("l.render.post", zzdrrVar39, zzdrrVar17);
        zzdrs zzdrsVar46 = new zzdrs("l.render.na.post", zzdrrVar38, zzdrrVar17);
        zzdrs zzdrsVar47 = new zzdrs("l.render.wvlh", zzdrr.RENDERING_WEBVIEW_LOAD_HTML_START, zzdrrVar39);
        zzdrs zzdrsVar48 = new zzdrs("l.na.b", zzdrr.NATIVE_ASSETS_LOADING_BASIC_START, zzdrr.NATIVE_ASSETS_LOADING_BASIC_END);
        zzdrs zzdrsVar49 = new zzdrs("l.na.im", zzdrr.NATIVE_ASSETS_LOADING_IMAGE_START, zzdrr.NATIVE_ASSETS_LOADING_IMAGE_END);
        zzdrs zzdrsVar50 = new zzdrs("l.na.imc", zzdrr.NATIVE_ASSETS_LOADING_IMAGE_COMPOSITION_START, zzdrr.NATIVE_ASSETS_LOADING_IMAGE_COMPOSITION_END);
        zzdrs zzdrsVar51 = new zzdrs("l.na.l", zzdrr.NATIVE_ASSETS_LOADING_LOGO_START, zzdrr.NATIVE_ASSETS_LOADING_LOGO_END);
        zzdrs zzdrsVar52 = new zzdrs("l.na.ic", zzdrr.NATIVE_ASSETS_LOADING_ICON_START, zzdrr.NATIVE_ASSETS_LOADING_ICON_END);
        zzdrs zzdrsVar53 = new zzdrs("l.na.a", zzdrr.NATIVE_ASSETS_LOADING_ATTRIBUTION_START, zzdrr.NATIVE_ASSETS_LOADING_ATTRIBUTION_END);
        zzdrr zzdrrVar40 = zzdrr.NATIVE_ASSETS_LOADING_VIDEO_START;
        zzdrr zzdrrVar41 = zzdrr.NATIVE_ASSETS_LOADING_VIDEO_END;
        zzb = zzfyq.zzt(zzdrsVar17, zzdrsVar18, zzdrsVar19, zzdrsVar20, zzdrsVar21, zzdrsVar22, zzdrsVar23, zzdrsVar24, zzdrsVar25, zzdrsVar26, zzdrsVar27, zzdrsVar28, zzdrsVar29, zzdrsVar30, zzdrsVar31, zzdrsVar32, zzdrsVar33, zzdrsVar34, zzdrsVar35, zzdrsVar36, zzdrsVar37, zzdrsVar38, zzdrsVar39, zzdrsVar40, zzdrsVar41, zzdrsVar42, zzdrsVar43, zzdrsVar44, zzdrsVar45, zzdrsVar46, zzdrsVar47, zzdrsVar48, zzdrsVar49, zzdrsVar50, zzdrsVar51, zzdrsVar52, zzdrsVar53, new zzdrs("l.na.v", zzdrrVar40, zzdrrVar41), new zzdrs("l.na.vc", zzdrr.NATIVE_ASSETS_LOADING_VIDEO_COMPOSITION_START, zzdrrVar41), new zzdrs("l.na.m", zzdrr.NATIVE_ASSETS_LOADING_MEDIA_START, zzdrr.NATIVE_ASSETS_LOADING_MEDIA_END), new zzdrs("l.na.c", zzdrr.NATIVE_ASSETS_LOADING_CUSTOM_START, zzdrr.NATIVE_ASSETS_LOADING_CUSTOM_END), new zzdrs("l.na.o", zzdrr.NATIVE_ASSETS_LOADING_OMID_START, zzdrr.NATIVE_ASSETS_LOADING_OMID_END));
    }

    public zzdrs(String str, zzdrr zzdrrVar, zzdrr zzdrrVar2) {
        this.zzc = str;
        this.zzd = zzdrrVar;
        this.zze = zzdrrVar2;
    }

    public final zzdrr zza() {
        return this.zzd;
    }

    public final zzdrr zzb() {
        return this.zze;
    }

    public final String zzc() {
        return this.zzc;
    }
}
