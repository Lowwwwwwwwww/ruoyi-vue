package com.ruoyi.web.controller;



import com.ruoyi.common.core.controller.BaseController;

import com.ruoyi.web.domain.Poi;
import com.ruoyi.web.service.IPoiService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Controller
 * 
 * @author ruoyi
 * @date 2021-10-13
 */
@Controller
@RequestMapping("/manage/map")
public class MapController extends BaseController
{
    private String prefix = "manage/map";

    @Autowired
    private IPoiService poiService;

    @RequiresPermissions("manage:map:view")
    @GetMapping()
    public String device()
    {
        return prefix + "/map";
    }


/*    @GetMapping("/findPoints")
    public Map<String, Object> findPoints(String keyWord)
    {
        Poi poi =new Poi();
        poi.setName(keyWord);
        List<Poi> pois =poiService.selectPoiList(poi);
        Map<String, Object> date = new HashMap<>();
        date.put("tips",pois);
        System.out.println(date);
        return date;
    }*/
    @RequestMapping(value = "/findPoints",method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getList(@RequestParam String keyWord){
        startPage();
        Poi poi =new Poi();
        poi.setName(keyWord);
        List<Poi> pois =poiService.selectPoiList(poi);
        for (Poi poi1:pois) {
            poi1.setLnglat(poi1.getLng()+","+poi1.getLat());
        }
        Map<String, Object> date = new HashMap<>();
        date.put("tips",pois);
        return date;
    }




}
