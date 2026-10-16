package io.adn.sdk.internal.data.dto;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: BidResponseDto.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001d\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b:\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 k2\u00020\u0001:\u0002jkB\u0095\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u001e\u0010\u001fB©\u0002\b\u0010\u0012\u0006\u0010 \u001a\u00020!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\"\u001a\u0004\u0018\u00010#¢\u0006\u0004\b\u001e\u0010$J\u000b\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010Y\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010Z\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010[\u001a\u0004\u0018\u00010\u0003HÆ\u0003JÍ\u0002\u0010\\\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÇ\u0001J\u0013\u0010]\u001a\u00020^2\b\u0010_\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010`\u001a\u00020!H×\u0001J\t\u0010a\u001a\u00020\u0003H×\u0001J%\u0010b\u001a\u00020c2\u0006\u0010d\u001a\u00020\u00002\u0006\u0010e\u001a\u00020f2\u0006\u0010g\u001a\u00020hH\u0001¢\u0006\u0002\biR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010&R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010&R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010&R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010&R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010&R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010&R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010&R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010&R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010&R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u0010&R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u0010&R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b2\u0010&R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b3\u0010&R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b4\u0010&R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b5\u0010&R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b6\u0010&R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b7\u0010&R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b8\u0010&R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b9\u0010&R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b:\u0010&R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b;\u0010&R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b<\u0010&R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b=\u0010&R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b>\u0010&R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b?\u0010&R\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b@\u0010&¨\u0006l"}, d2 = {"Lio/adn/sdk/internal/data/dto/CreativeConfigDto;", "", "cbc", "", "cbcr", "cbde", "cbp", "cbt", "cbs", "prbc", "prbp", "prbs", "ctabc", "ctabe", "ctabp", "ctabs", "ctatc", "mbc", "mbp", "mbs", "pbc", "pbe", "pbp", CampaignEx.KEY_ACTIVITY_PATH_AND_NAME, "skbdd", "skbs", "rd", "rs", "als", "lce", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCbc", "()Ljava/lang/String;", "getCbcr", "getCbde", "getCbp", "getCbt", "getCbs", "getPrbc", "getPrbp", "getPrbs", "getCtabc", "getCtabe", "getCtabp", "getCtabs", "getCtatc", "getMbc", "getMbp", "getMbs", "getPbc", "getPbe", "getPbp", "getAc", "getSkbdd", "getSkbs", "getRd", "getRs", "getAls", "getLce", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$adn_sdk_release", "$serializer", "Companion", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@Serializable
/* loaded from: classes7.dex */
public final /* data */ class CreativeConfigDto {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String ac;
    private final String als;
    private final String cbc;
    private final String cbcr;
    private final String cbde;
    private final String cbp;
    private final String cbs;
    private final String cbt;
    private final String ctabc;
    private final String ctabe;
    private final String ctabp;
    private final String ctabs;
    private final String ctatc;
    private final String lce;
    private final String mbc;
    private final String mbp;
    private final String mbs;
    private final String pbc;
    private final String pbe;
    private final String pbp;
    private final String prbc;
    private final String prbp;
    private final String prbs;
    private final String rd;
    private final String rs;
    private final String skbdd;
    private final String skbs;

    public static /* synthetic */ CreativeConfigDto copy$default(CreativeConfigDto creativeConfigDto, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, String str22, String str23, String str24, String str25, String str26, String str27, int i, Object obj) {
        String str28;
        String str29;
        String str30 = (i & 1) != 0 ? creativeConfigDto.cbc : str;
        String str31 = (i & 2) != 0 ? creativeConfigDto.cbcr : str2;
        String str32 = (i & 4) != 0 ? creativeConfigDto.cbde : str3;
        String str33 = (i & 8) != 0 ? creativeConfigDto.cbp : str4;
        String str34 = (i & 16) != 0 ? creativeConfigDto.cbt : str5;
        String str35 = (i & 32) != 0 ? creativeConfigDto.cbs : str6;
        String str36 = (i & 64) != 0 ? creativeConfigDto.prbc : str7;
        String str37 = (i & 128) != 0 ? creativeConfigDto.prbp : str8;
        String str38 = (i & 256) != 0 ? creativeConfigDto.prbs : str9;
        String str39 = (i & 512) != 0 ? creativeConfigDto.ctabc : str10;
        String str40 = (i & 1024) != 0 ? creativeConfigDto.ctabe : str11;
        String str41 = (i & 2048) != 0 ? creativeConfigDto.ctabp : str12;
        String str42 = (i & 4096) != 0 ? creativeConfigDto.ctabs : str13;
        String str43 = (i & 8192) != 0 ? creativeConfigDto.ctatc : str14;
        String str44 = str30;
        String str45 = (i & 16384) != 0 ? creativeConfigDto.mbc : str15;
        String str46 = (i & 32768) != 0 ? creativeConfigDto.mbp : str16;
        String str47 = (i & 65536) != 0 ? creativeConfigDto.mbs : str17;
        String str48 = (i & 131072) != 0 ? creativeConfigDto.pbc : str18;
        String str49 = (i & 262144) != 0 ? creativeConfigDto.pbe : str19;
        String str50 = (i & 524288) != 0 ? creativeConfigDto.pbp : str20;
        String str51 = (i & 1048576) != 0 ? creativeConfigDto.ac : str21;
        String str52 = (i & 2097152) != 0 ? creativeConfigDto.skbdd : str22;
        String str53 = (i & 4194304) != 0 ? creativeConfigDto.skbs : str23;
        String str54 = (i & 8388608) != 0 ? creativeConfigDto.rd : str24;
        String str55 = (i & 16777216) != 0 ? creativeConfigDto.rs : str25;
        String str56 = (i & 33554432) != 0 ? creativeConfigDto.als : str26;
        if ((i & 67108864) != 0) {
            str29 = str56;
            str28 = creativeConfigDto.lce;
        } else {
            str28 = str27;
            str29 = str56;
        }
        return creativeConfigDto.copy(str44, str31, str32, str33, str34, str35, str36, str37, str38, str39, str40, str41, str42, str43, str45, str46, str47, str48, str49, str50, str51, str52, str53, str54, str55, str29, str28);
    }

    /* renamed from: component1, reason: from getter */
    public final String getCbc() {
        return this.cbc;
    }

    /* renamed from: component10, reason: from getter */
    public final String getCtabc() {
        return this.ctabc;
    }

    /* renamed from: component11, reason: from getter */
    public final String getCtabe() {
        return this.ctabe;
    }

    /* renamed from: component12, reason: from getter */
    public final String getCtabp() {
        return this.ctabp;
    }

    /* renamed from: component13, reason: from getter */
    public final String getCtabs() {
        return this.ctabs;
    }

    /* renamed from: component14, reason: from getter */
    public final String getCtatc() {
        return this.ctatc;
    }

    /* renamed from: component15, reason: from getter */
    public final String getMbc() {
        return this.mbc;
    }

    /* renamed from: component16, reason: from getter */
    public final String getMbp() {
        return this.mbp;
    }

    /* renamed from: component17, reason: from getter */
    public final String getMbs() {
        return this.mbs;
    }

    /* renamed from: component18, reason: from getter */
    public final String getPbc() {
        return this.pbc;
    }

    /* renamed from: component19, reason: from getter */
    public final String getPbe() {
        return this.pbe;
    }

    /* renamed from: component2, reason: from getter */
    public final String getCbcr() {
        return this.cbcr;
    }

    /* renamed from: component20, reason: from getter */
    public final String getPbp() {
        return this.pbp;
    }

    /* renamed from: component21, reason: from getter */
    public final String getAc() {
        return this.ac;
    }

    /* renamed from: component22, reason: from getter */
    public final String getSkbdd() {
        return this.skbdd;
    }

    /* renamed from: component23, reason: from getter */
    public final String getSkbs() {
        return this.skbs;
    }

    /* renamed from: component24, reason: from getter */
    public final String getRd() {
        return this.rd;
    }

    /* renamed from: component25, reason: from getter */
    public final String getRs() {
        return this.rs;
    }

    /* renamed from: component26, reason: from getter */
    public final String getAls() {
        return this.als;
    }

    /* renamed from: component27, reason: from getter */
    public final String getLce() {
        return this.lce;
    }

    /* renamed from: component3, reason: from getter */
    public final String getCbde() {
        return this.cbde;
    }

    /* renamed from: component4, reason: from getter */
    public final String getCbp() {
        return this.cbp;
    }

    /* renamed from: component5, reason: from getter */
    public final String getCbt() {
        return this.cbt;
    }

    /* renamed from: component6, reason: from getter */
    public final String getCbs() {
        return this.cbs;
    }

    /* renamed from: component7, reason: from getter */
    public final String getPrbc() {
        return this.prbc;
    }

    /* renamed from: component8, reason: from getter */
    public final String getPrbp() {
        return this.prbp;
    }

    /* renamed from: component9, reason: from getter */
    public final String getPrbs() {
        return this.prbs;
    }

    public final CreativeConfigDto copy(String cbc, String cbcr, String cbde, String cbp, String cbt, String cbs, String prbc, String prbp, String prbs, String ctabc, String ctabe, String ctabp, String ctabs, String ctatc, String mbc, String mbp, String mbs, String pbc, String pbe, String pbp, String ac, String skbdd, String skbs, String rd, String rs, String als, String lce) {
        return new CreativeConfigDto(cbc, cbcr, cbde, cbp, cbt, cbs, prbc, prbp, prbs, ctabc, ctabe, ctabp, ctabs, ctatc, mbc, mbp, mbs, pbc, pbe, pbp, ac, skbdd, skbs, rd, rs, als, lce);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CreativeConfigDto)) {
            return false;
        }
        CreativeConfigDto creativeConfigDto = (CreativeConfigDto) other;
        return Intrinsics.areEqual(this.cbc, creativeConfigDto.cbc) && Intrinsics.areEqual(this.cbcr, creativeConfigDto.cbcr) && Intrinsics.areEqual(this.cbde, creativeConfigDto.cbde) && Intrinsics.areEqual(this.cbp, creativeConfigDto.cbp) && Intrinsics.areEqual(this.cbt, creativeConfigDto.cbt) && Intrinsics.areEqual(this.cbs, creativeConfigDto.cbs) && Intrinsics.areEqual(this.prbc, creativeConfigDto.prbc) && Intrinsics.areEqual(this.prbp, creativeConfigDto.prbp) && Intrinsics.areEqual(this.prbs, creativeConfigDto.prbs) && Intrinsics.areEqual(this.ctabc, creativeConfigDto.ctabc) && Intrinsics.areEqual(this.ctabe, creativeConfigDto.ctabe) && Intrinsics.areEqual(this.ctabp, creativeConfigDto.ctabp) && Intrinsics.areEqual(this.ctabs, creativeConfigDto.ctabs) && Intrinsics.areEqual(this.ctatc, creativeConfigDto.ctatc) && Intrinsics.areEqual(this.mbc, creativeConfigDto.mbc) && Intrinsics.areEqual(this.mbp, creativeConfigDto.mbp) && Intrinsics.areEqual(this.mbs, creativeConfigDto.mbs) && Intrinsics.areEqual(this.pbc, creativeConfigDto.pbc) && Intrinsics.areEqual(this.pbe, creativeConfigDto.pbe) && Intrinsics.areEqual(this.pbp, creativeConfigDto.pbp) && Intrinsics.areEqual(this.ac, creativeConfigDto.ac) && Intrinsics.areEqual(this.skbdd, creativeConfigDto.skbdd) && Intrinsics.areEqual(this.skbs, creativeConfigDto.skbs) && Intrinsics.areEqual(this.rd, creativeConfigDto.rd) && Intrinsics.areEqual(this.rs, creativeConfigDto.rs) && Intrinsics.areEqual(this.als, creativeConfigDto.als) && Intrinsics.areEqual(this.lce, creativeConfigDto.lce);
    }

    public int hashCode() {
        String str = this.cbc;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.cbcr;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.cbde;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.cbp;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.cbt;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.cbs;
        int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.prbc;
        int hashCode7 = (hashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.prbp;
        int hashCode8 = (hashCode7 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.prbs;
        int hashCode9 = (hashCode8 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.ctabc;
        int hashCode10 = (hashCode9 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.ctabe;
        int hashCode11 = (hashCode10 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.ctabp;
        int hashCode12 = (hashCode11 + (str12 == null ? 0 : str12.hashCode())) * 31;
        String str13 = this.ctabs;
        int hashCode13 = (hashCode12 + (str13 == null ? 0 : str13.hashCode())) * 31;
        String str14 = this.ctatc;
        int hashCode14 = (hashCode13 + (str14 == null ? 0 : str14.hashCode())) * 31;
        String str15 = this.mbc;
        int hashCode15 = (hashCode14 + (str15 == null ? 0 : str15.hashCode())) * 31;
        String str16 = this.mbp;
        int hashCode16 = (hashCode15 + (str16 == null ? 0 : str16.hashCode())) * 31;
        String str17 = this.mbs;
        int hashCode17 = (hashCode16 + (str17 == null ? 0 : str17.hashCode())) * 31;
        String str18 = this.pbc;
        int hashCode18 = (hashCode17 + (str18 == null ? 0 : str18.hashCode())) * 31;
        String str19 = this.pbe;
        int hashCode19 = (hashCode18 + (str19 == null ? 0 : str19.hashCode())) * 31;
        String str20 = this.pbp;
        int hashCode20 = (hashCode19 + (str20 == null ? 0 : str20.hashCode())) * 31;
        String str21 = this.ac;
        int hashCode21 = (hashCode20 + (str21 == null ? 0 : str21.hashCode())) * 31;
        String str22 = this.skbdd;
        int hashCode22 = (hashCode21 + (str22 == null ? 0 : str22.hashCode())) * 31;
        String str23 = this.skbs;
        int hashCode23 = (hashCode22 + (str23 == null ? 0 : str23.hashCode())) * 31;
        String str24 = this.rd;
        int hashCode24 = (hashCode23 + (str24 == null ? 0 : str24.hashCode())) * 31;
        String str25 = this.rs;
        int hashCode25 = (hashCode24 + (str25 == null ? 0 : str25.hashCode())) * 31;
        String str26 = this.als;
        int hashCode26 = (hashCode25 + (str26 == null ? 0 : str26.hashCode())) * 31;
        String str27 = this.lce;
        return hashCode26 + (str27 != null ? str27.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("CreativeConfigDto(cbc=");
        sb.append(this.cbc).append(", cbcr=").append(this.cbcr).append(", cbde=").append(this.cbde).append(", cbp=").append(this.cbp).append(", cbt=").append(this.cbt).append(", cbs=").append(this.cbs).append(", prbc=").append(this.prbc).append(", prbp=").append(this.prbp).append(", prbs=").append(this.prbs).append(", ctabc=").append(this.ctabc).append(", ctabe=").append(this.ctabe).append(", ctabp=");
        sb.append(this.ctabp).append(", ctabs=").append(this.ctabs).append(", ctatc=").append(this.ctatc).append(", mbc=").append(this.mbc).append(", mbp=").append(this.mbp).append(", mbs=").append(this.mbs).append(", pbc=").append(this.pbc).append(", pbe=").append(this.pbe).append(", pbp=").append(this.pbp).append(", ac=").append(this.ac).append(", skbdd=").append(this.skbdd).append(", skbs=").append(this.skbs);
        sb.append(", rd=").append(this.rd).append(", rs=").append(this.rs).append(", als=").append(this.als).append(", lce=").append(this.lce).append(')');
        return sb.toString();
    }

    /* compiled from: BidResponseDto.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0007¨\u0006\u0007"}, d2 = {"Lio/adn/sdk/internal/data/dto/CreativeConfigDto$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lio/adn/sdk/internal/data/dto/CreativeConfigDto;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<CreativeConfigDto> serializer() {
            return CreativeConfigDto$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ CreativeConfigDto(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, String str22, String str23, String str24, String str25, String str26, String str27, SerializationConstructorMarker serializationConstructorMarker) {
        if (134217727 != (i & 134217727)) {
            PluginExceptionsKt.throwMissingFieldException(i, 134217727, CreativeConfigDto$$serializer.INSTANCE.getDescriptor());
        }
        this.cbc = str;
        this.cbcr = str2;
        this.cbde = str3;
        this.cbp = str4;
        this.cbt = str5;
        this.cbs = str6;
        this.prbc = str7;
        this.prbp = str8;
        this.prbs = str9;
        this.ctabc = str10;
        this.ctabe = str11;
        this.ctabp = str12;
        this.ctabs = str13;
        this.ctatc = str14;
        this.mbc = str15;
        this.mbp = str16;
        this.mbs = str17;
        this.pbc = str18;
        this.pbe = str19;
        this.pbp = str20;
        this.ac = str21;
        this.skbdd = str22;
        this.skbs = str23;
        this.rd = str24;
        this.rs = str25;
        this.als = str26;
        this.lce = str27;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$adn_sdk_release(CreativeConfigDto self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.cbc);
        output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.cbcr);
        output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.cbde);
        output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.cbp);
        output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.cbt);
        output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.cbs);
        output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.prbc);
        output.encodeNullableSerializableElement(serialDesc, 7, StringSerializer.INSTANCE, self.prbp);
        output.encodeNullableSerializableElement(serialDesc, 8, StringSerializer.INSTANCE, self.prbs);
        output.encodeNullableSerializableElement(serialDesc, 9, StringSerializer.INSTANCE, self.ctabc);
        output.encodeNullableSerializableElement(serialDesc, 10, StringSerializer.INSTANCE, self.ctabe);
        output.encodeNullableSerializableElement(serialDesc, 11, StringSerializer.INSTANCE, self.ctabp);
        output.encodeNullableSerializableElement(serialDesc, 12, StringSerializer.INSTANCE, self.ctabs);
        output.encodeNullableSerializableElement(serialDesc, 13, StringSerializer.INSTANCE, self.ctatc);
        output.encodeNullableSerializableElement(serialDesc, 14, StringSerializer.INSTANCE, self.mbc);
        output.encodeNullableSerializableElement(serialDesc, 15, StringSerializer.INSTANCE, self.mbp);
        output.encodeNullableSerializableElement(serialDesc, 16, StringSerializer.INSTANCE, self.mbs);
        output.encodeNullableSerializableElement(serialDesc, 17, StringSerializer.INSTANCE, self.pbc);
        output.encodeNullableSerializableElement(serialDesc, 18, StringSerializer.INSTANCE, self.pbe);
        output.encodeNullableSerializableElement(serialDesc, 19, StringSerializer.INSTANCE, self.pbp);
        output.encodeNullableSerializableElement(serialDesc, 20, StringSerializer.INSTANCE, self.ac);
        output.encodeNullableSerializableElement(serialDesc, 21, StringSerializer.INSTANCE, self.skbdd);
        output.encodeNullableSerializableElement(serialDesc, 22, StringSerializer.INSTANCE, self.skbs);
        output.encodeNullableSerializableElement(serialDesc, 23, StringSerializer.INSTANCE, self.rd);
        output.encodeNullableSerializableElement(serialDesc, 24, StringSerializer.INSTANCE, self.rs);
        output.encodeNullableSerializableElement(serialDesc, 25, StringSerializer.INSTANCE, self.als);
        output.encodeNullableSerializableElement(serialDesc, 26, StringSerializer.INSTANCE, self.lce);
    }

    public CreativeConfigDto(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, String str22, String str23, String str24, String str25, String str26, String str27) {
        this.cbc = str;
        this.cbcr = str2;
        this.cbde = str3;
        this.cbp = str4;
        this.cbt = str5;
        this.cbs = str6;
        this.prbc = str7;
        this.prbp = str8;
        this.prbs = str9;
        this.ctabc = str10;
        this.ctabe = str11;
        this.ctabp = str12;
        this.ctabs = str13;
        this.ctatc = str14;
        this.mbc = str15;
        this.mbp = str16;
        this.mbs = str17;
        this.pbc = str18;
        this.pbe = str19;
        this.pbp = str20;
        this.ac = str21;
        this.skbdd = str22;
        this.skbs = str23;
        this.rd = str24;
        this.rs = str25;
        this.als = str26;
        this.lce = str27;
    }

    public final String getCbc() {
        return this.cbc;
    }

    public final String getCbcr() {
        return this.cbcr;
    }

    public final String getCbde() {
        return this.cbde;
    }

    public final String getCbp() {
        return this.cbp;
    }

    public final String getCbt() {
        return this.cbt;
    }

    public final String getCbs() {
        return this.cbs;
    }

    public final String getPrbc() {
        return this.prbc;
    }

    public final String getPrbp() {
        return this.prbp;
    }

    public final String getPrbs() {
        return this.prbs;
    }

    public final String getCtabc() {
        return this.ctabc;
    }

    public final String getCtabe() {
        return this.ctabe;
    }

    public final String getCtabp() {
        return this.ctabp;
    }

    public final String getCtabs() {
        return this.ctabs;
    }

    public final String getCtatc() {
        return this.ctatc;
    }

    public final String getMbc() {
        return this.mbc;
    }

    public final String getMbp() {
        return this.mbp;
    }

    public final String getMbs() {
        return this.mbs;
    }

    public final String getPbc() {
        return this.pbc;
    }

    public final String getPbe() {
        return this.pbe;
    }

    public final String getPbp() {
        return this.pbp;
    }

    public final String getAc() {
        return this.ac;
    }

    public final String getSkbdd() {
        return this.skbdd;
    }

    public final String getSkbs() {
        return this.skbs;
    }

    public final String getRd() {
        return this.rd;
    }

    public final String getRs() {
        return this.rs;
    }

    public final String getAls() {
        return this.als;
    }

    public final String getLce() {
        return this.lce;
    }
}
