package com.ACB.SubRA.utils;

import com.ACB.SubRA.Request.JsonGenerateCertificate;
import com.ACB.SubRA.entity.CustomerType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

/**
 * @author ThucCD
 */
public class WebserviceUtil {
    private static final Logger log = LoggerFactory.getLogger(WebserviceUtil.class);
    private StringBuilder strError;

    public boolean validateSynchronizedData(JsonGenerateCertificate jsonRequest){
        try {
            ConstantValue.CustomerType typeCustomer = ConstantValue.CustomerType.lookup(Integer.parseInt(jsonRequest.getCustomerType()));
            switch (Objects.requireNonNull(typeCustomer)) {  /*bắt buộc không đợc null */
                case PERSONAL:

                case ORGANIZATIONAL:

                case PERSONAL_IN_ORGANIZATION:

                default:
                    strError.append("Không đúng loại khách hàng! \n");
                    break;
            }




            return true;
        }catch (Exception e){
            log.info(e.getMessage());
            return false;
        }

    }


}
