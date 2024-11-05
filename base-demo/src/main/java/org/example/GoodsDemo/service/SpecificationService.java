package org.example.GoodsDemo.service;

public interface SpecificationService {
    void specadd(Long spuid, String spuname, String specname, String stocktype, Double stockmaxnum,String numunit);

    void specsetmaxnum(Long specid, Double stockmaxnum);

    void specsetwarnnum(Long specid, Double stockwarnnum);

    void specdelete(Long spuid, Long specid,String specname);
}
