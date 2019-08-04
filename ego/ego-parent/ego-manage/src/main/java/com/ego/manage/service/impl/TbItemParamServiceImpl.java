package com.ego.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ego.commons.pojo.EasyUIDataGrid;
import com.ego.dubbo.service.TbItemCatDubboService;
import com.ego.dubbo.service.TbItemParamDubboService;
import com.ego.manage.pojo.TbItemParamChild;
import com.ego.manage.service.TbItemParamService;
import com.ego.pojo.TbItemParam;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 辉
 * 座右铭:坚持总能遇见更好的自己!
 * @date 2019/8/3
 */
@Service
public class TbItemParamServiceImpl implements TbItemParamService {

    @Reference
    private TbItemParamDubboService tbItemParamDubboServiceimpl;
    @Reference
    private TbItemCatDubboService tbItemCatDubboServiceImpl;

    /**
     * @param page 页数
     * @param rows 总页码
     * @return
     */
    @Override
    public EasyUIDataGrid showPage(int page, int rows) {
        //将查询到的数据封装在EasyUIDataGrid中
        EasyUIDataGrid datagrid = tbItemParamDubboServiceimpl.showPage(page, rows);
        //将查到的数据放在集合中
        List<TbItemParam> list = (List<TbItemParam>) datagrid.getRows();
        //该集合是用于存储类目的名称,将所有的数据返回给商品规格参数
        List<TbItemParamChild> listChild = new ArrayList<>();
        //遍历数据库中的数据
        for (TbItemParam param : list) {
            TbItemParamChild child = new TbItemParamChild();
            //将两个数据库中的数据合二为一
            child.setCreated(param.getCreated());
            child.setId(param.getId());
            child.setItemCatId(param.getItemCatId());
            child.setParamData(param.getParamData());
            child.setUpdated(param.getUpdated());
            //这个是TbItemCat表中的name的属性
            child.setItemCatName(tbItemCatDubboServiceImpl.selById(child.getItemCatId()).getName());

            listChild.add(child);
        }
        datagrid.setRows(listChild);
        return datagrid;
    }

    /**
     *
     * @param ids 批量删除的id
     * @return
     */
    @Override
    public int delByids(String ids) throws Exception {
        return tbItemParamDubboServiceimpl.delByIds(ids);
    }


}
