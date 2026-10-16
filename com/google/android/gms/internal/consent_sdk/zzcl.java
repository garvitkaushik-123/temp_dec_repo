package com.google.android.gms.internal.consent_sdk;

import android.util.JsonReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.ump:user-messaging-platform@@3.2.0 */
/* loaded from: classes5.dex */
public final class zzcl {
    public String zza;
    public String zzb;
    public String zzc;
    public int zzf = 1;
    public List zzd = Collections.emptyList();
    public List zze = Collections.emptyList();
    public int zzg = 1;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x01fa, code lost:
    
        if (r1.equals("CONSENT_SIGNAL_UNKNOWN") != false) goto L144;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x008e, code lost:
    
        if (r1.equals("UNKNOWN") == false) goto L48;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x016a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static zzcl zza(JsonReader jsonReader) throws IOException {
        boolean z;
        boolean z2;
        char c;
        int i;
        zzcl zzclVar = new zzcl();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            int i2 = 4;
            int i3 = 3;
            char c2 = 0;
            switch (nextName.hashCode()) {
                case -2001388947:
                    if (nextName.equals("consent_signal")) {
                        z = false;
                        break;
                    }
                    z = -1;
                    break;
                case -1938755376:
                    if (nextName.equals("error_message")) {
                        z = 3;
                        break;
                    }
                    z = -1;
                    break;
                case -1851537225:
                    if (nextName.equals("consent_form_base_url")) {
                        z = 2;
                        break;
                    }
                    z = -1;
                    break;
                case -1324537865:
                    if (nextName.equals("privacy_options_required")) {
                        z = 6;
                        break;
                    }
                    z = -1;
                    break;
                case -1161803523:
                    if (nextName.equals("actions")) {
                        z = 5;
                        break;
                    }
                    z = -1;
                    break;
                case -986806987:
                    if (nextName.equals("request_info_keys")) {
                        z = 4;
                        break;
                    }
                    z = -1;
                    break;
                case -790907624:
                    if (nextName.equals("consent_form_payload")) {
                        z = true;
                        break;
                    }
                    z = -1;
                    break;
                default:
                    z = -1;
                    break;
            }
            switch (z) {
                case false:
                    String nextString = jsonReader.nextString();
                    switch (nextString.hashCode()) {
                        case -2058725357:
                            if (nextString.equals("CONSENT_SIGNAL_COLLECT_CONSENT")) {
                                c2 = 4;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case -1969035850:
                            if (nextString.equals("CONSENT_SIGNAL_ERROR")) {
                                c2 = 6;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case -1263695752:
                            break;
                        case -954325659:
                            if (nextString.equals("CONSENT_SIGNAL_NON_PERSONALIZED_ADS")) {
                                c2 = 2;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case -918677260:
                            if (nextString.equals("CONSENT_SIGNAL_PUBLISHER_MISCONFIGURATION")) {
                                c2 = 7;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 429411856:
                            if (nextString.equals("CONSENT_SIGNAL_SUFFICIENT")) {
                                c2 = 3;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 467888915:
                            if (nextString.equals("CONSENT_SIGNAL_PERSONALIZED_ADS")) {
                                c2 = 1;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 1725474845:
                            if (nextString.equals("CONSENT_SIGNAL_NOT_REQUIRED")) {
                                c2 = 5;
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
                            i2 = 1;
                            zzclVar.zzf = i2;
                            break;
                        case 1:
                            i2 = 2;
                            zzclVar.zzf = i2;
                            break;
                        case 2:
                            i2 = 3;
                            zzclVar.zzf = i2;
                            break;
                        case 3:
                            zzclVar.zzf = i2;
                            break;
                        case 4:
                            i2 = 5;
                            zzclVar.zzf = i2;
                            break;
                        case 5:
                            i2 = 6;
                            zzclVar.zzf = i2;
                            break;
                        case 6:
                            i2 = 7;
                            zzclVar.zzf = i2;
                            break;
                        case 7:
                            i2 = 8;
                            zzclVar.zzf = i2;
                            break;
                        default:
                            throw new IOException("Failed to parse contentads.contributor.direct.serving.appswitchboard.proto.ApplicationGdprResponse.ConsentSignalfrom: ".concat(String.valueOf(nextString)));
                    }
                case true:
                    zzclVar.zza = jsonReader.nextString();
                    break;
                case true:
                    zzclVar.zzb = jsonReader.nextString();
                    break;
                case true:
                    zzclVar.zzc = jsonReader.nextString();
                    break;
                case true:
                    zzclVar.zzd = new ArrayList();
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        zzclVar.zzd.add(jsonReader.nextString());
                    }
                    jsonReader.endArray();
                    break;
                case true:
                    zzclVar.zze = new ArrayList();
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        zzck zzckVar = new zzck();
                        jsonReader.beginObject();
                        while (jsonReader.hasNext()) {
                            String nextName2 = jsonReader.nextName();
                            int hashCode = nextName2.hashCode();
                            if (hashCode != -2105551094) {
                                if (hashCode == 1583758243 && nextName2.equals("action_type")) {
                                    z2 = false;
                                }
                                z2 = -1;
                            } else {
                                if (nextName2.equals("args_json")) {
                                    z2 = true;
                                }
                                z2 = -1;
                            }
                            if (!z2) {
                                String nextString2 = jsonReader.nextString();
                                int hashCode2 = nextString2.hashCode();
                                if (hashCode2 == 64208429) {
                                    if (nextString2.equals("CLEAR")) {
                                        c = 2;
                                        if (c != 0) {
                                        }
                                        zzckVar.zzb = i;
                                    }
                                    c = 65535;
                                    if (c != 0) {
                                    }
                                    zzckVar.zzb = i;
                                } else if (hashCode2 != 82862015) {
                                    if (hashCode2 == 1856333582 && nextString2.equals("UNKNOWN_ACTION_TYPE")) {
                                        c = 0;
                                        if (c != 0) {
                                            i = 1;
                                        } else if (c == 1) {
                                            i = 2;
                                        } else {
                                            if (c != 2) {
                                                throw new IOException("Failed to parse contentads.contributor.direct.serving.appswitchboard.proto.ApplicationGdprResponse.Action.ActionTypefrom: ".concat(String.valueOf(nextString2)));
                                            }
                                            i = 3;
                                        }
                                        zzckVar.zzb = i;
                                    }
                                    c = 65535;
                                    if (c != 0) {
                                    }
                                    zzckVar.zzb = i;
                                } else {
                                    if (nextString2.equals("WRITE")) {
                                        c = 1;
                                        if (c != 0) {
                                        }
                                        zzckVar.zzb = i;
                                    }
                                    c = 65535;
                                    if (c != 0) {
                                    }
                                    zzckVar.zzb = i;
                                }
                            } else if (!z2) {
                                jsonReader.skipValue();
                            } else {
                                zzckVar.zza = jsonReader.nextString();
                            }
                        }
                        jsonReader.endObject();
                        zzclVar.zze.add(zzckVar);
                    }
                    jsonReader.endArray();
                    break;
                case true:
                    String nextString3 = jsonReader.nextString();
                    int hashCode3 = nextString3.hashCode();
                    if (hashCode3 == -1888946261) {
                        if (nextString3.equals("NOT_REQUIRED")) {
                            c2 = 2;
                            if (c2 == 0) {
                            }
                            zzclVar.zzg = i3;
                        }
                        c2 = 65535;
                        if (c2 == 0) {
                        }
                        zzclVar.zzg = i3;
                    } else if (hashCode3 != 389487519) {
                        if (hashCode3 == 433141802) {
                            break;
                        }
                        c2 = 65535;
                        if (c2 == 0) {
                            i3 = 1;
                        } else if (c2 == 1) {
                            i3 = 2;
                        } else if (c2 != 2) {
                            throw new IOException("Failed to parse contentads.contributor.direct.serving.appswitchboard.proto.ApplicationGdprResponse.PrivacyOptionsRequirementStatusfrom: ".concat(String.valueOf(nextString3)));
                        }
                        zzclVar.zzg = i3;
                        break;
                    } else {
                        if (nextString3.equals("REQUIRED")) {
                            c2 = 1;
                            if (c2 == 0) {
                            }
                            zzclVar.zzg = i3;
                        }
                        c2 = 65535;
                        if (c2 == 0) {
                        }
                        zzclVar.zzg = i3;
                    }
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return zzclVar;
    }
}
