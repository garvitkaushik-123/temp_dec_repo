package com.instagram.common.viewpoint.core;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.vungle.ads.internal.protos.Sdk;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import kotlin.io.encoding.Base64;

@MetaExoPlayerCustomization("OculusDefaultDataSource extends this class and hence cannot be final")
/* loaded from: assets/audience_network/classes2.dex */
public final class AP implements InterfaceC2425pF {
    public static byte[] A0B;
    public static String[] A0C = {"tGdrGbTKqUAyZjAtECCaXso437TIFtay", "xasvTmVCH4LeG7al8p8ObQF4UIpko", "linuVDi59rGKxPba8cSgrQfx0g5xcZS0", "EsZJycHVVsXuEv", "at8NLtJKkPgo1aJyGFOZsbSRJOLI96cu", "TOIRSmJtL8rNzzbss9LVqHyYWtEEJZpF", "R6ga9urJMlxgk01j3rMsq3yEpAD", "8pNo6y0"};
    public InterfaceC2425pF A00;
    public InterfaceC2425pF A01;
    public InterfaceC2425pF A02;
    public InterfaceC2425pF A03;
    public InterfaceC2425pF A04;
    public InterfaceC2425pF A05;
    public InterfaceC2425pF A06;

    @MetaExoPlayerCustomization("OculusDefaultDataSource accesses this field directly")
    public InterfaceC2425pF A07;
    public final InterfaceC2425pF A08;

    @MetaExoPlayerCustomization("OculusDefaultDataSource accesses this field directly")
    public final Context A09;

    @MetaExoPlayerCustomization("OculusDefaultDataSource accesses this field directly")
    public final List<InterfaceC07605t> A0A = new ArrayList();

    public static String A07(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0B, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 6);
        }
        return new String(copyOfRange);
    }

    public static void A08() {
        A0B = new byte[]{Ascii.CAN, 86, 89, 83, 69, 88, 94, 83, 104, 86, 68, 68, 82, 67, Ascii.CAN, 76, 121, 121, 104, 96, 125, 121, 100, 99, 106, 45, 121, 98, 45, 125, 97, 108, 116, 45, 95, 89, SignedBytes.MAX_POWER_OF_TWO, 93, 45, 126, 121, Byte.MAX_VALUE, 104, 108, 96, 45, 122, 100, 121, 101, 98, 120, 121, 45, 105, 104, 125, 104, 99, 105, 100, 99, 106, 45, 98, 99, 45, 121, 101, 104, 45, 95, 89, SignedBytes.MAX_POWER_OF_TWO, 93, 45, 104, 117, 121, 104, 99, 126, 100, 98, 99, 83, 114, 113, 118, 98, 123, 99, 83, 118, 99, 118, 68, 120, 98, 101, 116, 114, 7, 48, 48, 45, 48, 98, 43, 44, 49, 54, 35, 44, 54, 43, 35, 54, 43, 44, 37, 98, Ascii.DLE, Ascii.SYN, Ascii.SI, Ascii.DC2, 98, 39, 58, 54, 39, 44, 49, 43, 45, 44, 70, 73, 67, 85, 72, 78, 67, 9, 85, 66, 84, 72, 82, 85, 68, 66, 48, 34, 34, 52, 37, 38, 42, 40, 107, 35, 36, 38, 32, 39, 42, 42, 46, 107, 36, 33, 54, 107, 34, 42, 42, 34, 41, 32, 107, 36, 43, 33, 55, 42, 44, 33, 107, 32, Base64.padSymbol, 42, 53, 41, 36, 60, 32, 55, 119, 107, 32, Base64.padSymbol, 49, 107, 55, 49, 40, 53, 107, Ascii.ETB, 49, 40, 53, 1, 36, 49, 36, Ascii.SYN, 42, 48, 55, 38, 32, Ascii.FF, 0, 1, Ascii.ESC, 10, 1, Ascii.ESC, 63, 58, 47, 58, 51, 32, 54, 51, 36, 50, 46, 52, 51, 34, 36, 75, 77, 84, 73, 70, 87, 67};
    }

    static {
        A08();
    }

    public AP(Context context, InterfaceC2425pF interfaceC2425pF) {
        this.A09 = context.getApplicationContext();
        this.A08 = (InterfaceC2425pF) AbstractC07133y.A01(interfaceC2425pF);
    }

    private InterfaceC2425pF A00() {
        if (this.A00 == null) {
            final Context context = this.A09;
            this.A00 = new AQ(context) { // from class: com.facebook.ads.redexgen.X.1n
                public static byte[] A05;
                public static String[] A06 = {"PTz87XAKzq7jvDXOa", "sgpUZ", "Bde9N92B9PLOW1wkk", "DRZuAIPcc", "gakZC5ePxUI2GDKV9", "pz9vQcEWFJbuREE6smExYo368tZlwkrG", "j43UPSzsV7IrH", "51Zh85ddLdY4jrUIDlK8L"};
                public long A00;
                public Uri A01;
                public InputStream A02;
                public boolean A03;
                public final AssetManager A04;

                public static String A00(int i, int i2, int i3) {
                    byte[] copyOfRange = Arrays.copyOfRange(A05, i, i + i2);
                    for (int i4 = 0; i4 < copyOfRange.length; i4++) {
                        int i5 = (copyOfRange[i4] ^ i3) ^ 113;
                        String[] strArr = A06;
                        if (strArr[2].length() != strArr[4].length()) {
                            throw new RuntimeException();
                        }
                        A06[1] = "rCVU";
                        copyOfRange[i4] = (byte) i5;
                    }
                    return new String(copyOfRange);
                }

                public static void A01() {
                    A05 = new byte[]{124, 116, 58, 53, 63, 41, 52, 50, 63, 4, 58, 40, 40, 62, 47, 116};
                }

                /* JADX WARN: Failed to parse debug info
                java.lang.ArrayIndexOutOfBoundsException
                 */
                @Override // com.instagram.common.viewpoint.core.InterfaceC2425pF
                public final long AGi(C07495i c07495i) throws C2427pH {
                    try {
                        this.A01 = c07495i.A06;
                        String str = (String) AbstractC07133y.A01(this.A01.getPath());
                        boolean startsWith = str.startsWith(A00(1, 15, 42));
                        String[] strArr = A06;
                        if (strArr[2].length() == strArr[4].length()) {
                            String[] strArr2 = A06;
                            strArr2[2] = "3xdRIl55zUe0UeQhp";
                            strArr2[4] = "pS29hwepCfn47vExr";
                            if (startsWith) {
                                str = str.substring(15);
                            } else if (str.startsWith(A00(0, 1, 34))) {
                                str = str.substring(1);
                            }
                            A0G(c07495i);
                            this.A02 = this.A04.open(str, 1);
                            if (this.A02.skip(c07495i.A04) < c07495i.A04) {
                                throw new C2427pH(null, 2008);
                            }
                            if (c07495i.A03 != -1) {
                                this.A00 = c07495i.A03;
                            } else {
                                this.A00 = this.A02.available();
                                if (this.A00 == 2147483647L) {
                                    this.A00 = -1L;
                                }
                            }
                            this.A03 = true;
                            A0H(c07495i);
                            return this.A00;
                        }
                    } catch (C2427pH e) {
                        throw e;
                    } catch (IOException e2) {
                        boolean z = e2 instanceof FileNotFoundException;
                        if (A06[6].length() == 13) {
                            A06[6] = "P3wDYI6sXfUMf";
                            throw new C2427pH(e2, z ? 2005 : 2000);
                        }
                    }
                    throw new RuntimeException();
                }

                static {
                    A01();
                }

                {
                    super(false);
                    this.A04 = context.getAssets();
                }

                @Override // com.instagram.common.viewpoint.core.InterfaceC2425pF
                public final Uri A9P() {
                    return this.A01;
                }

                @Override // com.instagram.common.viewpoint.core.InterfaceC2425pF
                public final void close() throws C2427pH {
                    this.A01 = null;
                    try {
                        try {
                            if (this.A02 != null) {
                                this.A02.close();
                            }
                        } catch (IOException e) {
                            throw new C2427pH(e, 2000);
                        }
                    } finally {
                        this.A02 = null;
                        if (this.A03) {
                            this.A03 = false;
                            A0E();
                        }
                    }
                }

                @Override // com.instagram.common.viewpoint.core.InterfaceC06692c
                public final int read(byte[] bArr, int i, int i2) throws C2427pH {
                    if (i2 == 0) {
                        return 0;
                    }
                    if (this.A00 == 0) {
                        return -1;
                    }
                    try {
                        if (this.A00 != -1) {
                            i2 = (int) Math.min(this.A00, i2);
                        }
                        int read = ((InputStream) C5C.A0f(this.A02)).read(bArr, i, i2);
                        if (read == -1) {
                            return -1;
                        }
                        long j = this.A00;
                        if (A06[6].length() != 13) {
                            throw new RuntimeException();
                        }
                        A06[6] = "7Z6S4bUZVA19c";
                        if (j != -1) {
                            this.A00 -= read;
                        }
                        A0F(read);
                        return read;
                    } catch (IOException e) {
                        throw new C2427pH(e, 2000);
                    }
                }
            };
            A09(this.A00);
        }
        return this.A00;
    }

    private InterfaceC2425pF A01() {
        if (this.A01 == null) {
            final Context context = this.A09;
            this.A01 = new AQ(context) { // from class: com.facebook.ads.redexgen.X.1m
                public static byte[] A06;
                public static String[] A07 = {"2ftN4rqyMzReasXlS0Bd7yvXq4Z2w8Rd", "SB3v1XRSpovCjfjTdx7anKa7xqXJKcRT", "XVjCn6r7eDTGJtLvngTS2wgt8nCOhnB8", "1Z3zzaFrxDlwod4BzGavHrSG6vNvtkR5", "UgcL11Y1AQOJlkVRTNTymNMOAMwNhJW2", "NkTGPgJcqOjwrAzhjPkYXMY7OTNaeVTG", "UuxCrg9I54LtW8vlxqROWB7HyIfBI135", "4rxicH75x32fMwhdD1obBcUBdLwTm4oP"};
                public long A00;
                public AssetFileDescriptor A01;
                public Uri A02;
                public FileInputStream A03;
                public boolean A04;
                public final ContentResolver A05;

                public static String A00(int i, int i2, int i3) {
                    byte[] copyOfRange = Arrays.copyOfRange(A06, i, i + i2);
                    for (int i4 = 0; i4 < copyOfRange.length; i4++) {
                        copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 87);
                    }
                    return new String(copyOfRange);
                }

                public static void A01() {
                    A06 = new byte[]{-76, -71, -76, 10, 54, 60, 51, 43, -25, 53, 54, 59, -25, 54, 55, 44, 53, -25, 45, 48, 51, 44, -25, 43, 44, 58, 42, 57, 48, 55, 59, 54, 57, -25, 45, 54, 57, 1, -25, Ascii.FF, Ascii.EM, Ascii.SI, Ascii.GS, Ascii.SUB, Ascii.DC4, Ascii.SI, -39, Ascii.ESC, Ascii.GS, Ascii.SUB, 33, Ascii.DC4, Ascii.SI, Ascii.DLE, Ascii.GS, -39, Ascii.DLE, 35, Ascii.US, Ascii.GS, Ascii.FF, -39, -20, -18, -18, -16, -5, -1, 10, -6, -3, -12, -14, -12, -7, -20, -9, 10, -8, -16, -17, -12, -20, 10, -15, -6, -3, -8, -20, -1, -70, -58, -59, -53, -68, -59, -53, 1};
                }

                /* JADX WARN: Code restructure failed: missing block: B:46:0x010e, code lost:
                
                    if (r0 >= 0) goto L39;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:48:0x016d, code lost:
                
                    throw new com.instagram.common.viewpoint.core.C2426pG(null, 2008);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:50:0x012a, code lost:
                
                    if (r0 >= 0) goto L39;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:55:0x00e4, code lost:
                
                    if (r0 >= 0) goto L39;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:57:0x0176, code lost:
                
                    throw new com.instagram.common.viewpoint.core.C2426pG(null, 2008);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:59:0x00ee, code lost:
                
                    if (r0 >= 0) goto L39;
                 */
                /* JADX WARN: Failed to parse debug info
                java.lang.ArrayIndexOutOfBoundsException: Index 23 out of bounds for length 15
                	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.restartVar(DebugInfoParser.java:193)
                	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:141)
                	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
                	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:636)
                	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
                 */
                @Override // com.instagram.common.viewpoint.core.InterfaceC2425pF
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final long AGi(C07495i c07495i) throws C2426pG {
                    AssetFileDescriptor openAssetFileDescriptor;
                    try {
                        try {
                            Uri uri = c07495i.A06;
                            this.A02 = uri;
                            A0G(c07495i);
                            if (A00(90, 7, 0).equals(c07495i.A06.getScheme())) {
                                Bundle bundle = new Bundle();
                                bundle.putBoolean(A00(39, 51, 84), true);
                                openAssetFileDescriptor = this.A05.openTypedAssetFileDescriptor(uri, A00(0, 3, 51), bundle);
                            } else {
                                openAssetFileDescriptor = this.A05.openAssetFileDescriptor(uri, A00(97, 1, 56));
                            }
                            this.A01 = openAssetFileDescriptor;
                            if (openAssetFileDescriptor == null) {
                                try {
                                    throw new C2426pG(new IOException(A00(3, 36, 112) + uri), 2000);
                                } catch (IOException e) {
                                    e = e;
                                    throw new C2426pG(e, e instanceof FileNotFoundException ? 2005 : 2000);
                                }
                            }
                            long length = openAssetFileDescriptor.getLength();
                            FileInputStream fileInputStream = new FileInputStream(openAssetFileDescriptor.getFileDescriptor());
                            this.A03 = fileInputStream;
                            if (length != -1 && c07495i.A04 > length) {
                                throw new C2426pG(null, 2008);
                            }
                            long startOffset = openAssetFileDescriptor.getStartOffset();
                            long skip = fileInputStream.skip(c07495i.A04 + startOffset) - startOffset;
                            long j = c07495i.A04;
                            String[] strArr = A07;
                            if (strArr[0].charAt(30) == strArr[3].charAt(30)) {
                                String[] strArr2 = A07;
                                strArr2[7] = "V2cYJorATJJITl96mEL4teMpahqL5My0";
                                strArr2[2] = "81QpsL8o4R3JZzZywbg9Kxgu0WDTOmHd";
                                if (skip != j) {
                                    throw new C2426pG(null, 2008);
                                }
                                if (length == -1) {
                                    FileChannel channel = fileInputStream.getChannel();
                                    long size = channel.size();
                                    if (size == 0) {
                                        this.A00 = -1L;
                                    } else {
                                        this.A00 = size - channel.position();
                                        long j2 = this.A00;
                                        if (A07[5].charAt(20) != 'X') {
                                            String[] strArr3 = A07;
                                            strArr3[7] = "o4lencYzmcLYt1MiV6fFEBYqoofjVCYJ";
                                            strArr3[2] = "LnRaAWOGUoCClb3L4bo6XdN18ipe8ADC";
                                        } else {
                                            A07[1] = "bSHOsa59vSpVf4yTu8YpmIN0mXabJXNA";
                                        }
                                    }
                                } else {
                                    this.A00 = length - skip;
                                    long j3 = this.A00;
                                    if (A07[5].charAt(20) != 'X') {
                                        A07[5] = "bEcLXKtmUZe87exD27VZX6tOwUTS9Sez";
                                    } else {
                                        A07[1] = "HQINqvWzgwxijb9Tl3Os5Fu0qA3gaNYz";
                                    }
                                }
                                long j4 = c07495i.A03;
                                if (A07[5].charAt(20) == 'X') {
                                    String[] strArr4 = A07;
                                    strArr4[0] = "HMZNFKbBHMEnP71uJIxHqXthvd44tlRl";
                                    strArr4[3] = "eoHh6GrHY21TbtSwRzT9Dqoif9pbqNR5";
                                    if (j4 != -1) {
                                        this.A00 = this.A00 == -1 ? c07495i.A03 : Math.min(this.A00, c07495i.A03);
                                    }
                                    this.A04 = true;
                                    A0H(c07495i);
                                    return c07495i.A03 != -1 ? c07495i.A03 : this.A00;
                                }
                            }
                            throw new RuntimeException();
                        } catch (IOException e2) {
                            e = e2;
                        }
                    } catch (C2426pG e3) {
                        throw e3;
                    }
                }

                static {
                    A01();
                }

                {
                    super(false);
                    this.A05 = context.getContentResolver();
                }

                @Override // com.instagram.common.viewpoint.core.InterfaceC2425pF
                public final Uri A9P() {
                    return this.A02;
                }

                @Override // com.instagram.common.viewpoint.core.InterfaceC2425pF
                public final void close() throws C2426pG {
                    this.A02 = null;
                    try {
                        try {
                            if (this.A03 != null) {
                                this.A03.close();
                            }
                            this.A03 = null;
                            try {
                                try {
                                    if (this.A01 != null) {
                                        this.A01.close();
                                    }
                                } catch (IOException e) {
                                    throw new C2426pG(e, 2000);
                                }
                            } finally {
                                this.A01 = null;
                                if (this.A04) {
                                    this.A04 = false;
                                    A0E();
                                }
                            }
                        } catch (IOException e2) {
                            throw new C2426pG(e2, 2000);
                        }
                    } catch (Throwable th) {
                        this.A03 = null;
                        try {
                            try {
                                if (this.A01 != null) {
                                    this.A01.close();
                                }
                                this.A01 = null;
                                if (this.A04) {
                                    this.A04 = false;
                                    A0E();
                                }
                                throw th;
                            } catch (IOException e3) {
                                throw new C2426pG(e3, 2000);
                            }
                        } finally {
                            this.A01 = null;
                            if (this.A04) {
                                this.A04 = false;
                                A0E();
                            }
                        }
                    }
                }

                @Override // com.instagram.common.viewpoint.core.InterfaceC06692c
                public final int read(byte[] bArr, int i, int i2) throws C2426pG {
                    if (i2 == 0) {
                        return 0;
                    }
                    long j = this.A00;
                    if (A07[1].charAt(15) != 'T') {
                        throw new RuntimeException();
                    }
                    String[] strArr = A07;
                    strArr[0] = "xrRDl1n0HP8M9562uVsbLDb97IGJJORF";
                    strArr[3] = "BxGqKYmJPgWUa88HGr5IfMWzChfrhfRY";
                    if (j == 0) {
                        return -1;
                    }
                    try {
                        if (this.A00 != -1) {
                            i2 = (int) Math.min(this.A00, i2);
                        }
                        int read = ((FileInputStream) C5C.A0f(this.A03)).read(bArr, i, i2);
                        if (read == -1) {
                            return -1;
                        }
                        if (this.A00 != -1) {
                            this.A00 -= read;
                        }
                        A0F(read);
                        return read;
                    } catch (IOException e) {
                        throw new C2426pG(e, 2000);
                    }
                }
            };
            A09(this.A01);
        }
        return this.A01;
    }

    private InterfaceC2425pF A02() {
        if (this.A02 == null) {
            this.A02 = new AQ() { // from class: com.facebook.ads.redexgen.X.1l
                public static byte[] A04;
                public int A00;
                public int A01;
                public C07495i A02;
                public byte[] A03;

                static {
                    A01();
                }

                public static String A00(int i, int i2, int i3) {
                    byte[] copyOfRange = Arrays.copyOfRange(A04, i, i + i2);
                    for (int i4 = 0; i4 < copyOfRange.length; i4++) {
                        copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 120);
                    }
                    return new String(copyOfRange);
                }

                public static void A01() {
                    A04 = new byte[]{-17, 48, 87, 86, 104, 90, 43, 41, 58, 103, 103, 100, 103, Ascii.NAK, 108, 93, 94, 97, 90, Ascii.NAK, 101, 86, 103, 104, 94, 99, 92, Ascii.NAK, 55, 86, 104, 90, 43, 41, Ascii.NAK, 90, 99, 88, 100, 89, 90, 89, Ascii.NAK, 104, 105, 103, 94, 99, 92, 47, Ascii.NAK, -23, 2, -7, Ascii.FF, 4, -7, -9, 8, -7, -8, -76, -23, -26, -35, -76, -6, 3, 6, 1, -11, 8, -50, -76, 60, 85, 90, 92, 87, 87, 86, 89, 91, 76, 75, 7, 90, 74, 79, 76, 84, 76, 33, 7, Ascii.EM, Ascii.SYN, 41, Ascii.SYN};
                }

                @Override // com.instagram.common.viewpoint.core.InterfaceC2425pF
                public final Uri A9P() {
                    if (this.A02 != null) {
                        return this.A02.A06;
                    }
                    return null;
                }

                @Override // com.instagram.common.viewpoint.core.InterfaceC2425pF
                public final long AGi(C07495i c07495i) throws IOException {
                    A0G(c07495i);
                    this.A02 = c07495i;
                    Uri uri = c07495i.A06;
                    String scheme = uri.getScheme();
                    AbstractC07133y.A09(A00(94, 4, 61).equals(scheme), A00(74, 20, 111) + scheme);
                    String[] uriParts = C5C.A1O(uri.getSchemeSpecificPart(), A00(0, 1, 75));
                    if (uriParts.length == 2) {
                        String str = uriParts[1];
                        String dataString = uriParts[0];
                        if (dataString.contains(A00(1, 7, Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE))) {
                            try {
                                this.A03 = android.util.Base64.decode(str, 0);
                            } catch (IllegalArgumentException e) {
                                throw C3K.A02(A00(8, 43, Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE) + str, e);
                            }
                        } else {
                            this.A03 = C5C.A1G(URLDecoder.decode(str, AbstractC2126k9.A01.name()));
                        }
                        if (c07495i.A04 <= this.A03.length) {
                            this.A01 = (int) c07495i.A04;
                            this.A00 = this.A03.length - this.A01;
                            if (c07495i.A03 != -1) {
                                this.A00 = (int) Math.min(this.A00, c07495i.A03);
                            }
                            A0H(c07495i);
                            return c07495i.A03 != -1 ? c07495i.A03 : this.A00;
                        }
                        this.A03 = null;
                        throw new C07425b(2008);
                    }
                    throw C3K.A02(A00(51, 23, 28) + uri, null);
                }

                @Override // com.instagram.common.viewpoint.core.InterfaceC2425pF
                public final void close() {
                    if (this.A03 != null) {
                        this.A03 = null;
                        A0E();
                    }
                    this.A02 = null;
                }

                @Override // com.instagram.common.viewpoint.core.InterfaceC06692c
                public final int read(byte[] bArr, int i, int i2) {
                    if (i2 == 0) {
                        return 0;
                    }
                    if (this.A00 == 0) {
                        return -1;
                    }
                    int min = Math.min(i2, this.A00);
                    System.arraycopy(C5C.A0f(this.A03), this.A01, bArr, i, min);
                    this.A01 += min;
                    this.A00 -= min;
                    A0F(min);
                    return min;
                }
            };
            A09(this.A02);
        }
        return this.A02;
    }

    private InterfaceC2425pF A03() {
        if (this.A03 == null) {
            this.A03 = new C06501j();
            A09(this.A03);
        }
        return this.A03;
    }

    private InterfaceC2425pF A04() {
        if (this.A04 == null) {
            final Context context = this.A09;
            this.A04 = new AQ(context) { // from class: com.facebook.ads.redexgen.X.1i
                public static byte[] A07;
                public static String[] A08 = {"QLuP8Pt4KiB", "RgtlFkBshe2uzsEMObMvf6GLE9oju0kX", "TTP1lITjIL7gpSd4kE", "ZIRCIqgztw3RRTH34yg2MmGGdHBG3Sqw", "W8lxrl5W", "1BP9Supp2XIZ7aBeV", "CPoLKetsO3XScG5XHhoA5", "r"};
                public long A00;
                public AssetFileDescriptor A01;
                public Uri A02;
                public InputStream A03;
                public boolean A04;
                public final Resources A05;
                public final String A06;

                public static String A00(int i, int i2, int i3) {
                    byte[] copyOfRange = Arrays.copyOfRange(A07, i, i + i2);
                    for (int i4 = 0; i4 < copyOfRange.length; i4++) {
                        copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 127);
                    }
                    return new String(copyOfRange);
                }

                public static void A01() {
                    A07 = new byte[]{105, 54, 72, 99, 105, 45, 98, 107, 45, 126, 121, Byte.MAX_VALUE, 104, 108, 96, 45, Byte.MAX_VALUE, 104, 108, 110, 101, 104, 105, 45, 101, 108, 123, 100, 99, 106, 45, 99, 98, 121, 45, Byte.MAX_VALUE, 104, 108, 105, 45, 126, 120, 107, 107, 100, 110, 100, 104, 99, 121, 45, 105, 108, 121, 108, 35, 122, 77, 91, 71, 93, 90, 75, 77, 8, 65, 76, 77, 70, 92, 65, 78, 65, 77, 90, 8, 69, 93, 91, 92, 8, 74, 77, 8, 73, 70, 8, 65, 70, 92, 77, 79, 77, 90, 6, Ascii.ESC, 44, 58, 38, 60, 59, 42, 44, 105, 32, 58, 105, 42, 38, 36, 57, 59, 44, 58, 58, 44, 45, 115, 105, 50, 5, 19, Ascii.SI, Ascii.NAK, Ascii.DC2, 3, 5, SignedBytes.MAX_POWER_OF_TWO, Ascii.SO, Ascii.SI, Ascii.DC4, SignedBytes.MAX_POWER_OF_TWO, 6, Ascii.SI, Ascii.NAK, Ascii.SO, 4, 78, 115, 116, 111, 6, 75, 83, 85, 82, 6, 67, 79, 82, 78, 67, 84, 6, 83, 85, 67, 6, 85, 69, 78, 67, 75, 67, 6, 84, 71, 81, 84, 67, 85, 73, 83, 84, 69, 67, 6, 73, 84, 6, 71, 72, 66, 84, 73, 79, 66, 8, 84, 67, 85, 73, 83, 84, 69, 67, 114, 74, 5, 98, 109, 103, 113, 108, 106, 103, 45, 113, 102, 112, 108, 118, 113, 96, 102, 69, 86, SignedBytes.MAX_POWER_OF_TWO, 92, 79, 89, 92, 75, 93, 65, 91, 92, 77, 75};
                }

                /* JADX WARN: Code restructure failed: missing block: B:101:0x0116, code lost:
                
                    if (r1 != 0) goto L25;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:22:0x00f7, code lost:
                
                    if (r1 != 0) goto L25;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:99:0x0260, code lost:
                
                    throw new com.instagram.common.viewpoint.core.C2413p3(A00(com.vungle.ads.internal.protos.Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE, 19, 31), null, 2005);
                 */
                /* JADX WARN: Failed to parse debug info
                java.lang.ArrayIndexOutOfBoundsException
                 */
                @Override // com.instagram.common.viewpoint.core.InterfaceC2425pF
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final long AGi(C07495i c07495i) throws C2413p3 {
                    int parseInt;
                    C06491i c06491i;
                    Uri uri = c07495i.A06;
                    this.A02 = uri;
                    try {
                        try {
                            if (!TextUtils.equals(A00(Sdk.SDKError.Reason.MRAID_JS_DOES_NOT_EXIST_VALUE, 11, 81), uri.getScheme())) {
                                String scheme = uri.getScheme();
                                String[] strArr = A08;
                                if (strArr[1].charAt(14) != strArr[3].charAt(14)) {
                                    String[] strArr2 = A08;
                                    strArr2[4] = "6WAfCQCC";
                                    strArr2[5] = "2bXUndVpRAzh6SBol";
                                    String A00 = A00(199, 16, Sdk.SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE);
                                    if (!TextUtils.equals(A00, scheme) || uri.getPathSegments().size() != 1 || !((String) AbstractC07133y.A01(uri.getLastPathSegment())).matches(A00(196, 3, 81))) {
                                        if (!TextUtils.equals(A00, uri.getScheme())) {
                                            throw new C2413p3(A00(138, 58, 89), null, 1004);
                                        }
                                        String str = (String) AbstractC07133y.A01(uri.getPath());
                                        if (str.startsWith(A00(0, 1, 57))) {
                                            str = str.substring(1);
                                        }
                                        String host = uri.getHost();
                                        String str2 = (TextUtils.isEmpty(host) ? A00(0, 0, 29) : host + A00(1, 1, 115)) + str;
                                        Resources resources = this.A05;
                                        String str3 = this.A06;
                                        if (A08[6].length() != 1) {
                                            String[] strArr3 = A08;
                                            strArr3[1] = "8DRS4lLYfMrToLqDwLXqvfchHPsueWE2";
                                            strArr3[3] = "vCWitTtlDB9EwPvV6O7ut3igyg5fSS64";
                                            parseInt = resources.getIdentifier(str2, A00(Sdk.SDKError.Reason.AD_RESPONSE_EMPTY_VALUE, 3, 72), str3);
                                        } else {
                                            String[] strArr4 = A08;
                                            strArr4[7] = ExifInterface.GPS_MEASUREMENT_IN_PROGRESS;
                                            strArr4[2] = "wipKq4bcm9KT4pACcA";
                                            parseInt = resources.getIdentifier(str2, A00(10, 1, 58), str3);
                                        }
                                    }
                                }
                                throw new RuntimeException();
                            }
                            AssetFileDescriptor openRawResourceFd = this.A05.openRawResourceFd(parseInt);
                            this.A01 = openRawResourceFd;
                            if (openRawResourceFd == null) {
                                throw new C2413p3(A00(95, 24, 54) + uri, null, 2000);
                            }
                            long length = openRawResourceFd.getLength();
                            FileInputStream fileInputStream = new FileInputStream(openRawResourceFd.getFileDescriptor());
                            this.A03 = fileInputStream;
                            if (length != -1) {
                                try {
                                    if (c07495i.A04 > length) {
                                        throw new C2413p3(null, null, 2008);
                                    }
                                } catch (C2413p3 e) {
                                    throw e;
                                } catch (IOException e2) {
                                    e = e2;
                                    throw new C2413p3(null, e, 2000);
                                }
                            }
                            try {
                                long startOffset = openRawResourceFd.getStartOffset();
                                long skip = fileInputStream.skip(c07495i.A04 + startOffset) - startOffset;
                                try {
                                } catch (C2413p3 e3) {
                                    throw e3;
                                } catch (IOException e4) {
                                    e = e4;
                                }
                                try {
                                    if (skip != c07495i.A04) {
                                        throw new C2413p3(null, null, 2008);
                                    }
                                    if (length == -1) {
                                        FileChannel channel = fileInputStream.getChannel();
                                        if (channel.size() == 0) {
                                            c06491i = this;
                                            c06491i.A00 = -1L;
                                        } else {
                                            c06491i = this;
                                            c06491i.A00 = channel.size() - channel.position();
                                            if (c06491i.A00 < 0) {
                                                throw new C2413p3(null, null, 2008);
                                            }
                                        }
                                    } else {
                                        c06491i = this;
                                        c06491i.A00 = length - skip;
                                        if (c06491i.A00 < 0) {
                                            throw new C07425b(2008);
                                        }
                                    }
                                    long j = c07495i.A03;
                                    String[] strArr5 = A08;
                                    if (strArr5[7].length() != strArr5[2].length()) {
                                        A08[0] = InneractiveMediationDefs.GENDER_FEMALE;
                                        if (j != -1) {
                                            c06491i.A00 = c06491i.A00 == -1 ? c07495i.A03 : Math.min(c06491i.A00, c07495i.A03);
                                        }
                                        c06491i.A04 = true;
                                        A0H(c07495i);
                                        return c07495i.A03 != -1 ? c07495i.A03 : c06491i.A00;
                                    }
                                    throw new RuntimeException();
                                } catch (C2413p3 e5) {
                                    throw e5;
                                } catch (IOException e6) {
                                    e = e6;
                                    throw new C2413p3(null, e, 2000);
                                }
                            } catch (C2413p3 e7) {
                                throw e7;
                            } catch (IOException e8) {
                                e = e8;
                            }
                        } catch (Resources.NotFoundException e9) {
                            throw new C2413p3(null, e9, 2005);
                        }
                        parseInt = Integer.parseInt((String) AbstractC07133y.A01(uri.getLastPathSegment()));
                        A0G(c07495i);
                    } catch (NumberFormatException unused) {
                        throw new C2413p3(A00(56, 39, 87), null, 1004);
                    }
                }

                static {
                    A01();
                }

                {
                    super(false);
                    this.A05 = context.getResources();
                    this.A06 = context.getPackageName();
                }

                @Override // com.instagram.common.viewpoint.core.InterfaceC2425pF
                public final Uri A9P() {
                    return this.A02;
                }

                @Override // com.instagram.common.viewpoint.core.InterfaceC2425pF
                public final void close() throws C2413p3 {
                    this.A02 = null;
                    try {
                        try {
                            if (this.A03 != null) {
                                this.A03.close();
                            }
                            this.A03 = null;
                            try {
                                try {
                                    if (this.A01 != null) {
                                        this.A01.close();
                                    }
                                } catch (IOException e) {
                                    throw new C2413p3(null, e, 2000);
                                }
                            } catch (Throwable th) {
                                this.A01 = null;
                                String[] strArr = A08;
                                if (strArr[1].charAt(14) == strArr[3].charAt(14)) {
                                    throw new RuntimeException();
                                }
                                A08[6] = "iC26zNxzLLnB2GH7qyOIGlAQhGgRPuU";
                                if (this.A04) {
                                    this.A04 = false;
                                    A0E();
                                }
                                throw th;
                            }
                        } catch (IOException e2) {
                            throw new C2413p3(null, e2, 2000);
                        }
                    } catch (Throwable th2) {
                        this.A03 = null;
                        try {
                            try {
                                if (this.A01 != null) {
                                    this.A01.close();
                                }
                                this.A01 = null;
                                if (this.A04) {
                                    this.A04 = false;
                                    A0E();
                                }
                                throw th2;
                            } catch (IOException e3) {
                                throw new C2413p3(null, e3, 2000);
                            }
                        } finally {
                            this.A01 = null;
                            if (this.A04) {
                                this.A04 = false;
                                A0E();
                            }
                        }
                    }
                }

                @Override // com.instagram.common.viewpoint.core.InterfaceC06692c
                public final int read(byte[] bArr, int i, int i2) throws C2413p3 {
                    if (i2 == 0) {
                        return 0;
                    }
                    if (this.A00 == 0) {
                        return -1;
                    }
                    try {
                        if (this.A00 != -1) {
                            i2 = (int) Math.min(this.A00, i2);
                        }
                        int read = ((InputStream) C5C.A0f(this.A03)).read(bArr, i, i2);
                        if (read == -1) {
                            if (this.A00 == -1) {
                                return -1;
                            }
                            throw new C2413p3(A00(2, 54, 114), new EOFException(), 2000);
                        }
                        if (this.A00 != -1) {
                            this.A00 -= read;
                        }
                        A0F(read);
                        return read;
                    } catch (IOException e) {
                        throw new C2413p3(null, e, 2000);
                    }
                }
            };
            A09(this.A04);
        }
        return this.A04;
    }

    private InterfaceC2425pF A05() {
        if (this.A05 == null) {
            try {
                this.A05 = (InterfaceC2425pF) Class.forName(A07(157, 66, 67)).getConstructor(new Class[0]).newInstance(new Object[0]);
                A09(this.A05);
            } catch (ClassNotFoundException unused) {
                AbstractC07214g.A07(A07(85, 17, 17), A07(15, 70, 11));
            } catch (Exception e) {
                throw new RuntimeException(A07(102, 34, 68), e);
            }
            if (this.A05 == null) {
                this.A05 = this.A08;
            }
        }
        return this.A05;
    }

    private InterfaceC2425pF A06() {
        if (this.A06 == null) {
            this.A06 = new C06481h();
            A09(this.A06);
        }
        return this.A06;
    }

    /* JADX WARN: Incorrect condition in loop: B:3:0x0007 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void A09(InterfaceC2425pF interfaceC2425pF) {
        for (int i = 0; i < i; i++) {
            interfaceC2425pF.A43(this.A0A.get(i));
        }
    }

    private void A0A(InterfaceC2425pF interfaceC2425pF, InterfaceC07605t interfaceC07605t) {
        if (interfaceC2425pF != null) {
            interfaceC2425pF.A43(interfaceC07605t);
        }
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2425pF
    public final void A43(InterfaceC07605t interfaceC07605t) {
        AbstractC07133y.A01(interfaceC07605t);
        this.A08.A43(interfaceC07605t);
        this.A0A.add(interfaceC07605t);
        A0A(this.A03, interfaceC07605t);
        A0A(this.A00, interfaceC07605t);
        A0A(this.A01, interfaceC07605t);
        A0A(this.A05, interfaceC07605t);
        A0A(this.A06, interfaceC07605t);
        A0A(this.A02, interfaceC07605t);
        A0A(this.A04, interfaceC07605t);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2425pF
    public final Map<String, List<String>> A8t() {
        return this.A07 == null ? Collections.emptyMap() : this.A07.A8t();
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2425pF
    public final Uri A9P() {
        if (this.A07 == null) {
            return null;
        }
        return this.A07.A9P();
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2425pF
    public final long AGi(C07495i c07495i) throws IOException {
        AbstractC07133y.A08(this.A07 == null);
        String scheme = c07495i.A06.getScheme();
        if (C5C.A1A(c07495i.A06)) {
            String path = c07495i.A06.getPath();
            if (path != null) {
                String[] strArr = A0C;
                String uriPath = strArr[4];
                if (uriPath.charAt(27) != strArr[0].charAt(27)) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A0C;
                strArr2[4] = "woaZ3GsQ3DbiayOrUPjNVqqq8n8IT0aY";
                strArr2[0] = "klzvMTRWbU3yZvxB9bRoGsioUmbI9kjx";
                String scheme2 = A07(0, 15, 49);
                if (path.startsWith(scheme2)) {
                    InterfaceC2425pF A00 = A00();
                    String[] strArr3 = A0C;
                    String uriPath2 = strArr3[4];
                    if (uriPath2.charAt(27) != strArr3[0].charAt(27)) {
                        String[] strArr4 = A0C;
                        strArr4[1] = "PIVfyqk1Etrv0Wbxq4vDpVOoMCV7O";
                        strArr4[7] = "Bsp2dR1";
                        this.A07 = A00;
                    } else {
                        String[] strArr5 = A0C;
                        strArr5[1] = "maZBVk5L4nnlZEqCNC7SxmxFjkMbb";
                        strArr5[7] = "XTvzFpJ";
                        this.A07 = A00;
                    }
                }
            }
            this.A07 = A03();
        } else {
            String scheme3 = A07(152, 5, 87);
            if (scheme3.equals(scheme)) {
                this.A07 = A00();
            } else {
                String scheme4 = A07(Sdk.SDKError.Reason.STALE_CACHED_RESPONSE_VALUE, 7, 105);
                if (scheme4.equals(scheme)) {
                    this.A07 = A01();
                } else {
                    String scheme5 = A07(245, 4, 63);
                    if (scheme5.equals(scheme)) {
                        this.A07 = A05();
                    } else {
                        String scheme6 = A07(249, 3, 53);
                        if (scheme6.equals(scheme)) {
                            this.A07 = A06();
                        } else {
                            String scheme7 = A07(230, 4, 93);
                            if (scheme7.equals(scheme)) {
                                this.A07 = A02();
                            } else {
                                String scheme8 = A07(234, 11, 71);
                                if (!scheme8.equals(scheme)) {
                                    String scheme9 = A07(136, 16, 33);
                                    if (!scheme9.equals(scheme)) {
                                        this.A07 = this.A08;
                                    }
                                }
                                this.A07 = A04();
                            }
                        }
                    }
                }
            }
        }
        return this.A07.AGi(c07495i);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2425pF
    public final void close() throws IOException {
        if (this.A07 != null) {
            try {
                this.A07.close();
            } finally {
                this.A07 = null;
            }
        }
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC06692c
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        return ((InterfaceC2425pF) AbstractC07133y.A01(this.A07)).read(bArr, i, i2);
    }
}
