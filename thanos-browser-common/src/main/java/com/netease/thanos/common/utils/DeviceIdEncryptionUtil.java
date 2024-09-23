package com.netease.thanos.common.utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


/**
 * sdk可信设备Id加解密工具
 *
 * @author hzzhanglei
 */
public class DeviceIdEncryptionUtil extends DeviceInfoUtil {
    private static Log log = LogFactory.getLog(DeviceIdEncryptionUtil.class);

    private static String private_key = "MIICeAIBADANBgkqhkiG9w0BAQEFAASCAmIwggJeAgEAAoGBANW2Q218cLvq2M8w" + "fDSfQIMNS3Pnj05WGBll074LxHJCHv2SvR27L1lQVGjW/TYC61vpaxg78QL+P8uy"
            + "Vfz3hT2wz62rsLpu2a6SZjFoUAwEQV96xTL1c6FXpgRHMAQSQlcl1F8LamyjtWd+" + "Mz0cn0CoN8Op7vjbgA8Fc/gchwzpAgMBAAECgYEAqDV4JvHeTZpQIeu4pzZ9cWkC"
            + "bWzh97d96meiXKAodAIlIFLh9UfCwdqfRZGJ5XwwwbwcJgvv6/owPmTUl3I+9Nkm" + "pe1dEcw5bYSwHxcjiH4q2Rxv3Vo4lpluPE8JnmdZkNLM4QAZWXPBs/cM1zxX2V5C"
            + "HeQ2ZUyq9IJUd5zWvwECQQD81Esg1g0XaMFjwhEAQIdVN4ErLoy2MrQUU+3Um3hn" + "2ZxLYfP/ge8L0JsdZBiVQXo4jpWKDCPrSnQTXSDVqWUhAkEA2GRiVDU/sLoimNfu"
            + "IFWEOoiKGXLWnWZQI2Ps8RMKx6pX3Kq1RDSNyWNCPiJu5sl+66z9rOKIDt+tWf8/" + "aUvmyQJBAKDSDQPTBDrKuJDTBetqIGt1ReWI05qlf+SaSmL9jcZJJmDQ6tqw9LRI"
            + "OhKk8/okzzCgicBo3oQxNMqIZ3VhLeECQH4Kco+z+GYa9R3r4CLrTLq/XxkVn9ZM" + "iu8iPBfrTIMiQE0jDbQtnEyqSSJh8hDxWsExoQy7Yh6vwIxENY5CjKkCQQCPEJsv"
            + "yNRfB3+2638nv3OP52ZPv6NMuI9LYWf4aNZwUbIB1BuZq22WS3+BwdINCtoCdHlS" + "QP3QeSCntxTB+SJ4";

    //解码deviceId
    public static String decodeDeviceId(String deviceIdEncode) {
        JSONObject deviceIdJsonObject = JSONObject.parseObject(deviceIdEncode);
//		JSONObject deviceIdJsonObject = JSONObject.fromObject(deviceIdEncode);
        String version = deviceIdJsonObject.getString("id_ver");
        String deviceIdJson = null;
        if (StringUtils.startsWith(version, "IOS_") && "IOS_1.2.1".compareTo(version) <= 0) {
            deviceIdJson = decodeByClientType(ClientDeviceType.ANDROID, deviceIdEncode, private_key);
        } else if (StringUtils.startsWith(version, "Android_")) {
            deviceIdJson = decodeByClientType(ClientDeviceType.ANDROID, deviceIdEncode, private_key);
        } else {
            deviceIdJson = decodeByClientType(ClientDeviceType.IOS, deviceIdEncode, private_key);
        }

        if (StringUtils.isBlank(deviceIdJson)) {
            //如果设备号解密为空,那么随机生成一个设备号;
            return "manual_" + UUID.randomUUID();
        }

        if (deviceIdJson.contains("uuid")) {
            Map m = JSONObject.parseObject(deviceIdJson, HashMap.class);
//			Map m = JsonUtil.toBean(deviceIdJson, HashMap.class);
            return JSONObject.toJSONString(m);
        }

        return deviceIdJson;
    }


    public static void main(String[] args) throws IOException {
        String  raw = "{\"id_ver\":\"IOS_1.3.0\",\"rk\":\"xanHpc\\/SlohU\\/C2sHe5ydPtxBjuu6i9risV7GPXUSFlbgxrR3O6VY9ClqAnGW\\/mjU5GX2F2\\/aDce2Y\\/W6bdQNuu2Wi+t3vXkYHKnwcalFwqq6\\/DayMvWpFMPVAcGKu8Q0XRJJ4BgiWcDGPuFItDxcvU2LIKRjdF3r6wxFiCsXcw=\",\"rdata\":\"z5uv0BVMIGW9nO2kPW5Ovax3P57mhlwmOz5WVvhPTK5\\/fl6d5PXr1hBvXLwPmgTs\",\"datatype\":\"aimt_datas\"}";
        raw = "{\"datatype\":\"aimt_datas\",\"id_ver\":\"Android_1.0.1\",\"rdata\":\"5vAXvMXbmnUxB6MU1KRoG93QkCz0zQckTd3vF+6JsUkA/ChtWsgkosixmgnwYfNOLUY1yBTGhpvfs7Hed9d8XsXTuUPSS3gnBZj1ObyIYrrm6SIjGCxXLtp1jwES7zlnwuLgFT4RkknI3jq7jEka2mphldzuLslc+YDwdwEPhaPDdmoewLLHdjduN8DqRA2sVZSCy2/4BpKyyGcw+qBwpq68VqwQFpVoGw7sWdFmZ6U5tafyaLOp0rSMFvn9PzvRFytdu2ucB1B/V1NuiMdd3Aa3HF+vHV79s7gVyOu3Tb60IYzgmL9uIiX3n+gwIDfO/UF0GGeLdv3CjTA4vU6cEloKTSNboZS/7MoRHyjkXmN63yEMOdF/QfbanO/6yE/wa8LucbI5T5q6iXYjGMLeoA==\",\"rk\":\"u29ZueP0zzkIuuDCdP84kR40l2VH/ogQRwdq9GOyfFclctKpbvDW+Wpvyt0vCMSNlu4ar/km+GVz3vFQkrYBNEjrjfrCqasvPeyUT+dWNI0rplqSitFeW45Nbn+saNWP+hEIBUFrrZVYeKFhlD8KM1s6ZU+VhggIXGmaRoeoI/w=\"}\n";
        System.out.println(decodeDeviceId(raw));
    }


}
