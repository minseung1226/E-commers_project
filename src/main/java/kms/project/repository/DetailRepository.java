package kms.project.repository;

import kms.project.repository.mapper.DetailMapper;
import kms.project.vo.DetailVO;
import org.apache.maven.lifecycle.internal.LifecycleStarter;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DetailRepository {
    private final DetailMapper detailMapper;

    public DetailRepository(DetailMapper detailMapper) {
        this.detailMapper = detailMapper;
    }

    public void detailInsert(List<DetailVO> list){
         detailMapper.detailInsert(list);
    }

    public List<DetailVO> selectDetail(int product_code){
        return detailMapper.select_detail(product_code);
    }

    public void delete_detail(int product_code){
        detailMapper.delete_detail(product_code);
    }

    public Integer select_code(DetailVO detail){
        return detailMapper.select_code(detail);
    }
}
