package com.fgs.fgscashbook.es;

import java.io.IOException;

public class dome01 {

    public static void main(String[] args) throws IOException {
        ESUtil esUtil = new ESUtil();
        String json = "{\"data\":{\"pageIndex\":1,\"totalSize\":1,\"list\":[{\"no\":193844571,\"title\":\"wx折扣824\",\"subtitle\":\"wx折扣824\",\"pic\":\"https://image-uat-1257137391.cos.ap-beijing.myqcloud.com/images/0bf7a51bf4ec1cdc5dc762ccaf155916.png,https://image-uat-1257137391.cos.ap-beijing.myqcloud.com/images/a72d8e1327e6912ff6592321185013a8.png,https://image-uat-1257137391.cos.ap-beijing.myqcloud.com/images/b34a9250f09a716e476f59d9248b7ef7.jpg,https://image-uat-1257137391.cos.ap-beijing.myqcloud.com/images/3248fd22e554109815d57614ba14d559.png\",\"video\":null,\"type\":3,\"cid\":0,\"oid\":0,\"brandName\":\"\",\"brandValidFlag\":null,\"settlement\":0,\"value\":10,\"dailyEachLimit\":0,\"personEachLimit\":0,\"personDailyEachLimit\":0,\"description\":null,\"richDescription\":null,\"address\":null,\"phone\":null,\"remark\":null,\"provideStartTime\":\"2020-08-24 00:00:00\",\"provideEndTime\":\"2020-08-28 00:00:00\",\"usePeriod\":2,\"useStartTime\":\"1970-01-01 08:00:00\",\"useEndTime\":\"1970-01-01 08:00:00\",\"useRule\":100,\"expiredAfterHours\":24,\"status\":3,\"display\":1,\"codeDisplay\":null,\"createOrgCode\":\"101\",\"createOrgName\":\"集团\",\"version\":null,\"createTime\":\"2020-08-24 16:04:41\",\"updateTime\":null,\"totalNum\":3,\"content\":null,\"isOuter\":1,\"channel\":null,\"channelName\":null,\"bucketName\":null,\"key\":null,\"oriName\":null,\"downloadUrl\":null,\"availableDeliveryNum\":0,\"pid\":0,\"sendCouponNum\":null,\"useWeekTime\":null,\"batchNo\":null,\"giveInfo\":\"{\\\"flag\\\":false}\",\"expireNoticeInfo\":null,\"outerType\":1,\"outerInfo\":\"{}\",\"outerCodeDisplay\":null,\"distanceRange\":null,\"passRate\":null,\"supportStores\":null,\"useScene\":0,\"memberLabelCode\":null,\"customEntrance\":null,\"preCharge\":0}]}}";
        esUtil.addData("193844571","string","1",json);
        esUtil.client.close();
    }

}
