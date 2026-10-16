package com.instagram.common.viewpoint.core;

import adn.analytics.Analytics;
import android.content.Context;
import android.graphics.Point;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Pair;
import android.view.Surface;
import androidx.datastore.preferences.protobuf.DescriptorProtos;
import com.facebook.ads.androidx.media3.common.ColorInfo;
import com.facebook.ads.androidx.media3.exoplayer.video.DummySurface;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomizations;
import com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters;
import com.google.common.primitives.SignedBytes;
import com.ironsource.D5;
import com.ironsource.Hd;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.mbridge.msdk.out.MBSupportMuteAdType;
import com.unity3d.mediation.LevelPlayAdError;
import com.vungle.ads.internal.protos.Sdk;
import io.bidmachine.media3.exoplayer.audio.SilenceSkippingAudioProcessor;
import io.bidmachine.protobuf.EventTypeExtended;
import io.ktor.util.date.GMTDateParser;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import kotlin.io.encoding.Base64;
import kotlin.text.Typography;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* renamed from: com.facebook.ads.redexgen.X.10, reason: invalid class name */
/* loaded from: assets/audience_network/classes2.dex */
public final class AnonymousClass10 extends AbstractC06471g {
    public static boolean A0z;
    public static boolean A10;
    public static byte[] A11;
    public static String[] A12 = {"1NrdYD1", "e5CK9xPn181JbTmOtknpsRCTtEnfDjR7", "JOO2xDl09pGw2ctw4YX5NjUR9G0o3YSd", "78GGNN1Oy", "9AKZq2G4NCUeKdGegrXYJ0IAO08zLsd4", "iWBlsDv", "UMYjsOFgfK8VKq5PmkWlrwAU0Drwgr0y", "VHiTYYEOZZ1JgajrOOPlCJmFeSyZZTnO"};
    public static final int[] A13;
    public C2292n5 A00;
    public float A01;
    public float A02;
    public float A03;
    public int A04;
    public int A05;
    public int A06;
    public int A07;
    public int A08;
    public int A09;
    public int A0A;
    public int A0B;
    public int A0C;
    public int A0D;
    public int A0E;
    public int A0F;
    public int A0G;
    public int A0H;
    public long A0I;
    public long A0J;
    public long A0K;
    public long A0L;
    public long A0M;
    public long A0N;
    public long A0O;
    public long A0P;
    public long A0Q;
    public long A0R;
    public MediaFormat A0S;
    public Surface A0T;
    public Surface A0U;
    public C2442pW A0V;
    public C0993Fm A0W;
    public G2 A0X;
    public Object A0Y;
    public boolean A0Z;
    public boolean A0a;
    public boolean A0b;
    public boolean A0c;
    public boolean A0d;
    public boolean A0e;
    public boolean A0f;
    public boolean A0g;

    @MetaExoPlayerCustomization(type = {"NEW_CLASS_ARG"}, value = "D69547806: Only become ready once we have a surface")
    public boolean A0h;
    public boolean A0i;
    public boolean A0j;
    public boolean A0k;
    public final int A0l;
    public final int A0m;
    public final int A0n;
    public final int A0o;
    public final long A0p;
    public final Context A0q;
    public final C0995Fo A0r;
    public final G7 A0s;
    public final GA A0t;
    public final GP A0u;
    public final boolean A0v;
    public final boolean A0w;
    public final long[] A0x;
    public final long[] A0y;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 15 out of bounds for length 14
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.restartVar(DebugInfoParser.java:193)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:141)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:636)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public static Point A07(B3 b3, C2489qI c2489qI) throws BX {
        boolean z = c2489qI.A0A > c2489qI.A0L;
        int i = z ? c2489qI.A0A : c2489qI.A0L;
        int i2 = z ? c2489qI.A0L : c2489qI.A0A;
        float f = i2 / i;
        for (int i3 : A13) {
            int i4 = (int) (i3 * f);
            if (i3 <= i || i4 <= i2) {
                return null;
            }
            if (C5C.A02 >= 21) {
                int i5 = z ? i4 : i3;
                if (!z) {
                    i3 = i4;
                }
                Point A0N = b3.A0N(i5, i3);
                if (b3.A0R(A0N.x, A0N.y, c2489qI.A01)) {
                    return A0N;
                }
            } else {
                int A05 = C5C.A05(i3, 16) * 16;
                int A052 = C5C.A05(i4, 16) * 16;
                if (A05 * A052 <= C0881Ba.A00()) {
                    int i6 = z ? A052 : A05;
                    if (!z) {
                        A05 = A052;
                    }
                    return new Point(i6, A05);
                }
            }
        }
        return null;
    }

    public static String A0B(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A11, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 7);
        }
        return new String(copyOfRange);
    }

    public static void A0P() {
        A11 = new byte[]{96, 101, 95, 96, 96, 102, 96, 98, 92, 98, 92, 95, -64, -80, -81, -84, -74, -81, -59, -74, -90, -91, -94, -84, -91, -63, -106, -122, -117, -123, -122, 79, SignedBytes.MAX_POWER_OF_TWO, 62, 63, 68, 111, 66, 62, 88, 78, 71, 71, 71, 68, 120, -113, -123, 126, 126, 126, -66, -70, -61, -63, -122, 124, 117, 118, 117, -90, 121, 125, 105, 95, 88, 90, 88, -119, 92, 96, -77, -72, -58, -77, 93, 98, 112, 106, -123, -105, -103, -105, -93, -100, 116, 116, -123, -120, 99, 117, 119, 117, -127, 122, 82, 82, 99, 102, 99, 95, 113, 115, 113, 125, 118, 78, 78, 95, 98, 97, 78, 96, 98, 96, 108, 101, Base64.padSymbol, Base64.padSymbol, 78, 81, 108, 63, -121, -76, -86, -72, -75, -77, -89, -66, 102, -121, 120, 124, -119, 122, -114, 78, 126, -126, 110, 93, 124, -124, 114, Byte.MAX_VALUE, 90, -71, -21, -19, -21, -41, -46, -70, -83, -88, -88, -61, -60, -76, -24, -27, -44, -46, -63, -30, -25, -40, -46, -91, -65, -55, -66, -64, -56, -86, -82, -43, -67, -51, -68, -47, -60, -68, -101, -81, -58, -101, -83, -85, -84, -80, Byte.MAX_VALUE, -113, 126, -109, -122, 126, -100, 126, -111, -109, 111, -108, -92, -109, -88, -101, -109, -79, -109, -90, -88, -123, -79, -122, -99, -89, -107, -123, -110, 122, 120, 121, 120, -95, -117, 114, 116, 118, -125, 123, 100, 105, 99, 108, 106, 119, Byte.MIN_VALUE, 95, 90, -122, 112, 87, 87, 85, -127, 118, 119, 117, 50, Byte.MAX_VALUE, 115, -118, 50, -124, 119, -123, -127, 126, -121, -122, 123, -127, Byte.MIN_VALUE, 50, 115, 118, 124, -121, -123, -122, 119, 118, 50, -122, -127, 76, 50, -71, -27, -29, -33, -27, -55, -89, -126, 114, 115, 113, 112, -103, -96, -87, -101, -107, -77, -107, -121, -77, -92, -58, -61, -59, -52, -43, -57, -63, -33, -50, -17, -12, -27, -54, -47, -38, -52, -58, -28, -43, -9, -18, -14, 77, 84, 93, 79, 73, 103, 90, 105, -127, 103, 96, -93, -44, -61, -48, -79, -46, -65, -48, -67, -79, -62, -81, -83, -83, -83, -76, -95, -97, -97, -95, 111, 92, 90, 90, 95, 90, 71, 70, 69, 69, 78, 59, 58, 57, 59, -106, -125, -126, -127, -123, 84, 65, 65, 63, 63, -107, -80, -69, -62, -76, -110, -73, -76, -78, -70, 111, -86, -69, -76, -74, -80, -78, -56, -107, -63, -80, -68, -76, -94, -72, -55, -76, 123, 111, 94, 96, 102, 101, 92, 92, 118, 94, 89, 99, 78, 74, 77, 71, -98, -96, -90, -91, -100, -100, -74, -86, -82, -82, -120, -115, -121, -112, -91, -89, -83, -84, -93, -93, -67, -79, -75, -75, -113, -108, -112, -107, 101, 103, 109, 108, 99, 99, 125, 113, 117, 117, 79, 84, 81, 79, -113, -111, -105, -106, -115, -115, -89, -97, -118, -108, 125, Byte.MAX_VALUE, 120, Byte.MIN_VALUE, 102, 104, 110, 109, 100, 100, 126, 118, 97, 107, 86, 82, 85, 84, -118, -116, -110, -111, -120, -120, -94, -102, -123, -113, 122, 120, 116, 124, -105, -71, -97, -98, -107, -107, -81, -109, -110, -100, -121, -123, -127, -125, -104, -70, -96, -97, -106, -106, -80, -104, -109, -99, -120, -124, -126, -118, 99, 112, 92, 114, 96, 100, 59, 105, 115, 111, 72, 103, 77, 84, 114, -127, 108, 118, 120, 87, 114, -125, -110, 126, 124, -120, 104, -125, 81, 96, 78, 86, 85, -97, -82, -83, -91, -86, -124, -97, -109, -94, -94, -116, -98, 120, -109, -89, -52, -60, -57, -52, -57, -42, -117, -74, -109, -107, -112, 93, 90, 109, -81, -72, -77, -110, -79, -105, -106, -70, -92, -97, -48, -93, -97, 103, 98, 72, 102, 79, 78, 75, 122, 117, 91, 123, 96, 99, 94, 99, 106, 68, 76, 71, 72, 78, -69, -44, -35, -34, -27, -34, -113, -80, -95, -97, -96, -91, -47, -94, -97, 125, -106, -97, -96, -89, -96, 81, 124, 98, 97, -110, 101, 97, -56, -31, -22, -21, -14, -21, -100, -57, -76, 117, 93, -117, 118, 110, 114, -125, 126, -120, 118, 94, 103, 114, 80, 84, 108, 107, 112, 104, 74, 118, 107, 108, 106, 93, 112, 107, 108, 118, 89, 108, 117, 107, 108, 121, 108, 121, -90, -56, -51, -56, -98, -117, -127, -115, -96, -122, -91, -83, -98, -126, 125, -97, -92, -97, 119, 99, -83, -75, -88, -93, -88, -96, 85, 95, 60, 59, 56, 81, -99, -89, -124, -122, -126, -103, -109, -111, -100, 114, -85, -77, -77, -85, -80, -87, -85, -54, -63, -84, -56, -47, -49, -111, -80, -51, -77, -75, -82, 126, 102, 99, 91, 77, Base64.padSymbol, 56, 65, 66, 59, 88, 118, 109, 116, 91, 88, 94, -88, -97, -90, -114, -119, -120, -125, 122, -127, 105, 100, 100, -76, -80, -87, 121, 123, 120, 96, 124, -71, -47, -54, -41, -35, -40, -42, -97, -107, -82, -67, -86, -79, 101, -91, -66, -51, -66, -119, -126, -116, -76, -120, -100, -81, -56, -41, -56, -108, -116, -112, -113, -66, -109, -90, 123, 93, 95, 90, -69, -98, -100, -96, -102, -103, 124, 122, Byte.MAX_VALUE, 107, 78, 77, 75, 74, -126, 102, 124, 120, 92, 97, -125, 112, -118, Byte.MIN_VALUE, -123, -116, 101, -50, -31, -32, -23, -27, -100, -80, -44, -79, -60, -61, -52, -56, Byte.MAX_VALUE, -83, -50, -45, -60, Byte.MAX_VALUE, -111, 113, -124, -125, -116, -120, 63, 109, -114, -109, -124, 63, 82, -105, -86, -77, -87, -86, -73, 101, -76, -70, -71, -75, -70, -71, 101, -85, -90, -82, -79, -86, -87, -78, -59, -45, -49, -52, -43, -44, -55, -49, -50, -45, Byte.MIN_VALUE, -43, -50, -53, -50, -49, -41, -50, -114, Byte.MIN_VALUE, -93, -49, -60, -59, -61, Byte.MIN_VALUE, -51, -63, -40, Byte.MIN_VALUE, -46, -59, -45, -49, -52, -43, -44, -55, -49, -50, -102, Byte.MIN_VALUE, -119, -125, 99, 125, 111, 105, 107, 102, -90, -96, Byte.MIN_VALUE, -99, -123, -125, -125, -102, -88, -83, -89, -121, -92, -116, -118, -118, -89, -118, -124, 100, -123, 112, 104, 103, -119, 107, 126, Byte.MIN_VALUE, 
        114, 108, 125, 75, 126, 100, -62, -59, -65, -100, -77, -61, -59, -96, -92, 118, -113, -124, -105, -120, -126, 115, -107, -110, -42, -14, -15, -4, -93, -41, -28, -27, -17, -24, -9, -93, -42, 126, 108, 93, 87, 97, 93, 90, 112, 126, 108, 93, 87, 97, 93, 90, -126, -72, -90, -105, -111, -100, -103, -108, -86, -116, 122, 107, 101, 112, 109, 104, -123, -77, -50, -50, Byte.MAX_VALUE, -52, -64, -51, -40, Byte.MAX_VALUE, -46, -45, -47, -60, -64, -52, Byte.MAX_VALUE, -62, -57, -64, -51, -58, -60, -46, -117, Byte.MAX_VALUE, -46, -50, Byte.MAX_VALUE, -61, -47, -50, -49, -49, -56, -51, -58, Byte.MAX_VALUE, -50, -59, -59, -46, -60, -45, -103, Byte.MAX_VALUE, -89, -126, 107, 71, 72, 92, 87, 112, 79, 117, 114, 87, 87, 79, -73, -110, -66, -89, -86, 97, 78, 59, 97, -38, -42, -77, -72, -72, -75, -82, -123, -122, -77, -92, -90, -93, -90, -124, 124, -92, -83, 112, -85, -101, -81, -98, -93, -87, 103, -83, -97, -83, -83, -93, -87, -88, 103, -93, -98, 120, -116, -117, -122, 68, 125, -119, 122, -92, 115, 111, -94, -81, -91, -77, -80, -86, -91, 111, -94, -73, 114, 110, -91, -94, -73, 114, -91, 111, -91, -90, -92, -80, -91, -90, -77, -24, -9, -12, -11, -78, -25, -12, -7, -7, -12, -14, 108, 123, 120, 121, 54, 117, 110, 111, 125, -48, -33, -36, -35, -102, -33, -42, -44, -43, -31, -95, -80, -83, -82, 107, -78, -83, -82, -28, -9, -78, 110, -127, 62, -51, -54, -41, -48, -54, -43, -52, -51, -54, -23, -9, -12, -11, -37, -18, -23, -22, -12, -57, -6, -21, -21, -22, -9, 114, 120, 123, -60, -51, -47, -46, -61, -48, -38, -26, -43, -31, -39, -95, -26, -43, -24, -39, -53, -38, -52, -38, -55, -44, -53, -56, -56, -53, -48, -72, -75, -71, -73, -72, -60, -65, -53, -70, -74, -68, -116, -115, -60, -61, -74, -69, -53, -52, -61, -81, -66, -120, -109, -116, 116, -113, -94, 114, 105, 108, 106, 115, 108, 107, 118, 118, 66, 65, Base64.padSymbol, 63, 105, 67, 66, 58, SignedBytes.MAX_POWER_OF_TWO, -46, -37, -46, -36, -97, -103, -52, -41, -56, -49, -62, -74, -105, -108, -104, 96, -90, -102, -94, -109, -105, -100, -95, -95, -105, -86, -101, -101, 100, 99, 101, 95, 120, 113, 107, -124, 66, -65, -62, -54, Byte.MIN_VALUE, -65, -76, -57, -72, -63, -74, -52, -56, -115, 123, -55, -54, -49, -64, 125, 113, 126, 126, 121, 126, 119, -17, -29, -12, -21, -16, -15, -31, -24, -115, -127, -104, 77, -120, -123, -119, -121, -120, -108, -27, -39, -16, -91, -31, -26, -24, -19, -20, -91, -21, -31, -14, -35, 117, 105, Byte.MIN_VALUE, 53, Byte.MAX_VALUE, 113, 108, 124, 112, 124, 119, -75, -79, -84, -73, -57, -61, -57, -65, -102, -115, -103, -115, -96, -108, -110, -115, -121, -113, -112, -123, -103, -105, -125, -118, -89, 105, 104, 105, -113, Byte.MIN_VALUE, -115, -124, -117, -117, 126, -125, -74, -89, -76, -85, -78, -78, -91, -86, -78, -18, -33, -20, -29, -22, -22, -35, -30, -15, -91, -106, -93, -102, -95, -95, -108, -103, -87, -24, -22, -31, -25, -22, -31, -20, -15, -84, -97, -90, -97, -101, -83, -97, -119, -81, -82, -86, -81, -82, 124, -81, -96, -96, -97, -84, Byte.MIN_VALUE, 125, -126, 111, -126, 119, 125, 124, 59, 114, 115, 117, Byte.MIN_VALUE, 115, 115, -127, -107, 91, 82, 87, -102, 82, 83, 90, -58, -76, -63, -57, -62, -63, -68, -105, -113, -115, -108, 122, -115, -120, -119, -109, 102, -103, -118, -118, -119, -106, -14, -33, -25, -30, -19, -35, -16, -19, -11, -119, 120, -127, 116, 122, -118, -84, -83, -90, -90, -99, -92, -99, -100, 101, -88, -92, -103, -79, -102, -103, -101, -93, -90, -107, -94, -98, -107, -107, -113, 125, 101, -54, -67, -72, -71, -61, -125, -121, -69, -60, -60, -86, -99, -104, -103, -93, 99, -107, -86, 100, 101, -40, -53, -58, -57, -47, -111, -61, -40, -59, -124, 119, 114, 115, 125, Base64.padSymbol, 114, 125, 122, 112, -121, 59, -124, 119, -127, 119, 125, 124, -37, -50, -55, -54, -44, -108, -51, -54, -37, -56, -109, -122, -127, -126, -116, 76, -118, -115, 81, -109, 74, -126, -112, -33, -46, -51, -50, -40, -104, -31, -106, -33, -41, -51, -105, -40, -41, -101, -105, -33, -39, -95, -22, -35, -40, -39, -29, -93, -20, -95, -22, -30, -40, -94, -29, -30, -90, -94, -22, -28, -83, -76, -98, -79, -80, -84, -85, -42, -57, -40, -47, -60, -61, -51, -65, -70, -54, -66, -88, -96, -96, -107, -92, -112, -105, -89, -97, -97, -108, -93, -113, -106, -98, -45};
    }

    static {
        A0P();
        A13 = new int[]{1920, 1600, 1440, 1280, 960, 854, 640, 540, 480};
    }

    @MetaExoPlayerCustomization(type = {"FEATURE_LOGIC"}, value = "D69547806: Only become ready once we have a surface")
    public AnonymousClass10(Context context, C2085jQ c2085jQ, MediaCodecRendererMetaParameters mediaCodecRendererMetaParameters, BT bt, long j, A6 a6, boolean z, boolean z2, Handler handler, GQ gq, int i, int i2, int i3, int i4, int i5) {
        super(2, c2085jQ, mediaCodecRendererMetaParameters, bt, a6, z, z2, i3, i4);
        this.A0e = true;
        this.A0Z = true;
        boolean z3 = false;
        this.A0f = false;
        this.A0K = -9223372036854775807L;
        this.A0c = false;
        this.A0h = false;
        this.A0w = MetaExoPlayerUpgradeConfig.A03(EnumC2089jX.A1v);
        this.A0h = MetaExoPlayerUpgradeConfig.A03(EnumC2089jX.A0w);
        this.A0p = j;
        this.A0l = i;
        this.A0m = i2;
        this.A0q = context.getApplicationContext();
        this.A0n = i5;
        this.A0t = new GA(context);
        this.A0s = new G7(this.A0q);
        this.A0u = new GP(handler, gq);
        this.A0r = new C0995Fo(this.A0s, this, this.A0w);
        this.A0v = A0i();
        if (C5C.A02 == 29 && C5C.A06.startsWith(A0B(811, 6, 62))) {
            z3 = true;
        }
        this.A0a = z3;
        this.A0x = new long[10];
        this.A0y = new long[10];
        this.A0R = -9223372036854775807L;
        this.A0O = -9223372036854775807L;
        this.A0M = -9223372036854775807L;
        this.A08 = -1;
        this.A06 = -1;
        this.A01 = -1.0f;
        this.A02 = -1.0f;
        this.A0H = 1;
        A0F();
    }

    private int A00(C2489qI c2489qI) {
        if (c2489qI.A0B != -1) {
            int i = 0;
            int i2 = c2489qI.A0X.size();
            for (int initializationDataCount = 0; initializationDataCount < i2; initializationDataCount++) {
                int totalInitializationDataSize = c2489qI.A0X.get(initializationDataCount).length;
                i += totalInitializationDataSize;
            }
            int totalInitializationDataSize2 = c2489qI.A0B;
            return totalInitializationDataSize2 + i;
        }
        int i3 = c2489qI.A0L;
        String str = c2489qI.A0W;
        int width = c2489qI.A0A;
        return A02(str, i3, width);
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x00fb, code lost:
    
        if (r6 <= r5) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00fd, code lost:
    
        r6 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00fe, code lost:
    
        if (r6 != false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0100, code lost:
    
        r5 = new java.lang.StringBuilder();
        r0 = A0B(380, 29, 72);
        r5 = r5.append(r0).append(r9.A0L);
        r0 = A0B(1775, 1, 84);
        r5 = r5.append(r0).append(r9.A0A);
        r0 = A0B(1154, 3, 73);
        r1 = r5.append(r0);
        r0 = com.instagram.common.viewpoint.core.C5C.A04;
        r5 = r1.append(r0);
        r0 = A0B(1153, 1, 64);
        r5 = r5.append(r0).toString();
        r0 = A0B(682, 23, 0);
        com.instagram.common.viewpoint.core.AbstractC07214g.A04(r0, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x016d, code lost:
    
        r7 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x016a, code lost:
    
        if (r6 <= r5) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00a8, code lost:
    
        if (r5 != false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00aa, code lost:
    
        r5 = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00c9, code lost:
    
        if (r4 != false) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00cb, code lost:
    
        r3 = 32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00cd, code lost:
    
        if (r6 == false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00cf, code lost:
    
        r0 = 4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00d2, code lost:
    
        return (r5 | r3) | r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00d3, code lost:
    
        r0 = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00d5, code lost:
    
        if (r4 != false) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00db, code lost:
    
        r5 = 8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00d8, code lost:
    
        if (r5 != false) goto L45;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int A01(BT bt, C2489qI c2489qI, boolean z) throws BX {
        String mimeType = c2489qI.A0W;
        int adaptiveSupport = 0;
        if (!C3J.A0F(mimeType)) {
            return 0;
        }
        boolean decoderCapable = true;
        boolean requiresSecureDecryption = c2489qI.A0O != null;
        String mimeType2 = c2489qI.A0W;
        List<B3> A7o = bt.A7o(mimeType2, requiresSecureDecryption, false);
        if (A7o.isEmpty() && z) {
            A7o = A0C(bt, c2489qI);
        }
        if (requiresSecureDecryption && A7o.isEmpty()) {
            if (!requiresSecureDecryption) {
                return 1;
            }
            String mimeType3 = c2489qI.A0W;
            if (bt.A7o(mimeType3, false, false).isEmpty()) {
                return 1;
            }
            return 2;
        }
        if (A7o.isEmpty()) {
            return AbstractC08017i.A00(1);
        }
        if (!AbstractC06471g.A1G(c2489qI)) {
            return AbstractC08017i.A00(2);
        }
        B3 b3 = A7o.get(0);
        boolean A0S = b3.A0S(c2489qI);
        if (A0S && c2489qI.A0L > 0 && c2489qI.A0A > 0) {
            int i = C5C.A02;
            String mimeType4 = A12[3];
            if (mimeType4.length() == 21) {
                throw new RuntimeException();
            }
            String[] strArr = A12;
            strArr[4] = "IH389xfTqQddwzM1XHaKnp7MZCz6cb7i";
            strArr[7] = "af13jltpF5ZHHZjQxHJ609Zz958wUZpm";
            if (i >= 21) {
                A0S = b3.A0R(c2489qI.A0L, c2489qI.A0A, c2489qI.A01);
            } else {
                int i2 = c2489qI.A0L * c2489qI.A0A;
                int A00 = C0881Ba.A00();
                String mimeType5 = A12[3];
                if (mimeType5.length() != 21) {
                    A12[6] = "ecceu4zvNIhSM2cVW4sHEkLyyuMr8ggY";
                } else {
                    String[] strArr2 = A12;
                    strArr2[4] = "Kv9mbenvGpQB93bFl6W05JZGB7qp372O";
                    strArr2[7] = "bO17OsYGhLw9DTwpfBLbbIHXKJZDjwiV";
                }
            }
        }
        boolean z2 = b3.A04;
        if (A12[2].charAt(6) != 'n') {
            A12[3] = "9b4CG0tnJeiPU0k4PARWVGoy4qv";
        }
        boolean requiresSecureDecryption2 = b3.A08;
        String[] strArr3 = A12;
        if (strArr3[4].charAt(23) != strArr3[7].charAt(23)) {
            A12[6] = "WfKDcH5FGJ5C30XN1qoZOnsI3qPSaUZa";
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0098, code lost:
    
        if (r7.equals(A0B(1682, 10, 94)) != false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x009a, code lost:
    
        r0 = 4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00ac, code lost:
    
        if (r7.equals(A0B(1682, 10, 94)) != false) goto L29;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0011 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int A02(String str, int i, int i2) {
        char c;
        int i3;
        int maxPixels;
        if (i == -1 || i2 == -1) {
            return -1;
        }
        switch (str.hashCode()) {
            case -1664118616:
                if (str.equals(A0B(1635, 10, 77))) {
                    c = 0;
                    switch (c) {
                        case 0:
                        case 1:
                            i3 = i * i2;
                            maxPixels = 2;
                            break;
                        case 2:
                            if (A0B(179, 14, 116).equals(C5C.A06)) {
                                return -1;
                            }
                            i3 = C5C.A05(i, 16) * C5C.A05(i2, 16) * 16 * 16;
                            maxPixels = 2;
                            break;
                        case 3:
                            i3 = i * i2;
                            maxPixels = 2;
                            break;
                        case 4:
                        case 5:
                            i3 = i * i2;
                            maxPixels = 4;
                            break;
                        default:
                            return -1;
                    }
                    int minCompressionRatio = i3 * 3;
                    return minCompressionRatio / (maxPixels * 2);
                }
                c = 65535;
                switch (c) {
                }
                int minCompressionRatio2 = i3 * 3;
                return minCompressionRatio2 / (maxPixels * 2);
            case -1662541442:
                if (A12[6].charAt(29) == 'x') {
                    A12[6] = "kyKsBwQU8xCkRSkCaxSqqZifTpXgRXEu";
                    break;
                } else {
                    String[] strArr = A12;
                    strArr[4] = "tnE0zKFGRA1mCoLoHHoslqD8Jr5mgPU8";
                    strArr[7] = "qP878wwRxP7hWQjb5gRcbhQ3e4xfipWz";
                    break;
                }
                switch (c) {
                }
                int minCompressionRatio22 = i3 * 3;
                return minCompressionRatio22 / (maxPixels * 2);
            case 1187890754:
                boolean equals = str.equals(A0B(1692, 13, 22));
                if (A12[2].charAt(6) == 'n') {
                    throw new RuntimeException();
                }
                A12[6] = "BSk60PaXf0Sk22Sw2ltCbt0PrRKp4yQI";
                if (equals) {
                    c = 1;
                    switch (c) {
                    }
                    int minCompressionRatio222 = i3 * 3;
                    return minCompressionRatio222 / (maxPixels * 2);
                }
                c = 65535;
                switch (c) {
                }
                int minCompressionRatio2222 = i3 * 3;
                return minCompressionRatio2222 / (maxPixels * 2);
            case 1331836730:
                if (str.equals(A0B(1655, 9, 91))) {
                    c = 2;
                    switch (c) {
                    }
                    int minCompressionRatio22222 = i3 * 3;
                    return minCompressionRatio22222 / (maxPixels * 2);
                }
                c = 65535;
                switch (c) {
                }
                int minCompressionRatio222222 = i3 * 3;
                return minCompressionRatio222222 / (maxPixels * 2);
            case 1599127256:
                if (str.equals(A0B(1705, 19, 98))) {
                    c = 3;
                    switch (c) {
                    }
                    int minCompressionRatio2222222 = i3 * 3;
                    return minCompressionRatio2222222 / (maxPixels * 2);
                }
                c = 65535;
                switch (c) {
                }
                int minCompressionRatio22222222 = i3 * 3;
                return minCompressionRatio22222222 / (maxPixels * 2);
            case 1599127257:
                if (str.equals(A0B(IronSourceConstants.errorCode_TEST_SUITE_WEB_CONTROLLER_NOT_LOADED, 19, 109))) {
                    c = 5;
                    switch (c) {
                    }
                    int minCompressionRatio222222222 = i3 * 3;
                    return minCompressionRatio222222222 / (maxPixels * 2);
                }
                c = 65535;
                switch (c) {
                }
                int minCompressionRatio2222222222 = i3 * 3;
                return minCompressionRatio2222222222 / (maxPixels * 2);
            default:
                c = 65535;
                switch (c) {
                }
                int minCompressionRatio22222222222 = i3 * 3;
                return minCompressionRatio22222222222 / (maxPixels * 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long A03(long j, long j2, long j3, long j4, boolean z) {
        double playbackSpeed = A1f();
        long j5 = (long) ((j4 - j) / playbackSpeed);
        if (z) {
            return j5 - (j3 - j2);
        }
        return j5;
    }

    @MetaExoPlayerCustomization("D64704257: Adding a new param to control AI FRC")
    private final MediaFormat A08(C2489qI c2489qI, C0993Fm c0993Fm, boolean z, int i) {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString(A0B(1462, 4, 83), c2489qI.A0W);
        mediaFormat.setInteger(A0B(1755, 5, 79), c2489qI.A0L);
        mediaFormat.setInteger(A0B(1307, 6, 73), c2489qI.A0A);
        AbstractC07234i.A06(mediaFormat, c2489qI.A0X);
        AbstractC07234i.A03(mediaFormat, A0B(1286, 10, 109), c2489qI.A01);
        AbstractC07234i.A04(mediaFormat, A0B(1548, 16, 7), c2489qI.A0F);
        AbstractC07234i.A02(mediaFormat, c2489qI.A0N);
        mediaFormat.setInteger(A0B(1447, 9, 1), c0993Fm.A02);
        mediaFormat.setInteger(A0B(1423, 10, 25), c0993Fm.A00);
        AbstractC07234i.A04(mediaFormat, A0B(1433, 14, 113), c0993Fm.A01);
        if (C5C.A02 >= 23) {
            String A0B = A0B(1521, 8, 113);
            String[] strArr = A12;
            if (strArr[4].charAt(23) == strArr[7].charAt(23)) {
                throw new RuntimeException();
            }
            A12[2] = "2RIBJj1oBKSBZdAo5SnKQdQzGU6CRjTj";
            mediaFormat.setInteger(A0B, 0);
        }
        if (z) {
            mediaFormat.setInteger(A0B(1173, 8, 16), 0);
        }
        AbstractC2056is.A03(this.A0z, mediaFormat);
        if (i != 0) {
            A0T(mediaFormat, i);
        }
        return mediaFormat;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005b A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final C0993Fm A0A(B3 b3, C2489qI c2489qI, C2489qI[] c2489qIArr) throws BX {
        int maxWidth;
        int maxHeight;
        int i = c2489qI.A0L;
        int i2 = c2489qI.A0A;
        int A00 = A00(c2489qI);
        int maxHeight2 = c2489qIArr.length;
        if (maxHeight2 == 1) {
            return new C0993Fm(i, i2, A00);
        }
        int i3 = 0;
        for (C2489qI streamFormat : c2489qIArr) {
            if (A0v(b3.A04, c2489qI, streamFormat)) {
                int maxWidth2 = streamFormat.A0L;
                if (maxWidth2 != -1) {
                    int maxWidth3 = streamFormat.A0A;
                    if (maxWidth3 != -1) {
                        maxWidth = 0;
                        i3 |= maxWidth;
                        int i4 = streamFormat.A0L;
                        maxHeight = A12[6].charAt(29);
                        if (maxHeight != 120) {
                            throw new RuntimeException();
                        }
                        A12[2] = "vHVCHU2tj4jzHHyhZwddXygsl3jVFph7";
                        i = Math.max(i, i4);
                        int maxWidth4 = streamFormat.A0A;
                        i2 = Math.max(i2, maxWidth4);
                        int maxWidth5 = A00(streamFormat);
                        A00 = Math.max(A00, maxWidth5);
                    }
                }
                maxWidth = 1;
                i3 |= maxWidth;
                int i42 = streamFormat.A0L;
                maxHeight = A12[6].charAt(29);
                if (maxHeight != 120) {
                }
            }
        }
        if (i3 != 0) {
            StringBuilder append = new StringBuilder().append(A0B(921, 43, 89)).append(i);
            String A0B = A0B(1775, 1, 84);
            String sb = append.append(A0B).append(i2).toString();
            String A0B2 = A0B(682, 23, 0);
            AbstractC07214g.A07(A0B2, sb);
            Point A07 = A07(b3, c2489qI);
            if (A07 != null) {
                int maxWidth6 = A07.x;
                i = Math.max(i, maxWidth6);
                int maxWidth7 = A07.y;
                i2 = Math.max(i2, maxWidth7);
                int maxWidth8 = A02(c2489qI.A0W, i, i2);
                A00 = Math.max(A00, maxWidth8);
                AbstractC07214g.A07(A0B2, A0B(246, 34, 11) + i + A0B + i2);
            }
        }
        return new C0993Fm(i, i2, A00);
    }

    public static List<B3> A0C(BT bt, C2489qI c2489qI) throws BX {
        ArrayList arrayList = new ArrayList();
        String alternativeMimeType = C0881Ba.A0P(c2489qI);
        if (alternativeMimeType != null) {
            List<B3> A7o = bt.A7o(alternativeMimeType, false, false);
            if (C5C.A02 >= 26) {
                if (A0B(1664, 18, 7).equals(c2489qI.A0W) && !A7o.isEmpty()) {
                    return A7o;
                }
                return arrayList;
            }
            return arrayList;
        }
        return arrayList;
    }

    public static List<B3> A0D(BT bt, C2489qI c2489qI, boolean z) throws BX {
        String str = c2489qI.A0W;
        if (str == null) {
            return Collections.emptyList();
        }
        return Collections.unmodifiableList(bt.A7o(str, z, false));
    }

    private void A0E() {
        B0 A1j;
        this.A0i = false;
        if (C5C.A02 >= 23 && this.A0k && (A1j = A1j()) != null) {
            this.A00 = new C2292n5(this, A1j);
        }
    }

    private void A0F() {
        this.A0G = -1;
        this.A0E = -1;
        this.A03 = -1.0f;
        this.A0F = -1;
    }

    @MetaExoPlayerCustomization("need for SR to release EGL context")
    private void A0G() {
        if (this.A0r.A0G() && MetaExoPlayerUpgradeConfig.A03(EnumC2089jX.A1t)) {
            this.A0r.A0A();
            throw null;
        }
    }

    private void A0H() {
        if (this.A0m > 0 && this.A05 > 0 && this.A05 >= this.A0m) {
            this.A0u.A00(this.A05, SystemClock.elapsedRealtime() - this.A0I);
        }
        this.A05 = 0;
        this.A0I = SystemClock.elapsedRealtime();
    }

    private void A0I() {
        B0 A1j = A1j();
        if (A1j != null && !this.A0c && A1j.A9K() > 30) {
            A0V(super.A0g);
            this.A0c = true;
        }
    }

    private void A0J() {
        if (this.A09 > 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long now = this.A0J;
            long elapsedMs = elapsedRealtime - now;
            this.A0u.A01(this.A09, elapsedMs);
            this.A09 = 0;
            this.A0J = elapsedRealtime;
        }
    }

    private void A0K() {
        if (this.A08 == -1 && this.A06 == -1) {
            return;
        }
        if (this.A0G != this.A08 || this.A0E != this.A06 || this.A0F != this.A07 || this.A03 != this.A01) {
            this.A0u.A07(new C2442pW(this.A08, this.A06, this.A07, this.A01));
            this.A0G = this.A08;
            this.A0E = this.A06;
            this.A0F = this.A07;
            this.A03 = this.A01;
        }
    }

    private void A0L() {
        if (this.A0i) {
            this.A0u.A0D(this.A0U);
        }
    }

    private void A0M() {
        if (this.A0G != -1 || this.A0E != -1) {
            this.A0u.A07(new C2442pW(this.A0G, this.A0E, this.A0F, this.A03));
        }
    }

    private void A0N() {
        long j;
        if (this.A0p > 0) {
            j = SystemClock.elapsedRealtime() + this.A0p;
        } else {
            j = -9223372036854775807L;
        }
        this.A0M = j;
    }

    @MetaExoPlayerCustomization("D36797879: Adding implementation for calculating avg render time")
    private void A0O() {
        super.A0h.A03(super.A0f);
    }

    private final void A0Q(int i) {
        super.A0h.A04 += i;
        this.A09 += i;
        this.A05 += i;
        super.A0h.A07 = Math.max(this.A05, super.A0h.A07);
        if (this.A09 >= this.A0l) {
            A0J();
        }
    }

    private final void A0R(long j, long j2, float f) {
        int A01 = (int) C2Y.A01(j);
        int A012 = (int) C2Y.A01(j2);
        if (A012 > 1000 && A012 < 10000) {
            int i = A01 + A012;
            int positionMs = this.A0A;
            int presentationGapMs = this.A0B;
            if (i > positionMs + presentationGapMs + 1000) {
                int presentationGapMs2 = this.A0A;
                if (A01 > presentationGapMs2) {
                    int positionMs2 = this.A0A;
                    int presentationGapMs3 = this.A0B;
                    if (A01 < positionMs2 + presentationGapMs3) {
                        C6I c6i = super.A0h;
                        int i2 = c6i.A0E;
                        int positionMs3 = this.A0A;
                        int presentationGapMs4 = this.A0B;
                        c6i.A0E = i2 + ((int) ((((A01 + A012) - (positionMs3 + presentationGapMs4)) * f) / 1000.0d));
                        this.A0A = A01;
                        this.A0B = A012;
                    }
                }
                int positionMs4 = this.A0A;
                int presentationGapMs5 = this.A0B;
                if (A01 > positionMs4 + presentationGapMs5) {
                    int presentationGapMs6 = (int) ((A012 * f) / 1000.0d);
                    super.A0h.A0E += presentationGapMs6;
                }
                this.A0A = A01;
                this.A0B = A012;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0S(long j, long j2, C2489qI c2489qI, MediaFormat mediaFormat) {
        if (this.A0X != null) {
            this.A0X.AGS(j, j2, c2489qI, mediaFormat);
        }
    }

    public static void A0T(MediaFormat mediaFormat, int i) {
        mediaFormat.setFeatureEnabled(A0B(1609, 17, 49), true);
        mediaFormat.setInteger(A0B(1157, 16, 51), i);
    }

    private void A0U(Surface surface) throws AD {
        if (surface == null) {
            if (this.A0T != null) {
                surface = this.A0T;
            } else {
                B3 A1k = A1k();
                if (A1k != null && A0r(A1k)) {
                    this.A0T = DummySurface.A01(this.A0q, A1k.A06);
                    surface = this.A0T;
                }
            }
        }
        boolean A03 = MetaExoPlayerUpgradeConfig.A03(EnumC2089jX.A0X);
        if (this.A0U != surface) {
            this.A0U = surface;
            this.A0Q = SystemClock.elapsedRealtime();
            if (A12[6].charAt(29) == 'x') {
                throw new RuntimeException();
            }
            A12[1] = "flDNbofxs3CTffCwMDp3s46Nt2jaxTe4";
            int A9A = A9A();
            boolean shouldIgnoreUnknownSurfaceSize = false;
            boolean z = this.A0f && AAe();
            if (A9A == 1 || A9A == 2) {
                B0 A1j = A1j();
                boolean shouldReInitCodecUponSurfaceSetFailure = this.A0r.A0G();
                if (!shouldReInitCodecUponSurfaceSetFailure) {
                    int state = C5C.A02;
                    if (state >= 23 && A1j != null && surface != null) {
                        boolean shouldReInitCodecUponSurfaceSetFailure2 = this.A0b;
                        if (!shouldReInitCodecUponSurfaceSetFailure2) {
                            if (A03) {
                                try {
                                    A0d(A1j, surface);
                                } catch (IllegalStateException unused) {
                                    A1n();
                                    A1p();
                                }
                            } else {
                                A0d(A1j, surface);
                            }
                        }
                    }
                    A1n();
                    A1p();
                }
            }
            if (surface != null && surface != this.A0T) {
                A0M();
                A0E();
                if (A9A == 2 || z) {
                    A0N();
                }
                if (this.A0r.A0G()) {
                    if (MetaExoPlayerUpgradeConfig.A03(EnumC2089jX.A0j) && this.A0r.A06 != null) {
                        shouldIgnoreUnknownSurfaceSize = true;
                    }
                    if (!shouldIgnoreUnknownSurfaceSize) {
                        this.A0r.A0C(surface, C07404z.A03);
                        return;
                    }
                    return;
                }
                return;
            }
            A0F();
            A0E();
            if (!this.A0r.A0G()) {
                return;
            }
            this.A0r.A08();
            throw null;
        }
        if (surface != null && surface != this.A0T) {
            A0M();
            if (A12[3].length() != 21) {
                A12[6] = "VhVyjLmIQ4bbJ9563iENK2u1xmxcLHgS";
                A0L();
            } else {
                A0L();
            }
        }
    }

    private void A0V(C2489qI c2489qI) {
        B0 codec = A1j();
        if (codec != null && c2489qI != null) {
            Pair<Long, Integer> A8j = codec.A8j();
            if (((Long) A8j.first).longValue() > 0) {
                super.A0h.A04(A8j);
                GP gp = this.A0u;
                if (A12[2].charAt(6) == 'n') {
                    throw new RuntimeException();
                }
                A12[3] = "UGSzGWhN7NgjOmIm99IkQUILfPM9Cd";
                gp.A04(super.A0h.A00, c2489qI);
            }
        }
    }

    private final void A0W(B0 b0, int i, long j) {
        AnonymousClass54.A02(A0B(1262, 15, 126));
        b0.AHi(i, false);
        AnonymousClass54.A00();
        A0Q(1);
    }

    @MetaExoPlayerCustomization("D36797879: Adding implementation for calculating avg render time")
    private final void A0X(B0 b0, int i, long j) {
        if (this.A0w) {
            A0Y(b0, i, j);
            return;
        }
        A0K();
        try {
            AnonymousClass54.A02(A0B(1529, 19, 51));
            long elapsedRealtime = SystemClock.elapsedRealtime();
            b0.AHi(i, true);
            long j2 = super.A0f;
            long startRenderTime = SystemClock.elapsedRealtime();
            super.A0f = j2 + (startRenderTime - elapsedRealtime);
            this.A0P = SystemClock.elapsedRealtime() * 1000;
            super.A0h.A09++;
            A0H();
            A27();
            A0O();
        } finally {
            AnonymousClass54.A00();
        }
    }

    @MetaExoPlayerCustomization("D36797879: Adding implementation for calculating avg render time")
    private final void A0Y(B0 b0, int i, long j) {
        AnonymousClass54.A02(A0B(1529, 19, 51));
        long elapsedRealtime = SystemClock.elapsedRealtime();
        b0.AHi(i, true);
        long j2 = super.A0f;
        long startRenderTime = SystemClock.elapsedRealtime();
        super.A0f = j2 + (startRenderTime - elapsedRealtime);
        AnonymousClass54.A00();
        super.A0h.A09++;
        A0H();
        if (!this.A0r.A0G()) {
            this.A0P = SystemClock.elapsedRealtime() * 1000;
            A0K();
            A27();
        }
    }

    private final void A0Z(B0 b0, int i, long j) {
        AnonymousClass54.A02(A0B(1579, 15, 29));
        b0.AHi(i, false);
        AnonymousClass54.A00();
        super.A0h.A0B++;
    }

    @MetaExoPlayerCustomization("D36797879: Adding implementation for calculating avg render time")
    private final void A0a(B0 b0, int i, long j, long j2) {
        if (this.A0w) {
            A0c(b0, i, j, j2, true);
            return;
        }
        A0K();
        A0S(j, j2, super.A0g, this.A0S);
        try {
            AnonymousClass54.A02(A0B(1529, 19, 51));
            long elapsedRealtime = SystemClock.elapsedRealtime();
            b0.AHh(i, j2);
            long j3 = super.A0f;
            long startRenderTime = SystemClock.elapsedRealtime();
            super.A0f = j3 + (startRenderTime - elapsedRealtime);
            this.A0P = SystemClock.elapsedRealtime() * 1000;
            super.A0h.A09++;
            A0H();
            A27();
            A0O();
        } finally {
            AnonymousClass54.A00();
        }
    }

    private final void A0b(@MetaExoPlayerCustomization B0 b0, int i, long j, long j2, boolean z) {
        if (this.A0w) {
            A0c(b0, i, j, j2, z);
            return;
        }
        A0K();
        A0S(j, j2, super.A0g, this.A0S);
        try {
            AnonymousClass54.A02(A0B(1529, 19, 51));
            long elapsedRealtime = SystemClock.elapsedRealtime();
            b0.AHh(i, j2);
            long j3 = super.A0f;
            long startRenderTime = SystemClock.elapsedRealtime();
            super.A0f = j3 + (startRenderTime - elapsedRealtime);
            this.A0P = SystemClock.elapsedRealtime() * 1000;
            super.A0h.A09++;
            A0H();
            A27();
            A0O();
        } finally {
            AnonymousClass54.A00();
        }
    }

    @MetaExoPlayerCustomization("notifyFrameMetadataListener be removed once we take the Exo renderOutputBufferNow Function refactor")
    private final void A0c(B0 b0, int i, long j, long j2, boolean z) {
        if (z) {
            C2489qI c2489qI = super.A0g;
            MediaFormat mediaFormat = this.A0S;
            if (A12[3].length() != 21) {
                A12[6] = "fwcrFdVwexqT3olBri8BzspmWxCtZa94";
                A0S(j, j2, c2489qI, mediaFormat);
            }
            throw new RuntimeException();
        }
        AnonymousClass54.A02(A0B(1529, 19, 51));
        long elapsedRealtime = SystemClock.elapsedRealtime();
        b0.AHh(i, j2);
        long j3 = super.A0f;
        long startRenderTime = SystemClock.elapsedRealtime();
        super.A0f = j3 + (startRenderTime - elapsedRealtime);
        if (A12[3].length() != 21) {
            String[] strArr = A12;
            strArr[5] = "NtBdNhJ";
            strArr[0] = "S1Pe4Cz";
            AnonymousClass54.A00();
            super.A0h.A09++;
            A0H();
            if (!this.A0r.A0G()) {
                this.A0P = SystemClock.elapsedRealtime() * 1000;
                A0K();
                A27();
                A0O();
                return;
            }
            return;
        }
        throw new RuntimeException();
    }

    public static void A0d(B0 b0, Surface surface) {
        b0.AJb(surface);
    }

    @MetaExoPlayerCustomization
    private void A0f(Object obj) {
        this.A0d = ((Boolean) obj).booleanValue();
        A1j();
    }

    private boolean A0g() {
        if (this.A0n <= 0) {
            return false;
        }
        boolean z = this.A0K == -9223372036854775807L || System.currentTimeMillis() - this.A0K <= ((long) this.A0n);
        if (this.A0K == -9223372036854775807L) {
            AbstractC07214g.A07(A0B(682, 23, 0), A0B(EventTypeExtended.EVENT_TYPE_EXTENDED_WATERFALL_STARTED_VALUE, 20, 62));
            this.A0K = System.currentTimeMillis();
        }
        return z;
    }

    public static boolean A0h() {
        return C5C.A02 >= 21;
    }

    public static boolean A0i() {
        return C5C.A02 <= 22 && A0B(1280, 6, 87).equals(C5C.A03) && A0B(725, 6, 88).equals(C5C.A05);
    }

    public static boolean A0k(long j) {
        return j < -30000;
    }

    public static boolean A0l(long j) {
        return j < -500000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean A0m(long j, long j2) {
        boolean z;
        boolean z2 = A9A() == 2;
        boolean isStarted = this.A0j;
        if (!isStarted) {
            if (!z2) {
                boolean isStarted2 = this.A0g;
                if (!isStarted2) {
                    z = false;
                }
            }
            z = true;
        } else {
            boolean isStarted3 = this.A0i;
            z = !isStarted3;
        }
        long elapsedRealtime = (SystemClock.elapsedRealtime() * 1000) - this.A0P;
        if (this.A0M == -9223372036854775807L && j >= A1i()) {
            if (z) {
                return true;
            }
            if (z2) {
                boolean isStarted4 = A0p(j2, elapsedRealtime);
                if (isStarted4) {
                    return true;
                }
            }
        }
        return false;
    }

    private final boolean A0n(long j, long j2) {
        return A0l(j);
    }

    private final boolean A0o(long j, long j2) {
        return A0k(j);
    }

    private final boolean A0p(long j, long j2) {
        return A0k(j) && j2 > SilenceSkippingAudioProcessor.DEFAULT_MINIMUM_SILENCE_DURATION_US;
    }

    private final boolean A0q(B0 b0, int i, long j, long j2) throws AD {
        int A1Q = A1Q(j2);
        if (A1Q == 0) {
            return false;
        }
        C6I c6i = super.A0h;
        int droppedSourceBufferCount = c6i.A06;
        c6i.A06 = droppedSourceBufferCount + 1;
        int droppedSourceBufferCount2 = this.A04;
        A0Q(droppedSourceBufferCount2 + A1Q);
        A1m();
        if (!this.A0r.A0G()) {
            return true;
        }
        this.A0r.A09();
        throw null;
    }

    private boolean A0r(B3 b3) {
        return C5C.A02 >= 23 && this.A0e && !this.A0k && !A0u(b3.A03) && (!b3.A06 || DummySurface.A05(this.A0q));
    }

    private final boolean A0u(String str) {
        char c = 0;
        if (str.startsWith(A0B(743, 10, 61))) {
            return false;
        }
        synchronized (AnonymousClass10.class) {
            if (!A10) {
                if (A0B(1253, 6, 98).equals(C5C.A03)) {
                    A0z = true;
                } else {
                    char c2 = 27;
                    if (C5C.A02 <= 27 && A0B(563, 5, 2).equals(C5C.A03)) {
                        A0z = true;
                    } else if (C5C.A02 < 27) {
                        String str2 = C5C.A03;
                        switch (str2.hashCode()) {
                            case -2144781245:
                                if (str2.equals(A0B(423, 14, 80))) {
                                    c2 = '+';
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case -2144781185:
                                if (str2.equals(A0B(437, 14, 87))) {
                                    c2 = AbstractJsonLexerKt.COMMA;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case -2144781160:
                                if (str2.equals(A0B(451, 14, 23))) {
                                    c2 = '-';
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case -2097309513:
                                if (str2.equals(A0B(604, 6, 104))) {
                                    c2 = '?';
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case -2022874474:
                                if (str2.equals(A0B(Sdk.SDKError.Reason.AD_RESPONSE_RETRY_AFTER_VALUE, 10, 59))) {
                                    c2 = 19;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case -1978993182:
                                if (str2.equals(A0B(731, 6, 0))) {
                                    c2 = GMTDateParser.MONTH;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case -1978990237:
                                if (str2.equals(A0B(737, 6, 72))) {
                                    c2 = 'N';
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case -1936688988:
                                if (str2.equals(A0B(777, 6, 31))) {
                                    c2 = 'X';
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case -1936688066:
                                if (str2.equals(A0B(783, 6, 81))) {
                                    c2 = GMTDateParser.YEAR;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case -1936688065:
                                if (str2.equals(A0B(789, 6, 44))) {
                                    c2 = 'Z';
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case -1931988508:
                                if (str2.equals(A0B(138, 10, 6))) {
                                    c2 = 11;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case -1696512866:
                                if (str2.equals(A0B(1137, 6, Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE))) {
                                    c2 = AbstractJsonLexerKt.BEGIN_OBJ;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case -1680025915:
                                if (str2.equals(A0B(280, 7, 111))) {
                                    c2 = 18;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case -1615810839:
                                if (str2.equals(A0B(EventTypeExtended.EVENT_TYPE_EXTENDED_LURL_VALUE, 8, 98))) {
                                    c2 = AbstractJsonLexerKt.BEGIN_LIST;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case -1554255044:
                                if (str2.equals(A0B(1626, 9, 41))) {
                                    c2 = 't';
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case -1481772737:
                                if (str2.equals(A0B(1494, 9, 63))) {
                                    c2 = 'T';
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case -1481772730:
                                if (str2.equals(A0B(Hd.c.f, 9, Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE))) {
                                    c2 = 'U';
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case -1481772729:
                                if (str2.equals(A0B(1512, 9, 46))) {
                                    c2 = 'V';
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case -1320080169:
                                if (str2.equals(A0B(521, 14, 74))) {
                                    c2 = ')';
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case -1217592143:
                                if (str2.equals(A0B(193, 11, 54))) {
                                    c2 = 15;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case -1180384755:
                                if (str2.equals(A0B(1353, 6, 98))) {
                                    c2 = ';';
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case -1139198265:
                                if (str2.equals(A0B(1015, 9, 28))) {
                                    c2 = GMTDateParser.HOURS;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case -1052835013:
                                if (str2.equals(A0B(1466, 6, 37))) {
                                    c2 = 'K';
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case -993250464:
                                if (str2.equals(A0B(12, 7, 120))) {
                                    c2 = 3;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case -993250458:
                                if (str2.equals(A0B(19, 7, 110))) {
                                    c2 = 4;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case -965403638:
                                if (str2.equals(A0B(1564, 8, 27))) {
                                    c2 = 'j';
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case -958336948:
                                if (str2.equals(A0B(324, 11, 1))) {
                                    c2 = 29;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case -879245230:
                                if (str2.equals(A0B(1603, 6, 14))) {
                                    c2 = 'p';
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case -842500323:
                                if (str2.equals(A0B(1472, 10, 29))) {
                                    c2 = 'L';
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case -821392978:
                                if (str2.equals(A0B(39, 7, 16))) {
                                    c2 = 7;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case -797483286:
                                if (str2.equals(A0B(1006, 9, 104))) {
                                    c2 = 'i';
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case -794946968:
                                if (str2.equals(A0B(1743, 6, 54))) {
                                    c2 = AbstractJsonLexerKt.UNICODE_ESC;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case -788334647:
                                if (str2.equals(A0B(1749, 6, 88))) {
                                    c2 = 'v';
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case -782144577:
                                if (str2.equals(A0B(753, 9, 85))) {
                                    c2 = 'O';
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case -575125681:
                                if (str2.equals(A0B(507, 14, 73))) {
                                    c2 = '(';
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case -521118391:
                                if (str2.equals(A0B(409, 14, 16))) {
                                    c2 = GMTDateParser.ANY;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case -430914369:
                                if (str2.equals(A0B(817, 10, 78))) {
                                    c2 = AbstractJsonLexerKt.STRING_ESC;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case -290434366:
                                if (str2.equals(A0B(1594, 9, Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE))) {
                                    c2 = 'k';
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case -282781963:
                                if (str2.equals(A0B(171, 8, Sdk.SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE))) {
                                    c2 = 14;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case -277133239:
                                if (str2.equals(A0B(1143, 7, 77))) {
                                    c2 = '|';
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case -173639913:
                                if (str2.equals(A0B(292, 12, 77))) {
                                    c2 = 26;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case -56598463:
                                if (str2.equals(A0B(1767, 8, 41))) {
                                    c2 = 'x';
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 2126:
                                if (str2.equals(A0B(Sdk.SDKError.Reason.MRAID_JS_DOES_NOT_EXIST_VALUE, 2, 93))) {
                                    c2 = 17;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 2564:
                                if (str2.equals(A0B(856, 2, 42))) {
                                    c2 = GMTDateParser.DAY_OF_MONTH;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 2715:
                                if (str2.equals(A0B(1114, 2, 74))) {
                                    c2 = 'q';
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 2719:
                                if (str2.equals(A0B(1121, 2, 19))) {
                                    c2 = GMTDateParser.SECONDS;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 3483:
                                if (str2.equals(A0B(1456, 2, 8))) {
                                    c2 = 'H';
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 73405:
                                if (str2.equals(A0B(594, 3, 12))) {
                                    c2 = Typography.greater;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 75739:
                                if (str2.equals(A0B(668, 3, 33))) {
                                    c2 = 'D';
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 76779:
                                if (str2.equals(A0B(679, 3, 19))) {
                                    c2 = 'J';
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 78669:
                                if (str2.equals(A0B(766, 3, 39))) {
                                    c2 = 'R';
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 79305:
                                if (str2.equals(A0B(795, 3, 93))) {
                                    c2 = '^';
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 80618:
                                if (str2.equals(A0B(866, 3, 45))) {
                                    c2 = 'f';
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 88274:
                                if (str2.equals(A0B(1150, 3, 69))) {
                                    c2 = AbstractJsonLexerKt.END_OBJ;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 98846:
                                if (str2.equals(A0B(1247, 3, Sdk.SDKError.Reason.INVALID_ADS_ENDPOINT_VALUE))) {
                                    c2 = 22;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 98848:
                                if (str2.equals(A0B(1250, 3, 4))) {
                                    c2 = 23;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 99329:
                                if (str2.equals(A0B(1259, 3, 97))) {
                                    c2 = 24;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 101481:
                                if (str2.equals(A0B(1277, 3, 5))) {
                                    c2 = Typography.amp;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 1513190:
                                if (str2.equals(A0B(0, 4, 40))) {
                                    c2 = 0;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 1514184:
                                if (str2.equals(A0B(4, 4, 40))) {
                                    c2 = 1;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 1514185:
                                if (str2.equals(A0B(8, 4, 36))) {
                                    c2 = 2;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 2436959:
                                if (str2.equals(A0B(762, 4, Sdk.SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE))) {
                                    c2 = 'Q';
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 2463773:
                                if (str2.equals(A0B(838, 4, 35))) {
                                    c2 = '`';
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 2464648:
                                if (str2.equals(A0B(847, 4, 65))) {
                                    c2 = 'b';
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 2689555:
                                if (str2.equals(A0B(1133, 4, 2))) {
                                    c2 = GMTDateParser.ZONE;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 3154429:
                                if (str2.equals(A0B(1296, 4, 94))) {
                                    c2 = '\'';
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 3284551:
                                if (str2.equals(A0B(1376, 4, 47))) {
                                    c2 = '@';
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 3351335:
                                if (str2.equals(A0B(1458, 4, 65))) {
                                    c2 = 'I';
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 3386211:
                                if (str2.equals(A0B(1482, 4, 48))) {
                                    c2 = 'P';
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 41325051:
                                if (str2.equals(A0B(671, 8, 34))) {
                                    c2 = 'G';
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 55178625:
                                if (str2.equals(A0B(160, 11, 108))) {
                                    c2 = '\r';
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 61542055:
                                if (str2.equals(A0B(26, 5, 78))) {
                                    c2 = 5;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 65355429:
                                if (str2.equals(A0B(MBSupportMuteAdType.INTERSTITIAL_VIDEO, 5, 54))) {
                                    c2 = 25;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 66214468:
                                if (str2.equals(A0B(345, 5, Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE))) {
                                    c2 = 31;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 66214470:
                                if (str2.equals(A0B(350, 5, 103))) {
                                    c2 = ' ';
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 66214473:
                                if (str2.equals(A0B(355, 5, 34))) {
                                    c2 = '!';
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 66215429:
                                if (str2.equals(A0B(360, 5, 13))) {
                                    c2 = '\"';
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 66215431:
                                if (str2.equals(A0B(365, 5, 1))) {
                                    c2 = '#';
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 66215433:
                                if (str2.equals(A0B(370, 5, 73))) {
                                    c2 = Typography.dollar;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 66216390:
                                if (str2.equals(A0B(375, 5, 7))) {
                                    c2 = '%';
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 76402249:
                                if (str2.equals(A0B(798, 5, 34))) {
                                    c2 = '_';
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 76404105:
                                if (str2.equals(A0B(842, 5, 99))) {
                                    c2 = 'a';
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 76404911:
                                if (str2.equals(A0B(851, 5, 19))) {
                                    c2 = 'c';
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 80963634:
                                if (str2.equals(A0B(1116, 5, 14))) {
                                    c2 = 'r';
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 82882791:
                                if (str2.equals(A0B(1128, 5, 88))) {
                                    c2 = 'y';
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 98715550:
                                if (str2.equals(A0B(1334, 5, 50))) {
                                    c2 = '8';
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 101370885:
                                if (str2.equals(A0B(1380, 5, 40))) {
                                    c2 = 'A';
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 102844228:
                                if (str2.equals(A0B(1385, 5, 5))) {
                                    c2 = 'B';
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 165221241:
                                if (str2.equals(A0B(31, 8, 7))) {
                                    c2 = 6;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 182191441:
                                if (str2.equals(A0B(237, 9, 32))) {
                                    c2 = 21;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 245388979:
                                if (str2.equals(A0B(1415, 8, Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE))) {
                                    c2 = 'F';
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 287431619:
                                if (str2.equals(A0B(1300, 7, 91))) {
                                    c2 = '1';
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 307593612:
                                if (str2.equals(A0B(55, 8, 62))) {
                                    c2 = '\t';
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 308517133:
                                if (str2.equals(A0B(63, 8, 33))) {
                                    c2 = '\n';
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 316215098:
                                if (str2.equals(A0B(IronSourceError.ERROR_IS_LOAD_DURING_SHOW, 8, 35))) {
                                    c2 = 'l';
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 316215116:
                                if (str2.equals(A0B(IronSourceError.ERROR_NT_LOAD_FAILED_NO_CANDIDATES, 8, 35))) {
                                    c2 = GMTDateParser.MINUTES;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 316246811:
                                if (str2.equals(A0B(1053, 8, 93))) {
                                    c2 = 'n';
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 316246818:
                                if (str2.equals(A0B(IronSourceError.ERROR_DO_IS_LOAD_MISSING_ACTIVITY, 8, 49))) {
                                    c2 = 'o';
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 407160593:
                                if (str2.equals(A0B(827, 11, 88))) {
                                    c2 = AbstractJsonLexerKt.END_LIST;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 507412548:
                                if (str2.equals(A0B(858, 8, 36))) {
                                    c2 = 'e';
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 793982701:
                                if (str2.equals(A0B(465, 14, 65))) {
                                    c2 = '.';
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 794038622:
                                if (str2.equals(A0B(479, 14, 24))) {
                                    c2 = '/';
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 794040393:
                                if (str2.equals(A0B(493, 14, 60))) {
                                    c2 = '0';
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 835649806:
                                if (str2.equals(A0B(1408, 7, 9))) {
                                    c2 = 'E';
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 917340916:
                                if (str2.equals(A0B(46, 9, 71))) {
                                    c2 = '\b';
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 958008161:
                                if (str2.equals(A0B(1367, 9, 39))) {
                                    c2 = D5.T;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 1060579533:
                                if (str2.equals(A0B(1486, 8, 24))) {
                                    c2 = 'S';
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 1150207623:
                                if (str2.equals(A0B(LevelPlayAdError.ERROR_CODE_NO_AD_UNIT_ID_SPECIFIED, 7, 16))) {
                                    c2 = 'C';
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 1176899427:
                                if (str2.equals(A0B(1359, 8, 92))) {
                                    c2 = Typography.less;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 1280332038:
                                if (str2.equals(A0B(1327, 7, 64))) {
                                    c2 = '3';
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 1306947716:
                                if (str2.equals(A0B(335, 10, 87))) {
                                    c2 = 30;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 1349174697:
                                if (str2.equals(A0B(1313, 14, 80))) {
                                    c2 = '2';
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 1522194893:
                                if (str2.equals(A0B(1760, 7, 42))) {
                                    c2 = 'w';
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 1691543273:
                                if (str2.equals(A0B(230, 7, 44))) {
                                    c2 = 20;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 1709443163:
                                if (str2.equals(A0B(1339, 14, 3))) {
                                    c2 = '9';
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 1865889110:
                                if (str2.equals(A0B(1572, 7, 76))) {
                                    c2 = 'g';
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 1906253259:
                                if (str2.equals(A0B(769, 8, 4))) {
                                    c2 = 'W';
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 1977196784:
                                if (str2.equals(A0B(582, 12, 87))) {
                                    c2 = AbstractJsonLexerKt.COLON;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 2006372676:
                                if (str2.equals(A0B(204, 14, 75))) {
                                    c2 = 16;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 2029784656:
                                if (str2.equals(A0B(549, 7, 35))) {
                                    c2 = '4';
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 2030379515:
                                if (str2.equals(A0B(556, 7, 52))) {
                                    c2 = '5';
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 2033393791:
                                if (str2.equals(A0B(111, 12, 6))) {
                                    c2 = '\f';
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 2047190025:
                                if (str2.equals(A0B(Sdk.SDKError.Reason.AD_EXPIRED_VALUE, 10, Sdk.SDKError.Reason.TPAT_ERROR_VALUE))) {
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 2047252157:
                                if (str2.equals(A0B(Sdk.SDKError.Reason.LINK_COMMAND_OPEN_FAILED_VALUE, 10, 126))) {
                                    c2 = 28;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 2048319463:
                                if (str2.equals(A0B(568, 7, 80))) {
                                    c2 = '6';
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 2048855701:
                                if (str2.equals(A0B(575, 7, 68))) {
                                    c2 = '7';
                                    break;
                                }
                                c2 = 65535;
                                break;
                            default:
                                c2 = 65535;
                                break;
                        }
                        switch (c2) {
                            case 0:
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                            case '\b':
                            case '\t':
                            case '\n':
                            case 11:
                            case '\f':
                            case '\r':
                            case 14:
                            case 15:
                            case 16:
                            case 17:
                            case 18:
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                            case 23:
                            case 24:
                            case 25:
                            case 26:
                            case 27:
                            case 28:
                            case 29:
                            case 30:
                            case 31:
                            case ' ':
                            case '!':
                            case '\"':
                            case '#':
                            case '$':
                            case '%':
                            case '&':
                            case '\'':
                            case '(':
                            case ')':
                            case '*':
                            case '+':
                            case ',':
                            case '-':
                            case '.':
                            case '/':
                            case '0':
                            case '1':
                            case '2':
                            case '3':
                            case '4':
                            case '5':
                            case '6':
                            case '7':
                            case '8':
                            case '9':
                            case ':':
                            case ';':
                            case '<':
                            case '=':
                            case '>':
                            case '?':
                            case '@':
                            case 'A':
                            case 'B':
                            case 'C':
                            case 'D':
                            case 'E':
                            case 'F':
                            case 'G':
                            case TokenParametersOuterClass$TokenParameters.MEDIAMUTED_FIELD_NUMBER /* 72 */:
                            case TokenParametersOuterClass$TokenParameters.APPSETID_FIELD_NUMBER /* 73 */:
                            case 'J':
                            case 'K':
                            case 'L':
                            case Analytics.AnalyticsData.COUNT_IMP_FIELD_NUMBER /* 77 */:
                            case 'N':
                            case Analytics.AnalyticsData.EXTRA_SIGNALS_FIELD_NUMBER /* 79 */:
                            case Analytics.AnalyticsData.BOOT_TIME_FIELD_NUMBER /* 80 */:
                            case 'Q':
                            case 'R':
                            case 'S':
                            case 'T':
                            case 'U':
                            case 'V':
                            case 'W':
                            case 'X':
                            case 'Y':
                            case 'Z':
                            case '[':
                            case '\\':
                            case ']':
                            case MBSupportMuteAdType.REWARD_VIDEO /* 94 */:
                            case '_':
                            case '`':
                            case 'a':
                            case 'b':
                            case 'c':
                            case 'd':
                            case 'e':
                            case 'f':
                            case 'g':
                            case 'h':
                            case 'i':
                            case 'j':
                            case 'k':
                            case 'l':
                            case 'm':
                            case 'n':
                            case 'o':
                            case 'p':
                            case 'q':
                            case 'r':
                            case 's':
                            case 't':
                            case ASSET_FAILED_STATUS_CODE_VALUE:
                            case PROTOBUF_SERIALIZATION_ERROR_VALUE:
                            case JSON_ENCODE_ERROR_VALUE:
                            case 'x':
                            case TPAT_ERROR_VALUE:
                            case INVALID_ADS_ENDPOINT_VALUE:
                            case INVALID_RI_ENDPOINT_VALUE:
                            case INVALID_LOG_ERROR_ENDPOINT_VALUE:
                            case INVALID_METRICS_ENDPOINT_VALUE:
                                A0z = true;
                                break;
                        }
                        String str3 = C5C.A06;
                        switch (str3.hashCode()) {
                            case -2038157993:
                                if (str3.equals(A0B(877, 12, 88))) {
                                    c = '\b';
                                    break;
                                }
                                c = 65535;
                                break;
                            case -2038157992:
                                if (str3.equals(A0B(889, 12, 24))) {
                                    c = 5;
                                    break;
                                }
                                c = 65535;
                                break;
                            case -1984447159:
                                if (str3.equals(A0B(719, 6, 41))) {
                                    c = 15;
                                    break;
                                }
                                c = 65535;
                                break;
                            case -1458559768:
                                if (str3.equals(A0B(IronSourceError.ERROR_NT_LOAD_EXCEPTION, 14, 82))) {
                                    c = 16;
                                    break;
                                }
                                c = 65535;
                                break;
                            case -1337484257:
                                if (str3.equals(A0B(148, 12, 113))) {
                                    c = 20;
                                    break;
                                }
                                c = 65535;
                                break;
                            case -1152053872:
                                if (str3.equals(A0B(DescriptorProtos.Edition.EDITION_PROTO2_VALUE, 8, 36))) {
                                    c = 19;
                                    break;
                                }
                                c = 65535;
                                break;
                            case -1147076792:
                                if (str3.equals(A0B(LevelPlayAdError.ERROR_CODE_SHOW_WHILE_LOAD, 15, 104))) {
                                    c = 17;
                                    break;
                                }
                                c = 65535;
                                break;
                            case -708142633:
                                if (str3.equals(A0B(869, 8, Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE))) {
                                    c = 18;
                                    break;
                                }
                                c = 65535;
                                break;
                            case -594534941:
                                if (str3.equals(A0B(597, 7, 94))) {
                                    c = 2;
                                    break;
                                }
                                c = 65535;
                                break;
                            case -581948979:
                                if (str3.equals(A0B(1401, 7, 84))) {
                                    c = 11;
                                    break;
                                }
                                c = 65535;
                                break;
                            case -401692983:
                                if (str3.equals(A0B(964, 8, 47))) {
                                    c = 23;
                                    break;
                                }
                                c = 65535;
                                break;
                            case -399133966:
                                if (str3.equals(A0B(981, 8, 83))) {
                                    c = 7;
                                    break;
                                }
                                c = 65535;
                                break;
                            case -154985182:
                                if (str3.equals(A0B(Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE, 15, 63))) {
                                    c = '\t';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 2006354:
                                if (str3.equals(A0B(71, 4, 107))) {
                                    break;
                                }
                                c = 65535;
                                break;
                            case 2006367:
                                if (str3.equals(A0B(75, 4, 21))) {
                                    c = 1;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 81951059:
                                if (str3.equals(A0B(1123, 5, 24))) {
                                    c = 24;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 439365079:
                                if (str3.equals(A0B(535, 14, 20))) {
                                    c = 22;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 511748841:
                                if (str3.equals(A0B(972, 9, 76))) {
                                    c = '\f';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 619782645:
                                if (str3.equals(A0B(89, 11, 27))) {
                                    c = 4;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 619782647:
                                if (str3.equals(A0B(100, 11, 23))) {
                                    c = 21;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 632760191:
                                if (str3.equals(A0B(989, 9, 48))) {
                                    c = 25;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 807317112:
                                if (str3.equals(A0B(610, 7, 20))) {
                                    c = 14;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 807374834:
                                if (str3.equals(A0B(617, 7, 39))) {
                                    c = 6;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 1070811680:
                                if (str3.equals(A0B(646, 13, 42))) {
                                    c = '\r';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 1682560972:
                                if (str3.equals(A0B(79, 10, 61))) {
                                    c = 3;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 1921424370:
                                if (str3.equals(A0B(1024, 13, Sdk.SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE))) {
                                    c = 26;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 2133907258:
                                if (str3.equals(A0B(659, 9, Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE))) {
                                    c = '\n';
                                    break;
                                }
                                c = 65535;
                                break;
                            default:
                                c = 65535;
                                break;
                        }
                        switch (c) {
                            case 0:
                            case 1:
                            case 2:
                                A0z = true;
                                break;
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                            case '\b':
                            case '\t':
                            case '\n':
                            case 11:
                            case '\f':
                            case '\r':
                            case 14:
                            case 15:
                            case 16:
                            case 17:
                            case 18:
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                            case 23:
                            case 24:
                            case 25:
                            case 26:
                                A0z = true;
                                break;
                        }
                    }
                }
                A10 = true;
            }
        }
        return A0z;
    }

    public static boolean A0v(boolean z, C2489qI c2489qI, C2489qI c2489qI2) {
        return c2489qI.A0W.equals(c2489qI2.A0W) && c2489qI.A0F == c2489qI2.A0F && (z || (c2489qI.A0L == c2489qI2.A0L && c2489qI.A0A == c2489qI2.A0A)) && C5C.A1E(c2489qI.A0N, c2489qI2.A0N);
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC06471g, com.instagram.common.viewpoint.core.AE
    public final void A1X() {
        super.A1X();
        this.A09 = 0;
        this.A0A = 0;
        this.A0B = 0;
        this.A0J = SystemClock.elapsedRealtime();
        this.A0P = SystemClock.elapsedRealtime() * 1000;
        if (this.A0w) {
            this.A0s.A0D();
        }
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC06471g, com.instagram.common.viewpoint.core.AE
    public final void A1Y() {
        this.A0M = -9223372036854775807L;
        A0J();
        A0H();
        if (this.A0w) {
            this.A0s.A0E();
        }
        super.A1Y();
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC06471g, com.instagram.common.viewpoint.core.AE
    public final void A1Z() {
        this.A08 = -1;
        this.A06 = -1;
        this.A01 = -1.0f;
        this.A02 = -1.0f;
        this.A0R = -9223372036854775807L;
        this.A0O = -9223372036854775807L;
        this.A0C = 0;
        A0F();
        A0E();
        this.A0t.A08();
        this.A00 = null;
        this.A0k = false;
        this.A0A = 0;
        this.A0B = 0;
        A0G();
        try {
            super.A1Z();
        } finally {
            super.A0h.A02();
            this.A0u.A09(super.A0h);
        }
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC06471g, com.instagram.common.viewpoint.core.AE
    public final void A1a(long j, boolean z) throws AD {
        super.A1a(j, z);
        if (this.A0r.A0G()) {
            this.A0r.A09();
            throw null;
        }
        A0E();
        if (this.A0w) {
            this.A0s.A0C();
        }
        this.A0N = -9223372036854775807L;
        this.A0L = -9223372036854775807L;
        this.A0O = -9223372036854775807L;
        this.A0A = 0;
        this.A0B = 0;
        if (this.A0C != 0) {
            this.A0R = this.A0x[this.A0C - 1];
            this.A0C = 0;
        }
        if (z) {
            A0N();
        } else {
            this.A0M = -9223372036854775807L;
        }
        A0H();
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC06471g, com.instagram.common.viewpoint.core.AE
    public final void A1b(boolean z, boolean z2) throws AD {
        super.A1b(z, z2);
        this.A0k = A1V().A00;
        this.A0u.A0A(super.A0h);
        this.A0t.A09();
        this.A0g = z2;
        this.A0j = false;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC06471g, com.instagram.common.viewpoint.core.AE
    public final void A1c(C2489qI[] c2489qIArr, long j, long j2) throws AD {
        if (this.A0R == -9223372036854775807L) {
            this.A0R = j2;
        } else {
            if (this.A0C == this.A0x.length) {
                AbstractC07214g.A07(A0B(682, 23, 0), A0B(1069, 45, 88) + this.A0x[this.A0C - 1]);
            } else {
                this.A0C++;
            }
            long[] jArr = this.A0x;
            int i = this.A0C - 1;
            if (A12[1].charAt(20) != 's') {
                throw new RuntimeException();
            }
            A12[2] = "SAUgnWkYDj4XEzprgfj9YLgtcmW5pkCR";
            jArr[i] = j2;
            this.A0y[this.A0C - 1] = this.A0O;
        }
        super.A1c(c2489qIArr, j, j2);
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC06471g
    public final int A1g(B0 b0, B3 b3, C2489qI c2489qI, C2489qI c2489qI2) {
        if (AbstractC2056is.A04(this.A0z, c2489qI.A0L, c2489qI.A0A, c2489qI2.A0L, c2489qI2.A0A)) {
            return 0;
        }
        if (A21() && c2489qI.A0W.equals(c2489qI2.A0W) && c2489qI.A0F == c2489qI2.A0F) {
            return 1;
        }
        if (!A0v(b3.A04, c2489qI, c2489qI2) || c2489qI2.A0L > this.A0W.A02 || c2489qI2.A0A > this.A0W.A00 || A00(c2489qI2) > this.A0W.A01) {
            return 0;
        }
        boolean A0A = c2489qI.A0A(c2489qI2);
        if (A12[2].charAt(6) == 'n') {
            throw new RuntimeException();
        }
        A12[2] = "4hDLfGBXu2jWhDFi4VyshDOfpKmyRTIF";
        return A0A ? 1 : 3;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC06471g
    public final int A1h(BT bt, A6 a6, C2489qI c2489qI) throws BX {
        if (A24(c2489qI)) {
            return 20;
        }
        return A01(bt, c2489qI, super.A0j);
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC06471g
    public final List<B3> A1l(BT bt, C2489qI c2489qI, boolean z) throws BX {
        return A0D(bt, c2489qI, z);
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC06471g
    public final void A1m() throws AD {
        super.A1m();
        this.A04 = 0;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC06471g
    public final void A1n() {
        try {
            super.A1n();
            this.A04 = 0;
            if (this.A0T != null) {
                if (this.A0U == this.A0T) {
                    this.A0U = null;
                }
                this.A0T.release();
                if (A12[3].length() == 21) {
                    throw new RuntimeException();
                }
                String[] strArr = A12;
                strArr[4] = "7lrYh0KktVrYvVNtOiQ9Yi2M4ixXH9PV";
                strArr[7] = "rg1WGkW3vr4OYC0nZllkbznbWLz7shBk";
                this.A0T = null;
            }
        } catch (Throwable th) {
            this.A04 = 0;
            if (this.A0T != null) {
                if (this.A0U == this.A0T) {
                    this.A0U = null;
                }
                this.A0T.release();
                this.A0T = null;
            }
            throw th;
        }
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC06471g
    public final void A1q(long j) {
        super.A1q(j);
        this.A04--;
        while (this.A0C != 0 && j >= this.A0y[0]) {
            this.A0R = this.A0x[0];
            this.A0C--;
            System.arraycopy(this.A0x, 1, this.A0x, 0, this.A0C);
            System.arraycopy(this.A0y, 1, this.A0y, 0, this.A0C);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0022  */
    @Override // com.instagram.common.viewpoint.core.AbstractC06471g
    @MetaExoPlayerCustomization("for SR video effects support of MCM")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void A1r(C2489qI c2489qI) {
        boolean isSwitchingToDav1d;
        if (A24(c2489qI)) {
            if (super.A0g != null) {
                if (!A0B(1645, 10, 45).equals(super.A0g.A0W)) {
                    isSwitchingToDav1d = true;
                    if (isSwitchingToDav1d) {
                        boolean isSwitchingToDav1d2 = this.A0r.A0G();
                        if (isSwitchingToDav1d2) {
                            this.A0r.A0A();
                            throw null;
                        }
                    }
                    this.A0r.A09 = false;
                    if (A12[2].charAt(6) != 'n') {
                        throw new RuntimeException();
                    }
                    String[] strArr = A12;
                    strArr[5] = "sIGbpbi";
                    strArr[0] = "eroBYPH";
                    return;
                }
            }
            isSwitchingToDav1d = false;
            if (isSwitchingToDav1d) {
            }
            this.A0r.A09 = false;
            if (A12[2].charAt(6) != 'n') {
            }
        } else {
            int A00 = MetaExoPlayerUpgradeConfig.A00(EnumC2090jY.A09);
            if (A00 <= 0 || c2489qI == null) {
                return;
            }
            int videoWidthToEnableSR = c2489qI.A0L;
            if (videoWidthToEnableSR <= A00) {
                return;
            }
            this.A0r.A09 = false;
        }
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC06471g
    public final void A1s(C2489qI c2489qI) throws AD {
        super.A1s(c2489qI);
        this.A0u.A05(c2489qI, null);
        this.A02 = c2489qI.A02;
        this.A0D = c2489qI.A0F;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC06471g
    public final void A1t(C2489qI c2489qI) throws AD {
        if (!this.A0r.A0G()) {
            this.A0r.A0J(c2489qI, A1i());
        }
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC06471g
    public final void A1u(C2410p0 c2410p0) {
        this.A04++;
        this.A0O = Math.max(c2410p0.A01, this.A0O);
        if (C5C.A02 < 23 && this.A0k) {
            A27();
        }
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC06471g
    public final void A1v(B0 b0, MediaFormat mediaFormat) {
        int integer;
        int integer2;
        this.A0S = mediaFormat;
        String A0B = A0B(1229, 10, 102);
        boolean containsKey = mediaFormat.containsKey(A0B);
        String A0B2 = A0B(1239, 8, 55);
        String A0B3 = A0B(1209, 11, 126);
        String A0B4 = A0B(1220, 9, 2);
        boolean z = containsKey && mediaFormat.containsKey(A0B4) && mediaFormat.containsKey(A0B3) && mediaFormat.containsKey(A0B2);
        if (z) {
            int integer3 = mediaFormat.getInteger(A0B);
            int unappliedRotationDegrees = mediaFormat.getInteger(A0B4);
            integer = (integer3 - unappliedRotationDegrees) + 1;
        } else {
            integer = mediaFormat.getInteger(A0B(1755, 5, 79));
        }
        this.A08 = integer;
        if (z) {
            int integer4 = mediaFormat.getInteger(A0B3);
            int unappliedRotationDegrees2 = mediaFormat.getInteger(A0B2);
            integer2 = (integer4 - unappliedRotationDegrees2) + 1;
        } else {
            integer2 = mediaFormat.getInteger(A0B(1307, 6, 73));
        }
        this.A06 = integer2;
        this.A01 = this.A02;
        if (C5C.A02 >= 21) {
            if (this.A0D == 90 || this.A0D == 270) {
                int rotatedHeight = this.A08;
                int unappliedRotationDegrees3 = this.A06;
                this.A08 = unappliedRotationDegrees3;
                this.A06 = rotatedHeight;
                this.A01 = 1.0f / this.A01;
            }
        } else if (!this.A0r.A0G()) {
            int unappliedRotationDegrees4 = this.A0D;
            this.A07 = unappliedRotationDegrees4;
        }
        int unappliedRotationDegrees5 = this.A0H;
        b0.AJs(unappliedRotationDegrees5);
        this.A0V = new C2442pW(this.A08, this.A06, this.A07, this.A01);
        this.A0s.A0F(super.A0g.A01);
        if (this.A0r.A0G()) {
            C0995Fo c0995Fo = this.A0r;
            C06802p A07 = super.A0g.A07();
            int unappliedRotationDegrees6 = this.A08;
            C06802p A0r = A07.A0r(unappliedRotationDegrees6);
            int unappliedRotationDegrees7 = this.A06;
            C06802p A0f = A0r.A0f(unappliedRotationDegrees7);
            int unappliedRotationDegrees8 = this.A07;
            c0995Fo.A0D(A0f.A0l(unappliedRotationDegrees8).A0Y(this.A01).A14());
            throw null;
        }
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC06471g
    @MetaExoPlayerCustomizations({@MetaExoPlayerCustomization("D40834768: [FBLite][Video] Enable low latency decoding for older Android versions"), @MetaExoPlayerCustomization(type = {"TEMPORARY"}, value = "Google Platform Dav1d Testing with Low Latency Decoding D62649046")})
    public final void A1w(B3 b3, B0 b0, C2489qI c2489qI, MediaCrypto mediaCrypto) throws BX {
        this.A0W = A0A(b3, c2489qI, A1e());
        MediaFormat A08 = A08(c2489qI, this.A0W, this.A0v, this.A0o);
        if (this.A0U == null) {
            AbstractC07133y.A08(A0r(b3));
            if (this.A0T == null) {
                Context context = this.A0q;
                boolean z = b3.A06;
                if (A12[3].length() != 21) {
                    A12[6] = "yiNR3QranPnEQfiPRrhMyH37rGbgy01y";
                    this.A0T = DummySurface.A01(context, z);
                }
                throw new RuntimeException();
            }
            Surface surface = this.A0T;
            if (A12[2].charAt(6) != 'n') {
                String[] strArr = A12;
                strArr[5] = "LRboFGG";
                strArr[0] = "hwnKdFV";
                this.A0U = surface;
            }
            throw new RuntimeException();
        }
        boolean z2 = this.A0z.A0I;
        boolean z3 = false;
        String A0B = A0B(1390, 11, 76);
        boolean z4 = z2 && b3.A00 != null && b3.A00.isFeatureSupported(A0B);
        if (b3.A03.equals(A0B(1181, 28, 58)) && this.A0z.A0B) {
            z3 = true;
        }
        if ((C5C.A02 >= 30 || this.A0z.A0J) && z4 && !z3) {
            A08.setFeatureEnabled(A0B, true);
            String[] strArr2 = A12;
            if (strArr2[5].length() != strArr2[0].length()) {
                String[] strArr3 = A12;
                strArr3[5] = "hfJ3VMX";
                strArr3[0] = "92OmzWl";
                A08.setInteger(A0B, 1);
            } else {
                A12[3] = "U57WE1Icqa5Z";
                A08.setInteger(A0B, 1);
            }
        }
        if (this.A0r.A0G()) {
            A08 = this.A0r.A06(A08);
        }
        if (this.A0r.A0G()) {
            C0995Fo c0995Fo = this.A0r;
            String[] strArr4 = A12;
            if (strArr4[4].charAt(23) == strArr4[7].charAt(23)) {
                throw new RuntimeException();
            }
            String[] strArr5 = A12;
            strArr5[4] = "vjf6uovaHCWDHHkpYfphkXQkMzg9bbjD";
            strArr5[7] = "sOVWNDiAOc7Hvgm0kOVhLN9DKu4y3eSs";
            c0995Fo.A07();
            throw null;
        }
        b0.A58(A08, this.A0U, mediaCrypto, 0, this.A0Y);
        int i = C5C.A02;
        if (A12[6].charAt(29) != 'x') {
            A12[1] = "mXryJuZr86dScF3AeNkyss5tnbfSKjka";
            if (i < 23) {
                return;
            }
        } else {
            A12[6] = "iNbmoOXFYL62OfUeH4JwG1appoAFSKUM";
            if (i < 21) {
                return;
            }
        }
        if (this.A0k) {
            this.A00 = new C2292n5(this, b0);
        }
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC06471g
    @MetaExoPlayerCustomization("D45988204: [FBLite][Video] Add Codec Hooks for Logging")
    public final void A1x(String str) {
        this.A0u.A0F(str);
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC06471g
    public final void A1y(String str, long j, long j2) {
        this.A0u.A0G(str, j, j2);
        this.A0b = A0u(str);
        if (this.A0w) {
            C0995Fo c0995Fo = this.A0r;
            if (A12[1].charAt(20) != 's') {
                throw new RuntimeException();
            }
            String[] strArr = A12;
            strArr[4] = "TMyTJm2xfuZjG3FrE9xxFPlKyVDcqwcD";
            strArr[7] = "gYDTbLVVgSlIu0qIAiA5ri17AONkCNH7";
            c0995Fo.A0E(str);
        }
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC06471g
    @MetaExoPlayerCustomization(type = {"TEMPORARY"}, value = "D60404164: Merge init calls in the renderer")
    public final void A1z(String str, C2489qI c2489qI) throws AD {
        this.A0u.A0F(str);
        if (!this.A0r.A0G()) {
            this.A0r.A0J(c2489qI, A1i());
        }
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC06471g
    public final boolean A20() {
        return this.A0a && SystemClock.elapsedRealtime() - this.A0Q < 500;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC06471g
    public final boolean A22() {
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:110:0x0261, code lost:
    
        if (r6 < com.unity3d.services.core.di.ServiceProvider.SCAR_SIGNALS_FETCH_TIMEOUT) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0269, code lost:
    
        A0a(r42, r44, r0, r28);
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0272, code lost:
    
        r37.A0K = -9223372036854775807L;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x027a, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x027b, code lost:
    
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x0280, code lost:
    
        if (A0g() != false) goto L122;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x0282, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x0283, code lost:
    
        throw r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x02d4, code lost:
    
        if (r7 != (-1.0f)) goto L144;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x02d6, code lost:
    
        r0 = r37.A0g.A01;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x02ef, code lost:
    
        r0 = 30.0f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x02ec, code lost:
    
        if (r7 != (-1.0f)) goto L144;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x0266, code lost:
    
        if (r6 < com.unity3d.services.core.di.ServiceProvider.SCAR_SIGNALS_FETCH_TIMEOUT) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x01dd, code lost:
    
        if (A0q(r42, r44, r0, r38) != false) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x01c5, code lost:
    
        if (A0q(r42, r44, r0, r38) != false) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x01c7, code lost:
    
        return false;
     */
    @Override // com.instagram.common.viewpoint.core.AbstractC06471g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean A23(long presentationTimeUs, long j, B0 b0, ByteBuffer byteBuffer, int i, int i2, long presentationTimeUs2, boolean z, boolean isStarted) throws AD {
        int i3;
        long presentationTimeUs3;
        int i4;
        float f;
        A0I();
        if (this.A0L == -9223372036854775807L) {
            this.A0L = presentationTimeUs;
        }
        if (presentationTimeUs2 != this.A0N) {
            C0995Fo c0995Fo = this.A0r;
            String[] strArr = A12;
            if (strArr[4].charAt(23) != strArr[7].charAt(23)) {
                A12[6] = "L0kRAN56GCoM9aTEFIfEof2AhWTAPhww";
                if (!c0995Fo.A0G()) {
                    this.A0s.A0G(presentationTimeUs2);
                }
                this.A0N = presentationTimeUs2;
            }
            throw new RuntimeException();
        }
        long elapsedSinceStartOfLoopUs = presentationTimeUs2 - this.A0R;
        if (z) {
            A0Z(b0, i, elapsedSinceStartOfLoopUs);
            this.A0K = -9223372036854775807L;
            return true;
        }
        long j2 = presentationTimeUs2 - presentationTimeUs;
        if (this.A0U == this.A0T) {
            if (!A0k(j2)) {
                return false;
            }
            A0Z(b0, i, elapsedSinceStartOfLoopUs);
            this.A0K = -9223372036854775807L;
            return true;
        }
        long elapsedRealtimeNowUs = SystemClock.elapsedRealtime() * 1000;
        boolean z2 = A9A() == 2;
        if (this.A0i) {
            if (!z2 || !A0p(j2, elapsedRealtimeNowUs - this.A0P)) {
                if (!z2 || presentationTimeUs == this.A0L) {
                    return false;
                }
                long j3 = j2 - (elapsedRealtimeNowUs - j);
                long nanoTime = System.nanoTime();
                long systemTimeNs = this.A0t.A07(presentationTimeUs2, nanoTime + (j3 * 1000));
                if (!this.A0r.A0G()) {
                    long j4 = systemTimeNs - nanoTime;
                    if (A12[1].charAt(20) != 's') {
                        A12[6] = "i4qTewa8ZWbDA8s4kXcKcwjveHudTAS9";
                        j3 = j4 / 1000;
                    } else {
                        A12[1] = "gEfAYqDTponyW9gbewcXscS7fdpN1mCh";
                        j3 = j4 / 1000;
                    }
                }
                boolean A0n = A0n(j3, j);
                String[] strArr2 = A12;
                if (strArr2[5].length() == strArr2[0].length()) {
                    String[] strArr3 = A12;
                    strArr3[4] = "x3sCqHu2x6JsDcuqwdAUHQ0k2SaVNxNE";
                    strArr3[7] = "ynqO8npVIpgyPmtNsd5sQ1b1Keqzobw0";
                    if (A0n) {
                        i4 = 21;
                        if (A12[3].length() != 21) {
                            A12[2] = "Im0K8TG4eXiLHobEoWn7h9VZsIuUdU0F";
                        } else {
                            A12[1] = "TqRORNfXADShgAM6oQQosmDa9t1KVXi2";
                        }
                    } else {
                        i4 = 21;
                    }
                    boolean A0o = A0o(j3, j);
                    if (A12[1].charAt(20) != 's') {
                        throw new RuntimeException();
                    }
                    A12[1] = "PbABcFTeATAG8BdJ5MobsRcJEcYTdsNJ";
                    if (A0o) {
                        A0W(b0, i, elapsedSinceStartOfLoopUs);
                        return true;
                    }
                    if (this.A0r.A0G()) {
                        C0995Fo c0995Fo2 = this.A0r;
                        if (A12[1].charAt(20) != 's') {
                            throw new RuntimeException();
                        }
                        A12[6] = "xPxknUi3OsFzLFKEvylwNjXsMhIdmdKw";
                        c0995Fo2.A0B(presentationTimeUs, j);
                        this.A0r.A0K(super.A0g, elapsedSinceStartOfLoopUs, isStarted);
                        throw null;
                    }
                    if (C5C.A02 >= i4) {
                        String[] strArr4 = A12;
                        if (strArr4[4].charAt(23) != strArr4[7].charAt(23)) {
                            A12[6] = "ZYuml2WQS49YsB2SRefxlPdxR9rLTqpk";
                        }
                    } else if (j3 < 30000) {
                        if (j3 > 11000) {
                            try {
                                Thread.sleep((j3 - 10000) / 1000);
                            } catch (InterruptedException unused) {
                                Thread.currentThread().interrupt();
                                return false;
                            }
                        }
                        try {
                            A0X(b0, i, elapsedSinceStartOfLoopUs);
                            this.A0K = -9223372036854775807L;
                            return true;
                        } catch (IllegalStateException e) {
                            if (A0g()) {
                                return false;
                            }
                            throw e;
                        }
                    }
                    long j5 = presentationTimeUs2 - presentationTimeUs;
                    float f2 = super.A0g.A01;
                    if (A12[2].charAt(6) != 'n') {
                        A12[2] = "GJYVSkrq4PYvrBUDuc6fvsIBQLmbbZax";
                    } else {
                        A12[2] = "FfF70zljYTd7nA7n6wc9JJE9WyzKMeyw";
                    }
                    A0R(presentationTimeUs, j5, f);
                    return false;
                }
                throw new RuntimeException();
            }
            i3 = 21;
            String[] strArr5 = A12;
            if (strArr5[4].charAt(23) == strArr5[7].charAt(23)) {
                throw new RuntimeException();
            }
            A12[1] = "Ca6wrlcfbPJTUKGkRuSnscA1gW8xLMZW";
            presentationTimeUs3 = -9223372036854775807L;
        } else {
            i3 = 21;
            presentationTimeUs3 = -9223372036854775807L;
        }
        if (this.A0r.A0G()) {
            C0995Fo c0995Fo3 = this.A0r;
            C2489qI c2489qI = super.A0g;
            if (A12[6].charAt(29) != 'x') {
                A12[6] = "ALWZkOReLcoODcDx9aoBhmHDBkFgQP5j";
                c0995Fo3.A0K(c2489qI, elapsedSinceStartOfLoopUs, isStarted);
            } else {
                A12[3] = "ZbZVwQDkp8zHMkP4lXo6fzwP4kG7";
                c0995Fo3.A0K(c2489qI, elapsedSinceStartOfLoopUs, isStarted);
            }
            throw null;
        }
        if (C5C.A02 >= i3) {
            try {
            } catch (IllegalStateException e2) {
                e = e2;
            }
            try {
                A0b(b0, i, elapsedSinceStartOfLoopUs, System.nanoTime(), true);
            } catch (IllegalStateException e3) {
                e = e3;
                if (A0g()) {
                    return false;
                }
                throw e;
            }
        } else {
            try {
                A0X(b0, i, elapsedSinceStartOfLoopUs);
            } catch (IllegalStateException e4) {
                if (A0g()) {
                    return false;
                }
                throw e4;
            }
        }
        this.A0K = presentationTimeUs3;
        return true;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC06471g
    public final boolean A25(B3 b3) {
        return (this.A0U != null && (this.A0Z || this.A0U.isValid())) || A0r(b3);
    }

    public final Pair<ColorInfo, ColorInfo> A26(ColorInfo colorInfo) {
        if (!ColorInfo.A09(colorInfo)) {
            return Pair.create(ColorInfo.A09, ColorInfo.A09);
        }
        if (colorInfo.A03 == 7) {
            return Pair.create(colorInfo, colorInfo.A0A().A02(6).A03());
        }
        return Pair.create(colorInfo, colorInfo);
    }

    public final void A27() {
        this.A0j = true;
        if (!this.A0i) {
            this.A0i = true;
            this.A0u.A0D(this.A0U);
        }
    }

    @MetaExoPlayerCustomization("Required for VideoProcessorManager migration")
    public final boolean A28(long j, long j2, boolean z) {
        return A0k(j) && !z;
    }

    @Override // com.instagram.common.viewpoint.core.AE, com.instagram.common.viewpoint.core.InterfaceC07957c
    public final void A9i(int i, Object obj) throws AD {
        if (i == 1) {
            A0U((Surface) obj);
            return;
        }
        if (i == 4) {
            this.A0H = ((Integer) obj).intValue();
            B0 A1j = A1j();
            if (A1j == null) {
                return;
            }
            A1j.AJs(this.A0H);
            return;
        }
        if (i == 7) {
            this.A0X = (G2) obj;
            return;
        }
        if (i == 10001) {
            A0f(obj);
            return;
        }
        if (i == 13) {
            this.A0r.A0F((List) AbstractC07133y.A01(obj));
            return;
        }
        if (A12[3].length() != 21) {
            A12[1] = "MccsEzjpf2F4QgbfkxLUs5z2ugRdHbCL";
            if (i == 14) {
                C07404z c07404z = (C07404z) AbstractC07133y.A01(obj);
                if (c07404z.A03() == 0 || c07404z.A02() == 0) {
                    return;
                }
                Surface surface = this.A0U;
                String[] strArr = A12;
                if (strArr[5].length() == strArr[0].length()) {
                    A12[1] = "OmulH2jEP4hpWDROHXWwsVVsUaMV65qL";
                    if (surface == null) {
                        return;
                    }
                    this.A0r.A0C(this.A0U, c07404z);
                    return;
                }
            } else {
                super.A9i(i, obj);
                return;
            }
        }
        throw new RuntimeException();
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC06471g, com.instagram.common.viewpoint.core.InterfaceC2398oo
    public final boolean AAP() {
        boolean AAP = super.AAP();
        boolean isEnded = this.A0r.A0G();
        if (isEnded) {
            boolean isEnded2 = this.A0r.A0I();
            return AAP & isEnded2;
        }
        return AAP;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0065, code lost:
    
        if (r5 != null) goto L29;
     */
    @Override // com.instagram.common.viewpoint.core.AbstractC06471g, com.instagram.common.viewpoint.core.InterfaceC2398oo
    @MetaExoPlayerCustomizations({@MetaExoPlayerCustomization("D18870411: Adding start stall debug reason"), @MetaExoPlayerCustomization(type = {"FEATURE_LOGIC"}, value = "D69547806: Only become ready once we have a surface")})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean AAe() {
        if (super.AAe() && !this.A0i && ((this.A0T == null || this.A0U != this.A0T) && A1j() != null && !this.A0k)) {
            ((AE) this).A0B = EnumC2055ir.A08;
        }
        if (super.AAe() && (!this.A0r.A0G() || this.A0r.A0H())) {
            if (this.A0h) {
                Surface surface = this.A0U;
                if (A12[1].charAt(20) != 's') {
                    throw new RuntimeException();
                }
                String[] strArr = A12;
                strArr[5] = "iOSBWWk";
                strArr[0] = "3hctIGW";
            }
            if (this.A0i || ((this.A0T != null && this.A0U == this.A0T) || A1j() == null || this.A0k)) {
                this.A0M = -9223372036854775807L;
                return true;
            }
        }
        if (this.A0M == -9223372036854775807L) {
            return false;
        }
        if (SystemClock.elapsedRealtime() < this.A0M) {
            return true;
        }
        this.A0M = -9223372036854775807L;
        return false;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC06471g, com.instagram.common.viewpoint.core.InterfaceC2398oo
    public final void AIX(long j, long j2) throws AD {
        super.AIX(j, j2);
        if (this.A0r.A0G()) {
            this.A0r.A0B(j, j2);
        }
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2398oo, com.instagram.common.viewpoint.core.InterfaceC08087p
    public final String getName() {
        return A0B(682, 23, 0);
    }
}
