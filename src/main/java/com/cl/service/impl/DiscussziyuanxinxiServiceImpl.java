package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.DiscussziyuanxinxiDao;
import com.cl.entity.DiscussziyuanxinxiEntity;
import com.cl.service.DiscussziyuanxinxiService;
import com.cl.entity.view.DiscussziyuanxinxiView;

@Service("discussziyuanxinxiService")
public class DiscussziyuanxinxiServiceImpl extends ServiceImpl<DiscussziyuanxinxiDao, DiscussziyuanxinxiEntity> implements DiscussziyuanxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussziyuanxinxiEntity> page = this.selectPage(
                new Query<DiscussziyuanxinxiEntity>(params).getPage(),
                new EntityWrapper<DiscussziyuanxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussziyuanxinxiEntity> wrapper) {
		  Page<DiscussziyuanxinxiView> page =new Query<DiscussziyuanxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<DiscussziyuanxinxiView> selectListView(Wrapper<DiscussziyuanxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussziyuanxinxiView selectView(Wrapper<DiscussziyuanxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
