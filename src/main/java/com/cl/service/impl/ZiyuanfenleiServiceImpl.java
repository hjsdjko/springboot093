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


import com.cl.dao.ZiyuanfenleiDao;
import com.cl.entity.ZiyuanfenleiEntity;
import com.cl.service.ZiyuanfenleiService;
import com.cl.entity.view.ZiyuanfenleiView;

@Service("ziyuanfenleiService")
public class ZiyuanfenleiServiceImpl extends ServiceImpl<ZiyuanfenleiDao, ZiyuanfenleiEntity> implements ZiyuanfenleiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZiyuanfenleiEntity> page = this.selectPage(
                new Query<ZiyuanfenleiEntity>(params).getPage(),
                new EntityWrapper<ZiyuanfenleiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZiyuanfenleiEntity> wrapper) {
		  Page<ZiyuanfenleiView> page =new Query<ZiyuanfenleiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<ZiyuanfenleiView> selectListView(Wrapper<ZiyuanfenleiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZiyuanfenleiView selectView(Wrapper<ZiyuanfenleiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
