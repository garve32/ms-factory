package com.hanwha.mscore.context;

import java.util.Arrays;
import lombok.Getter;

@Getter
public enum TenantEnum {
    COMPANY_A("517", "한화비전"),
    COMPANY_B("516", "한화비전"),
    COMPANY_C("515", "한화비전")
    ;

    private final String code;
    private final String label;

    TenantEnum(String code, String label) {
        this.code = code;
        this.label = label;
    }

    public static boolean hasTenantEnum(String tenantId) {
        return Arrays.stream(TenantEnum.values()).anyMatch(t -> t.getCode().equals(tenantId));
    }
}
