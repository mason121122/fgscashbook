package com.fgs.fgscashbook;


import lombok.Data;

import java.util.Date;

/**
 * @author wangfeng
 */
@Data
public class RelationCommercialPo {
    private Integer id;
    private String tenantId;
    private Integer plazaId;
    private String plazaName;
    private Integer storeId;
    private String storeName;
    private Integer platform;
    private String externalId;
    private String externalName;
    private Date createTime;
    private Date updateTime;
}
