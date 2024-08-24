package com.cl.dao;

import com.cl.entity.ZiyuanxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ZiyuanxinxiView;


/**
 * 资源信息
 * 
 * @author 
 * @email 
 * @date 2024-03-28 19:01:03
 */
public interface ZiyuanxinxiDao extends BaseMapper<ZiyuanxinxiEntity> {
	
	List<ZiyuanxinxiView> selectListView(@Param("ew") Wrapper<ZiyuanxinxiEntity> wrapper);

	List<ZiyuanxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<ZiyuanxinxiEntity> wrapper);
	
	ZiyuanxinxiView selectView(@Param("ew") Wrapper<ZiyuanxinxiEntity> wrapper);
	

}
