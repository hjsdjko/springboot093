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

import com.cl.entity.ZiyuanfenleiEntity;
import com.cl.entity.view.ZiyuanfenleiView;

import com.cl.service.ZiyuanfenleiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 资源分类
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-28 19:01:03
 */
@RestController
@RequestMapping("/ziyuanfenlei")
public class ZiyuanfenleiController {
    @Autowired
    private ZiyuanfenleiService ziyuanfenleiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZiyuanfenleiEntity ziyuanfenlei,
		HttpServletRequest request){
        EntityWrapper<ZiyuanfenleiEntity> ew = new EntityWrapper<ZiyuanfenleiEntity>();

		PageUtils page = ziyuanfenleiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, ziyuanfenlei), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZiyuanfenleiEntity ziyuanfenlei, 
		HttpServletRequest request){
        EntityWrapper<ZiyuanfenleiEntity> ew = new EntityWrapper<ZiyuanfenleiEntity>();

		PageUtils page = ziyuanfenleiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, ziyuanfenlei), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZiyuanfenleiEntity ziyuanfenlei){
       	EntityWrapper<ZiyuanfenleiEntity> ew = new EntityWrapper<ZiyuanfenleiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( ziyuanfenlei, "ziyuanfenlei")); 
        return R.ok().put("data", ziyuanfenleiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZiyuanfenleiEntity ziyuanfenlei){
        EntityWrapper< ZiyuanfenleiEntity> ew = new EntityWrapper< ZiyuanfenleiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( ziyuanfenlei, "ziyuanfenlei")); 
		ZiyuanfenleiView ziyuanfenleiView =  ziyuanfenleiService.selectView(ew);
		return R.ok("查询资源分类成功").put("data", ziyuanfenleiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZiyuanfenleiEntity ziyuanfenlei = ziyuanfenleiService.selectById(id);
		ziyuanfenlei = ziyuanfenleiService.selectView(new EntityWrapper<ZiyuanfenleiEntity>().eq("id", id));
        return R.ok().put("data", ziyuanfenlei);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZiyuanfenleiEntity ziyuanfenlei = ziyuanfenleiService.selectById(id);
		ziyuanfenlei = ziyuanfenleiService.selectView(new EntityWrapper<ZiyuanfenleiEntity>().eq("id", id));
        return R.ok().put("data", ziyuanfenlei);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZiyuanfenleiEntity ziyuanfenlei, HttpServletRequest request){
    	ziyuanfenlei.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(ziyuanfenlei);
        ziyuanfenleiService.insert(ziyuanfenlei);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZiyuanfenleiEntity ziyuanfenlei, HttpServletRequest request){
    	ziyuanfenlei.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(ziyuanfenlei);
        ziyuanfenleiService.insert(ziyuanfenlei);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ZiyuanfenleiEntity ziyuanfenlei, HttpServletRequest request){
        //ValidatorUtils.validateEntity(ziyuanfenlei);
        ziyuanfenleiService.updateById(ziyuanfenlei);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        ziyuanfenleiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
