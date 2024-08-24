package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.ZiyuanxinxiEntity;
import com.cl.entity.view.ZiyuanxinxiView;

import com.cl.service.ZiyuanxinxiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;
import com.cl.service.StoreupService;
import com.cl.entity.StoreupEntity;

/**
 * 资源信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-28 19:01:03
 */
@RestController
@RequestMapping("/ziyuanxinxi")
public class ZiyuanxinxiController {
    @Autowired
    private ZiyuanxinxiService ziyuanxinxiService;

    @Autowired
    private StoreupService storeupService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZiyuanxinxiEntity ziyuanxinxi,
		HttpServletRequest request){
        EntityWrapper<ZiyuanxinxiEntity> ew = new EntityWrapper<ZiyuanxinxiEntity>();

		PageUtils page = ziyuanxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, ziyuanxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZiyuanxinxiEntity ziyuanxinxi, 
		HttpServletRequest request){
        EntityWrapper<ZiyuanxinxiEntity> ew = new EntityWrapper<ZiyuanxinxiEntity>();

		PageUtils page = ziyuanxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, ziyuanxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZiyuanxinxiEntity ziyuanxinxi){
       	EntityWrapper<ZiyuanxinxiEntity> ew = new EntityWrapper<ZiyuanxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( ziyuanxinxi, "ziyuanxinxi")); 
        return R.ok().put("data", ziyuanxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZiyuanxinxiEntity ziyuanxinxi){
        EntityWrapper< ZiyuanxinxiEntity> ew = new EntityWrapper< ZiyuanxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( ziyuanxinxi, "ziyuanxinxi")); 
		ZiyuanxinxiView ziyuanxinxiView =  ziyuanxinxiService.selectView(ew);
		return R.ok("查询资源信息成功").put("data", ziyuanxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZiyuanxinxiEntity ziyuanxinxi = ziyuanxinxiService.selectById(id);
		ziyuanxinxi = ziyuanxinxiService.selectView(new EntityWrapper<ZiyuanxinxiEntity>().eq("id", id));
        return R.ok().put("data", ziyuanxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZiyuanxinxiEntity ziyuanxinxi = ziyuanxinxiService.selectById(id);
		ziyuanxinxi = ziyuanxinxiService.selectView(new EntityWrapper<ZiyuanxinxiEntity>().eq("id", id));
        return R.ok().put("data", ziyuanxinxi);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R vote(@PathVariable("id") String id,String type){
        ZiyuanxinxiEntity ziyuanxinxi = ziyuanxinxiService.selectById(id);
        if(type.equals("1")) {
        	ziyuanxinxi.setThumbsupnum(ziyuanxinxi.getThumbsupnum()+1);
        } else {
        	ziyuanxinxi.setCrazilynum(ziyuanxinxi.getCrazilynum()+1);
        }
        ziyuanxinxiService.updateById(ziyuanxinxi);
        return R.ok("投票成功");
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZiyuanxinxiEntity ziyuanxinxi, HttpServletRequest request){
    	ziyuanxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(ziyuanxinxi);
        ziyuanxinxiService.insert(ziyuanxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZiyuanxinxiEntity ziyuanxinxi, HttpServletRequest request){
    	ziyuanxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(ziyuanxinxi);
        ziyuanxinxiService.insert(ziyuanxinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ZiyuanxinxiEntity ziyuanxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(ziyuanxinxi);
        ziyuanxinxiService.updateById(ziyuanxinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        ziyuanxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
