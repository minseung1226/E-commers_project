package kms.project.service;

import kms.project.repository.DetailRepository;
import kms.project.vo.DetailVO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class DetailService {
    private final DetailRepository detailRepository;

    public DetailService(DetailRepository detailRepository) {
        this.detailRepository = detailRepository;
    }

    public void detailInsert(String size, String color,int product_code){
        List<DetailVO> list=new ArrayList<>();
        String[] sizeArr = size.split(",");
        String[] colorArr = color.split(",");

        for(int i = 0 ; i < sizeArr.length;i++){
            for(int j=0; j < colorArr.length;j++){
                DetailVO listVO = new DetailVO();
                listVO.setProduct_code(product_code);
                listVO.setColor(colorArr[j]);
                listVO.setSize(sizeArr[i]);
                list.add(listVO);
            }
        }
        detailRepository.detailInsert(list);
    }

    public String[] select_detail(int product_code){
        List<DetailVO> list = detailRepository.selectDetail(product_code);
        return null;
    }
}
