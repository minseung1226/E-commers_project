package kms.project.repository;

import kms.project.aop.Trace;
import kms.project.repository.mapper.DetailMapper;
import kms.project.vo.DetailVO;
import org.apache.maven.lifecycle.internal.LifecycleStarter;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Trace
public class DetailRepository {
    private final DetailMapper detailMapper;

    public DetailRepository(DetailMapper detailMapper) {
        this.detailMapper = detailMapper;
    }
    @Trace
    public void detailInsert(List<DetailVO> list){
         detailMapper.detailInsert(list);
    }
    @Trace
    public List<DetailVO> selectDetail(int product_code){
        return detailMapper.select_detail(product_code);
    }
    @Trace
    public void delete_detail(int product_code){
        detailMapper.delete_detail(product_code);
    }
    @Trace
    public Integer select_code(DetailVO detail){
        return detailMapper.select_code(detail);
    }
}
