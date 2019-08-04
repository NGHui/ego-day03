package com.ego.manage.controller;

import com.ego.commons.pojo.EasyUIDataGrid;
import com.ego.commons.pojo.EgoResult;
import com.ego.manage.service.TbItemParamService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author 辉
 * 座右铭:坚持总能遇见更好的自己!
 * @date 2019/8/3
 */
@Controller
public class TbItemParamController {
    @Resource
    private TbItemParamService tbItemParamServiceImpl;


    @RequestMapping("item/param/list")
    @ResponseBody
    public EasyUIDataGrid showPage(int page , int rows){
        return tbItemParamServiceImpl.showPage(page,rows);
    }
    @RequestMapping("item/param/delete")
    @ResponseBody
    public EgoResult delete(String ids){

        EgoResult result = new EgoResult();

        try {
            int index = tbItemParamServiceImpl.delByids(ids);

            if (index==1){
                result.setStatus(200);
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.setData(e.getMessage());

        }
        return result;
    }


}
