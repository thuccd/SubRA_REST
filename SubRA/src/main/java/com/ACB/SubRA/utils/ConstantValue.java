package com.ACB.SubRA.utils;

/**
 * @author ThucCD
 */
public class ConstantValue {

    /**
     * Loại khách hàng Cá nhân - Cá nhân thuộc doanh nghiệp và doanh nghiệp, và các
     * quy trình. Dùng chung cho cả WS và RA (COMMON - CM)
     */
    public enum CustomerType {
        PERSONAL(1, "Cá Nhân", "^CMND:[A-Za-z0-9\\-]+$"),
        ORGANIZATIONAL(2, "Doanh Nghiệp","^MST:[A-Za-z0-9\\-]+$"),
        PERSONAL_IN_ORGANIZATION(3, "Cá Nhân trong Doanh Nghiệp", "^MST:[A-Za-z0-9\\-]+\\-CMND:[A-Za-z0-9\\-]+$");
        public int code;
        public String vietnamese_name;
        public String subjectDNRegExPattern = "";

        CustomerType(int code, String vietnamese_name, String subjectDNRegExPattern) {
            this.code = code;
            this.vietnamese_name = vietnamese_name;
            this.subjectDNRegExPattern = subjectDNRegExPattern;
        }

        public static CustomerType lookup(int code) {
            for (CustomerType item : CustomerType.values()) {
                if (item.code == code)
                    return item;
            }
            return null;
        }
        public static String getVietnameseName(int code) {
            for (CustomerType item : CustomerType.values()) {
                if (item.code == code)
                    return item.vietnamese_name;
            }
            return "";
        }
    }

}
