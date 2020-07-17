package com.intesasanpaolo.bear.cond0.cjdispositiva.connector.rest.pcgestixme;

import org.apache.commons.lang3.StringUtils;

public class ISPUtil {

    public static String[] splitRapportoAnagrafe(String rapportoAnagrafe) {
        String[] split = new String[3];
        if (StringUtils.isNotBlank(rapportoAnagrafe)) {
            split[0] = rapportoAnagrafe.substring(0, 5);
            split[1] = rapportoAnagrafe.substring(5, 9);
            split[2] = rapportoAnagrafe.substring(9, rapportoAnagrafe.length());
        }
        return split;
    }

}
