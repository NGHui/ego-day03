package com.ego.dubbo.service;

import com.ego.commons.pojo.EasyUIDataGrid;

/**
 * @author 辉
 * 座右铭:坚持总能遇见更好的自己!
 * @date 2019/8/3
 */
public interface TbItemParamDubboService {

    /**
     * 商品规格参数分页
     * @param page 页码
     * @param rows 总页数
     * @return
     */
    EasyUIDataGrid showPage(int page ,int rows);

    /**
     * 商品规格参数批量删除
     * @param ids 批量删除的id
     * @return
     */
    int delByIds(String ids) throws Exception;


}
