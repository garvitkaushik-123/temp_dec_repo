package com.bytedance.sdk.component.ui.aGH.Os.eli.eli;

import com.bytedance.sdk.component.ui.Os;
import com.bytedance.sdk.component.utils.aAs;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes3.dex */
public class DbA implements Os {
    private eli DbA;
    private int eli;

    public DbA(File file, long j) {
        int i = (int) j;
        this.eli = i;
        this.DbA = eli.eli(i, file);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.sdk.component.ui.Os
    public InputStream eli(String str) {
        eli eliVar = this.DbA;
        if (eliVar == null) {
            return null;
        }
        return eliVar.eli(str);
    }

    @Override // com.bytedance.sdk.component.ui.eli
    public boolean eli(String str, byte[] bArr) {
        eli eliVar = this.DbA;
        if (eliVar == null || bArr == null || str == null) {
            return false;
        }
        return eliVar.eli(str, bArr);
    }

    @Override // com.bytedance.sdk.component.ui.eli
    /* renamed from: DbA, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public byte[] eli(String str) {
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th;
        InputStream inputStream;
        eli eliVar = this.DbA;
        if (eliVar != null && str != null) {
            try {
                inputStream = eliVar.eli(str);
                if (inputStream != null) {
                    try {
                        byteArrayOutputStream = new ByteArrayOutputStream();
                        try {
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int read = inputStream.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                byteArrayOutputStream.write(bArr, 0, read);
                            }
                        } catch (IOException unused) {
                        } catch (Throwable th2) {
                            th = th2;
                            aAs.eli(inputStream);
                            aAs.eli(byteArrayOutputStream);
                            throw th;
                        }
                    } catch (IOException unused2) {
                        byteArrayOutputStream = null;
                    } catch (Throwable th3) {
                        th = th3;
                        byteArrayOutputStream = null;
                        aAs.eli(inputStream);
                        aAs.eli(byteArrayOutputStream);
                        throw th;
                    }
                } else {
                    byteArrayOutputStream = null;
                }
                if (byteArrayOutputStream != null) {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    aAs.eli(inputStream);
                    aAs.eli(byteArrayOutputStream);
                    return byteArray;
                }
            } catch (IOException unused3) {
                inputStream = null;
                byteArrayOutputStream = null;
            } catch (Throwable th4) {
                byteArrayOutputStream = null;
                th = th4;
                inputStream = null;
            }
            aAs.eli(inputStream);
            aAs.eli(byteArrayOutputStream);
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.ui.eli
    /* renamed from: Os, reason: merged with bridge method [inline-methods] */
    public boolean DbA(String str) {
        try {
            InputStream eli = this.DbA.eli(str);
            boolean z = eli != null;
            aAs.eli(eli);
            return z;
        } catch (Throwable th) {
            try {
                th.getMessage();
                return false;
            } finally {
                aAs.eli(null);
            }
        }
    }
}
