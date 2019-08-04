package com.ego.manage.service;

import com.ego.commons.pojo.EasyUIDataGrid;

/**
 * @author 辉
 * 座右铭:坚持总能遇见更好的自己!
 * @date 2019/8/3
 */
public interface TbItemParamService {

    /**
     *商品规格参数表分页
     * @param page 页数
     * @param rows 总页码
     * @return
     */
    EasyUIDataGrid showPage(int page,int rows);

    /**
     *
     * @param ids 批量删除的id
     * @return
     */
    int delByids(String ids) throws Exception;

}
