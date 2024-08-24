package com.cl.dao;

import com.cl.entity.ZiyuanfenleiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ZiyuanfenleiView;


/**
 * 资源分类
 * 
 * @author 
 * @email 
 * @date 2024-03-28 19:01:03
 */
public interface ZiyuanfenleiDao extends BaseMapper<ZiyuanfenleiEntity> {
	
	List<ZiyuanfenleiView> selectListView(@Param("ew") Wrapper<ZiyuanfenleiEntity> wrapper);

	List<ZiyuanfenleiView> selectListView(Pagination page,@Param("ew") Wrapper<ZiyuanfenleiEntity> wrapper);
	
	ZiyuanfenleiView selectView(@Param("ew") Wrapper<ZiyuanfenleiEntity> wrapper);
	

}
