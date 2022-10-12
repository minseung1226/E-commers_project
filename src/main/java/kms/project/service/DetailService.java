package kms.project.service;

import kms.project.repository.DetailRepository;
import kms.project.vo.DetailVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class DetailService {
    private final DetailRepository detailRepository;

    public DetailService(DetailRepository detailRepository) {
        this.detailRepository = detailRepository;
    }

    public void detailInsert(String size, String color,int product_code){
        List<DetailVO> list = makeList(product_code, size, color);
        detailRepository.detailInsert(list);
    }

    public Map<String,String> select_detail(int product_code){
        List<DetailVO> list = detailRepository.selectDetail(product_code);

        Map<String, List<String>> sizeColorList = makeSizeColorList(list);

        String size = changeString(sizeColorList.get("size"));
        String color = changeString(sizeColorList.get("color"));

        String code=String.valueOf(list.get(0).getProduct_code());
        Map<String,String> map =new HashMap<>();
        map.put("product_code",code);
        map.put("size",size);
        map.put("color",color);

        return map;
    }
    @Transactional
    public void updateDetail(int product_code,String size,String color){
        detailRepository.delete_detail(product_code);
        List<DetailVO> list = makeList(product_code, size, color);
        detailRepository.detailInsert(list);
    }


    public Map<String, List<String>> getSizeColor(int product_code){
        List<DetailVO> list = detailRepository.selectDetail(product_code);
        Map<String, List<String>> map = makeSizeColorList(list);

        return map;

    }


    private String changeString(List list){
        StringBuffer result = new StringBuffer();
        for(int i = 0 ; i < list.size() ; i++){
            if(i==0){
                result.append(list.get(i));
            }
            else{
                result.append(","+list.get(i));
            }
        }
        return result.toString();
    }


    private List<DetailVO> makeList(int product_code,String size,String color){
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
        return list;
    }

    private Map<String,List<String>> makeSizeColorList(List<DetailVO> list){

        List<String> sizeList = new ArrayList<>();
        List<String> colorList = new ArrayList<>();

        for(int i = 0 ; i < list.size() ; i++){
            if(!sizeList.contains(list.get(i).getSize())){
                sizeList.add(list.get(i).getSize());
            }
            if(!colorList.contains(list.get(i).getColor())){
                colorList.add(list.get(i).getColor());
            }
        }
        Map<String,List<String>> map = new HashMap<>();
        map.put("size",sizeList);
        map.put("color",colorList);

        return map;
    }
}
